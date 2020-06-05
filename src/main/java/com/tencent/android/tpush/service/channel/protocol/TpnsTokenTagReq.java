package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* compiled from: ProGuard */
public final class TpnsTokenTagReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public long accessId = 0;
    public int flag = 0;
    public String tag = "";

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsTokenTagReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsTokenTagReq";
    }

    public long getAccessId() {
        return this.accessId;
    }

    public void setAccessId(long j) {
        this.accessId = j;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public TpnsTokenTagReq() {
    }

    public TpnsTokenTagReq(long j, String str, int i) {
        this.accessId = j;
        this.tag = str;
        this.flag = i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsTokenTagReq tpnsTokenTagReq = (TpnsTokenTagReq) obj;
        if (JceUtil.equals(this.accessId, tpnsTokenTagReq.accessId) && JceUtil.equals((Object) this.tag, (Object) tpnsTokenTagReq.tag) && JceUtil.equals(this.flag, tpnsTokenTagReq.flag)) {
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
        jceOutputStream.write(this.tag, 1);
        jceOutputStream.write(this.flag, 2);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.accessId = jceInputStream.read(this.accessId, 0, true);
        this.tag = jceInputStream.readString(1, true);
        this.flag = jceInputStream.read(this.flag, 2, true);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.accessId, "accessId");
        jceDisplayer.display(this.tag, "tag");
        jceDisplayer.display(this.flag, "flag");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.accessId, true);
        jceDisplayer.displaySimple(this.tag, true);
        jceDisplayer.displaySimple(this.flag, false);
    }
}
