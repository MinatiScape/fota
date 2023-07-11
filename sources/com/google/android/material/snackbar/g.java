package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnackbarManager.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f1402a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1403b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new f(this));
    private b d;
    private b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a> f1404a;

        /* renamed from: b  reason: collision with root package name */
        int f1405b;
        boolean c;

        boolean a(a aVar) {
            return aVar != null && this.f1404a.get() == aVar;
        }
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a() {
        if (f1402a == null) {
            f1402a = new g();
        }
        return f1402a;
    }

    private boolean c(a aVar) {
        b bVar = this.d;
        return bVar != null && bVar.a(aVar);
    }

    public void b(a aVar) {
        synchronized (this.f1403b) {
            if (c(aVar) && this.d.c) {
                this.d.c = false;
                b(this.d);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f1403b) {
            if (c(aVar) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    private void b(b bVar) {
        int i = bVar.f1405b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.c.removeCallbacksAndMessages(bVar);
        Handler handler = this.c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), i);
    }

    private boolean a(b bVar, int i) {
        a aVar = bVar.f1404a.get();
        if (aVar != null) {
            this.c.removeCallbacksAndMessages(bVar);
            aVar.a(i);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        synchronized (this.f1403b) {
            if (this.d == bVar || this.e == bVar) {
                a(bVar, 2);
            }
        }
    }
}
