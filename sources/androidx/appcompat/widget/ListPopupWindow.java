package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ListPopupWindow implements androidx.appcompat.view.menu.z {

    /* renamed from: a  reason: collision with root package name */
    private static Method f265a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f266b;
    private static Method c;
    final e A;
    private final d B;
    private final c C;
    private final a D;
    private Runnable E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;
    private Context d;
    private ListAdapter e;
    F f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    int s;
    private View t;
    private int u;
    private DataSetObserver v;
    private View w;
    private Drawable x;
    private AdapterView.OnItemClickListener y;
    private AdapterView.OnItemSelectedListener z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.a();
        }
    }

    /* loaded from: classes.dex */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.g() || ListPopupWindow.this.J.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.F.removeCallbacks(listPopupWindow.A);
            ListPopupWindow.this.A.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.J) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.J.getWidth() && y >= 0 && y < ListPopupWindow.this.J.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.F.postDelayed(listPopupWindow.A, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.F.removeCallbacks(listPopupWindow2.A);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            F f = ListPopupWindow.this.f;
            if (f == null || !androidx.core.h.t.y(f) || ListPopupWindow.this.f.getCount() <= ListPopupWindow.this.f.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.s) {
                listPopupWindow.J.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        try {
            f265a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f266b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    private void j() {
        View view = this.t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.v;
        if (dataSetObserver == null) {
            this.v = new b();
        } else {
            ListAdapter listAdapter2 = this.e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.e = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.v);
        }
        F f = this.f;
        if (f != null) {
            f.setAdapter(this.e);
        }
    }

    public View b() {
        return this.w;
    }

    public Drawable c() {
        return this.J.getBackground();
    }

    public int d() {
        return this.i;
    }

    @Override // androidx.appcompat.view.menu.z
    public void dismiss() {
        this.J.dismiss();
        j();
        this.J.setContentView(null);
        this.f = null;
        this.F.removeCallbacks(this.A);
    }

    public int e() {
        if (this.l) {
            return this.j;
        }
        return 0;
    }

    public void f(int i) {
        this.u = i;
    }

    public void g(int i) {
        F f = this.f;
        if (!isShowing() || f == null) {
            return;
        }
        f.setListSelectionHidden(false);
        f.setSelection(i);
        if (f.getChoiceMode() != 0) {
            f.setItemChecked(i, true);
        }
    }

    @Override // androidx.appcompat.view.menu.z
    public ListView getListView() {
        return this.f;
    }

    public boolean h() {
        return this.I;
    }

    public void i(int i) {
        this.h = i;
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean isShowing() {
        return this.J.isShowing();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.y = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.z = onItemSelectedListener;
    }

    @Override // androidx.appcompat.view.menu.z
    public void show() {
        int i = i();
        boolean g = g();
        androidx.core.widget.k.a(this.J, this.k);
        boolean z = true;
        if (this.J.isShowing()) {
            if (androidx.core.h.t.y(b())) {
                int i2 = this.h;
                if (i2 == -1) {
                    i2 = -1;
                } else if (i2 == -2) {
                    i2 = b().getWidth();
                }
                int i3 = this.g;
                if (i3 == -1) {
                    if (!g) {
                        i = -1;
                    }
                    if (g) {
                        this.J.setWidth(this.h == -1 ? -1 : 0);
                        this.J.setHeight(0);
                    } else {
                        this.J.setWidth(this.h == -1 ? -1 : 0);
                        this.J.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    i = i3;
                }
                this.J.setOutsideTouchable((this.r || this.q) ? false : false);
                this.J.update(b(), this.i, this.j, i2 < 0 ? -1 : i2, i < 0 ? -1 : i);
                return;
            }
            return;
        }
        int i4 = this.h;
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = b().getWidth();
        }
        int i5 = this.g;
        if (i5 == -1) {
            i = -1;
        } else if (i5 != -2) {
            i = i5;
        }
        this.J.setWidth(i4);
        this.J.setHeight(i);
        c(true);
        this.J.setOutsideTouchable((this.r || this.q) ? false : true);
        this.J.setTouchInterceptor(this.B);
        if (this.o) {
            androidx.core.widget.k.a(this.J, this.n);
        }
        Method method = c;
        if (method != null) {
            try {
                method.invoke(this.J, this.H);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        androidx.core.widget.k.a(this.J, b(), this.i, this.j, this.p);
        this.f.setSelection(-1);
        if (!this.I || this.f.isInTouchMode()) {
            a();
        }
        if (this.I) {
            return;
        }
        this.F.post(this.D);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listPopupWindowStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int i() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        if (this.f == null) {
            Context context = this.d;
            this.E = new I(this);
            this.f = a(context, !this.I);
            Drawable drawable = this.x;
            if (drawable != null) {
                this.f.setSelector(drawable);
            }
            this.f.setAdapter(this.e);
            this.f.setOnItemClickListener(this.y);
            this.f.setFocusable(true);
            this.f.setFocusableInTouchMode(true);
            this.f.setOnItemSelectedListener(new J(this));
            this.f.setOnScrollListener(this.C);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.z;
            if (onItemSelectedListener != null) {
                this.f.setOnItemSelectedListener(onItemSelectedListener);
            }
            F f = this.f;
            View view = this.t;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.u;
                if (i4 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(f, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.u);
                } else {
                    linearLayout.addView(f, layoutParams);
                    linearLayout.addView(view);
                }
                int i5 = this.h;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                f = linearLayout;
            } else {
                i = 0;
            }
            this.J.setContentView(f);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.J.getContentView();
            View view2 = this.t;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.l) {
                this.j = -i6;
            }
        } else {
            this.G.setEmpty();
            i2 = 0;
        }
        int a2 = a(b(), this.j, this.J.getInputMethodMode() == 2);
        if (this.q || this.g == -1) {
            return a2 + i2;
        }
        int i7 = this.h;
        if (i7 == -2) {
            int i8 = this.d.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.G;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.d.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.G;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int a3 = this.f.a(makeMeasureSpec, 0, -1, a2 - i, -1);
        if (a3 > 0) {
            i += i2 + this.f.getPaddingTop() + this.f.getPaddingBottom();
        }
        return a3 + i;
    }

    public void b(int i) {
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            this.h = rect.left + rect.right + i;
            return;
        }
        i(i);
    }

    public void c(int i) {
        this.p = i;
    }

    public void d(int i) {
        this.i = i;
    }

    public int f() {
        return this.h;
    }

    public void h(int i) {
        this.j = i;
        this.l = true;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    private void c(boolean z) {
        Method method = f265a;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void e(int i) {
        this.J.setInputMethodMode(i);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.g = -2;
        this.h = -2;
        this.k = 1002;
        this.m = true;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = Integer.MAX_VALUE;
        this.u = 0;
        this.A = new e();
        this.B = new d();
        this.C = new c();
        this.D = new a();
        this.G = new Rect();
        this.d = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i, i2);
        this.i = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.j = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.j != 0) {
            this.l = true;
        }
        obtainStyledAttributes.recycle();
        this.J = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.J.setInputMethodMode(1);
    }

    public void b(boolean z) {
        this.o = true;
        this.n = z;
    }

    public boolean g() {
        return this.J.getInputMethodMode() == 2;
    }

    public void a(boolean z) {
        this.I = z;
        this.J.setFocusable(z);
    }

    public void a(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public void a(int i) {
        this.J.setAnimationStyle(i);
    }

    public void a(View view) {
        this.w = view;
    }

    public void a(Rect rect) {
        this.H = rect;
    }

    public void a() {
        F f = this.f;
        if (f != null) {
            f.setListSelectionHidden(true);
            f.requestLayout();
        }
    }

    F a(Context context, boolean z) {
        return new F(context, z);
    }

    private int a(View view, int i, boolean z) {
        Method method = f266b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.J, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.J.getMaxAvailableHeight(view, i);
    }
}
