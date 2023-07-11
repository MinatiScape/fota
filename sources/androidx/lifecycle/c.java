package androidx.lifecycle;

import androidx.lifecycle.f;
/* compiled from: FullLifecycleObserverAdapter.java */
/* loaded from: classes.dex */
/* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f684a = new int[f.a.values().length];

    static {
        try {
            f684a[f.a.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f684a[f.a.ON_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f684a[f.a.ON_RESUME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f684a[f.a.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f684a[f.a.ON_STOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f684a[f.a.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f684a[f.a.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
