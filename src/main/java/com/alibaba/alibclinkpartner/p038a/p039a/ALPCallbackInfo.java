package com.alibaba.alibclinkpartner.p038a.p039a;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.alibaba.alibclinkpartner.a.a.b */
public class ALPCallbackInfo {
    /* renamed from: a */
    public ALPJumpCallback f2226a;
    /* renamed from: b */
    public String f2227b;
    /* renamed from: c */
    public String f2228c;
    /* renamed from: d */
    public long f2229d;

    /* renamed from: a */
    public boolean mo10478a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(this.f2227b) || TextUtils.isEmpty(str2) || !this.f2227b.equals(str) || !this.f2228c.equals(str2)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo10477a(int i, Bundle bundle) {
        ALPJumpCallback dVar = this.f2226a;
        if (dVar != null) {
            dVar.mo10480a(i, bundle);
        }
    }

    /* renamed from: a */
    public void mo10476a(int i) {
        ALPJumpCallback dVar = this.f2226a;
        if (dVar != null) {
            dVar.mo10479a(i);
        }
    }
}
