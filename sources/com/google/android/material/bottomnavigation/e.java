package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
/* compiled from: BottomNavigationView.java */
/* loaded from: classes.dex */
class e implements Parcelable.ClassLoaderCreator<BottomNavigationView.SavedState> {
    @Override // android.os.Parcelable.Creator
    public BottomNavigationView.SavedState[] newArray(int i) {
        return new BottomNavigationView.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public BottomNavigationView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomNavigationView.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public BottomNavigationView.SavedState createFromParcel(Parcel parcel) {
        return new BottomNavigationView.SavedState(parcel, null);
    }
}
