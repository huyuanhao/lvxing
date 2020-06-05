package com.tencent.android.tpush.data;

import java.io.Serializable;

/* compiled from: ProGuard */
public class UnregisterInfo implements Serializable {
    public static final byte TYPE_UNINSTALL = 1;
    public static final byte TYPE_UNREGISTER = 0;
    private static final long serialVersionUID = -2293449011577410421L;
    public long accessId;
    public String accessKey;
    public String appCert;
    public byte isUninstall;
    public String option;
    public String packName;
    public long timestamp;
    public String token;

    public UnregisterInfo() {
    }

    public UnregisterInfo(int i, String str, String str2, byte b, String str3) {
        this.accessId = (long) i;
        this.accessKey = str;
        this.token = str2;
        this.isUninstall = b;
        this.packName = str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------UnregisterInfo----------------\n");
        sb.append("accessId=");
        sb.append(this.accessId);
        String str = "\n";
        sb.append(str);
        sb.append("accesskey=");
        sb.append(this.accessKey);
        sb.append(str);
        sb.append("token=");
        sb.append(this.token);
        sb.append(str);
        sb.append("isUninstall=");
        sb.append(this.isUninstall);
        sb.append(str);
        sb.append("packName=");
        sb.append(this.packName);
        sb.append(str);
        sb.append("--------------UnregisterInfo End------------");
        return sb.toString();
    }
}
