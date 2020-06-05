package com.p530ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.p530ss.android.socialbase.appdownloader.p551b.Constants;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadDepend;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventListener;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadFileUriProvider;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadLaunchResumeListener;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadMonitorListener;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppStatusChangeListener;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadNotificationBuilder;
import com.p530ss.android.socialbase.appdownloader.p553d.DefaultDownloadLaunchHandler;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.d */
public class AppDownloader {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f21509a = AppDownloader.class.getSimpleName();
    /* renamed from: b */
    private static volatile AppDownloader f21510b = null;
    /* renamed from: l */
    private static boolean f21511l = false;
    /* renamed from: m */
    private static boolean f21512m = false;
    /* renamed from: c */
    private IAppDownloadDepend f21513c;
    /* renamed from: d */
    private IAppDownloadEventHandler f21514d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public IAppDownloadMonitorListener f21515e;
    /* renamed from: f */
    private IAppDownloadLaunchResumeListener f21516f;
    /* renamed from: g */
    private IDownloadNotificationBuilder f21517g;
    /* renamed from: h */
    private IAppStatusChangeListener f21518h;
    /* renamed from: i */
    private String f21519i;
    /* renamed from: j */
    private String f21520j;
    /* renamed from: k */
    private DownloadReceiver f21521k;
    /* renamed from: n */
    private boolean f21522n = false;
    /* renamed from: o */
    private boolean f21523o = true;
    /* renamed from: p */
    private IAppDownloadFileUriProvider f21524p;
    /* renamed from: q */
    private String f21525q;

    /* renamed from: a */
    public IAppDownloadDepend mo31474a() {
        return this.f21513c;
    }

    /* renamed from: b */
    public IAppDownloadEventHandler mo31485b() {
        return this.f21514d;
    }

    /* renamed from: a */
    public void mo31483a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f21520j = str;
        }
    }

    /* renamed from: c */
    public String mo31490c() {
        return this.f21520j;
    }

    /* renamed from: d */
    public IAppDownloadFileUriProvider mo31491d() {
        return this.f21524p;
    }

    /* renamed from: a */
    public void mo31484a(boolean z) {
        this.f21523o = z;
    }

    /* renamed from: e */
    public boolean mo31492e() {
        return this.f21523o;
    }

    /* renamed from: f */
    public File mo31493f() {
        File file;
        if (TextUtils.isEmpty(this.f21525q)) {
            return null;
        }
        try {
            file = new File(this.f21525q);
            try {
                if (!file.exists()) {
                    file.mkdirs();
                } else if (!file.isDirectory()) {
                    file.delete();
                    file.mkdirs();
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            file = null;
        }
        return file;
    }

    @Deprecated
    /* renamed from: a */
    public void mo31478a(long j) {
        if (j < 0) {
            j = 0;
        }
        try {
            C6694b.m27390v().put("failed_resume_min_hours", ((double) j) / 3600000.0d);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    /* renamed from: b */
    public void mo31488b(long j) {
        if (j < 0) {
            j = 0;
        }
        try {
            C6694b.m27390v().put("uninstall_resume_min_hours", ((double) j) / 3600000.0d);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    /* renamed from: a */
    public void mo31477a(int i) {
        if (i < 0) {
            i = 0;
        }
        try {
            C6694b.m27390v().put("failed_resume_max_count", i);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    /* renamed from: b */
    public void mo31487b(int i) {
        if (i < 0) {
            i = 0;
        }
        try {
            C6694b.m27390v().put("uninstall_resume_max_count", i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    public String mo31494g() {
        return this.f21519i;
    }

    private AppDownloader() {
    }

    /* renamed from: h */
    public static AppDownloader m26714h() {
        if (f21510b == null) {
            synchronized (AppDownloader.class) {
                if (f21510b == null) {
                    f21510b = new AppDownloader();
                }
            }
        }
        return f21510b;
    }

    @Deprecated
    /* renamed from: a */
    public void mo31480a(Context context, String str, IAppDownloadDepend cVar, IAppDownloadEventHandler dVar, IAppDownloadMonitorListener hVar) {
        if (cVar != null) {
            this.f21513c = cVar;
        }
        if (dVar != null) {
            this.f21514d = dVar;
        }
        if (hVar != null) {
            this.f21515e = hVar;
        }
        if (context != null && !f21511l) {
            C6694b.m27353a(context);
            C6694b.m27362a((IDownloadLaunchHandler) new DefaultDownloadLaunchHandler());
            m26716m();
            f21511l = true;
        }
    }

    /* renamed from: b */
    public void mo31489b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f21525q = str;
        }
    }

    /* renamed from: m */
    private void m26716m() {
        if (!f21512m) {
            if (this.f21521k == null) {
                this.f21521k = new DownloadReceiver();
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter2.addDataScheme("package");
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter3.addDataScheme("file");
                C6694b.m27342B().registerReceiver(this.f21521k, intentFilter);
                C6694b.m27342B().registerReceiver(this.f21521k, intentFilter2);
                C6694b.m27342B().registerReceiver(this.f21521k, intentFilter3);
                f21512m = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static boolean m26712a(Context context, int i) {
        return AppDownloadUtils.m26645a(context, i, true) == 1;
    }

    /* renamed from: a */
    public void mo31479a(Context context, int i, int i2) {
        switch (i2) {
            case -4:
            case -1:
                Downloader.m27478a(context).mo31925e(i);
                return;
            case -3:
                AppDownloadUtils.m26645a(context, i, true);
                return;
            case -2:
                Downloader.m27478a(context).mo31922c(i);
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                try {
                    Downloader.m27478a(context).mo31914a(i);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r12v12, types: [com.ss.android.socialbase.downloader.d.ad] */
    /* JADX WARNING: type inference failed for: r12v13, types: [com.ss.android.socialbase.downloader.d.ad] */
    /* JADX WARNING: type inference failed for: r12v14 */
    /* JADX WARNING: type inference failed for: r12v16, types: [com.ss.android.socialbase.appdownloader.h] */
    /* JADX WARNING: type inference failed for: r12v17 */
    /* JADX WARNING: type inference failed for: r12v18, types: [com.ss.android.socialbase.appdownloader.h] */
    /* JADX WARNING: type inference failed for: r12v27 */
    /* JADX WARNING: type inference failed for: r12v28 */
    /* JADX WARNING: Can't wrap try/catch for region: R(22:41|(2:43|(2:45|46))|47|48|(1:55)(1:54)|56|(2:62|(1:64)(15:66|67|(1:69)|70|71|72|(1:74)(1:75)|76|77|78|(2:80|(1:82)(4:83|85|(1:(1:97)(1:96))|98))|84|85|(0)|98))|65|67|(0)|70|71|72|(0)(0)|76|77|78|(0)|84|85|(0)|98) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00f6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0192 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v14
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0132 A[Catch:{ all -> 0x0028, all -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0141 A[Catch:{ all -> 0x0028, all -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0162 A[Catch:{ all -> 0x0028, all -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0171 A[Catch:{ all -> 0x0192 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0177 A[Catch:{ all -> 0x0192 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0198 A[Catch:{ all -> 0x0028, all -> 0x031b }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02ce A[Catch:{ all -> 0x0028, all -> 0x031b }] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: a */
    public int mo31473a(com.p530ss.android.socialbase.appdownloader.AppTaskBuilder r22) {
        /*
        r21 = this;
        r7 = r21
        r8 = r22
        r9 = 0
        if (r8 == 0) goto L_0x0343
        android.content.Context r0 = r22.mo31570b()
        if (r0 != 0) goto L_0x000f
        goto L_0x0343
    L_0x000f:
        java.util.List r0 = r22.mo31588f()     // Catch:{ all -> 0x031b }
        java.util.List r1 = r7.m26709a(r0)     // Catch:{ all -> 0x031b }
        java.lang.String r2 = r22.mo31578c()     // Catch:{ all -> 0x031b }
        boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x031b }
        if (r0 == 0) goto L_0x0022
        return r9
    L_0x0022:
        int r0 = r7.m26704a(r8, r2)     // Catch:{ all -> 0x0028 }
        r5 = r0
        goto L_0x0042
    L_0x0028:
        r0 = move-exception
        r3 = r0
        java.lang.String r0 = f21509a     // Catch:{ all -> 0x031b }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x031b }
        r4.<init>()     // Catch:{ all -> 0x031b }
        java.lang.String r5 = "redirectSavePathIfEmpty: throwable = "
        r4.append(r5)     // Catch:{ all -> 0x031b }
        r4.append(r3)     // Catch:{ all -> 0x031b }
        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x031b }
        android.util.Log.w(r0, r3)     // Catch:{ all -> 0x031b }
        r0 = 4
        r5 = 4
    L_0x0042:
        java.lang.String r0 = f21509a     // Catch:{ all -> 0x031b }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x031b }
        r3.<init>()     // Catch:{ all -> 0x031b }
        java.lang.String r4 = "antihijackErrorCode = "
        r3.append(r4)     // Catch:{ all -> 0x031b }
        r3.append(r5)     // Catch:{ all -> 0x031b }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x031b }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r0, r3)     // Catch:{ all -> 0x031b }
        if (r5 != 0) goto L_0x005c
        r6 = 1
        goto L_0x005d
    L_0x005c:
        r6 = 0
    L_0x005d:
        java.lang.String r0 = r22.mo31548L()     // Catch:{ all -> 0x031b }
        java.lang.String r3 = r22.mo31582d()     // Catch:{ all -> 0x031b }
        boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x031b }
        if (r4 == 0) goto L_0x0073
        java.lang.String r0 = r22.mo31606n()     // Catch:{ all -> 0x031b }
        java.lang.String r0 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26652a(r2, r3, r0, r6)     // Catch:{ all -> 0x031b }
    L_0x0073:
        int r4 = r0.length()     // Catch:{ all -> 0x031b }
        r12 = 255(0xff, float:3.57E-43)
        if (r4 <= r12) goto L_0x0084
        int r4 = r0.length()     // Catch:{ all -> 0x031b }
        int r4 = r4 - r12
        java.lang.String r0 = r0.substring(r4)     // Catch:{ all -> 0x031b }
    L_0x0084:
        boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x031b }
        if (r4 == 0) goto L_0x008b
        r3 = r0
    L_0x008b:
        java.lang.String r4 = r22.mo31606n()     // Catch:{ all -> 0x031b }
        java.lang.String r12 = ".apk"
        boolean r12 = r0.endsWith(r12)     // Catch:{ all -> 0x031b }
        if (r12 == 0) goto L_0x00a3
        java.lang.String r12 = r22.mo31606n()     // Catch:{ all -> 0x031b }
        boolean r12 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26668d(r12)     // Catch:{ all -> 0x031b }
        if (r12 != 0) goto L_0x00a3
        java.lang.String r4 = "application/vnd.android.package-archive"
    L_0x00a3:
        java.lang.String r12 = r22.mo31585e()     // Catch:{ all -> 0x031b }
        java.lang.String r13 = r22.mo31585e()     // Catch:{ all -> 0x031b }
        boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x031b }
        if (r13 == 0) goto L_0x00b9
        android.content.Context r12 = r22.mo31570b()     // Catch:{ all -> 0x031b }
        java.lang.String r12 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26650a(r12)     // Catch:{ all -> 0x031b }
    L_0x00b9:
        r15 = r12
        boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x031b }
        if (r12 != 0) goto L_0x0319
        boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x031b }
        if (r12 == 0) goto L_0x00c8
        goto L_0x0319
    L_0x00c8:
        int r14 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27348a(r2, r15)     // Catch:{ all -> 0x031b }
        org.json.JSONObject r12 = r22.mo31557U()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.k.a r12 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28613a(r12)     // Catch:{ all -> 0x031b }
        java.lang.String r13 = "resume_task_override_settings"
        boolean r12 = r12.mo32550a(r13)     // Catch:{ all -> 0x031b }
        if (r12 == 0) goto L_0x00f6
        android.content.Context r12 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27342B()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.downloader.f r12 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r12)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.c r12 = r12.mo31928h(r14)     // Catch:{ all -> 0x031b }
        if (r12 == 0) goto L_0x00f6
        org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x00f6 }
        java.lang.String r12 = r12.mo32167M()     // Catch:{ all -> 0x00f6 }
        r13.<init>(r12)     // Catch:{ all -> 0x00f6 }
        r8.mo31568a(r13)     // Catch:{ all -> 0x00f6 }
    L_0x00f6:
        org.json.JSONObject r12 = r22.mo31557U()     // Catch:{ all -> 0x031b }
        com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28615a(r14, r12)     // Catch:{ all -> 0x031b }
        boolean r12 = r22.mo31547K()     // Catch:{ all -> 0x031b }
        if (r12 != 0) goto L_0x0119
        boolean r13 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28808d(r15, r0)     // Catch:{ all -> 0x031b }
        if (r13 == 0) goto L_0x0119
        android.content.Context r13 = r22.mo31570b()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.downloader.f r13 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r13)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.c r13 = r13.mo31928h(r14)     // Catch:{ all -> 0x031b }
        if (r13 != 0) goto L_0x0119
        r13 = 1
        goto L_0x011a
    L_0x0119:
        r13 = r12
    L_0x011a:
        com.ss.android.socialbase.downloader.d.ad r12 = r22.mo31602l()     // Catch:{ all -> 0x031b }
        if (r12 != 0) goto L_0x013b
        boolean r16 = r22.mo31591g()     // Catch:{ all -> 0x031b }
        if (r16 != 0) goto L_0x012c
        boolean r16 = r22.mo31594h()     // Catch:{ all -> 0x031b }
        if (r16 == 0) goto L_0x013b
    L_0x012c:
        com.ss.android.socialbase.downloader.notification.a r12 = r22.mo31608p()     // Catch:{ all -> 0x031b }
        if (r12 == 0) goto L_0x0141
        com.ss.android.socialbase.appdownloader.h r12 = new com.ss.android.socialbase.appdownloader.h     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.notification.a r11 = r22.mo31608p()     // Catch:{ all -> 0x031b }
        r12.m51401init(r11)     // Catch:{ all -> 0x031b }
    L_0x013b:
        r10 = r13
        r19 = r14
        r20 = r15
        goto L_0x015c
    L_0x0141:
        com.ss.android.socialbase.appdownloader.h r11 = new com.ss.android.socialbase.appdownloader.h     // Catch:{ all -> 0x031b }
        android.content.Context r16 = r22.mo31570b()     // Catch:{ all -> 0x031b }
        java.lang.String r18 = r22.mo31604m()     // Catch:{ all -> 0x031b }
        r12 = r11
        r10 = r13
        r13 = r16
        r19 = r14
        r20 = r15
        r15 = r3
        r16 = r20
        r17 = r0
        r12.m51400init(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x031b }
        r12 = r11
    L_0x015c:
        com.ss.android.socialbase.downloader.d.s r11 = r22.mo31550N()     // Catch:{ all -> 0x031b }
        if (r11 != 0) goto L_0x0167
        com.ss.android.socialbase.appdownloader.d$1 r11 = new com.ss.android.socialbase.appdownloader.d$1     // Catch:{ all -> 0x031b }
        r11.m51381init()     // Catch:{ all -> 0x031b }
    L_0x0167:
        java.lang.String r13 = r22.mo31604m()     // Catch:{ all -> 0x031b }
        boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0192 }
        if (r14 != 0) goto L_0x0177
        org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0192 }
        r14.<init>(r13)     // Catch:{ all -> 0x0192 }
        goto L_0x017c
    L_0x0177:
        org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0192 }
        r14.<init>()     // Catch:{ all -> 0x0192 }
    L_0x017c:
        java.lang.String r15 = "auto_install_with_notification"
        boolean r9 = r22.mo31596i()     // Catch:{ all -> 0x0192 }
        r14.put(r15, r9)     // Catch:{ all -> 0x0192 }
        java.lang.String r9 = "auto_install_without_notification"
        boolean r15 = r22.mo31594h()     // Catch:{ all -> 0x0192 }
        r14.put(r9, r15)     // Catch:{ all -> 0x0192 }
        java.lang.String r13 = r14.toString()     // Catch:{ all -> 0x0192 }
    L_0x0192:
        boolean r9 = r22.mo31591g()     // Catch:{ all -> 0x031b }
        if (r9 != 0) goto L_0x01a1
        boolean r9 = r22.mo31594h()     // Catch:{ all -> 0x031b }
        if (r9 == 0) goto L_0x019f
        goto L_0x01a1
    L_0x019f:
        r9 = 0
        goto L_0x01a2
    L_0x01a1:
        r9 = 1
    L_0x01a2:
        android.content.Context r14 = r22.mo31570b()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r14 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27480b(r14)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r2 = r14.mo32395c(r2)     // Catch:{ all -> 0x031b }
        java.util.List r14 = r22.mo31555S()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r2 = r2.mo32385b(r14)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r2.mo32373a(r0)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32384b(r3)     // Catch:{ all -> 0x031b }
        r2 = r20
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32399d(r2)     // Catch:{ all -> 0x031b }
        boolean r2 = r22.mo31598j()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32386b(r2)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32374a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32367a(r11)     // Catch:{ all -> 0x031b }
        int r1 = r22.mo31615w()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32358a(r1)     // Catch:{ all -> 0x031b }
        int r1 = r22.mo31616x()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32381b(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32400d(r9)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32402e(r13)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32405f(r4)     // Catch:{ all -> 0x031b }
        int r1 = r22.mo31540D()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32398d(r1)     // Catch:{ all -> 0x031b }
        int r1 = r22.mo31541E()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32393c(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.d.ad r1 = r22.mo31600k()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32363a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32383b(r12)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.appdownloader.c.e r1 = r22.mo31551O()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.d.ag r1 = r7.m26706a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32365a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32396c(r10)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31611s()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32406f(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31612t()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32409g(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.downloader.i r1 = r22.mo31609q()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32371a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.downloader.h r1 = r22.mo31610r()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32370a(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31607o()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32403e(r1)     // Catch:{ all -> 0x031b }
        java.lang.String r1 = r22.mo31613u()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32408g(r1)     // Catch:{ all -> 0x031b }
        java.lang.String r1 = r22.mo31614v()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32411h(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31617y()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32412h(r1)     // Catch:{ all -> 0x031b }
        java.lang.String r1 = r22.mo31618z()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32414i(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31537A()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32415i(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31538B()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32417j(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31542F()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32421l(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31543G()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32422m(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.b.g r1 = r22.mo31546J()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32360a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.d.ae r1 = r22.mo31549M()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32364a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.downloader.r r1 = r22.mo31539C()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32372a(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31544H()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32425n(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.d.x r1 = r22.mo31552P()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32369a(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.d.w r1 = r22.mo31556T()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32368a(r1)     // Catch:{ all -> 0x031b }
        boolean r1 = r22.mo31545I()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32419k(r1)     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.d.d r1 = r22.mo31553Q()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r0 = r0.mo32366a(r1)     // Catch:{ all -> 0x031b }
        org.json.JSONObject r1 = r22.mo31557U()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.downloader.g.d r4 = r0.mo32375a(r1)     // Catch:{ all -> 0x031b }
        if (r4 == 0) goto L_0x0318
        if (r9 == 0) goto L_0x02fc
        boolean r0 = r22.mo31554R()     // Catch:{ all -> 0x031b }
        if (r0 == 0) goto L_0x02fc
        android.app.Activity r0 = r22.mo31558a()     // Catch:{ all -> 0x031b }
        if (r0 == 0) goto L_0x02fc
        android.app.Activity r0 = r22.mo31558a()     // Catch:{ all -> 0x031b }
        boolean r0 = r0.isFinishing()     // Catch:{ all -> 0x031b }
        if (r0 != 0) goto L_0x02fc
        boolean r0 = com.p530ss.android.socialbase.appdownloader.NotificationPermissionHelper.m26942a()     // Catch:{ all -> 0x031b }
        if (r0 != 0) goto L_0x02fc
        android.app.Activity r0 = r22.mo31558a()     // Catch:{ all -> 0x031b }
        com.ss.android.socialbase.appdownloader.d$2 r9 = new com.ss.android.socialbase.appdownloader.d$2     // Catch:{ all -> 0x031b }
        r1 = r9
        r2 = r21
        r1.m51382init(r3, r4, r5, r6)     // Catch:{ all -> 0x031b }
        com.p530ss.android.socialbase.appdownloader.NotificationPermissionHelper.m26940a(r0, r9)     // Catch:{ all -> 0x031b }
        goto L_0x0318
    L_0x02fc:
        java.lang.String r0 = f21509a     // Catch:{ all -> 0x031b }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x031b }
        r1.<init>()     // Catch:{ all -> 0x031b }
        java.lang.String r2 = "notification permission need not request, start download :"
        r1.append(r2)     // Catch:{ all -> 0x031b }
        r1.append(r3)     // Catch:{ all -> 0x031b }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x031b }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r0, r1)     // Catch:{ all -> 0x031b }
        r7.m26711a(r4, r5, r6)     // Catch:{ all -> 0x031b }
        r4.mo32357a()     // Catch:{ all -> 0x031b }
    L_0x0318:
        return r19
    L_0x0319:
        r1 = 0
        return r1
    L_0x031b:
        r0 = move-exception
        com.ss.android.socialbase.downloader.d.ae r1 = r22.mo31549M()
        com.ss.android.socialbase.downloader.e.a r2 = new com.ss.android.socialbase.downloader.e.a
        r3 = 1003(0x3eb, float:1.406E-42)
        java.lang.String r4 = "addDownloadTask"
        java.lang.String r4 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28786b(r0, r4)
        r2.m51543init(r3, r4)
        r3 = 0
        r4 = 0
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r1, r3, r2, r4)
        java.lang.String r1 = f21509a
        r2 = 1
        java.lang.Object[] r2 = new java.lang.Object[r2]
        r2[r4] = r0
        java.lang.String r0 = "add download task error:%s"
        java.lang.String r0 = java.lang.String.format(r0, r2)
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27762e(r1, r0)
        return r4
    L_0x0343:
        r4 = 0
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.AppDownloader.mo31473a(com.ss.android.socialbase.appdownloader.g):int");
    }

    /* renamed from: a */
    private int m26704a(AppTaskBuilder gVar, String str) {
        C6704a.m27758b(f21509a, "start redirectSavePathIfPossible");
        DownloadSetting a = DownloadSetting.m28613a(gVar.mo31557U());
        JSONObject d = a.mo32555d("anti_hijack_dir");
        boolean z = true;
        boolean z2 = d != null && d.optInt("ignore_task_save_path", 0) == 1;
        String d2 = gVar.mo31582d();
        String L = gVar.mo31548L();
        if (TextUtils.isEmpty(L)) {
            L = AppDownloadUtils.m26652a(str, d2, gVar.mo31606n(), true);
        }
        if (L.length() > 255) {
            L = L.substring(L.length() - 255);
        }
        if (TextUtils.isEmpty(d2)) {
            d2 = L;
        }
        String a2 = AppDownloadUtils.m26651a(gVar.mo31570b(), d2, a);
        String a3 = AppDownloadUtils.m26650a(gVar.mo31570b());
        if (TextUtils.isEmpty(gVar.mo31585e()) || (!gVar.mo31585e().equals(a2) && !gVar.mo31585e().equals(a3))) {
            z = false;
        }
        String str2 = f21509a;
        StringBuilder sb = new StringBuilder();
        sb.append("ignoreTaskSavePath = ");
        sb.append(z2);
        sb.append("\tisSavePathDefaultOrRedirected = ");
        sb.append(z);
        sb.append("\nbuilder.getSavePath = ");
        sb.append(gVar.mo31585e());
        sb.append("\npossibleRedirectSavePath = ");
        sb.append(a2);
        sb.append("\ndefaultSavePath = ");
        sb.append(a3);
        C6704a.m27758b(str2, sb.toString());
        if (z2 || TextUtils.isEmpty(gVar.mo31585e()) || z) {
            DownloadInfo a4 = mo31475a(gVar.mo31570b(), str);
            if (a4 == null || !a4.mo32259be()) {
                if (a4 == null) {
                    if ("application/vnd.android.package-archive".equalsIgnoreCase(m26708a(L, gVar.mo31606n()))) {
                        C6704a.m27758b(f21509a, "relatedUrlDownload is null && mimetype is apk");
                        int a5 = C6604b.m26605a(a);
                        if (a5 == 0) {
                            gVar.mo31576c(a2);
                        }
                        return a5;
                    }
                }
                if (a4 != null) {
                    C6704a.m27758b(f21509a, "relatedUrlDownload is not null");
                    return 8;
                }
                C6704a.m27758b(f21509a, "mimetype is not apk");
                return 9;
            }
            C6704a.m27758b(f21509a, "relatedUrlDownload.isSavePathRedirected is true");
            gVar.mo31576c(a4.mo32297k());
            try {
                gVar.mo31568a(new JSONObject(a4.mo32167M()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        C6704a.m27758b(f21509a, "redirectSavePath error");
        return 7;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26711a(C6712d dVar, int i, boolean z) {
        if (dVar != null) {
            dVar.mo32424n();
            DownloadInfo a = dVar.mo32357a();
            if (a != null) {
                a.mo32298k(i);
            }
            if (a != null && z) {
                a.mo32304m(z);
            }
        }
    }

    /* renamed from: a */
    private List<HttpHeader> m26709a(List<HttpHeader> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        String str = "User-Agent";
        boolean z2 = false;
        if (list != null && list.size() > 0) {
            for (HttpHeader eVar : list) {
                if (eVar != null && !TextUtils.isEmpty(eVar.mo32429a()) && !TextUtils.isEmpty(eVar.mo32430b())) {
                    if (eVar.mo32429a().equals(str)) {
                        z2 = true;
                    }
                    arrayList.add(new HttpHeader(eVar.mo32429a(), eVar.mo32430b()));
                }
            }
        }
        if (!z) {
            arrayList.add(new HttpHeader(str, Constants.f21502a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m26708a(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || AppDownloadUtils.m26668d(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    /* renamed from: a */
    private IDownloadNotificationEventListener m26706a(final IAppDownloadEventListener eVar) {
        if (eVar == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() {
            /* renamed from: a */
            public void mo31500a(int i, DownloadInfo cVar, String str, String str2) {
                if (!(i == 1 || i == 3)) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            eVar.mo31465a(i, cVar.mo32319z(), str, str2);
                            return;
                        case 9:
                            eVar.mo31466a(C6694b.m27342B(), str);
                            return;
                        case 10:
                            eVar.mo31467a(cVar);
                            return;
                        default:
                            return;
                    }
                }
                eVar.mo31464a(i, str, cVar.mo32308q(), cVar.mo32246aw());
            }

            /* renamed from: a */
            public boolean mo31501a(boolean z) {
                return eVar.mo31468a(z);
            }

            /* renamed from: a */
            public String mo31499a() {
                return eVar.mo31463a();
            }
        };
    }

    /* renamed from: a */
    public DownloadInfo mo31475a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo a = m26707a(context, str, mo31493f());
                if (a == null) {
                    a = m26707a(context, str, context.getFilesDir());
                }
                if (a == null) {
                    a = m26707a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                boolean a2 = DownloadSetting.m28617b().mo32550a("get_download_info_by_list");
                if (a == null && a2) {
                    a = m26713b(context, str);
                }
                return a;
            } catch (Throwable th) {
                C6704a.m27758b(f21509a, String.format("getAppDownloadInfo error:%s", new Object[]{th.getMessage()}));
            }
        }
        return null;
    }

    /* renamed from: a */
    private DownloadInfo m26707a(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.m27478a(context).mo31911a(str, file.getAbsolutePath());
    }

    /* renamed from: b */
    private DownloadInfo m26713b(Context context, String str) {
        List<DownloadInfo> a = Downloader.m27478a(context).mo31912a(str);
        if (a != null) {
            for (DownloadInfo cVar : a) {
                if (cVar != null && cVar.mo32259be()) {
                    return cVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31476a(Context context) {
        return Downloader.m27478a(context).mo31921c("application/vnd.android.package-archive");
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31486b(Context context) {
        return Downloader.m27478a(context).mo31923d("application/vnd.android.package-archive");
    }

    /* renamed from: i */
    public IDownloadNotificationBuilder mo31495i() {
        return this.f21517g;
    }

    /* renamed from: j */
    public IAppDownloadLaunchResumeListener mo31496j() {
        return this.f21516f;
    }

    /* renamed from: a */
    public void mo31481a(IAppDownloadLaunchResumeListener gVar) {
        this.f21516f = gVar;
    }

    /* renamed from: a */
    public void mo31482a(IAppStatusChangeListener iVar) {
        this.f21518h = iVar;
    }

    /* renamed from: k */
    public IAppStatusChangeListener mo31497k() {
        return this.f21518h;
    }
}
