package com.tencent.android.tpush.data;

import java.io.Serializable;

/* compiled from: ProGuard */
public class MessageId implements Serializable {
    public static final short FLAG_ACK = 1;
    public static final short FLAG_UNACK = 0;
    private static final long serialVersionUID = 8708157897391765794L;
    public long accessId;
    public byte apn;
    public long busiMsgId = 0;
    public long channelId;
    public String date;
    public String groupKeys;
    public long host;
    /* renamed from: id */
    public long f23015id;
    public short isAck;
    public byte isp;
    public long msgType = -1;
    public long multiPkg = 0;
    public byte pact;
    public String pkgName;
    public int port;
    public long pushTime;
    public long receivedTime;
    public long serverTime;
    public String serviceHost;
    public String statTag;
    public long timestamp = 0;
    public long ttl;

    public MessageId() {
        String str = "";
        this.date = str;
        this.channelId = -1;
        this.statTag = str;
        this.groupKeys = str;
    }

    public MessageId(long j, long j2, long j3, long j4, byte b, byte b2, byte b3, long j5, String str, String str2, int i, long j6, String str3, int i2, int i3) {
        String str4 = "";
        this.date = str4;
        this.channelId = -1;
        this.statTag = str4;
        this.groupKeys = str4;
        this.f23015id = j;
        this.accessId = j2;
        this.pushTime = j3;
        this.receivedTime = j4;
        this.isp = b;
        this.apn = b2;
        this.pact = b3;
        this.host = j5;
        this.serviceHost = str;
        this.pkgName = str2;
        this.msgType = (long) i;
        this.multiPkg = j6;
        this.date = str3;
        this.serverTime = (long) i2;
        this.ttl = (long) i3;
    }

    public boolean isMsgAcked() {
        return this.isAck == 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessageId [id=");
        sb.append(this.f23015id);
        sb.append(", isAck=");
        sb.append(this.isAck);
        sb.append(", isp=");
        sb.append(this.isp);
        sb.append(", apn=");
        sb.append(this.apn);
        sb.append(", accessId=");
        sb.append(this.accessId);
        sb.append(", pushTime=");
        sb.append(this.pushTime);
        sb.append(", receivedTime=");
        sb.append(this.receivedTime);
        sb.append(", pact=");
        sb.append(this.pact);
        sb.append(", host=");
        sb.append(this.host);
        sb.append(", port=");
        sb.append(this.port);
        sb.append(", serviceHost=");
        sb.append(this.serviceHost);
        sb.append(", pkgName=");
        sb.append(this.pkgName);
        sb.append(", busiMsgId=");
        sb.append(this.busiMsgId);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", msgType=");
        sb.append(this.msgType);
        sb.append(", multiPkg=");
        sb.append(this.multiPkg);
        sb.append(", date=");
        sb.append(this.date);
        sb.append(", serverTime=");
        sb.append(this.serverTime);
        sb.append(", ttl=");
        sb.append(this.ttl);
        sb.append("]");
        return sb.toString();
    }
}
