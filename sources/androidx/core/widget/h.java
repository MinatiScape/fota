package androidx.core.widget;

import android.widget.ListView;
/* compiled from: ListViewAutoScrollHelper.java */
/* loaded from: classes.dex */
public class h extends a {
    private final ListView s;

    public h(ListView listView) {
        super(listView);
        this.s = listView;
    }

    @Override // androidx.core.widget.a
    public void a(int i, int i2) {
        i.b(this.s, i2);
    }

    @Override // androidx.core.widget.a
    public boolean a(int i) {
        return false;
    }

    @Override // androidx.core.widget.a
    public boolean b(int i) {
        ListView listView = this.s;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
