package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout;
/* compiled from: DrawerLayout.java */
/* loaded from: classes.dex */
class b implements Parcelable.ClassLoaderCreator<DrawerLayout.SavedState> {
    @Override // android.os.Parcelable.Creator
    public DrawerLayout.SavedState[] newArray(int i) {
        return new DrawerLayout.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public DrawerLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public DrawerLayout.SavedState createFromParcel(Parcel parcel) {
        return new DrawerLayout.SavedState(parcel, null);
    }
}
