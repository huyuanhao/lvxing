package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.I */
public final class C7500I extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7500I.class.desiredAssertionStatus());
    /* renamed from: Zb */
    public long f25126Zb = 0;
    /* renamed from: _b */
    public boolean f25127_b = true;
    /* renamed from: ac */
    public long f25128ac = 0;
    /* renamed from: bc */
    public boolean f25129bc = true;

    public C7500I() {
    }

    public C7500I(long j, boolean z, long j2, boolean z2) {
        this.f25126Zb = j;
        this.f25127_b = z;
        this.f25128ac = j2;
        this.f25129bc = z2;
    }

    /* renamed from: Sa */
    public boolean mo36609Sa() {
        return this.f25127_b;
    }

    /* renamed from: Ta */
    public long mo36610Ta() {
        return this.f25126Zb;
    }

    /* renamed from: Ua */
    public boolean mo36611Ua() {
        return this.f25129bc;
    }

    /* renamed from: Va */
    public long mo36612Va() {
        return this.f25128ac;
    }

    public String className() {
        return "ADV.VideoDisplayInfo";
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
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f25126Zb, "bt");
        jceDisplayer.display(this.f25127_b, "bf");
        jceDisplayer.display(this.f25128ac, "et");
        jceDisplayer.display(this.f25129bc, "ef");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25126Zb, true);
        jceDisplayer.displaySimple(this.f25127_b, true);
        jceDisplayer.displaySimple(this.f25128ac, true);
        jceDisplayer.displaySimple(this.f25129bc, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7500I i = (C7500I) obj;
        if (JceUtil.equals(this.f25126Zb, i.f25126Zb) && JceUtil.equals(this.f25127_b, i.f25127_b) && JceUtil.equals(this.f25128ac, i.f25128ac) && JceUtil.equals(this.f25129bc, i.f25129bc)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.VideoDisplayInfo";
    }

    /* renamed from: g */
    public void mo36617g(boolean z) {
        this.f25127_b = z;
    }

    /* renamed from: h */
    public void mo36618h(boolean z) {
        this.f25129bc = z;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: k */
    public void mo36620k(long j) {
        this.f25126Zb = j;
    }

    /* renamed from: l */
    public void mo36621l(long j) {
        this.f25128ac = j;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25126Zb = jceInputStream.read(this.f25126Zb, 0, false);
        this.f25127_b = jceInputStream.read(this.f25127_b, 1, false);
        this.f25128ac = jceInputStream.read(this.f25128ac, 2, false);
        this.f25129bc = jceInputStream.read(this.f25129bc, 3, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25126Zb, 0);
        jceOutputStream.write(this.f25127_b, 1);
        jceOutputStream.write(this.f25128ac, 2);
        jceOutputStream.write(this.f25129bc, 3);
    }
}
