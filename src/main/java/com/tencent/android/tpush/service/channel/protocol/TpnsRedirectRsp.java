package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsRedirectRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* renamed from: ip */
    public long f23402ip = 0;
    public int port = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsRedirectRsp";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsRedirectRsp";
    }

    public long getIp() {
        return this.f23402ip;
    }

    public void setIp(long j) {
        this.f23402ip = j;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public TpnsRedirectRsp() {
    }

    public TpnsRedirectRsp(long j, int i) {
        this.f23402ip = j;
        this.port = i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsRedirectRsp tpnsRedirectRsp = (TpnsRedirectRsp) obj;
        if (JceUtil.equals(this.f23402ip, tpnsRedirectRsp.f23402ip) && JceUtil.equals(this.port, tpnsRedirectRsp.port)) {
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
        jceOutputStream.write(this.f23402ip, 0);
        jceOutputStream.write(this.port, 1);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f23402ip = jceInputStream.read(this.f23402ip, 0, false);
        this.port = jceInputStream.read(this.port, 1, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f23402ip, "ip");
        jceDisplayer.display(this.port, "port");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f23402ip, true);
        jceDisplayer.displaySimple(this.port, false);
    }
}
