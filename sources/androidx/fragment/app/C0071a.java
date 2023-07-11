package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.AbstractC0081k;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* renamed from: androidx.fragment.app.a  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0071a extends w implements AbstractC0081k.a, r.h {

    /* renamed from: a  reason: collision with root package name */
    final r f626a;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    String k;
    boolean l;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    ArrayList<Runnable> u;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<C0017a> f627b = new ArrayList<>();
    boolean j = true;
    int m = -1;
    boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackStackRecord.java */
    /* renamed from: androidx.fragment.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0017a {

        /* renamed from: a  reason: collision with root package name */
        int f628a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f629b;
        int c;
        int d;
        int e;
        int f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0017a() {
        }

        C0017a(int i, Fragment fragment) {
            this.f628a = i;
            this.f629b = fragment;
        }
    }

    public C0071a(r rVar) {
        this.f626a = rVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    @Override // androidx.fragment.app.w
    public w b(Fragment fragment) {
        a(new C0017a(6, fragment));
        return this;
    }

    public String c() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        for (int i = 0; i < this.f627b.size(); i++) {
            if (b(this.f627b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void e() {
        ArrayList<Runnable> arrayList = this.u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.u.get(i).run();
            }
            this.u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnStartPostponedListener(Fragment.c cVar) {
        for (int i = 0; i < this.f627b.size(); i++) {
            C0017a c0017a = this.f627b.get(i);
            if (b(c0017a)) {
                c0017a.f629b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) CpioConstants.C_IWUSR);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.c != 0 || this.d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (this.f627b.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.f627b.size();
        for (int i = 0; i < size; i++) {
            C0017a c0017a = this.f627b.get(i);
            switch (c0017a.f628a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                default:
                    str2 = "cmd=" + c0017a.f628a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(c0017a.f629b);
            if (z) {
                if (c0017a.c != 0 || c0017a.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0017a.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0017a.d));
                }
                if (c0017a.e != 0 || c0017a.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0017a.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0017a.f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.f627b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f627b.get(i2).f629b;
            int i3 = fragment != null ? fragment.A : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int size = this.f627b.size();
        for (int i = 0; i < size; i++) {
            C0017a c0017a = this.f627b.get(i);
            Fragment fragment = c0017a.f629b;
            if (fragment != null) {
                fragment.a(this.g, this.h);
            }
            switch (c0017a.f628a) {
                case 1:
                    fragment.a(c0017a.c);
                    this.f626a.a(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0017a.f628a);
                case 3:
                    fragment.a(c0017a.d);
                    this.f626a.k(fragment);
                    break;
                case 4:
                    fragment.a(c0017a.d);
                    this.f626a.e(fragment);
                    break;
                case 5:
                    fragment.a(c0017a.c);
                    this.f626a.o(fragment);
                    break;
                case 6:
                    fragment.a(c0017a.d);
                    this.f626a.c(fragment);
                    break;
                case 7:
                    fragment.a(c0017a.c);
                    this.f626a.a(fragment);
                    break;
                case 8:
                    this.f626a.n(fragment);
                    break;
                case 9:
                    this.f626a.n(null);
                    break;
            }
            if (!this.t && c0017a.f628a != 1 && fragment != null) {
                this.f626a.h(fragment);
            }
        }
        if (this.t) {
            return;
        }
        r rVar = this.f626a;
        rVar.a(rVar.r, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.f627b.size() - 1; size >= 0; size--) {
            C0017a c0017a = this.f627b.get(size);
            Fragment fragment = c0017a.f629b;
            if (fragment != null) {
                fragment.a(r.d(this.g), this.h);
            }
            switch (c0017a.f628a) {
                case 1:
                    fragment.a(c0017a.f);
                    this.f626a.k(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0017a.f628a);
                case 3:
                    fragment.a(c0017a.e);
                    this.f626a.a(fragment, false);
                    break;
                case 4:
                    fragment.a(c0017a.e);
                    this.f626a.o(fragment);
                    break;
                case 5:
                    fragment.a(c0017a.f);
                    this.f626a.e(fragment);
                    break;
                case 6:
                    fragment.a(c0017a.e);
                    this.f626a.a(fragment);
                    break;
                case 7:
                    fragment.a(c0017a.f);
                    this.f626a.c(fragment);
                    break;
                case 8:
                    this.f626a.n(null);
                    break;
                case 9:
                    this.f626a.n(fragment);
                    break;
            }
            if (!this.t && c0017a.f628a != 3 && fragment != null) {
                this.f626a.h(fragment);
            }
        }
        if (this.t || !z) {
            return;
        }
        r rVar = this.f626a;
        rVar.a(rVar.r, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0017a c0017a) {
        this.f627b.add(c0017a);
        c0017a.c = this.c;
        c0017a.d = this.d;
        c0017a.e = this.e;
        c0017a.f = this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int i = 0; i < this.f627b.size(); i++) {
            C0017a c0017a = this.f627b.get(i);
            int i2 = c0017a.f628a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = c0017a.f629b;
                            break;
                    }
                }
                arrayList.add(c0017a.f629b);
            }
            arrayList.remove(c0017a.f629b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.w
    public w a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            fragment.t = this.f626a;
            if (str != null) {
                String str2 = fragment.B;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.B + " now " + str);
                }
                fragment.B = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = fragment.z;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.z + " now " + i);
                    }
                    fragment.z = i;
                    fragment.A = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            a(new C0017a(i2, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    private static boolean b(C0017a c0017a) {
        Fragment fragment = c0017a.f629b;
        return (fragment == null || !fragment.m || fragment.K == null || fragment.D || fragment.C || !fragment.C()) ? false : true;
    }

    @Override // androidx.fragment.app.w
    public w a(Fragment fragment) {
        a(new C0017a(7, fragment));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        C0017a c0017a;
        if (this.i) {
            if (r.f645a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f627b.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f627b.get(i2).f629b;
                if (fragment != null) {
                    fragment.s += i;
                    if (r.f645a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0017a.f629b + " to " + c0017a.f629b.s);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.w
    public int a() {
        return a(false);
    }

    int a(boolean z) {
        if (!this.l) {
            if (r.f645a) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
                a("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.l = true;
            if (this.i) {
                this.m = this.f626a.b(this);
            } else {
                this.m = -1;
            }
            this.f626a.a(this, z);
            return this.m;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.r.h
    public boolean a(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2) {
        if (r.f645a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.i) {
            this.f626a.a(this);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<C0071a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f627b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f627b.get(i4).f629b;
            int i5 = fragment != null ? fragment.A : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0071a c0071a = arrayList.get(i6);
                    int size2 = c0071a.f627b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = c0071a.f627b.get(i7).f629b;
                        if ((fragment2 != null ? fragment2.A : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f627b.size()) {
            C0017a c0017a = this.f627b.get(i);
            int i2 = c0017a.f628a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = c0017a.f629b;
                    int i3 = fragment3.A;
                    Fragment fragment4 = fragment2;
                    int i4 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.A == i3) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f627b.add(i4, new C0017a(9, fragment5));
                                    i4++;
                                    fragment4 = null;
                                }
                                C0017a c0017a2 = new C0017a(3, fragment5);
                                c0017a2.c = c0017a.c;
                                c0017a2.e = c0017a.e;
                                c0017a2.d = c0017a.d;
                                c0017a2.f = c0017a.f;
                                this.f627b.add(i4, c0017a2);
                                arrayList.remove(fragment5);
                                i4++;
                            }
                        }
                    }
                    if (z) {
                        this.f627b.remove(i4);
                        i4--;
                    } else {
                        c0017a.f628a = 1;
                        arrayList.add(fragment3);
                    }
                    i = i4;
                    fragment2 = fragment4;
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(c0017a.f629b);
                    Fragment fragment6 = c0017a.f629b;
                    if (fragment6 == fragment2) {
                        this.f627b.add(i, new C0017a(9, fragment6));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f627b.add(i, new C0017a(9, fragment2));
                        i++;
                        fragment2 = c0017a.f629b;
                    }
                }
                i++;
            }
            arrayList.add(c0017a.f629b);
            i++;
        }
        return fragment2;
    }
}
