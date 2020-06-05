package com.tencent.android.tpush.p581c;

import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.c.a */
public abstract class C6867a {
    /* renamed from: a */
    protected JSONObject f22856a = null;
    /* renamed from: b */
    protected String f22857b = null;
    /* renamed from: c */
    protected String f22858c = null;
    /* renamed from: d */
    private String f22859d = null;
    /* renamed from: e */
    private String f22860e = null;
    /* renamed from: f */
    private String f22861f = null;
    /* renamed from: g */
    private String f22862g = null;

    /* renamed from: c */
    public abstract int mo32998c();

    /* renamed from: d */
    public abstract void mo32999d();

    protected C6867a(String str) {
        this.f22857b = str;
    }

    /* renamed from: a */
    public String mo32996a() {
        return this.f22858c;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|3|5|6|7|8|9|10|11|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087 A[SYNTHETIC, Splitter:B:23:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5 A[Catch:{ all -> 0x00ad }] */
    /* renamed from: b */
    public void mo32997b() {
        /*
        r10 = this;
        java.lang.String r0 = "accept_time"
        java.lang.String r1 = "custom_content"
        java.lang.String r2 = "content"
        java.lang.String r3 = "title"
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0012 }
        java.lang.String r5 = r10.f22857b     // Catch:{ Exception -> 0x0012 }
        r4.<init>(r5)     // Catch:{ Exception -> 0x0012 }
        r10.f22856a = r4     // Catch:{ Exception -> 0x0012 }
        goto L_0x005d
    L_0x0012:
        r4 = 1
        org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0032 }
        java.lang.String r6 = r10.f22857b     // Catch:{ Exception -> 0x0032 }
        java.lang.String r7 = r10.f22857b     // Catch:{ Exception -> 0x0032 }
        java.lang.String r8 = "{"
        int r7 = r7.indexOf(r8)     // Catch:{ Exception -> 0x0032 }
        java.lang.String r8 = r10.f22857b     // Catch:{ Exception -> 0x0032 }
        java.lang.String r9 = "}"
        int r8 = r8.lastIndexOf(r9)     // Catch:{ Exception -> 0x0032 }
        int r8 = r8 + r4
        java.lang.String r6 = r6.substring(r7, r8)     // Catch:{ Exception -> 0x0032 }
        r5.<init>(r6)     // Catch:{ Exception -> 0x0032 }
        r10.f22856a = r5     // Catch:{ Exception -> 0x0032 }
        goto L_0x005d
    L_0x0032:
        org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0040 }
        java.lang.String r6 = r10.f22857b     // Catch:{ Exception -> 0x0040 }
        java.lang.String r4 = r6.substring(r4)     // Catch:{ Exception -> 0x0040 }
        r5.<init>(r4)     // Catch:{ Exception -> 0x0040 }
        r10.f22856a = r5     // Catch:{ Exception -> 0x0040 }
        goto L_0x005d
    L_0x0040:
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x004f }
        java.lang.String r5 = r10.f22857b     // Catch:{ Exception -> 0x004f }
        r6 = 2
        java.lang.String r5 = r5.substring(r6)     // Catch:{ Exception -> 0x004f }
        r4.<init>(r5)     // Catch:{ Exception -> 0x004f }
        r10.f22856a = r4     // Catch:{ Exception -> 0x004f }
        goto L_0x005d
    L_0x004f:
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x005d }
        java.lang.String r5 = r10.f22857b     // Catch:{ Exception -> 0x005d }
        r6 = 3
        java.lang.String r5 = r5.substring(r6)     // Catch:{ Exception -> 0x005d }
        r4.<init>(r5)     // Catch:{ Exception -> 0x005d }
        r10.f22856a = r4     // Catch:{ Exception -> 0x005d }
    L_0x005d:
        org.json.JSONObject r4 = r10.f22856a     // Catch:{ all -> 0x00ad }
        boolean r4 = r4.isNull(r3)     // Catch:{ all -> 0x00ad }
        if (r4 != 0) goto L_0x006d
        org.json.JSONObject r4 = r10.f22856a     // Catch:{ all -> 0x00ad }
        java.lang.String r3 = r4.getString(r3)     // Catch:{ all -> 0x00ad }
        r10.f22859d = r3     // Catch:{ all -> 0x00ad }
    L_0x006d:
        org.json.JSONObject r3 = r10.f22856a     // Catch:{ all -> 0x00ad }
        boolean r3 = r3.isNull(r2)     // Catch:{ all -> 0x00ad }
        if (r3 != 0) goto L_0x007d
        org.json.JSONObject r3 = r10.f22856a     // Catch:{ all -> 0x00ad }
        java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x00ad }
        r10.f22860e = r2     // Catch:{ all -> 0x00ad }
    L_0x007d:
        org.json.JSONObject r2 = r10.f22856a     // Catch:{ all -> 0x00ad }
        boolean r2 = r2.isNull(r1)     // Catch:{ all -> 0x00ad }
        java.lang.String r3 = ""
        if (r2 != 0) goto L_0x009d
        org.json.JSONObject r2 = r10.f22856a     // Catch:{ all -> 0x00ad }
        java.lang.String r1 = r2.optString(r1, r3)     // Catch:{ all -> 0x00ad }
        if (r1 == 0) goto L_0x009d
        java.lang.String r2 = r1.trim()     // Catch:{ all -> 0x00ad }
        java.lang.String r4 = "{}"
        boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x00ad }
        if (r2 != 0) goto L_0x009d
        r10.f22861f = r1     // Catch:{ all -> 0x00ad }
    L_0x009d:
        org.json.JSONObject r1 = r10.f22856a     // Catch:{ all -> 0x00ad }
        boolean r1 = r1.isNull(r0)     // Catch:{ all -> 0x00ad }
        if (r1 != 0) goto L_0x00ad
        org.json.JSONObject r1 = r10.f22856a     // Catch:{ all -> 0x00ad }
        java.lang.String r0 = r1.optString(r0, r3)     // Catch:{ all -> 0x00ad }
        r10.f22862g = r0     // Catch:{ all -> 0x00ad }
    L_0x00ad:
        r10.mo32999d()
        java.lang.String r0 = r10.f22857b
        java.lang.String r0 = com.tencent.android.tpush.common.C6914l.m29508a(r0)
        java.lang.String r0 = r0.toUpperCase()
        r10.f22858c = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p581c.C6867a.mo32997b():void");
    }

    /* renamed from: e */
    public String mo33000e() {
        return this.f22859d;
    }

    /* renamed from: f */
    public String mo33001f() {
        return this.f22860e;
    }

    /* renamed from: g */
    public String mo33002g() {
        return this.f22861f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseMessageHolder [msgJson=");
        sb.append(this.f22856a);
        sb.append(", msgJsonStr=");
        sb.append(this.f22857b);
        sb.append(", title=");
        sb.append(this.f22859d);
        sb.append(", content=");
        sb.append(this.f22860e);
        sb.append(", customContent=");
        sb.append(this.f22861f);
        sb.append(", acceptTime=");
        sb.append(this.f22862g);
        sb.append("]");
        return sb.toString();
    }
}
