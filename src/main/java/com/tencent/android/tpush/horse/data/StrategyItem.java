package com.tencent.android.tpush.horse.data;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: ProGuard */
public class StrategyItem implements Serializable {
    private static final long serialVersionUID = 1692027785653072243L;
    private int protocolType;
    private String proxyIp;
    private int proxyPort;
    private int redirect;
    private String serverIp;
    private int serverPort;

    public StrategyItem(String str, int i, String str2, int i2, int i3, int i4) {
        this.serverIp = str;
        this.serverPort = i;
        this.proxyIp = str2;
        this.proxyPort = i2;
        this.protocolType = i3;
        this.redirect = i4;
    }

    public String getServerIp() {
        return this.serverIp;
    }

    public void setServerIp(String str) {
        this.serverIp = str;
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public void setServerPort(int i) {
        this.serverPort = i;
    }

    public String getProxyIp() {
        return this.proxyIp;
    }

    public void setProxyIp(String str) {
        this.proxyIp = str;
    }

    public int getProtocolType() {
        return this.protocolType;
    }

    public void setProtocolType(int i) {
        this.protocolType = i;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public int getRedirect() {
        return this.redirect;
    }

    public void setRedirect(int i) {
        this.redirect = i;
    }

    public boolean mEquals(StrategyItem strategyItem) {
        return strategyItem != null && this.serverIp.equals(strategyItem.serverIp) && this.serverPort == strategyItem.serverPort && this.proxyIp.equals(strategyItem.proxyIp) && this.proxyPort == strategyItem.proxyPort && this.protocolType == strategyItem.protocolType;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StrategyItem) {
            return mEquals((StrategyItem) obj);
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String str = this.serverIp;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.serverPort) * 31;
        String str2 = this.proxyIp;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return (((((((hashCode + i) * 31) + this.proxyPort) * 31) + this.protocolType) * 31) + this.redirect) & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("serverIp=");
        stringBuffer.append(this.serverIp);
        stringBuffer.append(",serverPort=");
        stringBuffer.append(this.serverPort);
        stringBuffer.append(", proxyIp=");
        stringBuffer.append(this.proxyIp);
        stringBuffer.append(",proxyPort=");
        stringBuffer.append(this.proxyPort);
        stringBuffer.append(", protocolType=");
        stringBuffer.append(this.protocolType == 1 ? "http" : "tcp");
        stringBuffer.append(", redirect=");
        stringBuffer.append(this.redirect);
        return stringBuffer.toString();
    }

    public boolean isFormatOk() {
        return !TextUtils.isEmpty(this.serverIp) && this.serverPort != 0;
    }

    public boolean isWap() {
        return !TextUtils.isEmpty(this.proxyIp);
    }

    public boolean isHttp() {
        return this.protocolType == 1;
    }

    public boolean isRedirected() {
        return this.redirect == 1;
    }
}
