package com.tencent.android.tpush.cloudctr.network;

import android.content.Context;
import android.os.Bundle;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.bugly.BuglyStrategy.C7120a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: ProGuard */
public class CloudControlDownloadControl {
    /* renamed from: b */
    public static boolean f22954b = true;
    /* renamed from: a */
    public boolean f22955a;
    /* renamed from: c */
    private long f22956c = 0;
    /* renamed from: d */
    private long f22957d = 0;
    /* renamed from: e */
    private Bundle f22958e;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException */
    public class DownLoadException extends Exception {
        public DownLoadException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$a */
    public interface C6892a {
        /* renamed from: a */
        void mo33078a(int i);

        /* renamed from: a */
        void mo33079a(String str, boolean z);
    }

    /* renamed from: a */
    public static boolean m29441a(int i) {
        return 2 == i || 3 == i;
    }

    CloudControlDownloadControl(Context context, DownloadItem downloadItem, Bundle bundle, C6892a aVar, int i) {
        int i2 = 0;
        this.f22955a = false;
        String str = "CloudCtrDownload";
        C6864a.m29286a(str, "Create downloadControl");
        this.f22955a = false;
        this.f22958e = bundle;
        while (f22954b) {
            if (this.f22955a) {
                C6864a.m29303e(str, "Download is already stopped. Dont start again.");
                aVar.mo33078a(1);
                return;
            } else if (downloadItem._downloadRetryTimes == 0) {
                C6864a.m29306g(str, "try to connect too much. stop download now.");
                if (aVar != null) {
                    this.f22955a = true;
                    CloudControlDownloadService.f22959a.remove(downloadItem);
                    aVar.mo33078a(2);
                    return;
                }
                return;
            } else if (i2 >= 3) {
                C6864a.m29306g(str, "check md5 error too much. stop download now.");
                if (aVar != null) {
                    this.f22955a = true;
                    CloudControlDownloadService.f22959a.remove(downloadItem);
                    aVar.mo33078a(2);
                    return;
                }
                return;
            } else {
                int a = m29435a(context, aVar, downloadItem);
                downloadItem._downloadRetryTimes--;
                if (a == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Connect time out, try rest - ");
                    sb.append(downloadItem._downloadRetryTimes);
                    C6864a.m29298c(str, sb.toString());
                    try {
                        Thread.sleep((long) i);
                    } catch (InterruptedException unused) {
                    }
                } else if (a == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Download again, try rest - ");
                    sb2.append(downloadItem._downloadRetryTimes);
                    C6864a.m29298c(str, sb2.toString());
                    Thread.sleep((long) i);
                } else if (a == 1) {
                    C6864a.m29298c(str, "Download succeed.");
                    this.f22955a = true;
                    return;
                } else if (a == 2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("md5 check error, try again - ");
                    sb3.append(downloadItem._downloadRetryTimes);
                    C6864a.m29298c(str, sb3.toString());
                    i2++;
                } else if (a == -3) {
                    this.f22955a = true;
                    CloudControlDownloadService.f22959a.remove(downloadItem);
                    aVar.mo33078a(3);
                    return;
                } else {
                    C6864a.m29298c(str, "Other exception!!");
                    this.f22955a = true;
                    CloudControlDownloadService.f22959a.remove(downloadItem);
                    aVar.mo33078a(2);
                    return;
                }
            }
        }
        C6864a.m29303e(str, "network is not available, dont download");
        this.f22955a = true;
        aVar.mo33078a(1);
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r3v34 */
    /* JADX WARNING: type inference failed for: r3v35 */
    /* JADX WARNING: type inference failed for: r3v36 */
    /* JADX WARNING: type inference failed for: r3v37 */
    /* JADX WARNING: type inference failed for: r3v38 */
    /* JADX WARNING: type inference failed for: r9v15, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v40 */
    /* JADX WARNING: type inference failed for: r3v41 */
    /* JADX WARNING: type inference failed for: r6v60 */
    /* JADX WARNING: type inference failed for: r3v42 */
    /* JADX WARNING: type inference failed for: r3v43 */
    /* JADX WARNING: type inference failed for: r3v44 */
    /* JADX WARNING: type inference failed for: r6v62 */
    /* JADX WARNING: type inference failed for: r3v45 */
    /* JADX WARNING: type inference failed for: r3v46 */
    /* JADX WARNING: type inference failed for: r3v47 */
    /* JADX WARNING: type inference failed for: r6v64 */
    /* JADX WARNING: type inference failed for: r3v48 */
    /* JADX WARNING: type inference failed for: r3v49 */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r6v66 */
    /* JADX WARNING: type inference failed for: r3v51 */
    /* JADX WARNING: type inference failed for: r3v52 */
    /* JADX WARNING: type inference failed for: r3v53 */
    /* JADX WARNING: type inference failed for: r6v68 */
    /* JADX WARNING: type inference failed for: r3v54 */
    /* JADX WARNING: type inference failed for: r3v55 */
    /* JADX WARNING: type inference failed for: r3v56 */
    /* JADX WARNING: type inference failed for: r6v70 */
    /* JADX WARNING: type inference failed for: r3v57 */
    /* JADX WARNING: type inference failed for: r3v58 */
    /* JADX WARNING: type inference failed for: r3v59 */
    /* JADX WARNING: type inference failed for: r6v72 */
    /* JADX WARNING: type inference failed for: r3v60 */
    /* JADX WARNING: type inference failed for: r6v73 */
    /* JADX WARNING: type inference failed for: r3v61 */
    /* JADX WARNING: type inference failed for: r6v74 */
    /* JADX WARNING: type inference failed for: r3v62 */
    /* JADX WARNING: type inference failed for: r6v75 */
    /* JADX WARNING: type inference failed for: r3v63 */
    /* JADX WARNING: type inference failed for: r6v76 */
    /* JADX WARNING: type inference failed for: r3v64 */
    /* JADX WARNING: type inference failed for: r6v77 */
    /* JADX WARNING: type inference failed for: r3v65 */
    /* JADX WARNING: type inference failed for: r6v78 */
    /* JADX WARNING: type inference failed for: r3v66 */
    /* JADX WARNING: type inference failed for: r6v79 */
    /* JADX WARNING: type inference failed for: r3v67 */
    /* JADX WARNING: type inference failed for: r6v80 */
    /* JADX WARNING: type inference failed for: r3v68 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r6v81 */
    /* JADX WARNING: type inference failed for: r6v82 */
    /* JADX WARNING: type inference failed for: r3v69 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r6v83 */
    /* JADX WARNING: type inference failed for: r6v84 */
    /* JADX WARNING: type inference failed for: r3v70 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r6v85 */
    /* JADX WARNING: type inference failed for: r6v86 */
    /* JADX WARNING: type inference failed for: r3v71 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r6v87 */
    /* JADX WARNING: type inference failed for: r6v88 */
    /* JADX WARNING: type inference failed for: r3v72 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* JADX WARNING: type inference failed for: r6v89 */
    /* JADX WARNING: type inference failed for: r6v90 */
    /* JADX WARNING: type inference failed for: r3v73 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r6v91 */
    /* JADX WARNING: type inference failed for: r6v92 */
    /* JADX WARNING: type inference failed for: r3v74 */
    /* JADX WARNING: type inference failed for: r9v23 */
    /* JADX WARNING: type inference failed for: r6v93 */
    /* JADX WARNING: type inference failed for: r9v24, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r6v95 */
    /* JADX WARNING: type inference failed for: r6v96 */
    /* JADX WARNING: type inference failed for: r3v75, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v76, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r3v77, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r6v100 */
    /* JADX WARNING: type inference failed for: r6v101 */
    /* JADX WARNING: type inference failed for: r6v102 */
    /* JADX WARNING: type inference failed for: r6v103 */
    /* JADX WARNING: type inference failed for: r6v104 */
    /* JADX WARNING: type inference failed for: r6v105 */
    /* JADX WARNING: type inference failed for: r6v106 */
    /* JADX WARNING: type inference failed for: r6v108 */
    /* JADX WARNING: type inference failed for: r6v110 */
    /* JADX WARNING: type inference failed for: r9v28 */
    /* JADX WARNING: type inference failed for: r3v80 */
    /* JADX WARNING: type inference failed for: r3v81 */
    /* JADX WARNING: type inference failed for: r3v82 */
    /* JADX WARNING: type inference failed for: r3v83 */
    /* JADX WARNING: type inference failed for: r3v84 */
    /* JADX WARNING: type inference failed for: r3v85 */
    /* JADX WARNING: type inference failed for: r3v86 */
    /* JADX WARNING: type inference failed for: r3v89 */
    /* JADX WARNING: type inference failed for: r3v90 */
    /* JADX WARNING: type inference failed for: r3v91 */
    /* JADX WARNING: type inference failed for: r3v92 */
    /* JADX WARNING: type inference failed for: r3v93 */
    /* JADX WARNING: type inference failed for: r3v94 */
    /* JADX WARNING: type inference failed for: r3v95 */
    /* JADX WARNING: type inference failed for: r3v191 */
    /* JADX WARNING: type inference failed for: r3v192 */
    /* JADX WARNING: type inference failed for: r3v193 */
    /* JADX WARNING: type inference failed for: r3v194 */
    /* JADX WARNING: type inference failed for: r3v195 */
    /* JADX WARNING: type inference failed for: r3v196 */
    /* JADX WARNING: type inference failed for: r3v197 */
    /* JADX WARNING: type inference failed for: r3v198 */
    /* JADX WARNING: type inference failed for: r9v32 */
    /* JADX WARNING: type inference failed for: r3v199 */
    /* JADX WARNING: type inference failed for: r3v200 */
    /* JADX WARNING: type inference failed for: r3v201 */
    /* JADX WARNING: type inference failed for: r3v202 */
    /* JADX WARNING: type inference failed for: r3v203 */
    /* JADX WARNING: type inference failed for: r3v204 */
    /* JADX WARNING: type inference failed for: r3v205 */
    /* JADX WARNING: type inference failed for: r3v206 */
    /* JADX WARNING: type inference failed for: r3v207 */
    /* JADX WARNING: type inference failed for: r3v208 */
    /* JADX WARNING: type inference failed for: r3v209 */
    /* JADX WARNING: type inference failed for: r3v210 */
    /* JADX WARNING: type inference failed for: r3v211 */
    /* JADX WARNING: type inference failed for: r3v212 */
    /* JADX WARNING: type inference failed for: r9v33 */
    /* JADX WARNING: type inference failed for: r6v174 */
    /* JADX WARNING: type inference failed for: r6v175 */
    /* JADX WARNING: type inference failed for: r6v176 */
    /* JADX WARNING: type inference failed for: r6v177 */
    /* JADX WARNING: type inference failed for: r6v178 */
    /* JADX WARNING: type inference failed for: r6v179 */
    /* JADX WARNING: type inference failed for: r6v180 */
    /* JADX WARNING: type inference failed for: r6v181 */
    /* JADX WARNING: type inference failed for: r6v182 */
    /* JADX WARNING: type inference failed for: r6v183 */
    /* JADX WARNING: type inference failed for: r3v213 */
    /* JADX WARNING: type inference failed for: r3v214 */
    /* JADX WARNING: type inference failed for: r3v215 */
    /* JADX WARNING: type inference failed for: r3v216 */
    /* JADX WARNING: type inference failed for: r3v217 */
    /* JADX WARNING: type inference failed for: r3v218 */
    /* JADX WARNING: type inference failed for: r3v219 */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0244, code lost:
            r34 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
            r3.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x024f, code lost:
            if (r11.length() != r14) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0255, code lost:
            if (com.tencent.android.tpush.cloudctr.p583b.C6890b.m29431a(r5, r11) == false) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x025b, code lost:
            if (r9.exists() == false) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
            r9.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0264, code lost:
            if (r11.renameTo(r9) != false) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0266, code lost:
            com.tencent.android.tpush.p580b.C6864a.m29306g(r6, "rename file error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x026b, code lost:
            m29439a(r2, r8, r34, r3, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0276, code lost:
            return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0277, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
            r7.f22958e.remove(r29);
            r1 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0281, code lost:
            if (r1 == null) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0283, code lost:
            r1.mo33079a(r9.getAbsolutePath(), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x028b, code lost:
            m29439a(r2, r8, r34, r5, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0295, code lost:
            return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0296, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
            com.tencent.android.tpush.p580b.C6864a.m29306g(r6, "The download file is not valid, download again");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02a0, code lost:
            if (r11.delete() != false) goto L_0x02b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02a2, code lost:
            com.tencent.android.tpush.p580b.C6864a.m29308i(r6, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02a7, code lost:
            m29439a(r2, r8, r34, r5, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02b1, code lost:
            return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02b2, code lost:
            m29439a(r2, r8, r34, r5, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02bb, code lost:
            return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02bc, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02be, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02c0, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02c2, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02c5, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02c8, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02cb, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02ce, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02cf, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02d1, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02d2, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02d4, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02d5, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02d7, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02d8, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02da, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02db, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02dd, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02de, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x02e0, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x02e1, code lost:
            r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0486, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0487, code lost:
            r1 = r0;
            r3 = null;
            r4 = null;
            r5 = null;
            r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0494, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x0495, code lost:
            r1 = r0;
            r3 = null;
            r4 = null;
            r5 = null;
            r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x04a2, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x04a3, code lost:
            r1 = r0;
            r3 = null;
            r4 = null;
            r5 = null;
            r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x04c1, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x04c2, code lost:
            r8 = r0;
            r3 = null;
            r4 = null;
            r5 = null;
            r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x04ce, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x04cf, code lost:
            r1 = r0;
            r3 = null;
            r4 = null;
            r5 = null;
            r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x04eb, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x04ec, code lost:
            r1 = r0;
            r3 = null;
            r4 = null;
            r5 = null;
            r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x054b, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x054c, code lost:
            r1 = r0;
            r3 = null;
            r4 = null;
            r5 = null;
            r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:477:0x0719, code lost:
            r6 = r9;
            r16 = r10;
            r13.flush();
            com.tencent.android.tpush.p580b.C6864a.m29298c(r8, "Download finished");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:478:0x072a, code lost:
            if (r14.length() != r11) goto L_0x074e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:0x0730, code lost:
            if (com.tencent.android.tpush.cloudctr.p583b.C6890b.m29431a(r5, r14) == false) goto L_0x074e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x0732, code lost:
            r7.f22958e.remove(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x0737, code lost:
            if (r1 == null) goto L_0x0741;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:483:0x0739, code lost:
            r1.mo33079a(r14.getAbsolutePath(), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0741, code lost:
            m29439a(r2, r6, r16, r13, r34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:485:0x074d, code lost:
            return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:487:0x0750, code lost:
            r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:488:?, code lost:
            com.tencent.android.tpush.p580b.C6864a.m29306g(r8, "The download file is not valid, download again");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:489:0x0757, code lost:
            if (r14.delete() != false) goto L_0x076b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0135, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:490:0x0759, code lost:
            com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:491:0x075e, code lost:
            m29439a(r2, r6, r16, r13, r34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:492:0x076a, code lost:
            return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:493:0x076b, code lost:
            m29439a(r2, r6, r16, r13, r34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x0776, code lost:
            return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0136, code lost:
            r6 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0140, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0141, code lost:
            r6 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0148, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0149, code lost:
            r6 = r23;
            r1 = -2;
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:704:0x0a37, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:705:0x0a38, code lost:
            r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:707:0x0a44, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:708:0x0a45, code lost:
            r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:715:0x0a5b, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:716:0x0a5c, code lost:
            r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:723:0x0a72, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:724:0x0a73, code lost:
            r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:733:0x0a8c, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:734:0x0a8d, code lost:
            r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:741:0x0aa3, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:742:0x0aa4, code lost:
            r9 = r25;
            r2 = null;
            r1 = r0;
            r3 = 0;
            r4 = null;
            r5 = null;
            r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:747:0x0aba, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:748:0x0abb, code lost:
            r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v12
  assigns: []
  uses: []
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
    /* JADX WARNING: Removed duplicated region for block: B:319:0x04c1 A[ExcHandler: all (r0v150 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:63:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x04ce A[ExcHandler: DownLoadException (r0v149 'e' com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException A[CUSTOM_DECLARE]), Splitter:B:63:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x04eb A[ExcHandler: IOException (r0v147 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:63:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x054b A[ExcHandler: NumberFormatException (r0v143 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:63:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0135 A[ExcHandler: DownLoadException (e com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException), Splitter:B:15:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0140 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:15:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:704:0x0a37 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:382:0x05c4] */
    /* JADX WARNING: Removed duplicated region for block: B:707:0x0a44 A[ExcHandler: DownLoadException (e com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException), Splitter:B:382:0x05c4] */
    /* JADX WARNING: Removed duplicated region for block: B:715:0x0a5b A[ExcHandler: IOException (e java.io.IOException), Splitter:B:382:0x05c4] */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0a72 A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), Splitter:B:382:0x05c4] */
    /* JADX WARNING: Removed duplicated region for block: B:733:0x0a8c A[ExcHandler: IllegalStateException (e java.lang.IllegalStateException), Splitter:B:382:0x05c4] */
    /* JADX WARNING: Removed duplicated region for block: B:747:0x0aba A[ExcHandler: NumberFormatException (e java.lang.NumberFormatException), Splitter:B:382:0x05c4] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:343:0x0510=Splitter:B:343:0x0510, B:357:0x0540=Splitter:B:357:0x0540, B:350:0x0528=Splitter:B:350:0x0528} */
    /* JADX WARNING: Unknown variable types count: 79 */
    /* renamed from: a */
    private int m29435a(android.content.Context r32, com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl.C6892a r33, com.tencent.android.tpush.cloudctr.network.DownloadItem r34) {
        /*
        r31 = this;
        r7 = r31
        r1 = r33
        r2 = r34
        java.lang.String r3 = ""
        java.lang.String r4 = r34.getDownloadUrl()
        java.lang.String r5 = r34.getMd5()
        java.lang.String r6 = r34.getDownloadSavedDir()
        java.lang.String r8 = r34.getFileName()
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        r9.append(r8)
        java.lang.String r10 = ".downloading"
        r9.append(r10)
        java.lang.String r9 = r9.toString()
        boolean r10 = android.text.TextUtils.isEmpty(r4)
        java.lang.String r12 = "CloudCtrDownload"
        if (r10 != 0) goto L_0x0ae0
        boolean r10 = android.text.TextUtils.isEmpty(r6)
        if (r10 != 0) goto L_0x0ae0
        boolean r10 = android.text.TextUtils.isEmpty(r8)
        if (r10 != 0) goto L_0x0ae0
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        java.lang.String r13 = "action:download - url:"
        r10.append(r13)
        r10.append(r4)
        java.lang.String r13 = ", saveFilePath:"
        r10.append(r13)
        r10.append(r6)
        java.lang.String r13 = ", fileName:"
        r10.append(r13)
        r10.append(r8)
        java.lang.String r10 = r10.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r12, r10)
        r7.m29440a(r6)
        android.os.Bundle r10 = r7.f22958e
        r13 = -1
        r15 = r12
        long r11 = r10.getLong(r4, r13)
        r16 = 0
        r17 = 0
        r18 = 0
        r19 = 0
        java.lang.String r10 = "IOException"
        java.lang.String r14 = "NULL response"
        java.lang.String r13 = "NumberFormatException, get content length from http fail."
        r22 = 2
        r23 = r15
        java.lang.String r15 = "ClientProtocolException"
        r24 = r13
        java.lang.String r13 = "delete file fail !!!"
        r25 = r14
        r26 = 0
        r14 = -1
        r28 = r3
        int r29 = (r11 > r26 ? 1 : (r11 == r26 ? 0 : -1))
        if (r29 > 0) goto L_0x0569
        java.io.File r11 = new java.io.File
        r11.<init>(r6, r9)
        java.io.File r9 = new java.io.File
        r9.<init>(r6, r8)
        boolean r6 = r11.exists()
        if (r6 == 0) goto L_0x015a
        long r29 = r11.length()
        int r6 = (r29 > r26 ? 1 : (r29 == r26 ? 0 : -1))
        if (r6 > 0) goto L_0x00aa
        goto L_0x015a
    L_0x00aa:
        long r2 = r11.length()
        int r6 = (r2 > r26 ? 1 : (r2 == r26 ? 0 : -1))
        if (r6 <= 0) goto L_0x0151
        r2 = -1
        org.apache.http.client.methods.HttpGet r2 = r7.m29437a(r4, r2)
        org.apache.http.impl.client.DefaultHttpClient r3 = r31.m29438a()
        org.apache.http.HttpResponse r2 = r3.execute(r2)     // Catch:{ ClientProtocolException -> 0x0148, IOException -> 0x0140, DownLoadException -> 0x0135 }
        long r2 = r7.m29436a(r2)     // Catch:{ ClientProtocolException -> 0x012f, IOException -> 0x0140, DownLoadException -> 0x0135 }
        long r16 = r11.length()     // Catch:{ ClientProtocolException -> 0x012f, IOException -> 0x0140, DownLoadException -> 0x0135 }
        int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
        if (r4 != 0) goto L_0x00fb
        boolean r4 = com.tencent.android.tpush.cloudctr.p583b.C6890b.m29431a(r5, r11)     // Catch:{ ClientProtocolException -> 0x012f, IOException -> 0x0140, DownLoadException -> 0x0135 }
        if (r4 == 0) goto L_0x00fb
        java.lang.String r2 = "Existed file size is same with target. Use it directly."
        r6 = r23
        com.tencent.android.tpush.p580b.C6864a.m29298c(r6, r2)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        boolean r2 = r9.exists()     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        if (r2 == 0) goto L_0x00e2
        r9.delete()     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
    L_0x00e2:
        boolean r2 = r11.renameTo(r9)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        if (r2 != 0) goto L_0x00ef
        java.lang.String r1 = "rename file error"
        com.tencent.android.tpush.p580b.C6864a.m29306g(r6, r1)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        r1 = -2
        return r1
    L_0x00ef:
        if (r1 == 0) goto L_0x00f9
        java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        r3 = 1
        r1.mo33079a(r2, r3)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
    L_0x00f9:
        r1 = 1
        return r1
    L_0x00fb:
        r6 = r23
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        r1.<init>()     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        java.lang.String r4 = "Exsit file length:"
        r1.append(r4)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        long r4 = r11.length()     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        r1.append(r4)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        java.lang.String r4 = ", fileTotalLength:"
        r1.append(r4)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        r1.append(r2)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        java.lang.String r1 = r1.toString()     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        com.tencent.android.tpush.p580b.C6864a.m29303e(r6, r1)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        boolean r1 = r11.delete()     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        if (r1 != 0) goto L_0x0128
        com.tencent.android.tpush.p580b.C6864a.m29308i(r6, r13)     // Catch:{ ClientProtocolException -> 0x012d, IOException -> 0x012b, DownLoadException -> 0x0129 }
        r1 = -2
        return r1
    L_0x0128:
        return r22
    L_0x0129:
        r0 = move-exception
        goto L_0x0138
    L_0x012b:
        r0 = move-exception
        goto L_0x0143
    L_0x012d:
        r0 = move-exception
        goto L_0x0132
    L_0x012f:
        r0 = move-exception
        r6 = r23
    L_0x0132:
        r2 = r0
        r1 = -2
        goto L_0x014d
    L_0x0135:
        r0 = move-exception
        r6 = r23
    L_0x0138:
        r1 = r0
        java.lang.String r2 = "Downloadexception"
        com.tencent.android.tpush.p580b.C6864a.m29299c(r6, r2, r1)
        r1 = -2
        return r1
    L_0x0140:
        r0 = move-exception
        r6 = r23
    L_0x0143:
        r1 = r0
        com.tencent.android.tpush.p580b.C6864a.m29294b(r6, r10, r1)
        return r14
    L_0x0148:
        r0 = move-exception
        r6 = r23
        r1 = -2
        r2 = r0
    L_0x014d:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r6, r15, r2)
        return r1
    L_0x0151:
        r6 = r23
        r1 = -2
        java.lang.String r2 = "unexpected !!"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r6, r2)
        return r1
    L_0x015a:
        r6 = r23
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        java.lang.String r12 = "Download file: "
        r10.append(r12)
        r10.append(r8)
        java.lang.String r8 = r10.toString()
        com.tencent.android.tpush.p580b.C6864a.m29286a(r6, r8)
        r14 = -1
        org.apache.http.client.methods.HttpGet r8 = r7.m29437a(r4, r14)
        org.apache.http.impl.client.DefaultHttpClient r10 = r31.m29438a()
        org.apache.http.HttpResponse r8 = r10.execute(r8)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x0533, IllegalStateException -> 0x051b, FileNotFoundException -> 0x0503, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        if (r8 == 0) goto L_0x04b0
        org.apache.http.StatusLine r10 = r8.getStatusLine()     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        int r10 = r10.getStatusCode()     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r12 = 200(0xc8, float:2.8E-43)
        if (r10 != r12) goto L_0x0441
        org.apache.http.HttpEntity r10 = r8.getEntity()     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        boolean r12 = r10.isStreaming()     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        if (r12 == 0) goto L_0x03e9
        long r14 = r7.m29436a(r8)     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        android.os.Bundle r8 = r7.f22958e     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        r8.putLong(r4, r14)     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        int r8 = r7.m29434a(r14)     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        r2._downloadRetryTimes = r8     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        java.io.InputStream r2 = r10.getContent()     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        if (r2 == 0) goto L_0x03d6
        java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ NumberFormatException -> 0x03cc, ClientProtocolException -> 0x03c0, IllegalStateException -> 0x03b4, FileNotFoundException -> 0x03a8, IOException -> 0x039e, DownLoadException -> 0x0394, all -> 0x0389 }
        r8.<init>(r2)     // Catch:{ NumberFormatException -> 0x03cc, ClientProtocolException -> 0x03c0, IllegalStateException -> 0x03b4, FileNotFoundException -> 0x03a8, IOException -> 0x039e, DownLoadException -> 0x0394, all -> 0x0389 }
        r11.delete()     // Catch:{ NumberFormatException -> 0x0385, ClientProtocolException -> 0x0381, IllegalStateException -> 0x037d, FileNotFoundException -> 0x0379, IOException -> 0x0375, DownLoadException -> 0x0371, all -> 0x0367 }
        r11.createNewFile()     // Catch:{ NumberFormatException -> 0x0385, ClientProtocolException -> 0x0381, IllegalStateException -> 0x037d, FileNotFoundException -> 0x0379, IOException -> 0x0375, DownLoadException -> 0x0371, all -> 0x0367 }
        java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ NumberFormatException -> 0x0385, ClientProtocolException -> 0x0381, IllegalStateException -> 0x037d, FileNotFoundException -> 0x0379, IOException -> 0x0375, DownLoadException -> 0x0371, all -> 0x0367 }
        r12.<init>(r11)     // Catch:{ NumberFormatException -> 0x0385, ClientProtocolException -> 0x0381, IllegalStateException -> 0x037d, FileNotFoundException -> 0x0379, IOException -> 0x0375, DownLoadException -> 0x0371, all -> 0x0367 }
        java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ NumberFormatException -> 0x035e, ClientProtocolException -> 0x0355, IllegalStateException -> 0x034c, FileNotFoundException -> 0x0343, IOException -> 0x033a, DownLoadException -> 0x0331, all -> 0x0329 }
        r3.<init>(r12)     // Catch:{ NumberFormatException -> 0x035e, ClientProtocolException -> 0x0355, IllegalStateException -> 0x034c, FileNotFoundException -> 0x0343, IOException -> 0x033a, DownLoadException -> 0x0331, all -> 0x0329 }
        r20 = r13
        r13 = 1024(0x400, float:1.435E-42)
        byte[] r13 = new byte[r13]     // Catch:{ NumberFormatException -> 0x031f, ClientProtocolException -> 0x0315, IllegalStateException -> 0x030b, FileNotFoundException -> 0x0301, IOException -> 0x02f7, DownLoadException -> 0x02ed, all -> 0x02e3 }
    L_0x01c6:
        int r1 = r8.read(r13)     // Catch:{ NumberFormatException -> 0x031f, ClientProtocolException -> 0x0315, IllegalStateException -> 0x030b, FileNotFoundException -> 0x0301, IOException -> 0x02f7, DownLoadException -> 0x02ed, all -> 0x02e3 }
        r29 = r4
        r4 = -1
        if (r1 == r4) goto L_0x0244
        boolean r4 = r7.f22955a     // Catch:{ NumberFormatException -> 0x023b, ClientProtocolException -> 0x0232, IllegalStateException -> 0x0229, FileNotFoundException -> 0x0220, IOException -> 0x0217, DownLoadException -> 0x020e, all -> 0x0206 }
        if (r4 != 0) goto L_0x01f7
        r4 = 0
        r3.write(r13, r4, r1)     // Catch:{ NumberFormatException -> 0x023b, ClientProtocolException -> 0x0232, IllegalStateException -> 0x0229, FileNotFoundException -> 0x0220, IOException -> 0x0217, DownLoadException -> 0x020e, all -> 0x0206 }
        r34 = r12
        r4 = r13
        long r12 = (long) r1
        long r12 = r26 + r12
        r7.f22956c = r12     // Catch:{ NumberFormatException -> 0x01f5, ClientProtocolException -> 0x01f3, IllegalStateException -> 0x01f1, FileNotFoundException -> 0x01ef, IOException -> 0x01ed, DownLoadException -> 0x01eb, all -> 0x01e9 }
        r7.f22957d = r14     // Catch:{ NumberFormatException -> 0x01f5, ClientProtocolException -> 0x01f3, IllegalStateException -> 0x01f1, FileNotFoundException -> 0x01ef, IOException -> 0x01ed, DownLoadException -> 0x01eb, all -> 0x01e9 }
        r26 = r12
        r12 = r34
        r13 = r4
        r4 = r29
        goto L_0x01c6
    L_0x01e9:
        r0 = move-exception
        goto L_0x0209
    L_0x01eb:
        r0 = move-exception
        goto L_0x0211
    L_0x01ed:
        r0 = move-exception
        goto L_0x021a
    L_0x01ef:
        r0 = move-exception
        goto L_0x0223
    L_0x01f1:
        r0 = move-exception
        goto L_0x022c
    L_0x01f3:
        r0 = move-exception
        goto L_0x0235
    L_0x01f5:
        r0 = move-exception
        goto L_0x023e
    L_0x01f7:
        r34 = r12
        java.lang.String r1 = "stop download by user, throw Exception."
        com.tencent.android.tpush.p580b.C6864a.m29306g(r6, r1)     // Catch:{ NumberFormatException -> 0x01f5, ClientProtocolException -> 0x01f3, IllegalStateException -> 0x01f1, FileNotFoundException -> 0x01ef, IOException -> 0x01ed, DownLoadException -> 0x01eb, all -> 0x01e9 }
        com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException r1 = new com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException     // Catch:{ NumberFormatException -> 0x01f5, ClientProtocolException -> 0x01f3, IllegalStateException -> 0x01f1, FileNotFoundException -> 0x01ef, IOException -> 0x01ed, DownLoadException -> 0x01eb, all -> 0x01e9 }
        java.lang.String r4 = "stop download by user."
        r1.m51901init(r4)     // Catch:{ NumberFormatException -> 0x01f5, ClientProtocolException -> 0x01f3, IllegalStateException -> 0x01f1, FileNotFoundException -> 0x01ef, IOException -> 0x01ed, DownLoadException -> 0x01eb, all -> 0x01e9 }
        throw r1     // Catch:{ NumberFormatException -> 0x01f5, ClientProtocolException -> 0x01f3, IllegalStateException -> 0x01f1, FileNotFoundException -> 0x01ef, IOException -> 0x01ed, DownLoadException -> 0x01eb, all -> 0x01e9 }
    L_0x0206:
        r0 = move-exception
        r34 = r12
    L_0x0209:
        r4 = r34
        r5 = r3
        goto L_0x02e9
    L_0x020e:
        r0 = move-exception
        r34 = r12
    L_0x0211:
        r4 = r34
        r1 = r0
        r5 = r3
        goto L_0x02f4
    L_0x0217:
        r0 = move-exception
        r34 = r12
    L_0x021a:
        r4 = r34
        r1 = r0
        r5 = r3
        goto L_0x02fe
    L_0x0220:
        r0 = move-exception
        r34 = r12
    L_0x0223:
        r4 = r34
        r1 = r0
        r5 = r3
        goto L_0x0308
    L_0x0229:
        r0 = move-exception
        r34 = r12
    L_0x022c:
        r4 = r34
        r1 = r0
        r5 = r3
        goto L_0x0312
    L_0x0232:
        r0 = move-exception
        r34 = r12
    L_0x0235:
        r4 = r34
        r1 = r0
        r5 = r3
        goto L_0x031c
    L_0x023b:
        r0 = move-exception
        r34 = r12
    L_0x023e:
        r4 = r34
        r1 = r0
        r5 = r3
        goto L_0x0326
    L_0x0244:
        r34 = r12
        r3.flush()     // Catch:{ NumberFormatException -> 0x02e0, ClientProtocolException -> 0x02dd, IllegalStateException -> 0x02da, FileNotFoundException -> 0x02d7, IOException -> 0x02d4, DownLoadException -> 0x02d1, all -> 0x02ce }
        long r12 = r11.length()     // Catch:{ NumberFormatException -> 0x02e0, ClientProtocolException -> 0x02dd, IllegalStateException -> 0x02da, FileNotFoundException -> 0x02d7, IOException -> 0x02d4, DownLoadException -> 0x02d1, all -> 0x02ce }
        int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
        if (r1 != 0) goto L_0x0296
        boolean r1 = com.tencent.android.tpush.cloudctr.p583b.C6890b.m29431a(r5, r11)     // Catch:{ NumberFormatException -> 0x02e0, ClientProtocolException -> 0x02dd, IllegalStateException -> 0x02da, FileNotFoundException -> 0x02d7, IOException -> 0x02d4, DownLoadException -> 0x02d1, all -> 0x02ce }
        if (r1 == 0) goto L_0x0296
        boolean r1 = r9.exists()     // Catch:{ NumberFormatException -> 0x02e0, ClientProtocolException -> 0x02dd, IllegalStateException -> 0x02da, FileNotFoundException -> 0x02d7, IOException -> 0x02d4, DownLoadException -> 0x02d1, all -> 0x02ce }
        if (r1 == 0) goto L_0x0260
        r9.delete()     // Catch:{ NumberFormatException -> 0x01f5, ClientProtocolException -> 0x01f3, IllegalStateException -> 0x01f1, FileNotFoundException -> 0x01ef, IOException -> 0x01ed, DownLoadException -> 0x01eb, all -> 0x01e9 }
    L_0x0260:
        boolean r1 = r11.renameTo(r9)     // Catch:{ NumberFormatException -> 0x02e0, ClientProtocolException -> 0x02dd, IllegalStateException -> 0x02da, FileNotFoundException -> 0x02d7, IOException -> 0x02d4, DownLoadException -> 0x02d1, all -> 0x02ce }
        if (r1 != 0) goto L_0x0277
        java.lang.String r1 = "rename file error"
        com.tencent.android.tpush.p580b.C6864a.m29306g(r6, r1)     // Catch:{ NumberFormatException -> 0x02e0, ClientProtocolException -> 0x02dd, IllegalStateException -> 0x02da, FileNotFoundException -> 0x02d7, IOException -> 0x02d4, DownLoadException -> 0x02d1, all -> 0x02ce }
        r1 = r31
        r5 = r3
        r3 = r8
        r4 = r34
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0277:
        r5 = r3
        android.os.Bundle r1 = r7.f22958e     // Catch:{ NumberFormatException -> 0x02cb, ClientProtocolException -> 0x02c8, IllegalStateException -> 0x02c5, FileNotFoundException -> 0x02c2, IOException -> 0x02c0, DownLoadException -> 0x02be, all -> 0x02bc }
        r3 = r29
        r1.remove(r3)     // Catch:{ NumberFormatException -> 0x02cb, ClientProtocolException -> 0x02c8, IllegalStateException -> 0x02c5, FileNotFoundException -> 0x02c2, IOException -> 0x02c0, DownLoadException -> 0x02be, all -> 0x02bc }
        r1 = r33
        if (r1 == 0) goto L_0x028b
        java.lang.String r3 = r9.getAbsolutePath()     // Catch:{ NumberFormatException -> 0x02cb, ClientProtocolException -> 0x02c8, IllegalStateException -> 0x02c5, FileNotFoundException -> 0x02c2, IOException -> 0x02c0, DownLoadException -> 0x02be, all -> 0x02bc }
        r4 = 0
        r1.mo33079a(r3, r4)     // Catch:{ NumberFormatException -> 0x02cb, ClientProtocolException -> 0x02c8, IllegalStateException -> 0x02c5, FileNotFoundException -> 0x02c2, IOException -> 0x02c0, DownLoadException -> 0x02be, all -> 0x02bc }
    L_0x028b:
        r1 = r31
        r3 = r8
        r4 = r34
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = 1
        return r1
    L_0x0296:
        r5 = r3
        java.lang.String r1 = "The download file is not valid, download again"
        com.tencent.android.tpush.p580b.C6864a.m29306g(r6, r1)     // Catch:{ NumberFormatException -> 0x02cb, ClientProtocolException -> 0x02c8, IllegalStateException -> 0x02c5, FileNotFoundException -> 0x02c2, IOException -> 0x02c0, DownLoadException -> 0x02be, all -> 0x02bc }
        boolean r1 = r11.delete()     // Catch:{ NumberFormatException -> 0x02cb, ClientProtocolException -> 0x02c8, IllegalStateException -> 0x02c5, FileNotFoundException -> 0x02c2, IOException -> 0x02c0, DownLoadException -> 0x02be, all -> 0x02bc }
        if (r1 != 0) goto L_0x02b2
        r4 = r20
        com.tencent.android.tpush.p580b.C6864a.m29308i(r6, r4)     // Catch:{ NumberFormatException -> 0x02cb, ClientProtocolException -> 0x02c8, IllegalStateException -> 0x02c5, FileNotFoundException -> 0x02c2, IOException -> 0x02c0, DownLoadException -> 0x02be, all -> 0x02bc }
        r1 = r31
        r3 = r8
        r4 = r34
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x02b2:
        r1 = r31
        r3 = r8
        r4 = r34
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        return r22
    L_0x02bc:
        r0 = move-exception
        goto L_0x02e7
    L_0x02be:
        r0 = move-exception
        goto L_0x02f1
    L_0x02c0:
        r0 = move-exception
        goto L_0x02fb
    L_0x02c2:
        r0 = move-exception
        goto L_0x0305
    L_0x02c5:
        r0 = move-exception
        goto L_0x030f
    L_0x02c8:
        r0 = move-exception
        goto L_0x0319
    L_0x02cb:
        r0 = move-exception
        goto L_0x0323
    L_0x02ce:
        r0 = move-exception
        r5 = r3
        goto L_0x02e7
    L_0x02d1:
        r0 = move-exception
        r5 = r3
        goto L_0x02f1
    L_0x02d4:
        r0 = move-exception
        r5 = r3
        goto L_0x02fb
    L_0x02d7:
        r0 = move-exception
        r5 = r3
        goto L_0x0305
    L_0x02da:
        r0 = move-exception
        r5 = r3
        goto L_0x030f
    L_0x02dd:
        r0 = move-exception
        r5 = r3
        goto L_0x0319
    L_0x02e0:
        r0 = move-exception
        r5 = r3
        goto L_0x0323
    L_0x02e3:
        r0 = move-exception
        r5 = r3
        r34 = r12
    L_0x02e7:
        r4 = r34
    L_0x02e9:
        r3 = r8
        r6 = r10
        goto L_0x036e
    L_0x02ed:
        r0 = move-exception
        r5 = r3
        r34 = r12
    L_0x02f1:
        r4 = r34
        r1 = r0
    L_0x02f4:
        r3 = r8
        goto L_0x04d9
    L_0x02f7:
        r0 = move-exception
        r5 = r3
        r34 = r12
    L_0x02fb:
        r4 = r34
        r1 = r0
    L_0x02fe:
        r3 = r8
        goto L_0x04f6
    L_0x0301:
        r0 = move-exception
        r5 = r3
        r34 = r12
    L_0x0305:
        r4 = r34
        r1 = r0
    L_0x0308:
        r3 = r8
        goto L_0x03b0
    L_0x030b:
        r0 = move-exception
        r5 = r3
        r34 = r12
    L_0x030f:
        r4 = r34
        r1 = r0
    L_0x0312:
        r3 = r8
        goto L_0x03bc
    L_0x0315:
        r0 = move-exception
        r5 = r3
        r34 = r12
    L_0x0319:
        r4 = r34
        r1 = r0
    L_0x031c:
        r3 = r8
        goto L_0x03c8
    L_0x031f:
        r0 = move-exception
        r5 = r3
        r34 = r12
    L_0x0323:
        r4 = r34
        r1 = r0
    L_0x0326:
        r3 = r8
        goto L_0x0556
    L_0x0329:
        r0 = move-exception
        r34 = r12
        r4 = r34
        r3 = r8
        r6 = r10
        goto L_0x036c
    L_0x0331:
        r0 = move-exception
        r34 = r12
        r4 = r34
        r1 = r0
        r3 = r8
        goto L_0x039a
    L_0x033a:
        r0 = move-exception
        r34 = r12
        r4 = r34
        r1 = r0
        r3 = r8
        goto L_0x03a4
    L_0x0343:
        r0 = move-exception
        r34 = r12
        r4 = r34
        r1 = r0
        r3 = r8
        goto L_0x03ae
    L_0x034c:
        r0 = move-exception
        r34 = r12
        r4 = r34
        r1 = r0
        r3 = r8
        goto L_0x03ba
    L_0x0355:
        r0 = move-exception
        r34 = r12
        r4 = r34
        r1 = r0
        r3 = r8
        goto L_0x03c6
    L_0x035e:
        r0 = move-exception
        r34 = r12
        r4 = r34
        r1 = r0
        r3 = r8
        goto L_0x03d2
    L_0x0367:
        r0 = move-exception
        r3 = r8
        r6 = r10
        r4 = r17
    L_0x036c:
        r5 = r18
    L_0x036e:
        r8 = r0
        goto L_0x0563
    L_0x0371:
        r0 = move-exception
        r1 = r0
        r3 = r8
        goto L_0x0398
    L_0x0375:
        r0 = move-exception
        r1 = r0
        r3 = r8
        goto L_0x03a2
    L_0x0379:
        r0 = move-exception
        r1 = r0
        r3 = r8
        goto L_0x03ac
    L_0x037d:
        r0 = move-exception
        r1 = r0
        r3 = r8
        goto L_0x03b8
    L_0x0381:
        r0 = move-exception
        r1 = r0
        r3 = r8
        goto L_0x03c4
    L_0x0385:
        r0 = move-exception
        r1 = r0
        r3 = r8
        goto L_0x03d0
    L_0x0389:
        r0 = move-exception
        r8 = r0
        r6 = r10
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0563
    L_0x0394:
        r0 = move-exception
        r1 = r0
        r3 = r16
    L_0x0398:
        r4 = r17
    L_0x039a:
        r5 = r18
        goto L_0x04d9
    L_0x039e:
        r0 = move-exception
        r1 = r0
        r3 = r16
    L_0x03a2:
        r4 = r17
    L_0x03a4:
        r5 = r18
        goto L_0x04f6
    L_0x03a8:
        r0 = move-exception
        r1 = r0
        r3 = r16
    L_0x03ac:
        r4 = r17
    L_0x03ae:
        r5 = r18
    L_0x03b0:
        r8 = r28
        goto L_0x0510
    L_0x03b4:
        r0 = move-exception
        r1 = r0
        r3 = r16
    L_0x03b8:
        r4 = r17
    L_0x03ba:
        r5 = r18
    L_0x03bc:
        r8 = r28
        goto L_0x0528
    L_0x03c0:
        r0 = move-exception
        r1 = r0
        r3 = r16
    L_0x03c4:
        r4 = r17
    L_0x03c6:
        r5 = r18
    L_0x03c8:
        r8 = r28
        goto L_0x0540
    L_0x03cc:
        r0 = move-exception
        r1 = r0
        r3 = r16
    L_0x03d0:
        r4 = r17
    L_0x03d2:
        r5 = r18
        goto L_0x0556
    L_0x03d6:
        r4 = 0
        java.lang.String r1 = "NULL response stream."
        com.tencent.android.tpush.p580b.C6864a.m29306g(r6, r1)     // Catch:{ NumberFormatException -> 0x03cc, ClientProtocolException -> 0x03c0, IllegalStateException -> 0x03b4, FileNotFoundException -> 0x03a8, IOException -> 0x039e, DownLoadException -> 0x0394, all -> 0x0389 }
        r3 = 0
        r5 = 0
        r6 = 0
        r1 = r31
        r8 = 0
        r4 = r5
        r5 = r6
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        return r8
    L_0x03e9:
        java.lang.String r1 = "data mode from server is not stream."
        com.tencent.android.tpush.p580b.C6864a.m29308i(r6, r1)     // Catch:{ NumberFormatException -> 0x0437, ClientProtocolException -> 0x042d, IllegalStateException -> 0x0423, FileNotFoundException -> 0x0419, IOException -> 0x040f, DownLoadException -> 0x0405, all -> 0x03fa }
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r1 = r31
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x03fa:
        r0 = move-exception
        r8 = r0
        r6 = r10
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x04cb
    L_0x0405:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x04d8
    L_0x040f:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x04f5
    L_0x0419:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0490
    L_0x0423:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x049e
    L_0x042d:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x04ac
    L_0x0437:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0555
    L_0x0441:
        r3 = r4
        r1 = 404(0x194, float:5.66E-43)
        if (r10 != r1) goto L_0x0466
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r1.<init>()     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        java.lang.String r2 = "The resource does not exist - "
        r1.append(r2)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r1.append(r3)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        com.tencent.android.tpush.p580b.C6864a.m29298c(r6, r1)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r8 = -3
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r6 = 0
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        return r8
    L_0x0466:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r1.<init>()     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        java.lang.String r2 = "network connect status code unexpected - "
        r1.append(r2)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r1.append(r10)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        com.tencent.android.tpush.p580b.C6864a.m29306g(r6, r1)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r6 = 0
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0486:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x0490:
        r8 = r28
        goto L_0x050f
    L_0x0494:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x049e:
        r8 = r28
        goto L_0x0527
    L_0x04a2:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x04ac:
        r8 = r28
        goto L_0x053f
    L_0x04b0:
        r8 = 0
        r13 = r25
        com.tencent.android.tpush.p580b.C6864a.m29306g(r6, r13)     // Catch:{ NumberFormatException -> 0x054b, ClientProtocolException -> 0x04a2, IllegalStateException -> 0x0494, FileNotFoundException -> 0x0486, IOException -> 0x04eb, DownLoadException -> 0x04ce, all -> 0x04c1 }
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r6 = 0
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        return r8
    L_0x04c1:
        r0 = move-exception
        r8 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x04cb:
        r2 = 0
        goto L_0x0563
    L_0x04ce:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x04d8:
        r2 = 0
    L_0x04d9:
        java.lang.String r8 = "Download exception"
        com.tencent.android.tpush.p580b.C6864a.m29299c(r6, r8, r1)     // Catch:{ all -> 0x04e6 }
        r1 = r31
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x04e6:
        r0 = move-exception
        r8 = r0
        r6 = r10
        goto L_0x0563
    L_0x04eb:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x04f5:
        r2 = 0
    L_0x04f6:
        r8 = r28
        com.tencent.android.tpush.p580b.C6864a.m29294b(r6, r8, r1)     // Catch:{ all -> 0x04e6 }
        r1 = r31
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -1
        return r1
    L_0x0503:
        r0 = move-exception
        r8 = r28
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x050f:
        r2 = 0
    L_0x0510:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r6, r8, r1)     // Catch:{ all -> 0x04e6 }
        r1 = r31
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x051b:
        r0 = move-exception
        r8 = r28
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x0527:
        r2 = 0
    L_0x0528:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r6, r8, r1)     // Catch:{ all -> 0x04e6 }
        r1 = r31
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0533:
        r0 = move-exception
        r8 = r28
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x053f:
        r2 = 0
    L_0x0540:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r6, r8, r1)     // Catch:{ all -> 0x04e6 }
        r1 = r31
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x054b:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r10 = r19
    L_0x0555:
        r2 = 0
    L_0x0556:
        r14 = r24
        com.tencent.android.tpush.p580b.C6864a.m29302d(r6, r14, r1)     // Catch:{ all -> 0x04e6 }
        r1 = r31
        r6 = r10
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0563:
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        throw r8
    L_0x0569:
        r3 = r4
        r4 = r13
        r8 = r23
        r13 = r25
        java.lang.String r14 = "Had record, keep download."
        com.tencent.android.tpush.p580b.C6864a.m29303e(r8, r14)
        java.io.File r14 = new java.io.File
        r14.<init>(r6, r9)
        boolean r6 = r14.exists()
        if (r6 == 0) goto L_0x058d
        java.lang.String r6 = "File exsit, getting the file length."
        com.tencent.android.tpush.p580b.C6864a.m29286a(r8, r6)
        long r26 = r14.length()
    L_0x0588:
        r20 = r10
        r9 = r26
        goto L_0x0596
    L_0x058d:
        java.lang.String r6 = "File had been delete, start from 0."
        com.tencent.android.tpush.p580b.C6864a.m29286a(r8, r6)
        r14.createNewFile()     // Catch:{ IOException -> 0x0ad7 }
        goto L_0x0588
    L_0x0596:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        r25 = r15
        java.lang.String r15 = "startPostion: "
        r6.append(r15)
        r6.append(r9)
        java.lang.String r6 = r6.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r8, r6)
        int r6 = r2._downloadRetryTimes
        r15 = -1
        if (r6 != r15) goto L_0x05bc
        java.lang.String r6 = "Reset download retry times because it ever failed."
        com.tencent.android.tpush.p580b.C6864a.m29298c(r8, r6)
        int r6 = r7.m29434a(r11)
        r2._downloadRetryTimes = r6
    L_0x05bc:
        org.apache.http.client.methods.HttpGet r2 = r7.m29437a(r3, r9)
        org.apache.http.impl.client.DefaultHttpClient r6 = r31.m29438a()
        org.apache.http.HttpResponse r2 = r6.execute(r2)     // Catch:{ NumberFormatException -> 0x0aba, ClientProtocolException -> 0x0aa3, IllegalStateException -> 0x0a8c, FileNotFoundException -> 0x0a72, IOException -> 0x0a5b, DownLoadException -> 0x0a44, all -> 0x0a37 }
        if (r2 == 0) goto L_0x0a17
        org.apache.http.StatusLine r6 = r2.getStatusLine()     // Catch:{ NumberFormatException -> 0x0aba, ClientProtocolException -> 0x0a08, IllegalStateException -> 0x0a8c, FileNotFoundException -> 0x0a72, IOException -> 0x0a5b, DownLoadException -> 0x0a44, all -> 0x0a37 }
        int r6 = r6.getStatusCode()     // Catch:{ NumberFormatException -> 0x0aba, ClientProtocolException -> 0x0a08, IllegalStateException -> 0x0a8c, FileNotFoundException -> 0x0a72, IOException -> 0x0a5b, DownLoadException -> 0x0a44, all -> 0x0a37 }
        r9 = 200(0xc8, float:2.8E-43)
        if (r6 == r9) goto L_0x06a1
        r9 = 206(0xce, float:2.89E-43)
        if (r6 != r9) goto L_0x05dc
        goto L_0x06a1
    L_0x05dc:
        r1 = 416(0x1a0, float:5.83E-43)
        if (r6 != r1) goto L_0x065c
        java.lang.String r1 = "server file length change at the same url, delete all info and download again at 0."
        com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r1)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        android.os.Bundle r1 = r7.f22958e     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        r1.remove(r3)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        boolean r1 = r14.delete()     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        if (r1 != 0) goto L_0x05f3
        com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r4)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
    L_0x05f3:
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r6 = 0
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = 0
        return r1
    L_0x05ff:
        r0 = move-exception
        r8 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0609:
        r2 = 0
        goto L_0x0ad1
    L_0x060c:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0616:
        r2 = 0
        goto L_0x0a4f
    L_0x0619:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0623:
        r2 = 0
        goto L_0x0a66
    L_0x0626:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0630:
        r2 = 0
        goto L_0x0a7d
    L_0x0633:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x063d:
        r2 = 0
        goto L_0x0a97
    L_0x0640:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x064a:
        r9 = r25
        r2 = 0
        goto L_0x0ab0
    L_0x064f:
        r0 = move-exception
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0659:
        r2 = 0
        goto L_0x0ac5
    L_0x065c:
        r1 = 404(0x194, float:5.66E-43)
        if (r6 != r1) goto L_0x0681
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        r1.<init>()     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        java.lang.String r2 = "The resource does not exist - "
        r1.append(r2)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        r1.append(r3)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        com.tencent.android.tpush.p580b.C6864a.m29298c(r8, r1)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        r8 = -3
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r1 = r31
        r6 = r19
        r1.m29439a(r2, r3, r4, r5, r6)
        return r8
    L_0x0681:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        r1.<init>()     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        java.lang.String r2 = "network connect status code unexpected - "
        r1.append(r2)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        r1.append(r6)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        com.tencent.android.tpush.p580b.C6864a.m29306g(r8, r1)     // Catch:{ NumberFormatException -> 0x064f, ClientProtocolException -> 0x0640, IllegalStateException -> 0x0633, FileNotFoundException -> 0x0626, IOException -> 0x0619, DownLoadException -> 0x060c, all -> 0x05ff }
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r6 = 0
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x06a1:
        org.apache.http.HttpEntity r6 = r2.getEntity()     // Catch:{ NumberFormatException -> 0x0aba, ClientProtocolException -> 0x0a08, IllegalStateException -> 0x0a8c, FileNotFoundException -> 0x0a72, IOException -> 0x0a5b, DownLoadException -> 0x0a44, all -> 0x0a37 }
        boolean r9 = r6.isStreaming()     // Catch:{ NumberFormatException -> 0x09fb, ClientProtocolException -> 0x09ef, IllegalStateException -> 0x09e2, FileNotFoundException -> 0x09d5, IOException -> 0x09c8, DownLoadException -> 0x09bb, all -> 0x09ae }
        if (r9 == 0) goto L_0x097c
        long r9 = r7.m29436a(r2)     // Catch:{ NumberFormatException -> 0x09fb, ClientProtocolException -> 0x09ef, IllegalStateException -> 0x09e2, FileNotFoundException -> 0x09d5, IOException -> 0x09c8, DownLoadException -> 0x09bb, all -> 0x09ae }
        long r9 = r9 + r26
        int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
        if (r2 != 0) goto L_0x0924
        java.io.InputStream r2 = r6.getContent()     // Catch:{ NumberFormatException -> 0x0918, ClientProtocolException -> 0x090c, IllegalStateException -> 0x0900, FileNotFoundException -> 0x08f4, IOException -> 0x08e8, DownLoadException -> 0x08dc, all -> 0x08d0 }
        if (r2 == 0) goto L_0x08bd
        java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ NumberFormatException -> 0x08b8, ClientProtocolException -> 0x08b3, IllegalStateException -> 0x08ae, FileNotFoundException -> 0x08a9, IOException -> 0x08a4, DownLoadException -> 0x089f, all -> 0x089a }
        r9.<init>(r2)     // Catch:{ NumberFormatException -> 0x08b8, ClientProtocolException -> 0x08b3, IllegalStateException -> 0x08ae, FileNotFoundException -> 0x08a9, IOException -> 0x08a4, DownLoadException -> 0x089f, all -> 0x089a }
        java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ NumberFormatException -> 0x088c, ClientProtocolException -> 0x087c, IllegalStateException -> 0x086e, FileNotFoundException -> 0x0860, IOException -> 0x0852, DownLoadException -> 0x0844, all -> 0x0836 }
        r13 = 1
        r10.<init>(r14, r13)     // Catch:{ NumberFormatException -> 0x088c, ClientProtocolException -> 0x087c, IllegalStateException -> 0x086e, FileNotFoundException -> 0x0860, IOException -> 0x0852, DownLoadException -> 0x0844, all -> 0x0836 }
        java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ NumberFormatException -> 0x082a, ClientProtocolException -> 0x081e, IllegalStateException -> 0x0812, FileNotFoundException -> 0x0806, IOException -> 0x07fa, DownLoadException -> 0x07ee, all -> 0x07e2 }
        r13.<init>(r10)     // Catch:{ NumberFormatException -> 0x082a, ClientProtocolException -> 0x081e, IllegalStateException -> 0x0812, FileNotFoundException -> 0x0806, IOException -> 0x07fa, DownLoadException -> 0x07ee, all -> 0x07e2 }
        r15 = 1024(0x400, float:1.435E-42)
        byte[] r15 = new byte[r15]     // Catch:{ NumberFormatException -> 0x07d5, ClientProtocolException -> 0x07c8, IllegalStateException -> 0x07bb, FileNotFoundException -> 0x07ae, IOException -> 0x07a1, DownLoadException -> 0x0794, all -> 0x0787 }
        r21 = r4
    L_0x06d1:
        int r4 = r9.read(r15)     // Catch:{ NumberFormatException -> 0x07d5, ClientProtocolException -> 0x07c8, IllegalStateException -> 0x07bb, FileNotFoundException -> 0x07ae, IOException -> 0x07a1, DownLoadException -> 0x0794, all -> 0x0787 }
        r34 = r6
        r6 = -1
        if (r4 == r6) goto L_0x0719
        boolean r6 = r7.f22955a     // Catch:{ NumberFormatException -> 0x0716, ClientProtocolException -> 0x0713, IllegalStateException -> 0x0710, FileNotFoundException -> 0x070d, IOException -> 0x070a, DownLoadException -> 0x0707, all -> 0x0704 }
        if (r6 != 0) goto L_0x06f4
        r6 = 0
        r13.write(r15, r6, r4)     // Catch:{ NumberFormatException -> 0x0716, ClientProtocolException -> 0x0713, IllegalStateException -> 0x0710, FileNotFoundException -> 0x070d, IOException -> 0x070a, DownLoadException -> 0x0707, all -> 0x0704 }
        r6 = r9
        r16 = r10
        long r9 = (long) r4
        long r9 = r26 + r9
        r7.f22956c = r9     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        r7.f22957d = r11     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        r26 = r9
        r10 = r16
        r9 = r6
        r6 = r34
        goto L_0x06d1
    L_0x06f4:
        r6 = r9
        r16 = r10
        java.lang.String r1 = "stop download by user, throw JPushException."
        com.tencent.android.tpush.p580b.C6864a.m29306g(r8, r1)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException r1 = new com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$DownLoadException     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        java.lang.String r3 = "stop download by user."
        r1.m51901init(r3)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        throw r1     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
    L_0x0704:
        r0 = move-exception
        goto L_0x078a
    L_0x0707:
        r0 = move-exception
        goto L_0x0797
    L_0x070a:
        r0 = move-exception
        goto L_0x07a4
    L_0x070d:
        r0 = move-exception
        goto L_0x07b1
    L_0x0710:
        r0 = move-exception
        goto L_0x07be
    L_0x0713:
        r0 = move-exception
        goto L_0x07cb
    L_0x0716:
        r0 = move-exception
        goto L_0x07d8
    L_0x0719:
        r6 = r9
        r16 = r10
        r13.flush()     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        java.lang.String r4 = "Download finished"
        com.tencent.android.tpush.p580b.C6864a.m29298c(r8, r4)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        long r9 = r14.length()     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
        if (r4 != 0) goto L_0x074e
        boolean r4 = com.tencent.android.tpush.cloudctr.p583b.C6890b.m29431a(r5, r14)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        if (r4 == 0) goto L_0x074e
        android.os.Bundle r4 = r7.f22958e     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        r4.remove(r3)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        if (r1 == 0) goto L_0x0741
        java.lang.String r3 = r14.getAbsolutePath()     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        r4 = 0
        r1.mo33079a(r3, r4)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
    L_0x0741:
        r1 = r31
        r3 = r6
        r4 = r16
        r5 = r13
        r6 = r34
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = 1
        return r1
    L_0x074e:
        java.lang.String r1 = "The download file is not valid, download again"
        com.tencent.android.tpush.p580b.C6864a.m29306g(r8, r1)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        boolean r1 = r14.delete()     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        if (r1 != 0) goto L_0x076b
        r1 = r21
        com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r1)     // Catch:{ NumberFormatException -> 0x0784, ClientProtocolException -> 0x0781, IllegalStateException -> 0x077f, FileNotFoundException -> 0x077d, IOException -> 0x077b, DownLoadException -> 0x0779, all -> 0x0777 }
        r1 = r31
        r3 = r6
        r4 = r16
        r5 = r13
        r6 = r34
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x076b:
        r1 = r31
        r3 = r6
        r4 = r16
        r5 = r13
        r6 = r34
        r1.m29439a(r2, r3, r4, r5, r6)
        return r22
    L_0x0777:
        r0 = move-exception
        goto L_0x078d
    L_0x0779:
        r0 = move-exception
        goto L_0x079a
    L_0x077b:
        r0 = move-exception
        goto L_0x07a7
    L_0x077d:
        r0 = move-exception
        goto L_0x07b4
    L_0x077f:
        r0 = move-exception
        goto L_0x07c1
    L_0x0781:
        r0 = move-exception
        goto L_0x07ce
    L_0x0784:
        r0 = move-exception
        goto L_0x07db
    L_0x0787:
        r0 = move-exception
        r34 = r6
    L_0x078a:
        r6 = r9
        r16 = r10
    L_0x078d:
        r8 = r0
        r3 = r6
        r5 = r13
        r4 = r16
        goto L_0x0840
    L_0x0794:
        r0 = move-exception
        r34 = r6
    L_0x0797:
        r6 = r9
        r16 = r10
    L_0x079a:
        r1 = r0
        r3 = r6
        r5 = r13
        r4 = r16
        goto L_0x084e
    L_0x07a1:
        r0 = move-exception
        r34 = r6
    L_0x07a4:
        r6 = r9
        r16 = r10
    L_0x07a7:
        r1 = r0
        r3 = r6
        r5 = r13
        r4 = r16
        goto L_0x085c
    L_0x07ae:
        r0 = move-exception
        r34 = r6
    L_0x07b1:
        r6 = r9
        r16 = r10
    L_0x07b4:
        r1 = r0
        r3 = r6
        r5 = r13
        r4 = r16
        goto L_0x086a
    L_0x07bb:
        r0 = move-exception
        r34 = r6
    L_0x07be:
        r6 = r9
        r16 = r10
    L_0x07c1:
        r1 = r0
        r3 = r6
        r5 = r13
        r4 = r16
        goto L_0x0878
    L_0x07c8:
        r0 = move-exception
        r34 = r6
    L_0x07cb:
        r6 = r9
        r16 = r10
    L_0x07ce:
        r1 = r0
        r3 = r6
        r5 = r13
        r4 = r16
        goto L_0x0886
    L_0x07d5:
        r0 = move-exception
        r34 = r6
    L_0x07d8:
        r6 = r9
        r16 = r10
    L_0x07db:
        r1 = r0
        r3 = r6
        r5 = r13
        r4 = r16
        goto L_0x0896
    L_0x07e2:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r16 = r10
        r8 = r0
        r3 = r6
        r4 = r16
        goto L_0x083e
    L_0x07ee:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r16 = r10
        r1 = r0
        r3 = r6
        r4 = r16
        goto L_0x084c
    L_0x07fa:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r16 = r10
        r1 = r0
        r3 = r6
        r4 = r16
        goto L_0x085a
    L_0x0806:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r16 = r10
        r1 = r0
        r3 = r6
        r4 = r16
        goto L_0x0868
    L_0x0812:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r16 = r10
        r1 = r0
        r3 = r6
        r4 = r16
        goto L_0x0876
    L_0x081e:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r16 = r10
        r1 = r0
        r3 = r6
        r4 = r16
        goto L_0x0884
    L_0x082a:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r16 = r10
        r1 = r0
        r3 = r6
        r4 = r16
        goto L_0x0894
    L_0x0836:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r8 = r0
        r3 = r6
        r4 = r17
    L_0x083e:
        r5 = r18
    L_0x0840:
        r6 = r34
        goto L_0x0ad1
    L_0x0844:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r1 = r0
        r3 = r6
        r4 = r17
    L_0x084c:
        r5 = r18
    L_0x084e:
        r6 = r34
        goto L_0x0a4f
    L_0x0852:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r1 = r0
        r3 = r6
        r4 = r17
    L_0x085a:
        r5 = r18
    L_0x085c:
        r6 = r34
        goto L_0x0a66
    L_0x0860:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r1 = r0
        r3 = r6
        r4 = r17
    L_0x0868:
        r5 = r18
    L_0x086a:
        r6 = r34
        goto L_0x0a7d
    L_0x086e:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r1 = r0
        r3 = r6
        r4 = r17
    L_0x0876:
        r5 = r18
    L_0x0878:
        r6 = r34
        goto L_0x0a97
    L_0x087c:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r1 = r0
        r3 = r6
        r4 = r17
    L_0x0884:
        r5 = r18
    L_0x0886:
        r9 = r25
        r6 = r34
        goto L_0x0ab0
    L_0x088c:
        r0 = move-exception
        r34 = r6
        r6 = r9
        r1 = r0
        r3 = r6
        r4 = r17
    L_0x0894:
        r5 = r18
    L_0x0896:
        r6 = r34
        goto L_0x0ac5
    L_0x089a:
        r0 = move-exception
        r34 = r6
        goto L_0x09b2
    L_0x089f:
        r0 = move-exception
        r34 = r6
        goto L_0x09bf
    L_0x08a4:
        r0 = move-exception
        r34 = r6
        goto L_0x09cc
    L_0x08a9:
        r0 = move-exception
        r34 = r6
        goto L_0x09d9
    L_0x08ae:
        r0 = move-exception
        r34 = r6
        goto L_0x09e6
    L_0x08b3:
        r0 = move-exception
        r34 = r6
        goto L_0x09f3
    L_0x08b8:
        r0 = move-exception
        r34 = r6
        goto L_0x09ff
    L_0x08bd:
        r34 = r6
        java.lang.String r1 = "NULL response stream"
        com.tencent.android.tpush.p580b.C6864a.m29306g(r8, r1)     // Catch:{ NumberFormatException -> 0x09a9, ClientProtocolException -> 0x09a5, IllegalStateException -> 0x09a1, FileNotFoundException -> 0x099d, IOException -> 0x0999, DownLoadException -> 0x0995, all -> 0x0991 }
        r3 = 0
        r4 = 0
        r5 = 0
        r1 = r31
        r6 = r34
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = 0
        return r1
    L_0x08d0:
        r0 = move-exception
        r34 = r6
    L_0x08d3:
        r8 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0609
    L_0x08dc:
        r0 = move-exception
        r34 = r6
    L_0x08df:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0616
    L_0x08e8:
        r0 = move-exception
        r34 = r6
    L_0x08eb:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0623
    L_0x08f4:
        r0 = move-exception
        r34 = r6
    L_0x08f7:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0630
    L_0x0900:
        r0 = move-exception
        r34 = r6
    L_0x0903:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x063d
    L_0x090c:
        r0 = move-exception
        r34 = r6
    L_0x090f:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x064a
    L_0x0918:
        r0 = move-exception
        r34 = r6
    L_0x091b:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0659
    L_0x0924:
        r1 = r4
        r34 = r6
        java.lang.String r2 = "File length between last and now were different."
        com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r2)     // Catch:{ NumberFormatException -> 0x0979, ClientProtocolException -> 0x0976, IllegalStateException -> 0x0973, FileNotFoundException -> 0x0970, IOException -> 0x096d, DownLoadException -> 0x096a, all -> 0x0967 }
        android.os.Bundle r2 = r7.f22958e     // Catch:{ NumberFormatException -> 0x0979, ClientProtocolException -> 0x0976, IllegalStateException -> 0x0973, FileNotFoundException -> 0x0970, IOException -> 0x096d, DownLoadException -> 0x096a, all -> 0x0967 }
        r2.remove(r3)     // Catch:{ NumberFormatException -> 0x0979, ClientProtocolException -> 0x0976, IllegalStateException -> 0x0973, FileNotFoundException -> 0x0970, IOException -> 0x096d, DownLoadException -> 0x096a, all -> 0x0967 }
        boolean r2 = r14.delete()     // Catch:{ NumberFormatException -> 0x0979, ClientProtocolException -> 0x0976, IllegalStateException -> 0x0973, FileNotFoundException -> 0x0970, IOException -> 0x096d, DownLoadException -> 0x096a, all -> 0x0967 }
        if (r2 != 0) goto L_0x0957
        com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r1)     // Catch:{ NumberFormatException -> 0x0953, ClientProtocolException -> 0x094f, IllegalStateException -> 0x094b, FileNotFoundException -> 0x0947, IOException -> 0x0943, DownLoadException -> 0x093f, all -> 0x093b }
        goto L_0x0957
    L_0x093b:
        r0 = move-exception
        r6 = r34
        goto L_0x08d3
    L_0x093f:
        r0 = move-exception
        r6 = r34
        goto L_0x08df
    L_0x0943:
        r0 = move-exception
        r6 = r34
        goto L_0x08eb
    L_0x0947:
        r0 = move-exception
        r6 = r34
        goto L_0x08f7
    L_0x094b:
        r0 = move-exception
        r6 = r34
        goto L_0x0903
    L_0x094f:
        r0 = move-exception
        r6 = r34
        goto L_0x090f
    L_0x0953:
        r0 = move-exception
        r6 = r34
        goto L_0x091b
    L_0x0957:
        r1 = r31
        r2 = 0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r34
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = 0
        return r1
    L_0x0967:
        r0 = move-exception
        r2 = 0
        goto L_0x0992
    L_0x096a:
        r0 = move-exception
        r2 = 0
        goto L_0x0996
    L_0x096d:
        r0 = move-exception
        r2 = 0
        goto L_0x099a
    L_0x0970:
        r0 = move-exception
        r2 = 0
        goto L_0x099e
    L_0x0973:
        r0 = move-exception
        r2 = 0
        goto L_0x09a2
    L_0x0976:
        r0 = move-exception
        r2 = 0
        goto L_0x09a6
    L_0x0979:
        r0 = move-exception
        r2 = 0
        goto L_0x09aa
    L_0x097c:
        r34 = r6
        r2 = 0
        java.lang.String r1 = "data mode from server is not stream."
        com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r1)     // Catch:{ NumberFormatException -> 0x09a9, ClientProtocolException -> 0x09a5, IllegalStateException -> 0x09a1, FileNotFoundException -> 0x099d, IOException -> 0x0999, DownLoadException -> 0x0995, all -> 0x0991 }
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r1 = r31
        r6 = r34
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0991:
        r0 = move-exception
    L_0x0992:
        r6 = r34
        goto L_0x09b2
    L_0x0995:
        r0 = move-exception
    L_0x0996:
        r6 = r34
        goto L_0x09bf
    L_0x0999:
        r0 = move-exception
    L_0x099a:
        r6 = r34
        goto L_0x09cc
    L_0x099d:
        r0 = move-exception
    L_0x099e:
        r6 = r34
        goto L_0x09d9
    L_0x09a1:
        r0 = move-exception
    L_0x09a2:
        r6 = r34
        goto L_0x09e6
    L_0x09a5:
        r0 = move-exception
    L_0x09a6:
        r6 = r34
        goto L_0x09f3
    L_0x09a9:
        r0 = move-exception
    L_0x09aa:
        r6 = r34
        goto L_0x09ff
    L_0x09ae:
        r0 = move-exception
        r34 = r6
        r2 = 0
    L_0x09b2:
        r8 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0ad1
    L_0x09bb:
        r0 = move-exception
        r34 = r6
        r2 = 0
    L_0x09bf:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0a4f
    L_0x09c8:
        r0 = move-exception
        r34 = r6
        r2 = 0
    L_0x09cc:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0a66
    L_0x09d5:
        r0 = move-exception
        r34 = r6
        r2 = 0
    L_0x09d9:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0a7d
    L_0x09e2:
        r0 = move-exception
        r34 = r6
        r2 = 0
    L_0x09e6:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0a97
    L_0x09ef:
        r0 = move-exception
        r34 = r6
        r2 = 0
    L_0x09f3:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0a13
    L_0x09fb:
        r0 = move-exception
        r34 = r6
        r2 = 0
    L_0x09ff:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        goto L_0x0ac5
    L_0x0a08:
        r0 = move-exception
        r2 = 0
    L_0x0a0a:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0a13:
        r9 = r25
        goto L_0x0ab0
    L_0x0a17:
        r2 = 0
        com.tencent.android.tpush.p580b.C6864a.m29306g(r8, r13)     // Catch:{ NumberFormatException -> 0x0a34, ClientProtocolException -> 0x0a32, IllegalStateException -> 0x0a2f, FileNotFoundException -> 0x0a2d, IOException -> 0x0a2b, DownLoadException -> 0x0a29, all -> 0x0a27 }
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r6 = 0
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = 0
        return r1
    L_0x0a27:
        r0 = move-exception
        goto L_0x0a39
    L_0x0a29:
        r0 = move-exception
        goto L_0x0a46
    L_0x0a2b:
        r0 = move-exception
        goto L_0x0a5d
    L_0x0a2d:
        r0 = move-exception
        goto L_0x0a74
    L_0x0a2f:
        r0 = move-exception
        goto L_0x0a8e
    L_0x0a32:
        r0 = move-exception
        goto L_0x0a0a
    L_0x0a34:
        r0 = move-exception
        goto L_0x0abc
    L_0x0a37:
        r0 = move-exception
        r2 = 0
    L_0x0a39:
        r8 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
        goto L_0x0ad1
    L_0x0a44:
        r0 = move-exception
        r2 = 0
    L_0x0a46:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0a4f:
        java.lang.String r9 = "Downloadexception"
        com.tencent.android.tpush.p580b.C6864a.m29299c(r8, r9, r1)     // Catch:{ all -> 0x0a89 }
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0a5b:
        r0 = move-exception
        r2 = 0
    L_0x0a5d:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0a66:
        r9 = r20
        com.tencent.android.tpush.p580b.C6864a.m29294b(r8, r9, r1)     // Catch:{ all -> 0x0a89 }
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -1
        return r1
    L_0x0a72:
        r0 = move-exception
        r2 = 0
    L_0x0a74:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0a7d:
        java.lang.String r9 = "FileNotFoundException"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r8, r9, r1)     // Catch:{ all -> 0x0a89 }
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0a89:
        r0 = move-exception
        r8 = r0
        goto L_0x0ad1
    L_0x0a8c:
        r0 = move-exception
        r2 = 0
    L_0x0a8e:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0a97:
        r9 = r25
        com.tencent.android.tpush.p580b.C6864a.m29302d(r8, r9, r1)     // Catch:{ all -> 0x0a89 }
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0aa3:
        r0 = move-exception
        r9 = r25
        r2 = 0
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0ab0:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r8, r9, r1)     // Catch:{ all -> 0x0a89 }
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0aba:
        r0 = move-exception
        r2 = 0
    L_0x0abc:
        r1 = r0
        r3 = r16
        r4 = r17
        r5 = r18
        r6 = r19
    L_0x0ac5:
        r9 = r24
        com.tencent.android.tpush.p580b.C6864a.m29302d(r8, r9, r1)     // Catch:{ all -> 0x0a89 }
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        r1 = -2
        return r1
    L_0x0ad1:
        r1 = r31
        r1.m29439a(r2, r3, r4, r5, r6)
        throw r8
    L_0x0ad7:
        r0 = move-exception
        r1 = r0
        java.lang.String r2 = "createNewFile fail."
        com.tencent.android.tpush.p580b.C6864a.m29302d(r8, r2, r1)
        r1 = -2
        return r1
    L_0x0ae0:
        r3 = r4
        r1 = r8
        r8 = r12
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r4 = "Param error !! url:"
        r2.append(r4)
        r2.append(r3)
        java.lang.String r3 = " savefilePath:"
        r2.append(r3)
        r2.append(r6)
        java.lang.String r3 = " fileName:"
        r2.append(r3)
        r2.append(r1)
        java.lang.String r1 = r2.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r8, r1)
        r1 = -2
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl.m29435a(android.content.Context, com.tencent.android.tpush.cloudctr.network.CloudControlDownloadControl$a, com.tencent.android.tpush.cloudctr.network.DownloadItem):int");
    }

    /* renamed from: a */
    private void m29439a(InputStream inputStream, BufferedInputStream bufferedInputStream, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream, HttpEntity httpEntity) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused3) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
        }
        if (httpEntity != null) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused5) {
            }
        }
    }

    /* renamed from: a */
    private DefaultHttpClient m29438a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, C7120a.MAX_USERDATA_VALUE_LENGTH);
        HttpConnectionParams.setSoTimeout(basicHttpParams, C7120a.MAX_USERDATA_VALUE_LENGTH);
        return new DefaultHttpClient(basicHttpParams);
    }

    /* renamed from: a */
    private HttpGet m29437a(String str, long j) {
        HttpGet httpGet = new HttpGet(str);
        httpGet.addHeader("Connection", "Close");
        if (j >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            httpGet.addHeader("Range", sb.toString());
        }
        return httpGet;
    }

    /* renamed from: a */
    private void m29440a(String str) {
        File file = new File(str);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }

    /* renamed from: a */
    private long m29436a(HttpResponse httpResponse) {
        long longValue = Long.valueOf(httpResponse.getFirstHeader("Content-Length").getValue()).longValue();
        if (longValue > 0) {
            return longValue;
        }
        throw new DownLoadException("get the file total length from http is 0.");
    }

    /* renamed from: a */
    private int m29434a(long j) {
        long j2 = j / 10240;
        int i = j2 < 1 ? 10 : j2 > 5 ? 50 : (int) (j2 * 10);
        return (int) (((double) i) * 1.1d);
    }
}
