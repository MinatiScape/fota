package androidx.core.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
/* compiled from: AccessibilityManagerCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: AccessibilityManagerCompat.java */
    /* loaded from: classes.dex */
    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* compiled from: AccessibilityManagerCompat.java */
    /* renamed from: androidx.core.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0013b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final a f515a;

        accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0013b(a aVar) {
            this.f515a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0013b.class != obj.getClass()) {
                return false;
            }
            return this.f515a.equals(((accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0013b) obj).f515a);
        }

        public int hashCode() {
            return this.f515a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f515a.onTouchExplorationStateChanged(z);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0013b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0013b(aVar));
    }
}
