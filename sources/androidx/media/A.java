package androidx.media;

import android.media.session.MediaSessionManager;
/* compiled from: MediaSessionManagerImplApi28.java */
/* loaded from: classes.dex */
final class A implements z {

    /* renamed from: a  reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(String str, int i, int i2) {
        this.f705a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof A) {
            return this.f705a.equals(((A) obj).f705a);
        }
        return false;
    }

    public int hashCode() {
        return androidx.core.g.c.a(this.f705a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f705a = remoteUserInfo;
    }
}
