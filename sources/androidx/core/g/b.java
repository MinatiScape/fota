package androidx.core.g;

import android.util.Log;
import java.io.Writer;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
public class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f497a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f498b = new StringBuilder((int) CpioConstants.C_IWUSR);

    public b(String str) {
        this.f497a = str;
    }

    private void l() {
        if (this.f498b.length() > 0) {
            Log.d(this.f497a, this.f498b.toString());
            StringBuilder sb = this.f498b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        l();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        l();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                l();
            } else {
                this.f498b.append(c);
            }
        }
    }
}
