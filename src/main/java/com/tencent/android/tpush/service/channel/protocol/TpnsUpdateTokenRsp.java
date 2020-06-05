package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* compiled from: ProGuard */
public final class TpnsUpdateTokenRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public byte result = 0;
    public String token = "";

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsUpdateTokenRsp";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsUpdateTokenRsp";
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public byte getResult() {
        return this.result;
    }

    public void setResult(byte b) {
        this.result = b;
    }

    public TpnsUpdateTokenRsp() {
    }

    public TpnsUpdateTokenRsp(String str, byte b) {
        this.token = str;
        this.result = b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsUpdateTokenRsp tpnsUpdateTokenRsp = (TpnsUpdateTokenRsp) obj;
        if (JceUtil.equals((Object) this.token, (Object) tpnsUpdateTokenRsp.token) && JceUtil.equals(this.result, tpnsUpdateTokenRsp.result)) {
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
        jceOutputStream.write(this.token, 0);
        jceOutputStream.write(this.result, 1);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.token = jceInputStream.readString(0, true);
        this.result = jceInputStream.read(this.result, 1, true);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.token, "token");
        jceDisplayer.display(this.result, ArgKey.KEY_RESULT);
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.token, true);
        jceDisplayer.displaySimple(this.result, false);
    }
}
