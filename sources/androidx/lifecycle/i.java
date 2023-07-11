package androidx.lifecycle;

import androidx.lifecycle.f;
/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
/* synthetic */ class i {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f686a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ int[] f687b = new int[f.b.values().length];

    static {
        try {
            f687b[f.b.INITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f687b[f.b.CREATED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f687b[f.b.STARTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f687b[f.b.RESUMED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f687b[f.b.DESTROYED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f686a = new int[f.a.values().length];
        try {
            f686a[f.a.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f686a[f.a.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f686a[f.a.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f686a[f.a.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f686a[f.a.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f686a[f.a.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f686a[f.a.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
