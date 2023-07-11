package androidx.media;

import android.media.AudioAttributes;
/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static C0085b read(androidx.versionedparcelable.b bVar) {
        C0085b c0085b = new C0085b();
        c0085b.f724a = (AudioAttributes) bVar.a((androidx.versionedparcelable.b) c0085b.f724a, 1);
        c0085b.f725b = bVar.a(c0085b.f725b, 2);
        return c0085b;
    }

    public static void write(C0085b c0085b, androidx.versionedparcelable.b bVar) {
        bVar.a(false, false);
        bVar.b(c0085b.f724a, 1);
        bVar.b(c0085b.f725b, 2);
    }
}
