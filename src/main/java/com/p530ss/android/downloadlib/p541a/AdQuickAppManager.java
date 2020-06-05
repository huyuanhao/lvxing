package com.p530ss.android.downloadlib.p541a;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.C6588h;
import com.p530ss.android.downloadlib.p549e.C6588h.C6589a;
import com.p530ss.android.downloadlib.p549e.TLogger;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ss.android.downloadlib.a.d */
public class AdQuickAppManager implements C6589a {
    /* renamed from: a */
    private static String f21341a = AdQuickAppManager.class.getSimpleName();
    /* renamed from: b */
    private static volatile AdQuickAppManager f21342b;
    /* renamed from: c */
    private C6588h f21343c;
    /* renamed from: d */
    private ConcurrentHashMap<Long, Runnable> f21344d;

    public AdQuickAppManager() {
        this.f21344d = null;
        this.f21344d = new ConcurrentHashMap<>();
        this.f21343c = new C6588h(Looper.getMainLooper(), this);
    }

    /* renamed from: a */
    public static AdQuickAppManager m26221a() {
        if (f21342b == null) {
            synchronized (AdQuickAppManager.class) {
                if (f21342b == null) {
                    f21342b = new AdQuickAppManager();
                }
            }
        }
        return f21342b;
    }

    /* renamed from: a */
    public void mo31256a(Message message) {
        if (message != null) {
            boolean a = C6565j.m26377k() != null ? C6565j.m26377k().mo16475a() : false;
            long j = 0;
            if (message.obj instanceof Long) {
                j = ((Long) message.obj).longValue();
            }
            int i = message.what;
            if (i != 4) {
                if (i != 5) {
                    if (i == 7) {
                        Runnable runnable = (Runnable) this.f21344d.get(Long.valueOf(j));
                        this.f21344d.remove(Long.valueOf(j));
                        if (a) {
                            AdEventHandler.m26446a().mo31391a(j, 1);
                            AdEventHandler.m26446a().mo31394a(j, true, 1);
                        } else {
                            if (runnable != null) {
                                this.f21343c.post(runnable);
                            }
                            AdEventHandler.m26446a().mo31394a(j, false, 1);
                        }
                    }
                } else if (a) {
                    AdEventHandler.m26446a().mo31394a(j, true, 1);
                }
            } else if (a) {
                AdEventHandler.m26446a().mo31394a(j, true, 2);
            }
        }
    }

    /* renamed from: a */
    public void mo31299a(int i, C6507c cVar, DownloadEventConfig bVar) {
        String str = f21341a;
        StringBuilder sb = new StringBuilder();
        sb.append("sendQuickAppMsg msgWhat:");
        sb.append(i);
        TLogger.m26504a(str, sb.toString(), null);
        if (this.f21343c != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = Long.valueOf(cVar.mo31064d());
            this.f21343c.sendMessageDelayed(obtain, mo31300b());
        }
    }

    /* renamed from: b */
    public long mo31300b() {
        return C6565j.m26375i().optLong("quick_app_check_internal", 1200);
    }

    /* renamed from: a */
    public static boolean m26222a(C6507c cVar) {
        return (cVar == null || cVar.mo31085y() == null || TextUtils.isEmpty(cVar.mo31085y().mo31141a())) ? false : true;
    }

    /* renamed from: a */
    public static boolean m26223a(DownloadInfo cVar) {
        return cVar == null || cVar.mo32308q() == 0 || cVar.mo32308q() == -4;
    }
}
