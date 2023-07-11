package androidx.appcompat.app;

import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f113a = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f113a;
        if ((appCompatDelegateImpl.P & 1) != 0) {
            appCompatDelegateImpl.f(0);
        }
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.f113a;
        if ((appCompatDelegateImpl2.P & CpioConstants.C_ISFIFO) != 0) {
            appCompatDelegateImpl2.f(108);
        }
        AppCompatDelegateImpl appCompatDelegateImpl3 = this.f113a;
        appCompatDelegateImpl3.O = false;
        appCompatDelegateImpl3.P = 0;
    }
}
