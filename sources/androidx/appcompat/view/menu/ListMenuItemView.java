package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.ia;
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements w.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private p f160a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f161b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private int j;
    private Context k;
    private boolean l;
    private Drawable m;
    private Drawable mBackground;
    private boolean n;
    private int o;
    private LayoutInflater p;
    private boolean q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private void b() {
        this.f161b = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        a(this.f161b, 0);
    }

    private void c() {
        this.c = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        a(this.c);
    }

    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // androidx.appcompat.view.menu.w.a
    public void a(p pVar, int i) {
        this.f160a = pVar;
        this.o = i;
        setVisibility(pVar.isVisible() ? 0 : 8);
        setTitle(pVar.a(this));
        setCheckable(pVar.isCheckable());
        a(pVar.q(), pVar.g());
        setIcon(pVar.getIcon());
        setEnabled(pVar.isEnabled());
        setSubMenuArrowVisible(pVar.hasSubMenu());
        setContentDescription(pVar.d());
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
        rect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.w.a
    public p getItemData() {
        return this.f160a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        androidx.core.h.t.a(this, this.mBackground);
        this.d = (TextView) findViewById(R$id.title);
        int i = this.j;
        if (i != -1) {
            this.d.setTextAppearance(this.k, i);
        }
        this.f = (TextView) findViewById(R$id.shortcut);
        this.g = (ImageView) findViewById(R$id.submenuarrow);
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageDrawable(this.m);
        }
        this.h = (ImageView) findViewById(R$id.group_divider);
        this.i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f161b != null && this.l) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f161b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.appcompat.view.menu.w.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.c == null && this.e == null) {
            return;
        }
        if (this.f160a.m()) {
            if (this.c == null) {
                c();
            }
            compoundButton = this.c;
            compoundButton2 = this.e;
        } else {
            if (this.e == null) {
                a();
            }
            compoundButton = this.e;
            compoundButton2 = this.c;
        }
        if (z) {
            compoundButton.setChecked(this.f160a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f160a.m()) {
            if (this.c == null) {
                c();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                a();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.l = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.n || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f160a.p() || this.q;
        if (z || this.l) {
            if (this.f161b == null && drawable == null && !this.l) {
                return;
            }
            if (this.f161b == null) {
                b();
            }
            if (drawable == null && !this.l) {
                this.f161b.setVisibility(8);
                return;
            }
            ImageView imageView = this.f161b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f161b.getVisibility() != 0) {
                this.f161b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        ia a2 = ia.a(getContext(), attributeSet, R$styleable.MenuView, i, 0);
        this.mBackground = a2.b(R$styleable.MenuView_android_itemBackground);
        this.j = a2.g(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.l = a2.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.k = context;
        this.m = a2.b(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R$attr.dropDownListViewStyle, 0);
        this.n = obtainStyledAttributes.hasValue(0);
        a2.a();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i) {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public void a(boolean z, char c) {
        int i = (z && this.f160a.q()) ? 0 : 8;
        if (i == 0) {
            this.f.setText(this.f160a.h());
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    private void a() {
        this.e = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        a(this.e);
    }
}
