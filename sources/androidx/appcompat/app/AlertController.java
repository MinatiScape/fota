package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a  reason: collision with root package name */
    private final Context f49a;

    /* renamed from: b  reason: collision with root package name */
    final A f50b;
    private final Window c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    ListView g;
    private View h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;
    private boolean n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new View$OnClickListenerC0028c(this);

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f51a;

        /* renamed from: b  reason: collision with root package name */
        private final int f52b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f51a, getPaddingRight(), z2 ? getPaddingBottom() : this.f52b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f52b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f51a = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public InterfaceC0003a O;

        /* renamed from: a  reason: collision with root package name */
        public final Context f53a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f54b;
        public Drawable d;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;
        public int c = 0;
        public int e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;
        public boolean r = true;

        /* renamed from: androidx.appcompat.app.AlertController$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0003a {
            void onPrepareListView(ListView listView);
        }

        public a(Context context) {
            this.f53a = context;
            this.f54b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            int i;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f54b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                Cursor cursor = this.K;
                if (cursor == null) {
                    listAdapter = new C0033h(this, this.f53a, alertController.M, 16908308, this.v, recycleListView);
                } else {
                    listAdapter = new C0034i(this, this.f53a, cursor, false, recycleListView, alertController);
                }
            } else {
                if (this.H) {
                    i = alertController.N;
                } else {
                    i = alertController.O;
                }
                int i2 = i;
                Cursor cursor2 = this.K;
                if (cursor2 != null) {
                    listAdapter = new SimpleCursorAdapter(this.f53a, i2, cursor2, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.w;
                    if (listAdapter == null) {
                        listAdapter = new c(this.f53a, i2, 16908308, this.v);
                    }
                }
            }
            InterfaceC0003a interfaceC0003a = this.O;
            if (interfaceC0003a != null) {
                interfaceC0003a.onPrepareListView(recycleListView);
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new C0035j(this, alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new C0036k(this, recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.g;
            if (view != null) {
                alertController.b(view);
            } else {
                CharSequence charSequence = this.f;
                if (charSequence != null) {
                    alertController.b(charSequence);
                }
                Drawable drawable = this.d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i = this.c;
                if (i != 0) {
                    alertController.b(i);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    alertController.b(alertController.a(i2));
                }
            }
            CharSequence charSequence2 = this.h;
            if (charSequence2 != null) {
                alertController.a(charSequence2);
            }
            if (this.i != null || this.j != null) {
                alertController.a(-1, this.i, this.k, (Message) null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.a(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.c(view2);
                    return;
                }
            }
            int i3 = this.y;
            if (i3 != 0) {
                alertController.c(i3);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f55a;

        public b(DialogInterface dialogInterface) {
            this.f55a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f55a.get(), message.what);
            } else if (i != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, A a2, Window window) {
        this.f49a = context;
        this.f50b = a2;
        this.c = window;
        this.R = new b(a2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        a2.a(1);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    private int b() {
        int i = this.K;
        if (i == 0) {
            return this.J;
        }
        return this.Q == 1 ? i : this.J;
    }

    private void d(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.e)) && this.P) {
            this.E = (TextView) this.c.findViewById(R$id.alertTitle);
            this.E.setText(this.e);
            int i = this.B;
            if (i != 0) {
                this.D.setImageResource(i);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            }
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
            return;
        }
        this.c.findViewById(R$id.title_template).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    public void c(int i) {
        this.h = null;
        this.i = i;
        this.n = false;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void c(View view) {
        this.h = view;
        this.i = 0;
        this.n = false;
    }

    public void b(CharSequence charSequence) {
        this.e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.c.findViewById(R$id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R$id.topPanel);
        View findViewById5 = findViewById3.findViewById(R$id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R$id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.customPanel);
        c(viewGroup);
        View findViewById7 = viewGroup.findViewById(R$id.topPanel);
        View findViewById8 = viewGroup.findViewById(R$id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R$id.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        b(a3);
        a(a4);
        d(a2);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a2 == null || a2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z3 && a3 != null && (findViewById2 = a3.findViewById(R$id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (this.f != null || this.g != null) {
                view = a2.findViewById(R$id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (a3 != null && (findViewById = a3.findViewById(R$id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view2 = this.g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                a(a3, view2, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i = this.I;
        if (i > -1) {
            listView2.setItemChecked(i, true);
            listView2.setSelection(i);
        }
    }

    public void b(View view) {
        this.G = view;
    }

    public void b(int i) {
        this.C = null;
        this.B = i;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void a() {
        this.f50b.setContentView(b());
        c();
    }

    public void a(CharSequence charSequence) {
        this.f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    private void b(ViewGroup viewGroup) {
        this.A = (NestedScrollView) this.c.findViewById(R$id.scrollView);
        this.A.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        this.F = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.F;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.h = view;
        this.i = 0;
        this.n = true;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else if (i == -1) {
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public int a(int i) {
        TypedValue typedValue = new TypedValue();
        this.f49a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private void c(ViewGroup viewGroup) {
        View view = this.h;
        if (view == null) {
            view = this.i != 0 ? LayoutInflater.from(this.f49a).inflate(this.i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !a(view)) {
            this.c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(R$id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f263a = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        View findViewById = this.c.findViewById(R$id.scrollIndicatorUp);
        View findViewById2 = this.c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.core.h.t.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById == null && view2 == null) {
            return;
        }
        if (this.f != null) {
            this.A.setOnScrollChangeListener(new C0029d(this, findViewById, view2));
            this.A.post(new RunnableC0030e(this, findViewById, view2));
            return;
        }
        ListView listView = this.g;
        if (listView != null) {
            listView.setOnScrollListener(new C0031f(this, findViewById, view2));
            this.g.post(new RunnableC0032g(this, findViewById, view2));
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private void a(ViewGroup viewGroup) {
        boolean z;
        this.o = (Button) viewGroup.findViewById(16908313);
        this.o.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            z = false;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i = this.d;
                drawable.setBounds(0, 0, i, i);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            z = true;
        }
        this.s = (Button) viewGroup.findViewById(16908314);
        this.s.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i2 = this.d;
                drawable2.setBounds(0, 0, i2, i2);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            z |= true;
        }
        this.w = (Button) viewGroup.findViewById(16908315);
        this.w.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.r;
            if (drawable3 != null) {
                int i3 = this.d;
                drawable3.setBounds(0, 0, i3, i3);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.w.setVisibility(0);
            z |= true;
        }
        if (a(this.f49a)) {
            if (z) {
                a(this.o);
            } else if (z) {
                a(this.s);
            } else if (z) {
                a(this.w);
            }
        }
        if (z) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
