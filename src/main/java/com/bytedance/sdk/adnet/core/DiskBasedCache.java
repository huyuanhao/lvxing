package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import com.bytedance.sdk.adnet.p161d.HttpHeaderParser;
import com.bytedance.sdk.adnet.p162e.ICache;
import com.bytedance.sdk.adnet.p162e.ICache.C1994a;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bytedance.sdk.adnet.core.h */
class DiskBasedCache implements ICache {
    /* renamed from: a */
    private final Map<String, C1973a> f6244a;
    /* renamed from: b */
    private long f6245b;
    /* renamed from: c */
    private final File f6246c;
    /* renamed from: d */
    private final int f6247d;

    /* compiled from: DiskBasedCache */
    /* renamed from: com.bytedance.sdk.adnet.core.h$a */
    static class C1973a {
        /* renamed from: a */
        long f6248a;
        /* renamed from: b */
        final String f6249b;
        /* renamed from: c */
        final String f6250c;
        /* renamed from: d */
        final long f6251d;
        /* renamed from: e */
        final long f6252e;
        /* renamed from: f */
        final long f6253f;
        /* renamed from: g */
        final long f6254g;
        /* renamed from: h */
        final List<C1969a> f6255h;

        private C1973a(String str, String str2, long j, long j2, long j3, long j4, List<C1969a> list) {
            this.f6249b = str;
            if ("".equals(str2)) {
                str2 = null;
            }
            this.f6250c = str2;
            this.f6251d = j;
            this.f6252e = j2;
            this.f6253f = j3;
            this.f6254g = j4;
            this.f6255h = list;
        }

        C1973a(String str, C1994a aVar) {
            this(str, aVar.f6326c, aVar.f6327d, aVar.f6328e, aVar.f6329f, aVar.f6330g, m7865a(aVar));
        }

        /* renamed from: a */
        private static List<C1969a> m7865a(C1994a aVar) {
            if (aVar.f6332i != null) {
                return aVar.f6332i;
            }
            return HttpHeaderParser.m7945b(aVar.f6331h);
        }

        /* renamed from: a */
        static C1973a m7864a(C1974b bVar) throws Throwable {
            if (DiskBasedCache.m7843a((InputStream) bVar) == 538247942) {
                C1973a aVar = new C1973a(DiskBasedCache.m7844a(bVar), DiskBasedCache.m7844a(bVar), DiskBasedCache.m7851b((InputStream) bVar), DiskBasedCache.m7851b((InputStream) bVar), DiskBasedCache.m7851b((InputStream) bVar), DiskBasedCache.m7851b((InputStream) bVar), DiskBasedCache.m7852b(bVar));
                return aVar;
            }
            throw new IOException();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1994a mo14342a(byte[] bArr) {
            C1994a aVar = new C1994a();
            aVar.f6325b = bArr;
            aVar.f6326c = this.f6250c;
            aVar.f6327d = this.f6251d;
            aVar.f6328e = this.f6252e;
            aVar.f6329f = this.f6253f;
            aVar.f6330g = this.f6254g;
            aVar.f6331h = HttpHeaderParser.m7944a(this.f6255h);
            aVar.f6332i = Collections.unmodifiableList(this.f6255h);
            return aVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo14343a(OutputStream outputStream) {
            try {
                DiskBasedCache.m7845a(outputStream, 538247942);
                DiskBasedCache.m7847a(outputStream, this.f6249b);
                DiskBasedCache.m7847a(outputStream, this.f6250c == null ? "" : this.f6250c);
                DiskBasedCache.m7846a(outputStream, this.f6251d);
                DiskBasedCache.m7846a(outputStream, this.f6252e);
                DiskBasedCache.m7846a(outputStream, this.f6253f);
                DiskBasedCache.m7846a(outputStream, this.f6254g);
                DiskBasedCache.m7849a(this.f6255h, outputStream);
                outputStream.flush();
                return true;
            } catch (Throwable th) {
                VNetLog.m7928b("%s", th.toString());
                return false;
            }
        }
    }

    /* compiled from: DiskBasedCache */
    /* renamed from: com.bytedance.sdk.adnet.core.h$b */
    static class C1974b extends FilterInputStream {
        /* renamed from: a */
        private final long f6256a;
        /* renamed from: b */
        private long f6257b;

        C1974b(InputStream inputStream, long j) {
            super(inputStream);
            this.f6256a = j;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f6257b++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f6257b += (long) read;
            }
            return read;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public long mo14344a() {
            return this.f6256a - this.f6257b;
        }
    }

    public DiskBasedCache(File file, int i) {
        this.f6244a = new LinkedHashMap(16, 0.75f, true);
        this.f6245b = 0;
        this.f6246c = file;
        this.f6247d = i;
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x009a */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f A[SYNTHETIC, Splitter:B:48:0x008f] */
    /* renamed from: a */
    public synchronized com.bytedance.sdk.adnet.p162e.ICache.C1994a mo14335a(java.lang.String r11) {
        /*
        r10 = this;
        monitor-enter(r10)
        boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x009b }
        r1 = 0
        if (r0 == 0) goto L_0x000a
        monitor-exit(r10)
        return r1
    L_0x000a:
        java.util.Map<java.lang.String, com.bytedance.sdk.adnet.core.h$a> r0 = r10.f6244a     // Catch:{ all -> 0x009b }
        java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x009b }
        com.bytedance.sdk.adnet.core.h$a r0 = (com.bytedance.sdk.adnet.core.DiskBasedCache.C1973a) r0     // Catch:{ all -> 0x009b }
        if (r0 != 0) goto L_0x0016
        monitor-exit(r10)
        return r1
    L_0x0016:
        java.io.File r2 = r10.mo14341c(r11)     // Catch:{ all -> 0x009b }
        r3 = 1
        r4 = 0
        r5 = 2
        com.bytedance.sdk.adnet.core.h$b r6 = new com.bytedance.sdk.adnet.core.h$b     // Catch:{ all -> 0x0075 }
        java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0075 }
        java.io.InputStream r8 = r10.mo14336a(r2)     // Catch:{ all -> 0x0075 }
        r7.<init>(r8)     // Catch:{ all -> 0x0075 }
        long r8 = r2.length()     // Catch:{ all -> 0x0075 }
        r6.m43160init(r7, r8)     // Catch:{ all -> 0x0075 }
        com.bytedance.sdk.adnet.core.h$a r7 = com.bytedance.sdk.adnet.core.DiskBasedCache.C1973a.m7864a(r6)     // Catch:{ all -> 0x006e }
        java.lang.String r8 = r7.f6249b     // Catch:{ all -> 0x006e }
        boolean r8 = android.text.TextUtils.equals(r11, r8)     // Catch:{ all -> 0x006e }
        if (r8 != 0) goto L_0x005a
        java.lang.String r0 = "%s: key=%s, found=%s"
        r8 = 3
        java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x006e }
        java.lang.String r9 = r2.getAbsolutePath()     // Catch:{ all -> 0x006e }
        r8[r4] = r9     // Catch:{ all -> 0x006e }
        r8[r3] = r11     // Catch:{ all -> 0x006e }
        java.lang.String r7 = r7.f6249b     // Catch:{ all -> 0x006e }
        r8[r5] = r7     // Catch:{ all -> 0x006e }
        com.bytedance.sdk.adnet.core.VNetLog.m7928b(r0, r8)     // Catch:{ all -> 0x006e }
        r10.m7856e(r11)     // Catch:{ all -> 0x006e }
        r6.close()     // Catch:{ all -> 0x0073 }
        r6.close()     // Catch:{ all -> 0x0058 }
    L_0x0058:
        monitor-exit(r10)
        return r1
    L_0x005a:
        long r7 = r6.mo14344a()     // Catch:{ all -> 0x006e }
        byte[] r7 = m7850a(r6, r7)     // Catch:{ all -> 0x006e }
        com.bytedance.sdk.adnet.e.b$a r0 = r0.mo14342a(r7)     // Catch:{ all -> 0x006e }
        r6.close()     // Catch:{ all -> 0x0073 }
        r6.close()     // Catch:{ all -> 0x006c }
    L_0x006c:
        monitor-exit(r10)
        return r0
    L_0x006e:
        r0 = move-exception
        r6.close()     // Catch:{ all -> 0x0073 }
        throw r0     // Catch:{ all -> 0x0073 }
    L_0x0073:
        r0 = move-exception
        goto L_0x0077
    L_0x0075:
        r0 = move-exception
        r6 = r1
    L_0x0077:
        java.lang.String r7 = "%s: %s"
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0094 }
        java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0094 }
        r5[r4] = r2     // Catch:{ all -> 0x0094 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0094 }
        r5[r3] = r0     // Catch:{ all -> 0x0094 }
        com.bytedance.sdk.adnet.core.VNetLog.m7928b(r7, r5)     // Catch:{ all -> 0x0094 }
        r10.mo14340b(r11)     // Catch:{ all -> 0x0094 }
        if (r6 == 0) goto L_0x0092
        r6.close()     // Catch:{ all -> 0x0092 }
    L_0x0092:
        monitor-exit(r10)
        return r1
    L_0x0094:
        r11 = move-exception
        if (r6 == 0) goto L_0x009a
        r6.close()     // Catch:{ all -> 0x009a }
    L_0x009a:
        throw r11     // Catch:{ all -> 0x009b }
    L_0x009b:
        r11 = move-exception
        monitor-exit(r10)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.DiskBasedCache.mo14335a(java.lang.String):com.bytedance.sdk.adnet.e.b$a");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:17|18|19|20|21|22|23|24|25|33|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
            return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0050 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0054 */
    /* renamed from: a */
    public synchronized void mo14337a() {
        /*
        r9 = this;
        monitor-enter(r9)
        java.io.File r0 = r9.f6246c     // Catch:{ all -> 0x005c }
        boolean r0 = r0.exists()     // Catch:{ all -> 0x005c }
        r1 = 0
        if (r0 != 0) goto L_0x0024
        java.io.File r0 = r9.f6246c     // Catch:{ all -> 0x005c }
        boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x005c }
        if (r0 != 0) goto L_0x0022
        java.lang.String r0 = "Unable to create cache dir %s"
        r2 = 1
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x005c }
        java.io.File r3 = r9.f6246c     // Catch:{ all -> 0x005c }
        java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x005c }
        r2[r1] = r3     // Catch:{ all -> 0x005c }
        com.bytedance.sdk.adnet.core.VNetLog.m7929c(r0, r2)     // Catch:{ all -> 0x005c }
    L_0x0022:
        monitor-exit(r9)
        return
    L_0x0024:
        java.io.File r0 = r9.f6246c     // Catch:{ all -> 0x005c }
        java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x005c }
        if (r0 != 0) goto L_0x002e
        monitor-exit(r9)
        return
    L_0x002e:
        int r2 = r0.length     // Catch:{ all -> 0x005c }
    L_0x002f:
        if (r1 >= r2) goto L_0x005a
        r3 = r0[r1]     // Catch:{ all -> 0x005c }
        long r4 = r3.length()     // Catch:{ all -> 0x0054 }
        com.bytedance.sdk.adnet.core.h$b r6 = new com.bytedance.sdk.adnet.core.h$b     // Catch:{ all -> 0x0054 }
        java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0054 }
        java.io.InputStream r8 = r9.mo14336a(r3)     // Catch:{ all -> 0x0054 }
        r7.<init>(r8)     // Catch:{ all -> 0x0054 }
        r6.m43160init(r7, r4)     // Catch:{ all -> 0x0054 }
        com.bytedance.sdk.adnet.core.h$a r7 = com.bytedance.sdk.adnet.core.DiskBasedCache.C1973a.m7864a(r6)     // Catch:{ all -> 0x0050 }
        r7.f6248a = r4     // Catch:{ all -> 0x0050 }
        java.lang.String r4 = r7.f6249b     // Catch:{ all -> 0x0050 }
        r9.m7848a(r4, r7)     // Catch:{ all -> 0x0050 }
    L_0x0050:
        r6.close()     // Catch:{ all -> 0x0054 }
        goto L_0x0057
    L_0x0054:
        r3.delete()     // Catch:{ all -> 0x005c }
    L_0x0057:
        int r1 = r1 + 1
        goto L_0x002f
    L_0x005a:
        monitor-exit(r9)
        return
    L_0x005c:
        r0 = move-exception
        monitor-exit(r9)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.DiskBasedCache.mo14337a():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x006e */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b A[SYNTHETIC, Splitter:B:30:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* renamed from: a */
    public synchronized void mo14338a(java.lang.String r8, com.bytedance.sdk.adnet.p162e.ICache.C1994a r9) {
        /*
        r7 = this;
        monitor-enter(r7)
        long r0 = r7.f6245b     // Catch:{ all -> 0x0083 }
        byte[] r2 = r9.f6325b     // Catch:{ all -> 0x0083 }
        int r2 = r2.length     // Catch:{ all -> 0x0083 }
        long r2 = (long) r2     // Catch:{ all -> 0x0083 }
        long r0 = r0 + r2
        int r2 = r7.f6247d     // Catch:{ all -> 0x0083 }
        long r2 = (long) r2     // Catch:{ all -> 0x0083 }
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 <= 0) goto L_0x0021
        byte[] r0 = r9.f6325b     // Catch:{ all -> 0x0083 }
        int r0 = r0.length     // Catch:{ all -> 0x0083 }
        float r0 = (float) r0     // Catch:{ all -> 0x0083 }
        int r1 = r7.f6247d     // Catch:{ all -> 0x0083 }
        float r1 = (float) r1
        r2 = 1063675494(0x3f666666, float:0.9)
        float r1 = r1 * r2
        int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
        if (r0 <= 0) goto L_0x0021
        monitor-exit(r7)
        return
    L_0x0021:
        java.io.File r0 = r7.mo14341c(r8)     // Catch:{ all -> 0x0083 }
        r1 = 0
        r2 = 0
        r3 = 1
        java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0068 }
        java.io.OutputStream r5 = r7.mo14339b(r0)     // Catch:{ all -> 0x0068 }
        r4.<init>(r5)     // Catch:{ all -> 0x0068 }
        com.bytedance.sdk.adnet.core.h$a r1 = new com.bytedance.sdk.adnet.core.h$a     // Catch:{ all -> 0x0069 }
        r1.m43158init(r8, r9)     // Catch:{ all -> 0x0069 }
        boolean r5 = r1.mo14343a(r4)     // Catch:{ all -> 0x0069 }
        if (r5 == 0) goto L_0x0052
        byte[] r9 = r9.f6325b     // Catch:{ all -> 0x0069 }
        r4.write(r9)     // Catch:{ all -> 0x0069 }
        long r5 = r0.length()     // Catch:{ all -> 0x0069 }
        r1.f6248a = r5     // Catch:{ all -> 0x0069 }
        r7.m7848a(r8, r1)     // Catch:{ all -> 0x0069 }
        r7.m7853b()     // Catch:{ all -> 0x0069 }
        r4.close()     // Catch:{ all -> 0x0050 }
    L_0x0050:
        monitor-exit(r7)
        return
    L_0x0052:
        r4.close()     // Catch:{ all -> 0x0069 }
        java.lang.String r8 = "Failed to write header for %s"
        java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x0069 }
        java.lang.String r1 = r0.getAbsolutePath()     // Catch:{ all -> 0x0069 }
        r9[r2] = r1     // Catch:{ all -> 0x0069 }
        com.bytedance.sdk.adnet.core.VNetLog.m7928b(r8, r9)     // Catch:{ all -> 0x0069 }
        java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0069 }
        r8.<init>()     // Catch:{ all -> 0x0069 }
        throw r8     // Catch:{ all -> 0x0069 }
    L_0x0068:
        r4 = r1
    L_0x0069:
        if (r4 == 0) goto L_0x006e
        r4.close()     // Catch:{ all -> 0x006e }
    L_0x006e:
        boolean r8 = r0.delete()     // Catch:{ all -> 0x0083 }
        if (r8 != 0) goto L_0x0081
        java.lang.String r8 = "Could not clean up file %s"
        java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x0083 }
        java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0083 }
        r9[r2] = r0     // Catch:{ all -> 0x0083 }
        com.bytedance.sdk.adnet.core.VNetLog.m7928b(r8, r9)     // Catch:{ all -> 0x0083 }
    L_0x0081:
        monitor-exit(r7)
        return
    L_0x0083:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.DiskBasedCache.mo14338a(java.lang.String, com.bytedance.sdk.adnet.e.b$a):void");
    }

    /* renamed from: b */
    public synchronized void mo14340b(String str) {
        boolean delete = mo14341c(str).delete();
        m7856e(str);
        if (!delete) {
            VNetLog.m7928b("Could not delete cache entry for key=%s, filename=%s", str, m7855d(str));
        }
    }

    /* renamed from: d */
    private String m7855d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        StringBuilder sb = new StringBuilder();
        sb.append(valueOf);
        sb.append(String.valueOf(str.substring(length).hashCode()));
        return sb.toString();
    }

    /* renamed from: c */
    public File mo14341c(String str) {
        return new File(this.f6246c, m7855d(str));
    }

    /* renamed from: b */
    private void m7853b() {
        if (this.f6245b >= ((long) this.f6247d)) {
            if (VNetLog.f6301a) {
                VNetLog.m7926a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f6245b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f6244a.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                C1973a aVar = (C1973a) ((Entry) it.next()).getValue();
                if (mo14341c(aVar.f6249b).delete()) {
                    this.f6245b -= aVar.f6248a;
                } else {
                    VNetLog.m7928b("Could not delete cache entry for key=%s, filename=%s", aVar.f6249b, m7855d(aVar.f6249b));
                }
                it.remove();
                i++;
                if (((float) this.f6245b) < ((float) this.f6247d) * 0.9f) {
                    break;
                }
            }
            if (VNetLog.f6301a) {
                VNetLog.m7926a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.f6245b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    /* renamed from: a */
    private void m7848a(String str, C1973a aVar) {
        if (!this.f6244a.containsKey(str)) {
            this.f6245b += aVar.f6248a;
        } else {
            this.f6245b += aVar.f6248a - ((C1973a) this.f6244a.get(str)).f6248a;
        }
        this.f6244a.put(str, aVar);
    }

    /* renamed from: e */
    private void m7856e(String str) {
        C1973a aVar = (C1973a) this.f6244a.remove(str);
        if (aVar != null) {
            this.f6245b -= aVar.f6248a;
        }
    }

    /* renamed from: a */
    static byte[] m7850a(C1974b bVar, long j) throws Throwable {
        long a = bVar.mo14344a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(a);
        throw new IOException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public InputStream mo14336a(File file) throws Throwable {
        return new FileInputStream(file);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public OutputStream mo14339b(File file) throws Throwable {
        return new FileOutputStream(file);
    }

    /* renamed from: c */
    private static int m7854c(InputStream inputStream) throws Throwable {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    static void m7845a(OutputStream outputStream, int i) throws Throwable {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    static int m7843a(InputStream inputStream) throws Throwable {
        return (m7854c(inputStream) << 24) | (m7854c(inputStream) << 0) | 0 | (m7854c(inputStream) << 8) | (m7854c(inputStream) << 16);
    }

    /* renamed from: a */
    static void m7846a(OutputStream outputStream, long j) throws Throwable {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    /* renamed from: b */
    static long m7851b(InputStream inputStream) throws Throwable {
        return ((((long) m7854c(inputStream)) & 255) << 0) | 0 | ((((long) m7854c(inputStream)) & 255) << 8) | ((((long) m7854c(inputStream)) & 255) << 16) | ((((long) m7854c(inputStream)) & 255) << 24) | ((((long) m7854c(inputStream)) & 255) << 32) | ((((long) m7854c(inputStream)) & 255) << 40) | ((((long) m7854c(inputStream)) & 255) << 48) | ((255 & ((long) m7854c(inputStream))) << 56);
    }

    /* renamed from: a */
    static void m7847a(OutputStream outputStream, String str) throws Throwable {
        byte[] bytes = str.getBytes("UTF-8");
        m7846a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    static String m7844a(C1974b bVar) throws Throwable {
        return new String(m7850a(bVar, m7851b((InputStream) bVar)), "UTF-8");
    }

    /* renamed from: a */
    static void m7849a(List<C1969a> list, OutputStream outputStream) throws Throwable {
        if (list != null) {
            m7845a(outputStream, list.size());
            for (C1969a aVar : list) {
                m7847a(outputStream, aVar.mo14306a());
                m7847a(outputStream, aVar.mo14307b());
            }
            return;
        }
        m7845a(outputStream, 0);
    }

    /* renamed from: b */
    static List<C1969a> m7852b(C1974b bVar) throws Throwable {
        int a = m7843a((InputStream) bVar);
        if (a >= 0) {
            List<C1969a> emptyList = a == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < a; i++) {
                emptyList.add(new C1969a(m7844a(bVar).intern(), m7844a(bVar).intern()));
            }
            return emptyList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("readHeaderList size=");
        sb.append(a);
        throw new IOException(sb.toString());
    }
}
