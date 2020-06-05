package btmsdkobf;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: btmsdkobf.fe */
public class C0846fe {
    /* renamed from: oa */
    public static String f981oa;

    /* renamed from: btmsdkobf.fe$a */
    public interface C0847a {
        /* renamed from: c */
        void mo9305c(boolean z, boolean z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078  */
    /* renamed from: a */
    public static java.lang.String m899a(btmsdkobf.C0846fe.C0847a r7) {
        /*
        java.lang.String r0 = "Meri"
        java.lang.String r1 = "no-cache"
        r2 = 0
        r3 = 0
        java.net.URL r4 = new java.net.URL     // Catch:{ all -> 0x0075 }
        java.lang.String r5 = "http://tools.3g.qq.com/cw.html"
        r4.<init>(r5)     // Catch:{ all -> 0x0075 }
        java.net.URLConnection r4 = r4.openConnection()     // Catch:{ all -> 0x0075 }
        java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x0075 }
        int r5 = btmsdkobf.C0875j.m991v()     // Catch:{ all -> 0x0073 }
        r6 = 8
        if (r5 >= r6) goto L_0x0022
        java.lang.String r5 = "http.keepAlive"
        java.lang.String r6 = "false"
        java.lang.System.setProperty(r5, r6)     // Catch:{ all -> 0x0073 }
    L_0x0022:
        r4.setUseCaches(r3)     // Catch:{ all -> 0x0073 }
        java.lang.String r5 = "Pragma"
        r4.setRequestProperty(r5, r1)     // Catch:{ all -> 0x0073 }
        java.lang.String r5 = "Cache-Control"
        r4.setRequestProperty(r5, r1)     // Catch:{ all -> 0x0073 }
        r4.setInstanceFollowRedirects(r3)     // Catch:{ all -> 0x0073 }
        java.lang.String r1 = "GET"
        r4.setRequestMethod(r1)     // Catch:{ all -> 0x0073 }
        r1 = 5000(0x1388, float:7.006E-42)
        r4.setReadTimeout(r1)     // Catch:{ all -> 0x0073 }
        int r1 = r4.getResponseCode()     // Catch:{ all -> 0x0073 }
        r5 = 200(0xc8, float:2.8E-43)
        r6 = 1
        if (r1 == r5) goto L_0x0050
        r5 = 301(0x12d, float:4.22E-43)
        if (r1 < r5) goto L_0x004e
        r5 = 305(0x131, float:4.27E-43)
        if (r1 > r5) goto L_0x004e
        goto L_0x0050
    L_0x004e:
        r0 = 1
        goto L_0x0062
    L_0x0050:
        java.lang.String r1 = r4.getHeaderField(r0)     // Catch:{ all -> 0x0073 }
        if (r1 == 0) goto L_0x005c
        boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x0073 }
        if (r0 != 0) goto L_0x0061
    L_0x005c:
        java.lang.String r0 = m900a(r4)     // Catch:{ all -> 0x0073 }
        r2 = r0
    L_0x0061:
        r0 = 0
    L_0x0062:
        if (r4 == 0) goto L_0x0067
        r4.disconnect()
    L_0x0067:
        if (r2 != 0) goto L_0x006d
        r7.mo9305c(r3, r0)
        goto L_0x007e
    L_0x006d:
        f981oa = r2
        r7.mo9305c(r6, r0)
        goto L_0x007e
        goto L_0x0076
    L_0x0075:
        r4 = r2
    L_0x0076:
        if (r4 == 0) goto L_0x007b
        r4.disconnect()
    L_0x007b:
        r7.mo9305c(r3, r3)
    L_0x007e:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0846fe.m899a(btmsdkobf.fe$a):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
            if (r2 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0072, code lost:
            if (0 != 0) goto L_0x006d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[SYNTHETIC, Splitter:B:15:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b A[SYNTHETIC, Splitter:B:25:0x005b] */
    /* renamed from: a */
    private static java.lang.String m900a(java.net.HttpURLConnection r5) {
        /*
        java.lang.String r0 = "Refresh"
        java.lang.String r1 = "Location"
        r2 = 0
        java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x0071 }
        java.lang.String r4 = "http://tools.3g.qq.com/cw.html"
        r3.<init>(r4)     // Catch:{ all -> 0x0071 }
        java.lang.String r3 = r3.getHost()     // Catch:{ all -> 0x0071 }
        java.net.URL r4 = r5.getURL()     // Catch:{ all -> 0x0071 }
        java.lang.String r4 = r4.getHost()     // Catch:{ all -> 0x0071 }
        boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0071 }
        if (r3 != 0) goto L_0x0027
        java.net.URL r3 = r5.getURL()     // Catch:{ all -> 0x0071 }
        java.lang.String r3 = r3.toExternalForm()     // Catch:{ all -> 0x0071 }
        goto L_0x0028
    L_0x0027:
        r3 = r2
    L_0x0028:
        if (r3 != 0) goto L_0x0037
        java.lang.String r4 = r5.getHeaderField(r1)     // Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x0037
        java.lang.String r1 = r5.getHeaderField(r1)     // Catch:{ all -> 0x0035 }
        goto L_0x0038
    L_0x0035:
        r0 = r3
        goto L_0x0072
    L_0x0037:
        r1 = r3
    L_0x0038:
        if (r1 != 0) goto L_0x0058
        java.lang.String r3 = r5.getHeaderField(r0)     // Catch:{ all -> 0x0056 }
        if (r3 == 0) goto L_0x0058
        java.lang.String r0 = r5.getHeaderField(r0)     // Catch:{ all -> 0x0056 }
        java.lang.String r3 = ";"
        java.lang.String[] r0 = r0.split(r3)     // Catch:{ all -> 0x0056 }
        int r3 = r0.length     // Catch:{ all -> 0x0056 }
        r4 = 2
        if (r3 != r4) goto L_0x0058
        r3 = 1
        r0 = r0[r3]     // Catch:{ all -> 0x0056 }
        java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x0056 }
        goto L_0x0059
    L_0x0056:
        r0 = r1
        goto L_0x0072
    L_0x0058:
        r0 = r1
    L_0x0059:
        if (r0 != 0) goto L_0x006b
        java.io.InputStream r2 = r5.getInputStream()     // Catch:{ all -> 0x0069 }
        if (r2 == 0) goto L_0x006b
        java.lang.String r5 = m901b(r2)     // Catch:{ all -> 0x0069 }
        if (r5 == 0) goto L_0x006b
        r0 = r5
        goto L_0x006b
        goto L_0x0072
    L_0x006b:
        if (r2 == 0) goto L_0x0075
    L_0x006d:
        r2.close()     // Catch:{ IOException -> 0x0075 }
        goto L_0x0075
    L_0x0071:
        r0 = r2
    L_0x0072:
        if (r2 == 0) goto L_0x0075
        goto L_0x006d
    L_0x0075:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0846fe.m900a(java.net.HttpURLConnection):java.lang.String");
    }

    /* renamed from: b */
    private static String m901b(InputStream inputStream) {
        String c = m902c(inputStream);
        String[] strArr = {"http-equiv\\s*=\\s*[\"']*refresh[\"']*\\s*content\\s*=\\s*[\"']*[^;]*;\\s*url\\s*=\\s*[\"']*([^\"'\\s>]+)", "[^\\w](?:location.href\\s*=|location\\s*=|location.replace\\s*\\()\\s*[\"']*([^\"'>]+)", "<NextURL>([^<]+)", "\\s+action\\s*=\\s*[\"']*([^\"'>]+)[\"'>\\s]*.*submit", "<LoginURL>([^<]+)"};
        int length = strArr.length;
        String str = null;
        for (int i = 0; i < length && str == null; i++) {
            Matcher matcher = Pattern.compile(strArr[i], 2).matcher(c);
            while (matcher.find() && str == null) {
                str = matcher.group(matcher.groupCount());
                if (str != null && !str.trim().toLowerCase().startsWith("http")) {
                    str = null;
                }
            }
        }
        return str;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0019 */
    /* renamed from: c */
    private static java.lang.String m902c(java.io.InputStream r2) {
        /*
        java.io.BufferedReader r0 = new java.io.BufferedReader
        java.io.InputStreamReader r1 = new java.io.InputStreamReader
        r1.<init>(r2)
        r0.<init>(r1)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
    L_0x000f:
        java.lang.String r1 = r0.readLine()     // Catch:{ IOException -> 0x0019, all -> 0x001d }
        if (r1 == 0) goto L_0x0019
        r2.append(r1)     // Catch:{ IOException -> 0x0019, all -> 0x001d }
        goto L_0x000f
    L_0x0019:
        r0.close()     // Catch:{ IOException -> 0x0022 }
        goto L_0x0022
    L_0x001d:
        r2 = move-exception
        r0.close()     // Catch:{ IOException -> 0x0021 }
    L_0x0021:
        throw r2
    L_0x0022:
        java.lang.String r2 = r2.toString()
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0846fe.m902c(java.io.InputStream):java.lang.String");
    }
}
