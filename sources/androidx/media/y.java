package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
/* compiled from: MediaSessionManager.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    z f755a;

    public y(String str, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f755a = new A(str, i, i2);
        } else {
            this.f755a = new B(str, i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.f755a.equals(((y) obj).f755a);
        }
        return false;
    }

    public int hashCode() {
        return this.f755a.hashCode();
    }

    public y(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f755a = new A(remoteUserInfo);
    }
}
