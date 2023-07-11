package androidx.core.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ComplexColorCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f437a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f438b;
    private int c;

    private b(Shader shader, ColorStateList colorStateList, int i) {
        this.f437a = shader;
        this.f438b = colorStateList;
        this.c = i;
    }

    static b a(Shader shader) {
        return new b(shader, null, 0);
    }

    public Shader b() {
        return this.f437a;
    }

    public boolean c() {
        return this.f437a != null;
    }

    public boolean d() {
        ColorStateList colorStateList;
        return this.f437a == null && (colorStateList = this.f438b) != null && colorStateList.isStateful();
    }

    public boolean e() {
        return c() || this.c != 0;
    }

    static b a(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    public void b(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(int i) {
        return new b(null, null, i);
    }

    private static b b(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c = 0;
                }
            } else if (name.equals("gradient")) {
                c = 1;
            }
            if (c != 0) {
                if (c == 1) {
                    return a(d.a(resources, xml, asAttributeSet, theme));
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return a(a.a(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }

    public int a() {
        return this.c;
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.f438b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.c) {
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }

    public static b a(Resources resources, int i, Resources.Theme theme) {
        try {
            return b(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }
}
