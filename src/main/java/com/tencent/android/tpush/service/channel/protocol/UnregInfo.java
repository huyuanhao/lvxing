package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import discoveryAD.C7880W.C7881a;

/* compiled from: ProGuard */
public final class UnregInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static AppInfo cache_appInfo = new AppInfo();
    public AppInfo appInfo = null;
    public byte isUninstall = 0;
    public long timestamp = 0;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.UnregInfo";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.UnregInfo";
    }

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public void setAppInfo(AppInfo appInfo2) {
        this.appInfo = appInfo2;
    }

    public byte getIsUninstall() {
        return this.isUninstall;
    }

    public void setIsUninstall(byte b) {
        this.isUninstall = b;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public UnregInfo() {
    }

    public UnregInfo(AppInfo appInfo2, byte b, long j) {
        this.appInfo = appInfo2;
        this.isUninstall = b;
        this.timestamp = j;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        UnregInfo unregInfo = (UnregInfo) obj;
        if (JceUtil.equals((Object) this.appInfo, (Object) unregInfo.appInfo) && JceUtil.equals(this.isUninstall, unregInfo.isUninstall) && JceUtil.equals(this.timestamp, unregInfo.timestamp)) {
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
        jceOutputStream.write((JceStruct) this.appInfo, 0);
        jceOutputStream.write(this.isUninstall, 1);
        jceOutputStream.write(this.timestamp, 2);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.appInfo = (AppInfo) jceInputStream.read((JceStruct) cache_appInfo, 0, true);
        this.isUninstall = jceInputStream.read(this.isUninstall, 1, true);
        this.timestamp = jceInputStream.read(this.timestamp, 2, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display((JceStruct) this.appInfo, "appInfo");
        jceDisplayer.display(this.isUninstall, "isUninstall");
        jceDisplayer.display(this.timestamp, C7881a.TIMESTAMP);
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple((JceStruct) this.appInfo, true);
        jceDisplayer.displaySimple(this.isUninstall, true);
        jceDisplayer.displaySimple(this.timestamp, false);
    }
}
