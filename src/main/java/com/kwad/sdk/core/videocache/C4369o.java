package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* renamed from: com.kwad.sdk.core.videocache.o */
public final class C4369o {
    /* renamed from: a */
    static File m17835a(Context context) {
        return new File(m17836b(context), "video-cache");
    }

    /* renamed from: b */
    private static File m17836b(Context context) {
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(context.getPackageName());
        sb.append("/cache/");
        return new File(sb.toString());
    }
}
