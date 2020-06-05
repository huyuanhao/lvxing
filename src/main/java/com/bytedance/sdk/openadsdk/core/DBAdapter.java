package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.DBHelper.C2234c;

/* renamed from: com.bytedance.sdk.openadsdk.core.e */
public class DBAdapter extends DBHelper {
    /* renamed from: a */
    private static volatile DBAdapter f7498a;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C2234c mo15610a() {
        return super.mo15610a();
    }

    /* renamed from: a */
    public static DBAdapter m9530a(Context context) {
        if (f7498a == null) {
            synchronized (DBAdapter.class) {
                if (f7498a == null) {
                    f7498a = new DBAdapter(context);
                }
            }
        }
        return f7498a;
    }

    private DBAdapter(Context context) {
        super(context);
    }
}
