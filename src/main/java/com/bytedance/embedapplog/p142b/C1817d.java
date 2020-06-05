package com.bytedance.embedapplog.p142b;

import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.d */
class C1817d extends C1816c {
    C1817d() {
        super(true, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", VERSION.RELEASE);
        jSONObject.put("os_api", VERSION.SDK_INT);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        String str = "build_serial";
        jSONObject.put(str, Build.SERIAL);
        if (VERSION.SDK_INT >= 26) {
            jSONObject.put(str, Build.getSerial());
        }
        return true;
    }
}
