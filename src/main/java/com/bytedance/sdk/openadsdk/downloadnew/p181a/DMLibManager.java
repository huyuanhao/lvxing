package com.bytedance.sdk.openadsdk.downloadnew.p181a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.WebHelper;
import com.bytedance.sdk.openadsdk.core.p170d.C2222b;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.C2417a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTAppDownloadListenerGroup;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b.LibModelFactory;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.AppDownloadListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p202b.TTAppDownloadListenerImpl;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p165c.OpenAppSuccEvent;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.CommonDialogHelper;
import com.bytedance.sdk.openadsdk.utils.CommonDialogHelper.C2550a;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.p522qq.taf.jce.JceStruct;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener;
import com.p530ss.android.p531a.p532a.p536c.DownloadShortInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.b */
public class DMLibManager implements ITTDownloadAdapter, C2539a {
    /* renamed from: a */
    protected IListenerManager f8570a;
    /* renamed from: b */
    private WeakReference<Context> f8571b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final C2222b f8572c;
    /* renamed from: d */
    private final MaterialMeta f8573d;
    /* renamed from: e */
    private String f8574e;
    /* renamed from: f */
    private int f8575f = -1;
    /* renamed from: g */
    private DownloadController f8576g;
    /* renamed from: h */
    private DownloadEventConfig f8577h;
    /* renamed from: i */
    private C6507c f8578i;
    /* access modifiers changed from: private|final */
    /* renamed from: j */
    public final AtomicInteger f8579j = new AtomicInteger(1);
    /* access modifiers changed from: private|final */
    /* renamed from: k */
    public final AtomicBoolean f8580k = new AtomicBoolean(false);
    /* renamed from: l */
    private boolean f8581l = false;
    /* renamed from: m */
    private boolean f8582m;
    /* renamed from: n */
    private final AtomicLong f8583n = new AtomicLong();
    /* renamed from: o */
    private final AtomicBoolean f8584o = new AtomicBoolean(false);
    /* renamed from: p */
    private WeakReference<View> f8585p;
    /* renamed from: q */
    private boolean f8586q = false;
    /* renamed from: r */
    private HashSet<Integer> f8587r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public TTAppDownloadListenerGroup f8588s;
    /* renamed from: t */
    private final C2538ak f8589t = new C2538ak(Looper.getMainLooper(), this);
    /* renamed from: u */
    private boolean f8590u = true;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public String f8591v;
    /* renamed from: w */
    private final DownloadStatusChangeListener f8592w = new DownloadStatusChangeListener() {
        /* renamed from: a */
        public void mo16528a() {
            DMLibManager.this.f8579j.set(1);
            DMLibManager.m11131b("onIdle");
            if (MultiGlobalInfo.m11808b()) {
                DMLibManager.this.m11124a("onIdle", 0, 0, null, null);
                return;
            }
            if (DMLibManager.this.f8588s != null) {
                DMLibManager.this.f8588s.onIdle();
            }
        }

        /* renamed from: a */
        public void mo16529a(C6507c cVar, DownloadController aVar) {
            DMLibManager.this.f8579j.set(2);
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadStart: ");
            sb.append(cVar.mo31064d());
            DMLibManager.m11131b(sb.toString());
            DMLibManager.this.mo16506a(cVar.mo31064d());
            if (MultiGlobalInfo.m11808b()) {
                DMLibManager.this.m11124a("onIdle", 0, 0, null, null);
                return;
            }
            if (DMLibManager.this.f8588s != null) {
                DMLibManager.this.f8588s.onIdle();
            }
        }

        /* renamed from: a */
        public void mo16531a(DownloadShortInfo eVar, int i) {
            DMLibManager.this.f8579j.set(3);
            DMLibManager.this.f8580k.set(false);
            DMLibManager.this.mo16506a(eVar.f21105a);
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadActive: ");
            sb.append(eVar.f21107c);
            sb.append(", ");
            sb.append(eVar.f21108d);
            DMLibManager.m11131b(sb.toString());
            if (MultiGlobalInfo.m11808b()) {
                DMLibManager.this.m11124a("onDownloadActive", eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
                return;
            }
            if (DMLibManager.this.f8588s != null) {
                DMLibManager.this.f8588s.onDownloadActive(eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
            }
        }

        /* renamed from: b */
        public void mo16533b(DownloadShortInfo eVar, int i) {
            DMLibManager.this.f8579j.set(4);
            DMLibManager.this.f8580k.set(false);
            DMLibManager.this.mo16506a(eVar.f21105a);
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadPaused: ");
            sb.append(eVar.f21107c);
            sb.append(", ");
            sb.append(eVar.f21108d);
            DMLibManager.m11131b(sb.toString());
            if (MultiGlobalInfo.m11808b()) {
                DMLibManager.this.m11124a("onDownloadPaused", eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
                return;
            }
            if (DMLibManager.this.f8588s != null) {
                DMLibManager.this.f8588s.onDownloadPaused(eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
            }
        }

        /* renamed from: a */
        public void mo16530a(DownloadShortInfo eVar) {
            DMLibManager.this.f8579j.set(5);
            DMLibManager.this.mo16506a(eVar.f21105a);
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadFailed: ");
            sb.append(eVar.f21107c);
            sb.append(", ");
            sb.append(eVar.f21108d);
            DMLibManager.m11131b(sb.toString());
            if (MultiGlobalInfo.m11808b()) {
                DMLibManager.this.m11124a("onDownloadFailed", eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
                return;
            }
            if (DMLibManager.this.f8588s != null) {
                DMLibManager.this.f8588s.onDownloadFailed(eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
            }
        }

        /* renamed from: b */
        public void mo16532b(DownloadShortInfo eVar) {
            DMLibManager.this.f8579j.set(7);
            DMLibManager.this.f8580k.set(true);
            DMLibManager.this.mo16506a(eVar.f21105a);
            StringBuilder sb = new StringBuilder();
            sb.append("onInstalled: ");
            sb.append(eVar.f21107c);
            sb.append(", ");
            sb.append(eVar.f21108d);
            DMLibManager.m11131b(sb.toString());
            if (MultiGlobalInfo.m11808b()) {
                DMLibManager.this.m11124a("onInstalled", eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
                return;
            }
            if (DMLibManager.this.f8588s != null) {
                DMLibManager.this.f8588s.onInstalled(eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
            }
        }

        /* renamed from: c */
        public void mo16534c(DownloadShortInfo eVar) {
            DMLibManager.this.f8579j.set(6);
            DMLibManager.this.mo16506a(eVar.f21105a);
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadFinished: ");
            sb.append(eVar.f21107c);
            sb.append(", ");
            sb.append(eVar.f21108d);
            DMLibManager.m11131b(sb.toString());
            if (MultiGlobalInfo.m11808b()) {
                DMLibManager.this.m11124a("onDownloadFinished", eVar.f21107c, eVar.f21108d, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
                return;
            }
            if (DMLibManager.this.f8588s != null) {
                DMLibManager.this.f8588s.onDownloadFinished(eVar.f21107c, eVar.f21109e, DMLibManager.this.f8572c.mo15345c());
            }
        }
    };
    /* renamed from: x */
    private C2415a f8593x = new C2415a();
    /* access modifiers changed from: private */
    /* renamed from: y */
    public List<ITTAppDownloadListener> f8594y = new ArrayList();

    /* compiled from: DMLibManager */
    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.b$a */
    private class C2415a implements Runnable {
        /* renamed from: a */
        String f8603a;
        /* renamed from: b */
        long f8604b;
        /* renamed from: c */
        long f8605c;
        /* renamed from: d */
        String f8606d;
        /* renamed from: e */
        String f8607e;

        public C2415a() {
        }

        public C2415a(String str, long j, long j2, String str2, String str3) {
            this.f8603a = str;
            this.f8604b = j;
            this.f8605c = j2;
            this.f8606d = str2;
            this.f8607e = str3;
        }

        /* renamed from: a */
        public void mo16541a(String str) {
            this.f8603a = str;
        }

        /* renamed from: a */
        public void mo16540a(long j) {
            this.f8604b = j;
        }

        /* renamed from: b */
        public void mo16542b(long j) {
            this.f8605c = j;
        }

        /* renamed from: b */
        public void mo16543b(String str) {
            this.f8606d = str;
        }

        /* renamed from: c */
        public void mo16544c(String str) {
            this.f8607e = str;
        }

        public void run() {
            try {
                DMLibManager.this.mo16526l().executeAppDownloadCallback(DMLibManager.this.f8591v, this.f8603a, this.f8604b, this.f8605c, this.f8606d, this.f8607e);
            } catch (Throwable th) {
                C2564t.m12223c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
            }
        }
    }

    /* renamed from: n */
    private void m11138n() {
    }

    /* renamed from: b */
    public boolean mo16515b(boolean z) {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11124a(String str, long j, long j2, String str2, String str3) {
        C2415a aVar = this.f8593x;
        if (aVar == null) {
            C2415a aVar2 = new C2415a(str, j, j2, str2, str3);
            this.f8593x = aVar2;
        } else {
            String str4 = str;
            aVar.mo16541a(str);
            long j3 = j;
            this.f8593x.mo16540a(j);
            this.f8593x.mo16542b(j2);
            this.f8593x.mo16543b(str2);
            this.f8593x.mo16544c(str3);
        }
        TTExecutor.m11692a().mo16804a((Runnable) this.f8593x, 5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public IListenerManager mo16526l() {
        if (this.f8570a == null) {
            this.f8570a = AppDownloadListenerManagerImpl.asInterface(BinderPool.m11776a(InternalContainer.m10059a()).mo16858a(3));
        }
        return this.f8570a;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m11131b(String str) {
        C2564t.m12220b("DMLibManager", str);
    }

    public DMLibManager(Context context, MaterialMeta kVar, String str) {
        this.f8571b = new WeakReference<>(context);
        this.f8573d = kVar;
        this.f8572c = kVar.mo15426N();
        this.f8574e = str;
        this.f8575f = ToolUtils.m12014c(kVar.mo15428P());
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8573d.hashCode());
        sb.append(this.f8573d.mo15459ae().toString());
        this.f8591v = DigestUtils.m12169a(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("====tag===");
        sb2.append(str);
        m11131b(sb2.toString());
        if (this.f8572c == null) {
            C2564t.m12226e("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (InternalContainer.m10059a() == null) {
            InternalContainer.m10061a(context);
        }
        this.f8588s = new TTAppDownloadListenerGroup();
        this.f8578i = LibModelFactory.m11200a(this.f8574e, this.f8573d, null).mo31182a();
        this.f8576g = LibModelFactory.m11198a(this.f8573d).mo31146a();
        this.f8577h = LibModelFactory.m11199a(this.f8573d, this.f8574e).mo31154a();
        mo16504a();
    }

    /* renamed from: a */
    public void mo16504a() {
        m11141q();
        m11138n();
    }

    /* renamed from: b */
    public void mo16513b() {
        if (InternalContainer.m10059a() == null) {
            InternalContainer.m10061a(m11143s());
        }
        this.f8582m = true;
        m11141q();
    }

    /* renamed from: c */
    public void mo16516c() {
        this.f8582m = false;
    }

    /* renamed from: d */
    public void mo16518d() {
        TTAppDownloadListenerGroup cVar = this.f8588s;
        if (cVar != null) {
            cVar.mo16558a();
        }
        m11140p();
        HashSet<Integer> hashSet = this.f8587r;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                LibHolder.m11225a(((Integer) it.next()).intValue());
                it.remove();
            }
        }
        WeakReference<Context> weakReference = this.f8571b;
        if (weakReference != null) {
            weakReference.clear();
            this.f8571b = null;
        }
    }

    /* renamed from: a */
    public void mo16507a(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("setActivity==activity:");
        sb.append(activity.getLocalClassName());
        C2564t.m12226e("DMLibManager", sb.toString());
        if (activity != null) {
            this.f8571b = new WeakReference<>(activity);
            m11141q();
        }
    }

    /* renamed from: a */
    public void mo16508a(View view) {
        if (view != null) {
            this.f8585p = new WeakReference<>(view);
        }
    }

    /* renamed from: o */
    private void m11139o() {
        m11131b("tryReleaseResource==");
        WeakReference<Context> weakReference = this.f8571b;
        if (weakReference == null) {
            m11131b("tryReleaseResource==  mContext is null");
            return;
        }
        Activity activity = weakReference.get() instanceof Activity ? (Activity) this.f8571b.get() : null;
        if (activity == null) {
            m11131b("tryReleaseResource==  activity is null");
        } else if (GlobalInfo.m9616c().mo15665a(activity)) {
            m11131b("tryReleaseResource==  isActivityAlive is true");
        } else {
            m11147w();
        }
    }

    /* renamed from: c */
    public void mo16517c(boolean z) {
        this.f8586q = z;
    }

    /* renamed from: p */
    private synchronized void m11140p() {
        StringBuilder sb = new StringBuilder();
        sb.append("unbindDownload==");
        sb.append(this.f8584o.get());
        m11131b(sb.toString());
        if (this.f8572c != null) {
            if (this.f8584o.get()) {
                this.f8584o.set(false);
                LibHolder.m11234d().mo31432a(this.f8578i.mo31061a(), hashCode());
            }
            m11139o();
        }
    }

    /* renamed from: q */
    private synchronized void m11141q() {
        StringBuilder sb = new StringBuilder();
        sb.append("bindDownload==");
        sb.append(this.f8584o.get());
        m11131b(sb.toString());
        if (this.f8572c != null) {
            this.f8584o.get();
            this.f8584o.set(true);
            LibHolder.m11234d().mo31430a(m11143s(), hashCode(), this.f8592w, this.f8578i);
        }
    }

    /* renamed from: e */
    public boolean mo16519e() {
        return this.f8580k.get();
    }

    /* renamed from: a */
    public void mo16506a(long j) {
        this.f8583n.set(j);
    }

    /* renamed from: f */
    public void mo16520f() {
        if (!(m11143s() == null || this.f8572c == null)) {
            TTCustomController d = GlobalInfo.m9616c().mo15672d();
            if (d != null && !d.isCanUseWriteExternal()) {
                try {
                    String str = LibHolder.f8618a;
                    String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                    if (str != null && !str.startsWith(absolutePath)) {
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            if (this.f8573d.mo15505s() || !LibHolder.m11228a(m11143s(), this.f8572c.mo15342b())) {
                StringBuilder sb = new StringBuilder();
                sb.append("changeDownloadStatus, the current status is1: ");
                sb.append(this.f8579j);
                m11131b(sb.toString());
                LibHolder.m11234d().mo31434a(this.f8572c.mo15342b(), this.f8578i.mo31064d(), 2, this.f8577h, this.f8576g);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("changeDownloadStatus, the current status is2: ");
                sb2.append(this.f8579j);
                m11131b(sb2.toString());
            } else {
                m11131b("changeDownloadStatus, not support pause/continue function");
                try {
                    Toast.makeText(m11143s(), "应用正在下载...", 0).show();
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* renamed from: g */
    public void mo16521g() {
        mo16514b(0);
    }

    /* renamed from: b */
    public void mo16514b(long j) {
        if (this.f8572c != null) {
            this.f8584o.set(false);
            LibHolder.m11234d().mo31435a(this.f8578i.mo31061a(), true);
            m11141q();
        }
    }

    /* renamed from: h */
    public void mo16522h() {
        if (!(m11143s() == null || this.f8572c == null)) {
            if (mo16527m()) {
                this.f8580k.set(true);
            } else if (!mo16525k()) {
                if (m11142r()) {
                    this.f8580k.set(true);
                } else if (mo16515b(this.f8590u)) {
                    this.f8580k.set(true);
                } else {
                    m11148x();
                }
            }
        }
    }

    /* renamed from: i */
    public boolean mo16523i() {
        MaterialMeta kVar = this.f8573d;
        return (kVar == null || kVar.mo15511y() == null || this.f8572c == null || this.f8573d.mo15511y().mo15384b() != 3 || this.f8572c.mo15339a() == null) ? false : true;
    }

    /* renamed from: r */
    private boolean m11142r() {
        if (this.f8572c == null || !mo16523i()) {
            return false;
        }
        boolean a = m11127a(m11143s(), this.f8572c.mo15339a(), this.f8573d, this.f8574e);
        if (a) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            this.f8589t.sendMessageDelayed(obtain, 3000);
        } else {
            m11134d(false);
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m11127a(Context context, String str, MaterialMeta kVar, String str2) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            if (InternalContainer.m10069h().mo15783d()) {
                ToolUtils.m12002a(kVar, str2);
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            z = true;
        } catch (Throwable unused) {
        }
        return z;
    }

    /* renamed from: s */
    private Context m11143s() {
        WeakReference<Context> weakReference = this.f8571b;
        return (weakReference == null || weakReference.get() == null) ? InternalContainer.m10059a() : (Context) this.f8571b.get();
    }

    /* renamed from: m */
    public boolean mo16527m() {
        String str = "open_url_app";
        if (this.f8573d.mo15427O() != null) {
            String a = this.f8573d.mo15427O().mo15376a();
            if (!TextUtils.isEmpty(a)) {
                Uri parse = Uri.parse(a);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (ToolUtils.m12004a(m11143s(), intent)) {
                    if (!(m11143s() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    try {
                        if (InternalContainer.m10069h().mo15783d()) {
                            ToolUtils.m12002a(this.f8573d, this.f8574e);
                        }
                        m11143s().startActivity(intent);
                        if (!m11128a(this.f8574e, str, this.f8573d)) {
                            AdEventManager.m8417p(m11143s(), this.f8573d, this.f8574e, str, null);
                        }
                        OpenAppSuccEvent.m8494a().mo15032a(this.f8573d, this.f8574e);
                        return true;
                    } catch (Throwable unused) {
                        if (this.f8573d.mo15417E() != null) {
                            WebHelper.m11012a(m11143s(), this.f8573d.mo15417E(), this.f8573d, ToolUtils.m11991a(this.f8574e), this.f8574e, true);
                        }
                        return false;
                    }
                }
            }
            if (!(this.f8579j.get() == 4 || this.f8579j.get() == 3 || (this.f8581l && !this.f8580k.get()))) {
                this.f8581l = true;
                String str2 = "open_fallback_url";
                if (!m11128a(this.f8574e, str2, this.f8573d)) {
                    AdEventManager.m8417p(m11143s(), this.f8573d, this.f8574e, str2, null);
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo16512a(boolean z) {
        this.f8590u = z;
        return m11142r();
    }

    /* renamed from: j */
    public boolean mo16524j() {
        if (this.f8579j.get() == 1) {
            int c = C2566w.m12244c(m11143s());
            if (c == 0) {
                Toast.makeText(m11143s(), ResourceHelp.m11932b(m11143s(), "tt_no_network"), 0).show();
                return true;
            } else if (m11126a(c)) {
                m11144t();
                return true;
            } else {
                m11145u();
                return true;
            }
        } else {
            mo16520f();
            if (this.f8579j.get() == 3 || this.f8579j.get() == 4) {
                this.f8580k.set(false);
            } else if (this.f8579j.get() == 6) {
                this.f8580k.set(true);
            }
            return false;
        }
    }

    /* renamed from: a */
    private boolean m11126a(int i) {
        int f = InternalContainer.m10069h().mo15787f();
        if (f == -1) {
            return !GlobalInfo.m9616c().mo15669b(i);
        }
        if (f == 0) {
            return false;
        }
        if (f != 2) {
            if (f != 3) {
                if (GlobalInfo.m9616c().mo15669b(i)) {
                    return false;
                }
                int i2 = JceStruct.JCE_MAX_STRING_LENGTH;
                C2222b bVar = this.f8572c;
                if (bVar != null && bVar.mo15352g() > 0) {
                    i2 = this.f8572c.mo15352g();
                }
                if (i2 <= InternalContainer.m10069h().mo15789g()) {
                    return false;
                }
            }
        } else if (i == 4) {
            return false;
        }
        return true;
    }

    /* renamed from: t */
    private void m11144t() {
        String str;
        Context context;
        String a = ResourceHelp.m11931a(m11143s(), "tt_confirm_download");
        C2222b bVar = this.f8572c;
        boolean z = false;
        if (bVar != null && !TextUtils.isEmpty(bVar.mo15345c())) {
            a = String.format(ResourceHelp.m11931a(m11143s(), "tt_confirm_download_have_app_name"), new Object[]{this.f8572c.mo15345c()});
        }
        String a2 = ResourceHelp.m11931a(m11143s(), "tt_tip");
        if (m11143s() != null && (m11143s() instanceof Activity)) {
            Activity activity = (Activity) m11143s();
            if (VERSION.SDK_INT < 17) {
                z = activity.isFinishing();
            } else if (activity.isDestroyed() || activity.isFinishing()) {
                z = true;
            }
        }
        if (m11143s() == null || !(m11143s() instanceof Activity) || z) {
            m11125a(a2, a);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            context = m11143s();
            str = "Theme.Dialog.TTDownload";
        } else {
            context = m11143s();
            str = "Theme.Dialog.TTDownloadOld";
        }
        Builder builder = new Builder(m11143s(), ResourceHelp.m11937g(context, str));
        builder.setTitle(a2).setMessage(a).setPositiveButton(ResourceHelp.m11931a(m11143s(), "tt_label_ok"), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DMLibManager.this.m11145u();
            }
        }).setNegativeButton(ResourceHelp.m11931a(m11143s(), "tt_label_cancel"), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        builder.show();
    }

    /* renamed from: a */
    private void m11125a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            C2222b bVar = this.f8572c;
            if (bVar != null) {
                CommonDialogHelper.m12143a(bVar.mo15342b(), str, str2, new C2550a() {
                    /* renamed from: b */
                    public void mo16494b() {
                    }

                    /* renamed from: c */
                    public void mo16495c() {
                    }

                    /* renamed from: a */
                    public void mo16493a() {
                        DMLibManager.this.m11145u();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m11145u() {
        m11146v();
        this.f8580k.set(true);
        if (InternalContainer.m10069h().mo15783d()) {
            ToolUtils.m12002a(this.f8573d, this.f8574e);
        }
    }

    /* renamed from: v */
    private void m11146v() {
        mo16520f();
    }

    /* renamed from: k */
    public boolean mo16525k() {
        C2222b bVar = this.f8572c;
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        String d = bVar.mo15348d();
        if (!TextUtils.isEmpty(d) && mo16511a(m11143s(), d)) {
            z = true;
            this.f8580k.set(true);
            if (!m11128a(this.f8574e, "click_open", this.f8573d)) {
                AdEventManager.m8418q(m11143s(), this.f8573d, this.f8574e, ToolUtils.m12029f(this.f8573d), null);
            }
        }
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|18|(1:20)|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
            if (r8.f8573d.mo15417E() != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
            com.bytedance.sdk.openadsdk.core.WebHelper.m11012a(m11143s(), r8.f8573d.mo15417E(), r8.f8573d, com.bytedance.sdk.openadsdk.utils.ToolUtils.m11991a(r8.f8574e), r8.f8574e, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0032 */
    /* renamed from: a */
    public boolean mo16511a(android.content.Context r9, java.lang.String r10) {
        /*
        r8 = this;
        r0 = 0
        if (r9 == 0) goto L_0x0053
        boolean r1 = android.text.TextUtils.isEmpty(r10)
        if (r1 == 0) goto L_0x000a
        goto L_0x0053
    L_0x000a:
        boolean r1 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12016c(r9, r10)     // Catch:{ all -> 0x0053 }
        if (r1 == 0) goto L_0x0053
        r1 = 1
        android.content.Intent r10 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12007b(r9, r10)     // Catch:{ Exception -> 0x0032 }
        if (r10 != 0) goto L_0x0018
        return r0
    L_0x0018:
        com.bytedance.sdk.openadsdk.core.h.l r2 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10069h()     // Catch:{ Exception -> 0x0032 }
        boolean r2 = r2.mo15783d()     // Catch:{ Exception -> 0x0032 }
        if (r2 == 0) goto L_0x0029
        com.bytedance.sdk.openadsdk.core.d.k r2 = r8.f8573d     // Catch:{ Exception -> 0x0032 }
        java.lang.String r3 = r8.f8574e     // Catch:{ Exception -> 0x0032 }
        com.bytedance.sdk.openadsdk.utils.ToolUtils.m12002a(r2, r3)     // Catch:{ Exception -> 0x0032 }
    L_0x0029:
        java.lang.String r2 = "START_ONLY_FOR_ANDROID"
        r10.putExtra(r2, r1)     // Catch:{ Exception -> 0x0032 }
        r9.startActivity(r10)     // Catch:{ Exception -> 0x0032 }
        return r1
    L_0x0032:
        com.bytedance.sdk.openadsdk.core.d.k r9 = r8.f8573d     // Catch:{ all -> 0x0053 }
        java.lang.String r9 = r9.mo15417E()     // Catch:{ all -> 0x0053 }
        if (r9 == 0) goto L_0x0052
        android.content.Context r2 = r8.m11143s()     // Catch:{ all -> 0x0053 }
        com.bytedance.sdk.openadsdk.core.d.k r9 = r8.f8573d     // Catch:{ all -> 0x0053 }
        java.lang.String r3 = r9.mo15417E()     // Catch:{ all -> 0x0053 }
        com.bytedance.sdk.openadsdk.core.d.k r4 = r8.f8573d     // Catch:{ all -> 0x0053 }
        java.lang.String r9 = r8.f8574e     // Catch:{ all -> 0x0053 }
        int r5 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m11991a(r9)     // Catch:{ all -> 0x0053 }
        java.lang.String r6 = r8.f8574e     // Catch:{ all -> 0x0053 }
        r7 = 1
        com.bytedance.sdk.openadsdk.core.WebHelper.m11012a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0053 }
    L_0x0052:
        return r1
    L_0x0053:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.p181a.DMLibManager.mo16511a(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: a */
    private boolean m11128a(String str, String str2, MaterialMeta kVar) {
        return LibHolder.m11229a(str, str2, kVar, Integer.valueOf(1));
    }

    /* renamed from: a */
    public void mo16509a(TTAppDownloadListener tTAppDownloadListener) {
        mo16510a(tTAppDownloadListener, true);
    }

    /* renamed from: a */
    public void mo16510a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
        if (tTAppDownloadListener != null) {
            TTAppDownloadListenerGroup cVar = this.f8588s;
            if (cVar != null) {
                cVar.mo16559a(tTAppDownloadListener);
            }
            if (z) {
                m11130b(tTAppDownloadListener);
            }
            m11140p();
            m11141q();
        }
    }

    /* renamed from: b */
    private void m11130b(final TTAppDownloadListener tTAppDownloadListener) {
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append("registerMultiProcessListener, mMetaMd5:");
        sb.append(this.f8591v);
        C2564t.m12226e("DMLibManager", sb.toString());
        if (MultiGlobalInfo.m11808b() && tTAppDownloadListener != null) {
            new Thread(new Runnable() {
                public void run() {
                    BinderPool a = BinderPool.m11776a(InternalContainer.m10059a());
                    TTAppDownloadListenerImpl eVar = new TTAppDownloadListenerImpl(tTAppDownloadListener);
                    IListenerManager asInterface = AppDownloadListenerManagerImpl.asInterface(a.mo16858a(3));
                    if (asInterface != null) {
                        try {
                            asInterface.registerTTAppDownloadListener(DMLibManager.this.f8591v, eVar);
                            DMLibManager.this.f8594y.add(eVar);
                            StringBuilder sb = new StringBuilder();
                            sb.append("registerMultiProcessListener, mTTAppDownloadListenerList size:");
                            sb.append(DMLibManager.this.f8594y.size());
                            C2564t.m12226e("DMLibManager", sb.toString());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    /* renamed from: w */
    private void m11147w() {
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append("unregisterMultiProcessListener, mMetaMd5:");
        sb.append(this.f8591v);
        C2564t.m12226e("DMLibManager", sb.toString());
        if (MultiGlobalInfo.m11808b()) {
            new Thread(new Runnable() {
                public void run() {
                    IListenerManager asInterface = AppDownloadListenerManagerImpl.asInterface(BinderPool.m11776a(InternalContainer.m10059a()).mo16858a(3));
                    String str = "DMLibManager";
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unregisterMultiProcessListener, mTTAppDownloadListenerList size:");
                        sb.append(DMLibManager.this.f8594y.size());
                        C2564t.m12226e(str, sb.toString());
                        if (asInterface != null && DMLibManager.this.f8594y.size() > 0) {
                            for (ITTAppDownloadListener unregisterTTAppDownloadListener : DMLibManager.this.f8594y) {
                                asInterface.unregisterTTAppDownloadListener(DMLibManager.this.f8591v, unregisterTTAppDownloadListener);
                            }
                            DMLibManager.this.f8594y.clear();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /* renamed from: a */
    public void mo16505a(int i, C2417a aVar) {
        if (this.f8587r == null) {
            this.f8587r = new HashSet<>();
        }
        this.f8587r.add(Integer.valueOf(i));
        LibHolder.m11226a(i, aVar);
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message.what == 9) {
            if (GlobalInfo.m9616c() == null || GlobalInfo.m9616c().mo15664a()) {
                m11134d(true);
            } else {
                m11134d(false);
                boolean z = this.f8590u;
                if (z && !mo16515b(z)) {
                    m11148x();
                }
            }
        }
    }

    /* renamed from: d */
    private void m11134d(boolean z) {
        if (z) {
            AdEventManager.m8382a(m11143s(), this.f8573d, this.f8574e, "quickapp_success");
        } else {
            AdEventManager.m8382a(m11143s(), this.f8573d, this.f8574e, "quickapp_fail");
        }
    }

    /* renamed from: x */
    private void m11148x() {
        C2222b bVar = this.f8572c;
        if (bVar != null && bVar.mo15342b() != null) {
            mo16524j();
        }
    }
}
