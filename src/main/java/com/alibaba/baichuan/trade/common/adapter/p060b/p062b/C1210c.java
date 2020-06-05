package com.alibaba.baichuan.trade.common.adapter.p060b.p062b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.b.b.c */
public class C1210c {
    /* renamed from: a */
    private Map<String, String> f2499a = new HashMap();

    /* renamed from: a */
    public String mo10870a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String str3 = (String) this.f2499a.get(str);
        if (TextUtils.isEmpty(str3)) {
            str3 = str2;
        }
        return str3;
    }
}
