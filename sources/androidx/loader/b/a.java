package androidx.loader.b;

import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class a<D> {

    /* renamed from: a  reason: collision with root package name */
    int f703a;

    /* renamed from: b  reason: collision with root package name */
    b<D> f704b;
    InterfaceC0020a<D> c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    /* compiled from: Loader.java */
    /* renamed from: androidx.loader.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0020a<D> {
    }

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public interface b<D> {
    }

    public void a() {
        this.e = true;
        c();
    }

    public boolean b() {
        return d();
    }

    protected void c() {
    }

    protected boolean d() {
        return false;
    }

    protected void e() {
    }

    protected void f() {
    }

    protected void g() {
    }

    public void h() {
        e();
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    public final void i() {
        this.d = true;
        this.f = false;
        this.e = false;
        f();
    }

    public void j() {
        this.d = false;
        g();
    }

    public void registerOnLoadCanceledListener(InterfaceC0020a<D> interfaceC0020a) {
        if (this.c == null) {
            this.c = interfaceC0020a;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.f703a);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(b<D> bVar) {
        b<D> bVar2 = this.f704b;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (bVar2 == bVar) {
            this.f704b = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }

    public void unregisterOnLoadCanceledListener(InterfaceC0020a<D> interfaceC0020a) {
        InterfaceC0020a<D> interfaceC0020a2 = this.c;
        if (interfaceC0020a2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0020a2 == interfaceC0020a) {
            this.c = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }

    public String a(D d) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f703a);
        printWriter.print(" mListener=");
        printWriter.println(this.f704b);
        if (this.d || this.g || this.h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.h);
        }
        if (this.e || this.f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.e);
            printWriter.print(" mReset=");
            printWriter.println(this.f);
        }
    }
}
