package com.alipay.apmobilesecuritysdk.p107e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p105c.C1438a;
import com.alipay.apmobilesecuritysdk.p108f.C1455a;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.tencent.mid.api.MidEntity;
import org.json.JSONObject;

/* renamed from: com.alipay.apmobilesecuritysdk.e.e */
public final class C1450e {
    /* renamed from: a */
    public static C1451f m4197a(Context context) {
        if (context == null) {
            return null;
        }
        String a = C1455a.m4247a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (C1460a.m4260a(a)) {
            a = C1455a.m4248a("device_feature_file_name", "device_feature_file_key");
        }
        if (C1460a.m4260a(a)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(a);
            C1451f fVar = new C1451f();
            fVar.mo12008a(jSONObject.getString(MidEntity.TAG_IMEI));
            fVar.mo12010b(jSONObject.getString("imsi"));
            fVar.mo12012c(jSONObject.getString(MidEntity.TAG_MAC));
            fVar.mo12014d(jSONObject.getString("bluetoothmac"));
            fVar.mo12016e(jSONObject.getString("gsi"));
            return fVar;
        } catch (Exception e) {
            C1438a.m4169a((Throwable) e);
            return null;
        }
    }
}
