package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.H */
public final class C7499H extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7499H.class.desiredAssertionStatus());
    /* renamed from: Sb */
    static C7504d f25119Sb = new C7504d();
    /* renamed from: Tb */
    static ArrayList<C7526z> f25120Tb = new ArrayList<>();
    /* renamed from: Ub */
    public C7504d f25121Ub = null;
    /* renamed from: Vb */
    public ArrayList<C7526z> f25122Vb = null;
    /* renamed from: Wb */
    public int f25123Wb = -1;
    /* renamed from: Xb */
    public int f25124Xb = -1;
    /* renamed from: Yb */
    public int f25125Yb = 0;
    public int percentSpent = 0;

    static {
        f25120Tb.add(new C7526z());
    }

    public C7499H() {
    }

    public C7499H(C7504d dVar, ArrayList<C7526z> arrayList, int i, int i2, int i3, int i4) {
        this.f25121Ub = dVar;
        this.f25122Vb = arrayList;
        this.percentSpent = i;
        this.f25123Wb = i2;
        this.f25124Xb = i3;
        this.f25125Yb = i4;
    }

    /* renamed from: C */
    public void mo36592C(int i) {
        this.f25124Xb = i;
    }

    /* renamed from: D */
    public void mo36593D(int i) {
        this.f25123Wb = i;
    }

    /* renamed from: E */
    public void mo36594E(int i) {
        this.f25125Yb = i;
    }

    /* renamed from: F */
    public void mo36595F(int i) {
        this.percentSpent = i;
    }

    /* renamed from: Ma */
    public C7504d mo36596Ma() {
        return this.f25121Ub;
    }

    /* renamed from: Na */
    public int mo36597Na() {
        return this.f25124Xb;
    }

    /* renamed from: Oa */
    public int mo36598Oa() {
        return this.f25123Wb;
    }

    /* renamed from: Pa */
    public int mo36599Pa() {
        return this.f25125Yb;
    }

    /* renamed from: Qa */
    public int mo36600Qa() {
        return this.percentSpent;
    }

    /* renamed from: Ra */
    public ArrayList<C7526z> mo36601Ra() {
        return this.f25122Vb;
    }

    /* renamed from: a */
    public void mo36602a(C7504d dVar) {
        this.f25121Ub = dVar;
    }

    public String className() {
        return "ADV.SecureAdvertise";
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
        jceDisplayer.display((JceStruct) this.f25121Ub, "advertise");
        jceDisplayer.display((Collection<T>) this.f25122Vb, "vecNotifyBars");
        jceDisplayer.display(this.percentSpent, "percentSpent");
        jceDisplayer.display(this.f25123Wb, "displayMaxTimes");
        jceDisplayer.display(this.f25124Xb, "clickMaxTimes");
        jceDisplayer.display(this.f25125Yb, "displayStartTime");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple((JceStruct) this.f25121Ub, true);
        jceDisplayer.displaySimple((Collection<T>) this.f25122Vb, true);
        jceDisplayer.displaySimple(this.percentSpent, true);
        jceDisplayer.displaySimple(this.f25123Wb, true);
        jceDisplayer.displaySimple(this.f25124Xb, true);
        jceDisplayer.displaySimple(this.f25125Yb, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7499H h = (C7499H) obj;
        if (JceUtil.equals((Object) this.f25121Ub, (Object) h.f25121Ub) && JceUtil.equals((Object) this.f25122Vb, (Object) h.f25122Vb) && JceUtil.equals(this.percentSpent, h.percentSpent) && JceUtil.equals(this.f25123Wb, h.f25123Wb) && JceUtil.equals(this.f25124Xb, h.f25124Xb) && JceUtil.equals(this.f25125Yb, h.f25125Yb)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.SecureAdvertise";
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: l */
    public void mo36608l(ArrayList<C7526z> arrayList) {
        this.f25122Vb = arrayList;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25121Ub = (C7504d) jceInputStream.read((JceStruct) f25119Sb, 0, false);
        this.f25122Vb = (ArrayList) jceInputStream.read(f25120Tb, 1, false);
        this.percentSpent = jceInputStream.read(this.percentSpent, 2, false);
        this.f25123Wb = jceInputStream.read(this.f25123Wb, 3, false);
        this.f25124Xb = jceInputStream.read(this.f25124Xb, 4, false);
        this.f25125Yb = jceInputStream.read(this.f25125Yb, 5, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        C7504d dVar = this.f25121Ub;
        if (dVar != null) {
            jceOutputStream.write((JceStruct) dVar, 0);
        }
        ArrayList<C7526z> arrayList = this.f25122Vb;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
        jceOutputStream.write(this.percentSpent, 2);
        jceOutputStream.write(this.f25123Wb, 3);
        jceOutputStream.write(this.f25124Xb, 4);
        jceOutputStream.write(this.f25125Yb, 5);
    }
}
