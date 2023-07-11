package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* compiled from: BottomSheetBehavior.java */
/* loaded from: classes.dex */
class b implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.SavedState> {
    @Override // android.os.Parcelable.Creator
    public BottomSheetBehavior.SavedState[] newArray(int i) {
        return new BottomSheetBehavior.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public BottomSheetBehavior.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public BottomSheetBehavior.SavedState createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.SavedState(parcel, (ClassLoader) null);
    }
}
