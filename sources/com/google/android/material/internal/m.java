package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ParcelableSparseArray.java */
/* loaded from: classes.dex */
class m implements Parcelable.ClassLoaderCreator<ParcelableSparseArray> {
    @Override // android.os.Parcelable.Creator
    public ParcelableSparseArray[] newArray(int i) {
        return new ParcelableSparseArray[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public ParcelableSparseArray createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ParcelableSparseArray(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public ParcelableSparseArray createFromParcel(Parcel parcel) {
        return new ParcelableSparseArray(parcel, null);
    }
}
