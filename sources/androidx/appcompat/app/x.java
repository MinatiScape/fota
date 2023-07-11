package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegateImpl;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class x extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl.e f121a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(AppCompatDelegateImpl.e eVar) {
        this.f121a = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f121a.b();
    }
}
