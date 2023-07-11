package androidx.media;
/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(androidx.versionedparcelable.b bVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.c = (InterfaceC0084a) bVar.a((androidx.versionedparcelable.b) audioAttributesCompat.c, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, androidx.versionedparcelable.b bVar) {
        bVar.a(false, false);
        bVar.b(audioAttributesCompat.c, 1);
    }
}
