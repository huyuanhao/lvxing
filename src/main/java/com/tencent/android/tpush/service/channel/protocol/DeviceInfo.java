package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.mid.api.MidEntity;

/* compiled from: ProGuard */
public final class DeviceInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String apiLevel;
    public String appList;
    public String cpuInfo;
    public String imei;
    public long isRooted = 0;
    public String language;
    public String launcherName;
    public String manu;
    public String model;
    public String network;
    /* renamed from: os */
    public String f23397os;
    public String resolution;
    public String sdCard;
    public String sdDouble;
    public String sdkVersion;
    public String sdkVersionName;
    public String timezone;
    public String xgAppList;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.DeviceInfo";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.DeviceInfo";
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getOs() {
        return this.f23397os;
    }

    public void setOs(String str) {
        this.f23397os = str;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String str) {
        this.network = str;
    }

    public String getSdCard() {
        return this.sdCard;
    }

    public void setSdCard(String str) {
        this.sdCard = str;
    }

    public String getSdDouble() {
        return this.sdDouble;
    }

    public void setSdDouble(String str) {
        this.sdDouble = str;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public String getManu() {
        return this.manu;
    }

    public void setManu(String str) {
        this.manu = str;
    }

    public String getApiLevel() {
        return this.apiLevel;
    }

    public void setApiLevel(String str) {
        this.apiLevel = str;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public void setSdkVersionName(String str) {
        this.sdkVersionName = str;
    }

    public long getIsRooted() {
        return this.isRooted;
    }

    public void setIsRooted(long j) {
        this.isRooted = j;
    }

    public String getAppList() {
        return this.appList;
    }

    public void setAppList(String str) {
        this.appList = str;
    }

    public String getCpuInfo() {
        return this.cpuInfo;
    }

    public void setCpuInfo(String str) {
        this.cpuInfo = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public String getLauncherName() {
        return this.launcherName;
    }

    public void setLauncherName(String str) {
        this.launcherName = str;
    }

    public String getXgAppList() {
        return this.xgAppList;
    }

    public void setXgAppList(String str) {
        this.xgAppList = str;
    }

    public DeviceInfo() {
        String str = "";
        this.imei = str;
        this.model = str;
        this.f23397os = str;
        this.network = str;
        this.sdCard = str;
        this.sdDouble = str;
        this.resolution = str;
        this.manu = str;
        this.apiLevel = str;
        this.sdkVersion = str;
        this.sdkVersionName = str;
        this.appList = str;
        this.cpuInfo = str;
        this.language = str;
        this.timezone = str;
        this.launcherName = str;
        this.xgAppList = str;
    }

    public DeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j, String str12, String str13, String str14, String str15, String str16, String str17) {
        String str18 = "";
        this.imei = str18;
        this.model = str18;
        this.f23397os = str18;
        this.network = str18;
        this.sdCard = str18;
        this.sdDouble = str18;
        this.resolution = str18;
        this.manu = str18;
        this.apiLevel = str18;
        this.sdkVersion = str18;
        this.sdkVersionName = str18;
        this.appList = str18;
        this.cpuInfo = str18;
        this.language = str18;
        this.timezone = str18;
        this.launcherName = str18;
        this.xgAppList = str18;
        this.imei = str;
        this.model = str2;
        this.f23397os = str3;
        this.network = str4;
        this.sdCard = str5;
        this.sdDouble = str6;
        this.resolution = str7;
        this.manu = str8;
        this.apiLevel = str9;
        this.sdkVersion = str10;
        this.sdkVersionName = str11;
        this.isRooted = j;
        this.appList = str12;
        this.cpuInfo = str13;
        this.language = str14;
        this.timezone = str15;
        this.launcherName = str16;
        this.xgAppList = str17;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (JceUtil.equals((Object) this.imei, (Object) deviceInfo.imei) && JceUtil.equals((Object) this.model, (Object) deviceInfo.model) && JceUtil.equals((Object) this.f23397os, (Object) deviceInfo.f23397os) && JceUtil.equals((Object) this.network, (Object) deviceInfo.network) && JceUtil.equals((Object) this.sdCard, (Object) deviceInfo.sdCard) && JceUtil.equals((Object) this.sdDouble, (Object) deviceInfo.sdDouble) && JceUtil.equals((Object) this.resolution, (Object) deviceInfo.resolution) && JceUtil.equals((Object) this.manu, (Object) deviceInfo.manu) && JceUtil.equals((Object) this.apiLevel, (Object) deviceInfo.apiLevel) && JceUtil.equals((Object) this.sdkVersion, (Object) deviceInfo.sdkVersion) && JceUtil.equals((Object) this.sdkVersionName, (Object) deviceInfo.sdkVersionName) && JceUtil.equals(this.isRooted, deviceInfo.isRooted) && JceUtil.equals((Object) this.appList, (Object) deviceInfo.appList) && JceUtil.equals((Object) this.cpuInfo, (Object) deviceInfo.cpuInfo) && JceUtil.equals((Object) this.language, (Object) deviceInfo.language) && JceUtil.equals((Object) this.timezone, (Object) deviceInfo.timezone) && JceUtil.equals((Object) this.launcherName, (Object) deviceInfo.launcherName) && JceUtil.equals((Object) this.xgAppList, (Object) deviceInfo.xgAppList)) {
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
        String str = this.imei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.model;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.f23397os;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.network;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.sdCard;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.sdDouble;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.resolution;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        String str8 = this.manu;
        if (str8 != null) {
            jceOutputStream.write(str8, 7);
        }
        String str9 = this.apiLevel;
        if (str9 != null) {
            jceOutputStream.write(str9, 8);
        }
        String str10 = this.sdkVersion;
        if (str10 != null) {
            jceOutputStream.write(str10, 9);
        }
        String str11 = this.sdkVersionName;
        if (str11 != null) {
            jceOutputStream.write(str11, 10);
        }
        jceOutputStream.write(this.isRooted, 11);
        String str12 = this.appList;
        if (str12 != null) {
            jceOutputStream.write(str12, 12);
        }
        String str13 = this.cpuInfo;
        if (str13 != null) {
            jceOutputStream.write(str13, 13);
        }
        String str14 = this.language;
        if (str14 != null) {
            jceOutputStream.write(str14, 14);
        }
        String str15 = this.timezone;
        if (str15 != null) {
            jceOutputStream.write(str15, 15);
        }
        String str16 = this.launcherName;
        if (str16 != null) {
            jceOutputStream.write(str16, 16);
        }
        String str17 = this.xgAppList;
        if (str17 != null) {
            jceOutputStream.write(str17, 17);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, false);
        this.model = jceInputStream.readString(1, false);
        this.f23397os = jceInputStream.readString(2, false);
        this.network = jceInputStream.readString(3, false);
        this.sdCard = jceInputStream.readString(4, false);
        this.sdDouble = jceInputStream.readString(5, false);
        this.resolution = jceInputStream.readString(6, false);
        this.manu = jceInputStream.readString(7, false);
        this.apiLevel = jceInputStream.readString(8, false);
        this.sdkVersion = jceInputStream.readString(9, false);
        this.sdkVersionName = jceInputStream.readString(10, false);
        this.isRooted = jceInputStream.read(this.isRooted, 11, false);
        this.appList = jceInputStream.readString(12, false);
        this.cpuInfo = jceInputStream.readString(13, false);
        this.language = jceInputStream.readString(14, false);
        this.timezone = jceInputStream.readString(15, false);
        this.launcherName = jceInputStream.readString(16, false);
        this.xgAppList = jceInputStream.readString(17, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.imei, MidEntity.TAG_IMEI);
        jceDisplayer.display(this.model, "model");
        jceDisplayer.display(this.f23397os, "os");
        jceDisplayer.display(this.network, "network");
        jceDisplayer.display(this.sdCard, "sdCard");
        jceDisplayer.display(this.sdDouble, "sdDouble");
        jceDisplayer.display(this.resolution, "resolution");
        jceDisplayer.display(this.manu, "manu");
        jceDisplayer.display(this.apiLevel, "apiLevel");
        jceDisplayer.display(this.sdkVersion, "sdkVersion");
        jceDisplayer.display(this.sdkVersionName, "sdkVersionName");
        jceDisplayer.display(this.isRooted, "isRooted");
        jceDisplayer.display(this.appList, "appList");
        jceDisplayer.display(this.cpuInfo, "cpuInfo");
        jceDisplayer.display(this.language, "language");
        jceDisplayer.display(this.timezone, "timezone");
        jceDisplayer.display(this.launcherName, "launcherName");
        jceDisplayer.display(this.xgAppList, "xgAppList");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.imei, true);
        jceDisplayer.displaySimple(this.model, true);
        jceDisplayer.displaySimple(this.f23397os, true);
        jceDisplayer.displaySimple(this.network, true);
        jceDisplayer.displaySimple(this.sdCard, true);
        jceDisplayer.displaySimple(this.sdDouble, true);
        jceDisplayer.displaySimple(this.resolution, true);
        jceDisplayer.displaySimple(this.manu, true);
        jceDisplayer.displaySimple(this.apiLevel, true);
        jceDisplayer.displaySimple(this.sdkVersion, true);
        jceDisplayer.displaySimple(this.sdkVersionName, true);
        jceDisplayer.displaySimple(this.isRooted, true);
        jceDisplayer.displaySimple(this.appList, true);
        jceDisplayer.displaySimple(this.cpuInfo, true);
        jceDisplayer.displaySimple(this.language, true);
        jceDisplayer.displaySimple(this.timezone, true);
        jceDisplayer.displaySimple(this.launcherName, true);
        jceDisplayer.displaySimple(this.xgAppList, false);
    }
}
