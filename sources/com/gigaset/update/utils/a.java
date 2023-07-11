package com.gigaset.update.utils;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* compiled from: AduHostnameVerifier.java */
/* loaded from: classes.dex */
public final class a implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1163a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f1164b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    private final String c = "gigaset.com";
    private final String d = "gigaset.com";

    private a() {
    }

    private static boolean a(String str) {
        return f1164b.matcher(str).matches();
    }

    private boolean b(String str, X509Certificate x509Certificate) {
        List<String> a2 = a(x509Certificate, 7);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(a2.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static List<String> a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean verify(String str, X509Certificate x509Certificate) {
        if (a(str)) {
            return b(str, x509Certificate);
        }
        return a(str, x509Certificate);
    }

    private boolean a(String str, X509Certificate x509Certificate) {
        String a2;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a3 = a(x509Certificate, 2);
        int size = a3.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (a(lowerCase, a3.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (a2 = new e(x509Certificate.getSubjectX500Principal()).a("cn")) == null) {
            return false;
        }
        return a(lowerCase, a2);
    }

    private boolean a(String str, String str2) {
        if ((!str.endsWith("gigaset.com") && !str.endsWith("gigaset.com")) || str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains("*")) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String substring = lowerCase.substring(1);
        if (str.endsWith(substring)) {
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
