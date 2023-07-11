package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import org.greenrobot.eventbus.e;
/* loaded from: classes.dex */
public class ErrorDialogManager {

    /* renamed from: a  reason: collision with root package name */
    public static b<?> f1526a;

    @TargetApi(11)
    /* loaded from: classes.dex */
    public static class HoneycombManagerFragment extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        private e f1527a;

        @Override // android.app.Fragment
        public void onPause() {
            this.f1527a.d(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            ErrorDialogManager.f1526a.f1528a.a();
            throw null;
        }
    }
}
