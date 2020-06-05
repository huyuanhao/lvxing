package com.p620ut.mini;

import android.text.TextUtils;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.p077d.C1328p;
import com.alibaba.mtl.log.p077d.Logger;
import com.p620ut.mini.p621a.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.ut.mini.f */
public class UTTracker {
    /* renamed from: d */
    private static Pattern f26076d = Pattern.compile("(\\|\\||[\t\r\n])+");
    /* renamed from: a */
    private String f26077a = null;
    /* renamed from: b */
    private Map<String, String> f26078b = new HashMap();
    /* renamed from: c */
    private String f26079c;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37474a(String str) {
        this.f26077a = str;
    }

    /* renamed from: a */
    public synchronized void mo37475a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            Logger.m3831a("setGlobalProperty", (Object) "key is null or key is empty or value is null,please check it!");
        } else {
            this.f26078b.put(str, str2);
        }
    }

    /* renamed from: b */
    private static String m33234b(String str) {
        if (str == null) {
            return str;
        }
        String str2 = "";
        return !str2.equals(str) ? f26076d.matcher(str).replaceAll(str2) : str;
    }

    /* renamed from: c */
    private static String m33236c(String str) {
        return m33234b(str);
    }

    /* renamed from: b */
    private Map<String, String> m33235b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator it = map.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null) {
                    hashMap.put(str, m33236c((String) map.get(str)));
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo37476a(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.f26078b);
            hashMap.putAll(map);
            if (!TextUtils.isEmpty(this.f26079c)) {
                hashMap.put(LogField.APPKEY.toString(), this.f26079c);
            }
            Map b = m33235b((Map<String, String>) hashMap);
            if (!TextUtils.isEmpty(this.f26077a)) {
                b.put("_track_id", this.f26077a);
            }
            UTMIVariables.m33112b().mo37393a();
            m33237c(b);
            m33238d(b);
            m33239e(b);
            m33240f(b);
            UTDC.m3695a((String) b.remove(LogField.PAGE.toString()), (String) b.remove(LogField.EVENTID.toString()), (String) b.remove(LogField.ARG1.toString()), (String) b.remove(LogField.ARG2.toString()), (String) b.remove(LogField.ARG3.toString()), b);
        }
    }

    /* renamed from: c */
    private static void m33237c(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(LogField.IMEI.toString())) {
                map.remove(LogField.IMEI.toString());
            }
            if (map.containsKey(LogField.IMSI.toString())) {
                map.remove(LogField.IMSI.toString());
            }
            if (map.containsKey(LogField.CARRIER.toString())) {
                map.remove(LogField.CARRIER.toString());
            }
            if (map.containsKey(LogField.ACCESS.toString())) {
                map.remove(LogField.ACCESS.toString());
            }
            if (map.containsKey(LogField.ACCESS_SUBTYPE.toString())) {
                map.remove(LogField.ACCESS_SUBTYPE.toString());
            }
            if (map.containsKey(LogField.CHANNEL.toString())) {
                map.remove(LogField.CHANNEL.toString());
            }
            if (map.containsKey(LogField.LL_USERNICK.toString())) {
                map.remove(LogField.LL_USERNICK.toString());
            }
            if (map.containsKey(LogField.USERNICK.toString())) {
                map.remove(LogField.USERNICK.toString());
            }
            if (map.containsKey(LogField.LL_USERID.toString())) {
                map.remove(LogField.LL_USERID.toString());
            }
            if (map.containsKey(LogField.USERID.toString())) {
                map.remove(LogField.USERID.toString());
            }
            if (map.containsKey(LogField.SDKVERSION.toString())) {
                map.remove(LogField.SDKVERSION.toString());
            }
            if (map.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
                map.remove(LogField.START_SESSION_TIMESTAMP.toString());
            }
            if (map.containsKey(LogField.UTDID.toString())) {
                map.remove(LogField.UTDID.toString());
            }
            if (map.containsKey(LogField.SDKTYPE.toString())) {
                map.remove(LogField.SDKTYPE.toString());
            }
            if (map.containsKey(LogField.RESERVE2.toString())) {
                map.remove(LogField.RESERVE2.toString());
            }
            if (map.containsKey(LogField.RESERVE3.toString())) {
                map.remove(LogField.RESERVE3.toString());
            }
            if (map.containsKey(LogField.RESERVE4.toString())) {
                map.remove(LogField.RESERVE4.toString());
            }
            if (map.containsKey(LogField.RESERVE5.toString())) {
                map.remove(LogField.RESERVE5.toString());
            }
            if (map.containsKey(LogField.RESERVES.toString())) {
                map.remove(LogField.RESERVES.toString());
            }
            if (map.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
                map.remove(LogField.RECORD_TIMESTAMP.toString());
            }
        }
    }

    /* renamed from: d */
    private static void m33238d(Map<String, String> map) {
        if (map != null) {
            String str = "_field_os";
            if (map.containsKey(str)) {
                String str2 = (String) map.get(str);
                map.remove(str);
                map.put(LogField.OS.toString(), str2);
            }
            String str3 = "_field_os_version";
            if (map.containsKey(str3)) {
                String str4 = (String) map.get(str3);
                map.remove(str3);
                map.put(LogField.OSVERSION.toString(), str4);
            }
        }
    }

    /* renamed from: e */
    private static void m33239e(Map<String, String> map) {
        map.put(LogField.SDKTYPE.toString(), "mini");
    }

    /* renamed from: f */
    private static void m33240f(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        String str = "_track_id";
        if (map.containsKey(str)) {
            String str2 = (String) map.get(str);
            map.remove(str);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("_tkid", str2);
            }
        }
        if (hashMap.size() > 0) {
            map.put(LogField.RESERVES.toString(), C1328p.m3864b(hashMap));
        }
        if (!map.containsKey(LogField.PAGE.toString())) {
            map.put(LogField.PAGE.toString(), "UT");
        }
    }
}
