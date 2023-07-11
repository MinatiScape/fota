package androidx.appcompat.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
class ba extends a.c.a.c implements View.OnClickListener {
    private final SearchManager l;
    private final SearchView m;
    private final SearchableInfo n;
    private final Context o;
    private final WeakHashMap<String, Drawable.ConstantState> p;
    private final int q;
    private boolean r;
    private int s;
    private ColorStateList t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuggestionsAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f313a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f314b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View view) {
            this.f313a = (TextView) view.findViewById(16908308);
            this.f314b = (TextView) view.findViewById(16908309);
            this.c = (ImageView) view.findViewById(16908295);
            this.d = (ImageView) view.findViewById(16908296);
            this.e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public ba(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.r = false;
        this.s = 1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.l = (SearchManager) this.d.getSystemService("search");
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    private Drawable c(Cursor cursor) {
        int i = this.x;
        if (i == -1) {
            return null;
        }
        Drawable b2 = b(cursor.getString(i));
        return b2 != null ? b2 : b(cursor);
    }

    private Drawable d(Cursor cursor) {
        int i = this.y;
        if (i == -1) {
            return null;
        }
        return b(cursor.getString(i));
    }

    private void e(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public void a(int i) {
        this.s = i;
    }

    @Override // a.c.a.c, a.c.a.a
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        View b2 = super.b(context, cursor, viewGroup);
        b2.setTag(new a(b2));
        ((ImageView) b2.findViewById(R$id.edit_query)).setImageResource(this.q);
        return b2;
    }

    @Override // a.c.a.a, a.c.a.b.a
    public void changeCursor(Cursor cursor) {
        if (this.r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // a.c.a.a, a.c.a.b.a
    public CharSequence convertToString(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (!this.n.shouldRewriteQueryFromData() || (a3 = a(cursor, "suggest_intent_data")) == null) {
            if (!this.n.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
                return null;
            }
            return a2;
        }
        return a3;
    }

    @Override // a.c.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a2 = a(this.d, this.c, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f313a.setText(e.toString());
            }
            return a2;
        }
    }

    @Override // a.c.a.a, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View b2 = b(this.d, this.c, viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f313a.setText(e.toString());
            }
            return b2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        e(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        e(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.a((CharSequence) tag);
        }
    }

    @Override // a.c.a.b.a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.m.getVisibility() == 0 && this.m.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.n, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    @Override // a.c.a.a
    public void a(View view, Context context, Cursor cursor) {
        CharSequence a2;
        a aVar = (a) view.getTag();
        int i = this.z;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f313a != null) {
            a(aVar.f313a, a(cursor, this.u));
        }
        if (aVar.f314b != null) {
            String a3 = a(cursor, this.w);
            if (a3 != null) {
                a2 = a((CharSequence) a3);
            } else {
                a2 = a(cursor, this.v);
            }
            if (TextUtils.isEmpty(a2)) {
                TextView textView = aVar.f313a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f313a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f313a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f313a.setMaxLines(1);
                }
            }
            a(aVar.f314b, a2);
        }
        ImageView imageView = aVar.c;
        if (imageView != null) {
            a(imageView, c(cursor), 4);
        }
        ImageView imageView2 = aVar.d;
        if (imageView2 != null) {
            a(imageView2, d(cursor), 8);
        }
        int i3 = this.s;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            aVar.e.setVisibility(8);
            return;
        }
        aVar.e.setVisibility(0);
        aVar.e.setTag(aVar.f313a.getText());
        aVar.e.setOnClickListener(this);
    }

    private Drawable b(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.o.getPackageName() + "/" + parseInt;
            Drawable a2 = a(str2);
            if (a2 != null) {
                return a2;
            }
            Drawable c = androidx.core.content.a.c(this.o, parseInt);
            a(str2, c);
            return c;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable a3 = a(str);
            if (a3 != null) {
                return a3;
            }
            Drawable b2 = b(Uri.parse(str));
            a(str, b2);
            return b2;
        }
    }

    private Drawable b(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return a(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.o.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
                return createFromStream;
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    private CharSequence a(CharSequence charSequence) {
        if (this.t == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.t = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable b(Cursor cursor) {
        Drawable b2 = b(this.n.getSearchActivity());
        return b2 != null ? b2 : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable b(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.p.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.o.getResources());
        }
        Drawable a2 = a(componentName);
        this.p.put(flattenToShortString, a2 != null ? a2.getConstantState() : null);
        return a2;
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private Drawable a(String str) {
        Drawable.ConstantState constantState = this.p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.p.put(str, drawable.getConstantState());
        }
    }

    private Drawable a(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, CpioConstants.C_IWUSR);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    Drawable a(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
