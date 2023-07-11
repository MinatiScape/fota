package androidx.appcompat.d;

import android.view.animation.Interpolator;
import androidx.core.h.A;
import androidx.core.h.B;
import androidx.core.h.z;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class i {
    private Interpolator c;
    A d;
    private boolean e;

    /* renamed from: b  reason: collision with root package name */
    private long f153b = -1;
    private final B f = new h(this);

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<z> f152a = new ArrayList<>();

    public i a(z zVar) {
        if (!this.e) {
            this.f152a.add(zVar);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            return;
        }
        Iterator<z> it = this.f152a.iterator();
        while (it.hasNext()) {
            z next = it.next();
            long j = this.f153b;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                next.a(interpolator);
            }
            if (this.d != null) {
                next.a(this.f);
            }
            next.c();
        }
        this.e = true;
    }

    public i a(z zVar, z zVar2) {
        this.f152a.add(zVar);
        zVar2.b(zVar.b());
        this.f152a.add(zVar2);
        return this;
    }

    public void a() {
        if (this.e) {
            Iterator<z> it = this.f152a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.e = false;
        }
    }

    public i a(long j) {
        if (!this.e) {
            this.f153b = j;
        }
        return this;
    }

    public i a(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public i a(A a2) {
        if (!this.e) {
            this.d = a2;
        }
        return this;
    }
}
