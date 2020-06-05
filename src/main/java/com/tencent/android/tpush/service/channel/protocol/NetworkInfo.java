package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class NetworkInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* renamed from: ip */
    public int f23398ip = 0;
    public byte network = 0;
    /* renamed from: op */
    public byte f23399op = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.NetworkInfo";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.NetworkInfo";
    }

    public int getIp() {
        return this.f23398ip;
    }

    public void setIp(int i) {
        this.f23398ip = i;
    }

    public byte getNetwork() {
        return this.network;
    }

    public void setNetwork(byte b) {
        this.network = b;
    }

    public byte getOp() {
        return this.f23399op;
    }

    public void setOp(byte b) {
        this.f23399op = b;
    }

    public NetworkInfo() {
    }

    public NetworkInfo(int i, byte b, byte b2) {
        this.f23398ip = i;
        this.network = b;
        this.f23399op = b2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        NetworkInfo networkInfo = (NetworkInfo) obj;
        if (JceUtil.equals(this.f23398ip, networkInfo.f23398ip) && JceUtil.equals(this.network, networkInfo.network) && JceUtil.equals(this.f23399op, networkInfo.f23399op)) {
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
        jceOutputStream.write(this.f23398ip, 0);
        jceOutputStream.write(this.network, 1);
        jceOutputStream.write(this.f23399op, 2);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f23398ip = jceInputStream.read(this.f23398ip, 0, true);
        this.network = jceInputStream.read(this.network, 1, true);
        this.f23399op = jceInputStream.read(this.f23399op, 2, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f23398ip, "ip");
        jceDisplayer.display(this.network, "network");
        jceDisplayer.display(this.f23399op, "op");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f23398ip, true);
        jceDisplayer.displaySimple(this.network, true);
        jceDisplayer.displaySimple(this.f23399op, false);
    }
}
