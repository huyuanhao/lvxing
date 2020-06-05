package com.tencent.android.tpush.service.channel.protocol;

import java.io.Serializable;

/* compiled from: ProGuard */
public final class TPNS_CLIENT_REPORT_CMD implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TPNS_CLIENT_REPORT_CMD CMD_REPORT_SPEED = new TPNS_CLIENT_REPORT_CMD(0, 0, "CMD_REPORT_SPEED");
    public static final int _CMD_REPORT_SPEED = 0;
    private static TPNS_CLIENT_REPORT_CMD[] __values = new TPNS_CLIENT_REPORT_CMD[1];
    private String __T = new String();
    private int __value;

    public static TPNS_CLIENT_REPORT_CMD convert(int i) {
        int i2 = 0;
        while (true) {
            TPNS_CLIENT_REPORT_CMD[] tpns_client_report_cmdArr = __values;
            if (i2 >= tpns_client_report_cmdArr.length) {
                return null;
            }
            if (tpns_client_report_cmdArr[i2].value() == i) {
                return __values[i2];
            }
            i2++;
        }
    }

    public static TPNS_CLIENT_REPORT_CMD convert(String str) {
        int i = 0;
        while (true) {
            TPNS_CLIENT_REPORT_CMD[] tpns_client_report_cmdArr = __values;
            if (i >= tpns_client_report_cmdArr.length) {
                return null;
            }
            if (tpns_client_report_cmdArr[i].toString().equals(str)) {
                return __values[i];
            }
            i++;
        }
    }

    public int value() {
        return this.__value;
    }

    public String toString() {
        return this.__T;
    }

    private TPNS_CLIENT_REPORT_CMD(int i, int i2, String str) {
        this.__T = str;
        this.__value = i2;
        __values[i] = this;
    }
}
