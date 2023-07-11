package org.greenrobot.eventbus;
/* compiled from: EventBus.java */
/* loaded from: classes.dex */
/* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f1496a = new int[ThreadMode.values().length];

    static {
        try {
            f1496a[ThreadMode.POSTING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1496a[ThreadMode.MAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1496a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1496a[ThreadMode.BACKGROUND.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1496a[ThreadMode.ASYNC.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
