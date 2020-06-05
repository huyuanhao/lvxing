package com.p530ss.android.downloadlib.p541a.p544c;

import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import java.io.File;
import java.util.List;

/* renamed from: com.ss.android.downloadlib.a.c.c */
public class ClearSpaceUtil {
    /* renamed from: a */
    public static void m26209a() {
        List a = AppDownloader.m26714h().mo31476a(C6565j.m26357a());
        if (a != null && a.size() > 0) {
            for (int i = 0; i < a.size(); i++) {
                DownloadInfo cVar = (DownloadInfo) a.get(i);
                File file = new File(cVar.mo32300l(), cVar.mo32303m());
                long lastModified = file.lastModified();
                long a2 = ((long) DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("download_file_expire_hours", 0)) * 3600000;
                if (a2 <= 0) {
                    a2 = 604800000;
                }
                if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= a2) {
                    m26210a(file);
                    Downloader.m27478a(C6565j.m26357a()).mo31930j(cVar.mo32283g());
                }
            }
        }
    }

    /* renamed from: b */
    public static void m26211b() {
        List b = Downloader.m27478a(C6565j.m26357a()).mo31919b("application/vnd.android.package-archive");
        if (b != null && !b.isEmpty()) {
            for (int i = 0; i < b.size(); i++) {
                DownloadInfo cVar = (DownloadInfo) b.get(i);
                if (cVar != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cVar.mo32297k());
                    sb.append(File.separator);
                    sb.append(cVar.mo32287h());
                    String sb2 = sb.toString();
                    File file = new File(sb2);
                    if (file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                        long a = ((long) DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("download_complete_file_expire_hours", 0)) * 3600000;
                        if (a <= 0) {
                            a = 604800000;
                        }
                        boolean z = true;
                        if (currentTimeMillis < a && !C6587g.m26537d(C6565j.m26357a(), sb2)) {
                            z = false;
                        }
                        if (z) {
                            m26210a(file);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030 A[SYNTHETIC, Splitter:B:22:0x0030] */
    /* renamed from: a */
    public static void m26210a(java.io.File r3) {
        /*
        r0 = 0
        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
        r1.<init>(r3)     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
        java.lang.String r0 = "1"
        byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x0013 }
        r1.write(r0)     // Catch:{ Exception -> 0x0013 }
        r1.close()     // Catch:{ Exception -> 0x0013 }
        goto L_0x0029
    L_0x0013:
        r0 = move-exception
        goto L_0x001c
    L_0x0015:
        r3 = move-exception
        r1 = r0
        goto L_0x002e
    L_0x0018:
        r1 = move-exception
        r2 = r1
        r1 = r0
        r0 = r2
    L_0x001c:
        r0.printStackTrace()     // Catch:{ all -> 0x002d }
        if (r1 == 0) goto L_0x0029
        r1.close()     // Catch:{ Exception -> 0x0025 }
        goto L_0x0029
    L_0x0025:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0029:
        r3.delete()
        return
    L_0x002d:
        r3 = move-exception
    L_0x002e:
        if (r1 == 0) goto L_0x0038
        r1.close()     // Catch:{ Exception -> 0x0034 }
        goto L_0x0038
    L_0x0034:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0038:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p541a.p544c.ClearSpaceUtil.m26210a(java.io.File):void");
    }
}
