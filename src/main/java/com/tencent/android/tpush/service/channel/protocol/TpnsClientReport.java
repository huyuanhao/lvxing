package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* compiled from: ProGuard */
public final class TpnsClientReport extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_commandId;
    public long acceptTime;
    public long accip = 0;
    public byte apn = 0;
    public byte available = 0;
    public int commandId = 0;
    public long connectTime;
    public String domain;
    public long downstreamTime;
    public byte isp = 0;
    public String lbs;
    public byte pack = 0;
    public int port = 0;
    public String qua;
    public byte result = 0;
    public long resultCode = 0;
    public String signal;
    public long tmcost = 0;
    public long upstreamTime;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.TpnsClientReport";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.TpnsClientReport";
    }

    public int getCommandId() {
        return this.commandId;
    }

    public void setCommandId(int i) {
        this.commandId = i;
    }

    public byte getIsp() {
        return this.isp;
    }

    public void setIsp(byte b) {
        this.isp = b;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public long getAccip() {
        return this.accip;
    }

    public void setAccip(long j) {
        this.accip = j;
    }

    public byte getApn() {
        return this.apn;
    }

    public void setApn(byte b) {
        this.apn = b;
    }

    public byte getPack() {
        return this.pack;
    }

    public void setPack(byte b) {
        this.pack = b;
    }

    public byte getAvailable() {
        return this.available;
    }

    public void setAvailable(byte b) {
        this.available = b;
    }

    public long getTmcost() {
        return this.tmcost;
    }

    public void setTmcost(long j) {
        this.tmcost = j;
    }

    public byte getResult() {
        return this.result;
    }

    public void setResult(byte b) {
        this.result = b;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(long j) {
        this.resultCode = j;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getQua() {
        return this.qua;
    }

    public void setQua(String str) {
        this.qua = str;
    }

    public long getConnectTime() {
        return this.connectTime;
    }

    public void setConnectTime(long j) {
        this.connectTime = j;
    }

    public long getUpstreamTime() {
        return this.upstreamTime;
    }

    public void setUpstreamTime(long j) {
        this.upstreamTime = j;
    }

    public long getDownstreamTime() {
        return this.downstreamTime;
    }

    public void setDownstreamTime(long j) {
        this.downstreamTime = j;
    }

    public long getAcceptTime() {
        return this.acceptTime;
    }

    public void setAcceptTime(long j) {
        this.acceptTime = j;
    }

    public String getSignal() {
        return this.signal;
    }

    public void setSignal(String str) {
        this.signal = str;
    }

    public String getLbs() {
        return this.lbs;
    }

    public void setLbs(String str) {
        this.lbs = str;
    }

    public TpnsClientReport() {
        String str = "";
        this.domain = str;
        this.qua = str;
        this.connectTime = 0;
        this.upstreamTime = 0;
        this.downstreamTime = 0;
        this.acceptTime = 0;
        this.signal = str;
        this.lbs = str;
    }

    public TpnsClientReport(int i, byte b, int i2, long j, byte b2, byte b3, byte b4, long j2, byte b5, long j3, String str, String str2, long j4, long j5, long j6, long j7, String str3, String str4) {
        String str5 = "";
        this.domain = str5;
        this.qua = str5;
        this.connectTime = 0;
        this.upstreamTime = 0;
        this.downstreamTime = 0;
        this.acceptTime = 0;
        this.signal = str5;
        this.lbs = str5;
        this.commandId = i;
        this.isp = b;
        this.port = i2;
        this.accip = j;
        this.apn = b2;
        this.pack = b3;
        this.available = b4;
        this.tmcost = j2;
        this.result = b5;
        this.resultCode = j3;
        this.domain = str;
        this.qua = str2;
        this.connectTime = j4;
        this.upstreamTime = j5;
        this.downstreamTime = j6;
        this.acceptTime = j7;
        this.signal = str3;
        this.lbs = str4;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        TpnsClientReport tpnsClientReport = (TpnsClientReport) obj;
        if (JceUtil.equals(this.commandId, tpnsClientReport.commandId) && JceUtil.equals(this.isp, tpnsClientReport.isp) && JceUtil.equals(this.port, tpnsClientReport.port) && JceUtil.equals(this.accip, tpnsClientReport.accip) && JceUtil.equals(this.apn, tpnsClientReport.apn) && JceUtil.equals(this.pack, tpnsClientReport.pack) && JceUtil.equals(this.available, tpnsClientReport.available) && JceUtil.equals(this.tmcost, tpnsClientReport.tmcost) && JceUtil.equals(this.result, tpnsClientReport.result) && JceUtil.equals(this.resultCode, tpnsClientReport.resultCode) && JceUtil.equals((Object) this.domain, (Object) tpnsClientReport.domain) && JceUtil.equals((Object) this.qua, (Object) tpnsClientReport.qua) && JceUtil.equals(this.connectTime, tpnsClientReport.connectTime) && JceUtil.equals(this.upstreamTime, tpnsClientReport.upstreamTime) && JceUtil.equals(this.downstreamTime, tpnsClientReport.downstreamTime) && JceUtil.equals(this.acceptTime, tpnsClientReport.acceptTime) && JceUtil.equals((Object) this.signal, (Object) tpnsClientReport.signal) && JceUtil.equals((Object) this.lbs, (Object) tpnsClientReport.lbs)) {
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
        jceOutputStream.write(this.commandId, 0);
        jceOutputStream.write(this.isp, 1);
        jceOutputStream.write(this.port, 2);
        jceOutputStream.write(this.accip, 3);
        jceOutputStream.write(this.apn, 4);
        jceOutputStream.write(this.pack, 5);
        jceOutputStream.write(this.available, 6);
        jceOutputStream.write(this.tmcost, 7);
        jceOutputStream.write(this.result, 8);
        jceOutputStream.write(this.resultCode, 9);
        String str = this.domain;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        String str2 = this.qua;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        jceOutputStream.write(this.connectTime, 12);
        jceOutputStream.write(this.upstreamTime, 13);
        jceOutputStream.write(this.downstreamTime, 14);
        jceOutputStream.write(this.acceptTime, 15);
        String str3 = this.signal;
        if (str3 != null) {
            jceOutputStream.write(str3, 16);
        }
        String str4 = this.lbs;
        if (str4 != null) {
            jceOutputStream.write(str4, 17);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.commandId = jceInputStream.read(this.commandId, 0, false);
        this.isp = jceInputStream.read(this.isp, 1, false);
        this.port = jceInputStream.read(this.port, 2, false);
        this.accip = jceInputStream.read(this.accip, 3, false);
        this.apn = jceInputStream.read(this.apn, 4, false);
        this.pack = jceInputStream.read(this.pack, 5, false);
        this.available = jceInputStream.read(this.available, 6, false);
        this.tmcost = jceInputStream.read(this.tmcost, 7, false);
        this.result = jceInputStream.read(this.result, 8, false);
        this.resultCode = jceInputStream.read(this.resultCode, 9, false);
        this.domain = jceInputStream.readString(10, false);
        this.qua = jceInputStream.readString(11, false);
        this.connectTime = jceInputStream.read(this.connectTime, 12, false);
        this.upstreamTime = jceInputStream.read(this.upstreamTime, 13, false);
        this.downstreamTime = jceInputStream.read(this.downstreamTime, 14, false);
        this.acceptTime = jceInputStream.read(this.acceptTime, 15, false);
        this.signal = jceInputStream.readString(16, false);
        this.lbs = jceInputStream.readString(17, false);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.commandId, "commandId");
        jceDisplayer.display(this.isp, "isp");
        jceDisplayer.display(this.port, "port");
        jceDisplayer.display(this.accip, "accip");
        jceDisplayer.display(this.apn, "apn");
        jceDisplayer.display(this.pack, "pack");
        jceDisplayer.display(this.available, "available");
        jceDisplayer.display(this.tmcost, "tmcost");
        jceDisplayer.display(this.result, ArgKey.KEY_RESULT);
        jceDisplayer.display(this.resultCode, "resultCode");
        jceDisplayer.display(this.domain, "domain");
        jceDisplayer.display(this.qua, "qua");
        jceDisplayer.display(this.connectTime, "connectTime");
        jceDisplayer.display(this.upstreamTime, "upstreamTime");
        jceDisplayer.display(this.downstreamTime, "downstreamTime");
        jceDisplayer.display(this.acceptTime, "acceptTime");
        jceDisplayer.display(this.signal, "signal");
        jceDisplayer.display(this.lbs, "lbs");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.commandId, true);
        jceDisplayer.displaySimple(this.isp, true);
        jceDisplayer.displaySimple(this.port, true);
        jceDisplayer.displaySimple(this.accip, true);
        jceDisplayer.displaySimple(this.apn, true);
        jceDisplayer.displaySimple(this.pack, true);
        jceDisplayer.displaySimple(this.available, true);
        jceDisplayer.displaySimple(this.tmcost, true);
        jceDisplayer.displaySimple(this.result, true);
        jceDisplayer.displaySimple(this.resultCode, true);
        jceDisplayer.displaySimple(this.domain, true);
        jceDisplayer.displaySimple(this.qua, true);
        jceDisplayer.displaySimple(this.connectTime, true);
        jceDisplayer.displaySimple(this.upstreamTime, true);
        jceDisplayer.displaySimple(this.downstreamTime, true);
        jceDisplayer.displaySimple(this.acceptTime, true);
        jceDisplayer.displaySimple(this.signal, true);
        jceDisplayer.displaySimple(this.lbs, false);
    }
}
