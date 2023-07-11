package androidx.loader.a;

import a.b.j;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.loader.b.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
public class b extends androidx.loader.a.a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f699a = false;

    /* renamed from: b  reason: collision with root package name */
    private final h f700b;
    private final c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019b<D> implements p<D> {
        public void a(String str, PrintWriter printWriter) {
            throw null;
        }

        boolean a() {
            throw null;
        }

        void b() {
            throw null;
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    static class c extends r {

        /* renamed from: a  reason: collision with root package name */
        private static final s.a f701a = new androidx.loader.a.c();

        /* renamed from: b  reason: collision with root package name */
        private j<a> f702b = new j<>();
        private boolean c = false;

        static c a(t tVar) {
            return (c) new s(tVar, f701a).a(c.class);
        }

        void b() {
            int b2 = this.f702b.b();
            for (int i = 0; i < b2; i++) {
                this.f702b.f(i).f();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.r
        public void a() {
            super.a();
            int b2 = this.f702b.b();
            for (int i = 0; i < b2; i++) {
                this.f702b.f(i).a(true);
            }
            this.f702b.a();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f702b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f702b.b(); i++) {
                    a f = this.f702b.f(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f702b.d(i));
                    printWriter.print(": ");
                    printWriter.println(f.toString());
                    f.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(h hVar, t tVar) {
        this.f700b = hVar;
        this.c = c.a(tVar);
    }

    @Override // androidx.loader.a.a
    public void a() {
        this.c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) CpioConstants.C_IWUSR);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.g.a.a(this.f700b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.loader.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }

    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    public static class a<D> extends o<D> implements a.b<D> {
        private final int k;
        private final Bundle l;
        private final androidx.loader.b.a<D> m;
        private h n;
        private C0019b<D> o;
        private androidx.loader.b.a<D> p;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(p<? super D> pVar) {
            super.a((p) pVar);
            this.n = null;
            this.o = null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (b.f699a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.i();
        }

        @Override // androidx.lifecycle.LiveData
        protected void d() {
            if (b.f699a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.j();
        }

        androidx.loader.b.a<D> e() {
            return this.m;
        }

        void f() {
            h hVar = this.n;
            C0019b<D> c0019b = this.o;
            if (hVar == null || c0019b == null) {
                return;
            }
            super.a((p) c0019b);
            a(hVar, c0019b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            androidx.core.g.a.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        androidx.loader.b.a<D> a(boolean z) {
            if (b.f699a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.b();
            this.m.a();
            C0019b<D> c0019b = this.o;
            if (c0019b != null) {
                a((p) c0019b);
                if (z) {
                    c0019b.b();
                    throw null;
                }
            }
            this.m.unregisterListener(this);
            if (c0019b != null) {
                c0019b.a();
                throw null;
            } else if (z) {
                this.m.h();
                return this.p;
            } else {
                return this.m;
            }
        }

        @Override // androidx.lifecycle.o, androidx.lifecycle.LiveData
        public void a(D d) {
            super.a((a<D>) d);
            androidx.loader.b.a<D> aVar = this.p;
            if (aVar != null) {
                aVar.h();
                this.p = null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            androidx.loader.b.a<D> aVar = this.m;
            aVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.o == null) {
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(e().a(a()));
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.println(b());
                return;
            }
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.o);
            C0019b<D> c0019b = this.o;
            c0019b.a(str + "  ", printWriter);
            throw null;
        }
    }
}
