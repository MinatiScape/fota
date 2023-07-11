package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.navigation.NavigationView;
/* compiled from: NavigationView.java */
/* loaded from: classes.dex */
class b implements Parcelable.ClassLoaderCreator<NavigationView.SavedState> {
    @Override // android.os.Parcelable.Creator
    public NavigationView.SavedState[] newArray(int i) {
        return new NavigationView.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public NavigationView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new NavigationView.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public NavigationView.SavedState createFromParcel(Parcel parcel) {
        return new NavigationView.SavedState(parcel, null);
    }
}
