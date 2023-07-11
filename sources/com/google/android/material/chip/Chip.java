package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.a.h;
import androidx.core.h.a.c;
import androidx.core.h.t;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.chip.d;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements d.a {

    /* renamed from: b  reason: collision with root package name */
    private static final Rect f1306b = new Rect();
    private static final int[] c = {16842913};
    private d d;
    private RippleDrawable e;
    private View.OnClickListener f;
    private CompoundButton.OnCheckedChangeListener g;
    private boolean h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final a m;
    private final Rect n;
    private final RectF o;
    private final h.a p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.customview.a.c {
        a(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.a.c
        protected int a(float f, float f2) {
            return (Chip.this.f() && Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 0 : -1;
        }

        @Override // androidx.customview.a.c
        protected void a(List<Integer> list) {
            if (Chip.this.f()) {
                list.add(0);
            }
        }

        @Override // androidx.customview.a.c
        protected void a(int i, androidx.core.h.a.c cVar) {
            if (Chip.this.f()) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.b(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    cVar.b((CharSequence) context.getString(i2, objArr).trim());
                }
                cVar.c(Chip.this.getCloseIconTouchBoundsInt());
                cVar.a(c.a.e);
                cVar.g(Chip.this.isEnabled());
                return;
            }
            cVar.b("");
            cVar.c(Chip.f1306b);
        }

        @Override // androidx.customview.a.c
        protected void a(androidx.core.h.a.c cVar) {
            cVar.c(Chip.this.d != null && Chip.this.d.D());
            cVar.a((CharSequence) Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.f(text);
            } else {
                cVar.b(text);
            }
        }

        @Override // androidx.customview.a.c
        protected boolean a(int i, int i2, Bundle bundle) {
            if (i2 == 16 && i == 0) {
                return Chip.this.c();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.i == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        d dVar = this.d;
        return (dVar == null || dVar.m() == null) ? false : true;
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.o.setEmpty();
        if (f()) {
            this.d.a(this.o);
        }
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.n.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.n;
    }

    private com.google.android.material.f.c getTextAppearance() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.A();
        }
        return null;
    }

    private void h() {
        d dVar;
        if (TextUtils.isEmpty(getText()) || (dVar = this.d) == null) {
            return;
        }
        float j = dVar.j() + this.d.e() + this.d.C() + this.d.B();
        if ((this.d.F() && this.d.f() != null) || (this.d.b() != null && this.d.E() && isChecked())) {
            j += this.d.w() + this.d.v() + this.d.g();
        }
        if (this.d.H() && this.d.m() != null) {
            j += this.d.q() + this.d.o() + this.d.p();
        }
        if (t.n(this) != j) {
            t.b(this, t.o(this), getPaddingTop(), (int) j, getPaddingBottom());
        }
    }

    private void setCloseIconFocused(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    private void setFocusedVirtualView(int i) {
        int i2 = this.i;
        if (i2 != i) {
            if (i2 == 0) {
                setCloseIconFocused(false);
            }
            this.i = i;
            if (i == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return a(motionEvent) || this.m.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.m.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.d;
        if ((dVar == null || !dVar.G()) ? false : this.d.a(d())) {
            invalidate();
        }
    }

    public Drawable getCheckedIcon() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public float getChipCornerRadius() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.d();
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.d;
    }

    public float getChipEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.e();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.f();
        }
        return null;
    }

    public float getChipIconSize() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.g();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.h();
        }
        return null;
    }

    public float getChipMinHeight() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.i();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.j();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.k();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.l();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.m();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.n();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.o();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.p();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.q();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.s();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.t();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.i == 0) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.u();
        }
        return null;
    }

    public float getIconEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.v();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.w();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.x();
        }
        return null;
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.y();
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        d dVar = this.d;
        return dVar != null ? dVar.z() : "";
    }

    public float getTextEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.B();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.C();
        }
        return 0.0f;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, c);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        d dVar;
        if (!TextUtils.isEmpty(getText()) && (dVar = this.d) != null && !dVar.J()) {
            int save = canvas.save();
            canvas.translate(b(this.d), 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z, i, rect);
        this.m.a(z, i, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        int keyCode = keyEvent.getKeyCode();
        boolean z = false;
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasNoModifiers()) {
                            z = a(com.google.android.material.internal.t.a(this));
                            break;
                        }
                        break;
                    case 22:
                        if (keyEvent.hasNoModifiers()) {
                            z = a(!com.google.android.material.internal.t.a(this));
                            break;
                        }
                        break;
                }
            }
            int i3 = this.i;
            if (i3 == -1) {
                performClick();
                return true;
            } else if (i3 == 0) {
                c();
                return true;
            }
        } else {
            if (keyEvent.hasNoModifiers()) {
                i2 = 2;
            } else {
                i2 = keyEvent.hasModifiers(1) ? 1 : 0;
            }
            if (i2 != 0) {
                ViewParent parent = getParent();
                View view = this;
                do {
                    view = view.focusSearch(i2);
                    if (view == null || view == this) {
                        break;
                    }
                } while (view.getParent() == parent);
                if (view != null) {
                    view.requestFocus();
                    return true;
                }
            }
        }
        if (z) {
            invalidate();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.j
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.j
            if (r0 == 0) goto L34
            r5.c()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != this.d && drawable != this.e) {
            throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != this.d && drawable != this.e) {
            throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public void setCheckableResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        d dVar = this.d;
        if (dVar == null) {
            this.h = z;
        } else if (dVar.D()) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked == z || (onCheckedChangeListener = this.g) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(i);
        }
    }

    public void setCheckedIconVisible(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(i);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(i);
        }
    }

    public void setChipCornerRadius(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(f);
        }
    }

    public void setChipCornerRadiusResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.e(i);
        }
    }

    public void setChipDrawable(d dVar) {
        d dVar2 = this.d;
        if (dVar2 != dVar) {
            c(dVar2);
            this.d = dVar;
            a(this.d);
            if (com.google.android.material.g.a.f1350a) {
                this.e = new RippleDrawable(com.google.android.material.g.a.a(this.d.x()), this.d, null);
                this.d.f(false);
                t.a(this, this.e);
                return;
            }
            this.d.f(true);
            t.a(this, this.d);
        }
    }

    public void setChipEndPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(f);
        }
    }

    public void setChipEndPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.f(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.g(i);
        }
    }

    public void setChipIconSize(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.h(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.i(i);
        }
    }

    public void setChipIconVisible(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.j(i);
        }
    }

    public void setChipMinHeight(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(f);
        }
    }

    public void setChipMinHeightResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.k(i);
        }
    }

    public void setChipStartPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.e(f);
        }
    }

    public void setChipStartPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.l(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.m(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.f(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.n(i);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(drawable);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.g(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.o(i);
        }
    }

    public void setCloseIconResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.p(i);
        }
    }

    public void setCloseIconSize(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.h(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.q(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.i(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.r(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.s(i);
        }
    }

    public void setCloseIconVisible(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.t(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.d == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(hVar);
        }
    }

    public void setHideMotionSpecResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.u(i);
        }
    }

    public void setIconEndPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.j(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.v(i);
        }
    }

    public void setIconStartPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.k(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.w(i);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        d dVar = this.d;
        if (dVar != null) {
            dVar.x(i);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.g = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.e(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.y(i);
        }
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(hVar);
        }
    }

    public void setShowMotionSpecResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.z(i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.d == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        CharSequence a2 = androidx.core.f.a.a().a(charSequence);
        if (this.d.J()) {
            a2 = null;
        }
        super.setText(a2, bufferType);
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(charSequence);
        }
    }

    public void setTextAppearance(com.google.android.material.f.c cVar) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(cVar);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.p);
            a(cVar);
        }
    }

    public void setTextAppearanceResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.A(i);
        }
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.l(f);
        }
    }

    public void setTextEndPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.B(i);
        }
    }

    public void setTextStartPadding(float f) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.m(f);
        }
    }

    public void setTextStartPaddingResource(int i) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.C(i);
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                            if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                                if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                    Log.w("Chip", "Chip text must be vertically center and start aligned");
                                    return;
                                }
                                return;
                            }
                            throw new UnsupportedOperationException("Chip does not support multi-line text");
                        }
                        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    private void c(d dVar) {
        if (dVar != null) {
            dVar.a((d.a) null);
        }
    }

    private int[] d() {
        int i = 0;
        int i2 = isEnabled() ? 1 : 0;
        if (this.l) {
            i2++;
        }
        if (this.k) {
            i2++;
        }
        if (this.j) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i = 1;
        }
        if (this.l) {
            iArr[i] = 16842908;
            i++;
        }
        if (this.k) {
            iArr[i] = 16843623;
            i++;
        }
        if (this.j) {
            iArr[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            iArr[i] = 16842913;
        }
        return iArr;
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = Integer.MIN_VALUE;
        this.n = new Rect();
        this.o = new RectF();
        this.p = new com.google.android.material.chip.a(this);
        a(attributeSet);
        d a2 = d.a(context, attributeSet, i, R$style.Widget_MaterialComponents_Chip_Action);
        setChipDrawable(a2);
        this.m = new a(this);
        t.a(this, this.m);
        g();
        setChecked(this.h);
        a2.e(false);
        setText(a2.z());
        setEllipsize(a2.t());
        setIncludeFontPadding(false);
        if (getTextAppearance() != null) {
            a(getTextAppearance());
        }
        setSingleLine();
        setGravity(8388627);
        h();
    }

    private float b(d dVar) {
        float chipStartPadding = getChipStartPadding() + dVar.a() + getTextStartPadding();
        return t.k(this) == 0 ? chipStartPadding : -chipStartPadding;
    }

    public boolean c() {
        boolean z;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        } else {
            z = false;
        }
        this.m.a(0, 1);
        return z;
    }

    public void setCheckedIconVisible(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(z);
        }
    }

    public void setCloseIconVisible(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        d dVar = this.d;
        if (dVar != null) {
            dVar.A(i);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(context, getPaint(), this.p);
            a(getTextAppearance());
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        d dVar = this.d;
        if (dVar != null) {
            dVar.A(i);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.p);
            a(getTextAppearance());
        }
    }

    private void a(d dVar) {
        dVar.a(this);
    }

    @Override // com.google.android.material.chip.d.a
    public void a() {
        h();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = androidx.customview.a.c.class.getDeclaredField("o");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.m)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = androidx.customview.a.c.class.getDeclaredMethod("i", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.m, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            } catch (NoSuchFieldException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchMethodException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            }
        }
        return false;
    }

    private boolean a(boolean z) {
        e();
        if (z) {
            if (this.i == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.i == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    private void a(com.google.android.material.f.c cVar) {
        TextPaint paint = getPaint();
        paint.drawableState = this.d.getState();
        cVar.b(getContext(), paint, this.p);
    }
}
