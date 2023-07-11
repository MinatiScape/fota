package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    FragmentState[] f609a;

    /* renamed from: b  reason: collision with root package name */
    int[] f610b;
    BackStackState[] c;
    int d;
    int e;

    public FragmentManagerState() {
        this.d = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f609a, i);
        parcel.writeIntArray(this.f610b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

    public FragmentManagerState(Parcel parcel) {
        this.d = -1;
        this.f609a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f610b = parcel.createIntArray();
        this.c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }
}
