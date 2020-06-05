package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.commonbase.software.AppEntity;

/* compiled from: ProGuard */
public final class TpnsRegisterReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static DeviceInfo cache_deviceInfo = new DeviceInfo();
    static MutableInfo cache_mutableInfo = new MutableInfo();
    public long accessId = 0;
    public String accessKey;
    public String account;
    public long accountType;
    public String appCert;
    public String appVersion;
    public long channelId;
    public String clientid;
    public long connVersion;
    public String deviceId;
    public DeviceInfo deviceInfo;
    public short deviceType;
    public long guid;
    public byte keyEncrypted;
    public MutableInfo mutableInfo;
    public String otherPushData;
    public String otherPushToken;
    public long otherPushTokenCrc32;
    public long otherPushTokenOpType;
    public long otherPushTokenType;
    public String reserved;
    public String ticket;
    public short ticketType;
    public String token;
    public long tokenCrc32;
    /* renamed from: ts */
    public long f23403ts;
    public short updateAutoTag;
    public short version;

    public String className() {
        return "TpnsRegisterReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsRegisterReq";
    }

    public long getAccessId() {
        return this.accessId;
    }

    public void setAccessId(long j) {
        this.accessId = j;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getAppCert() {
        return this.appCert;
    }

    public void setAppCert(String str) {
        this.appCert = str;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public short getTicketType() {
        return this.ticketType;
    }

    public void setTicketType(short s) {
        this.ticketType = s;
    }

    public short getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(short s) {
        this.deviceType = s;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo2) {
        this.deviceInfo = deviceInfo2;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public short getVersion() {
        return this.version;
    }

    public void setVersion(short s) {
        this.version = s;
    }

    public byte getKeyEncrypted() {
        return this.keyEncrypted;
    }

    public void setKeyEncrypted(byte b) {
        this.keyEncrypted = b;
    }

    public MutableInfo getMutableInfo() {
        return this.mutableInfo;
    }

    public void setMutableInfo(MutableInfo mutableInfo2) {
        this.mutableInfo = mutableInfo2;
    }

    public short getUpdateAutoTag() {
        return this.updateAutoTag;
    }

    public void setUpdateAutoTag(short s) {
        this.updateAutoTag = s;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getReserved() {
        return this.reserved;
    }

    public void setReserved(String str) {
        this.reserved = str;
    }

    public String getClientid() {
        return this.clientid;
    }

    public void setClientid(String str) {
        this.clientid = str;
    }

    public long getGuid() {
        return this.guid;
    }

    public void setGuid(long j) {
        this.guid = j;
    }

    public long getAccountType() {
        return this.accountType;
    }

    public void setAccountType(long j) {
        this.accountType = j;
    }

    public long getTs() {
        return this.f23403ts;
    }

    public void setTs(long j) {
        this.f23403ts = j;
    }

    public long getConnVersion() {
        return this.connVersion;
    }

    public void setConnVersion(long j) {
        this.connVersion = j;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public long getOtherPushTokenOpType() {
        return this.otherPushTokenOpType;
    }

    public void setOtherPushTokenOpType(long j) {
        this.otherPushTokenOpType = j;
    }

    public long getOtherPushTokenType() {
        return this.otherPushTokenType;
    }

    public void setOtherPushTokenType(long j) {
        this.otherPushTokenType = j;
    }

    public String getOtherPushToken() {
        return this.otherPushToken;
    }

    public void setOtherPushToken(String str) {
        this.otherPushToken = str;
    }

    public long getOtherPushTokenCrc32() {
        return this.otherPushTokenCrc32;
    }

    public void setOtherPushTokenCrc32(long j) {
        this.otherPushTokenCrc32 = j;
    }

    public long getTokenCrc32() {
        return this.tokenCrc32;
    }

    public void setTokenCrc32(long j) {
        this.tokenCrc32 = j;
    }

    public String getOtherPushData() {
        return this.otherPushData;
    }

    public void setOtherPushData(String str) {
        this.otherPushData = str;
    }

    public TpnsRegisterReq() {
        String str = "";
        this.accessKey = str;
        this.deviceId = str;
        this.appCert = str;
        this.account = str;
        this.ticket = str;
        this.ticketType = 0;
        this.deviceType = 0;
        this.deviceInfo = null;
        this.token = str;
        this.version = 0;
        this.keyEncrypted = 0;
        this.mutableInfo = null;
        this.updateAutoTag = 0;
        this.appVersion = str;
        this.reserved = str;
        this.clientid = str;
        this.guid = 0;
        this.accountType = 0;
        this.f23403ts = 0;
        this.connVersion = 0;
        this.channelId = 0;
        this.otherPushTokenOpType = 0;
        this.otherPushTokenType = 0;
        this.otherPushToken = str;
        this.otherPushTokenCrc32 = 0;
        this.tokenCrc32 = 0;
        this.otherPushData = str;
    }

    public TpnsRegisterReq(long j, String str, String str2, String str3, String str4, String str5, short s, short s2, DeviceInfo deviceInfo2, String str6, short s3, byte b, MutableInfo mutableInfo2, short s4, String str7, String str8, String str9, long j2, long j3, long j4, long j5, long j6, long j7, long j8, String str10, long j9, long j10, String str11) {
        String str12 = "";
        this.accessKey = str12;
        this.deviceId = str12;
        this.appCert = str12;
        this.account = str12;
        this.ticket = str12;
        this.ticketType = 0;
        this.deviceType = 0;
        this.deviceInfo = null;
        this.token = str12;
        this.version = 0;
        this.keyEncrypted = 0;
        this.mutableInfo = null;
        this.updateAutoTag = 0;
        this.appVersion = str12;
        this.reserved = str12;
        this.clientid = str12;
        this.guid = 0;
        this.accountType = 0;
        this.f23403ts = 0;
        this.connVersion = 0;
        this.channelId = 0;
        this.otherPushTokenOpType = 0;
        this.otherPushTokenType = 0;
        this.otherPushToken = str12;
        this.otherPushTokenCrc32 = 0;
        this.tokenCrc32 = 0;
        this.otherPushData = str12;
        this.accessId = j;
        this.accessKey = str;
        this.deviceId = str2;
        this.appCert = str3;
        this.account = str4;
        this.ticket = str5;
        this.ticketType = s;
        this.deviceType = s2;
        this.deviceInfo = deviceInfo2;
        this.token = str6;
        this.version = s3;
        this.keyEncrypted = b;
        this.mutableInfo = mutableInfo2;
        this.updateAutoTag = s4;
        this.appVersion = str7;
        this.reserved = str8;
        this.clientid = str9;
        this.guid = j2;
        this.accountType = j3;
        this.f23403ts = j4;
        this.connVersion = j5;
        this.channelId = j6;
        this.otherPushTokenOpType = j7;
        this.otherPushTokenType = j8;
        this.otherPushToken = str10;
        this.otherPushTokenCrc32 = j9;
        this.tokenCrc32 = j10;
        this.otherPushData = str11;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsRegisterReq tpnsRegisterReq = (TpnsRegisterReq) obj;
        if (JceUtil.equals(this.accessId, tpnsRegisterReq.accessId) && JceUtil.equals((Object) this.accessKey, (Object) tpnsRegisterReq.accessKey) && JceUtil.equals((Object) this.deviceId, (Object) tpnsRegisterReq.deviceId) && JceUtil.equals((Object) this.appCert, (Object) tpnsRegisterReq.appCert) && JceUtil.equals((Object) this.account, (Object) tpnsRegisterReq.account) && JceUtil.equals((Object) this.ticket, (Object) tpnsRegisterReq.ticket) && JceUtil.equals(this.ticketType, tpnsRegisterReq.ticketType) && JceUtil.equals(this.deviceType, tpnsRegisterReq.deviceType) && JceUtil.equals((Object) this.deviceInfo, (Object) tpnsRegisterReq.deviceInfo) && JceUtil.equals((Object) this.token, (Object) tpnsRegisterReq.token) && JceUtil.equals(this.version, tpnsRegisterReq.version) && JceUtil.equals(this.keyEncrypted, tpnsRegisterReq.keyEncrypted) && JceUtil.equals((Object) this.mutableInfo, (Object) tpnsRegisterReq.mutableInfo) && JceUtil.equals(this.updateAutoTag, tpnsRegisterReq.updateAutoTag) && JceUtil.equals((Object) this.appVersion, (Object) tpnsRegisterReq.appVersion) && JceUtil.equals((Object) this.reserved, (Object) tpnsRegisterReq.reserved) && JceUtil.equals((Object) this.clientid, (Object) tpnsRegisterReq.clientid) && JceUtil.equals(this.guid, tpnsRegisterReq.guid) && JceUtil.equals(this.accountType, tpnsRegisterReq.accountType) && JceUtil.equals(this.f23403ts, tpnsRegisterReq.f23403ts) && JceUtil.equals(this.connVersion, tpnsRegisterReq.connVersion) && JceUtil.equals(this.channelId, tpnsRegisterReq.channelId) && JceUtil.equals(this.otherPushTokenOpType, tpnsRegisterReq.otherPushTokenOpType) && JceUtil.equals(this.otherPushTokenType, tpnsRegisterReq.otherPushTokenType) && JceUtil.equals((Object) this.otherPushToken, (Object) tpnsRegisterReq.otherPushToken) && JceUtil.equals(this.otherPushTokenCrc32, tpnsRegisterReq.otherPushTokenCrc32) && JceUtil.equals(this.tokenCrc32, tpnsRegisterReq.tokenCrc32) && JceUtil.equals((Object) this.otherPushData, (Object) tpnsRegisterReq.otherPushData)) {
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
        jceOutputStream.write(this.accessId, 0);
        jceOutputStream.write(this.accessKey, 1);
        jceOutputStream.write(this.deviceId, 2);
        jceOutputStream.write(this.appCert, 3);
        String str = this.account;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.ticket;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.ticketType, 6);
        jceOutputStream.write(this.deviceType, 7);
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            jceOutputStream.write((JceStruct) deviceInfo2, 8);
        }
        String str3 = this.token;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        jceOutputStream.write(this.version, 10);
        jceOutputStream.write(this.keyEncrypted, 11);
        MutableInfo mutableInfo2 = this.mutableInfo;
        if (mutableInfo2 != null) {
            jceOutputStream.write((JceStruct) mutableInfo2, 12);
        }
        jceOutputStream.write(this.updateAutoTag, 13);
        String str4 = this.appVersion;
        if (str4 != null) {
            jceOutputStream.write(str4, 14);
        }
        String str5 = this.reserved;
        if (str5 != null) {
            jceOutputStream.write(str5, 15);
        }
        String str6 = this.clientid;
        if (str6 != null) {
            jceOutputStream.write(str6, 16);
        }
        jceOutputStream.write(this.guid, 17);
        jceOutputStream.write(this.accountType, 18);
        jceOutputStream.write(this.f23403ts, 19);
        jceOutputStream.write(this.connVersion, 20);
        jceOutputStream.write(this.channelId, 21);
        jceOutputStream.write(this.otherPushTokenOpType, 22);
        jceOutputStream.write(this.otherPushTokenType, 23);
        String str7 = this.otherPushToken;
        if (str7 != null) {
            jceOutputStream.write(str7, 24);
        }
        jceOutputStream.write(this.otherPushTokenCrc32, 25);
        jceOutputStream.write(this.tokenCrc32, 26);
        String str8 = this.otherPushData;
        if (str8 != null) {
            jceOutputStream.write(str8, 27);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.accessId = jceInputStream.read(this.accessId, 0, true);
        this.accessKey = jceInputStream.readString(1, true);
        this.deviceId = jceInputStream.readString(2, true);
        this.appCert = jceInputStream.readString(3, true);
        this.account = jceInputStream.readString(4, false);
        this.ticket = jceInputStream.readString(5, false);
        this.ticketType = jceInputStream.read(this.ticketType, 6, false);
        this.deviceType = jceInputStream.read(this.deviceType, 7, false);
        this.deviceInfo = (DeviceInfo) jceInputStream.read((JceStruct) cache_deviceInfo, 8, false);
        this.token = jceInputStream.readString(9, false);
        this.version = jceInputStream.read(this.version, 10, false);
        this.keyEncrypted = jceInputStream.read(this.keyEncrypted, 11, false);
        this.mutableInfo = (MutableInfo) jceInputStream.read((JceStruct) cache_mutableInfo, 12, false);
        this.updateAutoTag = jceInputStream.read(this.updateAutoTag, 13, false);
        this.appVersion = jceInputStream.readString(14, false);
        this.reserved = jceInputStream.readString(15, false);
        this.clientid = jceInputStream.readString(16, false);
        this.guid = jceInputStream.read(this.guid, 17, false);
        this.accountType = jceInputStream.read(this.accountType, 18, false);
        this.f23403ts = jceInputStream.read(this.f23403ts, 19, false);
        this.connVersion = jceInputStream.read(this.connVersion, 20, false);
        this.channelId = jceInputStream.read(this.channelId, 21, false);
        this.otherPushTokenOpType = jceInputStream.read(this.otherPushTokenOpType, 22, false);
        this.otherPushTokenType = jceInputStream.read(this.otherPushTokenType, 23, false);
        this.otherPushToken = jceInputStream.readString(24, false);
        this.otherPushTokenCrc32 = jceInputStream.read(this.otherPushTokenCrc32, 25, false);
        this.tokenCrc32 = jceInputStream.read(this.tokenCrc32, 26, false);
        this.otherPushData = jceInputStream.readString(27, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.accessId, "accessId");
        jceDisplayer.display(this.accessKey, "accessKey");
        jceDisplayer.display(this.deviceId, Constants.FLAG_DEVICE_ID);
        jceDisplayer.display(this.appCert, "appCert");
        jceDisplayer.display(this.account, "account");
        jceDisplayer.display(this.ticket, Constants.FLAG_TICKET);
        jceDisplayer.display(this.ticketType, Constants.FLAG_TICKET_TYPE);
        jceDisplayer.display(this.deviceType, "deviceType");
        jceDisplayer.display((JceStruct) this.deviceInfo, "deviceInfo");
        jceDisplayer.display(this.token, "token");
        jceDisplayer.display(this.version, AppEntity.KEY_VERSION_STR);
        jceDisplayer.display(this.keyEncrypted, "keyEncrypted");
        jceDisplayer.display((JceStruct) this.mutableInfo, "mutableInfo");
        jceDisplayer.display(this.updateAutoTag, "updateAutoTag");
        jceDisplayer.display(this.appVersion, "appVersion");
        jceDisplayer.display(this.reserved, "reserved");
        jceDisplayer.display(this.clientid, "clientid");
        jceDisplayer.display(this.guid, "guid");
        jceDisplayer.display(this.accountType, "accountType");
        jceDisplayer.display(this.f23403ts, "ts");
        jceDisplayer.display(this.connVersion, "connVersion");
        jceDisplayer.display(this.channelId, C7887a.f26838Mh);
        jceDisplayer.display(this.otherPushTokenOpType, "otherPushTokenOpType");
        jceDisplayer.display(this.otherPushTokenType, "otherPushTokenType");
        jceDisplayer.display(this.otherPushToken, "otherPushToken");
        jceDisplayer.display(this.otherPushTokenCrc32, "otherPushTokenCrc32");
        jceDisplayer.display(this.tokenCrc32, "tokenCrc32");
        jceDisplayer.display(this.otherPushData, "otherPushData");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.accessId, true);
        jceDisplayer.displaySimple(this.accessKey, true);
        jceDisplayer.displaySimple(this.deviceId, true);
        jceDisplayer.displaySimple(this.appCert, true);
        jceDisplayer.displaySimple(this.account, true);
        jceDisplayer.displaySimple(this.ticket, true);
        jceDisplayer.displaySimple(this.ticketType, true);
        jceDisplayer.displaySimple(this.deviceType, true);
        jceDisplayer.displaySimple((JceStruct) this.deviceInfo, true);
        jceDisplayer.displaySimple(this.token, true);
        jceDisplayer.displaySimple(this.version, true);
        jceDisplayer.displaySimple(this.keyEncrypted, true);
        jceDisplayer.displaySimple((JceStruct) this.mutableInfo, true);
        jceDisplayer.displaySimple(this.updateAutoTag, true);
        jceDisplayer.displaySimple(this.appVersion, true);
        jceDisplayer.displaySimple(this.reserved, true);
        jceDisplayer.displaySimple(this.clientid, true);
        jceDisplayer.displaySimple(this.guid, true);
        jceDisplayer.displaySimple(this.accountType, true);
        jceDisplayer.displaySimple(this.f23403ts, true);
        jceDisplayer.displaySimple(this.connVersion, true);
        jceDisplayer.displaySimple(this.channelId, true);
        jceDisplayer.displaySimple(this.otherPushTokenOpType, true);
        jceDisplayer.displaySimple(this.otherPushTokenType, true);
        jceDisplayer.displaySimple(this.otherPushToken, true);
        jceDisplayer.displaySimple(this.otherPushTokenCrc32, true);
        jceDisplayer.displaySimple(this.tokenCrc32, true);
        jceDisplayer.displaySimple(this.otherPushData, false);
    }
}
