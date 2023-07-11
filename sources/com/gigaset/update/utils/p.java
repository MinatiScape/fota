package com.gigaset.update.utils;

import android.text.TextUtils;
import com.gigaset.update.bean.RootErrBean;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
/* compiled from: RootCheck.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f1178a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f1179b;
    private List<String> c;
    private Map<String, String> d;
    private RootErrBean e;

    /* JADX WARN: Removed duplicated region for block: B:56:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String b(java.lang.String r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            r8 = 1048576(0x100000, float:1.469368E-39)
            byte[] r8 = new byte[r8]     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            if (r2 != 0) goto L20
            r3.close()     // Catch: java.io.IOException -> L1b
            goto L1f
        L1b:
            r8 = move-exception
            r8.printStackTrace()
        L1f:
            return r1
        L20:
            int r4 = r3.read(r8)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L2c
            r2.update(r8, r6, r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            goto L20
        L2c:
            byte[] r8 = r2.digest()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            if (r8 != 0) goto L3b
            r3.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L36:
            r8 = move-exception
            r8.printStackTrace()
        L3a:
            return r1
        L3b:
            int r2 = r8.length     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
        L3c:
            if (r6 >= r2) goto L58
            r4 = r8[r6]     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            r4 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            int r5 = r4.length()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            r7 = 1
            if (r5 != r7) goto L52
            java.lang.String r5 = "0"
            r0.append(r5)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
        L52:
            r0.append(r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            int r6 = r6 + 1
            goto L3c
        L58:
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L92
            r3.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r0 = move-exception
            r0.printStackTrace()
        L64:
            return r8
        L65:
            r8 = move-exception
            goto L6c
        L67:
            r8 = move-exception
            r3 = r1
            goto L93
        L6a:
            r8 = move-exception
            r3 = r1
        L6c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
            r0.<init>()     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = "getFileMD5, Exception "
            r0.append(r2)     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r8.toString()     // Catch: java.lang.Throwable -> L92
            r0.append(r2)     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L92
            com.gigaset.update.utils.LogUtil.a(r0)     // Catch: java.lang.Throwable -> L92
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L91
            r3.close()     // Catch: java.io.IOException -> L8d
            goto L91
        L8d:
            r8 = move-exception
            r8.printStackTrace()
        L91:
            return r1
        L92:
            r8 = move-exception
        L93:
            if (r3 == 0) goto L9d
            r3.close()     // Catch: java.io.IOException -> L99
            goto L9d
        L99:
            r0 = move-exception
            r0.printStackTrace()
        L9d:
            goto L9f
        L9e:
            throw r8
        L9f:
            goto L9e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.p.b(java.lang.String):java.lang.String");
    }

    private boolean c(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (a(file)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0190  */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [org.apache.commons.compress.archivers.sevenz.SevenZFile] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.lang.String r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.p.a(java.lang.String):java.lang.String");
    }

    private void a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, StandardCharsets.UTF_8));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.indexOf("\t") > -1) {
                            String[] split = readLine.split("\t");
                            if (split.length > 0) {
                                String str = "/system/" + split[0];
                                try {
                                    this.d.put(str, split[1]);
                                    LogUtil.a("checkDevicesIsRoot " + str + " md5Encode " + split[1]);
                                } catch (Exception unused) {
                                    this.d.put(str, "");
                                }
                            }
                        }
                    } else {
                        bufferedInputStream.close();
                        bufferedReader.close();
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream.close();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    private boolean a(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!this.d.containsKey(absolutePath)) {
            LogUtil.a("path " + absolutePath + " is un exist");
            this.f1178a.add(absolutePath);
            this.e.setAdd(this.f1178a);
        } else if (this.d.containsKey(absolutePath)) {
            if (this.d.get(absolutePath).equals("ignore")) {
                this.d.remove(absolutePath);
            } else if (file.isDirectory()) {
                LogUtil.a("path " + absolutePath + " is directory");
                try {
                    Thread.sleep(5L);
                    this.d.remove(absolutePath);
                    c(absolutePath);
                } catch (Exception unused) {
                }
            } else if (file.isFile()) {
                try {
                    String b2 = b(absolutePath);
                    if (!TextUtils.isEmpty(b2) && !this.d.get(absolutePath).equals(b2)) {
                        this.f1179b.add(absolutePath);
                        this.e.setModify(this.f1179b);
                    }
                    this.d.remove(absolutePath);
                } catch (Exception unused2) {
                    this.d.remove(absolutePath);
                }
            } else {
                this.d.remove(absolutePath);
            }
        }
        return this.f1178a.size() + this.f1179b.size() > 5;
    }
}
