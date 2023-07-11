package androidx.drawerlayout.widget;

import android.view.View;
import android.view.WindowInsets;
/* compiled from: DrawerLayout.java */
/* loaded from: classes.dex */
class a implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DrawerLayout f584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DrawerLayout drawerLayout) {
        this.f584a = drawerLayout;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((DrawerLayout) view).a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
