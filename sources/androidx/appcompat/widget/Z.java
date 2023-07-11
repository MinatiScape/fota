package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class Z implements Parcelable.ClassLoaderCreator<SearchView.SavedState> {
    @Override // android.os.Parcelable.Creator
    public SearchView.SavedState[] newArray(int i) {
        return new SearchView.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public SearchView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SearchView.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public SearchView.SavedState createFromParcel(Parcel parcel) {
        return new SearchView.SavedState(parcel, null);
    }
}
