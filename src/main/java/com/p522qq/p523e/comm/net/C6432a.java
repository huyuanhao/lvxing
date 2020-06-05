package com.p522qq.p523e.comm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.managers.plugin.C6413PM;
import com.p522qq.p523e.comm.managers.setting.C6424SM;
import com.p522qq.p523e.comm.managers.status.APPStatus;
import com.p522qq.p523e.comm.managers.status.DeviceStatus;
import com.p522qq.p523e.comm.managers.status.SDKStatus;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.net.a */
public final class C6432a {
    /* renamed from: a */
    private static String m25240a() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
                StringBuilder sb = new StringBuilder();
                sb.append(telephonyManager.getNetworkType());
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static JSONObject m25241a(C6413PM pm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
        jSONObject.putOpt("pv", Integer.valueOf(pm.getPluginVersion()));
        jSONObject.putOpt("sdk_st", Integer.valueOf(1));
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m25242a(C6424SM sm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (sm != null) {
            jSONObject.putOpt("suid", sm.getSuid());
            jSONObject.putOpt("sid", sm.getSid());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m25243a(APPStatus aPPStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aPPStatus != null) {
            jSONObject.putOpt("an", aPPStatus.getAPPName());
            jSONObject.putOpt("appkey", aPPStatus.getAPPID());
            jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
            jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m25244a(DeviceStatus deviceStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
            jSONObject.putOpt("dn", deviceStatus.getDataNet());
            String a = m25240a();
            if (!StringUtil.isEmpty(a)) {
                jSONObject.putOpt("cell_native", a);
            }
            jSONObject.putOpt("lat", deviceStatus.getLat());
            jSONObject.putOpt("lng", deviceStatus.getLng());
            for (Entry entry : deviceStatus.getLacAndCeilId().entrySet()) {
                jSONObject.putOpt((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }
}
