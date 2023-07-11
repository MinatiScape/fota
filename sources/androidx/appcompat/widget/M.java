package androidx.appcompat.widget;
/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
class M {

    /* renamed from: a  reason: collision with root package name */
    private int f272a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f273b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public int a() {
        return this.g ? this.f272a : this.f273b;
    }

    public int b() {
        return this.f272a;
    }

    public int c() {
        return this.f273b;
    }

    public int d() {
        return this.g ? this.f273b : this.f272a;
    }

    public void a(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f272a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.f273b = i2;
        }
    }

    public void b(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f272a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f273b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f272a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f273b = i2;
        }
    }

    public void a(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.f272a = this.e;
            this.f273b = this.f;
        } else if (z) {
            int i = this.d;
            if (i == Integer.MIN_VALUE) {
                i = this.e;
            }
            this.f272a = i;
            int i2 = this.c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f;
            }
            this.f273b = i2;
        } else {
            int i3 = this.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.e;
            }
            this.f272a = i3;
            int i4 = this.d;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f;
            }
            this.f273b = i4;
        }
    }
}
