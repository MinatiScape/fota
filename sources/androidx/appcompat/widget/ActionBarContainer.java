package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f198a;

    /* renamed from: b  reason: collision with root package name */
    private View f199b;
    private View c;
    private View d;
    Drawable e;
    Drawable f;
    boolean g;
    boolean h;
    private int i;
    Drawable mBackground;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mBackground;
        if (drawable != null && drawable.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f199b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.c = findViewById(R$id.action_bar);
        this.d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f198a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f199b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.g) {
            Drawable drawable2 = this.f;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.mBackground != null) {
                if (this.c.getVisibility() == 0) {
                    this.mBackground.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
                } else {
                    View view2 = this.d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.mBackground.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
                    } else {
                        this.mBackground.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.h = z4;
            if (!z4 || (drawable = this.e) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int a2;
        int i3;
        if (this.c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.i) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.f199b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!b(this.c)) {
            a2 = a(this.c);
        } else {
            a2 = !b(this.d) ? a(this.d) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a2 + a(this.f199b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.mBackground;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.mBackground);
        }
        this.mBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.c;
            if (view != null) {
                this.mBackground.setBounds(view.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = true;
        if (!this.g ? this.mBackground != null || this.e != null : this.f != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f);
        }
        this.f = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.g && (drawable2 = this.f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.g ? !(this.mBackground != null || this.e != null) : this.f == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.e;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.e);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h && (drawable2 = this.e) != null) {
                drawable2.setBounds(this.f199b.getLeft(), this.f199b.getTop(), this.f199b.getRight(), this.f199b.getBottom());
            }
        }
        boolean z = true;
        if (!this.g ? this.mBackground != null || this.e != null : this.f != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f199b;
        if (view != null) {
            removeView(view);
        }
        this.f199b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f198a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.mBackground && !this.g) || (drawable == this.e && this.h) || ((drawable == this.f && this.g) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.h.t.a(this, new C0043b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        if (getId() == R$id.split_action_bar) {
            this.g = true;
            this.f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.g ? !(this.mBackground != null || this.e != null) : this.f == null) {
            z = true;
        }
        setWillNotDraw(z);
    }
}
