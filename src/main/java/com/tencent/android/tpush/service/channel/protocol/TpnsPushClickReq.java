package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
public final class TpnsPushClickReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<TpnsClickClientReport> cache_msgClickList = new ArrayList<>();
    public ArrayList<TpnsClickClientReport> msgClickList = null;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsPushClickReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsPushClickReq";
    }

    public ArrayList<TpnsClickClientReport> getMsgClickList() {
        return this.msgClickList;
    }

    public void setMsgClickList(ArrayList<TpnsClickClientReport> arrayList) {
        this.msgClickList = arrayList;
    }

    public TpnsPushClickReq() {
    }

    public TpnsPushClickReq(ArrayList<TpnsClickClientReport> arrayList) {
        this.msgClickList = arrayList;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.msgClickList, (Object) ((TpnsPushClickReq) obj).msgClickList);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection<T>) this.msgClickList, 1);
    }

    static {
        cache_msgClickList.add(new TpnsClickClientReport());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.msgClickList = (ArrayList) jceInputStream.read(cache_msgClickList, 1, true);
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display((Collection<T>) this.msgClickList, "msgClickList");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((Collection<T>) this.msgClickList, false);
    }
}
