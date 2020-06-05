package com.p530ss.android.downloadlib.p541a.p543b;

import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.b.b */
public class DownloadInstallInfo {
    /* renamed from: a */
    public static int f21304a = 0;
    /* renamed from: b */
    public static int f21305b = 1;
    /* renamed from: c */
    public static int f21306c = 2;
    /* renamed from: d */
    private int f21307d = f21304a;
    /* renamed from: e */
    private long f21308e = 0;
    /* renamed from: f */
    private JSONObject f21309f = null;
    /* renamed from: g */
    private int f21310g = 0;
    /* renamed from: h */
    private String f21311h;
    /* renamed from: i */
    private String f21312i;

    public DownloadInstallInfo() {
        String str = "";
        this.f21311h = str;
        this.f21312i = str;
    }

    /* renamed from: a */
    public boolean mo31261a() {
        return this.f21307d == f21305b;
    }

    /* renamed from: a */
    public DownloadInstallInfo mo31260a(int i) {
        this.f21307d = i;
        return this;
    }
}
