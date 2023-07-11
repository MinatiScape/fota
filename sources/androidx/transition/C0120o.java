package androidx.transition;

import android.widget.ImageView;
/* compiled from: ChangeImageTransform.java */
/* renamed from: androidx.transition.o  reason: case insensitive filesystem */
/* loaded from: classes.dex */
/* synthetic */ class C0120o {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f974a = new int[ImageView.ScaleType.values().length];

    static {
        try {
            f974a[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f974a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
