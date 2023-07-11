package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.D;
import androidx.core.h.j;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@CoordinatorLayout.b(Behavior.class)
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f1246a;

    /* renamed from: b  reason: collision with root package name */
    private int f1247b;
    private int c;
    private boolean d;
    private int e;
    private D f;
    private List<a> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int[] l;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private int k;
        private int l;
        private ValueAnimator m;
        private int n;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private a r;

        /* loaded from: classes.dex */
        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
            this.n = -1;
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int b(View view) {
            return b((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int c(View view) {
            return c((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable d(CoordinatorLayout coordinatorLayout, View view) {
            return b(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ void e(CoordinatorLayout coordinatorLayout, View view) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        private void d(CoordinatorLayout coordinatorLayout, T t) {
            int c = c();
            int b2 = b((BaseBehavior<T>) t, c);
            if (b2 >= 0) {
                View childAt = t.getChildAt(b2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a2 = layoutParams.a();
                if ((a2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (b2 == t.getChildCount() - 1) {
                        i2 += t.getTopInset();
                    }
                    if (a(a2, 2)) {
                        i2 += t.l(childAt);
                    } else if (a(a2, 5)) {
                        int l = t.l(childAt) + i2;
                        if (c < l) {
                            i = l;
                        } else {
                            i2 = l;
                        }
                    }
                    if (a(a2, 32)) {
                        i += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i2 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (c < (i2 + i) / 2) {
                        i = i2;
                    }
                    a(coordinatorLayout, (CoordinatorLayout) t, androidx.core.c.a.a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ boolean a(View view) {
            return a((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, view3, i, i2);
        }

        int c(T t) {
            return t.getTotalScrollRange();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        private int c(T t, int i) {
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b2 = layoutParams.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b2 != null) {
                    int a2 = layoutParams.a();
                    if ((a2 & 1) != 0) {
                        i2 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i2 -= t.l(childAt);
                        }
                    }
                    if (t.h(childAt)) {
                        i2 -= t.getTopInset();
                    }
                    if (i2 > 0) {
                        float f = i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * b2.getInterpolation((abs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int b(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new c();
            int c;
            float d;
            boolean e;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.c = parcel.readInt();
                this.d = parcel.readFloat();
                this.e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.c);
                parcel.writeFloat(this.d);
                parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        private int b(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (a(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i, i2, i3, i4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i, i2, iArr, i3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i, i2, i3, i4, i5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), parcelable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.c() || a(coordinatorLayout, (CoordinatorLayout) t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i2;
            return z;
        }

        int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable d = super.d(coordinatorLayout, (CoordinatorLayout) t);
            int b2 = b();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(d);
                    savedState.c = i;
                    savedState.e = bottom == t.l(childAt) + t.getTopInset();
                    savedState.d = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return d;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.b() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -t.getTotalScrollRange();
                    i4 = i6;
                    i5 = t.getDownNestedPreScrollRange() + i6;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = a(coordinatorLayout, (CoordinatorLayout) t, i2, i4, i5);
                    a(i2, (int) t, view, i3);
                }
            }
        }

        private boolean c(CoordinatorLayout coordinatorLayout, T t) {
            List<View> c = coordinatorLayout.c(t);
            int size = c.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior d = ((CoordinatorLayout.d) c.get(i).getLayoutParams()).d();
                if (d instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) d).c() != 0;
                }
            }
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                a(coordinatorLayout, (CoordinatorLayout) t, i4, -t.getDownNestedScrollRange(), 0);
                a(i4, (int) t, view, i5);
            }
            if (t.c()) {
                t.a(view.getScrollY() > 0);
            }
        }

        private void a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int c = c();
                if ((i >= 0 || c != 0) && (i <= 0 || c != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                t.f(view, 1);
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int c() {
            return b() + this.k;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.l == 0 || i == 1) {
                d(coordinatorLayout, (CoordinatorLayout) t);
            }
            this.q = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            int abs = Math.abs(c() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (CoordinatorLayout) t, i, height);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int c = c();
            if (c == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                this.m = new ValueAnimator();
                this.m.setInterpolator(com.google.android.material.a.a.e);
                this.m.addUpdateListener(new com.google.android.material.appbar.b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i2, 600));
            this.m.setIntValues(c, i);
            this.m.start();
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.d) t.getLayoutParams())).height == -2) {
                coordinatorLayout.a(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.a(coordinatorLayout, (CoordinatorLayout) t, i, i2, i3, i4);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int round;
            boolean a2 = super.a(coordinatorLayout, (CoordinatorLayout) t, i);
            int pendingAction = t.getPendingAction();
            int i2 = this.n;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i2);
                int i3 = -childAt.getBottom();
                if (this.o) {
                    round = t.l(childAt) + t.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.p);
                }
                c(coordinatorLayout, (CoordinatorLayout) t, i3 + round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, i4, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) t, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, 0, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) t, 0);
                    }
                }
            }
            t.d();
            this.n = -1;
            a(androidx.core.c.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (CoordinatorLayout) t, b(), 0, true);
            t.a(b());
            return a2;
        }

        boolean a(T t) {
            a aVar = this.r;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference != null) {
                View view = weakReference.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        void a(CoordinatorLayout coordinatorLayout, T t) {
            d(coordinatorLayout, (CoordinatorLayout) t);
        }

        int a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int c = c();
            int i4 = 0;
            if (i2 != 0 && c >= i2 && c <= i3) {
                int a2 = androidx.core.c.a.a(i, i2, i3);
                if (c != a2) {
                    int c2 = t.a() ? c((BaseBehavior<T>) t, a2) : a2;
                    boolean a3 = a(c2);
                    i4 = c - a2;
                    this.k = a2 - c2;
                    if (!a3 && t.a()) {
                        coordinatorLayout.a(t);
                    }
                    t.a(b());
                    a(coordinatorLayout, (CoordinatorLayout) t, a2, a2 < c ? -1 : 1, false);
                }
            } else {
                this.k = 0;
            }
            return i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = a(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r1 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = androidx.core.h.t.l(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = 1
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = 0
            L42:
                boolean r9 = r7.c()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.a(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L56
                r8 = 1
                goto L57
            L56:
                r8 = 0
            L57:
                boolean r8 = r7.a(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.c(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        private static View a(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof j) {
                    return childAt;
                }
            }
            return null;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, (CoordinatorLayout) t, savedState.a());
                this.n = savedState.c;
                this.p = savedState.d;
                this.o = savedState.e;
                return;
            }
            super.a(coordinatorLayout, (CoordinatorLayout) t, parcelable);
            this.n = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.b(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* bridge */ /* synthetic */ View a(List list) {
            return a((List<View>) list);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public int c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, (CoordinatorLayout) view, i);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float b(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (a2 / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a(coordinatorLayout.b(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.c()) {
                    appBarLayout.a(view.getScrollY() > 0);
                }
            }
        }

        private void a(View view, View view2) {
            CoordinatorLayout.Behavior d = ((CoordinatorLayout.d) view2.getLayoutParams()).d();
            if (d instanceof BaseBehavior) {
                t.b(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) d).k) + d()) - a(view2));
            }
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior d = ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).d();
            if (d instanceof BaseBehavior) {
                return ((BaseBehavior) d).c();
            }
            return 0;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    /* loaded from: classes.dex */
    public interface b extends a<AppBarLayout> {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private boolean e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void f() {
        this.f1246a = -1;
        this.f1247b = -1;
        this.c = -1;
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    public void addOnOffsetChangedListener(a aVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (aVar == null || this.g.contains(aVar)) {
            return;
        }
        this.g.add(aVar);
    }

    boolean b() {
        return getTotalScrollRange() != 0;
    }

    public boolean c() {
        return this.k;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void d() {
        this.e = 0;
    }

    int getDownNestedPreScrollRange() {
        int topInset;
        int i = this.f1247b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f1248a;
            if ((i3 & 5) == 5) {
                int i4 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i3 & 8) != 0) {
                    i2 = i4 + t.l(childAt);
                } else {
                    if ((i3 & 2) != 0) {
                        topInset = t.l(childAt);
                    } else {
                        topInset = getTopInset();
                    }
                    i2 = i4 + (measuredHeight - topInset);
                }
            } else if (i2 > 0) {
                break;
            }
        }
        int max = Math.max(0, i2);
        this.f1247b = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i4 = layoutParams.f1248a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= t.l(childAt) + getTopInset();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.c = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int l = t.l(this);
        if (l == 0) {
            int childCount = getChildCount();
            l = childCount >= 1 ? t.l(getChildAt(childCount - 1)) : 0;
            if (l == 0) {
                return getHeight() / 3;
            }
        }
        return (l * 2) + topInset;
    }

    int getPendingAction() {
        return this.e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        D d = this.f;
        if (d != null) {
            return d.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f1246a;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.f1248a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if ((i4 & 2) != 0) {
                i3 -= t.l(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3 - getTopInset());
        this.f1246a = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.l == null) {
            this.l = new int[4];
        }
        int[] iArr = this.l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.i ? R$attr.state_liftable : -R$attr.state_liftable;
        iArr[1] = (this.i && this.j) ? R$attr.state_lifted : -R$attr.state_lifted;
        iArr[2] = this.i ? R$attr.state_collapsible : -R$attr.state_collapsible;
        iArr[3] = (this.i && this.j) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        f();
        boolean z2 = false;
        this.d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (((LayoutParams) getChildAt(i5).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            } else {
                i5++;
            }
        }
        if (this.h) {
            return;
        }
        b((this.k || e()) ? true : true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    public void removeOnOffsetChangedListener(a aVar) {
        List<a> list = this.g;
        if (list == null || aVar == null) {
            return;
        }
        list.remove(aVar);
    }

    public void setExpanded(boolean z) {
        a(z, t.z(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            g.a(this, f);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1246a = -1;
        this.f1247b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            g.a(this);
            g.a(this, attributeSet, 0, R$style.Widget_Design_AppBarLayout);
        }
        TypedArray a2 = s.a(context, attributeSet, R$styleable.AppBarLayout, 0, R$style.Widget_Design_AppBarLayout, new int[0]);
        t.a(this, a2.getDrawable(R$styleable.AppBarLayout_android_background));
        if (a2.hasValue(R$styleable.AppBarLayout_expanded)) {
            a(a2.getBoolean(R$styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(R$styleable.AppBarLayout_elevation)) {
            g.a(this, a2.getDimensionPixelSize(R$styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(R$styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(R$styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(R$styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(R$styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = a2.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        a2.recycle();
        t.a(this, new com.google.android.material.appbar.a(this));
    }

    private void a(boolean z, boolean z2, boolean z3) {
        this.e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    private boolean b(boolean z) {
        if (this.i != z) {
            this.i = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void removeOnOffsetChangedListener(b bVar) {
        removeOnOffsetChangedListener((a) bVar);
    }

    boolean a() {
        return this.d;
    }

    void a(int i) {
        List<a> list = this.g;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.g.get(i2);
                if (aVar != null) {
                    aVar.a(this, i);
                }
            }
        }
    }

    public void addOnOffsetChangedListener(b bVar) {
        addOnOffsetChangedListener((a) bVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f1248a;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f1249b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1248a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.f1248a = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f1249b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f1248a;
        }

        public Interpolator b() {
            return this.f1249b;
        }

        boolean c() {
            int i = this.f1248a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1248a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1248a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1248a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1248a = 1;
        }
    }

    boolean a(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D a(D d) {
        D d2 = t.h(this) ? d : null;
        if (!androidx.core.g.c.a(this.f, d2)) {
            this.f = d2;
            f();
        }
        return d;
    }
}
