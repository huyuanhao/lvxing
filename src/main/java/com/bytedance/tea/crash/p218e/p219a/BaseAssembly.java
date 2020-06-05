package com.bytedance.tea.crash.p218e.p219a;

import android.content.Context;
import android.os.Process;
import com.bytedance.tea.crash.AttachUserData;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.ICommonParams;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p216c.CrashBody;
import com.bytedance.tea.crash.p218e.LogcatDump;
import com.bytedance.tea.crash.p221g.App;
import com.bytedance.tea.crash.p221g.Storage;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.e.a.c */
public abstract class BaseAssembly {
    /* renamed from: a */
    protected CrashType f9310a;
    /* renamed from: b */
    protected Context f9311b;
    /* renamed from: c */
    protected ICommonParams f9312c = NpthBus.m12591a().mo17021c();
    /* renamed from: d */
    protected ActivityDataManager f9313d;
    /* renamed from: e */
    protected BatteryWatcher f9314e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo17034a() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo17036b() {
        return true;
    }

    BaseAssembly(CrashType cVar, Context context, ActivityDataManager bVar, BatteryWatcher dVar) {
        this.f9310a = cVar;
        this.f9311b = context;
        this.f9313d = bVar;
        this.f9314e = dVar;
    }

    /* renamed from: a */
    public CrashBody mo17024a(CrashBody aVar) {
        if (aVar == null) {
            aVar = new CrashBody();
        }
        mo17035b(aVar);
        m12431e(aVar);
        return aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo17035b(CrashBody aVar) {
        if (mo17036b()) {
            ActivityDataManager bVar = this.f9313d;
            if (bVar != null) {
                aVar.mo16992a(bVar);
            }
        }
        aVar.mo16990a(NpthBus.m12597f());
        aVar.mo16998a("is_background", (Object) Boolean.valueOf(!App.m12500a(this.f9311b)));
        aVar.mo16998a("pid", (Object) Integer.valueOf(Process.myPid()));
        aVar.mo16998a("battery", (Object) Integer.valueOf(this.f9314e.mo17039a()));
        aVar.mo16995a(this.f9312c.mo15831e());
        aVar.mo17000b((Map<Integer, String>) NpthBus.m12600i());
        aVar.mo16989a(NpthBus.m12601j(), NpthBus.m12602k());
        aVar.mo16994a(this.f9312c.mo15832f());
        aVar.mo16996a(Storage.m12581a(this.f9311b));
        if (mo17034a()) {
            mo17038d(aVar);
        }
        aVar.mo16993a(this.f9312c.mo15830d());
        String g = NpthBus.m12598g();
        if (g != null) {
            aVar.mo16998a("business", (Object) g);
        }
        if (NpthBus.m12599h()) {
            aVar.mo16998a("is_mp", (Object) Integer.valueOf(1));
        }
        aVar.mo17001c(NpthBus.m12593b().mo16971a());
        aVar.mo16998a("crash_uuid", (Object) UUID.randomUUID().toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo17037c(CrashBody aVar) {
        String str = "crash_update_version_code";
        String str2 = "crash_version_code";
        Map a = NpthBus.m12591a().mo17019a();
        if (a != null) {
            String str3 = "app_version";
            if (a.containsKey(str3)) {
                aVar.mo16998a("crash_version", a.get(str3));
            }
            String str4 = "version_name";
            if (a.containsKey(str4)) {
                aVar.mo16998a(str3, a.get(str4));
            }
            String str5 = "version_code";
            if (a.containsKey(str5)) {
                try {
                    aVar.mo16998a(str2, (Object) Integer.valueOf(Integer.parseInt(a.get(str5).toString())));
                } catch (Exception unused) {
                    aVar.mo16998a(str2, a.get(str5));
                }
            }
            String str6 = "update_version_code";
            if (a.containsKey(str6)) {
                try {
                    aVar.mo16998a(str, (Object) Integer.valueOf(Integer.parseInt(a.get(str6).toString())));
                } catch (Exception unused2) {
                    aVar.mo16998a(str, a.get(str6));
                }
            }
        }
    }

    /* renamed from: e */
    private void m12431e(CrashBody aVar) {
        List<AttachUserData> a = NpthBus.m12593b().mo16970a(this.f9310a);
        if (a != null) {
            JSONObject jSONObject = new JSONObject();
            for (AttachUserData a2 : a) {
                Map a3 = a2.mo16957a(this.f9310a);
                if (a3 != null) {
                    try {
                        for (String str : a3.keySet()) {
                            jSONObject.put(str, a3.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            aVar.mo16998a("custom", (Object) jSONObject);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo17038d(CrashBody aVar) {
        aVar.mo16999b(LogcatDump.m12458a(NpthBus.m12596e().mo17043b(), NpthBus.m12596e().mo17044c()));
    }
}
