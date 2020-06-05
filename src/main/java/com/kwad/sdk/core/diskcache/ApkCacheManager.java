package com.kwad.sdk.core.diskcache;

import com.kwad.sdk.C3794a;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ApkCacheManager {
    /* renamed from: a */
    private Future f13677a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public File f13678b;
    /* renamed from: c */
    private final ExecutorService f13679c;
    /* renamed from: d */
    private final Callable<Void> f13680d;

    /* renamed from: com.kwad.sdk.core.diskcache.ApkCacheManager$Holder */
    private enum Holder {
        INSTANCE;
        
        private ApkCacheManager mInstance;

        /* access modifiers changed from: 0000 */
        public ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    private ApkCacheManager() {
        this.f13679c = Executors.newSingleThreadExecutor();
        this.f13680d = new Callable<Void>() {
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
            return null;
     */
            /* renamed from: a */
            public java.lang.Void call() {
                /*
                r6 = this;
                java.lang.Class<com.kwad.sdk.core.diskcache.ApkCacheManager> r0 = com.kwad.sdk.core.diskcache.ApkCacheManager.class
                monitor-enter(r0)
                r1 = 0
                com.kwad.sdk.core.diskcache.ApkCacheManager r2 = com.kwad.sdk.core.diskcache.ApkCacheManager.this     // Catch:{ all -> 0x005b }
                java.io.File r2 = r2.f13678b     // Catch:{ all -> 0x005b }
                if (r2 == 0) goto L_0x0059
                com.kwad.sdk.core.diskcache.ApkCacheManager r2 = com.kwad.sdk.core.diskcache.ApkCacheManager.this     // Catch:{ all -> 0x005b }
                java.io.File r2 = r2.f13678b     // Catch:{ all -> 0x005b }
                boolean r2 = r2.exists()     // Catch:{ all -> 0x005b }
                if (r2 == 0) goto L_0x0059
                com.kwad.sdk.core.diskcache.ApkCacheManager r2 = com.kwad.sdk.core.diskcache.ApkCacheManager.this     // Catch:{ all -> 0x005b }
                boolean r2 = r2.m16888c()     // Catch:{ all -> 0x005b }
                if (r2 == 0) goto L_0x0021
                goto L_0x0059
            L_0x0021:
                com.kwad.sdk.core.diskcache.ApkCacheManager r2 = com.kwad.sdk.core.diskcache.ApkCacheManager.this     // Catch:{ all -> 0x005b }
                com.kwad.sdk.core.diskcache.ApkCacheManager r3 = com.kwad.sdk.core.diskcache.ApkCacheManager.this     // Catch:{ all -> 0x005b }
                java.io.File r3 = r3.f13678b     // Catch:{ all -> 0x005b }
                java.util.List r2 = r2.m16889d(r3)     // Catch:{ all -> 0x005b }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x005b }
            L_0x0031:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005b }
                if (r3 == 0) goto L_0x005f
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005b }
                java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x005b }
                java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x005b }
                java.lang.String r5 = ".apk"
                boolean r4 = r4.endsWith(r5)     // Catch:{ all -> 0x005b }
                if (r4 != 0) goto L_0x004a
                goto L_0x0031
            L_0x004a:
                com.kwad.sdk.core.diskcache.ApkCacheManager r4 = com.kwad.sdk.core.diskcache.ApkCacheManager.this     // Catch:{ all -> 0x005b }
                r4.m16887c(r3)     // Catch:{ all -> 0x005b }
                com.kwad.sdk.core.diskcache.ApkCacheManager r3 = com.kwad.sdk.core.diskcache.ApkCacheManager.this     // Catch:{ all -> 0x005b }
                boolean r3 = r3.m16888c()     // Catch:{ all -> 0x005b }
                if (r3 == 0) goto L_0x0031
                monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                return r1
            L_0x0059:
                monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                return r1
            L_0x005b:
                r2 = move-exception
                com.kwad.sdk.core.p319c.C4065b.m16865a(r2)     // Catch:{ all -> 0x0061 }
            L_0x005f:
                monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                return r1
            L_0x0061:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.ApkCacheManager.C40681.call():java.lang.Void");
            }
        };
        if (KsAdSDK.getContext() != null) {
            this.f13678b = C3794a.m15724a(KsAdSDK.getContext());
        }
    }

    /* renamed from: a */
    private int m16879a(File file) {
        return (int) ((((float) m16884b(file)) / 1000.0f) / 1000.0f);
    }

    /* renamed from: a */
    public static ApkCacheManager m16880a() {
        return Holder.INSTANCE.getInstance();
    }

    /* renamed from: a */
    private void m16883a(List<File> list) {
        Collections.sort(list, new Comparator<File>() {
            /* renamed from: a */
            public int compare(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }
        });
    }

    /* renamed from: b */
    private long m16884b(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? m16884b(listFiles[i]) : listFiles[i].length();
            }
        }
        return j;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16887c(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File c : file.listFiles()) {
                        m16887c(c);
                    }
                } else if (!file.exists()) {
                    return;
                }
                file.delete();
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m16888c() {
        File file = this.f13678b;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.f13678b.listFiles();
        return listFiles.length <= 5 || (listFiles.length <= 10 && m16879a(this.f13678b) <= 400);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public List<File> m16889d(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        m16883a((List<File>) arrayList);
        return arrayList;
    }

    /* renamed from: b */
    public void mo23729b() {
        File file = this.f13678b;
        if (file != null && file.exists()) {
            Future future = this.f13677a;
            if (future == null || future.isDone()) {
                this.f13677a = this.f13679c.submit(this.f13680d);
            }
        }
    }
}
