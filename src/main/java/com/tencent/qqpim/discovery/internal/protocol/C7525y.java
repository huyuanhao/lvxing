package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.y */
public final class C7525y extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7525y.class.desiredAssertionStatus());
    /* renamed from: ma */
    public int f25290ma = 0;

    public C7525y() {
    }

    public C7525y(int i) {
        this.f25290ma = i;
    }

    /* renamed from: F */
    public int mo36881F() {
        return this.f25290ma;
    }

    public String className() {
        return "ADV.GDTSDKReportItemResult";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display(this.f25290ma, KEYS.RET);
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple(this.f25290ma, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.f25290ma, ((C7525y) obj).f25290ma);
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.GDTSDKReportItemResult";
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: m */
    public void mo36887m(int i) {
        this.f25290ma = i;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25290ma = jceInputStream.read(this.f25290ma, 0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25290ma, 0);
    }
}
