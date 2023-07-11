package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.d.b;
import androidx.core.h.C0070d;
/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class A extends Dialog implements m {

    /* renamed from: a  reason: collision with root package name */
    private n f46a;

    /* renamed from: b  reason: collision with root package name */
    private final C0070d.a f47b;

    public A(Context context, int i) {
        super(context, a(context, i));
        this.f47b = new z(this);
        a().a((Bundle) null);
        a().a();
    }

    public boolean a(int i) {
        return a().b(i);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0070d.a(this.f47b, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().a(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().f();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().k();
    }

    @Override // androidx.appcompat.app.m
    public void onSupportActionModeFinished(androidx.appcompat.d.b bVar) {
    }

    @Override // androidx.appcompat.app.m
    public void onSupportActionModeStarted(androidx.appcompat.d.b bVar) {
    }

    @Override // androidx.appcompat.app.m
    public androidx.appcompat.d.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().c(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    public n a() {
        if (this.f46a == null) {
            this.f46a = n.a(this, this);
        }
        return this.f46a;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    private static int a(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
