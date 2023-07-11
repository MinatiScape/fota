package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
class K<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f922a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f923b;
    private final float c;
    private final float[] d;
    private final PointF e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        this.e = new PointF();
        this.f922a = property;
        this.f923b = new PathMeasure(path, false);
        this.c = this.f923b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.f923b.getPosTan(this.c * f.floatValue(), this.d, null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f922a.set(t, pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((K<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f);
    }
}
