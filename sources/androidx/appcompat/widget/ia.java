package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.a.h;
/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class ia {

    /* renamed from: a  reason: collision with root package name */
    private final Context f334a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f335b;
    private TypedValue c;

    private ia(Context context, TypedArray typedArray) {
        this.f334a = context;
        this.f335b = typedArray;
    }

    public static ia a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ia(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i) {
        int resourceId;
        if (this.f335b.hasValue(i) && (resourceId = this.f335b.getResourceId(i, 0)) != 0) {
            return androidx.appcompat.a.a.a.b(this.f334a, resourceId);
        }
        return this.f335b.getDrawable(i);
    }

    public Drawable c(int i) {
        int resourceId;
        if (!this.f335b.hasValue(i) || (resourceId = this.f335b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0058q.a().a(this.f334a, resourceId, true);
    }

    public String d(int i) {
        return this.f335b.getString(i);
    }

    public CharSequence e(int i) {
        return this.f335b.getText(i);
    }

    public int f(int i, int i2) {
        return this.f335b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f335b.getResourceId(i, i2);
    }

    public static ia a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ia(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int d(int i, int i2) {
        return this.f335b.getInt(i, i2);
    }

    public int e(int i, int i2) {
        return this.f335b.getInteger(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f335b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f335b.hasValue(i);
    }

    public static ia a(Context context, int i, int[] iArr) {
        return new ia(context, context.obtainStyledAttributes(i, iArr));
    }

    public int c(int i, int i2) {
        return this.f335b.getDimensionPixelSize(i, i2);
    }

    public Typeface a(int i, int i2, h.a aVar) {
        int resourceId = this.f335b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return androidx.core.content.a.h.a(this.f334a, resourceId, this.c, i2, aVar);
    }

    public float b(int i, float f) {
        return this.f335b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.f335b.getDimensionPixelOffset(i, i2);
    }

    public boolean a(int i, boolean z) {
        return this.f335b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.f335b.getColor(i, i2);
    }

    public ColorStateList a(int i) {
        int resourceId;
        ColorStateList a2;
        return (!this.f335b.hasValue(i) || (resourceId = this.f335b.getResourceId(i, 0)) == 0 || (a2 = androidx.appcompat.a.a.a.a(this.f334a, resourceId)) == null) ? this.f335b.getColorStateList(i) : a2;
    }

    public float a(int i, float f) {
        return this.f335b.getDimension(i, f);
    }

    public void a() {
        this.f335b.recycle();
    }
}
