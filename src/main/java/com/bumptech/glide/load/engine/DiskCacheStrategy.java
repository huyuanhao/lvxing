package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* renamed from: com.bumptech.glide.load.engine.j */
public abstract class DiskCacheStrategy {
    /* renamed from: a */
    public static final DiskCacheStrategy f4629a = new DiskCacheStrategy() {
        /* renamed from: a */
        public boolean mo12856a() {
            return true;
        }

        /* renamed from: b */
        public boolean mo12859b() {
            return true;
        }

        /* renamed from: a */
        public boolean mo12857a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        /* renamed from: a */
        public boolean mo12858a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    /* renamed from: b */
    public static final DiskCacheStrategy f4630b = new DiskCacheStrategy() {
        /* renamed from: a */
        public boolean mo12856a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo12857a(DataSource dataSource) {
            return false;
        }

        /* renamed from: a */
        public boolean mo12858a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        /* renamed from: b */
        public boolean mo12859b() {
            return false;
        }
    };
    /* renamed from: c */
    public static final DiskCacheStrategy f4631c = new DiskCacheStrategy() {
        /* renamed from: a */
        public boolean mo12856a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo12858a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        /* renamed from: b */
        public boolean mo12859b() {
            return true;
        }

        /* renamed from: a */
        public boolean mo12857a(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    /* renamed from: d */
    public static final DiskCacheStrategy f4632d = new DiskCacheStrategy() {
        /* renamed from: a */
        public boolean mo12856a() {
            return true;
        }

        /* renamed from: a */
        public boolean mo12857a(DataSource dataSource) {
            return false;
        }

        /* renamed from: b */
        public boolean mo12859b() {
            return false;
        }

        /* renamed from: a */
        public boolean mo12858a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    /* renamed from: e */
    public static final DiskCacheStrategy f4633e = new DiskCacheStrategy() {
        /* renamed from: a */
        public boolean mo12856a() {
            return true;
        }

        /* renamed from: b */
        public boolean mo12859b() {
            return true;
        }

        /* renamed from: a */
        public boolean mo12857a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        /* renamed from: a */
        public boolean mo12858a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    /* renamed from: a */
    public abstract boolean mo12856a();

    /* renamed from: a */
    public abstract boolean mo12857a(DataSource dataSource);

    /* renamed from: a */
    public abstract boolean mo12858a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    /* renamed from: b */
    public abstract boolean mo12859b();
}
