package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.B */
public final class C7493B extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7493B.class.desiredAssertionStatus());
    /* renamed from: ma */
    public int f25103ma = 0;

    public C7493B() {
    }

    public C7493B(int i) {
        this.f25103ma = i;
    }

    /* renamed from: F */
    public int mo36519F() {
        return this.f25103ma;
    }

    public String className() {
        return "ADV.SCAdReport";
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
        new JceDisplayer(sb, i).display(this.f25103ma, KEYS.RET);
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple(this.f25103ma, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.f25103ma, ((C7493B) obj).f25103ma);
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.SCAdReport";
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
    public void mo36525m(int i) {
        this.f25103ma = i;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25103ma = jceInputStream.read(this.f25103ma, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25103ma, 0);
    }
}
