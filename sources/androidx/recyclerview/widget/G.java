package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.C0067a;
/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class G extends C0067a {
    final RecyclerView c;
    final C0067a d = new a(this);

    public G(RecyclerView recyclerView) {
        this.c = recyclerView;
    }

    @Override // androidx.core.h.C0067a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (c() || this.c.getLayoutManager() == null) {
            return false;
        }
        return this.c.getLayoutManager().a(i, bundle);
    }

    @Override // androidx.core.h.C0067a
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().a(accessibilityEvent);
        }
    }

    boolean c() {
        return this.c.j();
    }

    @Override // androidx.core.h.C0067a
    public void a(View view, androidx.core.h.a.c cVar) {
        super.a(view, cVar);
        cVar.a((CharSequence) RecyclerView.class.getName());
        if (c() || this.c.getLayoutManager() == null) {
            return;
        }
        this.c.getLayoutManager().a(cVar);
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public static class a extends C0067a {
        final G c;

        public a(G g) {
            this.c = g;
        }

        @Override // androidx.core.h.C0067a
        public void a(View view, androidx.core.h.a.c cVar) {
            super.a(view, cVar);
            if (this.c.c() || this.c.c.getLayoutManager() == null) {
                return;
            }
            this.c.c.getLayoutManager().a(view, cVar);
        }

        @Override // androidx.core.h.C0067a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.c.c() || this.c.c.getLayoutManager() == null) {
                return false;
            }
            return this.c.c.getLayoutManager().a(view, i, bundle);
        }
    }

    public C0067a b() {
        return this.d;
    }
}
