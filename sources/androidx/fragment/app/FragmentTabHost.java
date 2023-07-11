package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f613a;

    /* renamed from: b  reason: collision with root package name */
    private AbstractC0081k f614b;
    private int c;
    private a d;
    private boolean e;
    private Context mContext;
    private TabHost.OnTabChangeListener mOnTabChangeListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new v();

        /* renamed from: a  reason: collision with root package name */
        String f615a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f615a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f615a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel) {
            super(parcel);
            this.f615a = parcel.readString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f616a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f617b;
        final Bundle c;
        Fragment d;
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        this.f613a = new ArrayList<>();
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.c = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f613a.size();
        w wVar = null;
        for (int i = 0; i < size; i++) {
            a aVar = this.f613a.get(i);
            aVar.d = this.f614b.a(aVar.f616a);
            Fragment fragment = aVar.d;
            if (fragment != null && !fragment.z()) {
                if (aVar.f616a.equals(currentTabTag)) {
                    this.d = aVar;
                } else {
                    if (wVar == null) {
                        wVar = this.f614b.a();
                    }
                    wVar.b(aVar.d);
                }
            }
        }
        this.e = true;
        w a2 = a(currentTabTag, wVar);
        if (a2 != null) {
            a2.a();
            this.f614b.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e = false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f615a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f615a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        w a2;
        if (this.e && (a2 = a(str, (w) null)) != null) {
            a2.a();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f613a = new ArrayList<>();
        a(context, attributeSet);
    }

    private w a(String str, w wVar) {
        Fragment fragment;
        a a2 = a(str);
        if (this.d != a2) {
            if (wVar == null) {
                wVar = this.f614b.a();
            }
            a aVar = this.d;
            if (aVar != null && (fragment = aVar.d) != null) {
                wVar.b(fragment);
            }
            if (a2 != null) {
                Fragment fragment2 = a2.d;
                if (fragment2 == null) {
                    a2.d = Fragment.a(this.mContext, a2.f617b.getName(), a2.c);
                    wVar.a(this.c, a2.d, a2.f616a);
                } else {
                    wVar.a(fragment2);
                }
            }
            this.d = a2;
        }
        return wVar;
    }

    private a a(String str) {
        int size = this.f613a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f613a.get(i);
            if (aVar.f616a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
