package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f229a;
    private boolean mOverlapAnchor;

    static {
        f229a = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        ia a2 = ia.a(context, attributeSet, R$styleable.PopupWindow, i, i2);
        if (a2.g(R$styleable.PopupWindow_overlapAnchor)) {
            a(a2.a(R$styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.b(R$styleable.PopupWindow_android_popupBackground));
        a2.a();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f229a && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f229a && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f229a && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    private void a(boolean z) {
        if (f229a) {
            this.mOverlapAnchor = z;
        } else {
            androidx.core.widget.k.a(this, z);
        }
    }
}
