package com.bytedance.sdk.openadsdk.core.p174h;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.TTDnsProxy;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.DnsTimeLog;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.SPUtils;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.k */
public class TTDnsSettings implements ISettings {
    /* renamed from: a */
    private String f7650a;
    /* renamed from: b */
    private DnsInfo f7651b;

    /* renamed from: a */
    public void mo15741a() {
        String str = "";
        String str2 = "dnsinfo";
        if (MultiGlobalInfo.m11808b()) {
            this.f7650a = SPMultiHelper.m11880b("tt_dns_settings", str2, str);
            m9761c();
            return;
        }
        this.f7650a = m9763e().mo16915b(str2, str);
        m9761c();
    }

    /* renamed from: a */
    public void mo15742a(JSONObject jSONObject) {
        this.f7651b = DnsInfo.m9704a(jSONObject);
        DnsInfo cVar = this.f7651b;
        if (cVar != null) {
            this.f7650a = cVar.mo15727c().toString();
        }
        m9762d();
    }

    /* renamed from: c */
    private void m9761c() {
        if (!TextUtils.isEmpty(this.f7650a)) {
            try {
                this.f7651b = DnsInfo.m9704a(new JSONObject(this.f7650a));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    private void m9762d() {
        String str = "dnsinfo";
        if (MultiGlobalInfo.m11808b()) {
            if (!TextUtils.isEmpty(this.f7650a)) {
                SPMultiHelper.m11874a("tt_dns_settings", str, this.f7650a);
            }
            return;
        }
        SPUtils e = m9763e();
        if (!TextUtils.isEmpty(this.f7650a)) {
            e.mo16911a(str, this.f7650a);
        }
    }

    /* renamed from: e */
    private SPUtils m9763e() {
        return SPUtils.m11969a("tt_dns_settings", InternalContainer.m10059a());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m9759a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DnsItem dVar = null;
        DnsInfo cVar = this.f7651b;
        if (!(cVar == null || cVar.f7623b == null)) {
            dVar = (DnsItem) this.f7651b.f7623b.get(str);
        }
        if (dVar == null) {
            if (str.equals("is.snssdk.com")) {
                SdkDnsHelper.m9732a((ISettings) this).mo15746a();
            }
            return str;
        } else if (dVar.mo15736d()) {
            SdkDnsHelper.m9732a((ISettings) this).mo15746a();
            return str;
        } else {
            String e = dVar.mo15737e();
            if (TextUtils.isEmpty(e)) {
                SdkDnsHelper.m9732a((ISettings) this).mo15746a();
            } else {
                m9760a(dVar, System.currentTimeMillis() - currentTimeMillis);
            }
            return e;
        }
    }

    /* renamed from: a */
    private void m9760a(DnsItem dVar, long j) {
        if (dVar != null && !dVar.mo15739g() && !TextUtils.isEmpty(dVar.mo15728a())) {
            dVar.mo15733a(true);
            DnsTimeLog aVar = new DnsTimeLog();
            aVar.mo16591a("dns_resolution_time");
            aVar.mo16586a("dns_host", dVar.mo15728a());
            aVar.mo16586a("dns_duration", Long.valueOf(j));
            StatsLogManager.m11278a().mo16566a(aVar);
        }
    }

    /* renamed from: b */
    public void mo15752b() {
        TTNetClient.m11428a(InternalContainer.m10059a()).mo16652a((TTDnsProxy) new TTDnsProxy() {
            /* renamed from: a */
            public String mo14375a(String str) {
                return TTDnsSettings.this.m9759a(str);
            }
        });
    }
}
