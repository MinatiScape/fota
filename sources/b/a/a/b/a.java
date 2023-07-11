package b.a.a.b;
/* compiled from: ZipException.java */
/* loaded from: classes.dex */
public class a extends Exception {
    private static final long serialVersionUID = 1;
    private int code;

    public a() {
        this.code = -1;
    }

    public int getCode() {
        return this.code;
    }

    public a(String str) {
        super(str);
        this.code = -1;
    }

    public a(String str, Throwable th) {
        super(str, th);
        this.code = -1;
    }

    public a(String str, int i) {
        super(str);
        this.code = -1;
        this.code = i;
    }

    public a(String str, Throwable th, int i) {
        super(str, th);
        this.code = -1;
        this.code = i;
    }

    public a(Throwable th) {
        super(th);
        this.code = -1;
    }

    public a(Throwable th, int i) {
        super(th);
        this.code = -1;
        this.code = i;
    }
}
