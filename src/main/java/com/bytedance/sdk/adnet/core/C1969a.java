package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;

/* compiled from: Header */
/* renamed from: com.bytedance.sdk.adnet.core.a */
public final class C1969a {
    /* renamed from: a */
    private final String f6214a;
    /* renamed from: b */
    private final String f6215b;

    public C1969a(String str, String str2) {
        this.f6214a = str;
        this.f6215b = str2;
    }

    /* renamed from: a */
    public final String mo14306a() {
        return this.f6214a;
    }

    /* renamed from: b */
    public final String mo14307b() {
        return this.f6215b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1969a aVar = (C1969a) obj;
        if (!TextUtils.equals(this.f6214a, aVar.f6214a) || !TextUtils.equals(this.f6215b, aVar.f6215b)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.f6214a.hashCode() * 31) + this.f6215b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Header[name=");
        sb.append(this.f6214a);
        sb.append(",value=");
        sb.append(this.f6215b);
        sb.append("]");
        return sb.toString();
    }
}
