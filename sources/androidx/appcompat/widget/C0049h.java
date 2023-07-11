package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.ActionMenuPresenter;
/* compiled from: ActionMenuPresenter.java */
/* renamed from: androidx.appcompat.widget.h  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0049h implements Parcelable.Creator<ActionMenuPresenter.SavedState> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ActionMenuPresenter.SavedState createFromParcel(Parcel parcel) {
        return new ActionMenuPresenter.SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ActionMenuPresenter.SavedState[] newArray(int i) {
        return new ActionMenuPresenter.SavedState[i];
    }
}
