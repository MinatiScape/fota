package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f1024a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f1025b;
    private final int c;
    private final int d;
    private final String e;
    private int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    private int d(int i) {
        int readInt;
        do {
            int i2 = this.g;
            if (i2 >= this.d) {
                return -1;
            }
            this.f1025b.setDataPosition(i2);
            int readInt2 = this.f1025b.readInt();
            readInt = this.f1025b.readInt();
            this.g += readInt2;
        } while (readInt != i);
        return this.f1025b.dataPosition();
    }

    @Override // androidx.versionedparcelable.b
    public boolean a(int i) {
        int d = d(i);
        if (d == -1) {
            return false;
        }
        this.f1025b.setDataPosition(d);
        return true;
    }

    @Override // androidx.versionedparcelable.b
    public void b(int i) {
        a();
        this.f = i;
        this.f1024a.put(i, this.f1025b.dataPosition());
        c(0);
        c(i);
    }

    @Override // androidx.versionedparcelable.b
    public void c(int i) {
        this.f1025b.writeInt(i);
    }

    @Override // androidx.versionedparcelable.b
    public int e() {
        return this.f1025b.readInt();
    }

    @Override // androidx.versionedparcelable.b
    public <T extends Parcelable> T f() {
        return (T) this.f1025b.readParcelable(c.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.b
    public String g() {
        return this.f1025b.readString();
    }

    c(Parcel parcel, int i, int i2, String str) {
        this.f1024a = new SparseIntArray();
        this.f = -1;
        this.g = 0;
        this.f1025b = parcel;
        this.c = i;
        this.d = i2;
        this.g = this.c;
        this.e = str;
    }

    @Override // androidx.versionedparcelable.b
    public void a() {
        int i = this.f;
        if (i >= 0) {
            int i2 = this.f1024a.get(i);
            int dataPosition = this.f1025b.dataPosition();
            this.f1025b.setDataPosition(i2);
            this.f1025b.writeInt(dataPosition - i2);
            this.f1025b.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.b
    protected b b() {
        Parcel parcel = this.f1025b;
        int dataPosition = parcel.dataPosition();
        int i = this.g;
        if (i == this.c) {
            i = this.d;
        }
        return new c(parcel, dataPosition, i, this.e + "  ");
    }

    @Override // androidx.versionedparcelable.b
    public byte[] d() {
        int readInt = this.f1025b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1025b.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.b
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f1025b.writeInt(bArr.length);
            this.f1025b.writeByteArray(bArr);
            return;
        }
        this.f1025b.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.b
    public void a(String str) {
        this.f1025b.writeString(str);
    }

    @Override // androidx.versionedparcelable.b
    public void a(Parcelable parcelable) {
        this.f1025b.writeParcelable(parcelable, 0);
    }
}
