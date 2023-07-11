package androidx.appcompat.app;

import android.os.Message;
import android.view.View;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class View$OnClickListenerC0028c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController f92a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC0028c(AlertController alertController) {
        this.f92a = alertController;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Message obtain;
        Message message;
        Message message2;
        Message message3;
        AlertController alertController = this.f92a;
        if (view == alertController.o && (message3 = alertController.q) != null) {
            obtain = Message.obtain(message3);
        } else {
            AlertController alertController2 = this.f92a;
            if (view == alertController2.s && (message2 = alertController2.u) != null) {
                obtain = Message.obtain(message2);
            } else {
                AlertController alertController3 = this.f92a;
                obtain = (view != alertController3.w || (message = alertController3.y) == null) ? null : Message.obtain(message);
            }
        }
        if (obtain != null) {
            obtain.sendToTarget();
        }
        AlertController alertController4 = this.f92a;
        alertController4.R.obtainMessage(1, alertController4.f50b).sendToTarget();
    }
}
