package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.b */
public final class C7502b extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7502b.class.desiredAssertionStatus());
    /* renamed from: da */
    static ArrayList<Integer> f25137da = new ArrayList<>();
    /* renamed from: ea */
    static int f25138ea = 0;
    /* renamed from: fa */
    static Map<Integer, String> f25139fa = new HashMap();
    public int advNum = 0;
    public int businessType = 0;
    /* renamed from: ga */
    public ArrayList<Integer> f25140ga = null;
    /* renamed from: ha */
    public String f25141ha = "";
    /* renamed from: ia */
    public Map<Integer, String> f25142ia = null;
    /* renamed from: ja */
    public double f25143ja = 0.0d;
    /* renamed from: ka */
    public double f25144ka = 0.0d;
    public int positionId = 0;

    static {
        Integer valueOf = Integer.valueOf(0);
        f25137da.add(valueOf);
        f25139fa.put(valueOf, "");
    }

    public C7502b() {
    }

    public C7502b(int i, int i2, ArrayList<Integer> arrayList, String str, int i3, Map<Integer, String> map, double d, double d2) {
        this.positionId = i;
        this.advNum = i2;
        this.f25140ga = arrayList;
        this.f25141ha = str;
        this.businessType = i3;
        this.f25142ia = map;
        this.f25143ja = d;
        this.f25144ka = d2;
    }

    /* renamed from: A */
    public String mo36643A() {
        return this.f25141ha;
    }

    /* renamed from: B */
    public int mo36644B() {
        return this.advNum;
    }

    /* renamed from: C */
    public int mo36645C() {
        return this.businessType;
    }

    /* renamed from: D */
    public ArrayList<Integer> mo36646D() {
        return this.f25140ga;
    }

    /* renamed from: b */
    public void mo36647b(ArrayList<Integer> arrayList) {
        this.f25140ga = arrayList;
    }

    /* renamed from: c */
    public void mo36648c(Map<Integer, String> map) {
        this.f25142ia = map;
    }

    public String className() {
        return "ADV.AdvPositonReq";
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
        jceDisplayer.display(this.positionId, "positionId");
        jceDisplayer.display(this.advNum, "advNum");
        jceDisplayer.display((Collection<T>) this.f25140ga, "vecPositionFormatTypes");
        jceDisplayer.display(this.f25141ha, "advKeyWord");
        jceDisplayer.display(this.businessType, "businessType");
        jceDisplayer.display(this.f25142ia, "additionalParam");
        jceDisplayer.display(this.f25143ja, "longitude");
        jceDisplayer.display(this.f25144ka, "latitude");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.positionId, true);
        jceDisplayer.displaySimple(this.advNum, true);
        jceDisplayer.displaySimple((Collection<T>) this.f25140ga, true);
        jceDisplayer.displaySimple(this.f25141ha, true);
        jceDisplayer.displaySimple(this.businessType, true);
        jceDisplayer.displaySimple(this.f25142ia, true);
        jceDisplayer.displaySimple(this.f25143ja, true);
        jceDisplayer.displaySimple(this.f25144ka, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7502b bVar = (C7502b) obj;
        if (JceUtil.equals(this.positionId, bVar.positionId) && JceUtil.equals(this.advNum, bVar.advNum) && JceUtil.equals((Object) this.f25140ga, (Object) bVar.f25140ga) && JceUtil.equals((Object) this.f25141ha, (Object) bVar.f25141ha) && JceUtil.equals(this.businessType, bVar.businessType) && JceUtil.equals((Object) this.f25142ia, (Object) bVar.f25142ia) && JceUtil.equals(this.f25143ja, bVar.f25143ja) && JceUtil.equals(this.f25144ka, bVar.f25144ka)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.AdvPositonReq";
    }

    public double getLatitude() {
        return this.f25144ka;
    }

    public double getLongitude() {
        return this.f25143ja;
    }

    public int getPositionId() {
        return this.positionId;
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
    public void mo36657j(int i) {
        this.positionId = i;
    }

    /* renamed from: k */
    public void mo36658k(int i) {
        this.advNum = i;
    }

    /* renamed from: l */
    public void mo36659l(int i) {
        this.businessType = i;
    }

    /* renamed from: o */
    public void mo36660o(String str) {
        this.f25141ha = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.positionId = jceInputStream.read(this.positionId, 0, false);
        this.advNum = jceInputStream.read(this.advNum, 1, false);
        this.f25140ga = (ArrayList) jceInputStream.read(f25137da, 2, false);
        this.f25141ha = jceInputStream.readString(3, false);
        this.businessType = jceInputStream.read(this.businessType, 4, false);
        this.f25142ia = (Map) jceInputStream.read(f25139fa, 5, false);
        this.f25143ja = jceInputStream.read(this.f25143ja, 6, false);
        this.f25144ka = jceInputStream.read(this.f25144ka, 7, false);
    }

    public void setLatitude(double d) {
        this.f25144ka = d;
    }

    public void setLongitude(double d) {
        this.f25143ja = d;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.positionId, 0);
        jceOutputStream.write(this.advNum, 1);
        ArrayList<Integer> arrayList = this.f25140ga;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 2);
        }
        String str = this.f25141ha;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.businessType, 4);
        Map<Integer, String> map = this.f25142ia;
        if (map != null) {
            jceOutputStream.write(map, 5);
        }
        jceOutputStream.write(this.f25143ja, 6);
        jceOutputStream.write(this.f25144ka, 7);
    }

    /* renamed from: z */
    public Map<Integer, String> mo36663z() {
        return this.f25142ia;
    }
}
