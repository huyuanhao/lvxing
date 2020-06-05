package com.bytedance.embedapplog.p141a;

import android.app.Application;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.p142b.C1821h;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p143c.C1835a;
import com.bytedance.embedapplog.p143c.C1836b;
import com.bytedance.embedapplog.util.C1856h;
import com.bytedance.embedapplog.util.C1857i;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.a.a */
class C1801a extends C1803c {
    /* renamed from: b */
    private long f5036b;
    /* renamed from: c */
    private final C1821h f5037c;
    /* renamed from: d */
    private final C1822i f5038d;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13345a() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo13349e() {
        return "ab";
    }

    C1801a(Application application, C1822i iVar, C1821h hVar) {
        super(application);
        this.f5038d = iVar;
        this.f5037c = hVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo13346b() {
        long v = this.f5037c.mo13419v();
        if (v < 600000) {
            v = 600000;
        }
        return this.f5036b + v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long[] mo13347c() {
        return C1809i.f5066c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo13348d() {
        JSONObject a = this.f5038d.mo13425a();
        if (!(this.f5038d.mo13446o() == 0 || a == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f5038d.mo13425a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", currentTimeMillis);
            JSONObject d = C1835a.m6440d(C1836b.m6441a(this.f5041a, this.f5038d.mo13425a(), C1835a.m6431a().getABConfigUri(), true, AppLog.getIAppParam()), jSONObject);
            if (d != null) {
                AppLog.getDataObserver().onRemoteAbConfigGet(!C1857i.m6592a(AppLog.getAbConfig(), d), d);
                if (C1856h.f5226b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getAbConfig ");
                    sb.append(d);
                    C1856h.m6581a(sb.toString(), null);
                }
                this.f5038d.mo13428a(d);
                this.f5036b = currentTimeMillis;
                return true;
            }
        }
        return false;
    }
}
