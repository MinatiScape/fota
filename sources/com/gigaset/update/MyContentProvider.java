package com.gigaset.update;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes.dex */
public class MyContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private UriMatcher f1072a;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f1072a = new UriMatcher(-1);
        this.f1072a.addURI("com.gigaset.update.MyContentProvider", "reject_status", 1);
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (this.f1072a.match(uri) != 1) {
            return 0;
        }
        com.gigaset.update.manager.i.b(contentValues.getAsBoolean("reject_status").booleanValue());
        com.gigaset.update.manager.i.a(!contentValues.getAsBoolean("report_status").booleanValue());
        com.gigaset.update.manager.i.t();
        return 0;
    }
}
