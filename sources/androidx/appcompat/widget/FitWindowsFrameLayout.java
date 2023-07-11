package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.G;
/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements G {

    /* renamed from: a  reason: collision with root package name */
    private G.a f252a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        G.a aVar = this.f252a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.G
    public void setOnFitSystemWindowsListener(G.a aVar) {
        this.f252a = aVar;
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
