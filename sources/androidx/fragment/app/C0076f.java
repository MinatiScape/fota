package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
/* compiled from: Fragment.java */
/* renamed from: androidx.fragment.app.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0076f implements Parcelable.ClassLoaderCreator<Fragment.SavedState> {
    @Override // android.os.Parcelable.Creator
    public Fragment.SavedState[] newArray(int i) {
        return new Fragment.SavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public Fragment.SavedState createFromParcel(Parcel parcel) {
        return new Fragment.SavedState(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public Fragment.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Fragment.SavedState(parcel, classLoader);
    }
}
