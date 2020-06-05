package com.p530ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.p530ss.android.socialbase.downloader.p557b.DownloadStatus;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService */
public class DownloadHandlerService extends Service {
    /* renamed from: a */
    private static final String f21463a = DownloadHandlerService.class.getSimpleName();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C6694b.m27353a((Context) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (C6704a.m27756a()) {
            C6704a.m27758b(f21463a, "onStartCommand");
        }
        m26585a(intent);
        stopSelf();
        return 2;
    }

    /* renamed from: a */
    private boolean m26585a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        int intExtra2 = intent.getIntExtra("extra_click_download_type", 0);
        IDownloadNotificationEventListener i = Downloader.m27478a((Context) this).mo31929i(intExtra);
        String str = "android.ss.intent.action.DOWNLOAD_DELETE";
        String str2 = "";
        if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN") || action.equals(str) || action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            m26582a((Context) this, intent);
            if (action.equals(str)) {
                DownloadInfo h = Downloader.m27478a((Context) this).mo31928h(intExtra);
                if (h != null) {
                    h.mo32170P();
                    if (b != null) {
                        int i2 = intExtra;
                        b.mo31368a(i2, 7, "", h.mo32308q(), h.mo32246aw());
                    }
                    if (i != null) {
                        i.mo31500a(7, h, str2, str2);
                    }
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK")) {
            DownloadInfo h2 = Downloader.m27478a((Context) this).mo31928h(intExtra);
            if (h2 == null) {
                return false;
            }
            int q = h2.mo32308q();
            if (q == 0) {
                return false;
            }
            if (intExtra2 == 1 || intExtra2 == 4) {
                if (DownloadStatus.m26982b(q)) {
                    Downloader.m27478a((Context) this).mo31914a(intExtra);
                    if (b != null) {
                        int i3 = intExtra;
                        b.mo31368a(i3, 5, "", h2.mo32308q(), h2.mo32246aw());
                    }
                    if (i != null) {
                        i.mo31500a(5, h2, str2, str2);
                    }
                } else if (q == -3) {
                    AppDownloadUtils.m26645a((Context) this, intExtra, true);
                    m26583a(b, h2);
                }
            } else if (intExtra2 == 2) {
                if (q == -3) {
                    AppDownloadUtils.m26645a((Context) this, intExtra, true);
                    m26583a(b, h2);
                } else {
                    Downloader.m27478a((Context) this).mo31922c(intExtra);
                    if (b != null) {
                        int i4 = intExtra;
                        b.mo31368a(i4, 6, "", h2.mo32308q(), h2.mo32246aw());
                    }
                    if (i != null) {
                        i.mo31500a(6, h2, str2, str2);
                    }
                }
            } else if (intExtra2 != 3) {
                m26584a(h2, b, i);
            } else if (q == -1 || q == -4) {
                Downloader.m27478a((Context) this).mo31925e(intExtra);
            } else if (q == -3) {
                AppDownloadUtils.m26645a((Context) this, intExtra, true);
                m26583a(b, h2);
            }
            if (h2.mo32199aB()) {
                DownloadNotificationManager.m28984a().mo32639a(intExtra);
                DownloadNotificationManager.m28984a().mo32648f(intExtra);
            }
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            C6694b.m27379k().execute(new Runnable() {
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plugin");
                        Downloader.m27478a(C6694b.m27342B()).mo31917a((List<String>) arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m26583a(final IAppDownloadEventHandler dVar, final DownloadInfo cVar) {
        if (cVar != null) {
            final IDownloadNotificationEventListener i = Downloader.m27478a((Context) this).mo31929i(cVar.mo32283g());
            if (dVar != null || i != null) {
                C6694b.m27379k().execute(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[Catch:{ Exception -> 0x005a }] */
                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051 A[Catch:{ Exception -> 0x005a }] */
                    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
                    public void run() {
                        /*
                        r10 = this;
                        java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x005f }
                        com.ss.android.socialbase.downloader.g.c r1 = r5     // Catch:{ Exception -> 0x005f }
                        java.lang.String r1 = r1.mo32297k()     // Catch:{ Exception -> 0x005f }
                        com.ss.android.socialbase.downloader.g.c r2 = r5     // Catch:{ Exception -> 0x005f }
                        java.lang.String r2 = r2.mo32287h()     // Catch:{ Exception -> 0x005f }
                        r0.<init>(r1, r2)     // Catch:{ Exception -> 0x005f }
                        boolean r1 = r0.exists()     // Catch:{ Exception -> 0x005f }
                        if (r1 == 0) goto L_0x0063
                        android.content.Context r1 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27342B()     // Catch:{ Exception -> 0x005a }
                        java.lang.String r2 = ""
                        if (r1 == 0) goto L_0x0034
                        android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x005a }
                        java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x005a }
                        int r3 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26643a()     // Catch:{ Exception -> 0x005a }
                        android.content.pm.PackageInfo r0 = r1.getPackageArchiveInfo(r0, r3)     // Catch:{ Exception -> 0x005a }
                        if (r0 == 0) goto L_0x0034
                        java.lang.String r0 = r0.packageName     // Catch:{ Exception -> 0x005a }
                        goto L_0x0035
                    L_0x0034:
                        r0 = r2
                    L_0x0035:
                        com.ss.android.socialbase.appdownloader.c.d r1 = r4     // Catch:{ Exception -> 0x005a }
                        if (r1 == 0) goto L_0x004d
                        com.ss.android.socialbase.appdownloader.c.d r3 = r4     // Catch:{ Exception -> 0x005a }
                        com.ss.android.socialbase.downloader.g.c r1 = r5     // Catch:{ Exception -> 0x005a }
                        int r4 = r1.mo32283g()     // Catch:{ Exception -> 0x005a }
                        r5 = 3
                        r7 = -3
                        com.ss.android.socialbase.downloader.g.c r1 = r5     // Catch:{ Exception -> 0x005a }
                        long r8 = r1.mo32246aw()     // Catch:{ Exception -> 0x005a }
                        r6 = r0
                        r3.mo31368a(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005a }
                    L_0x004d:
                        com.ss.android.socialbase.downloader.d.ag r1 = r0     // Catch:{ Exception -> 0x005a }
                        if (r1 == 0) goto L_0x0063
                        com.ss.android.socialbase.downloader.d.ag r1 = r0     // Catch:{ Exception -> 0x005a }
                        r3 = 3
                        com.ss.android.socialbase.downloader.g.c r4 = r5     // Catch:{ Exception -> 0x005a }
                        r1.mo31500a(r3, r4, r0, r2)     // Catch:{ Exception -> 0x005a }
                        goto L_0x0063
                    L_0x005a:
                        r0 = move-exception
                        r0.printStackTrace()     // Catch:{ Exception -> 0x005f }
                        goto L_0x0063
                    L_0x005f:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x0063:
                        return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.DownloadHandlerService.C65962.run():void");
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m26582a(Context context, Intent intent) {
        String str = "extra_click_download_ids";
        String action = intent.getAction();
        boolean z = false;
        try {
            int intExtra = intent.getIntExtra(str, 0);
            boolean booleanExtra = intent.getBooleanExtra("extra_from_notification", false);
            if ("android.ss.intent.action.DOWNLOAD_DELETE".equals(action)) {
                if (booleanExtra) {
                    INotificationClickCallback l = DownloadProcessDispatcher.m27395a().mo31883l(intExtra);
                    if (l == null) {
                        l = C6694b.m27393y();
                    }
                    if (l != null) {
                        try {
                            DownloadInfo h = Downloader.m27478a(context).mo31928h(intExtra);
                            if (h != null) {
                                z = l.mo31751a(h);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (!z) {
                    Intent intent2 = new Intent(context, DownloadTaskDeleteActivity.class);
                    intent2.putExtra(str, intExtra);
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                    DownloadNotificationManager.m28984a().mo32639a(intExtra);
                }
            } else if ("android.ss.intent.action.DOWNLOAD_OPEN".equals(action)) {
                m26581a(context, intExtra, booleanExtra);
                IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
                IDownloadNotificationEventListener i = Downloader.m27478a((Context) this).mo31929i(intExtra);
                if (!(b == null && i == null)) {
                    DownloadInfo h2 = Downloader.m27478a((Context) this).mo31928h(intExtra);
                    if (h2 != null) {
                        m26583a(b, h2);
                    }
                }
                boolean z2 = true;
                if (DownloadSetting.m28610a(intExtra).mo32547a("notification_click_install_auto_cancel", 1) == 0) {
                    AbsNotificationItem e = DownloadNotificationManager.m28984a().mo32647e(intExtra);
                    if (e != null) {
                        e.mo32636g();
                        e.mo32625a(-3, null, false, true);
                        z2 = false;
                    }
                }
                if (z2) {
                    DownloadNotificationManager.m28984a().mo32639a(intExtra);
                }
            } else if ("android.ss.intent.action.DOWNLOAD_HIDE".equals(action)) {
                DownloadNotificationManager.m28984a().mo32639a(intExtra);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m26581a(Context context, int i, boolean z) {
        boolean z2;
        if (z) {
            INotificationClickCallback l = DownloadProcessDispatcher.m27395a().mo31883l(i);
            if (l != null) {
                try {
                    DownloadInfo h = Downloader.m27478a(context).mo31928h(i);
                    if (h != null) {
                        z2 = l.mo31752b(h);
                        if (!z2 && AppDownloadUtils.m26645a(context, i, true) == 0) {
                            Toast.makeText(context, "Open Fail!", 0).show();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        z2 = false;
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    /* renamed from: a */
    private void m26584a(DownloadInfo cVar, IAppDownloadEventHandler dVar, IDownloadNotificationEventListener agVar) {
        int g = cVar.mo32283g();
        String str = "";
        switch (cVar.mo32308q()) {
            case -4:
            case -1:
                Downloader.m27478a((Context) this).mo31925e(g);
                return;
            case -3:
                AppDownloadUtils.m26645a((Context) this, g, true);
                m26583a(dVar, cVar);
                return;
            case -2:
                Downloader.m27478a((Context) this).mo31922c(g);
                if (dVar != null) {
                    IAppDownloadEventHandler dVar2 = dVar;
                    dVar2.mo31368a(g, 6, "", cVar.mo32308q(), cVar.mo32246aw());
                }
                if (agVar != null) {
                    agVar.mo31500a(6, cVar, str, str);
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.m27478a((Context) this).mo31914a(g);
                if (dVar != null) {
                    IAppDownloadEventHandler dVar3 = dVar;
                    dVar3.mo31368a(g, 5, "", cVar.mo32308q(), cVar.mo32246aw());
                }
                if (agVar != null) {
                    agVar.mo31500a(5, cVar, str, str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
