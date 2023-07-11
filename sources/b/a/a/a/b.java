package b.a.a.a;

import b.a.a.c.f;
import b.a.a.c.j;
import java.io.File;
/* compiled from: ZipFile.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f1047a;

    /* renamed from: b  reason: collision with root package name */
    private int f1048b;
    private j c;
    private b.a.a.d.a d;
    private boolean e;
    private String f;

    public b(String str) throws b.a.a.b.a {
        this(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() throws b.a.a.b.a {
        /*
            r5 = this;
            java.lang.String r0 = r5.f1047a
            boolean r0 = b.a.a.e.b.a(r0)
            if (r0 == 0) goto L6c
            java.lang.String r0 = r5.f1047a
            boolean r0 = b.a.a.e.b.b(r0)
            if (r0 == 0) goto L64
            int r0 = r5.f1048b
            r1 = 2
            if (r0 != r1) goto L5c
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L46 java.io.FileNotFoundException -> L4b
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L46 java.io.FileNotFoundException -> L4b
            java.lang.String r3 = r5.f1047a     // Catch: java.lang.Throwable -> L46 java.io.FileNotFoundException -> L4b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L46 java.io.FileNotFoundException -> L4b
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L46 java.io.FileNotFoundException -> L4b
            b.a.a.c.j r0 = r5.c     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            if (r0 != 0) goto L40
            b.a.a.a.a r0 = new b.a.a.a.a     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            r0.<init>(r1)     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            java.lang.String r2 = r5.f     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            b.a.a.c.j r0 = r0.a(r2)     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            r5.c = r0     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            b.a.a.c.j r0 = r5.c     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            if (r0 == 0) goto L40
            b.a.a.c.j r0 = r5.c     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            java.lang.String r2 = r5.f1047a     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
            r0.b(r2)     // Catch: java.io.FileNotFoundException -> L44 java.lang.Throwable -> L55
        L40:
            r1.close()     // Catch: java.io.IOException -> L43
        L43:
            return
        L44:
            r0 = move-exception
            goto L4f
        L46:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L56
        L4b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L4f:
            b.a.a.b.a r2 = new b.a.a.b.a     // Catch: java.lang.Throwable -> L55
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L55
            throw r2     // Catch: java.lang.Throwable -> L55
        L55:
            r0 = move-exception
        L56:
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.io.IOException -> L5b
        L5b:
            throw r0
        L5c:
            b.a.a.b.a r0 = new b.a.a.b.a
            java.lang.String r1 = "Invalid mode"
            r0.<init>(r1)
            throw r0
        L64:
            b.a.a.b.a r0 = new b.a.a.b.a
            java.lang.String r1 = "no read access for the input zip file"
            r0.<init>(r1)
            throw r0
        L6c:
            b.a.a.b.a r0 = new b.a.a.b.a
            java.lang.String r1 = "zip file does not exist"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a.b.a():void");
    }

    public b(File file) throws b.a.a.b.a {
        if (file != null) {
            this.f1047a = file.getPath();
            this.f1048b = 2;
            this.d = new b.a.a.d.a();
            this.e = false;
            return;
        }
        throw new b.a.a.b.a("Input zip file parameter is not null", 1);
    }

    public f a(String str) throws b.a.a.b.a {
        if (b.a.a.e.b.c(str)) {
            a();
            j jVar = this.c;
            if (jVar == null || jVar.a() == null) {
                return null;
            }
            return b.a.a.e.b.a(this.c, str);
        }
        throw new b.a.a.b.a("input file name is emtpy or null, cannot get FileHeader");
    }
}
