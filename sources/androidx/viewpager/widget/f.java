package androidx.viewpager.widget;
/* compiled from: ViewPager.java */
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewPager f1042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ViewPager viewPager) {
        this.f1042a = viewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1042a.setScrollState(0);
        this.f1042a.e();
    }
}
