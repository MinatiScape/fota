package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.G;
/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements G {

    /* renamed from: a  reason: collision with root package name */
    private G.a f253a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        G.a aVar = this.f253a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.G
    public void setOnFitSystemWindowsListener(G.a aVar) {
        this.f253a = aVar;
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
