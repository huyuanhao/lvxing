package com.tencent.stat;

public class StatSpecifyReportedInfo {
    /* renamed from: a */
    private String f25579a = null;
    /* renamed from: b */
    private String f25580b = null;
    /* renamed from: c */
    private String f25581c = null;
    /* renamed from: d */
    private boolean f25582d = false;
    /* renamed from: e */
    private boolean f25583e = false;
    /* renamed from: f */
    private int f25584f = 0;

    public int getFromH5() {
        return this.f25584f;
    }

    public void setFromH5(int i) {
        this.f25584f = i;
    }

    public boolean isSendImmediately() {
        return this.f25582d;
    }

    public void setSendImmediately(boolean z) {
        this.f25582d = z;
    }

    public String getVersion() {
        return this.f25581c;
    }

    public void setVersion(String str) {
        this.f25581c = str;
    }

    public String getAppKey() {
        return this.f25579a;
    }

    public void setAppKey(String str) {
        this.f25579a = str;
    }

    public String getInstallChannel() {
        return this.f25580b;
    }

    public void setInstallChannel(String str) {
        this.f25580b = str;
    }

    public boolean isImportant() {
        return this.f25583e;
    }

    public void setImportant(boolean z) {
        this.f25583e = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatSpecifyReportedInfo [appKey=");
        sb.append(this.f25579a);
        sb.append(", installChannel=");
        sb.append(this.f25580b);
        sb.append(", version=");
        sb.append(this.f25581c);
        sb.append(", sendImmediately=");
        sb.append(this.f25582d);
        sb.append(", isImportant=");
        sb.append(this.f25583e);
        sb.append("]");
        return sb.toString();
    }
}
