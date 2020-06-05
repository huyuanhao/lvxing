package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.x */
public final class C7524x extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7524x.class.desiredAssertionStatus());
    /* renamed from: Fb */
    static int f25285Fb = 0;
    /* renamed from: Gb */
    public boolean f25286Gb = false;
    /* renamed from: Hb */
    public String f25287Hb;
    /* renamed from: Ib */
    public int f25288Ib;
    public String appId;
    public int requestTimeout;
    /* renamed from: sa */
    public long f25289sa;
    public int sdkType = 0;

    public C7524x() {
        String str = "";
        this.appId = str;
        this.f25287Hb = str;
        this.f25288Ib = 0;
        this.f25289sa = 0;
        this.requestTimeout = 0;
    }

    public C7524x(boolean z, int i, String str, String str2, int i2, long j, int i3) {
        String str3 = "";
        this.appId = str3;
        this.f25287Hb = str3;
        this.f25288Ib = 0;
        this.f25289sa = 0;
        this.requestTimeout = 0;
        this.f25286Gb = z;
        this.sdkType = i;
        this.appId = str;
        this.f25287Hb = str2;
        this.f25288Ib = i2;
        this.f25289sa = j;
        this.requestTimeout = i3;
    }

    /* renamed from: A */
    public void mo36862A(int i) {
        this.sdkType = i;
    }

    /* renamed from: Ea */
    public int mo36863Ea() {
        return this.f25288Ib;
    }

    /* renamed from: F */
    public void mo36864F(String str) {
        this.f25287Hb = str;
    }

    /* renamed from: Fa */
    public String mo36865Fa() {
        return this.f25287Hb;
    }

    /* renamed from: Ga */
    public int mo36866Ga() {
        return this.sdkType;
    }

    /* renamed from: Ha */
    public boolean mo36867Ha() {
        return this.f25286Gb;
    }

    /* renamed from: K */
    public long mo36868K() {
        return this.f25289sa;
    }

    public String className() {
        return "ADV.GDTSDKInfo";
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
        jceDisplayer.display(this.f25286Gb, "shouldRequireGDTSDK");
        jceDisplayer.display(this.sdkType, "sdkType");
        jceDisplayer.display(this.appId, "appId");
        jceDisplayer.display(this.f25287Hb, "gdtPosId");
        jceDisplayer.display(this.f25288Ib, "gdtPosAmount");
        jceDisplayer.display(this.f25289sa, "expireTime");
        jceDisplayer.display(this.requestTimeout, "requestTimeout");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25286Gb, true);
        jceDisplayer.displaySimple(this.sdkType, true);
        jceDisplayer.displaySimple(this.appId, true);
        jceDisplayer.displaySimple(this.f25287Hb, true);
        jceDisplayer.displaySimple(this.f25288Ib, true);
        jceDisplayer.displaySimple(this.f25289sa, true);
        jceDisplayer.displaySimple(this.requestTimeout, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7524x xVar = (C7524x) obj;
        if (JceUtil.equals(this.f25286Gb, xVar.f25286Gb) && JceUtil.equals(this.sdkType, xVar.sdkType) && JceUtil.equals((Object) this.appId, (Object) xVar.appId) && JceUtil.equals((Object) this.f25287Hb, (Object) xVar.f25287Hb) && JceUtil.equals(this.f25288Ib, xVar.f25288Ib) && JceUtil.equals(this.f25289sa, xVar.f25289sa) && JceUtil.equals(this.requestTimeout, xVar.requestTimeout)) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public void mo36872f(boolean z) {
        this.f25286Gb = z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.GDTSDKInfo";
    }

    public String getAppId() {
        return this.appId;
    }

    public int getRequestTimeout() {
        return this.requestTimeout;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: j */
    public void mo36877j(long j) {
        this.f25289sa = j;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25286Gb = jceInputStream.read(this.f25286Gb, 0, true);
        this.sdkType = jceInputStream.read(this.sdkType, 1, true);
        this.appId = jceInputStream.readString(2, false);
        this.f25287Hb = jceInputStream.readString(3, false);
        this.f25288Ib = jceInputStream.read(this.f25288Ib, 4, false);
        this.f25289sa = jceInputStream.read(this.f25289sa, 5, false);
        this.requestTimeout = jceInputStream.read(this.requestTimeout, 6, false);
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setRequestTimeout(int i) {
        this.requestTimeout = i;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25286Gb, 0);
        jceOutputStream.write(this.sdkType, 1);
        String str = this.appId;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.f25287Hb;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.f25288Ib, 4);
        jceOutputStream.write(this.f25289sa, 5);
        jceOutputStream.write(this.requestTimeout, 6);
    }

    /* renamed from: z */
    public void mo36880z(int i) {
        this.f25288Ib = i;
    }
}
