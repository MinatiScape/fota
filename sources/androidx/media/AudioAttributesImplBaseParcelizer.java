package androidx.media;
/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static C0086c read(androidx.versionedparcelable.b bVar) {
        C0086c c0086c = new C0086c();
        c0086c.f726a = bVar.a(c0086c.f726a, 1);
        c0086c.f727b = bVar.a(c0086c.f727b, 2);
        c0086c.c = bVar.a(c0086c.c, 3);
        c0086c.d = bVar.a(c0086c.d, 4);
        return c0086c;
    }

    public static void write(C0086c c0086c, androidx.versionedparcelable.b bVar) {
        bVar.a(false, false);
        bVar.b(c0086c.f726a, 1);
        bVar.b(c0086c.f727b, 2);
        bVar.b(c0086c.c, 3);
        bVar.b(c0086c.d, 4);
    }
}
