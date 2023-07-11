package a.c.a;

import android.database.Cursor;
import android.widget.Filter;
/* compiled from: CursorFilter.java */
/* loaded from: classes.dex */
class b extends Filter {

    /* renamed from: a  reason: collision with root package name */
    a f39a;

    /* compiled from: CursorFilter.java */
    /* loaded from: classes.dex */
    interface a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f39a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f39a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f39a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f39a.getCursor();
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        this.f39a.changeCursor((Cursor) obj);
    }
}
