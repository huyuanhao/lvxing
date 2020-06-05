package com.alibaba.baichuan.trade.common.utils;

import android.content.Context;

/* renamed from: com.alibaba.baichuan.trade.common.utils.d */
public class C1230d {
    /* renamed from: a */
    public static int m2426a(Context context, String str) {
        return m2427a(context, "layout", str);
    }

    /* renamed from: a */
    public static int m2427a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
    }
}
