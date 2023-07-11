package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.C0101a;
import androidx.transition.Transition;
/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int L;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements Transition.c, C0101a.InterfaceC0024a {

        /* renamed from: a  reason: collision with root package name */
        private final View f935a;

        /* renamed from: b  reason: collision with root package name */
        private final int f936b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;

        a(View view, int i, boolean z) {
            this.f935a = view;
            this.f936b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            a(true);
        }

        @Override // androidx.transition.Transition.c
        public void a(Transition transition) {
            a(true);
        }

        @Override // androidx.transition.Transition.c
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void c(Transition transition) {
            a(false);
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            a();
            transition.b(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.C0101a.InterfaceC0024a
        public void onAnimationPause(Animator animator) {
            if (this.f) {
                return;
            }
            va.a(this.f935a, this.f936b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.C0101a.InterfaceC0024a
        public void onAnimationResume(Animator animator) {
            if (this.f) {
                return;
            }
            va.a(this.f935a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        private void a() {
            if (!this.f) {
                va.a(this.f935a, this.f936b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.d || this.e == z || (viewGroup = this.c) == null) {
                return;
            }
            this.e = z;
            ma.a(viewGroup, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f937a;

        /* renamed from: b  reason: collision with root package name */
        boolean f938b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

    public Visibility() {
        this.L = 3;
    }

    private b b(ga gaVar, ga gaVar2) {
        b bVar = new b();
        bVar.f937a = false;
        bVar.f938b = false;
        if (gaVar != null && gaVar.f959a.containsKey("android:visibility:visibility")) {
            bVar.c = ((Integer) gaVar.f959a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) gaVar.f959a.get("android:visibility:parent");
        } else {
            bVar.c = -1;
            bVar.e = null;
        }
        if (gaVar2 != null && gaVar2.f959a.containsKey("android:visibility:visibility")) {
            bVar.d = ((Integer) gaVar2.f959a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) gaVar2.f959a.get("android:visibility:parent");
        } else {
            bVar.d = -1;
            bVar.f = null;
        }
        if (gaVar != null && gaVar2 != null) {
            if (bVar.c == bVar.d && bVar.e == bVar.f) {
                return bVar;
            }
            int i = bVar.c;
            int i2 = bVar.d;
            if (i != i2) {
                if (i == 0) {
                    bVar.f938b = false;
                    bVar.f937a = true;
                } else if (i2 == 0) {
                    bVar.f938b = true;
                    bVar.f937a = true;
                }
            } else if (bVar.f == null) {
                bVar.f938b = false;
                bVar.f937a = true;
            } else if (bVar.e == null) {
                bVar.f938b = true;
                bVar.f937a = true;
            }
        } else if (gaVar == null && bVar.d == 0) {
            bVar.f938b = true;
            bVar.f937a = true;
        } else if (gaVar2 == null && bVar.c == 0) {
            bVar.f938b = false;
            bVar.f937a = true;
        }
        return bVar;
    }

    private void d(ga gaVar) {
        gaVar.f959a.put("android:visibility:visibility", Integer.valueOf(gaVar.f960b.getVisibility()));
        gaVar.f959a.put("android:visibility:parent", gaVar.f960b.getParent());
        int[] iArr = new int[2];
        gaVar.f960b.getLocationOnScreen(iArr);
        gaVar.f959a.put("android:visibility:screenLocation", iArr);
    }

    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        return null;
    }

    public void a(int i) {
        if ((i & (-4)) == 0) {
            this.L = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        return null;
    }

    @Override // androidx.transition.Transition
    public void c(ga gaVar) {
        d(gaVar);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    public int q() {
        return this.L;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.e);
        int b2 = androidx.core.content.a.i.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (b2 != 0) {
            a(b2);
        }
    }

    @Override // androidx.transition.Transition
    public void a(ga gaVar) {
        d(gaVar);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        b b2 = b(gaVar, gaVar2);
        if (b2.f937a) {
            if (b2.e == null && b2.f == null) {
                return null;
            }
            if (b2.f938b) {
                return a(viewGroup, gaVar, b2.c, gaVar2, b2.d);
            }
            return b(viewGroup, gaVar, b2.c, gaVar2, b2.d);
        }
        return null;
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, int i, ga gaVar2, int i2) {
        if ((this.L & 1) != 1 || gaVar2 == null) {
            return null;
        }
        if (gaVar == null) {
            View view = (View) gaVar2.f960b.getParent();
            if (b(a(view, false), b(view, false)).f937a) {
                return null;
            }
        }
        return a(viewGroup, gaVar2.f960b, gaVar, gaVar2);
    }

    @Override // androidx.transition.Transition
    public boolean a(ga gaVar, ga gaVar2) {
        if (gaVar == null && gaVar2 == null) {
            return false;
        }
        if (gaVar == null || gaVar2 == null || gaVar2.f959a.containsKey("android:visibility:visibility") == gaVar.f959a.containsKey("android:visibility:visibility")) {
            b b2 = b(gaVar, gaVar2);
            if (b2.f937a) {
                return b2.c == 0 || b2.d == 0;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator b(android.view.ViewGroup r7, androidx.transition.ga r8, int r9, androidx.transition.ga r10, int r11) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.b(android.view.ViewGroup, androidx.transition.ga, int, androidx.transition.ga, int):android.animation.Animator");
    }
}
