package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: FragmentHostCallback.java */
/* renamed from: androidx.fragment.app.j  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0080j<E> extends AbstractC0078h {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f635a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f636b;
    private final Handler c;
    private final int d;
    final r e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0080j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Fragment fragment);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity b() {
        return this.f635a;
    }

    public abstract boolean b(Fragment fragment);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context c() {
        return this.f636b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler e() {
        return this.c;
    }

    public abstract LayoutInflater f();

    public abstract int g();

    public abstract boolean h();

    public abstract void i();

    AbstractC0080j(Activity activity, Context context, Handler handler, int i) {
        this.e = new r();
        this.f635a = activity;
        androidx.core.g.h.a(context, "context == null");
        this.f636b = context;
        androidx.core.g.h.a(handler, "handler == null");
        this.c = handler;
        this.d = i;
    }
}
