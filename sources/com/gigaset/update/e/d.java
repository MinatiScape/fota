package com.gigaset.update.e;

import android.os.Build;
import android.text.TextUtils;
import com.gigaset.update.bean.RootErrBean;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.i;
import com.gigaset.update.utils.p;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* compiled from: QueryRootVerify.java */
/* loaded from: classes.dex */
public class d {
    public static String a(String str) {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            String a2 = new p().a(str);
            return TextUtils.isEmpty(a2) ? c(str) : a2;
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
            return null;
        }
    }

    private static String b(String str) throws IOException {
        int i;
        int indexOf;
        RootErrBean rootErrBean = new RootErrBean();
        ArrayList arrayList = new ArrayList();
        LogUtil.a("start checkSourceFile");
        ZipInputStream zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(str), new CRC32()));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            } else if (nextEntry.getName().equals(String.valueOf(new char[]{'M', 'E', 'T', 'A', '-', 'I', 'N', 'F', '/', 'c', 'o', 'm', '/', 'g', 'o', 'o', 'g', 'l', 'e', '/', 'a', 'n', 'd', 'r', 'o', 'i', 'd', '/', 'u', 'p', 'd', 'a', 't', 'e', 'r', '-', 's', 'c', 'r', 'i', 'p', 't'}))) {
                StringBuilder sb = new StringBuilder();
                for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                    sb.append(new String(bArr, 0, read));
                }
                int i2 = 0;
                while (true) {
                    int indexOf2 = sb.indexOf("apply_patch_check(\"/system", i2);
                    if (indexOf2 < 0 || (indexOf = sb.indexOf("\")", (i = indexOf2 + 26))) < 0) {
                        break;
                    }
                    String substring = sb.substring(i, indexOf);
                    int i3 = indexOf + 3;
                    int indexOf3 = substring.indexOf("\", \"", 0);
                    if (indexOf3 >= 0) {
                        String substring2 = substring.substring(0, indexOf3);
                        int i4 = indexOf3 + 4;
                        int indexOf4 = substring.indexOf("\", \"", i4);
                        if (indexOf4 >= 0) {
                            String substring3 = substring.substring(i4, indexOf4);
                            String substring4 = substring.substring(indexOf4 + 4);
                            LogUtil.a("file path = " + substring2 + "  sha1_str1 = " + substring3 + "  sha1_str2 = " + substring4);
                            try {
                                if (!a(substring2, substring3, substring4)) {
                                    arrayList.add(substring2.substring(substring2.lastIndexOf("/") + 1));
                                }
                            } catch (Exception e) {
                                LogUtil.b("checkSourceFileInvaild, Exception = " + e.toString());
                            }
                        }
                    }
                    i2 = i3;
                }
            }
        }
        bufferedInputStream.close();
        if (arrayList.size() > 0) {
            rootErrBean.setModify(arrayList);
            return i.a(rootErrBean);
        }
        return null;
    }

    private static String c(String str) {
        try {
            return b(str);
        } catch (FileNotFoundException e) {
            LogUtil.b("checkUpdateFileResult, FileNotFoundException = " + e.toString());
            return null;
        } catch (IOException e2) {
            LogUtil.b("checkUpdateFileResult, IOException = " + e2.toString());
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3) throws OutOfMemoryError, IOException {
        boolean z;
        File file = new File("/system" + str);
        if (!file.exists()) {
            LogUtil.a("/system" + str + " is not exists !");
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                LogUtil.a("getFileSha1()---path = /system" + str + " sha1_str1 = " + str2 + " sha1_str2 = " + str3);
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                byte[] bArr = new byte[102400];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String lowerCase = a(messageDigest.digest()).toLowerCase();
                LogUtil.a("getFileSha1()---act_sha1String = " + lowerCase);
                if (!lowerCase.equals(str2)) {
                    if (!lowerCase.equals(str3)) {
                        z = false;
                        fileInputStream.close();
                        return z;
                    }
                }
                z = true;
                fileInputStream.close();
                return z;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (OutOfMemoryError e) {
            LogUtil.b("getFileSha1, OutOfMemoryError = " + e.toString());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            LogUtil.b("getFileSha1, NoSuchAlgorithmException = " + e2.toString());
            return false;
        }
    }

    private static String a(byte b2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(a(b2));
        }
        return sb.toString();
    }
}
