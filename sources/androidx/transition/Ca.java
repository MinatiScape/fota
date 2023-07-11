package androidx.transition;

import android.os.IBinder;
/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
class Ca implements Ea {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(IBinder iBinder) {
        this.f906a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Ca) && ((Ca) obj).f906a.equals(this.f906a);
    }

    public int hashCode() {
        return this.f906a.hashCode();
    }
}
