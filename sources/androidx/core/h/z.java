package androidx.core.h;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f545a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f546b = null;
    Runnable c = null;
    int d = -1;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class a implements A {

        /* renamed from: a  reason: collision with root package name */
        z f547a;

        /* renamed from: b  reason: collision with root package name */
        boolean f548b;

        a(z zVar) {
            this.f547a = zVar;
        }

        @Override // androidx.core.h.A
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            A a2 = tag instanceof A ? (A) tag : null;
            if (a2 != null) {
                a2.a(view);
            }
        }

        @Override // androidx.core.h.A
        public void b(View view) {
            int i = this.f547a.d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f547a.d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f548b) {
                z zVar = this.f547a;
                Runnable runnable = zVar.c;
                if (runnable != null) {
                    zVar.c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                A a2 = tag instanceof A ? (A) tag : null;
                if (a2 != null) {
                    a2.b(view);
                }
                this.f548b = true;
            }
        }

        @Override // androidx.core.h.A
        public void c(View view) {
            this.f548b = false;
            if (this.f547a.d > -1) {
                view.setLayerType(2, null);
            }
            z zVar = this.f547a;
            Runnable runnable = zVar.f546b;
            if (runnable != null) {
                zVar.f546b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            A a2 = tag instanceof A ? (A) tag : null;
            if (a2 != null) {
                a2.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(View view) {
        this.f545a = new WeakReference<>(view);
    }

    public z a(long j) {
        View view = this.f545a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public z b(float f) {
        View view = this.f545a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public void c() {
        View view = this.f545a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z a(float f) {
        View view = this.f545a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public long b() {
        View view = this.f545a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public z a(Interpolator interpolator) {
        View view = this.f545a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z b(long j) {
        View view = this.f545a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void a() {
        View view = this.f545a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public z a(A a2) {
        View view = this.f545a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, a2);
            } else {
                view.setTag(2113929216, a2);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(View view, A a2) {
        if (a2 != null) {
            view.animate().setListener(new x(this, a2, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public z a(C c) {
        View view = this.f545a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(c != null ? new y(this, c, view) : null);
        }
        return this;
    }
}
