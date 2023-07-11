package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class ForwardingTimeout extends Timeout {

    /* renamed from: a  reason: collision with root package name */
    private Timeout f1467a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout != null) {
            this.f1467a = timeout;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final Timeout a() {
        return this.f1467a;
    }

    @Override // okio.Timeout
    public Timeout clearDeadline() {
        return this.f1467a.clearDeadline();
    }

    @Override // okio.Timeout
    public Timeout clearTimeout() {
        return this.f1467a.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.f1467a.deadlineNanoTime();
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.f1467a.hasDeadline();
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.f1467a.throwIfReached();
    }

    @Override // okio.Timeout
    public Timeout timeout(long j, TimeUnit timeUnit) {
        return this.f1467a.timeout(j, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.f1467a.timeoutNanos();
    }

    public final ForwardingTimeout a(Timeout timeout) {
        if (timeout != null) {
            this.f1467a = timeout;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.Timeout
    public Timeout deadlineNanoTime(long j) {
        return this.f1467a.deadlineNanoTime(j);
    }
}
