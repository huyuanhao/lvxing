package com.alibaba.mtl.appmonitor.p071d;

import android.text.TextUtils;
import java.util.Set;

/* renamed from: com.alibaba.mtl.appmonitor.d.b */
public class AccurateSampleCondition {
    /* renamed from: a */
    private Set<String> f3203a;
    /* renamed from: b */
    private C1299a f3204b;

    /* compiled from: AccurateSampleCondition */
    /* renamed from: com.alibaba.mtl.appmonitor.d.b$a */
    private enum C1299a {
        IN,
        NOT_IN
    }

    /* renamed from: a */
    public boolean mo11633a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.f3203a.contains(str);
        return this.f3204b == C1299a.IN ? contains : !contains;
    }
}
