package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f302a;

    /* renamed from: b  reason: collision with root package name */
    private int f303b;
    private WeakReference<View> c;
    private LayoutInflater d;
    private a e;

    /* loaded from: classes.dex */
    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            if (this.f302a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.d;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.f302a, viewGroup, false);
                int i = this.f303b;
                if (i != -1) {
                    inflate.setId(i);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.c = new WeakReference<>(inflate);
                a aVar = this.e;
                if (aVar != null) {
                    aVar.a(this, inflate);
                }
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f303b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.d;
    }

    public int getLayoutResource() {
        return this.f302a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f303b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f302a = i;
    }

    public void setOnInflateListener(a aVar) {
        this.e = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f302a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewStubCompat, i, 0);
        this.f303b = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_inflatedId, -1);
        this.f302a = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
