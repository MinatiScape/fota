package androidx.appcompat.widget;

import android.util.Property;
/* compiled from: SwitchCompat.java */
/* loaded from: classes.dex */
class ca extends Property<SwitchCompat, Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(SwitchCompat switchCompat) {
        return Float.valueOf(switchCompat.x);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(SwitchCompat switchCompat, Float f) {
        switchCompat.setThumbPosition(f.floatValue());
    }
}
