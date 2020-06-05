package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.u */
public final class C7521u extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7521u.class.desiredAssertionStatus());
    /* renamed from: fb */
    static C7522v f25260fb = new C7522v();
    /* renamed from: gb */
    static C7522v f25261gb = new C7522v();
    /* renamed from: hb */
    static C7522v f25262hb = new C7522v();
    /* renamed from: ib */
    static C7522v f25263ib = new C7522v();
    /* renamed from: jb */
    static C7522v f25264jb = new C7522v();
    /* renamed from: kb */
    static C7522v f25265kb = new C7522v();
    /* renamed from: lb */
    static C7522v f25266lb = new C7522v();
    /* renamed from: mb */
    static C7522v f25267mb = new C7522v();
    /* renamed from: nb */
    static C7522v f25268nb = new C7522v();
    /* renamed from: ob */
    static C7522v f25269ob = new C7522v();
    /* renamed from: pb */
    static C7522v f25270pb = new C7522v();
    /* renamed from: Ab */
    public C7522v f25271Ab = null;
    /* renamed from: Bb */
    public C7522v f25272Bb = null;
    /* renamed from: qb */
    public C7522v f25273qb = null;
    /* renamed from: rb */
    public C7522v f25274rb = null;
    /* renamed from: tb */
    public C7522v f25275tb = null;
    /* renamed from: ub */
    public C7522v f25276ub = null;
    /* renamed from: vb */
    public C7522v f25277vb = null;
    /* renamed from: wb */
    public C7522v f25278wb = null;
    /* renamed from: xb */
    public C7522v f25279xb = null;
    /* renamed from: yb */
    public C7522v f25280yb = null;
    /* renamed from: zb */
    public C7522v f25281zb = null;

    public C7521u() {
    }

    public C7521u(C7522v vVar, C7522v vVar2, C7522v vVar3, C7522v vVar4, C7522v vVar5, C7522v vVar6, C7522v vVar7, C7522v vVar8, C7522v vVar9, C7522v vVar10, C7522v vVar11) {
        this.f25273qb = vVar;
        this.f25274rb = vVar2;
        this.f25275tb = vVar3;
        this.f25276ub = vVar4;
        this.f25277vb = vVar5;
        this.f25278wb = vVar6;
        this.f25279xb = vVar7;
        this.f25280yb = vVar8;
        this.f25281zb = vVar9;
        this.f25271Ab = vVar10;
        this.f25272Bb = vVar11;
    }

    /* renamed from: Aa */
    public C7522v mo36819Aa() {
        return this.f25271Ab;
    }

    /* renamed from: Ba */
    public C7522v mo36820Ba() {
        return this.f25278wb;
    }

    /* renamed from: Ca */
    public C7522v mo36821Ca() {
        return this.f25279xb;
    }

    /* renamed from: b */
    public void mo36822b(C7522v vVar) {
        this.f25274rb = vVar;
    }

    /* renamed from: c */
    public void mo36823c(C7522v vVar) {
        this.f25277vb = vVar;
    }

    public String className() {
        return "ADV.ExternalEventTracking";
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
    public void mo36826d(C7522v vVar) {
        this.f25273qb = vVar;
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display((JceStruct) this.f25273qb, "exposure");
        jceDisplayer.display((JceStruct) this.f25274rb, "click");
        jceDisplayer.display((JceStruct) this.f25275tb, "startDownload");
        jceDisplayer.display((JceStruct) this.f25276ub, "finishDownload");
        jceDisplayer.display((JceStruct) this.f25277vb, "close");
        jceDisplayer.display((JceStruct) this.f25278wb, "videoPlayBegin");
        jceDisplayer.display((JceStruct) this.f25279xb, "videoPlayEnd");
        jceDisplayer.display((JceStruct) this.f25280yb, "videoPlay25");
        jceDisplayer.display((JceStruct) this.f25281zb, "videoPlay50");
        jceDisplayer.display((JceStruct) this.f25271Ab, "videoPlay75");
        jceDisplayer.display((JceStruct) this.f25272Bb, "finishInstall");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple((JceStruct) this.f25273qb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25274rb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25275tb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25276ub, true);
        jceDisplayer.displaySimple((JceStruct) this.f25277vb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25278wb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25279xb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25280yb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25281zb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25271Ab, true);
        jceDisplayer.displaySimple((JceStruct) this.f25272Bb, false);
    }

    /* renamed from: e */
    public void mo36827e(C7522v vVar) {
        this.f25276ub = vVar;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7521u uVar = (C7521u) obj;
        if (JceUtil.equals((Object) this.f25273qb, (Object) uVar.f25273qb) && JceUtil.equals((Object) this.f25274rb, (Object) uVar.f25274rb) && JceUtil.equals((Object) this.f25275tb, (Object) uVar.f25275tb) && JceUtil.equals((Object) this.f25276ub, (Object) uVar.f25276ub) && JceUtil.equals((Object) this.f25277vb, (Object) uVar.f25277vb) && JceUtil.equals((Object) this.f25278wb, (Object) uVar.f25278wb) && JceUtil.equals((Object) this.f25279xb, (Object) uVar.f25279xb) && JceUtil.equals((Object) this.f25280yb, (Object) uVar.f25280yb) && JceUtil.equals((Object) this.f25281zb, (Object) uVar.f25281zb) && JceUtil.equals((Object) this.f25271Ab, (Object) uVar.f25271Ab) && JceUtil.equals((Object) this.f25272Bb, (Object) uVar.f25272Bb)) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public void mo36829f(C7522v vVar) {
        this.f25272Bb = vVar;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.ExternalEventTracking";
    }

    /* renamed from: g */
    public void mo36831g(C7522v vVar) {
        this.f25275tb = vVar;
    }

    /* renamed from: h */
    public void mo36832h(C7522v vVar) {
        this.f25280yb = vVar;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: i */
    public void mo36834i(C7522v vVar) {
        this.f25281zb = vVar;
    }

    /* renamed from: j */
    public void mo36835j(C7522v vVar) {
        this.f25271Ab = vVar;
    }

    /* renamed from: k */
    public void mo36836k(C7522v vVar) {
        this.f25278wb = vVar;
    }

    /* renamed from: l */
    public void mo36837l(C7522v vVar) {
        this.f25279xb = vVar;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25273qb = (C7522v) jceInputStream.read((JceStruct) f25260fb, 0, false);
        this.f25274rb = (C7522v) jceInputStream.read((JceStruct) f25261gb, 1, false);
        this.f25275tb = (C7522v) jceInputStream.read((JceStruct) f25262hb, 2, false);
        this.f25276ub = (C7522v) jceInputStream.read((JceStruct) f25263ib, 3, false);
        this.f25277vb = (C7522v) jceInputStream.read((JceStruct) f25264jb, 4, false);
        this.f25278wb = (C7522v) jceInputStream.read((JceStruct) f25265kb, 5, false);
        this.f25279xb = (C7522v) jceInputStream.read((JceStruct) f25266lb, 6, false);
        this.f25280yb = (C7522v) jceInputStream.read((JceStruct) f25267mb, 7, false);
        this.f25281zb = (C7522v) jceInputStream.read((JceStruct) f25268nb, 8, false);
        this.f25271Ab = (C7522v) jceInputStream.read((JceStruct) f25269ob, 9, false);
        this.f25272Bb = (C7522v) jceInputStream.read((JceStruct) f25270pb, 10, false);
    }

    /* renamed from: sa */
    public C7522v mo36838sa() {
        return this.f25274rb;
    }

    /* renamed from: ta */
    public C7522v mo36839ta() {
        return this.f25277vb;
    }

    /* renamed from: ua */
    public C7522v mo36840ua() {
        return this.f25273qb;
    }

    /* renamed from: va */
    public C7522v mo36841va() {
        return this.f25276ub;
    }

    /* renamed from: wa */
    public C7522v mo36842wa() {
        return this.f25272Bb;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        C7522v vVar = this.f25273qb;
        if (vVar != null) {
            jceOutputStream.write((JceStruct) vVar, 0);
        }
        C7522v vVar2 = this.f25274rb;
        if (vVar2 != null) {
            jceOutputStream.write((JceStruct) vVar2, 1);
        }
        C7522v vVar3 = this.f25275tb;
        if (vVar3 != null) {
            jceOutputStream.write((JceStruct) vVar3, 2);
        }
        C7522v vVar4 = this.f25276ub;
        if (vVar4 != null) {
            jceOutputStream.write((JceStruct) vVar4, 3);
        }
        C7522v vVar5 = this.f25277vb;
        if (vVar5 != null) {
            jceOutputStream.write((JceStruct) vVar5, 4);
        }
        C7522v vVar6 = this.f25278wb;
        if (vVar6 != null) {
            jceOutputStream.write((JceStruct) vVar6, 5);
        }
        C7522v vVar7 = this.f25279xb;
        if (vVar7 != null) {
            jceOutputStream.write((JceStruct) vVar7, 6);
        }
        C7522v vVar8 = this.f25280yb;
        if (vVar8 != null) {
            jceOutputStream.write((JceStruct) vVar8, 7);
        }
        C7522v vVar9 = this.f25281zb;
        if (vVar9 != null) {
            jceOutputStream.write((JceStruct) vVar9, 8);
        }
        C7522v vVar10 = this.f25271Ab;
        if (vVar10 != null) {
            jceOutputStream.write((JceStruct) vVar10, 9);
        }
        C7522v vVar11 = this.f25272Bb;
        if (vVar11 != null) {
            jceOutputStream.write((JceStruct) vVar11, 10);
        }
    }

    /* renamed from: xa */
    public C7522v mo36843xa() {
        return this.f25275tb;
    }

    /* renamed from: ya */
    public C7522v mo36844ya() {
        return this.f25280yb;
    }

    /* renamed from: za */
    public C7522v mo36845za() {
        return this.f25281zb;
    }
}
