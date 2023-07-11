package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ia;
import com.google.android.material.R$styleable;
/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f1406a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f1407b;
    public final int c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ia a2 = ia.a(context, attributeSet, R$styleable.TabItem);
        this.f1406a = a2.e(R$styleable.TabItem_android_text);
        this.f1407b = a2.b(R$styleable.TabItem_android_icon);
        this.c = a2.g(R$styleable.TabItem_android_layout, 0);
        a2.a();
    }
}
