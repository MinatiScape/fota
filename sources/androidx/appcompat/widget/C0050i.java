package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.utils.CharsetNames;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityChooserModel.java */
/* renamed from: androidx.appcompat.widget.i  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0050i extends DataSetObservable {

    /* renamed from: a  reason: collision with root package name */
    static final String f327a = "i";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f328b = new Object();
    private static final Map<String, C0050i> c = new HashMap();
    private final Object d;
    private final List<b> e;
    private final List<d> f;
    final Context g;
    final String h;
    private Intent i;
    private c j;
    private int k;
    boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private e p;

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.i$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.i$b */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final ResolveInfo f329a;

        /* renamed from: b  reason: collision with root package name */
        public float f330b;

        public b(ResolveInfo resolveInfo) {
            this.f329a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            return Float.floatToIntBits(bVar.f330b) - Float.floatToIntBits(this.f330b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && Float.floatToIntBits(this.f330b) == Float.floatToIntBits(((b) obj).f330b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f330b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f329a.toString() + "; weight:" + new BigDecimal(this.f330b) + "]";
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.i$c */
    /* loaded from: classes.dex */
    public interface c {
        void sort(Intent intent, List<b> list, List<d> list2);
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.i$d */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f331a;

        /* renamed from: b  reason: collision with root package name */
        public final long f332b;
        public final float c;

        public d(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                ComponentName componentName = this.f331a;
                if (componentName == null) {
                    if (dVar.f331a != null) {
                        return false;
                    }
                } else if (!componentName.equals(dVar.f331a)) {
                    return false;
                }
                return this.f332b == dVar.f332b && Float.floatToIntBits(this.c) == Float.floatToIntBits(dVar.c);
            }
            return false;
        }

        public int hashCode() {
            ComponentName componentName = this.f331a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f332b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public String toString() {
            return "[; activity:" + this.f331a + "; time:" + this.f332b + "; weight:" + new BigDecimal(this.c) + "]";
        }

        public d(ComponentName componentName, long j, float f) {
            this.f331a = componentName;
            this.f332b = j;
            this.c = f;
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.i$e */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(C0050i c0050i, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.i$f */
    /* loaded from: classes.dex */
    public final class f extends AsyncTask<Object, Void, Void> {
        f() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r15 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x006f, code lost:
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0092, code lost:
            if (r15 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b2, code lost:
            if (r15 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d2, code lost:
            if (r15 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d5, code lost:
            return null;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0050i.f.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private void d() {
        boolean e2 = e() | h();
        g();
        if (e2) {
            j();
            notifyChanged();
        }
    }

    private boolean e() {
        if (!this.o || this.i == null) {
            return false;
        }
        this.o = false;
        this.e.clear();
        List<ResolveInfo> queryIntentActivities = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new b(queryIntentActivities.get(i)));
        }
        return true;
    }

    private void f() {
        if (this.m) {
            if (this.n) {
                this.n = false;
                if (TextUtils.isEmpty(this.h)) {
                    return;
                }
                new f().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f), this.h);
                return;
            }
            return;
        }
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void g() {
        int size = this.f.size() - this.k;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.f.remove(0);
        }
    }

    private boolean h() {
        if (this.l && this.n && !TextUtils.isEmpty(this.h)) {
            this.l = false;
            this.m = true;
            i();
            return true;
        }
        return false;
    }

    private void i() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.g.openFileInput(this.h);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, CharsetNames.UTF_8);
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                    } catch (IOException e2) {
                        String str = f327a;
                        Log.e(str, "Error reading historical recrod file: " + this.h, e2);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (XmlPullParserException e3) {
                    String str2 = f327a;
                    Log.e(str2, "Error reading historical recrod file: " + this.h, e3);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<d> list = this.f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (next != 3 && next != 4) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new d(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    private boolean j() {
        if (this.j == null || this.i == null || this.e.isEmpty() || this.f.isEmpty()) {
            return false;
        }
        this.j.sort(this.i, this.e, Collections.unmodifiableList(this.f));
        return true;
    }

    public int a() {
        int size;
        synchronized (this.d) {
            d();
            size = this.e.size();
        }
        return size;
    }

    public ResolveInfo b(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.d) {
            d();
            resolveInfo = this.e.get(i).f329a;
        }
        return resolveInfo;
    }

    public void c(int i) {
        synchronized (this.d) {
            d();
            b bVar = this.e.get(i);
            b bVar2 = this.e.get(0);
            a(new d(new ComponentName(bVar.f329a.activityInfo.packageName, bVar.f329a.activityInfo.name), System.currentTimeMillis(), bVar2 != null ? (bVar2.f330b - bVar.f330b) + 5.0f : 1.0f));
        }
    }

    public void setOnChooseActivityListener(e eVar) {
        synchronized (this.d) {
            this.p = eVar;
        }
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.d) {
            d();
            List<b> list = this.e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f329a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo b() {
        synchronized (this.d) {
            d();
            if (this.e.isEmpty()) {
                return null;
            }
            return this.e.get(0).f329a;
        }
    }

    public int c() {
        int size;
        synchronized (this.d) {
            d();
            size = this.f.size();
        }
        return size;
    }

    public Intent a(int i) {
        synchronized (this.d) {
            if (this.i == null) {
                return null;
            }
            d();
            b bVar = this.e.get(i);
            ComponentName componentName = new ComponentName(bVar.f329a.activityInfo.packageName, bVar.f329a.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new d(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    private boolean a(d dVar) {
        boolean add = this.f.add(dVar);
        if (add) {
            this.n = true;
            g();
            f();
            j();
            notifyChanged();
        }
        return add;
    }
}
