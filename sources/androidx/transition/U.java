package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;
/* compiled from: Slide.java */
/* loaded from: classes.dex */
class U extends Slide.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public U() {
        super(null);
    }

    @Override // androidx.transition.Slide.a
    public float b(ViewGroup viewGroup, View view) {
        if (androidx.core.h.t.k(viewGroup) == 1) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
        return view.getTranslationX() + viewGroup.getWidth();
    }
}
