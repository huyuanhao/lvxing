package com.kwad.sdk.core.diskcache.p322b;

import com.kwad.sdk.core.diskcache.p321a.C4070a;
import com.kwad.sdk.core.diskcache.p321a.C4070a.C4073a;
import com.kwad.sdk.core.p319c.C4065b;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.kwad.sdk.core.diskcache.b.c */
class C4083c {
    /* renamed from: a */
    private static ExecutorService f13731a = Executors.newFixedThreadPool(5);

    /* renamed from: a */
    static void m16959a(final C4070a aVar, final String str, final String str2) {
        f13731a.execute(new Runnable() {
            public void run() {
                OutputStream outputStream = null;
                try {
                    C4073a a = aVar.mo23735a(str2);
                    if (a != null) {
                        outputStream = a.mo23744a(0);
                        if (C4083c.m16962b(str, outputStream)) {
                            a.mo23745a();
                        } else {
                            a.mo23746b();
                        }
                        aVar.mo23737b();
                    }
                } catch (IOException e) {
                    C4065b.m16865a(e);
                    C4065b.m16864a("FileHelper", "downLoadFileAsync file crash", e);
                } catch (Throwable th) {
                    C4085d.m16965a((Closeable) null);
                    throw th;
                }
                C4085d.m16965a((Closeable) outputStream);
            }
        });
    }

    /* renamed from: b */
    static boolean m16961b(C4070a aVar, String str, String str2) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            C4073a a = aVar.mo23735a(str2);
            if (a != null) {
                outputStream = a.mo23744a(0);
                if (m16962b(str, outputStream)) {
                    a.mo23745a();
                    z = true;
                } else {
                    a.mo23746b();
                }
                aVar.mo23737b();
            }
        } catch (IOException e) {
            C4065b.m16865a(e);
            C4065b.m16864a("FileHelper", "downLoadFileSync file crash", e);
        } catch (Throwable th) {
            C4085d.m16965a((Closeable) null);
            throw th;
        }
        C4085d.m16965a((Closeable) outputStream);
        return z;
    }

    /* access modifiers changed from: private|static */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
    /* renamed from: b */
    public static boolean m16962b(java.lang.String r6, java.io.OutputStream r7) {
        /*
        r0 = 0
        r1 = 0
        java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0072, all -> 0x006e }
        r2.<init>(r6)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
        java.net.URLConnection r6 = r2.openConnection()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
        java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0072, all -> 0x006e }
        java.lang.String r2 = "Accept-Language"
        java.lang.String r3 = "zh-CN"
        r6.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        r2 = 10000(0x2710, float:1.4013E-41)
        r6.setConnectTimeout(r2)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        r2 = 120000(0x1d4c0, float:1.68156E-40)
        r6.setReadTimeout(r2)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        r6.setUseCaches(r0)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        r2 = 1
        r6.setDoInput(r2)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        java.lang.String r3 = "Connection"
        java.lang.String r4 = "keep-alive"
        r6.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        java.lang.String r3 = "Charset"
        java.lang.String r4 = "UTF-8"
        r6.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        java.io.InputStream r4 = r6.getInputStream()     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        r3.<init>(r4)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0066 }
        r4.<init>(r7)     // Catch:{ Exception -> 0x0066 }
        r7 = 1024(0x400, float:1.435E-42)
        byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
    L_0x0046:
        int r1 = r3.read(r7)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
        r5 = -1
        if (r1 == r5) goto L_0x0051
        r4.write(r7, r0, r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
        goto L_0x0046
    L_0x0051:
        r4.flush()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
        com.kwad.sdk.core.diskcache.p322b.C4085d.m16965a(r4)
        com.kwad.sdk.core.diskcache.p322b.C4085d.m16965a(r3)
        if (r6 == 0) goto L_0x005f
        r6.disconnect()
    L_0x005f:
        return r2
    L_0x0060:
        r7 = move-exception
        r1 = r4
        goto L_0x008c
    L_0x0063:
        r7 = move-exception
        r1 = r4
        goto L_0x0075
    L_0x0066:
        r7 = move-exception
        goto L_0x0075
    L_0x0068:
        r7 = move-exception
        r3 = r1
        goto L_0x008c
    L_0x006b:
        r7 = move-exception
        r3 = r1
        goto L_0x0075
    L_0x006e:
        r7 = move-exception
        r6 = r1
        r3 = r6
        goto L_0x008c
    L_0x0072:
        r7 = move-exception
        r6 = r1
        r3 = r6
    L_0x0075:
        com.kwad.sdk.core.p319c.C4065b.m16865a(r7)     // Catch:{ all -> 0x008b }
        java.lang.String r2 = "FileHelper"
        java.lang.String r4 = "downloadUrlToStream file crash"
        com.kwad.sdk.core.p319c.C4065b.m16864a(r2, r4, r7)     // Catch:{ all -> 0x008b }
        com.kwad.sdk.core.diskcache.p322b.C4085d.m16965a(r1)
        com.kwad.sdk.core.diskcache.p322b.C4085d.m16965a(r3)
        if (r6 == 0) goto L_0x008a
        r6.disconnect()
    L_0x008a:
        return r0
    L_0x008b:
        r7 = move-exception
    L_0x008c:
        com.kwad.sdk.core.diskcache.p322b.C4085d.m16965a(r1)
        com.kwad.sdk.core.diskcache.p322b.C4085d.m16965a(r3)
        if (r6 == 0) goto L_0x0097
        r6.disconnect()
    L_0x0097:
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.p322b.C4083c.m16962b(java.lang.String, java.io.OutputStream):boolean");
    }
}
