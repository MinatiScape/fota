package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
class ua extends Property<View, Rect> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ua(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Rect get(View view) {
        return androidx.core.h.t.e(view);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(View view, Rect rect) {
        androidx.core.h.t.a(view, rect);
    }
}
