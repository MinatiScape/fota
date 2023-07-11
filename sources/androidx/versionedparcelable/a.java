package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ParcelImpl.java */
/* loaded from: classes.dex */
class a implements Parcelable.Creator<ParcelImpl> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ParcelImpl createFromParcel(Parcel parcel) {
        return new ParcelImpl(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ParcelImpl[] newArray(int i) {
        return new ParcelImpl[i];
    }
}
