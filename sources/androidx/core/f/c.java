package androidx.core.f;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;
/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class c implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f482a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Executor f483b = null;
    private final Spannable c;
    private final a d;
    private final PrecomputedText e;

    public a a() {
        return this.d;
    }

    public PrecomputedText b() {
        Spannable spannable = this.c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.c.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T[]) this.e.getSpans(i, i2, cls);
        }
        return (T[]) this.c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.c.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.removeSpan(obj);
                return;
            } else {
                this.c.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.setSpan(obj, i, i2, i3);
                return;
            } else {
                this.c.setSpan(obj, i, i2, i3);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.c.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f484a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f485b;
        private final int c;
        private final int d;
        final PrecomputedText.Params e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: androidx.core.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0010a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f486a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f487b;
            private int c;
            private int d;

            public C0010a(TextPaint textPaint) {
                this.f486a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f487b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f487b = null;
                }
            }

            public C0010a a(int i) {
                this.c = i;
                return this;
            }

            public C0010a b(int i) {
                this.d = i;
                return this;
            }

            public C0010a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f487b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f486a, this.f487b, this.c, this.d);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.e = null;
            }
            this.f484a = textPaint;
            this.f485b = textDirectionHeuristic;
            this.c = i;
            this.d = i2;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public TextDirectionHeuristic c() {
            return this.f485b;
        }

        public TextPaint d() {
            return this.f484a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            PrecomputedText.Params params = this.e;
            if (params != null) {
                return params.equals(aVar.e);
            }
            if (Build.VERSION.SDK_INT < 23 || (this.c == aVar.a() && this.d == aVar.b())) {
                if ((Build.VERSION.SDK_INT < 18 || this.f485b == aVar.c()) && this.f484a.getTextSize() == aVar.d().getTextSize() && this.f484a.getTextScaleX() == aVar.d().getTextScaleX() && this.f484a.getTextSkewX() == aVar.d().getTextSkewX()) {
                    if ((Build.VERSION.SDK_INT < 21 || (this.f484a.getLetterSpacing() == aVar.d().getLetterSpacing() && TextUtils.equals(this.f484a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) && this.f484a.getFlags() == aVar.d().getFlags()) {
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 24) {
                            if (!this.f484a.getTextLocales().equals(aVar.d().getTextLocales())) {
                                return false;
                            }
                        } else if (i >= 17 && !this.f484a.getTextLocale().equals(aVar.d().getTextLocale())) {
                            return false;
                        }
                        if (this.f484a.getTypeface() == null) {
                            if (aVar.d().getTypeface() != null) {
                                return false;
                            }
                        } else if (!this.f484a.getTypeface().equals(aVar.d().getTypeface())) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return androidx.core.g.c.a(Float.valueOf(this.f484a.getTextSize()), Float.valueOf(this.f484a.getTextScaleX()), Float.valueOf(this.f484a.getTextSkewX()), Float.valueOf(this.f484a.getLetterSpacing()), Integer.valueOf(this.f484a.getFlags()), this.f484a.getTextLocales(), this.f484a.getTypeface(), Boolean.valueOf(this.f484a.isElegantTextHeight()), this.f485b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 21) {
                return androidx.core.g.c.a(Float.valueOf(this.f484a.getTextSize()), Float.valueOf(this.f484a.getTextScaleX()), Float.valueOf(this.f484a.getTextSkewX()), Float.valueOf(this.f484a.getLetterSpacing()), Integer.valueOf(this.f484a.getFlags()), this.f484a.getTextLocale(), this.f484a.getTypeface(), Boolean.valueOf(this.f484a.isElegantTextHeight()), this.f485b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 18) {
                return androidx.core.g.c.a(Float.valueOf(this.f484a.getTextSize()), Float.valueOf(this.f484a.getTextScaleX()), Float.valueOf(this.f484a.getTextSkewX()), Integer.valueOf(this.f484a.getFlags()), this.f484a.getTextLocale(), this.f484a.getTypeface(), this.f485b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 17) {
                return androidx.core.g.c.a(Float.valueOf(this.f484a.getTextSize()), Float.valueOf(this.f484a.getTextScaleX()), Float.valueOf(this.f484a.getTextSkewX()), Integer.valueOf(this.f484a.getFlags()), this.f484a.getTextLocale(), this.f484a.getTypeface(), this.f485b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            return androidx.core.g.c.a(Float.valueOf(this.f484a.getTextSize()), Float.valueOf(this.f484a.getTextScaleX()), Float.valueOf(this.f484a.getTextSkewX()), Integer.valueOf(this.f484a.getFlags()), this.f484a.getTypeface(), this.f485b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f484a.getTextSize());
            sb.append(", textScaleX=" + this.f484a.getTextScaleX());
            sb.append(", textSkewX=" + this.f484a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f484a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f484a.isElegantTextHeight());
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                sb.append(", textLocale=" + this.f484a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f484a.getTextLocale());
            }
            sb.append(", typeface=" + this.f484a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f484a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f485b);
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f484a = params.getTextPaint();
            this.f485b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            this.e = params;
        }
    }
}
