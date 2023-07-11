package androidx.transition;

import android.view.View;
import android.view.WindowId;
/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
class Da implements Ea {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f915a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(View view) {
        this.f915a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Da) && ((Da) obj).f915a.equals(this.f915a);
    }

    public int hashCode() {
        return this.f915a.hashCode();
    }
}
