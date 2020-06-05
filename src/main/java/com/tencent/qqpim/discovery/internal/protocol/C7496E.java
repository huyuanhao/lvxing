package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.E */
public final class C7496E extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7496E.class.desiredAssertionStatus());
    /* renamed from: Ob */
    static ArrayList<C7498G> f25109Ob = new ArrayList<>();
    /* renamed from: Pb */
    public ArrayList<C7498G> f25110Pb = null;

    static {
        f25109Ob.add(new C7498G());
    }

    public C7496E() {
    }

    public C7496E(ArrayList<C7498G> arrayList) {
        this.f25110Pb = arrayList;
    }

    /* renamed from: Ka */
    public ArrayList<C7498G> mo36542Ka() {
        return this.f25110Pb;
    }

    public String className() {
        return "ADV.SCGetSecureAdvertise";
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
        new JceDisplayer(sb, i).display((Collection<T>) this.f25110Pb, "vecAdvPositonResp");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((Collection<T>) this.f25110Pb, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.f25110Pb, (Object) ((C7496E) obj).f25110Pb);
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.SCGetSecureAdvertise";
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
    public void mo36548j(ArrayList<C7498G> arrayList) {
        this.f25110Pb = arrayList;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25110Pb = (ArrayList) jceInputStream.read(f25109Ob, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<C7498G> arrayList = this.f25110Pb;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
    }
}
