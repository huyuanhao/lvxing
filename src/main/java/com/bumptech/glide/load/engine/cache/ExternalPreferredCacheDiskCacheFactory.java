package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.C1664a;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalPreferredCacheDiskCacheFactory(final Context context, final String str, long j) {
        super(new C1664a() {
            /* renamed from: b */
            private File m5526b() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                String str = str;
                return str != null ? new File(cacheDir, str) : cacheDir;
            }

            /* renamed from: a */
            public File mo12778a() {
                File b = m5526b();
                if (b != null && b.exists()) {
                    return b;
                }
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null || !externalCacheDir.canWrite()) {
                    return b;
                }
                String str = str;
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, j);
    }
}
