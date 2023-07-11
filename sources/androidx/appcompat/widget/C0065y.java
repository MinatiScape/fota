package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatSpinner.java */
/* renamed from: androidx.appcompat.widget.y  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0065y implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f371a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f372b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0065y(AppCompatSpinner.b bVar, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f372b = bVar;
        this.f371a = onGlobalLayoutListener;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f371a);
        }
    }
}
