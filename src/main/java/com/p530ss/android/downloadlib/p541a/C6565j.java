package com.p530ss.android.downloadlib.p541a;

import android.content.Context;
import android.os.Environment;
import com.p530ss.android.downloadlib.p546b.DefaultDownloadUIFactory;
import com.p530ss.android.downloadlib.p546b.DefaultPermissionChecker;
import com.p530ss.android.downloadlib.p549e.AntiHijackUtils;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.p531a.p532a.p533a.AppStatusChangeListener;
import com.p530ss.android.p531a.p532a.p533a.DownloadActionListener;
import com.p530ss.android.p531a.p532a.p533a.DownloadAutoInstallInterceptListener;
import com.p530ss.android.p531a.p532a.p533a.DownloadClearSpaceListener;
import com.p530ss.android.p531a.p532a.p533a.DownloadEventLogger;
import com.p530ss.android.p531a.p532a.p533a.DownloadNetworkFactory;
import com.p530ss.android.p531a.p532a.p533a.DownloadPermissionChecker;
import com.p530ss.android.p531a.p532a.p533a.DownloadSettings;
import com.p530ss.android.p531a.p532a.p533a.DownloadTLogger;
import com.p530ss.android.p531a.p532a.p533a.DownloadUIFactory;
import com.p530ss.android.p531a.p532a.p533a.ICleanManager;
import com.p530ss.android.p531a.p532a.p533a.IDownloadCustomChecker;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p536c.C6512a;
import com.p530ss.android.p531a.p532a.p536c.C6512a.C6513a;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadMonitorListener;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* compiled from: GlobalInfo */
/* renamed from: com.ss.android.downloadlib.a.j */
public class C6565j {
    /* renamed from: a */
    private static Context f21384a;
    /* renamed from: b */
    private static DownloadEventLogger f21385b;
    /* renamed from: c */
    private static DownloadActionListener f21386c;
    /* renamed from: d */
    private static DownloadUIFactory f21387d;
    /* renamed from: e */
    private static DownloadNetworkFactory f21388e;
    /* renamed from: f */
    private static DownloadPermissionChecker f21389f;
    /* renamed from: g */
    private static DownloadSettings f21390g;
    /* renamed from: h */
    private static C6512a f21391h;
    /* renamed from: i */
    private static AppStatusChangeListener f21392i;
    /* renamed from: j */
    private static IAppDownloadMonitorListener f21393j;
    /* renamed from: k */
    private static DownloadAutoInstallInterceptListener f21394k;
    /* renamed from: l */
    private static DownloadClearSpaceListener f21395l;
    /* renamed from: m */
    private static IDownloadCustomChecker f21396m;
    /* renamed from: n */
    private static DownloadTLogger f21397n;
    /* renamed from: o */
    private static ICleanManager f21398o;

    /* renamed from: m */
    public static String m26379m() {
        return "1.9.5.1";
    }

    /* renamed from: r */
    public static boolean m26384r() {
        return false;
    }

    /* renamed from: a */
    public static void m26358a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f21384a = context.getApplicationContext();
    }

    /* renamed from: b */
    public static void m26368b(Context context) {
        if (f21384a == null && context != null && context.getApplicationContext() != null) {
            f21384a = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    public static Context m26357a() {
        Context context = f21384a;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    /* renamed from: a */
    public static void m26360a(DownloadEventLogger eVar) {
        f21385b = eVar;
    }

    /* renamed from: a */
    public static void m26364a(DownloadUIFactory jVar) {
        f21387d = jVar;
    }

    /* renamed from: a */
    public static void m26361a(DownloadNetworkFactory fVar) {
        f21388e = fVar;
    }

    /* renamed from: a */
    public static void m26362a(DownloadPermissionChecker gVar) {
        f21389f = gVar;
    }

    /* renamed from: a */
    public static void m26363a(DownloadSettings hVar) {
        f21390g = hVar;
        try {
            if (hVar.mo16485a().optInt("hook", 0) == 1) {
                AntiHijackUtils.m26481a();
            }
            AppDownloader.m26714h().mo31489b(m26388v());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m26365a(C6512a aVar) {
        f21391h = aVar;
    }

    /* renamed from: a */
    public static void m26359a(AppStatusChangeListener aVar) {
        f21392i = aVar;
    }

    /* renamed from: b */
    public static DownloadEventLogger m26367b() {
        return f21385b;
    }

    /* renamed from: c */
    public static DownloadActionListener m26369c() {
        if (f21386c == null) {
            f21386c = new DownloadActionListener() {
                /* renamed from: a */
                public void mo31028a(Context context, C6507c cVar, DownloadController aVar, DownloadEventConfig bVar) {
                }

                /* renamed from: a */
                public void mo31029a(Context context, C6507c cVar, DownloadController aVar, DownloadEventConfig bVar, String str) {
                }
            };
        }
        return f21386c;
    }

    /* renamed from: d */
    public static DownloadUIFactory m26370d() {
        if (f21387d == null) {
            f21387d = new DefaultDownloadUIFactory();
        }
        return f21387d;
    }

    /* renamed from: e */
    public static DownloadNetworkFactory m26371e() {
        return f21388e;
    }

    /* renamed from: f */
    public static DownloadPermissionChecker m26372f() {
        if (f21389f == null) {
            f21389f = new DefaultPermissionChecker();
        }
        return f21389f;
    }

    /* renamed from: g */
    public static IAppDownloadMonitorListener m26373g() {
        if (f21393j == null) {
            f21393j = new IAppDownloadMonitorListener() {
                /* renamed from: a */
                public void mo31357a(DownloadInfo cVar, BaseException aVar, int i) {
                }
            };
        }
        return f21393j;
    }

    /* renamed from: h */
    public static IDownloadCustomChecker m26374h() {
        return f21396m;
    }

    /* renamed from: i */
    public static JSONObject m26375i() {
        if (f21390g == null) {
            f21390g = new DownloadSettings() {
                /* renamed from: a */
                public JSONObject mo16485a() {
                    return new JSONObject();
                }
            };
        }
        return (JSONObject) C6587g.m26511a((T[]) new JSONObject[]{f21390g.mo16485a(), new JSONObject()});
    }

    /* renamed from: j */
    public static C6512a m26376j() {
        if (f21391h == null) {
            f21391h = new C6513a().mo31096a();
        }
        return f21391h;
    }

    /* renamed from: k */
    public static AppStatusChangeListener m26377k() {
        return f21392i;
    }

    /* renamed from: l */
    public static ICleanManager m26378l() {
        return f21398o;
    }

    /* renamed from: a */
    public static void m26366a(String str) {
        AppDownloader.m26714h().mo31483a(str);
    }

    /* renamed from: n */
    public static DownloadAutoInstallInterceptListener m26380n() {
        return f21394k;
    }

    /* renamed from: o */
    public static DownloadClearSpaceListener m26381o() {
        return f21395l;
    }

    /* renamed from: p */
    public static DownloadTLogger m26382p() {
        return f21397n;
    }

    /* renamed from: q */
    public static boolean m26383q() {
        if (m26375i().optInt("is_enable_start_install_again") == 1 || m26384r()) {
            return true;
        }
        return false;
    }

    /* renamed from: s */
    public static double m26385s() {
        return m26375i().optDouble("min_install_size", 0.0d);
    }

    /* renamed from: t */
    public static long m26386t() {
        long optLong = m26375i().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000;
        }
        return optLong;
    }

    /* renamed from: u */
    public static long m26387u() {
        long optLong = m26375i().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000;
        }
        return optLong;
    }

    /* renamed from: v */
    public static String m26388v() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getPath());
            sb.append(File.separator);
            sb.append("ByteDownload");
            return m26375i().optString("default_save_dir_name", sb.toString());
        } catch (Throwable unused) {
            return null;
        }
    }
}
