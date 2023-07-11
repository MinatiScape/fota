package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.s;
/* loaded from: classes.dex */
public class ChipGroup extends FlowLayout {
    private int d;
    private int e;
    private boolean f;
    private b g;
    private final a h;
    private c i;
    private int j;
    private boolean k;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    /* loaded from: classes.dex */
    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.k) {
                return;
            }
            int id = compoundButton.getId();
            if (z) {
                if (ChipGroup.this.j != -1 && ChipGroup.this.j != id && ChipGroup.this.f) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.a(chipGroup.j, false);
                }
                ChipGroup.this.setCheckedId(id);
            } else if (ChipGroup.this.j == id) {
                ChipGroup.this.setCheckedId(-1);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(ChipGroup chipGroup, int i);
    }

    /* loaded from: classes.dex */
    private class c implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f1308a;

        private c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            int hashCode;
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        hashCode = View.generateViewId();
                    } else {
                        hashCode = view2.hashCode();
                    }
                    view2.setId(hashCode);
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.h);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f1308a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f1308a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.j = i;
        b bVar = this.g;
        if (bVar == null || !this.f) {
            return;
        }
        bVar.a(this, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i2 = this.j;
                if (i2 != -1 && this.f) {
                    a(i2, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.f) {
            return this.j;
        }
        return -1;
    }

    public int getChipSpacingHorizontal() {
        return this.d;
    }

    public int getChipSpacingVertical() {
        return this.e;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.j;
        if (i != -1) {
            a(i, true);
            setCheckedId(this.j);
        }
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.d != i) {
            this.d = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.e != i) {
            this.e = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(b bVar) {
        this.g = bVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.i.f1308a = onHierarchyChangeListener;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.f != z) {
            this.f = z;
            b();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipGroupStyle);
    }

    public void b() {
        this.k = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.k = false;
        setCheckedId(-1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new a();
        this.i = new c();
        this.j = -1;
        this.k = false;
        TypedArray a2 = s.a(context, attributeSet, R$styleable.ChipGroup, i, R$style.Widget_MaterialComponents_ChipGroup, new int[0]);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(a2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(a2.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(a2.getBoolean(R$styleable.ChipGroup_singleLine, false));
        setSingleSelection(a2.getBoolean(R$styleable.ChipGroup_singleSelection, false));
        int resourceId = a2.getResourceId(R$styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.j = resourceId;
        }
        a2.recycle();
        super.setOnHierarchyChangeListener(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof Chip) {
            this.k = true;
            ((Chip) findViewById).setChecked(z);
            this.k = false;
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
