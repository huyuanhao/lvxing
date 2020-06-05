package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.v */
public final class C7522v extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7522v.class.desiredAssertionStatus());
    /* renamed from: Cb */
    static ArrayList<String> f25282Cb = new ArrayList<>();
    /* renamed from: Db */
    public ArrayList<String> f25283Db = null;

    static {
        f25282Cb.add("");
    }

    public C7522v() {
    }

    public C7522v(ArrayList<String> arrayList) {
        this.f25283Db = arrayList;
    }

    public String className() {
        return "ADV.ExternalEventTrackingUrl";
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
        new JceDisplayer(sb, i).display((Collection<T>) this.f25283Db, "urls");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((Collection<T>) this.f25283Db, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.f25283Db, (Object) ((C7522v) obj).f25283Db);
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.ExternalEventTrackingUrl";
    }

    public ArrayList<String> getUrls() {
        return this.f25283Db;
    }

    /* renamed from: h */
    public void mo36851h(ArrayList<String> arrayList) {
        this.f25283Db = arrayList;
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
        this.f25283Db = (ArrayList) jceInputStream.read(f25282Cb, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.f25283Db;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 0);
        }
    }
}
