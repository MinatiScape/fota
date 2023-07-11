package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.qa;
import androidx.core.h.p;
import androidx.core.h.t;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
@ViewPager.a
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.core.g.e<f> f1408a = new androidx.core.g.g(16);
    int A;
    boolean B;
    boolean C;
    boolean D;
    private b E;
    private final ArrayList<b> F;
    private b G;
    private ValueAnimator H;
    ViewPager I;
    private androidx.viewpager.widget.a J;
    private DataSetObserver K;
    private g L;
    private a M;
    private boolean N;
    private final androidx.core.g.e<h> O;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<f> f1409b;
    private f c;
    private final RectF d;
    private final e e;
    int f;
    int g;
    int h;
    int i;
    int j;
    ColorStateList k;
    ColorStateList l;
    ColorStateList m;
    Drawable n;
    PorterDuff.Mode o;
    float p;
    float q;
    final int r;
    int s;
    private final int t;
    private final int u;
    private final int v;
    private int w;
    int x;
    int y;
    int z;

    /* loaded from: classes.dex */
    public interface b<T extends f> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    /* loaded from: classes.dex */
    public interface c extends b<f> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.c();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.c();
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private Object f1415a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f1416b;
        private CharSequence c;
        private CharSequence d;
        private int e = -1;
        private View f;
        public TabLayout g;
        public h h;

        public int c() {
            return this.e;
        }

        public CharSequence d() {
            return this.c;
        }

        public boolean e() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void f() {
            this.g = null;
            this.h = null;
            this.f1415a = null;
            this.f1416b = null;
            this.c = null;
            this.d = null;
            this.e = -1;
            this.f = null;
        }

        public void g() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                tabLayout.c(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void h() {
            h hVar = this.h;
            if (hVar != null) {
                hVar.b();
            }
        }

        public View a() {
            return this.f;
        }

        public Drawable b() {
            return this.f1416b;
        }

        public f a(View view) {
            this.f = view;
            h();
            return this;
        }

        void b(int i) {
            this.e = i;
        }

        public f b(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.h.setContentDescription(charSequence);
            }
            this.c = charSequence;
            h();
            return this;
        }

        public f a(int i) {
            a(LayoutInflater.from(this.h.getContext()).inflate(i, (ViewGroup) this.h, false));
            return this;
        }

        public f a(Drawable drawable) {
            this.f1416b = drawable;
            h();
            return this;
        }

        public f a(CharSequence charSequence) {
            this.d = charSequence;
            h();
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class g implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f1417a;

        /* renamed from: b  reason: collision with root package name */
        private int f1418b;
        private int c;

        public g(TabLayout tabLayout) {
            this.f1417a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.c = 0;
            this.f1418b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int i) {
            this.f1418b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = this.f1417a.get();
            if (tabLayout != null) {
                boolean z = false;
                tabLayout.a(i, f, this.c != 2 || this.f1418b == 1, (this.c == 2 && this.f1418b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.f1417a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.b(tabLayout.b(i), i2 == 0 || (i2 == 2 && this.f1418b == 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private f f1419a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f1420b;
        private ImageView c;
        private View d;
        private TextView e;
        private ImageView f;
        private Drawable g;
        private int h;

        public h(Context context) {
            super(context);
            this.h = 2;
            a(context);
            t.b(this, TabLayout.this.f, TabLayout.this.g, TabLayout.this.h, TabLayout.this.i);
            setGravity(17);
            setOrientation(!TabLayout.this.B ? 1 : 0);
            setClickable(true);
            t.a(this, p.a(getContext(), 1002));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d() {
            View[] viewArr;
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (View view : new View[]{this.f1420b, this.c, this.d}) {
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(Canvas canvas) {
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.g.draw(canvas);
            }
        }

        final void b() {
            f fVar = this.f1419a;
            Drawable drawable = null;
            View a2 = fVar != null ? fVar.a() : null;
            if (a2 != null) {
                ViewParent parent = a2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a2);
                    }
                    addView(a2);
                }
                this.d = a2;
                TextView textView = this.f1420b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.c.setImageDrawable(null);
                }
                this.e = (TextView) a2.findViewById(16908308);
                TextView textView2 = this.e;
                if (textView2 != null) {
                    this.h = l.d(textView2);
                }
                this.f = (ImageView) a2.findViewById(16908294);
            } else {
                View view = this.d;
                if (view != null) {
                    removeView(view);
                    this.d = null;
                }
                this.e = null;
                this.f = null;
            }
            boolean z = false;
            if (this.d == null) {
                if (this.c == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.c = imageView2;
                }
                if (fVar != null && fVar.b() != null) {
                    drawable = androidx.core.graphics.drawable.a.i(fVar.b()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.l);
                    PorterDuff.Mode mode = TabLayout.this.o;
                    if (mode != null) {
                        androidx.core.graphics.drawable.a.a(drawable, mode);
                    }
                }
                if (this.f1420b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.f1420b = textView3;
                    this.h = l.d(this.f1420b);
                }
                l.d(this.f1420b, TabLayout.this.j);
                ColorStateList colorStateList = TabLayout.this.k;
                if (colorStateList != null) {
                    this.f1420b.setTextColor(colorStateList);
                }
                a(this.f1420b, this.c);
            } else if (this.e != null || this.f != null) {
                a(this.e, this.f);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.d)) {
                setContentDescription(fVar.d);
            }
            if (fVar != null && fVar.e()) {
                z = true;
            }
            setSelected(z);
        }

        final void c() {
            setOrientation(!TabLayout.this.B ? 1 : 0);
            if (this.e == null && this.f == null) {
                a(this.f1420b, this.c);
            } else {
                a(this.e, this.f);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.g;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.g.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.b.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.s, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f1420b != null) {
                float f = TabLayout.this.p;
                int i3 = this.h;
                ImageView imageView = this.c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f1420b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.q;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.f1420b.getTextSize();
                int lineCount = this.f1420b.getLineCount();
                int d = l.d(this.f1420b);
                if (f != textSize || (d >= 0 && i3 != d)) {
                    if (TabLayout.this.A == 1 && f > textSize && lineCount == 1 && ((layout = this.f1420b.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f1420b.setTextSize(0, f);
                        this.f1420b.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f1419a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f1419a.g();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f1420b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.d;
            if (view != null) {
                view.setSelected(z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void a(Context context) {
            int i = TabLayout.this.r;
            if (i != 0) {
                this.g = androidx.appcompat.a.a.a.b(context, i);
                Drawable drawable = this.g;
                if (drawable != null && drawable.isStateful()) {
                    this.g.setState(getDrawableState());
                }
            } else {
                this.g = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.m != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a2 = com.google.android.material.g.a.a(TabLayout.this.m);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (TabLayout.this.D) {
                        gradientDrawable = null;
                    }
                    gradientDrawable = new RippleDrawable(a2, gradientDrawable, TabLayout.this.D ? null : gradientDrawable2);
                } else {
                    Drawable i2 = androidx.core.graphics.drawable.a.i(gradientDrawable2);
                    androidx.core.graphics.drawable.a.a(i2, a2);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, i2});
                }
            }
            t.a(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        void a(f fVar) {
            if (fVar != this.f1419a) {
                this.f1419a = fVar;
                b();
            }
        }

        void a() {
            a((f) null);
            setSelected(false);
        }

        private void a(TextView textView, ImageView imageView) {
            f fVar = this.f1419a;
            Drawable mutate = (fVar == null || fVar.b() == null) ? null : androidx.core.graphics.drawable.a.i(this.f1419a.b()).mutate();
            f fVar2 = this.f1419a;
            CharSequence d = fVar2 != null ? fVar2.d() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d);
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int a2 = (z && imageView.getVisibility() == 0) ? TabLayout.this.a(8) : 0;
                if (TabLayout.this.B) {
                    if (a2 != androidx.core.h.f.a(marginLayoutParams)) {
                        androidx.core.h.f.a(marginLayoutParams, a2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (a2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a2;
                    androidx.core.h.f.a(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.f1419a;
            CharSequence charSequence = fVar3 != null ? fVar3.d : null;
            if (z) {
                charSequence = null;
            }
            qa.a(this, charSequence);
        }

        private float a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* loaded from: classes.dex */
    public static class i implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f1421a;

        public i(ViewPager viewPager) {
            this.f1421a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void a(f fVar) {
            this.f1421a.setCurrentItem(fVar.c());
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void b(f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void c(f fVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private h e(f fVar) {
        androidx.core.g.e<h> eVar = this.O;
        h acquire = eVar != null ? eVar.acquire() : null;
        if (acquire == null) {
            acquire = new h(getContext());
        }
        acquire.a(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.d)) {
            acquire.setContentDescription(fVar.c);
        } else {
            acquire.setContentDescription(fVar.d);
        }
        return acquire;
    }

    private LinearLayout.LayoutParams f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void g() {
        if (this.H == null) {
            this.H = new ValueAnimator();
            this.H.setInterpolator(com.google.android.material.a.a.f1233b);
            this.H.setDuration(this.y);
            this.H.addUpdateListener(new com.google.android.material.tabs.a(this));
        }
    }

    private int getDefaultHeight() {
        int size = this.f1409b.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.f1409b.get(i2);
                if (fVar != null && fVar.b() != null && !TextUtils.isEmpty(fVar.d())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.B) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        if (this.A == 0) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h() {
        int size = this.f1409b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1409b.get(i2).h();
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.e.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.e.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    public void addOnTabSelectedListener(b bVar) {
        if (this.F.contains(bVar)) {
            return;
        }
        this.F.add(bVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    public f b() {
        f a2 = a();
        a2.g = this;
        a2.h = e(a2);
        return a2;
    }

    void c() {
        int currentItem;
        d();
        androidx.viewpager.widget.a aVar = this.J;
        if (aVar != null) {
            int a2 = aVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                f b2 = b();
                b2.b(this.J.a(i2));
                a(b2, false);
            }
            ViewPager viewPager = this.I;
            if (viewPager == null || a2 <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            c(b(currentItem));
        }
    }

    public void d() {
        for (int childCount = this.e.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<f> it = this.f1409b.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.f();
            b(next);
        }
        this.c = null;
    }

    public int getSelectedTabPosition() {
        f fVar = this.c;
        if (fVar != null) {
            return fVar.c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f1409b.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.l;
    }

    public int getTabIndicatorGravity() {
        return this.z;
    }

    int getTabMaxWidth() {
        return this.s;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.m;
    }

    public Drawable getTabSelectedIndicator() {
        return this.n;
    }

    public ColorStateList getTabTextColors() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.I == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager(null);
            this.N = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
            View childAt = this.e.getChildAt(i2);
            if (childAt instanceof h) {
                ((h) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int a2 = a(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(a2, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(a2, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.u;
            if (i4 <= 0) {
                i4 = size - a(56);
            }
            this.s = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            boolean z = false;
            View childAt = getChildAt(0);
            int i5 = this.A;
            if (i5 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i5 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z = true;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void removeOnTabSelectedListener(b bVar) {
        this.F.remove(bVar);
    }

    public void setInlineLabel(boolean z) {
        if (this.B != z) {
            this.B = z;
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                View childAt = this.e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).c();
                }
            }
            e();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.E;
        if (bVar2 != null) {
            removeOnTabSelectedListener(bVar2);
        }
        this.E = bVar;
        if (bVar != null) {
            addOnTabSelectedListener(bVar);
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.H.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.n != drawable) {
            this.n = drawable;
            t.C(this.e);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.e.a(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            t.C(this.e);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.e.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            e();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            h();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.C = z;
        t.C(this.e);
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            e();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                View childAt = this.e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            h();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        a(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.D != z) {
            this.D = z;
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                View childAt = this.e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements ViewPager.d {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1410a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.I == viewPager) {
                tabLayout.a(aVar2, this.f1410a);
            }
        }

        void a(boolean z) {
            this.f1410a = z;
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    public void a(int i2, float f2, boolean z) {
        a(i2, f2, z, true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private int f1413a;

        /* renamed from: b  reason: collision with root package name */
        private final Paint f1414b;
        private final GradientDrawable c;
        int d;
        float e;
        private int f;
        private int g;
        private int h;
        private ValueAnimator i;

        e(Context context) {
            super(context);
            this.d = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            setWillNotDraw(false);
            this.f1414b = new Paint();
            this.c = new GradientDrawable();
        }

        void a(int i) {
            if (this.f1414b.getColor() != i) {
                this.f1414b.setColor(i);
                t.C(this);
            }
        }

        void b(int i) {
            if (this.f1413a != i) {
                this.f1413a = i;
                t.C(this);
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            Drawable drawable = TabLayout.this.n;
            int i = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i2 = this.f1413a;
            if (i2 >= 0) {
                intrinsicHeight = i2;
            }
            int i3 = TabLayout.this.z;
            if (i3 == 0) {
                i = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i3 == 1) {
                i = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i3 != 2) {
                intrinsicHeight = i3 != 3 ? 0 : getHeight();
            }
            int i4 = this.g;
            if (i4 >= 0 && this.h > i4) {
                Drawable drawable2 = TabLayout.this.n;
                if (drawable2 == null) {
                    drawable2 = this.c;
                }
                Drawable i5 = androidx.core.graphics.drawable.a.i(drawable2);
                i5.setBounds(this.g, i, this.h, intrinsicHeight);
                Paint paint = this.f1414b;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        i5.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.b(i5, paint.getColor());
                    }
                }
                i5.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
                a(this.d, Math.round((1.0f - this.i.getAnimatedFraction()) * ((float) this.i.getDuration())));
                return;
            }
            b();
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.A == 1 && tabLayout.x == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = Math.max(i3, childAt.getMeasuredWidth());
                    }
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (TabLayout.this.a(16) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.x = 0;
                    tabLayout2.a(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.f == i) {
                return;
            }
            requestLayout();
            this.f = i;
        }

        private void b() {
            int i;
            int i2;
            View childAt = getChildAt(this.d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.C && (childAt instanceof h)) {
                    a((h) childAt, tabLayout.d);
                    i = (int) TabLayout.this.d.left;
                    i2 = (int) TabLayout.this.d.right;
                }
                if (this.e > 0.0f && this.d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.d + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.C && (childAt2 instanceof h)) {
                        a((h) childAt2, tabLayout2.d);
                        left = (int) TabLayout.this.d.left;
                        right = (int) TabLayout.this.d.right;
                    }
                    float f = this.e;
                    i = (int) ((left * f) + ((1.0f - f) * i));
                    i2 = (int) ((right * f) + ((1.0f - f) * i2));
                }
            }
            b(i, i2);
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void a(int i, float f) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            this.d = i;
            this.e = f;
            b();
        }

        void a(int i, int i2) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.C && (childAt instanceof h)) {
                a((h) childAt, tabLayout.d);
                left = (int) TabLayout.this.d.left;
                right = (int) TabLayout.this.d.right;
            }
            int i3 = left;
            int i4 = right;
            int i5 = this.g;
            int i6 = this.h;
            if (i5 == i3 && i6 == i4) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.i = valueAnimator2;
            valueAnimator2.setInterpolator(com.google.android.material.a.a.f1233b);
            valueAnimator2.setDuration(i2);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new com.google.android.material.tabs.b(this, i5, i3, i6, i4));
            valueAnimator2.addListener(new com.google.android.material.tabs.c(this, i));
            valueAnimator2.start();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(int i, int i2) {
            if (i == this.g && i2 == this.h) {
                return;
            }
            this.g = i;
            this.h = i2;
            t.C(this);
        }

        private void a(h hVar, RectF rectF) {
            int d = hVar.d();
            if (d < TabLayout.this.a(24)) {
                d = TabLayout.this.a(24);
            }
            int left = (hVar.getLeft() + hVar.getRight()) / 2;
            int i = d / 2;
            rectF.set(left - i, 0.0f, left + i, 0.0f);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1409b = new ArrayList<>();
        this.d = new RectF();
        this.s = Integer.MAX_VALUE;
        this.F = new ArrayList<>();
        this.O = new androidx.core.g.f(12);
        setHorizontalScrollBarEnabled(false);
        this.e = new e(context);
        super.addView(this.e, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a2 = s.a(context, attributeSet, R$styleable.TabLayout, i2, R$style.Widget_Design_TabLayout, R$styleable.TabLayout_tabTextAppearance);
        this.e.b(a2.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        this.e.a(a2.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.f.a.b(context, a2, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(a2.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(a2.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.f = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, this.f);
        this.g = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.g);
        this.h = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.h);
        this.i = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.i);
        this.j = a2.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.j, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.p = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, 0);
            this.k = com.google.android.material.f.a.a(context, obtainStyledAttributes, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (a2.hasValue(R$styleable.TabLayout_tabTextColor)) {
                this.k = com.google.android.material.f.a.a(context, a2, R$styleable.TabLayout_tabTextColor);
            }
            if (a2.hasValue(R$styleable.TabLayout_tabSelectedTextColor)) {
                this.k = a(this.k.getDefaultColor(), a2.getColor(R$styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.l = com.google.android.material.f.a.a(context, a2, R$styleable.TabLayout_tabIconTint);
            this.o = com.google.android.material.internal.t.a(a2.getInt(R$styleable.TabLayout_tabIconTintMode, -1), null);
            this.m = com.google.android.material.f.a.a(context, a2, R$styleable.TabLayout_tabRippleColor);
            this.y = a2.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.t = a2.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.u = a2.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.r = a2.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.w = a2.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.A = a2.getInt(R$styleable.TabLayout_tabMode, 1);
            this.x = a2.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.B = a2.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.D = a2.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            a2.recycle();
            Resources resources = getResources();
            this.q = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.v = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            e();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void f(f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).c(fVar);
        }
    }

    private void h(f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).b(fVar);
        }
    }

    void a(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.e.getChildCount()) {
            return;
        }
        if (z2) {
            this.e.a(i2, f2);
        }
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.H.cancel();
        }
        scrollTo(a(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    protected boolean b(f fVar) {
        return f1408a.release(fVar);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public f b(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f1409b.get(i2);
    }

    private void g(f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).a(fVar);
        }
    }

    void b(f fVar, boolean z) {
        f fVar2 = this.c;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                f(fVar);
                c(fVar.c());
                return;
            }
            return;
        }
        int c2 = fVar != null ? fVar.c() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.c() == -1) && c2 != -1) {
                a(c2, 0.0f, true);
            } else {
                c(c2);
            }
            if (c2 != -1) {
                setSelectedTabView(c2);
            }
        }
        this.c = fVar;
        if (fVar2 != null) {
            h(fVar2);
        }
        if (fVar != null) {
            g(fVar);
        }
    }

    private void c(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && t.z(this) && !this.e.a()) {
            int scrollX = getScrollX();
            int a2 = a(i2, 0.0f);
            if (scrollX != a2) {
                g();
                this.H.setIntValues(scrollX, a2);
                this.H.start();
            }
            this.e.a(i2, this.y);
            return;
        }
        a(i2, 0.0f, true);
    }

    private void d(f fVar) {
        this.e.addView(fVar.h, fVar.c(), f());
    }

    private void e() {
        t.b(this.e, this.A == 0 ? Math.max(0, this.w - this.f) : 0, 0, 0, 0);
        int i2 = this.A;
        if (i2 == 0) {
            this.e.setGravity(8388611);
        } else if (i2 == 1) {
            this.e.setGravity(1);
        }
        a(true);
    }

    public void a(f fVar) {
        a(fVar, this.f1409b.isEmpty());
    }

    private void d(int i2) {
        h hVar = (h) this.e.getChildAt(i2);
        this.e.removeViewAt(i2);
        if (hVar != null) {
            hVar.a();
            this.O.release(hVar);
        }
        requestLayout();
    }

    public void a(f fVar, boolean z) {
        a(fVar, this.f1409b.size(), z);
    }

    public void a(f fVar, int i2, boolean z) {
        if (fVar.g == this) {
            a(fVar, i2);
            d(fVar);
            if (z) {
                fVar.g();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void a(TabItem tabItem) {
        f b2 = b();
        CharSequence charSequence = tabItem.f1406a;
        if (charSequence != null) {
            b2.b(charSequence);
        }
        Drawable drawable = tabItem.f1407b;
        if (drawable != null) {
            b2.a(drawable);
        }
        int i2 = tabItem.c;
        if (i2 != 0) {
            b2.a(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            b2.a(tabItem.getContentDescription());
        }
        a(b2);
    }

    void c(f fVar) {
        b(fVar, true);
    }

    protected f a() {
        f acquire = f1408a.acquire();
        return acquire == null ? new f() : acquire;
    }

    public void a(ViewPager viewPager, boolean z) {
        a(viewPager, z, false);
    }

    private void a(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.I;
        if (viewPager2 != null) {
            g gVar = this.L;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            a aVar = this.M;
            if (aVar != null) {
                this.I.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.G;
        if (bVar != null) {
            removeOnTabSelectedListener(bVar);
            this.G = null;
        }
        if (viewPager != null) {
            this.I = viewPager;
            if (this.L == null) {
                this.L = new g(this);
            }
            this.L.a();
            viewPager.addOnPageChangeListener(this.L);
            this.G = new i(viewPager);
            addOnTabSelectedListener(this.G);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.M == null) {
                this.M = new a();
            }
            this.M.a(z);
            viewPager.addOnAdapterChangeListener(this.M);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.I = null;
            a((androidx.viewpager.widget.a) null, false);
        }
        this.N = z2;
    }

    void a(androidx.viewpager.widget.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.J;
        if (aVar2 != null && (dataSetObserver = this.K) != null) {
            aVar2.c(dataSetObserver);
        }
        this.J = aVar;
        if (z && aVar != null) {
            if (this.K == null) {
                this.K = new d();
            }
            aVar.a(this.K);
        }
        c();
    }

    private void a(f fVar, int i2) {
        fVar.b(i2);
        this.f1409b.add(i2, fVar);
        int size = this.f1409b.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.f1409b.get(i2).b(i2);
        }
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.A == 1 && this.x == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    int a(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    private int a(int i2, float f2) {
        if (this.A == 0) {
            View childAt = this.e.getChildAt(i2);
            int i3 = i2 + 1;
            View childAt2 = i3 < this.e.getChildCount() ? this.e.getChildAt(i3) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i4 = (int) ((width + width2) * 0.5f * f2);
            return t.k(this) == 0 ? left + i4 : left - i4;
        }
        return 0;
    }

    void a(boolean z) {
        for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
            View childAt = this.e.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }
}
