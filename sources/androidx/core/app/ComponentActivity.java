package androidx.core.app;

import a.b.i;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.h.C0070d;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.f;
import androidx.lifecycle.j;
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements androidx.lifecycle.h, C0070d.a {
    private i<Class<? extends a>, a> mExtraDataMap = new i<>();
    private j mLifecycleRegistry = new j(this);

    /* loaded from: classes.dex */
    public static class a {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0070d.a(decorView, keyEvent)) {
            return C0070d.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0070d.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    @Override // androidx.lifecycle.h
    public androidx.lifecycle.f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.a(f.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    @Override // androidx.core.h.C0070d.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
