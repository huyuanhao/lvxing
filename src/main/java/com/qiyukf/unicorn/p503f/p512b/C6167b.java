package com.qiyukf.unicorn.p503f.p512b;

import com.tencent.p605ep.commonbase.network.HttpStatus;

/* renamed from: com.qiyukf.unicorn.f.b.b */
public final class C6167b extends Exception {
    /* renamed from: a */
    private int f19281a;

    public C6167b() {
    }

    public C6167b(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" code is: 408");
        super(sb.toString(), th);
        this.f19281a = HttpStatus.SC_REQUEST_TIMEOUT;
    }

    /* renamed from: a */
    public final int mo29239a() {
        return this.f19281a;
    }
}
