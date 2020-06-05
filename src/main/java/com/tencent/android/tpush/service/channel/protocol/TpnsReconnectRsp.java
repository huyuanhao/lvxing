package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
public final class TpnsReconnectRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<TpnsPushMsg> cache_appOfflinePushMsgList = new ArrayList<>();
    public ArrayList<TpnsPushMsg> appOfflinePushMsgList = null;
    public long confVersion = 0;
    public long timeUs = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsReconnectRsp";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsReconnectRsp";
    }

    public long getConfVersion() {
        return this.confVersion;
    }

    public void setConfVersion(long j) {
        this.confVersion = j;
    }

    public ArrayList<TpnsPushMsg> getAppOfflinePushMsgList() {
        return this.appOfflinePushMsgList;
    }

    public void setAppOfflinePushMsgList(ArrayList<TpnsPushMsg> arrayList) {
        this.appOfflinePushMsgList = arrayList;
    }

    public long getTimeUs() {
        return this.timeUs;
    }

    public void setTimeUs(long j) {
        this.timeUs = j;
    }

    public TpnsReconnectRsp() {
    }

    public TpnsReconnectRsp(long j, ArrayList<TpnsPushMsg> arrayList, long j2) {
        this.confVersion = j;
        this.appOfflinePushMsgList = arrayList;
        this.timeUs = j2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsReconnectRsp tpnsReconnectRsp = (TpnsReconnectRsp) obj;
        if (JceUtil.equals(this.confVersion, tpnsReconnectRsp.confVersion) && JceUtil.equals((Object) this.appOfflinePushMsgList, (Object) tpnsReconnectRsp.appOfflinePushMsgList) && JceUtil.equals(this.timeUs, tpnsReconnectRsp.timeUs)) {
            z = true;
        }
        return z;
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
        jceOutputStream.write(this.confVersion, 0);
        ArrayList<TpnsPushMsg> arrayList = this.appOfflinePushMsgList;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
        jceOutputStream.write(this.timeUs, 2);
    }

    static {
        cache_appOfflinePushMsgList.add(new TpnsPushMsg());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.confVersion = jceInputStream.read(this.confVersion, 0, true);
        this.appOfflinePushMsgList = (ArrayList) jceInputStream.read(cache_appOfflinePushMsgList, 1, false);
        this.timeUs = jceInputStream.read(this.timeUs, 2, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.confVersion, "confVersion");
        jceDisplayer.display((Collection<T>) this.appOfflinePushMsgList, "appOfflinePushMsgList");
        jceDisplayer.display(this.timeUs, "timeUs");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.confVersion, true);
        jceDisplayer.displaySimple((Collection<T>) this.appOfflinePushMsgList, true);
        jceDisplayer.displaySimple(this.timeUs, false);
    }
}
