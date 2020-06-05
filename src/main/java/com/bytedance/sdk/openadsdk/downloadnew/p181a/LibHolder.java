package com.bytedance.sdk.openadsdk.downloadnew.p181a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager;
import com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.C2417a;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibAppStatus;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibNetwork;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibPermission;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibSettings;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibUIFactory;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibUrlConnection4DZ;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import com.bytedance.sdk.openadsdk.utils.FreeSpaceHelper;
import com.p530ss.android.downloadlib.TTDownloader;
import com.p530ss.android.downloadlib.p541a.p542a.AdDownloadDialogManager;
import com.p530ss.android.p531a.p532a.DownloadConfigure;
import com.p530ss.android.p531a.p532a.p533a.AppStatusChangeListener;
import com.p530ss.android.p531a.p532a.p533a.DownloadEventLogger;
import com.p530ss.android.p531a.p532a.p533a.DownloadNetworkFactory;
import com.p530ss.android.p531a.p532a.p533a.DownloadPermissionChecker;
import com.p530ss.android.p531a.p532a.p533a.DownloadSettings;
import com.p530ss.android.p531a.p532a.p533a.DownloadUIFactory;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p534b.p535a.DownloadCompletedListener;
import com.p530ss.android.p531a.p532a.p536c.C6512a.C6513a;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpService;
import com.tencent.mid.core.Constants;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.d */
public final class LibHolder {
    /* renamed from: a */
    public static volatile String f8618a;
    /* renamed from: b */
    private static final AtomicBoolean f8619b = new AtomicBoolean(false);
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static Context f8620c;
    /* renamed from: d */
    private static Map<Integer, C2417a> f8621d;
    /* renamed from: e */
    private static boolean f8622e = true;
    /* renamed from: f */
    private static AtomicBoolean f8623f = new AtomicBoolean(false);
    /* renamed from: g */
    private static DownloadCompletedListener f8624g = new DownloadCompletedListener() {
        /* renamed from: a */
        public void mo16552a(C6507c cVar, DownloadController aVar, DownloadEventConfig bVar) {
            C2564t.m12220b("LibHolder", "completeListener: onDownloadStart");
        }

        /* renamed from: a */
        public void mo16555a(DownloadInfo cVar, String str) {
            C2564t.m12220b("LibHolder", "completeListener: onDownloadFinished");
        }

        /* renamed from: b */
        public void mo16556b(DownloadInfo cVar, String str) {
            String str2 = "LibHolder";
            C2564t.m12220b(str2, "completeListener: onInstalled");
            try {
                if (InternalContainer.m10069h().mo15765M()) {
                    AdDownloadDialogManager.m26137a().mo31251b(LibHolder.f8620c);
                }
            } catch (Throwable th) {
                C2564t.m12221b(str2, "show market open app error: ", th);
            }
        }

        /* renamed from: a */
        public void mo16554a(DownloadInfo cVar, BaseException aVar, String str) {
            C2564t.m12220b("LibHolder", "completeListener: onDownloadFailed");
        }

        /* renamed from: a */
        public void mo16553a(DownloadInfo cVar) {
            C2564t.m12220b("LibHolder", "completeListener: onCanceled");
        }
    };

    static {
        try {
            f8618a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private static Context m11237g() {
        Context context = f8620c;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* renamed from: a */
    public static void m11227a(Context context) {
        if (context == null) {
            context = InternalContainer.m10059a();
        }
        if (context != null) {
            f8620c = context.getApplicationContext();
            m11224a();
            if (!f8619b.get()) {
                synchronized (LibHolder.class) {
                    if (!f8619b.get()) {
                        f8619b.set(m11231b(f8620c));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m11224a() {
        String str;
        String str2 = null;
        try {
            str = "LibHolder";
            if (f8622e) {
                if (!m11230b()) {
                    File file = new File(m11237g().getCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                    file.mkdirs();
                    str2 = file.getPath();
                    if (!TextUtils.isEmpty(str2)) {
                        Runtime runtime = Runtime.getRuntime();
                        StringBuilder sb = new StringBuilder();
                        sb.append("chmod 777 ");
                        sb.append(str2);
                        runtime.exec(sb.toString());
                    }
                }
            }
        } catch (Throwable unused) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalFilesDir = m11237g().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (externalFilesDir != null) {
                    str2 = externalFilesDir.getPath();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                File file2 = new File(m11237g().getFilesDir(), Environment.DIRECTORY_DOWNLOADS);
                file2.mkdirs();
                str2 = file2.getPath();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            f8618a = str2;
            FreeSpaceHelper.m12182a();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("path: ");
        sb2.append(String.valueOf(f8618a));
        C2564t.m12220b(str, sb2.toString());
    }

    /* renamed from: b */
    public static boolean m11230b() {
        if (VERSION.SDK_INT >= 23) {
            return PermissionsManager.m9560a().mo15632a(m11237g(), Constants.PERMISSION_WRITE_EXTERNAL_STORAGE);
        }
        return true;
    }

    /* renamed from: c */
    public static void m11232c() {
        TTSdkSettings h = InternalContainer.m10069h();
        if (h != null) {
            boolean F = h.mo15758F();
            if (f8622e != F) {
                f8622e = F;
                m11224a();
            }
        }
        try {
            DownloadConfigure a = m11234d().mo31429a();
            if (a != null) {
                a.mo31024a((DownloadSettings) LibSettings.m11098a(InternalContainer.m10059a()));
            }
        } catch (Throwable th) {
            C2564t.m12223c("LibHolder", "sync config error: ", th);
        }
    }

    /* renamed from: d */
    public static TTDownloader m11234d() {
        if (!f8619b.get()) {
            m11231b(InternalContainer.m10059a());
        }
        return TTDownloader.m26565a(m11237g());
    }

    /* renamed from: e */
    public static void m11235e() {
        m11234d().mo31441g();
        if (!TextUtils.isEmpty(f8618a)) {
            FileUtils.m12176c(new File(f8618a));
        }
    }

    /* renamed from: a */
    public static void m11225a(int i) {
        Map<Integer, C2417a> map = f8621d;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public static void m11226a(int i, C2417a aVar) {
        if (aVar != null) {
            if (f8621d == null) {
                f8621d = Collections.synchronizedMap(new WeakHashMap());
            }
            f8621d.put(Integer.valueOf(i), aVar);
        }
    }

    /* renamed from: h */
    private static Map<Integer, C2417a> m11238h() {
        return f8621d;
    }

    /* renamed from: a */
    public static boolean m11229a(String str, String str2, MaterialMeta kVar, Object obj) {
        boolean z;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && kVar != null) {
            Map h = m11238h();
            if (h != null) {
                for (Entry entry : h.entrySet()) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    C2417a aVar = (C2417a) entry.getValue();
                    if (aVar != null) {
                        boolean a = aVar.mo14872a(intValue, kVar, str, str2, obj);
                        if (!z2 && !a) {
                            z2 = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m11228a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> b = AppDownloader.m26714h().mo31486b(context);
            if (!b.isEmpty()) {
                for (DownloadInfo cVar : b) {
                    if (cVar != null && str.equals(cVar.mo32295j())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private LibHolder() {
    }

    /* renamed from: b */
    private static boolean m11231b(Context context) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        m11239i();
        DownloadConfigure a = TTDownloader.m26565a(applicationContext).mo31429a();
        if (a == null) {
            return false;
        }
        DownloadConfigure a2 = a.mo31023a((DownloadPermissionChecker) new LibPermission(applicationContext)).mo31021a((DownloadEventLogger) new LibEventLogger(applicationContext)).mo31025a((DownloadUIFactory) new LibUIFactory(applicationContext)).mo31022a((DownloadNetworkFactory) new LibNetwork(applicationContext)).mo31024a((DownloadSettings) LibSettings.m11098a(applicationContext)).mo31020a((AppStatusChangeListener) new LibAppStatus(applicationContext)).mo31026a(new C6513a().mo31097b("143").mo31095a("open_news").mo31098c("2.9.5.5").mo31099d(String.valueOf(2955)).mo31096a());
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(".TTFileProvider");
        a2.mo31027a(sb.toString());
        AppDownloader.m26714h().mo31484a(true);
        m11233c(applicationContext);
        TTDownloader.m26565a(applicationContext).mo31438d().mo31142a(1);
        if (!f8623f.getAndSet(true)) {
            m11234d().mo31431a(f8624g);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* renamed from: i */
    private static void m11239i() {
        /*
        r0 = 0
        r1 = 5
        r2 = 2
        com.bytedance.sdk.openadsdk.core.h.l r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10069h()     // Catch:{ all -> 0x0018 }
        if (r3 == 0) goto L_0x0018
        boolean r4 = r3.mo15759G()     // Catch:{ all -> 0x0018 }
        int r1 = r3.mo15760H()     // Catch:{ all -> 0x0016 }
        int r2 = r3.mo15761I()     // Catch:{ all -> 0x0016 }
        goto L_0x0019
        goto L_0x0019
    L_0x0018:
        r4 = 0
    L_0x0019:
        if (r4 != 0) goto L_0x001c
        goto L_0x001d
    L_0x001c:
        r0 = r2
    L_0x001d:
        r2 = 60000(0xea60, float:8.4078E-41)
        int r1 = r1 * r2
        com.ss.android.socialbase.appdownloader.d r2 = com.p530ss.android.socialbase.appdownloader.AppDownloader.m26714h()
        r2.mo31487b(r0)
        com.ss.android.socialbase.appdownloader.d r2 = com.p530ss.android.socialbase.appdownloader.AppDownloader.m26714h()
        r2.mo31477a(r0)
        com.ss.android.socialbase.appdownloader.d r2 = com.p530ss.android.socialbase.appdownloader.AppDownloader.m26714h()
        long r3 = (long) r1
        r2.mo31478a(r3)
        com.ss.android.socialbase.appdownloader.d r2 = com.p530ss.android.socialbase.appdownloader.AppDownloader.m26714h()
        r2.mo31488b(r3)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "count="
        r2.append(r3)
        r2.append(r0)
        java.lang.String r0 = ", time="
        r2.append(r0)
        r2.append(r1)
        java.lang.String r0 = r2.toString()
        java.lang.String r1 = "LibHolder"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder.m11239i():void");
    }

    /* renamed from: c */
    private static void m11233c(Context context) {
        TTSdkSettings h = InternalContainer.m10069h();
        if (h != null) {
            Downloader.m27479a(new DownloaderBuilder(context).mo31937a(LibSettings.m11098a(context).mo16485a()).mo31935a(h.mo15764L()).mo31936a((IDownloadHttpService) new LibUrlConnection4DZ(context)));
        }
    }
}
