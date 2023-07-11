package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;
/* compiled from: BottomNavigationPresenter.java */
/* loaded from: classes.dex */
class c implements Parcelable.Creator<BottomNavigationPresenter.SavedState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BottomNavigationPresenter.SavedState createFromParcel(Parcel parcel) {
        return new BottomNavigationPresenter.SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BottomNavigationPresenter.SavedState[] newArray(int i) {
        return new BottomNavigationPresenter.SavedState[i];
    }
}
