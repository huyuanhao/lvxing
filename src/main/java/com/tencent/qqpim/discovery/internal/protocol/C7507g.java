package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.g */
public final class C7507g extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7507g.class.desiredAssertionStatus());
    /* renamed from: Ea */
    static ArrayList<C7502b> f25163Ea = new ArrayList<>();
    /* renamed from: Fa */
    public ArrayList<C7502b> f25164Fa = null;
    /* renamed from: Ga */
    public boolean f25165Ga = false;

    static {
        f25163Ea.add(new C7502b());
    }

    public C7507g() {
    }

    public C7507g(ArrayList<C7502b> arrayList, boolean z) {
        this.f25164Fa = arrayList;
        this.f25165Ga = z;
    }

    /* renamed from: O */
    public boolean mo36714O() {
        return this.f25165Ga;
    }

    /* renamed from: P */
    public ArrayList<C7502b> mo36715P() {
        return this.f25164Fa;
    }

    /* renamed from: b */
    public void mo36716b(boolean z) {
        this.f25165Ga = z;
    }

    public String className() {
        return "ADV.CSGetAdvertise";
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
        jceDisplayer.display((Collection<T>) this.f25164Fa, "vecAdvPositionReq");
        jceDisplayer.display(this.f25165Ga, "isAdvance");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple((Collection<T>) this.f25164Fa, true);
        jceDisplayer.displaySimple(this.f25165Ga, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7507g gVar = (C7507g) obj;
        if (JceUtil.equals((Object) this.f25164Fa, (Object) gVar.f25164Fa) && JceUtil.equals(this.f25165Ga, gVar.f25165Ga)) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public void mo36720f(ArrayList<C7502b> arrayList) {
        this.f25164Fa = arrayList;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.CSGetAdvertise";
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
        this.f25164Fa = (ArrayList) jceInputStream.read(f25163Ea, 0, false);
        this.f25165Ga = jceInputStream.read(this.f25165Ga, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<C7502b> arrayList = this.f25164Fa;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
        jceOutputStream.write(this.f25165Ga, 1);
    }
}
