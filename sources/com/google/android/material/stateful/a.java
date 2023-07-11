package com.google.android.material.stateful;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ExtendableSavedState.java */
/* loaded from: classes.dex */
class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
    @Override // android.os.Parcelable.Creator
    public ExtendableSavedState[] newArray(int i) {
        return new ExtendableSavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ExtendableSavedState(parcel, classLoader, null);
    }

    @Override // android.os.Parcelable.Creator
    public ExtendableSavedState createFromParcel(Parcel parcel) {
        return new ExtendableSavedState(parcel, null, null);
    }
}
