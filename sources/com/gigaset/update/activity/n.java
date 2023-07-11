package com.gigaset.update.activity;
/* compiled from: PopupActivity.java */
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PopupActivity popupActivity) {
        this.f1091a = popupActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1091a.finish();
    }
}
