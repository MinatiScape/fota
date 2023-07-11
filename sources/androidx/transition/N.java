package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class N {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f925a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f926b;

    public void a() {
        Runnable runnable;
        if (a(this.f925a) != this || (runnable = this.f926b) == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, N n) {
        view.setTag(R$id.transition_current_scene, n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static N a(View view) {
        return (N) view.getTag(R$id.transition_current_scene);
    }
}
