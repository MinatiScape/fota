package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatSpinner.java */
/* renamed from: androidx.appcompat.widget.w  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0063w implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner f367a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f368b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0063w(AppCompatSpinner.b bVar, AppCompatSpinner appCompatSpinner) {
        this.f368b = bVar;
        this.f367a = appCompatSpinner;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppCompatSpinner.this.setSelection(i);
        if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.b bVar = this.f368b;
            AppCompatSpinner.this.performItemClick(view, i, bVar.L.getItemId(i));
        }
        this.f368b.dismiss();
    }
}
