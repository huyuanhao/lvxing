package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.InternalContainer;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.e */
public class TTPathConst {
    /* renamed from: a */
    public static String f9098a = "com.bytedance.openadsdk";
    /* renamed from: b */
    public static String f9099b;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(f9098a);
        sb.append(".TTMultiProvider");
        f9099b = sb.toString();
        m11910a();
    }

    /* renamed from: a */
    public static void m11910a() {
        if (InternalContainer.m10059a() != null) {
            f9098a = InternalContainer.m10059a().getPackageName();
            StringBuilder sb = new StringBuilder();
            sb.append("content://");
            sb.append(f9098a);
            sb.append(".TTMultiProvider");
            f9099b = sb.toString();
        }
    }
}
