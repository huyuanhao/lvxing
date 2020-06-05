package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.z */
public final class C7526z extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7526z.class.desiredAssertionStatus());
    /* renamed from: Kb */
    static int f25291Kb = 0;
    /* renamed from: Lb */
    public int f25292Lb = 0;
    public String text = "";

    public C7526z() {
    }

    public C7526z(int i, String str) {
        this.f25292Lb = i;
        this.text = str;
    }

    /* renamed from: B */
    public void mo36888B(int i) {
        this.f25292Lb = i;
    }

    /* renamed from: Ia */
    public int mo36889Ia() {
        return this.f25292Lb;
    }

    public String className() {
        return "ADV.NotifyBar";
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
        jceDisplayer.display(this.f25292Lb, "notifyBarType");
        jceDisplayer.display(this.text, "text");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25292Lb, true);
        jceDisplayer.displaySimple(this.text, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7526z zVar = (C7526z) obj;
        if (JceUtil.equals(this.f25292Lb, zVar.f25292Lb) && JceUtil.equals((Object) this.text, (Object) zVar.text)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.NotifyBar";
    }

    public String getText() {
        return this.text;
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
        this.f25292Lb = jceInputStream.read(this.f25292Lb, 0, false);
        this.text = jceInputStream.readString(1, false);
    }

    public void setText(String str) {
        this.text = str;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25292Lb, 0);
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }
}
