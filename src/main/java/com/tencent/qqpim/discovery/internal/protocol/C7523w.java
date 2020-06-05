package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.w */
public final class C7523w extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7523w.class.desiredAssertionStatus());
    /* renamed from: Eb */
    public String f25284Eb = "";
    public int type = 0;

    public C7523w() {
    }

    public C7523w(int i, String str) {
        this.type = i;
        this.f25284Eb = str;
    }

    /* renamed from: Da */
    public String mo36853Da() {
        return this.f25284Eb;
    }

    /* renamed from: E */
    public void mo36854E(String str) {
        this.f25284Eb = str;
    }

    public String className() {
        return "ADV.ExtraData";
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
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.f25284Eb, "dynamicJson");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.f25284Eb, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7523w wVar = (C7523w) obj;
        if (JceUtil.equals(this.type, wVar.type) && JceUtil.equals((Object) this.f25284Eb, (Object) wVar.f25284Eb)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.ExtraData";
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.f25284Eb = jceInputStream.readString(1, false);
    }

    public void setType(int i) {
        this.type = i;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.f25284Eb;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }
}
