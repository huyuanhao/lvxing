package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.F */
public final class C7497F extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7497F.class.desiredAssertionStatus());
    /* renamed from: Ob */
    static ArrayList<C7498G> f25111Ob = new ArrayList<>();
    /* renamed from: Pb */
    public ArrayList<C7498G> f25112Pb = null;

    static {
        f25111Ob.add(new C7498G());
    }

    public C7497F() {
    }

    public C7497F(ArrayList<C7498G> arrayList) {
        this.f25112Pb = arrayList;
    }

    /* renamed from: Ka */
    public ArrayList<C7498G> mo36549Ka() {
        return this.f25112Pb;
    }

    public String className() {
        return "ADV.SCPushSecureAdvertise";
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
        new JceDisplayer(sb, i).display((Collection<T>) this.f25112Pb, "vecAdvPositonResp");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((Collection<T>) this.f25112Pb, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.f25112Pb, (Object) ((C7497F) obj).f25112Pb);
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.SCPushSecureAdvertise";
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
    public void mo36555j(ArrayList<C7498G> arrayList) {
        this.f25112Pb = arrayList;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25112Pb = (ArrayList) jceInputStream.read(f25111Ob, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<C7498G> arrayList = this.f25112Pb;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
    }
}
