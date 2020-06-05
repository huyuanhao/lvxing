package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.b */
public class MultiGlobalInfo {
    /* renamed from: a */
    public static boolean f9078a;
    /* renamed from: b */
    public static boolean f9079b;

    /* renamed from: a */
    public static void m11807a() {
        SPMultiHelper.m11870a("sp_multi_info", "is_support_multi_process", Boolean.valueOf(true));
        f9078a = true;
        f9079b = true;
    }

    /* renamed from: b */
    public static boolean m11808b() {
        if (!f9079b) {
            f9078a = SPMultiHelper.m11877a("sp_multi_info", "is_support_multi_process", false);
            f9079b = true;
        }
        return f9078a;
    }
}
