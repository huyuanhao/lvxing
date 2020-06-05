package com.alipay.sdk.protocol;

import android.text.TextUtils;
import p655io.reactivex.annotations.SchedulerSupport;

/* renamed from: com.alipay.sdk.protocol.a */
public enum C1533a {
    None(SchedulerSupport.NONE),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");
    
    /* renamed from: g */
    private String f3919g;

    private C1533a(String str) {
        this.f3919g = str;
    }

    /* renamed from: a */
    public static C1533a m4593a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        C1533a aVar = None;
        C1533a[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            C1533a aVar2 = values[i];
            if (str.startsWith(aVar2.f3919g)) {
                aVar = aVar2;
                break;
            }
            i++;
        }
        return aVar;
    }
}
