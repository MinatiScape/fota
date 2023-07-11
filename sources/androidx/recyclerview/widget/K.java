package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* compiled from: StaggeredGridLayoutManager.java */
/* loaded from: classes.dex */
class K implements Parcelable.Creator<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int i) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[i];
    }
}
