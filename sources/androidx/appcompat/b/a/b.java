package androidx.appcompat.b.a;

import a.b.j;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.R$styleable;
import androidx.appcompat.b.a.d;
import androidx.appcompat.b.a.f;
import androidx.core.content.a.i;
import androidx.vectordrawable.a.a.k;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedStateListDrawableCompat.java */
/* loaded from: classes.dex */
public class b extends androidx.appcompat.b.a.f {
    private C0004b p;
    private f q;
    private int r;
    private int s;
    private boolean t;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f123a;

        a(Animatable animatable) {
            super();
            this.f123a = animatable;
        }

        @Override // androidx.appcompat.b.a.b.f
        public void c() {
            this.f123a.start();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void d() {
            this.f123a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004b extends f.a {
        a.b.f<Long> K;
        j<Integer> L;

        C0004b(C0004b c0004b, b bVar, Resources resources) {
            super(c0004b, bVar, resources);
            if (c0004b != null) {
                this.K = c0004b.K;
                this.L = c0004b.L;
                return;
            }
            this.K = new a.b.f<>();
            this.L = new j<>();
        }

        private static long f(int i, int i2) {
            return i2 | (i << 32);
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long f = f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = a2;
            this.K.a(f, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        int b(int[] iArr) {
            int a2 = super.a(iArr);
            return a2 >= 0 ? a2 : super.a(StateSet.WILD_CARD);
        }

        int c(int i, int i2) {
            return (int) this.K.b(f(i, i2), -1L).longValue();
        }

        int d(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.b(i, 0).intValue();
        }

        boolean e(int i, int i2) {
            return (this.K.b(f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.b.a.f.a, androidx.appcompat.b.a.d.b
        void n() {
            this.K = this.K.m0clone();
            this.L = this.L.m1clone();
        }

        @Override // androidx.appcompat.b.a.f.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this, null);
        }

        boolean d(int i, int i2) {
            return (this.K.b(f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        @Override // androidx.appcompat.b.a.f.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new b(this, resources);
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int a2 = super.a(iArr, drawable);
            this.L.c(a2, Integer.valueOf(i));
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.vectordrawable.a.a.d f124a;

        c(androidx.vectordrawable.a.a.d dVar) {
            super();
            this.f124a = dVar;
        }

        @Override // androidx.appcompat.b.a.b.f
        public void c() {
            this.f124a.start();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void d() {
            this.f124a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f125a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f126b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(eVar.a());
            ofInt.setInterpolator(eVar);
            this.f126b = z2;
            this.f125a = ofInt;
        }

        @Override // androidx.appcompat.b.a.b.f
        public boolean a() {
            return this.f126b;
        }

        @Override // androidx.appcompat.b.a.b.f
        public void b() {
            this.f125a.reverse();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void c() {
            this.f125a.start();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void d() {
            this.f125a.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        private f() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public b() {
        this(null, null);
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void d() {
        onStateChange(getState());
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = i.a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable b2 = resourceId3 > 0 ? androidx.appcompat.a.a.a.b(context, resourceId3) : null;
        boolean z = a2.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (b2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    b2 = androidx.vectordrawable.a.a.d.a(context, resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (b2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.p.a(resourceId, resourceId2, b2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = i.a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        d();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d
    public void clearMutated() {
        super.clearMutated();
        this.t = false;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.b.a.f, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.q;
        if (fVar != null) {
            fVar.d();
            this.q = null;
            a(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.n();
                this.t = true;
            }
        }
        return this;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int b2 = this.p.b(iArr);
        boolean z = b2 != b() && (b(b2) || a(b2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.q != null && (visible || z2)) {
            if (z) {
                this.q.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    b(C0004b c0004b, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        a(new C0004b(c0004b, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = i.a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable b2 = resourceId2 > 0 ? androidx.appcompat.a.a.a.b(context, resourceId2) : null;
        a2.recycle();
        int[] a3 = a(attributeSet);
        if (b2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    b2 = k.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    b2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (b2 != null) {
            return this.p.a(a3, b2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            b bVar = new b();
            bVar.b(context, resources, xmlPullParser, attributeSet, theme);
            return bVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class e implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f127a;

        /* renamed from: b  reason: collision with root package name */
        private int f128b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f128b = numberOfFrames;
            int[] iArr = this.f127a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f127a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f127a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.f128b;
            int[] iArr = this.f127a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }

        int a() {
            return this.c;
        }
    }

    private boolean b(int i) {
        int b2;
        int c2;
        f aVar;
        f fVar = this.q;
        if (fVar != null) {
            if (i == this.r) {
                return true;
            }
            if (i == this.s && fVar.a()) {
                fVar.b();
                this.r = this.s;
                this.s = i;
                return true;
            }
            b2 = this.r;
            fVar.d();
        } else {
            b2 = b();
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        C0004b c0004b = this.p;
        int d2 = c0004b.d(b2);
        int d3 = c0004b.d(i);
        if (d3 == 0 || d2 == 0 || (c2 = c0004b.c(d2, d3)) < 0) {
            return false;
        }
        boolean e2 = c0004b.e(d2, d3);
        a(c2);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            aVar = new d((AnimationDrawable) current, c0004b.d(d2, d3), e2);
        } else if (current instanceof androidx.vectordrawable.a.a.d) {
            aVar = new c((androidx.vectordrawable.a.a.d) current);
        } else {
            if (current instanceof Animatable) {
                aVar = new a((Animatable) current);
            }
            return false;
        }
        aVar.c();
        this.q = aVar;
        this.s = b2;
        this.r = i;
        return true;
    }

    private void a(TypedArray typedArray) {
        C0004b c0004b = this.p;
        if (Build.VERSION.SDK_INT >= 21) {
            c0004b.d |= typedArray.getChangingConfigurations();
        }
        c0004b.b(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, c0004b.i));
        c0004b.a(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, c0004b.l));
        c0004b.b(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, c0004b.A));
        c0004b.c(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, c0004b.B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, c0004b.x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d
    public C0004b a() {
        return new C0004b(this.p, this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d
    public void a(d.b bVar) {
        super.a(bVar);
        if (bVar instanceof C0004b) {
            this.p = (C0004b) bVar;
        }
    }
}
