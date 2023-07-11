package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* compiled from: AudioAttributesImplApi21.java */
@TargetApi(21)
/* renamed from: androidx.media.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0085b implements InterfaceC0084a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f724a;

    /* renamed from: b  reason: collision with root package name */
    int f725b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof C0085b) {
            return this.f724a.equals(((C0085b) obj).f724a);
        }
        return false;
    }

    public int hashCode() {
        return this.f724a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f724a;
    }
}
