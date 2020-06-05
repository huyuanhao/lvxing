package com.alipay.sdk.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.util.C1553o;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.sys.a */
public class C1535a {
    /* renamed from: a */
    private String f3923a;
    /* renamed from: b */
    private String f3924b;
    /* renamed from: c */
    private Context f3925c = null;

    public C1535a(Context context) {
        String str = "";
        this.f3923a = str;
        this.f3924b = str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f3923a = packageInfo.versionName;
            this.f3924b = packageInfo.packageName;
            this.f3925c = context.getApplicationContext();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public String mo12199a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        if (m4603b(str)) {
            return m4604c(str);
        }
        return m4605d(str);
    }

    /* renamed from: b */
    private boolean m4603b(String str) {
        return !str.contains("\"&");
    }

    /* renamed from: c */
    private String m4604c(String str) {
        String str2 = "&";
        String str3 = "bizcontext=";
        try {
            String a = m4600a(str, str2, str3);
            String str4 = "";
            if (TextUtils.isEmpty(a)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str2);
                sb.append(m4602b(str3, str4));
                return sb.toString();
            }
            int indexOf = str.indexOf(a);
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + a.length());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(substring);
            sb2.append(m4601a(a, str3, str4, true));
            sb2.append(substring2);
            return sb2.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: d */
    private String m4605d(String str) {
        String str2 = "bizcontext=\"";
        try {
            String a = m4600a(str, "\"&", str2);
            String str3 = "\"";
            if (TextUtils.isEmpty(a)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("&");
                sb.append(m4602b(str2, str3));
                return sb.toString();
            }
            if (!a.endsWith(str3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a);
                sb2.append(str3);
                a = sb2.toString();
            }
            int indexOf = str.indexOf(a);
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + a.length());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(substring);
            sb3.append(m4601a(a, str2, str3, false));
            sb3.append(substring2);
            return sb3.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: a */
    private String m4600a(String str, String str2, String str3) {
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        int i = 0;
        while (true) {
            if (i < split.length) {
                if (!TextUtils.isEmpty(split[i]) && split[i].startsWith(str3)) {
                    str4 = split[i];
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return str4;
    }

    /* renamed from: b */
    private String m4602b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        String str3 = "";
        String a = mo12200a(str3, str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(a);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public String mo12200a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", "2014052600006128");
            jSONObject.put("ty", "and_lite");
            jSONObject.put("sv", "h.a.3.6.5");
            if (!this.f3924b.contains("setting") || !C1553o.m4681b(this.f3925c)) {
                jSONObject.put("an", this.f3924b);
            }
            jSONObject.put("av", this.f3923a);
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            C1542e.m4633a(th);
            return "";
        }
    }

    /* renamed from: a */
    private String m4601a(String str, String str2, String str3, boolean z) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject;
        String substring = str.substring(str2.length());
        boolean z2 = false;
        String substring2 = substring.substring(0, substring.length() - str3.length());
        String str4 = "\"";
        if (substring2.length() < 2 || !substring2.startsWith(str4) || !substring2.endsWith(str4)) {
            jSONObject = new JSONObject(substring2);
        } else {
            jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
            z2 = true;
        }
        String str5 = "appkey";
        if (!jSONObject.has(str5)) {
            jSONObject.put(str5, "2014052600006128");
        }
        String str6 = "ty";
        if (!jSONObject.has(str6)) {
            jSONObject.put(str6, "and_lite");
        }
        String str7 = "sv";
        if (!jSONObject.has(str7)) {
            jSONObject.put(str7, "h.a.3.6.5");
        }
        String str8 = "an";
        if (!jSONObject.has(str8) && (!this.f3924b.contains("setting") || !C1553o.m4681b(this.f3925c))) {
            jSONObject.put(str8, this.f3924b);
        }
        String str9 = "av";
        if (!jSONObject.has(str9)) {
            jSONObject.put(str9, this.f3923a);
        }
        String str10 = "sdk_start_time";
        if (!jSONObject.has(str10)) {
            jSONObject.put(str10, System.currentTimeMillis());
        }
        String jSONObject2 = jSONObject.toString();
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(jSONObject2);
            sb.append(str4);
            jSONObject2 = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(jSONObject2);
        sb2.append(str3);
        return sb2.toString();
    }
}
