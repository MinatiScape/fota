package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
class ma implements Parcelable.ClassLoaderCreator<Toolbar.SavedState> {
    @Override // android.os.Parcelable.Creator
    public Toolbar.SavedState[] newArray(int i) {
        return new Toolbar.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public Toolbar.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public Toolbar.SavedState createFromParcel(Parcel parcel) {
        return new Toolbar.SavedState(parcel, null);
    }
}
