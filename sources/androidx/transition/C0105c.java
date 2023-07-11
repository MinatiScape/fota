package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0105c extends Property<Drawable, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0105c(Class cls, String str) {
        super(cls, str);
        this.f948a = new Rect();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.f948a);
        this.f948a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.f948a);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.f948a);
        Rect rect = this.f948a;
        return new PointF(rect.left, rect.top);
    }
}
