package com.ali.auth.third.p016a.p019c;

import com.ali.auth.third.core.config.C0990a;
import com.ali.auth.third.core.p023b.C0988e;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p032i.C1016a;
import com.ali.auth.third.core.rpc.C1032a;
import com.ali.auth.third.core.util.C1039d;
import com.ali.auth.third.p016a.p020d.C0978b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.a.c.b */
public class C0965b extends C1016a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0988e f1847a;

    public C0965b(C0988e eVar) {
        this.f1847a = eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo10274a(Object[] objArr) {
        try {
            final HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(C1032a.m1972a(C0990a.f1911j));
            C1039d.m1992a((Map<String, Object>) hashMap, jSONObject);
            int i = 480;
            int intValue = (objArr == null || objArr.length < 1) ? 480 : objArr[0].intValue();
            if (objArr != null && objArr.length >= 2) {
                i = objArr[1].intValue();
            }
            String str = (objArr == null || objArr.length < 3) ? null : objArr[2];
            hashMap.put("imageBitMap", C0978b.m1854a(jSONObject.getString("url"), intValue, i, str));
            C0989a.f1901p.mo10335a(new Runnable() {
                public void run() {
                    C0965b.this.f1847a.mo10309a(hashMap);
                }
            });
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10281a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10282a(Throwable th) {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                C0965b.this.f1847a.mo10305a(0, "");
            }
        });
    }
}
