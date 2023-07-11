package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private boolean f261a;

    /* renamed from: b  reason: collision with root package name */
    private int f262b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View a2 = a(i3);
            if (a2.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = a2.getMeasuredWidth();
                    measureChildWithMargins(a2, i2, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i4;
                }
            }
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View a2 = a(i3);
            if (a2.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = a2.getMeasuredHeight();
                    measureChildWithMargins(a2, makeMeasureSpec, 0, i2, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
                }
            }
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int i) {
        return 0;
    }

    void a(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean a2 = wa.a(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View a3 = a(i2);
            if (a3 != null && a3.getVisibility() != 8 && b(i2)) {
                LayoutParams layoutParams = (LayoutParams) a3.getLayoutParams();
                if (a2) {
                    left2 = a3.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else {
                    left2 = (a3.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.l;
                }
                b(canvas, left2);
            }
        }
        if (b(virtualChildCount)) {
            View a4 = a(virtualChildCount - 1);
            if (a4 != null) {
                LayoutParams layoutParams2 = (LayoutParams) a4.getLayoutParams();
                if (a2) {
                    left = a4.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    i = this.l;
                    right = left - i;
                } else {
                    right = a4.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                }
            } else if (a2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.l;
                right = left - i;
            }
            b(canvas, right);
        }
    }

    int b(View view) {
        return 0;
    }

    void b(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View a2 = a(i);
            if (a2 != null && a2.getVisibility() != 8 && b(i)) {
                a(canvas, (a2.getTop() - ((ViewGroup.MarginLayoutParams) ((LayoutParams) a2.getLayoutParams())).topMargin) - this.m);
            }
        }
        if (b(virtualChildCount)) {
            View a3 = a(virtualChildCount - 1);
            if (a3 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                bottom = a3.getBottom() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) a3.getLayoutParams())).bottomMargin;
            }
            a(canvas, bottom);
        }
    }

    int c(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f262b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f262b;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f262b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i3 = this.c;
            if (this.d == 1 && (i = this.e & 112) != 48) {
                if (i == 16) {
                    i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
                } else if (i == 80) {
                    i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                }
            }
            return i3 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f262b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            b(i, i2, i3, i4);
        } else {
            a(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.d == 1) {
            b(i, i2);
        } else {
            a(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f261a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f262b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.k) {
            return;
        }
        this.k = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
            this.m = drawable.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.e;
        if ((8388615 & i3) != i2) {
            this.e = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.e;
        if ((i3 & 112) != i2) {
            this.e = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.d;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f261a = true;
        this.f262b = -1;
        this.c = 0;
        this.e = 8388659;
        ia a2 = ia.a(context, attributeSet, R$styleable.LinearLayoutCompat, i, 0);
        int d = a2.d(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (d >= 0) {
            setOrientation(d);
        }
        int d2 = a2.d(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (d2 >= 0) {
            setGravity(d2);
        }
        boolean a3 = a2.a(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.g = a2.b(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f262b = a2.d(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a2.a(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a2.b(R$styleable.LinearLayoutCompat_divider));
        this.n = a2.d(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.o = a2.c(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        a2.a();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public float f263a;

        /* renamed from: b  reason: collision with root package name */
        public int f264b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f264b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LinearLayoutCompat_Layout);
            this.f263a = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f264b = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f264b = -1;
            this.f263a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f264b = -1;
        }
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.n & 4) != 0;
        } else if ((this.n & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    View a(int i) {
        return getChildAt(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.a(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0330  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 923
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.b(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = 0
        L49:
            if (r12 >= r10) goto Lc9
            android.view.View r13 = r6.a(r12)
            r14 = 1
            if (r13 != 0) goto L59
            int r1 = r6.c(r12)
            int r0 = r0 + r1
            goto Lc6
        L59:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto Lc6
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r1 = r5.f264b
            if (r1 >= 0) goto L75
            r1 = r11
        L75:
            int r2 = androidx.core.h.t.k(r17)
            int r1 = androidx.core.h.C0069c.a(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L8e
            r2 = 5
            if (r1 == r2) goto L89
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L87:
            r2 = r1
            goto L9a
        L89:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
            goto L98
        L8e:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
        L98:
            int r1 = r1 - r2
            goto L87
        L9a:
            boolean r1 = r6.b(r12)
            if (r1 == 0) goto La3
            int r1 = r6.m
            int r0 = r0 + r1
        La3:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.a(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.a(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.b(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.a(r13, r12)
            int r12 = r12 + r0
            r0 = r16
        Lc6:
            r1 = 1
            int r12 = r12 + r1
            goto L49
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.b(int, int, int, int):void");
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.a(int, int, int, int):void");
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }
}
