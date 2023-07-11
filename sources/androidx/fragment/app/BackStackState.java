package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.C0071a;
import java.util.ArrayList;
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0072b();

    /* renamed from: a  reason: collision with root package name */
    final int[] f592a;

    /* renamed from: b  reason: collision with root package name */
    final int f593b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public BackStackState(C0071a c0071a) {
        int size = c0071a.f627b.size();
        this.f592a = new int[size * 6];
        if (c0071a.i) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C0071a.C0017a c0017a = c0071a.f627b.get(i2);
                int[] iArr = this.f592a;
                int i3 = i + 1;
                iArr[i] = c0017a.f628a;
                int i4 = i3 + 1;
                Fragment fragment = c0017a.f629b;
                iArr[i3] = fragment != null ? fragment.g : -1;
                int[] iArr2 = this.f592a;
                int i5 = i4 + 1;
                iArr2[i4] = c0017a.c;
                int i6 = i5 + 1;
                iArr2[i5] = c0017a.d;
                int i7 = i6 + 1;
                iArr2[i6] = c0017a.e;
                i = i7 + 1;
                iArr2[i7] = c0017a.f;
            }
            this.f593b = c0071a.g;
            this.c = c0071a.h;
            this.d = c0071a.k;
            this.e = c0071a.m;
            this.f = c0071a.n;
            this.g = c0071a.o;
            this.h = c0071a.p;
            this.i = c0071a.q;
            this.j = c0071a.r;
            this.k = c0071a.s;
            this.l = c0071a.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0071a a(r rVar) {
        C0071a c0071a = new C0071a(rVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f592a.length) {
            C0071a.C0017a c0017a = new C0071a.C0017a();
            int i3 = i + 1;
            c0017a.f628a = this.f592a[i];
            if (r.f645a) {
                Log.v("FragmentManager", "Instantiate " + c0071a + " op #" + i2 + " base fragment #" + this.f592a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f592a[i3];
            if (i5 >= 0) {
                c0017a.f629b = rVar.k.get(i5);
            } else {
                c0017a.f629b = null;
            }
            int[] iArr = this.f592a;
            int i6 = i4 + 1;
            c0017a.c = iArr[i4];
            int i7 = i6 + 1;
            c0017a.d = iArr[i6];
            int i8 = i7 + 1;
            c0017a.e = iArr[i7];
            c0017a.f = iArr[i8];
            c0071a.c = c0017a.c;
            c0071a.d = c0017a.d;
            c0071a.e = c0017a.e;
            c0071a.f = c0017a.f;
            c0071a.a(c0017a);
            i2++;
            i = i8 + 1;
        }
        c0071a.g = this.f593b;
        c0071a.h = this.c;
        c0071a.k = this.d;
        c0071a.m = this.e;
        c0071a.i = true;
        c0071a.n = this.f;
        c0071a.o = this.g;
        c0071a.p = this.h;
        c0071a.q = this.i;
        c0071a.r = this.j;
        c0071a.s = this.k;
        c0071a.t = this.l;
        c0071a.a(1);
        return c0071a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f592a);
        parcel.writeInt(this.f593b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f592a = parcel.createIntArray();
        this.f593b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }
}
