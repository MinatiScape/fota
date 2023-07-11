package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements androidx.core.h.r {

    /* renamed from: a  reason: collision with root package name */
    private final C0056o f221a;

    /* renamed from: b  reason: collision with root package name */
    private final A f222b;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0056o c0056o = this.f221a;
        if (c0056o != null) {
            c0056o.a();
        }
        A a2 = this.f222b;
        if (a2 != null) {
            a2.a();
        }
    }

    @Override // androidx.core.h.r
    public ColorStateList getSupportBackgroundTintList() {
        C0056o c0056o = this.f221a;
        if (c0056o != null) {
            return c0056o.b();
        }
        return null;
    }

    @Override // androidx.core.h.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0056o c0056o = this.f221a;
        if (c0056o != null) {
            return c0056o.c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0056o c0056o = this.f221a;
        if (c0056o != null) {
            c0056o.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0056o c0056o = this.f221a;
        if (c0056o != null) {
            c0056o.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.l.a(this, callback));
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0056o c0056o = this.f221a;
        if (c0056o != null) {
            c0056o.b(colorStateList);
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0056o c0056o = this.f221a;
        if (c0056o != null) {
            c0056o.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f222b;
        if (a2 != null) {
            a2.a(context, i);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f221a = new C0056o(this);
        this.f221a.a(attributeSet, i);
        this.f222b = new A(this);
        this.f222b.a(attributeSet, i);
        this.f222b.a();
    }
}
