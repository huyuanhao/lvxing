package com.kwad.sdk.core.p326e.p328b;

import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4320a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.kwad.sdk.core.e.b.a */
public class C4107a {
    /* renamed from: a */
    public static C4320a m17055a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        C4320a aVar = new C4320a();
        try {
            new StringBuilder();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            m17060a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            aVar.f14210a = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            }
        } catch (IOException | MalformedURLException e) {
            C4065b.m16865a(e);
        }
        aVar.f14211b = sb.toString();
        return aVar;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v9, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v4
  assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.io.OutputStream]
  uses: [?[OBJECT, ARRAY], ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.net.HttpURLConnection, java.io.OutputStream]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0085 A[SYNTHETIC, Splitter:B:35:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099 A[SYNTHETIC, Splitter:B:45:0x0099] */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    public static com.kwad.sdk.core.response.p341a.C4320a m17056a(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, boolean r7) {
        /*
        com.kwad.sdk.core.response.a.a r0 = new com.kwad.sdk.core.response.a.a
        r0.m48251init()
        r1 = 0
        java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
        r2.<init>(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
        java.net.URLConnection r4 = r2.openConnection()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
        r2 = 1
        r4.setDoInput(r2)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r4.setDoOutput(r2)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        java.lang.String r2 = "POST"
        r4.setRequestMethod(r2)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        java.lang.String r2 = "Content-Type"
        if (r7 == 0) goto L_0x0027
        java.lang.String r7 = "application/json"
    L_0x0023:
        r4.setRequestProperty(r2, r7)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        goto L_0x002a
    L_0x0027:
        java.lang.String r7 = "application/x-www-form-urlencoded"
        goto L_0x0023
    L_0x002a:
        m17060a(r4, r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r5 = 5000(0x1388, float:7.006E-42)
        r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r5 = 0
        r4.setUseCaches(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r4.connect()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        if (r5 != 0) goto L_0x0050
        java.io.OutputStream r1 = r4.getOutputStream()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        byte[] r5 = r6.getBytes()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r1.write(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r1.flush()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
    L_0x0050:
        int r5 = r4.getResponseCode()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r0.f14210a = r5     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r6 = 200(0xc8, float:2.8E-43)
        if (r5 != r6) goto L_0x0064
        java.io.InputStream r5 = r4.getInputStream()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        java.lang.String r5 = m17058a(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        r0.f14211b = r5     // Catch:{ Exception -> 0x0071, all -> 0x006f }
    L_0x0064:
        if (r4 == 0) goto L_0x0069
        r4.disconnect()
    L_0x0069:
        if (r1 == 0) goto L_0x008d
        r1.close()     // Catch:{ IOException -> 0x0089 }
        goto L_0x008d
    L_0x006f:
        r5 = move-exception
        goto L_0x0092
    L_0x0071:
        r5 = move-exception
        r3 = r1
        r1 = r4
        r4 = r3
        goto L_0x007b
    L_0x0076:
        r5 = move-exception
        r4 = r1
        goto L_0x0092
    L_0x0079:
        r5 = move-exception
        r4 = r1
    L_0x007b:
        com.kwad.sdk.core.p319c.C4065b.m16865a(r5)     // Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x0083
        r1.disconnect()
    L_0x0083:
        if (r4 == 0) goto L_0x008d
        r4.close()     // Catch:{ IOException -> 0x0089 }
        goto L_0x008d
    L_0x0089:
        r4 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r4)
    L_0x008d:
        return r0
    L_0x008e:
        r5 = move-exception
        r3 = r1
        r1 = r4
        r4 = r3
    L_0x0092:
        if (r4 == 0) goto L_0x0097
        r4.disconnect()
    L_0x0097:
        if (r1 == 0) goto L_0x00a1
        r1.close()     // Catch:{ IOException -> 0x009d }
        goto L_0x00a1
    L_0x009d:
        r4 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r4)
    L_0x00a1:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p326e.p328b.C4107a.m17056a(java.lang.String, java.util.Map, java.lang.String, boolean):com.kwad.sdk.core.response.a.a");
    }

    /* renamed from: a */
    public static C4320a m17057a(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Entry entry : map2.entrySet()) {
                String a = m17059a((String) entry.getValue());
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(a);
                sb.append("&");
            }
            str2 = sb.substring(0, sb.length() - 1);
        } else {
            str2 = null;
        }
        return m17056a(str, map, str2, false);
    }

    /* renamed from: a */
    private static String m17058a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                C4065b.m16865a(e);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        C4065b.m16865a(e2);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    C4065b.m16865a(e3);
                }
                return null;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        C4065b.m16865a(e4);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    C4065b.m16865a(e5);
                }
            }
        }
        String str = new String(byteArrayOutputStream.toByteArray());
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                C4065b.m16865a(e6);
            }
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e7) {
            C4065b.m16865a(e7);
        }
        return str;
    }

    /* renamed from: a */
    private static String m17059a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4065b.m16865a(e);
            return str2;
        }
    }

    /* renamed from: a */
    private static void m17060a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null && httpURLConnection != null) {
            for (Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
