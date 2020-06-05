package com.bytedance.tea.crash.upload;

import org.json.JSONObject;

/* compiled from: Response */
/* renamed from: com.bytedance.tea.crash.upload.f */
public class C2602f {
    /* renamed from: a */
    private final int f9415a;
    /* renamed from: b */
    private String f9416b;
    /* renamed from: c */
    private JSONObject f9417c;

    public C2602f(int i) {
        this.f9415a = i;
    }

    public C2602f(int i, Throwable th) {
        this.f9415a = i;
        if (th != null) {
            this.f9416b = th.getMessage();
        }
    }

    public C2602f(int i, String str) {
        this.f9415a = i;
        this.f9416b = str;
    }

    public C2602f(int i, JSONObject jSONObject) {
        this.f9415a = i;
        this.f9417c = jSONObject;
    }

    /* renamed from: a */
    public boolean mo17083a() {
        return this.f9415a == 0;
    }
}
