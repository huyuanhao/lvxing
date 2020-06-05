package com.p522qq.p523e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.constants.LoadAdParams */
public class LoadAdParams {
    /* renamed from: a */
    private int f20168a;
    /* renamed from: b */
    private LoginType f20169b;
    /* renamed from: c */
    private String f20170c;
    /* renamed from: d */
    private String f20171d;
    /* renamed from: e */
    private String f20172e;
    /* renamed from: f */
    private int f20173f;
    /* renamed from: g */
    private String f20174g;
    /* renamed from: h */
    private Map f20175h;
    /* renamed from: i */
    private boolean f20176i;
    /* renamed from: j */
    private JSONObject f20177j;

    public int getBlockEffectValue() {
        return this.f20173f;
    }

    public JSONObject getExtraInfo() {
        return this.f20177j;
    }

    public int getFlowSourceId() {
        return this.f20168a;
    }

    public String getLoginAppId() {
        return this.f20170c;
    }

    public String getLoginOpenid() {
        return this.f20171d;
    }

    public LoginType getLoginType() {
        return this.f20169b;
    }

    public Map getPassThroughInfo() {
        return this.f20175h;
    }

    public String getPassThroughInfoJsonString() {
        String str = null;
        try {
            if (this.f20175h != null && this.f20175h.size() > 0) {
                str = new JSONObject(this.f20175h).toString();
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUin() {
        return this.f20172e;
    }

    public String getWXAppId() {
        return this.f20174g;
    }

    public boolean isHotStart() {
        return this.f20176i;
    }

    public void setBlockEffectValue(int i) {
        this.f20173f = i;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f20177j = jSONObject;
    }

    public void setFlowSourceId(int i) {
        this.f20168a = i;
    }

    public void setHotStart(boolean z) {
        this.f20176i = z;
    }

    public void setLoginAppId(String str) {
        this.f20170c = str;
    }

    public void setLoginOpenid(String str) {
        this.f20171d = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f20169b = loginType;
    }

    public void setPassThroughInfo(Map map) {
        this.f20175h = map;
    }

    public void setUin(String str) {
        this.f20172e = str;
    }

    public void setWXAppId(String str) {
        this.f20174g = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LoadAdParams{flowSourceId=");
        sb.append(this.f20168a);
        sb.append(", loginType=");
        sb.append(this.f20169b);
        sb.append(", loginAppId=");
        sb.append(this.f20170c);
        sb.append(", loginOpenid=");
        sb.append(this.f20171d);
        sb.append(", uin=");
        sb.append(this.f20172e);
        sb.append(", blockEffect=");
        sb.append(this.f20173f);
        sb.append(", passThroughInfo=");
        sb.append(this.f20175h);
        sb.append(", extraInfo=");
        sb.append(this.f20177j);
        sb.append('}');
        return sb.toString();
    }
}
