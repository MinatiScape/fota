package androidx.recyclerview.widget;

import androidx.recyclerview.widget.p;
import java.util.Comparator;
/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
class o implements Comparator<p.b> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(p.b bVar, p.b bVar2) {
        if ((bVar.d == null) != (bVar2.d == null)) {
            return bVar.d == null ? 1 : -1;
        }
        boolean z = bVar.f857a;
        if (z != bVar2.f857a) {
            return z ? -1 : 1;
        }
        int i = bVar2.f858b - bVar.f858b;
        if (i != 0) {
            return i;
        }
        int i2 = bVar.c - bVar2.c;
        if (i2 != 0) {
            return i2;
        }
        return 0;
    }
}
