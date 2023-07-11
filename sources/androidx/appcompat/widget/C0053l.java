package androidx.appcompat.widget;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
/* compiled from: ActivityChooserView.java */
/* renamed from: androidx.appcompat.widget.l  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0053l extends View.AccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f340a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0053l(ActivityChooserView activityChooserView) {
        this.f340a = activityChooserView;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        androidx.core.h.a.c.a(accessibilityNodeInfo).b(true);
    }
}
