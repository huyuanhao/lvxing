package com.alibaba.mtl.log.p077d;

import android.text.TextUtils;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.LogField;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.mtl.log.d.h */
public class LogAssemble {
    /* renamed from: a */
    public static String m3827a(Map<String, String> map) {
        String str;
        boolean z;
        String str2;
        StringBuilder sb = new StringBuilder();
        LogField[] values = LogField.values();
        int length = values.length;
        int i = 0;
        while (true) {
            String str3 = "||";
            String str4 = null;
            str = "";
            if (i >= length) {
                break;
            }
            LogField logField = values[i];
            if (logField == LogField.ARGS) {
                break;
            }
            if (map.containsKey(logField.toString())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((String) map.get(logField.toString()));
                sb2.append(str);
                str4 = sb2.toString();
                map.remove(logField.toString());
            }
            sb.append(m3825a(str4));
            sb.append(str3);
            i++;
        }
        if (map.containsKey(LogField.ARGS.toString())) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append((String) map.get(LogField.ARGS.toString()));
            sb3.append(str);
            sb.append(m3825a(sb3.toString()));
            map.remove(LogField.ARGS.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str5 : map.keySet()) {
            if (map.containsKey(str5)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append((String) map.get(str5));
                sb4.append(str);
                str2 = sb4.toString();
            } else {
                str2 = null;
            }
            String str6 = "StackTrace=====>";
            String str7 = "=";
            String str8 = "StackTrace";
            if (z) {
                if (str8.equals(str5)) {
                    sb.append(str6);
                    sb.append(str2);
                } else {
                    sb.append(m3825a(str5));
                    sb.append(str7);
                    sb.append(str2);
                }
                z = false;
            } else {
                boolean equals = str8.equals(str5);
                String str9 = StorageInterface.KEY_SPLITER;
                if (equals) {
                    sb.append(str9);
                    sb.append(str6);
                    sb.append(str2);
                } else {
                    sb.append(str9);
                    sb.append(m3825a(str5));
                    sb.append(str7);
                    sb.append(str2);
                }
            }
        }
        String sb5 = sb.toString();
        if (TextUtils.isEmpty(sb5) || !sb5.endsWith(str3)) {
            return sb5;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(sb5);
        sb6.append("-");
        return sb6.toString();
    }

    /* renamed from: b */
    public static String m3828b(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        m3829c(map);
        return m3827a(map);
    }

    /* renamed from: c */
    public static Map<String, String> m3829c(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        try {
            String d = AppInfoUtil.m3797d();
            if (!TextUtils.isEmpty(d) && !map.containsKey(LogField.USERNICK.toString())) {
                map.put(LogField.USERNICK.toString(), d);
            }
            String a = AppInfoUtil.m3790a();
            if (!TextUtils.isEmpty(a) && !map.containsKey(LogField.LL_USERNICK.toString())) {
                map.put(LogField.LL_USERNICK.toString(), a);
            }
            String e = AppInfoUtil.m3798e();
            if (!TextUtils.isEmpty(e) && !map.containsKey(LogField.USERID.toString())) {
                map.put(LogField.USERID.toString(), e);
            }
            String b = AppInfoUtil.m3793b();
            if (!TextUtils.isEmpty(b) && !map.containsKey(LogField.LL_USERID.toString())) {
                map.put(LogField.LL_USERID.toString(), b);
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (!map.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
                map.put(LogField.RECORD_TIMESTAMP.toString(), valueOf);
            }
            if (!map.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
                map.put(LogField.START_SESSION_TIMESTAMP.toString(), String.valueOf(UTDC.f3275f));
            }
            Map a2 = DeviceUtil.m3807a(UTDC.m3697c());
            if (a2 != null) {
                for (String str : a2.keySet()) {
                    String str2 = (String) a2.get(str);
                    if (!TextUtils.isEmpty(str2) && !map.containsKey(str) && !map.containsKey(str)) {
                        map.put(str, str2);
                    }
                }
            }
            String d2 = m3830d(map);
            if (!TextUtils.isEmpty(d2) && !map.containsKey(LogField.RESERVES.toString())) {
                map.put(LogField.RESERVES.toString(), d2);
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    /* renamed from: d */
    private static String m3830d(Map<String, String> map) {
        String str = "_ap=1";
        if ("y".equalsIgnoreCase((String) map.get(LogField.OS.toString()))) {
            String b = DeviceUtil.m3810b();
            if (!TextUtils.isEmpty(b)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(",_did=");
                sb.append(b);
                str = sb.toString();
            }
        }
        String str2 = (String) map.get(LogField.APPKEY.toString());
        if (TextUtils.isEmpty(AppInfoUtil.m3799f()) || TextUtils.isEmpty(str2) || AppInfoUtil.m3799f().equalsIgnoreCase(str2)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(",_mak=");
        sb2.append(AppInfoUtil.m3799f());
        return sb2.toString();
    }

    /* renamed from: a */
    private static String m3825a(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    /* renamed from: a */
    public static String m3826a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(LogField.PAGE.toString(), str);
        }
        hashMap.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(LogField.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(LogField.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(LogField.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(LogField.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(LogField.RESERVE3.toString(), str6);
        }
        return m3828b(hashMap);
    }
}
