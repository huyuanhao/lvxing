package com.bytedance.sdk.adnet.core;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bytedance.sdk.adnet.core.b */
public final class HttpResponse {
    /* renamed from: a */
    private final int f6216a;
    /* renamed from: b */
    private final List<C1969a> f6217b;
    /* renamed from: c */
    private final int f6218c;
    /* renamed from: d */
    private final InputStream f6219d;

    public HttpResponse(int i, List<C1969a> list) {
        this(i, list, -1, null);
    }

    public HttpResponse(int i, List<C1969a> list, int i2, InputStream inputStream) {
        this.f6216a = i;
        this.f6217b = list;
        this.f6218c = i2;
        this.f6219d = inputStream;
    }

    /* renamed from: a */
    public final int mo14311a() {
        return this.f6216a;
    }

    /* renamed from: b */
    public final List<C1969a> mo14312b() {
        return Collections.unmodifiableList(this.f6217b);
    }

    /* renamed from: c */
    public final int mo14313c() {
        return this.f6218c;
    }

    /* renamed from: d */
    public final InputStream mo14314d() {
        return this.f6219d;
    }
}
