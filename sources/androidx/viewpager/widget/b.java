package androidx.viewpager.widget;

import android.view.View;
/* compiled from: PagerTabStrip.java */
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PagerTabStrip f1040a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PagerTabStrip pagerTabStrip) {
        this.f1040a = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewPager viewPager = this.f1040a.c;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
}
