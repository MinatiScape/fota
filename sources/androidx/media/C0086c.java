package androidx.media;

import java.util.Arrays;
/* compiled from: AudioAttributesImplBase.java */
/* renamed from: androidx.media.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0086c implements InterfaceC0084a {

    /* renamed from: a  reason: collision with root package name */
    int f726a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f727b = 0;
    int c = 0;
    int d = -1;

    public int a() {
        return this.f727b;
    }

    public int b() {
        int i = this.c;
        int c = c();
        if (c == 6) {
            i |= 4;
        } else if (c == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int c() {
        int i = this.d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.c, this.f726a);
    }

    public int d() {
        return this.f726a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0086c) {
            C0086c c0086c = (C0086c) obj;
            return this.f727b == c0086c.a() && this.c == c0086c.b() && this.f726a == c0086c.d() && this.d == c0086c.d;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f727b), Integer.valueOf(this.c), Integer.valueOf(this.f726a), Integer.valueOf(this.d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f726a));
        sb.append(" content=");
        sb.append(this.f727b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }
}
