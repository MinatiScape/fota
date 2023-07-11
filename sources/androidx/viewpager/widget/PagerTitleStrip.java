package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;
@ViewPager.a
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1026a = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1027b = {16843660};
    ViewPager c;
    TextView d;
    TextView e;
    TextView f;
    private int g;
    float h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private final a m;
    private WeakReference<androidx.viewpager.widget.a> n;
    private int o;
    int p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends DataSetObserver implements ViewPager.e, ViewPager.d {

        /* renamed from: a  reason: collision with root package name */
        private int f1028a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.a(pagerTitleStrip.c.getCurrentItem(), PagerTitleStrip.this.c.getAdapter());
            float f = PagerTitleStrip.this.h;
            if (f < 0.0f) {
                f = 0.0f;
            }
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.a(pagerTitleStrip2.c.getCurrentItem(), f, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int i) {
            this.f1028a = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.a(i, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int i) {
            if (this.f1028a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.a(pagerTitleStrip.c.getCurrentItem(), PagerTitleStrip.this.c.getAdapter());
                float f = PagerTitleStrip.this.h;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.a(pagerTitleStrip2.c.getCurrentItem(), f, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends SingleLineTransformationMethod {

        /* renamed from: a  reason: collision with root package name */
        private Locale f1030a;

        b(Context context) {
            this.f1030a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f1030a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i, float f) {
        this.d.setTextSize(i, f);
        this.e.setTextSize(i, f);
        this.f.setTextSize(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            viewPager.a(this.m);
            viewPager.addOnAdapterChangeListener(this.m);
            this.c = viewPager;
            WeakReference<androidx.viewpager.widget.a> weakReference = this.n;
            a(weakReference != null ? weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.c;
        if (viewPager != null) {
            a(viewPager.getAdapter(), (androidx.viewpager.widget.a) null);
            this.c.a((ViewPager.e) null);
            this.c.removeOnAdapterChangeListener(this.m);
            this.c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c != null) {
            float f = this.h;
            if (f < 0.0f) {
                f = 0.0f;
            }
            a(this.g, f, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int max;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (size * 0.2f), -2);
            this.d.measure(childMeasureSpec2, childMeasureSpec);
            this.e.measure(childMeasureSpec2, childMeasureSpec);
            this.f.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                max = View.MeasureSpec.getSize(i2);
            } else {
                max = Math.max(getMinHeight(), this.e.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i2, this.e.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.k) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i) {
        this.j = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        this.o = ((int) (f * 255.0f)) & 255;
        int i = (this.o << 24) | (this.p & 16777215);
        this.d.setTextColor(i);
        this.f.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.p = i;
        this.e.setTextColor(i);
        int i2 = (this.o << 24) | (this.p & 16777215);
        this.d.setTextColor(i2);
        this.f.setTextColor(i2);
    }

    public void setTextSpacing(int i) {
        this.i = i;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.h = -1.0f;
        this.m = new a();
        TextView textView = new TextView(context);
        this.d = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.e = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1026a);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            l.d(this.d, resourceId);
            l.d(this.e, resourceId);
            l.d(this.f, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.d.setTextColor(color);
            this.e.setTextColor(color);
            this.f.setTextColor(color);
        }
        this.j = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.p = this.e.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f1027b);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.d);
            setSingleLineAllCaps(this.e);
            setSingleLineAllCaps(this.f);
        } else {
            this.d.setSingleLine();
            this.e.setSingleLine();
            this.f.setSingleLine();
        }
        this.i = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    void a(int i, androidx.viewpager.widget.a aVar) {
        int a2 = aVar != null ? aVar.a() : 0;
        this.k = true;
        CharSequence charSequence = null;
        this.d.setText((i < 1 || aVar == null) ? null : aVar.a(i - 1));
        this.e.setText((aVar == null || i >= a2) ? null : aVar.a(i));
        int i2 = i + 1;
        if (i2 < a2 && aVar != null) {
            charSequence = aVar.a(i2);
        }
        this.f.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.e.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f.measure(makeMeasureSpec, makeMeasureSpec2);
        this.g = i;
        if (!this.l) {
            a(i, this.h, false);
        }
        this.k = false;
    }

    void a(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        if (aVar != null) {
            aVar.c(this.m);
            this.n = null;
        }
        if (aVar2 != null) {
            aVar2.a((DataSetObserver) this.m);
            this.n = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.c;
        if (viewPager != null) {
            this.g = -1;
            this.h = -1.0f;
            a(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (i != this.g) {
            a(i, this.c.getAdapter());
        } else if (!z && f == this.h) {
            return;
        }
        this.l = true;
        int measuredWidth = this.d.getMeasuredWidth();
        int measuredWidth2 = this.e.getMeasuredWidth();
        int measuredWidth3 = this.f.getMeasuredWidth();
        int i6 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = paddingRight + i6;
        int i8 = (width - (paddingLeft + i6)) - i7;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i9 = ((width - i7) - ((int) (i8 * f2))) - i6;
        int i10 = measuredWidth2 + i9;
        int baseline = this.d.getBaseline();
        int baseline2 = this.e.getBaseline();
        int baseline3 = this.f.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i11 = max - baseline;
        int i12 = max - baseline2;
        int i13 = max - baseline3;
        int max2 = Math.max(Math.max(this.d.getMeasuredHeight() + i11, this.e.getMeasuredHeight() + i12), this.f.getMeasuredHeight() + i13);
        int i14 = this.j & 112;
        if (i14 == 16) {
            i2 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i14 != 80) {
            i3 = i11 + paddingTop;
            i4 = i12 + paddingTop;
            i5 = paddingTop + i13;
            TextView textView = this.e;
            textView.layout(i9, i4, i10, textView.getMeasuredHeight() + i4);
            int min = Math.min(paddingLeft, (i9 - this.i) - measuredWidth);
            TextView textView2 = this.d;
            textView2.layout(min, i3, measuredWidth + min, textView2.getMeasuredHeight() + i3);
            int max3 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.i);
            TextView textView3 = this.f;
            textView3.layout(max3, i5, max3 + measuredWidth3, textView3.getMeasuredHeight() + i5);
            this.h = f;
            this.l = false;
        } else {
            i2 = (height - paddingBottom) - max2;
        }
        i3 = i11 + i2;
        i4 = i12 + i2;
        i5 = i2 + i13;
        TextView textView4 = this.e;
        textView4.layout(i9, i4, i10, textView4.getMeasuredHeight() + i4);
        int min2 = Math.min(paddingLeft, (i9 - this.i) - measuredWidth);
        TextView textView22 = this.d;
        textView22.layout(min2, i3, measuredWidth + min2, textView22.getMeasuredHeight() + i3);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.i);
        TextView textView32 = this.f;
        textView32.layout(max32, i5, max32 + measuredWidth3, textView32.getMeasuredHeight() + i5);
        this.h = f;
        this.l = false;
    }
}
