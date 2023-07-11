package com.gigaset.update.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
/* compiled from: PackageUtils.java */
/* loaded from: classes.dex */
public class n {
    public static int a(Context context) {
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return -1;
            } catch (PackageManager.NameNotFoundException unused) {
                return -1;
            }
        }
        return -1;
    }

    public static String b(Context context) {
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return packageInfo != null ? packageInfo.versionName.equalsIgnoreCase("5.28") ? packageInfo.versionName : "5.28" : "0";
            } catch (PackageManager.NameNotFoundException unused) {
                return "0";
            }
        }
        return "0";
    }

    /* compiled from: PackageUtils.java */
    /* loaded from: classes.dex */
    private static class a {
        private a() {
        }

        private String a(byte[] bArr) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return b(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }

        private String b(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
                sb.append("");
            }
            return sb.toString();
        }

        public String[] a(Signature[] signatureArr) {
            if (signatureArr.length == 0 || signatureArr[0] == null) {
                return null;
            }
            byte[] byteArray = signatureArr[0].toByteArray();
            if (byteArray.length <= 0) {
                return null;
            }
            String[] strArr = new String[2];
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(byteArray));
                strArr[0] = a(Base64.encodeToString(x509Certificate.getEncoded(), 2).getBytes());
                strArr[1] = x509Certificate.getIssuerDN().toString();
                return strArr;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static String a(Context context, String str) {
        String[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && (a2 = new a().a(packageInfo.signatures)) != null && a2.length == 2) {
                return a2[0];
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static int a(int i) {
        int i2 = i / BZip2Constants.BASEBLOCKSIZE;
        LogUtil.a("[getUserId]userId is  = " + i2);
        return i2;
    }
}
