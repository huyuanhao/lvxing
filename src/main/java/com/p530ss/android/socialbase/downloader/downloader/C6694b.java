package com.p530ss.android.socialbase.downloader.downloader;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.p530ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.p530ss.android.socialbase.downloader.impls.DefaultChunkAdjustCalculator;
import com.p530ss.android.socialbase.downloader.impls.DefaultChunkCntCalculator;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.p530ss.android.socialbase.downloader.impls.DefaultIdGenerator;
import com.p530ss.android.socialbase.downloader.impls.DefaultRetryDelayTimeCalculator;
import com.p530ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.p530ss.android.socialbase.downloader.impls.DownloadProxy;
import com.p530ss.android.socialbase.downloader.impls.IndependentDownloadServiceHandler;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager;
import com.p530ss.android.socialbase.downloader.p557b.DownloadCacheSyncStatus;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadCacheSyncStatusListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p559d.ProcessCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p563h.IDownloadGlobalMonitorListener;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpConnection;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpService;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpConnection;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpService;
import com.p530ss.android.socialbase.downloader.p564i.p565a.DownloadPreconnecter;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p568l.C6745a;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.C8495n;
import okhttp3.C8513x;
import okhttp3.C8513x.C8515a;
import okhttp3.Protocol;
import org.json.JSONObject;

/* compiled from: DownloadComponentManager */
/* renamed from: com.ss.android.socialbase.downloader.downloader.b */
public class C6694b {
    /* renamed from: A */
    private static int f21831A;
    /* renamed from: B */
    private static final int f21832B = (Runtime.getRuntime().availableProcessors() + 1);
    /* renamed from: C */
    private static final int f21833C = ((Runtime.getRuntime().availableProcessors() * 2) + 1);
    /* renamed from: D */
    private static final int f21834D = (Runtime.getRuntime().availableProcessors() + 1);
    /* renamed from: E */
    private static int f21835E = 8192;
    /* renamed from: F */
    private static boolean f21836F;
    /* renamed from: G */
    private static volatile List<IDownloadCacheSyncStatusListener> f21837G = new ArrayList();
    /* renamed from: H */
    private static int f21838H;
    /* renamed from: I */
    private static JSONObject f21839I;
    /* renamed from: J */
    private static IDownloadGlobalMonitorListener f21840J;
    /* renamed from: K */
    private static volatile boolean f21841K = false;
    /* renamed from: a */
    private static volatile Context f21842a;
    /* renamed from: b */
    private static volatile IDownloadCache f21843b;
    /* renamed from: c */
    private static volatile IDownloadIdGenerator f21844c;
    /* renamed from: d */
    private static volatile IChunkCntCalculator f21845d;
    /* renamed from: e */
    private static volatile INotificationClickCallback f21846e;
    /* renamed from: f */
    private static volatile AbsDownloadEngine f21847f;
    /* renamed from: g */
    private static volatile IDownloadServiceHandler f21848g;
    /* renamed from: h */
    private static volatile IDownloadServiceHandler f21849h;
    /* renamed from: i */
    private static volatile IDownloadHttpService f21850i;
    /* renamed from: j */
    private static volatile IDownloadHeadHttpService f21851j;
    /* renamed from: k */
    private static volatile IDownloadHttpService f21852k;
    /* renamed from: l */
    private static volatile IDownloadHeadHttpService f21853l;
    /* renamed from: m */
    private static volatile IDownloadLaunchHandler f21854m;
    /* renamed from: n */
    private static volatile ExecutorService f21855n;
    /* renamed from: o */
    private static volatile ExecutorService f21856o;
    /* renamed from: p */
    private static volatile ExecutorService f21857p;
    /* renamed from: q */
    private static volatile ExecutorService f21858q;
    /* renamed from: r */
    private static volatile IChunkAdjustCalculator f21859r;
    /* renamed from: s */
    private static volatile DownloadReceiver f21860s;
    /* renamed from: t */
    private static volatile IRetryDelayTimeCalculator f21861t;
    /* renamed from: u */
    private static volatile IMonitorConfig f21862u;
    /* renamed from: v */
    private static volatile List<ProcessCallback> f21863v = new ArrayList();
    /* renamed from: w */
    private static volatile boolean f21864w = false;
    /* renamed from: x */
    private static volatile C8513x f21865x = null;
    /* renamed from: y */
    private static volatile AlarmManager f21866y;
    /* renamed from: z */
    private static boolean f21867z = false;

    private C6694b() {
    }

    /* renamed from: a */
    static synchronized void m27357a(DownloaderBuilder gVar) {
        synchronized (C6694b.class) {
            if (f21841K) {
                C6704a.m27762e("DownloadComponentManager", "component has init");
                return;
            }
            boolean z = f21864w;
            if (gVar != null) {
                m27353a(gVar.mo31934a());
                m27360a(gVar.mo31938b());
                m27361a(gVar.mo31939c());
                m27359a(gVar.mo31948l());
                m27355a(gVar.mo31954r());
                m27352a(gVar.mo31947k());
                m27364a(gVar.mo31940d());
                m27363a(gVar.mo31941e());
                m27362a(gVar.mo31942f());
                m27367b(gVar.mo31943g());
                m27370c(gVar.mo31944h());
                m27372d(gVar.mo31945i());
                m27365a(gVar.mo31946j());
                if (gVar.mo31952p() != null) {
                    f21862u = gVar.mo31952p();
                }
                if (gVar.mo31950n() > 1024) {
                    f21835E = gVar.mo31950n();
                }
                m27358a(gVar.mo31949m());
                if (gVar.mo31951o()) {
                    f21864w = true;
                }
                f21838H = gVar.mo31953q();
                m27366a(gVar.mo31955s());
            }
            if (f21843b == null) {
                f21843b = new DefaultDownloadCache();
            }
            if (f21848g == null) {
                f21848g = new DefaultDownloadServiceHandler();
            }
            if (f21849h == null) {
                f21849h = new IndependentDownloadServiceHandler();
            }
            if (f21844c == null) {
                f21844c = new DefaultIdGenerator();
            }
            if (f21847f == null) {
                f21847f = new DefaultDownloadEngine();
            }
            if (f21845d == null) {
                f21845d = new DefaultChunkCntCalculator();
            }
            if (f21859r == null) {
                f21859r = new DefaultChunkAdjustCalculator();
            }
            if (f21861t == null) {
                f21861t = new DefaultRetryDelayTimeCalculator();
            }
            if (f21831A <= 0 || f21831A > f21832B) {
                f21831A = f21832B;
            }
            m27345E();
            if (f21864w && !z && !DownloadUtils.m28801c()) {
                DownloadProxy.m28368a(true).mo32046d();
            } else if (DownloadUtils.m28807d()) {
                ExecutorService k = m27379k();
                if (k != null) {
                    k.execute(new Runnable() {
                        public void run() {
                            Context B = C6694b.m27342B();
                            if (B != null) {
                                DownloadUtils.m28799c(B);
                            }
                        }
                    });
                }
            } else {
                Context B = m27342B();
                if (B != null) {
                    DownloadUtils.m28799c(B);
                }
            }
            DownloadPreconnecter.m28192a();
            f21841K = true;
        }
    }

    /* renamed from: E */
    private static void m27345E() {
        if (f21860s == null) {
            f21860s = new DownloadReceiver();
        }
        if (!f21867z) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f21842a.registerReceiver(f21860s, intentFilter);
                f21867z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m27351a() {
        synchronized (C6694b.class) {
            if (!f21864w) {
                f21864w = true;
                try {
                    Intent intent = new Intent(m27342B(), DownloadHandleService.class);
                    intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                    m27342B().startService(intent);
                    if (!DownloadUtils.m28801c()) {
                        DownloadProxy.m28368a(true).mo32046d();
                    }
                } catch (Throwable th) {
                    f21864w = false;
                    th.printStackTrace();
                }
            } else {
                return;
            }
        }
        return;
    }

    /* renamed from: b */
    public static synchronized boolean m27368b() {
        boolean z;
        synchronized (C6694b.class) {
            z = f21864w;
        }
        return z;
    }

    /* renamed from: c */
    public static IDownloadHttpService m27369c() {
        if (f21850i == null) {
            synchronized (C6694b.class) {
                if (f21850i == null) {
                    f21850i = new DefaultDownloadHttpService();
                }
            }
        }
        return f21850i;
    }

    /* renamed from: a */
    public static void m27356a(ProcessCallback hVar) {
        if (hVar != null) {
            synchronized (f21863v) {
                f21863v.add(hVar);
            }
        }
    }

    /* renamed from: d */
    public static List<ProcessCallback> m27371d() {
        List<ProcessCallback> list;
        synchronized (f21863v) {
            list = f21863v;
        }
        return list;
    }

    /* renamed from: a */
    public static void m27354a(DownloadCacheSyncStatus dVar) {
        synchronized (f21837G) {
            if (f21837G != null) {
                for (IDownloadCacheSyncStatusListener rVar : f21837G) {
                    if (rVar != null) {
                        if (dVar == DownloadCacheSyncStatus.SYNC_START) {
                            rVar.mo31803a();
                        } else if (dVar == DownloadCacheSyncStatus.SYNC_SUCCESS) {
                            rVar.mo31804b();
                        }
                    }
                }
                f21837G.clear();
            }
        }
    }

    /* renamed from: e */
    public static IDownloadHeadHttpService m27373e() {
        if (f21851j == null) {
            synchronized (C6694b.class) {
                if (f21851j == null) {
                    f21851j = new DefaultDownloadHeadHttpService();
                }
            }
        }
        return f21851j;
    }

    /* renamed from: a */
    public static IDownloadHttpConnection m27350a(boolean z, int i, String str, List<HttpHeader> list) throws BaseException, IOException {
        Throwable e;
        IDownloadHttpService c = m27369c();
        if (c != null || z) {
            IDownloadHttpConnection eVar = null;
            if (c != null) {
                try {
                    e = null;
                    eVar = c.mo16498a(i, str, list);
                } catch (IOException e2) {
                    e = e2;
                }
            } else {
                e = null;
            }
            if (z && eVar == null && (c == null || c.getClass() != DefaultDownloadHttpService.class)) {
                IDownloadHttpService f = m27374f();
                if (f != null) {
                    eVar = f.mo16498a(i, str, list);
                }
            }
            if (eVar != null || e == null) {
                return eVar;
            }
            throw e;
        }
        throw new BaseException(1022, (Throwable) new IOException("download can't continue, because httpService not exist"));
    }

    /* renamed from: a */
    public static IDownloadHeadHttpConnection m27349a(String str, List<HttpHeader> list) throws BaseException, IOException {
        Throwable e;
        IDownloadHeadHttpService e2 = m27373e();
        IDownloadHeadHttpConnection cVar = null;
        if (e2 != null) {
            try {
                cVar = e2.mo32468a(str, list);
                e = null;
            } catch (IOException e3) {
                e = e3;
            }
        } else {
            e = null;
        }
        if (cVar == null) {
            IDownloadHeadHttpService g = m27375g();
            if (g != null) {
                cVar = g.mo32468a(str, list);
            }
        }
        if (cVar != null || e == null) {
            return cVar;
        }
        throw e;
    }

    /* renamed from: f */
    public static IDownloadHttpService m27374f() {
        if (f21852k == null) {
            synchronized (C6694b.class) {
                if (f21852k == null) {
                    f21852k = new DefaultDownloadHttpService();
                }
            }
        }
        return f21852k;
    }

    /* renamed from: g */
    public static IDownloadHeadHttpService m27375g() {
        if (f21853l == null) {
            synchronized (C6694b.class) {
                if (f21853l == null) {
                    f21853l = new DefaultDownloadHeadHttpService();
                }
            }
        }
        return f21853l;
    }

    /* renamed from: h */
    public static AlarmManager m27376h() {
        if (f21866y == null) {
            synchronized (C6694b.class) {
                if (f21866y == null && f21842a != null) {
                    f21866y = (AlarmManager) f21842a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
            }
        }
        return f21866y;
    }

    /* renamed from: a */
    public static synchronized void m27362a(IDownloadLaunchHandler mVar) {
        synchronized (C6694b.class) {
            if (mVar != null) {
                f21854m = mVar;
                if (f21843b instanceof DefaultDownloadCache) {
                    ((DefaultDownloadCache) f21843b).mo32514g();
                }
            }
        }
    }

    /* renamed from: b */
    private static void m27367b(ExecutorService executorService) {
        if (executorService != null) {
            f21855n = executorService;
        }
    }

    /* renamed from: c */
    private static void m27370c(ExecutorService executorService) {
        if (executorService != null) {
            f21856o = executorService;
        }
    }

    /* renamed from: d */
    private static void m27372d(ExecutorService executorService) {
        if (executorService != null) {
            f21857p = executorService;
        }
    }

    /* renamed from: a */
    public static void m27365a(ExecutorService executorService) {
        if (executorService != null) {
            f21858q = executorService;
        }
    }

    /* renamed from: i */
    public static synchronized IMonitorConfig m27377i() {
        IMonitorConfig qVar;
        synchronized (C6694b.class) {
            qVar = f21862u;
        }
        return qVar;
    }

    /* renamed from: j */
    public static ExecutorService m27378j() {
        if (f21855n == null) {
            synchronized (C6694b.class) {
                if (f21855n == null) {
                    int F = m27346F();
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(F, F, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C6745a("DownloadThreadPool-cpu-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    f21855n = threadPoolExecutor;
                }
            }
        }
        return f21855n;
    }

    /* renamed from: k */
    public static ExecutorService m27379k() {
        if (f21856o == null) {
            synchronized (C6694b.class) {
                if (f21856o == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f21833C, f21833C, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C6745a("DownloadThreadPool-io-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    f21856o = threadPoolExecutor;
                }
            }
        }
        return f21856o;
    }

    /* renamed from: l */
    public static ExecutorService m27380l() {
        if (f21858q == null) {
            synchronized (C6694b.class) {
                if (f21858q == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f21833C, f21833C, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C6745a("DownloadThreadPool-chunk-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    f21858q = threadPoolExecutor;
                }
            }
        }
        return f21858q;
    }

    /* renamed from: m */
    public static ExecutorService m27381m() {
        if (f21857p == null) {
            synchronized (C6694b.class) {
                if (f21857p == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f21834D, f21834D, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C6745a("DownloadThreadPool-db-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    f21857p = threadPoolExecutor;
                }
            }
        }
        return f21857p;
    }

    /* renamed from: n */
    public static C8513x m27382n() {
        if (f21865x == null) {
            synchronized (C6694b.class) {
                if (f21865x == null) {
                    C8515a aVar = new C8515a();
                    aVar.mo40622a(30000, TimeUnit.MILLISECONDS).mo40633b(30000, TimeUnit.MILLISECONDS).mo40636c(30000, TimeUnit.MILLISECONDS).mo40635b(true).mo40629a(new C8495n(m27379k())).mo40631a(true).mo40623a(Collections.singletonList(Protocol.HTTP_1_1));
                    f21865x = aVar.mo40632a();
                }
            }
        }
        return f21865x;
    }

    /* renamed from: o */
    public static synchronized IDownloadLaunchHandler m27383o() {
        IDownloadLaunchHandler mVar;
        synchronized (C6694b.class) {
            mVar = f21854m;
        }
        return mVar;
    }

    /* renamed from: a */
    private static void m27364a(IDownloadHttpService fVar) {
        if (fVar != null) {
            f21850i = fVar;
        }
        f21836F = f21850i != null;
    }

    /* renamed from: a */
    private static void m27363a(IDownloadHeadHttpService dVar) {
        if (dVar != null) {
            f21851j = dVar;
        }
    }

    /* renamed from: p */
    public static IDownloadCache m27384p() {
        if (f21843b == null) {
            synchronized (C6694b.class) {
                if (f21843b == null) {
                    f21843b = new DefaultDownloadCache();
                }
            }
        }
        return f21843b;
    }

    /* renamed from: a */
    private static void m27360a(IDownloadCache kVar) {
        if (kVar != null) {
            f21843b = kVar;
        }
    }

    /* renamed from: q */
    public static IDownloadServiceHandler m27385q() {
        if (f21848g == null) {
            synchronized (C6694b.class) {
                if (f21848g == null) {
                    f21848g = new DefaultDownloadServiceHandler();
                }
            }
        }
        return f21848g;
    }

    /* renamed from: r */
    public static IDownloadServiceHandler m27386r() {
        if (f21849h == null) {
            synchronized (C6694b.class) {
                if (f21849h == null) {
                    f21849h = new IndependentDownloadServiceHandler();
                }
            }
        }
        return f21849h;
    }

    /* renamed from: s */
    public static IDownloadIdGenerator m27387s() {
        if (f21844c == null) {
            synchronized (C6694b.class) {
                if (f21844c == null) {
                    f21844c = new DefaultIdGenerator();
                }
            }
        }
        return f21844c;
    }

    /* renamed from: t */
    public static AbsDownloadEngine m27388t() {
        if (f21847f == null) {
            synchronized (C6694b.class) {
                if (f21847f == null) {
                    f21847f = new DefaultDownloadEngine();
                }
            }
        }
        return f21847f;
    }

    /* renamed from: a */
    private static void m27361a(IDownloadIdGenerator lVar) {
        if (lVar != null) {
            f21844c = lVar;
        }
    }

    /* renamed from: F */
    private static int m27346F() {
        int i = f21831A;
        if (i <= 0 || i > f21832B) {
            f21831A = f21832B;
        }
        return f21831A;
    }

    /* renamed from: a */
    private static void m27352a(int i) {
        if (i > 0) {
            f21831A = i;
        }
    }

    /* renamed from: u */
    public static int m27389u() {
        return f21838H;
    }

    /* renamed from: v */
    public static JSONObject m27390v() {
        if (f21839I == null) {
            synchronized (C6694b.class) {
                if (f21839I == null) {
                    f21839I = new JSONObject();
                }
            }
        }
        return f21839I;
    }

    /* renamed from: a */
    public static void m27366a(JSONObject jSONObject) {
        if (f21839I != jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            f21839I = jSONObject;
            DownloadSetting.m28614a();
        }
    }

    /* renamed from: w */
    public static synchronized int m27391w() {
        int i;
        synchronized (C6694b.class) {
            i = f21835E;
        }
        return i;
    }

    /* renamed from: x */
    public static IChunkCntCalculator m27392x() {
        if (f21845d == null) {
            synchronized (C6694b.class) {
                if (f21845d == null) {
                    f21845d = new DefaultChunkCntCalculator();
                }
            }
        }
        return f21845d;
    }

    /* renamed from: a */
    private static void m27359a(IChunkCntCalculator iVar) {
        if (iVar != null) {
            f21845d = iVar;
        }
    }

    /* renamed from: a */
    public static void m27355a(INotificationClickCallback dVar) {
        if (dVar != null) {
            f21846e = dVar;
        }
    }

    /* renamed from: y */
    public static INotificationClickCallback m27393y() {
        return f21846e;
    }

    /* renamed from: z */
    public static IChunkAdjustCalculator m27394z() {
        if (f21859r == null) {
            synchronized (C6694b.class) {
                if (f21859r == null) {
                    f21859r = new DefaultChunkAdjustCalculator();
                }
            }
        }
        return f21859r;
    }

    /* renamed from: a */
    private static void m27358a(IChunkAdjustCalculator hVar) {
        if (hVar != null) {
            f21859r = hVar;
        }
    }

    /* renamed from: A */
    public static IRetryDelayTimeCalculator m27341A() {
        if (f21861t == null) {
            synchronized (C6694b.class) {
                if (f21861t == null) {
                    f21861t = new DefaultRetryDelayTimeCalculator();
                }
            }
        }
        return f21861t;
    }

    /* renamed from: B */
    public static synchronized Context m27342B() {
        Context context;
        synchronized (C6694b.class) {
            context = f21842a;
        }
        return context;
    }

    /* renamed from: a */
    public static synchronized void m27353a(Context context) {
        synchronized (C6694b.class) {
            if (context != null) {
                if (f21842a == null) {
                    f21842a = context.getApplicationContext();
                    AppStatusManager.m26964a().mo31646b();
                }
            }
        }
    }

    /* renamed from: a */
    public static int m27347a(DownloadInfo cVar) {
        if (cVar == null) {
            return 0;
        }
        return m27348a(cVar.mo32295j(), cVar.mo32297k());
    }

    /* renamed from: a */
    public static int m27348a(String str, String str2) {
        IDownloadIdGenerator s = m27387s();
        if (s == null) {
            return 0;
        }
        return s.mo32011a(str, str2);
    }

    /* renamed from: C */
    public static synchronized boolean m27343C() {
        boolean z;
        synchronized (C6694b.class) {
            z = f21836F;
        }
        return z;
    }

    /* renamed from: D */
    public static IDownloadGlobalMonitorListener m27344D() {
        return f21840J;
    }
}
