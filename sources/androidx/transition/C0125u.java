package androidx.transition;

import android.animation.TypeEvaluator;
/* compiled from: FloatArrayEvaluator.java */
/* renamed from: androidx.transition.u  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0125u implements TypeEvaluator<float[]> {

    /* renamed from: a  reason: collision with root package name */
    private float[] f988a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0125u(float[] fArr) {
        this.f988a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f988a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return fArr3;
    }
}
