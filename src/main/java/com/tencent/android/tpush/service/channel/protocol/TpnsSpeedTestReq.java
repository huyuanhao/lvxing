package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsSpeedTestReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public byte padding = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsSpeedTestReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsSpeedTestReq";
    }

    public byte getPadding() {
        return this.padding;
    }

    public void setPadding(byte b) {
        this.padding = b;
    }

    public TpnsSpeedTestReq() {
    }

    public TpnsSpeedTestReq(byte b) {
        this.padding = b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.padding, ((TpnsSpeedTestReq) obj).padding);
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
        jceOutputStream.write(this.padding, 0);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.padding = jceInputStream.read(this.padding, 0, true);
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display(this.padding, "padding");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple(this.padding, false);
    }
}
