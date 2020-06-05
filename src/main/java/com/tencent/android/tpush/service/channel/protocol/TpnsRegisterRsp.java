package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: ProGuard */
public final class TpnsRegisterRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<String> cache_groupKeys = new ArrayList<>();
    public long confVersion = 0;
    public ArrayList<String> groupKeys;
    public long guid;
    public String otherPushToken;
    public long otherPushTokenCrc32;
    public long otherPushTokenType;
    public String reserved;
    public String token;
    public long tokenCrc32;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsRegisterRsp";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsRegisterRsp";
    }

    public long getConfVersion() {
        return this.confVersion;
    }

    public void setConfVersion(long j) {
        this.confVersion = j;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public long getGuid() {
        return this.guid;
    }

    public void setGuid(long j) {
        this.guid = j;
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

    public String getReserved() {
        return this.reserved;
    }

    public void setReserved(String str) {
        this.reserved = str;
    }

    public ArrayList<String> getGroupKeys() {
        return this.groupKeys;
    }

    public void setGroupKeys(ArrayList<String> arrayList) {
        this.groupKeys = arrayList;
    }

    public TpnsRegisterRsp() {
        String str = "";
        this.token = str;
        this.guid = 0;
        this.otherPushTokenType = 0;
        this.otherPushToken = str;
        this.otherPushTokenCrc32 = 0;
        this.tokenCrc32 = 0;
        this.reserved = str;
        this.groupKeys = null;
    }

    public TpnsRegisterRsp(long j, String str, long j2, long j3, String str2, long j4, long j5, String str3, ArrayList<String> arrayList) {
        String str4 = "";
        this.token = str4;
        this.guid = 0;
        this.otherPushTokenType = 0;
        this.otherPushToken = str4;
        this.otherPushTokenCrc32 = 0;
        this.tokenCrc32 = 0;
        this.reserved = str4;
        this.groupKeys = null;
        this.confVersion = j;
        this.token = str;
        this.guid = j2;
        this.otherPushTokenType = j3;
        this.otherPushToken = str2;
        this.otherPushTokenCrc32 = j4;
        this.tokenCrc32 = j5;
        this.reserved = str3;
        this.groupKeys = arrayList;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsRegisterRsp tpnsRegisterRsp = (TpnsRegisterRsp) obj;
        if (JceUtil.equals(this.confVersion, tpnsRegisterRsp.confVersion) && JceUtil.equals((Object) this.token, (Object) tpnsRegisterRsp.token) && JceUtil.equals(this.guid, tpnsRegisterRsp.guid) && JceUtil.equals(this.otherPushTokenType, tpnsRegisterRsp.otherPushTokenType) && JceUtil.equals((Object) this.otherPushToken, (Object) tpnsRegisterRsp.otherPushToken) && JceUtil.equals(this.otherPushTokenCrc32, tpnsRegisterRsp.otherPushTokenCrc32) && JceUtil.equals(this.tokenCrc32, tpnsRegisterRsp.tokenCrc32) && JceUtil.equals((Object) this.reserved, (Object) tpnsRegisterRsp.reserved) && JceUtil.equals((Object) this.groupKeys, (Object) tpnsRegisterRsp.groupKeys)) {
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
        jceOutputStream.write(this.token, 1);
        jceOutputStream.write(this.guid, 2);
        jceOutputStream.write(this.otherPushTokenType, 3);
        String str = this.otherPushToken;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.otherPushTokenCrc32, 5);
        jceOutputStream.write(this.tokenCrc32, 6);
        String str2 = this.reserved;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        ArrayList<String> arrayList = this.groupKeys;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 8);
        }
    }

    static {
        cache_groupKeys.add("");
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.confVersion = jceInputStream.read(this.confVersion, 0, true);
        this.token = jceInputStream.readString(1, true);
        this.guid = jceInputStream.read(this.guid, 2, false);
        this.otherPushTokenType = jceInputStream.read(this.otherPushTokenType, 3, false);
        this.otherPushToken = jceInputStream.readString(4, false);
        this.otherPushTokenCrc32 = jceInputStream.read(this.otherPushTokenCrc32, 5, false);
        this.tokenCrc32 = jceInputStream.read(this.tokenCrc32, 6, false);
        this.reserved = jceInputStream.readString(7, false);
        this.groupKeys = (ArrayList) jceInputStream.read(cache_groupKeys, 8, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.confVersion, "confVersion");
        jceDisplayer.display(this.token, "token");
        jceDisplayer.display(this.guid, "guid");
        jceDisplayer.display(this.otherPushTokenType, "otherPushTokenType");
        jceDisplayer.display(this.otherPushToken, "otherPushToken");
        jceDisplayer.display(this.otherPushTokenCrc32, "otherPushTokenCrc32");
        jceDisplayer.display(this.tokenCrc32, "tokenCrc32");
        jceDisplayer.display(this.reserved, "reserved");
        jceDisplayer.display((Collection<T>) this.groupKeys, "groupKeys");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.confVersion, true);
        jceDisplayer.displaySimple(this.token, true);
        jceDisplayer.displaySimple(this.guid, true);
        jceDisplayer.displaySimple(this.otherPushTokenType, true);
        jceDisplayer.displaySimple(this.otherPushToken, true);
        jceDisplayer.displaySimple(this.otherPushTokenCrc32, true);
        jceDisplayer.displaySimple(this.tokenCrc32, true);
        jceDisplayer.displaySimple(this.reserved, true);
        jceDisplayer.displaySimple((Collection<T>) this.groupKeys, false);
    }
}
