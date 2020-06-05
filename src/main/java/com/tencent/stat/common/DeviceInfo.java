package com.tencent.stat.common;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfo {
    public static final int NEW_USER = 0;
    public static final int OLD_USER = 1;
    public static final String TAG_ANDROID_ID = "aid";
    public static final String TAG_FLAG = "__MTA_DEVICE_INFO__";
    public static final String TAG_IMEI = "ui";
    public static final String TAG_MAC = "mc";
    public static final String TAG_MID = "mid";
    public static final String TAG_TIMESTAMPS = "ts";
    public static final String TAG_VERSION = "ver";
    public static final int UPGRADE_USER = 2;
    /* renamed from: a */
    private String f25608a = null;
    /* renamed from: b */
    private String f25609b = null;
    /* renamed from: c */
    private String f25610c = null;
    /* renamed from: d */
    private String f25611d = "0";
    /* renamed from: e */
    private int f25612e;
    /* renamed from: f */
    private int f25613f = 0;
    /* renamed from: g */
    private long f25614g = 0;

    public DeviceInfo() {
    }

    public DeviceInfo(String str, String str2, int i) {
        this.f25608a = str;
        this.f25609b = str2;
        this.f25612e = i;
    }

    public String toString() {
        return mo37093a().toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo37093a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Util.jsonPut(jSONObject, TAG_IMEI, this.f25608a);
            Util.jsonPut(jSONObject, TAG_MAC, this.f25609b);
            Util.jsonPut(jSONObject, "mid", this.f25611d);
            Util.jsonPut(jSONObject, TAG_ANDROID_ID, this.f25610c);
            jSONObject.put("ts", this.f25614g);
            jSONObject.put("ver", this.f25613f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getMid() {
        return this.f25611d;
    }

    public String getImei() {
        return this.f25608a;
    }

    public String getMac() {
        return this.f25609b;
    }

    public void setUserType(int i) {
        this.f25612e = i;
    }

    public int getUserType() {
        return this.f25612e;
    }
}
