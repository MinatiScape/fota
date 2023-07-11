package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;
/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0111f extends Property<View, PointF> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0111f(Class cls, String str) {
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
        va.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
    }
}
