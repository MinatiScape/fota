package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.b;
/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String[] f422a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f423b;
    final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String[] strArr, Activity activity, int i) {
        this.f422a = strArr;
        this.f423b = activity;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.f422a.length];
        PackageManager packageManager = this.f423b.getPackageManager();
        String packageName = this.f423b.getPackageName();
        int length = this.f422a.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.f422a[i], packageName);
        }
        ((b.a) this.f423b).onRequestPermissionsResult(this.c, this.f422a, iArr);
    }
}
