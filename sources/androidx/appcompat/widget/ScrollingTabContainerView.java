package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f280a = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    Runnable f281b;
    private b c;
    LinearLayoutCompat d;
    private Spinner e;
    private boolean f;
    int g;
    int h;
    private int i;
    private int j;
    protected ViewPropertyAnimator k;
    protected final d l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.d.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) ScrollingTabContainerView.this.d.getChildAt(i)).a();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.a((ActionBar.b) getItem(i), true);
            }
            ((c) view).a((ActionBar.b) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).a().e();
            int childCount = ScrollingTabContainerView.this.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.d.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* loaded from: classes.dex */
    protected class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f286a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f287b;

        protected d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f286a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f286a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.k = null;
            scrollingTabContainerView.setVisibility(this.f287b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f286a = false;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.l = new d();
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.d.a a2 = androidx.appcompat.d.a.a(context);
        setContentHeight(a2.e());
        this.h = a2.d();
        this.d = b();
        addView(this.d, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean c() {
        Spinner spinner = this.e;
        return spinner != null && spinner.getParent() == this;
    }

    private void d() {
        if (c()) {
            return;
        }
        if (this.e == null) {
            this.e = a();
        }
        removeView(this.d);
        addView(this.e, new ViewGroup.LayoutParams(-2, -1));
        if (this.e.getAdapter() == null) {
            this.e.setAdapter((SpinnerAdapter) new a());
        }
        Runnable runnable = this.f281b;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f281b = null;
        }
        this.e.setSelection(this.j);
    }

    private boolean e() {
        if (c()) {
            removeView(this.e);
            addView(this.d, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.e.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f281b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.d.a a2 = androidx.appcompat.d.a.a(getContext());
        setContentHeight(a2.e());
        this.h = a2.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f281b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((c) view).a().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.d.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.g = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.g = View.MeasureSpec.getSize(i) / 2;
            }
            this.g = Math.min(this.g, this.h);
        } else {
            this.g = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        if ((z2 || !this.f) ? false : false) {
            this.d.measure(0, makeMeasureSpec);
            if (this.d.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                d();
            } else {
                e();
            }
        } else {
            e();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f = z;
    }

    public void setContentHeight(int i) {
        this.i = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.j = i;
        int childCount = this.d.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.d.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.e;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f284a;

        /* renamed from: b  reason: collision with root package name */
        private ActionBar.b f285b;
        private TextView c;
        private ImageView d;
        private View e;

        public c(Context context, ActionBar.b bVar, boolean z) {
            super(context, null, R$attr.actionBarTabStyle);
            this.f284a = new int[]{16842964};
            this.f285b = bVar;
            ia a2 = ia.a(context, null, this.f284a, R$attr.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.b(0));
            }
            a2.a();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public void a(ActionBar.b bVar) {
            this.f285b = bVar;
            b();
        }

        public void b() {
            ActionBar.b bVar = this.f285b;
            View b2 = bVar.b();
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.e = b2;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.e;
            if (view != null) {
                removeView(view);
                this.e = null;
            }
            Drawable c = bVar.c();
            CharSequence d = bVar.d();
            if (c != null) {
                if (this.d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.d = appCompatImageView;
                }
                this.d.setImageDrawable(c);
                this.d.setVisibility(0);
            } else {
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d);
            if (z) {
                if (this.c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.c = appCompatTextView;
                }
                this.c.setText(d);
                this.c.setVisibility(0);
            } else {
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.d;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.a());
            }
            qa.a(this, z ? null : bVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.b.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = ScrollingTabContainerView.this.g;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public ActionBar.b a() {
            return this.f285b;
        }
    }

    public void a(int i) {
        View childAt = this.d.getChildAt(i);
        Runnable runnable = this.f281b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f281b = new N(this, childAt);
        post(this.f281b);
    }

    c a(ActionBar.b bVar, boolean z) {
        c cVar = new c(getContext(), bVar, z);
        if (z) {
            cVar.setBackgroundDrawable(null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
        } else {
            cVar.setFocusable(true);
            if (this.c == null) {
                this.c = new b();
            }
            cVar.setOnClickListener(this.c);
        }
        return cVar;
    }
}
