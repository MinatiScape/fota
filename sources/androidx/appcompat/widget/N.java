package androidx.appcompat.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class N implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f274a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ScrollingTabContainerView f275b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.f275b = scrollingTabContainerView;
        this.f274a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f275b.smoothScrollTo(this.f274a.getLeft() - ((this.f275b.getWidth() - this.f274a.getWidth()) / 2), 0);
        this.f275b.f281b = null;
    }
}
