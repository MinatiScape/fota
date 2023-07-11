package androidx.appcompat.widget;
/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
class ra implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ta f355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ra(ta taVar) {
        this.f355a = taVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f355a.a(false);
    }
}
