package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.android.tpush.common.MessageKey;
import discoveryAD.C7880W.C7881a;

/* compiled from: ProGuard */
public final class TpnsPushMsg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public long accessId = 0;
    public long adPush;
    public String appPkgName;
    public long busiMsgId = 0;
    public long channelId;
    public String content;
    public String date;
    public String groupKey;
    public long msgId = 0;
    public long multiPkg;
    public long reseverId;
    public long serverTime;
    public String statTag;
    public long timestamp;
    public String title;
    public int ttl;
    public long type;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsPushMsg";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg";
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

    public long getBusiMsgId() {
        return this.busiMsgId;
    }

    public void setBusiMsgId(long j) {
        this.busiMsgId = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public long getType() {
        return this.type;
    }

    public void setType(long j) {
        this.type = j;
    }

    public String getAppPkgName() {
        return this.appPkgName;
    }

    public void setAppPkgName(String str) {
        this.appPkgName = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public long getMultiPkg() {
        return this.multiPkg;
    }

    public void setMultiPkg(long j) {
        this.multiPkg = j;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public long getAdPush() {
        return this.adPush;
    }

    public void setAdPush(long j) {
        this.adPush = j;
    }

    public long getReseverId() {
        return this.reseverId;
    }

    public void setReseverId(long j) {
        this.reseverId = j;
    }

    public String getStatTag() {
        return this.statTag;
    }

    public void setStatTag(String str) {
        this.statTag = str;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public TpnsPushMsg() {
        String str = "";
        this.title = str;
        this.content = str;
        this.type = 0;
        this.appPkgName = str;
        this.timestamp = 0;
        this.multiPkg = 0;
        this.date = str;
        this.serverTime = 0;
        this.ttl = 0;
        this.channelId = 0;
        this.adPush = 0;
        this.reseverId = 0;
        this.statTag = str;
        this.groupKey = str;
    }

    public TpnsPushMsg(long j, long j2, long j3, String str, String str2, long j4, String str3, long j5, long j6, String str4, long j7, int i, long j8, long j9, long j10, String str5, String str6) {
        String str7 = "";
        this.title = str7;
        this.content = str7;
        this.type = 0;
        this.appPkgName = str7;
        this.timestamp = 0;
        this.multiPkg = 0;
        this.date = str7;
        this.serverTime = 0;
        this.ttl = 0;
        this.channelId = 0;
        this.adPush = 0;
        this.reseverId = 0;
        this.statTag = str7;
        this.groupKey = str7;
        this.msgId = j;
        this.accessId = j2;
        this.busiMsgId = j3;
        this.title = str;
        this.content = str2;
        this.type = j4;
        this.appPkgName = str3;
        this.timestamp = j5;
        this.multiPkg = j6;
        this.date = str4;
        this.serverTime = j7;
        this.ttl = i;
        this.channelId = j8;
        this.adPush = j9;
        this.reseverId = j10;
        this.statTag = str5;
        this.groupKey = str6;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsPushMsg tpnsPushMsg = (TpnsPushMsg) obj;
        if (JceUtil.equals(this.msgId, tpnsPushMsg.msgId) && JceUtil.equals(this.accessId, tpnsPushMsg.accessId) && JceUtil.equals(this.busiMsgId, tpnsPushMsg.busiMsgId) && JceUtil.equals((Object) this.title, (Object) tpnsPushMsg.title) && JceUtil.equals((Object) this.content, (Object) tpnsPushMsg.content) && JceUtil.equals(this.type, tpnsPushMsg.type) && JceUtil.equals((Object) this.appPkgName, (Object) tpnsPushMsg.appPkgName) && JceUtil.equals(this.timestamp, tpnsPushMsg.timestamp) && JceUtil.equals(this.multiPkg, tpnsPushMsg.multiPkg) && JceUtil.equals((Object) this.date, (Object) tpnsPushMsg.date) && JceUtil.equals(this.serverTime, tpnsPushMsg.serverTime) && JceUtil.equals(this.ttl, tpnsPushMsg.ttl) && JceUtil.equals(this.channelId, tpnsPushMsg.channelId) && JceUtil.equals(this.adPush, tpnsPushMsg.adPush) && JceUtil.equals(this.reseverId, tpnsPushMsg.reseverId) && JceUtil.equals((Object) this.statTag, (Object) tpnsPushMsg.statTag) && JceUtil.equals((Object) this.groupKey, (Object) tpnsPushMsg.groupKey)) {
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
        jceOutputStream.write(this.busiMsgId, 2);
        jceOutputStream.write(this.title, 3);
        jceOutputStream.write(this.content, 4);
        jceOutputStream.write(this.type, 5);
        String str = this.appPkgName;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        jceOutputStream.write(this.timestamp, 7);
        jceOutputStream.write(this.multiPkg, 8);
        String str2 = this.date;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        jceOutputStream.write(this.serverTime, 10);
        jceOutputStream.write(this.ttl, 11);
        jceOutputStream.write(this.channelId, 12);
        jceOutputStream.write(this.adPush, 13);
        jceOutputStream.write(this.reseverId, 14);
        String str3 = this.statTag;
        if (str3 != null) {
            jceOutputStream.write(str3, 15);
        }
        String str4 = this.groupKey;
        if (str4 != null) {
            jceOutputStream.write(str4, 16);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.msgId = jceInputStream.read(this.msgId, 0, true);
        this.accessId = jceInputStream.read(this.accessId, 1, true);
        this.busiMsgId = jceInputStream.read(this.busiMsgId, 2, true);
        this.title = jceInputStream.readString(3, true);
        this.content = jceInputStream.readString(4, true);
        this.type = jceInputStream.read(this.type, 5, true);
        this.appPkgName = jceInputStream.readString(6, false);
        this.timestamp = jceInputStream.read(this.timestamp, 7, false);
        this.multiPkg = jceInputStream.read(this.multiPkg, 8, false);
        this.date = jceInputStream.readString(9, false);
        this.serverTime = jceInputStream.read(this.serverTime, 10, false);
        this.ttl = jceInputStream.read(this.ttl, 11, false);
        this.channelId = jceInputStream.read(this.channelId, 12, false);
        this.adPush = jceInputStream.read(this.adPush, 13, false);
        this.reseverId = jceInputStream.read(this.reseverId, 14, false);
        this.statTag = jceInputStream.readString(15, false);
        this.groupKey = jceInputStream.readString(16, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.msgId, MessageKey.MSG_ID);
        jceDisplayer.display(this.accessId, "accessId");
        jceDisplayer.display(this.busiMsgId, MessageKey.MSG_BUSI_MSG_ID);
        jceDisplayer.display(this.title, "title");
        jceDisplayer.display(this.content, MessageKey.MSG_CONTENT);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.appPkgName, "appPkgName");
        jceDisplayer.display(this.timestamp, C7881a.TIMESTAMP);
        jceDisplayer.display(this.multiPkg, MessageKey.MSG_CREATE_MULTIPKG);
        jceDisplayer.display(this.date, MessageKey.MSG_DATE);
        jceDisplayer.display(this.serverTime, "serverTime");
        jceDisplayer.display(this.ttl, MessageKey.MSG_TTL);
        jceDisplayer.display(this.channelId, C7887a.f26838Mh);
        jceDisplayer.display(this.adPush, "adPush");
        jceDisplayer.display(this.reseverId, "reseverId");
        jceDisplayer.display(this.statTag, "statTag");
        jceDisplayer.display(this.groupKey, "groupKey");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.msgId, true);
        jceDisplayer.displaySimple(this.accessId, true);
        jceDisplayer.displaySimple(this.busiMsgId, true);
        jceDisplayer.displaySimple(this.title, true);
        jceDisplayer.displaySimple(this.content, true);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.appPkgName, true);
        jceDisplayer.displaySimple(this.timestamp, true);
        jceDisplayer.displaySimple(this.multiPkg, true);
        jceDisplayer.displaySimple(this.date, true);
        jceDisplayer.displaySimple(this.serverTime, true);
        jceDisplayer.displaySimple(this.ttl, true);
        jceDisplayer.displaySimple(this.channelId, true);
        jceDisplayer.displaySimple(this.adPush, true);
        jceDisplayer.displaySimple(this.reseverId, true);
        jceDisplayer.displaySimple(this.statTag, true);
        jceDisplayer.displaySimple(this.groupKey, false);
    }
}
