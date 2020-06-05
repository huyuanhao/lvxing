package com.tencent.mid.api;

import com.tencent.mid.util.Logger;
import com.tencent.mid.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class MidEntity {
    public static final String TAG_GUID = "guid";
    public static final String TAG_IMEI = "imei";
    public static final String TAG_IMSI = "imsi";
    public static final String TAG_MAC = "mac";
    public static final String TAG_MID = "mid";
    public static final String TAG_TIMESTAMPS = "ts";
    public static final String TAG_VER = "ver";
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_NEW = 2;
    private static Logger logger = Util.getLogger();
    private long guid = 0;
    private String imei = null;
    private String imsi = null;
    private String mac = null;
    private String mid = "0";
    private long timestamps = 0;
    private int version = 0;

    public long getGuid() {
        return this.guid;
    }

    public void setGuid(long j) {
        this.guid = j;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public long getTimestamps() {
        return this.timestamps;
    }

    public void setTimestamps(long j) {
        this.timestamps = j;
    }

    public boolean isMidValid() {
        return Util.isMidValid(this.mid);
    }

    /* access modifiers changed from: 0000 */
    public void update(String str) {
        setMid(str);
    }

    public static MidEntity parse(String str) {
        String str2 = "guid";
        String str3 = "ver";
        String str4 = "ts";
        String str5 = "mid";
        String str6 = TAG_MAC;
        String str7 = "imsi";
        String str8 = TAG_IMEI;
        MidEntity midEntity = new MidEntity();
        if (Util.isStringValid(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(str8)) {
                    midEntity.setImei(jSONObject.getString(str8));
                }
                if (!jSONObject.isNull(str7)) {
                    midEntity.setImsi(jSONObject.getString(str7));
                }
                if (!jSONObject.isNull(str6)) {
                    midEntity.setMac(jSONObject.getString(str6));
                }
                if (!jSONObject.isNull(str5)) {
                    midEntity.setMid(jSONObject.getString(str5));
                }
                if (!jSONObject.isNull(str4)) {
                    midEntity.setTimestamps(jSONObject.getLong(str4));
                }
                if (!jSONObject.isNull(str3)) {
                    midEntity.version = jSONObject.optInt(str3, 0);
                }
                if (!jSONObject.isNull(str2)) {
                    midEntity.guid = jSONObject.optLong(str2, 0);
                }
            } catch (JSONException e) {
                logger.mo35708w(e.toString());
            }
        }
        return midEntity;
    }

    public int compairTo(MidEntity midEntity) {
        int i = 1;
        if (midEntity == null) {
            return 1;
        }
        if (!isMidValid() || !midEntity.isMidValid()) {
            if (!isMidValid()) {
                i = -1;
            }
            return i;
        } else if (this.mid.equals(midEntity.mid)) {
            return 0;
        } else {
            if (this.timestamps < midEntity.timestamps) {
                i = -1;
            }
            return i;
        }
    }

    public String toString() {
        return encode().toString();
    }

    /* access modifiers changed from: 0000 */
    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            Util.jsonPut(jSONObject, TAG_IMEI, this.imei);
            Util.jsonPut(jSONObject, "imsi", this.imsi);
            Util.jsonPut(jSONObject, TAG_MAC, this.mac);
            Util.jsonPut(jSONObject, "mid", this.mid);
            try {
                jSONObject.put("guid", this.guid);
            } catch (Throwable unused) {
            }
            jSONObject.put("ts", this.timestamps);
        } catch (JSONException e) {
            logger.mo35708w(e.toString());
        }
        return jSONObject;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public String getImsi() {
        return this.imsi;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String str) {
        this.mac = str;
    }
}
