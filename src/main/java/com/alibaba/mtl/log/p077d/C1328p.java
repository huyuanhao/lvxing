package com.alibaba.mtl.log.p077d;

import android.text.TextUtils;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StringUtils */
/* renamed from: com.alibaba.mtl.log.d.p */
public class C1328p {
    /* renamed from: a */
    public static String m3862a(Object obj) {
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof String) {
            return ((String) obj).toString();
        }
        if (obj instanceof Integer) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(((Integer) obj).intValue());
            return sb.toString();
        } else if (obj instanceof Long) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(((Long) obj).longValue());
            return sb2.toString();
        } else if (obj instanceof Double) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(((Double) obj).doubleValue());
            return sb3.toString();
        } else if (obj instanceof Float) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(((Float) obj).floatValue());
            return sb4.toString();
        } else if (obj instanceof Short) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(((Short) obj).shortValue());
            return sb5.toString();
        } else if (obj instanceof Byte) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str);
            sb6.append(((Byte) obj).byteValue());
            return sb6.toString();
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        } else {
            if (obj instanceof Character) {
                return ((Character) obj).toString();
            }
            return obj.toString();
        }
    }

    /* renamed from: a */
    public static Map<String, String> m3863a(Map<String, String> map) {
        String str = "UTF-8";
        if (map == null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            if (str2 instanceof String) {
                String str3 = (String) map.get(str2);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    try {
                        hashMap.put(URLEncoder.encode(str2, str), URLEncoder.encode(str3, str));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static String m3864b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        boolean z = true;
        StringBuffer stringBuffer = new StringBuffer();
        for (Object next : map.keySet()) {
            String a = m3862a(map.get(next));
            String a2 = m3862a(next);
            if (!(a == null || a2 == null)) {
                String str = "=";
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a2);
                    sb.append(str);
                    sb.append(a);
                    stringBuffer.append(sb.toString());
                    z = false;
                } else {
                    stringBuffer.append(StorageInterface.KEY_SPLITER);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(a2);
                    sb2.append(str);
                    sb2.append(a);
                    stringBuffer.append(sb2.toString());
                }
            }
        }
        return stringBuffer.toString();
    }
}
