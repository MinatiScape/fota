package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;
/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.h  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0113h extends Property<View, PointF> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0113h(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(View view, PointF pointF) {
        int round = Math.round(pointF.x);
        int round2 = Math.round(pointF.y);
        va.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
    }
}
