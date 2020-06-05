package com.tencent.android.tpush.data;

import com.tencent.android.tpush.common.C6905e;
import java.io.Serializable;

/* compiled from: ProGuard */
public class RegisterEntity implements Serializable {
    public static final byte TYPE_REGISTER = 0;
    public static final byte TYPE_REMOTE_UNINSTALL = 4;
    public static final byte TYPE_REMOTE_UNREGISTER = 3;
    public static final byte TYPE_UNINSTALL = 2;
    public static final byte TYPE_UNREGISTER = 1;
    private static final long serialVersionUID = -7991157757568940717L;
    public long accessId;
    public String accessKey;
    public String appVersion;
    public long channelId;
    public long guid;
    public String packageName;
    public int state;
    public long timestamp;
    public String token;
    public float xgSDKVersion = 4.03f;

    public long getGuid() {
        return this.guid;
    }

    public void setGuid(long j) {
        this.guid = j;
    }

    public static String encode(RegisterEntity registerEntity) {
        try {
            return C6905e.m29468a((Serializable) registerEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static RegisterEntity decode(String str) {
        try {
            return (RegisterEntity) C6905e.m29467a(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isRegistered() {
        return this.state == 0;
    }

    public boolean isUnregistered() {
        return this.state == 1;
    }

    public boolean isUnstalled() {
        return this.state == 2;
    }

    public void setRegistered() {
        this.state = 0;
    }

    public void setUnstalled() {
        this.state = 2;
    }

    public void setUnregistered() {
        this.state = 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegisterEntity [accessId=");
        sb.append(this.accessId);
        sb.append(", accessKey=");
        sb.append(this.accessKey);
        sb.append(", token=");
        sb.append(this.token);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", xgSDKVersion=");
        sb.append(this.xgSDKVersion);
        sb.append(", appVersion=");
        sb.append(this.appVersion);
        sb.append(", guid=");
        sb.append(this.guid);
        sb.append("]");
        return sb.toString();
    }
}
