package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7130d;
import com.tencent.bugly.beta.p602ui.C7144c;
import com.tencent.bugly.beta.utils.C7159e;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.t */
public class C7277t extends DownloadTask implements Runnable {
    /* renamed from: k */
    public long f24613k = 0;
    /* renamed from: l */
    private File f24614l;
    /* renamed from: m */
    private long f24615m = 0;

    public C7277t(String str, String str2, long j, long j2, String str3) {
        String str4 = "";
        super(str, str4, str4, str3);
        this.f24614l = new File(str2);
        this.f23674b = this.f24614l.getParent();
        this.f23675c = this.f24614l.getName();
        this.f23677e = j;
        this.f23678f = j2;
        getStatus();
    }

    public C7277t(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        getStatus();
    }

    public File getSaveFile() {
        return this.f24614l;
    }

    public void download() {
        if (getStatus() == 1) {
            mo34966b();
        } else if (getStatus() != 2) {
            if (getSaveFile() == null || !getSaveFile().exists()) {
                this.f23677e = 0;
                this.f23678f = 0;
                this.f24613k = 0;
            } else {
                this.f23677e = getSaveFile().length();
            }
            if (this.f23679g) {
                C7144c.f23780a.mo34444a(this);
            }
            this.f24615m = System.currentTimeMillis();
            this.f23681i = 2;
            C7275s.f24609a.f24610b.put(getDownloadUrl(), this);
            C7275s.f24609a.mo34962a(this);
        }
    }

    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            C7270p.f24600a.mo34955b((DownloadTask) this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f23675c = null;
        this.f23677e = 0;
        this.f23678f = 0;
        this.f23681i = 4;
    }

    public void stop() {
        if (this.f23681i != 5) {
            this.f23681i = 3;
        }
    }

    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f23678f && !C7275s.f24609a.f24610b.contains(this)) {
            this.f23677e = this.f23678f;
            this.f23681i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f23678f && !C7275s.f24609a.f24610b.contains(this)) {
            this.f23677e = getSaveFile().length();
            this.f23681i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !C7275s.f24609a.f24610b.contains(this)) {
            this.f23681i = 0;
        }
        return this.f23681i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x019e, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x019f, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0094, code lost:
            mo34965a(2000, "tLen <= 0 ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0099, code lost:
            if (r5 == null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
            if (r6 == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a4, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a5, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00dc, code lost:
            mo34966b();
            com.tencent.bugly.proguard.C7226an.m31149e("mSavedLength > mTotalLength,重新下载!", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e9, code lost:
            if (r6 == null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ef, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f0, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0129, code lost:
            if (r6 == null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012f, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0130, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            mo34966b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013b, code lost:
            r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0178, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0179, code lost:
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x017b, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            mo34965a(2000, r0.getMessage());
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0186, code lost:
            if (r6 != null) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x018c, code lost:
            if (r6 != null) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0192, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0193, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0197, code lost:
            throw r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x015e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015b A[SYNTHETIC, Splitter:B:75:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0163 A[Catch:{ Exception -> 0x017b, all -> 0x0178 }] */
    public void run() {
        /*
        r18 = this;
        r1 = r18
        java.lang.Class<com.tencent.bugly.proguard.t> r2 = com.tencent.bugly.proguard.C7277t.class
        r3 = 0
        java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x01a4 }
        java.lang.String r0 = r18.getDownloadUrl()     // Catch:{ MalformedURLException -> 0x01a4 }
        r4.<init>(r0)     // Catch:{ MalformedURLException -> 0x01a4 }
        r0 = 0
        r5 = r0
        r6 = r5
        r0 = 0
    L_0x0012:
        r7 = 2000(0x7d0, float:2.803E-42)
        r8 = 3
        if (r0 >= r8) goto L_0x0167
        int r9 = r0 + 1
        java.net.URLConnection r0 = r4.openConnection()     // Catch:{ IOException -> 0x0145 }
        javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ IOException -> 0x0145 }
        r10 = 5000(0x1388, float:7.006E-42)
        r0.setConnectTimeout(r10)     // Catch:{ IOException -> 0x0145 }
        java.lang.String r10 = "GET"
        r0.setRequestMethod(r10)     // Catch:{ IOException -> 0x0145 }
        java.lang.String r10 = "Referer"
        java.lang.String r11 = r4.toString()     // Catch:{ IOException -> 0x0145 }
        r0.setRequestProperty(r10, r11)     // Catch:{ IOException -> 0x0145 }
        java.lang.String r10 = "Charset"
        java.lang.String r11 = "UTF-8"
        r0.setRequestProperty(r10, r11)     // Catch:{ IOException -> 0x0145 }
        java.lang.String r10 = "Range"
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0145 }
        r11.<init>()     // Catch:{ IOException -> 0x0145 }
        java.lang.String r12 = "bytes="
        r11.append(r12)     // Catch:{ IOException -> 0x0145 }
        long r12 = r1.f23677e     // Catch:{ IOException -> 0x0145 }
        r11.append(r12)     // Catch:{ IOException -> 0x0145 }
        java.lang.String r12 = "-"
        r11.append(r12)     // Catch:{ IOException -> 0x0145 }
        java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0145 }
        r0.setRequestProperty(r10, r11)     // Catch:{ IOException -> 0x0145 }
        java.lang.String r10 = "Connection"
        java.lang.String r11 = "Keep-Alive"
        r0.setRequestProperty(r10, r11)     // Catch:{ IOException -> 0x0145 }
        r0.connect()     // Catch:{ IOException -> 0x0145 }
        java.lang.String r10 = r1.m31422a(r0)     // Catch:{ IOException -> 0x0145 }
        r1.f23675c = r10     // Catch:{ IOException -> 0x0145 }
        java.io.File r10 = new java.io.File     // Catch:{ IOException -> 0x0145 }
        java.lang.String r11 = r1.f23674b     // Catch:{ IOException -> 0x0145 }
        r10.<init>(r11)     // Catch:{ IOException -> 0x0145 }
        boolean r11 = r10.exists()     // Catch:{ IOException -> 0x0145 }
        if (r11 != 0) goto L_0x0076
        r10.mkdirs()     // Catch:{ IOException -> 0x0145 }
    L_0x0076:
        java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x0145 }
        java.lang.String r12 = r1.f23675c     // Catch:{ IOException -> 0x0145 }
        r11.<init>(r10, r12)     // Catch:{ IOException -> 0x0145 }
        r1.f24614l = r11     // Catch:{ IOException -> 0x0145 }
        long r10 = r1.f23678f     // Catch:{ IOException -> 0x0145 }
        r12 = 0
        int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
        if (r14 != 0) goto L_0x00aa
        int r10 = r0.getContentLength()     // Catch:{ IOException -> 0x0145 }
        long r10 = (long) r10     // Catch:{ IOException -> 0x0145 }
        r1.f23678f = r10     // Catch:{ IOException -> 0x0145 }
        long r10 = r1.f23678f     // Catch:{ IOException -> 0x0145 }
        int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
        if (r14 > 0) goto L_0x00aa
        java.lang.String r0 = "tLen <= 0 "
        r1.mo34965a(r7, r0)     // Catch:{ IOException -> 0x0145 }
        if (r5 == 0) goto L_0x009e
        r5.close()     // Catch:{ Exception -> 0x017b }
    L_0x009e:
        if (r6 == 0) goto L_0x00a9
        r6.close()     // Catch:{ Exception -> 0x00a4 }
        goto L_0x00a9
    L_0x00a4:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x00a9:
        return
    L_0x00aa:
        com.tencent.bugly.proguard.p r10 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ IOException -> 0x0145 }
        r10.mo34952a(r1)     // Catch:{ IOException -> 0x0145 }
        java.io.InputStream r6 = r0.getInputStream()     // Catch:{ IOException -> 0x0145 }
        r0 = 307200(0x4b000, float:4.30479E-40)
        byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0145 }
        java.io.RandomAccessFile r10 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0145 }
        java.io.File r11 = r1.f24614l     // Catch:{ IOException -> 0x0145 }
        java.lang.String r12 = "rwd"
        r10.<init>(r11, r12)     // Catch:{ IOException -> 0x0145 }
        long r11 = r1.f23677e     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        r10.seek(r11)     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        r5 = 0
    L_0x00c7:
        int r11 = r6.read(r0)     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        r12 = -1
        if (r11 == r12) goto L_0x0135
        long r12 = r1.f23677e     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        long r14 = (long) r11     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        long r12 = r12 + r14
        r1.f23677e = r12     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        long r12 = r1.f23677e     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        long r14 = r1.f23678f     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
        if (r16 <= 0) goto L_0x00f5
        r18.mo34966b()     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        java.lang.String r0 = "mSavedLength > mTotalLength,重新下载!"
        java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r5)     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        r10.close()     // Catch:{ Exception -> 0x017b }
        if (r6 == 0) goto L_0x00f4
        r6.close()     // Catch:{ Exception -> 0x00ef }
        goto L_0x00f4
    L_0x00ef:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x00f4:
        return
    L_0x00f5:
        r12 = 1120403456(0x42c80000, float:100.0)
        long r13 = r1.f23677e     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        float r13 = (float) r13     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        long r14 = r1.f23678f     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        float r14 = (float) r14     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        float r13 = r13 / r14
        float r13 = r13 * r12
        float r12 = r13 - r5
        double r14 = (double) r12     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        int r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
        if (r12 < 0) goto L_0x010d
        r18.mo34964a()     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        r5 = r13
    L_0x010d:
        r10.write(r0, r3, r11)     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        java.io.File r11 = r18.getSaveFile()     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        if (r11 == 0) goto L_0x0126
        java.io.File r11 = r18.getSaveFile()     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        boolean r11 = r11.exists()     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        if (r11 == 0) goto L_0x0126
        int r11 = r18.getStatus()     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        if (r11 != r8) goto L_0x00c7
    L_0x0126:
        r10.close()     // Catch:{ Exception -> 0x017b }
        if (r6 == 0) goto L_0x0134
        r6.close()     // Catch:{ Exception -> 0x012f }
        goto L_0x0134
    L_0x012f:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x0134:
        return
    L_0x0135:
        r18.mo34966b()     // Catch:{ IOException -> 0x0140, all -> 0x013d }
        r10.close()     // Catch:{ Exception -> 0x017b }
        r0 = r9
        goto L_0x0167
    L_0x013d:
        r0 = move-exception
        r5 = r10
        goto L_0x0161
    L_0x0140:
        r0 = move-exception
        r5 = r10
        goto L_0x0146
    L_0x0143:
        r0 = move-exception
        goto L_0x0161
    L_0x0145:
        r0 = move-exception
    L_0x0146:
        r0.printStackTrace()     // Catch:{ all -> 0x0143 }
        r8 = 2020(0x7e4, float:2.83E-42)
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0143 }
        r1.mo34965a(r8, r0)     // Catch:{ all -> 0x0143 }
        java.lang.String r0 = "IOException,stop download!"
        java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x0143 }
        com.tencent.bugly.proguard.C7226an.m31143b(r2, r0, r8)     // Catch:{ all -> 0x0143 }
        if (r5 == 0) goto L_0x015e
        r5.close()     // Catch:{ Exception -> 0x017b }
    L_0x015e:
        r0 = r9
        goto L_0x0012
    L_0x0161:
        if (r5 == 0) goto L_0x0166
        r5.close()     // Catch:{ Exception -> 0x017b }
    L_0x0166:
        throw r0     // Catch:{ Exception -> 0x017b }
    L_0x0167:
        if (r0 < r8) goto L_0x0198
        java.lang.String r0 = "have retry %d times"
        r4 = 1
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x017b }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x017b }
        r4[r3] = r5     // Catch:{ Exception -> 0x017b }
        com.tencent.bugly.proguard.C7226an.m31143b(r2, r0, r4)     // Catch:{ Exception -> 0x017b }
        goto L_0x0198
    L_0x0178:
        r0 = move-exception
        r2 = r0
        goto L_0x018c
    L_0x017b:
        r0 = move-exception
        java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0178 }
        r1.mo34965a(r7, r2)     // Catch:{ all -> 0x0178 }
        r0.printStackTrace()     // Catch:{ all -> 0x0178 }
        if (r6 == 0) goto L_0x01a3
        r6.close()     // Catch:{ Exception -> 0x019e }
        goto L_0x01a3
    L_0x018c:
        if (r6 == 0) goto L_0x0197
        r6.close()     // Catch:{ Exception -> 0x0192 }
        goto L_0x0197
    L_0x0192:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x0197:
        throw r2
    L_0x0198:
        if (r6 == 0) goto L_0x01a3
        r6.close()     // Catch:{ Exception -> 0x019e }
        goto L_0x01a3
    L_0x019e:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x01a3:
        return
    L_0x01a4:
        r0 = move-exception
        java.lang.String r2 = r0.getMessage()
        java.lang.Object[] r3 = new java.lang.Object[r3]
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)
        r2 = 2010(0x7da, float:2.817E-42)
        java.lang.String r0 = r0.getMessage()
        r1.mo34965a(r2, r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7277t.run():void");
    }

    /* renamed from: a */
    private String m31422a(HttpURLConnection httpURLConnection) {
        try {
            if (!TextUtils.isEmpty(this.f23675c)) {
                return this.f23675c;
            }
            Map headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null) {
                for (String str : headerFields.keySet()) {
                    if (str != null) {
                        List<String> list = (List) headerFields.get(str);
                        if (list != null) {
                            for (String str2 : list) {
                                if (str2 != null) {
                                    if ("content-disposition".equals(str.toLowerCase())) {
                                        Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str2.toLowerCase());
                                        if (matcher.find()) {
                                            return matcher.group(1);
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                }
            }
            String substring = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
            if (!TextUtils.isEmpty(substring)) {
                return substring;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UUID.randomUUID());
            sb.append(".apk");
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34965a(int i, String str) {
        this.f23681i = 5;
        C7144c.f23780a.mo34443a();
        C7275s.f24609a.f24610b.remove(getDownloadUrl());
        C7159e.m30681a(new C7130d(10, this.f23676d, this, Integer.valueOf(i), str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34964a() {
        this.f24613k += System.currentTimeMillis() - this.f24615m;
        C7270p.f24600a.mo34952a((DownloadTask) this);
        this.f24615m = System.currentTimeMillis();
        C7144c.f23780a.mo34443a();
        C7159e.m30681a(new C7130d(9, this.f23676d, this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo34966b() {
        this.f23681i = 1;
        mo34964a();
        C7275s.f24609a.f24610b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        C7159e.m30681a(new C7130d(8, this.f23676d, this));
    }

    public long getCostTime() {
        return this.f24613k;
    }
}
