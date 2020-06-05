package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.android.tpush.common.MessageKey;
import discoveryAD.C7880W.C7881a;

/* compiled from: ProGuard */
public final class TpnsPushClientReport extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public long accessId = 0;
    public byte ackType;
    public byte apn = 0;
    public long broadcastId;
    public long channelId;
    public long confirmMs;
    public String groupKey;
    public byte isp = 0;
    public long locip;
    public int locport;
    public long msgId = 0;
    public byte pack = 0;
    public String qua;
    public long receiveTime;
    public String serviceHost;
    public String statTag;
    public long timeUs;
    public long timestamp;
    public long type;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsPushClientReport";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport";
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public long getAccessId() {
        return this.accessId;
    }

    public void setAccessId(long j) {
        this.accessId = j;
    }

    public byte getIsp() {
        return this.isp;
    }

    public void setIsp(byte b) {
        this.isp = b;
    }

    public byte getApn() {
        return this.apn;
    }

    public void setApn(byte b) {
        this.apn = b;
    }

    public byte getPack() {
        return this.pack;
    }

    public void setPack(byte b) {
        this.pack = b;
    }

    public String getQua() {
        return this.qua;
    }

    public void setQua(String str) {
        this.qua = str;
    }

    public long getLocip() {
        return this.locip;
    }

    public void setLocip(long j) {
        this.locip = j;
    }

    public int getLocport() {
        return this.locport;
    }

    public void setLocport(int i) {
        this.locport = i;
    }

    public String getServiceHost() {
        return this.serviceHost;
    }

    public void setServiceHost(String str) {
        this.serviceHost = str;
    }

    public long getTimeUs() {
        return this.timeUs;
    }

    public void setTimeUs(long j) {
        this.timeUs = j;
    }

    public long getConfirmMs() {
        return this.confirmMs;
    }

    public void setConfirmMs(long j) {
        this.confirmMs = j;
    }

    public long getBroadcastId() {
        return this.broadcastId;
    }

    public void setBroadcastId(long j) {
        this.broadcastId = j;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public long getType() {
        return this.type;
    }

    public void setType(long j) {
        this.type = j;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public void setReceiveTime(long j) {
        this.receiveTime = j;
    }

    public byte getAckType() {
        return this.ackType;
    }

    public void setAckType(byte b) {
        this.ackType = b;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public String getStatTag() {
        return this.statTag;
    }

    public void setStatTag(String str) {
        this.statTag = str;
    }

    public TpnsPushClientReport() {
        String str = "";
        this.qua = str;
        this.locip = 0;
        this.locport = 0;
        this.serviceHost = str;
        this.timeUs = 0;
        this.confirmMs = 0;
        this.broadcastId = 0;
        this.timestamp = 0;
        this.type = 0;
        this.receiveTime = 0;
        this.ackType = 0;
        this.groupKey = str;
        this.channelId = 0;
        this.statTag = str;
    }

    public TpnsPushClientReport(long j, long j2, byte b, byte b2, byte b3, String str, long j3, int i, String str2, long j4, long j5, long j6, long j7, long j8, long j9, byte b4, String str3, long j10, String str4) {
        String str5 = "";
        this.qua = str5;
        this.locip = 0;
        this.locport = 0;
        this.serviceHost = str5;
        this.timeUs = 0;
        this.confirmMs = 0;
        this.broadcastId = 0;
        this.timestamp = 0;
        this.type = 0;
        this.receiveTime = 0;
        this.ackType = 0;
        this.groupKey = str5;
        this.channelId = 0;
        this.statTag = str5;
        this.msgId = j;
        this.accessId = j2;
        this.isp = b;
        this.apn = b2;
        this.pack = b3;
        this.qua = str;
        this.locip = j3;
        this.locport = i;
        this.serviceHost = str2;
        this.timeUs = j4;
        this.confirmMs = j5;
        this.broadcastId = j6;
        this.timestamp = j7;
        this.type = j8;
        this.receiveTime = j9;
        this.ackType = b4;
        this.groupKey = str3;
        this.channelId = j10;
        this.statTag = str4;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsPushClientReport tpnsPushClientReport = (TpnsPushClientReport) obj;
        if (JceUtil.equals(this.msgId, tpnsPushClientReport.msgId) && JceUtil.equals(this.accessId, tpnsPushClientReport.accessId) && JceUtil.equals(this.isp, tpnsPushClientReport.isp) && JceUtil.equals(this.apn, tpnsPushClientReport.apn) && JceUtil.equals(this.pack, tpnsPushClientReport.pack) && JceUtil.equals((Object) this.qua, (Object) tpnsPushClientReport.qua) && JceUtil.equals(this.locip, tpnsPushClientReport.locip) && JceUtil.equals(this.locport, tpnsPushClientReport.locport) && JceUtil.equals((Object) this.serviceHost, (Object) tpnsPushClientReport.serviceHost) && JceUtil.equals(this.timeUs, tpnsPushClientReport.timeUs) && JceUtil.equals(this.confirmMs, tpnsPushClientReport.confirmMs) && JceUtil.equals(this.broadcastId, tpnsPushClientReport.broadcastId) && JceUtil.equals(this.timestamp, tpnsPushClientReport.timestamp) && JceUtil.equals(this.type, tpnsPushClientReport.type) && JceUtil.equals(this.receiveTime, tpnsPushClientReport.receiveTime) && JceUtil.equals(this.ackType, tpnsPushClientReport.ackType) && JceUtil.equals((Object) this.groupKey, (Object) tpnsPushClientReport.groupKey) && JceUtil.equals(this.channelId, tpnsPushClientReport.channelId) && JceUtil.equals((Object) this.statTag, (Object) tpnsPushClientReport.statTag)) {
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
        jceOutputStream.write(this.msgId, 0);
        jceOutputStream.write(this.accessId, 1);
        jceOutputStream.write(this.isp, 2);
        jceOutputStream.write(this.apn, 3);
        jceOutputStream.write(this.pack, 4);
        String str = this.qua;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.locip, 6);
        jceOutputStream.write(this.locport, 7);
        String str2 = this.serviceHost;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        jceOutputStream.write(this.timeUs, 9);
        jceOutputStream.write(this.confirmMs, 10);
        jceOutputStream.write(this.broadcastId, 11);
        jceOutputStream.write(this.timestamp, 12);
        jceOutputStream.write(this.type, 13);
        jceOutputStream.write(this.receiveTime, 14);
        jceOutputStream.write(this.ackType, 15);
        String str3 = this.groupKey;
        if (str3 != null) {
            jceOutputStream.write(str3, 16);
        }
        jceOutputStream.write(this.channelId, 17);
        String str4 = this.statTag;
        if (str4 != null) {
            jceOutputStream.write(str4, 18);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.msgId = jceInputStream.read(this.msgId, 0, true);
        this.accessId = jceInputStream.read(this.accessId, 1, true);
        this.isp = jceInputStream.read(this.isp, 2, false);
        this.apn = jceInputStream.read(this.apn, 3, false);
        this.pack = jceInputStream.read(this.pack, 4, false);
        this.qua = jceInputStream.readString(5, false);
        this.locip = jceInputStream.read(this.locip, 6, false);
        this.locport = jceInputStream.read(this.locport, 7, false);
        this.serviceHost = jceInputStream.readString(8, false);
        this.timeUs = jceInputStream.read(this.timeUs, 9, false);
        this.confirmMs = jceInputStream.read(this.confirmMs, 10, false);
        this.broadcastId = jceInputStream.read(this.broadcastId, 11, false);
        this.timestamp = jceInputStream.read(this.timestamp, 12, false);
        this.type = jceInputStream.read(this.type, 13, false);
        this.receiveTime = jceInputStream.read(this.receiveTime, 14, false);
        this.ackType = jceInputStream.read(this.ackType, 15, false);
        this.groupKey = jceInputStream.readString(16, false);
        this.channelId = jceInputStream.read(this.channelId, 17, false);
        this.statTag = jceInputStream.readString(18, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.msgId, MessageKey.MSG_ID);
        jceDisplayer.display(this.accessId, "accessId");
        jceDisplayer.display(this.isp, "isp");
        jceDisplayer.display(this.apn, "apn");
        jceDisplayer.display(this.pack, "pack");
        jceDisplayer.display(this.qua, "qua");
        jceDisplayer.display(this.locip, "locip");
        jceDisplayer.display(this.locport, "locport");
        jceDisplayer.display(this.serviceHost, "serviceHost");
        jceDisplayer.display(this.timeUs, "timeUs");
        jceDisplayer.display(this.confirmMs, "confirmMs");
        jceDisplayer.display(this.broadcastId, "broadcastId");
        jceDisplayer.display(this.timestamp, C7881a.TIMESTAMP);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.receiveTime, "receiveTime");
        jceDisplayer.display(this.ackType, "ackType");
        jceDisplayer.display(this.groupKey, "groupKey");
        jceDisplayer.display(this.channelId, C7887a.f26838Mh);
        jceDisplayer.display(this.statTag, "statTag");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.msgId, true);
        jceDisplayer.displaySimple(this.accessId, true);
        jceDisplayer.displaySimple(this.isp, true);
        jceDisplayer.displaySimple(this.apn, true);
        jceDisplayer.displaySimple(this.pack, true);
        jceDisplayer.displaySimple(this.qua, true);
        jceDisplayer.displaySimple(this.locip, true);
        jceDisplayer.displaySimple(this.locport, true);
        jceDisplayer.displaySimple(this.serviceHost, true);
        jceDisplayer.displaySimple(this.timeUs, true);
        jceDisplayer.displaySimple(this.confirmMs, true);
        jceDisplayer.displaySimple(this.broadcastId, true);
        jceDisplayer.displaySimple(this.timestamp, true);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.receiveTime, true);
        jceDisplayer.displaySimple(this.ackType, true);
        jceDisplayer.displaySimple(this.groupKey, true);
        jceDisplayer.displaySimple(this.channelId, true);
        jceDisplayer.displaySimple(this.statTag, false);
    }
}
