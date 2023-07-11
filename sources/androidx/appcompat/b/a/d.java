package androidx.appcompat.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
public class d extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private b f130a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f131b;
    private Drawable c;
    private Drawable d;
    private boolean f;
    private boolean i;
    private Runnable j;
    private long k;
    private long l;
    private a m;
    private int e = 255;
    private int g = -1;
    private int h = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public static class a implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Drawable.Callback f132a;

        a() {
        }

        public a a(Drawable.Callback callback) {
            this.f132a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f132a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f132a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f132a;
            this.f132a = null;
            return callback;
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    private boolean c() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    static int resolveDensity(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }

    b a() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r9) {
        /*
            r8 = this;
            int r0 = r8.g
            r1 = 0
            if (r9 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.b.a.d$b r0 = r8.f130a
            int r0 = r0.B
            r4 = -1
            r5 = 0
            r6 = 0
            if (r0 <= 0) goto L35
            android.graphics.drawable.Drawable r0 = r8.d
            if (r0 == 0) goto L1b
            r0.setVisible(r1, r1)
        L1b:
            android.graphics.drawable.Drawable r0 = r8.c
            if (r0 == 0) goto L2e
            r8.d = r0
            int r0 = r8.g
            r8.h = r0
            androidx.appcompat.b.a.d$b r0 = r8.f130a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r8.l = r0
            goto L3c
        L2e:
            r8.d = r5
            r8.h = r4
            r8.l = r6
            goto L3c
        L35:
            android.graphics.drawable.Drawable r0 = r8.c
            if (r0 == 0) goto L3c
            r0.setVisible(r1, r1)
        L3c:
            if (r9 < 0) goto L5c
            androidx.appcompat.b.a.d$b r0 = r8.f130a
            int r1 = r0.h
            if (r9 >= r1) goto L5c
            android.graphics.drawable.Drawable r0 = r0.a(r9)
            r8.c = r0
            r8.g = r9
            if (r0 == 0) goto L60
            androidx.appcompat.b.a.d$b r9 = r8.f130a
            int r9 = r9.A
            if (r9 <= 0) goto L58
            long r4 = (long) r9
            long r2 = r2 + r4
            r8.k = r2
        L58:
            r8.a(r0)
            goto L60
        L5c:
            r8.c = r5
            r8.g = r4
        L60:
            long r0 = r8.k
            r9 = 1
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L6d
            long r0 = r8.l
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 == 0) goto L7f
        L6d:
            java.lang.Runnable r0 = r8.j
            if (r0 != 0) goto L79
            androidx.appcompat.b.a.c r0 = new androidx.appcompat.b.a.c
            r0.<init>(r8)
            r8.j = r0
            goto L7c
        L79:
            r8.unscheduleSelf(r0)
        L7c:
            r8.a(r9)
        L7f:
            r8.invalidateSelf()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.d.a(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f130a.a(theme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f130a.canApplyTheme();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMutated() {
        this.f130a.b();
        this.i = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f130a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f130a.a()) {
            this.f130a.d = getChangingConfigurations();
            return this.f130a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f131b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f130a.m()) {
            return this.f130a.f();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f130a.m()) {
            return this.f130a.j();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f130a.m()) {
            return this.f130a.g();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f130a.m()) {
            return this.f130a.h();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f130a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect i = this.f130a.i();
        if (i != null) {
            rect.set(i);
            padding = (i.right | ((i.left | i.top) | i.bottom)) != 0;
        } else {
            Drawable drawable = this.c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (c()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    public void invalidateDrawable(Drawable drawable) {
        b bVar = this.f130a;
        if (bVar != null) {
            bVar.l();
        }
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f130a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.d = null;
            this.h = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f) {
                this.c.setAlpha(this.e);
            }
        }
        if (this.l != 0) {
            this.l = 0L;
            z = true;
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            b a2 = a();
            a2.n();
            a(a2);
            this.i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f130a.b(i, b());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f && this.e == i) {
            return;
        }
        this.f = true;
        this.e = i;
        Drawable drawable = this.c;
        if (drawable != null) {
            if (this.k == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        b bVar = this.f130a;
        if (bVar.C != z) {
            bVar.C = z;
            Drawable drawable = this.c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, bVar.C);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        b bVar = this.f130a;
        bVar.E = true;
        if (bVar.D != colorFilter) {
            bVar.D = colorFilter;
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        b bVar = this.f130a;
        if (bVar.x != z) {
            bVar.x = z;
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.setDither(bVar.x);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f131b;
        if (rect == null) {
            this.f131b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        b bVar = this.f130a;
        bVar.H = true;
        if (bVar.F != colorStateList) {
            bVar.F = colorStateList;
            androidx.core.graphics.drawable.a.a(this.c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f130a;
        bVar.I = true;
        if (bVar.G != mode) {
            bVar.G = mode;
            androidx.core.graphics.drawable.a.a(this.c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public static abstract class b extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final d f133a;

        /* renamed from: b  reason: collision with root package name */
        Resources f134b;
        int c;
        int d;
        int e;
        SparseArray<Drawable.ConstantState> f;
        Drawable[] g;
        int h;
        boolean i;
        boolean j;
        Rect k;
        boolean l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(b bVar, d dVar, Resources resources) {
            Resources resources2;
            this.c = 160;
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f133a = dVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = bVar != null ? bVar.f134b : null;
            }
            this.f134b = resources2;
            this.c = d.resolveDensity(resources, bVar != null ? bVar.c : 0);
            if (bVar != null) {
                this.d = bVar.d;
                this.e = bVar.e;
                this.v = true;
                this.w = true;
                this.i = bVar.i;
                this.l = bVar.l;
                this.x = bVar.x;
                this.y = bVar.y;
                this.z = bVar.z;
                this.A = bVar.A;
                this.B = bVar.B;
                this.C = bVar.C;
                this.D = bVar.D;
                this.E = bVar.E;
                this.F = bVar.F;
                this.G = bVar.G;
                this.H = bVar.H;
                this.I = bVar.I;
                if (bVar.c == this.c) {
                    if (bVar.j) {
                        this.k = new Rect(bVar.k);
                        this.j = true;
                    }
                    if (bVar.m) {
                        this.n = bVar.n;
                        this.o = bVar.o;
                        this.p = bVar.p;
                        this.q = bVar.q;
                        this.m = true;
                    }
                }
                if (bVar.r) {
                    this.s = bVar.s;
                    this.r = true;
                }
                if (bVar.t) {
                    this.u = bVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = bVar.g;
                this.g = new Drawable[drawableArr.length];
                this.h = bVar.h;
                SparseArray<Drawable.ConstantState> sparseArray = bVar.f;
                if (sparseArray != null) {
                    this.f = sparseArray.clone();
                } else {
                    this.f = new SparseArray<>(this.h);
                }
                int i = this.h;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f.put(i2, constantState);
                        } else {
                            this.g[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.g = new Drawable[10];
            this.h = 0;
        }

        private Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f133a);
            return mutate;
        }

        private void o() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.g[this.f.keyAt(i)] = b(this.f.valueAt(i).newDrawable(this.f134b));
                }
                this.f = null;
            }
        }

        public final int a(Drawable drawable) {
            int i = this.h;
            if (i >= this.g.length) {
                a(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f133a);
            this.g[i] = drawable;
            this.h++;
            this.e = drawable.getChangingConfigurations() | this.e;
            l();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return i;
        }

        protected void c() {
            this.m = true;
            o();
            int i = this.h;
            Drawable[] drawableArr = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.h;
            Drawable[] drawableArr = this.g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int d() {
            return this.g.length;
        }

        public final int e() {
            return this.h;
        }

        public final int f() {
            if (!this.m) {
                c();
            }
            return this.o;
        }

        public final int g() {
            if (!this.m) {
                c();
            }
            return this.q;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.d | this.e;
        }

        public final int h() {
            if (!this.m) {
                c();
            }
            return this.p;
        }

        public final Rect i() {
            if (this.i) {
                return null;
            }
            if (this.k == null && !this.j) {
                o();
                Rect rect = new Rect();
                int i = this.h;
                Drawable[] drawableArr = this.g;
                Rect rect2 = null;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                this.j = true;
                this.k = rect2;
                return rect2;
            }
            return this.k;
        }

        public final int j() {
            if (!this.m) {
                c();
            }
            return this.n;
        }

        public final int k() {
            if (this.r) {
                return this.s;
            }
            o();
            int i = this.h;
            Drawable[] drawableArr = this.g;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        void l() {
            this.r = false;
            this.t = false;
        }

        public final boolean m() {
            return this.l;
        }

        abstract void n();

        final boolean b(int i, int i2) {
            int i3 = this.h;
            Drawable[] drawableArr = this.g;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.z = i;
            return z;
        }

        final void b() {
            this.y = false;
        }

        public final void b(boolean z) {
            this.i = z;
        }

        public final void b(int i) {
            this.A = i;
        }

        public final Drawable a(int i) {
            int indexOfKey;
            Drawable drawable = this.g[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable b2 = b(this.f.valueAt(indexOfKey).newDrawable(this.f134b));
            this.g[i] = b2;
            this.f.removeAt(indexOfKey);
            if (this.f.size() == 0) {
                this.f = null;
            }
            return b2;
        }

        public final void c(int i) {
            this.B = i;
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.f134b = resources;
                int resolveDensity = d.resolveDensity(resources, this.c);
                int i = this.c;
                this.c = resolveDensity;
                if (i != resolveDensity) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        final void a(Resources.Theme theme) {
            if (theme != null) {
                o();
                int i = this.h;
                Drawable[] drawableArr = this.g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.e |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                a(theme.getResources());
            }
        }

        public final void a(boolean z) {
            this.l = z;
        }

        public void a(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.g, 0, drawableArr, 0, i);
            this.g = drawableArr;
        }

        public synchronized boolean a() {
            if (this.v) {
                return this.w;
            }
            o();
            this.v = true;
            int i = this.h;
            Drawable[] drawableArr = this.g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    private void a(Drawable drawable) {
        if (this.m == null) {
            this.m = new a();
        }
        a aVar = this.m;
        aVar.a(drawable.getCallback());
        drawable.setCallback(aVar);
        try {
            if (this.f130a.A <= 0 && this.f) {
                drawable.setAlpha(this.e);
            }
            if (this.f130a.E) {
                drawable.setColorFilter(this.f130a.D);
            } else {
                if (this.f130a.H) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f130a.F);
                }
                if (this.f130a.I) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f130a.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f130a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f130a.C);
            }
            Rect rect = this.f131b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.e
            r3.setAlpha(r9)
            r13.k = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.b.a.d$b r9 = r13.f130a
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.k = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.d
            if (r9 == 0) goto L68
            long r10 = r13.l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L6a
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L55
            r9.setVisible(r6, r6)
            r0 = 0
            r13.d = r0
            r0 = -1
            r13.h = r0
            r13.l = r7
            goto L6a
        L55:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.b.a.d$b r4 = r13.f130a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L6b
        L68:
            r13.l = r7
        L6a:
            r0 = r3
        L6b:
            if (r14 == 0) goto L77
            if (r0 == 0) goto L77
            java.lang.Runnable r14 = r13.j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.d.a(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Resources resources) {
        this.f130a.a(resources);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        this.f130a = bVar;
        int i = this.g;
        if (i >= 0) {
            this.c = bVar.a(i);
            Drawable drawable = this.c;
            if (drawable != null) {
                a(drawable);
            }
        }
        this.h = -1;
        this.d = null;
    }
}
