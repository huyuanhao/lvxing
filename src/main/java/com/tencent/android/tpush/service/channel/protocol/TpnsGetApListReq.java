package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsGetApListReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static NetworkInfo cache_netInfo = new NetworkInfo();
    public NetworkInfo netInfo = null;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsGetApListReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsGetApListReq";
    }

    public NetworkInfo getNetInfo() {
        return this.netInfo;
    }

    public void setNetInfo(NetworkInfo networkInfo) {
        this.netInfo = networkInfo;
    }

    public TpnsGetApListReq() {
    }

    public TpnsGetApListReq(NetworkInfo networkInfo) {
        this.netInfo = networkInfo;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.netInfo, (Object) ((TpnsGetApListReq) obj).netInfo);
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
        jceOutputStream.write((JceStruct) this.netInfo, 0);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.netInfo = (NetworkInfo) jceInputStream.read((JceStruct) cache_netInfo, 0, true);
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display((JceStruct) this.netInfo, "netInfo");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((JceStruct) this.netInfo, false);
    }
}
