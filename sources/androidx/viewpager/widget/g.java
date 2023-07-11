package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.h.D;
import androidx.core.h.o;
import androidx.core.h.t;
/* compiled from: ViewPager.java */
/* loaded from: classes.dex */
class g implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f1043a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPager f1044b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ViewPager viewPager) {
        this.f1044b = viewPager;
    }

    @Override // androidx.core.h.o
    public D a(View view, D d) {
        D b2 = t.b(view, d);
        if (b2.g()) {
            return b2;
        }
        Rect rect = this.f1043a;
        rect.left = b2.c();
        rect.top = b2.e();
        rect.right = b2.d();
        rect.bottom = b2.b();
        int childCount = this.f1044b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            D a2 = t.a(this.f1044b.getChildAt(i), b2);
            rect.left = Math.min(a2.c(), rect.left);
            rect.top = Math.min(a2.e(), rect.top);
            rect.right = Math.min(a2.d(), rect.right);
            rect.bottom = Math.min(a2.b(), rect.bottom);
        }
        return b2.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
