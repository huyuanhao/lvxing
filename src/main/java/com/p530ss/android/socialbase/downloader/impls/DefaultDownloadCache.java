package com.p530ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.p530ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.p530ss.android.socialbase.downloader.p557b.DownloadCacheSyncStatus;
import com.p530ss.android.socialbase.downloader.p558c.SqlCacheLoadCompleteCallback;
import com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache;
import com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCacheAidlWrapper;
import com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCacheAidlWrapper.C6660a;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p568l.WeakDownloadHandler;
import com.p530ss.android.socialbase.downloader.p568l.WeakDownloadHandler.C6749a;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.p530ss.android.socialbase.downloader.p569m.SystemUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.d */
public class DefaultDownloadCache implements IDownloadCache {
    /* renamed from: a */
    private final DownloadCache f22191a = new DownloadCache();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ISqlDownloadCache f22192b;
    /* renamed from: c */
    private volatile boolean f22193c;
    /* renamed from: d */
    private volatile boolean f22194d;
    /* renamed from: e */
    private C6749a f22195e = new C6749a() {
        /* renamed from: a */
        public void mo31460a(Message message) {
            if (message.what == 1) {
                C6694b.m27379k().execute(new Runnable() {
                    public void run() {
                        try {
                            SystemUtils.m28952a();
                            DefaultDownloadCache.this.mo32515h();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    /* renamed from: f */
    private WeakDownloadHandler f22196f = null;

    public DefaultDownloadCache() {
        if (!DownloadSetting.m28617b().mo32550a("fix_sigbus_downloader_db")) {
            this.f22192b = new SqlDownloadCache();
        } else if (DownloadUtils.m28769a()) {
            this.f22192b = new SqlDownloadCache();
        } else {
            SqlDownloadCacheAidlWrapper fVar = new SqlDownloadCacheAidlWrapper();
            fVar.mo31718a((C6660a) new C6660a() {
                /* renamed from: a */
                public void mo31725a() {
                    DefaultDownloadCache.this.f22192b = new SqlDownloadCache();
                    Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
            this.f22192b = fVar;
        }
        this.f22193c = false;
        this.f22196f = new WeakDownloadHandler(Looper.getMainLooper(), this.f22195e);
        mo32513f();
    }

    /* renamed from: a */
    public DownloadCache mo32511a() {
        return this.f22191a;
    }

    /* renamed from: e */
    public ISqlDownloadCache mo32512e() {
        return this.f22192b;
    }

    /* renamed from: g */
    public DownloadInfo mo31695g(int i) {
        DownloadInfo g = this.f22191a.mo31695g(i);
        m28270c(g);
        return g;
    }

    /* renamed from: f */
    public void mo32513f() {
        C6694b.m27354a(DownloadCacheSyncStatus.SYNC_START);
        this.f22192b.mo31704a(this.f22191a.mo32517a(), this.f22191a.mo32518e(), new SqlCacheLoadCompleteCallback() {
            /* renamed from: a */
            public void mo31702a() {
                DefaultDownloadCache.this.m28271i();
                DefaultDownloadCache.this.mo32514g();
                C6694b.m27354a(DownloadCacheSyncStatus.SYNC_SUCCESS);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m28271i() {
        synchronized (this) {
            this.f22193c = true;
            notifyAll();
        }
    }

    /* renamed from: d */
    public boolean mo31691d() {
        if (this.f22193c) {
            return true;
        }
        synchronized (this) {
            if (!this.f22193c) {
                C6704a.m27761d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                C6704a.m27761d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.f22193c;
    }

    /* renamed from: c */
    public boolean mo31687c() {
        return this.f22193c;
    }

    /* renamed from: g */
    public void mo32514g() {
        long j = DownloadSetting.m28617b().mo32550a("task_resume_delay") ? 4000 : VERSION.SDK_INT >= 23 ? 1000 : 5000;
        this.f22196f.sendMessageDelayed(this.f22196f.obtainMessage(1), j);
    }

    /* renamed from: h */
    public void mo32515h() {
        if (this.f22193c) {
            if (this.f22194d) {
                C6704a.m27758b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f22194d = true;
            if (DownloadUtils.m28769a()) {
                IDownloadLaunchHandler o = C6694b.m27383o();
                if (o != null) {
                    List a = o.mo31502a();
                    if (a != null && !a.isEmpty()) {
                        SparseArray a2 = this.f22191a.mo32517a();
                        if (a2 != null) {
                            ArrayList arrayList = new ArrayList();
                            synchronized (a2) {
                                for (int i = 0; i < a2.size(); i++) {
                                    int keyAt = a2.keyAt(i);
                                    if (keyAt != 0) {
                                        DownloadInfo cVar = (DownloadInfo) a2.get(keyAt);
                                        if (cVar != null && a.contains(cVar.mo32231ah())) {
                                            if (cVar.mo32315w() != -2) {
                                                arrayList.add(cVar);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                o.mo31503a(arrayList);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public DownloadInfo mo31677b(int i) {
        return this.f22191a.mo31677b(i);
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31667a(String str) {
        return this.f22191a.mo31667a(str);
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31679b(String str) {
        return this.f22191a.mo31679b(str);
    }

    /* renamed from: c */
    public List<DownloadInfo> mo31686c(String str) {
        return this.f22191a.mo31686c(str);
    }

    /* renamed from: d */
    public List<DownloadInfo> mo31689d(String str) {
        return this.f22191a.mo31689d(str);
    }

    /* renamed from: c */
    public List<DownloadChunk> mo31685c(int i) {
        return this.f22191a.mo31685c(i);
    }

    /* renamed from: d */
    public void mo31690d(int i) {
        this.f22191a.mo31690d(i);
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32062o(i);
            } else {
                this.f22192b.mo31690d(i);
            }
        } else {
            this.f22192b.mo31690d(i);
        }
    }

    /* renamed from: a */
    public void mo31674a(DownloadChunk bVar) {
        this.f22191a.mo31674a(bVar);
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32026a(bVar);
            } else {
                this.f22192b.mo31674a(bVar);
            }
        } else {
            this.f22192b.mo31674a(bVar);
        }
    }

    /* renamed from: b */
    public void mo31682b(DownloadChunk bVar) {
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32026a(bVar);
            } else {
                this.f22192b.mo31674a(bVar);
            }
        } else {
            this.f22192b.mo31674a(bVar);
        }
    }

    /* renamed from: a */
    public void mo31671a(int i, int i2, long j) {
        this.f22191a.mo31671a(i, i2, j);
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32019a(i, i2, j);
            } else {
                this.f22192b.mo31671a(i, i2, j);
            }
        } else {
            this.f22192b.mo31671a(i, i2, j);
        }
    }

    /* renamed from: a */
    public void mo31670a(int i, int i2, int i3, long j) {
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32018a(i, i2, i3, j);
            } else {
                this.f22192b.mo31670a(i, i2, i3, j);
            }
        } else {
            this.f22192b.mo31670a(i, i2, i3, j);
        }
    }

    /* renamed from: a */
    public void mo31669a(int i, int i2, int i3, int i4) {
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32017a(i, i2, i3, i4);
            } else {
                this.f22192b.mo31669a(i, i2, i3, i4);
            }
        } else {
            this.f22192b.mo31669a(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public DownloadInfo mo31664a(int i, int i2) {
        DownloadInfo a = this.f22191a.mo31664a(i, i2);
        m28270c(a);
        return a;
    }

    /* renamed from: a */
    public boolean mo31676a(DownloadInfo cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a = this.f22191a.mo31676a(cVar);
        m28270c(cVar);
        return a;
    }

    /* renamed from: e */
    public boolean mo31693e(int i) {
        try {
            if (DownloadUtils.m28789b()) {
                IDownloadProxy a = DownloadProxy.m28368a(true);
                if (a != null) {
                    a.mo32061n(i);
                } else {
                    this.f22192b.mo31693e(i);
                }
            } else {
                this.f22192b.mo31693e(i);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return this.f22191a.mo31693e(i);
    }

    /* renamed from: f */
    public boolean mo31694f(int i) {
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32063p(i);
            } else {
                this.f22192b.mo31694f(i);
            }
        } else {
            this.f22192b.mo31694f(i);
        }
        return this.f22191a.mo31694f(i);
    }

    /* renamed from: b */
    public void mo31680b() {
        try {
            this.f22191a.mo31680b();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (DownloadUtils.m28789b()) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32052f();
            } else {
                this.f22192b.mo31680b();
            }
        } else {
            this.f22192b.mo31680b();
        }
    }

    /* renamed from: a */
    public DownloadInfo mo31666a(int i, long j, String str, String str2) {
        DownloadInfo a = this.f22191a.mo31666a(i, j, str, str2);
        m28270c(a);
        return a;
    }

    /* renamed from: a */
    public DownloadInfo mo31665a(int i, long j) {
        DownloadInfo a = this.f22191a.mo31665a(i, j);
        m28268a(a, false);
        return a;
    }

    /* renamed from: c */
    private void m28270c(DownloadInfo cVar) {
        m28268a(cVar, true);
    }

    /* renamed from: a */
    private void m28268a(DownloadInfo cVar, boolean z) {
        if (cVar != null) {
            if (!DownloadUtils.m28789b()) {
                this.f22192b.mo31676a(cVar);
            } else if (z) {
                IDownloadProxy a = DownloadProxy.m28368a(true);
                if (a != null) {
                    a.mo32044c(cVar);
                } else {
                    this.f22192b.mo31676a(cVar);
                }
            }
        }
    }

    /* renamed from: b */
    public DownloadInfo mo31678b(int i, long j) {
        DownloadInfo b = this.f22191a.mo31678b(i, j);
        mo31681b(i, null);
        return b;
    }

    /* renamed from: h */
    public DownloadInfo mo31696h(int i) {
        DownloadInfo h = this.f22191a.mo31696h(i);
        m28270c(h);
        return h;
    }

    /* renamed from: c */
    public DownloadInfo mo31684c(int i, long j) {
        DownloadInfo c = this.f22191a.mo31684c(i, j);
        mo31681b(i, null);
        return c;
    }

    /* renamed from: d */
    public DownloadInfo mo31688d(int i, long j) {
        DownloadInfo d = this.f22191a.mo31688d(i, j);
        mo31681b(i, null);
        return d;
    }

    /* renamed from: i */
    public DownloadInfo mo31697i(int i) {
        DownloadInfo i2 = this.f22191a.mo31697i(i);
        m28270c(i2);
        return i2;
    }

    /* renamed from: j */
    public DownloadInfo mo31698j(int i) {
        DownloadInfo j = this.f22191a.mo31698j(i);
        m28270c(j);
        return j;
    }

    /* renamed from: b */
    public void mo31683b(DownloadInfo cVar) {
        if (cVar != null) {
            this.f22191a.mo31676a(cVar);
        }
    }

    /* renamed from: a */
    public void mo31672a(int i, List<DownloadChunk> list) {
        if (list != null && list.size() != 0) {
            this.f22191a.mo31672a(i, list);
            if (DownloadUtils.m28801c()) {
                this.f22192b.mo31681b(i, list);
            }
        }
    }

    /* renamed from: b */
    public void mo31681b(int i, List<DownloadChunk> list) {
        try {
            mo31676a(this.f22191a.mo31677b(i));
            if (list == null) {
                list = this.f22191a.mo31685c(i);
            }
            if (DownloadUtils.m28789b()) {
                IDownloadProxy a = DownloadProxy.m28368a(true);
                if (a != null) {
                    a.mo32034b(i, list);
                } else {
                    this.f22192b.mo31681b(i, list);
                }
            } else {
                this.f22192b.mo31681b(i, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
