package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.mid.api.MidEntity;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.e */
public final class C7505e extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7505e.class.desiredAssertionStatus());
    /* renamed from: ya */
    static ArrayList<C7501a> f25157ya = new ArrayList<>();
    /* renamed from: Aa */
    public String f25158Aa = "";
    /* renamed from: Ba */
    public int f25159Ba = 0;
    /* renamed from: za */
    public ArrayList<C7501a> f25160za = null;

    static {
        f25157ya.add(new C7501a());
    }

    public C7505e() {
    }

    public C7505e(ArrayList<C7501a> arrayList, String str, int i) {
        this.f25160za = arrayList;
        this.f25158Aa = str;
        this.f25159Ba = i;
    }

    /* renamed from: M */
    public ArrayList<C7501a> mo36696M() {
        return this.f25160za;
    }

    public String className() {
        return "ADV.CSAdReport";
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

    /* renamed from: d */
    public void mo36699d(ArrayList<C7501a> arrayList) {
        this.f25160za = arrayList;
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display((Collection<T>) this.f25160za, "vecAdReportItem");
        jceDisplayer.display(this.f25158Aa, MidEntity.TAG_IMEI);
        jceDisplayer.display(this.f25159Ba, "productId");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple((Collection<T>) this.f25160za, true);
        jceDisplayer.displaySimple(this.f25158Aa, true);
        jceDisplayer.displaySimple(this.f25159Ba, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7505e eVar = (C7505e) obj;
        if (JceUtil.equals((Object) this.f25160za, (Object) eVar.f25160za) && JceUtil.equals((Object) this.f25158Aa, (Object) eVar.f25158Aa) && JceUtil.equals(this.f25159Ba, eVar.f25159Ba)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.CSAdReport";
    }

    public String getImei() {
        return this.f25158Aa;
    }

    public int getProductId() {
        return this.f25159Ba;
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
    public void mo36705o(int i) {
        this.f25159Ba = i;
    }

    /* renamed from: q */
    public void mo36706q(String str) {
        this.f25158Aa = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25160za = (ArrayList) jceInputStream.read(f25157ya, 0, false);
        this.f25158Aa = jceInputStream.readString(1, false);
        this.f25159Ba = jceInputStream.read(this.f25159Ba, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<C7501a> arrayList = this.f25160za;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
        String str = this.f25158Aa;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.f25159Ba, 2);
    }
}
