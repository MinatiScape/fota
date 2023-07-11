package androidx.core.b.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.core.h.AbstractC0068b;
/* compiled from: SupportMenuItem.java */
/* loaded from: classes.dex */
public interface b extends MenuItem {
    MenuItem a(char c, int i);

    MenuItem a(ColorStateList colorStateList);

    MenuItem a(PorterDuff.Mode mode);

    b a(AbstractC0068b abstractC0068b);

    b a(CharSequence charSequence);

    AbstractC0068b a();

    MenuItem b(char c, int i);

    b b(CharSequence charSequence);

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    MenuItem setActionView(int i);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    void setShowAsAction(int i);

    @Override // android.view.MenuItem
    MenuItem setShowAsActionFlags(int i);
}
