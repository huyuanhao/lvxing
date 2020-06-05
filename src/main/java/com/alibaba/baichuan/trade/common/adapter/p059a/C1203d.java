package com.alibaba.baichuan.trade.common.adapter.p059a;

import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.wireless.security.open.C1355b;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.p082c.C1359a;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.a.d */
public class C1203d extends C1201b {
    /* renamed from: b */
    private static final String f2487b = C1203d.class.getSimpleName();
    /* renamed from: a */
    private C1355b f2488a;

    /* renamed from: a */
    public String mo10850a(String str) {
        String str2;
        C1355b bVar = this.f2488a;
        if (bVar == null) {
            return str;
        }
        C1359a c = bVar.mo11876c();
        if (c != null) {
            try {
                str = c.mo11879a(str);
            } catch (SecException e) {
                C1224a.m2403a(f2487b, "dynamicEncrypt", e);
                return str;
            }
        }
        return str2;
    }

    /* renamed from: b */
    public String mo10851b(String str) {
        String str2;
        C1355b bVar = this.f2488a;
        if (bVar == null) {
            return str;
        }
        C1359a c = bVar.mo11876c();
        if (c != null) {
            try {
                str = c.mo11880b(str);
            } catch (SecException e) {
                C1224a.m2403a(f2487b, "dynamicDecrypt ", e);
                return str;
            }
        }
        return str2;
    }
}
