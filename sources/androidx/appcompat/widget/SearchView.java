package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements androidx.appcompat.d.c {
    static final a p = new a();
    private Rect A;
    private int[] B;
    private int[] C;
    private final ImageView D;
    private final Drawable E;
    private final int F;
    private final int G;
    private final Intent H;
    private final Intent I;
    private final CharSequence J;
    private c K;
    private b L;
    View.OnFocusChangeListener M;
    private d N;
    private View.OnClickListener O;
    private boolean P;
    private boolean Q;
    a.c.a.a R;
    private boolean S;
    private CharSequence T;
    private boolean U;
    private boolean V;
    private int W;
    private boolean aa;
    private CharSequence ba;
    private CharSequence ca;
    private boolean da;
    private int ea;
    SearchableInfo fa;
    private Bundle ga;
    private final Runnable ha;
    private Runnable ia;
    private final WeakHashMap<String, Drawable.ConstantState> ja;
    private final View.OnClickListener ka;
    View.OnKeyListener la;
    private e mTouchDelegate;
    private final TextView.OnEditorActionListener ma;
    private final AdapterView.OnItemClickListener na;
    private final AdapterView.OnItemSelectedListener oa;
    private TextWatcher pa;
    final SearchAutoComplete q;
    private final View r;
    private final View s;
    private final View t;
    final ImageView u;
    final ImageView v;
    final ImageView w;
    final ImageView x;
    private final View y;
    private Rect z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Z();
        boolean c;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private SearchView d;
        private boolean e;
        final Runnable f;
        private int mThreshold;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                if (i < 600) {
                    return (i < 640 || i2 < 480) ? 160 : 192;
                }
                return 192;
            }
            return CpioConstants.C_IRUSR;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            if (this.e) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.e = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.e) {
                removeCallbacks(this.f);
                post(this.f);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.d.g();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.d.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.d.hasFocus() && getVisibility() == 0) {
                this.e = true;
                if (SearchView.a(getContext())) {
                    SearchView.p.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.e = false;
                removeCallbacks(this.f);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.e = false;
                removeCallbacks(this.f);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.e = true;
            }
        }

        void setSearchView(SearchView searchView) {
            this.d = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.mThreshold = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f = new aa(this);
            this.mThreshold = getThreshold();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean onClose();
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    /* loaded from: classes.dex */
    private static class e extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f290a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f291b;
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds;

        public e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f290a = new Rect();
            this.mSlopBounds = new Rect();
            this.f291b = new Rect();
            a(rect, rect2);
            this.mDelegateView = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f290a.set(rect);
            this.mSlopBounds.set(rect);
            Rect rect3 = this.mSlopBounds;
            int i = this.mSlop;
            rect3.inset(-i, -i);
            this.f291b.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action == 0) {
                if (this.f290a.contains(x, y)) {
                    this.mDelegateTargeted = true;
                    z = true;
                }
                z = false;
            } else if (action == 1 || action == 2) {
                z = this.mDelegateTargeted;
                if (z && !this.mSlopBounds.contains(x, y)) {
                    z2 = false;
                }
            } else {
                if (action == 3) {
                    z = this.mDelegateTargeted;
                    this.mDelegateTargeted = false;
                }
                z = false;
            }
            if (z) {
                if (z2 && !this.f291b.contains(x, y)) {
                    motionEvent.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
                } else {
                    Rect rect = this.f291b;
                    motionEvent.setLocation(x - rect.left, y - rect.top);
                }
                return this.mDelegateView.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private void b(boolean z) {
        this.Q = z;
        int i = 8;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.q.getText());
        this.u.setVisibility(i2);
        a(z2);
        this.r.setVisibility(z ? 8 : 0);
        if (this.D.getDrawable() != null && !this.P) {
            i = 0;
        }
        this.D.setVisibility(i);
        n();
        c(z2 ? false : true);
        q();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    private void j() {
        this.q.dismissDropDown();
    }

    private boolean k() {
        SearchableInfo searchableInfo = this.fa;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.fa.getVoiceSearchLaunchWebSearch()) {
            intent = this.H;
        } else if (this.fa.getVoiceSearchLaunchRecognizer()) {
            intent = this.I;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean l() {
        return (this.S || this.aa) && !c();
    }

    private void m() {
        post(this.ha);
    }

    private void n() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.q.getText());
        if (!z2 && (!this.P || this.da)) {
            z = false;
        }
        this.w.setVisibility(z ? 0 : 8);
        Drawable drawable = this.w.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void o() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(c(queryHint));
    }

    private void p() {
        this.q.setThreshold(this.fa.getSuggestThreshold());
        this.q.setImeOptions(this.fa.getImeOptions());
        int inputType = this.fa.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.fa.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.q.setInputType(inputType);
        a.c.a.a aVar = this.R;
        if (aVar != null) {
            aVar.changeCursor(null);
        }
        if (this.fa.getSuggestAuthority() != null) {
            this.R = new ba(getContext(), this, this.fa, this.ja);
            this.q.setAdapter(this.R);
            ((ba) this.R).a(this.U ? 2 : 1);
        }
    }

    private void q() {
        this.t.setVisibility((l() && (this.v.getVisibility() == 0 || this.x.getVisibility() == 0)) ? 0 : 8);
    }

    private void setQuery(CharSequence charSequence) {
        this.q.setText(charSequence);
        this.q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void a(CharSequence charSequence, boolean z) {
        this.q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.ca = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        f();
    }

    public boolean c() {
        return this.Q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.V = true;
        super.clearFocus();
        this.q.clearFocus();
        this.q.setImeVisibility(false);
        this.V = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (TextUtils.isEmpty(this.q.getText())) {
            if (this.P) {
                b bVar = this.L;
                if (bVar == null || !bVar.onClose()) {
                    clearFocus();
                    b(true);
                    return;
                }
                return;
            }
            return;
        }
        this.q.setText("");
        this.q.requestFocus();
        this.q.setImeVisibility(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        b(false);
        this.q.requestFocus();
        this.q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.O;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        Editable text = this.q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        c cVar = this.K;
        if (cVar == null || !cVar.onQueryTextSubmit(text.toString())) {
            if (this.fa != null) {
                a(0, (String) null, text.toString());
            }
            this.q.setImeVisibility(false);
            j();
        }
    }

    void g() {
        b(c());
        m();
        if (this.q.hasFocus()) {
            b();
        }
    }

    public int getImeOptions() {
        return this.q.getImeOptions();
    }

    public int getInputType() {
        return this.q.getInputType();
    }

    public int getMaxWidth() {
        return this.W;
    }

    public CharSequence getQuery() {
        return this.q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.T;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.fa;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.fa.getHintId());
        }
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.F;
    }

    public a.c.a.a getSuggestionsAdapter() {
        return this.R;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        SearchableInfo searchableInfo = this.fa;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(b(this.H, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(a(this.I, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int[] iArr = this.q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // androidx.appcompat.d.c
    public void onActionViewCollapsed() {
        a("", false);
        clearFocus();
        b(true);
        this.q.setImeOptions(this.ea);
        this.da = false;
    }

    @Override // androidx.appcompat.d.c
    public void onActionViewExpanded() {
        if (this.da) {
            return;
        }
        this.da = true;
        this.ea = this.q.getImeOptions();
        this.q.setImeOptions(this.ea | 33554432);
        this.q.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ha);
        post(this.ia);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(this.q, this.z);
            Rect rect = this.A;
            Rect rect2 = this.z;
            rect.set(rect2.left, 0, rect2.right, i4 - i2);
            e eVar = this.mTouchDelegate;
            if (eVar == null) {
                this.mTouchDelegate = new e(this.A, this.z, this.q);
                setTouchDelegate(this.mTouchDelegate);
                return;
            }
            eVar.a(this.A, this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.W;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.W;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.W) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        b(savedState.c);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = c();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (!this.V && isFocusable()) {
            if (!c()) {
                boolean requestFocus = this.q.requestFocus(i, rect);
                if (requestFocus) {
                    b(false);
                }
                return requestFocus;
            }
            return super.requestFocus(i, rect);
        }
        return false;
    }

    public void setAppSearchData(Bundle bundle) {
        this.ga = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            d();
        } else {
            e();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.P == z) {
            return;
        }
        this.P = z;
        b(z);
        o();
    }

    public void setImeOptions(int i) {
        this.q.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.q.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.W = i;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
        this.L = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
        this.K = cVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.O = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.N = dVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.T = charSequence;
        o();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.U = z;
        a.c.a.a aVar = this.R;
        if (aVar instanceof ba) {
            ((ba) aVar).a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.fa = searchableInfo;
        if (this.fa != null) {
            p();
            o();
        }
        this.aa = k();
        if (this.aa) {
            this.q.setPrivateImeOptions("nm");
        }
        b(c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.S = z;
        b(c());
    }

    public void setSuggestionsAdapter(a.c.a.a aVar) {
        this.R = aVar;
        this.q.setAdapter(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Method f288a;

        /* renamed from: b  reason: collision with root package name */
        private Method f289b;
        private Method c;

        a() {
            try {
                this.f288a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f288a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f289b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f289b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f289b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f288a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    private CharSequence c(CharSequence charSequence) {
        if (!this.P || this.E == null) {
            return charSequence;
        }
        double textSize = this.q.getTextSize();
        Double.isNaN(textSize);
        int i = (int) (textSize * 1.25d);
        this.E.setBounds(0, 0, i, i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.C = new int[2];
        this.ha = new P(this);
        this.ia = new Q(this);
        this.ja = new WeakHashMap<>();
        this.ka = new U(this);
        this.la = new V(this);
        this.ma = new W(this);
        this.na = new X(this);
        this.oa = new Y(this);
        this.pa = new O(this);
        ia a2 = ia.a(context, attributeSet, R$styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a2.g(R$styleable.SearchView_layout, R$layout.abc_search_view), (ViewGroup) this, true);
        this.q = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.q.setSearchView(this);
        this.r = findViewById(R$id.search_edit_frame);
        this.s = findViewById(R$id.search_plate);
        this.t = findViewById(R$id.submit_area);
        this.u = (ImageView) findViewById(R$id.search_button);
        this.v = (ImageView) findViewById(R$id.search_go_btn);
        this.w = (ImageView) findViewById(R$id.search_close_btn);
        this.x = (ImageView) findViewById(R$id.search_voice_btn);
        this.D = (ImageView) findViewById(R$id.search_mag_icon);
        androidx.core.h.t.a(this.s, a2.b(R$styleable.SearchView_queryBackground));
        androidx.core.h.t.a(this.t, a2.b(R$styleable.SearchView_submitBackground));
        this.u.setImageDrawable(a2.b(R$styleable.SearchView_searchIcon));
        this.v.setImageDrawable(a2.b(R$styleable.SearchView_goIcon));
        this.w.setImageDrawable(a2.b(R$styleable.SearchView_closeIcon));
        this.x.setImageDrawable(a2.b(R$styleable.SearchView_voiceIcon));
        this.D.setImageDrawable(a2.b(R$styleable.SearchView_searchIcon));
        this.E = a2.b(R$styleable.SearchView_searchHintIcon);
        qa.a(this.u, getResources().getString(R$string.abc_searchview_description_search));
        this.F = a2.g(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.G = a2.g(R$styleable.SearchView_commitIcon, 0);
        this.u.setOnClickListener(this.ka);
        this.w.setOnClickListener(this.ka);
        this.v.setOnClickListener(this.ka);
        this.x.setOnClickListener(this.ka);
        this.q.setOnClickListener(this.ka);
        this.q.addTextChangedListener(this.pa);
        this.q.setOnEditorActionListener(this.ma);
        this.q.setOnItemClickListener(this.na);
        this.q.setOnItemSelectedListener(this.oa);
        this.q.setOnKeyListener(this.la);
        this.q.setOnFocusChangeListener(new S(this));
        setIconifiedByDefault(a2.a(R$styleable.SearchView_iconifiedByDefault, true));
        int c2 = a2.c(R$styleable.SearchView_android_maxWidth, -1);
        if (c2 != -1) {
            setMaxWidth(c2);
        }
        this.J = a2.e(R$styleable.SearchView_defaultQueryHint);
        this.T = a2.e(R$styleable.SearchView_queryHint);
        int d2 = a2.d(R$styleable.SearchView_android_imeOptions, -1);
        if (d2 != -1) {
            setImeOptions(d2);
        }
        int d3 = a2.d(R$styleable.SearchView_android_inputType, -1);
        if (d3 != -1) {
            setInputType(d3);
        }
        setFocusable(a2.a(R$styleable.SearchView_android_focusable, true));
        a2.a();
        this.H = new Intent("android.speech.action.WEB_SEARCH");
        this.H.addFlags(268435456);
        this.H.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.I = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I.addFlags(268435456);
        this.y = findViewById(this.q.getDropDownAnchor());
        View view = this.y;
        if (view != null) {
            view.addOnLayoutChangeListener(new T(this));
        }
        b(this.P);
        o();
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.B);
        getLocationInWindow(this.C);
        int[] iArr = this.B;
        int i = iArr[1];
        int[] iArr2 = this.C;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    private void e(int i) {
        Editable text = this.q.getText();
        Cursor cursor = this.R.getCursor();
        if (cursor == null) {
            return;
        }
        if (cursor.moveToPosition(i)) {
            CharSequence convertToString = this.R.convertToString(cursor);
            if (convertToString != null) {
                setQuery(convertToString);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    private void c(boolean z) {
        int i;
        if (this.aa && !c() && z) {
            i = 0;
            this.v.setVisibility(8);
        } else {
            i = 8;
        }
        this.x.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i) {
        d dVar = this.N;
        if (dVar == null || !dVar.onSuggestionSelect(i)) {
            e(i);
            return true;
        }
        return false;
    }

    private void a(boolean z) {
        this.v.setVisibility((this.S && l() && hasFocus() && (z || !this.aa)) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        Editable text = this.q.getText();
        this.ca = text;
        boolean z = !TextUtils.isEmpty(text);
        a(z);
        c(z ? false : true);
        n();
        q();
        if (this.K != null && !TextUtils.equals(charSequence, this.ba)) {
            this.K.onQueryTextChange(charSequence.toString());
        }
        this.ba = charSequence.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i, KeyEvent keyEvent) {
        if (this.fa != null && this.R != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return a(this.q.getListSelection(), 0, (String) null);
            }
            if (i != 21 && i != 22) {
                if (i != 19 || this.q.getListSelection() == 0) {
                    return false;
                }
            } else {
                this.q.setSelection(i == 21 ? 0 : this.q.length());
                this.q.setListSelection(0);
                this.q.clearListSelection();
                p.a(this.q, true);
                return true;
            }
        }
        return false;
    }

    private boolean b(int i, int i2, String str) {
        Cursor cursor = this.R.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        a(a(cursor, i2, str));
        return true;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int i;
        if (this.y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.s.getPaddingLeft();
            Rect rect = new Rect();
            boolean a2 = wa.a(this);
            int dimensionPixelSize = this.P ? resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left) : 0;
            this.q.getDropDownBackground().getPadding(rect);
            if (a2) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.q.setDropDownHorizontalOffset(i);
            this.q.setDropDownWidth((((this.y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        p.b(this.q);
        p.a(this.q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, String str) {
        d dVar = this.N;
        if (dVar == null || !dVar.onSuggestionClick(i)) {
            b(i, 0, null);
            this.q.setImeVisibility(false);
            j();
            return true;
        }
        return false;
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.ca);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.ga;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.fa.getSearchActivity());
        return intent;
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.ga;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent a(Cursor cursor, int i, String str) {
        int i2;
        String a2;
        try {
            String a3 = ba.a(cursor, "suggest_intent_action");
            if (a3 == null) {
                a3 = this.fa.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String str2 = a3;
            String a4 = ba.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.fa.getSuggestIntentData();
            }
            if (a4 != null && (a2 = ba.a(cursor, "suggest_intent_data_id")) != null) {
                a4 = a4 + "/" + Uri.encode(a2);
            }
            return a(str2, a4 == null ? null : Uri.parse(a4), ba.a(cursor, "suggest_intent_extra_data"), ba.a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e2) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e2);
            return null;
        }
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
