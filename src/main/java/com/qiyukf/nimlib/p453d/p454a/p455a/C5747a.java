package com.qiyukf.nimlib.p453d.p454a.p455a;

import com.tencent.bugly.BuglyStrategy.C7120a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.d.a.a.a */
public final class C5747a {
    /* renamed from: a */
    private static final Integer f18322a = Integer.valueOf(C7120a.MAX_USERDATA_VALUE_LENGTH);

    /* renamed from: com.qiyukf.nimlib.d.a.a.a$a */
    static class C5748a<T> {
        /* renamed from: a */
        int f18323a = 0;
        /* renamed from: b */
        Throwable f18324b = null;
        /* renamed from: c */
        T f18325c = null;

        C5748a() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    /* renamed from: a */
    public static com.qiyukf.nimlib.p453d.p454a.p455a.C5747a.C5748a<java.lang.String> m23131a(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
        java.lang.String r0 = ", url="
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r2 = "http get url="
        r1.<init>(r2)
        r1.append(r5)
        java.lang.String r1 = r1.toString()
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23147d(r1)
        com.qiyukf.nimlib.d.a.a.a$a r1 = new com.qiyukf.nimlib.d.a.a.a$a
        r1.m49932init()
        r2 = 0
        java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x0082 }
        r3.<init>(r5)     // Catch:{ IOException -> 0x0082 }
        java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0082 }
        java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0082 }
        m23134a(r3)     // Catch:{ IOException -> 0x0082 }
        java.lang.String r4 = "GET"
        r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x0082 }
        m23135a(r3, r6)     // Catch:{ IOException -> 0x0082 }
        int r6 = r3.getResponseCode()     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r1.f18323a = r6     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r2 = 200(0xc8, float:2.8E-43)
        if (r6 != r2) goto L_0x005f
        java.io.InputStream r6 = r3.getInputStream()     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        java.lang.String r6 = m23133a(r6)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r1.f18325c = r6     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        java.lang.String r2 = "http get success, result="
        r6.<init>(r2)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        T r2 = r1.f18325c     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r6.append(r2)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r6.append(r0)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r6.append(r5)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x007c, all -> 0x007a }
    L_0x005b:
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23147d(r6)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        goto L_0x0074
    L_0x005f:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        java.lang.String r4 = "http get failed, code="
        r2.<init>(r4)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r2.append(r6)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r2.append(r0)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        r2.append(r5)     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        java.lang.String r6 = r2.toString()     // Catch:{ IOException -> 0x007c, all -> 0x007a }
        goto L_0x005b
    L_0x0074:
        if (r3 == 0) goto L_0x00a8
        r3.disconnect()
        goto L_0x00a8
    L_0x007a:
        r5 = move-exception
        goto L_0x00a9
    L_0x007c:
        r6 = move-exception
        r2 = r3
        goto L_0x0083
    L_0x007f:
        r5 = move-exception
        r3 = r2
        goto L_0x00a9
    L_0x0082:
        r6 = move-exception
    L_0x0083:
        r6.printStackTrace()     // Catch:{ all -> 0x007f }
        r1.f18324b = r6     // Catch:{ all -> 0x007f }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
        java.lang.String r4 = "http get error, e="
        r3.<init>(r4)     // Catch:{ all -> 0x007f }
        java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x007f }
        r3.append(r6)     // Catch:{ all -> 0x007f }
        r3.append(r0)     // Catch:{ all -> 0x007f }
        r3.append(r5)     // Catch:{ all -> 0x007f }
        java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x007f }
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23147d(r5)     // Catch:{ all -> 0x007f }
        if (r2 == 0) goto L_0x00a8
        r2.disconnect()
    L_0x00a8:
        return r1
    L_0x00a9:
        if (r3 == 0) goto L_0x00ae
        r3.disconnect()
    L_0x00ae:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p454a.p455a.C5747a.m23131a(java.lang.String, java.util.Map):com.qiyukf.nimlib.d.a.a.a$a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0087, code lost:
            if (r2 == null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008a, code lost:
            return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005e, code lost:
            if (r2 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0060, code lost:
            r2.disconnect();
     */
    /* renamed from: a */
    public static <T> com.qiyukf.nimlib.p453d.p454a.p455a.C5747a.C5748a<java.lang.String> m23132a(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, T r6) {
        /*
        java.lang.String r0 = ", url="
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r2 = "http post url="
        r1.<init>(r2)
        r1.append(r4)
        java.lang.String r1 = r1.toString()
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23147d(r1)
        com.qiyukf.nimlib.d.a.a.a$a r1 = new com.qiyukf.nimlib.d.a.a.a$a
        r1.m49932init()
        r2 = 0
        java.net.HttpURLConnection r2 = m23136b(r4, r5, r6)     // Catch:{ IOException -> 0x0066 }
        int r5 = r2.getResponseCode()     // Catch:{ IOException -> 0x0066 }
        r1.f18323a = r5     // Catch:{ IOException -> 0x0066 }
        r6 = 200(0xc8, float:2.8E-43)
        if (r5 != r6) goto L_0x0049
        java.io.InputStream r5 = r2.getInputStream()     // Catch:{ IOException -> 0x0066 }
        java.lang.String r5 = m23133a(r5)     // Catch:{ IOException -> 0x0066 }
        r1.f18325c = r5     // Catch:{ IOException -> 0x0066 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0066 }
        java.lang.String r6 = "http post success, result="
        r5.<init>(r6)     // Catch:{ IOException -> 0x0066 }
        r5.append(r1)     // Catch:{ IOException -> 0x0066 }
        r5.append(r0)     // Catch:{ IOException -> 0x0066 }
        r5.append(r4)     // Catch:{ IOException -> 0x0066 }
        java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0066 }
    L_0x0045:
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23147d(r5)     // Catch:{ IOException -> 0x0066 }
        goto L_0x005e
    L_0x0049:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0066 }
        java.lang.String r3 = "http post failed, code="
        r6.<init>(r3)     // Catch:{ IOException -> 0x0066 }
        r6.append(r5)     // Catch:{ IOException -> 0x0066 }
        r6.append(r0)     // Catch:{ IOException -> 0x0066 }
        r6.append(r4)     // Catch:{ IOException -> 0x0066 }
        java.lang.String r5 = r6.toString()     // Catch:{ IOException -> 0x0066 }
        goto L_0x0045
    L_0x005e:
        if (r2 == 0) goto L_0x008a
    L_0x0060:
        r2.disconnect()
        goto L_0x008a
    L_0x0064:
        r4 = move-exception
        goto L_0x008b
    L_0x0066:
        r5 = move-exception
        r5.printStackTrace()     // Catch:{ all -> 0x0064 }
        r1.f18324b = r5     // Catch:{ all -> 0x0064 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
        java.lang.String r3 = "http post error, e="
        r6.<init>(r3)     // Catch:{ all -> 0x0064 }
        java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0064 }
        r6.append(r5)     // Catch:{ all -> 0x0064 }
        r6.append(r0)     // Catch:{ all -> 0x0064 }
        r6.append(r4)     // Catch:{ all -> 0x0064 }
        java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0064 }
        com.qiyukf.nimlib.p453d.p454a.p456b.C5753a.m23147d(r4)     // Catch:{ all -> 0x0064 }
        if (r2 == 0) goto L_0x008a
        goto L_0x0060
    L_0x008a:
        return r1
    L_0x008b:
        if (r2 == 0) goto L_0x0090
        r2.disconnect()
    L_0x0090:
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p454a.p455a.C5747a.m23132a(java.lang.String, java.util.Map, java.lang.Object):com.qiyukf.nimlib.d.a.a.a$a");
    }

    /* renamed from: a */
    private static String m23133a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            inputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m23134a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setReadTimeout(f18322a.intValue());
        httpURLConnection.setConnectTimeout(f18322a.intValue());
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    private static void m23135a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        httpURLConnection.setRequestProperty("charset", "UTF-8");
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map.get(str));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
            if ("gzip".equals(r5.get(r1)) != false) goto L_0x0040;
     */
    /* renamed from: b */
    private static <T> java.net.HttpURLConnection m23136b(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, T r6) {
        /*
        java.net.URL r0 = new java.net.URL
        r0.<init>(r4)
        java.net.URLConnection r4 = r0.openConnection()
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4
        m23134a(r4)
        java.lang.String r0 = "POST"
        r4.setRequestMethod(r0)
        r0 = 1
        r4.setDoOutput(r0)
        r4.setDoInput(r0)
        m23135a(r4, r5)
        boolean r1 = r6 instanceof org.json.JSONObject
        if (r1 == 0) goto L_0x0028
        java.lang.String r1 = "Content-Type"
        java.lang.String r2 = "application/json"
        r4.setRequestProperty(r1, r2)
    L_0x0028:
        if (r5 == 0) goto L_0x003f
        java.lang.String r1 = "Content-Encoding"
        boolean r2 = r5.containsKey(r1)
        if (r2 == 0) goto L_0x003f
        java.lang.Object r5 = r5.get(r1)
        java.lang.String r1 = "gzip"
        boolean r5 = r1.equals(r5)
        if (r5 == 0) goto L_0x003f
        goto L_0x0040
    L_0x003f:
        r0 = 0
    L_0x0040:
        if (r0 == 0) goto L_0x004c
        java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream
        java.io.OutputStream r0 = r4.getOutputStream()
        r5.<init>(r0)
        goto L_0x0050
    L_0x004c:
        java.io.OutputStream r5 = r4.getOutputStream()
    L_0x0050:
        java.io.DataOutputStream r0 = new java.io.DataOutputStream
        r0.<init>(r5)
        r1 = 0
        boolean r2 = r6 instanceof java.lang.String     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        java.lang.String r3 = "UTF-8"
        if (r2 == 0) goto L_0x0066
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        byte[] r6 = r6.getBytes(r3)     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        r0.write(r6)     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        goto L_0x0081
    L_0x0066:
        boolean r2 = r6 instanceof byte[]     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        if (r2 == 0) goto L_0x0072
        byte[] r6 = (byte[]) r6     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        byte[] r6 = (byte[]) r6     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        r0.write(r6)     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        goto L_0x0081
    L_0x0072:
        boolean r2 = r6 instanceof org.json.JSONObject     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        if (r2 == 0) goto L_0x0081
        java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        byte[] r6 = r6.getBytes(r3)     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        r0.write(r6)     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
    L_0x0081:
        r5.flush()     // Catch:{ IOException -> 0x008d, all -> 0x0085 }
        goto L_0x008f
    L_0x0085:
        r4 = move-exception
        r0.close()
        r5.close()
        throw r4
    L_0x008d:
        r6 = move-exception
        r1 = r6
    L_0x008f:
        r0.close()
        r5.close()
        if (r1 != 0) goto L_0x0098
        return r4
    L_0x0098:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p454a.p455a.C5747a.m23136b(java.lang.String, java.util.Map, java.lang.Object):java.net.HttpURLConnection");
    }
}
