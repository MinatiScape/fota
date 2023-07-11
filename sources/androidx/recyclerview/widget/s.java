package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;
/* compiled from: LinearLayoutManager.java */
/* loaded from: classes.dex */
class s implements Parcelable.Creator<LinearLayoutManager.SavedState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LinearLayoutManager.SavedState createFromParcel(Parcel parcel) {
        return new LinearLayoutManager.SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LinearLayoutManager.SavedState[] newArray(int i) {
        return new LinearLayoutManager.SavedState[i];
    }
}
