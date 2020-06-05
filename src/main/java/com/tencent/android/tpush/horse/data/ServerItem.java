package com.tencent.android.tpush.horse.data;

import com.tencent.android.tpush.service.p595e.C7056i;
import java.io.Serializable;

/* compiled from: ProGuard */
public class ServerItem implements Serializable {
    private static final long serialVersionUID = -6609283086276910655L;
    private long serverIpLong;
    private String serverIpStr;
    private int serverPort;
    private int spType;

    public ServerItem(String str, int i, int i2) {
        this.serverIpStr = str;
        this.serverIpLong = C7056i.m30195c(this.serverIpStr);
        this.serverPort = i;
        this.spType = i2;
    }

    public ServerItem(long j, int i, int i2) {
        this.serverIpLong = j;
        this.serverIpStr = C7056i.m30176a(j);
        this.serverPort = i;
        this.spType = i2;
    }

    public String getServerIp() {
        return this.serverIpStr;
    }

    public void setServerIp(String str) {
        this.serverIpStr = str;
        this.serverIpLong = C7056i.m30195c(this.serverIpStr);
    }

    public void setServerIp(long j) {
        this.serverIpLong = j;
        this.serverIpStr = C7056i.m30176a(j);
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public void setServerPort(int i) {
        this.serverPort = i;
    }

    private boolean mEquals(ServerItem serverItem) {
        return serverItem != null && serverItem.getServerIp().equals(this.serverIpStr) && serverItem.getServerPort() == this.serverPort && serverItem.getSpType() == this.spType;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ServerItem) {
            return mEquals((ServerItem) obj);
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String str = this.serverIpStr;
        return ((((((str != null ? str.hashCode() : 0) + 31) * 31) + this.serverPort) * 31) + this.spType) & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.serverIpStr);
        sb.append(":");
        sb.append(this.serverPort);
        return sb.toString();
    }

    public int getSpType() {
        return this.spType;
    }

    public void setSpType(int i) {
        this.spType = i;
    }

    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(this.serverIpStr);
        sb.append(":");
        sb.append(this.serverPort);
        return sb.toString();
    }

    public long getServerIpLong() {
        return this.serverIpLong;
    }
}
