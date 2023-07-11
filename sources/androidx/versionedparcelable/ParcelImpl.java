package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final d f1023a;

    /* JADX INFO: Access modifiers changed from: protected */
    public ParcelImpl(Parcel parcel) {
        this.f1023a = new c(parcel).h();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new c(parcel).a(this.f1023a);
    }
}
