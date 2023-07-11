package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
/* compiled from: MatrixEvaluator.java */
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1239a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1240b = new float[9];
    private final Matrix c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f1239a);
        matrix2.getValues(this.f1240b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f1240b;
            float f2 = fArr[i];
            float[] fArr2 = this.f1239a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.c.setValues(this.f1240b);
        return this.c;
    }
}
