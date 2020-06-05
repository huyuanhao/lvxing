package com.meituan.android.walle;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.meituan.android.walle.f */
public final class WalleChannelReader {
    /* renamed from: a */
    public static String m19531a(Context context, String str) {
        ChannelInfo a = m19530a(context);
        if (a == null) {
            return str;
        }
        return a.mo25364a();
    }

    /* renamed from: a */
    public static ChannelInfo m19530a(Context context) {
        String b = m19532b(context);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        return ChannelReader.m19521a(new File(b));
    }

    /* renamed from: b */
    private static String m19532b(Context context) {
        String str = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            str = applicationInfo.sourceDir;
            return str;
        } catch (Throwable unused) {
        }
    }
}
