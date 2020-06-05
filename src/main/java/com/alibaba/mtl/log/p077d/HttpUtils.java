package com.alibaba.mtl.log.p077d;

/* renamed from: com.alibaba.mtl.log.d.e */
public final class HttpUtils {
    /* renamed from: a */
    private static UtSslSocketFactory f3396a = null;

    /* compiled from: HttpUtils */
    /* renamed from: com.alibaba.mtl.log.d.e$a */
    public static class C1319a {
        /* renamed from: a */
        public int f3397a = -1;
        /* renamed from: b */
        public byte[] f3398b = null;
    }

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x01f9 A[Catch:{ IOException -> 0x0214 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01fd A[EDGE_INSN: B:118:0x01fd->B:119:? ?: BREAK  
EDGE_INSN: B:118:0x01fd->B:119:? ?: BREAK  , SYNTHETIC, Splitter:B:118:0x01fd] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0221 A[SYNTHETIC, Splitter:B:133:0x0221] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x022f A[SYNTHETIC, Splitter:B:141:0x022f] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0257 A[SYNTHETIC, Splitter:B:161:0x0257] */
    /* renamed from: a */
    public static com.alibaba.mtl.log.p077d.HttpUtils.C1319a m3819a(int r16, java.lang.String r17, java.util.Map<java.lang.String, java.lang.Object> r18, boolean r19) {
        /*
        r1 = r16
        r2 = r18
        com.alibaba.mtl.log.d.e$a r3 = new com.alibaba.mtl.log.d.e$a
        r3.m41908init()
        boolean r0 = android.text.TextUtils.isEmpty(r17)
        if (r0 == 0) goto L_0x0010
        return r3
    L_0x0010:
        java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0278, IOException -> 0x0273 }
        r4 = r17
        r0.<init>(r4)     // Catch:{ MalformedURLException -> 0x0278, IOException -> 0x0273 }
        java.net.URLConnection r4 = r0.openConnection()     // Catch:{ MalformedURLException -> 0x0278, IOException -> 0x0273 }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ MalformedURLException -> 0x0278, IOException -> 0x0273 }
        java.lang.String r5 = "UtAnalytics"
        r6 = 1
        r7 = 0
        r8 = 2
        if (r4 == 0) goto L_0x0266
        boolean r9 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x004a }
        if (r9 == 0) goto L_0x004b
        com.alibaba.mtl.log.d.u r9 = f3396a     // Catch:{ all -> 0x004a }
        if (r9 != 0) goto L_0x0041
        java.lang.String r9 = r0.getHost()     // Catch:{ all -> 0x004a }
        boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x004a }
        if (r9 != 0) goto L_0x0041
        com.alibaba.mtl.log.d.u r9 = new com.alibaba.mtl.log.d.u     // Catch:{ all -> 0x004a }
        java.lang.String r0 = r0.getHost()     // Catch:{ all -> 0x004a }
        r9.m41932init(r0)     // Catch:{ all -> 0x004a }
        f3396a = r9     // Catch:{ all -> 0x004a }
    L_0x0041:
        r0 = r4
        javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ all -> 0x004a }
        com.alibaba.mtl.log.d.u r9 = f3396a     // Catch:{ all -> 0x004a }
        r0.setSSLSocketFactory(r9)     // Catch:{ all -> 0x004a }
        goto L_0x004b
    L_0x004b:
        r9 = 3
        if (r1 == r8) goto L_0x0050
        if (r1 != r9) goto L_0x0053
    L_0x0050:
        r4.setDoOutput(r6)
    L_0x0053:
        r4.setDoInput(r6)
        if (r1 == r8) goto L_0x0061
        if (r1 != r9) goto L_0x005b
        goto L_0x0061
    L_0x005b:
        java.lang.String r0 = "GET"
        r4.setRequestMethod(r0)     // Catch:{ ProtocolException -> 0x0261 }
        goto L_0x0066
    L_0x0061:
        java.lang.String r0 = "POST"
        r4.setRequestMethod(r0)     // Catch:{ ProtocolException -> 0x0261 }
    L_0x0066:
        r4.setUseCaches(r7)
        r0 = 10000(0x2710, float:1.4013E-41)
        r4.setConnectTimeout(r0)
        r0 = 60000(0xea60, float:8.4078E-41)
        r4.setReadTimeout(r0)
        java.lang.String r0 = "Connection"
        java.lang.String r10 = "close"
        r4.setRequestProperty(r0, r10)
        if (r19 == 0) goto L_0x0084
        java.lang.String r0 = "Accept-Encoding"
        java.lang.String r10 = "gzip,deflate"
        r4.setRequestProperty(r0, r10)
    L_0x0084:
        r4.setInstanceFollowRedirects(r6)
        if (r1 == r8) goto L_0x008f
        if (r1 != r9) goto L_0x008c
        goto L_0x008f
    L_0x008c:
        r10 = 0
        goto L_0x0176
    L_0x008f:
        java.lang.String r0 = "Content-Type"
        if (r1 != r8) goto L_0x0099
        java.lang.String r11 = "multipart/form-data; boundary=GJircTeP"
        r4.setRequestProperty(r0, r11)
        goto L_0x00a0
    L_0x0099:
        if (r1 != r9) goto L_0x00a0
        java.lang.String r11 = "application/x-www-form-urlencoded"
        r4.setRequestProperty(r0, r11)
    L_0x00a0:
        if (r2 == 0) goto L_0x0167
        int r0 = r18.size()
        if (r0 <= 0) goto L_0x0167
        java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream
        r11.<init>()
        java.util.Set r0 = r18.keySet()
        int r12 = r0.size()
        java.lang.String[] r12 = new java.lang.String[r12]
        r0.toArray(r12)
        com.alibaba.mtl.log.d.g r0 = com.alibaba.mtl.log.p077d.KeyArraySorter.m3821a()
        java.lang.String[] r12 = r0.mo11801a(r12, r6)
        int r13 = r12.length
        r14 = 0
    L_0x00c4:
        if (r14 >= r13) goto L_0x0151
        r0 = r12[r14]
        if (r1 != r8) goto L_0x00f9
        java.lang.Object r15 = r2.get(r0)
        byte[] r15 = (byte[]) r15
        byte[] r15 = (byte[]) r15
        if (r15 == 0) goto L_0x014b
        java.lang.String r10 = "--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n"
        java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x00f4 }
        r9[r7] = r0     // Catch:{ IOException -> 0x00f4 }
        r9[r6] = r0     // Catch:{ IOException -> 0x00f4 }
        java.lang.String r0 = java.lang.String.format(r10, r9)     // Catch:{ IOException -> 0x00f4 }
        byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x00f4 }
        r11.write(r0)     // Catch:{ IOException -> 0x00f4 }
        r11.write(r15)     // Catch:{ IOException -> 0x00f4 }
        java.lang.String r0 = "\r\n"
        byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x00f4 }
        r11.write(r0)     // Catch:{ IOException -> 0x00f4 }
        goto L_0x014b
    L_0x00f4:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x014b
    L_0x00f9:
        if (r1 != r9) goto L_0x014b
        java.lang.Object r9 = r2.get(r0)
        java.lang.String r9 = (java.lang.String) r9
        int r10 = r11.size()
        java.lang.String r15 = "="
        if (r10 <= 0) goto L_0x012d
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0128 }
        r10.<init>()     // Catch:{ IOException -> 0x0128 }
        java.lang.String r6 = "&"
        r10.append(r6)     // Catch:{ IOException -> 0x0128 }
        r10.append(r0)     // Catch:{ IOException -> 0x0128 }
        r10.append(r15)     // Catch:{ IOException -> 0x0128 }
        r10.append(r9)     // Catch:{ IOException -> 0x0128 }
        java.lang.String r0 = r10.toString()     // Catch:{ IOException -> 0x0128 }
        byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0128 }
        r11.write(r0)     // Catch:{ IOException -> 0x0128 }
        goto L_0x014b
    L_0x0128:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x014b
    L_0x012d:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0147 }
        r6.<init>()     // Catch:{ IOException -> 0x0147 }
        r6.append(r0)     // Catch:{ IOException -> 0x0147 }
        r6.append(r15)     // Catch:{ IOException -> 0x0147 }
        r6.append(r9)     // Catch:{ IOException -> 0x0147 }
        java.lang.String r0 = r6.toString()     // Catch:{ IOException -> 0x0147 }
        byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0147 }
        r11.write(r0)     // Catch:{ IOException -> 0x0147 }
        goto L_0x014b
    L_0x0147:
        r0 = move-exception
        r0.printStackTrace()
    L_0x014b:
        int r14 = r14 + 1
        r6 = 1
        r9 = 3
        goto L_0x00c4
    L_0x0151:
        if (r1 != r8) goto L_0x0161
        java.lang.String r0 = "--GJircTeP--\r\n"
        byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x015d }
        r11.write(r0)     // Catch:{ IOException -> 0x015d }
        goto L_0x0161
    L_0x015d:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0161:
        byte[] r0 = r11.toByteArray()
        r10 = r0
        goto L_0x0168
    L_0x0167:
        r10 = 0
    L_0x0168:
        if (r10 == 0) goto L_0x016c
        int r0 = r10.length
        goto L_0x016d
    L_0x016c:
        r0 = 0
    L_0x016d:
        java.lang.String r0 = java.lang.String.valueOf(r0)
        java.lang.String r2 = "Content-Length"
        r4.setRequestProperty(r2, r0)
    L_0x0176:
        r4.connect()     // Catch:{ Exception -> 0x023d, all -> 0x0239 }
        if (r1 == r8) goto L_0x017e
        r2 = 3
        if (r1 != r2) goto L_0x019b
    L_0x017e:
        if (r10 == 0) goto L_0x019b
        int r0 = r10.length     // Catch:{ Exception -> 0x023d, all -> 0x0239 }
        if (r0 <= 0) goto L_0x019b
        java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x023d, all -> 0x0239 }
        java.io.OutputStream r0 = r4.getOutputStream()     // Catch:{ Exception -> 0x023d, all -> 0x0239 }
        r1.<init>(r0)     // Catch:{ Exception -> 0x023d, all -> 0x0239 }
        r1.write(r10)     // Catch:{ Exception -> 0x0197, all -> 0x0193 }
        r1.flush()     // Catch:{ Exception -> 0x0197, all -> 0x0193 }
        goto L_0x019c
    L_0x0193:
        r0 = move-exception
        r10 = r1
        goto L_0x0254
    L_0x0197:
        r0 = move-exception
        r10 = r1
        goto L_0x023f
    L_0x019b:
        r1 = 0
    L_0x019c:
        if (r1 == 0) goto L_0x01a7
        r1.close()     // Catch:{ IOException -> 0x01a2 }
        goto L_0x01a7
    L_0x01a2:
        r0 = move-exception
        r1 = r0
        r1.printStackTrace()
    L_0x01a7:
        int r0 = r4.getResponseCode()     // Catch:{ IOException -> 0x01c0 }
        r3.f3397a = r0     // Catch:{ IOException -> 0x01c0 }
        java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x01c0 }
        java.lang.String r1 = "responseCode:"
        r0[r7] = r1     // Catch:{ IOException -> 0x01c0 }
        int r1 = r3.f3397a     // Catch:{ IOException -> 0x01c0 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x01c0 }
        r2 = 1
        r0[r2] = r1     // Catch:{ IOException -> 0x01c0 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r5, r0)     // Catch:{ IOException -> 0x01c0 }
        goto L_0x01c4
    L_0x01c0:
        r0 = move-exception
        r0.printStackTrace()
    L_0x01c4:
        java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
        r1.<init>()
        if (r19 == 0) goto L_0x01e1
        java.lang.String r0 = "gzip"
        java.lang.String r2 = r4.getContentEncoding()     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
        boolean r0 = r0.equals(r2)     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
        if (r0 == 0) goto L_0x01e1
        java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
        java.io.InputStream r2 = r4.getInputStream()     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
        r0.<init>(r2)     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
        goto L_0x01ea
    L_0x01e1:
        java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
        java.io.InputStream r2 = r4.getInputStream()     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
        r0.<init>(r2)     // Catch:{ IOException -> 0x021a, all -> 0x0216 }
    L_0x01ea:
        r10 = r0
        java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0214 }
        r0 = 2048(0x800, float:2.87E-42)
        byte[] r2 = new byte[r0]     // Catch:{ IOException -> 0x0214 }
    L_0x01f2:
        int r4 = r10.read(r2, r7, r0)     // Catch:{ IOException -> 0x0214 }
        r5 = -1
        if (r4 == r5) goto L_0x01fd
        r1.write(r2, r7, r4)     // Catch:{ IOException -> 0x0214 }
        goto L_0x01f2
    L_0x01fd:
        r10.close()     // Catch:{ Exception -> 0x0201 }
        goto L_0x0206
    L_0x0201:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x0206:
        int r0 = r1.size()
        if (r0 <= 0) goto L_0x0272
        byte[] r0 = r1.toByteArray()
        r3.f3398b = r0
        goto L_0x0272
    L_0x0214:
        r0 = move-exception
        goto L_0x021c
    L_0x0216:
        r0 = move-exception
        r1 = r0
        r10 = 0
        goto L_0x022d
    L_0x021a:
        r0 = move-exception
        r10 = 0
    L_0x021c:
        r0.printStackTrace()     // Catch:{ all -> 0x022b }
        if (r10 == 0) goto L_0x022a
        r10.close()     // Catch:{ Exception -> 0x0225 }
        goto L_0x022a
    L_0x0225:
        r0 = move-exception
        r1 = r0
        r1.printStackTrace()
    L_0x022a:
        return r3
    L_0x022b:
        r0 = move-exception
        r1 = r0
    L_0x022d:
        if (r10 == 0) goto L_0x0238
        r10.close()     // Catch:{ Exception -> 0x0233 }
        goto L_0x0238
    L_0x0233:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x0238:
        throw r1
    L_0x0239:
        r0 = move-exception
        r1 = r0
        r10 = 0
        goto L_0x0255
    L_0x023d:
        r0 = move-exception
        r10 = 0
    L_0x023f:
        r0.printStackTrace()     // Catch:{ all -> 0x0253 }
        java.lang.String r1 = "http"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r5, r1, r0)     // Catch:{ all -> 0x0253 }
        if (r10 == 0) goto L_0x0252
        r10.close()     // Catch:{ IOException -> 0x024d }
        goto L_0x0252
    L_0x024d:
        r0 = move-exception
        r1 = r0
        r1.printStackTrace()
    L_0x0252:
        return r3
    L_0x0253:
        r0 = move-exception
    L_0x0254:
        r1 = r0
    L_0x0255:
        if (r10 == 0) goto L_0x0260
        r10.close()     // Catch:{ IOException -> 0x025b }
        goto L_0x0260
    L_0x025b:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x0260:
        throw r1
    L_0x0261:
        r0 = move-exception
        r0.printStackTrace()
        return r3
    L_0x0266:
        java.lang.Object[] r0 = new java.lang.Object[r8]
        java.lang.String r1 = "conn"
        r0[r7] = r1
        r1 = 1
        r0[r1] = r4
        com.alibaba.mtl.log.p077d.Logger.m3833a(r5, r0)
    L_0x0272:
        return r3
    L_0x0273:
        r0 = move-exception
        r0.printStackTrace()
        return r3
    L_0x0278:
        r0 = move-exception
        r0.printStackTrace()
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p077d.HttpUtils.m3819a(int, java.lang.String, java.util.Map, boolean):com.alibaba.mtl.log.d.e$a");
    }
}
