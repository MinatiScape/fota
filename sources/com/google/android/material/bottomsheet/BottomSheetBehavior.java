package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.customview.a.g;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1297a;

    /* renamed from: b  reason: collision with root package name */
    private float f1298b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    int g;
    int h;
    int i;
    boolean j;
    private boolean k;
    int l;
    g m;
    private boolean n;
    private int o;
    private boolean p;
    int q;
    WeakReference<V> r;
    WeakReference<View> s;
    private a t;
    private VelocityTracker u;
    int v;
    private int w;
    boolean x;
    private Map<View, Integer> y;
    private final g.a z;

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f1299a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1300b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(View view, int i) {
            this.f1299a = view;
            this.f1300b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = BottomSheetBehavior.this.m;
            if (gVar != null && gVar.a(true)) {
                t.a(this.f1299a, this);
            } else {
                BottomSheetBehavior.this.c(this.f1300b);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f1297a = true;
        this.l = 4;
        this.z = new com.google.android.material.bottomsheet.a(this);
    }

    private void e() {
        this.v = -1;
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.u = null;
        }
    }

    public void c(boolean z) {
        this.k = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.d(coordinatorLayout, v), this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.google.android.material.bottomsheet.b();
        final int c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.c = i;
        }
    }

    private float d() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND, this.f1298b);
        return this.u.getYVelocity(this.v);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (CoordinatorLayout) v, savedState.a());
        int i = savedState.c;
        if (i != 1 && i != 2) {
            this.l = i;
        } else {
            this.l = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.l == 1 && actionMasked == 0) {
                return true;
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.a(motionEvent);
            }
            if (actionMasked == 0) {
                e();
            }
            if (this.u == null) {
                this.u = VelocityTracker.obtain();
            }
            this.u.addMovement(motionEvent);
            if (actionMasked == 2 && !this.n && Math.abs(this.w - motionEvent.getY()) > this.m.e()) {
                this.m.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.n;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        a aVar;
        if (this.l == i) {
            return;
        }
        this.l = i;
        if (i == 6 || i == 3) {
            d(true);
        } else if (i == 5 || i == 4) {
            d(false);
        }
        V v = this.r.get();
        if (v == null || (aVar = this.t) == null) {
            return;
        }
        aVar.a((View) v, i);
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.f1297a = true;
        this.l = 4;
        this.z = new com.google.android.material.bottomsheet.a(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && (i = peekValue.data) == -1) {
            b(i);
        } else {
            b(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        b(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f1298b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void d(boolean z) {
        WeakReference<V> weakReference = this.r;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.y != null) {
                    return;
                }
                this.y = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.r.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.y;
                        if (map != null && map.containsKey(childAt)) {
                            t.d(childAt, this.y.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        t.d(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.y = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (t.h(coordinatorLayout) && !t.h(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.c(v, i);
        this.q = coordinatorLayout.getHeight();
        if (this.d) {
            if (this.e == 0) {
                this.e = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            }
            this.f = Math.max(this.e, this.q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f = this.c;
        }
        this.g = Math.max(0, this.q - v.getHeight());
        this.h = this.q / 2;
        b();
        int i2 = this.l;
        if (i2 == 3) {
            t.b((View) v, c());
        } else if (i2 == 6) {
            t.b((View) v, this.h);
        } else if (this.j && i2 == 5) {
            t.b((View) v, this.q);
        } else {
            int i3 = this.l;
            if (i3 == 4) {
                t.b((View) v, this.i);
            } else if (i3 == 1 || i3 == 2) {
                t.b((View) v, top - v.getTop());
            }
        }
        if (this.m == null) {
            this.m = g.a(coordinatorLayout, this.z);
        }
        this.r = new WeakReference<>(v);
        this.s = new WeakReference<>(a(v));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        if (this.f1297a) {
            return this.g;
        }
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.o = 0;
        this.p = false;
        return (i & 2) != 0;
    }

    public final void b(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.d) {
                this.d = true;
            }
            z = false;
        } else {
            if (this.d || this.c != i) {
                this.d = false;
                this.c = Math.max(0, i);
                this.i = this.q - i;
            }
            z = false;
        }
        if (!z || this.l != 4 || (weakReference = this.r) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public void b(boolean z) {
        this.j = z;
    }

    private void b() {
        if (this.f1297a) {
            this.i = Math.max(this.q - this.f, this.g);
        } else {
            this.i = this.q - this.f;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        g gVar;
        if (!v.isShown()) {
            this.n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            e();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.s;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.a(view, x, this.w)) {
                this.v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.x = true;
            }
            this.n = this.v == -1 && !coordinatorLayout.a(v, x, this.w);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.x = false;
            this.v = -1;
            if (this.n) {
                this.n = false;
                return false;
            }
        }
        if (this.n || (gVar = this.m) == null || !gVar.b(motionEvent)) {
            WeakReference<View> weakReference2 = this.s;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            return (actionMasked != 2 || view2 == null || this.n || this.l == 1 || coordinatorLayout.a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.m == null || Math.abs(((float) this.w) - motionEvent.getY()) <= ((float) this.m.e())) ? false : true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1 && view == this.s.get()) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < c()) {
                    iArr[1] = top - c();
                    t.b((View) v, -iArr[1]);
                    c(3);
                } else {
                    iArr[1] = i2;
                    t.b((View) v, -i2);
                    c(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i5 = this.i;
                if (i4 > i5 && !this.j) {
                    iArr[1] = top - i5;
                    t.b((View) v, -iArr[1]);
                    c(4);
                } else {
                    iArr[1] = i2;
                    t.b((View) v, -i2);
                    c(1);
                }
            }
            a(v.getTop());
            this.o = i2;
            this.p = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3 = 3;
        if (v.getTop() == c()) {
            c(3);
        } else if (view == this.s.get() && this.p) {
            if (this.o > 0) {
                i2 = c();
            } else if (this.j && a(v, d())) {
                i2 = this.q;
                i3 = 5;
            } else {
                if (this.o == 0) {
                    int top = v.getTop();
                    if (this.f1297a) {
                        if (Math.abs(top - this.g) < Math.abs(top - this.i)) {
                            i2 = this.g;
                        } else {
                            i2 = this.i;
                        }
                    } else {
                        int i4 = this.h;
                        if (top < i4) {
                            if (top < Math.abs(top - this.i)) {
                                i2 = 0;
                            } else {
                                i2 = this.h;
                            }
                        } else if (Math.abs(top - i4) < Math.abs(top - this.i)) {
                            i2 = this.h;
                        } else {
                            i2 = this.i;
                        }
                        i3 = 6;
                    }
                } else {
                    i2 = this.i;
                }
                i3 = 4;
            }
            if (this.m.b(v, v.getLeft(), i2)) {
                c(2);
                t.a(v, new b(v, i3));
            } else {
                c(i3);
            }
            this.p = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.s.get() && (this.l != 3 || super.a(coordinatorLayout, (CoordinatorLayout) v, view, f, f2));
    }

    public void a(boolean z) {
        if (this.f1297a == z) {
            return;
        }
        this.f1297a = z;
        if (this.r != null) {
            b();
        }
        c((this.f1297a && this.l == 6) ? 3 : this.l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, float f) {
        if (this.k) {
            return true;
        }
        return view.getTop() >= this.i && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.i)) / ((float) this.c) > 0.5f;
    }

    View a(View view) {
        if (t.A(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a2 = a(viewGroup.getChildAt(i));
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        a aVar;
        V v = this.r.get();
        if (v == null || (aVar = this.t) == null) {
            return;
        }
        int i2 = this.i;
        if (i > i2) {
            aVar.a(v, (i2 - i) / (this.q - i2));
        } else {
            aVar.a(v, (i2 - i) / (i2 - c()));
        }
    }
}
