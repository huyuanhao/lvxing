package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.C */
public final class C7494C extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7494C.class.desiredAssertionStatus());
    /* renamed from: Mb */
    static ArrayList<C7525y> f25104Mb = new ArrayList<>();
    /* renamed from: Nb */
    public ArrayList<C7525y> f25105Nb = null;
    /* renamed from: ma */
    public int f25106ma = 0;

    static {
        f25104Mb.add(new C7525y());
    }

    public C7494C() {
    }

    public C7494C(int i, ArrayList<C7525y> arrayList) {
        this.f25106ma = i;
        this.f25105Nb = arrayList;
    }

    /* renamed from: F */
    public int mo36526F() {
        return this.f25106ma;
    }

    /* renamed from: Ja */
    public ArrayList<C7525y> mo36527Ja() {
        return this.f25105Nb;
    }

    public String className() {
        return "ADV.SCGDTSDKAdReport";
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
        jceDisplayer.display(this.f25106ma, KEYS.RET);
        jceDisplayer.display((Collection<T>) this.f25105Nb, "vecItemReportResult");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25106ma, true);
        jceDisplayer.displaySimple((Collection<T>) this.f25105Nb, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7494C c = (C7494C) obj;
        if (JceUtil.equals(this.f25106ma, c.f25106ma) && JceUtil.equals((Object) this.f25105Nb, (Object) c.f25105Nb)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.SCGDTSDKAdReport";
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
    public void mo36533i(ArrayList<C7525y> arrayList) {
        this.f25105Nb = arrayList;
    }

    /* renamed from: m */
    public void mo36534m(int i) {
        this.f25106ma = i;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25106ma = jceInputStream.read(this.f25106ma, 0, true);
        this.f25105Nb = (ArrayList) jceInputStream.read(f25104Mb, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25106ma, 0);
        ArrayList<C7525y> arrayList = this.f25105Nb;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
