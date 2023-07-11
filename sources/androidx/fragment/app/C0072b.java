package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: BackStackRecord.java */
/* renamed from: androidx.fragment.app.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0072b implements Parcelable.Creator<BackStackState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BackStackState createFromParcel(Parcel parcel) {
        return new BackStackState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BackStackState[] newArray(int i) {
        return new BackStackState[i];
    }
}
