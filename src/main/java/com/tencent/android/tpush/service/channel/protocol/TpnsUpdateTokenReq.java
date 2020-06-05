package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsUpdateTokenReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public long accessId = 0;
    public String externalToken;
    public String token;
    public String type;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsUpdateTokenReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsUpdateTokenReq";
    }

    public long getAccessId() {
        return this.accessId;
    }

    public void setAccessId(long j) {
        this.accessId = j;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getExternalToken() {
        return this.externalToken;
    }

    public void setExternalToken(String str) {
        this.externalToken = str;
    }

    public TpnsUpdateTokenReq() {
        String str = "";
        this.token = str;
        this.type = str;
        this.externalToken = str;
    }

    public TpnsUpdateTokenReq(long j, String str, String str2, String str3) {
        String str4 = "";
        this.token = str4;
        this.type = str4;
        this.externalToken = str4;
        this.accessId = j;
        this.token = str;
        this.type = str2;
        this.externalToken = str3;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsUpdateTokenReq tpnsUpdateTokenReq = (TpnsUpdateTokenReq) obj;
        if (JceUtil.equals(this.accessId, tpnsUpdateTokenReq.accessId) && JceUtil.equals((Object) this.token, (Object) tpnsUpdateTokenReq.token) && JceUtil.equals((Object) this.type, (Object) tpnsUpdateTokenReq.type) && JceUtil.equals((Object) this.externalToken, (Object) tpnsUpdateTokenReq.externalToken)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.accessId, 0);
        jceOutputStream.write(this.token, 1);
        jceOutputStream.write(this.type, 2);
        jceOutputStream.write(this.externalToken, 3);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.accessId = jceInputStream.read(this.accessId, 0, true);
        this.token = jceInputStream.readString(1, true);
        this.type = jceInputStream.readString(2, true);
        this.externalToken = jceInputStream.readString(3, true);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.accessId, "accessId");
        jceDisplayer.display(this.token, "token");
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.externalToken, "externalToken");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.accessId, true);
        jceDisplayer.displaySimple(this.token, true);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.externalToken, false);
    }
}
