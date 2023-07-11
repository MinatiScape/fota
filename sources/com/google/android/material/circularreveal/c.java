package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.circularreveal.e;
/* compiled from: CircularRevealHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1320a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1321b;
    private final View c;
    private final Path d;
    private final Paint e;
    private final Paint f;
    private e.d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularRevealHelper.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1320a = 2;
        } else if (i >= 18) {
            f1320a = 1;
        } else {
            f1320a = 0;
        }
    }

    public c(a aVar) {
        this.f1321b = aVar;
        this.c = (View) aVar;
        this.c.setWillNotDraw(false);
        this.d = new Path();
        this.e = new Paint(7);
        this.f = new Paint(1);
        this.f.setColor(0);
    }

    private void g() {
        if (f1320a == 1) {
            this.d.rewind();
            e.d dVar = this.g;
            if (dVar != null) {
                this.d.addCircle(dVar.f1326a, dVar.f1327b, dVar.c, Path.Direction.CW);
            }
        }
        this.c.invalidate();
    }

    private boolean h() {
        e.d dVar = this.g;
        boolean z = dVar == null || dVar.a();
        return f1320a == 0 ? !z && this.j : !z;
    }

    private boolean i() {
        return (this.i || this.h == null || this.g == null) ? false : true;
    }

    private boolean j() {
        return (this.i || Color.alpha(this.f.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f1320a == 0) {
            this.i = true;
            this.j = false;
            this.c.buildDrawingCache();
            Bitmap drawingCache = this.c.getDrawingCache();
            if (drawingCache == null && this.c.getWidth() != 0 && this.c.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
                this.c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.e;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void b() {
        if (f1320a == 0) {
            this.j = false;
            this.c.destroyDrawingCache();
            this.e.setShader(null);
            this.c.invalidate();
        }
    }

    public Drawable c() {
        return this.h;
    }

    public int d() {
        return this.f.getColor();
    }

    public e.d e() {
        e.d dVar = this.g;
        if (dVar == null) {
            return null;
        }
        e.d dVar2 = new e.d(dVar);
        if (dVar2.a()) {
            dVar2.c = b(dVar2);
        }
        return dVar2;
    }

    public boolean f() {
        return this.f1321b.c() && !h();
    }

    private float b(e.d dVar) {
        return com.google.android.material.e.a.a(dVar.f1326a, dVar.f1327b, 0.0f, 0.0f, this.c.getWidth(), this.c.getHeight());
    }

    private void b(Canvas canvas) {
        if (i()) {
            Rect bounds = this.h.getBounds();
            float width = this.g.f1326a - (bounds.width() / 2.0f);
            float height = this.g.f1327b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.h.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public void a(e.d dVar) {
        if (dVar == null) {
            this.g = null;
        } else {
            e.d dVar2 = this.g;
            if (dVar2 == null) {
                this.g = new e.d(dVar);
            } else {
                dVar2.a(dVar);
            }
            if (com.google.android.material.e.a.a(dVar.c, b(dVar), 1.0E-4f)) {
                this.g.c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public void a(int i) {
        this.f.setColor(i);
        this.c.invalidate();
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        this.c.invalidate();
    }

    public void a(Canvas canvas) {
        if (h()) {
            int i = f1320a;
            if (i == 0) {
                e.d dVar = this.g;
                canvas.drawCircle(dVar.f1326a, dVar.f1327b, dVar.c, this.e);
                if (j()) {
                    e.d dVar2 = this.g;
                    canvas.drawCircle(dVar2.f1326a, dVar2.f1327b, dVar2.c, this.f);
                }
            } else if (i == 1) {
                int save = canvas.save();
                canvas.clipPath(this.d);
                this.f1321b.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                }
                canvas.restoreToCount(save);
            } else if (i == 2) {
                this.f1321b.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + f1320a);
            }
        } else {
            this.f1321b.a(canvas);
            if (j()) {
                canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
            }
        }
        b(canvas);
    }
}
