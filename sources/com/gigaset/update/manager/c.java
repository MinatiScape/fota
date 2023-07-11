package com.gigaset.update.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.gigaset.update.MyApplication;
import com.gigaset.update.bean.ReportBean;
import com.gigaset.update.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DatabaseManager.java */
/* loaded from: classes.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1155a = com.gigaset.update.utils.f.d(String.valueOf(new char[]{'o', 't', 'a', '.', 'd', 'b'}));

    /* renamed from: b  reason: collision with root package name */
    private static final String f1156b = String.valueOf(new char[]{'r', 'e', 'p', 'o', 'r', 't'});
    private static final String c = "CREATE TABLE IF NOT EXISTS " + f1156b + " (id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, time LONG, result TEXT )";
    private static c d;
    private static SQLiteDatabase e;

    private c(Context context) {
        super(context, f1155a, (SQLiteDatabase.CursorFactory) null, 4);
    }

    public static c c() {
        if (d == null) {
            d = new c(MyApplication.c());
        }
        try {
            if (e == null) {
                e = d.getWritableDatabase();
            }
        } catch (Exception e2) {
            LogUtil.a(e2.getMessage());
        }
        return d;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || e == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put("result", str2);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        e.insert(f1156b, null, contentValues);
    }

    public List<ReportBean> b() {
        if (e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor query = e.query(f1156b, null, null, null, null, null, null);
        if (query != null && query.getCount() > 0) {
            while (query.moveToNext()) {
                ReportBean reportBean = new ReportBean();
                reportBean.setAction(query.getString(query.getColumnIndex("type")));
                reportBean.setResult(query.getString(query.getColumnIndex("result")));
                reportBean.setTime(query.getLong(query.getColumnIndex("time")));
                arrayList.add(reportBean);
            }
            query.close();
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(c);
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onCreate(sQLiteDatabase);
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = e;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.delete(f1156b, null, null);
    }
}
