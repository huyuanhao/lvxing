package com.qiyukf.basesdk.p394b.p395a.p397b.p401d;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5309c;

/* renamed from: com.qiyukf.basesdk.b.a.b.d.b */
public class C5306b {
    /* renamed from: a */
    private static final String f17205a = C5309c.m21831a(C5306b.class);

    /* renamed from: a */
    public static String m21815a(String str) {
        String str2 = f17205a;
        StringBuilder sb = new StringBuilder("query lbs url: ");
        sb.append(str);
        C5264a.m21624d(str2, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("?version=1.0");
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m21816a(String str, String str2, String str3, String str4) {
        String str5;
        String str6 = "/";
        if (str4 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str6);
            sb.append(str3);
            sb.append("?uploadContext&version=1.0&context=");
            sb.append(str4);
            str5 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str6);
            sb2.append(str3);
            sb2.append("?uploadContext&version=1.0");
            str5 = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str6);
        sb3.append(str5);
        return sb3.toString();
    }

    /* renamed from: a */
    public static String m21817a(String str, String str2, String str3, String str4, long j, boolean z) {
        String str5;
        String str6 = "&complete=";
        String str7 = "/";
        if (str4 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str7);
            sb.append(str3);
            sb.append("?version=1.0&context=");
            sb.append(str4);
            sb.append("&offset=");
            sb.append(j);
            sb.append(str6);
            sb.append(z);
            str5 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str7);
            sb2.append(str3);
            sb2.append("?version=1.0&offset=");
            sb2.append(j);
            sb2.append(str6);
            sb2.append(z);
            str5 = sb2.toString();
        }
        String str8 = f17205a;
        StringBuilder sb3 = new StringBuilder("post data url server: ");
        sb3.append(str);
        sb3.append(", query string: ");
        sb3.append(str5);
        C5264a.m21624d(str8, sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(str7);
        sb4.append(str5);
        return sb4.toString();
    }
}
