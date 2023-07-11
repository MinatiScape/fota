package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    long f549a;

    /* renamed from: b  reason: collision with root package name */
    boolean f550b;
    boolean c;
    boolean d;
    private final Runnable e;
    private final Runnable f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    private void a() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f549a = -1L;
        this.f550b = false;
        this.c = false;
        this.d = false;
        this.e = new d(this);
        this.f = new e(this);
    }
}
