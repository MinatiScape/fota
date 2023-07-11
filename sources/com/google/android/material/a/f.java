package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
/* compiled from: ImageMatrixProperty.java */
/* loaded from: classes.dex */
public class f extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f1238a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f1238a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.f1238a.set(imageView.getImageMatrix());
        return this.f1238a;
    }
}
