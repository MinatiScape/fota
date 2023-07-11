package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.j;
/* compiled from: CardViewBaseImpl.java */
/* loaded from: classes.dex */
class e implements j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.f380a = fVar;
    }

    @Override // androidx.cardview.widget.j.a
    public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        float f2 = 2.0f * f;
        float width = (rectF.width() - f2) - 1.0f;
        float height = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.f380a.f381a.set(f4, f4, f3, f3);
            int save = canvas.save();
            canvas.translate(rectF.left + f3, rectF.top + f3);
            canvas.drawArc(this.f380a.f381a, 180.0f, 90.0f, true, paint);
            canvas.translate(width, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f380a.f381a, 180.0f, 90.0f, true, paint);
            canvas.translate(height, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f380a.f381a, 180.0f, 90.0f, true, paint);
            canvas.translate(width, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f380a.f381a, 180.0f, 90.0f, true, paint);
            canvas.restoreToCount(save);
            float f5 = rectF.top;
            canvas.drawRect((rectF.left + f3) - 1.0f, f5, (rectF.right - f3) + 1.0f, f5 + f3, paint);
            float f6 = rectF.bottom;
            canvas.drawRect((rectF.left + f3) - 1.0f, f6 - f3, (rectF.right - f3) + 1.0f, f6, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
    }
}
