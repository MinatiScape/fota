package okio;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Segment {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f1486a;

    /* renamed from: b  reason: collision with root package name */
    int f1487b;
    int c;
    boolean d;
    boolean e;
    Segment f;
    Segment g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment() {
        this.f1486a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    public Segment a(Segment segment) {
        segment.g = this;
        segment.f = this.f;
        this.f.g = segment;
        this.f = segment;
        return segment;
    }

    public Segment b() {
        Segment segment = this.f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.g;
        segment2.f = this.f;
        this.f.g = segment2;
        this.f = null;
        this.g = null;
        return segment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(Segment segment) {
        this(segment.f1486a, segment.f1487b, segment.c);
        segment.d = true;
    }

    public Segment a(int i) {
        if (i > 0 && i <= this.c - this.f1487b) {
            Segment segment = new Segment(this);
            segment.c = segment.f1487b + i;
            this.f1487b += i;
            this.g.a(segment);
            return segment;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment(byte[] bArr, int i, int i2) {
        this.f1486a = bArr;
        this.f1487b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public void a() {
        Segment segment = this.g;
        if (segment != this) {
            if (segment.e) {
                int i = this.c - this.f1487b;
                if (i > (2048 - segment.c) + (segment.d ? 0 : segment.f1487b)) {
                    return;
                }
                a(this.g, i);
                b();
                SegmentPool.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void a(Segment segment, int i) {
        if (segment.e) {
            int i2 = segment.c;
            if (i2 + i > 2048) {
                if (!segment.d) {
                    int i3 = segment.f1487b;
                    if ((i2 + i) - i3 <= 2048) {
                        byte[] bArr = segment.f1486a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        segment.c -= segment.f1487b;
                        segment.f1487b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f1486a, this.f1487b, segment.f1486a, segment.c, i);
            segment.c += i;
            this.f1487b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
