package com.alibaba.mtl.log.p079f;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.Log;
import com.alibaba.mtl.log.p074a.Config;
import com.alibaba.mtl.log.p074a.HostConfig;
import com.alibaba.mtl.log.p074a.HostConfigMgr;
import com.alibaba.mtl.log.p075b.CoreStatics;
import com.alibaba.mtl.log.p076c.LogStoreMgr;
import com.alibaba.mtl.log.p077d.ApiResponseParse;
import com.alibaba.mtl.log.p077d.ApiResponseParse.C1315a;
import com.alibaba.mtl.log.p077d.HttpUtils;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.MutiProcessLock;
import com.alibaba.mtl.log.p077d.NetworkUtil;
import com.alibaba.mtl.log.p077d.UrlWrapper;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: UploadTask */
/* renamed from: com.alibaba.mtl.log.f.b */
public abstract class C1333b implements Runnable {
    /* renamed from: a */
    private static volatile boolean f3453a = false;
    /* renamed from: c */
    static int f3454c = 0;
    /* renamed from: f */
    private static boolean f3455f = false;
    /* renamed from: b */
    int f3456b = -1;
    /* renamed from: d */
    float f3457d = 200.0f;
    /* renamed from: e */
    int f3458e = 0;

    /* renamed from: a */
    public abstract void mo11832a();

    /* renamed from: b */
    public abstract void mo11833b();

    public void run() {
        try {
            m3905d();
            mo11832a();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static boolean m3904c() {
        return f3453a;
    }

    /* renamed from: d */
    private void m3905d() {
        int i;
        List list;
        String str;
        String str2;
        String str3 = "UploadTask";
        Logger.m3833a(str3, "Upload");
        if (!UTDC.f3279j) {
            Logger.m3834a(str3, "Upload is disabled");
            return;
        }
        if (NetworkUtil.m3847b() && !f3455f && !f3453a) {
            f3453a = true;
            Map b = HostConfigMgr.m3724a().mo11766b();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    break;
                } else if (!MutiProcessLock.m3842a(UTDC.m3697c())) {
                    Logger.m3833a(str3, "Other Process is Uploading, break");
                    break;
                } else {
                    LogStoreMgr.m3777a().mo11792b();
                    if (b != null && b.size() > 0) {
                        list = null;
                        while (true) {
                            if (i2 >= b.size()) {
                                i = i2;
                                str = null;
                                break;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(i2);
                            sb.append("");
                            HostConfig cVar = (HostConfig) b.get(sb.toString());
                            if (cVar.f3304b == null || cVar.f3304b.size() <= 0) {
                                str2 = null;
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("eventId");
                                sb2.append(" in (");
                                for (int i4 = 0; i4 < cVar.f3304b.size(); i4++) {
                                    if (i4 != 0) {
                                        sb2.append(" , ");
                                    }
                                    sb2.append((String) cVar.f3304b.get(i4));
                                }
                                sb2.append(" ) ");
                                str2 = sb2.toString();
                            }
                            List a = LogStoreMgr.m3777a().mo11790a(str2, m3906e());
                            if (a.size() > 0) {
                                List list2 = a;
                                i = i2;
                                str = cVar.f3303a;
                                list = list2;
                                break;
                            }
                            i2++;
                            list = a;
                        }
                    } else {
                        i = i2;
                        str = null;
                        list = null;
                    }
                    if (list == null || (list != null && list.size() == 0)) {
                        list = LogStoreMgr.m3777a().mo11790a((String) null, m3906e());
                    }
                    if (list == null || list.size() == 0) {
                        f3453a = false;
                    } else {
                        int a2 = m3899a(list);
                        Map b2 = m3903b(list);
                        if (b2 == null || b2.size() == 0) {
                            f3453a = false;
                        } else {
                            try {
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                String a3 = Config.m3704a();
                                if (!TextUtils.isEmpty(str)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("http://");
                                    sb3.append(str);
                                    sb3.append("/rest/sur");
                                    a3 = sb3.toString();
                                }
                                C1315a a4 = m3900a(UrlWrapper.m3879a(a3, null, b2), b2);
                                boolean z = a4.f3373a;
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                long j = elapsedRealtime2 - elapsedRealtime;
                                m3898a(Boolean.valueOf(z), j);
                                if (!z) {
                                    CoreStatics.m3738a(list.size() - a2);
                                    CoreStatics.m3742b();
                                    if (!a4.mo11797a()) {
                                        if (a4.mo11798b()) {
                                            f3455f = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    int a5 = LogStoreMgr.m3777a().mo11789a(list);
                                    if (a5 < list.size() - a2) {
                                        mo11833b();
                                    }
                                    CoreStatics.m3740a(list, a5);
                                    CoreStatics.m3737a();
                                }
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                Logger.m3833a(str3, "logs.size():", Integer.valueOf(list.size()), " selfMonitorLogCount:", Integer.valueOf(a2));
                                Logger.m3833a(str3, "upload isSendSuccess:", Boolean.valueOf(z), " consume:", Long.valueOf(j), " delete consume:", Long.valueOf(elapsedRealtime3 - elapsedRealtime2));
                                Thread.sleep((long) new Random().nextInt(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT));
                            } catch (Throwable unused) {
                            }
                            MutiProcessLock.m3841a();
                            i3++;
                            i2 = i;
                        }
                    }
                }
            }
            MutiProcessLock.m3841a();
            f3453a = false;
            MutiProcessLock.m3841a();
        }
    }

    /* renamed from: a */
    private int m3899a(List<Log> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = ((Log) list.get(i2)).f3462b;
            if (str != null) {
                if ("6005".equalsIgnoreCase(str.toString())) {
                    i++;
                }
            }
        }
        return i;
    }

    /* renamed from: e */
    private int m3906e() {
        if (this.f3456b == -1) {
            String a = NetworkUtil.m3843a();
            if ("wifi".equalsIgnoreCase(a)) {
                this.f3456b = 20;
            } else if ("4G".equalsIgnoreCase(a)) {
                this.f3456b = 16;
            } else if ("3G".equalsIgnoreCase(a)) {
                this.f3456b = 12;
            } else {
                this.f3456b = 8;
            }
        }
        return this.f3456b;
    }

    /* renamed from: a */
    private C1315a m3900a(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = HttpUtils.m3819a(2, str, map, false).f3398b;
            Object[] objArr = {"url:", str};
            String str2 = "UploadTask";
            Logger.m3833a(str2, objArr);
            if (bArr != null) {
                String str3 = null;
                try {
                    str3 = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (str3 != null) {
                    Logger.m3833a(str2, "result:", str3);
                    return ApiResponseParse.m3787a(str3);
                }
            }
        }
        return C1315a.f3372c;
    }

    /* renamed from: a */
    private int m3898a(Boolean bool, long j) {
        if (j < 0) {
            return this.f3456b;
        }
        float f = ((float) this.f3458e) / ((float) j);
        if (!bool.booleanValue()) {
            this.f3456b /= 2;
            f3454c++;
        } else if (j > 45000) {
            return this.f3456b;
        } else {
            this.f3456b = (int) ((((double) (f * 45000.0f)) / ((double) this.f3457d)) - ((double) f3454c));
        }
        int i = this.f3456b;
        if (i < 1) {
            this.f3456b = 1;
            f3454c = 0;
        } else if (i > 350) {
            this.f3456b = TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE;
        }
        Logger.m3833a("UploadTask", "winsize:", Integer.valueOf(this.f3456b));
        return this.f3456b;
    }

    /* renamed from: b */
    private Map<String, Object> m3903b(List<Log> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            List a = m3901a((Log) list.get(i));
            if (a != null) {
                for (int i2 = 0; i2 < a.size(); i2++) {
                    StringBuilder sb = (StringBuilder) hashMap.get(a.get(i2));
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap.put(a.get(i2), sb);
                    } else {
                        sb.append("\n");
                    }
                    sb.append(((Log) list.get(i)).mo11835a());
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        this.f3458e = 0;
        for (String str : hashMap.keySet()) {
            byte[] a2 = m3902a(((StringBuilder) hashMap.get(str)).toString());
            hashMap2.put(str, a2);
            this.f3458e += a2.length;
        }
        this.f3457d = ((float) this.f3458e) / ((float) list.size());
        Logger.m3833a("UploadTask", "averagePackageSize:", Float.valueOf(this.f3457d));
        return hashMap2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029 A[SYNTHETIC, Splitter:B:17:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A[SYNTHETIC, Splitter:B:26:0x003c] */
    /* renamed from: a */
    private byte[] m3902a(java.lang.String r4) {
        /*
        r3 = this;
        java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
        r0.<init>()
        r1 = 0
        java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0023 }
        r2.<init>(r0)     // Catch:{ IOException -> 0x0023 }
        java.lang.String r1 = "UTF-8"
        byte[] r4 = r4.getBytes(r1)     // Catch:{ IOException -> 0x001d, all -> 0x001b }
        r2.write(r4)     // Catch:{ IOException -> 0x001d, all -> 0x001b }
        r2.flush()     // Catch:{ IOException -> 0x001d, all -> 0x001b }
        r2.close()     // Catch:{ Exception -> 0x002c }
        goto L_0x002c
    L_0x001b:
        r4 = move-exception
        goto L_0x003a
    L_0x001d:
        r4 = move-exception
        r1 = r2
        goto L_0x0024
    L_0x0020:
        r4 = move-exception
        r2 = r1
        goto L_0x003a
    L_0x0023:
        r4 = move-exception
    L_0x0024:
        r4.printStackTrace()     // Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x002c
        r1.close()     // Catch:{ Exception -> 0x002c }
    L_0x002c:
        byte[] r4 = r0.toByteArray()
        java.lang.String r1 = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"
        byte[] r4 = com.alibaba.mtl.log.p077d.RC4.m3857a(r4, r1)
        r0.close()     // Catch:{ Exception -> 0x0039 }
    L_0x0039:
        return r4
    L_0x003a:
        if (r2 == 0) goto L_0x003f
        r2.close()     // Catch:{ Exception -> 0x003f }
    L_0x003f:
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p079f.C1333b.m3902a(java.lang.String):byte[]");
    }

    /* renamed from: a */
    private List<String> m3901a(Log aVar) {
        return Config.m3705a(aVar.f3462b);
    }
}
