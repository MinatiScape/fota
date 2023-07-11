package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private static final float f899a = (float) Math.tan(Math.toRadians(35.0d));

    /* renamed from: b  reason: collision with root package name */
    private float f900b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;

    public ArcMotion() {
        this.f900b = 0.0f;
        this.c = 0.0f;
        this.d = 70.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = f899a;
    }

    private static float d(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians(f / 2.0f));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public void a(float f) {
        this.d = f;
        this.g = d(f);
    }

    public void b(float f) {
        this.f900b = f;
        this.e = d(f);
    }

    public void c(float f) {
        this.c = f;
        this.f = d(f);
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        Path path = new Path();
        path.moveTo(f, f2);
        float f8 = f3 - f;
        float f9 = f4 - f2;
        float f10 = (f8 * f8) + (f9 * f9);
        float f11 = (f + f3) / 2.0f;
        float f12 = (f2 + f4) / 2.0f;
        float f13 = 0.25f * f10;
        boolean z = f2 > f4;
        if (Math.abs(f8) < Math.abs(f9)) {
            float abs = Math.abs(f10 / (f9 * 2.0f));
            if (z) {
                f6 = abs + f4;
                f5 = f3;
            } else {
                f6 = abs + f2;
                f5 = f;
            }
            f7 = this.f;
        } else {
            float f14 = f10 / (f8 * 2.0f);
            if (z) {
                f6 = f2;
                f5 = f14 + f;
            } else {
                f5 = f3 - f14;
                f6 = f4;
            }
            f7 = this.e;
        }
        float f15 = f13 * f7 * f7;
        float f16 = f11 - f5;
        float f17 = f12 - f6;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.g;
        float f20 = f13 * f19 * f19;
        if (f18 < f15) {
            f20 = f15;
        } else if (f18 <= f20) {
            f20 = 0.0f;
        }
        if (f20 != 0.0f) {
            float sqrt = (float) Math.sqrt(f20 / f18);
            f5 = ((f5 - f11) * sqrt) + f11;
            f6 = f12 + (sqrt * (f6 - f12));
        }
        path.cubicTo((f + f5) / 2.0f, (f2 + f6) / 2.0f, (f5 + f3) / 2.0f, (f6 + f4) / 2.0f, f3, f4);
        return path;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f900b = 0.0f;
        this.c = 0.0f;
        this.d = 70.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = f899a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        c(androidx.core.content.a.i.a(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        b(androidx.core.content.a.i.a(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        a(androidx.core.content.a.i.a(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
