package com.qiyukf.unicorn.p503f;

import com.qiyukf.nimlib.sdk.auth.LoginInfo;

/* renamed from: com.qiyukf.unicorn.f.b */
public final class C6165b {
    /* renamed from: a */
    private LoginInfo f19277a;
    /* renamed from: b */
    private String f19278b;
    /* renamed from: c */
    private boolean f19279c;
    /* renamed from: d */
    private boolean f19280d;

    /* renamed from: a */
    public final LoginInfo mo29234a() {
        return this.f19277a;
    }

    /* renamed from: a */
    public final void mo29235a(LoginInfo loginInfo) {
        this.f19277a = loginInfo;
    }

    /* renamed from: a */
    public final void mo29236a(boolean z) {
        this.f19279c = z;
    }

    /* renamed from: b */
    public final boolean mo29237b() {
        return this.f19280d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("auth: ");
        sb.append(this.f19277a);
        sb.append("\r\nexchanges: ");
        sb.append(this.f19278b);
        sb.append("\r\npush: ");
        sb.append(this.f19279c);
        sb.append("\r\nisHisAccount: ");
        sb.append(this.f19280d);
        return sb.toString();
    }
}
