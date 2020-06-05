package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.content.Context;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;

@C6111b(mo29052a = 70)
/* renamed from: com.qiyukf.unicorn.f.a.d.p */
public class C6135p extends C6144e {
    @C6110a(mo29051a = "sessionid")
    /* renamed from: a */
    private long f19180a;
    @C6110a(mo29051a = "message")
    /* renamed from: b */
    private String f19181b;

    /* renamed from: a */
    public final String mo29146a() {
        return this.f19181b;
    }

    /* renamed from: b */
    public final long mo29147b() {
        return this.f19180a;
    }

    public boolean countToUnread() {
        return true;
    }

    public String getContent(Context context) {
        return this.f19181b;
    }
}
