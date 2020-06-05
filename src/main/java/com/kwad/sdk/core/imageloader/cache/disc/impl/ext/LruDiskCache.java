package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Editor;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.C4246L;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.IoUtils.CopyListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final CompressFormat DEFAULT_COMPRESS_FORMAT = CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected DiskLruCache cache;
    protected CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator2, long j) {
        this(file, null, fileNameGenerator2, j, 0);
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator2, long j, int i) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file != null) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
            } else if (i < 0) {
                throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
            } else if (fileNameGenerator2 != null) {
                if (i2 == 0) {
                    j = Long.MAX_VALUE;
                }
                long j2 = j;
                int i3 = i == 0 ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i;
                this.reserveCacheDir = file2;
                this.fileNameGenerator = fileNameGenerator2;
                initCache(file, file2, j2, i3);
            } else {
                throw new IllegalArgumentException("fileNameGenerator argument must be not null");
            }
        } else {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j, int i) {
        try {
            this.cache = DiskLruCache.open(file, 1, 1, j, i);
        } catch (IOException e) {
            C4246L.m17481e(e);
            if (file2 != null) {
                initCache(file2, null, j, i);
            }
            if (this.cache == null) {
                throw e;
            }
        }
    }

    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e) {
            C4246L.m17481e(e);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
        } catch (IOException e2) {
            C4246L.m17481e(e2);
        }
    }

    public void close() {
        try {
            this.cache.close();
        } catch (IOException e) {
            C4246L.m17481e(e);
        }
        this.cache = null;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot] */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v7, types: [com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot] */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
  assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.io.File]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARNING: Unknown variable types count: 5 */
    public java.io.File get(java.lang.String r4) {
        /*
        r3 = this;
        r0 = 0
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = r3.cache     // Catch:{ IOException -> 0x001d, all -> 0x001b }
        java.lang.String r4 = r3.getKey(r4)     // Catch:{ IOException -> 0x001d, all -> 0x001b }
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot r4 = r1.get(r4)     // Catch:{ IOException -> 0x001d, all -> 0x001b }
        if (r4 != 0) goto L_0x000e
        goto L_0x0013
    L_0x000e:
        r1 = 0
        java.io.File r0 = r4.getFile(r1)     // Catch:{ IOException -> 0x0019 }
    L_0x0013:
        if (r4 == 0) goto L_0x0018
        r4.close()
    L_0x0018:
        return r0
    L_0x0019:
        r1 = move-exception
        goto L_0x001f
    L_0x001b:
        r4 = move-exception
        goto L_0x002c
    L_0x001d:
        r1 = move-exception
        r4 = r0
    L_0x001f:
        com.kwad.sdk.core.imageloader.utils.C4246L.m17481e(r1)     // Catch:{ all -> 0x0028 }
        if (r4 == 0) goto L_0x0027
        r4.close()
    L_0x0027:
        return r0
    L_0x0028:
        r0 = move-exception
        r2 = r0
        r0 = r4
        r4 = r2
    L_0x002c:
        if (r0 == 0) goto L_0x0031
        r0.close()
    L_0x0031:
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.LruDiskCache.get(java.lang.String):java.io.File");
    }

    public File getDirectory() {
        return this.cache.getDirectory();
    }

    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e) {
            C4246L.m17481e(e);
            return false;
        }
    }

    public boolean save(String str, Bitmap bitmap) {
        Editor edit = this.cache.edit(getKey(str));
        if (edit == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                edit.commit();
            } else {
                edit.abort();
            }
            return compress;
        } finally {
            IoUtils.closeSilently(bufferedOutputStream);
        }
    }

    public boolean save(String str, InputStream inputStream, CopyListener copyListener) {
        Editor edit = this.cache.edit(getKey(str));
        if (edit == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            IoUtils.closeSilently(bufferedOutputStream);
            if (copyStream) {
                edit.commit();
            } else {
                edit.abort();
            }
            return copyStream;
        } catch (Throwable th) {
            IoUtils.closeSilently(bufferedOutputStream);
            edit.abort();
            throw th;
        }
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setCompressFormat(CompressFormat compressFormat2) {
        this.compressFormat = compressFormat2;
    }

    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }
}
