package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
public final class TpnsReconnectReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<TpnsClickClientReport> cache_msgClickList = new ArrayList<>();
    static MutableInfo cache_mutableInfo = new MutableInfo();
    static ArrayList<TpnsPushClientReport> cache_recvMsgList = new ArrayList<>();
    static ArrayList<UnregInfo> cache_unregInfoList = new ArrayList<>();
    public long configVersion;
    public long connVersion;
    public String deviceId;
    public short deviceType = 0;
    public long guid;
    public ArrayList<TpnsClickClientReport> msgClickList = null;
    public MutableInfo mutableInfo = null;
    public short networkType = 0;
    public ArrayList<TpnsPushClientReport> recvMsgList = null;
    public String reserved;
    public String sdkVersion;
    public String token;
    /* renamed from: ts */
    public long f23400ts;
    public ArrayList<UnregInfo> unregInfoList = null;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsReconnectReq";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsReconnectReq";
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public short getNetworkType() {
        return this.networkType;
    }

    public void setNetworkType(short s) {
        this.networkType = s;
    }

    public ArrayList<UnregInfo> getUnregInfoList() {
        return this.unregInfoList;
    }

    public void setUnregInfoList(ArrayList<UnregInfo> arrayList) {
        this.unregInfoList = arrayList;
    }

    public ArrayList<TpnsPushClientReport> getRecvMsgList() {
        return this.recvMsgList;
    }

    public void setRecvMsgList(ArrayList<TpnsPushClientReport> arrayList) {
        this.recvMsgList = arrayList;
    }

    public MutableInfo getMutableInfo() {
        return this.mutableInfo;
    }

    public void setMutableInfo(MutableInfo mutableInfo2) {
        this.mutableInfo = mutableInfo2;
    }

    public short getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(short s) {
        this.deviceType = s;
    }

    public ArrayList<TpnsClickClientReport> getMsgClickList() {
        return this.msgClickList;
    }

    public void setMsgClickList(ArrayList<TpnsClickClientReport> arrayList) {
        this.msgClickList = arrayList;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String getReserved() {
        return this.reserved;
    }

    public void setReserved(String str) {
        this.reserved = str;
    }

    public long getConnVersion() {
        return this.connVersion;
    }

    public void setConnVersion(long j) {
        this.connVersion = j;
    }

    public long getGuid() {
        return this.guid;
    }

    public void setGuid(long j) {
        this.guid = j;
    }

    public long getTs() {
        return this.f23400ts;
    }

    public void setTs(long j) {
        this.f23400ts = j;
    }

    public long getConfigVersion() {
        return this.configVersion;
    }

    public void setConfigVersion(long j) {
        this.configVersion = j;
    }

    public TpnsReconnectReq() {
        String str = "";
        this.token = str;
        this.deviceId = str;
        this.sdkVersion = str;
        this.reserved = str;
        this.connVersion = 0;
        this.guid = 0;
        this.f23400ts = 0;
        this.configVersion = 0;
    }

    public TpnsReconnectReq(String str, String str2, short s, ArrayList<UnregInfo> arrayList, ArrayList<TpnsPushClientReport> arrayList2, MutableInfo mutableInfo2, short s2, ArrayList<TpnsClickClientReport> arrayList3, String str3, String str4, long j, long j2, long j3, long j4) {
        String str5 = "";
        this.token = str5;
        this.deviceId = str5;
        this.sdkVersion = str5;
        this.reserved = str5;
        this.connVersion = 0;
        this.guid = 0;
        this.f23400ts = 0;
        this.configVersion = 0;
        this.token = str;
        this.deviceId = str2;
        this.networkType = s;
        this.unregInfoList = arrayList;
        this.recvMsgList = arrayList2;
        this.mutableInfo = mutableInfo2;
        this.deviceType = s2;
        this.msgClickList = arrayList3;
        this.sdkVersion = str3;
        this.reserved = str4;
        this.connVersion = j;
        this.guid = j2;
        this.f23400ts = j3;
        this.configVersion = j4;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsReconnectReq tpnsReconnectReq = (TpnsReconnectReq) obj;
        if (JceUtil.equals((Object) this.token, (Object) tpnsReconnectReq.token) && JceUtil.equals((Object) this.deviceId, (Object) tpnsReconnectReq.deviceId) && JceUtil.equals(this.networkType, tpnsReconnectReq.networkType) && JceUtil.equals((Object) this.unregInfoList, (Object) tpnsReconnectReq.unregInfoList) && JceUtil.equals((Object) this.recvMsgList, (Object) tpnsReconnectReq.recvMsgList) && JceUtil.equals((Object) this.mutableInfo, (Object) tpnsReconnectReq.mutableInfo) && JceUtil.equals(this.deviceType, tpnsReconnectReq.deviceType) && JceUtil.equals((Object) this.msgClickList, (Object) tpnsReconnectReq.msgClickList) && JceUtil.equals((Object) this.sdkVersion, (Object) tpnsReconnectReq.sdkVersion) && JceUtil.equals((Object) this.reserved, (Object) tpnsReconnectReq.reserved) && JceUtil.equals(this.connVersion, tpnsReconnectReq.connVersion) && JceUtil.equals(this.guid, tpnsReconnectReq.guid) && JceUtil.equals(this.f23400ts, tpnsReconnectReq.f23400ts) && JceUtil.equals(this.configVersion, tpnsReconnectReq.configVersion)) {
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
        jceOutputStream.write(this.token, 0);
        jceOutputStream.write(this.deviceId, 1);
        jceOutputStream.write(this.networkType, 2);
        ArrayList<UnregInfo> arrayList = this.unregInfoList;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 3);
        }
        ArrayList<TpnsPushClientReport> arrayList2 = this.recvMsgList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection<T>) arrayList2, 4);
        }
        MutableInfo mutableInfo2 = this.mutableInfo;
        if (mutableInfo2 != null) {
            jceOutputStream.write((JceStruct) mutableInfo2, 5);
        }
        jceOutputStream.write(this.deviceType, 6);
        ArrayList<TpnsClickClientReport> arrayList3 = this.msgClickList;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection<T>) arrayList3, 7);
        }
        String str = this.sdkVersion;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        String str2 = this.reserved;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        jceOutputStream.write(this.connVersion, 10);
        jceOutputStream.write(this.guid, 11);
        jceOutputStream.write(this.f23400ts, 12);
        jceOutputStream.write(this.configVersion, 13);
    }

    static {
        cache_unregInfoList.add(new UnregInfo());
        cache_recvMsgList.add(new TpnsPushClientReport());
        cache_msgClickList.add(new TpnsClickClientReport());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.token = jceInputStream.readString(0, true);
        this.deviceId = jceInputStream.readString(1, true);
        this.networkType = jceInputStream.read(this.networkType, 2, true);
        this.unregInfoList = (ArrayList) jceInputStream.read(cache_unregInfoList, 3, false);
        this.recvMsgList = (ArrayList) jceInputStream.read(cache_recvMsgList, 4, false);
        this.mutableInfo = (MutableInfo) jceInputStream.read((JceStruct) cache_mutableInfo, 5, false);
        this.deviceType = jceInputStream.read(this.deviceType, 6, false);
        this.msgClickList = (ArrayList) jceInputStream.read(cache_msgClickList, 7, false);
        this.sdkVersion = jceInputStream.readString(8, false);
        this.reserved = jceInputStream.readString(9, false);
        this.connVersion = jceInputStream.read(this.connVersion, 10, false);
        this.guid = jceInputStream.read(this.guid, 11, false);
        this.f23400ts = jceInputStream.read(this.f23400ts, 12, false);
        this.configVersion = jceInputStream.read(this.configVersion, 13, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.token, "token");
        jceDisplayer.display(this.deviceId, Constants.FLAG_DEVICE_ID);
        jceDisplayer.display(this.networkType, "networkType");
        jceDisplayer.display((Collection<T>) this.unregInfoList, "unregInfoList");
        jceDisplayer.display((Collection<T>) this.recvMsgList, "recvMsgList");
        jceDisplayer.display((JceStruct) this.mutableInfo, "mutableInfo");
        jceDisplayer.display(this.deviceType, "deviceType");
        jceDisplayer.display((Collection<T>) this.msgClickList, "msgClickList");
        jceDisplayer.display(this.sdkVersion, "sdkVersion");
        jceDisplayer.display(this.reserved, "reserved");
        jceDisplayer.display(this.connVersion, "connVersion");
        jceDisplayer.display(this.guid, "guid");
        jceDisplayer.display(this.f23400ts, "ts");
        jceDisplayer.display(this.configVersion, "configVersion");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.token, true);
        jceDisplayer.displaySimple(this.deviceId, true);
        jceDisplayer.displaySimple(this.networkType, true);
        jceDisplayer.displaySimple((Collection<T>) this.unregInfoList, true);
        jceDisplayer.displaySimple((Collection<T>) this.recvMsgList, true);
        jceDisplayer.displaySimple((JceStruct) this.mutableInfo, true);
        jceDisplayer.displaySimple(this.deviceType, true);
        jceDisplayer.displaySimple((Collection<T>) this.msgClickList, true);
        jceDisplayer.displaySimple(this.sdkVersion, true);
        jceDisplayer.displaySimple(this.reserved, true);
        jceDisplayer.displaySimple(this.connVersion, true);
        jceDisplayer.displaySimple(this.guid, true);
        jceDisplayer.displaySimple(this.f23400ts, true);
        jceDisplayer.displaySimple(this.configVersion, false);
    }
}
