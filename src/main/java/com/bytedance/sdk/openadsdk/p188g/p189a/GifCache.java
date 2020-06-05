package com.bytedance.sdk.openadsdk.p188g.p189a;

import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.p164b.DiskUsage;
import com.bytedance.sdk.openadsdk.p164b.TotalSizeLruDiskUsage;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import java.io.File;
import java.util.WeakHashMap;

/* renamed from: com.bytedance.sdk.openadsdk.g.a.a */
public class GifCache {
    /* renamed from: a */
    private static String f8669a;
    /* renamed from: e */
    private static volatile GifCache f8670e;
    /* renamed from: b */
    private WeakHashMap<String, String> f8671b = new WeakHashMap<>();
    /* renamed from: c */
    private final DiskUsage f8672c = new TotalSizeLruDiskUsage();
    /* renamed from: d */
    private final LruCache<String, C2426a> f8673d = new LruCache<String, C2426a>(5242880) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, C2426a aVar) {
            int i = 0;
            if (aVar.f8675a != null) {
                i = 0 + aVar.f8675a.length;
            }
            return i == 0 ? super.sizeOf(str, aVar) : i;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, C2426a aVar, C2426a aVar2) {
            super.entryRemoved(z, str, aVar, aVar2);
            if (z && aVar != null) {
                aVar.f8675a = null;
            }
        }
    };

    /* compiled from: GifCache */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.a$a */
    public static class C2426a {
        /* renamed from: a */
        byte[] f8675a;

        public C2426a(byte[] bArr) {
            this.f8675a = bArr;
        }
    }

    /* renamed from: a */
    public static GifCache m11369a() {
        if (f8670e == null) {
            synchronized (GifCache.class) {
                if (f8670e == null) {
                    f8670e = new GifCache();
                }
            }
        }
        return f8670e;
    }

    private GifCache() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:42|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r8.delete();
            r0.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
            if (r4 == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a4, code lost:
            return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0091 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00a2 */
    /* renamed from: a */
    public synchronized void mo16626a(java.lang.String r8, byte[] r9) {
        /*
        r7 = this;
        monitor-enter(r7)
        boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x00a3
        if (r9 != 0) goto L_0x000b
        goto L_0x00a3
    L_0x000b:
        boolean r0 = r7.m11370a(r9)     // Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x0024
        android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.g.a.a$a> r0 = r7.f8673d     // Catch:{ all -> 0x001c }
        com.bytedance.sdk.openadsdk.g.a.a$a r1 = new com.bytedance.sdk.openadsdk.g.a.a$a     // Catch:{ all -> 0x001c }
        r1.m44022init(r9)     // Catch:{ all -> 0x001c }
        r0.put(r8, r1)     // Catch:{ all -> 0x001c }
        goto L_0x0024
    L_0x001c:
        r0 = move-exception
        java.lang.String r1 = "GifCache"
        java.lang.String r2 = "gifCache mLruCache.put error "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r2, r0)     // Catch:{ all -> 0x00a5 }
    L_0x0024:
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00a5 }
        java.lang.String r1 = m11371b()     // Catch:{ all -> 0x00a5 }
        r0.<init>(r1, r8)     // Catch:{ all -> 0x00a5 }
        boolean r8 = r0.exists()     // Catch:{ all -> 0x00a5 }
        r1 = 0
        if (r8 == 0) goto L_0x0045
        boolean r8 = r0.isFile()     // Catch:{ all -> 0x00a5 }
        if (r8 == 0) goto L_0x0045
        long r3 = r0.length()     // Catch:{ all -> 0x00a5 }
        int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
        if (r8 <= 0) goto L_0x0045
        monitor-exit(r7)
        return
    L_0x0045:
        java.io.File r8 = new java.io.File     // Catch:{ all -> 0x00a5 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
        r3.<init>()     // Catch:{ all -> 0x00a5 }
        r3.append(r0)     // Catch:{ all -> 0x00a5 }
        java.lang.String r4 = ".tmp"
        r3.append(r4)     // Catch:{ all -> 0x00a5 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a5 }
        r8.<init>(r3)     // Catch:{ all -> 0x00a5 }
        r8.delete()     // Catch:{ all -> 0x00a5 }
        r3 = 0
        r8.createNewFile()     // Catch:{ all -> 0x0090 }
        java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0090 }
        r4.<init>(r8)     // Catch:{ all -> 0x0090 }
        r4.write(r9)     // Catch:{ all -> 0x0091 }
        r4.flush()     // Catch:{ all -> 0x0091 }
        boolean r9 = r8.exists()     // Catch:{ all -> 0x0091 }
        if (r9 == 0) goto L_0x0087
        long r5 = r8.length()     // Catch:{ all -> 0x0091 }
        int r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
        if (r9 <= 0) goto L_0x0087
        boolean r9 = r0.exists()     // Catch:{ all -> 0x0091 }
        if (r9 == 0) goto L_0x0084
        r0.delete()     // Catch:{ all -> 0x0091 }
    L_0x0084:
        r8.renameTo(r0)     // Catch:{ all -> 0x0091 }
    L_0x0087:
        com.bytedance.sdk.openadsdk.b.a r9 = r7.f8672c     // Catch:{ all -> 0x0091 }
        r9.mo14986a(r0)     // Catch:{ all -> 0x0091 }
    L_0x008c:
        r4.close()     // Catch:{ IOException -> 0x009a }
        goto L_0x009a
    L_0x0090:
        r4 = r3
    L_0x0091:
        r8.delete()     // Catch:{ all -> 0x009c }
        r0.delete()     // Catch:{ all -> 0x009c }
        if (r4 == 0) goto L_0x009a
        goto L_0x008c
    L_0x009a:
        monitor-exit(r7)
        return
    L_0x009c:
        r8 = move-exception
        if (r4 == 0) goto L_0x00a2
        r4.close()     // Catch:{ IOException -> 0x00a2 }
    L_0x00a2:
        throw r8     // Catch:{ all -> 0x00a5 }
    L_0x00a3:
        monitor-exit(r7)
        return
    L_0x00a5:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p188g.p189a.GifCache.mo16626a(java.lang.String, byte[]):void");
    }

    /* renamed from: a */
    private boolean m11370a(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            return null;
     */
    /* renamed from: a */
    public synchronized java.io.File mo16624a(java.lang.String r7) {
        /*
        r6 = this;
        monitor-enter(r6)
        boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0027 }
        r1 = 0
        if (r0 == 0) goto L_0x000a
        monitor-exit(r6)
        return r1
    L_0x000a:
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0027 }
        java.lang.String r2 = m11371b()     // Catch:{ all -> 0x0027 }
        r0.<init>(r2, r7)     // Catch:{ all -> 0x0027 }
        boolean r7 = r0.exists()     // Catch:{ all -> 0x0027 }
        if (r7 == 0) goto L_0x0025
        long r2 = r0.length()     // Catch:{ all -> 0x0027 }
        r4 = 0
        int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r7 <= 0) goto L_0x0025
        monitor-exit(r6)
        return r0
    L_0x0025:
        monitor-exit(r6)
        return r1
    L_0x0027:
        r7 = move-exception
        monitor-exit(r6)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p188g.p189a.GifCache.mo16624a(java.lang.String):java.io.File");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:44|(2:46|47)|48|49) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0079 */
    /* renamed from: b */
    public synchronized com.bytedance.sdk.openadsdk.p188g.p189a.GifCache.C2426a mo16627b(java.lang.String r6) {
        /*
        r5 = this;
        monitor-enter(r5)
        boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x007c }
        r1 = 0
        if (r0 == 0) goto L_0x000a
        monitor-exit(r5)
        return r1
    L_0x000a:
        android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.g.a.a$a> r0 = r5.f8673d     // Catch:{ all -> 0x007c }
        java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x007c }
        com.bytedance.sdk.openadsdk.g.a.a$a r0 = (com.bytedance.sdk.openadsdk.p188g.p189a.GifCache.C2426a) r0     // Catch:{ all -> 0x007c }
        if (r0 == 0) goto L_0x0016
        monitor-exit(r5)
        return r0
    L_0x0016:
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x007c }
        java.lang.String r2 = m11371b()     // Catch:{ all -> 0x007c }
        r0.<init>(r2, r6)     // Catch:{ all -> 0x007c }
        boolean r2 = r0.exists()     // Catch:{ all -> 0x007c }
        if (r2 == 0) goto L_0x007a
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0067 }
        r2.<init>(r0)     // Catch:{ all -> 0x0067 }
        long r3 = r0.length()     // Catch:{ all -> 0x0065 }
        java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0065 }
        int r0 = r0.intValue()     // Catch:{ all -> 0x0065 }
        java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x0065 }
        java.nio.channels.FileChannel r3 = r2.getChannel()     // Catch:{ all -> 0x0065 }
        r3.read(r0)     // Catch:{ all -> 0x0065 }
        byte[] r0 = r0.array()     // Catch:{ all -> 0x0065 }
        com.bytedance.sdk.openadsdk.g.a.a$a r3 = new com.bytedance.sdk.openadsdk.g.a.a$a     // Catch:{ all -> 0x004f }
        r3.m44022init(r0)     // Catch:{ all -> 0x004f }
        r2.close()     // Catch:{ IOException -> 0x004d }
    L_0x004d:
        monitor-exit(r5)
        return r3
        if (r0 == 0) goto L_0x0061
        com.bytedance.sdk.openadsdk.g.a.a$a r3 = new com.bytedance.sdk.openadsdk.g.a.a$a     // Catch:{ all -> 0x0065 }
        r3.m44022init(r0)     // Catch:{ all -> 0x0065 }
        android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.g.a.a$a> r0 = r5.f8673d     // Catch:{ all -> 0x0065 }
        r0.put(r6, r3)     // Catch:{ all -> 0x0065 }
        r2.close()     // Catch:{ IOException -> 0x005f }
    L_0x005f:
        monitor-exit(r5)
        return r3
    L_0x0061:
        r2.close()     // Catch:{ IOException -> 0x007a }
        goto L_0x007a
    L_0x0065:
        r6 = move-exception
        goto L_0x0069
    L_0x0067:
        r6 = move-exception
        r2 = r1
    L_0x0069:
        java.lang.String r0 = "GifCache"
        java.lang.String r3 = "gifCache get error "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r0, r3, r6)     // Catch:{ all -> 0x0073 }
        if (r2 == 0) goto L_0x007a
        goto L_0x0061
    L_0x0073:
        r6 = move-exception
        if (r2 == 0) goto L_0x0079
        r2.close()     // Catch:{ IOException -> 0x0079 }
    L_0x0079:
        throw r6     // Catch:{ all -> 0x007c }
    L_0x007a:
        monitor-exit(r5)
        return r1
    L_0x007c:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p188g.p189a.GifCache.mo16627b(java.lang.String):com.bytedance.sdk.openadsdk.g.a.a$a");
    }

    /* renamed from: a */
    public synchronized String mo16625a(String str, int i, int i2, ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        String str2 = (String) this.f8671b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String a = DigestUtils.m12169a(str);
        this.f8671b.put(str, a);
        return a;
    }

    /* renamed from: b */
    private static String m11371b() {
        if (TextUtils.isEmpty(f8669a)) {
            File file = new File(AdNetSdk.m7649b(InternalContainer.m10059a()), "diskGif");
            file.mkdirs();
            f8669a = file.getAbsolutePath();
        }
        return f8669a;
    }
}
