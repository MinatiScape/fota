package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* compiled from: CoordinatorLayout.java */
/* loaded from: classes.dex */
class b implements Parcelable.ClassLoaderCreator<CoordinatorLayout.SavedState> {
    @Override // android.os.Parcelable.Creator
    public CoordinatorLayout.SavedState[] newArray(int i) {
        return new CoordinatorLayout.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public CoordinatorLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public CoordinatorLayout.SavedState createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.SavedState(parcel, null);
    }
}
