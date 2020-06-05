package com.bytedance.tea.crash.p218e.p219a;

import android.content.Context;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p216c.C2578b;
import com.bytedance.tea.crash.p216c.CrashBody;

@Deprecated
/* renamed from: com.bytedance.tea.crash.e.a.f */
class CustomJavaCrashAssembly extends BaseAssembly {
    CustomJavaCrashAssembly(Context context, ActivityDataManager bVar, BatteryWatcher dVar) {
        super(CrashType.CUSTOM_JAVA, context, bVar, dVar);
    }

    /* renamed from: a */
    public CrashBody mo17024a(CrashBody aVar) {
        CrashBody a = super.mo17024a(aVar);
        C2578b a2 = C2578b.m12359a(this.f9311b);
        a2.mo17004a(NpthBus.m12591a().mo17019a());
        a2.mo17003a(NpthBus.m12594c().mo17059a());
        a2.mo17005b(this.f9312c.mo15829c());
        a.mo16991a(a2);
        return a;
    }
}
