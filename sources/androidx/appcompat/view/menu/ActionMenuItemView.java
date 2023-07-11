package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.H;
import androidx.appcompat.widget.qa;
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements w.a, View.OnClickListener, ActionMenuView.a {
    p d;
    private CharSequence e;
    private Drawable f;
    l.b g;
    private H h;
    b i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int mMinWidth;

    /* loaded from: classes.dex */
    private class a extends H {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.H
        public z a() {
            b bVar = ActionMenuItemView.this.i;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.H
        protected boolean b() {
            z a2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            l.b bVar = actionMenuItemView.g;
            return bVar != null && bVar.a(actionMenuItemView.d) && (a2 = a()) != null && a2.isShowing();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract z a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    private boolean b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void c() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.e);
        if (this.f != null && (!this.d.r() || (!this.j && !this.k))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.e : null);
        CharSequence d = this.d.d();
        if (TextUtils.isEmpty(d)) {
            setContentDescription(z3 ? null : this.d.getTitle());
        } else {
            setContentDescription(d);
        }
        CharSequence i = this.d.i();
        if (TextUtils.isEmpty(i)) {
            qa.a(this, z3 ? null : this.d.getTitle());
        } else {
            qa.a(this, i);
        }
    }

    @Override // androidx.appcompat.view.menu.w.a
    public void a(p pVar, int i) {
        this.d = pVar;
        setIcon(pVar.getIcon());
        setTitle(pVar.a(this));
        setId(pVar.getItemId());
        setVisibility(pVar.isVisible() ? 0 : 8);
        setEnabled(pVar.isEnabled());
        if (pVar.hasSubMenu() && this.h == null) {
            this.h = new a();
        }
    }

    @Override // androidx.appcompat.view.menu.w.a
    public p getItemData() {
        return this.d;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerAfter() {
        return a();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerBefore() {
        return a() && this.d.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l.b bVar = this.g;
        if (bVar != null) {
            bVar.a(this.d);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.j = b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean a2 = a();
        if (a2 && (i3 = this.l) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.mMinWidth) : this.mMinWidth;
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (a2 || this.f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        H h;
        if (this.d.hasSubMenu() && (h = this.h) != null && h.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.w.a
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.k != z) {
            this.k = z;
            p pVar = this.d;
            if (pVar != null) {
                pVar.b();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.m;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            int i2 = this.m;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        c();
    }

    public void setItemInvoker(l.b bVar) {
        this.g = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.l = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.i = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        c();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.j = b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.m = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.l = -1;
        setSaveEnabled(false);
    }

    public boolean a() {
        return !TextUtils.isEmpty(getText());
    }
}
