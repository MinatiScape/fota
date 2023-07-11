package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
class F implements Parcelable.ClassLoaderCreator<RecyclerView.SavedState> {
    @Override // android.os.Parcelable.Creator
    public RecyclerView.SavedState[] newArray(int i) {
        return new RecyclerView.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public RecyclerView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public RecyclerView.SavedState createFromParcel(Parcel parcel) {
        return new RecyclerView.SavedState(parcel, null);
    }
}
