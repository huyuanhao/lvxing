package com.tencent.stat;

import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class StatAccount {
    public static final int CUSTOM_TYPE = 7;
    public static final int DEFAULT_TYPE = 0;
    public static final int EMAIL_TYPE = 6;
    public static final int PHONE_NUM_TYPE = 5;
    public static final int QQ_NUM_TYPE = 1;
    public static final int QQ_OPENID_TYPE = 3;
    public static final int WECHAT_ID_TYPE = 2;
    public static final int WECHAT_OPENID_TYPE = 4;
    /* renamed from: a */
    private String f25308a;
    /* renamed from: b */
    private int f25309b = 0;
    /* renamed from: c */
    private String f25310c;
    /* renamed from: d */
    private String f25311d;

    public StatAccount(String str) {
        String str2 = "";
        this.f25308a = str2;
        this.f25310c = str2;
        this.f25311d = str2;
        this.f25308a = str;
    }

    public StatAccount(String str, int i) {
        String str2 = "";
        this.f25308a = str2;
        this.f25310c = str2;
        this.f25311d = str2;
        this.f25308a = str;
        this.f25309b = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatAccount [account=");
        sb.append(this.f25308a);
        sb.append(", accountType=");
        sb.append(this.f25309b);
        sb.append(", ext=");
        sb.append(this.f25310c);
        sb.append(", ext1=");
        sb.append(this.f25311d);
        sb.append("]");
        return sb.toString();
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        if (StatCommonHelper.isStringValid(this.f25308a)) {
            try {
                Util.jsonPut(jSONObject, "a", this.f25308a);
                jSONObject.put("t", this.f25309b);
                Util.jsonPut(jSONObject, "e", this.f25310c);
                Util.jsonPut(jSONObject, "e1", this.f25311d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String getAccount() {
        return this.f25308a;
    }

    public void setAccount(String str) {
        this.f25308a = str;
    }

    public int getAccountType() {
        return this.f25309b;
    }

    public void setAccountType(int i) {
        this.f25309b = i;
    }

    public String getExt() {
        return this.f25310c;
    }

    public void setExt(String str) {
        this.f25310c = str;
    }

    public String getExt1() {
        return this.f25311d;
    }

    public void setExt1(String str) {
        this.f25311d = str;
    }
}
