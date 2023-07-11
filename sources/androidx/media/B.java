package androidx.media;

import android.text.TextUtils;
/* compiled from: MediaSessionManagerImplBase.java */
/* loaded from: classes.dex */
class B implements z {

    /* renamed from: a  reason: collision with root package name */
    private String f708a;

    /* renamed from: b  reason: collision with root package name */
    private int f709b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(String str, int i, int i2) {
        this.f708a = str;
        this.f709b = i;
        this.c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof B) {
            B b2 = (B) obj;
            return TextUtils.equals(this.f708a, b2.f708a) && this.f709b == b2.f709b && this.c == b2.c;
        }
        return false;
    }

    public int hashCode() {
        return androidx.core.g.c.a(this.f708a, Integer.valueOf(this.f709b), Integer.valueOf(this.c));
    }
}
