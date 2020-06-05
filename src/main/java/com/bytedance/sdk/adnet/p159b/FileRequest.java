package com.bytedance.sdk.adnet.p159b;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1969a;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.DefaultRetryPolicy;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.NetworkResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.Request.C1968b;
import com.bytedance.sdk.adnet.err.AuthFailureError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p161d.HttpHeaderParser;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.adnet.b.c */
public class FileRequest extends Request<File> {
    /* renamed from: c */
    private File f6091c;
    /* renamed from: d */
    private File f6092d;
    /* renamed from: e */
    private final Object f6093e = new Object();
    /* renamed from: f */
    private C1983a<File> f6094f;

    /* compiled from: FileRequest */
    /* renamed from: com.bytedance.sdk.adnet.b.c$a */
    public interface C1953a extends C1983a<File> {
        /* renamed from: a */
        void mo14187a(long j, long j2);
    }

    public FileRequest(String str, String str2, C1983a<File> aVar) {
        super(str2, aVar);
        this.f6094f = aVar;
        this.f6091c = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".tmp");
        this.f6092d = new File(sb.toString());
        try {
            if (!(this.f6091c == null || this.f6091c.getParentFile() == null || this.f6091c.getParentFile().exists())) {
                this.f6091c.getParentFile().mkdirs();
            }
        } catch (Throwable unused) {
        }
        setRetryPolicy(new DefaultRetryPolicy(25000, 1, 1.0f));
        setShouldCache(false);
    }

    /* renamed from: f */
    public File mo14193f() {
        return this.f6091c;
    }

    /* renamed from: g */
    public File mo14194g() {
        return this.f6092d;
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f6093e) {
            this.f6094f = null;
        }
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(this.f6092d.length());
        sb.append("-");
        hashMap.put("Range", sb.toString());
        hashMap.put("Accept-Encoding", "identity");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1982p<File> mo14188a(NetworkResponse lVar) {
        if (isCanceled()) {
            m7698h();
            return C1982p.m7916a(new VAdError("Request was Canceled!"));
        } else if (!this.f6092d.canRead() || this.f6092d.length() <= 0) {
            m7698h();
            return C1982p.m7916a(new VAdError("Download temporary file was invalid!"));
        } else if (this.f6092d.renameTo(this.f6091c)) {
            return C1982p.m7917a(null, HttpHeaderParser.m7939a(lVar));
        } else {
            m7698h();
            return C1982p.m7916a(new VAdError("Can't rename the download temporary file!"));
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* renamed from: h */
    private void m7698h() {
        /*
        r1 = this;
        java.io.File r0 = r1.f6091c     // Catch:{ all -> 0x0005 }
        r0.delete()     // Catch:{ all -> 0x0005 }
    L_0x0005:
        java.io.File r0 = r1.f6091c     // Catch:{ all -> 0x000a }
        r0.delete()     // Catch:{ all -> 0x000a }
    L_0x000a:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p159b.FileRequest.m7698h():void");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00e1 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0112 A[EDGE_INSN: B:100:0x0112->B:45:0x0112 ?: BREAK  
EDGE_INSN: B:100:0x0112->B:45:0x0112 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0103 A[Catch:{ all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0114 A[SYNTHETIC, Splitter:B:46:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0122 A[SYNTHETIC, Splitter:B:52:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0142 A[SYNTHETIC, Splitter:B:68:0x0142] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014d A[SYNTHETIC, Splitter:B:73:0x014d] */
    /* renamed from: a */
    public byte[] mo14191a(com.bytedance.sdk.adnet.core.HttpResponse r19) throws java.io.IOException, com.bytedance.sdk.adnet.err.ServerError {
        /*
        r18 = this;
        r1 = r18
        java.lang.String r2 = "Error occured when calling tmpFile.close"
        java.lang.String r3 = "Error occured when calling consumingContent"
        java.lang.String r4 = "Error occured when calling InputStream.close"
        int r0 = r19.mo14313c()
        long r5 = (long) r0
        r7 = 0
        r9 = 0
        int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r0 > 0) goto L_0x001b
        java.lang.Object[] r0 = new java.lang.Object[r9]
        java.lang.String r10 = "Response doesn't present Content-Length!"
        com.bytedance.sdk.adnet.core.VNetLog.m7928b(r10, r0)
    L_0x001b:
        java.io.File r0 = r18.mo14194g()
        long r10 = r0.length()
        boolean r0 = r18.m7697c(r19)
        r12 = -1
        if (r0 == 0) goto L_0x008d
        long r5 = r5 + r10
        java.lang.String r13 = "Content-Range"
        r14 = r19
        java.lang.String r13 = r1.m7695a(r14, r13)
        boolean r15 = android.text.TextUtils.isEmpty(r13)
        if (r15 != 0) goto L_0x008f
        java.lang.StringBuilder r15 = new java.lang.StringBuilder
        r15.<init>()
        java.lang.String r9 = "bytes "
        r15.append(r9)
        r15.append(r10)
        java.lang.String r9 = "-"
        r15.append(r9)
        r16 = 1
        long r7 = r5 - r16
        r15.append(r7)
        java.lang.String r7 = r15.toString()
        int r8 = android.text.TextUtils.indexOf(r13, r7)
        if (r8 == r12) goto L_0x005d
        goto L_0x008f
    L_0x005d:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "The Content-Range Header is invalid Assume["
        r2.append(r3)
        r2.append(r7)
        java.lang.String r3 = "] vs Real["
        r2.append(r3)
        r2.append(r13)
        java.lang.String r3 = "], please remove the temporary file ["
        r2.append(r3)
        java.io.File r3 = r18.mo14194g()
        r2.append(r3)
        java.lang.String r3 = "]."
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        r0.<init>(r2)
        throw r0
    L_0x008d:
        r14 = r19
    L_0x008f:
        r7 = 0
        r8 = 0
        int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
        if (r13 <= 0) goto L_0x00b1
        java.io.File r8 = r18.mo14193f()
        long r8 = r8.length()
        int r13 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
        if (r13 != 0) goto L_0x00b1
        java.io.File r0 = r18.mo14193f()
        java.io.File r2 = r18.mo14194g()
        r0.renameTo(r2)
        r1.mo14189a(r5, r5)
        return r7
    L_0x00b1:
        java.io.File r8 = r18.mo14193f()
        if (r8 == 0) goto L_0x00c8
        java.io.File r8 = r18.mo14193f()
        boolean r8 = r8.exists()
        if (r8 == 0) goto L_0x00c8
        java.io.File r8 = r18.mo14193f()
        r8.delete()
    L_0x00c8:
        java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ all -> 0x00e0 }
        java.io.File r9 = r18.mo14194g()     // Catch:{ all -> 0x00e0 }
        java.lang.String r13 = "rw"
        r8.<init>(r9, r13)     // Catch:{ all -> 0x00e0 }
        if (r0 == 0) goto L_0x00d9
        r8.seek(r10)     // Catch:{ all -> 0x00e1 }
        goto L_0x00e1
    L_0x00d9:
        r12 = 0
        r8.setLength(r12)     // Catch:{ all -> 0x00e1 }
        r10 = r12
        goto L_0x00e1
    L_0x00e0:
        r8 = r7
    L_0x00e1:
        java.io.InputStream r9 = r19.mo14314d()     // Catch:{ all -> 0x0137 }
        boolean r12 = r18.m7696b(r19)     // Catch:{ all -> 0x0135 }
        if (r12 == 0) goto L_0x00f5
        boolean r12 = r9 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0135 }
        if (r12 != 0) goto L_0x00f5
        java.util.zip.GZIPInputStream r12 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0135 }
        r12.<init>(r9)     // Catch:{ all -> 0x0135 }
        r9 = r12
    L_0x00f5:
        r12 = 1024(0x400, float:1.435E-42)
        byte[] r12 = new byte[r12]     // Catch:{ all -> 0x0135 }
        r1.mo14189a(r10, r5)     // Catch:{ all -> 0x0135 }
    L_0x00fc:
        int r13 = r9.read(r12)     // Catch:{ all -> 0x0135 }
        r0 = -1
        if (r13 == r0) goto L_0x0112
        r14 = 0
        r8.write(r12, r14, r13)     // Catch:{ all -> 0x0135 }
        long r13 = (long) r13     // Catch:{ all -> 0x0135 }
        long r10 = r10 + r13
        r1.mo14189a(r10, r5)     // Catch:{ all -> 0x0135 }
        boolean r13 = r18.isCanceled()     // Catch:{ all -> 0x0135 }
        if (r13 == 0) goto L_0x00fc
    L_0x0112:
        if (r9 == 0) goto L_0x011f
        r9.close()     // Catch:{ all -> 0x0118 }
        goto L_0x011f
    L_0x0118:
        r5 = 0
        java.lang.Object[] r0 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r4, r0)
        goto L_0x0120
    L_0x011f:
        r5 = 0
    L_0x0120:
        if (r9 == 0) goto L_0x012b
        r9.close()     // Catch:{ all -> 0x0126 }
        goto L_0x012b
    L_0x0126:
        java.lang.Object[] r0 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r3, r0)
    L_0x012b:
        r8.close()     // Catch:{ all -> 0x012f }
        goto L_0x015f
    L_0x012f:
        java.lang.Object[] r0 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r2, r0)
        goto L_0x015f
    L_0x0135:
        r5 = 0
        goto L_0x0139
    L_0x0137:
        r5 = 0
        r9 = r7
    L_0x0139:
        java.lang.String r0 = "Error occured when FileRequest.parseHttpResponse"
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0160 }
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r0, r6)     // Catch:{ all -> 0x0160 }
        if (r9 == 0) goto L_0x014b
        r9.close()     // Catch:{ all -> 0x0146 }
        goto L_0x014b
    L_0x0146:
        java.lang.Object[] r0 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r4, r0)
    L_0x014b:
        if (r9 == 0) goto L_0x0156
        r9.close()     // Catch:{ all -> 0x0151 }
        goto L_0x0156
    L_0x0151:
        java.lang.Object[] r0 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r3, r0)
    L_0x0156:
        r8.close()     // Catch:{ all -> 0x015a }
        goto L_0x015f
    L_0x015a:
        java.lang.Object[] r0 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r2, r0)
    L_0x015f:
        return r7
    L_0x0160:
        r0 = move-exception
        if (r9 == 0) goto L_0x016e
        r9.close()     // Catch:{ all -> 0x0167 }
        goto L_0x016e
    L_0x0167:
        r5 = 0
        java.lang.Object[] r6 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r4, r6)
        goto L_0x016f
    L_0x016e:
        r5 = 0
    L_0x016f:
        if (r9 == 0) goto L_0x017a
        r9.close()     // Catch:{ all -> 0x0175 }
        goto L_0x017a
    L_0x0175:
        java.lang.Object[] r4 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r3, r4)
    L_0x017a:
        r8.close()     // Catch:{ all -> 0x017e }
        goto L_0x0183
    L_0x017e:
        java.lang.Object[] r3 = new java.lang.Object[r5]
        com.bytedance.sdk.adnet.core.VNetLog.m7926a(r2, r3)
    L_0x0183:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p159b.FileRequest.mo14191a(com.bytedance.sdk.adnet.core.b):byte[]");
    }

    /* renamed from: b */
    private boolean m7696b(HttpResponse bVar) {
        return TextUtils.equals(m7695a(bVar, "Content-Encoding"), "gzip");
    }

    /* renamed from: c */
    private boolean m7697c(HttpResponse bVar) {
        String str = "bytes";
        boolean z = true;
        if (TextUtils.equals(m7695a(bVar, "Accept-Ranges"), str)) {
            return true;
        }
        String a = m7695a(bVar, "Content-Range");
        if (a == null || !a.startsWith(str)) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private String m7695a(HttpResponse bVar, String str) {
        if (!(bVar == null || bVar.mo14312b() == null || bVar.mo14312b().isEmpty())) {
            for (C1969a aVar : bVar.mo14312b()) {
                if (aVar != null && TextUtils.equals(aVar.mo14306a(), str)) {
                    return aVar.mo14307b();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14190a(C1982p<File> pVar) {
        C1983a<File> aVar;
        synchronized (this.f6093e) {
            aVar = this.f6094f;
        }
        if (aVar != null) {
            aVar.mo14171a(C1982p.m7917a(this.f6091c, pVar.f6294b));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14189a(long j, long j2) {
        C1983a<File> aVar;
        synchronized (this.f6093e) {
            aVar = this.f6094f;
        }
        if (aVar instanceof C1953a) {
            ((C1953a) aVar).mo14187a(j, j2);
        }
    }

    public C1968b getPriority() {
        return C1968b.LOW;
    }
}
