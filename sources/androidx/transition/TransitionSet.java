package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    private ArrayList<Transition> K;
    private boolean L;
    int M;
    boolean N;
    private int O;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends C0102aa {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f934a;

        a(TransitionSet transitionSet) {
            this.f934a = transitionSet;
        }

        @Override // androidx.transition.C0102aa, androidx.transition.Transition.c
        public void b(Transition transition) {
            TransitionSet transitionSet = this.f934a;
            if (transitionSet.N) {
                return;
            }
            transitionSet.p();
            this.f934a.N = true;
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            TransitionSet transitionSet = this.f934a;
            transitionSet.M--;
            if (transitionSet.M == 0) {
                transitionSet.N = false;
                transitionSet.a();
            }
            transition.b(this);
        }
    }

    public TransitionSet() {
        this.K = new ArrayList<>();
        this.L = true;
        this.N = false;
        this.O = 0;
    }

    private void r() {
        a aVar = new a(this);
        Iterator<Transition> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.M = this.K.size();
    }

    @Override // androidx.transition.Transition
    public void c(ga gaVar) {
        if (b(gaVar.f960b)) {
            Iterator<Transition> it = this.K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.b(gaVar.f960b)) {
                    next.c(gaVar);
                    gaVar.c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).e(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    public void o() {
        if (this.K.isEmpty()) {
            p();
            a();
            return;
        }
        r();
        if (!this.L) {
            for (int i = 1; i < this.K.size(); i++) {
                this.K.get(i - 1).a(new C0110ea(this, this.K.get(i)));
            }
            Transition transition = this.K.get(0);
            if (transition != null) {
                transition.o();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    public int q() {
        return this.K.size();
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo2clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo2clone();
        transitionSet.K = new ArrayList<>();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            transitionSet.a(this.K.get(i).mo2clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public TransitionSet d(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).d(view);
        }
        super.d(view);
        return this;
    }

    public TransitionSet b(int i) {
        if (i == 0) {
            this.L = true;
        } else if (i == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public TransitionSet a(Transition transition) {
        this.K.add(transition);
        transition.u = this;
        long j = this.f;
        if (j >= 0) {
            transition.a(j);
        }
        if ((this.O & 1) != 0) {
            transition.a(e());
        }
        if ((this.O & 2) != 0) {
            transition.a(h());
        }
        if ((this.O & 4) != 0) {
            transition.a(g());
        }
        if ((this.O & 8) != 0) {
            transition.a(d());
        }
        return this;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = new ArrayList<>();
        this.L = true;
        this.N = false;
        this.O = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.i);
        b(androidx.core.content.a.i.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    public TransitionSet b(long j) {
        super.b(j);
        return this;
    }

    @Override // androidx.transition.Transition
    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).c(view);
        }
    }

    @Override // androidx.transition.Transition
    public TransitionSet b(Transition.c cVar) {
        super.b(cVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public void b(ga gaVar) {
        super.b(gaVar);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).b(gaVar);
        }
    }

    public Transition a(int i) {
        if (i < 0 || i >= this.K.size()) {
            return null;
        }
        return this.K.get(i);
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(long j) {
        super.a(j);
        if (this.f >= 0) {
            int size = this.K.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<Transition> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(view);
        }
        super.a(view);
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet a(Transition.c cVar) {
        super.a(cVar);
        return this;
    }

    @Override // androidx.transition.Transition
    public void a(PathMotion pathMotion) {
        super.a(pathMotion);
        this.O |= 4;
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(pathMotion);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.Transition
    public void a(ViewGroup viewGroup, ha haVar, ha haVar2, ArrayList<ga> arrayList, ArrayList<ga> arrayList2) {
        long i = i();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.K.get(i2);
            if (i > 0 && (this.L || i2 == 0)) {
                long i3 = transition.i();
                if (i3 > 0) {
                    transition.b(i3 + i);
                } else {
                    transition.b(i);
                }
            }
            transition.a(viewGroup, haVar, haVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    public void a(ga gaVar) {
        if (b(gaVar.f960b)) {
            Iterator<Transition> it = this.K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.b(gaVar.f960b)) {
                    next.a(gaVar);
                    gaVar.c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void a(AbstractC0108da abstractC0108da) {
        super.a(abstractC0108da);
        this.O |= 2;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(abstractC0108da);
        }
    }

    @Override // androidx.transition.Transition
    public void a(Transition.b bVar) {
        super.a(bVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public String a(String str) {
        String a2 = super.a(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.K.get(i).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }
}
