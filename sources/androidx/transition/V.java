package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;
/* compiled from: Slide.java */
/* loaded from: classes.dex */
class V extends Slide.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public V() {
        super(null);
    }

    @Override // androidx.transition.Slide.a
    public float a(ViewGroup viewGroup, View view) {
        return view.getTranslationY() + viewGroup.getHeight();
    }
}
