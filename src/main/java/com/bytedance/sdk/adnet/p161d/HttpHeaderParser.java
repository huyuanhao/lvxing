package com.bytedance.sdk.adnet.p161d;

import com.bytedance.sdk.adnet.core.C1969a;
import com.bytedance.sdk.adnet.core.NetworkResponse;
import com.bytedance.sdk.adnet.core.VNetLog;
import com.bytedance.sdk.adnet.p162e.ICache.C1994a;
import com.tencent.mid.sotrage.StorageInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

/* renamed from: com.bytedance.sdk.adnet.d.c */
public class HttpHeaderParser {
    /* renamed from: a */
    public static C1994a m7939a(NetworkResponse lVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        NetworkResponse lVar2 = lVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lVar2.f6276c;
        String str = (String) map.get("Date");
        long a = str != null ? m7938a(str) : 0;
        String str2 = (String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(StorageInterface.KEY_SPLITER, 0);
            j2 = 0;
            int i2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j2 = 0;
            j = 0;
            z = false;
        }
        String str3 = (String) map.get("Expires");
        long a2 = str3 != null ? m7938a(str3) : 0;
        String str4 = (String) map.get("Last-Modified");
        long a3 = str4 != null ? m7938a(str4) : 0;
        String str5 = (String) map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i == 0) {
                Long.signum(j);
                j3 = (j * 1000) + j4;
                C1994a aVar = new C1994a();
                aVar.f6324a = lVar2.f6274a;
                aVar.f6325b = lVar2.f6275b;
                aVar.f6326c = str5;
                aVar.f6330g = j4;
                aVar.f6329f = j3;
                aVar.f6327d = a;
                aVar.f6328e = a3;
                aVar.f6331h = map;
                aVar.f6332i = lVar2.f6277d;
                return aVar;
            }
        } else if (a <= 0 || a2 < a) {
            j4 = 0;
        } else {
            j3 = (a2 - a) + currentTimeMillis;
            j4 = j3;
            C1994a aVar2 = new C1994a();
            aVar2.f6324a = lVar2.f6274a;
            aVar2.f6325b = lVar2.f6275b;
            aVar2.f6326c = str5;
            aVar2.f6330g = j4;
            aVar2.f6329f = j3;
            aVar2.f6327d = a;
            aVar2.f6328e = a3;
            aVar2.f6331h = map;
            aVar2.f6332i = lVar2.f6277d;
            return aVar2;
        }
        j3 = j4;
        C1994a aVar22 = new C1994a();
        aVar22.f6324a = lVar2.f6274a;
        aVar22.f6325b = lVar2.f6275b;
        aVar22.f6326c = str5;
        aVar22.f6330g = j4;
        aVar22.f6329f = j3;
        aVar22.f6327d = a;
        aVar22.f6328e = a3;
        aVar22.f6331h = map;
        aVar22.f6332i = lVar2.f6277d;
        return aVar22;
    }

    /* renamed from: a */
    public static long m7938a(String str) {
        try {
            return m7943a().parse(str).getTime();
        } catch (Throwable th) {
            VNetLog.m7927a(th, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    /* renamed from: a */
    public static String m7940a(long j) {
        return m7943a().format(new Date(j));
    }

    /* renamed from: a */
    private static SimpleDateFormat m7943a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    /* renamed from: a */
    public static String m7942a(Map<String, String> map, String str) {
        String str2 = (String) map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m7941a(Map<String, String> map) {
        return m7942a(map, "UTF-8");
    }

    /* renamed from: a */
    public static Map<String, String> m7944a(List<C1969a> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        if (list != null) {
            for (C1969a aVar : list) {
                treeMap.put(aVar.mo14306a(), aVar.mo14307b());
            }
        }
        return treeMap;
    }

    /* renamed from: b */
    public static List<C1969a> m7945b(Map<String, String> map) {
        if (map == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(new C1969a((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }
}
