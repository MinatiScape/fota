package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardView.java */
/* loaded from: classes.dex */
public class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f377a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CardView f378b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CardView cardView) {
        this.f378b = cardView;
    }

    @Override // androidx.cardview.widget.g
    public void a(Drawable drawable) {
        this.f377a = drawable;
        this.f378b.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.g
    public Drawable b() {
        return this.f377a;
    }

    @Override // androidx.cardview.widget.g
    public boolean c() {
        return this.f378b.getPreventCornerOverlap();
    }

    @Override // androidx.cardview.widget.g
    public View d() {
        return this.f378b;
    }

    @Override // androidx.cardview.widget.g
    public boolean a() {
        return this.f378b.getUseCompatPadding();
    }

    @Override // androidx.cardview.widget.g
    public void a(int i, int i2, int i3, int i4) {
        this.f378b.h.set(i, i2, i3, i4);
        CardView cardView = this.f378b;
        Rect rect = cardView.g;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    @Override // androidx.cardview.widget.g
    public void a(int i, int i2) {
        CardView cardView = this.f378b;
        if (i > cardView.e) {
            super/*android.widget.FrameLayout*/.setMinimumWidth(i);
        }
        CardView cardView2 = this.f378b;
        if (i2 > cardView2.f) {
            super/*android.widget.FrameLayout*/.setMinimumHeight(i2);
        }
    }
}
