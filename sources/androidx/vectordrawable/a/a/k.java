package androidx.vectordrawable.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.a.b;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class k extends i {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private g f1013b;
    private PorterDuffColorFilter c;
    private ColorFilter d;
    private boolean e;
    private boolean f;
    private Drawable.ConstantState g;
    private final float[] h;
    private final Matrix i;
    private final Rect j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class a extends e {
        public a() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.a.i.a(xmlPullParser, "pathData")) {
                TypedArray a2 = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.d);
                a(a2);
                a2.recycle();
            }
        }

        @Override // androidx.vectordrawable.a.a.k.e
        public boolean b() {
            return true;
        }

        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1017b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f1016a = androidx.core.a.b.a(string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class d {
        private d() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f1020a;

        /* renamed from: b  reason: collision with root package name */
        f f1021b;
        ColorStateList c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.c = null;
            this.d = k.DEFAULT_TINT_MODE;
            if (gVar != null) {
                this.f1020a = gVar.f1020a;
                this.f1021b = new f(gVar.f1021b);
                Paint paint = gVar.f1021b.f;
                if (paint != null) {
                    this.f1021b.f = new Paint(paint);
                }
                Paint paint2 = gVar.f1021b.e;
                if (paint2 != null) {
                    this.f1021b.e = new Paint(paint2);
                }
                this.c = gVar.c;
                this.d = gVar.d;
                this.e = gVar.e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.f1021b.getRootAlpha() < 255;
        }

        public void c(int i, int i2) {
            this.f.eraseColor(0);
            this.f1021b.a(new Canvas(this.f), i, i2, (ColorFilter) null);
        }

        public void d() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.f1021b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1020a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new k(this);
        }

        public void b(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new k(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (b() || colorFilter != null) {
                if (this.l == null) {
                    this.l = new Paint();
                    this.l.setFilterBitmap(true);
                }
                this.l.setAlpha(this.f1021b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean c() {
            return this.f1021b.a();
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean a() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.f1021b.getRootAlpha();
        }

        public g() {
            this.c = null;
            this.d = k.DEFAULT_TINT_MODE;
            this.f1021b = new f();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f1021b.a(iArr);
            this.k |= a2;
            return a2;
        }
    }

    k() {
        this.f = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1013b = new g();
    }

    public static k createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        k kVar = new k();
        kVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f1013b.f1021b.q.get(str);
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable);
            return false;
        }
        return false;
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.j);
        if (this.j.width() <= 0 || this.j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.d;
        if (colorFilter == null) {
            colorFilter = this.c;
        }
        canvas.getMatrix(this.i);
        this.i.getValues(this.h);
        float abs = Math.abs(this.h[0]);
        float abs2 = Math.abs(this.h[4]);
        float abs3 = Math.abs(this.h[1]);
        float abs4 = Math.abs(this.h[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.j.width() * abs));
        int min2 = Math.min(2048, (int) (this.j.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.j;
        canvas.translate(rect.left, rect.top);
        if (a()) {
            canvas.translate(this.j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.j.offsetTo(0, 0);
        this.f1013b.b(min, min2);
        if (!this.f) {
            this.f1013b.c(min, min2);
        } else if (!this.f1013b.a()) {
            this.f1013b.c(min, min2);
            this.f1013b.d();
        }
        this.f1013b.a(canvas, colorFilter, this.j);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.c(drawable);
        }
        return this.f1013b.f1021b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f1013b.getChangingConfigurations();
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f1012a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new h(drawable.getConstantState());
        }
        this.f1013b.f1020a = getChangingConfigurations();
        return this.f1013b;
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f1013b.f1021b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f1013b.f1021b.j;
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.f(drawable);
        }
        return this.f1013b.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        g gVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((gVar = this.f1013b) != null && (gVar.c() || ((colorStateList = this.f1013b.c) != null && colorStateList.isStateful())));
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.e && super.mutate() == this) {
            this.f1013b = new g(this.f1013b);
            this.e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f1013b;
        ColorStateList colorStateList = gVar.c;
        if (colorStateList != null && (mode = gVar.d) != null) {
            this.c = updateTintFilter(this.c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (gVar.c() && gVar.a(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f1013b.f1021b.getRootAlpha() != i) {
            this.f1013b.f1021b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f1013b.e = z;
        }
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            return;
        }
        g gVar = this.f1013b;
        if (gVar.c != colorStateList) {
            gVar.c = colorStateList;
            this.c = updateTintFilter(this.c, colorStateList, gVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
            return;
        }
        g gVar = this.f1013b;
        if (gVar.d != mode) {
            gVar.d = mode;
            this.c = updateTintFilter(this.c, gVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e extends d {

        /* renamed from: a  reason: collision with root package name */
        protected b.C0006b[] f1016a;

        /* renamed from: b  reason: collision with root package name */
        String f1017b;
        int c;

        public e() {
            super();
            this.f1016a = null;
        }

        public void a(Path path) {
            path.reset();
            b.C0006b[] c0006bArr = this.f1016a;
            if (c0006bArr != null) {
                b.C0006b.a(c0006bArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public b.C0006b[] getPathData() {
            return this.f1016a;
        }

        public String getPathName() {
            return this.f1017b;
        }

        public void setPathData(b.C0006b[] c0006bArr) {
            if (!androidx.core.a.b.a(this.f1016a, c0006bArr)) {
                this.f1016a = androidx.core.a.b.a(c0006bArr);
            } else {
                androidx.core.a.b.b(this.f1016a, c0006bArr);
            }
        }

        public e(e eVar) {
            super();
            this.f1016a = null;
            this.f1017b = eVar.f1017b;
            this.c = eVar.c;
            this.f1016a = androidx.core.a.b.a(eVar.f1016a);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f1022a;

        public h(Drawable.ConstantState constantState) {
            this.f1022a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1022a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1022a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            k kVar = new k();
            kVar.f1012a = (VectorDrawable) this.f1022a.newDrawable();
            return kVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            k kVar = new k();
            kVar.f1012a = (VectorDrawable) this.f1022a.newDrawable(resources);
            return kVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            k kVar = new k();
            kVar.f1012a = (VectorDrawable) this.f1022a.newDrawable(resources, theme);
            return kVar;
        }
    }

    public static k a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            k kVar = new k();
            kVar.f1012a = androidx.core.content.a.h.a(resources, i, theme);
            kVar.g = new h(kVar.f1012a.getConstantState());
            return kVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.d = colorFilter;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends e {
        private int[] d;
        androidx.core.content.a.b e;
        float f;
        androidx.core.content.a.b g;
        float h;
        int i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        public b() {
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.g.a();
        }

        float getStrokeAlpha() {
            return this.h;
        }

        int getStrokeColor() {
            return this.e.a();
        }

        float getStrokeWidth() {
            return this.f;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f) {
            this.j = f;
        }

        void setFillColor(int i) {
            this.g.b(i);
        }

        void setStrokeAlpha(float f) {
            this.h = f;
        }

        void setStrokeColor(int i) {
            this.e.b(i);
        }

        void setStrokeWidth(float f) {
            this.f = f;
        }

        void setTrimPathEnd(float f) {
            this.l = f;
        }

        void setTrimPathOffset(float f) {
            this.m = f;
        }

        void setTrimPathStart(float f) {
            this.k = f;
        }

        private Paint.Join a(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.d = null;
            if (androidx.core.content.a.i.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f1017b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f1016a = androidx.core.a.b.a(string2);
                }
                this.g = androidx.core.content.a.i.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = androidx.core.content.a.i.a(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a(androidx.core.content.a.i.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(androidx.core.content.a.i.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = androidx.core.content.a.i.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.e = androidx.core.content.a.i.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.h = androidx.core.content.a.i.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f = androidx.core.content.a.i.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f);
                this.l = androidx.core.content.a.i.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = androidx.core.content.a.i.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = androidx.core.content.a.i.a(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = androidx.core.content.a.i.b(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        public b(b bVar) {
            super(bVar);
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.h = bVar.h;
            this.g = bVar.g;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
        }

        @Override // androidx.vectordrawable.a.a.k.d
        public boolean a() {
            return this.g.d() || this.e.d();
        }

        @Override // androidx.vectordrawable.a.a.k.d
        public boolean a(int[] iArr) {
            return this.e.a(iArr) | this.g.a(iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends d {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f1014a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<d> f1015b;
        float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public c(c cVar, a.b.b<String, Object> bVar) {
            super();
            e aVar;
            this.f1014a = new Matrix();
            this.f1015b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.l = cVar.l;
            this.m = cVar.m;
            this.k = cVar.k;
            String str = this.m;
            if (str != null) {
                bVar.put(str, this);
            }
            this.j.set(cVar.j);
            ArrayList<d> arrayList = cVar.f1015b;
            for (int i = 0; i < arrayList.size(); i++) {
                d dVar = arrayList.get(i);
                if (dVar instanceof c) {
                    this.f1015b.add(new c((c) dVar, bVar));
                } else {
                    if (dVar instanceof b) {
                        aVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        aVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f1015b.add(aVar);
                    String str2 = aVar.f1017b;
                    if (str2 != null) {
                        bVar.put(str2, aVar);
                    }
                }
            }
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.f1002b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.d) {
                this.d = f;
                b();
            }
        }

        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                b();
            }
        }

        public void setRotation(float f) {
            if (f != this.c) {
                this.c = f;
                b();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                b();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                b();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                b();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                b();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = androidx.core.content.a.i.a(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = androidx.core.content.a.i.a(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = androidx.core.content.a.i.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = androidx.core.content.a.i.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = androidx.core.content.a.i.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        @Override // androidx.vectordrawable.a.a.k.d
        public boolean a() {
            for (int i = 0; i < this.f1015b.size(); i++) {
                if (this.f1015b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.a.a.k.d
        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f1015b.size(); i++) {
                z |= this.f1015b.get(i).a(iArr);
            }
            return z;
        }

        public c() {
            super();
            this.f1014a = new Matrix();
            this.f1015b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f1013b;
        gVar.f1021b = new f();
        TypedArray a2 = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.f1001a);
        a(a2, xmlPullParser);
        a2.recycle();
        gVar.f1020a = getChangingConfigurations();
        gVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.c = updateTintFilter(this.c, gVar.c, gVar.d);
    }

    k(g gVar) {
        this.f = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f1013b = gVar;
        this.c = updateTintFilter(this.c, gVar.c, gVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private static final Matrix f1018a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final Path f1019b;
        private final Path c;
        private final Matrix d;
        Paint e;
        Paint f;
        private PathMeasure g;
        private int h;
        final c i;
        float j;
        float k;
        float l;
        float m;
        int n;
        String o;
        Boolean p;
        final a.b.b<String, Object> q;

        public f() {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.b.b<>();
            this.i = new c();
            this.f1019b = new Path();
            this.c = new Path();
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f1014a.set(matrix);
            cVar.f1014a.preConcat(cVar.j);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f1015b.size(); i3++) {
                d dVar = cVar.f1015b.get(i3);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f1014a, canvas, i, i2, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.n = i;
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.i, f1018a, canvas, i, i2, colorFilter);
        }

        public f(f fVar) {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.b.b<>();
            this.i = new c(fVar.i, this.q);
            this.f1019b = new Path(fVar.f1019b);
            this.c = new Path(fVar.c);
            this.j = fVar.j;
            this.k = fVar.k;
            this.l = fVar.l;
            this.m = fVar.m;
            this.h = fVar.h;
            this.n = fVar.n;
            this.o = fVar.o;
            String str = fVar.o;
            if (str != null) {
                this.q.put(str, this);
            }
            this.p = fVar.p;
        }

        private void a(c cVar, e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.l;
            float f2 = i2 / this.m;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.f1014a;
            this.d.set(matrix);
            this.d.postScale(f, f2);
            float a2 = a(matrix);
            if (a2 == 0.0f) {
                return;
            }
            eVar.a(this.f1019b);
            Path path = this.f1019b;
            this.c.reset();
            if (eVar.b()) {
                this.c.addPath(path, this.d);
                canvas.clipPath(this.c);
                return;
            }
            b bVar = (b) eVar;
            if (bVar.k != 0.0f || bVar.l != 1.0f) {
                float f3 = bVar.k;
                float f4 = bVar.m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (bVar.l + f4) % 1.0f;
                if (this.g == null) {
                    this.g = new PathMeasure();
                }
                this.g.setPath(this.f1019b, false);
                float length = this.g.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.g.getSegment(f7, length, path, true);
                    this.g.getSegment(0.0f, f8, path, true);
                } else {
                    this.g.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.c.addPath(path, this.d);
            if (bVar.g.e()) {
                androidx.core.content.a.b bVar2 = bVar.g;
                if (this.f == null) {
                    this.f = new Paint(1);
                    this.f.setStyle(Paint.Style.FILL);
                }
                Paint paint = this.f;
                if (bVar2.c()) {
                    Shader b2 = bVar2.b();
                    b2.setLocalMatrix(this.d);
                    paint.setShader(b2);
                    paint.setAlpha(Math.round(bVar.j * 255.0f));
                } else {
                    paint.setColor(k.a(bVar2.a(), bVar.j));
                }
                paint.setColorFilter(colorFilter);
                this.c.setFillType(bVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.c, paint);
            }
            if (bVar.e.e()) {
                androidx.core.content.a.b bVar3 = bVar.e;
                if (this.e == null) {
                    this.e = new Paint(1);
                    this.e.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.e;
                Paint.Join join = bVar.o;
                if (join != null) {
                    paint2.setStrokeJoin(join);
                }
                Paint.Cap cap = bVar.n;
                if (cap != null) {
                    paint2.setStrokeCap(cap);
                }
                paint2.setStrokeMiter(bVar.p);
                if (bVar3.c()) {
                    Shader b3 = bVar3.b();
                    b3.setLocalMatrix(this.d);
                    paint2.setShader(b3);
                    paint2.setAlpha(Math.round(bVar.h * 255.0f));
                } else {
                    paint2.setColor(k.a(bVar3.a(), bVar.h));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(bVar.f * min * a2);
                canvas.drawPath(this.c, paint2);
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.i.a());
            }
            return this.p.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.i.a(iArr);
        }
    }

    static int a(int i, float f2) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f2)) << 24);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        g gVar = this.f1013b;
        f fVar = gVar.f1021b;
        gVar.d = a(androidx.core.content.a.i.b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            gVar.c = colorStateList;
        }
        gVar.e = androidx.core.content.a.i.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.e);
        fVar.l = androidx.core.content.a.i.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.l);
        fVar.m = androidx.core.content.a.i.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.m);
        if (fVar.l > 0.0f) {
            if (fVar.m > 0.0f) {
                fVar.j = typedArray.getDimension(3, fVar.j);
                fVar.k = typedArray.getDimension(2, fVar.k);
                if (fVar.j > 0.0f) {
                    if (fVar.k > 0.0f) {
                        fVar.setAlpha(androidx.core.content.a.i.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            fVar.o = string;
                            fVar.q.put(string, fVar);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = this.f1013b;
        f fVar = gVar.f1021b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1015b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.q.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f1020a = bVar.c | gVar.f1020a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1015b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.q.put(aVar.getPathName(), aVar);
                    }
                    gVar.f1020a = aVar.c | gVar.f1020a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1015b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.q.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f1020a = cVar2.k | gVar.f1020a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f = z;
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }
}
