package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.textfield.TextInputLayout;
/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
class g implements Parcelable.ClassLoaderCreator<TextInputLayout.SavedState> {
    @Override // android.os.Parcelable.Creator
    public TextInputLayout.SavedState[] newArray(int i) {
        return new TextInputLayout.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public TextInputLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public TextInputLayout.SavedState createFromParcel(Parcel parcel) {
        return new TextInputLayout.SavedState(parcel, null);
    }
}
