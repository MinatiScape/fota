package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public interface i {

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        static final boolean f1505a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1506b;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f1505a = z;
        }

        public a(String str) {
            this.f1506b = str;
        }

        public static boolean a() {
            return f1505a;
        }

        @Override // org.greenrobot.eventbus.i
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f1506b, str);
            }
        }

        @Override // org.greenrobot.eventbus.i
        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                int a2 = a(level);
                String str2 = this.f1506b;
                Log.println(a2, str2, str + "\n" + Log.getStackTraceString(th));
            }
        }

        protected int a(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            } else if (intValue < 900) {
                return 4;
            } else {
                return intValue < 1000 ? 5 : 6;
            }
        }
    }

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public static class b implements i {
        @Override // org.greenrobot.eventbus.i
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.i
        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
