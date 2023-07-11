package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* compiled from: FragmentController.java */
/* renamed from: androidx.fragment.app.i  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0079i {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0080j<?> f634a;

    private C0079i(AbstractC0080j<?> abstractC0080j) {
        this.f634a = abstractC0080j;
    }

    public static C0079i a(AbstractC0080j<?> abstractC0080j) {
        return new C0079i(abstractC0080j);
    }

    public void b() {
        this.f634a.e.g();
    }

    public void c() {
        this.f634a.e.h();
    }

    public void d() {
        this.f634a.e.j();
    }

    public void e() {
        this.f634a.e.k();
    }

    public void f() {
        this.f634a.e.l();
    }

    public void g() {
        this.f634a.e.m();
    }

    public void h() {
        this.f634a.e.n();
    }

    public boolean i() {
        return this.f634a.e.p();
    }

    public AbstractC0081k j() {
        return this.f634a.d();
    }

    public void k() {
        this.f634a.e.s();
    }

    public s l() {
        return this.f634a.e.u();
    }

    public Parcelable m() {
        return this.f634a.e.v();
    }

    public Fragment a(String str) {
        return this.f634a.e.b(str);
    }

    public void b(boolean z) {
        this.f634a.e.b(z);
    }

    public void a(Fragment fragment) {
        AbstractC0080j<?> abstractC0080j = this.f634a;
        abstractC0080j.e.a(abstractC0080j, abstractC0080j, fragment);
    }

    public boolean b(Menu menu) {
        return this.f634a.e.b(menu);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f634a.e.onCreateView(view, str, context, attributeSet);
    }

    public boolean b(MenuItem menuItem) {
        return this.f634a.e.b(menuItem);
    }

    public void a(Parcelable parcelable, s sVar) {
        this.f634a.e.a(parcelable, sVar);
    }

    public void a() {
        this.f634a.e.f();
    }

    public void a(boolean z) {
        this.f634a.e.a(z);
    }

    public void a(Configuration configuration) {
        this.f634a.e.a(configuration);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f634a.e.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f634a.e.a(menuItem);
    }

    public void a(Menu menu) {
        this.f634a.e.a(menu);
    }
}
