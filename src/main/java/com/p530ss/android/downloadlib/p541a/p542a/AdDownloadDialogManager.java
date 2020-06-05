package com.p530ss.android.downloadlib.p541a.p542a;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.TTDownloader;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.C6544a;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.downloadlib.p549e.OpenAppUtils;
import com.p530ss.android.downloadlib.p549e.TLogger;
import com.p530ss.android.p531a.p532a.p533a.DownloadUIFactory;
import com.p530ss.android.p531a.p532a.p536c.DownloadAlertDialogInfo.C6516a;
import com.p530ss.android.p531a.p532a.p536c.DownloadAlertDialogInfo.C6517b;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.a.a */
public class AdDownloadDialogManager {
    /* renamed from: a */
    private static final String f21277a = AdDownloadDialogManager.class.getSimpleName();
    /* renamed from: b */
    private static AdDownloadDialogManager f21278b;
    /* renamed from: c */
    private CopyOnWriteArrayList<C6544a> f21279c = this.f21283g.mo31253a("sp_ad_install_back_dialog", "key_uninstalled_list");
    /* renamed from: d */
    private boolean f21280d = false;
    /* renamed from: e */
    private String f21281e;
    /* renamed from: f */
    private CopyOnWriteArrayList<C6544a> f21282f = this.f21283g.mo31253a("sp_name_installed_app", "key_installed_list");
    /* renamed from: g */
    private AdDownloadDialogSpHelper f21283g = new AdDownloadDialogSpHelper();

    /* compiled from: AdDownloadDialogManager */
    /* renamed from: com.ss.android.downloadlib.a.a.a$a */
    public interface C6543a {
        /* renamed from: a */
        void mo16473a();
    }

    private AdDownloadDialogManager() {
    }

    /* renamed from: a */
    public static AdDownloadDialogManager m26137a() {
        if (f21278b == null) {
            f21278b = new AdDownloadDialogManager();
        }
        return f21278b;
    }

    /* renamed from: a */
    public boolean mo31249a(Context context, boolean z, C6543a aVar) {
        Context context2 = context;
        boolean z2 = z;
        C6543a aVar2 = aVar;
        String str = f21277a;
        StringBuilder sb = new StringBuilder();
        sb.append("tryShowInstallDialog canBackRefresh:");
        sb.append(z2);
        TLogger.m26504a(str, sb.toString(), null);
        boolean z3 = true;
        if (C6565j.m26375i().optInt("disable_install_app_dialog") == 1 || this.f21280d) {
            return false;
        }
        DownloadInfo a = mo31245a(context);
        if (a == null && this.f21279c.isEmpty()) {
            return false;
        }
        if (a == null || !this.f21279c.isEmpty()) {
            long j = 0;
            if (a != null) {
                j = new File(a.mo32305n()).lastModified();
            }
            CopyOnWriteArrayList<C6544a> copyOnWriteArrayList = this.f21279c;
            ListIterator listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z3 = false;
                    break;
                }
                C6544a aVar3 = (C6544a) listIterator.previous();
                if (aVar3 != null) {
                    if (C6587g.m26535c(context2, aVar3.f21299d)) {
                        continue;
                    } else if (C6587g.m26528a(aVar3.f21302g)) {
                        if (new File(aVar3.f21302g).lastModified() >= j) {
                            mo31247a(context2, aVar3, z2, aVar2);
                        } else {
                            C6544a aVar4 = new C6544a((long) a.mo32283g(), 0, 0, a.mo32319z(), a.mo32291i(), null, a.mo32305n());
                            mo31247a(context2, aVar4, z2, aVar2);
                        }
                    }
                }
            }
            String str2 = f21277a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("tryShowInstallDialog isShow:");
            sb2.append(z3);
            TLogger.m26504a(str2, sb2.toString(), null);
            return z3;
        }
        C6544a aVar5 = new C6544a((long) a.mo32283g(), 0, 0, a.mo32319z(), a.mo32291i(), null, a.mo32305n());
        mo31247a(context2, aVar5, z2, aVar2);
        return true;
    }

    /* renamed from: a */
    public void mo31247a(Context context, C6544a aVar, boolean z, C6543a aVar2) {
        this.f21279c.clear();
        m26139a(context, aVar, aVar2, z);
        this.f21280d = true;
        TTDownloader.m26565a(context).mo31437c();
        this.f21283g.mo31255b("sp_ad_install_back_dialog", "key_uninstalled_list");
        TLogger.m26504a(f21277a, "tryShowInstallDialog isShow:true", null);
    }

    /* renamed from: a */
    public DownloadInfo mo31245a(Context context) {
        DownloadInfo cVar;
        long b = TTDownloader.m26565a(context).mo31436b();
        DownloadInfo cVar2 = null;
        if (C6565j.m26375i().optInt("enable_miniapp_dialog", 0) == 0) {
            return null;
        }
        List<DownloadInfo> b2 = Downloader.m27478a(context).mo31919b("application/vnd.android.package-archive");
        if (b2 != null && !b2.isEmpty()) {
            long j = 0;
            for (DownloadInfo cVar3 : b2) {
                if (cVar3 != null) {
                    if (!C6587g.m26535c(context, cVar3.mo32319z())) {
                        if (C6587g.m26528a(cVar3.mo32305n())) {
                            long lastModified = new File(cVar3.mo32305n()).lastModified();
                            if (lastModified >= b) {
                                if (cVar3.mo32318y() != null) {
                                    try {
                                        if (new JSONObject(cVar3.mo32318y()).has("isMiniApp")) {
                                            if (j == 0 || lastModified > j) {
                                                cVar2 = cVar3;
                                                j = lastModified;
                                            }
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return cVar;
    }

    /* renamed from: a */
    public void mo31246a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        int i = 0;
        while (true) {
            String str5 = "key_uninstalled_list";
            String str6 = "sp_ad_install_back_dialog";
            if (i < this.f21279c.size()) {
                C6544a aVar = (C6544a) this.f21279c.get(i);
                if (aVar == null || aVar.f21297b != j2) {
                    i++;
                } else {
                    CopyOnWriteArrayList<C6544a> copyOnWriteArrayList = this.f21279c;
                    C6544a aVar2 = new C6544a(j, j2, j3, str, str2, str3, str4);
                    copyOnWriteArrayList.set(i, aVar2);
                    this.f21283g.mo31254a(str6, str5, this.f21279c);
                    return;
                }
            } else {
                CopyOnWriteArrayList<C6544a> copyOnWriteArrayList2 = this.f21279c;
                C6544a aVar3 = new C6544a(j, j2, j3, str, str2, str3, str4);
                copyOnWriteArrayList2.add(aVar3);
                this.f21283g.mo31254a(str6, str5, this.f21279c);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m26139a(Context context, C6544a aVar, C6543a aVar2, boolean z) {
        String str;
        NativeDownloadModel d = ModelManager.m26169a().mo31275d(aVar.f21297b);
        if (d == null) {
            C6587g.m26532b();
            return;
        }
        DownloadUIFactory d2 = C6565j.m26370d();
        C6516a a = new C6516a(context).mo31110a(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.f21300e) ? "刚刚下载的应用" : aVar.f21300e;
        C6516a c = a.mo31113b(String.format("%1$s下载完成，是否立即安装？", objArr)).mo31114c("立即安装");
        if (z) {
            str = "暂不安装";
        } else {
            str = String.format("退出%1$s", new Object[]{context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes)});
        }
        C6516a a2 = c.mo31115d(str).mo31111a(false).mo31108a(C6587g.m26509a(context, aVar.f21302g));
        final NativeDownloadModel aVar3 = d;
        final Context context2 = context;
        final C6544a aVar4 = aVar;
        final C6543a aVar5 = aVar2;
        C65411 r3 = new C6517b() {
            /* renamed from: a */
            public void mo31116a(DialogInterface dialogInterface) {
                AdEventHandler.m26446a().mo31400a("backdialog_install", aVar3);
                AppDownloader.m26712a(context2, (int) aVar4.f21296a);
                dialogInterface.dismiss();
            }

            /* renamed from: b */
            public void mo31117b(DialogInterface dialogInterface) {
                AdEventHandler.m26446a().mo31400a("backdialog_exit", aVar3);
                C6543a aVar = aVar5;
                if (aVar != null) {
                    aVar.mo16473a();
                }
                AdDownloadDialogManager.this.mo31252b("");
                dialogInterface.dismiss();
            }

            /* renamed from: c */
            public void mo31118c(DialogInterface dialogInterface) {
                AdDownloadDialogManager.this.mo31252b("");
            }
        };
        d2.mo16488b(a2.mo31109a((C6517b) r3).mo31107a(1).mo31112a());
        AdEventHandler.m26446a().mo31400a("backdialog_show", d);
        this.f21281e = aVar.f21299d;
    }

    /* renamed from: a */
    public boolean mo31250a(String str) {
        return TextUtils.equals(this.f21281e, str);
    }

    /* renamed from: b */
    public void mo31252b(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            this.f21281e = str2;
        } else if (TextUtils.equals(this.f21281e, str)) {
            this.f21281e = str2;
        }
    }

    /* renamed from: a */
    public void mo31248a(C6544a aVar) {
        if (aVar != null) {
            int i = 0;
            while (i < this.f21282f.size()) {
                C6544a aVar2 = (C6544a) this.f21282f.get(i);
                if (aVar2 == null || aVar2.f21297b != aVar.f21297b) {
                    i++;
                } else {
                    return;
                }
            }
            this.f21282f.add(aVar);
            this.f21283g.mo31254a("sp_name_installed_app", "key_installed_list", this.f21282f);
        }
    }

    /* renamed from: b */
    public void mo31251b(Context context) {
        TLogger.m26504a(f21277a, "tryShowOpenAppDialog start", null);
        if (C6565j.m26375i().optInt("disable_open_app_dialog") != 1 && context != null && !this.f21282f.isEmpty()) {
            TLogger.m26504a(f21277a, "tryShowOpenAppDialog next", null);
            CopyOnWriteArrayList<C6544a> copyOnWriteArrayList = this.f21282f;
            ListIterator listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                C6544a aVar = (C6544a) listIterator.previous();
                if (System.currentTimeMillis() - aVar.f21303h > 3600000) {
                    this.f21282f.clear();
                    break;
                } else if (!C6587g.m26535c(context, aVar.f21299d)) {
                    this.f21282f.remove(aVar);
                } else if (m26141a(context, aVar)) {
                    this.f21282f.clear();
                    this.f21283g.mo31255b("sp_name_installed_app", "key_installed_list");
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m26141a(final Context context, C6544a aVar) {
        String str = f21277a;
        StringBuilder sb = new StringBuilder();
        sb.append("showOpenAppDialog appname:");
        sb.append(aVar.f21300e);
        sb.append(",pgk:");
        sb.append(aVar.f21299d);
        TLogger.m26504a(str, sb.toString(), null);
        final NativeDownloadModel d = ModelManager.m26169a().mo31275d(aVar.f21297b);
        if (d == null) {
            C6587g.m26532b();
            return true;
        }
        DownloadUIFactory d2 = C6565j.m26370d();
        C6516a a = new C6516a(context).mo31110a("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.f21300e) ? "刚刚下载的应用" : aVar.f21300e;
        d2.mo16488b(a.mo31113b(String.format("%1$s已安装完成，是否立即打开？", objArr)).mo31114c("打开").mo31115d("取消").mo31111a(false).mo31108a(C6587g.m26530b(context, aVar.f21299d)).mo31109a((C6517b) new C6517b() {
            /* renamed from: c */
            public void mo31118c(DialogInterface dialogInterface) {
            }

            /* renamed from: a */
            public void mo31116a(DialogInterface dialogInterface) {
                AdDownloadDialogManager.this.m26138a(context, d);
                dialogInterface.dismiss();
            }

            /* renamed from: b */
            public void mo31117b(DialogInterface dialogInterface) {
                AdEventHandler.m26446a().mo31400a("market_openapp_cancel", d);
                dialogInterface.dismiss();
            }
        }).mo31107a(2).mo31112a());
        AdEventHandler.m26446a().mo31400a("market_openapp_window_show", d);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26138a(Context context, NativeDownloadModel aVar) {
        if (aVar != null) {
            try {
                if (OpenAppUtils.m26493b(context, aVar.mo31210d()).mo31280a() != 3) {
                    C6565j.m26370d().mo16487a(4, context, aVar.mo31229s(), "应用打开失败，请检查是否安装", null, 1);
                    AdEventHandler.m26446a().mo31400a("market_openapp_failed", aVar);
                } else {
                    AdEventHandler.m26446a().mo31400a("market_openapp_success", aVar);
                }
            } catch (Exception unused) {
            }
        }
    }
}
