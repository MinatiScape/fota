package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* compiled from: StaggeredGridLayoutManager.java */
/* loaded from: classes.dex */
class L implements Parcelable.Creator<StaggeredGridLayoutManager.SavedState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.SavedState[] newArray(int i) {
        return new StaggeredGridLayoutManager.SavedState[i];
    }
}
