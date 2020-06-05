package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.tencent.stat.common.DeviceInfo;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.l */
class C1825l extends C1816c {
    /* renamed from: e */
    private final Context f5121e;
    /* renamed from: f */
    private final C1821h f5122f;

    C1825l(Context context, C1821h hVar) {
        super(true, false);
        this.f5121e = context;
        this.f5122f = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        String mac = AppLog.getInitConfig() != null ? AppLog.getInitConfig().getSensitiveInfoProvider().getMac() : "";
        if (!TextUtils.isEmpty(mac)) {
            jSONObject.put(DeviceInfo.TAG_MAC, mac);
        }
        return true;
    }
}
