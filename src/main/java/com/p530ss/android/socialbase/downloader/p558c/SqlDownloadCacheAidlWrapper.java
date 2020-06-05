package com.p530ss.android.socialbase.downloader.p558c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.p530ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.p530ss.android.socialbase.downloader.p558c.ISqlCacheLoadCompleteCallbackAidl.C6640a;
import com.p530ss.android.socialbase.downloader.p558c.ISqlDownloadCacheAidl.C6642a;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ss.android.socialbase.downloader.c.f */
public class SqlDownloadCacheAidlWrapper implements ServiceConnection, ISqlDownloadCache {
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static boolean f21765b;
    /* renamed from: c */
    private static int f21766c;
    /* renamed from: d */
    private static long f21767d;
    /* renamed from: a */
    private ISqlDownloadCacheAidl f21768a;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Handler f21769e = new Handler(Looper.getMainLooper());
    /* renamed from: f */
    private ISqlCacheLoadCompleteCallbackAidl f21770f = null;
    /* renamed from: g */
    private CountDownLatch f21771g = new CountDownLatch(1);
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C6660a f21772h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public Runnable f21773i = new Runnable() {
        public void run() {
            if (!SqlDownloadCacheAidlWrapper.f21765b && SqlDownloadCacheAidlWrapper.this.f21772h != null) {
                SqlDownloadCacheAidlWrapper.this.f21772h.mo31725a();
            }
        }
    };

    /* compiled from: SqlDownloadCacheAidlWrapper */
    /* renamed from: com.ss.android.socialbase.downloader.c.f$a */
    public interface C6660a {
        /* renamed from: a */
        void mo31725a();
    }

    public SqlDownloadCacheAidlWrapper() {
        SqlDownloadCacheService.m27322a(C6694b.m27342B(), this);
    }

    /* renamed from: a */
    public void mo31718a(C6660a aVar) {
        this.f21772h = aVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        f21765b = true;
        this.f21769e.removeCallbacks(this.f21773i);
        synchronized (this) {
            try {
                this.f21768a = C6642a.m27027a(iBinder);
                if (!(this.f21770f == null || this.f21768a == null)) {
                    this.f21768a.mo31673a(this.f21770f);
                }
                iBinder.linkToDeath(new DeathRecipient() {
                    public void binderDied() {
                        SqlDownloadCacheAidlWrapper.f21765b = false;
                        if (!SqlDownloadCacheAidlWrapper.this.m27140f() && SqlDownloadCacheAidlWrapper.this.f21772h != null) {
                            SqlDownloadCacheAidlWrapper.this.f21769e.postDelayed(SqlDownloadCacheAidlWrapper.this.f21773i, 2000);
                        }
                    }
                }, 0);
                countDownLatch = this.f21771g;
            } catch (Throwable th) {
                this.f21771g.countDown();
                throw th;
            }
            countDownLatch.countDown();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f21768a = null;
        f21765b = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m27140f() {
        if (VERSION.SDK_INT >= 26 || f21765b) {
            return false;
        }
        String str = "SqlDownloadCacheAidlWra";
        if (f21766c > 5) {
            C6704a.m27761d(str, "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f21767d < 15000) {
            C6704a.m27761d(str, "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        f21766c++;
        f21767d = currentTimeMillis;
        this.f21769e.postDelayed(new Runnable() {
            public void run() {
                SqlDownloadCacheService.m27322a(C6694b.m27342B(), SqlDownloadCacheAidlWrapper.this);
            }
        }, 1000);
        return true;
    }

    /* renamed from: a */
    public void mo31704a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<DownloadChunk>> sparseArray2, final SqlCacheLoadCompleteCallback dVar) {
        C6694b.m27379k().submit(new Runnable() {
            public void run() {
                SqlDownloadCacheAidlWrapper.this.mo31717a((ISqlCacheLoadCompleteCallbackAidl) new C6640a() {
                    /* renamed from: a */
                    public void mo31660a(Map map, Map map2) {
                        DownloadUtils.m28762a(sparseArray, map);
                        DownloadUtils.m28762a(sparseArray2, map2);
                        dVar.mo31702a();
                        SqlDownloadCacheAidlWrapper.this.mo31717a((ISqlCacheLoadCompleteCallbackAidl) null);
                    }
                });
                SqlDownloadCacheAidlWrapper.this.mo31716a();
            }
        });
    }

    /* renamed from: a */
    public void mo31717a(ISqlCacheLoadCompleteCallbackAidl bVar) {
        synchronized (this) {
            if (this.f21768a != null) {
                try {
                    this.f21768a.mo31673a(bVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.f21770f = bVar;
            }
        }
    }

    /* renamed from: a */
    public void mo31716a() {
        try {
            this.f21771g.await(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31668a();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public DownloadInfo mo31677b(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31677b(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31667a(String str) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31667a(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31679b(String str) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31679b(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: c */
    public List<DownloadInfo> mo31686c(String str) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31686c(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: d */
    public List<DownloadInfo> mo31689d(String str) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31689d(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: c */
    public List<DownloadChunk> mo31685c(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31685c(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: d */
    public void mo31690d(int i) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31690d(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo31674a(DownloadChunk bVar) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31674a(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo31682b(DownloadChunk bVar) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31682b(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo31671a(int i, int i2, long j) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31671a(i, i2, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo31670a(int i, int i2, int i3, long j) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31670a(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo31669a(int i, int i2, int i3, int i4) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31669a(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public DownloadInfo mo31664a(int i, int i2) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31664a(i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo31676a(DownloadInfo cVar) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31676a(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: e */
    public boolean mo31693e(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31693e(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo31694f(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31694f(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public void mo31680b() {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31680b();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public DownloadInfo mo31695g(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31695g(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public DownloadInfo mo31666a(int i, long j, String str, String str2) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31666a(i, j, str, str2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public DownloadInfo mo31665a(int i, long j) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31665a(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: b */
    public DownloadInfo mo31678b(int i, long j) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31678b(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: h */
    public DownloadInfo mo31696h(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31696h(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: c */
    public DownloadInfo mo31684c(int i, long j) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31684c(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: d */
    public DownloadInfo mo31688d(int i, long j) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31688d(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: i */
    public DownloadInfo mo31697i(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31697i(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: j */
    public DownloadInfo mo31698j(int i) {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31698j(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: c */
    public boolean mo31687c() {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31687c();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: d */
    public boolean mo31691d() {
        try {
            if (this.f21768a != null) {
                return this.f21768a.mo31691d();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public void mo31683b(DownloadInfo cVar) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31683b(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo31672a(int i, List<DownloadChunk> list) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31672a(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo31681b(int i, List<DownloadChunk> list) {
        try {
            if (this.f21768a != null) {
                this.f21768a.mo31681b(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
