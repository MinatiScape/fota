package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements androidx.core.h.r {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f234a = {16843505};

    /* renamed from: b  reason: collision with root package name */
    private final C0056o f235b;
    private final boolean c;
    int mDropDownWidth;
    private H mForwardingListener;
    b mPopup;
    private final Context mPopupContext;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f236a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f237b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f236a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f237b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof ea) {
                    ea eaVar = (ea) spinnerAdapter;
                    if (eaVar.getDropDownViewTheme() == null) {
                        eaVar.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f237b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f236a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f236a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f236a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f236a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f236a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f237b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f236a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f236a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends ListPopupWindow {
        private CharSequence K;
        ListAdapter L;
        private final Rect M;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.M = new Rect();
            a(AppCompatSpinner.this);
            a(true);
            f(0);
            setOnItemClickListener(new C0063w(this, AppCompatSpinner.this));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view) {
            return androidx.core.h.t.y(view) && view.getGlobalVisibleRect(this.M);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void i() {
            Drawable c = c();
            int i = 0;
            if (c != null) {
                c.getPadding(AppCompatSpinner.this.mTempRect);
                i = wa.a(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i2 = appCompatSpinner.mDropDownWidth;
            if (i2 == -2) {
                int a2 = appCompatSpinner.a((SpinnerAdapter) this.L, c());
                int i3 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.mTempRect;
                int i4 = (i3 - rect2.left) - rect2.right;
                if (a2 > i4) {
                    a2 = i4;
                }
                b(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                b((width - paddingLeft) - paddingRight);
            } else {
                b(i2);
            }
            d(wa.a(AppCompatSpinner.this) ? i + ((width - paddingRight) - f()) : i + paddingLeft);
        }

        public CharSequence j() {
            return this.K;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.view.menu.z
        public void show() {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            i();
            e(2);
            super.show();
            getListView().setChoiceMode(1);
            g(AppCompatSpinner.this.getSelectedItemPosition());
            if (isShowing || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            ViewTreeObserver$OnGlobalLayoutListenerC0064x viewTreeObserver$OnGlobalLayoutListenerC0064x = new ViewTreeObserver$OnGlobalLayoutListenerC0064x(this);
            viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListenerC0064x);
            setOnDismissListener(new C0065y(this, viewTreeObserver$OnGlobalLayoutListenerC0064x));
        }

        @Override // androidx.appcompat.widget.ListPopupWindow
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.L = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.K = charSequence;
        }
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            return i2 + rect.left + rect.right;
        }
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0056o c0056o = this.f235b;
        if (c0056o != null) {
            c0056o.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        b bVar = this.mPopup;
        if (bVar != null) {
            return bVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        b bVar = this.mPopup;
        if (bVar != null) {
            return bVar.e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        b bVar = this.mPopup;
        if (bVar != null) {
            return bVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.mPopup != null) {
            return this.mPopupContext;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        b bVar = this.mPopup;
        return bVar != null ? bVar.j() : super.getPrompt();
    }

    @Override // androidx.core.h.r
    public ColorStateList getSupportBackgroundTintList() {
        C0056o c0056o = this.f235b;
        if (c0056o != null) {
            return c0056o.b();
        }
        return null;
    }

    @Override // androidx.core.h.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0056o c0056o = this.f235b;
        if (c0056o != null) {
            return c0056o.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.mPopup;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.mPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        H h = this.mForwardingListener;
        if (h == null || !h.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        b bVar = this.mPopup;
        if (bVar != null) {
            if (bVar.isShowing()) {
                return true;
            }
            this.mPopup.show();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0056o c0056o = this.f235b;
        if (c0056o != null) {
            c0056o.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0056o c0056o = this.f235b;
        if (c0056o != null) {
            c0056o.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.h(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        b bVar = this.mPopup;
        if (bVar != null) {
            bVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0056o c0056o = this.f235b;
        if (c0056o != null) {
            c0056o.b(colorStateList);
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0056o c0056o = this.f235b;
        if (c0056o != null) {
            c0056o.a(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.c) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.a(new a(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r12 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
        r12.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
        if (r12 == null) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.mTempRect = r0
            int[] r0 = androidx.appcompat.R$styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.ia r0 = androidx.appcompat.widget.ia.a(r8, r9, r0, r10, r1)
            androidx.appcompat.widget.o r2 = new androidx.appcompat.widget.o
            r2.<init>(r7)
            r7.f235b = r2
            r2 = 0
            if (r12 == 0) goto L23
            androidx.appcompat.d.d r3 = new androidx.appcompat.d.d
            r3.<init>(r8, r12)
            r7.mPopupContext = r3
            goto L3e
        L23:
            int r12 = androidx.appcompat.R$styleable.Spinner_popupTheme
            int r12 = r0.g(r12, r1)
            if (r12 == 0) goto L33
            androidx.appcompat.d.d r3 = new androidx.appcompat.d.d
            r3.<init>(r8, r12)
            r7.mPopupContext = r3
            goto L3e
        L33:
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r12 >= r3) goto L3b
            r12 = r8
            goto L3c
        L3b:
            r12 = r2
        L3c:
            r7.mPopupContext = r12
        L3e:
            android.content.Context r12 = r7.mPopupContext
            r3 = 1
            if (r12 == 0) goto Lac
            r12 = -1
            if (r11 != r12) goto L74
            int[] r12 = androidx.appcompat.widget.AppCompatSpinner.f234a     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            android.content.res.TypedArray r12 = r8.obtainStyledAttributes(r9, r12, r10, r1)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            boolean r4 = r12.hasValue(r1)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L6d
            if (r4 == 0) goto L56
            int r11 = r12.getInt(r1, r1)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L6d
        L56:
            if (r12 == 0) goto L74
        L58:
            r12.recycle()
            goto L74
        L5c:
            r4 = move-exception
            goto L63
        L5e:
            r8 = move-exception
            r12 = r2
            goto L6e
        L61:
            r4 = move-exception
            r12 = r2
        L63:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch: java.lang.Throwable -> L6d
            if (r12 == 0) goto L74
            goto L58
        L6d:
            r8 = move-exception
        L6e:
            if (r12 == 0) goto L73
            r12.recycle()
        L73:
            throw r8
        L74:
            if (r11 != r3) goto Lac
            androidx.appcompat.widget.AppCompatSpinner$b r11 = new androidx.appcompat.widget.AppCompatSpinner$b
            android.content.Context r12 = r7.mPopupContext
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.mPopupContext
            int[] r4 = androidx.appcompat.R$styleable.Spinner
            androidx.appcompat.widget.ia r12 = androidx.appcompat.widget.ia.a(r12, r9, r4, r10, r1)
            int r1 = androidx.appcompat.R$styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r12.f(r1, r4)
            r7.mDropDownWidth = r1
            int r1 = androidx.appcompat.R$styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r12.b(r1)
            r11.a(r1)
            int r1 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r11.a(r1)
            r12.a()
            r7.mPopup = r11
            androidx.appcompat.widget.v r12 = new androidx.appcompat.widget.v
            r12.<init>(r7, r7, r11)
            r7.mForwardingListener = r12
        Lac:
            int r11 = androidx.appcompat.R$styleable.Spinner_android_entries
            java.lang.CharSequence[] r11 = r0.f(r11)
            if (r11 == 0) goto Lc4
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = androidx.appcompat.R$layout.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter(r12)
        Lc4:
            r0.a()
            r7.c = r3
            android.widget.SpinnerAdapter r8 = r7.mTempAdapter
            if (r8 == 0) goto Ld2
            r7.setAdapter(r8)
            r7.mTempAdapter = r2
        Ld2:
            androidx.appcompat.widget.o r8 = r7.f235b
            r8.a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
