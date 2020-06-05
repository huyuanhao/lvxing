package com.alibaba.mtl.log.p077d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.p074a.Config;
import com.alibaba.mtl.log.p078e.BaseRequestAuth;
import com.alibaba.mtl.log.p078e.IRequestAuth;
import com.alibaba.mtl.log.p078e.SecurityRequestAuth;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.alibaba.mtl.log.d.t */
public class UrlWrapper {
    /* renamed from: a */
    private static final String f3430a = UrlWrapper.class.getSimpleName();

    /* renamed from: a */
    public static String m3879a(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        String str2;
        String[] a;
        String str3 = "";
        if (map2 != null && map2.size() > 0) {
            Set keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            for (String str4 : KeyArraySorter.m3821a().mo11801a(strArr, true)) {
                byte[] bArr = (byte[]) map2.get(str4);
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str4);
                sb.append(MD5Utils.m3839b(bArr));
                str3 = sb.toString();
            }
        }
        try {
            str2 = m3878a(str, null, null, str3);
        } catch (Throwable unused) {
            str2 = m3878a(Config.m3704a(), null, null, str3);
        }
        String str5 = Config.f3286d;
        if (TextUtils.isEmpty(str5)) {
            return str2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("&dk=");
        sb2.append(URLEncoder.encode(str5, "UTF-8"));
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m3880b(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        if (map == null) {
            new HashMap();
        }
        Context c = UTDC.m3697c();
        String f = AppInfoUtil.m3799f();
        String c2 = AppInfoUtil.m3796c();
        if (c2 == null) {
            c2 = "";
        }
        String str2 = (String) DeviceUtil.m3807a(c).get(LogField.APPVERSION.toString());
        String str3 = (String) DeviceUtil.m3807a(c).get(LogField.OS.toString());
        String str4 = "2.6.4.5_for_bc";
        String str5 = (String) DeviceUtil.m3807a(c).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        IRequestAuth d = UTDC.m3698d();
        String str6 = d instanceof SecurityRequestAuth ? "1" : "0";
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append(str2);
        sb.append(c2);
        sb.append(str3);
        sb.append(str5);
        sb.append(str4);
        sb.append(valueOf);
        sb.append(str6);
        String str7 = "_b01n15";
        sb.append(map.get(str7));
        String str8 = "_b01na";
        sb.append(map.get(str8));
        String a = d.mo11827a(MD5Utils.m3839b(sb.toString().getBytes()));
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append("?");
        sb2.append("ak");
        String str9 = "=";
        sb2.append(str9);
        sb2.append(f);
        String str10 = "&";
        sb2.append(str10);
        sb2.append("av");
        sb2.append(str9);
        sb2.append(str2);
        sb2.append(str10);
        sb2.append("c");
        sb2.append(str9);
        sb2.append(URLEncoder.encode(c2));
        sb2.append(str10);
        sb2.append("d");
        sb2.append(str9);
        sb2.append(str5);
        sb2.append(str10);
        sb2.append("sv");
        sb2.append(str9);
        sb2.append(str4);
        sb2.append(str10);
        sb2.append("t");
        sb2.append(str9);
        sb2.append(valueOf);
        sb2.append(str10);
        sb2.append("is");
        sb2.append(str9);
        sb2.append(str6);
        sb2.append(str10);
        sb2.append(str7);
        sb2.append(str9);
        sb2.append(map.get(str7));
        sb2.append(str10);
        sb2.append(str8);
        sb2.append(str9);
        sb2.append(map.get(str8));
        sb2.append(str10);
        sb2.append("s");
        sb2.append(str9);
        sb2.append(a);
        return sb2.toString();
    }

    /* renamed from: a */
    private static String m3878a(String str, String str2, String str3, String str4) throws Exception {
        String str5;
        Context c = UTDC.m3697c();
        String f = AppInfoUtil.m3799f();
        String c2 = AppInfoUtil.m3796c();
        String str6 = "";
        if (c2 == null) {
            c2 = str6;
        }
        String str7 = (String) DeviceUtil.m3807a(c).get(LogField.APPVERSION.toString());
        String str8 = (String) DeviceUtil.m3807a(c).get(LogField.OS.toString());
        String str9 = "2.6.4.5_for_bc";
        String str10 = (String) DeviceUtil.m3807a(c).get(LogField.UTDID.toString());
        String str11 = "3.0";
        String valueOf = String.valueOf(System.currentTimeMillis());
        IRequestAuth d = UTDC.m3698d();
        String str12 = "1";
        String str13 = "0";
        if (d instanceof SecurityRequestAuth) {
            String str14 = str13;
            str13 = str12;
            str12 = str14;
        } else if (!(d instanceof BaseRequestAuth) || !((BaseRequestAuth) d).mo11828b()) {
            str12 = str13;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append(c2);
        sb.append(str7);
        sb.append(str8);
        sb.append(str9);
        sb.append(str10);
        sb.append(valueOf);
        sb.append(str11);
        sb.append(str13);
        sb.append(str3 == null ? str6 : str3);
        sb.append(str4 == null ? str6 : str4);
        String a = d.mo11827a(MD5Utils.m3839b(sb.toString().getBytes()));
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append("&");
            str5 = sb2.toString();
        } else {
            str5 = str6;
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", new Object[]{str, str5, m3877a(f), m3877a(str7), m3877a(c2), m3877a(str11), m3877a(a), m3877a(str10), str9, str8, valueOf, str6, str13, str12});
    }

    /* renamed from: a */
    private static String m3877a(String str) {
        if (str == null) {
            return "";
        }
        try {
            str = URLEncoder.encode(str, "UTF-8");
            return str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
