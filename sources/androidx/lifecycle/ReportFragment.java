package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.f;
/* loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private a f676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onCreate();

        void onResume();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f676a);
        a(f.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(f.a.ON_DESTROY);
        this.f676a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(f.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        b(this.f676a);
        a(f.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.f676a);
        a(f.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(f.a.ON_STOP);
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    private void a(f.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof k) {
            ((k) activity).getLifecycle().b(aVar);
        } else if (activity instanceof h) {
            f lifecycle = ((h) activity).getLifecycle();
            if (lifecycle instanceof j) {
                ((j) lifecycle).b(aVar);
            }
        }
    }
}
