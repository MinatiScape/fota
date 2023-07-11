package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.g;
/* compiled from: SnackbarManager.java */
/* loaded from: classes.dex */
class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar) {
        this.f1401a = gVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.f1401a.a((g.b) message.obj);
        return true;
    }
}
