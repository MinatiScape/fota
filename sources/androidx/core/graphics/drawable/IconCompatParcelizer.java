package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f504b = bVar.a(iconCompat.f504b, 1);
        iconCompat.d = bVar.a(iconCompat.d, 2);
        iconCompat.e = bVar.a((androidx.versionedparcelable.b) iconCompat.e, 3);
        iconCompat.f = bVar.a(iconCompat.f, 4);
        iconCompat.g = bVar.a(iconCompat.g, 5);
        iconCompat.h = (ColorStateList) bVar.a((androidx.versionedparcelable.b) iconCompat.h, 6);
        iconCompat.j = bVar.a(iconCompat.j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.b bVar) {
        bVar.a(true, true);
        iconCompat.a(bVar.c());
        bVar.b(iconCompat.f504b, 1);
        bVar.b(iconCompat.d, 2);
        bVar.b(iconCompat.e, 3);
        bVar.b(iconCompat.f, 4);
        bVar.b(iconCompat.g, 5);
        bVar.b(iconCompat.h, 6);
        bVar.b(iconCompat.j, 7);
    }
}
