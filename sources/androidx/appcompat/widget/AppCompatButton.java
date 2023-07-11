package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class AppCompatButton extends Button implements androidx.core.h.r, androidx.core.widget.b {

    /* renamed from: a  reason: collision with root package name */
    private final C0056o f216a;

    /* renamed from: b  reason: collision with root package name */
    private final A f217b;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0056o c0056o = this.f216a;
        if (c0056o != null) {
            c0056o.a();
        }
        A a2 = this.f217b;
        if (a2 != null) {
            a2.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f559a) {
            return super.getAutoSizeMaxTextSize();
        }
        A a2 = this.f217b;
        if (a2 != null) {
            return a2.c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.f559a) {
            return super.getAutoSizeMinTextSize();
        }
        A a2 = this.f217b;
        if (a2 != null) {
            return a2.d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.f559a) {
            return super.getAutoSizeStepGranularity();
        }
        A a2 = this.f217b;
        if (a2 != null) {
            return a2.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.f559a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        A a2 = this.f217b;
        if (a2 != null) {
            return a2.f();
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f559a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        A a2 = this.f217b;
        if (a2 != null) {
            return a2.g();
        }
        return 0;
    }

    @Override // androidx.core.h.r
    public ColorStateList getSupportBackgroundTintList() {
        C0056o c0056o = this.f216a;
        if (c0056o != null) {
            return c0056o.b();
        }
        return null;
    }

    @Override // androidx.core.h.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0056o c0056o = this.f216a;
        if (c0056o != null) {
            return c0056o.c();
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        A a2 = this.f217b;
        if (a2 != null) {
            a2.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        A a2 = this.f217b;
        if (a2 == null || androidx.core.widget.b.f559a || !a2.h()) {
            return;
        }
        this.f217b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (androidx.core.widget.b.f559a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        A a2 = this.f217b;
        if (a2 != null) {
            a2.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0056o c0056o = this.f216a;
        if (c0056o != null) {
            c0056o.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0056o c0056o = this.f216a;
        if (c0056o != null) {
            c0056o.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.l.a(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        A a2 = this.f217b;
        if (a2 != null) {
            a2.a(z);
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0056o c0056o = this.f216a;
        if (c0056o != null) {
            c0056o.b(colorStateList);
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0056o c0056o = this.f216a;
        if (c0056o != null) {
            c0056o.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f217b;
        if (a2 != null) {
            a2.a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (androidx.core.widget.b.f559a) {
            super.setTextSize(i, f);
            return;
        }
        A a2 = this.f217b;
        if (a2 != null) {
            a2.a(i, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f216a = new C0056o(this);
        this.f216a.a(attributeSet, i);
        this.f217b = new A(this);
        this.f217b.a(attributeSet, i);
        this.f217b.a();
    }
}
