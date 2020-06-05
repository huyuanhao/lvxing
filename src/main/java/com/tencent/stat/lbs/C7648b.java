package com.tencent.stat.lbs;

import android.content.Context;
import com.tencent.mid.core.Constants;
import com.tencent.stat.common.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.lbs.b */
public class C7648b {
    /* renamed from: a */
    private static long f25859a;

    /* renamed from: a */
    public static JSONObject m32908a(Context context) {
        f25859a = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fun", "fbi");
            if (Util.checkPermission(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
                Util.safeJsonPut(jSONObject, "wflist", Util.getWifiTopN(context, 10));
                Util.safeJsonPut(jSONObject, "wf", Util.getConnecetedWifiInfo(context));
            }
            if (Util.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION") && Util.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                Util.safeJsonPut(jSONObject, "gps", StatGpsMonitor.getInstance().mo37203b());
                Util.safeJsonPut(jSONObject, "cell", StatGpsMonitor.getInstance().mo37202a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
