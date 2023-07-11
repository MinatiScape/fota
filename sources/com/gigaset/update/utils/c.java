package com.gigaset.update.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.gigaset.update.MyApplication;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* compiled from: DeviceInfoUtil.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1167a;

    private c() {
    }

    private String G() {
        return f.a(c("persist.sys.fota_deviceid3").replaceAll(",", ""));
    }

    private String H() {
        return c("ro.fota.id");
    }

    private String I() {
        String str;
        try {
            str = J();
        } catch (Exception unused) {
            str = "";
        }
        try {
            String K = K();
            return Long.parseLong(str) >= Long.parseLong(K) ? str : K;
        } catch (Exception unused2) {
            return !TextUtils.isEmpty(str) ? str : "";
        }
    }

    private String J() {
        String c;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            c = ((TelephonyManager) MyApplication.c().getSystemService("phone")).getImei(0);
        } else if (i == 19) {
            c = c("gsm.fota_deviceid1");
        } else {
            c = c("persist.sys.fota_deviceid1");
        }
        if (!TextUtils.isEmpty(c)) {
            String a2 = f.a(c.replaceAll(",", ""));
            if (!TextUtils.isEmpty(a2) && !d(a2)) {
                return a(a2);
            }
        }
        return M();
    }

    private String K() {
        String c;
        if (Build.VERSION.SDK_INT >= 29) {
            c = ((TelephonyManager) MyApplication.c().getSystemService("phone")).getImei(1);
        } else if (TextUtils.isEmpty("") && Build.VERSION.SDK_INT == 19) {
            c = c("gsm.fota_deviceid2");
        } else {
            c = c("persist.sys.fota_deviceid2");
        }
        if (!TextUtils.isEmpty(c)) {
            String a2 = f.a(c.replaceAll(",", ""));
            if (!TextUtils.isEmpty(a2) && !d(a2)) {
                return a(a2);
            }
        }
        return M();
    }

    private String L() {
        byte[] hardwareAddress;
        String str = "";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            String str2 = "";
            while (true) {
                if (str2 == null) {
                    break;
                }
                str2 = lineNumberReader.readLine();
                if (str2 != null) {
                    str = str2.trim();
                    break;
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = f("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            }
            if (TextUtils.isEmpty(str)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        str = sb.toString();
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            str = N();
        }
        return TextUtils.isEmpty(str) ? "ff:ff:ff:ff:ff:ff" : str;
    }

    private String M() {
        String c = c("persist.sys.fota_deviceid4");
        if (!TextUtils.isEmpty(c)) {
            String a2 = f.a(c.replaceAll(",", ""));
            if (!TextUtils.isEmpty(a2) && !d(a2)) {
                return a(a2);
            }
        }
        return "";
    }

    private static String N() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String O() {
        String str = null;
        for (String str2 : new String[]{"ro.boot.serialno", "ro.serialno"}) {
            str = SystemProperties.get(str2);
            LogUtil.a("SN VALUE : " + str);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    private String a(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                sb.append(e(String.valueOf(c).toLowerCase()));
            }
        }
        return sb.toString();
    }

    private int b(String str) {
        return SystemProperties.getInt(str, 0);
    }

    private String c(String str) {
        return SystemProperties.get(str, "");
    }

    private String g(String str) {
        return str.replaceAll("_", "\\$");
    }

    public static c k() {
        if (f1167a == null) {
            f1167a = new c();
        }
        return f1167a;
    }

    public boolean A() {
        return b("ro.fota.fmcheck") == 1;
    }

    public boolean B() {
        return b("ro.fota.fmsuccess") == 1;
    }

    public boolean C() {
        return b("ro.fota.pop") == 0;
    }

    public boolean D() {
        return SystemProperties.getInt("ro.fota.exit", 1) == 0;
    }

    public boolean E() {
        return SystemProperties.getInt("ro.fota.localupdate", 1) == 0;
    }

    public boolean F() {
        return SystemProperties.getBoolean("ro.build.ab_update", false);
    }

    public String d() {
        String c = c("ro.fota.type");
        return TextUtils.isEmpty(c) ? "phone" : c;
    }

    public String e() {
        String c = c("ro.product.model");
        String c2 = c("ro.product.brand");
        String c3 = c("ro.product.name");
        String c4 = c("ro.product.device");
        String c5 = c("ro.product.board");
        String c6 = c("ro.product.manufacturer");
        String c7 = c("ro.product.platform");
        String c8 = c("ro.product.product");
        return g(c) + "_" + g(c2) + "_" + g(c3) + "_" + g(c4) + "_" + g(c5) + "_" + g(c6) + "_" + g(c7) + "_" + g(c8);
    }

    public int f(Context context) {
        int i = 0;
        if (Build.VERSION.SDK_INT < 21) {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("level", 0);
            }
        } else {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            if (batteryManager != null) {
                i = batteryManager.getIntProperty(4);
            }
        }
        LogUtil.a("real battery = " + i);
        return i;
    }

    public boolean h(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager != null && powerManager.isScreenOn();
    }

    public String i() {
        String c = c("ro.fota.language");
        if (TextUtils.isEmpty(c)) {
            c = c("ro.product.locale");
        }
        if (TextUtils.isEmpty(c)) {
            c = c("ro.product.locale.language");
        }
        if (TextUtils.isEmpty(c)) {
            c = "en";
        }
        return g(c);
    }

    public String j() {
        return Build.FINGERPRINT;
    }

    public String l() {
        String c = c("ro.fota.version");
        return TextUtils.isEmpty(c) ? "unknownbuildnumber" : c;
    }

    public String m() {
        String str;
        String J;
        try {
            J = J();
            str = K();
        } catch (Exception unused) {
            str = "";
        }
        try {
            long parseLong = Long.parseLong(J);
            long parseLong2 = Long.parseLong(str);
            return parseLong > parseLong2 ? str : parseLong < parseLong2 ? J : "";
        } catch (Exception unused2) {
            return !TextUtils.isEmpty(str) ? str : "";
        }
    }

    public String n() {
        String c = c("ro.fota.path");
        LogUtil.a("ro.fota.path = " + c);
        return c;
    }

    public String o() {
        return c("ro.fota.platform");
    }

    public String p() {
        String c;
        String str;
        String str2;
        String c2 = c("ro.fota.oem");
        String g = TextUtils.isEmpty(c2) ? "unknownoem" : g(c2);
        if (TextUtils.isEmpty(c("ro.fota.device"))) {
            str = "_unknownproduct_" + i();
        } else {
            str = "_" + g(c) + "_" + i();
        }
        String g2 = g(c("ro.operator.optr"));
        if (g2.equalsIgnoreCase("OP01")) {
            str2 = "CMCC";
        } else {
            str2 = g2.equalsIgnoreCase("OP02") ? "CU" : "other";
        }
        return g + str + "_" + str2;
    }

    public long q() {
        long j = SystemProperties.getLong("ro.fota.activate", 0L);
        if (j <= 1 || j >= 1440) {
            return 900000L;
        }
        return j * 60 * 1000;
    }

    public String r() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public String s() {
        return Build.VERSION.RELEASE;
    }

    public String t() {
        return c("ro.fota.finalizing.pro");
    }

    public boolean u() {
        return b("ro.fota.auto.wifi") == 1;
    }

    public boolean v() {
        return b("ro.fota.hide.shake") == 0 || b("ro.fota.hide.shake") == 1;
    }

    public boolean w() {
        return b("ro.fota.no_ring") == 1;
    }

    public boolean x() {
        return b("ro.fota.no_touch") == 1;
    }

    public boolean y() {
        return b("ro.fota.wifi.only") == 1;
    }

    public boolean z() {
        return b("ro.fota.screen") == 1;
    }

    public int b() {
        int i = SystemProperties.getInt("ro.fota.battery", 30);
        if (i != 30) {
            return i;
        }
        int intValue = ((Integer) com.gigaset.update.e.c.a().a("install_battery", Integer.class)).intValue();
        if (intValue == 30 || intValue == 0) {
            return 30;
        }
        LogUtil.a("battery=" + intValue);
        return intValue;
    }

    public String c() {
        String c = c("ro.fota.cycle");
        return !TextUtils.isEmpty(c) ? c : "1";
    }

    public String g(Context context) {
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        return i + "#" + i2;
    }

    private boolean d(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (Integer.valueOf(String.valueOf(str.charAt(i))).intValue() != 0) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public String h() {
        String G;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            G = Build.getSerial();
        } else {
            G = i >= 26 ? G() : "";
        }
        if (TextUtils.isEmpty(G)) {
            G = O();
        }
        return TextUtils.isEmpty(G) ? Build.SERIAL : G;
    }

    public String c(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getSimOperatorName();
    }

    public String b(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
        }
        return L();
    }

    public int d(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return type == 1 ? -2 : -1;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkType();
        }
        return -1;
    }

    public String g() {
        return c("ro.fota.version.display");
    }

    public String a(Context context) {
        String h;
        String d = d();
        LogUtil.a("deviceType = " + d);
        if (!"pad".equalsIgnoreCase(d) && !"tv".equalsIgnoreCase(d) && !"box".equalsIgnoreCase(d)) {
            if (!"phone".equalsIgnoreCase(d) && !"pad_phone".equalsIgnoreCase(d)) {
                h = h();
            } else {
                h = I();
            }
        } else {
            h = h();
        }
        String H = H();
        LogUtil.a("id = " + H);
        if (TextUtils.isEmpty(H)) {
            return h;
        }
        if ("sn".equalsIgnoreCase(H)) {
            return h();
        }
        if ("mac".equalsIgnoreCase(H)) {
            return b(context);
        }
        return "imei".equalsIgnoreCase(H) ? I() : h;
    }

    public String f() {
        String c = c("ro.fota.display");
        return !TextUtils.isEmpty(c) ? c : "0";
    }

    private String f(String str) throws Exception {
        FileReader fileReader = new FileReader(str);
        String a2 = a(fileReader);
        fileReader.close();
        return a2;
    }

    private long e(String str) {
        byte[] bytes = str.getBytes();
        if (bytes.length > 0) {
            return bytes[0] - 96;
        }
        return 0L;
    }

    public String e(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getSimOperator();
    }

    private String a(Reader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[CpioConstants.C_ISFIFO];
        int read = reader.read(cArr);
        while (read >= 0) {
            sb.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        return sb.toString();
    }

    public String a() {
        return H();
    }
}
