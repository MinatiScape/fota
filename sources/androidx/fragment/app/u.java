package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: FragmentState.java */
/* loaded from: classes.dex */
class u implements Parcelable.Creator<FragmentState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentState createFromParcel(Parcel parcel) {
        return new FragmentState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentState[] newArray(int i) {
        return new FragmentState[i];
    }
}
