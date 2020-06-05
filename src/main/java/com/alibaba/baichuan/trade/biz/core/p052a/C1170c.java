package com.alibaba.baichuan.trade.biz.core.p052a;

import androidx.core.app.NotificationCompat;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.fastjson.JSONObject;

/* renamed from: com.alibaba.baichuan.trade.biz.core.a.c */
public class C1170c {
    /* renamed from: a */
    public static final C1170c f2409a = new C1170c("0");
    /* renamed from: b */
    public static final C1170c f2410b = new C1170c("6");
    /* renamed from: c */
    public static final C1170c f2411c = new C1170c("2");
    /* renamed from: d */
    public static final C1170c f2412d = new C1170c("1");
    /* renamed from: e */
    public static final C1170c f2413e = new C1170c("4");
    /* renamed from: f */
    public static final C1170c f2414f = new C1170c("7");
    /* renamed from: g */
    private JSONObject f2415g = new JSONObject();
    /* renamed from: h */
    private String f2416h = "6";
    /* renamed from: i */
    private String f2417i = "";

    public C1170c() {
    }

    public C1170c(String str) {
        mo10738a(str);
    }

    /* renamed from: a */
    public String mo10737a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", (Object) this.f2416h);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, (Object) this.f2417i);
            jSONObject.put("data", (Object) this.f2415g);
        } catch (Exception e) {
            C1224a.m2406d("alibc", e.getMessage());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public void mo10738a(String str) {
        this.f2417i = str;
    }
}
