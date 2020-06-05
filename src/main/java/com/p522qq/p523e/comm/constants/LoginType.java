package com.p522qq.p523e.comm.constants;

/* renamed from: com.qq.e.comm.constants.LoginType */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);
    
    /* renamed from: a */
    private int f20180a;

    private LoginType(int i) {
        this.f20180a = i;
        ordinal();
    }

    public final int getValue() {
        return this.f20180a;
    }
}
