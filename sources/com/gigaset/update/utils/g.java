package com.gigaset.update.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* compiled from: FileUtil.java */
/* loaded from: classes.dex */
public class g {
    public static void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (Exception e2) {
                fileOutputStream2 = fileOutputStream;
                e = e2;
                LogUtil.a("writeByteData : Exception = " + e.toString());
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(file.getParent());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            LogUtil.b(false);
            LogUtil.a("write2Sd : " + file2.getAbsolutePath() + " mkdirs failed !");
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())) + "=======" + str2 + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.lang.String r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r8 = 262144(0x40000, float:3.67342E-40)
            byte[] r8 = new byte[r8]     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            if (r2 != 0) goto L23
            r3.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r8 = move-exception
            r8.printStackTrace()
        L22:
            return r1
        L23:
            int r4 = r3.read(r8)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L2f
            r2.update(r8, r6, r4)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            goto L23
        L2f:
            byte[] r8 = r2.digest()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            if (r8 != 0) goto L3e
            r3.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r8 = move-exception
            r8.printStackTrace()
        L3d:
            return r1
        L3e:
            int r2 = r8.length     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
        L3f:
            if (r6 >= r2) goto L5b
            r4 = r8[r6]     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            r4 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            int r5 = r4.length()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            r7 = 1
            if (r5 != r7) goto L55
            java.lang.String r5 = "0"
            r0.append(r5)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
        L55:
            r0.append(r4)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            int r6 = r6 + 1
            goto L3f
        L5b:
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> L95
            r3.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r0 = move-exception
            r0.printStackTrace()
        L67:
            return r8
        L68:
            r8 = move-exception
            goto L6f
        L6a:
            r8 = move-exception
            r3 = r1
            goto L96
        L6d:
            r8 = move-exception
            r3 = r1
        L6f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r0.<init>()     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = "getFileMD5, Exception "
            r0.append(r2)     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = r8.toString()     // Catch: java.lang.Throwable -> L95
            r0.append(r2)     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L95
            com.gigaset.update.utils.LogUtil.a(r0)     // Catch: java.lang.Throwable -> L95
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L95
            if (r3 == 0) goto L94
            r3.close()     // Catch: java.io.IOException -> L90
            goto L94
        L90:
            r8 = move-exception
            r8.printStackTrace()
        L94:
            return r1
        L95:
            r8 = move-exception
        L96:
            if (r3 == 0) goto La0
            r3.close()     // Catch: java.io.IOException -> L9c
            goto La0
        L9c:
            r0 = move-exception
            r0.printStackTrace()
        La0:
            goto La2
        La1:
            throw r8
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.g.c(java.lang.String):java.lang.String");
    }

    public static long d(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return 0L;
    }

    public static List<String> e(String str) {
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream;
        BufferedReader bufferedReader;
        LogUtil.a("zipFile=" + str + " , " + new File(str).exists());
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        try {
            zipFile = new ZipFile(str);
            try {
                ZipEntry entry = zipFile.getEntry("payload_properties.txt");
                if (entry != null) {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, StandardCharsets.UTF_8));
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (TextUtils.isEmpty(readLine)) {
                                        break;
                                    }
                                    LogUtil.a("getHeaderValue,line=" + readLine);
                                    arrayList.add(readLine);
                                } catch (IOException e) {
                                    bufferedReader2 = bufferedReader;
                                    e = e;
                                    LogUtil.a("upZipFile:IOException = " + e.toString());
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException unused) {
                                            return arrayList;
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (zipFile != null) {
                                        zipFile.close();
                                    }
                                    return arrayList;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException unused2) {
                                            throw th;
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (zipFile != null) {
                                        zipFile.close();
                                    }
                                    throw th;
                                }
                            }
                            bufferedInputStream2 = bufferedInputStream;
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    bufferedReader = null;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                zipFile.close();
                LogUtil.a("getHeaderValue : " + arrayList);
                return arrayList;
            } catch (IOException e3) {
                e = e3;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            zipFile = null;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(java.lang.String r5) {
        /*
            java.lang.String r0 = "getMD5sum"
            com.gigaset.update.utils.LogUtil.a(r0)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            r5 = 64
            byte[] r5 = new byte[r5]     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            int r2 = r1.read(r5)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            r3.<init>()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            java.lang.String r4 = "getMD5sum 1, length = "
            r3.append(r4)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            r3.append(r2)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            com.gigaset.update.utils.LogUtil.a(r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            r3 = 32
            if (r2 <= r3) goto L2d
            r2 = 32
        L2d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            r3.<init>()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            java.lang.String r4 = "getMD5sum 2, length = "
            r3.append(r4)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            r3.append(r2)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            com.gigaset.update.utils.LogUtil.a(r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            r4 = 0
            r3.<init>(r5, r4, r2)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L65
            r1.close()     // Catch: java.io.IOException -> L4b
            goto L4f
        L4b:
            r5 = move-exception
            r5.printStackTrace()
        L4f:
            return r3
        L50:
            r5 = move-exception
            goto L57
        L52:
            r5 = move-exception
            r1 = r0
            goto L66
        L55:
            r5 = move-exception
            r1 = r0
        L57:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r5 = move-exception
            r5.printStackTrace()
        L64:
            return r0
        L65:
            r5 = move-exception
        L66:
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r0 = move-exception
            r0.printStackTrace()
        L70:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.g.f(java.lang.String):java.lang.String");
    }

    public static long g(String str) {
        try {
            b.a.a.c.f a2 = new b.a.a.a.b(str).a("payload.bin");
            if (a2 == null) {
                return 0L;
            }
            long f = a2.f() + 30 + 11 + a2.d();
            LogUtil.a("getOffset=" + f);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static boolean h(String str) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            randomAccessFile.seek(0L);
            byte[] bArr = new byte[4];
            int read = randomAccessFile.read(bArr, 0, bArr.length);
            String a2 = a(bArr);
            if (read > 0) {
                if (a2.equalsIgnoreCase("504B0304")) {
                    randomAccessFile.close();
                    return true;
                }
            }
            randomAccessFile.close();
            return false;
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String i(String str) {
        String str2;
        File file;
        try {
            file = new File(str);
        } catch (Exception e) {
            e = e;
            str2 = null;
        }
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str2 = new String(bArr, StandardCharsets.UTF_8);
            try {
                fileInputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return str2;
            }
            return str2;
        }
        return null;
    }

    private static void j(String str) {
        String[] list;
        File file;
        File file2 = new File(str);
        if (file2.exists() && file2.isDirectory() && (list = file2.list()) != null) {
            for (String str2 : list) {
                if (str.endsWith(File.separator)) {
                    file = new File(str + str2);
                } else {
                    file = new File(str + File.separator + str2);
                }
                if (file.isFile()) {
                    file.delete();
                }
                if (file.isDirectory()) {
                    j(str + "/" + str2);
                    a(str + "/" + str2);
                }
            }
        }
    }

    private static boolean k(String str) {
        return new File(str).exists();
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            if (openFileOutput != null) {
                openFileOutput.close();
                return true;
            }
            return true;
        } catch (Exception e) {
            LogUtil.a("writeInternalFile : Exception = " + e.toString());
            return false;
        }
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            str2 = new String(bArr, StandardCharsets.UTF_8);
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                } catch (Exception e) {
                    e = e;
                    LogUtil.a("readInternalFile,Exception e=" + e.getMessage());
                    return str2;
                }
            }
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        return str2;
    }

    public static void b(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "writeMD5File"
            com.gigaset.update.utils.LogUtil.a(r0)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = "/md5sum"
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L22
            return
        L22:
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r3.<init>()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.io.File r6 = r6.getFilesDir()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r3.append(r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r3.append(r7)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r2.<init>(r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            if (r6 == 0) goto L49
            java.lang.String r6 = "writeMD5File, del exists md5sum file"
            com.gigaset.update.utils.LogUtil.a(r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r2.delete()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
        L49:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r7 = "rws"
            r6.<init>(r2, r7)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L9a
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L9a
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r0]     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            r2 = 0
            r3 = 0
        L5b:
            int r4 = r7.read(r1, r2, r0)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            if (r4 <= 0) goto L66
            r6.write(r1, r2, r4)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            int r3 = r3 + r4
            goto L5b
        L66:
            r6.close()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            r7.close()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            r0.<init>()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            java.lang.String r1 = "writeMD5File, finish, i = "
            r0.append(r1)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            r0.append(r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            java.lang.String r1 = "bytes"
            r0.append(r1)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            com.gigaset.update.utils.LogUtil.a(r0)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            r6.close()     // Catch: java.lang.Exception -> L88
        L88:
            r7.close()     // Catch: java.lang.Exception -> Lc1
            goto Lc1
        L8c:
            r0 = move-exception
            r1 = r6
            r6 = r0
            goto Lc3
        L90:
            r0 = move-exception
            r1 = r6
            r6 = r0
            goto La5
        L94:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r5
            goto Lc3
        L9a:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r5
            goto La5
        La0:
            r6 = move-exception
            r7 = r1
            goto Lc3
        La3:
            r6 = move-exception
            r7 = r1
        La5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc2
            r0.<init>()     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r2 = "writeMD5File, Exception"
            r0.append(r2)     // Catch: java.lang.Throwable -> Lc2
            r0.append(r6)     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> Lc2
            com.gigaset.update.utils.LogUtil.a(r6)     // Catch: java.lang.Throwable -> Lc2
            if (r1 == 0) goto Lbe
            r1.close()     // Catch: java.lang.Exception -> Lbe
        Lbe:
            if (r7 == 0) goto Lc1
            goto L88
        Lc1:
            return
        Lc2:
            r6 = move-exception
        Lc3:
            if (r1 == 0) goto Lc8
            r1.close()     // Catch: java.lang.Exception -> Lc8
        Lc8:
            if (r7 == 0) goto Lcd
            r7.close()     // Catch: java.lang.Exception -> Lcd
        Lcd:
            goto Lcf
        Lce:
            throw r6
        Lcf:
            goto Lce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.g.b(android.content.Context, java.lang.String):void");
    }

    public static void a(String str) {
        j(str);
        File file = new File(str);
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        return file.renameTo(new File(str2));
    }

    public static boolean c(Context context) {
        try {
            if (k(context.getExternalFilesDir(null) + "/trace.trace")) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                    return k(Environment.getExternalStorageDirectory() + "/trace.trace");
                }
                return false;
            }
            return k(Environment.getExternalStorageDirectory() + "/trace.trace");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2, Boolean bool) {
        LogUtil.a("copy, oldPath = " + str);
        LogUtil.a("copy, newPath = " + str2);
        boolean z = false;
        try {
            File file = new File(str2);
            File file2 = new File(str);
            if (file.exists()) {
                file.delete();
            } else {
                LogUtil.a("copy, newPath = " + str2 + " is not exist!");
            }
            if (file2.exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                byte[] bArr = new byte[32768];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
                z = true;
                if (bool.booleanValue()) {
                    LogUtil.a("copy success to delete" + file2.delete());
                }
            } else {
                LogUtil.a("copy, oldPath = " + str + " is not exist!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.a("copy, Exception" + e.toString());
        }
        LogUtil.a("copy, isOk " + z);
        return z;
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static String a(long j) {
        String str;
        float f = (float) j;
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "KB";
        } else {
            str = "B";
        }
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "MB";
        }
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "GB";
        }
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "TB";
        }
        String str2 = f < 10.0f ? "%.2f" : f < 100.0f ? "%.1f" : "%.0f";
        return String.format(str2 + str, Float.valueOf(f));
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(a(b2));
        }
        return sb.toString();
    }

    private static String a(byte b2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
    }

    public static boolean a(File file, String str) {
        ZipFile zipFile;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                zipFile = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    byte[] bArr = new byte[1024];
                    bufferedOutputStream2 = null;
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            String name = nextElement.getName();
                            if (TextUtils.isEmpty(name)) {
                                LogUtil.a("upZipFile:: zipEntry is null or zipEntry.getName is empty !");
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (bufferedOutputStream2 != null) {
                                    bufferedOutputStream2.close();
                                }
                                zipFile.close();
                                return false;
                            }
                            LogUtil.a("upZipFile:: ze.getName() = " + nextElement.getName());
                            if (nextElement.isDirectory()) {
                                File file2 = new File(str + File.separator + name.substring(0, name.length() - 1));
                                if (!file2.exists()) {
                                    file2.mkdirs();
                                }
                            } else {
                                File file3 = new File(str + File.separator + name);
                                StringBuilder sb = new StringBuilder();
                                sb.append("upZipFile::file = ");
                                sb.append(file3.getPath());
                                LogUtil.a(sb.toString());
                                File file4 = new File(file3.getParent());
                                if (!file4.exists()) {
                                    file4.mkdirs();
                                }
                                try {
                                    if (!file3.exists()) {
                                        file3.createNewFile();
                                    }
                                } catch (IOException e2) {
                                    LogUtil.a("upZipFile::createNewFile  exception  = " + e2.toString());
                                    e2.printStackTrace();
                                }
                                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file3));
                                try {
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                    while (true) {
                                        try {
                                            int read = bufferedInputStream2.read(bArr, 0, 1024);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream3.write(bArr, 0, read);
                                        } catch (ZipException e3) {
                                            e = e3;
                                            bufferedInputStream = bufferedInputStream2;
                                            bufferedOutputStream2 = bufferedOutputStream3;
                                            LogUtil.a("upZipFile::zipex = " + e.toString());
                                            e.printStackTrace();
                                            if (bufferedInputStream != null) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                    return false;
                                                }
                                            }
                                            if (bufferedOutputStream2 != null) {
                                                bufferedOutputStream2.close();
                                            }
                                            if (zipFile != null) {
                                                zipFile.close();
                                            }
                                            return false;
                                        } catch (IOException e5) {
                                            e = e5;
                                            bufferedInputStream = bufferedInputStream2;
                                            bufferedOutputStream2 = bufferedOutputStream3;
                                            LogUtil.a("upZipFile::ioex = " + e.toString());
                                            e.printStackTrace();
                                            if (bufferedInputStream != null) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (IOException e6) {
                                                    e6.printStackTrace();
                                                    return false;
                                                }
                                            }
                                            if (bufferedOutputStream2 != null) {
                                                bufferedOutputStream2.close();
                                            }
                                            if (zipFile != null) {
                                                zipFile.close();
                                            }
                                            return false;
                                        } catch (Throwable th) {
                                            th = th;
                                            bufferedInputStream = bufferedInputStream2;
                                            bufferedOutputStream = bufferedOutputStream3;
                                            if (bufferedInputStream != null) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (IOException e7) {
                                                    e7.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (bufferedOutputStream != null) {
                                                bufferedOutputStream.close();
                                            }
                                            if (zipFile != null) {
                                                zipFile.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    LogUtil.a("upZipFile::finish the path: " + file3.getPath());
                                    bufferedInputStream2.close();
                                    bufferedOutputStream3.close();
                                    bufferedInputStream = bufferedInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream3;
                                } catch (ZipException e8) {
                                    e = e8;
                                } catch (IOException e9) {
                                    e = e9;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        } catch (ZipException e10) {
                            e = e10;
                        } catch (IOException e11) {
                            e = e11;
                        }
                    }
                    zipFile.close();
                    LogUtil.a("upZipFile::finish !");
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                    zipFile.close();
                    return true;
                } catch (ZipException e13) {
                    e = e13;
                    bufferedOutputStream2 = null;
                } catch (IOException e14) {
                    e = e14;
                    bufferedOutputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (ZipException e15) {
            e = e15;
            zipFile = null;
            bufferedOutputStream2 = null;
        } catch (IOException e16) {
            e = e16;
            zipFile = null;
            bufferedOutputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
            bufferedOutputStream = null;
        }
    }

    public static void a(String str, long j, String str2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(str2.getBytes());
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
    }
}
