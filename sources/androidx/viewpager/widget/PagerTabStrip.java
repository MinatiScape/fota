package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private boolean A;
    private int B;
    private boolean C;
    private float D;
    private float E;
    private int mTouchSlop;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private final Paint w;
    private final Rect x;
    private int y;
    private boolean z;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void a(int i, float f, boolean z) {
        Rect rect = this.x;
        int height = getHeight();
        int left = this.e.getLeft() - this.v;
        int right = this.e.getRight() + this.v;
        int i2 = height - this.r;
        rect.set(left, i2, right, height);
        super.a(i, f, z);
        this.y = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.e.getLeft() - this.v, i2, this.e.getRight() + this.v, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.u);
    }

    public int getTabIndicatorColor() {
        return this.q;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.e.getLeft() - this.v;
        int right = this.e.getRight() + this.v;
        this.w.setColor((this.y << 24) | (this.q & 16777215));
        float f = height;
        canvas.drawRect(left, height - this.r, right, f, this.w);
        if (this.z) {
            this.w.setColor((-16777216) | (this.q & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.B, getWidth() - getPaddingRight(), f, this.w);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || !this.C) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (action == 0) {
                this.D = x;
                this.E = y;
                this.C = false;
            } else if (action != 1) {
                if (action == 2 && (Math.abs(x - this.D) > this.mTouchSlop || Math.abs(y - this.E) > this.mTouchSlop)) {
                    this.C = true;
                }
            } else if (x < this.e.getLeft() - this.v) {
                ViewPager viewPager = this.c;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x > this.e.getRight() + this.v) {
                ViewPager viewPager2 = this.c;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.A) {
            return;
        }
        this.z = (i & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.A) {
            return;
        }
        this.z = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.A) {
            return;
        }
        this.z = i == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.z = z;
        this.A = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.s;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(int i) {
        this.q = i;
        this.w.setColor(this.q);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(androidx.core.content.a.a(getContext(), i));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        int i2 = this.t;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = new Paint();
        this.x = new Rect();
        this.y = 255;
        this.z = false;
        this.A = false;
        this.q = this.p;
        this.w.setColor(this.q);
        float f = context.getResources().getDisplayMetrics().density;
        this.r = (int) ((3.0f * f) + 0.5f);
        this.s = (int) ((6.0f * f) + 0.5f);
        this.t = (int) (64.0f * f);
        this.v = (int) ((16.0f * f) + 0.5f);
        this.B = (int) ((1.0f * f) + 0.5f);
        this.u = (int) ((f * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.d.setFocusable(true);
        this.d.setOnClickListener(new b(this));
        this.f.setFocusable(true);
        this.f.setOnClickListener(new c(this));
        if (getBackground() == null) {
            this.z = true;
        }
    }
}
