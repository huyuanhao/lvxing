package com.tencent.mid.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

public class Env {
    private static JSONObject attr_json = null;
    static BasicEnv basicEnv;
    private static Logger logger = Util.getLogger();
    String conn = null;
    Integer tel_network = null;

    /* renamed from: com.tencent.mid.util.Env$BasicEnv */
    static class BasicEnv {
        private String allSensors;
        String appVersion;
        String channel;
        private String cpuInfo;
        Context ctx;
        DisplayMetrics display;
        /* renamed from: ip */
        private String f24793ip;
        /* renamed from: jb */
        int f24794jb;
        String language;
        String manufacture;
        String model;
        String operator;
        int osVersion;
        String packageName;
        private String ramInfo;
        private String romInfo;
        /* renamed from: sd */
        String f24795sd;
        String sdkVersion;
        String timezone;

        private BasicEnv(Context context) {
            this.sdkVersion = String.valueOf(4.07f);
            this.osVersion = VERSION.SDK_INT;
            this.model = Build.MODEL;
            this.manufacture = Build.MANUFACTURER;
            this.language = Locale.getDefault().getLanguage();
            this.f24794jb = 0;
            this.packageName = null;
            this.ctx = null;
            this.allSensors = null;
            this.cpuInfo = null;
            this.ramInfo = null;
            this.romInfo = null;
            this.f24793ip = null;
            this.ctx = context;
            this.display = DeviceInfos.getDisplayMetrics(context);
            this.appVersion = StatCommonHelper.getCurAppVersion(context);
            this.operator = CustomDeviceInfos.getSimOperator(context);
            this.timezone = TimeZone.getDefault().getID();
            this.f24794jb = DeviceInfos.hasRootAccess(context);
            this.f24795sd = DeviceInfos.getExternalStorageInfo(context);
            this.packageName = context.getPackageName();
            if (this.osVersion >= 14) {
                this.allSensors = DeviceInfos.getSensorsString(context);
            }
            this.cpuInfo = DeviceInfos.getCpuInfo(context).toString();
            this.ramInfo = DeviceInfos.getSystemMemory(context);
            this.romInfo = DeviceInfos.getRomMemory();
            this.f24793ip = CustomDeviceInfos.getIp(context);
        }

        /* access modifiers changed from: 0000 */
        public void encode(JSONObject jSONObject) throws JSONException {
            StringBuilder sb = new StringBuilder();
            sb.append(this.display.widthPixels);
            sb.append(Marker.ANY_MARKER);
            sb.append(this.display.heightPixels);
            jSONObject.put("sr", sb.toString());
            Util.jsonPut(jSONObject, "av", this.appVersion);
            Util.jsonPut(jSONObject, "ch", this.channel);
            Util.jsonPut(jSONObject, "mf", this.manufacture);
            Util.jsonPut(jSONObject, "sv", this.sdkVersion);
            Util.jsonPut(jSONObject, "ov", Integer.toString(this.osVersion));
            jSONObject.put("os", 1);
            Util.jsonPut(jSONObject, "op", this.operator);
            Util.jsonPut(jSONObject, "lg", this.language);
            Util.jsonPut(jSONObject, "md", this.model);
            Util.jsonPut(jSONObject, "tz", this.timezone);
            int i = this.f24794jb;
            if (i != 0) {
                jSONObject.put("jb", i);
            }
            Util.jsonPut(jSONObject, "sd", this.f24795sd);
            Util.jsonPut(jSONObject, "apn", this.packageName);
            if (Util.isNetworkAvailable(this.ctx) && DeviceInfos.isWifiNet(this.ctx)) {
                JSONObject jSONObject2 = new JSONObject();
                Util.jsonPut(jSONObject2, "bs", CustomDeviceInfos.getWiFiBBSID(this.ctx));
                Util.jsonPut(jSONObject2, "ss", CustomDeviceInfos.getWiFiSSID(this.ctx));
                if (jSONObject2.length() > 0) {
                    Util.jsonPut(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray wifiTopN = CustomDeviceInfos.getWifiTopN(this.ctx, 10);
            if (wifiTopN != null && wifiTopN.length() > 0) {
                Util.jsonPut(jSONObject, "wflist", wifiTopN.toString());
            }
            JSONArray sensorsJson = DeviceInfos.getSensorsJson(this.ctx);
            if (sensorsJson != null && sensorsJson.length() > 0) {
                Util.jsonPut(jSONObject, "sslist", sensorsJson.toString());
            }
            Util.jsonPut(jSONObject, "sen", this.allSensors);
            Util.jsonPut(jSONObject, "cpu", this.cpuInfo);
            Util.jsonPut(jSONObject, "ram", this.ramInfo);
            Util.jsonPut(jSONObject, "rom", this.romInfo);
            Util.jsonPut(jSONObject, "ciip", this.f24793ip);
        }
    }

    public static void appendEnvAttr(Context context, Map<String, String> map) throws JSONException {
        if (map != null) {
            HashMap hashMap = new HashMap(map);
            if (attr_json == null) {
                attr_json = new JSONObject();
            }
            for (Entry entry : hashMap.entrySet()) {
                attr_json.put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    static synchronized BasicEnv getBasicEnv(Context context) {
        BasicEnv basicEnv2;
        synchronized (Env.class) {
            if (basicEnv == null) {
                basicEnv = new BasicEnv(context.getApplicationContext());
            }
            basicEnv2 = basicEnv;
        }
        return basicEnv2;
    }

    public Env(Context context) {
        try {
            getBasicEnv(context);
            this.tel_network = DeviceInfos.getTelephonyNetworkType(context.getApplicationContext());
            this.conn = DeviceInfos.getLinkedWay(context);
        } catch (Throwable th) {
            logger.mo35696e(th);
        }
    }

    public void encode(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (basicEnv != null) {
                basicEnv.encode(jSONObject2);
            }
            Util.jsonPut(jSONObject2, "cn", this.conn);
            if (this.tel_network != null) {
                jSONObject2.put("tn", this.tel_network);
            }
            jSONObject.put("ev", jSONObject2);
            if (attr_json != null && attr_json.length() > 0) {
                jSONObject.put("eva", attr_json);
            }
        } catch (Throwable th) {
            logger.mo35696e(th);
        }
    }
}
