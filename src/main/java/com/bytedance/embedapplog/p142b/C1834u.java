package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.embedapplog.util.C1853e;
import com.bytedance.embedapplog.util.C1856h;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.u */
class C1834u extends C1816c {
    /* renamed from: e */
    private final Context f5132e;
    /* renamed from: f */
    private final C1821h f5133f;

    C1834u(Context context, C1821h hVar) {
        super(true, false);
        this.f5132e = context;
        this.f5133f = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f5132e.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                C1822i.m6381a(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                C1822i.m6381a(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                C1822i.m6381a(jSONObject, "udid", this.f5133f.mo13383R() ? C1853e.m6567a(telephonyManager) : this.f5133f.mo13382Q());
                return true;
            } catch (Exception e) {
                C1856h.m6582a(e);
            }
        }
        return false;
    }
}
