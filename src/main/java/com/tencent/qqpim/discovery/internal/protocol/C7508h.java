package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.mid.api.MidEntity;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.h */
public final class C7508h extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7508h.class.desiredAssertionStatus());
    /* renamed from: Ea */
    static ArrayList<C7502b> f25166Ea = new ArrayList<>();
    /* renamed from: Aa */
    public String f25167Aa = "";
    /* renamed from: Ba */
    public int f25168Ba = 0;
    /* renamed from: Fa */
    public ArrayList<C7502b> f25169Fa = null;
    /* renamed from: Ga */
    public boolean f25170Ga = false;
    /* renamed from: Ha */
    public boolean f25171Ha = false;

    static {
        f25166Ea.add(new C7502b());
    }

    public C7508h() {
    }

    public C7508h(ArrayList<C7502b> arrayList, boolean z, boolean z2, int i, String str) {
        this.f25169Fa = arrayList;
        this.f25170Ga = z;
        this.f25171Ha = z2;
        this.f25168Ba = i;
        this.f25167Aa = str;
    }

    /* renamed from: O */
    public boolean mo36723O() {
        return this.f25170Ga;
    }

    /* renamed from: P */
    public ArrayList<C7502b> mo36724P() {
        return this.f25169Fa;
    }

    /* renamed from: Q */
    public boolean mo36725Q() {
        return this.f25171Ha;
    }

    /* renamed from: b */
    public void mo36726b(boolean z) {
        this.f25170Ga = z;
    }

    /* renamed from: c */
    public void mo36727c(boolean z) {
        this.f25171Ha = z;
    }

    public String className() {
        return "ADV.CSGetSecureAdvertise";
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
        jceDisplayer.display((Collection<T>) this.f25169Fa, "vecAdvPositionReq");
        jceDisplayer.display(this.f25170Ga, "isAdvance");
        jceDisplayer.display(this.f25171Ha, "isSupportDeepLink");
        jceDisplayer.display(this.f25168Ba, "productId");
        jceDisplayer.display(this.f25167Aa, MidEntity.TAG_IMEI);
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple((Collection<T>) this.f25169Fa, true);
        jceDisplayer.displaySimple(this.f25170Ga, true);
        jceDisplayer.displaySimple(this.f25171Ha, true);
        jceDisplayer.displaySimple(this.f25168Ba, true);
        jceDisplayer.displaySimple(this.f25167Aa, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7508h hVar = (C7508h) obj;
        if (JceUtil.equals((Object) this.f25169Fa, (Object) hVar.f25169Fa) && JceUtil.equals(this.f25170Ga, hVar.f25170Ga) && JceUtil.equals(this.f25171Ha, hVar.f25171Ha) && JceUtil.equals(this.f25168Ba, hVar.f25168Ba) && JceUtil.equals((Object) this.f25167Aa, (Object) hVar.f25167Aa)) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public void mo36731f(ArrayList<C7502b> arrayList) {
        this.f25169Fa = arrayList;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.CSGetSecureAdvertise";
    }

    public String getImei() {
        return this.f25167Aa;
    }

    public int getProductId() {
        return this.f25168Ba;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: o */
    public void mo36736o(int i) {
        this.f25168Ba = i;
    }

    /* renamed from: q */
    public void mo36737q(String str) {
        this.f25167Aa = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25169Fa = (ArrayList) jceInputStream.read(f25166Ea, 0, false);
        this.f25170Ga = jceInputStream.read(this.f25170Ga, 1, false);
        this.f25171Ha = jceInputStream.read(this.f25171Ha, 2, false);
        this.f25168Ba = jceInputStream.read(this.f25168Ba, 3, false);
        this.f25167Aa = jceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<C7502b> arrayList = this.f25169Fa;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
        jceOutputStream.write(this.f25170Ga, 1);
        jceOutputStream.write(this.f25171Ha, 2);
        jceOutputStream.write(this.f25168Ba, 3);
        String str = this.f25167Aa;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }
}
