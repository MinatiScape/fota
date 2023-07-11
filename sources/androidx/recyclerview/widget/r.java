package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
class r {

    /* renamed from: b  reason: collision with root package name */
    int f860b;
    int c;
    int d;
    int e;
    boolean h;
    boolean i;

    /* renamed from: a  reason: collision with root package name */
    boolean f859a = true;
    int f = 0;
    int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.s sVar) {
        int i = this.c;
        return i >= 0 && i < sVar.a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f860b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.o oVar) {
        View d = oVar.d(this.c);
        this.c += this.d;
        return d;
    }
}
