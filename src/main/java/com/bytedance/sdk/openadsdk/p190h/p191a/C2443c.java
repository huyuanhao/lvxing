package com.bytedance.sdk.openadsdk.p190h.p191a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.p190h.Preloader;
import com.bytedance.sdk.openadsdk.p190h.Proxy;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/* compiled from: DiskLruCache */
/* renamed from: com.bytedance.sdk.openadsdk.h.a.c */
public class C2443c extends C2440a {
    /* renamed from: a */
    public final File f8752a;
    /* renamed from: b */
    private final LinkedHashMap<String, File> f8753b = new LinkedHashMap<>(0, 0.75f, true);
    /* renamed from: c */
    private final ReentrantReadWriteLock f8754c = new ReentrantReadWriteLock();
    /* renamed from: d */
    private final ReadLock f8755d = this.f8754c.readLock();
    /* renamed from: e */
    private final WriteLock f8756e = this.f8754c.writeLock();
    /* renamed from: f */
    private final Set<C2450a> f8757f = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private|volatile */
    /* renamed from: g */
    public volatile long f8758g = 104857600;
    /* renamed from: h */
    private volatile float f8759h = 0.5f;
    /* renamed from: i */
    private final C2451b f8760i = new C2451b();
    /* renamed from: j */
    private final Runnable f8761j = new Runnable() {
        public void run() {
            TTExecutor.m11692a().mo16808c(new Runnable() {
                public void run() {
                    C2443c.this.m11475b(C2443c.this.f8758g);
                }
            }, 1);
        }
    };
    /* renamed from: k */
    private final Handler f8762k = new Handler(Looper.getMainLooper());

    /* compiled from: DiskLruCache */
    /* renamed from: com.bytedance.sdk.openadsdk.h.a.c$a */
    public interface C2450a {
        /* renamed from: a */
        void mo16690a(String str);

        /* renamed from: a */
        void mo16691a(Set<String> set);
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.bytedance.sdk.openadsdk.h.a.c$b */
    private static final class C2451b {
        /* renamed from: a */
        private final Map<String, Integer> f8771a;

        private C2451b() {
            this.f8771a = new HashMap();
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: a */
        public synchronized void mo16692a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = (Integer) this.f8771a.get(str);
                if (num == null) {
                    this.f8771a.put(str, Integer.valueOf(1));
                } else {
                    this.f8771a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: b */
        public synchronized void mo16693b(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = (Integer) this.f8771a.get(str);
                if (num != null) {
                    if (num.intValue() == 1) {
                        this.f8771a.remove(str);
                    } else {
                        this.f8771a.put(str, Integer.valueOf(num.intValue() - 1));
                    }
                }
            }
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: c */
        public synchronized boolean mo16694c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f8771a.containsKey(str);
        }
    }

    /* renamed from: a */
    public void mo16682a(C2450a aVar) {
        if (aVar != null) {
            this.f8757f.add(aVar);
        }
    }

    public C2443c(File file) throws IOException {
        String str;
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            if (file == null) {
                str = " dir null";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("exists: ");
                sb.append(file.exists());
                sb.append(", isDirectory: ");
                sb.append(file.isDirectory());
                sb.append(", canRead: ");
                sb.append(file.canRead());
                sb.append(", canWrite: ");
                sb.append(file.canWrite());
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("dir error!  ");
            sb2.append(str);
            throw new IOException(sb2.toString());
        }
        this.f8752a = file;
        TTExecutor.m11692a().mo16808c(new Runnable() {
            public void run() {
                C2443c.this.m11474b();
            }
        }, 5);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11474b() {
        this.f8756e.lock();
        try {
            File[] listFiles = this.f8752a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() {
                    /* renamed from: a */
                    public int compare(File file, File file2) {
                        int i = ((((Long) hashMap.get(file)).longValue() - ((Long) hashMap.get(file2)).longValue()) > 0 ? 1 : ((((Long) hashMap.get(file)).longValue() - ((Long) hashMap.get(file2)).longValue()) == 0 ? 0 : -1));
                        if (i < 0) {
                            return -1;
                        }
                        return i > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.f8753b.put(m11472a(file2), file2);
                }
            }
            this.f8756e.unlock();
            m11477c();
        } catch (Throwable th) {
            this.f8756e.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    public void mo16681a(long j) {
        this.f8758g = j;
        m11477c();
    }

    /* renamed from: c */
    private void m11477c() {
        this.f8762k.removeCallbacks(this.f8761j);
        this.f8762k.postDelayed(this.f8761j, 10000);
    }

    /* renamed from: a */
    public void mo16680a() {
        Preloader.m11521c().mo16730d();
        Context a = Proxy.m11537a();
        if (a != null) {
            VideoProxyDB.m11510a(a).mo16711a(0);
        }
        this.f8762k.removeCallbacks(this.f8761j);
        TTExecutor.m11692a().mo16808c(new Runnable() {
            public void run() {
                C2443c.this.m11475b(0);
            }
        }, 1);
    }

    /* renamed from: a */
    public void mo16672a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8760i.mo16692a(str);
        }
    }

    /* renamed from: b */
    public void mo16673b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8760i.mo16693b(str);
        }
    }

    /* renamed from: c */
    public File mo16674c(String str) {
        this.f8755d.lock();
        File file = (File) this.f8753b.get(str);
        this.f8755d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.f8752a, str);
        this.f8756e.lock();
        this.f8753b.put(str, file2);
        this.f8756e.unlock();
        for (C2450a a : this.f8757f) {
            a.mo16690a(str);
        }
        m11477c();
        return file2;
    }

    /* renamed from: d */
    public File mo16675d(String str) {
        if (!this.f8755d.tryLock()) {
            return null;
        }
        File file = (File) this.f8753b.get(str);
        this.f8755d.unlock();
        return file;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dd A[LOOP:3: B:41:0x00d7->B:43:0x00dd, LOOP_END] */
    /* renamed from: b */
    public void m11475b(long r13) {
        /*
        r12 = this;
        java.util.HashSet r0 = new java.util.HashSet
        r0.<init>()
        java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r12.f8756e
        r1.lock()
        r1 = 0
        r3 = 0
        java.util.LinkedHashMap<java.lang.String, java.io.File> r4 = r12.f8753b     // Catch:{ all -> 0x00c7 }
        java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x00c7 }
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00c7 }
    L_0x0017:
        boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00c7 }
        if (r5 == 0) goto L_0x002f
        java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00c7 }
        java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00c7 }
        java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x00c7 }
        java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x00c7 }
        long r5 = r5.length()     // Catch:{ all -> 0x00c7 }
        long r1 = r1 + r5
        goto L_0x0017
    L_0x002f:
        int r4 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
        if (r4 > 0) goto L_0x0039
        java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r13 = r12.f8756e
        r13.unlock()
        return
    L_0x0039:
        float r13 = (float) r13
        float r14 = r12.f8759h     // Catch:{ all -> 0x00c7 }
        float r13 = r13 * r14
        long r13 = (long) r13     // Catch:{ all -> 0x00c7 }
        java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x00c7 }
        r4.<init>()     // Catch:{ all -> 0x00c7 }
        java.util.LinkedHashMap<java.lang.String, java.io.File> r3 = r12.f8753b     // Catch:{ all -> 0x00c5 }
        java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x00c5 }
        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c5 }
    L_0x004e:
        boolean r5 = r3.hasNext()     // Catch:{ all -> 0x00c5 }
        if (r5 == 0) goto L_0x00af
        java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x00c5 }
        java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00c5 }
        java.lang.Object r6 = r5.getValue()     // Catch:{ all -> 0x00c5 }
        java.io.File r6 = (java.io.File) r6     // Catch:{ all -> 0x00c5 }
        if (r6 == 0) goto L_0x00a4
        boolean r7 = r6.exists()     // Catch:{ all -> 0x00c5 }
        if (r7 == 0) goto L_0x00a4
        com.bytedance.sdk.openadsdk.h.a.c$b r7 = r12.f8760i     // Catch:{ all -> 0x00c5 }
        java.lang.String r8 = r12.m11472a(r6)     // Catch:{ all -> 0x00c5 }
        boolean r7 = r7.mo16694c(r8)     // Catch:{ all -> 0x00c5 }
        if (r7 != 0) goto L_0x00ab
        long r7 = r6.length()     // Catch:{ all -> 0x00c5 }
        java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00c5 }
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
        r10.<init>()     // Catch:{ all -> 0x00c5 }
        java.lang.String r11 = r6.getAbsolutePath()     // Catch:{ all -> 0x00c5 }
        r10.append(r11)     // Catch:{ all -> 0x00c5 }
        java.lang.String r11 = "-tmp"
        r10.append(r11)     // Catch:{ all -> 0x00c5 }
        java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00c5 }
        r9.<init>(r10)     // Catch:{ all -> 0x00c5 }
        boolean r6 = r6.renameTo(r9)     // Catch:{ all -> 0x00c5 }
        if (r6 == 0) goto L_0x00ab
        r0.add(r9)     // Catch:{ all -> 0x00c5 }
        long r1 = r1 - r7
        java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x00c5 }
        r4.add(r5)     // Catch:{ all -> 0x00c5 }
        goto L_0x00ab
    L_0x00a4:
        java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x00c5 }
        r4.add(r5)     // Catch:{ all -> 0x00c5 }
    L_0x00ab:
        int r5 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
        if (r5 > 0) goto L_0x004e
    L_0x00af:
        java.util.Iterator r13 = r4.iterator()     // Catch:{ all -> 0x00c5 }
    L_0x00b3:
        boolean r14 = r13.hasNext()     // Catch:{ all -> 0x00c5 }
        if (r14 == 0) goto L_0x00cc
        java.lang.Object r14 = r13.next()     // Catch:{ all -> 0x00c5 }
        java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x00c5 }
        java.util.LinkedHashMap<java.lang.String, java.io.File> r1 = r12.f8753b     // Catch:{ all -> 0x00c5 }
        r1.remove(r14)     // Catch:{ all -> 0x00c5 }
        goto L_0x00b3
    L_0x00c5:
        r13 = move-exception
        goto L_0x00c9
    L_0x00c7:
        r13 = move-exception
        r4 = r3
    L_0x00c9:
        r13.printStackTrace()     // Catch:{ all -> 0x00f5 }
    L_0x00cc:
        java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r13 = r12.f8756e
        r13.unlock()
        java.util.Set<com.bytedance.sdk.openadsdk.h.a.c$a> r13 = r12.f8757f
        java.util.Iterator r13 = r13.iterator()
    L_0x00d7:
        boolean r14 = r13.hasNext()
        if (r14 == 0) goto L_0x00e7
        java.lang.Object r14 = r13.next()
        com.bytedance.sdk.openadsdk.h.a.c$a r14 = (com.bytedance.sdk.openadsdk.p190h.p191a.C2443c.C2450a) r14
        r14.mo16691a(r4)
        goto L_0x00d7
    L_0x00e7:
        com.bytedance.sdk.openadsdk.i.a r13 = com.bytedance.sdk.openadsdk.p198i.TTExecutor.m11692a()
        com.bytedance.sdk.openadsdk.h.a.c$5 r14 = new com.bytedance.sdk.openadsdk.h.a.c$5
        r14.m44053init(r0)
        r0 = 1
        r13.mo16808c(r14, r0)
        return
    L_0x00f5:
        r13 = move-exception
        java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r14 = r12.f8756e
        r14.unlock()
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.p191a.C2443c.m11475b(long):void");
    }

    /* renamed from: a */
    private String m11472a(File file) {
        return file.getName();
    }
}
