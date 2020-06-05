package com.p530ss.android.downloadlib.p541a;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadController.C6525a;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadModel;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p541a.p543b.SharedPrefsManager;
import com.p530ss.android.downloadlib.p541a.p544c.DownloadOptimizationManager;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.AsyncTaskUtils;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.downloadlib.p549e.C6588h;
import com.p530ss.android.downloadlib.p549e.C6588h.C6589a;
import com.p530ss.android.downloadlib.p549e.OpenAppUtils;
import com.p530ss.android.downloadlib.p549e.TLogger;
import com.p530ss.android.p531a.p532a.p533a.IPermissionCallback;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener;
import com.p530ss.android.p531a.p532a.p534b.SimpleDownloadEventConfig.C6509a;
import com.p530ss.android.p531a.p532a.p536c.DownloadShortInfo;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.C6711a;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ss.android.downloadlib.a.f */
public class CommonDownloadHandler implements DownloadHandler, C6589a {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f21354a = CommonDownloadHandler.class.getSimpleName();
    /* renamed from: b */
    private final C6588h f21355b = new C6588h(Looper.getMainLooper(), this);
    /* access modifiers changed from: private */
    /* renamed from: c */
    public DownloadHelper f21356c = new DownloadHelper();
    /* renamed from: d */
    private WeakReference<Context> f21357d;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final Map<Integer, Object> f21358e = new ConcurrentHashMap();
    /* renamed from: f */
    private DownloadShortInfo f21359f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public DownloadInfo f21360g;
    /* renamed from: h */
    private C6559a f21361h;
    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final IDownloadListener f21362i = new C6563a(this.f21355b);
    /* renamed from: j */
    private boolean f21363j;
    /* renamed from: k */
    private long f21364k;
    /* renamed from: l */
    private long f21365l = -1;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public C6507c f21366m = null;
    /* renamed from: n */
    private DownloadEventConfig f21367n = null;
    /* renamed from: o */
    private DownloadController f21368o = null;
    /* renamed from: p */
    private boolean f21369p;

    /* compiled from: CommonDownloadHandler */
    /* renamed from: com.ss.android.downloadlib.a.f$a */
    private class C6559a extends AsyncTask<String, Void, DownloadInfo> {
        private C6559a() {
        }

        /* access modifiers changed from: protected|varargs */
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo cVar = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = strArr[0];
            if (CommonDownloadHandler.this.f21366m != null && !TextUtils.isEmpty(CommonDownloadHandler.this.f21366m.mo31072l())) {
                cVar = Downloader.m27478a(C6565j.m26357a()).mo31911a(str, CommonDownloadHandler.this.f21366m.mo31072l());
            }
            return cVar == null ? AppDownloader.m26714h().mo31475a(C6565j.m26357a(), str) : cVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(DownloadInfo cVar) {
            super.onPostExecute(cVar);
            if (!isCancelled() && CommonDownloadHandler.this.f21366m != null) {
                try {
                    boolean a = C6587g.m26510a(CommonDownloadHandler.this.f21366m.mo31080t(), CommonDownloadHandler.this.f21366m.mo31076p(), CommonDownloadHandler.this.f21366m.mo31077q()).mo31261a();
                    if (cVar == null || cVar.mo32283g() == 0 || (!a && Downloader.m27478a(C6565j.m26357a()).mo31918a(cVar))) {
                        if (cVar != null && Downloader.m27478a(C6565j.m26357a()).mo31918a(cVar)) {
                            DownloadNotificationManager.m28984a().mo32648f(cVar.mo32283g());
                            CommonDownloadHandler.this.f21360g = null;
                        }
                        if (CommonDownloadHandler.this.f21360g != null) {
                            Downloader.m27478a(C6565j.m26357a()).mo31931k(CommonDownloadHandler.this.f21360g.mo32283g());
                            Downloader.m27478a(CommonDownloadHandler.this.m26265k()).mo31915a(CommonDownloadHandler.this.f21360g.mo32283g(), CommonDownloadHandler.this.f21362i);
                        }
                        if (a) {
                            CommonDownloadHandler.this.f21360g = new C6711a(CommonDownloadHandler.this.f21366m.mo31061a()).mo32330a();
                            CommonDownloadHandler.this.f21360g.mo32251b(-3);
                            CommonDownloadHandler.this.f21356c.mo31338a(CommonDownloadHandler.this.f21360g, CommonDownloadHandler.this.m26270p(), DownloadHelper.m26310a(CommonDownloadHandler.this.f21358e));
                        } else {
                            for (DownloadStatusChangeListener a2 : DownloadHelper.m26310a(CommonDownloadHandler.this.f21358e)) {
                                a2.mo16528a();
                            }
                            CommonDownloadHandler.this.f21360g = null;
                        }
                    } else {
                        Downloader.m27478a(C6565j.m26357a()).mo31931k(cVar.mo32283g());
                        boolean z = !DownloadSetting.m28610a(cVar.mo32283g()).mo32552b("bugfix_remove_listener", true);
                        if (CommonDownloadHandler.this.f21360g == null || (CommonDownloadHandler.this.f21360g.mo32308q() != -4 && (z || CommonDownloadHandler.this.f21360g.mo32308q() != -1))) {
                            CommonDownloadHandler.this.f21360g = cVar;
                            Downloader.m27478a(C6565j.m26357a()).mo31915a(CommonDownloadHandler.this.f21360g.mo32283g(), CommonDownloadHandler.this.f21362i);
                        } else {
                            CommonDownloadHandler.this.f21360g = null;
                        }
                        CommonDownloadHandler.this.f21356c.mo31338a(CommonDownloadHandler.this.f21360g, CommonDownloadHandler.this.m26270p(), DownloadHelper.m26310a(CommonDownloadHandler.this.f21358e));
                    }
                    CommonDownloadHandler.this.f21356c.mo31342b(CommonDownloadHandler.this.f21360g);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public CommonDownloadHandler mo31317b(Context context) {
        if (context != null) {
            this.f21357d = new WeakReference<>(context);
        }
        C6565j.m26368b(context);
        return this;
    }

    /* renamed from: a */
    public CommonDownloadHandler mo31316b(int i, DownloadStatusChangeListener dVar) {
        if (dVar != null) {
            if (C6565j.m26375i().optInt("back_use_softref_listener") == 1) {
                this.f21358e.put(Integer.valueOf(i), dVar);
            } else {
                this.f21358e.put(Integer.valueOf(i), new SoftReference(dVar));
            }
        }
        return this;
    }

    /* renamed from: a */
    public CommonDownloadHandler mo31320b(C6507c cVar) {
        if (cVar != null) {
            ModelManager.m26169a().mo31267a(cVar);
            this.f21365l = cVar.mo31064d();
            this.f21366m = cVar;
            if (DownloadInsideHelper.m26353a(cVar)) {
                ((AdDownloadModel) cVar).mo31175a(3);
                NativeDownloadModel d = ModelManager.m26169a().mo31275d(this.f21365l);
                if (!(d == null || d.mo31200b() == 3)) {
                    d.mo31202b(3);
                    SharedPrefsManager.m26192a().mo31281a(d);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    public CommonDownloadHandler mo31318b(DownloadController aVar) {
        this.f21368o = aVar;
        ModelManager.m26169a().mo31265a(this.f21365l, m26267m());
        return this;
    }

    /* renamed from: a */
    public CommonDownloadHandler mo31319b(DownloadEventConfig bVar) {
        this.f21367n = bVar;
        this.f21369p = m26266l().mo31057k() == 0;
        ModelManager.m26169a().mo31266a(this.f21365l, m26266l());
        return this;
    }

    /* renamed from: a */
    public void mo31312a() {
        this.f21363j = true;
        ModelManager.m26169a().mo31266a(this.f21365l, m26266l());
        ModelManager.m26169a().mo31265a(this.f21365l, m26267m());
        this.f21356c.mo31334a(this.f21365l);
        m26269o();
    }

    /* renamed from: a */
    public boolean mo31315a(int i) {
        if (i == 0) {
            this.f21358e.clear();
        } else {
            this.f21358e.remove(Integer.valueOf(i));
        }
        boolean z = false;
        if (this.f21358e.isEmpty()) {
            this.f21363j = false;
            this.f21364k = System.currentTimeMillis();
            if (this.f21360g != null) {
                Downloader.m27478a(C6565j.m26357a()).mo31931k(this.f21360g.mo32283g());
            }
            C6559a aVar = this.f21361h;
            z = true;
            if (!(aVar == null || aVar.getStatus() == Status.FINISHED)) {
                this.f21361h.cancel(true);
            }
            this.f21356c.mo31337a(this.f21360g);
            String str = f21354a;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo cVar = this.f21360g;
            sb.append(cVar == null ? "" : cVar.mo32295j());
            TLogger.m26504a(str, sb.toString(), null);
            this.f21355b.removeCallbacksAndMessages(null);
            this.f21359f = null;
            this.f21360g = null;
        }
        return z;
    }

    /* renamed from: a */
    public void mo31314a(boolean z) {
        if (this.f21360g == null) {
            return;
        }
        if (z) {
            IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
            if (b != null) {
                b.mo31371a(this.f21360g);
            }
            Downloader.m27478a(C6694b.m27342B()).mo31916a(this.f21360g.mo32283g(), true);
            return;
        }
        Intent intent = new Intent(C6565j.m26357a(), DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
        intent.putExtra("extra_click_download_ids", this.f21360g.mo32283g());
        C6565j.m26357a().startService(intent);
    }

    /* renamed from: b */
    public boolean mo31321b() {
        return this.f21363j;
    }

    /* renamed from: c */
    public boolean mo31322c() {
        return this.f21360g != null;
    }

    /* renamed from: d */
    public long mo31323d() {
        return this.f21364k;
    }

    /* renamed from: a */
    public void mo31313a(long j, int i) {
        if (i == 2 || i == 1) {
            if (j > 0) {
                C6507c a = ModelManager.m26169a().mo31262a(j);
                if (a != null) {
                    this.f21366m = a;
                    this.f21365l = j;
                    this.f21356c.mo31334a(this.f21365l);
                }
            } else {
                C6587g.m26532b();
            }
            if (!this.f21356c.mo31340a(m26265k(), i, this.f21369p)) {
                boolean b = m26251b(i);
                String str = "handleDownload id:";
                if (i != 1) {
                    if (i == 2 && !b) {
                        String str2 = f21354a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(j);
                        sb.append(",tryPerformButtonClick:");
                        TLogger.m26504a(str2, sb.toString(), null);
                        m26250b(true);
                    }
                } else if (!b) {
                    String str3 = f21354a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(j);
                    sb2.append(",tryPerformItemClick:");
                    TLogger.m26504a(str3, sb2.toString(), null);
                    m26253c(true);
                }
            }
        } else {
            throw new IllegalArgumentException("error actionType");
        }
    }

    /* renamed from: i */
    private boolean m26263i() {
        if (C6565j.m26375i().optInt("quick_app_enable_switch", 0) == 0 && AdQuickAppManager.m26222a(this.f21366m) && AdQuickAppManager.m26223a(this.f21360g)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m26251b(int i) {
        if (!m26263i()) {
            return false;
        }
        int i2 = -1;
        String a = this.f21366m.mo31085y().mo31141a();
        if (i == 1) {
            i2 = 5;
        } else if (i == 2) {
            i2 = 4;
        }
        AdEventHandler.m26446a().mo31391a(this.f21365l, i);
        boolean c = OpenAppUtils.m26494c(C6565j.m26357a(), a);
        if (c) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = Long.valueOf(this.f21366m.mo31064d());
            this.f21355b.sendMessageDelayed(obtain, AdQuickAppManager.m26221a().mo31300b());
            AdQuickAppManager.m26221a().mo31299a(i2, this.f21366m, this.f21367n);
        } else {
            AdEventHandler.m26446a().mo31394a(this.f21365l, false, 0);
        }
        return c;
    }

    /* renamed from: b */
    private void m26250b(boolean z) {
        if (this.f21356c.mo31333a(this.f21369p) != 1) {
            m26255d(z);
            return;
        }
        if (z) {
            AdEventHandler.m26446a().mo31391a(this.f21365l, 1);
        }
        C6565j.m26369c().mo31028a(m26265k(), this.f21366m, m26267m(), m26266l());
    }

    /* renamed from: c */
    private void m26253c(boolean z) {
        if (z) {
            AdEventHandler.m26446a().mo31391a(this.f21365l, 1);
        }
        m26257e(z);
    }

    /* renamed from: d */
    private void m26255d(boolean z) {
        m26259f(z);
        this.f21356c.mo31341b();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m26264j() {
        m26268n();
    }

    /* renamed from: e */
    public void mo31324e() {
        this.f21355b.post(new Runnable() {
            public void run() {
                for (DownloadStatusChangeListener b : DownloadHelper.m26310a(CommonDownloadHandler.this.f21358e)) {
                    b.mo16532b(CommonDownloadHandler.this.m26270p());
                }
            }
        });
    }

    /* renamed from: a */
    public void mo31256a(Message message) {
        if (message != null && this.f21363j) {
            int i = message.what;
            if (i == 3) {
                this.f21360g = (DownloadInfo) message.obj;
                this.f21356c.mo31335a(message, m26270p(), DownloadHelper.m26310a(this.f21358e));
            } else if (i != 4) {
                if (i == 5 && (C6565j.m26377k() == null || !C6565j.m26377k().mo16475a())) {
                    AdEventHandler.m26446a().mo31394a(this.f21365l, false, 1);
                    m26253c(false);
                }
            } else if (C6565j.m26377k() == null || !C6565j.m26377k().mo16475a()) {
                AdEventHandler.m26446a().mo31394a(this.f21365l, false, 2);
                m26250b(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public Context m26265k() {
        WeakReference<Context> weakReference = this.f21357d;
        if (weakReference == null || weakReference.get() == null) {
            return C6565j.m26357a();
        }
        return (Context) this.f21357d.get();
    }

    /* renamed from: l */
    private DownloadEventConfig m26266l() {
        DownloadEventConfig bVar = this.f21367n;
        return bVar == null ? new C6509a().mo31087a() : bVar;
    }

    /* renamed from: m */
    private DownloadController m26267m() {
        DownloadController aVar = this.f21368o;
        return aVar == null ? new C6525a().mo31146a() : aVar;
    }

    /* renamed from: e */
    private void m26257e(boolean z) {
        TLogger.m26504a(f21354a, "performItemClickWithNewDownloader", null);
        if (this.f21356c.mo31345c(this.f21360g)) {
            TLogger.m26504a(f21354a, "performItemClickWithNewDownloader ButtonClick", null);
            m26259f(z);
            return;
        }
        TLogger.m26504a(f21354a, "performItemClickWithNewDownloader onItemClick", null);
        C6565j.m26369c().mo31028a(m26265k(), this.f21366m, m26267m(), m26266l());
    }

    /* renamed from: f */
    private void m26259f(boolean z) {
        TLogger.m26504a(f21354a, "performButtonClickWithNewDownloader", null);
        DownloadInfo cVar = this.f21360g;
        if (cVar == null || (cVar.mo32308q() != -3 && !Downloader.m27478a(C6565j.m26357a()).mo31924d(this.f21360g.mo32283g()))) {
            if (z) {
                AdEventHandler.m26446a().mo31391a(this.f21365l, 2);
            }
            TLogger.m26504a(f21354a, "performButtonClickWithNewDownloader not start", null);
            this.f21356c.mo31336a((IPermissionCallback) new IPermissionCallback() {
                /* renamed from: a */
                public void mo31041a() {
                    TLogger.m26504a(CommonDownloadHandler.f21354a, "performButtonClickWithNewDownloader start download", null);
                    CommonDownloadHandler.this.m26264j();
                }

                /* renamed from: a */
                public void mo31042a(String str) {
                    TLogger.m26504a(CommonDownloadHandler.f21354a, "performButtonClickWithNewDownloader onDenied", null);
                }
            });
            return;
        }
        String str = f21354a;
        StringBuilder sb = new StringBuilder();
        sb.append("performButtonClickWithNewDownloader continue download, status:");
        sb.append(this.f21360g.mo32308q());
        TLogger.m26504a(str, sb.toString(), null);
        this.f21356c.mo31346d(this.f21360g);
        DownloadInfo cVar2 = this.f21360g;
        if (cVar2 != null) {
            C6507c cVar3 = this.f21366m;
            if (cVar3 != null) {
                cVar2.mo32266c(cVar3.mo31071k());
            }
        }
        AppDownloader.m26714h().mo31479a(C6565j.m26357a(), this.f21360g.mo32283g(), this.f21360g.mo32308q());
    }

    /* renamed from: n */
    private void m26268n() {
        for (DownloadStatusChangeListener a : DownloadHelper.m26310a(this.f21358e)) {
            a.mo16529a(this.f21366m, m26267m());
        }
        int a2 = this.f21356c.mo31332a(C6565j.m26357a(), this.f21362i);
        String str = f21354a;
        StringBuilder sb = new StringBuilder();
        sb.append("beginDownloadWithNewDownloader id:");
        sb.append(a2);
        TLogger.m26504a(str, sb.toString(), null);
        if (a2 != 0) {
            DownloadInfo cVar = this.f21360g;
            if (cVar == null) {
                this.f21356c.mo31344c();
            } else {
                this.f21356c.mo31346d(cVar);
            }
            ModelManager.m26169a().mo31268a(new NativeDownloadModel(this.f21366m, m26266l(), m26267m(), a2));
        } else {
            DownloadInfo a3 = new C6711a(this.f21366m.mo31061a()).mo32330a();
            a3.mo32251b(-1);
            m26248a(a3);
            AdEventHandler.m26446a().mo31393a(this.f21365l, new BaseException(2, "start download failed, id=0"));
            C6587g.m26532b();
        }
        DownloadOptimizationManager.m26212a().mo31295b().remove((long) a2);
        if (this.f21356c.mo31343b(mo31322c())) {
            C6565j.m26369c().mo31028a(m26265k(), this.f21366m, m26267m(), m26266l());
            String str2 = f21354a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("beginDownloadWithNewDownloader onItemClick id:");
            sb2.append(a2);
            TLogger.m26504a(str2, sb2.toString(), null);
        }
    }

    /* renamed from: f */
    public void mo31325f() {
        if (this.f21358e.size() != 0) {
            for (DownloadStatusChangeListener a : DownloadHelper.m26310a(this.f21358e)) {
                a.mo16528a();
            }
            DownloadInfo cVar = this.f21360g;
            if (cVar != null) {
                cVar.mo32251b(-4);
            }
        }
    }

    /* renamed from: a */
    private void m26248a(DownloadInfo cVar) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = cVar;
        this.f21355b.sendMessage(obtain);
    }

    /* renamed from: o */
    private void m26269o() {
        C6559a aVar = this.f21361h;
        if (!(aVar == null || aVar.getStatus() == Status.FINISHED)) {
            this.f21361h.cancel(true);
        }
        this.f21361h = new C6559a();
        AsyncTaskUtils.m26485a(this.f21361h, this.f21366m.mo31061a(), this.f21366m.mo31080t());
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public DownloadShortInfo m26270p() {
        if (this.f21359f == null) {
            this.f21359f = new DownloadShortInfo();
        }
        return this.f21359f;
    }

    /* renamed from: g */
    public void mo31326g() {
        ModelManager.m26169a().mo31277f(this.f21365l);
    }
}
