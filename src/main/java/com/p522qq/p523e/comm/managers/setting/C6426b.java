package com.p522qq.p523e.comm.managers.setting;

import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.b */
public class C6426b {
    /* renamed from: a */
    private JSONObject f20237a;

    public C6426b() {
        this.f20237a = new JSONObject();
    }

    public C6426b(String str) {
        this();
        StringBuilder sb = new StringBuilder("Initialize GDTSDKSetting,Json=");
        sb.append(str);
        GDTLogger.m25258d(sb.toString());
        if (!StringUtil.isEmpty(str)) {
            try {
                this.f20237a = new JSONObject(str);
            } catch (JSONException e) {
                GDTLogger.report("Exception while building GDTSDKSetting from json", e);
            }
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final Object mo30156a(String str) {
        return this.f20237a.opt(str);
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo30157a(String str, Object obj) {
        try {
            this.f20237a.putOpt(str, obj);
        } catch (JSONException e) {
            GDTLogger.m25261e("Exception while update setting", e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GDTSDKSetting[");
        sb.append(this.f20237a.toString());
        sb.append("]");
        return sb.toString();
    }
}
