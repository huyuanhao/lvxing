package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGPushRegisterResult implements XGIResult {
    /* renamed from: a */
    long f22807a = 0;
    /* renamed from: b */
    String f22808b;
    /* renamed from: c */
    String f22809c;
    /* renamed from: d */
    String f22810d;
    /* renamed from: e */
    short f22811e;
    /* renamed from: f */
    String f22812f;
    /* renamed from: g */
    String f22813g;
    /* renamed from: h */
    int f22814h;

    public long getAccessId() {
        return this.f22807a;
    }

    public String getDeviceId() {
        return this.f22808b;
    }

    public String getAccount() {
        return this.f22809c;
    }

    public String getTicket() {
        return this.f22810d;
    }

    public short getTicketType() {
        return this.f22811e;
    }

    public String getToken() {
        return this.f22812f;
    }

    public String getOtherPushToken() {
        return this.f22813g;
    }

    public int getPushChannel() {
        return this.f22814h;
    }

    XGPushRegisterResult() {
        String str = "";
        this.f22808b = str;
        this.f22809c = str;
        this.f22810d = str;
        this.f22811e = 0;
        this.f22812f = str;
        this.f22813g = str;
        this.f22814h = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPushRegisterMessage [accessId=");
        sb.append(this.f22807a);
        sb.append(", deviceId=");
        sb.append(this.f22808b);
        sb.append(", account=");
        sb.append(this.f22809c);
        sb.append(", ticket=");
        sb.append(this.f22810d);
        sb.append(", ticketType=");
        sb.append(this.f22811e);
        sb.append(", token=");
        sb.append(this.f22812f);
        sb.append("]");
        return sb.toString();
    }

    public void parseIntent(Intent intent) {
        try {
            this.f22807a = intent.getLongExtra("accId", -1);
            this.f22808b = intent.getStringExtra(Constants.FLAG_DEVICE_ID);
            this.f22809c = intent.getStringExtra("account");
            this.f22810d = intent.getStringExtra(Constants.FLAG_TICKET);
            this.f22811e = intent.getShortExtra(Constants.FLAG_TICKET_TYPE, 0);
            this.f22812f = intent.getStringExtra("token");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account", this.f22809c);
            jSONObject.put(Constants.FLAG_TICKET, this.f22810d);
            jSONObject.put(Constants.FLAG_DEVICE_ID, this.f22808b);
            jSONObject.put(Constants.FLAG_TICKET_TYPE, this.f22811e);
            jSONObject.put("token", this.f22812f);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
