package com.alibaba.baichuan.trade.common.utils;

import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.utils.e */
public class C1231e {
    /* renamed from: a */
    public static boolean m2428a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return m2429a((String) obj);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2429a(String str) {
        return "true".equals(str.toLowerCase()) || "1".equals(str) || "YES".equals(str);
    }

    /* renamed from: b */
    public static Long m2430b(Object obj) {
        try {
            return Long.valueOf(Long.parseLong(obj.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return Long.valueOf(-1);
        }
    }

    /* renamed from: c */
    public static Map<String, Object> m2431c(Object obj) {
        try {
            return (Map) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static Map<String, String> m2432d(Object obj) {
        try {
            return (Map) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
