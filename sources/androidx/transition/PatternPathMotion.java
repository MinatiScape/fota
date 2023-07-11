package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private Path f928a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f929b = new Path();
    private final Matrix c = new Matrix();

    public PatternPathMotion() {
        this.f929b.lineTo(1.0f, 0.0f);
        this.f928a = this.f929b;
    }

    public void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.c.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float a2 = 1.0f / a(f5, f6);
        this.c.postScale(a2, a2);
        this.c.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
        path.transform(this.c, this.f929b);
        this.f928a = path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.k);
        try {
            String a2 = androidx.core.content.a.i.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (a2 != null) {
                a(androidx.core.a.b.b(a2));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float a2 = a(f5, f6);
        double atan2 = Math.atan2(f6, f5);
        this.c.setScale(a2, a2);
        this.c.postRotate((float) Math.toDegrees(atan2));
        this.c.postTranslate(f, f2);
        Path path = new Path();
        this.f929b.transform(this.c, path);
        return path;
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }
}
