package com.p530ss.android.downloadlib;

import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.AdDownloadCompletedEventHandler;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p542a.AdDownloadDialogManager;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p541a.p543b.SharedPrefsManager;
import com.p530ss.android.downloadlib.p541a.p544c.DownloadOptimizationManager;
import com.p530ss.android.downloadlib.p541a.p545d.UploadHelper;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.AntiHijackUtils;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.appdownloader.AntiHijackAttempt;
import com.p530ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.p530ss.android.socialbase.appdownloader.C6604b;
import com.p530ss.android.socialbase.appdownloader.C6604b.C6609c;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager.C6638a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.AppUtils.C6750a;
import com.p530ss.android.socialbase.downloader.p569m.C6792i;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a */
public class AdDownloadCompletedEventHandlerImpl implements AdDownloadCompletedEventHandler, C6609c, C6638a {
    /* renamed from: a */
    private static String f21263a = AdDownloadCompletedEventHandlerImpl.class.getSimpleName();
    /* renamed from: d */
    private static volatile AdDownloadCompletedEventHandlerImpl f21264d;
    /* access modifiers changed from: private|volatile */
    /* renamed from: b */
    public volatile boolean f21265b = false;
    /* renamed from: c */
    private long f21266c;

    /* compiled from: AdDownloadCompletedEventHandlerImpl */
    /* renamed from: com.ss.android.downloadlib.a$a */
    private class C6539a implements Runnable {
        /* renamed from: b */
        private final int f21271b;

        public C6539a(int i) {
            this.f21271b = i;
        }

        public void run() {
            try {
                ModelManager.m26169a().mo31272b();
                ConcurrentHashMap c = ModelManager.m26169a().mo31274c();
                if (c != null && !c.isEmpty()) {
                    AdDownloadCompletedEventHandlerImpl.this.m26115a(c, this.f21271b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: AdDownloadCompletedEventHandlerImpl */
    /* renamed from: com.ss.android.downloadlib.a$b */
    private class C6540b implements Runnable {
        /* renamed from: b */
        private final String f21273b;

        public C6540b(String str) {
            this.f21273b = str;
        }

        public void run() {
            try {
                AdDownloadCompletedEventHandlerImpl.this.f21265b = true;
                AdDownloadCompletedEventHandlerImpl.this.m26120c(this.f21273b);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                AdDownloadCompletedEventHandlerImpl.this.f21265b = false;
                throw th;
            }
            AdDownloadCompletedEventHandlerImpl.this.f21265b = false;
        }
    }

    private AdDownloadCompletedEventHandlerImpl() {
        C6604b.m26611a((C6609c) this);
        if (DownloadSetting.m28617b().mo32547a("check_event_when_app_switch", 0) == 1) {
            AppStatusManager.m26964a().mo31645a((C6638a) this);
        }
    }

    /* renamed from: a */
    public static AdDownloadCompletedEventHandlerImpl m26106a() {
        if (f21264d == null) {
            synchronized (AdDownloadCompletedEventHandlerImpl.class) {
                if (f21264d == null) {
                    f21264d = new AdDownloadCompletedEventHandlerImpl();
                }
            }
        }
        return f21264d;
    }

    /* renamed from: a */
    public static void m26116a(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            DownloadSetting a = DownloadSetting.m28610a(i);
            JSONObject d = a.mo32555d("anti_hijack_report_config");
            if (d != null) {
                try {
                    C6750a a2 = C6604b.m26607a(d.optString("report_installer_pkg_name"));
                    if (a2 != null) {
                        jSONObject.put("installer_package_name", a2.mo32596c());
                        jSONObject.put("installer_version_code", a2.mo32601f());
                        jSONObject.put("installer_version_name", a2.mo32602g());
                    }
                    C6750a a3 = C6604b.m26607a(d.optString("report_file_manager_pkg_name"));
                    if (a3 != null) {
                        jSONObject.put("file_manager_package_name", a3.mo32596c());
                        jSONObject.put("file_manager_version_code", a3.mo32601f());
                        jSONObject.put("file_manager_version_name", a3.mo32602g());
                    }
                    jSONObject.put("rom_version", C6792i.m28937g());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            int i2 = 0;
            if (a.mo32547a("report_unknown_source", 0) == 1) {
                try {
                    String str = "is_unknown_source_enabled";
                    if (C6604b.m26612a(C6694b.m27342B())) {
                        i2 = 1;
                    }
                    jSONObject.put(str, i2);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m26114a(DownloadInfo cVar, NativeDownloadModel aVar) {
        synchronized (AdDownloadCompletedEventHandlerImpl.class) {
            if (cVar == null || aVar == null) {
                C6587g.m26532b();
                return;
            }
            try {
                if (aVar.mo31205c() == 1) {
                    String b = m26118b(cVar, aVar);
                    m26111a(aVar);
                    aVar.mo31207c(System.currentTimeMillis());
                    aVar.mo31195a(2);
                    ModelManager.m26169a().mo31269a(aVar, cVar, b);
                    DownloadDispatcherImpl.m26547a().mo31422a(cVar, b);
                    if ("application/vnd.android.package-archive".equals(cVar.mo32231ah())) {
                        m26106a().mo31236b(b);
                        m26106a().mo31233a(cVar.mo32305n(), aVar.mo31194a());
                        if (aVar.mo31224n()) {
                            AdDownloadDialogManager.m26137a().mo31246a((long) cVar.mo32283g(), aVar.mo31194a(), aVar.mo31200b(), b, cVar.mo32291i(), aVar.mo31215f(), cVar.mo32305n());
                        }
                        UploadHelper.m26228a(cVar, aVar.mo31194a(), aVar.mo31215f(), b);
                    }
                } else {
                    return;
                }
            } catch (Exception e) {
                C6587g.m26520a((Throwable) e);
            }
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo31232a(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3)
        boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x0009
        monitor-exit(r3)
        return
    L_0x0009:
        boolean r0 = com.p530ss.android.downloadlib.p549e.C6587g.m26521a()     // Catch:{ Exception -> 0x008d }
        if (r0 != 0) goto L_0x0083
        com.ss.android.downloadlib.a.b.c r0 = com.p530ss.android.downloadlib.p541a.p543b.ModelManager.m26169a()     // Catch:{ Exception -> 0x008d }
        com.ss.android.downloadad.a.b.a r0 = r0.mo31264a(r4)     // Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x0081
        java.util.concurrent.atomic.AtomicBoolean r1 = r0.f21245a     // Catch:{ Exception -> 0x008d }
        boolean r1 = r1.get()     // Catch:{ Exception -> 0x008d }
        if (r1 == 0) goto L_0x0022
        goto L_0x0081
    L_0x0022:
        r3.mo31234a(r4, r0)     // Catch:{ Exception -> 0x008d }
        com.ss.android.downloadlib.a.a r1 = com.p530ss.android.downloadlib.p541a.AdDeepLinkManager.m26130a()     // Catch:{ Exception -> 0x008d }
        boolean r1 = r1.mo31244a(r4, r0)     // Catch:{ Exception -> 0x008d }
        if (r1 != 0) goto L_0x0036
        com.ss.android.downloadlib.a.a r1 = com.p530ss.android.downloadlib.p541a.AdDeepLinkManager.m26130a()     // Catch:{ Exception -> 0x008d }
        r1.mo31243a(r4)     // Catch:{ Exception -> 0x008d }
    L_0x0036:
        com.ss.android.downloadlib.g r1 = com.p530ss.android.downloadlib.DownloadDispatcherImpl.m26547a()     // Catch:{ Exception -> 0x008d }
        java.lang.String r0 = r0.mo31227q()     // Catch:{ Exception -> 0x008d }
        com.ss.android.downloadlib.a.f r0 = r1.mo31418a(r0)     // Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x0047
        r0.mo31324e()     // Catch:{ Exception -> 0x008d }
    L_0x0047:
        com.ss.android.downloadlib.a.a.a r0 = com.p530ss.android.downloadlib.p541a.p542a.AdDownloadDialogManager.m26137a()     // Catch:{ Exception -> 0x008d }
        r0.mo31252b(r4)     // Catch:{ Exception -> 0x008d }
        android.content.Context r0 = com.p530ss.android.downloadlib.p541a.C6565j.m26357a()     // Catch:{ Exception -> 0x008d }
        com.ss.android.socialbase.downloader.downloader.f r0 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r0)     // Catch:{ Exception -> 0x008d }
        java.lang.String r1 = "application/vnd.android.package-archive"
        java.util.List r0 = r0.mo31919b(r1)     // Catch:{ Exception -> 0x008d }
        com.ss.android.socialbase.downloader.g.c r0 = m26107a(r0, r4)     // Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x0078
        com.ss.android.socialbase.downloader.notification.b r1 = com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager.m28984a()     // Catch:{ Exception -> 0x008d }
        int r2 = r0.mo32283g()     // Catch:{ Exception -> 0x008d }
        r1.mo32639a(r2)     // Catch:{ Exception -> 0x008d }
        com.ss.android.downloadlib.g r1 = com.p530ss.android.downloadlib.DownloadDispatcherImpl.m26547a()     // Catch:{ Exception -> 0x008d }
        r1.mo31423b(r0, r4)     // Catch:{ Exception -> 0x008d }
        com.p530ss.android.downloadlib.p541a.p544c.DownloadOptimizationManager.m26214a(r0)     // Catch:{ Exception -> 0x008d }
        goto L_0x0091
    L_0x0078:
        com.ss.android.downloadlib.g r0 = com.p530ss.android.downloadlib.DownloadDispatcherImpl.m26547a()     // Catch:{ Exception -> 0x008d }
        r1 = 0
        r0.mo31423b(r1, r4)     // Catch:{ Exception -> 0x008d }
        goto L_0x0091
    L_0x0081:
        monitor-exit(r3)
        return
    L_0x0083:
        java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x008d }
        java.lang.String r0 = "handleAppInstalled in main thread."
        r4.<init>(r0)     // Catch:{ Exception -> 0x008d }
        throw r4     // Catch:{ Exception -> 0x008d }
    L_0x008b:
        r4 = move-exception
        goto L_0x0093
    L_0x008d:
        r4 = move-exception
        com.p530ss.android.downloadlib.p549e.C6587g.m26520a(r4)     // Catch:{ all -> 0x008b }
    L_0x0091:
        monitor-exit(r3)
        return
    L_0x0093:
        monitor-exit(r3)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.AdDownloadCompletedEventHandlerImpl.mo31232a(java.lang.String):void");
    }

    /* renamed from: a */
    public void mo31234a(String str, NativeDownloadModel aVar) {
        if (aVar != null && C6587g.m26526a(aVar) && aVar.f21245a.compareAndSet(false, true)) {
            int i = 4;
            if (aVar.mo31223m() != 4) {
                i = 3;
            }
            JSONObject a = m26108a(m26105a(String.valueOf(aVar.mo31194a()), str), i);
            m26116a(a, aVar.mo31221k());
            DownloadInfo h = Downloader.m27478a(C6565j.m26357a()).mo31928h(aVar.mo31221k());
            if (h != null) {
                try {
                    a.put("uninstall_resume_count", h.mo32256bb());
                } catch (Throwable unused) {
                }
                String string = h.mo32261bg().getString("anti_hijack_attempt");
                if (!TextUtils.isEmpty(string)) {
                    AntiHijackAttempt a2 = AntiHijackAttempt.m26588a(string);
                    if (a2 != null) {
                        a2.mo31452a(a);
                    }
                }
            }
            AdEventHandler.m26446a().mo31403a(aVar.mo31225o(), "install_finish", a, aVar);
            SharedPrefsManager.m26192a().mo31281a(aVar);
        }
    }

    /* renamed from: a */
    private static DownloadInfo m26107a(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo cVar : list) {
                if (cVar != null) {
                    if (str.equals(cVar.mo32319z())) {
                        return cVar;
                    }
                    if (C6587g.m26524a(C6565j.m26357a(), cVar.mo32305n(), str)) {
                        return cVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:54|55|56|57|58) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x016f */
    /* renamed from: a */
    public static org.json.JSONObject m26110a(org.json.JSONObject r10, com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r11, boolean r12) {
        /*
        if (r10 == 0) goto L_0x01e5
        if (r11 != 0) goto L_0x0006
        goto L_0x01e5
    L_0x0006:
        int r0 = r11.mo32283g()
        com.ss.android.socialbase.downloader.k.a r0 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r0)
        r1 = 0
        java.lang.String r2 = "download_event_opt"
        int r0 = r0.mo32547a(r2, r1)
        if (r0 != 0) goto L_0x0018
        return r10
    L_0x0018:
        java.lang.String r0 = "download_id"
        int r2 = r11.mo32283g()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "name"
        java.lang.String r2 = r11.mo32287h()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "url"
        java.lang.String r2 = r11.mo32295j()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "download_time"
        long r2 = r11.mo32246aw()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "cur_bytes"
        long r2 = r11.mo32180Z()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "total_bytes"
        long r2 = r11.mo32225ab()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "network_quality"
        java.lang.String r2 = r11.mo32227ad()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        com.ss.android.socialbase.downloader.i.g r0 = com.p530ss.android.socialbase.downloader.p564i.NetTrafficManager.m28219a()     // Catch:{ JSONException -> 0x01e1 }
        com.ss.android.socialbase.downloader.i.h r0 = r0.mo32470b()     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r2 = "current_network_quality"
        java.lang.String r0 = r0.name()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r2, r0)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "only_wifi"
        boolean r2 = r11.mo32317x()     // Catch:{ JSONException -> 0x01e1 }
        r3 = 1
        if (r2 == 0) goto L_0x0073
        r2 = 1
        goto L_0x0074
    L_0x0073:
        r2 = 0
    L_0x0074:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "need_https_degrade"
        boolean r2 = r11.mo32232ai()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x0081
        r2 = 1
        goto L_0x0082
    L_0x0081:
        r2 = 0
    L_0x0082:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "https_degrade_retry_used"
        boolean r2 = r11.mo32311t()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x008f
        r2 = 1
        goto L_0x0090
    L_0x008f:
        r2 = 0
    L_0x0090:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "chunk_count"
        int r2 = r11.mo32219aV()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "retry_count"
        int r2 = r11.mo32158D()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "cur_retry_time"
        int r2 = r11.mo32235al()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "need_retry_delay"
        boolean r2 = r11.mo32233aj()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x00b8
        r2 = 1
        goto L_0x00b9
    L_0x00b8:
        r2 = 0
    L_0x00b9:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "backup_url_used"
        boolean r2 = r11.mo32164J()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x00c6
        r2 = 1
        goto L_0x00c7
    L_0x00c6:
        r2 = 0
    L_0x00c7:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "head_connection_error_msg"
        java.lang.String r2 = r11.mo32262c()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x00d7
        java.lang.String r2 = r11.mo32262c()     // Catch:{ JSONException -> 0x01e1 }
        goto L_0x00d9
    L_0x00d7:
        java.lang.String r2 = ""
    L_0x00d9:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "need_independent_process"
        boolean r2 = r11.mo32174T()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x00e6
        r2 = 1
        goto L_0x00e7
    L_0x00e6:
        r2 = 0
    L_0x00e7:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "total_retry_count"
        int r2 = r11.mo32160F()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "cur_retry_time_in_total"
        int r2 = r11.mo32161G()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "real_download_time"
        long r4 = r11.mo32247ax()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r4)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "chunk_downgrade_retry_used"
        boolean r2 = r11.mo32239ap()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x010f
        r2 = 1
        goto L_0x0110
    L_0x010f:
        r2 = 0
    L_0x0110:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "need_chunk_downgrade_retry"
        boolean r2 = r11.mo32238ao()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x011d
        r2 = 1
        goto L_0x011e
    L_0x011d:
        r2 = 0
    L_0x011e:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "failed_resume_count"
        int r2 = r11.mo32223aZ()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        int r0 = r11.mo32260bf()     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r2 = "preconnect_level"
        r10.put(r2, r0)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "retry_schedule_count"
        int r2 = r11.mo32168N()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = "rw_concurrent"
        boolean r2 = r11.mo32169O()     // Catch:{ JSONException -> 0x01e1 }
        if (r2 == 0) goto L_0x0146
        r2 = 1
        goto L_0x0147
    L_0x0146:
        r2 = 0
    L_0x0147:
        r10.put(r0, r2)     // Catch:{ JSONException -> 0x01e1 }
        if (r12 != 0) goto L_0x018a
        long r4 = r11.mo32180Z()     // Catch:{ JSONException -> 0x01e1 }
        double r4 = (double) r4     // Catch:{ JSONException -> 0x01e1 }
        r6 = 4697254411347427328(0x4130000000000000, double:1048576.0)
        double r4 = r4 / r6
        long r6 = r11.mo32247ax()     // Catch:{ JSONException -> 0x01e1 }
        double r6 = (double) r6
        r8 = 4652007308841189376(0x408f400000000000, double:1000.0)
        double r6 = r6 / r8
        r8 = 0
        int r12 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
        if (r12 <= 0) goto L_0x018a
        int r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r12 <= 0) goto L_0x018a
        double r4 = r4 / r6
        java.lang.String r12 = "download_speed"
        r10.put(r12, r4)     // Catch:{ Exception -> 0x016f }
    L_0x016f:
        java.lang.String r12 = f21263a     // Catch:{ JSONException -> 0x01e1 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01e1 }
        r0.<init>()     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r2 = "download speed : "
        r0.append(r2)     // Catch:{ JSONException -> 0x01e1 }
        r0.append(r4)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r2 = "MB/s"
        r0.append(r2)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01e1 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r12, r0)     // Catch:{ JSONException -> 0x01e1 }
    L_0x018a:
        android.content.Context r12 = com.p530ss.android.downloadlib.p541a.C6565j.m26357a()     // Catch:{ Exception -> 0x01a3 }
        com.ss.android.socialbase.downloader.downloader.f r12 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r12)     // Catch:{ Exception -> 0x01a3 }
        int r0 = r11.mo32283g()     // Catch:{ Exception -> 0x01a3 }
        boolean r12 = r12.mo31933m(r0)     // Catch:{ Exception -> 0x01a3 }
        java.lang.String r0 = "is_download_service_foreground"
        if (r12 == 0) goto L_0x019f
        r1 = 1
    L_0x019f:
        r10.put(r0, r1)     // Catch:{ Exception -> 0x01a3 }
        goto L_0x01a7
    L_0x01a3:
        r12 = move-exception
        r12.printStackTrace()     // Catch:{ JSONException -> 0x01e1 }
    L_0x01a7:
        java.util.List r12 = r11.mo32200aC()     // Catch:{ JSONException -> 0x01e1 }
        if (r12 == 0) goto L_0x01c3
        java.lang.String r12 = "backup_url_count"
        java.util.List r0 = r11.mo32200aC()     // Catch:{ JSONException -> 0x01e1 }
        int r0 = r0.size()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r12, r0)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r12 = "cur_backup_url_index"
        int r0 = r11.mo32310s()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r12, r0)     // Catch:{ JSONException -> 0x01e1 }
    L_0x01c3:
        java.lang.String r12 = "clear_space_restart_times"
        com.ss.android.downloadlib.a.c.d r0 = com.p530ss.android.downloadlib.p541a.p544c.DownloadOptimizationManager.m26212a()     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r1 = r11.mo32295j()     // Catch:{ JSONException -> 0x01e1 }
        int r0 = r0.mo31294b(r1)     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r12, r0)     // Catch:{ JSONException -> 0x01e1 }
        java.lang.String r12 = "mime_type"
        java.lang.String r0 = r11.mo32231ah()     // Catch:{ JSONException -> 0x01e1 }
        r10.put(r12, r0)     // Catch:{ JSONException -> 0x01e1 }
        m26109a(r10, r11)     // Catch:{ JSONException -> 0x01e1 }
        goto L_0x01e5
    L_0x01e1:
        r11 = move-exception
        r11.printStackTrace()
    L_0x01e5:
        return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.AdDownloadCompletedEventHandlerImpl.m26110a(org.json.JSONObject, com.ss.android.socialbase.downloader.g.c, boolean):org.json.JSONObject");
    }

    /* renamed from: a */
    public static JSONObject m26109a(JSONObject jSONObject, DownloadInfo cVar) {
        if (jSONObject == null || cVar == null || DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("download_event_opt", 0) == 0) {
            return jSONObject;
        }
        try {
            long c = DownloadUtils.m28796c(Environment.getExternalStorageDirectory().toString());
            double d = (double) c;
            jSONObject.put("available_space", d / 1048576.0d);
            long ab = cVar.mo32225ab();
            if (c > 0 && ab > 0) {
                jSONObject.put("available_space_ratio", d / ((double) ab));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo31233a(final String str, final long j) {
        if (C6565j.m26375i().optInt("check_hijack", 0) != 0 && !TextUtils.isEmpty(str) && j > 0) {
            DownloadComponentManager.m26440a().mo31386a(new Runnable() {
                public void run() {
                    String a = AntiHijackUtils.m26480a(str);
                    if (!TextUtils.isEmpty(a)) {
                        C6565j.m26357a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(j), a).apply();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private static void m26111a(NativeDownloadModel aVar) {
        if (aVar != null) {
            String str = (String) DownloadOptimizationManager.m26212a().mo31295b().get((long) aVar.mo31221k());
            JSONObject h = aVar.mo31218h();
            if (!TextUtils.isEmpty(str)) {
                DownloadOptimizationManager.m26212a().mo31295b().remove((long) aVar.mo31221k());
                if (h == null) {
                    h = new JSONObject();
                }
                try {
                    h.putOpt("finish_reason", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            DownloadInfo h2 = Downloader.m27478a(C6565j.m26357a()).mo31928h(aVar.mo31221k());
            JSONObject a = m26110a(new JSONObject(), h2, false);
            m26116a(a, h2.mo32283g());
            AdEventHandler.m26446a().mo31405a(a, aVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26120c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 15;
            SystemClock.sleep(20000);
            while (true) {
                if (i <= 0) {
                    break;
                } else if (C6587g.m26535c(C6565j.m26357a(), str)) {
                    mo31232a(str);
                    break;
                } else {
                    i--;
                    if (i == 0) {
                        break;
                    }
                    SystemClock.sleep(20000);
                }
            }
        }
    }

    /* renamed from: a */
    private int m26105a(String str, String str2) {
        if (C6565j.m26375i().optInt("check_hijack", 0) == 0) {
            return 0;
        }
        String string = C6565j.m26357a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(str, null);
        String b = AntiHijackUtils.m26482b(str2);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(b)) {
            return 0;
        }
        return string.equals(b) ? 2 : 1;
    }

    /* renamed from: b */
    public static String m26118b(DownloadInfo cVar, NativeDownloadModel aVar) {
        File file = new File(cVar.mo32297k(), cVar.mo32287h());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = C6565j.m26357a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), AppDownloadUtils.m26643a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(cVar.mo32319z())) {
            return cVar.mo32319z();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", cVar.mo32319z());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.m26446a().mo31403a("embeded_ad", "package_name_error", jSONObject, aVar);
        return str;
    }

    /* renamed from: b */
    public void mo31235b() {
        mo31142a(5);
    }

    /* renamed from: c */
    public void mo31237c() {
        mo31142a(6);
    }

    /* renamed from: a */
    public void mo31142a(int i) {
        if (!this.f21265b) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f21266c >= 180000) {
                this.f21266c = currentTimeMillis;
                DownloadComponentManager.m26440a().mo31386a(new C6539a(i));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26115a(ConcurrentHashMap<Long, NativeDownloadModel> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (NativeDownloadModel aVar : concurrentHashMap.values()) {
            if (aVar.f21245a.get()) {
                arrayList.add(Long.valueOf(aVar.mo31194a()));
            } else if (aVar.mo31205c() == 1) {
                if (currentTimeMillis - aVar.mo31213e() >= 259200000) {
                    arrayList.add(Long.valueOf(aVar.mo31194a()));
                }
            } else if (aVar.mo31205c() != 2) {
                arrayList.add(Long.valueOf(aVar.mo31194a()));
            } else if (currentTimeMillis - aVar.mo31213e() >= 604800000) {
                arrayList.add(Long.valueOf(aVar.mo31194a()));
            } else if (TextUtils.isEmpty(aVar.mo31210d())) {
                arrayList.add(Long.valueOf(aVar.mo31194a()));
            } else if (C6587g.m26526a(aVar)) {
                if (aVar.mo31223m() == 4) {
                    i = aVar.mo31223m();
                }
                JSONObject a = m26108a(m26105a(String.valueOf(aVar.mo31194a()), aVar.mo31210d()), i);
                m26116a(a, aVar.mo31221k());
                DownloadInfo h = Downloader.m27478a(C6565j.m26357a()).mo31928h(aVar.mo31221k());
                if (h != null) {
                    try {
                        a.put("uninstall_resume_count", h.mo32256bb());
                    } catch (Throwable unused) {
                    }
                }
                AdEventHandler.m26446a().mo31407b(a, aVar);
                arrayList.add(Long.valueOf(aVar.mo31194a()));
                DownloadOptimizationManager.m26213a(aVar);
            }
        }
        ModelManager.m26169a().mo31270a((List<Long>) arrayList);
    }

    /* renamed from: a */
    public void mo31231a(DownloadInfo cVar, AntiHijackAttempt aVar) {
        if (cVar != null && aVar != null && DownloadSetting.m28610a(cVar.mo32283g()).mo32555d("anti_hijack_report_config") != null) {
            m26119b(cVar, aVar);
        }
    }

    /* renamed from: b */
    private void m26119b(DownloadInfo cVar, AntiHijackAttempt aVar) {
        NativeDownloadModel a = ModelManager.m26169a().mo31263a(cVar);
        if (a != null) {
            JSONObject jSONObject = new JSONObject();
            aVar.mo31452a(jSONObject);
            try {
                jSONObject.put("download_id", cVar.mo32283g());
                jSONObject.put(ArgKey.KEY_NAME, cVar.mo32287h());
                jSONObject.put("url", cVar.mo32295j());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            m26116a(jSONObject, cVar.mo32283g());
            AdEventHandler.m26446a().mo31403a("embeded_ad", "anti_hijack_result", jSONObject, a);
        }
    }

    /* renamed from: b */
    public void mo31236b(String str) {
        DownloadComponentManager.m26440a().mo31386a(new C6540b(str));
    }

    /* renamed from: a */
    private JSONObject m26108a(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("scene", Integer.valueOf(i2));
            jSONObject.put("hijack", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo31230a(DownloadInfo cVar, long j, long j2, long j3, long j4, long j5, boolean z) {
        DownloadInfo cVar2 = cVar;
        long j6 = j;
        NativeDownloadModel a = ModelManager.m26169a().mo31263a(cVar);
        if (a == null) {
            C6587g.m26532b();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(((double) j6) / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf(((double) (j2 - j6)) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            AdEventHandler.m26446a().mo31396a(cVar, jSONObject);
            AdEventHandler.m26446a().mo31403a("embeded_ad", "cleanup", jSONObject, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
