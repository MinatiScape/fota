package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f219a = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final A f220b;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        A a2 = this.f220b;
        if (a2 != null) {
            a2.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.l.a(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f220b;
        if (a2 != null) {
            a2.a(context, i);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f220b = new A(this);
        this.f220b.a(attributeSet, i);
        this.f220b.a();
        ia a2 = ia.a(getContext(), attributeSet, f219a, i, 0);
        setCheckMarkDrawable(a2.b(0));
        a2.a();
    }
}
