package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;
/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.g  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0112g extends Property<View, PointF> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0112g(Class cls, String str) {
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
        va.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
    }
}
