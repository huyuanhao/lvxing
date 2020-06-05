package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.D */
public final class C7495D extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7495D.class.desiredAssertionStatus());
    /* renamed from: Ob */
    static ArrayList<C7503c> f25107Ob = new ArrayList<>();
    /* renamed from: Pb */
    public ArrayList<C7503c> f25108Pb = null;

    static {
        f25107Ob.add(new C7503c());
    }

    public C7495D() {
    }

    public C7495D(ArrayList<C7503c> arrayList) {
        this.f25108Pb = arrayList;
    }

    /* renamed from: Ka */
    public ArrayList<C7503c> mo36535Ka() {
        return this.f25108Pb;
    }

    public String className() {
        return "ADV.SCGetAdvertise";
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
        new JceDisplayer(sb, i).display((Collection<T>) this.f25108Pb, "vecAdvPositonResp");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((Collection<T>) this.f25108Pb, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.f25108Pb, (Object) ((C7495D) obj).f25108Pb);
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.SCGetAdvertise";
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
    public void mo36541j(ArrayList<C7503c> arrayList) {
        this.f25108Pb = arrayList;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25108Pb = (ArrayList) jceInputStream.read(f25107Ob, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<C7503c> arrayList = this.f25108Pb;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
    }
}
