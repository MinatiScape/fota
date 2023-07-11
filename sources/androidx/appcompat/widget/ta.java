package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
public class ta implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static ta f361a;

    /* renamed from: b  reason: collision with root package name */
    private static ta f362b;
    private final View c;
    private final CharSequence d;
    private final int e;
    private final Runnable f = new ra(this);
    private final Runnable g = new sa(this);
    private int h;
    private int i;
    private ua j;
    private boolean k;

    private ta(View view, CharSequence charSequence) {
        this.c = view;
        this.d = charSequence;
        this.e = androidx.core.h.u.a(ViewConfiguration.get(this.c.getContext()));
        c();
        this.c.setOnLongClickListener(this);
        this.c.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        ta taVar = f361a;
        if (taVar != null && taVar.c == view) {
            a((ta) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            ta taVar2 = f362b;
            if (taVar2 != null && taVar2.c == view) {
                taVar2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new ta(view, charSequence);
    }

    private void b() {
        this.c.removeCallbacks(this.f);
    }

    private void c() {
        this.h = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
    }

    private void d() {
        this.c.postDelayed(this.f, ViewConfiguration.getLongPressTimeout());
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.j == null || !this.k) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.c.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    c();
                    a();
                }
            } else if (this.c.isEnabled() && this.j == null && a(motionEvent)) {
                a(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.h = view.getWidth() / 2;
        this.i = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        long j;
        int longPressTimeout;
        long j2;
        if (androidx.core.h.t.y(this.c)) {
            a((ta) null);
            ta taVar = f362b;
            if (taVar != null) {
                taVar.a();
            }
            f362b = this;
            this.k = z;
            this.j = new ua(this.c.getContext());
            this.j.a(this.c, this.h, this.i, this.k, this.d);
            this.c.addOnAttachStateChangeListener(this);
            if (this.k) {
                j2 = 2500;
            } else {
                if ((androidx.core.h.t.s(this.c) & 1) == 1) {
                    j = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - longPressTimeout;
            }
            this.c.removeCallbacks(this.g);
            this.c.postDelayed(this.g, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (f362b == this) {
            f362b = null;
            ua uaVar = this.j;
            if (uaVar != null) {
                uaVar.a();
                this.j = null;
                c();
                this.c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f361a == this) {
            a((ta) null);
        }
        this.c.removeCallbacks(this.g);
    }

    private static void a(ta taVar) {
        ta taVar2 = f361a;
        if (taVar2 != null) {
            taVar2.b();
        }
        f361a = taVar;
        ta taVar3 = f361a;
        if (taVar3 != null) {
            taVar3.d();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.h) > this.e || Math.abs(y - this.i) > this.e) {
            this.h = x;
            this.i = y;
            return true;
        }
        return false;
    }
}
