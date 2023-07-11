package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final String[] K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> L = new C0105c(PointF.class, "boundsOrigin");
    private static final Property<a, PointF> M = new C0107d(PointF.class, "topLeft");
    private static final Property<a, PointF> N = new C0109e(PointF.class, "bottomRight");
    private static final Property<View, PointF> O = new C0111f(PointF.class, "bottomRight");
    private static final Property<View, PointF> P = new C0112g(PointF.class, "topLeft");
    private static final Property<View, PointF> Q = new C0113h(PointF.class, "position");
    private static M R = new M();
    private int[] S;
    private boolean T;
    private boolean U;

    public ChangeBounds() {
        this.S = new int[2];
        this.T = false;
        this.U = false;
    }

    private void d(ga gaVar) {
        View view = gaVar.f960b;
        if (!androidx.core.h.t.z(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        gaVar.f959a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        gaVar.f959a.put("android:changeBounds:parent", gaVar.f960b.getParent());
        if (this.U) {
            gaVar.f960b.getLocationInWindow(this.S);
            gaVar.f959a.put("android:changeBounds:windowX", Integer.valueOf(this.S[0]));
            gaVar.f959a.put("android:changeBounds:windowY", Integer.valueOf(this.S[1]));
        }
        if (this.T) {
            gaVar.f959a.put("android:changeBounds:clip", androidx.core.h.t.e(view));
        }
    }

    @Override // androidx.transition.Transition
    public void a(ga gaVar) {
        d(gaVar);
    }

    public void b(boolean z) {
        this.T = z;
    }

    @Override // androidx.transition.Transition
    public void c(ga gaVar) {
        d(gaVar);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    private boolean a(View view, View view2) {
        if (this.U) {
            ga a2 = a(view, true);
            if (a2 == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == a2.f960b) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f907a;

        /* renamed from: b  reason: collision with root package name */
        private int f908b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(PointF pointF) {
            this.f907a = Math.round(pointF.x);
            this.f908b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }

        private void a() {
            va.a(this.e, this.f907a, this.f908b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = new int[2];
        this.T = false;
        this.U = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.d);
        boolean a2 = androidx.core.content.a.i.a(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        b(a2);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        int i;
        View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator a2;
        if (gaVar == null || gaVar2 == null) {
            return null;
        }
        Map<String, Object> map = gaVar.f959a;
        Map<String, Object> map2 = gaVar2.f959a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = gaVar2.f960b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) gaVar.f959a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) gaVar2.f959a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) gaVar.f959a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) gaVar2.f959a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                if (!this.T) {
                    view = view2;
                    va.a(view, i3, i5, i7, i9);
                    if (i == 2) {
                        if (i11 == i13 && i12 == i14) {
                            a2 = J.a(view, Q, g().a(i3, i5, i4, i6));
                        } else {
                            a aVar = new a(view);
                            ObjectAnimator a3 = J.a(aVar, M, g().a(i3, i5, i4, i6));
                            ObjectAnimator a4 = J.a(aVar, N, g().a(i7, i9, i8, i10));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(a3, a4);
                            animatorSet.addListener(new C0114i(this, aVar));
                            a2 = animatorSet;
                        }
                    } else if (i3 == i4 && i5 == i6) {
                        a2 = J.a(view, O, g().a(i7, i9, i8, i10));
                    } else {
                        a2 = J.a(view, P, g().a(i3, i5, i4, i6));
                    }
                } else {
                    view = view2;
                    va.a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                    ObjectAnimator a5 = (i3 == i4 && i5 == i6) ? null : J.a(view, Q, g().a(i3, i5, i4, i6));
                    if (rect4 == null) {
                        i2 = 0;
                        rect = new Rect(0, 0, i11, i12);
                    } else {
                        i2 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        androidx.core.h.t.a(view, rect);
                        M m = R;
                        Object[] objArr = new Object[2];
                        objArr[i2] = rect;
                        objArr[1] = rect6;
                        objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", m, objArr);
                        objectAnimator.addListener(new C0115j(this, view, rect5, i4, i6, i8, i10));
                    }
                    a2 = fa.a(a5, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ma.a(viewGroup4, true);
                    a(new C0116k(this, viewGroup4));
                }
                return a2;
            }
            return null;
        }
        int intValue = ((Integer) gaVar.f959a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) gaVar.f959a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) gaVar2.f959a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) gaVar2.f959a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.S);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c = va.c(view2);
        va.a(view2, 0.0f);
        va.b(viewGroup).a(bitmapDrawable);
        PathMotion g = g();
        int[] iArr = this.S;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, L.a(L, g.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new C0103b(this, viewGroup, bitmapDrawable, view2, c));
        return ofPropertyValuesHolder;
    }
}
