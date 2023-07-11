package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbsActionBarView.java */
/* renamed from: androidx.appcompat.widget.a  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0042a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0005a f307a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f308b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected int e;
    protected androidx.core.h.z f;
    private boolean g;
    private boolean h;

    AbstractC0042a(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.f307a.f310b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            androidx.core.h.z zVar = this.f;
            if (zVar != null) {
                zVar.a();
            }
            super.setVisibility(i);
        }
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0005a implements androidx.core.h.A {

        /* renamed from: a  reason: collision with root package name */
        private boolean f309a = false;

        /* renamed from: b  reason: collision with root package name */
        int f310b;

        protected C0005a() {
        }

        public C0005a a(androidx.core.h.z zVar, int i) {
            AbstractC0042a.this.f = zVar;
            this.f310b = i;
            return this;
        }

        @Override // androidx.core.h.A
        public void b(View view) {
            if (this.f309a) {
                return;
            }
            AbstractC0042a abstractC0042a = AbstractC0042a.this;
            abstractC0042a.f = null;
            AbstractC0042a.super.setVisibility(this.f310b);
        }

        @Override // androidx.core.h.A
        public void c(View view) {
            AbstractC0042a.super.setVisibility(0);
            this.f309a = false;
        }

        @Override // androidx.core.h.A
        public void a(View view) {
            this.f309a = true;
        }
    }

    AbstractC0042a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public androidx.core.h.z a(int i, long j) {
        androidx.core.h.z zVar = this.f;
        if (zVar != null) {
            zVar.a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            androidx.core.h.z a2 = androidx.core.h.t.a(this);
            a2.a(1.0f);
            a2.a(j);
            C0005a c0005a = this.f307a;
            c0005a.a(a2, i);
            a2.a(c0005a);
            return a2;
        }
        androidx.core.h.z a3 = androidx.core.h.t.a(this);
        a3.a(0.0f);
        a3.a(j);
        C0005a c0005a2 = this.f307a;
        c0005a2.a(a3, i);
        a3.a(c0005a2);
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0042a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.f307a = new C0005a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) && (i2 = typedValue.resourceId) != 0) {
            this.f308b = new ContextThemeWrapper(context, i2);
        } else {
            this.f308b = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
