package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements K {
    private static Method K;
    private K L;

    /* loaded from: classes.dex */
    public static class MenuDropDownListView extends F {
        final int g;
        final int h;
        private K i;
        private MenuItem j;

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.g = 21;
                this.h = 22;
                return;
            }
            this.g = 22;
            this.h = 21;
        }

        @Override // androidx.appcompat.widget.F
        public /* bridge */ /* synthetic */ int a(int i, int i2, int i3, int i4, int i5) {
            return super.a(i, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.F, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.F
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i, boolean z) {
            return super.lookForSelectablePosition(i, z);
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            androidx.appcompat.view.menu.k kVar;
            int pointToPosition;
            int i2;
            if (this.i != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    kVar = (androidx.appcompat.view.menu.k) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    kVar = (androidx.appcompat.view.menu.k) adapter;
                }
                androidx.appcompat.view.menu.p pVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < kVar.getCount()) {
                    pVar = kVar.getItem(i2);
                }
                MenuItem menuItem = this.j;
                if (menuItem != pVar) {
                    androidx.appcompat.view.menu.l b2 = kVar.b();
                    if (menuItem != null) {
                        this.i.b(b2, menuItem);
                    }
                    this.j = pVar;
                    if (pVar != null) {
                        this.i.a(b2, pVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.g) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.h) {
                setSelection(-1);
                ((androidx.appcompat.view.menu.k) getAdapter()).b().a(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        @Override // androidx.appcompat.widget.F, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(K k) {
            this.i = k;
        }

        @Override // androidx.appcompat.widget.F, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        @Override // androidx.appcompat.widget.F
        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i) {
            return super.a(motionEvent, i);
        }
    }

    static {
        try {
            K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    F a(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.J.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z) {
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.J.setEnterTransition((Transition) obj);
        }
    }

    @Override // androidx.appcompat.widget.K
    public void b(androidx.appcompat.view.menu.l lVar, MenuItem menuItem) {
        K k = this.L;
        if (k != null) {
            k.b(lVar, menuItem);
        }
    }

    public void a(K k) {
        this.L = k;
    }

    @Override // androidx.appcompat.widget.K
    public void a(androidx.appcompat.view.menu.l lVar, MenuItem menuItem) {
        K k = this.L;
        if (k != null) {
            k.a(lVar, menuItem);
        }
    }
}
