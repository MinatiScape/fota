package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
/* loaded from: classes.dex */
public class BottomNavigationPresenter implements v {

    /* renamed from: a  reason: collision with root package name */
    private l f1290a;

    /* renamed from: b  reason: collision with root package name */
    private BottomNavigationMenuView f1291b;
    private boolean c = false;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        int f1292a;

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1292a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel) {
            this.f1292a = parcel.readInt();
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(l lVar, boolean z) {
    }

    public void a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f1291b = bottomNavigationMenuView;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(D d) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(l lVar, p pVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean b(l lVar, p pVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public int getId() {
        return this.d;
    }

    @Override // androidx.appcompat.view.menu.v
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1291b.b(((SavedState) parcelable).f1292a);
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f1292a = this.f1291b.getSelectedItemId();
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.v
    public void updateMenuView(boolean z) {
        if (this.c) {
            return;
        }
        if (z) {
            this.f1291b.a();
        } else {
            this.f1291b.c();
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(Context context, l lVar) {
        this.f1290a = lVar;
        this.f1291b.a(this.f1290a);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
