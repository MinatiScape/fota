package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.c;
/* compiled from: CircularRevealWidget.java */
/* loaded from: classes.dex */
public interface e extends c.a {

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final TypeEvaluator<d> f1322a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final d f1323b = new d();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public d evaluate(float f, d dVar, d dVar2) {
            this.f1323b.a(com.google.android.material.e.a.b(dVar.f1326a, dVar2.f1326a, f), com.google.android.material.e.a.b(dVar.f1327b, dVar2.f1327b, f), com.google.android.material.e.a.b(dVar.c, dVar2.c, f));
            return this.f1323b;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class b extends Property<e, d> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<e, d> f1324a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public d get(e eVar) {
            return eVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(e eVar, d dVar) {
            eVar.setRevealInfo(dVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class c extends Property<e, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<e, Integer> f1325a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(e eVar, Integer num) {
            eVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public float f1326a;

        /* renamed from: b  reason: collision with root package name */
        public float f1327b;
        public float c;

        public void a(float f, float f2, float f3) {
            this.f1326a = f;
            this.f1327b = f2;
            this.c = f3;
        }

        private d() {
        }

        public d(float f, float f2, float f3) {
            this.f1326a = f;
            this.f1327b = f2;
            this.c = f3;
        }

        public void a(d dVar) {
            a(dVar.f1326a, dVar.f1327b, dVar.c);
        }

        public boolean a() {
            return this.c == Float.MAX_VALUE;
        }

        public d(d dVar) {
            this(dVar.f1326a, dVar.f1327b, dVar.c);
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(d dVar);
}
