package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class h implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f429a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f430b;

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private h(Context context) {
        this.f430b = context;
    }

    public static h a(Context context) {
        return new h(context);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f429a.iterator();
    }

    public h a(Intent intent) {
        this.f429a.add(intent);
        return this;
    }

    public h a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = f.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f430b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public h a(ComponentName componentName) {
        int size = this.f429a.size();
        try {
            Intent a2 = f.a(this.f430b, componentName);
            while (a2 != null) {
                this.f429a.add(size, a2);
                a2 = f.a(this.f430b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f429a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f429a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (androidx.core.content.a.a(this.f430b, intentArr, bundle)) {
                return;
            }
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f430b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
