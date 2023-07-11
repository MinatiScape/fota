package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;
/* compiled from: Slide.java */
/* loaded from: classes.dex */
class T extends Slide.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public T() {
        super(null);
    }

    @Override // androidx.transition.Slide.a
    public float b(ViewGroup viewGroup, View view) {
        return view.getTranslationX() + viewGroup.getWidth();
    }
}
