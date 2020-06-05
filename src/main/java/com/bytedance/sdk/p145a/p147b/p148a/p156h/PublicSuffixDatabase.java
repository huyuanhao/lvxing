package com.bytedance.sdk.p145a.p147b.p148a.p156h;

import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.GzipSource;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Marker;

/* renamed from: com.bytedance.sdk.a.b.a.h.a */
public final class PublicSuffixDatabase {
    /* renamed from: a */
    private static final byte[] f5682a = {42};
    /* renamed from: b */
    private static final String[] f5683b = new String[0];
    /* renamed from: c */
    private static final String[] f5684c = {Marker.ANY_MARKER};
    /* renamed from: d */
    private static final PublicSuffixDatabase f5685d = new PublicSuffixDatabase();
    /* renamed from: e */
    private final AtomicBoolean f5686e = new AtomicBoolean(false);
    /* renamed from: f */
    private final CountDownLatch f5687f = new CountDownLatch(1);
    /* renamed from: g */
    private byte[] f5688g;
    /* renamed from: h */
    private byte[] f5689h;

    /* renamed from: a */
    public static PublicSuffixDatabase m7307a() {
        return f5685d;
    }

    /* renamed from: a */
    public String mo13893a(String str) {
        int i;
        int i2;
        if (str != null) {
            String str2 = "\\.";
            String[] split = IDN.toUnicode(str).split(str2);
            String[] a = m7309a(split);
            if (split.length == a.length && a[0].charAt(0) != '!') {
                return null;
            }
            if (a[0].charAt(0) == '!') {
                i2 = split.length;
                i = a.length;
            } else {
                i2 = split.length;
                i = a.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split(str2);
            for (int i3 = i2 - i; i3 < split2.length; i3++) {
                sb.append(split2[i3]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068 A[LOOP:3: B:34:0x0068->B:38:0x0075, LOOP_START, PHI: r1 
  PHI: (r1v3 int) = (r1v0 int), (r1v4 int) binds: {(r1v0 int)=B:33:0x0066, (r1v4 int)=B:38:0x0075} A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093  */
    /* renamed from: a */
    private java.lang.String[] m7309a(java.lang.String[] r8) {
        /*
        r7 = this;
        java.util.concurrent.atomic.AtomicBoolean r0 = r7.f5686e
        boolean r0 = r0.get()
        r1 = 0
        r2 = 1
        if (r0 != 0) goto L_0x0016
        java.util.concurrent.atomic.AtomicBoolean r0 = r7.f5686e
        boolean r0 = r0.compareAndSet(r1, r2)
        if (r0 == 0) goto L_0x0016
        r7.m7310b()
        goto L_0x001b
    L_0x0016:
        java.util.concurrent.CountDownLatch r0 = r7.f5687f     // Catch:{ InterruptedException -> 0x001b }
        r0.await()     // Catch:{ InterruptedException -> 0x001b }
    L_0x001b:
        monitor-enter(r7)
        byte[] r0 = r7.f5688g     // Catch:{ all -> 0x00bf }
        if (r0 == 0) goto L_0x00b7
        monitor-exit(r7)     // Catch:{ all -> 0x00bf }
        int r0 = r8.length
        byte[][] r0 = new byte[r0][]
        r3 = 0
    L_0x0025:
        int r4 = r8.length
        if (r3 >= r4) goto L_0x0035
        r4 = r8[r3]
        java.nio.charset.Charset r5 = com.bytedance.sdk.p145a.p147b.p148a.C1876c.f5402e
        byte[] r4 = r4.getBytes(r5)
        r0[r3] = r4
        int r3 = r3 + 1
        goto L_0x0025
    L_0x0035:
        r8 = 0
    L_0x0036:
        int r3 = r0.length
        r4 = 0
        if (r8 >= r3) goto L_0x0046
        byte[] r3 = r7.f5688g
        java.lang.String r3 = m7308a(r3, r0, r8)
        if (r3 == 0) goto L_0x0043
        goto L_0x0047
    L_0x0043:
        int r8 = r8 + 1
        goto L_0x0036
    L_0x0046:
        r3 = r4
    L_0x0047:
        int r8 = r0.length
        if (r8 <= r2) goto L_0x0065
        java.lang.Object r8 = r0.clone()
        byte[][] r8 = (byte[][]) r8
        r5 = 0
    L_0x0051:
        int r6 = r8.length
        int r6 = r6 - r2
        if (r5 >= r6) goto L_0x0065
        byte[] r6 = f5682a
        r8[r5] = r6
        byte[] r6 = r7.f5688g
        java.lang.String r6 = m7308a(r6, r8, r5)
        if (r6 == 0) goto L_0x0062
        goto L_0x0066
    L_0x0062:
        int r5 = r5 + 1
        goto L_0x0051
    L_0x0065:
        r6 = r4
    L_0x0066:
        if (r6 == 0) goto L_0x0078
    L_0x0068:
        int r8 = r0.length
        int r8 = r8 - r2
        if (r1 >= r8) goto L_0x0078
        byte[] r8 = r7.f5689h
        java.lang.String r8 = m7308a(r8, r0, r1)
        if (r8 == 0) goto L_0x0075
        goto L_0x0079
    L_0x0075:
        int r1 = r1 + 1
        goto L_0x0068
    L_0x0078:
        r8 = r4
    L_0x0079:
        if (r8 == 0) goto L_0x0093
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "!"
        r0.append(r1)
        r0.append(r8)
        java.lang.String r8 = r0.toString()
        java.lang.String r0 = "\\."
        java.lang.String[] r8 = r8.split(r0)
        return r8
    L_0x0093:
        if (r3 != 0) goto L_0x009a
        if (r6 != 0) goto L_0x009a
        java.lang.String[] r8 = f5684c
        return r8
    L_0x009a:
        if (r3 == 0) goto L_0x00a3
        java.lang.String r8 = "\\."
        java.lang.String[] r8 = r3.split(r8)
        goto L_0x00a5
    L_0x00a3:
        java.lang.String[] r8 = f5683b
    L_0x00a5:
        if (r6 == 0) goto L_0x00ae
        java.lang.String r0 = "\\."
        java.lang.String[] r0 = r6.split(r0)
        goto L_0x00b0
    L_0x00ae:
        java.lang.String[] r0 = f5683b
    L_0x00b0:
        int r1 = r8.length
        int r2 = r0.length
        if (r1 <= r2) goto L_0x00b5
        goto L_0x00b6
    L_0x00b5:
        r8 = r0
    L_0x00b6:
        return r8
    L_0x00b7:
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00bf }
        java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
        r8.<init>(r0)     // Catch:{ all -> 0x00bf }
        throw r8     // Catch:{ all -> 0x00bf }
    L_0x00bf:
        r8 = move-exception
        monitor-exit(r7)     // Catch:{ all -> 0x00bf }
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p156h.PublicSuffixDatabase.m7309a(java.lang.String[]):java.lang.String[]");
    }

    /* renamed from: a */
    private static String m7308a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        byte b;
        int i3;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = (i4 + length) / 2;
            while (i5 > -1 && bArr3[i5] != 10) {
                i5--;
            }
            int i6 = i5 + 1;
            int i7 = 1;
            while (true) {
                i2 = i6 + i7;
                if (bArr3[i2] == 10) {
                    break;
                }
                i7++;
            }
            int i8 = i2 - i6;
            int i9 = i;
            boolean z = false;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (z) {
                    z = false;
                    b = 46;
                } else {
                    b = bArr4[i9][i10] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
                i3 = b - (bArr3[i6 + i11] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                if (i3 == 0) {
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr4[i9].length == i10) {
                        if (i9 == bArr4.length - 1) {
                            break;
                        }
                        i9++;
                        z = true;
                        i10 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i3 >= 0) {
                if (i3 <= 0) {
                    int i12 = i8 - i11;
                    int length2 = bArr4[i9].length - i10;
                    while (true) {
                        i9++;
                        if (i9 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i9].length;
                    }
                    if (length2 >= i12) {
                        if (length2 <= i12) {
                            return new String(bArr3, i6, i8, C1876c.f5402e);
                        }
                    }
                }
                i4 = i2 + 1;
            }
            length = i6 - 1;
        }
        return null;
    }

    /* renamed from: b */
    private void m7310b() {
        boolean z = false;
        while (true) {
            try {
                m7311c();
                break;
            } catch (InterruptedIOException unused) {
                z = true;
            } catch (IOException e) {
                Platform.m7295b().mo13872a(5, "Failed to read public suffix list", (Throwable) e);
                if (z) {
                    Thread.currentThread().interrupt();
                }
                return;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: c */
    private void m7311c() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            BufferedSource a = Okio.m6747a((Source) new GzipSource(Okio.m6750a(resourceAsStream)));
            try {
                byte[] bArr = new byte[a.mo13562j()];
                a.mo13528a(bArr);
                byte[] bArr2 = new byte[a.mo13562j()];
                a.mo13528a(bArr2);
                synchronized (this) {
                    this.f5688g = bArr;
                    this.f5689h = bArr2;
                }
                this.f5687f.countDown();
            } finally {
                C1876c.m6961a((Closeable) a);
            }
        }
    }
}
