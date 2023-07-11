package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class ga {

    /* renamed from: b  reason: collision with root package name */
    public View f960b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f959a = new HashMap();
    final ArrayList<Transition> c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj instanceof ga) {
            ga gaVar = (ga) obj;
            return this.f960b == gaVar.f960b && this.f959a.equals(gaVar.f959a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f960b.hashCode() * 31) + this.f959a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f960b + "\n") + "    values:";
        for (String str2 : this.f959a.keySet()) {
            str = str + "    " + str2 + ": " + this.f959a.get(str2) + "\n";
        }
        return str;
    }
}
