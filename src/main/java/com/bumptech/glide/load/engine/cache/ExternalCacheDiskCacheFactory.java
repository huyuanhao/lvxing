package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.C1664a;
import java.io.File;

@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i) {
        super(new C1664a() {
            /* renamed from: a */
            public File mo12778a() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                String str = str;
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, (long) i);
    }
}
