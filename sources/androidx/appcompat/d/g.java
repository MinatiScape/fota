package androidx.appcompat.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.widget.E;
import androidx.core.h.AbstractC0068b;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = {Context.class};
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f146a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f147b;
        private Method c;

        public a(Object obj, String str) {
            this.f147b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, f146a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.f147b, menuItem)).booleanValue();
                }
                this.c.invoke(this.f147b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.mActionViewConstructorArguments = new Object[]{context};
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }

    private Object findRealOwner(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? findRealOwner(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r6 = r15;
        r8 = null;
        r15 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r15 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r6 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r6 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r6 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        r6 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r6.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r6.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
        r0.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r6.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r0.c() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        r6 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r6 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        if (r6.a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
        if (r6.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
        r6 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        if (r6.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
        if (r6.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        r0.b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
        if (r6.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
        parseMenu(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b8, code lost:
        r8 = r6;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
        r6 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c6, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void parseMenu(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            androidx.appcompat.d.g$b r0 = new androidx.appcompat.d.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r6 = r15
            r8 = r4
            r15 = 0
            r7 = 0
        L41:
            if (r15 != 0) goto Lc7
            if (r6 == r3) goto Lbf
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r6 == r1) goto L8f
            r11 = 3
            if (r6 == r11) goto L50
            goto Lba
        L50:
            java.lang.String r6 = r13.getName()
            if (r7 == 0) goto L5f
            boolean r11 = r6.equals(r8)
            if (r11 == 0) goto L5f
            r8 = r4
            r7 = 0
            goto Lba
        L5f:
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto L69
            r0.d()
            goto Lba
        L69:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L87
            boolean r6 = r0.c()
            if (r6 != 0) goto Lba
            androidx.core.h.b r6 = r0.A
            if (r6 == 0) goto L83
            boolean r6 = r6.a()
            if (r6 == 0) goto L83
            r0.b()
            goto Lba
        L83:
            r0.a()
            goto Lba
        L87:
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto Lba
            r15 = 1
            goto Lba
        L8f:
            if (r7 == 0) goto L92
            goto Lba
        L92:
            java.lang.String r6 = r13.getName()
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto La0
            r0.a(r14)
            goto Lba
        La0:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto Laa
            r0.b(r14)
            goto Lba
        Laa:
            boolean r9 = r6.equals(r2)
            if (r9 == 0) goto Lb8
            android.view.SubMenu r6 = r0.b()
            r12.parseMenu(r13, r14, r6)
            goto Lba
        Lb8:
            r8 = r6
            r7 = 1
        Lba:
            int r6 = r13.next()
            goto L41
        Lbf:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.d.g.parseMenu(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof androidx.core.b.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.mContext.getResources().getLayout(i);
                    parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public class b {
        AbstractC0068b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f148a;

        /* renamed from: b  reason: collision with root package name */
        private int f149b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f148a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f149b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuItem);
            this.i = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_id, 0);
            this.j = (obtainStyledAttributes.getInt(R$styleable.MenuItem_android_menuCategory, this.c) & (-65536)) | (obtainStyledAttributes.getInt(R$styleable.MenuItem_android_orderInCategory, this.d) & 65535);
            this.k = obtainStyledAttributes.getText(R$styleable.MenuItem_android_title);
            this.l = obtainStyledAttributes.getText(R$styleable.MenuItem_android_titleCondensed);
            this.m = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_icon, 0);
            this.n = a(obtainStyledAttributes.getString(R$styleable.MenuItem_android_alphabeticShortcut));
            this.o = obtainStyledAttributes.getInt(R$styleable.MenuItem_alphabeticModifiers, CpioConstants.C_ISFIFO);
            this.p = a(obtainStyledAttributes.getString(R$styleable.MenuItem_android_numericShortcut));
            this.q = obtainStyledAttributes.getInt(R$styleable.MenuItem_numericModifiers, CpioConstants.C_ISFIFO);
            if (obtainStyledAttributes.hasValue(R$styleable.MenuItem_android_checkable)) {
                this.r = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checked, false);
            this.t = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_visible, this.f);
            this.u = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_enabled, this.g);
            this.v = obtainStyledAttributes.getInt(R$styleable.MenuItem_showAsAction, -1);
            this.z = obtainStyledAttributes.getString(R$styleable.MenuItem_android_onClick);
            this.w = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_actionLayout, 0);
            this.x = obtainStyledAttributes.getString(R$styleable.MenuItem_actionViewClass);
            this.y = obtainStyledAttributes.getString(R$styleable.MenuItem_actionProviderClass);
            boolean z = this.y != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (AbstractC0068b) a(this.y, g.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, g.this.mActionProviderConstructorArguments);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(R$styleable.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(R$styleable.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(R$styleable.MenuItem_iconTintMode)) {
                this.E = E.a(obtainStyledAttributes.getInt(R$styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(R$styleable.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(R$styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.h = false;
        }

        public boolean c() {
            return this.h;
        }

        public void d() {
            this.f149b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (!g.this.mContext.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.getRealOwner(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof p;
            if (z2) {
                p pVar = (p) menuItem;
            }
            if (this.r >= 2) {
                if (z2) {
                    ((p) menuItem).c(true);
                } else if (menuItem instanceof q) {
                    ((q) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, g.this.mActionViewConstructorArguments));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            AbstractC0068b abstractC0068b = this.A;
            if (abstractC0068b != null) {
                androidx.core.h.g.a(menuItem, abstractC0068b);
            }
            androidx.core.h.g.a(menuItem, this.B);
            androidx.core.h.g.b(menuItem, this.C);
            androidx.core.h.g.a(menuItem, this.n, this.o);
            androidx.core.h.g.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                androidx.core.h.g.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                androidx.core.h.g.a(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.h = true;
            SubMenu addSubMenu = this.f148a.addSubMenu(this.f149b, this.i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public void a() {
            this.h = true;
            a(this.f148a.add(this.f149b, this.i, this.j, this.k));
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
