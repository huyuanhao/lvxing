package com.tencent.p605ep.commonbase.QQPIM;

import java.io.Serializable;

/* renamed from: com.tencent.ep.commonbase.QQPIM.ConnectType */
public final class ConnectType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ConnectType.class.desiredAssertionStatus());
    public static final ConnectType CT_3G_NET = new ConnectType(5, 5, "CT_3G_NET");
    public static final ConnectType CT_GPRS = new ConnectType(1, 1, "CT_GPRS");
    public static final ConnectType CT_GPRS_NET = new ConnectType(4, 4, "CT_GPRS_NET");
    public static final ConnectType CT_GPRS_WAP = new ConnectType(3, 3, "CT_GPRS_WAP");
    public static final ConnectType CT_NONE = new ConnectType(0, 0, "CT_NONE");
    public static final ConnectType CT_WIFI = new ConnectType(2, 2, "CT_WIFI");
    public static final int _CT_3G_NET = 5;
    public static final int _CT_GPRS = 1;
    public static final int _CT_GPRS_NET = 4;
    public static final int _CT_GPRS_WAP = 3;
    public static final int _CT_NONE = 0;
    public static final int _CT_WIFI = 2;
    private static ConnectType[] __values = new ConnectType[6];
    private String __T = new String();
    private int __value;

    private ConnectType(int i, int i2, String str) {
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }

    public static ConnectType convert(int i) {
        int i2 = 0;
        while (true) {
            ConnectType[] connectTypeArr = __values;
            if (i2 < connectTypeArr.length) {
                if (connectTypeArr[i2].value() == i) {
                    return __values[i2];
                }
                i2++;
            } else if ($assertionsDisabled) {
                return null;
            } else {
                throw new AssertionError();
            }
        }
    }

    public static ConnectType convert(String str) {
        int i = 0;
        while (true) {
            ConnectType[] connectTypeArr = __values;
            if (i < connectTypeArr.length) {
                if (connectTypeArr[i].toString().equals(str)) {
                    return __values[i];
                }
                i++;
            } else if ($assertionsDisabled) {
                return null;
            } else {
                throw new AssertionError();
            }
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }
}
