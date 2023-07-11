package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0042a {
    private CharSequence i;
    private CharSequence j;
    private View k;
    private View l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private int p;
    private int q;
    private boolean r;
    private int s;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.m == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            this.m = (LinearLayout) getChildAt(getChildCount() - 1);
            this.n = (TextView) this.m.findViewById(R$id.action_bar_title);
            this.o = (TextView) this.m.findViewById(R$id.action_bar_subtitle);
            if (this.p != 0) {
                this.n.setTextAppearance(getContext(), this.p);
            }
            if (this.q != 0) {
                this.o.setTextAppearance(getContext(), this.q);
            }
        }
        this.n.setText(this.i);
        this.o.setText(this.j);
        boolean z = !TextUtils.isEmpty(this.i);
        boolean z2 = !TextUtils.isEmpty(this.j);
        int i = 0;
        this.o.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.m;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        if (this.m.getParent() == null) {
            addView(this.m);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0042a
    public /* bridge */ /* synthetic */ androidx.core.h.z a(int i, long j) {
        return super.a(i, j);
    }

    public boolean b() {
        return this.r;
    }

    public void c() {
        removeAllViews();
        this.l = null;
        this.c = null;
    }

    public boolean d() {
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.h();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC0042a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0042a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.d();
            this.d.e();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0042a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(ActionBarContextView.class.getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a2 = wa.a(this);
        int paddingRight = a2 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.k;
        if (view == null || view.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            int i6 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = AbstractC0042a.a(paddingRight, i6, a2);
            i5 = AbstractC0042a.a(a3 + a(this.k, a3, paddingTop, paddingTop2, a2), i7, a2);
        }
        LinearLayout linearLayout = this.m;
        if (linearLayout != null && this.l == null && linearLayout.getVisibility() != 8) {
            i5 += a(this.m, i5, paddingTop, paddingTop2, a2);
        }
        int i8 = i5;
        View view2 = this.l;
        if (view2 != null) {
            a(view2, i8, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView != null) {
            a(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i2) != 0) {
                int size = View.MeasureSpec.getSize(i);
                int i3 = this.e;
                if (i3 <= 0) {
                    i3 = View.MeasureSpec.getSize(i2);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i4 = i3 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                View view = this.k;
                if (view != null) {
                    int a2 = a(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
                    paddingLeft = a2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = a(this.c, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.m;
                if (linearLayout != null && this.l == null) {
                    if (this.r) {
                        this.m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.m.getMeasuredWidth();
                        boolean z = measuredWidth <= paddingLeft;
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        this.m.setVisibility(z ? 0 : 8);
                    } else {
                        paddingLeft = a(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.l;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                    int i6 = layoutParams.width;
                    if (i6 >= 0) {
                        paddingLeft = Math.min(i6, paddingLeft);
                    }
                    int i7 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
                    int i8 = layoutParams.height;
                    if (i8 >= 0) {
                        i4 = Math.min(i8, i4);
                    }
                    this.l.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(i4, i7));
                }
                if (this.e <= 0) {
                    int childCount = getChildCount();
                    int i9 = 0;
                    for (int i10 = 0; i10 < childCount; i10++) {
                        int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i9) {
                            i9 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i9);
                    return;
                }
                setMeasuredDimension(size, i3);
                return;
            }
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.AbstractC0042a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0042a
    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.l;
        if (view2 != null) {
            removeView(view2);
        }
        this.l = view;
        if (view != null && (linearLayout = this.m) != null) {
            removeView(linearLayout);
            this.m = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.j = charSequence;
        e();
    }

    public void setTitle(CharSequence charSequence) {
        this.i = charSequence;
        e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.r) {
            requestLayout();
        }
        this.r = z;
    }

    @Override // androidx.appcompat.widget.AbstractC0042a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public void a(androidx.appcompat.d.b bVar) {
        View view = this.k;
        if (view == null) {
            this.k = LayoutInflater.from(getContext()).inflate(this.s, (ViewGroup) this, false);
            addView(this.k);
        } else if (view.getParent() == null) {
            addView(this.k);
        }
        this.k.findViewById(R$id.action_mode_close_button).setOnClickListener(new View$OnClickListenerC0044c(this, bVar));
        androidx.appcompat.view.menu.l lVar = (androidx.appcompat.view.menu.l) bVar.c();
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.d.b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        lVar.a(this.d, this.f308b);
        this.c = (ActionMenuView) this.d.b(this);
        androidx.core.h.t.a(this.c, (Drawable) null);
        addView(this.c, layoutParams);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ia a2 = ia.a(context, attributeSet, R$styleable.ActionMode, i, 0);
        androidx.core.h.t.a(this, a2.b(R$styleable.ActionMode_background));
        this.p = a2.g(R$styleable.ActionMode_titleTextStyle, 0);
        this.q = a2.g(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.e = a2.f(R$styleable.ActionMode_height, 0);
        this.s = a2.g(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        a2.a();
    }

    public void a() {
        if (this.k == null) {
            c();
        }
    }
}
