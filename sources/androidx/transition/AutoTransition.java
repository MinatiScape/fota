package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        s();
    }

    private void s() {
        b(1);
        a(new Fade(2)).a(new ChangeBounds()).a(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s();
    }
}
