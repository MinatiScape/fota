package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;
/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private Object f534a;

    private p(Object obj) {
        this.f534a = obj;
    }

    public Object a() {
        return this.f534a;
    }

    public static p a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new p(PointerIcon.getSystemIcon(context, i));
        }
        return new p(null);
    }
}
