package com.bumptech.glide.load.p135a.p136a;

import android.net.Uri;
import com.tencent.android.tpush.common.MessageKey;

/* renamed from: com.bumptech.glide.load.a.a.b */
public final class MediaStoreUtil {
    /* renamed from: a */
    public static boolean m5300a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    /* renamed from: a */
    public static boolean m5301a(Uri uri) {
        if (uri != null) {
            if (MessageKey.MSG_CONTENT.equals(uri.getScheme())) {
                if ("media".equals(uri.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    private static boolean m5304d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    /* renamed from: b */
    public static boolean m5302b(Uri uri) {
        return m5301a(uri) && m5304d(uri);
    }

    /* renamed from: c */
    public static boolean m5303c(Uri uri) {
        return m5301a(uri) && !m5304d(uri);
    }
}
