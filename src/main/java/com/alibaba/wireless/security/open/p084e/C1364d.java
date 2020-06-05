package com.alibaba.wireless.security.open.p084e;

import android.content.Context;
import com.alibaba.wireless.security.framework.C1338c;
import com.alibaba.wireless.security.framework.C1343h;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.alibaba.wireless.security.open.e.d */
public class C1364d {
    /* renamed from: a */
    boolean f3565a = false;
    /* renamed from: b */
    private Set<Object> f3566b = new HashSet();
    /* renamed from: c */
    private Object f3567c = new Object();
    /* renamed from: d */
    private String f3568d = null;
    /* renamed from: e */
    private C1338c f3569e = null;

    public C1364d() {
    }

    public C1364d(String str) {
        this.f3568d = str;
    }

    /* renamed from: a */
    public synchronized int mo11892a(Context context, String str, boolean z, boolean z2) throws SecException {
        if (!this.f3565a) {
            if (context != null) {
                C1343h hVar = new C1343h();
                hVar.mo11859a(context, this.f3568d, str, z, new Object[0]);
                hVar.mo11857a(hVar.mo11858a());
                this.f3569e = hVar;
                this.f3565a = true;
            } else {
                throw new SecException(101);
            }
        }
        return !this.f3565a;
    }

    /* renamed from: a */
    public C1338c mo11893a() {
        return this.f3569e;
    }
}
