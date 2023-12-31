package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
/* compiled from: RectEvaluator.java */
/* loaded from: classes.dex */
class M implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f924a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left;
        int i2 = i + ((int) ((rect2.left - i) * f));
        int i3 = rect.top;
        int i4 = i3 + ((int) ((rect2.top - i3) * f));
        int i5 = rect.right;
        int i6 = i5 + ((int) ((rect2.right - i5) * f));
        int i7 = rect.bottom;
        int i8 = i7 + ((int) ((rect2.bottom - i7) * f));
        Rect rect3 = this.f924a;
        if (rect3 == null) {
            return new Rect(i2, i4, i6, i8);
        }
        rect3.set(i2, i4, i6, i8);
        return this.f924a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(Rect rect) {
        this.f924a = rect;
    }
}
