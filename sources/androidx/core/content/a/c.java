package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0008c[] f439a;

        public b(C0008c[] c0008cArr) {
            this.f439a = c0008cArr;
        }

        public C0008c[] a() {
            return this.f439a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0008c {

        /* renamed from: a  reason: collision with root package name */
        private final String f440a;

        /* renamed from: b  reason: collision with root package name */
        private int f441b;
        private boolean c;
        private String d;
        private int e;
        private int f;

        public C0008c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f440a = str;
            this.f441b = i;
            this.c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String a() {
            return this.f440a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.f441b;
        }

        public boolean f() {
            return this.c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.core.e.a f442a;

        /* renamed from: b  reason: collision with root package name */
        private final int f443b;
        private final int c;

        public d(androidx.core.e.a aVar, int i, int i2) {
            this.f442a = aVar;
            this.c = i;
            this.f443b = i2;
        }

        public int a() {
            return this.c;
        }

        public androidx.core.e.a b() {
            return this.f442a;
        }

        public int c() {
            return this.f443b;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new androidx.core.e.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0008c[]) arrayList.toArray(new C0008c[arrayList.size()]));
    }

    private static C0008c d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontWeight) ? R$styleable.FontFamilyFont_fontWeight : R$styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontStyle) ? R$styleable.FontFamilyFont_fontStyle : R$styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_ttcIndex) ? R$styleable.FontFamilyFont_ttcIndex : R$styleable.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontVariationSettings) ? R$styleable.FontFamilyFont_fontVariationSettings : R$styleable.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_font) ? R$styleable.FontFamilyFont_font : R$styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0008c(string2, i, z, string, i3, resourceId);
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
