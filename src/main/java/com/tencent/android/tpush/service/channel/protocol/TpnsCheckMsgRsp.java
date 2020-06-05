package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* compiled from: ProGuard */
public final class TpnsCheckMsgRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public short result = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsCheckMsgRsp";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsCheckMsgRsp";
    }

    public short getResult() {
        return this.result;
    }

    public void setResult(short s) {
        this.result = s;
    }

    public TpnsCheckMsgRsp() {
    }

    public TpnsCheckMsgRsp(short s) {
        this.result = s;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.result, ((TpnsCheckMsgRsp) obj).result);
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
        jceOutputStream.write(this.result, 0);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display(this.result, ArgKey.KEY_RESULT);
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple(this.result, false);
    }
}
