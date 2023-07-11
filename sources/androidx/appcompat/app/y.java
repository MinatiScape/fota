package androidx.appcompat.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class y implements Parcelable.ClassLoaderCreator<AppCompatDelegateImpl.PanelFeatureState.SavedState> {
    @Override // android.os.Parcelable.Creator
    public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int i) {
        return new AppCompatDelegateImpl.PanelFeatureState.SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel parcel) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(parcel, null);
    }
}
