package com.p530ss.android.socialbase.appdownloader.p553d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadLaunchResumeListener;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.d.b */
public class DefaultDownloadLaunchHandler implements IDownloadLaunchHandler {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<Integer> f21536a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public BroadcastReceiver f21537b;

    /* renamed from: a */
    public List<String> mo31502a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("application/vnd.android.package-archive");
        return arrayList;
    }

    /* renamed from: a */
    public void mo31503a(final List<DownloadInfo> list) {
        if (DownloadUtils.m28807d()) {
            C6694b.m27379k().execute(new Runnable() {
                public void run() {
                    try {
                        DefaultDownloadLaunchHandler.this.m26765b(list);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            m26765b(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26765b(List<DownloadInfo> list) {
        if (list != null && !list.isEmpty()) {
            IAppDownloadLaunchResumeListener j = AppDownloader.m26714h().mo31496j();
            if (j != null) {
                j.mo31367a(list);
            }
            Context B = C6694b.m27342B();
            if (B != null) {
                boolean a = DownloadUtils.m28773a(B);
                for (DownloadInfo a2 : list) {
                    m26759a(B, a2, a);
                }
                List<Integer> list2 = this.f21536a;
                if (list2 != null && !list2.isEmpty() && this.f21537b == null) {
                    this.f21537b = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            final Context applicationContext = context.getApplicationContext();
                            if (DownloadUtils.m28773a(applicationContext)) {
                                C6704a.m27758b("LaunchResume", "onReceive : wifi connected !!!");
                                C6694b.m27379k().execute(new Runnable() {
                                    public void run() {
                                        try {
                                            if (DefaultDownloadLaunchHandler.this.f21536a != null) {
                                                if (!DefaultDownloadLaunchHandler.this.f21536a.isEmpty()) {
                                                    Integer[] numArr = new Integer[DefaultDownloadLaunchHandler.this.f21536a.size()];
                                                    DefaultDownloadLaunchHandler.this.f21536a.toArray(numArr);
                                                    DefaultDownloadLaunchHandler.this.f21536a.clear();
                                                    for (Integer intValue : numArr) {
                                                        DownloadInfo h = Downloader.m27478a(applicationContext).mo31928h(intValue.intValue());
                                                        if (h != null) {
                                                            if (h.mo32315w() == -5) {
                                                                DefaultDownloadLaunchHandler.this.m26759a(applicationContext, h, true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                try {
                                    applicationContext.unregisterReceiver(DefaultDownloadLaunchHandler.this.f21537b);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                DefaultDownloadLaunchHandler.this.f21537b = null;
                            }
                        }
                    };
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        B.registerReceiver(this.f21537b, intentFilter);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.f21537b = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f0  */
    /* renamed from: a */
    public void m26759a(android.content.Context r24, com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r25, boolean r26) {
        /*
        r23 = this;
        r0 = r23
        r1 = r25
        if (r1 == 0) goto L_0x024c
        boolean r2 = r25.mo32230ag()
        if (r2 != 0) goto L_0x000e
        goto L_0x024c
    L_0x000e:
        int r2 = r25.mo32315w()
        r3 = -5
        java.lang.String r4 = ", canShowNotification = "
        java.lang.String r5 = "LaunchResume"
        r6 = 4622945017495814144(0x4028000000000000, double:12.0)
        r8 = 4634766966517661696(0x4052000000000000, double:72.0)
        r10 = 4704985352480227328(0x414b774000000000, double:3600000.0)
        r13 = 0
        if (r2 != r3) goto L_0x0106
        boolean r3 = r25.mo32206aI()
        if (r3 != 0) goto L_0x0106
        int r2 = r25.mo32283g()
        com.ss.android.socialbase.downloader.k.a r2 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r2)
        java.lang.String r3 = "failed_resume_max_count"
        int r3 = r2.mo32547a(r3, r13)
        java.lang.String r14 = "failed_resume_max_hours"
        double r8 = r2.mo32546a(r14, r8)
        java.lang.String r14 = "failed_resume_min_hours"
        double r6 = r2.mo32546a(r14, r6)
        long r14 = java.lang.System.currentTimeMillis()
        int r13 = r25.mo32223aZ()
        if (r13 >= r3) goto L_0x0069
        long r16 = r25.mo32258bd()
        long r12 = r14 - r16
        double r12 = (double) r12
        double r8 = r8 * r10
        int r16 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
        if (r16 >= 0) goto L_0x0069
        long r8 = r25.mo32255ba()
        long r8 = r14 - r8
        double r8 = (double) r8
        double r6 = r6 * r10
        int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
        if (r10 <= 0) goto L_0x0069
        r6 = 1
        goto L_0x006a
    L_0x0069:
        r6 = 0
    L_0x006a:
        if (r6 == 0) goto L_0x00d0
        java.lang.String r7 = "failed_resume_need_wifi"
        r3 = 1
        int r7 = r2.mo32547a(r7, r3)
        if (r7 != r3) goto L_0x0077
        r7 = 1
        goto L_0x0078
    L_0x0077:
        r7 = 0
    L_0x0078:
        java.lang.String r8 = "failed_resume_need_wait_wifi"
        r9 = 0
        int r2 = r2.mo32547a(r8, r9)
        if (r2 != r3) goto L_0x0083
        r2 = 1
        goto L_0x0084
    L_0x0083:
        r2 = 0
    L_0x0084:
        if (r26 != 0) goto L_0x00bb
        if (r7 == 0) goto L_0x00bb
        if (r2 != 0) goto L_0x008b
        goto L_0x00bb
    L_0x008b:
        java.util.List<java.lang.Integer> r2 = r0.f21536a
        if (r2 != 0) goto L_0x0096
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
        r0.f21536a = r2
    L_0x0096:
        int r2 = r25.mo32283g()
        java.util.List<java.lang.Integer> r7 = r0.f21536a
        java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
        boolean r7 = r7.contains(r8)
        if (r7 != 0) goto L_0x00af
        java.util.List<java.lang.Integer> r7 = r0.f21536a
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        r7.add(r2)
    L_0x00af:
        r2 = 1
        r1.mo32266c(r2)
        com.ss.android.socialbase.downloader.impls.r r2 = com.p530ss.android.socialbase.downloader.impls.RetryScheduler.m28554a()
        r2.mo32528a(r1)
        goto L_0x00d0
    L_0x00bb:
        r2 = 1
        r0.m26762a(r1, r6, r7)
        r1.mo32275e(r14)
        int r3 = r25.mo32223aZ()
        int r7 = r3 + 1
        r1.mo32288h(r7)
        r25.mo32221aX()
        r3 = 1
        goto L_0x00d1
    L_0x00d0:
        r3 = 0
    L_0x00d1:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r7 = "launchResume, name = "
        r2.append(r7)
        java.lang.String r7 = r25.mo32291i()
        r2.append(r7)
        r2.append(r4)
        r2.append(r6)
        java.lang.String r4 = ", downloadResumed = "
        r2.append(r4)
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c(r5, r2)
        com.ss.android.socialbase.appdownloader.d r2 = com.p530ss.android.socialbase.appdownloader.AppDownloader.m26714h()
        com.ss.android.socialbase.appdownloader.c.g r2 = r2.mo31496j()
        if (r2 == 0) goto L_0x024c
        r2.mo31366a(r1, r3)
        goto L_0x024c
    L_0x0106:
        r12 = -3
        if (r2 != r12) goto L_0x024c
        boolean r2 = r0.m26763a(r1)
        if (r2 == 0) goto L_0x024c
        com.ss.android.socialbase.appdownloader.d r2 = com.p530ss.android.socialbase.appdownloader.AppDownloader.m26714h()
        com.ss.android.socialbase.appdownloader.c.i r2 = r2.mo31497k()
        int r12 = r25.mo32283g()
        com.ss.android.socialbase.downloader.k.a r12 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r12)
        java.lang.String r13 = "back_fix_sigbus"
        r14 = 0
        int r13 = r12.mo32547a(r13, r14)
        if (r13 != 0) goto L_0x0162
        if (r2 == 0) goto L_0x0162
        boolean r2 = r2.mo31408a()
        if (r2 == 0) goto L_0x0162
        java.lang.String r2 = "bugfix_sigbus_all_brand"
        int r2 = r12.mo32547a(r2, r14)
        r3 = 1
        if (r2 == r3) goto L_0x013f
        boolean r2 = com.p530ss.android.socialbase.downloader.p569m.C6792i.m28932b()
        if (r2 == 0) goto L_0x0162
    L_0x013f:
        int r2 = android.os.Build.VERSION.SDK_INT
        r13 = 21
        if (r2 < r13) goto L_0x0162
        r13 = 25
        if (r2 > r13) goto L_0x0162
        boolean r2 = com.p530ss.android.socialbase.downloader.p569m.SystemUtils.m28952a()
        if (r2 == 0) goto L_0x0162
        java.lang.String r2 = r25.mo32297k()
        java.io.File r13 = android.os.Environment.getDataDirectory()
        java.lang.String r13 = r13.getAbsolutePath()
        boolean r2 = r2.startsWith(r13)
        if (r2 != 0) goto L_0x0162
        return
    L_0x0162:
        java.lang.String r2 = r25.mo32297k()
        java.lang.String r13 = r25.mo32287h()
        java.lang.StringBuilder r14 = new java.lang.StringBuilder
        r14.<init>()
        java.lang.String r15 = "url: "
        r14.append(r15)
        java.lang.String r15 = r25.mo32295j()
        r14.append(r15)
        java.lang.String r15 = ", backupUrl: "
        r14.append(r15)
        java.lang.String r15 = r25.mo32165K()
        r14.append(r15)
        java.lang.String r14 = r14.toString()
        r15 = r24
        boolean r2 = com.p530ss.android.socialbase.appdownloader.AppDownloadUtils.m26658a(r15, r2, r13, r14)
        if (r2 == 0) goto L_0x0194
        return
    L_0x0194:
        java.lang.String r2 = "uninstall_resume_max_count"
        r13 = 0
        int r2 = r12.mo32547a(r2, r13)
        java.lang.String r13 = "uninstall_resume_max_hours"
        double r8 = r12.mo32546a(r13, r8)
        java.lang.String r13 = "uninstall_resume_min_hours"
        double r6 = r12.mo32546a(r13, r6)
        long r12 = java.lang.System.currentTimeMillis()
        int r14 = r25.mo32256bb()
        if (r14 >= r2) goto L_0x01ce
        long r16 = r25.mo32258bd()
        r2 = r4
        long r3 = r12 - r16
        double r3 = (double) r3
        double r8 = r8 * r10
        int r14 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
        if (r14 >= 0) goto L_0x01cf
        long r3 = r25.mo32257bc()
        long r3 = r12 - r3
        double r3 = (double) r3
        double r6 = r6 * r10
        int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
        if (r8 <= 0) goto L_0x01cf
        r3 = 1
        goto L_0x01d0
    L_0x01ce:
        r2 = r4
    L_0x01cf:
        r3 = 0
    L_0x01d0:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r6 = "uninstallResume, name = "
        r4.append(r6)
        java.lang.String r6 = r25.mo32291i()
        r4.append(r6)
        r4.append(r2)
        r4.append(r3)
        java.lang.String r2 = r4.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c(r5, r2)
        if (r3 == 0) goto L_0x024c
        com.ss.android.socialbase.downloader.notification.b r2 = com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager.m28984a()
        int r3 = r25.mo32283g()
        com.ss.android.socialbase.downloader.notification.a r2 = r2.mo32647e(r3)
        if (r2 != 0) goto L_0x0223
        com.ss.android.socialbase.appdownloader.e r2 = new com.ss.android.socialbase.appdownloader.e
        int r18 = r25.mo32283g()
        java.lang.String r19 = r25.mo32291i()
        java.lang.String r20 = r25.mo32297k()
        java.lang.String r21 = r25.mo32287h()
        java.lang.String r22 = r25.mo32318y()
        r16 = r2
        r17 = r24
        r16.m51390init(r17, r18, r19, r20, r21, r22)
        com.ss.android.socialbase.downloader.notification.b r3 = com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager.m28984a()
        r3.mo32642a(r2)
        goto L_0x0226
    L_0x0223:
        r2.mo31508a(r1)
    L_0x0226:
        long r3 = r25.mo32225ab()
        r2.mo32631b(r3)
        long r3 = r25.mo32225ab()
        r2.mo32626a(r3)
        int r3 = r25.mo32308q()
        r4 = 0
        r5 = 0
        r2.mo32625a(r3, r4, r5, r5)
        r1.mo32280f(r12)
        int r2 = r25.mo32256bb()
        r3 = 1
        int r2 = r2 + r3
        r1.mo32292i(r2)
        r25.mo32221aX()
    L_0x024c:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.p553d.DefaultDownloadLaunchHandler.m26759a(android.content.Context, com.ss.android.socialbase.downloader.g.c, boolean):void");
    }

    /* renamed from: a */
    private boolean m26763a(DownloadInfo cVar) {
        if (DownloadSetting.m28610a(cVar.mo32283g()).mo32552b("uninstall_can_not_resume_for_force_task", false)) {
            return DownloadUtils.m28777a(cVar, false, cVar.mo32155A());
        }
        return cVar.mo32206aI();
    }

    /* renamed from: a */
    private void m26762a(DownloadInfo cVar, boolean z, boolean z2) {
        AppTaskBuilder a = new AppTaskBuilder(C6694b.m27342B(), cVar.mo32295j()).mo31566a(cVar.mo32291i()).mo31572b(cVar.mo32287h()).mo31576c(cVar.mo32297k()).mo31569a(cVar.mo32230ag());
        boolean z3 = cVar.mo32317x() || z2;
        AppDownloader.m26714h().mo31473a(a.mo31577c(z3).mo31580d(cVar.mo32318y()).mo31583e(cVar.mo32231ah()).mo31567a(cVar.mo32156B()).mo31584e(true).mo31559a(cVar.mo32158D()).mo31571b(cVar.mo32159E()).mo31573b(cVar.mo32200aC()).mo31575c(cVar.mo32204aG()).mo31579d(cVar.mo32203aF()).mo31587f(z).mo31581d(cVar.mo32232ai()).mo31586f(cVar.mo32319z()).mo31589g(cVar.mo32155A()).mo31595i(cVar.mo32306o()).mo31597j(cVar.mo32173S()).mo31601l(cVar.mo32174T()).mo31560a(cVar.mo32309r()).mo31605n(cVar.mo32179Y()).mo31603m(cVar.mo32175U()).mo31590g(cVar.mo32233aj()).mo31592h(cVar.mo32234ak()).mo31568a(m26758a(cVar.mo32167M())));
    }

    /* renamed from: a */
    private JSONObject m26758a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
