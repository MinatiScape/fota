package androidx.viewpager.widget;

import android.view.View;
/* compiled from: PagerTabStrip.java */
/* loaded from: classes.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PagerTabStrip f1041a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PagerTabStrip pagerTabStrip) {
        this.f1041a = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewPager viewPager = this.f1041a.c;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }
}
