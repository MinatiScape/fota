package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.h.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleImageView.java */
/* loaded from: classes.dex */
public class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Animation.AnimationListener f875a;

    /* renamed from: b  reason: collision with root package name */
    int f876b;

    /* compiled from: CircleImageView.java */
    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0023a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        private RadialGradient f877a;

        /* renamed from: b  reason: collision with root package name */
        private Paint f878b = new Paint();

        C0023a(int i) {
            a.this.f876b = i;
            a((int) rect().width());
        }

        private void a(int i) {
            float f = i / 2;
            this.f877a = new RadialGradient(f, f, a.this.f876b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f878b.setShader(this.f877a);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            float width2 = a.this.getWidth() / 2;
            float height = a.this.getHeight() / 2;
            canvas.drawCircle(width2, height, width2, this.f878b);
            canvas.drawCircle(width2, height, width - a.this.f876b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            a((int) f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.f876b = (int) (3.5f * f);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            t.a(this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0023a(this.f876b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f876b, i3, i2, 503316480);
            int i4 = this.f876b;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        t.a(this, shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f875a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f875a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f876b * 2), getMeasuredHeight() + (this.f876b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f875a = animationListener;
    }
}
