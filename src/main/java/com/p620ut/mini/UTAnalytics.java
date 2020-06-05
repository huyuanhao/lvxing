package com.p620ut.mini;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.UTMCStatConfig;
import com.alibaba.mtl.log.p077d.Logger;
import com.p620ut.mini.p621a.UTMIVariables;
import com.p620ut.mini.p622b.p623a.UTMCAppStatusCallbacks;
import com.p620ut.mini.p622b.p623a.UTMCAppStatusRegHelper;
import com.p620ut.mini.p622b.p624b.IUTRequestAuthentication;
import com.p620ut.mini.p622b.p624b.UTBaseRequestAuthentication;
import com.p620ut.mini.p622b.p624b.UTSecuritySDKRequestAuthentication;
import com.p620ut.mini.p625c.UTTeamWork;
import com.p620ut.mini.p626d.UTPlugin;
import com.p620ut.mini.p626d.UTPluginMgr;
import com.p620ut.mini.p627e.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ut.mini.b */
public class UTAnalytics {
    /* renamed from: a */
    private static UTAnalytics f26009a;
    /* renamed from: b */
    private UTTracker f26010b;
    /* renamed from: c */
    private Map<String, UTTracker> f26011c = new HashMap();
    /* renamed from: d */
    private Map<String, UTTracker> f26012d = new HashMap();

    private UTAnalytics() {
        if (VERSION.SDK_INT < 14) {
            UTMI1010_2001Event aVar = new UTMI1010_2001Event();
            UTPluginMgr.m33170c().mo37438a((UTPlugin) aVar, false);
            UTMIVariables.m33112b().mo37391a(aVar);
            return;
        }
        UTMI1010_2001Event aVar2 = new UTMI1010_2001Event();
        UTMCAppStatusRegHelper.m33141a((UTMCAppStatusCallbacks) aVar2);
        UTMIVariables.m33112b().mo37391a(aVar2);
    }

    @Deprecated
    /* renamed from: a */
    public void mo37399a(Context context) {
        UTMCStatConfig.m3729a().mo11769a(context);
        if (context != null) {
            UTTeamWork.m33159a().mo37431b();
        }
    }

    @Deprecated
    /* renamed from: a */
    public void mo37398a(Application application) {
        UTMCStatConfig.m3729a().mo11768a(application);
        AppMonitor.m3283a(application);
    }

    /* renamed from: a */
    public static synchronized UTAnalytics m33119a() {
        UTAnalytics bVar;
        synchronized (UTAnalytics.class) {
            if (f26009a == null) {
                f26009a = new UTAnalytics();
            }
            bVar = f26009a;
        }
        return bVar;
    }

    /* renamed from: b */
    public synchronized UTTracker mo37401b() {
        if (this.f26010b == null) {
            this.f26010b = new UTTracker();
        }
        if (this.f26010b == null) {
            Logger.m3831a("getDefaultTracker error", (Object) "Fatal Error,must call setRequestAuthentication method first.");
        }
        return this.f26010b;
    }

    @Deprecated
    /* renamed from: a */
    public void mo37400a(IUTRequestAuthentication aVar) {
        if (aVar == null) {
            Logger.m3831a("setRequestAuthentication", (Object) "Fatal Error,pRequestAuth must not be null.");
        }
        if (aVar instanceof UTBaseRequestAuthentication) {
            String a = aVar.mo37420a();
            UTBaseRequestAuthentication bVar = (UTBaseRequestAuthentication) aVar;
            AppMonitor.m3286a(false, a, bVar.mo37421b(), bVar.mo37422c() ? "1" : "0");
            return;
        }
        AppMonitor.m3286a(true, aVar.mo37420a(), null, ((UTSecuritySDKRequestAuthentication) aVar).mo37423b());
    }

    /* renamed from: a */
    public synchronized UTTracker mo37397a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.m3831a("getTracker", (Object) "TrackId is null.");
            return null;
        } else if (this.f26011c.containsKey(str)) {
            return (UTTracker) this.f26011c.get(str);
        } else {
            UTTracker fVar = new UTTracker();
            fVar.mo37474a(str);
            this.f26011c.put(str, fVar);
            return fVar;
        }
    }

    @Deprecated
    /* renamed from: c */
    public void mo37402c() {
        UTMCStatConfig.m3729a().mo11771c();
    }

    /* renamed from: d */
    public void mo37403d() {
        UTPageHitHelper.m33190a().mo37453b();
    }
}
