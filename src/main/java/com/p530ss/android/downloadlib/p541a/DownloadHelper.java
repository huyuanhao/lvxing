package com.p530ss.android.downloadlib.p541a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.DownloadDispatcherImpl;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager.C6546a;
import com.p530ss.android.downloadlib.p541a.p544c.AppDownloadDiskSpaceHandler;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.downloadlib.p549e.C6588h;
import com.p530ss.android.downloadlib.p549e.C6588h.C6589a;
import com.p530ss.android.downloadlib.p549e.DownloadDataAdapterUtils;
import com.p530ss.android.downloadlib.p549e.PermissionUtils;
import com.p530ss.android.downloadlib.p549e.PermissionUtils.C6586a;
import com.p530ss.android.p531a.p532a.p533a.AppStatusChangeListener;
import com.p530ss.android.p531a.p532a.p533a.IPermissionCallback;
import com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener;
import com.p530ss.android.p531a.p532a.p536c.DownloadShortInfo;
import com.p530ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p559d.AbsDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.C6792i;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.p530ss.android.socialbase.downloader.p569m.SystemUtils;
import com.tencent.mid.core.Constants;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.ss.android.downloadlib.a.h */
public class DownloadHelper implements C6589a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public long f21373a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C6546a f21374b;
    /* renamed from: c */
    private boolean f21375c = false;
    /* renamed from: d */
    private final C6588h f21376d = new C6588h(Looper.getMainLooper(), this);
    /* renamed from: e */
    private C6564b f21377e;

    /* compiled from: DownloadHelper */
    /* renamed from: com.ss.android.downloadlib.a.h$a */
    static class C6563a extends AbsDownloadListener {
        /* renamed from: a */
        private C6588h f21383a;

        C6563a(C6588h hVar) {
            this.f21383a = hVar;
        }

        /* renamed from: a */
        public void mo31350a(DownloadInfo cVar) {
            m26342a(cVar, 1);
        }

        /* renamed from: b */
        public void mo31352b(DownloadInfo cVar) {
            m26342a(cVar, 2);
        }

        /* renamed from: c */
        public void mo31353c(DownloadInfo cVar) {
            m26342a(cVar, 4);
        }

        /* renamed from: d */
        public void mo31354d(DownloadInfo cVar) {
            m26342a(cVar, -2);
        }

        /* renamed from: e */
        public void mo31355e(DownloadInfo cVar) {
            m26342a(cVar, -3);
        }

        /* renamed from: a */
        public void mo31351a(DownloadInfo cVar, BaseException aVar) {
            m26342a(cVar, -1);
        }

        /* renamed from: f */
        public void mo31356f(DownloadInfo cVar) {
            m26342a(cVar, -4);
        }

        /* renamed from: a */
        private void m26342a(DownloadInfo cVar, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = cVar;
            obtain.arg1 = i;
            this.f21383a.sendMessage(obtain);
        }
    }

    /* compiled from: DownloadHelper */
    /* renamed from: com.ss.android.downloadlib.a.h$b */
    public interface C6564b {
        /* renamed from: a */
        void mo31349a(DownloadInfo cVar);
    }

    /* renamed from: a */
    public void mo31334a(long j) {
        this.f21373a = j;
        this.f21374b = ModelManager.m26169a().mo31276e(j);
        if (this.f21374b.mo31279a()) {
            C6587g.m26532b();
        }
    }

    /* renamed from: a */
    public void mo31337a(DownloadInfo cVar) {
        this.f21375c = false;
        C6564b bVar = this.f21377e;
        if (bVar != null) {
            bVar.mo31349a(cVar);
            this.f21377e = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ff, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0127, code lost:
            return true;
     */
    /* renamed from: a */
    public boolean mo31340a(android.content.Context r11, int r12, boolean r13) {
        /*
        r10 = this;
        com.ss.android.downloadlib.a.b.d r0 = new com.ss.android.downloadlib.a.b.d
        r1 = 0
        r0.m51259init(r1)
        com.ss.android.downloadlib.a.b.c$a r2 = r10.f21374b
        com.ss.android.a.a.b.c r2 = r2.f21320b
        boolean r2 = com.p530ss.android.downloadlib.p549e.C6587g.m26525a(r2)
        r3 = 1
        if (r2 == 0) goto L_0x0052
        com.ss.android.downloadlib.a.b.c$a r2 = r10.f21374b
        com.ss.android.a.a.b.c r2 = r2.f21320b
        com.ss.android.a.a.c.b r2 = r2.mo31081u()
        if (r2 != 0) goto L_0x001d
        r2 = 0
        goto L_0x0021
    L_0x001d:
        java.lang.String r2 = r2.mo31100a()
    L_0x0021:
        com.ss.android.downloadlib.a.b.c$a r4 = r10.f21374b
        com.ss.android.a.a.b.a r4 = r4.f21322d
        int r4 = r4.mo31043a()
        boolean r4 = com.p530ss.android.downloadlib.p541a.DownloadInsideHelper.m26352a(r4)
        if (r4 == 0) goto L_0x003d
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        com.ss.android.a.a.b.c r13 = r13.f21320b
        java.lang.String r13 = r13.mo31080t()
        com.ss.android.downloadlib.a.b.d r13 = com.p530ss.android.downloadlib.p549e.OpenAppUtils.m26492a(r2, r13)
    L_0x003b:
        r0 = r13
        goto L_0x0089
    L_0x003d:
        if (r13 != 0) goto L_0x0089
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        com.ss.android.a.a.b.a r13 = r13.f21322d
        int r13 = r13.mo31043a()
        boolean r13 = com.p530ss.android.downloadlib.p541a.DownloadInsideHelper.m26356c(r13)
        if (r13 == 0) goto L_0x0089
        com.ss.android.downloadlib.a.b.d r13 = com.p530ss.android.downloadlib.p549e.OpenAppUtils.m26491a(r2)
        goto L_0x003b
    L_0x0052:
        boolean r13 = r10.m26311a(r12)
        if (r13 == 0) goto L_0x0089
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        com.ss.android.a.a.b.c r13 = r13.f21320b
        java.lang.String r13 = r13.mo31080t()
        boolean r13 = android.text.TextUtils.isEmpty(r13)
        if (r13 != 0) goto L_0x0089
        org.json.JSONObject r13 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()
        java.lang.String r2 = "disable_market"
        int r13 = r13.optInt(r2)
        if (r13 == r3) goto L_0x0089
        com.ss.android.downloadlib.d.a r13 = com.p530ss.android.downloadlib.p548d.AdEventHandler.m26446a()
        com.ss.android.downloadlib.a.b.c$a r0 = r10.f21374b
        java.lang.String r2 = "market_click_open"
        r13.mo31401a(r2, r0)
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        com.ss.android.a.a.b.c r13 = r13.f21320b
        java.lang.String r13 = r13.mo31080t()
        com.ss.android.downloadlib.a.b.d r0 = com.p530ss.android.downloadlib.p549e.OpenAppUtils.m26490a(r11, r13)
    L_0x0089:
        int r13 = r0.mo31280a()
        switch(r13) {
            case 1: goto L_0x0128;
            case 2: goto L_0x0127;
            case 3: goto L_0x0100;
            case 4: goto L_0x00ff;
            case 5: goto L_0x009d;
            case 6: goto L_0x0091;
            default: goto L_0x0090;
        }
    L_0x0090:
        return r1
    L_0x0091:
        com.ss.android.downloadlib.d.a r11 = com.p530ss.android.downloadlib.p548d.AdEventHandler.m26446a()
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        java.lang.String r13 = "market_open_failed"
        r11.mo31401a(r13, r12)
        return r1
    L_0x009d:
        com.ss.android.downloadlib.d.a r13 = com.p530ss.android.downloadlib.p548d.AdEventHandler.m26446a()
        long r0 = r10.f21373a
        r13.mo31391a(r0, r12)
        com.ss.android.downloadlib.d.a r12 = com.p530ss.android.downloadlib.p548d.AdEventHandler.m26446a()
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        java.lang.String r0 = "market_open_success"
        r12.mo31401a(r0, r13)
        com.ss.android.a.a.a.b r4 = com.p530ss.android.downloadlib.p541a.C6565j.m26369c()
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r6 = r12.f21320b
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.a r7 = r12.f21322d
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.b r8 = r12.f21321c
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r12 = r12.f21320b
        java.lang.String r9 = r12.mo31080t()
        r5 = r11
        r4.mo31029a(r5, r6, r7, r8, r9)
        com.ss.android.downloadlib.a.a r11 = com.p530ss.android.downloadlib.p541a.AdDeepLinkManager.m26130a()
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r12 = r12.f21320b
        r11.mo31241a(r12)
        com.ss.android.downloadad.a.b.a r11 = new com.ss.android.downloadad.a.b.a
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r12 = r12.f21320b
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        com.ss.android.a.a.b.b r13 = r13.f21321c
        com.ss.android.downloadlib.a.b.c$a r0 = r10.f21374b
        com.ss.android.a.a.b.a r0 = r0.f21322d
        r11.m51210init(r12, r13, r0)
        r12 = 2
        r11.mo31195a(r12)
        long r12 = java.lang.System.currentTimeMillis()
        r11.mo31207c(r12)
        r12 = 4
        r11.mo31211d(r12)
        com.ss.android.downloadlib.a.b.c r12 = com.p530ss.android.downloadlib.p541a.p543b.ModelManager.m26169a()
        r12.mo31268a(r11)
    L_0x00ff:
        return r3
    L_0x0100:
        com.ss.android.downloadlib.d.a r12 = com.p530ss.android.downloadlib.p548d.AdEventHandler.m26446a()
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        java.lang.String r0 = "deeplink_app_open"
        r12.mo31401a(r0, r13)
        com.ss.android.a.a.a.b r4 = com.p530ss.android.downloadlib.p541a.C6565j.m26369c()
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r6 = r12.f21320b
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.a r7 = r12.f21322d
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.b r8 = r12.f21321c
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r12 = r12.f21320b
        java.lang.String r9 = r12.mo31080t()
        r5 = r11
        r4.mo31029a(r5, r6, r7, r8, r9)
    L_0x0127:
        return r3
    L_0x0128:
        com.ss.android.downloadlib.d.a r12 = com.p530ss.android.downloadlib.p548d.AdEventHandler.m26446a()
        com.ss.android.downloadlib.a.b.c$a r13 = r10.f21374b
        java.lang.String r0 = "deeplink_url_open"
        r12.mo31401a(r0, r13)
        com.ss.android.a.a.a.b r4 = com.p530ss.android.downloadlib.p541a.C6565j.m26369c()
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r6 = r12.f21320b
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.a r7 = r12.f21322d
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.b r8 = r12.f21321c
        com.ss.android.downloadlib.a.b.c$a r12 = r10.f21374b
        com.ss.android.a.a.b.c r12 = r12.f21320b
        java.lang.String r9 = r12.mo31080t()
        r5 = r11
        r4.mo31029a(r5, r6, r7, r8, r9)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p541a.DownloadHelper.mo31340a(android.content.Context, int, boolean):boolean");
    }

    /* renamed from: a */
    private boolean m26311a(int i) {
        if ((this.f21374b.f21322d.mo31044b() == 2 && i == 2) || this.f21374b.f21322d.mo31044b() == 3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo31339a() {
        return C6587g.m26525a(this.f21374b.f21320b) && !DownloadInsideHelper.m26352a(this.f21374b.f21322d.mo31043a());
    }

    /* renamed from: a */
    public int mo31333a(boolean z) {
        return (!mo31339a() || !z) ? 0 : 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo31341b() {
        if (DownloadInsideHelper.m26355b(this.f21374b.f21322d.mo31043a()) && this.f21374b.f21320b.mo31081u() != null) {
            AdDeepLinkManager.m26130a().mo31242a(this.f21374b.f21320b.mo31081u());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo31343b(boolean z) {
        return !z && this.f21374b.f21322d.mo31044b() == 1;
    }

    /* renamed from: d */
    private boolean m26314d() {
        return m26315e() && m26317f();
    }

    /* renamed from: e */
    private boolean m26315e() {
        return this.f21374b.f21320b != null && !TextUtils.isEmpty(this.f21374b.f21320b.mo31080t()) && !TextUtils.isEmpty(this.f21374b.f21320b.mo31061a());
    }

    /* renamed from: f */
    private boolean m26317f() {
        return this.f21374b.f21322d.mo31046d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo31336a(final IPermissionCallback nVar) {
        if (TextUtils.isEmpty(this.f21374b.f21320b.mo31072l()) || !this.f21374b.f21320b.mo31072l().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            m26313b((IPermissionCallback) new IPermissionCallback() {
                /* renamed from: a */
                public void mo31041a() {
                    nVar.mo31041a();
                }

                /* renamed from: a */
                public void mo31042a(String str) {
                    C6565j.m26370d().mo16487a(1, C6565j.m26357a(), DownloadHelper.this.f21374b.f21320b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                    AdEventHandler.m26446a().mo31406b(DownloadHelper.this.f21373a, 1);
                    nVar.mo31042a(str);
                }
            });
        } else {
            nVar.mo31041a();
        }
    }

    /* renamed from: b */
    private void m26313b(final IPermissionCallback nVar) {
        String str = Constants.PERMISSION_WRITE_EXTERNAL_STORAGE;
        if (PermissionUtils.m26500b(str)) {
            if (nVar != null) {
                nVar.mo31041a();
            }
            return;
        }
        PermissionUtils.m26499a(new String[]{str}, (C6586a) new C6586a() {
            /* renamed from: a */
            public void mo31347a() {
                IPermissionCallback nVar = nVar;
                if (nVar != null) {
                    nVar.mo31041a();
                }
            }

            /* renamed from: a */
            public void mo31348a(String str) {
                IPermissionCallback nVar = nVar;
                if (nVar != null) {
                    nVar.mo31042a(str);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo31335a(Message message, DownloadShortInfo eVar, List<DownloadStatusChangeListener> list) {
        if (message != null && message.what == 3) {
            DownloadInfo cVar = (DownloadInfo) message.obj;
            int i = 0;
            if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2 && cVar.mo32248ay()) {
                DownloadDispatcherImpl.m26547a().mo31419a(this.f21374b.f21320b, this.f21374b.f21322d, this.f21374b.f21321c);
                cVar.mo32282f(false);
            }
            eVar.mo31138a(cVar);
            int a = AppDownloadUtils.m26644a(cVar.mo32308q());
            long ab = cVar.mo32225ab();
            if (ab > 0) {
                i = (int) ((cVar.mo32180Z() * 100) / ab);
                C6564b bVar = this.f21377e;
                if (bVar != null) {
                    bVar.mo31349a(cVar);
                    this.f21377e = null;
                }
            }
            for (DownloadStatusChangeListener dVar : list) {
                if (a == 1) {
                    dVar.mo16531a(eVar, i);
                } else if (a == 2) {
                    dVar.mo16533b(eVar, i);
                } else if (a == 3) {
                    if (cVar.mo32308q() == -4) {
                        dVar.mo16528a();
                    } else if (cVar.mo32308q() == -1) {
                        dVar.mo16530a(eVar);
                    } else if (cVar.mo32308q() == -3) {
                        if (C6587g.m26525a(this.f21374b.f21320b)) {
                            dVar.mo16532b(eVar);
                        } else {
                            dVar.mo16534c(eVar);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo31342b(DownloadInfo cVar) {
        if (DownloadInsideHelper.m26353a(this.f21374b.f21320b) && !this.f21375c) {
            int i = (cVar == null || !C6587g.m26534b(cVar.mo32305n())) ? 2 : 1;
            AdEventHandler.m26446a().mo31397a("file_status", i, this.f21374b);
            this.f21375c = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo31344c() {
        if (this.f21377e == null) {
            this.f21377e = new C6564b() {
                /* renamed from: a */
                public void mo31349a(DownloadInfo cVar) {
                    AdEventHandler.m26446a().mo31392a(DownloadHelper.this.f21373a, 2, cVar);
                }
            };
        }
    }

    /* renamed from: g */
    private void m26319g() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f21376d.sendMessageDelayed(obtain, 1200);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo31345c(DownloadInfo cVar) {
        return m26316e(cVar) || m26320h();
    }

    /* renamed from: e */
    private boolean m26316e(DownloadInfo cVar) {
        return m26318f(cVar) && !C6587g.m26525a(this.f21374b.f21320b);
    }

    /* renamed from: h */
    private boolean m26320h() {
        return C6587g.m26525a(this.f21374b.f21320b) && DownloadInsideHelper.m26352a(this.f21374b.f21322d.mo31043a());
    }

    /* renamed from: f */
    private boolean m26318f(DownloadInfo cVar) {
        return cVar != null && cVar.mo32308q() == -3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo31332a(Context context, IDownloadListener adVar) {
        if (context == null) {
            return 0;
        }
        Map h = this.f21374b.f21320b.mo31068h();
        ArrayList arrayList = new ArrayList();
        if (h != null) {
            for (Entry entry : h.entrySet()) {
                if (entry != null) {
                    arrayList.add(new HttpHeader((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        String a = DownloadDataAdapterUtils.m26488a(String.valueOf(this.f21374b.f21320b.mo31064d()), this.f21374b.f21320b.mo31063c(), this.f21374b.f21320b.mo31069i(), String.valueOf(this.f21374b.f21320b.mo31084x()));
        DownloadSetting a2 = DownloadSetting.m28613a(this.f21374b.f21320b.mo31074n());
        String a3 = m26309a(this.f21374b.f21320b.mo31061a(), this.f21374b.f21320b.mo31072l(), a2);
        DownloadInfo h2 = Downloader.m27478a(C6565j.m26357a()).mo31928h(C6694b.m27348a(this.f21374b.f21320b.mo31061a(), a3));
        if (h2 != null && 3 == this.f21374b.f21320b.mo31084x()) {
            h2.mo32282f(true);
            DownloadUtils.m28763a(h2);
        }
        AppTaskBuilder a4 = new AppTaskBuilder(context, this.f21374b.f21320b.mo31061a()).mo31573b(this.f21374b.f21320b.mo31062b()).mo31566a(this.f21374b.f21320b.mo31066f()).mo31580d(a).mo31567a((List<HttpHeader>) arrayList).mo31569a(this.f21374b.f21320b.mo31070j()).mo31577c(this.f21374b.f21320b.mo31071k()).mo31572b(this.f21374b.f21320b.mo31073m()).mo31576c(a3).mo31561a(adVar).mo31601l(this.f21374b.f21320b.mo31075o()).mo31563a(this.f21374b.f21320b.mo31060A()).mo31574b(this.f21374b.f21320b.mo31086z()).mo31586f(this.f21374b.f21320b.mo31080t()).mo31575c(1000).mo31579d(100).mo31568a(this.f21374b.f21320b.mo31074n()).mo31595i(true).mo31597j(true).mo31559a(a2.mo32547a("retry_count", 5)).mo31571b(a2.mo32547a("backup_url_retry_count", 0)).mo31597j(true).mo31603m(true).mo31581d(a2.mo32547a("need_https_to_http_retry", 0) == 1).mo31593h(a2.mo32547a("need_chunk_downgrade_retry", 1) == 1).mo31590g(a2.mo32547a("need_retry_delay", 0) == 1).mo31592h(a2.mo32553c("retry_delay_time_array")).mo31599k(a2.mo32547a("need_reuse_runnable", 0) == 1).mo31601l(a2.mo32547a("need_independent_process", 0) == 1).mo31565a(ChunkCalculatorFactory.m26231a(this.f21374b.f21320b.mo31061a(), this.f21374b.f21320b.mo31074n())).mo31564a(ChunkCalculatorFactory.m26229a(this.f21374b.f21320b.mo31074n()));
        if (!TextUtils.isEmpty(this.f21374b.f21320b.mo31067g())) {
            a4.mo31583e(this.f21374b.f21320b.mo31067g());
        } else {
            a4.mo31583e("application/vnd.android.package-archive");
        }
        AppDownloadDiskSpaceHandler aVar = null;
        if (a2.mo32547a("clear_space_use_disk_handler", 0) == 1) {
            aVar = new AppDownloadDiskSpaceHandler();
            a4.mo31562a((IDownloadDiskSpaceHandler) aVar);
        }
        int a5 = DownloadInsideHelper.m26351a(this.f21374b.f21320b, m26314d(), a4);
        if (aVar != null) {
            aVar.mo31290a(a5);
        }
        return a5;
    }

    /* renamed from: a */
    public static String m26309a(String str, String str2, DownloadSetting aVar) {
        DownloadInfo a = AppDownloader.m26714h().mo31475a(C6565j.m26357a(), str);
        if (a != null) {
            return a.mo32297k();
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = null;
        try {
            str3 = AppDownloadUtils.m26650a(C6565j.m26357a());
        } catch (Exception unused) {
        }
        if (aVar.mo32547a("back_fix_sigbus", 0) == 1) {
            return str3;
        }
        File filesDir = C6565j.m26357a().getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        if (filesDir.exists() && filesDir.isDirectory() && (aVar.mo32547a("bugfix_sigbus_all_brand", 0) == 1 || C6792i.m28932b())) {
            int i = VERSION.SDK_INT;
            if (i >= 21 && i <= 25 && SystemUtils.m28952a()) {
                str3 = filesDir.getPath();
            }
        }
        return str3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo31346d(DownloadInfo cVar) {
        if (this.f21374b.f21320b != null && cVar != null && cVar.mo32283g() != 0) {
            int q = cVar.mo32308q();
            if (q == -1 || q == -4) {
                AdEventHandler.m26446a().mo31391a(this.f21373a, 2);
            } else if (DownloadInsideHelper.m26353a(this.f21374b.f21320b)) {
                AdEventHandler.m26446a().mo31391a(this.f21373a, 2);
            }
            switch (q) {
                case -4:
                case -1:
                    mo31344c();
                    ModelManager.m26169a().mo31268a(new NativeDownloadModel(this.f21374b.f21320b, this.f21374b.f21321c, this.f21374b.f21322d, cVar.mo32283g()));
                    return;
                case -3:
                    if (C6587g.m26525a(this.f21374b.f21320b)) {
                        C6587g.m26532b();
                        return;
                    }
                    AdEventHandler.m26446a().mo31406b(this.f21373a, 5);
                    m26319g();
                    return;
                case -2:
                    AdEventHandler.m26446a().mo31406b(this.f21373a, 4);
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    AdEventHandler.m26446a().mo31406b(this.f21373a, 3);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* renamed from: a */
    public void mo31338a(com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r7, com.p530ss.android.p531a.p532a.p536c.DownloadShortInfo r8, java.util.List<com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener> r9) {
        /*
        r6 = this;
        boolean r0 = r9.isEmpty()
        if (r0 == 0) goto L_0x0007
        return
    L_0x0007:
        if (r7 == 0) goto L_0x007f
        if (r8 != 0) goto L_0x000d
        goto L_0x007f
    L_0x000d:
        r0 = 0
        long r1 = r7.mo32225ab()     // Catch:{ Exception -> 0x0027 }
        r3 = 0
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 <= 0) goto L_0x002b
        long r1 = r7.mo32180Z()     // Catch:{ Exception -> 0x0027 }
        r3 = 100
        long r1 = r1 * r3
        long r3 = r7.mo32225ab()     // Catch:{ Exception -> 0x0027 }
        long r1 = r1 / r3
        int r2 = (int) r1
        goto L_0x002c
    L_0x0027:
        r1 = move-exception
        r1.printStackTrace()
    L_0x002b:
        r2 = 0
    L_0x002c:
        if (r2 >= 0) goto L_0x002f
        goto L_0x0030
    L_0x002f:
        r0 = r2
    L_0x0030:
        r8.mo31138a(r7)
        java.util.Iterator r9 = r9.iterator()
    L_0x0037:
        boolean r1 = r9.hasNext()
        if (r1 == 0) goto L_0x007e
        java.lang.Object r1 = r9.next()
        com.ss.android.a.a.b.d r1 = (com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener) r1
        int r2 = r7.mo32308q()
        switch(r2) {
            case -4: goto L_0x0069;
            case -3: goto L_0x0057;
            case -2: goto L_0x0053;
            case -1: goto L_0x004f;
            case 0: goto L_0x004a;
            case 1: goto L_0x004b;
            case 2: goto L_0x004b;
            case 3: goto L_0x004b;
            case 4: goto L_0x004b;
            case 5: goto L_0x004b;
            case 6: goto L_0x004a;
            case 7: goto L_0x004b;
            case 8: goto L_0x004b;
            default: goto L_0x004a;
        }
    L_0x004a:
        goto L_0x0037
    L_0x004b:
        r1.mo16531a(r8, r0)
        goto L_0x0037
    L_0x004f:
        r1.mo16530a(r8)
        goto L_0x0037
    L_0x0053:
        r1.mo16533b(r8, r0)
        goto L_0x0037
    L_0x0057:
        com.ss.android.downloadlib.a.b.c$a r2 = r6.f21374b
        com.ss.android.a.a.b.c r2 = r2.f21320b
        boolean r2 = com.p530ss.android.downloadlib.p549e.C6587g.m26525a(r2)
        if (r2 == 0) goto L_0x0065
        r1.mo16532b(r8)
        goto L_0x0037
    L_0x0065:
        r1.mo16534c(r8)
        goto L_0x0037
    L_0x0069:
        com.ss.android.downloadlib.a.b.c$a r2 = r6.f21374b
        com.ss.android.a.a.b.c r2 = r2.f21320b
        boolean r2 = com.p530ss.android.downloadlib.p549e.C6587g.m26525a(r2)
        if (r2 == 0) goto L_0x007a
        r2 = -3
        r8.f21106b = r2
        r1.mo16532b(r8)
        goto L_0x0037
    L_0x007a:
        r1.mo16528a()
        goto L_0x0037
    L_0x007e:
        return
    L_0x007f:
        java.util.Iterator r7 = r9.iterator()
    L_0x0083:
        boolean r8 = r7.hasNext()
        if (r8 == 0) goto L_0x0093
        java.lang.Object r8 = r7.next()
        com.ss.android.a.a.b.d r8 = (com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener) r8
        r8.mo16528a()
        goto L_0x0083
    L_0x0093:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p541a.DownloadHelper.mo31338a(com.ss.android.socialbase.downloader.g.c, com.ss.android.a.a.c.e, java.util.List):void");
    }

    /* renamed from: a */
    public void mo31256a(Message message) {
        if (message.what == 1) {
            AppStatusChangeListener k = C6565j.m26377k();
            if (k != null && k.mo16475a()) {
                AdEventHandler.m26446a().mo31401a("install_window_show", this.f21374b);
            }
        }
    }

    /* renamed from: a */
    public static List<DownloadStatusChangeListener> m26310a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object next : map.values()) {
                if (next instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) next);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof DownloadStatusChangeListener) {
                        arrayList.add((DownloadStatusChangeListener) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }
}
