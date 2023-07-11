package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
class t implements Parcelable.Creator<FragmentManagerState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentManagerState createFromParcel(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentManagerState[] newArray(int i) {
        return new FragmentManagerState[i];
    }
}
