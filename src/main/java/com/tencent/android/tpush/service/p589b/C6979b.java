package com.tencent.android.tpush.service.p589b;

import android.content.Context;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.security.C7043d;
import com.tencent.mid.sotrage.StorageInterface;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.b.b */
public class C6979b {
    /* renamed from: a */
    private static C6979b f23183a;
    /* renamed from: f */
    private static String f23184f;
    /* renamed from: g */
    private static long f23185g;
    /* renamed from: b */
    private Context f23186b = null;
    /* renamed from: c */
    private String f23187c = "182.254.116.117";
    /* renamed from: d */
    private C6978a f23188d = null;
    /* renamed from: e */
    private int f23189e = 300;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.b.b$a */
    static class C6980a implements Runnable {
        /* renamed from: a */
        private String f23190a;
        /* renamed from: b */
        private String f23191b;

        public C6980a(String str) {
            this.f23190a = str;
        }

        public void run() {
            try {
                mo33306a(C6979b.m29801i(this.f23190a));
            } catch (Exception unused) {
            }
        }

        /* renamed from: a */
        public synchronized void mo33306a(String str) {
            this.f23191b = str;
        }

        /* renamed from: a */
        public synchronized String mo33305a() {
            return this.f23191b;
        }
    }

    /* renamed from: h */
    private String m29800h(String str) {
        return "http://182.254.116.117/d?dn=99e2d153e4d0527186ebed5ac5608367&id=6&ttl=1";
    }

    private C6979b(Context context) {
        this.f23186b = context;
        this.f23188d = new C6978a(context, "tpns.qq.com");
    }

    /* renamed from: a */
    public static C6979b m29795a(Context context) {
        if (f23183a == null) {
            synchronized (C6979b.class) {
                if (f23183a == null) {
                    f23183a = new C6979b(context);
                }
            }
        }
        return f23183a;
    }

    /* renamed from: a */
    public String mo33299a(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("azIoMLoU".getBytes("utf-8"), "DES");
            Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(C7043d.m30110b(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public synchronized String mo33298a() {
        try {
            String b = this.f23188d.mo33297b();
            if (m29796b(b)) {
                return b;
            }
            return mo33301c("tpns.qq.com");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m29796b(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || "".equals(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    /* renamed from: c */
    public synchronized String mo33301c(String str) {
        return mo33303e(str);
    }

    /* renamed from: d */
    public String mo33302d(String str) {
        String trim = str.trim();
        if (trim.length() < 8) {
            return null;
        }
        String a = mo33299a(trim);
        ArrayList arrayList = new ArrayList();
        boolean b = m29796b(a);
        String str2 = "exp";
        String str3 = MessageKey.MSG_TTL;
        String str4 = "ips";
        if (b) {
            arrayList.add(a);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str4, a);
                jSONObject.put(str3, 300);
                jSONObject.put(str2, System.currentTimeMillis() + 300000);
                this.f23188d.mo33296a(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            int indexOf = a.indexOf(44);
            if (indexOf > 8) {
                String substring = a.substring(indexOf + 1, a.length());
                if (substring != null && substring.trim().length() > 0) {
                    this.f23189e = Integer.valueOf(substring).intValue();
                    if (this.f23189e < 10) {
                        this.f23189e = 300;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("ttl:");
                sb.append(substring);
                sb.append(StorageInterface.KEY_SPLITER);
                sb.append(this.f23189e);
                C6864a.m29298c("httpDns", sb.toString());
            }
            try {
                String substring2 = a.substring(0, indexOf);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str4, substring2);
                jSONObject2.put(str3, this.f23189e);
                jSONObject2.put(str2, System.currentTimeMillis() + ((long) (this.f23189e * 1000)));
                this.f23188d.mo33296a(jSONObject2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f23188d.mo33297b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[SYNTHETIC, Splitter:B:27:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d A[SYNTHETIC, Splitter:B:36:0x006d] */
    /* renamed from: e */
    public synchronized java.lang.String mo33303e(java.lang.String r7) {
        /*
        r6 = this;
        monitor-enter(r6)
        r0 = 0
        java.lang.String r7 = r6.m29800h(r7)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r1.<init>(r7)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r1 = 3000(0xbb8, float:4.204E-42)
        r7.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r2.<init>(r7)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r1.<init>(r2)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r7 = r0
    L_0x0023:
        java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0054 }
        if (r2 == 0) goto L_0x004a
        java.lang.String r3 = "httpDns"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0054 }
        r4.<init>()     // Catch:{ Exception -> 0x0054 }
        java.lang.String r5 = "getAddrByName line:"
        r4.append(r5)     // Catch:{ Exception -> 0x0054 }
        r4.append(r2)     // Catch:{ Exception -> 0x0054 }
        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0054 }
        com.tencent.android.tpush.p580b.C6864a.m29298c(r3, r4)     // Catch:{ Exception -> 0x0054 }
        boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0054 }
        if (r3 == 0) goto L_0x0023
        java.lang.String r7 = r6.mo33302d(r2)     // Catch:{ Exception -> 0x0054 }
        goto L_0x0023
    L_0x004a:
        r1.close()     // Catch:{ IOException -> 0x004e }
        goto L_0x0052
    L_0x004e:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ all -> 0x0076 }
    L_0x0052:
        monitor-exit(r6)
        return r7
    L_0x0054:
        r7 = move-exception
        goto L_0x005b
    L_0x0056:
        r7 = move-exception
        r1 = r0
        goto L_0x006b
    L_0x0059:
        r7 = move-exception
        r1 = r0
    L_0x005b:
        r7.printStackTrace()     // Catch:{ all -> 0x006a }
        if (r1 == 0) goto L_0x0068
        r1.close()     // Catch:{ IOException -> 0x0064 }
        goto L_0x0068
    L_0x0064:
        r7 = move-exception
        r7.printStackTrace()     // Catch:{ all -> 0x0076 }
    L_0x0068:
        monitor-exit(r6)
        return r0
    L_0x006a:
        r7 = move-exception
    L_0x006b:
        if (r1 == 0) goto L_0x0075
        r1.close()     // Catch:{ IOException -> 0x0071 }
        goto L_0x0075
    L_0x0071:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ all -> 0x0076 }
    L_0x0075:
        throw r7     // Catch:{ all -> 0x0076 }
    L_0x0076:
        r7 = move-exception
        monitor-exit(r6)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p589b.C6979b.mo33303e(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public synchronized boolean mo33300b() {
        return mo33304f("tpns.qq.com");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0078 A[SYNTHETIC, Splitter:B:41:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0084 A[SYNTHETIC, Splitter:B:49:0x0084] */
    /* renamed from: f */
    public synchronized boolean mo33304f(java.lang.String r6) {
        /*
        r5 = this;
        monitor-enter(r5)
        r0 = 0
        r1 = 0
        java.lang.String r6 = r5.m29800h(r6)     // Catch:{ Exception -> 0x0072 }
        java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0072 }
        r2.<init>(r6)     // Catch:{ Exception -> 0x0072 }
        java.net.URLConnection r6 = r2.openConnection()     // Catch:{ Exception -> 0x0072 }
        r2 = 3000(0xbb8, float:4.204E-42)
        r6.setConnectTimeout(r2)     // Catch:{ Exception -> 0x0072 }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0072 }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0072 }
        java.io.InputStream r6 = r6.getInputStream()     // Catch:{ Exception -> 0x0072 }
        r3.<init>(r6)     // Catch:{ Exception -> 0x0072 }
        r2.<init>(r3)     // Catch:{ Exception -> 0x0072 }
        java.lang.String r6 = r2.readLine()     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        if (r6 == 0) goto L_0x0060
        java.lang.String r0 = "httpDns"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        r3.<init>()     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        java.lang.String r4 = "getAddrByName line:"
        r3.append(r4)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        r3.append(r6)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        com.tencent.android.tpush.p580b.C6864a.m29298c(r0, r3)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        int r6 = r6.length()     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        r0 = 8
        if (r6 >= r0) goto L_0x0055
        r2.close()     // Catch:{ IOException -> 0x004f }
        goto L_0x0053
    L_0x004f:
        r6 = move-exception
        r6.printStackTrace()     // Catch:{ all -> 0x008d }
    L_0x0053:
        monitor-exit(r5)
        return r1
    L_0x0055:
        r6 = 1
        r2.close()     // Catch:{ IOException -> 0x005a }
        goto L_0x005e
    L_0x005a:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ all -> 0x008d }
    L_0x005e:
        monitor-exit(r5)
        return r6
    L_0x0060:
        r2.close()     // Catch:{ IOException -> 0x0064 }
        goto L_0x0068
    L_0x0064:
        r6 = move-exception
        r6.printStackTrace()     // Catch:{ all -> 0x008d }
    L_0x0068:
        monitor-exit(r5)
        return r1
    L_0x006a:
        r6 = move-exception
        r0 = r2
        goto L_0x0082
    L_0x006d:
        r6 = move-exception
        r0 = r2
        goto L_0x0073
    L_0x0070:
        r6 = move-exception
        goto L_0x0082
    L_0x0072:
        r6 = move-exception
    L_0x0073:
        r6.printStackTrace()     // Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x0080
        r0.close()     // Catch:{ IOException -> 0x007c }
        goto L_0x0080
    L_0x007c:
        r6 = move-exception
        r6.printStackTrace()     // Catch:{ all -> 0x008d }
    L_0x0080:
        monitor-exit(r5)
        return r1
    L_0x0082:
        if (r0 == 0) goto L_0x008c
        r0.close()     // Catch:{ IOException -> 0x0088 }
        goto L_0x008c
    L_0x0088:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ all -> 0x008d }
    L_0x008c:
        throw r6     // Catch:{ all -> 0x008d }
    L_0x008d:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p589b.C6979b.mo33304f(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
            return r1;
     */
    /* renamed from: c */
    public static synchronized java.lang.String m29797c() {
        /*
        java.lang.Class<com.tencent.android.tpush.service.b.b> r0 = com.tencent.android.tpush.service.p589b.C6979b.class
        monitor-enter(r0)
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0085 }
        long r3 = f23185g     // Catch:{ all -> 0x0085 }
        long r1 = r1 - r3
        long r1 = java.lang.Math.abs(r1)     // Catch:{ all -> 0x0085 }
        r3 = 600000(0x927c0, double:2.964394E-318)
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 >= 0) goto L_0x0039
        java.lang.String r1 = f23184f     // Catch:{ all -> 0x0085 }
        boolean r1 = com.tencent.android.tpush.common.C6914l.m29521c(r1)     // Catch:{ all -> 0x0085 }
        if (r1 != 0) goto L_0x0039
        java.lang.String r1 = "httpDns"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
        r2.<init>()     // Catch:{ all -> 0x0085 }
        java.lang.String r3 = "Use the cached DNS tpns.qq.com -> "
        r2.append(r3)     // Catch:{ all -> 0x0085 }
        java.lang.String r3 = f23184f     // Catch:{ all -> 0x0085 }
        r2.append(r3)     // Catch:{ all -> 0x0085 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0085 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r2)     // Catch:{ all -> 0x0085 }
        java.lang.String r1 = f23184f     // Catch:{ all -> 0x0085 }
        monitor-exit(r0)
        return r1
    L_0x0039:
        com.tencent.android.tpush.service.b.b$a r1 = new com.tencent.android.tpush.service.b.b$a     // Catch:{ all -> 0x0085 }
        java.lang.String r2 = "tpns.qq.com"
        r1.m52029init(r2)     // Catch:{ all -> 0x0085 }
        java.lang.Thread r2 = new java.lang.Thread     // Catch:{ all -> 0x0085 }
        r2.<init>(r1)     // Catch:{ all -> 0x0085 }
        r2.start()     // Catch:{ all -> 0x0085 }
        r3 = 4000(0xfa0, double:1.9763E-320)
        r2.join(r3)     // Catch:{ Exception -> 0x004e }
        goto L_0x0056
    L_0x004e:
        r2 = move-exception
        java.lang.String r3 = "httpDns"
        java.lang.String r4 = "t.join"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r2)     // Catch:{ all -> 0x0085 }
    L_0x0056:
        java.lang.String r1 = r1.mo33305a()     // Catch:{ all -> 0x0085 }
        java.lang.String r2 = "httpDns"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
        r3.<init>()     // Catch:{ all -> 0x0085 }
        java.lang.String r4 = "DNS tpns.qq.com -> "
        r3.append(r4)     // Catch:{ all -> 0x0085 }
        r3.append(r1)     // Catch:{ all -> 0x0085 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0085 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r3)     // Catch:{ all -> 0x0085 }
        boolean r2 = com.tencent.android.tpush.common.C6914l.m29521c(r1)     // Catch:{ all -> 0x0085 }
        if (r2 == 0) goto L_0x007b
        java.lang.String r1 = m29798d()     // Catch:{ all -> 0x0085 }
        goto L_0x0083
    L_0x007b:
        f23184f = r1     // Catch:{ all -> 0x0085 }
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0085 }
        f23185g = r2     // Catch:{ all -> 0x0085 }
    L_0x0083:
        monitor-exit(r0)
        return r1
    L_0x0085:
        r1 = move-exception
        monitor-exit(r0)
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p589b.C6979b.m29797c():java.lang.String");
    }

    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static String m29801i(String str) {
        InetAddress inetAddress;
        String str2 = "httpDns";
        if (C6914l.m29521c(str)) {
            return null;
        }
        try {
            System.nanoTime();
            long nanoTime = System.nanoTime();
            InetAddress[] allByName = InetAddress.getAllByName(str);
            long nanoTime2 = System.nanoTime();
            if (allByName == null || allByName.length <= 0) {
                inetAddress = null;
            } else {
                inetAddress = allByName[0];
                StringBuilder sb = new StringBuilder();
                sb.append("DNS ");
                sb.append(str);
                sb.append(" -> ");
                sb.append(inetAddress);
                sb.append(" in ");
                sb.append((nanoTime2 - nanoTime) / 1000000);
                sb.append("ms");
                C6864a.m29308i(str2, sb.toString());
            }
            if (inetAddress != null) {
                return inetAddress.getHostAddress();
            }
        } catch (Throwable th) {
            C6864a.m29302d(str2, "NSLookup error: ", th);
        }
        return null;
    }

    /* renamed from: d */
    private static String m29798d() {
        return new Random().nextInt(1) == 0 ? "203.205.179.220" : "203.205.179.210";
    }
}
