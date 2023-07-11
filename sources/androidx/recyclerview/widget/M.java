package androidx.recyclerview.widget;

import android.view.View;
/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
class M {

    /* renamed from: a  reason: collision with root package name */
    final b f772a;

    /* renamed from: b  reason: collision with root package name */
    a f773b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(b bVar) {
        this.f772a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f772a.a();
        int b2 = this.f772a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f772a.a(i);
            this.f773b.a(a2, b2, this.f772a.a(a3), this.f772a.b(a3));
            if (i3 != 0) {
                this.f773b.b();
                this.f773b.a(i3);
                if (this.f773b.a()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f773b.b();
                this.f773b.a(i4);
                if (this.f773b.a()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f774a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f775b;
        int c;
        int d;
        int e;

        a() {
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void a(int i, int i2, int i3, int i4) {
            this.f775b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        void b() {
            this.f774a = 0;
        }

        void a(int i) {
            this.f774a = i | this.f774a;
        }

        boolean a() {
            int i = this.f774a;
            if ((i & 7) == 0 || (i & (a(this.d, this.f775b) << 0)) != 0) {
                int i2 = this.f774a;
                if ((i2 & 112) == 0 || (i2 & (a(this.d, this.c) << 4)) != 0) {
                    int i3 = this.f774a;
                    if ((i3 & 1792) == 0 || (i3 & (a(this.e, this.f775b) << 8)) != 0) {
                        int i4 = this.f774a;
                        return (i4 & 28672) == 0 || (i4 & (a(this.e, this.c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f773b.a(this.f772a.a(), this.f772a.b(), this.f772a.a(view), this.f772a.b(view));
        if (i != 0) {
            this.f773b.b();
            this.f773b.a(i);
            return this.f773b.a();
        }
        return false;
    }
}
