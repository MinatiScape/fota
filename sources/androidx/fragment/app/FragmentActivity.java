package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.ComponentActivity;
import androidx.core.app.b;
import androidx.lifecycle.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements androidx.lifecycle.u, b.a, b.c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    int mNextCandidateRequestIndex;
    a.b.j<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    private androidx.lifecycle.t mViewModelStore;
    final Handler mHandler = new HandlerC0077g(this);
    final C0079i mFragments = C0079i.a(new a());
    boolean mStopped = true;

    /* loaded from: classes.dex */
    class a extends AbstractC0080j<FragmentActivity> {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.AbstractC0080j
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.AbstractC0080j
        public boolean b(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.AbstractC0080j
        public LayoutInflater f() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.AbstractC0080j
        public int g() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.AbstractC0080j
        public boolean h() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.AbstractC0080j
        public void i() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.AbstractC0080j
        public void a(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.AbstractC0078h
        public View a(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // androidx.fragment.app.AbstractC0078h
        public boolean a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        Object f607a;

        /* renamed from: b  reason: collision with root package name */
        androidx.lifecycle.t f608b;
        s c;

        b() {
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.c(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.c(i, fragment.h);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void checkForValidRequestCode(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), f.b.CREATED));
    }

    private static boolean markState(AbstractC0081k abstractC0081k, f.b bVar) {
        boolean z = false;
        for (Fragment fragment : abstractC0081k.c()) {
            if (fragment != null) {
                if (fragment.getLifecycle().a().isAtLeast(f.b.STARTED)) {
                    fragment.U.a(bVar);
                    z = true;
                }
                AbstractC0081k N = fragment.N();
                if (N != null) {
                    z |= markState(N, bVar);
                }
            }
        }
        return z;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.j().a(str, fileDescriptor, printWriter, strArr);
    }

    public Object getLastCustomNonConfigurationInstance() {
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.f607a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.h
    public androidx.lifecycle.f getLifecycle() {
        return super.getLifecycle();
    }

    public AbstractC0081k getSupportFragmentManager() {
        return this.mFragments.j();
    }

    @Deprecated
    public androidx.loader.a.a getSupportLoaderManager() {
        return androidx.loader.a.a.a(this);
    }

    @Override // androidx.lifecycle.u
    public androidx.lifecycle.t getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                b bVar = (b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.mViewModelStore = bVar.f608b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new androidx.lifecycle.t();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.k();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String b2 = this.mPendingFragmentActivityResults.b(i4);
            this.mPendingFragmentActivityResults.e(i4);
            if (b2 == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.mFragments.a(b2);
            if (a2 == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + b2);
                return;
            }
            a2.a(i & 65535, i2, intent);
            return;
        }
        b.InterfaceC0007b a3 = androidx.core.app.b.a();
        if (a3 == null || !a3.a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AbstractC0081k j = this.mFragments.j();
        boolean d = j.d();
        if (!d || Build.VERSION.SDK_INT > 25) {
            if (d || !j.e()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.k();
        this.mFragments.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        androidx.lifecycle.t tVar;
        this.mFragments.a((Fragment) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null && (tVar = bVar.f608b) != null && this.mViewModelStore == null) {
            this.mViewModelStore = tVar;
        }
        if (bundle != null) {
            this.mFragments.a(bundle.getParcelable(FRAGMENTS_TAG), bVar != null ? bVar.c : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                    this.mPendingFragmentActivityResults = new a.b.j<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.c(intArray[i], stringArray[i]);
                    }
                } else {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new a.b.j<>();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.mFragments.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mViewModelStore != null && !isChangingConfigurations()) {
            this.mViewModelStore.a();
        }
        this.mFragments.c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.mFragments.a(menuItem);
        }
        return this.mFragments.b(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.a(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.e();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.i();
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0 && menu != null) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.b(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity, androidx.core.app.b.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.k();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String b2 = this.mPendingFragmentActivityResults.b(i3);
            this.mPendingFragmentActivityResults.e(i3);
            if (b2 == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.mFragments.a(b2);
            if (a2 == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + b2);
                return;
            }
            a2.a(i & 65535, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragments.f();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        s l = this.mFragments.l();
        if (l == null && this.mViewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        b bVar = new b();
        bVar.f607a = onRetainCustomNonConfigurationInstance;
        bVar.f608b = this.mViewModelStore;
        bVar.c = l;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        Parcelable m = this.mFragments.m();
        if (m != null) {
            bundle.putParcelable(FRAGMENTS_TAG, m);
        }
        if (this.mPendingFragmentActivityResults.b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.b(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.d(i);
                strArr[i] = this.mPendingFragmentActivityResults.f(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.a();
        }
        this.mFragments.k();
        this.mFragments.i();
        this.mFragments.g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.h();
    }

    void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            androidx.core.app.b.a(this, strArr, i);
            return;
        }
        checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            androidx.core.app.b.a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    public void setEnterSharedElementCallback(androidx.core.app.g gVar) {
        androidx.core.app.b.a(this, gVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.g gVar) {
        androidx.core.app.b.b(this, gVar);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.mStartedIntentSenderFromFragment = true;
        try {
            if (i == -1) {
                androidx.core.app.b.a(this, intentSender, i, intent, i2, i3, i4, bundle);
                return;
            }
            checkForValidRequestCode(i);
            androidx.core.app.b.a(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), intent, i2, i3, i4, bundle);
        } finally {
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.b.b(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.b.c(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.b.d(this);
    }

    @Override // androidx.core.app.b.c
    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.mRequestedPermissionsFromFragment || i == -1) {
            return;
        }
        checkForValidRequestCode(i);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        try {
            if (i == -1) {
                androidx.core.app.b.a(this, intent, -1, bundle);
                return;
            }
            checkForValidRequestCode(i);
            androidx.core.app.b.a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), bundle);
        } finally {
            this.mStartedActivityFromFragment = false;
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
