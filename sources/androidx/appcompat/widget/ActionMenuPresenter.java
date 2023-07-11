package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.AbstractC0038b;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.h.AbstractC0068b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends AbstractC0038b implements AbstractC0068b.a {
    a A;
    c B;
    private b C;
    final f D;
    int E;
    d k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private final SparseBooleanArray x;
    private View y;
    e z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0049h();

        /* renamed from: a  reason: collision with root package name */
        public int f202a;

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f202a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel) {
            this.f202a = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.u {
        public a(Context context, androidx.appcompat.view.menu.D d, View view) {
            super(context, d, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.p) d.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.k;
                a(view2 == null ? (View) ((AbstractC0038b) ActionMenuPresenter.this).i : view2);
            }
            a(ActionMenuPresenter.this.D);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.appcompat.view.menu.u
        public void d() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.A = null;
            actionMenuPresenter.E = 0;
            super.d();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.z a() {
            a aVar = ActionMenuPresenter.this.A;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private e f204a;

        public c(e eVar) {
            this.f204a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractC0038b) ActionMenuPresenter.this).c != null) {
                ((AbstractC0038b) ActionMenuPresenter.this).c.a();
            }
            View view = (View) ((AbstractC0038b) ActionMenuPresenter.this).i;
            if (view != null && view.getWindowToken() != null && this.f204a.f()) {
                ActionMenuPresenter.this.z = this.f204a;
            }
            ActionMenuPresenter.this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends AppCompatImageView implements ActionMenuView.a {
        private final float[] c;

        public d(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            this.c = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            qa.a(this, getContentDescription());
            setOnTouchListener(new C0048g(this, this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.h();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.u {
        public e(Context context, androidx.appcompat.view.menu.l lVar, View view, boolean z) {
            super(context, lVar, view, z, R$attr.actionOverflowMenuStyle);
            a(8388613);
            a(ActionMenuPresenter.this.D);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.appcompat.view.menu.u
        public void d() {
            if (((AbstractC0038b) ActionMenuPresenter.this).c != null) {
                ((AbstractC0038b) ActionMenuPresenter.this).c.close();
            }
            ActionMenuPresenter.this.z = null;
            super.d();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.D = new f();
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean flagActionItems() {
        ArrayList<androidx.appcompat.view.menu.p> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.l lVar = actionMenuPresenter.c;
        int i5 = 0;
        if (lVar != null) {
            arrayList = lVar.n();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = actionMenuPresenter.r;
        int i7 = actionMenuPresenter.q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.i;
        int i8 = i6;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            androidx.appcompat.view.menu.p pVar = arrayList.get(i11);
            if (pVar.o()) {
                i9++;
            } else if (pVar.n()) {
                i10++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.v && pVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.n && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.t) {
            int i13 = actionMenuPresenter.w;
            i3 = i7 / i13;
            i2 = i13 + ((i7 % i13) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i14 = i7;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i) {
            androidx.appcompat.view.menu.p pVar2 = arrayList.get(i15);
            if (pVar2.o()) {
                View a2 = actionMenuPresenter.a(pVar2, actionMenuPresenter.y, viewGroup);
                if (actionMenuPresenter.y == null) {
                    actionMenuPresenter.y = a2;
                }
                if (actionMenuPresenter.t) {
                    i3 -= ActionMenuView.a(a2, i2, i3, makeMeasureSpec, i5);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = pVar2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                pVar2.d(z);
                i4 = i;
                i16 = measuredWidth;
            } else if (pVar2.n()) {
                int groupId2 = pVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i14 > 0 && (!actionMenuPresenter.t || i3 > 0);
                if (z4) {
                    boolean z5 = z4;
                    View a3 = actionMenuPresenter.a(pVar2, actionMenuPresenter.y, viewGroup);
                    i4 = i;
                    if (actionMenuPresenter.y == null) {
                        actionMenuPresenter.y = a3;
                    }
                    if (actionMenuPresenter.t) {
                        int a4 = ActionMenuView.a(a3, i2, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        if (a4 == 0) {
                            z5 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z4 = z5 & (!actionMenuPresenter.t ? i14 + i16 <= 0 : i14 < 0);
                } else {
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i17 = 0; i17 < i15; i17++) {
                        androidx.appcompat.view.menu.p pVar3 = arrayList.get(i17);
                        if (pVar3.getGroupId() == groupId2) {
                            if (pVar3.l()) {
                                i12++;
                            }
                            pVar3.d(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                pVar2.d(z4);
            } else {
                i4 = i;
                pVar2.d(false);
                i15++;
                i5 = 0;
                actionMenuPresenter = this;
                i = i4;
            }
            i15++;
            i5 = 0;
            actionMenuPresenter = this;
            i = i4;
        }
        return true;
    }

    public boolean g() {
        e eVar = this.z;
        return eVar != null && eVar.c();
    }

    public boolean h() {
        androidx.appcompat.view.menu.l lVar;
        if (!this.n || g() || (lVar = this.c) == null || this.i == null || this.B != null || lVar.j().isEmpty()) {
            return false;
        }
        this.B = new c(new e(this.f165b, this.c, this.k, true));
        ((View) this.i).post(this.B);
        super.a((androidx.appcompat.view.menu.D) null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.v
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).f202a) > 0 && (findItem = this.c.findItem(i)) != null) {
            a((androidx.appcompat.view.menu.D) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f202a = this.E;
        return savedState;
    }

    @Override // androidx.core.h.AbstractC0068b.a
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.a((androidx.appcompat.view.menu.D) null);
            return;
        }
        androidx.appcompat.view.menu.l lVar = this.c;
        if (lVar != null) {
            lVar.a(false);
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b, androidx.appcompat.view.menu.v
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.i).requestLayout();
        androidx.appcompat.view.menu.l lVar = this.c;
        boolean z2 = false;
        if (lVar != null) {
            ArrayList<androidx.appcompat.view.menu.p> c2 = lVar.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                AbstractC0068b a2 = c2.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        androidx.appcompat.view.menu.l lVar2 = this.c;
        ArrayList<androidx.appcompat.view.menu.p> j = lVar2 != null ? lVar2.j() : null;
        if (this.n && j != null) {
            int size2 = j.size();
            if (size2 == 1) {
                z2 = !j.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.k == null) {
                this.k = new d(this.f164a);
            }
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.k, actionMenuView.b());
            }
        } else {
            d dVar = this.k;
            if (dVar != null) {
                ViewParent parent = dVar.getParent();
                androidx.appcompat.view.menu.w wVar = this.i;
                if (parent == wVar) {
                    ((ViewGroup) wVar).removeView(this.k);
                }
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.n);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b, androidx.appcompat.view.menu.v
    public void a(Context context, androidx.appcompat.view.menu.l lVar) {
        super.a(context, lVar);
        Resources resources = context.getResources();
        androidx.appcompat.d.a a2 = androidx.appcompat.d.a.a(context);
        if (!this.o) {
            this.n = a2.g();
        }
        if (!this.u) {
            this.p = a2.b();
        }
        if (!this.s) {
            this.r = a2.c();
        }
        int i = this.p;
        if (this.n) {
            if (this.k == null) {
                this.k = new d(this.f164a);
                if (this.m) {
                    this.k.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.q = i;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.y = null;
    }

    public void b(boolean z) {
        this.n = z;
        this.o = true;
    }

    public Drawable c() {
        d dVar = this.k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.m) {
            return this.l;
        }
        return null;
    }

    public boolean d() {
        androidx.appcompat.view.menu.w wVar;
        c cVar = this.B;
        if (cVar != null && (wVar = this.i) != null) {
            ((View) wVar).removeCallbacks(cVar);
            this.B = null;
            return true;
        }
        e eVar = this.z;
        if (eVar != null) {
            eVar.a();
            return true;
        }
        return false;
    }

    public boolean e() {
        a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.B != null || g();
    }

    /* loaded from: classes.dex */
    private class f implements v.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.v.a
        public boolean a(androidx.appcompat.view.menu.l lVar) {
            if (lVar == null) {
                return false;
            }
            ActionMenuPresenter.this.E = ((androidx.appcompat.view.menu.D) lVar).getItem().getItemId();
            v.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                return a2.a(lVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.v.a
        public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
            if (lVar instanceof androidx.appcompat.view.menu.D) {
                lVar.m().a(false);
            }
            v.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                a2.a(lVar, z);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b
    public androidx.appcompat.view.menu.w b(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.w wVar = this.i;
        androidx.appcompat.view.menu.w b2 = super.b(viewGroup);
        if (wVar != b2) {
            ((ActionMenuView) b2).setPresenter(this);
        }
        return b2;
    }

    public boolean b() {
        return d() | e();
    }

    public void a(Configuration configuration) {
        if (!this.s) {
            this.r = androidx.appcompat.d.a.a(this.f165b).c();
        }
        androidx.appcompat.view.menu.l lVar = this.c;
        if (lVar != null) {
            lVar.b(true);
        }
    }

    public void a(boolean z) {
        this.v = z;
    }

    public void a(Drawable drawable) {
        d dVar = this.k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.m = true;
        this.l = drawable;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b
    public View a(androidx.appcompat.view.menu.p pVar, View view, ViewGroup viewGroup) {
        View actionView = pVar.getActionView();
        if (actionView == null || pVar.j()) {
            actionView = super.a(pVar, view, viewGroup);
        }
        actionView.setVisibility(pVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b
    public void a(androidx.appcompat.view.menu.p pVar, w.a aVar) {
        aVar.a(pVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b
    public boolean a(int i, androidx.appcompat.view.menu.p pVar) {
        return pVar.l();
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b, androidx.appcompat.view.menu.v
    public boolean a(androidx.appcompat.view.menu.D d2) {
        boolean z = false;
        if (d2.hasVisibleItems()) {
            androidx.appcompat.view.menu.D d3 = d2;
            while (d3.t() != this.c) {
                d3 = (androidx.appcompat.view.menu.D) d3.t();
            }
            View a2 = a(d3.getItem());
            if (a2 == null) {
                return false;
            }
            this.E = d2.getItem().getItemId();
            int size = d2.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = d2.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            this.A = new a(this.f165b, d2, a2);
            this.A.a(z);
            this.A.e();
            super.a(d2);
            return true;
        }
        return false;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof w.a) && ((w.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.AbstractC0038b, androidx.appcompat.view.menu.v
    public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
        b();
        super.a(lVar, z);
    }

    public void a(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.a(this.c);
    }
}
