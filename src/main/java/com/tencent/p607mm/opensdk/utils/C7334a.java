package com.tencent.p607mm.opensdk.utils;

import android.os.Bundle;

/* renamed from: com.tencent.mm.opensdk.utils.a */
public final class C7334a {
    /* renamed from: a */
    public static int m31631a(Bundle bundle, String str) {
        int i = -1;
        if (bundle == null) {
            return -1;
        }
        try {
            i = bundle.getInt(str, -1);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("getIntExtra exception:");
            sb.append(e.getMessage());
            Log.m31627e("MicroMsg.IntentUtil", sb.toString());
        }
        return i;
    }

    /* renamed from: b */
    public static String m31632b(Bundle bundle, String str) {
        String str2 = null;
        if (bundle == null) {
            return null;
        }
        try {
            str2 = bundle.getString(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("getStringExtra exception:");
            sb.append(e.getMessage());
            Log.m31627e("MicroMsg.IntentUtil", sb.toString());
        }
        return str2;
    }
}
