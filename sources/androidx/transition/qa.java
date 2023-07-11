package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOverlayApi14.java */
/* loaded from: classes.dex */
public class qa implements sa {

    /* renamed from: a  reason: collision with root package name */
    protected a f979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qa(Context context, ViewGroup viewGroup, View view) {
        this.f979a = new a(context, viewGroup, view, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static qa c(View view) {
        ViewGroup d = d(view);
        if (d != null) {
            int childCount = d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = d.getChildAt(i);
                if (childAt instanceof a) {
                    return ((a) childAt).e;
                }
            }
            return new ja(d.getContext(), d, view);
        }
        return null;
    }

    static ViewGroup d(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // androidx.transition.sa
    public void a(Drawable drawable) {
        this.f979a.a(drawable);
    }

    @Override // androidx.transition.sa
    public void b(Drawable drawable) {
        this.f979a.b(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewOverlayApi14.java */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        static Method f980a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f981b;
        View c;
        ArrayList<Drawable> d;
        qa e;

        static {
            try {
                f980a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, qa qaVar) {
            super(context);
            this.d = null;
            this.f981b = viewGroup;
            this.c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.e = qaVar;
        }

        public void a(Drawable drawable) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            if (this.d.contains(drawable)) {
                return;
            }
            this.d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f981b.getLocationOnScreen(iArr);
            this.c.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.d.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f981b != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f981b instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    a(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.d) != null && arrayList.contains(drawable));
        }

        public void b(View view) {
            super.removeView(view);
            if (a()) {
                this.f981b.removeView(this);
            }
        }

        public void a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f981b && viewGroup.getParent() != null && androidx.core.h.t.y(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f981b.getLocationOnScreen(iArr2);
                    androidx.core.h.t.a(view, iArr[0] - iArr2[0]);
                    androidx.core.h.t.b(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        boolean a() {
            ArrayList<Drawable> arrayList;
            return getChildCount() == 0 && ((arrayList = this.d) == null || arrayList.size() == 0);
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f981b.getLocationOnScreen(iArr2);
            this.c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }
}
