package okhttp3.internal.publicsuffix;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.C8417c;
import okhttp3.internal.p701e.C8447f;
import okio.C8529e;
import okio.C8533i;
import okio.C8535k;
import okio.C8547r;
import org.slf4j.Marker;

public final class PublicSuffixDatabase {
    /* renamed from: a */
    private static final byte[] f28820a = {42};
    /* renamed from: b */
    private static final String[] f28821b = new String[0];
    /* renamed from: c */
    private static final String[] f28822c = {Marker.ANY_MARKER};
    /* renamed from: d */
    private static final PublicSuffixDatabase f28823d = new PublicSuffixDatabase();
    /* renamed from: e */
    private final AtomicBoolean f28824e = new AtomicBoolean(false);
    /* renamed from: f */
    private final CountDownLatch f28825f = new CountDownLatch(1);
    /* renamed from: g */
    private byte[] f28826g;
    /* renamed from: h */
    private byte[] f28827h;

    /* renamed from: a */
    public static PublicSuffixDatabase m36424a() {
        return f28823d;
    }

    /* renamed from: a */
    public String mo40459a(String str) {
        int i;
        int i2;
        if (str != null) {
            String str2 = "\\.";
            String[] split = IDN.toUnicode(str).split(str2);
            String[] a = m36425a(split);
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

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b  */
    /* renamed from: a */
    private java.lang.String[] m36425a(java.lang.String[] r8) {
        /*
        r7 = this;
        java.util.concurrent.atomic.AtomicBoolean r0 = r7.f28824e
        boolean r0 = r0.get()
        r1 = 0
        r2 = 1
        if (r0 != 0) goto L_0x0016
        java.util.concurrent.atomic.AtomicBoolean r0 = r7.f28824e
        boolean r0 = r0.compareAndSet(r1, r2)
        if (r0 == 0) goto L_0x0016
        r7.m36426b()
        goto L_0x0023
    L_0x0016:
        java.util.concurrent.CountDownLatch r0 = r7.f28825f     // Catch:{ InterruptedException -> 0x001c }
        r0.await()     // Catch:{ InterruptedException -> 0x001c }
        goto L_0x0023
    L_0x001c:
        java.lang.Thread r0 = java.lang.Thread.currentThread()
        r0.interrupt()
    L_0x0023:
        monitor-enter(r7)
        byte[] r0 = r7.f28826g     // Catch:{ all -> 0x00c7 }
        if (r0 == 0) goto L_0x00bf
        monitor-exit(r7)     // Catch:{ all -> 0x00c7 }
        int r0 = r8.length
        byte[][] r0 = new byte[r0][]
        r3 = 0
    L_0x002d:
        int r4 = r8.length
        if (r3 >= r4) goto L_0x003d
        r4 = r8[r3]
        java.nio.charset.Charset r5 = okhttp3.internal.C8417c.f28532e
        byte[] r4 = r4.getBytes(r5)
        r0[r3] = r4
        int r3 = r3 + 1
        goto L_0x002d
    L_0x003d:
        r8 = 0
    L_0x003e:
        int r3 = r0.length
        r4 = 0
        if (r8 >= r3) goto L_0x004e
        byte[] r3 = r7.f28826g
        java.lang.String r3 = m36423a(r3, r0, r8)
        if (r3 == 0) goto L_0x004b
        goto L_0x004f
    L_0x004b:
        int r8 = r8 + 1
        goto L_0x003e
    L_0x004e:
        r3 = r4
    L_0x004f:
        int r8 = r0.length
        if (r8 <= r2) goto L_0x006d
        java.lang.Object r8 = r0.clone()
        byte[][] r8 = (byte[][]) r8
        r5 = 0
    L_0x0059:
        int r6 = r8.length
        int r6 = r6 - r2
        if (r5 >= r6) goto L_0x006d
        byte[] r6 = f28820a
        r8[r5] = r6
        byte[] r6 = r7.f28826g
        java.lang.String r6 = m36423a(r6, r8, r5)
        if (r6 == 0) goto L_0x006a
        goto L_0x006e
    L_0x006a:
        int r5 = r5 + 1
        goto L_0x0059
    L_0x006d:
        r6 = r4
    L_0x006e:
        if (r6 == 0) goto L_0x0080
    L_0x0070:
        int r8 = r0.length
        int r8 = r8 - r2
        if (r1 >= r8) goto L_0x0080
        byte[] r8 = r7.f28827h
        java.lang.String r8 = m36423a(r8, r0, r1)
        if (r8 == 0) goto L_0x007d
        goto L_0x0081
    L_0x007d:
        int r1 = r1 + 1
        goto L_0x0070
    L_0x0080:
        r8 = r4
    L_0x0081:
        if (r8 == 0) goto L_0x009b
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "!"
        r0.append(r1)
        r0.append(r8)
        java.lang.String r8 = r0.toString()
        java.lang.String r0 = "\\."
        java.lang.String[] r8 = r8.split(r0)
        return r8
    L_0x009b:
        if (r3 != 0) goto L_0x00a2
        if (r6 != 0) goto L_0x00a2
        java.lang.String[] r8 = f28822c
        return r8
    L_0x00a2:
        if (r3 == 0) goto L_0x00ab
        java.lang.String r8 = "\\."
        java.lang.String[] r8 = r3.split(r8)
        goto L_0x00ad
    L_0x00ab:
        java.lang.String[] r8 = f28821b
    L_0x00ad:
        if (r6 == 0) goto L_0x00b6
        java.lang.String r0 = "\\."
        java.lang.String[] r0 = r6.split(r0)
        goto L_0x00b8
    L_0x00b6:
        java.lang.String[] r0 = f28821b
    L_0x00b8:
        int r1 = r8.length
        int r2 = r0.length
        if (r1 <= r2) goto L_0x00bd
        goto L_0x00be
    L_0x00bd:
        r8 = r0
    L_0x00be:
        return r8
    L_0x00bf:
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c7 }
        java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
        r8.<init>(r0)     // Catch:{ all -> 0x00c7 }
        throw r8     // Catch:{ all -> 0x00c7 }
    L_0x00c7:
        r8 = move-exception
        monitor-exit(r7)     // Catch:{ all -> 0x00c7 }
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.m36425a(java.lang.String[]):java.lang.String[]");
    }

    /* renamed from: a */
    private static String m36423a(byte[] bArr, byte[][] bArr2, int i) {
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
                            return new String(bArr3, i6, i8, C8417c.f28532e);
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
    private void m36426b() {
        boolean z = false;
        while (true) {
            try {
                m36427c();
                break;
            } catch (InterruptedIOException unused) {
                z = true;
            } catch (IOException e) {
                C8447f.m36198c().mo40323a(5, "Failed to read public suffix list", (Throwable) e);
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
    private void m36427c() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            C8529e a = C8535k.m36849a((C8547r) new C8533i(C8535k.m36855a(resourceAsStream)));
            try {
                byte[] bArr = new byte[a.mo40769k()];
                a.mo40730a(bArr);
                byte[] bArr2 = new byte[a.mo40769k()];
                a.mo40730a(bArr2);
                synchronized (this) {
                    this.f28826g = bArr;
                    this.f28827h = bArr2;
                }
                this.f28825f.countDown();
            } finally {
                C8417c.m36040a((Closeable) a);
            }
        }
    }
}
