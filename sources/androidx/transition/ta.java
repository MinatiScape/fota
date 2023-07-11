package androidx.transition;

import android.util.Property;
import android.view.View;
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
class ta extends Property<View, Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ta(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(View view) {
        return Float.valueOf(va.c(view));
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(View view, Float f) {
        va.a(view, f.floatValue());
    }
}
