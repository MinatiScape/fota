package androidx.vectordrawable.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class d extends i implements androidx.vectordrawable.a.a.b {

    /* renamed from: b  reason: collision with root package name */
    private a f1004b;
    private Context c;
    private ArgbEvaluator d;
    private Animator.AnimatorListener e;
    ArrayList<Object> f;
    final Drawable.Callback mCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f1005a;

        /* renamed from: b  reason: collision with root package name */
        k f1006b;
        AnimatorSet c;
        ArrayList<Animator> d;
        a.b.b<Animator, String> e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f1005a = aVar.f1005a;
                k kVar = aVar.f1006b;
                if (kVar != null) {
                    Drawable.ConstantState constantState = kVar.getConstantState();
                    if (resources != null) {
                        this.f1006b = (k) constantState.newDrawable(resources);
                    } else {
                        this.f1006b = (k) constantState.newDrawable();
                    }
                    k kVar2 = this.f1006b;
                    kVar2.mutate();
                    this.f1006b = kVar2;
                    this.f1006b.setCallback(callback);
                    this.f1006b.setBounds(aVar.f1006b.getBounds());
                    this.f1006b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList<>(size);
                    this.e = new a.b.b<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.d.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.e.get(animator);
                        clone.setTarget(this.f1006b.a(str));
                        this.d.add(clone);
                        this.e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1005a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    d() {
        this(null, null, null);
    }

    public static d a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        d dVar = new d(context);
        dVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return dVar;
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.a(drawable);
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
        this.f1004b.f1006b.draw(canvas);
        if (this.f1004b.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.c(drawable);
        }
        return this.f1004b.f1006b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f1004b.f1005a;
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f1012a;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(drawable.getConstantState());
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
        return this.f1004b.f1006b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f1004b.f1006b.getIntrinsicWidth();
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
        return this.f1004b.f1006b.getOpacity();
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
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        k a3 = k.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.mCallback);
                        k kVar = this.f1004b.f1006b;
                        if (kVar != null) {
                            kVar.setCallback(null);
                        }
                        this.f1004b.f1006b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.a.a.a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.c;
                        if (context != null) {
                            a(string, f.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f1004b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.f(drawable);
        }
        return this.f1004b.f1006b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f1004b.c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f1004b.f1006b.isStateful();
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
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f1004b.f1006b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.a.a.i, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f1004b.f1006b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f1004b.f1006b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f1004b.f1006b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f1004b.f1006b.setAutoMirrored(z);
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
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
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
            this.f1004b.f1006b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        } else {
            this.f1004b.f1006b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        } else {
            this.f1004b.f1006b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f1004b.f1006b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f1004b.c.isStarted()) {
        } else {
            this.f1004b.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f1004b.c.end();
        }
    }

    private d(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1012a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1004b.f1006b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f1007a;

        public b(Drawable.ConstantState constantState) {
            this.f1007a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1007a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1007a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            d dVar = new d();
            dVar.f1012a = this.f1007a.newDrawable();
            dVar.f1012a.setCallback(dVar.mCallback);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            d dVar = new d();
            dVar.f1012a = this.f1007a.newDrawable(resources);
            dVar.f1012a.setCallback(dVar.mCallback);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            dVar.f1012a = this.f1007a.newDrawable(resources, theme);
            dVar.f1012a.setCallback(dVar.mCallback);
            return dVar;
        }
    }

    private d(Context context, a aVar, Resources resources) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.mCallback = new c(this);
        this.c = context;
        if (aVar != null) {
            this.f1004b = aVar;
        } else {
            this.f1004b = new a(context, aVar, this.mCallback, resources);
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.d == null) {
                    this.d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.d);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f1004b.f1006b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        a aVar = this.f1004b;
        if (aVar.d == null) {
            aVar.d = new ArrayList<>();
            this.f1004b.e = new a.b.b<>();
        }
        this.f1004b.d.add(animator);
        this.f1004b.e.put(animator, str);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
