package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
public final class TpnsPushVerifyReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<TpnsPushClientReport> cache_msgReportList = new ArrayList<>();
    public ArrayList<TpnsPushClientReport> msgReportList = null;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsPushVerifyReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq";
    }

    public ArrayList<TpnsPushClientReport> getMsgReportList() {
        return this.msgReportList;
    }

    public void setMsgReportList(ArrayList<TpnsPushClientReport> arrayList) {
        this.msgReportList = arrayList;
    }

    public TpnsPushVerifyReq() {
    }

    public TpnsPushVerifyReq(ArrayList<TpnsPushClientReport> arrayList) {
        this.msgReportList = arrayList;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals((Object) this.msgReportList, (Object) ((TpnsPushVerifyReq) obj).msgReportList);
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
        jceOutputStream.write((Collection<T>) this.msgReportList, 1);
    }

    static {
        cache_msgReportList.add(new TpnsPushClientReport());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.msgReportList = (ArrayList) jceInputStream.read(cache_msgReportList, 1, true);
    }

    public void display(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).display((Collection<T>) this.msgReportList, "msgReportList");
    }

    public void displaySimple(StringBuilder sb, int i) {
        new JceDisplayer(sb, i).displaySimple((Collection<T>) this.msgReportList, false);
    }
}
