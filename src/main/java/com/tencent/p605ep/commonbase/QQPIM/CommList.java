package com.tencent.p605ep.commonbase.QQPIM;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.ep.commonbase.QQPIM.CommList */
public final class CommList extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!CommList.class.desiredAssertionStatus());
    static ArrayList<CommElementInfo> cache_vctCommList;
    public ArrayList<CommElementInfo> vctCommList = null;

    public CommList() {
    }

    public CommList(ArrayList<CommElementInfo> arrayList) {
        this.vctCommList = arrayList;
    }

    public String className() {
        return "CommList";
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
        new JceDisplayer(sb, i).display((Collection<T>) this.vctCommList, "vctCommList");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.vctCommList, (Object) ((CommList) obj).vctCommList);
    }

    public String fullClassName() {
        return "CommList";
    }

    public ArrayList<CommElementInfo> getVctCommList() {
        return this.vctCommList;
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
        if (cache_vctCommList == null) {
            cache_vctCommList = new ArrayList<>();
            cache_vctCommList.add(new CommElementInfo());
        }
        this.vctCommList = (ArrayList) jceInputStream.read(cache_vctCommList, 0, true);
    }

    public void setVctCommList(ArrayList<CommElementInfo> arrayList) {
        this.vctCommList = arrayList;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection<T>) this.vctCommList, 0);
    }
}
