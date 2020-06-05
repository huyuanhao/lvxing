package com.alibaba.baichuan.trade.common.adapter.p060b.p062b;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.adapter.p060b.C1204a;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.AppMonitor.C1285a;
import com.p620ut.mini.UTAnalytics;
import com.p620ut.mini.UTHitBuilders.C7712a;
import com.p620ut.mini.p622b.p624b.IUTRequestAuthentication;
import com.p620ut.mini.p622b.p624b.UTSecuritySDKRequestAuthentication;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.b.b.b */
public class C1209b extends C1204a {
    /* renamed from: a */
    private boolean f2498a = true;

    /* renamed from: a */
    public void mo10852a(String str, String str2, long j, Map<String, String> map) {
        mo10854a("aliTradesdk", str, str2, j, map);
    }

    /* renamed from: a */
    public void mo10853a(String str, String str2, String str3) {
        try {
            if (C1223b.m2401e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("可用性埋点-success: module = ");
                sb.append(str);
                sb.append("\n monitorPoint = ");
                sb.append(str2);
                sb.append("\n args = ");
                sb.append(str3);
                C1224a.m2404b("AppMonitorUserTracker-UseabilityPoint", sb.toString());
            }
        } catch (Throwable unused) {
        }
        C1285a.m3300a(str, str2, str3);
    }

    /* renamed from: a */
    public void mo10854a(String str, String str2, String str3, long j, Map<String, String> map) {
        try {
            if (C1223b.m2401e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("业务埋点信息为: trackId = ");
                sb.append(str);
                sb.append("\n label = ");
                sb.append(str2);
                sb.append("\n page = ");
                sb.append(str3);
                sb.append("\n time = ");
                sb.append(j);
                sb.append("\n prop = ");
                sb.append(map);
                C1224a.m2404b("AppMonitorUserTracker-CustomHit", sb.toString());
            }
        } catch (Throwable unused) {
        }
        C7712a aVar = new C7712a(str2);
        aVar.mo37424a(j);
        aVar.mo37425a(str3);
        aVar.mo37428a(map);
        Map a = aVar.mo37426a();
        if (!TextUtils.isEmpty(str)) {
            str = "aliTradesdk";
        }
        UTAnalytics.m33119a().mo37397a(str).mo37476a(a);
    }

    /* renamed from: a */
    public void mo10855a(String str, String str2, String str3, String str4, String str5) {
        try {
            if (C1223b.m2401e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("可用性埋点-success: module = ");
                sb.append(str);
                sb.append("\n monitorPoint = ");
                sb.append(str2);
                sb.append("\n args = ");
                sb.append(str3);
                sb.append("\n errorCode = ");
                sb.append(str4);
                sb.append("\n errorMsg = ");
                sb.append(str5);
                C1224a.m2404b("AppMonitorUserTracker-UseabilityPoint", sb.toString());
            }
        } catch (Throwable unused) {
        }
        C1285a.m3301a(str, str2, str3, str4, str5);
    }

    /* renamed from: a */
    public void mo10856a(String str, String str2, Map<String, String> map) {
        mo10852a(str, str2, 60, map);
    }

    /* renamed from: a */
    public boolean mo10857a() {
        try {
            UTAnalytics.m33119a().mo37399a((Context) C1223b.f2466f);
            UTAnalytics.m33119a().mo37398a(C1223b.f2466f);
            UTAnalytics.m33119a().mo37400a((IUTRequestAuthentication) new UTSecuritySDKRequestAuthentication(C1223b.m2399c(), ""));
            if (C1223b.m2401e()) {
                mo10858b();
            }
            UTAnalytics.m33119a().mo37403d();
            UTAnalytics.m33119a().mo37397a("aliTradesdk").mo37475a("sdk_version", C1223b.f2467g);
            return true;
        } catch (Throwable unused) {
            this.f2498a = false;
            return false;
        }
    }

    /* renamed from: b */
    public void mo10858b() {
        UTAnalytics.m33119a().mo37402c();
        AppMonitor.m3285a(true);
    }
}
