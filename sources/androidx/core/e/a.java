package androidx.core.e;

import android.util.Base64;
import java.util.List;
/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f450a;

    /* renamed from: b  reason: collision with root package name */
    private final String f451b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e;
    private final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        androidx.core.g.h.a(str);
        this.f450a = str;
        androidx.core.g.h.a(str2);
        this.f451b = str2;
        androidx.core.g.h.a(str3);
        this.c = str3;
        androidx.core.g.h.a(list);
        this.d = list;
        this.e = 0;
        this.f = this.f450a + "-" + this.f451b + "-" + this.c;
    }

    public List<List<byte[]>> a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.f450a;
    }

    public String e() {
        return this.f451b;
    }

    public String f() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f450a + ", mProviderPackage: " + this.f451b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
