package com.kwad.sdk.core.imageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.FlushedInputStream;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
import com.kwad.sdk.core.imageloader.utils.C4246L;
import com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class ImageLoaderConfiguration {
    final boolean customExecutor;
    final boolean customExecutorForCachedImages;
    final ImageDecoder decoder;
    final DisplayImageOptions defaultDisplayImageOptions;
    final DiskCache diskCache;
    final ImageDownloader downloader;
    final int maxImageHeightForDiskCache;
    final int maxImageHeightForMemoryCache;
    final int maxImageWidthForDiskCache;
    final int maxImageWidthForMemoryCache;
    final MemoryCache memoryCache;
    final ImageDownloader networkDeniedDownloader;
    final BitmapProcessor processorForDiskCache;
    final Resources resources;
    final ImageDownloader slowNetworkDownloader;
    final Executor taskExecutor;
    final Executor taskExecutorForCachedImages;
    final QueueProcessingType tasksProcessingType;
    final int threadPoolSize;
    final int threadPriority;

    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration$1 */
    static /* synthetic */ class C42371 {
        /* renamed from: $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme */
        static final /* synthetic */ int[] f14036x3b39606f = new int[Scheme.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.kwad.sdk.core.imageloader.core.download.ImageDownloader$Scheme[] r0 = com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f14036x3b39606f = r0
            int[] r0 = f14036x3b39606f     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.kwad.sdk.core.imageloader.core.download.ImageDownloader$Scheme r1 = com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme.HTTP     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f14036x3b39606f     // Catch:{ NoSuchFieldError -> 0x001f }
            com.kwad.sdk.core.imageloader.core.download.ImageDownloader$Scheme r1 = com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme.HTTPS     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration.C42371.m48080clinit():void");
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration$Builder */
    public static class Builder {
        public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 3;
        private static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
        private static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
        private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public boolean customExecutor = false;
        /* access modifiers changed from: private */
        public boolean customExecutorForCachedImages = false;
        /* access modifiers changed from: private */
        public ImageDecoder decoder;
        /* access modifiers changed from: private */
        public DisplayImageOptions defaultDisplayImageOptions = null;
        private boolean denyCacheImageMultipleSizesInMemory = false;
        /* access modifiers changed from: private */
        public DiskCache diskCache = null;
        private int diskCacheFileCount = 0;
        private FileNameGenerator diskCacheFileNameGenerator = null;
        private long diskCacheSize = 0;
        /* access modifiers changed from: private */
        public ImageDownloader downloader = null;
        /* access modifiers changed from: private */
        public int maxImageHeightForDiskCache = 0;
        /* access modifiers changed from: private */
        public int maxImageHeightForMemoryCache = 0;
        /* access modifiers changed from: private */
        public int maxImageWidthForDiskCache = 0;
        /* access modifiers changed from: private */
        public int maxImageWidthForMemoryCache = 0;
        /* access modifiers changed from: private */
        public MemoryCache memoryCache = null;
        private int memoryCacheSize = 0;
        /* access modifiers changed from: private */
        public BitmapProcessor processorForDiskCache = null;
        /* access modifiers changed from: private */
        public Executor taskExecutor = null;
        /* access modifiers changed from: private */
        public Executor taskExecutorForCachedImages = null;
        /* access modifiers changed from: private */
        public QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
        /* access modifiers changed from: private */
        public int threadPoolSize = 3;
        /* access modifiers changed from: private */
        public int threadPriority = 3;
        /* access modifiers changed from: private */
        public boolean writeLogs = false;

        public Builder(Context context2) {
            this.context = context2.getApplicationContext();
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.taskExecutor == null) {
                this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutor = true;
            }
            if (this.taskExecutorForCachedImages == null) {
                this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutorForCachedImages = true;
            }
            if (this.diskCache == null) {
                if (this.diskCacheFileNameGenerator == null) {
                    this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                }
                this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount);
            }
            if (this.memoryCache == null) {
                this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
            }
            if (this.denyCacheImageMultipleSizesInMemory) {
                this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
            }
            if (this.downloader == null) {
                this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.decoder == null) {
                this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
            }
        }

        public ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        @Deprecated
        public Builder discCache(DiskCache diskCache2) {
            return diskCache(diskCache2);
        }

        @Deprecated
        public Builder discCacheExtraOptions(int i, int i2, BitmapProcessor bitmapProcessor) {
            return diskCacheExtraOptions(i, i2, bitmapProcessor);
        }

        @Deprecated
        public Builder discCacheFileCount(int i) {
            return diskCacheFileCount(i);
        }

        @Deprecated
        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            return diskCacheFileNameGenerator(fileNameGenerator);
        }

        @Deprecated
        public Builder discCacheSize(int i) {
            return diskCacheSize(i);
        }

        public Builder diskCache(DiskCache diskCache2) {
            if (this.diskCacheSize > 0 || this.diskCacheFileCount > 0) {
                C4246L.m17484w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
            }
            if (this.diskCacheFileNameGenerator != null) {
                C4246L.m17484w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCache = diskCache2;
            return this;
        }

        public Builder diskCacheExtraOptions(int i, int i2, BitmapProcessor bitmapProcessor) {
            this.maxImageWidthForDiskCache = i;
            this.maxImageHeightForDiskCache = i2;
            this.processorForDiskCache = bitmapProcessor;
            return this;
        }

        public Builder diskCacheFileCount(int i) {
            if (i > 0) {
                if (this.diskCache != null) {
                    C4246L.m17484w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheFileCount = i;
                return this;
            }
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }

        public Builder diskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            if (this.diskCache != null) {
                C4246L.m17484w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public Builder diskCacheSize(int i) {
            if (i > 0) {
                if (this.diskCache != null) {
                    C4246L.m17484w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheSize = (long) i;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public Builder imageDecoder(ImageDecoder imageDecoder) {
            this.decoder = imageDecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memoryCache2) {
            if (this.memoryCacheSize != 0) {
                C4246L.m17484w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCache = memoryCache2;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i, int i2) {
            this.maxImageWidthForMemoryCache = i;
            this.maxImageHeightForMemoryCache = i2;
            return this;
        }

        public Builder memoryCacheSize(int i) {
            if (i > 0) {
                if (this.memoryCache != null) {
                    C4246L.m17484w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCacheSize = i;
                return this;
            }
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }

        public Builder memoryCacheSizePercentage(int i) {
            if (i <= 0 || i >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.memoryCache != null) {
                C4246L.m17484w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCacheSize = (int) (((float) Runtime.getRuntime().maxMemory()) * (((float) i) / 100.0f));
            return this;
        }

        public Builder taskExecutor(Executor executor) {
            if (!(this.threadPoolSize == 3 && this.threadPriority == 3 && this.tasksProcessingType == DEFAULT_TASK_PROCESSING_TYPE)) {
                C4246L.m17484w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutor = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor) {
            if (!(this.threadPoolSize == 3 && this.threadPriority == 3 && this.tasksProcessingType == DEFAULT_TASK_PROCESSING_TYPE)) {
                C4246L.m17484w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutorForCachedImages = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueProcessingType) {
            if (!(this.taskExecutor == null && this.taskExecutorForCachedImages == null)) {
                C4246L.m17484w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.tasksProcessingType = queueProcessingType;
            return this;
        }

        public Builder threadPoolSize(int i) {
            if (!(this.taskExecutor == null && this.taskExecutorForCachedImages == null)) {
                C4246L.m17484w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.threadPoolSize = i;
            return this;
        }

        public Builder threadPriority(int i) {
            if (!(this.taskExecutor == null && this.taskExecutorForCachedImages == null)) {
                C4246L.m17484w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            int i2 = 1;
            if (i >= 1) {
                i2 = 10;
                if (i <= 10) {
                    this.threadPriority = i;
                    return this;
                }
            }
            this.threadPriority = i2;
            return this;
        }

        public Builder writeDebugLogs() {
            this.writeLogs = true;
            return this;
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration$NetworkDeniedImageDownloader */
    private static class NetworkDeniedImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        public InputStream getStream(String str, Object obj) {
            int i = C42371.f14036x3b39606f[Scheme.ofUri(str).ordinal()];
            if (i != 1 && i != 2) {
                return this.wrappedDownloader.getStream(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration$SlowNetworkImageDownloader */
    private static class SlowNetworkImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        public InputStream getStream(String str, Object obj) {
            InputStream stream = this.wrappedDownloader.getStream(str, obj);
            int i = C42371.f14036x3b39606f[Scheme.ofUri(str).ordinal()];
            return (i == 1 || i == 2) ? new FlushedInputStream(stream) : stream;
        }
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        this.maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        this.processorForDiskCache = builder.processorForDiskCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        this.threadPoolSize = builder.threadPoolSize;
        this.threadPriority = builder.threadPriority;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.diskCache = builder.diskCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        this.downloader = builder.downloader;
        this.decoder = builder.decoder;
        this.customExecutor = builder.customExecutor;
        this.customExecutorForCachedImages = builder.customExecutorForCachedImages;
        this.networkDeniedDownloader = new NetworkDeniedImageDownloader(this.downloader);
        this.slowNetworkDownloader = new SlowNetworkImageDownloader(this.downloader);
        C4246L.writeDebugLogs(builder.writeLogs);
    }

    /* synthetic */ ImageLoaderConfiguration(Builder builder, C42371 r2) {
        this(builder);
    }

    public static ImageLoaderConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    /* access modifiers changed from: 0000 */
    public ImageSize getMaxImageSize() {
        DisplayMetrics displayMetrics = this.resources.getDisplayMetrics();
        int i = this.maxImageWidthForMemoryCache;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.maxImageHeightForMemoryCache;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new ImageSize(i, i2);
    }
}
