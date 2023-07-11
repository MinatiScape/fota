package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.appbar.AppBarLayout;
/* compiled from: AppBarLayout.java */
/* loaded from: classes.dex */
class c implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.SavedState> {
    @Override // android.os.Parcelable.Creator
    public AppBarLayout.BaseBehavior.SavedState[] newArray(int i) {
        return new AppBarLayout.BaseBehavior.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout.BaseBehavior.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel parcel) {
        return new AppBarLayout.BaseBehavior.SavedState(parcel, null);
    }
}
