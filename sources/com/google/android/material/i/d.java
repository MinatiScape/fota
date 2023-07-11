package com.google.android.material.i;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f1355a;

    /* renamed from: b  reason: collision with root package name */
    public float f1356b;
    public float c;
    public float d;
    private final List<c> e = new ArrayList();

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        private static final RectF f1357b = new RectF();
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;

        public a(float f, float f2, float f3, float f4) {
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
        }

        @Override // com.google.android.material.i.d.c
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1359a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f1357b.set(this.c, this.d, this.e, this.f);
            path.arcTo(f1357b, this.g, this.h, false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        private float f1358b;
        private float c;

        @Override // com.google.android.material.i.d.c
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1359a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1358b, this.c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f1359a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public d() {
        b(0.0f, 0.0f);
    }

    public void a(float f, float f2) {
        b bVar = new b();
        bVar.f1358b = f;
        bVar.c = f2;
        this.e.add(bVar);
        this.c = f;
        this.d = f2;
    }

    public void b(float f, float f2) {
        this.f1355a = f;
        this.f1356b = f2;
        this.c = f;
        this.d = f2;
        this.e.clear();
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        a aVar = new a(f, f2, f3, f4);
        aVar.g = f5;
        aVar.h = f6;
        this.e.add(aVar);
        double d = f5 + f6;
        this.c = ((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d))));
        this.d = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(matrix, path);
        }
    }
}
