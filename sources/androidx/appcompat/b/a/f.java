package androidx.appcompat.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.d;
/* compiled from: StateListDrawable.java */
/* loaded from: classes.dex */
class f extends d {
    private a n;
    private boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListDrawable.java */
    /* loaded from: classes.dex */
    public static class a extends d.b {
        int[][] J;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, f fVar, Resources resources) {
            super(aVar, fVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[d()];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.J[a2] = iArr;
            return a2;
        }

        @Override // androidx.appcompat.b.a.d.b
        void n() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this, resources);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int[] iArr) {
            int[][] iArr2 = this.J;
            int e = e();
            for (int i = 0; i < e; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.appcompat.b.a.d.b
        public void a(int i, int i2) {
            super.a(i, i2);
            int[][] iArr = new int[i2];
            System.arraycopy(this.J, 0, iArr, 0, i);
            this.J = iArr;
        }
    }

    f(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.d
    public void clearMutated() {
        super.clearMutated();
        this.o = false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.o) {
            super.mutate();
            if (this == this) {
                this.n.n();
                this.o = true;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int a2 = this.n.a(iArr);
        if (a2 < 0) {
            a2 = this.n.a(StateSet.WILD_CARD);
        }
        return a(a2) || onStateChange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.d
    public a a() {
        return new a(this.n, this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.b.a.d
    public void a(d.b bVar) {
        super.a(bVar);
        if (bVar instanceof a) {
            this.n = (a) bVar;
        }
    }
}
