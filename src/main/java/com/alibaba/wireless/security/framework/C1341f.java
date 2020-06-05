package com.alibaba.wireless.security.framework;

import com.alibaba.wireless.security.framework.utils.C1349c;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.framework.f */
public class C1341f {
    /* renamed from: b */
    private static String f3476b = "version";
    /* renamed from: c */
    private static String f3477c = "lib_dep_version";
    /* renamed from: d */
    private static String f3478d = "lib_dep_arch";
    /* renamed from: e */
    private static String f3479e = "target_plugin";
    /* renamed from: a */
    private JSONObject f3480a;
    /* renamed from: f */
    private boolean f3481f = true;
    /* renamed from: g */
    private int f3482g = 0;
    /* renamed from: h */
    private boolean f3483h = true;
    /* renamed from: i */
    private String f3484i;
    /* renamed from: j */
    private boolean f3485j;
    /* renamed from: k */
    private String f3486k;

    private C1341f(JSONObject jSONObject) {
        String str = "";
        this.f3484i = str;
        this.f3485j = true;
        this.f3486k = str;
        this.f3480a = jSONObject;
    }

    /* renamed from: a */
    public static C1341f m3923a(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            String a = C1349c.m3981a(file);
            if (a == null || a.length() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(a);
            if ("1.0".equals(jSONObject.getString(f3476b))) {
                return new C1341f(jSONObject);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo11851a(String str) {
        try {
            return mo11852a().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public JSONObject mo11852a() {
        return this.f3480a;
    }

    /* renamed from: b */
    public int mo11853b() {
        int i;
        if (this.f3481f) {
            try {
                i = Integer.parseInt(mo11852a().getString(f3477c));
            } catch (Exception unused) {
                i = 0;
            }
            this.f3482g = i;
            this.f3481f = false;
        }
        return this.f3482g;
    }

    /* renamed from: c */
    public String mo11854c() {
        String str;
        if (this.f3483h) {
            try {
                str = mo11852a().getString(f3478d);
            } catch (Exception unused) {
                str = "";
            }
            this.f3484i = str;
            this.f3483h = false;
        }
        return this.f3484i;
    }

    /* renamed from: d */
    public String mo11855d() {
        String str;
        if (this.f3485j) {
            try {
                str = mo11852a().getString(f3479e);
            } catch (Exception unused) {
                str = "";
            }
            this.f3486k = str;
            this.f3485j = false;
        }
        return this.f3486k;
    }
}
