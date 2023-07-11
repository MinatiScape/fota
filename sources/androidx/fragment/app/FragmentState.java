package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    final String f611a;

    /* renamed from: b  reason: collision with root package name */
    final int f612b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    Fragment l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState(Fragment fragment) {
        this.f611a = fragment.getClass().getName();
        this.f612b = fragment.g;
        this.c = fragment.o;
        this.d = fragment.z;
        this.e = fragment.A;
        this.f = fragment.B;
        this.g = fragment.E;
        this.h = fragment.D;
        this.i = fragment.i;
        this.j = fragment.C;
    }

    public Fragment a(AbstractC0080j abstractC0080j, AbstractC0078h abstractC0078h, Fragment fragment, s sVar, androidx.lifecycle.t tVar) {
        if (this.l == null) {
            Context c = abstractC0080j.c();
            Bundle bundle = this.i;
            if (bundle != null) {
                bundle.setClassLoader(c.getClassLoader());
            }
            if (abstractC0078h != null) {
                this.l = abstractC0078h.a(c, this.f611a, this.i);
            } else {
                this.l = Fragment.a(c, this.f611a, this.i);
            }
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(c.getClassLoader());
                this.l.d = this.k;
            }
            this.l.a(this.f612b, fragment);
            Fragment fragment2 = this.l;
            fragment2.o = this.c;
            fragment2.q = true;
            fragment2.z = this.d;
            fragment2.A = this.e;
            fragment2.B = this.f;
            fragment2.E = this.g;
            fragment2.D = this.h;
            fragment2.C = this.j;
            fragment2.t = abstractC0080j.e;
            if (r.f645a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        Fragment fragment3 = this.l;
        fragment3.w = sVar;
        fragment3.x = tVar;
        return fragment3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f611a);
        parcel.writeInt(this.f612b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState(Parcel parcel) {
        this.f611a = parcel.readString();
        this.f612b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
    }
}
