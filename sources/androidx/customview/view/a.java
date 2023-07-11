package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: AbsSavedState.java */
/* loaded from: classes.dex */
class a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
    @Override // android.os.Parcelable.Creator
    public AbsSavedState[] newArray(int i) {
        return new AbsSavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.f576a;
        }
        throw new IllegalStateException("superState must be null");
    }

    @Override // android.os.Parcelable.Creator
    public AbsSavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
