package androidx.core.h;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: androidx.core.h.a  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0067a {

    /* renamed from: a  reason: collision with root package name */
    private static final View.AccessibilityDelegate f512a = new View.AccessibilityDelegate();

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f513b = new C0012a(this);

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: androidx.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0012a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final C0067a f514a;

        C0012a(C0067a c0067a) {
            this.f514a = c0067a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f514a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.h.a.d a2 = this.f514a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f514a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f514a.a(view, androidx.core.h.a.c.a(accessibilityNodeInfo));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f514a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f514a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f514a.a(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f514a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f514a.d(view, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.f513b;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        f512a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        f512a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        f512a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void a(View view, int i) {
        f512a.sendAccessibilityEvent(view, i);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return f512a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, androidx.core.h.a.c cVar) {
        f512a.onInitializeAccessibilityNodeInfo(view, cVar.x());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f512a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public androidx.core.h.a.d a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = f512a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new androidx.core.h.a.d(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return f512a.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }
}
