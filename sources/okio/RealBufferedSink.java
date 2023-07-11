package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f1480a;

    /* renamed from: b  reason: collision with root package name */
    public final Sink f1481b;
    private boolean c;

    public RealBufferedSink(Sink sink, Buffer buffer) {
        if (sink != null) {
            this.f1480a = buffer;
            this.f1481b = sink;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSink
    public BufferedSink b(long j) throws IOException {
        if (!this.c) {
            this.f1480a.b(j);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink c() throws IOException {
        if (!this.c) {
            long m = this.f1480a.m();
            if (m > 0) {
                this.f1481b.write(this.f1480a, m);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        try {
            if (this.f1480a.c > 0) {
                this.f1481b.write(this.f1480a, this.f1480a.c);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f1481b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th == null) {
            return;
        }
        Util.a(th);
        throw null;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.c) {
            Buffer buffer = this.f1480a;
            long j = buffer.c;
            if (j > 0) {
                this.f1481b.write(buffer, j);
            }
            this.f1481b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f1481b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f1481b + ")";
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (!this.c) {
            this.f1480a.write(buffer, j);
            c();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i) throws IOException {
        if (!this.c) {
            this.f1480a.writeByte(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i) throws IOException {
        if (!this.c) {
            this.f1480a.writeInt(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i) throws IOException {
        if (!this.c) {
            this.f1480a.writeShort(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public Buffer a() {
        return this.f1480a;
    }

    @Override // okio.BufferedSink
    public BufferedSink a(ByteString byteString) throws IOException {
        if (!this.c) {
            this.f1480a.a(byteString);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: okio.RealBufferedSink$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RealBufferedSink f1482a;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f1482a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            if (this.f1482a.c) {
                return;
            }
            this.f1482a.flush();
        }

        public String toString() {
            return this.f1482a + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            if (!this.f1482a.c) {
                this.f1482a.f1480a.writeByte((int) ((byte) i));
                this.f1482a.c();
                return;
            }
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (!this.f1482a.c) {
                this.f1482a.f1480a.write(bArr, i, i2);
                this.f1482a.c();
                return;
            }
            throw new IOException("closed");
        }
    }

    public RealBufferedSink(Sink sink) {
        this(sink, new Buffer());
    }

    @Override // okio.BufferedSink
    public BufferedSink b() throws IOException {
        if (!this.c) {
            long p = this.f1480a.p();
            if (p > 0) {
                this.f1481b.write(this.f1480a, p);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (!this.c) {
            this.f1480a.write(bArr);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink a(String str) throws IOException {
        if (!this.c) {
            this.f1480a.a(str);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c) {
            this.f1480a.write(bArr, i, i2);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public long a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.f1480a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (read == -1) {
                return j;
            }
            j += read;
            c();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink a(int i) throws IOException {
        if (!this.c) {
            this.f1480a.a(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink a(long j) throws IOException {
        if (!this.c) {
            this.f1480a.a(j);
            return c();
        }
        throw new IllegalStateException("closed");
    }
}
