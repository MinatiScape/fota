package androidx.fragment.app;

import android.view.View;
import android.view.ViewTreeObserver;
/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
class L implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f624a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f625b;
    private final Runnable c;

    private L(View view, Runnable runnable) {
        this.f624a = view;
        this.f625b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static L a(View view, Runnable runnable) {
        L l = new L(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(l);
        view.addOnAttachStateChangeListener(l);
        return l;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f625b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f625b.isAlive()) {
            this.f625b.removeOnPreDrawListener(this);
        } else {
            this.f624a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f624a.removeOnAttachStateChangeListener(this);
    }
}
