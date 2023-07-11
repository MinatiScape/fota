package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;
/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f375a = {16842801};

    /* renamed from: b  reason: collision with root package name */
    private static final h f376b;
    private boolean c;
    private boolean d;
    int e;
    int f;
    final Rect g;
    final Rect h;
    private final g i;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f376b = new d();
        } else if (i >= 17) {
            f376b = new c();
        } else {
            f376b = new f();
        }
        f376b.a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f376b.c(this.i);
    }

    public float getCardElevation() {
        return f376b.f(this.i);
    }

    public int getContentPaddingBottom() {
        return this.g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.g.left;
    }

    public int getContentPaddingRight() {
        return this.g.right;
    }

    public int getContentPaddingTop() {
        return this.g.top;
    }

    public float getMaxCardElevation() {
        return f376b.b(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.d;
    }

    public float getRadius() {
        return f376b.a(this.i);
    }

    public boolean getUseCompatPadding() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(f376b instanceof d)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f376b.i(this.i)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f376b.d(this.i)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f376b.a(this.i, ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f) {
        f376b.b(this.i, f);
    }

    public void setMaxCardElevation(float f) {
        f376b.c(this.i, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.e = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.d) {
            this.d = z;
            f376b.e(this.i);
        }
    }

    public void setRadius(float f) {
        f376b.a(this.i, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.c != z) {
            this.c = z;
            f376b.g(this.i);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f376b.a(this.i, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        ColorStateList valueOf;
        this.g = new Rect();
        this.h = new Rect();
        this.i = new a(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R$styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f375a);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R$color.cardview_light_background);
            } else {
                color = getResources().getColor(R$color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.c = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.d = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        this.g.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.g.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.g.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.g.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f376b.a(this.i, context, colorStateList, dimension, dimension2, f);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.g.set(i, i2, i3, i4);
        f376b.h(this.i);
    }
}
