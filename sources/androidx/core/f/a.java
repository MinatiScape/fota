package androidx.core.f;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final d f474a = e.c;

    /* renamed from: b  reason: collision with root package name */
    private static final String f475b = Character.toString(8206);
    private static final String c = Character.toString(8207);
    static final a d = new a(false, 2, f474a);
    static final a e = new a(true, 2, f474a);
    private final boolean f;
    private final int g;
    private final d h;

    /* compiled from: BidiFormatter.java */
    /* renamed from: androidx.core.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0009a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f476a;

        /* renamed from: b  reason: collision with root package name */
        private int f477b;
        private d c;

        public C0009a() {
            b(a.a(Locale.getDefault()));
        }

        private static a a(boolean z) {
            return z ? a.e : a.d;
        }

        private void b(boolean z) {
            this.f476a = z;
            this.c = a.f474a;
            this.f477b = 2;
        }

        public a a() {
            if (this.f477b == 2 && this.c == a.f474a) {
                return a(this.f476a);
            }
            return new a(this.f476a, this.f477b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BidiFormatter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f478a = new byte[1792];

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f479b;
        private final boolean c;
        private final int d;
        private int e;
        private char f;

        static {
            for (int i = 0; i < 1792; i++) {
                f478a[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f479b = charSequence;
            this.c = z;
            this.d = charSequence.length();
        }

        private static byte a(char c) {
            return c < 1792 ? f478a[c] : Character.getDirectionality(c);
        }

        private byte e() {
            char c;
            int i = this.e;
            do {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f479b;
                int i3 = i2 - 1;
                this.e = i3;
                this.f = charSequence.charAt(i3);
                c = this.f;
                if (c == '&') {
                    return (byte) 12;
                }
            } while (c != ';');
            this.e = i;
            this.f = ';';
            return (byte) 13;
        }

        private byte f() {
            char charAt;
            do {
                int i = this.e;
                if (i >= this.d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f479b;
                this.e = i + 1;
                charAt = charSequence.charAt(i);
                this.f = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte g() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f479b;
                int i3 = i2 - 1;
                this.e = i3;
                this.f = charSequence.charAt(i3);
                char c = this.f;
                if (c == '<') {
                    return (byte) 12;
                }
                if (c == '>') {
                    break;
                } else if (c == '\"' || c == '\'') {
                    char c2 = this.f;
                    do {
                        int i4 = this.e;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.f479b;
                            int i5 = i4 - 1;
                            this.e = i5;
                            charAt = charSequence2.charAt(i5);
                            this.f = charAt;
                        }
                    } while (charAt != c2);
                }
            }
            this.e = i;
            this.f = '>';
            return (byte) 13;
        }

        private byte h() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 < this.d) {
                    CharSequence charSequence = this.f479b;
                    this.e = i2 + 1;
                    this.f = charSequence.charAt(i2);
                    char c = this.f;
                    if (c == '>') {
                        return (byte) 12;
                    }
                    if (c == '\"' || c == '\'') {
                        char c2 = this.f;
                        do {
                            int i3 = this.e;
                            if (i3 < this.d) {
                                CharSequence charSequence2 = this.f479b;
                                this.e = i3 + 1;
                                charAt = charSequence2.charAt(i3);
                                this.f = charAt;
                            }
                        } while (charAt != c2);
                    }
                } else {
                    this.e = i;
                    this.f = '<';
                    return (byte) 13;
                }
            }
        }

        byte b() {
            this.f = this.f479b.charAt(this.e);
            if (Character.isHighSurrogate(this.f)) {
                int codePointAt = Character.codePointAt(this.f479b, this.e);
                this.e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.e++;
            byte a2 = a(this.f);
            if (this.c) {
                char c = this.f;
                if (c == '<') {
                    return h();
                }
                return c == '&' ? f() : a2;
            }
            return a2;
        }

        int c() {
            this.e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.e < this.d && i == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.e > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int d() {
            this.e = this.d;
            int i = 0;
            int i2 = 0;
            while (this.e > 0) {
                byte a2 = a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i == 0) {
                            i = i2;
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i != 0) {
                                    break;
                                } else {
                                    i = i2;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else if (i2 == 0) {
                    return -1;
                } else {
                    if (i == 0) {
                        i = i2;
                    }
                }
            }
            return 0;
        }

        byte a() {
            this.f = this.f479b.charAt(this.e - 1);
            if (Character.isLowSurrogate(this.f)) {
                int codePointBefore = Character.codePointBefore(this.f479b, this.e);
                this.e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.e--;
            byte a2 = a(this.f);
            if (this.c) {
                char c = this.f;
                if (c == '>') {
                    return g();
                }
                return c == ';' ? e() : a2;
            }
            return a2;
        }
    }

    a(boolean z, int i, d dVar) {
        this.f = z;
        this.g = i;
        this.h = dVar;
    }

    public static a a() {
        return new C0009a().a();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public boolean b() {
        return (this.g & 2) != 0;
    }

    private String a(CharSequence charSequence, d dVar) {
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        if (this.f || !(isRtl || c(charSequence) == 1)) {
            return this.f ? (!isRtl || c(charSequence) == -1) ? c : "" : "";
        }
        return f475b;
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        if (this.f || !(isRtl || b(charSequence) == 1)) {
            return this.f ? (!isRtl || b(charSequence) == -1) ? c : "" : "";
        }
        return f475b;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).c();
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, isRtl ? e.f489b : e.f488a));
        }
        if (isRtl != this.f) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, isRtl ? e.f489b : e.f488a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.h, true);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }
}
