package b.a.a.a;

import b.a.a.c.c;
import b.a.a.c.d;
import b.a.a.c.e;
import b.a.a.c.f;
import b.a.a.c.g;
import b.a.a.c.h;
import b.a.a.c.i;
import b.a.a.c.j;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/* compiled from: HeaderReader.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f1045a;

    /* renamed from: b  reason: collision with root package name */
    private j f1046b;

    public a(RandomAccessFile randomAccessFile) {
        this.f1045a = null;
        this.f1045a = randomAccessFile;
    }

    private d b() throws b.a.a.b.a {
        RandomAccessFile randomAccessFile = this.f1045a;
        if (randomAccessFile != null) {
            try {
                byte[] bArr = new byte[4];
                long length = randomAccessFile.length() - 22;
                d dVar = new d();
                int i = 0;
                while (true) {
                    long j = length - 1;
                    this.f1045a.seek(length);
                    i++;
                    if (b.a.a.e.a.a(this.f1045a, bArr) == 101010256 || i > 3000) {
                        break;
                    }
                    length = j;
                }
                if (b.a.a.e.a.a(bArr, 0) == 101010256) {
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[2];
                    dVar.b(101010256L);
                    a(this.f1045a, bArr3);
                    dVar.b(b.a.a.e.a.d(bArr3, 0));
                    a(this.f1045a, bArr3);
                    dVar.c(b.a.a.e.a.d(bArr3, 0));
                    a(this.f1045a, bArr3);
                    dVar.f(b.a.a.e.a.d(bArr3, 0));
                    a(this.f1045a, bArr3);
                    dVar.e(b.a.a.e.a.d(bArr3, 0));
                    a(this.f1045a, bArr2);
                    dVar.d(b.a.a.e.a.a(bArr2, 0));
                    a(this.f1045a, bArr2);
                    dVar.a(b.a.a.e.a.b(a(bArr2), 0));
                    a(this.f1045a, bArr3);
                    int d = b.a.a.e.a.d(bArr3, 0);
                    dVar.a(d);
                    if (d > 0) {
                        byte[] bArr4 = new byte[d];
                        a(this.f1045a, bArr4);
                        dVar.a(new String(bArr4));
                        dVar.a(bArr4);
                    } else {
                        dVar.a((String) null);
                    }
                    if (dVar.a() > 0) {
                        this.f1046b.a(true);
                    } else {
                        this.f1046b.a(false);
                    }
                    return dVar;
                }
                throw new b.a.a.b.a("zip headers not found. probably not a zip file");
            } catch (IOException e) {
                throw new b.a.a.b.a("Probably not a zip file or a corrupted zip file", e, 4);
            }
        }
        throw new b.a.a.b.a("random access file was null", 3);
    }

    private g c() throws b.a.a.b.a {
        if (this.f1045a != null) {
            try {
                g gVar = new g();
                e();
                byte[] bArr = new byte[4];
                byte[] bArr2 = new byte[8];
                a(this.f1045a, bArr);
                long a2 = b.a.a.e.a.a(bArr, 0);
                if (a2 == 117853008) {
                    this.f1046b.b(true);
                    gVar.b(a2);
                    a(this.f1045a, bArr);
                    gVar.a(b.a.a.e.a.a(bArr, 0));
                    a(this.f1045a, bArr2);
                    gVar.a(b.a.a.e.a.b(bArr2, 0));
                    a(this.f1045a, bArr);
                    gVar.b(b.a.a.e.a.a(bArr, 0));
                    return gVar;
                }
                this.f1046b.b(false);
                return null;
            } catch (Exception e) {
                throw new b.a.a.b.a(e);
            }
        }
        throw new b.a.a.b.a("invalid file handler when trying to read Zip64EndCentralDirLocator");
    }

    private h d() throws b.a.a.b.a {
        if (this.f1046b.d() != null) {
            long a2 = this.f1046b.d().a();
            if (a2 >= 0) {
                try {
                    this.f1045a.seek(a2);
                    h hVar = new h();
                    byte[] bArr = new byte[2];
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[8];
                    a(this.f1045a, bArr2);
                    long a3 = b.a.a.e.a.a(bArr2, 0);
                    if (a3 == 101075792) {
                        hVar.b(a3);
                        a(this.f1045a, bArr3);
                        hVar.d(b.a.a.e.a.b(bArr3, 0));
                        a(this.f1045a, bArr);
                        hVar.c(b.a.a.e.a.d(bArr, 0));
                        a(this.f1045a, bArr);
                        hVar.d(b.a.a.e.a.d(bArr, 0));
                        a(this.f1045a, bArr2);
                        hVar.a(b.a.a.e.a.a(bArr2, 0));
                        a(this.f1045a, bArr2);
                        hVar.b(b.a.a.e.a.a(bArr2, 0));
                        a(this.f1045a, bArr3);
                        hVar.f(b.a.a.e.a.b(bArr3, 0));
                        a(this.f1045a, bArr3);
                        hVar.e(b.a.a.e.a.b(bArr3, 0));
                        a(this.f1045a, bArr3);
                        hVar.c(b.a.a.e.a.b(bArr3, 0));
                        a(this.f1045a, bArr3);
                        hVar.a(b.a.a.e.a.b(bArr3, 0));
                        long c = hVar.c() - 44;
                        if (c > 0) {
                            byte[] bArr4 = new byte[(int) c];
                            a(this.f1045a, bArr4);
                            hVar.a(bArr4);
                        }
                        return hVar;
                    }
                    throw new b.a.a.b.a("invalid signature for zip64 end of central directory record");
                } catch (IOException e) {
                    throw new b.a.a.b.a(e);
                }
            }
            throw new b.a.a.b.a("invalid offset for start of end of central directory record");
        }
        throw new b.a.a.b.a("invalid zip64 end of central directory locator");
    }

    private void e() throws b.a.a.b.a {
        try {
            byte[] bArr = new byte[4];
            long length = this.f1045a.length() - 22;
            while (true) {
                long j = length - 1;
                this.f1045a.seek(length);
                if (b.a.a.e.a.a(this.f1045a, bArr) == 101010256) {
                    this.f1045a.seek(((((this.f1045a.getFilePointer() - 4) - 4) - 8) - 4) - 4);
                    return;
                }
                length = j;
            }
        } catch (IOException e) {
            throw new b.a.a.b.a(e);
        }
    }

    public j a(String str) throws b.a.a.b.a {
        this.f1046b = new j();
        this.f1046b.a(str);
        this.f1046b.a(b());
        this.f1046b.a(c());
        if (this.f1046b.f()) {
            this.f1046b.a(d());
            if (this.f1046b.e() != null && this.f1046b.e().a() > 0) {
                this.f1046b.a(true);
            } else {
                this.f1046b.a(false);
            }
        }
        this.f1046b.a(a());
        return this.f1046b;
    }

    private b.a.a.c.b a() throws b.a.a.b.a {
        String a2;
        if (this.f1045a != null) {
            if (this.f1046b.b() != null) {
                try {
                    b.a.a.c.b bVar = new b.a.a.c.b();
                    ArrayList arrayList = new ArrayList();
                    d b2 = this.f1046b.b();
                    long b3 = b2.b();
                    int c = b2.c();
                    if (this.f1046b.f()) {
                        b3 = this.f1046b.e().b();
                        c = (int) this.f1046b.e().d();
                    }
                    this.f1045a.seek(b3);
                    byte[] bArr = new byte[4];
                    byte[] bArr2 = new byte[2];
                    byte[] bArr3 = new byte[8];
                    for (int i = 0; i < c; i++) {
                        f fVar = new f();
                        a(this.f1045a, bArr);
                        int a3 = b.a.a.e.a.a(bArr, 0);
                        boolean z = true;
                        if (a3 == 33639248) {
                            fVar.g(a3);
                            a(this.f1045a, bArr2);
                            fVar.h(b.a.a.e.a.d(bArr2, 0));
                            a(this.f1045a, bArr2);
                            fVar.i(b.a.a.e.a.d(bArr2, 0));
                            a(this.f1045a, bArr2);
                            fVar.d((b.a.a.e.a.d(bArr2, 0) & 2048) != 0);
                            byte b4 = bArr2[0];
                            if ((b4 & 1) != 0) {
                                fVar.c(true);
                            }
                            fVar.c((byte[]) bArr2.clone());
                            fVar.a((b4 >> 3) == 1);
                            a(this.f1045a, bArr2);
                            fVar.a(b.a.a.e.a.d(bArr2, 0));
                            a(this.f1045a, bArr);
                            fVar.f(b.a.a.e.a.a(bArr, 0));
                            a(this.f1045a, bArr);
                            fVar.b(b.a.a.e.a.a(bArr, 0));
                            fVar.a((byte[]) bArr.clone());
                            a(this.f1045a, bArr);
                            fVar.a(b.a.a.e.a.b(a(bArr), 0));
                            a(this.f1045a, bArr);
                            fVar.d(b.a.a.e.a.b(a(bArr), 0));
                            a(this.f1045a, bArr2);
                            int d = b.a.a.e.a.d(bArr2, 0);
                            fVar.e(d);
                            a(this.f1045a, bArr2);
                            fVar.d(b.a.a.e.a.d(bArr2, 0));
                            a(this.f1045a, bArr2);
                            int d2 = b.a.a.e.a.d(bArr2, 0);
                            fVar.a(new String(bArr2));
                            a(this.f1045a, bArr2);
                            fVar.b(b.a.a.e.a.d(bArr2, 0));
                            a(this.f1045a, bArr2);
                            fVar.d((byte[]) bArr2.clone());
                            a(this.f1045a, bArr);
                            fVar.b((byte[]) bArr.clone());
                            a(this.f1045a, bArr);
                            fVar.c(b.a.a.e.a.b(a(bArr), 0) & 4294967295L);
                            if (d > 0) {
                                byte[] bArr4 = new byte[d];
                                a(this.f1045a, bArr4);
                                if (b.a.a.e.b.c(this.f1046b.c())) {
                                    a2 = new String(bArr4, this.f1046b.c());
                                } else {
                                    a2 = b.a.a.e.b.a(bArr4, fVar.h());
                                }
                                if (a2 != null) {
                                    StringBuffer stringBuffer = new StringBuffer(":");
                                    stringBuffer.append(System.getProperty("file.separator"));
                                    if (a2.indexOf(stringBuffer.toString()) >= 0) {
                                        StringBuffer stringBuffer2 = new StringBuffer(":");
                                        stringBuffer2.append(System.getProperty("file.separator"));
                                        a2 = a2.substring(a2.indexOf(stringBuffer2.toString()) + 2);
                                    }
                                    fVar.b(a2);
                                    if (!a2.endsWith("/") && !a2.endsWith("\\")) {
                                        z = false;
                                    }
                                    fVar.b(z);
                                } else {
                                    throw new b.a.a.b.a("fileName is null when reading central directory");
                                }
                            } else {
                                fVar.b((String) null);
                            }
                            b(fVar);
                            c(fVar);
                            a(fVar);
                            if (d2 > 0) {
                                byte[] bArr5 = new byte[d2];
                                a(this.f1045a, bArr5);
                                fVar.a(new String(bArr5));
                            }
                            arrayList.add(fVar);
                        } else {
                            StringBuffer stringBuffer3 = new StringBuffer("Expected central directory entry not found (#");
                            stringBuffer3.append(i + 1);
                            stringBuffer3.append(")");
                            throw new b.a.a.b.a(stringBuffer3.toString());
                        }
                    }
                    bVar.a(arrayList);
                    c cVar = new c();
                    a(this.f1045a, bArr);
                    int a4 = b.a.a.e.a.a(bArr, 0);
                    if (a4 != 84233040) {
                        return bVar;
                    }
                    cVar.a(a4);
                    a(this.f1045a, bArr2);
                    int d3 = b.a.a.e.a.d(bArr2, 0);
                    cVar.b(d3);
                    if (d3 > 0) {
                        byte[] bArr6 = new byte[d3];
                        a(this.f1045a, bArr6);
                        cVar.a(new String(bArr6));
                    }
                    return bVar;
                } catch (IOException e) {
                    throw new b.a.a.b.a(e);
                }
            }
            throw new b.a.a.b.a("EndCentralRecord was null, maybe a corrupt zip file");
        }
        throw new b.a.a.b.a("random access file was null", 3);
    }

    private void c(f fVar) throws b.a.a.b.a {
        i a2;
        if (fVar != null) {
            if (fVar.c() == null || fVar.c().size() <= 0 || (a2 = a(fVar.c(), fVar.g(), fVar.a(), fVar.f(), fVar.b())) == null) {
                return;
            }
            fVar.a(a2);
            if (a2.d() != -1) {
                fVar.d(a2.d());
            }
            if (a2.a() != -1) {
                fVar.a(a2.a());
            }
            if (a2.c() != -1) {
                fVar.c(a2.c());
            }
            if (a2.b() != -1) {
                fVar.b(a2.b());
                return;
            }
            return;
        }
        throw new b.a.a.b.a("file header is null in reading Zip64 Extended Info");
    }

    private void b(f fVar) throws b.a.a.b.a {
        if (this.f1045a == null) {
            throw new b.a.a.b.a("invalid file handler when trying to read extra data record");
        }
        if (fVar != null) {
            int d = fVar.d();
            if (d <= 0) {
                return;
            }
            fVar.a(a(d));
            return;
        }
        throw new b.a.a.b.a("file header is null");
    }

    private ArrayList a(int i) throws b.a.a.b.a {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            this.f1045a.read(bArr);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < i) {
                e eVar = new e();
                eVar.a(b.a.a.e.a.d(bArr, i2));
                int i3 = i2 + 2;
                int d = b.a.a.e.a.d(bArr, i3);
                if (d + 2 > i) {
                    d = b.a.a.e.a.c(bArr, i3);
                    if (d + 2 > i) {
                        break;
                    }
                }
                eVar.a(d);
                int i4 = i3 + 2;
                if (d > 0) {
                    byte[] bArr2 = new byte[d];
                    System.arraycopy(bArr, i4, bArr2, 0, d);
                    eVar.a(bArr2);
                }
                i2 = i4 + d;
                arrayList.add(eVar);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (IOException e) {
            throw new b.a.a.b.a(e);
        }
    }

    private i a(ArrayList arrayList, long j, long j2, long j3, int i) throws b.a.a.b.a {
        int i2;
        boolean z;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            e eVar = (e) arrayList.get(i3);
            if (eVar != null && eVar.b() == 1) {
                i iVar = new i();
                byte[] a2 = eVar.a();
                if (eVar.c() <= 0) {
                    return null;
                }
                byte[] bArr = new byte[8];
                byte[] bArr2 = new byte[4];
                if ((j & 65535) != 65535 || eVar.c() <= 0) {
                    i2 = 0;
                    z = false;
                } else {
                    System.arraycopy(a2, 0, bArr, 0, 8);
                    iVar.c(b.a.a.e.a.b(bArr, 0));
                    i2 = 8;
                    z = true;
                }
                if ((j2 & 65535) == 65535 && i2 < eVar.c()) {
                    System.arraycopy(a2, i2, bArr, 0, 8);
                    iVar.a(b.a.a.e.a.b(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((j3 & 65535) == 65535 && i2 < eVar.c()) {
                    System.arraycopy(a2, i2, bArr, 0, 8);
                    iVar.b(b.a.a.e.a.b(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((i & 65535) == 65535 && i2 < eVar.c()) {
                    System.arraycopy(a2, i2, bArr2, 0, 4);
                    iVar.a(b.a.a.e.a.a(bArr2, 0));
                    z = true;
                }
                if (z) {
                    return iVar;
                }
                return null;
            }
        }
        return null;
    }

    private void a(f fVar) throws b.a.a.b.a {
        b.a.a.c.a a2;
        if (fVar != null) {
            if (fVar.c() == null || fVar.c().size() <= 0 || (a2 = a(fVar.c())) == null) {
                return;
            }
            fVar.a(a2);
            fVar.c(99);
            return;
        }
        throw new b.a.a.b.a("file header is null in reading Zip64 Extended Info");
    }

    private b.a.a.c.a a(ArrayList arrayList) throws b.a.a.b.a {
        if (arrayList == null) {
            return null;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            e eVar = (e) arrayList.get(i);
            if (eVar != null && eVar.b() == 39169) {
                if (eVar.a() != null) {
                    b.a.a.c.a aVar = new b.a.a.c.a();
                    aVar.a(39169L);
                    aVar.c(eVar.c());
                    byte[] a2 = eVar.a();
                    aVar.d(b.a.a.e.a.d(a2, 0));
                    byte[] bArr = new byte[2];
                    System.arraycopy(a2, 2, bArr, 0, 2);
                    aVar.a(new String(bArr));
                    aVar.a(a2[4] & 255);
                    aVar.b(b.a.a.e.a.d(a2, 5));
                    return aVar;
                }
                throw new b.a.a.b.a("corrput AES extra data records");
            }
        }
        return null;
    }

    private byte[] a(RandomAccessFile randomAccessFile, byte[] bArr) throws b.a.a.b.a {
        try {
            if (randomAccessFile.read(bArr, 0, bArr.length) != -1) {
                return bArr;
            }
            throw new b.a.a.b.a("unexpected end of file when reading short buff");
        } catch (IOException e) {
            throw new b.a.a.b.a("IOException when reading short buff", e);
        }
    }

    private byte[] a(byte[] bArr) throws b.a.a.b.a {
        if (bArr != null) {
            if (bArr.length == 4) {
                return new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]};
            }
            throw new b.a.a.b.a("invalid byte length, cannot expand to 8 bytes");
        }
        throw new b.a.a.b.a("input parameter is null, cannot expand to 8 bytes");
    }
}
