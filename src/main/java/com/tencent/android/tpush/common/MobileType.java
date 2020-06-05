package com.tencent.android.tpush.common;

/* compiled from: ProGuard */
public enum MobileType {
    UNKNOWN(0, "未知运营商"),
    TELCOM(1, "中国电信"),
    UNICOM(2, "中国联通"),
    CHINAMOBILE(3, "中国移动");
    
    private String str;
    private byte type;

    private MobileType(byte b, String str2) {
        this.type = b;
        this.str = str2;
    }

    public byte getType() {
        return this.type;
    }

    public String getStr() {
        return this.str;
    }
}
