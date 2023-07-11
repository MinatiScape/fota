package androidx.core.f;

import java.util.Locale;
/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final androidx.core.f.d f488a = new C0011e(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final androidx.core.f.d f489b = new C0011e(null, true);
    public static final androidx.core.f.d c = new C0011e(b.f492a, false);
    public static final androidx.core.f.d d = new C0011e(b.f492a, true);
    public static final androidx.core.f.d e = new C0011e(a.f490a, false);
    public static final androidx.core.f.d f = f.f495b;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f490a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        static final a f491b = new a(false);
        private final boolean c;

        private a(boolean z) {
            this.c = z;
        }

        @Override // androidx.core.f.e.c
        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.c) {
                        return 1;
                    }
                } else if (this.c) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.c ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f492a = new b();

        private b() {
        }

        @Override // androidx.core.f.e.c
        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        int checkRtl(CharSequence charSequence, int i, int i2);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static abstract class d implements androidx.core.f.d {

        /* renamed from: a  reason: collision with root package name */
        private final c f493a;

        d(c cVar) {
            this.f493a = cVar;
        }

        private boolean a(CharSequence charSequence, int i, int i2) {
            int checkRtl = this.f493a.checkRtl(charSequence, i, i2);
            if (checkRtl != 0) {
                if (checkRtl != 1) {
                    return a();
                }
                return false;
            }
            return true;
        }

        protected abstract boolean a();

        @Override // androidx.core.f.d
        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                if (this.f493a == null) {
                    return a();
                }
                return a(charSequence, i, i2);
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0011e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f494b;

        C0011e(c cVar, boolean z) {
            super(cVar);
            this.f494b = z;
        }

        @Override // androidx.core.f.e.d
        protected boolean a() {
            return this.f494b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final f f495b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.f.e.d
        protected boolean a() {
            return androidx.core.f.f.a(Locale.getDefault()) == 1;
        }
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
