package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class Slide extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private static final a O = new P();
    private static final a P = new Q();
    private static final a Q = new S();
    private static final a R = new T();
    private static final a S = new U();
    private static final a T = new V();
    private a U;
    private int V;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b implements a {
        private b() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(P p) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c implements a {
        private c() {
        }

        @Override // androidx.transition.Slide.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(P p) {
            this();
        }
    }

    public Slide() {
        this.U = T;
        this.V = 80;
        b(80);
    }

    private void e(ga gaVar) {
        int[] iArr = new int[2];
        gaVar.f960b.getLocationOnScreen(iArr);
        gaVar.f959a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void a(ga gaVar) {
        super.a(gaVar);
        e(gaVar);
    }

    public void b(int i) {
        if (i == 3) {
            this.U = O;
        } else if (i == 5) {
            this.U = R;
        } else if (i == 48) {
            this.U = Q;
        } else if (i == 80) {
            this.U = T;
        } else if (i == 8388611) {
            this.U = P;
        } else if (i == 8388613) {
            this.U = S;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.V = i;
        O o = new O();
        o.a(i);
        a(o);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void c(ga gaVar) {
        super.c(gaVar);
        e(gaVar);
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        if (gaVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) gaVar2.f959a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return ia.a(view, gaVar2, iArr[0], iArr[1], this.U.b(viewGroup, view), this.U.a(viewGroup, view), translationX, translationY, M);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = T;
        this.V = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.h);
        int b2 = androidx.core.content.a.i.b(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        b(b2);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        if (gaVar == null) {
            return null;
        }
        int[] iArr = (int[]) gaVar.f959a.get("android:slide:screenPosition");
        return ia.a(view, gaVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.U.b(viewGroup, view), this.U.a(viewGroup, view), N);
    }
}
