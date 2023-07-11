package androidx.core.e;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.a.h;
import androidx.core.e.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static final a.b.g<String, Typeface> f457a = new a.b.g<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final k f458b = new k("fonts", 10, 10000);
    static final Object c = new Object();
    static final a.b.i<String, ArrayList<k.a<c>>> d = new a.b.i<>();
    private static final Comparator<byte[]> e = new e();

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f459a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f460b;

        public a(int i, b[] bVarArr) {
            this.f459a = i;
            this.f460b = bVarArr;
        }

        public b[] a() {
            return this.f460b;
        }

        public int b() {
            return this.f459a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f461a;

        /* renamed from: b  reason: collision with root package name */
        private final int f462b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            androidx.core.g.h.a(uri);
            this.f461a = uri;
            this.f462b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public int a() {
            return this.e;
        }

        public int b() {
            return this.f462b;
        }

        public Uri c() {
            return this.f461a;
        }

        public int d() {
            return this.c;
        }

        public boolean e() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f463a;

        /* renamed from: b  reason: collision with root package name */
        final int f464b;

        c(Typeface typeface, int i) {
            this.f463a = typeface;
            this.f464b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Context context, androidx.core.e.a aVar, int i) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            if (a2.b() == 0) {
                Typeface a3 = androidx.core.a.c.a(context, null, a2.a(), i);
                return new c(a3, a3 != null ? 0 : -3);
            }
            return new c(null, a2.b() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    public static Typeface a(Context context, androidx.core.e.a aVar, h.a aVar2, Handler handler, boolean z, int i, int i2) {
        String str = aVar.c() + "-" + i2;
        Typeface b2 = f457a.b(str);
        if (b2 != null) {
            if (aVar2 != null) {
                aVar2.a(b2);
            }
            return b2;
        } else if (z && i == -1) {
            c a2 = a(context, aVar, i2);
            if (aVar2 != null) {
                int i3 = a2.f464b;
                if (i3 == 0) {
                    aVar2.a(a2.f463a, handler);
                } else {
                    aVar2.a(i3, handler);
                }
            }
            return a2.f463a;
        } else {
            androidx.core.e.b bVar = new androidx.core.e.b(context, aVar, i2, str);
            if (z) {
                try {
                    return ((c) f458b.a(bVar, i)).f463a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            androidx.core.e.c cVar = aVar2 == null ? null : new androidx.core.e.c(aVar2, handler);
            synchronized (c) {
                if (d.containsKey(str)) {
                    if (cVar != null) {
                        d.get(str).add(cVar);
                    }
                    return null;
                }
                if (cVar != null) {
                    ArrayList<k.a<c>> arrayList = new ArrayList<>();
                    arrayList.add(cVar);
                    d.put(str, arrayList);
                }
                f458b.a(bVar, new d(str));
                return null;
            }
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.a() == 0) {
                Uri c2 = bVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, androidx.core.a.k.a(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, androidx.core.e.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new a(1, null);
        }
        return new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, androidx.core.e.a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(aVar.e())) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, e);
                List<List<byte[]>> a3 = a(aVar, resources);
                for (int i = 0; i < a3.size(); i++) {
                    ArrayList arrayList = new ArrayList(a3.get(i));
                    Collections.sort(arrayList, e);
                    if (a(a2, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
    }

    private static List<List<byte[]>> a(androidx.core.e.a aVar, Resources resources) {
        if (aVar.a() != null) {
            return aVar.a();
        }
        return androidx.core.content.a.c.a(resources, aVar.b());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    static b[] a(Context context, androidx.core.e.a aVar, String str, CancellationSignal cancellationSignal) {
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new b(withAppendedId, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (b[]) arrayList.toArray(new b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
