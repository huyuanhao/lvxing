package com.tencent.p607mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: com.tencent.mm.opensdk.utils.c */
public final class C7336c {

    /* renamed from: com.tencent.mm.opensdk.utils.c$a */
    public static final class C7337a {
        /* renamed from: a */
        public static Object m31634a(int i, String str) {
            String str2 = "MicroMsg.SDK.PluginProvider.Resolver";
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    try {
                        return Double.valueOf(str);
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder("resolveObj exception:");
                        sb.append(e.getMessage());
                        Log.m31627e(str2, sb.toString());
                        break;
                    }
                default:
                    Log.m31627e(str2, "unknown type");
                    break;
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.opensdk.utils.c$b */
    public static final class C7338b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
