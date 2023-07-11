package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomappbar.BottomAppBar;
/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
class h implements Parcelable.ClassLoaderCreator<BottomAppBar.SavedState> {
    @Override // android.os.Parcelable.Creator
    public BottomAppBar.SavedState[] newArray(int i) {
        return new BottomAppBar.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public BottomAppBar.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomAppBar.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public BottomAppBar.SavedState createFromParcel(Parcel parcel) {
        return new BottomAppBar.SavedState(parcel, null);
    }
}
