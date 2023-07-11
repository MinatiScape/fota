package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
/* compiled from: FragmentManager.java */
/* renamed from: androidx.fragment.app.k  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0081k {

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.k$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.k$b */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(AbstractC0081k abstractC0081k, Fragment fragment);

        public abstract void a(AbstractC0081k abstractC0081k, Fragment fragment, Context context);

        public abstract void a(AbstractC0081k abstractC0081k, Fragment fragment, Bundle bundle);

        public abstract void a(AbstractC0081k abstractC0081k, Fragment fragment, View view, Bundle bundle);

        public abstract void b(AbstractC0081k abstractC0081k, Fragment fragment);

        public abstract void b(AbstractC0081k abstractC0081k, Fragment fragment, Context context);

        public abstract void b(AbstractC0081k abstractC0081k, Fragment fragment, Bundle bundle);

        public abstract void c(AbstractC0081k abstractC0081k, Fragment fragment);

        public abstract void c(AbstractC0081k abstractC0081k, Fragment fragment, Bundle bundle);

        public abstract void d(AbstractC0081k abstractC0081k, Fragment fragment);

        public abstract void d(AbstractC0081k abstractC0081k, Fragment fragment, Bundle bundle);

        public abstract void e(AbstractC0081k abstractC0081k, Fragment fragment);

        public abstract void f(AbstractC0081k abstractC0081k, Fragment fragment);

        public abstract void g(AbstractC0081k abstractC0081k, Fragment fragment);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.k$c */
    /* loaded from: classes.dex */
    public interface c {
        void onBackStackChanged();
    }

    public abstract Fragment a(String str);

    public abstract w a();

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void addOnBackStackChangedListener(c cVar);

    public abstract boolean b();

    public abstract List<Fragment> c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract void removeOnBackStackChangedListener(c cVar);
}
