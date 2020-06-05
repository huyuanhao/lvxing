package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* renamed from: com.alipay.android.phone.mrpc.core.o */
public final class C1424o extends C1429t {
    /* renamed from: b */
    private String f3648b;
    /* renamed from: c */
    private byte[] f3649c;
    /* renamed from: d */
    private String f3650d = "application/x-www-form-urlencoded";
    /* renamed from: e */
    private ArrayList<Header> f3651e = new ArrayList<>();
    /* renamed from: f */
    private Map<String, String> f3652f = new HashMap();
    /* renamed from: g */
    private boolean f3653g;

    public C1424o(String str) {
        this.f3648b = str;
    }

    /* renamed from: a */
    public final String mo11974a() {
        return this.f3648b;
    }

    /* renamed from: a */
    public final void mo11975a(String str) {
        this.f3650d = str;
    }

    /* renamed from: a */
    public final void mo11976a(String str, String str2) {
        if (this.f3652f == null) {
            this.f3652f = new HashMap();
        }
        this.f3652f.put(str, str2);
    }

    /* renamed from: a */
    public final void mo11977a(Header header) {
        this.f3651e.add(header);
    }

    /* renamed from: a */
    public final void mo11978a(boolean z) {
        this.f3653g = z;
    }

    /* renamed from: a */
    public final void mo11979a(byte[] bArr) {
        this.f3649c = bArr;
    }

    /* renamed from: b */
    public final String mo11980b(String str) {
        Map<String, String> map = this.f3652f;
        if (map == null) {
            return null;
        }
        return (String) map.get(str);
    }

    /* renamed from: b */
    public final byte[] mo11981b() {
        return this.f3649c;
    }

    /* renamed from: c */
    public final String mo11982c() {
        return this.f3650d;
    }

    /* renamed from: d */
    public final ArrayList<Header> mo11983d() {
        return this.f3651e;
    }

    /* renamed from: e */
    public final boolean mo11984e() {
        return this.f3653g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1424o oVar = (C1424o) obj;
        byte[] bArr = this.f3649c;
        if (bArr == null) {
            if (oVar.f3649c != null) {
                return false;
            }
        } else if (!bArr.equals(oVar.f3649c)) {
            return false;
        }
        String str = this.f3648b;
        String str2 = oVar.f3648b;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    public final int hashCode() {
        /*
        r2 = this;
        java.util.Map<java.lang.String, java.lang.String> r0 = r2.f3652f
        if (r0 == 0) goto L_0x001b
        java.lang.String r1 = "id"
        boolean r0 = r0.containsKey(r1)
        if (r0 == 0) goto L_0x001b
        java.util.Map<java.lang.String, java.lang.String> r0 = r2.f3652f
        java.lang.Object r0 = r0.get(r1)
        java.lang.String r0 = (java.lang.String) r0
        int r0 = r0.hashCode()
        int r0 = r0 + 31
        goto L_0x001c
    L_0x001b:
        r0 = 1
    L_0x001c:
        int r0 = r0 * 31
        java.lang.String r1 = r2.f3648b
        if (r1 != 0) goto L_0x0024
        r1 = 0
        goto L_0x0028
    L_0x0024:
        int r1 = r1.hashCode()
    L_0x0028:
        int r0 = r0 + r1
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.C1424o.hashCode():int");
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", new Object[]{this.f3648b, this.f3651e});
    }
}
