package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0058q;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.ia;
import androidx.core.h.C0067a;
import androidx.core.h.t;
import androidx.core.widget.l;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.s;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private int A;
    private Drawable B;
    private final Rect C;
    private final RectF D;
    private Typeface E;
    private boolean F;
    private Drawable G;
    private CharSequence H;
    private CheckableImageButton I;
    private boolean J;
    private Drawable K;
    private Drawable L;
    private ColorStateList M;
    private boolean N;
    private PorterDuff.Mode O;
    private boolean P;
    private ColorStateList Q;
    private ColorStateList R;
    private final int S;
    private final int T;
    private int U;
    private final int V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f1427a;
    final com.google.android.material.internal.e aa;

    /* renamed from: b  reason: collision with root package name */
    EditText f1428b;
    private boolean ba;
    private CharSequence c;
    private ValueAnimator ca;
    private final c d;
    private boolean da;
    boolean e;
    private boolean ea;
    private int f;
    private boolean fa;
    private boolean g;
    private TextView h;
    private final int i;
    private final int j;
    private boolean k;
    private CharSequence l;
    private boolean m;
    private GradientDrawable n;
    private final int o;
    private final int p;
    private int q;
    private final int r;
    private float s;
    private float t;
    private float u;
    private float v;
    private int w;
    private final int x;
    private final int y;
    private int z;

    /* loaded from: classes.dex */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new g();
        CharSequence c;
        boolean d;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.c) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.c, parcel, i);
            parcel.writeInt(this.d ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.d = parcel.readInt() == 1;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends C0067a {
        private final TextInputLayout c;

        public a(TextInputLayout textInputLayout) {
            this.c = textInputLayout;
        }

        @Override // androidx.core.h.C0067a
        public void a(View view, androidx.core.h.a.c cVar) {
            super.a(view, cVar);
            EditText editText = this.c.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.c.getHint();
            CharSequence error = this.c.getError();
            CharSequence counterOverflowDescription = this.c.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                cVar.f(text);
            } else if (z2) {
                cVar.f(hint);
            }
            if (z2) {
                cVar.d(hint);
                if (!z && z2) {
                    z4 = true;
                }
                cVar.m(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                cVar.c(error);
                cVar.f(true);
            }
        }

        @Override // androidx.core.h.C0067a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            EditText editText = this.c.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.c.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private void e() {
        int i;
        Drawable drawable;
        if (this.n == null) {
            return;
        }
        q();
        EditText editText = this.f1428b;
        if (editText != null && this.q == 2) {
            if (editText.getBackground() != null) {
                this.B = this.f1428b.getBackground();
            }
            t.a(this.f1428b, (Drawable) null);
        }
        EditText editText2 = this.f1428b;
        if (editText2 != null && this.q == 1 && (drawable = this.B) != null) {
            t.a(editText2, drawable);
        }
        int i2 = this.w;
        if (i2 > -1 && (i = this.z) != 0) {
            this.n.setStroke(i2, i);
        }
        this.n.setCornerRadii(getCornerRadiiAsArray());
        this.n.setColor(this.A);
        invalidate();
    }

    private void f() {
        if (this.G != null) {
            if (this.N || this.P) {
                this.G = androidx.core.graphics.drawable.a.i(this.G).mutate();
                if (this.N) {
                    androidx.core.graphics.drawable.a.a(this.G, this.M);
                }
                if (this.P) {
                    androidx.core.graphics.drawable.a.a(this.G, this.O);
                }
                CheckableImageButton checkableImageButton = this.I;
                if (checkableImageButton != null) {
                    Drawable drawable = checkableImageButton.getDrawable();
                    Drawable drawable2 = this.G;
                    if (drawable != drawable2) {
                        this.I.setImageDrawable(drawable2);
                    }
                }
            }
        }
    }

    private void g() {
        int i = this.q;
        if (i == 0) {
            this.n = null;
        } else if (i == 2 && this.k && !(this.n instanceof com.google.android.material.textfield.a)) {
            this.n = new com.google.android.material.textfield.a();
        } else if (this.n instanceof GradientDrawable) {
        } else {
            this.n = new GradientDrawable();
        }
    }

    private Drawable getBoxBackground() {
        int i = this.q;
        if (i != 1 && i != 2) {
            throw new IllegalStateException();
        }
        return this.n;
    }

    private float[] getCornerRadiiAsArray() {
        if (com.google.android.material.internal.t.a(this)) {
            float f = this.t;
            float f2 = this.s;
            float f3 = this.v;
            float f4 = this.u;
            return new float[]{f, f, f2, f2, f3, f3, f4, f4};
        }
        float f5 = this.s;
        float f6 = this.t;
        float f7 = this.u;
        float f8 = this.v;
        return new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
    }

    private int h() {
        EditText editText = this.f1428b;
        if (editText == null) {
            return 0;
        }
        int i = this.q;
        if (i != 1) {
            if (i != 2) {
                return 0;
            }
            return editText.getTop() + j();
        }
        return editText.getTop();
    }

    private int i() {
        int i = this.q;
        if (i != 1) {
            if (i != 2) {
                return getPaddingTop();
            }
            return getBoxBackground().getBounds().top - j();
        }
        return getBoxBackground().getBounds().top + this.r;
    }

    private int j() {
        float d;
        if (this.k) {
            int i = this.q;
            if (i == 0 || i == 1) {
                d = this.aa.d();
            } else if (i != 2) {
                return 0;
            } else {
                d = this.aa.d() / 2.0f;
            }
            return (int) d;
        }
        return 0;
    }

    private void k() {
        if (l()) {
            ((com.google.android.material.textfield.a) this.n).b();
        }
    }

    private boolean l() {
        return this.k && !TextUtils.isEmpty(this.l) && (this.n instanceof com.google.android.material.textfield.a);
    }

    private void m() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.f1428b.getBackground()) == null || this.da) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.da = com.google.android.material.internal.g.a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.da) {
            return;
        }
        t.a(this.f1428b, newDrawable);
        this.da = true;
        o();
    }

    private boolean n() {
        EditText editText = this.f1428b;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private void o() {
        g();
        if (this.q != 0) {
            t();
        }
        v();
    }

    private void p() {
        if (l()) {
            RectF rectF = this.D;
            this.aa.a(rectF);
            a(rectF);
            ((com.google.android.material.textfield.a) this.n).a(rectF);
        }
    }

    private void q() {
        int i = this.q;
        if (i != 1) {
            if (i == 2 && this.U == 0) {
                this.U = this.R.getColorForState(getDrawableState(), this.R.getDefaultColor());
                return;
            }
            return;
        }
        this.w = 0;
    }

    private boolean r() {
        return this.F && (n() || this.J);
    }

    private void s() {
        Drawable background;
        EditText editText = this.f1428b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        if (E.a(background)) {
            background = background.mutate();
        }
        com.google.android.material.internal.f.a(this, this.f1428b, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f1428b.getBottom());
        }
    }

    private void setEditText(EditText editText) {
        if (this.f1428b == null) {
            if (!(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f1428b = editText;
            o();
            setTextInputAccessibilityDelegate(new a(this));
            if (!n()) {
                this.aa.c(this.f1428b.getTypeface());
            }
            this.aa.a(this.f1428b.getTextSize());
            int gravity = this.f1428b.getGravity();
            this.aa.b((gravity & (-113)) | 48);
            this.aa.d(gravity);
            this.f1428b.addTextChangedListener(new d(this));
            if (this.Q == null) {
                this.Q = this.f1428b.getHintTextColors();
            }
            if (this.k) {
                if (TextUtils.isEmpty(this.l)) {
                    this.c = this.f1428b.getHint();
                    setHint(this.c);
                    this.f1428b.setHint((CharSequence) null);
                }
                this.m = true;
            }
            if (this.h != null) {
                a(this.f1428b.getText().length());
            }
            this.d.a();
            u();
            a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.l)) {
            return;
        }
        this.l = charSequence;
        this.aa.a(charSequence);
        if (this.W) {
            return;
        }
        p();
    }

    private void t() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1427a.getLayoutParams();
        int j = j();
        if (j != layoutParams.topMargin) {
            layoutParams.topMargin = j;
            this.f1427a.requestLayout();
        }
    }

    private void u() {
        if (this.f1428b == null) {
            return;
        }
        if (r()) {
            if (this.I == null) {
                this.I = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_password_icon, (ViewGroup) this.f1427a, false);
                this.I.setImageDrawable(this.G);
                this.I.setContentDescription(this.H);
                this.f1427a.addView(this.I);
                this.I.setOnClickListener(new e(this));
            }
            EditText editText = this.f1428b;
            if (editText != null && t.l(editText) <= 0) {
                this.f1428b.setMinimumHeight(t.l(this.I));
            }
            this.I.setVisibility(0);
            this.I.setChecked(this.J);
            if (this.K == null) {
                this.K = new ColorDrawable();
            }
            this.K.setBounds(0, 0, this.I.getMeasuredWidth(), 1);
            Drawable[] a2 = l.a(this.f1428b);
            if (a2[2] != this.K) {
                this.L = a2[2];
            }
            l.a(this.f1428b, a2[0], a2[1], this.K, a2[3]);
            this.I.setPadding(this.f1428b.getPaddingLeft(), this.f1428b.getPaddingTop(), this.f1428b.getPaddingRight(), this.f1428b.getPaddingBottom());
            return;
        }
        CheckableImageButton checkableImageButton = this.I;
        if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
            this.I.setVisibility(8);
        }
        if (this.K != null) {
            Drawable[] a3 = l.a(this.f1428b);
            if (a3[2] == this.K) {
                l.a(this.f1428b, a3[0], a3[1], this.L, a3[3]);
                this.K = null;
            }
        }
    }

    private void v() {
        if (this.q == 0 || this.n == null || this.f1428b == null || getRight() == 0) {
            return;
        }
        int left = this.f1428b.getLeft();
        int h = h();
        int right = this.f1428b.getRight();
        int bottom = this.f1428b.getBottom() + this.o;
        if (this.q == 2) {
            int i = this.y;
            left += i / 2;
            h -= i / 2;
            right -= i / 2;
            bottom += i / 2;
        }
        this.n.setBounds(left, h, right, bottom);
        e();
        s();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f1427a.addView(view, layoutParams2);
            this.f1427a.setLayoutParams(layoutParams);
            t();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        a(z, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable background;
        TextView textView;
        EditText editText = this.f1428b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        m();
        if (E.a(background)) {
            background = background.mutate();
        }
        if (this.d.c()) {
            background.setColorFilter(C0058q.a(this.d.e(), PorterDuff.Mode.SRC_IN));
        } else if (this.g && (textView = this.h) != null) {
            background.setColorFilter(C0058q.a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.b(background);
            this.f1428b.refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        TextView textView;
        if (this.n == null || this.q == 0) {
            return;
        }
        EditText editText = this.f1428b;
        boolean z = true;
        boolean z2 = editText != null && editText.hasFocus();
        EditText editText2 = this.f1428b;
        z = (editText2 == null || !editText2.isHovered()) ? false : false;
        if (this.q == 2) {
            if (!isEnabled()) {
                this.z = this.V;
            } else if (this.d.c()) {
                this.z = this.d.e();
            } else if (this.g && (textView = this.h) != null) {
                this.z = textView.getCurrentTextColor();
            } else if (z2) {
                this.z = this.U;
            } else if (z) {
                this.z = this.T;
            } else {
                this.z = this.S;
            }
            if ((z || z2) && isEnabled()) {
                this.w = this.y;
            } else {
                this.w = this.x;
            }
            e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.fa = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.fa = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.n;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.k) {
            this.aa.a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.ea) {
            return;
        }
        boolean z = true;
        this.ea = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        b((t.z(this) && isEnabled()) ? false : false);
        c();
        v();
        d();
        com.google.android.material.internal.e eVar = this.aa;
        if (eVar != null ? eVar.a(drawableState) | false : false) {
            invalidate();
        }
        this.ea = false;
    }

    public int getBoxBackgroundColor() {
        return this.A;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.u;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.v;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.t;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.s;
    }

    public int getBoxStrokeColor() {
        return this.U;
    }

    public int getCounterMaxLength() {
        return this.f;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.e && this.g && (textView = this.h) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.Q;
    }

    public EditText getEditText() {
        return this.f1428b;
    }

    public CharSequence getError() {
        if (this.d.k()) {
            return this.d.d();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.d.e();
    }

    final int getErrorTextCurrentColor() {
        return this.d.e();
    }

    public CharSequence getHelperText() {
        if (this.d.l()) {
            return this.d.g();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.d.h();
    }

    public CharSequence getHint() {
        if (this.k) {
            return this.l;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.aa.d();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.aa.f();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.H;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.G;
    }

    public Typeface getTypeface() {
        return this.E;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        EditText editText;
        super.onLayout(z, i, i2, i3, i4);
        if (this.n != null) {
            v();
        }
        if (!this.k || (editText = this.f1428b) == null) {
            return;
        }
        Rect rect = this.C;
        com.google.android.material.internal.f.a(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.f1428b.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f1428b.getCompoundPaddingRight();
        int i5 = i();
        this.aa.b(compoundPaddingLeft, rect.top + this.f1428b.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f1428b.getCompoundPaddingBottom());
        this.aa.a(compoundPaddingLeft, i5, compoundPaddingRight, (i4 - i2) - getPaddingBottom());
        this.aa.m();
        if (!l() || this.W) {
            return;
        }
        p();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        u();
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.c);
        if (savedState.d) {
            a(true);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.d.c()) {
            savedState.c = getError();
        }
        savedState.d = this.J;
        return savedState;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.A != i) {
            this.A = i;
            e();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(androidx.core.content.a.a(getContext(), i));
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.q) {
            return;
        }
        this.q = i;
        o();
    }

    public void setBoxStrokeColor(int i) {
        if (this.U != i) {
            this.U = i;
            d();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.e != z) {
            if (z) {
                this.h = new AppCompatTextView(getContext());
                this.h.setId(R$id.textinput_counter);
                Typeface typeface = this.E;
                if (typeface != null) {
                    this.h.setTypeface(typeface);
                }
                this.h.setMaxLines(1);
                a(this.h, this.j);
                this.d.a(this.h, 2);
                EditText editText = this.f1428b;
                if (editText == null) {
                    a(0);
                } else {
                    a(editText.getText().length());
                }
            } else {
                this.d.b(this.h, 2);
                this.h = null;
            }
            this.e = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f != i) {
            if (i > 0) {
                this.f = i;
            } else {
                this.f = -1;
            }
            if (this.e) {
                EditText editText = this.f1428b;
                a(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.Q = colorStateList;
        this.R = colorStateList;
        if (this.f1428b != null) {
            b(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        a(this, z);
        super.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        if (!this.d.k()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.d.a(charSequence);
        } else {
            this.d.i();
        }
    }

    public void setErrorEnabled(boolean z) {
        this.d.a(z);
    }

    public void setErrorTextAppearance(int i) {
        this.d.b(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.d.a(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (a()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!a()) {
            setHelperTextEnabled(true);
        }
        this.d.b(charSequence);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.d.b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.d.b(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.d.c(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.k) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.ba = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (!this.k) {
                this.m = false;
                if (!TextUtils.isEmpty(this.l) && TextUtils.isEmpty(this.f1428b.getHint())) {
                    this.f1428b.setHint(this.l);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f1428b.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.l)) {
                        setHint(hint);
                    }
                    this.f1428b.setHint((CharSequence) null);
                }
                this.m = true;
            }
            if (this.f1428b != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.aa.a(i);
        this.R = this.aa.b();
        if (this.f1428b != null) {
            b(false);
            t();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EditText editText;
        if (this.F != z) {
            this.F = z;
            if (!z && this.J && (editText = this.f1428b) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.J = false;
            u();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.M = colorStateList;
        this.N = true;
        f();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.O = mode;
        this.P = true;
        f();
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        EditText editText = this.f1428b;
        if (editText != null) {
            t.a(editText, aVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.E) {
            this.E = typeface;
            this.aa.c(typeface);
            this.d.a(typeface);
            TextView textView = this.h;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    private void a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f1428b;
        boolean z3 = true;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f1428b;
        z3 = (editText2 == null || !editText2.hasFocus()) ? false : false;
        boolean c = this.d.c();
        ColorStateList colorStateList2 = this.Q;
        if (colorStateList2 != null) {
            this.aa.a(colorStateList2);
            this.aa.b(this.Q);
        }
        if (!isEnabled) {
            this.aa.a(ColorStateList.valueOf(this.V));
            this.aa.b(ColorStateList.valueOf(this.V));
        } else if (c) {
            this.aa.a(this.d.f());
        } else if (this.g && (textView = this.h) != null) {
            this.aa.a(textView.getTextColors());
        } else if (z3 && (colorStateList = this.R) != null) {
            this.aa.a(colorStateList);
        }
        if (!z4 && (!isEnabled() || (!z3 && !c))) {
            if (z2 || !this.W) {
                d(z);
            }
        } else if (z2 || this.W) {
            c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.m;
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new c(this);
        this.C = new Rect();
        this.D = new RectF();
        this.aa = new com.google.android.material.internal.e(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f1427a = new FrameLayout(context);
        this.f1427a.setAddStatesFromChildren(true);
        addView(this.f1427a);
        this.aa.b(com.google.android.material.a.a.f1232a);
        this.aa.a(com.google.android.material.a.a.f1232a);
        this.aa.b(8388659);
        ia b2 = s.b(context, attributeSet, R$styleable.TextInputLayout, i, R$style.Widget_Design_TextInputLayout, new int[0]);
        this.k = b2.a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(b2.e(R$styleable.TextInputLayout_android_hint));
        this.ba = b2.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.o = context.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_bottom_offset);
        this.p = context.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.r = b2.b(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.s = b2.a(R$styleable.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.t = b2.a(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.u = b2.a(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.v = b2.a(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.A = b2.a(R$styleable.TextInputLayout_boxBackgroundColor, 0);
        this.U = b2.a(R$styleable.TextInputLayout_boxStrokeColor, 0);
        this.x = context.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default);
        this.y = context.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused);
        this.w = this.x;
        setBoxBackgroundMode(b2.d(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        if (b2.g(R$styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList a2 = b2.a(R$styleable.TextInputLayout_android_textColorHint);
            this.R = a2;
            this.Q = a2;
        }
        this.S = androidx.core.content.a.a(context, R$color.mtrl_textinput_default_box_stroke_color);
        this.V = androidx.core.content.a.a(context, R$color.mtrl_textinput_disabled_color);
        this.T = androidx.core.content.a.a(context, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (b2.g(R$styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(b2.g(R$styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int g = b2.g(R$styleable.TextInputLayout_errorTextAppearance, 0);
        boolean a3 = b2.a(R$styleable.TextInputLayout_errorEnabled, false);
        int g2 = b2.g(R$styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean a4 = b2.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence e = b2.e(R$styleable.TextInputLayout_helperText);
        boolean a5 = b2.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(b2.d(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.j = b2.g(R$styleable.TextInputLayout_counterTextAppearance, 0);
        this.i = b2.g(R$styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.F = b2.a(R$styleable.TextInputLayout_passwordToggleEnabled, false);
        this.G = b2.b(R$styleable.TextInputLayout_passwordToggleDrawable);
        this.H = b2.e(R$styleable.TextInputLayout_passwordToggleContentDescription);
        if (b2.g(R$styleable.TextInputLayout_passwordToggleTint)) {
            this.N = true;
            this.M = b2.a(R$styleable.TextInputLayout_passwordToggleTint);
        }
        if (b2.g(R$styleable.TextInputLayout_passwordToggleTintMode)) {
            this.P = true;
            this.O = com.google.android.material.internal.t.a(b2.d(R$styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        b2.a();
        setHelperTextEnabled(a4);
        setHelperText(e);
        setHelperTextTextAppearance(g2);
        setErrorEnabled(a3);
        setErrorTextAppearance(g);
        setCounterEnabled(a5);
        f();
        t.d(this, 2);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.H = charSequence;
        CheckableImageButton checkableImageButton = this.I;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.G = drawable;
        CheckableImageButton checkableImageButton = this.I;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void c(boolean z) {
        ValueAnimator valueAnimator = this.ca;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ca.cancel();
        }
        if (z && this.ba) {
            a(1.0f);
        } else {
            this.aa.b(1.0f);
        }
        this.W = false;
        if (l()) {
            p();
        }
    }

    private void d(boolean z) {
        ValueAnimator valueAnimator = this.ca;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ca.cancel();
        }
        if (z && this.ba) {
            a(0.0f);
        } else {
            this.aa.b(0.0f);
        }
        if (l() && ((com.google.android.material.textfield.a) this.n).a()) {
            k();
        }
        this.W = true;
    }

    public boolean a() {
        return this.d.l();
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        boolean z = this.g;
        if (this.f == -1) {
            this.h.setText(String.valueOf(i));
            this.h.setContentDescription(null);
            this.g = false;
        } else {
            if (t.b(this.h) == 1) {
                t.c(this.h, 0);
            }
            this.g = i > this.f;
            boolean z2 = this.g;
            if (z != z2) {
                a(this.h, z2 ? this.i : this.j);
                if (this.g) {
                    t.c(this.h, 1);
                }
            }
            this.h.setText(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.f)));
            this.h.setContentDescription(getContext().getString(R$string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.f)));
        }
        if (this.f1428b == null || z == this.g) {
            return;
        }
        b(false);
        d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.l.d(r3, r4)     // Catch: java.lang.Exception -> L1a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1a
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1a
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1a
        L18:
            r4 = 0
            r0 = 0
        L1a:
            if (r0 == 0) goto L2e
            int r4 = com.google.android.material.R$style.TextAppearance_AppCompat_Caption
            androidx.core.widget.l.d(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R$color.design_error
            int r4 = androidx.core.content.a.a(r4, r0)
            r3.setTextColor(r4)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.a(android.widget.TextView, int):void");
    }

    public void a(boolean z) {
        if (this.F) {
            int selectionEnd = this.f1428b.getSelectionEnd();
            if (n()) {
                this.f1428b.setTransformationMethod(null);
                this.J = true;
            } else {
                this.f1428b.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.J = false;
            }
            this.I.setChecked(this.J);
            if (z) {
                this.I.jumpDrawablesToCurrentState();
            }
            this.f1428b.setSelection(selectionEnd);
        }
    }

    private void a(RectF rectF) {
        float f = rectF.left;
        int i = this.p;
        rectF.left = f - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    void a(float f) {
        if (this.aa.i() == f) {
            return;
        }
        if (this.ca == null) {
            this.ca = new ValueAnimator();
            this.ca.setInterpolator(com.google.android.material.a.a.f1233b);
            this.ca.setDuration(167L);
            this.ca.addUpdateListener(new f(this));
        }
        this.ca.setFloatValues(this.aa.i(), f);
        this.ca.start();
    }
}
