package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.j;
/* compiled from: CardViewApi17Impl.java */
/* loaded from: classes.dex */
class b implements j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f379a = cVar;
    }

    @Override // androidx.cardview.widget.j.a
    public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
