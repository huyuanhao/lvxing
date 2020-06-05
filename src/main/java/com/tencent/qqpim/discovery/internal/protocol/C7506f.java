package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.f */
public final class C7506f extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7506f.class.desiredAssertionStatus());
    /* renamed from: Ca */
    static ArrayList<GDTSDKReportItem> f25161Ca = new ArrayList<>();
    /* renamed from: Da */
    public ArrayList<GDTSDKReportItem> f25162Da = null;

    static {
        f25161Ca.add(new GDTSDKReportItem());
    }

    public C7506f() {
    }

    public C7506f(ArrayList<GDTSDKReportItem> arrayList) {
        this.f25162Da = arrayList;
    }

    /* renamed from: N */
    public ArrayList<GDTSDKReportItem> mo36707N() {
        return this.f25162Da;
    }

    public String className() {
        return "ADV.CSGDTSDKAdReport";
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
        new JceDisplayer(sb, i).display((Collection<T>) this.f25162Da, "vecAdItem");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((Collection<T>) this.f25162Da, false);
    }

    /* renamed from: e */
    public void mo36710e(ArrayList<GDTSDKReportItem> arrayList) {
        this.f25162Da = arrayList;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.f25162Da, (Object) ((C7506f) obj).f25162Da);
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.CSGDTSDKAdReport";
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
        this.f25162Da = (ArrayList) jceInputStream.read(f25161Ca, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<GDTSDKReportItem> arrayList = this.f25162Da;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
    }
}
