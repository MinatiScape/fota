package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
/* compiled from: ActionBarBackgroundDrawable.java */
/* renamed from: androidx.appcompat.widget.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0043b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f312a;

    public C0043b(ActionBarContainer actionBarContainer) {
        this.f312a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f312a;
        if (actionBarContainer.g) {
            Drawable drawable = actionBarContainer.f;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.mBackground;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f312a;
        Drawable drawable3 = actionBarContainer2.e;
        if (drawable3 == null || !actionBarContainer2.h) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f312a;
        if (actionBarContainer.g) {
            Drawable drawable = actionBarContainer.f;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.mBackground;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
