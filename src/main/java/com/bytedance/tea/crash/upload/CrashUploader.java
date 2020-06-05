package com.bytedance.tea.crash.upload;

import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p221g.IoUtil;
import com.bytedance.tea.crash.p221g.NpthLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.upload.b */
public class CrashUploader {
    /* renamed from: a */
    public static boolean f9393a = false;
    /* renamed from: b */
    private static IRequestIntercept f9394b;

    /* compiled from: CrashUploader */
    /* renamed from: com.bytedance.tea.crash.upload.b$a */
    public enum C2600a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        
        /* renamed from: d */
        final int f9399d;

        private C2600a(int i) {
            this.f9399d = i;
        }
    }

    /* compiled from: CrashUploader */
    /* renamed from: com.bytedance.tea.crash.upload.b$b */
    public enum C2601b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);
        
        /* renamed from: g */
        final int f9407g;

        private C2601b(int i) {
            this.f9407g = i;
        }
    }

    /* renamed from: a */
    public static boolean m12613a() {
        return true;
    }

    /* renamed from: b */
    public static boolean m12617b() {
        return true;
    }

    /* renamed from: a */
    public static C2602f m12607a(long j, String str, byte[] bArr, C2600a aVar, String str2, boolean z) throws IOException {
        String str3;
        byte[] bArr2;
        String str4;
        if (str == null) {
            return new C2602f(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str5 = null;
        if (C2600a.GZIP == aVar && length > 128) {
            bArr = m12618b(bArr);
            str5 = "gzip";
        } else if (C2600a.DEFLATER == aVar && length > 128) {
            bArr = m12615a(bArr);
            str5 = "deflate";
        }
        byte[] bArr3 = bArr;
        String str6 = str5;
        if (bArr3 == null) {
            return new C2602f(202);
        }
        if (z) {
            byte[] a = TTEncryptUtils.m6552a(bArr3, bArr3.length);
            if (a != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    String str7 = "?";
                    if (!str.endsWith(str7)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(str7);
                        str = sb.toString();
                    }
                } else {
                    String str8 = "&";
                    if (!str.endsWith(str8)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(str8);
                        str = sb2.toString();
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("tt_data=a");
                String sb4 = sb3.toString();
                bArr2 = a;
                str4 = sb4;
                str3 = "application/octet-stream;tt-data=a";
            } else {
                str4 = str;
                str3 = str2;
                bArr2 = bArr3;
            }
            return m12611a(str4, bArr2, str3, str6, "POST", true, true);
        }
        return m12611a(str, bArr3, str2, str6, "POST", true, false);
    }

    /* renamed from: a */
    private static byte[] m12615a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private static byte[] m12618b(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v10, types: [java.util.zip.GZIPInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r6v12, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010e A[SYNTHETIC, Splitter:B:91:0x010e] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: a */
    private static com.bytedance.tea.crash.upload.C2602f m12611a(java.lang.String r4, byte[] r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10) {
        /*
        java.lang.String r0 = "gzip"
        r1 = 0
        com.bytedance.tea.crash.upload.c r2 = f9394b     // Catch:{ all -> 0x00ff }
        if (r2 == 0) goto L_0x000d
        com.bytedance.tea.crash.upload.c r2 = f9394b     // Catch:{ all -> 0x00ff }
        java.lang.String r4 = r2.mo17078a(r4, r5)     // Catch:{ all -> 0x00ff }
    L_0x000d:
        java.util.LinkedList r2 = new java.util.LinkedList     // Catch:{ all -> 0x00ff }
        r2.<init>()     // Catch:{ all -> 0x00ff }
        if (r10 == 0) goto L_0x001e
        java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x00ff }
        java.lang.String r4 = com.bytedance.tea.p206a.p207a.p208a.RequestEncryptUtils.m12264a(r4, r2)     // Catch:{ all -> 0x00ff }
        r3.<init>(r4)     // Catch:{ all -> 0x00ff }
        goto L_0x0023
    L_0x001e:
        java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x00ff }
        r3.<init>(r4)     // Catch:{ all -> 0x00ff }
    L_0x0023:
        java.net.URLConnection r4 = r3.openConnection()     // Catch:{ all -> 0x00ff }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x00ff }
        if (r10 == 0) goto L_0x0053
        boolean r10 = r2.isEmpty()     // Catch:{ all -> 0x0050 }
        if (r10 != 0) goto L_0x0053
        java.util.Iterator r10 = r2.iterator()     // Catch:{ all -> 0x0050 }
    L_0x0035:
        boolean r2 = r10.hasNext()     // Catch:{ all -> 0x0050 }
        if (r2 == 0) goto L_0x0053
        java.lang.Object r2 = r10.next()     // Catch:{ all -> 0x0050 }
        android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x0044
        goto L_0x0035
    L_0x0044:
        java.lang.Object r3 = r2.first     // Catch:{ all -> 0x0050 }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0050 }
        java.lang.Object r2 = r2.second     // Catch:{ all -> 0x0050 }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0050 }
        r4.setRequestProperty(r3, r2)     // Catch:{ all -> 0x0050 }
        goto L_0x0035
    L_0x0050:
        r5 = move-exception
        goto L_0x0102
    L_0x0053:
        if (r9 == 0) goto L_0x005a
        r9 = 1
        r4.setDoOutput(r9)     // Catch:{ all -> 0x0050 }
        goto L_0x005e
    L_0x005a:
        r9 = 0
        r4.setDoOutput(r9)     // Catch:{ all -> 0x0050 }
    L_0x005e:
        if (r6 == 0) goto L_0x0065
        java.lang.String r9 = "Content-Type"
        r4.setRequestProperty(r9, r6)     // Catch:{ all -> 0x0050 }
    L_0x0065:
        if (r7 == 0) goto L_0x006c
        java.lang.String r6 = "Content-Encoding"
        r4.setRequestProperty(r6, r7)     // Catch:{ all -> 0x0050 }
    L_0x006c:
        java.lang.String r6 = "Accept-Encoding"
        r4.setRequestProperty(r6, r0)     // Catch:{ all -> 0x0050 }
        if (r8 == 0) goto L_0x00f7
        r4.setRequestMethod(r8)     // Catch:{ all -> 0x0050 }
        if (r5 == 0) goto L_0x0096
        int r6 = r5.length     // Catch:{ all -> 0x0050 }
        if (r6 <= 0) goto L_0x0096
        java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ all -> 0x0090 }
        java.io.OutputStream r7 = r4.getOutputStream()     // Catch:{ all -> 0x0090 }
        r6.<init>(r7)     // Catch:{ all -> 0x0090 }
        r6.write(r5)     // Catch:{ all -> 0x008e }
        r6.flush()     // Catch:{ all -> 0x008e }
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r6)     // Catch:{ all -> 0x0050 }
        goto L_0x0096
    L_0x008e:
        r5 = move-exception
        goto L_0x0092
    L_0x0090:
        r5 = move-exception
        r6 = r1
    L_0x0092:
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r6)     // Catch:{ all -> 0x0050 }
        throw r5     // Catch:{ all -> 0x0050 }
    L_0x0096:
        int r5 = r4.getResponseCode()     // Catch:{ all -> 0x0050 }
        r6 = 200(0xc8, float:2.8E-43)
        if (r5 != r6) goto L_0x00d6
        java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x0050 }
        java.lang.String r6 = r4.getContentEncoding()     // Catch:{ all -> 0x00d2 }
        boolean r6 = r0.equalsIgnoreCase(r6)     // Catch:{ all -> 0x00d2 }
        if (r6 == 0) goto L_0x00c1
        java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x00bc }
        r6.<init>(r5)     // Catch:{ all -> 0x00bc }
        byte[] r7 = m12614a(r6)     // Catch:{ all -> 0x00b9 }
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r6)     // Catch:{ all -> 0x00d2 }
        goto L_0x00c5
    L_0x00b9:
        r7 = move-exception
        r1 = r6
        goto L_0x00bd
    L_0x00bc:
        r7 = move-exception
    L_0x00bd:
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r1)     // Catch:{ all -> 0x00d2 }
        throw r7     // Catch:{ all -> 0x00d2 }
    L_0x00c1:
        byte[] r7 = m12614a(r5)     // Catch:{ all -> 0x00d2 }
    L_0x00c5:
        com.bytedance.tea.crash.upload.f r6 = m12619c(r7)     // Catch:{ all -> 0x00d2 }
        if (r4 == 0) goto L_0x00ce
        r4.disconnect()     // Catch:{ Exception -> 0x00ce }
    L_0x00ce:
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r5)
        return r6
    L_0x00d2:
        r6 = move-exception
        r1 = r5
        r5 = r6
        goto L_0x0102
    L_0x00d6:
        com.bytedance.tea.crash.upload.f r6 = new com.bytedance.tea.crash.upload.f     // Catch:{ all -> 0x0050 }
        r7 = 206(0xce, float:2.89E-43)
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
        r8.<init>()     // Catch:{ all -> 0x0050 }
        java.lang.String r9 = "http response code "
        r8.append(r9)     // Catch:{ all -> 0x0050 }
        r8.append(r5)     // Catch:{ all -> 0x0050 }
        java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x0050 }
        r6.m44351init(r7, r5)     // Catch:{ all -> 0x0050 }
        if (r4 == 0) goto L_0x00f3
        r4.disconnect()     // Catch:{ Exception -> 0x00f3 }
    L_0x00f3:
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r1)
        return r6
    L_0x00f7:
        java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0050 }
        java.lang.String r6 = "request method is not null"
        r5.<init>(r6)     // Catch:{ all -> 0x0050 }
        throw r5     // Catch:{ all -> 0x0050 }
    L_0x00ff:
        r4 = move-exception
        r5 = r4
        r4 = r1
    L_0x0102:
        com.bytedance.tea.crash.p221g.NpthLog.m12550b(r5)     // Catch:{ all -> 0x0115 }
        com.bytedance.tea.crash.upload.f r6 = new com.bytedance.tea.crash.upload.f     // Catch:{ all -> 0x0115 }
        r7 = 207(0xcf, float:2.9E-43)
        r6.m44352init(r7, r5)     // Catch:{ all -> 0x0115 }
        if (r4 == 0) goto L_0x0111
        r4.disconnect()     // Catch:{ Exception -> 0x0111 }
    L_0x0111:
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r1)
        return r6
    L_0x0115:
        r5 = move-exception
        if (r4 == 0) goto L_0x011b
        r4.disconnect()     // Catch:{ Exception -> 0x011b }
    L_0x011b:
        com.bytedance.tea.crash.p221g.IoUtil.m12535a(r1)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.upload.CrashUploader.m12611a(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.bytedance.tea.crash.upload.f");
    }

    /* renamed from: c */
    private static C2602f m12619c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new C2602f(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                return new C2602f(0, jSONObject);
            }
            return new C2602f(204, str);
        } catch (JSONException unused) {
            return new C2602f(204, str);
        }
    }

    /* renamed from: a */
    public static C2602f m12608a(String str, String str2) {
        return m12610a(str, str2, m12617b());
    }

    /* renamed from: b */
    public static C2602f m12616b(String str, String str2) {
        return m12610a(str, str2, m12613a());
    }

    /* renamed from: a */
    public static C2602f m12609a(String str, String str2, String str3) {
        try {
            MultipartUtility eVar = new MultipartUtility(str, "UTF-8", true);
            eVar.mo17082a("json", str2);
            eVar.mo17081a("file", new File(str3));
            String a = eVar.mo17080a();
            try {
                JSONObject jSONObject = new JSONObject(a);
                if ("succ".equals(jSONObject.optString("succ_kind"))) {
                    return new C2602f(0, jSONObject);
                }
                return new C2602f(204, a);
            } catch (JSONException e) {
                return new C2602f(205, (Throwable) e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new C2602f(207);
        }
    }

    /* renamed from: a */
    public static String m12612a(Map map) {
        return NpthBus.m12596e().mo17042a();
    }

    /* renamed from: a */
    public static C2602f m12610a(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    return m12607a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), C2600a.GZIP, "application/json; charset=utf-8", z);
                }
            }
            return new C2602f(201);
        } catch (Throwable th) {
            NpthLog.m12550b(th);
            return new C2602f(207, th);
        }
    }

    /* renamed from: a */
    private static byte[] m12614a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    IoUtil.m12535a(byteArrayOutputStream);
                }
            }
        }
    }
}
