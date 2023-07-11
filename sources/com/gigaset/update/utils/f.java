package com.gigaset.update.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: EncryptUtil.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1171a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        if (str.startsWith("AEVA")) {
            String replaceAll = str.replaceAll("AEVA", "");
            return !TextUtils.isEmpty(replaceAll) ? new String(Base64.decode(replaceAll, 8)) : "";
        }
        return str;
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        int random = (int) (Math.random() * 15.0d);
        int random2 = ((int) (Math.random() * 12.0d)) + 3;
        byte[] a2 = a(random2);
        int i = random2 | (random << 4);
        byte[] a3 = a(a2, bytes);
        byte[] e = e(a2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(i);
            if (random > 0) {
                byte[] bArr = new byte[random];
                bArr[0] = 8;
                dataOutputStream.write(bArr);
            }
            dataOutputStream.write(e);
            dataOutputStream.write(a3);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.close();
            byteArrayOutputStream.close();
            return a(byteArray);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return d(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str) {
        try {
            return f(MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static byte[] e(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = (byte) (((bArr[i] & 255) >> 5) | ((bArr[i] & 255) << 3));
        }
        return bArr2;
    }

    private static String f(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(f1171a[(b2 >> 4) & 15]);
            sb.append(f1171a[b2 & 15]);
        }
        return sb.toString();
    }

    private static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        return sb.toString();
    }

    public static String e(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bytes);
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        return sb.toString().toUpperCase();
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto Ld
            return r1
        Ld:
            java.lang.String r5 = "SHA-256"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r2 = 102400(0x19000, float:1.43493E-40)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
        L1d:
            int r0 = r3.read(r2)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L4d
            if (r0 <= 0) goto L28
            r4 = 0
            r5.update(r2, r4, r0)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L4d
            goto L1d
        L28:
            byte[] r5 = r5.digest()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L4d
            java.lang.String r5 = b(r5)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L4d
            r3.close()     // Catch: java.io.IOException -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            return r5
        L39:
            r5 = move-exception
            goto L3f
        L3b:
            r5 = move-exception
            goto L4f
        L3d:
            r5 = move-exception
            r3 = r1
        L3f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L4c
            r3.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r5 = move-exception
            r5.printStackTrace()
        L4c:
            return r1
        L4d:
            r5 = move-exception
            r1 = r3
        L4f:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r0 = move-exception
            r0.printStackTrace()
        L59:
            goto L5b
        L5a:
            throw r5
        L5b:
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.utils.f.f(java.lang.String):java.lang.String");
    }

    private static byte[] a(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (Math.random() * 255.0d);
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        int length2 = bArr.length;
        byte[] bArr3 = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) ((bArr2[i2] & 255) ^ (bArr[i] & 255));
            i++;
            if (i == length2) {
                i = 0;
            }
        }
        return bArr3;
    }

    private static String a(byte b2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(a(b2));
        }
        return sb.toString();
    }
}
