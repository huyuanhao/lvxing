package com.tencent.stat;

import org.json.JSONException;
import org.json.JSONObject;

public class NetworkMonitor {
    /* renamed from: a */
    private long f25303a = 0;
    /* renamed from: b */
    private int f25304b = 0;
    /* renamed from: c */
    private String f25305c;
    /* renamed from: d */
    private int f25306d;
    /* renamed from: e */
    private String f25307e;

    public NetworkMonitor() {
        String str = "";
        this.f25305c = str;
        this.f25306d = 0;
        this.f25307e = str;
    }

    public long getMillisecondsConsume() {
        return this.f25303a;
    }

    public void setMillisecondsConsume(long j) {
        this.f25303a = j;
    }

    public int getStatusCode() {
        return this.f25304b;
    }

    public void setStatusCode(int i) {
        this.f25304b = i;
    }

    public String getDomain() {
        return this.f25305c;
    }

    public void setDomain(String str) {
        this.f25305c = str;
    }

    public int getPort() {
        return this.f25306d;
    }

    public void setPort(int i) {
        this.f25306d = i;
    }

    public String getRemoteIp() {
        return this.f25307e;
    }

    public void setRemoteIp(String str) {
        this.f25307e = str;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f25303a);
            jSONObject.put("st", this.f25304b);
            if (this.f25305c != null) {
                jSONObject.put("dm", this.f25305c);
            }
            jSONObject.put("pt", this.f25306d);
            if (this.f25307e != null) {
                jSONObject.put("rip", this.f25307e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
