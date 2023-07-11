package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndicatorViewController.java */
/* loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1431a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TextView f1432b;
    final /* synthetic */ int c;
    final /* synthetic */ TextView d;
    final /* synthetic */ c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, int i, TextView textView, int i2, TextView textView2) {
        this.e = cVar;
        this.f1431a = i;
        this.f1432b = textView;
        this.c = i2;
        this.d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        TextView textView;
        TextView textView2;
        this.e.i = this.f1431a;
        this.e.g = null;
        TextView textView3 = this.f1432b;
        if (textView3 != null) {
            textView3.setVisibility(4);
            if (this.c == 1) {
                textView = this.e.m;
                if (textView != null) {
                    textView2 = this.e.m;
                    textView2.setText((CharSequence) null);
                }
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
