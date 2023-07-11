package a.c.a;

import a.c.a.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f35a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f36b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected C0001a f;
    protected DataSetObserver g;
    protected a.c.a.b h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* renamed from: a.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001a extends ContentObserver {
        C0001a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f35a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f35a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f36b = true;
        } else {
            this.f36b = false;
        }
        boolean z = cursor != null;
        this.c = cursor;
        this.f35a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f = new C0001a();
            this.g = new b();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            C0001a c0001a = this.f;
            if (c0001a != null) {
                cursor.registerContentObserver(c0001a);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract View b(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // a.c.a.b.a
    public void changeCursor(Cursor cursor) {
        Cursor a2 = a(cursor);
        if (a2 != null) {
            a2.close();
        }
    }

    @Override // a.c.a.b.a
    public abstract CharSequence convertToString(Cursor cursor);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f35a || (cursor = this.c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // a.c.a.b.a
    public Cursor getCursor() {
        return this.c;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f35a) {
            this.c.moveToPosition(i);
            if (view == null) {
                view = a(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new a.c.a.b(this);
        }
        return this.h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f35a || (cursor = this.c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f35a && (cursor = this.c) != null && cursor.moveToPosition(i)) {
            return this.c.getLong(this.e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f35a) {
            if (this.c.moveToPosition(i)) {
                if (view == null) {
                    view = b(this.d, this.c, viewGroup);
                }
                a(view, this.d, this.c);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public Cursor a(Cursor cursor) {
        Cursor cursor2 = this.c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0001a c0001a = this.f;
            if (c0001a != null) {
                cursor2.unregisterContentObserver(c0001a);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            C0001a c0001a2 = this.f;
            if (c0001a2 != null) {
                cursor.registerContentObserver(c0001a2);
            }
            DataSetObserver dataSetObserver2 = this.g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.f35a = true;
            notifyDataSetChanged();
        } else {
            this.e = -1;
            this.f35a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    protected void a() {
        Cursor cursor;
        if (!this.f36b || (cursor = this.c) == null || cursor.isClosed()) {
            return;
        }
        this.f35a = this.c.requery();
    }
}
