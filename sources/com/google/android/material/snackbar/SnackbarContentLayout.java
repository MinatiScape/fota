package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.h.t;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1397a;

    /* renamed from: b  reason: collision with root package name */
    private Button f1398b;
    private int c;
    private int d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    private boolean a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f1397a.getPaddingTop() == i2 && this.f1397a.getPaddingBottom() == i3) {
            return z;
        }
        a(this.f1397a, i2, i3);
        return true;
    }

    public Button getActionView() {
        return this.f1398b;
    }

    public TextView getMessageView() {
        return this.f1397a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f1397a = (TextView) findViewById(R$id.snackbar_text);
        this.f1398b = (Button) findViewById(R$id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        r4 = false;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.c
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.c
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R$dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.R$dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f1397a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = 1
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.d
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f1398b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.d
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.a(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L62
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.a(r3, r0, r0)
            if (r0 == 0) goto L61
            goto L62
        L61:
            r4 = 0
        L62:
            if (r4 == 0) goto L67
            super.onMeasure(r8, r9)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i, int i2) {
        if (t.B(view)) {
            t.b(view, t.o(view), i, t.n(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }
}
