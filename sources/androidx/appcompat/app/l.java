package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class l extends A implements DialogInterface {
    final AlertController c;

    /* compiled from: AlertDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.a f109a;

        /* renamed from: b  reason: collision with root package name */
        private final int f110b;

        public a(Context context) {
            this(context, l.a(context, 0));
        }

        public a a(CharSequence charSequence) {
            this.f109a.f = charSequence;
            return this;
        }

        public Context b() {
            return this.f109a.f53a;
        }

        public a(Context context, int i) {
            this.f109a = new AlertController.a(new ContextThemeWrapper(context, l.a(context, i)));
            this.f110b = i;
        }

        public a a(View view) {
            this.f109a.g = view;
            return this;
        }

        public a a(Drawable drawable) {
            this.f109a.d = drawable;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f109a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f109a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public l a() {
            l lVar = new l(this.f109a.f53a, this.f110b);
            this.f109a.a(lVar.c);
            lVar.setCancelable(this.f109a.r);
            if (this.f109a.r) {
                lVar.setCanceledOnTouchOutside(true);
            }
            lVar.setOnCancelListener(this.f109a.s);
            lVar.setOnDismissListener(this.f109a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f109a.u;
            if (onKeyListener != null) {
                lVar.setOnKeyListener(onKeyListener);
            }
            return lVar;
        }
    }

    protected l(Context context, int i) {
        super(context, a(context, i));
        this.c = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.A, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.c.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.c.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.A, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.c.b(charSequence);
    }
}
