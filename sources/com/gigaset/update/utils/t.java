package com.gigaset.update.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.gigaset.update.MyApplication;
import com.gigaset.update.bean.VersionBean;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
/* compiled from: StorageUtil.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static String f1185a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f1186b = null;
    private static String c = null;
    private static double d = 2.5d;

    /* compiled from: StorageUtil.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1187a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1188b;
        public final boolean c;
        public final int d;

        a(String str, boolean z, boolean z2, int i) {
            this.f1187a = str;
            this.f1188b = z;
            this.c = z2;
            this.d = i;
        }
    }

    public static int b(Context context, long j) {
        try {
            VersionBean c2 = com.gigaset.update.e.c.a().c();
            d = (c2 != null ? c2.getIsOldPkg() : 0) == 0 ? 2.5d : 1.0d;
            return d(context, ((long) d) * j);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean c(Context context, long j) {
        return a(b(context, true), a(j));
    }

    public static int d(Context context, long j) {
        long f = f(context, j);
        LogUtil.a("size = " + f);
        if (f == 0) {
            return 3;
        }
        return f == -1 ? 1 : 2;
    }

    public static boolean e(Context context, long j) {
        long a2 = a(j);
        if (!h(context)) {
            return g(context, a2);
        }
        boolean a3 = a(b(context, true), a2);
        return !a3 ? g(context, a2) : a3;
    }

    public static void f(Context context) {
        try {
            context.getExternalFilesDir(null);
            new File(context.getFilesDir() + "/gigasetfota").mkdirs();
            new File(context.getExternalFilesDir(null) + "/gigasetfota").mkdirs();
            new File(context.getExternalFilesDir(null) + "/fota").mkdirs();
            new r(context).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean g(Context context) {
        String l;
        String a2 = o.a(context, "ota_download_path", (String) null);
        if (!TextUtils.isEmpty(a2) && a2.contains("#")) {
            String[] split = a2.split("#");
            if (split.length == 3) {
                a(split[0], split[1], split[2]);
            }
        }
        String str = f1185a;
        if (str != null && str.length() > 0 && !f1185a.equals("null")) {
            l = b(f1185a);
        } else {
            l = l(context);
        }
        LogUtil.a("externalStorageState = " + l);
        return "mounted".equals(l);
    }

    public static boolean h(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            if (Build.VERSION.SDK_INT < 24) {
                try {
                    int length = Array.getLength(storageManager.getClass().getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]));
                    LogUtil.a("storage count : " + length);
                    return length > 1;
                } catch (Exception unused) {
                }
            } else {
                int size = storageManager.getStorageVolumes().size();
                LogUtil.a("storage count : " + size);
                return size > 1;
            }
        }
        return Environment.getExternalStorageState().equalsIgnoreCase("mounted");
    }

    private static String i(Context context) {
        String a2 = o.a(context, "CustomDtPath", "");
        if (TextUtils.isEmpty(a2) || !new File(a2).exists()) {
            String b2 = b(context, true);
            if (TextUtils.isEmpty(b2)) {
                return "";
            }
            String str = b2 + "/Android/data/" + context.getPackageName() + "/files";
            o.b(context, "CustomDtPath", str);
            return str;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context) {
        try {
            File file = new File(context.getFilesDir().getPath() + "/gigasetfota/update.zip");
            if (file.exists()) {
                LogUtil.a("delete " + file);
                file.delete();
            }
            File file2 = new File(context.getFilesDir().getPath() + "/update.zip");
            if (file2.exists()) {
                LogUtil.a("delete " + file2);
                file2.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File k(Context context) {
        return new File(a(context, true));
    }

    private static String l(Context context) {
        return b(k(context).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (r0.equals("internal") == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String m(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.t.m(android.content.Context):java.lang.String");
    }

    private static boolean n(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            try {
                Object invoke = storageManager.getClass().getMethod("getVolumes", new Class[0]).invoke(storageManager, new Object[0]);
                for (int i = 0; i < Array.getLength(invoke); i++) {
                    Object obj = Array.get(invoke, i);
                    Method method = obj.getClass().getMethod("getType", new Class[0]);
                    Method method2 = obj.getClass().getMethod("getState", new Class[0]);
                    Method method3 = obj.getClass().getMethod("getDisk", new Class[0]);
                    if (((Integer) method.invoke(obj, new Object[0])).intValue() == 0 && ((Integer) method2.invoke(obj, new Object[0])).intValue() == 2) {
                        Object invoke2 = method3.invoke(obj, new Object[0]);
                        return ((Integer) invoke2.getClass().getField("volumeCount").get(invoke2)).intValue() > 1;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String c() {
        return Environment.getExternalStorageDirectory() + File.separator + "Android/";
    }

    public static boolean a(Context context, long j) {
        return g(context, a(j));
    }

    public static String c(Context context) {
        return context.getExternalFilesDir(null) + File.separator;
    }

    private static boolean d(String str) {
        long j;
        try {
            File file = new File(str);
            if (!file.exists() && !file.mkdir() && !file.mkdirs()) {
                LogUtil.a(str + ",mkdir fail");
                return false;
            }
            StatFs statFs = new StatFs(file.getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            VersionBean c2 = com.gigaset.update.e.c.a().c();
            double d2 = 1.0d;
            if (c2 != null) {
                j = c2.getFileSize();
                if (c2.getIsOldPkg() == 0) {
                    d2 = 2.5d;
                }
            } else {
                j = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("availableBlock = ");
            long j2 = availableBlocks * blockSize;
            sb.append(j2);
            sb.append("; needSize = ");
            sb.append(j);
            LogUtil.a(sb.toString());
            if (j != 0) {
                double d3 = j;
                Double.isNaN(d3);
                if (j2 <= d3 * d2) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            LogUtil.b(str + " card mount error");
            return false;
        }
    }

    private static long a(long j) {
        VersionBean c2 = com.gigaset.update.e.c.a().c();
        d = (c2 != null ? c2.getIsOldPkg() : 0) == 0 ? 2.5d : 1.0d;
        double d2 = d;
        double d3 = j;
        Double.isNaN(d3);
        return Double.valueOf(d2 * d3).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0095 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:7:0x000f, B:9:0x002b, B:10:0x0043, B:12:0x005f, B:13:0x0077, B:15:0x007d, B:18:0x0084, B:20:0x008f, B:22:0x0095, B:24:0x00b1, B:19:0x008a), top: B:31:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b7, blocks: (B:7:0x000f, B:9:0x002b, B:10:0x0043, B:12:0x005f, B:13:0x0077, B:15:0x007d, B:18:0x0084, B:20:0x008f, B:22:0x0095, B:24:0x00b1, B:19:0x008a), top: B:31:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c(java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto Lc0
            boolean r0 = d(r5)
            if (r0 != 0) goto Lf
            goto Lc0
        Lf:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> Lb7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb7
            r2.<init>()     // Catch: java.lang.Exception -> Lb7
            r2.append(r5)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r3 = "/test/test.txt"
            r2.append(r3)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lb7
            r0.<init>(r2)     // Catch: java.lang.Exception -> Lb7
            boolean r2 = r0.exists()     // Catch: java.lang.Exception -> Lb7
            if (r2 == 0) goto L43
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb7
            r2.<init>()     // Catch: java.lang.Exception -> Lb7
            java.lang.String r3 = "file.exists,so delete="
            r2.append(r3)     // Catch: java.lang.Exception -> Lb7
            boolean r3 = r0.delete()     // Catch: java.lang.Exception -> Lb7
            r2.append(r3)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lb7
            com.gigaset.update.utils.LogUtil.a(r2)     // Catch: java.lang.Exception -> Lb7
        L43:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> Lb7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb7
            r3.<init>()     // Catch: java.lang.Exception -> Lb7
            r3.append(r5)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r4 = "/test/"
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Lb7
            r2.<init>(r3)     // Catch: java.lang.Exception -> Lb7
            boolean r3 = r2.exists()     // Catch: java.lang.Exception -> Lb7
            if (r3 == 0) goto L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb7
            r3.<init>()     // Catch: java.lang.Exception -> Lb7
            java.lang.String r4 = "fileDir.exists,so delete="
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            boolean r4 = r2.delete()     // Catch: java.lang.Exception -> Lb7
            r3.append(r4)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Lb7
            com.gigaset.update.utils.LogUtil.a(r3)     // Catch: java.lang.Exception -> Lb7
        L77:
            boolean r3 = r2.mkdirs()     // Catch: java.lang.Exception -> Lb7
            if (r3 != 0) goto L8a
            boolean r3 = r2.mkdir()     // Catch: java.lang.Exception -> Lb7
            if (r3 == 0) goto L84
            goto L8a
        L84:
            java.lang.String r3 = "mkdirs  failed!!"
            com.gigaset.update.utils.LogUtil.a(r3)     // Catch: java.lang.Exception -> Lb7
            goto L8f
        L8a:
            java.lang.String r3 = "mkdirs  success"
            com.gigaset.update.utils.LogUtil.a(r3)     // Catch: java.lang.Exception -> Lb7
        L8f:
            boolean r3 = r0.createNewFile()     // Catch: java.lang.Exception -> Lb7
            if (r3 == 0) goto Lb1
            r0.delete()     // Catch: java.lang.Exception -> Lb7
            r2.delete()     // Catch: java.lang.Exception -> Lb7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb7
            r0.<init>()     // Catch: java.lang.Exception -> Lb7
            java.lang.String r2 = "sdcard = "
            r0.append(r2)     // Catch: java.lang.Exception -> Lb7
            r0.append(r5)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Exception -> Lb7
            com.gigaset.update.utils.LogUtil.a(r5)     // Catch: java.lang.Exception -> Lb7
            r5 = 1
            return r5
        Lb1:
            java.lang.String r5 = "createNewFile failed!!"
            com.gigaset.update.utils.LogUtil.a(r5)     // Catch: java.lang.Exception -> Lb7
            return r1
        Lb7:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.gigaset.update.utils.LogUtil.a(r5)
            return r1
        Lc0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "invalid path "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.gigaset.update.utils.LogUtil.a(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.t.c(java.lang.String):boolean");
    }

    public static String b(String str) {
        LogUtil.a("path = " + str);
        try {
            StatFs statFs = new StatFs(new File(str).getPath());
            if (statFs.getBlockCount() * statFs.getBlockSize() <= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) {
                return "removed";
            }
            if (str.contains(Environment.getExternalStorageDirectory().getAbsolutePath())) {
                LogUtil.a("Environment.getExternalStorageState = " + Environment.getExternalStorageState());
                return Environment.getExternalStorageState();
            }
            if (!str.startsWith("/data/data") && c(str)) {
            }
            return "mounted";
        } catch (Exception e) {
            LogUtil.a(e.toString());
            return Build.VERSION.SDK_INT < 23 ? "removed" : "unmounted";
        }
    }

    private static long e() {
        VersionBean c2 = com.gigaset.update.e.c.a().c();
        if (c2 != null) {
            d = c2.getIsOldPkg() == 0 ? 2.5d : 1.0d;
            double d2 = d;
            double fileSize = c2.getFileSize();
            Double.isNaN(fileSize);
            return Double.valueOf(d2 * fileSize).longValue();
        }
        return 0L;
    }

    public static boolean a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.isFile()) {
            return false;
        }
        long freeSpace = file.getFreeSpace();
        LogUtil.a("path ：" + str + " ; total : " + Formatter.formatFileSize(MyApplication.c(), freeSpace) + " ; minSize : " + Formatter.formatFileSize(MyApplication.c(), j));
        return freeSpace - j > 0;
    }

    private static long f(Context context, long j) {
        try {
            StatFs statFs = new StatFs(k(context).getPath());
            long blockSize = statFs.getBlockSize() * statFs.getAvailableBlocks();
            File file = new File(d(context));
            if (file.exists()) {
                j -= file.length();
            }
            LogUtil.a("totalSize = " + blockSize + "; miniSize = " + j);
            return blockSize < j ? j - blockSize : blockSize > j + 10 ? 0L : -1L;
        } catch (Exception unused) {
            LogUtil.b("card mount error");
            return -1L;
        }
    }

    public static String e(Context context) {
        int c2 = com.gigaset.update.b.d.c(context);
        String a2 = o.a(context, "update_package_path", "");
        if ((c2 == 4 || c2 == 6) && !TextUtils.isEmpty(a2)) {
            return a2;
        }
        if (Build.VERSION.SDK_INT <= 27 || !c.k().F()) {
            return a(context, true) + "/gigasetfota";
        }
        return "/data/ota_package";
    }

    private static boolean g(Context context, long j) {
        return a(context.getFilesDir().getAbsolutePath(), j);
    }

    public static String a(Context context, boolean z) {
        String m;
        String str = f1185a;
        boolean z2 = true;
        boolean z3 = (str == null || str.length() <= 0 || f1185a.equals("null")) ? false : true;
        String str2 = f1186b;
        boolean z4 = (str2 == null || str2.length() <= 0 || f1186b.equals("null")) ? false : true;
        String str3 = c;
        z2 = (str3 == null || str3.length() <= 0 || c.equals("null")) ? false : false;
        LogUtil.a("download_path_server : " + com.gigaset.update.e.c.a().a("download_path_server", Integer.class));
        if (z3 && "mounted".equals(b(f1185a))) {
            m = f1185a;
        } else if (z4 && "mounted".equals(b(f1186b))) {
            m = f1186b;
        } else if (z2 && "mounted".equals(b(c))) {
            m = c;
        } else {
            m = m(context);
        }
        LogUtil.a(z, "sdcard = " + m);
        return m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fb, code lost:
        if (r6 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fd, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0105, code lost:
        if (r6 == null) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.gigaset.update.utils.t.a> d() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.t.d():java.util.List");
    }

    public static String b(Context context) {
        if (h(context) && g.b(context)) {
            String str = b(context, true) + "/Android/data/" + context.getPackageName() + "/files";
            if (a(str, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                return str;
            }
        }
        return c(context);
    }

    public static boolean c(Context context, String str) {
        String b2 = b(context, false);
        return b2 != null && str.startsWith(b2);
    }

    public static File b() {
        try {
            File file = new File("/cache/recovery/last_error_log");
            if (file.exists()) {
                LogUtil.a("last_log exist");
                return file;
            }
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
        LogUtil.a("last_log not exist");
        return null;
    }

    public static void a() {
        File b2 = b();
        if (b2 != null) {
            b2.delete();
        }
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String b2 = b(context, true);
        String b3 = b(context, false);
        return (b2 == null || !str.startsWith(b2)) ? (b3 == null || !str.startsWith(b3)) ? "" : b3 : b2;
    }

    public static void a(String str, String str2, String str3) {
        if (str != null && str.length() > 0 && !str.equals("null")) {
            f1185a = str;
        }
        if (str2 != null && str2.length() > 0 && !str2.equals("null")) {
            f1186b = str2;
        }
        if (str3 != null && str3.length() > 0 && !str3.equals("null")) {
            c = str3;
        }
        LogUtil.a("upgradePath1 = " + f1185a + ", upgradePath2 = " + f1186b + ", upgradePath3 = " + c);
    }

    public static String b(Context context, boolean z) {
        LogUtil.a("outSdcard : " + z);
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            try {
                if (Build.VERSION.SDK_INT < 24) {
                    Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                    Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                    Method method2 = cls.getMethod("getPath", new Class[0]);
                    Method method3 = cls.getMethod("isEmulated", new Class[0]);
                    Object invoke = method.invoke(storageManager, new Object[0]);
                    int length = Array.getLength(invoke);
                    for (int i = 0; i < length; i++) {
                        Object obj = Array.get(invoke, i);
                        String str = (String) method2.invoke(obj, new Object[0]);
                        boolean booleanValue = ((Boolean) method3.invoke(obj, new Object[0])).booleanValue();
                        LogUtil.a("emulated = " + booleanValue + "; path = " + str);
                        if (z == (!booleanValue) && !str.startsWith("/dev/null")) {
                            return str;
                        }
                    }
                    return null;
                }
                for (StorageVolume storageVolume : storageManager.getStorageVolumes()) {
                    boolean isEmulated = storageVolume.isEmulated();
                    String obj2 = storageVolume.getClass().getMethod("getPath", new Class[0]).invoke(storageVolume, new Object[0]).toString();
                    LogUtil.a("emulated = " + isEmulated + "; path = " + obj2);
                    if (z == (!isEmulated) && !obj2.startsWith("/dev/null")) {
                        return obj2;
                    }
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, String str) {
        new s(str, context).start();
    }

    public static void a(String str) {
        LogUtil.a("path = " + str);
        File file = new File(str + "/modem.bin");
        if (file.exists()) {
            LogUtil.a("delete " + file);
            file.delete();
        }
        File file2 = new File(str + "/nvitem.bin");
        if (file2.exists()) {
            LogUtil.a("delete " + file2);
            file2.delete();
        }
        File file3 = new File(str + "/dsp.bin");
        if (file3.exists()) {
            LogUtil.a("delete " + file3);
            file3.delete();
        }
        File file4 = new File(str + "/vmjaluna.bin");
        if (file4.exists()) {
            LogUtil.a("delete " + file4);
            file4.delete();
        }
    }

    public static String d(Context context) {
        String str = e(context) + "/update.zip";
        LogUtil.a("filename = " + str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file) {
        String[] list;
        LogUtil.a("destfile = " + file);
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!b(new File(file, str))) {
                    LogUtil.a("deleteErrFileExt err");
                    return false;
                }
            }
        }
        return file.delete();
    }
}
