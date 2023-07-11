package org.greenrobot.eventbus;

import android.os.Looper;
/* compiled from: MainThreadSupport.java */
/* loaded from: classes.dex */
public interface j {

    /* compiled from: MainThreadSupport.java */
    /* loaded from: classes.dex */
    public static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f1507a;

        public a(Looper looper) {
            this.f1507a = looper;
        }

        @Override // org.greenrobot.eventbus.j
        public boolean a() {
            return this.f1507a == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.j
        public n a(e eVar) {
            return new h(eVar, this.f1507a, 10);
        }
    }

    n a(e eVar);

    boolean a();
}
