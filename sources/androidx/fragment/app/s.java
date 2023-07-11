package androidx.fragment.app;

import java.util.List;
/* compiled from: FragmentManagerNonConfig.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final List<Fragment> f659a;

    /* renamed from: b  reason: collision with root package name */
    private final List<s> f660b;
    private final List<androidx.lifecycle.t> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(List<Fragment> list, List<s> list2, List<androidx.lifecycle.t> list3) {
        this.f659a = list;
        this.f660b = list2;
        this.c = list3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<s> a() {
        return this.f660b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> b() {
        return this.f659a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<androidx.lifecycle.t> c() {
        return this.c;
    }
}
