package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static final Object f410a = new Object();

    /* renamed from: b  reason: collision with root package name */
    static final HashMap<ComponentName, h> f411b = new HashMap<>();
    b c;
    h d;
    a e;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    final ArrayList<d> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        IBinder a();

        e b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f413a;

        /* renamed from: b  reason: collision with root package name */
        final int f414b;

        d(Intent intent, int i) {
            this.f413a = intent;
            this.f414b = i;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f414b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f413a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        Intent getIntent();
    }

    /* loaded from: classes.dex */
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f415a;

        /* renamed from: b  reason: collision with root package name */
        final Object f416b;
        JobParameters c;

        /* loaded from: classes.dex */
        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f417a;

            a(JobWorkItem jobWorkItem) {
                this.f417a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f416b) {
                    if (f.this.c != null) {
                        f.this.c.completeWork(this.f417a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                return this.f417a.getIntent();
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f416b = new Object();
            this.f415a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.b
        public e b() {
            synchronized (this.f416b) {
                if (this.c == null) {
                    return null;
                }
                JobWorkItem dequeueWork = this.c.dequeueWork();
                if (dequeueWork != null) {
                    dequeueWork.getIntent().setExtrasClassLoader(this.f415a.getClassLoader());
                    return new a(dequeueWork);
                }
                return null;
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.c = jobParameters;
            this.f415a.a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f415a.b();
            synchronized (this.f416b) {
                this.c = null;
            }
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g extends h {
        private final JobInfo d;
        private final JobScheduler e;

        g(Context context, ComponentName componentName, int i) {
            super(context, componentName);
            a(i);
            this.d = new JobInfo.Builder(i, this.f419a).setOverrideDeadline(0L).build();
            this.e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.h
        void a(Intent intent) {
            this.e.enqueue(this.d, new JobWorkItem(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f419a;

        /* renamed from: b  reason: collision with root package name */
        boolean f420b;
        int c;

        h(Context context, ComponentName componentName) {
            this.f419a = componentName;
        }

        public void a() {
        }

        void a(int i) {
            if (!this.f420b) {
                this.f420b = true;
                this.c = i;
            } else if (this.c == i) {
            } else {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.c);
            }
        }

        abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.i = null;
        } else {
            this.i = new ArrayList<>();
        }
    }

    public static void a(Context context, Class cls, int i, Intent intent) {
        a(context, new ComponentName(context, cls), i, intent);
    }

    protected abstract void a(Intent intent);

    boolean b() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.cancel(this.f);
        }
        this.g = true;
        return c();
    }

    public boolean c() {
        return true;
    }

    void d() {
        ArrayList<d> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.e = null;
                if (this.i != null && this.i.size() > 0) {
                    a(false);
                } else if (!this.h) {
                    this.d.a();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.c = new f(this);
            this.d = null;
            return;
        }
        this.c = null;
        this.d = a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.h = true;
                this.d.a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.i != null) {
            this.d.c();
            synchronized (this.i) {
                ArrayList<d> arrayList = this.i;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new d(intent, i2));
                a(true);
            }
            return 3;
        }
        return 2;
    }

    public static void a(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent != null) {
            synchronized (f410a) {
                h a2 = a(context, componentName, true, i);
                a2.a(i);
                a2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.a(a2.getIntent());
                a2.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            JobIntentService.this.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onCancelled(Void r1) {
            JobIntentService.this.d();
        }
    }

    static h a(Context context, ComponentName componentName, boolean z, int i) {
        h cVar;
        h hVar = f411b.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                cVar = new c(context, componentName);
            } else if (z) {
                cVar = new g(context, componentName, i);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            h hVar2 = cVar;
            f411b.put(componentName, hVar2);
            return hVar2;
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends h {
        private final Context d;
        private final PowerManager.WakeLock e;
        private final PowerManager.WakeLock f;
        boolean g;
        boolean h;

        c(Context context, ComponentName componentName) {
            super(context, componentName);
            this.d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.e = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.e.setReferenceCounted(false);
            this.f = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f419a);
            if (this.d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.g) {
                        this.g = true;
                        if (!this.h) {
                            this.e.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.f.acquire(600000L);
                    this.e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                this.g = false;
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void a() {
            synchronized (this) {
                if (this.h) {
                    if (this.g) {
                        this.e.acquire(60000L);
                    }
                    this.h = false;
                    this.f.release();
                }
            }
        }
    }

    void a(boolean z) {
        if (this.e == null) {
            this.e = new a();
            h hVar = this.d;
            if (hVar != null && z) {
                hVar.b();
            }
            this.e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    e a() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.i) {
            if (this.i.size() > 0) {
                return this.i.remove(0);
            }
            return null;
        }
    }
}
