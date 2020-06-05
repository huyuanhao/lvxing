package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsConfigRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String confContent = "";
    public long confVersion = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsConfigRsp";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsConfigRsp";
    }

    public long getConfVersion() {
        return this.confVersion;
    }

    public void setConfVersion(long j) {
        this.confVersion = j;
    }

    public String getConfContent() {
        return this.confContent;
    }

    public void setConfContent(String str) {
        this.confContent = str;
    }

    public TpnsConfigRsp() {
    }

    public TpnsConfigRsp(long j, String str) {
        this.confVersion = j;
        this.confContent = str;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsConfigRsp tpnsConfigRsp = (TpnsConfigRsp) obj;
        if (JceUtil.equals(this.confVersion, tpnsConfigRsp.confVersion) && JceUtil.equals((Object) this.confContent, (Object) tpnsConfigRsp.confContent)) {
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
        jceOutputStream.write(this.confVersion, 0);
        jceOutputStream.write(this.confContent, 1);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.confVersion = jceInputStream.read(this.confVersion, 0, true);
        this.confContent = jceInputStream.readString(1, true);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.confVersion, "confVersion");
        jceDisplayer.display(this.confContent, "confContent");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.confVersion, true);
        jceDisplayer.displaySimple(this.confContent, false);
    }
}
