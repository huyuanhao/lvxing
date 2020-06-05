package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsRedirectReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public byte network = 0;
    /* renamed from: op */
    public byte f23401op = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsRedirectReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsRedirectReq";
    }

    public byte getNetwork() {
        return this.network;
    }

    public void setNetwork(byte b) {
        this.network = b;
    }

    public byte getOp() {
        return this.f23401op;
    }

    public void setOp(byte b) {
        this.f23401op = b;
    }

    public TpnsRedirectReq() {
    }

    public TpnsRedirectReq(byte b, byte b2) {
        this.network = b;
        this.f23401op = b2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsRedirectReq tpnsRedirectReq = (TpnsRedirectReq) obj;
        if (JceUtil.equals(this.network, tpnsRedirectReq.network) && JceUtil.equals(this.f23401op, tpnsRedirectReq.f23401op)) {
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
        jceOutputStream.write(this.network, 0);
        jceOutputStream.write(this.f23401op, 1);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.network = jceInputStream.read(this.network, 0, false);
        this.f23401op = jceInputStream.read(this.f23401op, 1, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.network, "network");
        jceDisplayer.display(this.f23401op, "op");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.network, true);
        jceDisplayer.displaySimple(this.f23401op, false);
    }
}
