package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.i  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0034i extends CursorAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final int f103a;

    /* renamed from: b  reason: collision with root package name */
    private final int f104b;
    final /* synthetic */ AlertController.RecycleListView c;
    final /* synthetic */ AlertController d;
    final /* synthetic */ AlertController.a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0034i(AlertController.a aVar, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.e = aVar;
        this.c = recycleListView;
        this.d = alertController;
        Cursor cursor2 = getCursor();
        this.f103a = cursor2.getColumnIndexOrThrow(this.e.L);
        this.f104b = cursor2.getColumnIndexOrThrow(this.e.M);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f103a));
        this.c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f104b) == 1);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.e.f54b.inflate(this.d.M, viewGroup, false);
    }
}
