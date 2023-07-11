package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.C0058q;
import androidx.appcompat.widget.C0059s;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.r;
import androidx.core.h.t;
import androidx.core.widget.n;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.a.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.e;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.s;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
@CoordinatorLayout.b(Behavior.class)
/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements r, n, com.google.android.material.d.a {

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1335b;
    private PorterDuff.Mode c;
    private ColorStateList d;
    private PorterDuff.Mode e;
    private int f;
    private ColorStateList g;
    private int h;
    private int i;
    private int j;
    private int k;
    boolean l;
    final Rect m;
    private final Rect n;
    private final C0059s o;
    private final com.google.android.material.d.c p;
    private e q;

    /* loaded from: classes.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f1336a;

        /* renamed from: b  reason: collision with root package name */
        private a f1337b;
        private boolean c;

        public BaseBehavior() {
            this.c = true;
        }

        public void setInternalAutoHideListener(a aVar) {
            this.f1337b = aVar;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (a(view, floatingActionButton)) {
                if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.d) floatingActionButton.getLayoutParams())).topMargin) {
                    floatingActionButton.a(this.f1337b, false);
                    return true;
                }
                floatingActionButton.b(this.f1337b, false);
                return true;
            }
            return false;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout.d dVar) {
            if (dVar.h == 0) {
                dVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (a(view)) {
                b(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.c && ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (a(appBarLayout, floatingActionButton)) {
                if (this.f1336a == null) {
                    this.f1336a = new Rect();
                }
                Rect rect = this.f1336a;
                com.google.android.material.internal.f.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    floatingActionButton.a(this.f1337b, false);
                    return true;
                }
                floatingActionButton.b(this.f1337b, false);
                return true;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> b2 = coordinatorLayout.b(floatingActionButton);
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = b2.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.c(floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) dVar).rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) dVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) dVar).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                t.b((View) floatingActionButton, i2);
            }
            if (i != 0) {
                t.a((View) floatingActionButton, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(a aVar) {
            super.setInternalAutoHideListener(aVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout.d dVar) {
            super.a(dVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.b(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.a(coordinatorLayout, floatingActionButton, i);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(FloatingActionButton floatingActionButton);

        public abstract void b(FloatingActionButton floatingActionButton);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private void d() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.d;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a.b(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C0058q.a(colorForState, mode));
    }

    private e getImpl() {
        if (this.q == null) {
            this.q = c();
        }
        return this.q;
    }

    void b(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f1335b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.c;
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().e();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f();
    }

    public Drawable getContentBackground() {
        return getImpl().b();
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        return this.p.a();
    }

    public h getHideMotionSpec() {
        return getImpl().d();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public h getShowMotionSpec() {
        return getImpl().g();
    }

    public int getSize() {
        return this.h;
    }

    int getSizeDimension() {
        return a(this.h);
    }

    @Override // androidx.core.h.r
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.h.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.n
    public ColorStateList getSupportImageTintList() {
        return this.d;
    }

    @Override // androidx.core.widget.n
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.e;
    }

    public boolean getUseCompatPadding() {
        return this.l;
    }

    public void hide(a aVar) {
        a(aVar, true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().j();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().o();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension - this.k) / 2;
        getImpl().s();
        int min = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.p.a(extendableSavedState.c.get("expandableWidgetHelper"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.c.put("expandableWidgetHelper", this.p.c());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.n) && !this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1335b != colorStateList) {
            this.f1335b = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.c != mode) {
            this.c = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().a(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().b(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().d(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i >= 0) {
            this.i = i;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int i) {
        this.p.a(i);
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().a(hVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(h.a(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().r();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.o.a(i);
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().b(hVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(h.a(getContext(), i));
    }

    public void setSize(int i) {
        this.i = 0;
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            d();
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            d();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.l != z) {
            this.l = z;
            getImpl().n();
        }
    }

    public void show(a aVar) {
        b(aVar, true);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    private void c(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.m;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            getImpl().b(this.g);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new Rect();
        this.n = new Rect();
        TypedArray a2 = s.a(context, attributeSet, R$styleable.FloatingActionButton, i, R$style.Widget_Design_FloatingActionButton, new int[0]);
        this.f1335b = com.google.android.material.f.a.a(context, a2, R$styleable.FloatingActionButton_backgroundTint);
        this.c = com.google.android.material.internal.t.a(a2.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.g = com.google.android.material.f.a.a(context, a2, R$styleable.FloatingActionButton_rippleColor);
        this.h = a2.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.i = a2.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.f = a2.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = a2.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = a2.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = a2.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.l = a2.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        this.k = a2.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        h a3 = h.a(context, a2, R$styleable.FloatingActionButton_showMotionSpec);
        h a4 = h.a(context, a2, R$styleable.FloatingActionButton_hideMotionSpec);
        a2.recycle();
        this.o = new C0059s(this);
        this.o.a(attributeSet, i);
        this.p = new com.google.android.material.d.c(this);
        getImpl().a(this.f1335b, this.c, this.g, this.f);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().d(dimension3);
        getImpl().a(this.k);
        getImpl().b(a3);
        getImpl().a(a4);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    void a(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    public boolean b() {
        return getImpl().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements com.google.android.material.h.b {
        b() {
        }

        @Override // com.google.android.material.h.b
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.m.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.j, i2 + FloatingActionButton.this.j, i3 + FloatingActionButton.this.j, i4 + FloatingActionButton.this.j);
        }

        @Override // com.google.android.material.h.b
        public float b() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.h.b
        public void setBackgroundDrawable(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.h.b
        public boolean a() {
            return FloatingActionButton.this.l;
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    @Override // com.google.android.material.d.b
    public boolean a() {
        return this.p.b();
    }

    private e.d a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.google.android.material.floatingactionbutton.a(this, aVar);
    }

    private e c() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new f(this, new b());
        }
        return new e(this, new b());
    }

    private int a(int i) {
        int i2 = this.i;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i != 1) {
                return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        } else {
            return a(0);
        }
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (t.z(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            c(rect);
            return true;
        }
        return false;
    }

    private static int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i;
        }
        return Math.min(i, size);
    }
}
