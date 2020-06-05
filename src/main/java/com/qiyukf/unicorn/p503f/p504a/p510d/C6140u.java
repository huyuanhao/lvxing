package com.qiyukf.unicorn.p503f.p504a.p510d;

import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;

@C6111b(mo29052a = 57)
/* renamed from: com.qiyukf.unicorn.f.a.d.u */
public class C6140u extends C6144e {
    @C6110a(mo29051a = "config")
    /* renamed from: a */
    private C6141a f19205a;

    /* renamed from: com.qiyukf.unicorn.f.a.d.u$a */
    public static class C6141a implements C6070a {
        /* access modifiers changed from: private */
        @C6110a(mo29051a = "switch")
        /* renamed from: a */
        public int f19206a;
        /* access modifiers changed from: private */
        @C6110a(mo29051a = "sendingRate")
        /* renamed from: b */
        public String f19207b;
    }

    /* renamed from: a */
    public final boolean mo29170a() {
        C6141a aVar = this.f19205a;
        return aVar != null && aVar.f19206a > 0;
    }

    /* renamed from: b */
    public final float mo29171b() {
        C6141a aVar = this.f19205a;
        if (aVar != null) {
            try {
                return Float.parseFloat(aVar.f19207b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0.0f;
    }
}
