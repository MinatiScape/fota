package b.a.a.e;

import b.a.a.c.f;
import b.a.a.c.j;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/* compiled from: Zip4jUtil.java */
/* loaded from: classes.dex */
public class b {
    public static boolean a(String str) throws b.a.a.b.a {
        if (c(str)) {
            return a(new File(str));
        }
        throw new b.a.a.b.a("path is null");
    }

    public static boolean b(String str) throws b.a.a.b.a {
        if (c(str)) {
            if (a(str)) {
                try {
                    return new File(str).canRead();
                } catch (Exception unused) {
                    throw new b.a.a.b.a("cannot read zip file");
                }
            }
            StringBuffer stringBuffer = new StringBuffer("file does not exist: ");
            stringBuffer.append(str);
            throw new b.a.a.b.a(stringBuffer.toString());
        }
        throw new b.a.a.b.a("path is null");
    }

    public static boolean c(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean a(File file) throws b.a.a.b.a {
        if (file != null) {
            return file.exists();
        }
        throw new b.a.a.b.a("cannot check if file exists: input file is null");
    }

    public static f a(j jVar, String str) throws b.a.a.b.a {
        if (jVar != null) {
            if (c(str)) {
                f b2 = b(jVar, str);
                if (b2 == null) {
                    String replaceAll = str.replaceAll("\\\\", "/");
                    f b3 = b(jVar, replaceAll);
                    return b3 == null ? b(jVar, replaceAll.replaceAll("/", "\\\\")) : b3;
                }
                return b2;
            }
            StringBuffer stringBuffer = new StringBuffer("file name is null, cannot determine file header for fileName: ");
            stringBuffer.append(str);
            throw new b.a.a.b.a(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer("zip model is null, cannot determine file header for fileName: ");
        stringBuffer2.append(str);
        throw new b.a.a.b.a(stringBuffer2.toString());
    }

    public static f b(j jVar, String str) throws b.a.a.b.a {
        if (jVar != null) {
            if (c(str)) {
                if (jVar.a() != null) {
                    if (jVar.a().a() != null) {
                        if (jVar.a().a().size() <= 0) {
                            return null;
                        }
                        ArrayList a2 = jVar.a().a();
                        for (int i = 0; i < a2.size(); i++) {
                            f fVar = (f) a2.get(i);
                            String e = fVar.e();
                            if (c(e) && str.equalsIgnoreCase(e)) {
                                return fVar;
                            }
                        }
                        return null;
                    }
                    StringBuffer stringBuffer = new StringBuffer("file Headers are null, cannot determine file header with exact match for fileName: ");
                    stringBuffer.append(str);
                    throw new b.a.a.b.a(stringBuffer.toString());
                }
                StringBuffer stringBuffer2 = new StringBuffer("central directory is null, cannot determine file header with exact match for fileName: ");
                stringBuffer2.append(str);
                throw new b.a.a.b.a(stringBuffer2.toString());
            }
            StringBuffer stringBuffer3 = new StringBuffer("file name is null, cannot determine file header with exact match for fileName: ");
            stringBuffer3.append(str);
            throw new b.a.a.b.a(stringBuffer3.toString());
        }
        StringBuffer stringBuffer4 = new StringBuffer("zip model is null, cannot determine file header with exact match for fileName: ");
        stringBuffer4.append(str);
        throw new b.a.a.b.a(stringBuffer4.toString());
    }

    public static String a(byte[] bArr, boolean z) {
        if (z) {
            try {
                return new String(bArr, "UTF8");
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        return a(bArr);
    }

    public static String a(byte[] bArr) {
        try {
            return new String(bArr, "Cp850");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }
}
