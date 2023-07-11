package androidx.fragment.app;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentActivity.java */
/* renamed from: androidx.fragment.app.g  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class HandlerC0077g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FragmentActivity f633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC0077g(FragmentActivity fragmentActivity) {
        this.f633a = fragmentActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 2) {
            super.handleMessage(message);
            return;
        }
        this.f633a.onResumeFragments();
        this.f633a.mFragments.i();
    }
}
