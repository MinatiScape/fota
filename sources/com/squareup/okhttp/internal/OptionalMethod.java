package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class OptionalMethod<T> {
    private final String methodName;
    private final Class[] methodParams;
    private final Class<?> returnType;

    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.returnType = cls;
        this.methodName = str;
        this.methodParams = clsArr;
    }

    private Method getMethod(Class<?> cls) {
        Class<?> cls2;
        String str = this.methodName;
        if (str != null) {
            Method publicMethod = getPublicMethod(cls, str, this.methodParams);
            if (publicMethod == null || (cls2 = this.returnType) == null || cls2.isAssignableFrom(publicMethod.getReturnType())) {
                return publicMethod;
            }
            return null;
        }
        return null;
    }

    private static Method getPublicMethod(Class<?> cls, String str, Class[] clsArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) != 0) {
                return method;
            }
            return null;
        } catch (NoSuchMethodException unused2) {
            return method;
        }
    }

    public Object invoke(T t, Object... objArr) throws InvocationTargetException {
        Method method = getMethod(t.getClass());
        if (method != null) {
            try {
                return method.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + method);
                assertionError.initCause(e);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.methodName + " not supported for object " + t);
    }

    public Object invokeOptional(T t, Object... objArr) throws InvocationTargetException {
        Method method = getMethod(t.getClass());
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object invokeOptionalWithoutCheckedException(T t, Object... objArr) {
        try {
            return invokeOptional(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object invokeWithoutCheckedException(T t, Object... objArr) {
        try {
            return invoke(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean isSupported(T t) {
        return getMethod(t.getClass()) != null;
    }
}
