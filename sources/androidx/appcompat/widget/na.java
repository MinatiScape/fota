package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.C0037a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class na implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C0037a f343a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ pa f344b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public na(pa paVar) {
        this.f344b = paVar;
        this.f343a = new C0037a(this.f344b.f351a.getContext(), 0, 16908332, 0, 0, this.f344b.i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        pa paVar = this.f344b;
        Window.Callback callback = paVar.l;
        if (callback == null || !paVar.m) {
            return;
        }
        callback.onMenuItemSelected(0, this.f343a);
    }
}
