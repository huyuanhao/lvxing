package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsGetApListRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ApList cache_apList = new ApList();
    public ApList apList = null;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsGetApListRsp";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsGetApListRsp";
    }

    public ApList getApList() {
        return this.apList;
    }

    public void setApList(ApList apList2) {
        this.apList = apList2;
    }

    public TpnsGetApListRsp() {
    }

    public TpnsGetApListRsp(ApList apList2) {
        this.apList = apList2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.apList, (Object) ((TpnsGetApListRsp) obj).apList);
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
        jceOutputStream.write((JceStruct) this.apList, 0);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.apList = (ApList) jceInputStream.read((JceStruct) cache_apList, 0, true);
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display((JceStruct) this.apList, "apList");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((JceStruct) this.apList, false);
    }
}
