package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

public final class GDTSDKReportItem extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!GDTSDKReportItem.class.desiredAssertionStatus());
    /* renamed from: Jb */
    static int f25118Jb = 0;
    public long adPullTimestamp = 0;
    public String appId;
    public double ecpm;
    public String errMsg;
    public String gdtPositionId;
    public boolean isSuccess = true;
    public String positionId;
    public int reportState = 0;

    public GDTSDKReportItem() {
        String str = "";
        this.gdtPositionId = str;
        this.appId = str;
        this.errMsg = str;
        this.ecpm = 0.0d;
        this.positionId = str;
    }

    public GDTSDKReportItem(String str, String str2, long j, int i, boolean z, String str3, double d, String str4) {
        String str5 = "";
        this.gdtPositionId = str5;
        this.appId = str5;
        this.errMsg = str5;
        this.ecpm = 0.0d;
        this.positionId = str5;
        this.gdtPositionId = str;
        this.appId = str2;
        this.adPullTimestamp = j;
        this.reportState = i;
        this.isSuccess = z;
        this.errMsg = str3;
        this.ecpm = d;
        this.positionId = str4;
    }

    public String className() {
        return "GDTSDKReportItem";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.gdtPositionId, "gdtPositionId");
        jceDisplayer.display(this.appId, "appId");
        jceDisplayer.display(this.adPullTimestamp, "adPullTimestamp");
        jceDisplayer.display(this.reportState, "reportState");
        jceDisplayer.display(this.isSuccess, "isSuccess");
        jceDisplayer.display(this.errMsg, "errMsg");
        jceDisplayer.display(this.ecpm, "ecpm");
        jceDisplayer.display(this.positionId, "positionId");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.gdtPositionId, true);
        jceDisplayer.displaySimple(this.appId, true);
        jceDisplayer.displaySimple(this.adPullTimestamp, true);
        jceDisplayer.displaySimple(this.reportState, true);
        jceDisplayer.displaySimple(this.isSuccess, true);
        jceDisplayer.displaySimple(this.errMsg, true);
        jceDisplayer.displaySimple(this.ecpm, true);
        jceDisplayer.displaySimple(this.positionId, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        GDTSDKReportItem gDTSDKReportItem = (GDTSDKReportItem) obj;
        if (JceUtil.equals((Object) this.gdtPositionId, (Object) gDTSDKReportItem.gdtPositionId) && JceUtil.equals((Object) this.appId, (Object) gDTSDKReportItem.appId) && JceUtil.equals(this.adPullTimestamp, gDTSDKReportItem.adPullTimestamp) && JceUtil.equals(this.reportState, gDTSDKReportItem.reportState) && JceUtil.equals(this.isSuccess, gDTSDKReportItem.isSuccess) && JceUtil.equals((Object) this.errMsg, (Object) gDTSDKReportItem.errMsg) && JceUtil.equals(this.ecpm, gDTSDKReportItem.ecpm) && JceUtil.equals((Object) this.positionId, (Object) gDTSDKReportItem.positionId)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.GDTSDKReportItem";
    }

    public long getAdPullTimestamp() {
        return this.adPullTimestamp;
    }

    public String getAppId() {
        return this.appId;
    }

    public double getEcpm() {
        return this.ecpm;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getGdtPositionId() {
        return this.gdtPositionId;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public String getPositionId() {
        return this.positionId;
    }

    public int getReportState() {
        return this.reportState;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.gdtPositionId = jceInputStream.readString(0, true);
        this.appId = jceInputStream.readString(1, true);
        this.adPullTimestamp = jceInputStream.read(this.adPullTimestamp, 2, true);
        this.reportState = jceInputStream.read(this.reportState, 3, true);
        this.isSuccess = jceInputStream.read(this.isSuccess, 4, true);
        this.errMsg = jceInputStream.readString(5, false);
        this.ecpm = jceInputStream.read(this.ecpm, 6, false);
        this.positionId = jceInputStream.readString(7, false);
    }

    public void setAdPullTimestamp(long j) {
        this.adPullTimestamp = j;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setEcpm(double d) {
        this.ecpm = d;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setGdtPositionId(String str) {
        this.gdtPositionId = str;
    }

    public void setIsSuccess(boolean z) {
        this.isSuccess = z;
    }

    public void setPositionId(String str) {
        this.positionId = str;
    }

    public void setReportState(int i) {
        this.reportState = i;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.gdtPositionId, 0);
        jceOutputStream.write(this.appId, 1);
        jceOutputStream.write(this.adPullTimestamp, 2);
        jceOutputStream.write(this.reportState, 3);
        jceOutputStream.write(this.isSuccess, 4);
        String str = this.errMsg;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.ecpm, 6);
        String str2 = this.positionId;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
    }
}
