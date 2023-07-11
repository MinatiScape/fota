package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.C0050i;
import androidx.core.h.AbstractC0068b;
/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements C0050i.a {

    /* renamed from: a  reason: collision with root package name */
    final a f208a;

    /* renamed from: b  reason: collision with root package name */
    private final b f209b;
    private final View c;
    private final Drawable d;
    final FrameLayout e;
    private final ImageView f;
    final FrameLayout g;
    private final ImageView h;
    private final int i;
    AbstractC0068b j;
    final DataSetObserver k;
    private final ViewTreeObserver.OnGlobalLayoutListener l;
    private ListPopupWindow m;
    PopupWindow.OnDismissListener n;
    boolean o;
    int p;
    private boolean q;
    private int r;

    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f210a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ia a2 = ia.a(context, attributeSet, f210a);
            setBackgroundDrawable(a2.b(0));
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.g) {
                activityChooserView.a();
                Intent a2 = ActivityChooserView.this.f208a.b().a(ActivityChooserView.this.f208a.b().a(ActivityChooserView.this.f208a.c()));
                if (a2 != null) {
                    a2.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(a2);
                }
            } else if (view == activityChooserView.e) {
                activityChooserView.o = false;
                activityChooserView.a(activityChooserView.p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            AbstractC0068b abstractC0068b = ActivityChooserView.this.j;
            if (abstractC0068b != null) {
                abstractC0068b.a(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ActivityChooserView.this.a(Integer.MAX_VALUE);
                    return;
                }
                throw new IllegalArgumentException();
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.o) {
                if (i > 0) {
                    activityChooserView.f208a.b().c(i);
                    return;
                }
                return;
            }
            if (!activityChooserView.f208a.e()) {
                i++;
            }
            Intent a2 = ActivityChooserView.this.f208a.b().a(i);
            if (a2 != null) {
                a2.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(a2);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.g) {
                if (activityChooserView.f208a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.o = true;
                    activityChooserView2.a(activityChooserView2.p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int, boolean] */
    void a(int i) {
        if (this.f208a.b() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.l);
            ?? r0 = this.g.getVisibility() == 0 ? 1 : 0;
            int a2 = this.f208a.a();
            if (i != Integer.MAX_VALUE && a2 > i + r0) {
                this.f208a.a(true);
                this.f208a.a(i - 1);
            } else {
                this.f208a.a(false);
                this.f208a.a(i);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (listPopupWindow.isShowing()) {
                return;
            }
            if (!this.o && r0 != 0) {
                this.f208a.a(false, false);
            } else {
                this.f208a.a(true, r0);
            }
            listPopupWindow.b(Math.min(this.f208a.f(), this.i));
            listPopupWindow.show();
            AbstractC0068b abstractC0068b = this.j;
            if (abstractC0068b != null) {
                abstractC0068b.a(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(R$string.abc_activitychooserview_choose_application));
            listPopupWindow.getListView().setSelector(new ColorDrawable(0));
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean b() {
        return getListPopupWindow().isShowing();
    }

    public boolean c() {
        if (b() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f208a.getCount() > 0) {
            this.e.setEnabled(true);
        } else {
            this.e.setEnabled(false);
        }
        int a2 = this.f208a.a();
        int d = this.f208a.d();
        if (a2 != 1 && (a2 <= 1 || d <= 0)) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            ResolveInfo c = this.f208a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.h.setImageDrawable(c.loadIcon(packageManager));
            if (this.r != 0) {
                this.g.setContentDescription(getContext().getString(this.r, c.loadLabel(packageManager)));
            }
        }
        if (this.g.getVisibility() == 0) {
            this.c.setBackgroundDrawable(this.d);
        } else {
            this.c.setBackgroundDrawable(null);
        }
    }

    public C0050i getDataModel() {
        return this.f208a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.m == null) {
            this.m = new ListPopupWindow(getContext());
            this.m.a(this.f208a);
            this.m.a(this);
            this.m.a(true);
            this.m.setOnItemClickListener(this.f209b);
            this.m.setOnDismissListener(this.f209b);
        }
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0050i b2 = this.f208a.b();
        if (b2 != null) {
            b2.registerObserver(this.k);
        }
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0050i b2 = this.f208a.b();
        if (b2 != null) {
            b2.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (b()) {
            a();
        }
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.c.layout(0, 0, i3 - i, i4 - i2);
        if (b()) {
            return;
        }
        a();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.c;
        if (this.g.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0050i c0050i) {
        this.f208a.a(c0050i);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.p = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void setProvider(AbstractC0068b abstractC0068b) {
        this.j = abstractC0068b;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new C0051j(this);
        this.l = new ViewTreeObserver$OnGlobalLayoutListenerC0052k(this);
        this.p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i, 0);
        this.p = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.f209b = new b();
        this.c = findViewById(R$id.activity_chooser_view_content);
        this.d = this.c.getBackground();
        this.g = (FrameLayout) findViewById(R$id.default_activity_button);
        this.g.setOnClickListener(this.f209b);
        this.g.setOnLongClickListener(this.f209b);
        this.h = (ImageView) this.g.findViewById(R$id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout.setOnClickListener(this.f209b);
        frameLayout.setAccessibilityDelegate(new C0053l(this));
        frameLayout.setOnTouchListener(new C0054m(this, frameLayout));
        this.e = frameLayout;
        this.f = (ImageView) frameLayout.findViewById(R$id.image);
        this.f.setImageDrawable(drawable);
        this.f208a = new a();
        this.f208a.registerDataSetObserver(new C0055n(this));
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private C0050i f211a;

        /* renamed from: b  reason: collision with root package name */
        private int f212b = 4;
        private boolean c;
        private boolean d;
        private boolean e;

        a() {
        }

        public void a(C0050i c0050i) {
            C0050i b2 = ActivityChooserView.this.f208a.b();
            if (b2 != null && ActivityChooserView.this.isShown()) {
                b2.unregisterObserver(ActivityChooserView.this.k);
            }
            this.f211a = c0050i;
            if (c0050i != null && ActivityChooserView.this.isShown()) {
                c0050i.registerObserver(ActivityChooserView.this.k);
            }
            notifyDataSetChanged();
        }

        public C0050i b() {
            return this.f211a;
        }

        public ResolveInfo c() {
            return this.f211a.b();
        }

        public int d() {
            return this.f211a.c();
        }

        public boolean e() {
            return this.c;
        }

        public int f() {
            int i = this.f212b;
            this.f212b = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f212b = i;
            return i2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int a2 = this.f211a.a();
            if (!this.c && this.f211a.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.f212b);
            return this.e ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.c && this.f211a.b() != null) {
                i++;
            }
            return this.f211a.b(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.e && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                        return inflate;
                    }
                    return view;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != R$id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            ((ImageView) view.findViewById(R$id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.c && i == 0 && this.d) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void a(int i) {
            if (this.f212b != i) {
                this.f212b = i;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z) {
            if (this.e != z) {
                this.e = z;
                notifyDataSetChanged();
            }
        }

        public int a() {
            return this.f211a.a();
        }

        public void a(boolean z, boolean z2) {
            if (this.c == z && this.d == z2) {
                return;
            }
            this.c = z;
            this.d = z2;
            notifyDataSetChanged();
        }
    }

    public boolean a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.l);
                return true;
            }
            return true;
        }
        return true;
    }
}
