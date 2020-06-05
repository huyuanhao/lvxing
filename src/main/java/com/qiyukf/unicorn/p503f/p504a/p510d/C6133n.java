package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.content.Context;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;

@C6111b(mo29052a = 6)
/* renamed from: com.qiyukf.unicorn.f.a.d.n */
public class C6133n extends C6144e {
    @C6110a(mo29051a = "sessionid")
    /* renamed from: a */
    private long f19172a;
    @C6110a(mo29051a = "evaluate")
    /* renamed from: b */
    private int f19173b;
    @C6110a(mo29051a = "evaluation_auto_popup")
    /* renamed from: c */
    private int f19174c;
    @C6110a(mo29051a = "message")
    /* renamed from: d */
    private String f19175d;
    @C6110a(mo29051a = "close_reason")
    /* renamed from: e */
    private int f19176e;

    /* renamed from: a */
    public final long mo29138a() {
        return this.f19172a;
    }

    /* renamed from: b */
    public final int mo29139b() {
        return this.f19173b;
    }

    /* renamed from: c */
    public final boolean mo29140c() {
        return this.f19174c == 1;
    }

    public boolean countToUnread() {
        return true;
    }

    /* renamed from: d */
    public final String mo29141d() {
        return this.f19175d;
    }

    /* renamed from: e */
    public final int mo29142e() {
        return this.f19176e;
    }

    public String getContent(Context context) {
        return this.f19175d;
    }
}
