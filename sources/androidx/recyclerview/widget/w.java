package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.i f862a;

    /* renamed from: b  reason: collision with root package name */
    private int f863b;
    final Rect c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(RecyclerView.i iVar, u uVar) {
        this(iVar);
    }

    public static w a(RecyclerView.i iVar, int i) {
        if (i != 0) {
            if (i == 1) {
                return b(iVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(iVar);
    }

    public static w b(RecyclerView.i iVar) {
        return new v(iVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f863b) {
            return 0;
        }
        return g() - this.f863b;
    }

    public void i() {
        this.f863b = g();
    }

    private w(RecyclerView.i iVar) {
        this.f863b = Integer.MIN_VALUE;
        this.c = new Rect();
        this.f862a = iVar;
    }

    public static w a(RecyclerView.i iVar) {
        return new u(iVar);
    }
}
