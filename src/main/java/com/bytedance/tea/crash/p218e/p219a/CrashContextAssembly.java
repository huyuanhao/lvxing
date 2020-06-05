package com.bytedance.tea.crash.p218e.p219a;

import android.content.Context;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.p216c.CrashBody;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.tea.crash.e.a.e */
public class CrashContextAssembly {
    /* renamed from: a */
    private static volatile CrashContextAssembly f9317a;
    /* renamed from: b */
    private Context f9318b;
    /* renamed from: c */
    private Map<CrashType, BaseAssembly> f9319c = new HashMap();
    /* renamed from: d */
    private ActivityDataManager f9320d;
    /* renamed from: e */
    private BatteryWatcher f9321e;

    /* compiled from: CrashContextAssembly */
    /* renamed from: com.bytedance.tea.crash.e.a.e$1 */
    static /* synthetic */ class C25831 {
        /* renamed from: a */
        static final /* synthetic */ int[] f9322a = new int[CrashType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.bytedance.tea.crash.c[] r0 = com.bytedance.tea.crash.CrashType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f9322a = r0
            int[] r0 = f9322a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.bytedance.tea.crash.c r1 = com.bytedance.tea.crash.CrashType.JAVA     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f9322a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.bytedance.tea.crash.c r1 = com.bytedance.tea.crash.CrashType.ANR     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f9322a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.bytedance.tea.crash.c r1 = com.bytedance.tea.crash.CrashType.CUSTOM_JAVA     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p218e.p219a.CrashContextAssembly.C25831.m44300clinit():void");
        }
    }

    private CrashContextAssembly(Context context) {
        this.f9318b = context;
        this.f9320d = new ActivityDataManager(this.f9318b);
        this.f9321e = new BatteryWatcher(this.f9318b);
    }

    /* renamed from: a */
    public static CrashContextAssembly m12442a() {
        if (f9317a != null) {
            return f9317a;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    /* renamed from: a */
    public static void m12443a(Context context) {
        if (f9317a == null) {
            f9317a = new CrashContextAssembly(context);
        }
    }

    /* renamed from: a */
    private BaseAssembly m12441a(CrashType cVar) {
        BaseAssembly cVar2 = (BaseAssembly) this.f9319c.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i = C25831.f9322a[cVar.ordinal()];
        if (i == 1) {
            cVar2 = new JavaCrashAssembly(this.f9318b, this.f9320d, this.f9321e);
        } else if (i == 2) {
            cVar2 = new ANRAssembly(this.f9318b, this.f9320d, this.f9321e);
        } else if (i == 3) {
            cVar2 = new CustomJavaCrashAssembly(this.f9318b, this.f9320d, this.f9321e);
        }
        if (cVar2 != null) {
            this.f9319c.put(cVar, cVar2);
        }
        return cVar2;
    }

    /* renamed from: a */
    public CrashBody mo17041a(CrashType cVar, CrashBody aVar) {
        if (cVar == null) {
            return aVar;
        }
        BaseAssembly a = m12441a(cVar);
        return a != null ? a.mo17024a(aVar) : aVar;
    }
}
