package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.widget.NestedScrollView;
/* compiled from: NestedScrollView.java */
/* loaded from: classes.dex */
class j implements Parcelable.Creator<NestedScrollView.SavedState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NestedScrollView.SavedState createFromParcel(Parcel parcel) {
        return new NestedScrollView.SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NestedScrollView.SavedState[] newArray(int i) {
        return new NestedScrollView.SavedState[i];
    }
}
