package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.f.c;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements androidx.core.h.r, androidx.core.widget.b {

    /* renamed from: a  reason: collision with root package name */
    private final C0056o f238a;

    /* renamed from: b  reason: collision with root package name */
    private final A f239b;
    private Future<androidx.core.f.c> c;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void a() {
        Future<androidx.core.f.c> future = this.c;
        if (future != null) {
            try {
                this.c = null;
                androidx.core.widget.l.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0056o c0056o = this.f238a;
        if (c0056o != null) {
            c0056o.a();
        }
        A a2 = this.f239b;
        if (a2 != null) {
            a2.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f559a) {
            return super.getAutoSizeMaxTextSize();
        }
        A a2 = this.f239b;
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
        A a2 = this.f239b;
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
        A a2 = this.f239b;
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
        A a2 = this.f239b;
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
        A a2 = this.f239b;
        if (a2 != null) {
            return a2.g();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.l.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.l.c(this);
    }

    @Override // androidx.core.h.r
    public ColorStateList getSupportBackgroundTintList() {
        C0056o c0056o = this.f238a;
        if (c0056o != null) {
            return c0056o.b();
        }
        return null;
    }

    @Override // androidx.core.h.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0056o c0056o = this.f238a;
        if (c0056o != null) {
            return c0056o.c();
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        a();
        return super.getText();
    }

    public c.a getTextMetricsParamsCompat() {
        return androidx.core.widget.l.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        A a2 = this.f239b;
        if (a2 != null) {
            a2.a(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        A a2 = this.f239b;
        if (a2 == null || androidx.core.widget.b.f559a || !a2.h()) {
            return;
        }
        this.f239b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (androidx.core.widget.b.f559a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        A a2 = this.f239b;
        if (a2 != null) {
            a2.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0056o c0056o = this.f238a;
        if (c0056o != null) {
            c0056o.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0056o c0056o = this.f238a;
        if (c0056o != null) {
            c0056o.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.l.a(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            androidx.core.widget.l.a(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            androidx.core.widget.l.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        androidx.core.widget.l.c(this, i);
    }

    public void setPrecomputedText(androidx.core.f.c cVar) {
        androidx.core.widget.l.a(this, cVar);
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0056o c0056o = this.f238a;
        if (c0056o != null) {
            c0056o.b(colorStateList);
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0056o c0056o = this.f238a;
        if (c0056o != null) {
            c0056o.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f239b;
        if (a2 != null) {
            a2.a(context, i);
        }
    }

    public void setTextFuture(Future<androidx.core.f.c> future) {
        this.c = future;
        requestLayout();
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        androidx.core.widget.l.a(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (androidx.core.widget.b.f559a) {
            super.setTextSize(i, f);
            return;
        }
        A a2 = this.f239b;
        if (a2 != null) {
            a2.a(i, f);
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f238a = new C0056o(this);
        this.f238a.a(attributeSet, i);
        this.f239b = new A(this);
        this.f239b.a(attributeSet, i);
        this.f239b.a();
    }
}
