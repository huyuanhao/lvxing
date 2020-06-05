package com.qiyukf.nimlib;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5965a;

/* renamed from: com.qiyukf.nimlib.c */
public final class C5729c {
    /* renamed from: a */
    public static void m23062a(boolean z) {
        if (C5743d.m23121f() || C5743d.m23122g()) {
            String b = C5946c.m23841b(C5944b.TYPE_LOG);
            int i = C5965a.f18785a ? 2 : 4;
            if (!z) {
                i = 6;
            }
            C5264a.m21618a(b, "nim_sdk.log", i, C5743d.m23122g());
        }
    }
}
