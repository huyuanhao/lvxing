package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.mid.api.MidEntity;

/* compiled from: ProGuard */
public final class MutableInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String bssid;
    public String mac;
    public String ssid;
    public String wflist;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.MutableInfo";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.MutableInfo";
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String getBssid() {
        return this.bssid;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public String getWflist() {
        return this.wflist;
    }

    public void setWflist(String str) {
        this.wflist = str;
    }

    public MutableInfo() {
        String str = "";
        this.ssid = str;
        this.bssid = str;
        this.mac = str;
        this.wflist = str;
    }

    public MutableInfo(String str, String str2, String str3, String str4) {
        String str5 = "";
        this.ssid = str5;
        this.bssid = str5;
        this.mac = str5;
        this.wflist = str5;
        this.ssid = str;
        this.bssid = str2;
        this.mac = str3;
        this.wflist = str4;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        MutableInfo mutableInfo = (MutableInfo) obj;
        if (JceUtil.equals((Object) this.ssid, (Object) mutableInfo.ssid) && JceUtil.equals((Object) this.bssid, (Object) mutableInfo.bssid) && JceUtil.equals((Object) this.mac, (Object) mutableInfo.mac) && JceUtil.equals((Object) this.wflist, (Object) mutableInfo.wflist)) {
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
        String str = this.ssid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.bssid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.mac;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.wflist;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.ssid = jceInputStream.readString(0, false);
        this.bssid = jceInputStream.readString(1, false);
        this.mac = jceInputStream.readString(2, false);
        this.wflist = jceInputStream.readString(3, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.ssid, "ssid");
        jceDisplayer.display(this.bssid, "bssid");
        jceDisplayer.display(this.mac, MidEntity.TAG_MAC);
        jceDisplayer.display(this.wflist, "wflist");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.ssid, true);
        jceDisplayer.displaySimple(this.bssid, true);
        jceDisplayer.displaySimple(this.mac, true);
        jceDisplayer.displaySimple(this.wflist, false);
    }
}
