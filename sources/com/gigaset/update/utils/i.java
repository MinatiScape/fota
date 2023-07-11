package com.gigaset.update.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
/* compiled from: JsonUtil.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Gson f1172a;

    private static Gson a() {
        if (f1172a == null) {
            f1172a = new Gson();
        }
        return f1172a;
    }

    public static <T> T a(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (T) a().fromJson(str, (Class<Object>) cls);
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
            return null;
        }
    }

    public static <T> String a(List<T> list) {
        return a().toJson(list);
    }

    public static <T> String a(T t) {
        return a().toJson(t);
    }

    public static String a(Map map) {
        return a().toJson(map);
    }

    public static <T> T a(String str) {
        return (T) a().fromJson(str, new h().getType());
    }
}
