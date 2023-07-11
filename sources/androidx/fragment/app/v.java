package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentTabHost;
/* compiled from: FragmentTabHost.java */
/* loaded from: classes.dex */
class v implements Parcelable.Creator<FragmentTabHost.SavedState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentTabHost.SavedState createFromParcel(Parcel parcel) {
        return new FragmentTabHost.SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FragmentTabHost.SavedState[] newArray(int i) {
        return new FragmentTabHost.SavedState[i];
    }
}
