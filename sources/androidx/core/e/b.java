package androidx.core.e;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.e.f;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class b implements Callable<f.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f452a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f453b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, a aVar, int i, String str) {
        this.f452a = context;
        this.f453b = aVar;
        this.c = i;
        this.d = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public f.c call() throws Exception {
        f.c a2 = f.a(this.f452a, this.f453b, this.c);
        Typeface typeface = a2.f463a;
        if (typeface != null) {
            f.f457a.a(this.d, typeface);
        }
        return a2;
    }
}
