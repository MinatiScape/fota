package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;
/* compiled from: FragmentTransitionSupport.java */
/* renamed from: androidx.transition.x  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0128x implements Transition.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f996a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f997b;
    final /* synthetic */ Object c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ Object e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ C0130z g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0128x(C0130z c0130z, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = c0130z;
        this.f996a = obj;
        this.f997b = arrayList;
        this.c = obj2;
        this.d = arrayList2;
        this.e = obj3;
        this.f = arrayList3;
    }

    @Override // androidx.transition.Transition.c
    public void a(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void b(Transition transition) {
        Object obj = this.f996a;
        if (obj != null) {
            this.g.a(obj, this.f997b, (ArrayList<View>) null);
        }
        Object obj2 = this.c;
        if (obj2 != null) {
            this.g.a(obj2, this.d, (ArrayList<View>) null);
        }
        Object obj3 = this.e;
        if (obj3 != null) {
            this.g.a(obj3, this.f, (ArrayList<View>) null);
        }
    }

    @Override // androidx.transition.Transition.c
    public void c(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
    }
}
