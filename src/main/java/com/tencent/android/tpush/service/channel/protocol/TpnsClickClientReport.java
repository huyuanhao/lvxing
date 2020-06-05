package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import discoveryAD.C7880W.C7881a;

/* compiled from: ProGuard */
public final class TpnsClickClientReport extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public long accessId = 0;
    public long action = 0;
    public long broadcastId = 0;
    public long channelId;
    public long clickTime = 0;
    public String groupKey;
    public long msgId = 0;
    public String statTag;
    public long timestamp = 0;
    public long type = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsClickClientReport";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsClickClientReport";
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

    public long getClickTime() {
        return this.clickTime;
    }

    public void setClickTime(long j) {
        this.clickTime = j;
    }

    public long getAction() {
        return this.action;
    }

    public void setAction(long j) {
        this.action = j;
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

    public TpnsClickClientReport() {
        String str = "";
        this.groupKey = str;
        this.channelId = 0;
        this.statTag = str;
    }

    public TpnsClickClientReport(long j, long j2, long j3, long j4, long j5, long j6, long j7, String str, long j8, String str2) {
        String str3 = "";
        this.groupKey = str3;
        this.channelId = 0;
        this.statTag = str3;
        this.msgId = j;
        this.accessId = j2;
        this.broadcastId = j3;
        this.timestamp = j4;
        this.type = j5;
        this.clickTime = j6;
        this.action = j7;
        this.groupKey = str;
        this.channelId = j8;
        this.statTag = str2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsClickClientReport tpnsClickClientReport = (TpnsClickClientReport) obj;
        if (JceUtil.equals(this.msgId, tpnsClickClientReport.msgId) && JceUtil.equals(this.accessId, tpnsClickClientReport.accessId) && JceUtil.equals(this.broadcastId, tpnsClickClientReport.broadcastId) && JceUtil.equals(this.timestamp, tpnsClickClientReport.timestamp) && JceUtil.equals(this.type, tpnsClickClientReport.type) && JceUtil.equals(this.clickTime, tpnsClickClientReport.clickTime) && JceUtil.equals(this.action, tpnsClickClientReport.action) && JceUtil.equals((Object) this.groupKey, (Object) tpnsClickClientReport.groupKey) && JceUtil.equals(this.channelId, tpnsClickClientReport.channelId) && JceUtil.equals((Object) this.statTag, (Object) tpnsClickClientReport.statTag)) {
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
        jceOutputStream.write(this.broadcastId, 2);
        jceOutputStream.write(this.timestamp, 3);
        jceOutputStream.write(this.type, 4);
        jceOutputStream.write(this.clickTime, 5);
        jceOutputStream.write(this.action, 6);
        String str = this.groupKey;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        jceOutputStream.write(this.channelId, 8);
        String str2 = this.statTag;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.msgId = jceInputStream.read(this.msgId, 0, true);
        this.accessId = jceInputStream.read(this.accessId, 1, true);
        this.broadcastId = jceInputStream.read(this.broadcastId, 2, false);
        this.timestamp = jceInputStream.read(this.timestamp, 3, false);
        this.type = jceInputStream.read(this.type, 4, false);
        this.clickTime = jceInputStream.read(this.clickTime, 5, false);
        this.action = jceInputStream.read(this.action, 6, false);
        this.groupKey = jceInputStream.readString(7, false);
        this.channelId = jceInputStream.read(this.channelId, 8, false);
        this.statTag = jceInputStream.readString(9, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.msgId, MessageKey.MSG_ID);
        jceDisplayer.display(this.accessId, "accessId");
        jceDisplayer.display(this.broadcastId, "broadcastId");
        jceDisplayer.display(this.timestamp, C7881a.TIMESTAMP);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.clickTime, Constants.FLAG_CLICK_TIME);
        jceDisplayer.display(this.action, "action");
        jceDisplayer.display(this.groupKey, "groupKey");
        jceDisplayer.display(this.channelId, C7887a.f26838Mh);
        jceDisplayer.display(this.statTag, "statTag");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.msgId, true);
        jceDisplayer.displaySimple(this.accessId, true);
        jceDisplayer.displaySimple(this.broadcastId, true);
        jceDisplayer.displaySimple(this.timestamp, true);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.clickTime, true);
        jceDisplayer.displaySimple(this.action, true);
        jceDisplayer.displaySimple(this.groupKey, true);
        jceDisplayer.displaySimple(this.channelId, true);
        jceDisplayer.displaySimple(this.statTag, false);
    }
}
