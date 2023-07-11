package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;
/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
class G {

    /* renamed from: a  reason: collision with root package name */
    private static G f83a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f84b;
    private final LocationManager c;
    private final a d = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TwilightManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f85a;

        /* renamed from: b  reason: collision with root package name */
        long f86b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }

    G(Context context, LocationManager locationManager) {
        this.f84b = context;
        this.c = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static G a(Context context) {
        if (f83a == null) {
            Context applicationContext = context.getApplicationContext();
            f83a = new G(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f83a;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location a2 = androidx.core.content.b.a(this.f84b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location a3 = androidx.core.content.b.a(this.f84b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (a3 == null || a2 == null) ? a3 != null ? a3 : a2 : a3.getTime() > a2.getTime() ? a3 : a2;
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.f85a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f85a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        F a2 = F.a();
        a2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.f82b;
        a2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.d == 1;
        long j3 = a2.c;
        long j4 = a2.f82b;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.c;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f85a = z2;
        aVar.f86b = j2;
        aVar.c = j3;
        aVar.d = j4;
        aVar.e = j5;
        aVar.f = j;
    }
}
