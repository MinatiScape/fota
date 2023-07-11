package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private ColorStateList F;
    private Layout G;
    private Layout H;
    private TransformationMethod I;
    ObjectAnimator J;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f293b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;
    private Drawable g;
    private ColorStateList h;
    private PorterDuff.Mode i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private final Rect mTempRect;
    private final TextPaint mTextPaint;
    private int mTouchSlop;
    private int n;
    private boolean o;
    private CharSequence p;
    private CharSequence q;
    private boolean r;
    private int s;
    private float t;
    private float u;
    private VelocityTracker v;
    private int w;
    float x;
    private int y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f292a = new ca(Float.class, "thumbPos");
    private static final int[] CHECKED_STATE_SET = {16842912};

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private void b() {
        if (this.g != null) {
            if (this.j || this.k) {
                this.g = this.g.mutate();
                if (this.j) {
                    androidx.core.graphics.drawable.a.a(this.g, this.h);
                }
                if (this.k) {
                    androidx.core.graphics.drawable.a.a(this.g, this.i);
                }
                if (this.g.isStateful()) {
                    this.g.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.x > 0.5f;
    }

    private int getThumbOffset() {
        float f;
        if (wa.a(this)) {
            f = 1.0f - this.x;
        } else {
            f = this.x;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.g;
        if (drawable != null) {
            Rect rect2 = this.mTempRect;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f293b;
            if (drawable2 != null) {
                rect = E.c(drawable2);
            } else {
                rect = E.f246a;
            }
            return ((((this.y - this.A) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    public void a(Context context, int i) {
        ia a2 = ia.a(context, i, R$styleable.TextAppearance);
        ColorStateList a3 = a2.a(R$styleable.TextAppearance_android_textColor);
        if (a3 != null) {
            this.F = a3;
        } else {
            this.F = getTextColors();
        }
        int c = a2.c(R$styleable.TextAppearance_android_textSize, 0);
        if (c != 0) {
            float f = c;
            if (f != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f);
                requestLayout();
            }
        }
        a(a2.d(R$styleable.TextAppearance_android_typeface, -1), a2.d(R$styleable.TextAppearance_android_textStyle, -1));
        if (a2.a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.I = new androidx.appcompat.c.a(getContext());
        } else {
            this.I = null;
        }
        a2.a();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        Rect rect2 = this.mTempRect;
        int i3 = this.B;
        int i4 = this.C;
        int i5 = this.D;
        int i6 = this.E;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.f293b;
        if (drawable != null) {
            rect = E.c(drawable);
        } else {
            rect = E.f246a;
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i7 = rect2.left;
            thumbOffset += i7;
            if (rect != null) {
                int i8 = rect.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rect.top;
                int i10 = rect2.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rect.right;
                int i12 = rect2.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rect.bottom;
                int i14 = rect2.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                    this.g.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.g.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.f293b;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i15 = thumbOffset - rect2.left;
            int i16 = thumbOffset + this.A + rect2.right;
            this.f293b.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.a(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        Drawable drawable = this.f293b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f, f2);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.a(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f293b;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!wa.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (wa.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.r;
    }

    public boolean getSplitTrack() {
        return this.o;
    }

    public int getSwitchMinWidth() {
        return this.m;
    }

    public int getSwitchPadding() {
        return this.n;
    }

    public CharSequence getTextOff() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.f293b;
    }

    public int getThumbTextPadding() {
        return this.l;
    }

    public ColorStateList getThumbTintList() {
        return this.c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.d;
    }

    public Drawable getTrackDrawable() {
        return this.g;
    }

    public ColorStateList getTrackTintList() {
        return this.h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f293b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.J.end();
        this.J = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.C;
        int i2 = this.E;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f293b;
        if (drawable != null) {
            if (this.o && drawable2 != null) {
                Rect c = E.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += c.left;
                rect.right -= c.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.G : this.H;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.F;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        super.onLayout(z, i, i2, i3, i4);
        int i9 = 0;
        if (this.f293b != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect c = E.c(this.f293b);
            i5 = Math.max(0, c.left - rect.left);
            i9 = Math.max(0, c.right - rect.right);
        } else {
            i5 = 0;
        }
        if (wa.a(this)) {
            i6 = getPaddingLeft() + i5;
            width = ((this.y + i6) - i5) - i9;
        } else {
            width = (getWidth() - getPaddingRight()) - i9;
            i6 = (width - this.y) + i5 + i9;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i7 = this.z;
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i7 / 2);
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            i7 = this.z;
        } else {
            i8 = getHeight() - getPaddingBottom();
            paddingTop = i8 - this.z;
            this.B = i6;
            this.C = paddingTop;
            this.E = i8;
            this.D = width;
        }
        i8 = i7 + paddingTop;
        this.B = i6;
        this.C = paddingTop;
        this.E = i8;
        this.D = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.r) {
            if (this.G == null) {
                this.G = a(this.p);
            }
            if (this.H == null) {
                this.H = a(this.q);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.f293b;
        int i5 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i3 = (this.f293b.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f293b.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.A = Math.max(this.r ? Math.max(this.G.getWidth(), this.H.getWidth()) + (this.l * 2) : 0, i3);
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i5 = this.g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        Drawable drawable3 = this.f293b;
        if (drawable3 != null) {
            Rect c = E.c(drawable3);
            i6 = Math.max(i6, c.left);
            i7 = Math.max(i7, c.right);
        }
        int max = Math.max(this.m, (this.A * 2) + i6 + i7);
        int max2 = Math.max(i5, i4);
        this.y = max;
        this.z = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.v
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto La1
            r2 = 2
            if (r0 == r1) goto L8d
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8d
            goto Lbb
        L16:
            int r0 = r6.s
            if (r0 == 0) goto Lbb
            if (r0 == r1) goto L59
            if (r0 == r2) goto L20
            goto Lbb
        L20:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.t
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L34
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3f
        L34:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L3b
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3f
        L3b:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3f:
            boolean r0 = androidx.appcompat.widget.wa.a(r6)
            if (r0 == 0) goto L46
            float r2 = -r2
        L46:
            float r0 = r6.x
            float r0 = r0 + r2
            float r0 = a(r0, r4, r3)
            float r2 = r6.x
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L58
            r6.t = r7
            r6.setThumbPosition(r0)
        L58:
            return r1
        L59:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.t
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7f
            float r4 = r6.u
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lbb
        L7f:
            r6.s = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.t = r0
            r6.u = r3
            return r1
        L8d:
            int r0 = r6.s
            if (r0 != r2) goto L98
            r6.b(r7)
            super.onTouchEvent(r7)
            return r1
        L98:
            r0 = 0
            r6.s = r0
            android.view.VelocityTracker r0 = r6.v
            r0.clear()
            goto Lbb
        La1:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lbb
            boolean r3 = r6.a(r0, r2)
            if (r3 == 0) goto Lbb
            r6.s = r1
            r6.t = r0
            r6.u = r2
        Lbb:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && androidx.core.h.t.z(this)) {
            a(isChecked);
            return;
        }
        c();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.l.a(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.r != z) {
            this.r = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.m = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.n = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() == null || this.mTextPaint.getTypeface().equals(typeface)) && (this.mTextPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        this.mTextPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f293b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f293b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setThumbPosition(float f) {
        this.x = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.l = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.c = colorStateList;
        this.e = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.d = mode;
        this.f = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        this.j = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.i = mode;
        this.k = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f293b || drawable == this.g;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.v = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mTextPaint = new TextPaint(1);
        Resources resources = getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        ia a2 = ia.a(context, attributeSet, R$styleable.SwitchCompat, i, 0);
        this.f293b = a2.b(R$styleable.SwitchCompat_android_thumb);
        Drawable drawable = this.f293b;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.g = a2.b(R$styleable.SwitchCompat_track);
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.p = a2.e(R$styleable.SwitchCompat_android_textOn);
        this.q = a2.e(R$styleable.SwitchCompat_android_textOff);
        this.r = a2.a(R$styleable.SwitchCompat_showText, true);
        this.l = a2.c(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.m = a2.c(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.n = a2.c(R$styleable.SwitchCompat_switchPadding, 0);
        this.o = a2.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList a3 = a2.a(R$styleable.SwitchCompat_thumbTint);
        if (a3 != null) {
            this.c = a3;
            this.e = true;
        }
        PorterDuff.Mode a4 = E.a(a2.d(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.d != a4) {
            this.d = a4;
            this.f = true;
        }
        if (this.e || this.f) {
            a();
        }
        ColorStateList a5 = a2.a(R$styleable.SwitchCompat_trackTint);
        if (a5 != null) {
            this.h = a5;
            this.j = true;
        }
        PorterDuff.Mode a6 = E.a(a2.d(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.i != a6) {
            this.i = a6;
            this.k = true;
        }
        if (this.j || this.k) {
            b();
        }
        int g = a2.g(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            a(context, g);
        }
        a2.a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.w = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void b(MotionEvent motionEvent) {
        boolean z;
        this.s = 0;
        boolean z2 = true;
        boolean z3 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z3) {
            this.v.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND);
            float xVelocity = this.v.getXVelocity();
            if (Math.abs(xVelocity) > this.w) {
                if (!wa.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z2 = false;
                }
                z = z2;
            } else {
                z = getTargetCheckedState();
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        a(motionEvent);
    }

    private void a(int i, int i2) {
        Typeface typeface;
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i != 2) {
            typeface = i != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        a(typeface, i2);
    }

    public void a(Typeface typeface, int i) {
        Typeface create;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            int style = ((create != null ? create.getStyle() : 0) ^ (-1)) & i;
            this.mTextPaint.setFakeBoldText((style & 1) != 0);
            this.mTextPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    private void a() {
        if (this.f293b != null) {
            if (this.e || this.f) {
                this.f293b = this.f293b.mutate();
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(this.f293b, this.c);
                }
                if (this.f) {
                    androidx.core.graphics.drawable.a.a(this.f293b, this.d);
                }
                if (this.f293b.isStateful()) {
                    this.f293b.setState(getDrawableState());
                }
            }
        }
    }

    private Layout a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.I;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.mTextPaint;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean a(float f, float f2) {
        if (this.f293b == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f293b.getPadding(this.mTempRect);
        int i = this.C;
        int i2 = this.mTouchSlop;
        int i3 = i - i2;
        int i4 = (this.B + thumbOffset) - i2;
        Rect rect = this.mTempRect;
        return f > ((float) i4) && f < ((float) ((((this.A + i4) + rect.left) + rect.right) + i2)) && f2 > ((float) i3) && f2 < ((float) (this.E + i2));
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void a(boolean z) {
        this.J = ObjectAnimator.ofFloat(this, f292a, z ? 1.0f : 0.0f);
        this.J.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.J.setAutoCancel(true);
        }
        this.J.start();
    }
}
