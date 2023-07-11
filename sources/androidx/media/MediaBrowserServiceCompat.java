package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.v;
import androidx.media.w;
import androidx.media.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f710a = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    private c f711b;
    b d;
    MediaSessionCompat.Token f;
    final a.b.b<IBinder, b> c = new a.b.b<>();
    final m e = new m();

    /* loaded from: classes.dex */
    public static final class a {
        public Bundle a() {
            throw null;
        }

        public String b() {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f712a;

        /* renamed from: b  reason: collision with root package name */
        public final int f713b;
        public final int c;
        public final y d;
        public final Bundle e;
        public final k f;
        public final HashMap<String, List<androidx.core.g.d<IBinder, Bundle>>> g = new HashMap<>();
        public a h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str, int i, int i2, Bundle bundle, k kVar) {
            this.f712a = str;
            this.f713b = i;
            this.c = i2;
            this.d = new y(str, i, i2);
            this.e = bundle;
            this.f = kVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.e.post(new androidx.media.i(this));
        }
    }

    /* loaded from: classes.dex */
    interface c {
        IBinder a(Intent intent);

        void onCreate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements c, v.d {

        /* renamed from: a  reason: collision with root package name */
        final List<Bundle> f714a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        Object f715b;
        Messenger c;

        d() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        public IBinder a(Intent intent) {
            return v.a(this.f715b, intent);
        }

        @Override // androidx.media.v.d
        public void b(String str, v.c<List<Parcel>> cVar) {
            MediaBrowserServiceCompat.this.a(str, new androidx.media.j(this, str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        public void onCreate() {
            this.f715b = v.a(MediaBrowserServiceCompat.this, this);
            v.a(this.f715b);
        }

        @Override // androidx.media.v.d
        public v.a a(String str, int i, Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.c = new Messenger(MediaBrowserServiceCompat.this.e);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                androidx.core.app.e.a(bundle2, "extra_messenger", this.c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    androidx.core.app.e.a(bundle2, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.f714a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.d = new b(str, -1, i, bundle, null);
            a a2 = MediaBrowserServiceCompat.this.a(str, i, bundle);
            MediaBrowserServiceCompat.this.d = null;
            if (a2 == null) {
                return null;
            }
            if (bundle2 == null) {
                a2.a();
                throw null;
            }
            a2.a();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends d implements w.b {
        e() {
            super();
        }

        @Override // androidx.media.w.b
        public void a(String str, v.c<Parcel> cVar) {
            MediaBrowserServiceCompat.this.b(str, new androidx.media.k(this, str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.d, androidx.media.MediaBrowserServiceCompat.c
        public void onCreate() {
            this.f715b = w.a(MediaBrowserServiceCompat.this, this);
            v.a(this.f715b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends e implements x.c {
        f() {
            super();
        }

        @Override // androidx.media.x.c
        public void a(String str, x.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.a(str, new androidx.media.l(this, str, bVar), bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.e, androidx.media.MediaBrowserServiceCompat.d, androidx.media.MediaBrowserServiceCompat.c
        public void onCreate() {
            this.f715b = x.a(MediaBrowserServiceCompat.this, this);
            v.a(this.f715b);
        }
    }

    /* loaded from: classes.dex */
    class g extends f {
        g() {
            super();
        }
    }

    /* loaded from: classes.dex */
    class h implements c {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f716a;

        h() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        public IBinder a(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.f716a.getBinder();
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.c
        public void onCreate() {
            this.f716a = new Messenger(MediaBrowserServiceCompat.this.e);
        }
    }

    /* loaded from: classes.dex */
    public static class i<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f718a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f719b;
        private boolean c;
        private boolean d;
        private int e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(Object obj) {
            this.f718a = obj;
        }

        void a(int i) {
            this.e = i;
        }

        void a(T t) {
            throw null;
        }

        public void b(T t) {
            if (!this.c && !this.d) {
                this.c = true;
                a((i<T>) t);
                return;
            }
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f718a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.e;
        }

        void a(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f718a);
        }

        public void b(Bundle bundle) {
            if (!this.c && !this.d) {
                this.d = true;
                a(bundle);
                return;
            }
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f718a);
        }

        boolean b() {
            return this.f719b || this.c || this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j {
        j() {
        }

        public void a(String str, int i, int i2, Bundle bundle, k kVar) {
            if (MediaBrowserServiceCompat.this.a(str, i2)) {
                MediaBrowserServiceCompat.this.e.a(new androidx.media.m(this, kVar, str, i, i2, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
        }

        public void b(k kVar) {
            MediaBrowserServiceCompat.this.e.a(new s(this, kVar));
        }

        public void b(String str, Bundle bundle, ResultReceiver resultReceiver, k kVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.e.a(new u(this, kVar, str, bundle, resultReceiver));
        }

        public void a(k kVar) {
            MediaBrowserServiceCompat.this.e.a(new n(this, kVar));
        }

        public void a(String str, IBinder iBinder, Bundle bundle, k kVar) {
            MediaBrowserServiceCompat.this.e.a(new o(this, kVar, str, iBinder, bundle));
        }

        public void a(String str, IBinder iBinder, k kVar) {
            MediaBrowserServiceCompat.this.e.a(new p(this, kVar, str, iBinder));
        }

        public void a(String str, ResultReceiver resultReceiver, k kVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.e.a(new q(this, kVar, str, resultReceiver));
        }

        public void a(k kVar, String str, int i, int i2, Bundle bundle) {
            MediaBrowserServiceCompat.this.e.a(new r(this, kVar, str, i, i2, bundle));
        }

        public void a(String str, Bundle bundle, ResultReceiver resultReceiver, k kVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.e.a(new t(this, kVar, str, bundle, resultReceiver));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface k {
        void a() throws RemoteException;

        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        IBinder asBinder();
    }

    /* loaded from: classes.dex */
    private static class l implements k {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f721a;

        l(Messenger messenger) {
            this.f721a = messenger;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public void a() throws RemoteException {
            a(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public IBinder asBinder() {
            return this.f721a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            a(3, bundle3);
        }

        private void a(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f721a.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class m extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final j f722a;

        m() {
            this.f722a = new j();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f722a.a(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new l(message.replyTo));
                    return;
                case 2:
                    this.f722a.a(new l(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f722a.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), bundle2, new l(message.replyTo));
                    return;
                case 4:
                    this.f722a.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), new l(message.replyTo));
                    return;
                case 5:
                    this.f722a.a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new l(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.f722a.a(new l(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f722a.b(new l(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f722a.a(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new l(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f722a.b(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new l(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    public abstract a a(String str, int i2, Bundle bundle);

    public void a(String str) {
    }

    public void a(String str, Bundle bundle) {
    }

    public abstract void a(String str, i<List<MediaBrowserCompat.MediaItem>> iVar);

    public void a(String str, i<List<MediaBrowserCompat.MediaItem>> iVar, Bundle bundle) {
        iVar.a(1);
        a(str, iVar);
    }

    public void b(String str, i<MediaBrowserCompat.MediaItem> iVar) {
        iVar.a(2);
        iVar.b((i<MediaBrowserCompat.MediaItem>) null);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f711b.a(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f711b = new g();
        } else if (i2 >= 26) {
            this.f711b = new f();
        } else if (i2 >= 23) {
            this.f711b = new e();
        } else if (i2 >= 21) {
            this.f711b = new d();
        } else {
            this.f711b = new h();
        }
        this.f711b.onCreate();
    }

    public void a(String str, Bundle bundle, i<Bundle> iVar) {
        iVar.b((Bundle) null);
    }

    public void b(String str, Bundle bundle, i<List<MediaBrowserCompat.MediaItem>> iVar) {
        iVar.a(4);
        iVar.b((i<List<MediaBrowserCompat.MediaItem>>) null);
    }

    boolean a(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i2)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, Bundle bundle, b bVar, ResultReceiver resultReceiver) {
        androidx.media.g gVar = new androidx.media.g(this, str, resultReceiver);
        this.d = bVar;
        b(str, bundle, gVar);
        this.d = null;
        if (gVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.g.d<IBinder, Bundle>> list = bVar.g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (androidx.core.g.d<IBinder, Bundle> dVar : list) {
            if (iBinder == dVar.f499a && androidx.media.d.a(bundle, dVar.f500b)) {
                return;
            }
        }
        list.add(new androidx.core.g.d<>(iBinder, bundle));
        bVar.g.put(str, list);
        a(str, bVar, bundle, (Bundle) null);
        this.d = bVar;
        a(str, bundle);
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, b bVar, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder == null) {
                return bVar.g.remove(str) != null;
            }
            List<androidx.core.g.d<IBinder, Bundle>> list = bVar.g.get(str);
            if (list != null) {
                Iterator<androidx.core.g.d<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().f499a) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    bVar.g.remove(str);
                }
            }
            return z;
        } finally {
            this.d = bVar;
            a(str);
            this.d = null;
        }
    }

    void a(String str, b bVar, Bundle bundle, Bundle bundle2) {
        androidx.media.e eVar = new androidx.media.e(this, str, bVar, str, bundle, bundle2);
        this.d = bVar;
        if (bundle == null) {
            a(str, eVar);
        } else {
            a(str, eVar, bundle);
        }
        this.d = null;
        if (eVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.f712a + " id=" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i2 == -1 && i3 == -1) {
            return list;
        }
        int i4 = i3 * i2;
        int i5 = i4 + i3;
        if (i2 >= 0 && i3 >= 1 && i4 < list.size()) {
            if (i5 > list.size()) {
                i5 = list.size();
            }
            return list.subList(i4, i5);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar, ResultReceiver resultReceiver) {
        androidx.media.f fVar = new androidx.media.f(this, str, resultReceiver);
        this.d = bVar;
        b(str, fVar);
        this.d = null;
        if (fVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Bundle bundle, b bVar, ResultReceiver resultReceiver) {
        androidx.media.h hVar = new androidx.media.h(this, str, resultReceiver);
        this.d = bVar;
        a(str, bundle, hVar);
        this.d = null;
        if (hVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }
}
