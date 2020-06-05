package com.alibaba.mtl.log.model;

import android.text.TextUtils;
import com.alibaba.mtl.log.p077d.Base64;
import com.alibaba.mtl.log.p077d.LogAssemble;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.RC4;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* renamed from: com.alibaba.mtl.log.model.a */
public class Log {
    /* renamed from: a */
    public int f3461a;
    /* renamed from: b */
    public String f3462b;
    /* renamed from: c */
    public String f3463c = "3";
    /* renamed from: d */
    public String f3464d = null;
    /* renamed from: e */
    public String f3465e = "";
    /* renamed from: f */
    private String f3466f;
    /* renamed from: g */
    private String f3467g;
    /* renamed from: h */
    private String f3468h;
    /* renamed from: i */
    private String f3469i;
    /* renamed from: j */
    private String f3470j;
    /* renamed from: k */
    private Map<String, String> f3471k;

    public Log() {
    }

    public Log(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.f3462b = str2;
        this.f3467g = str;
        this.f3468h = str3;
        this.f3469i = str4;
        this.f3470j = str5;
        this.f3471k = map;
        this.f3464d = String.valueOf(System.currentTimeMillis());
        mo11839c();
    }

    /* renamed from: a */
    public String mo11835a() {
        try {
            byte[] a = Base64.m3800a(this.f3466f.getBytes("UTF-8"), 2);
            if (a != null) {
                return new String(RC4.m3857a(a, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String mo11837b() {
        return this.f3466f;
    }

    /* renamed from: a */
    public void mo11836a(String str) {
        if (str != null) {
            try {
                this.f3466f = new String(Base64.m3804c(RC4.m3857a(str.getBytes(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"), 2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo11838b(String str) {
        this.f3466f = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Log [id=");
        sb.append(this.f3461a);
        sb.append(", eventId=");
        sb.append(this.f3462b);
        sb.append(", index=");
        sb.append(this.f3465e);
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: c */
    public void mo11839c() {
        if (TextUtils.isEmpty(this.f3464d)) {
            this.f3464d = String.valueOf(System.currentTimeMillis());
        }
        String a = LogAssemble.m3826a(this.f3467g, this.f3462b, this.f3468h, this.f3469i, this.f3470j, this.f3471k, this.f3465e, this.f3464d);
        Logger.m3833a("UTLog", this, a);
        mo11836a(a);
    }
}
