package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatSpinner.java */
/* renamed from: androidx.appcompat.widget.x  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewTreeObserver$OnGlobalLayoutListenerC0064x implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC0064x(AppCompatSpinner.b bVar) {
        this.f370a = bVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        AppCompatSpinner.b bVar = this.f370a;
        if (!bVar.b(AppCompatSpinner.this)) {
            this.f370a.dismiss();
            return;
        }
        this.f370a.i();
        super/*androidx.appcompat.widget.ListPopupWindow*/.show();
    }
}
