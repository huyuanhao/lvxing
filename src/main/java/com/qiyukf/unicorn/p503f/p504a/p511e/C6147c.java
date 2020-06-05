package com.qiyukf.unicorn.p503f.p504a.p511e;

import android.text.TextUtils;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;

@C6111b(mo29052a = 52)
/* renamed from: com.qiyukf.unicorn.f.a.e.c */
public final class C6147c extends C6144e {
    @C6110a(mo29051a = "foreignid")
    /* renamed from: a */
    private String f19217a;
    @C6110a(mo29051a = "authToken")
    /* renamed from: b */
    private String f19218b;
    @C6110a(mo29051a = "userinfo")
    /* renamed from: c */
    private String f19219c;

    /* renamed from: a */
    public final void mo29181a(String str) {
        this.f19217a = str;
    }

    /* renamed from: b */
    public final void mo29182b(String str) {
        this.f19219c = str;
    }

    /* renamed from: c */
    public final void mo29183c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f19218b = str;
    }
}
