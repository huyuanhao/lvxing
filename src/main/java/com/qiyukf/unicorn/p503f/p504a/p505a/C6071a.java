package com.qiyukf.unicorn.p503f.p504a.p505a;

import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5966a;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5969b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5972c;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5968b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b.C5971b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6072a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6074b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6076c;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6079d;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6084f;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6086g;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6090h;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6092i;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6094j;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6095k;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6099l;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6101m;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6103n;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6105a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6106b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6107c;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.a.a.a */
public final class C6071a {
    /* renamed from: b */
    private static C6071a f18980b;
    /* renamed from: a */
    private Map<String, Class<? extends C5972c>> f18981a = new HashMap();

    private C6071a() {
        m24133a(C6086g.class);
        m24133a(C6095k.class);
        m24133a(C6094j.class);
        m24133a(C6101m.class);
        m24133a(C6074b.class);
        m24133a(C6072a.class);
        m24133a(C6099l.class);
        m24133a(C6103n.class);
        m24133a(C6084f.class);
        m24133a(C6092i.class);
        m24133a(C6080e.class);
        m24133a(C6076c.class);
        m24133a(C6079d.class);
        m24133a(C5968b.class);
        m24133a(C6090h.class);
        m24133a(C5971b.class);
        m24133a(C6107c.class);
        m24133a(C6105a.class);
        m24133a(C6106b.class);
    }

    /* renamed from: a */
    public static C6071a m24132a() {
        if (f18980b == null) {
            f18980b = new C6071a();
        }
        return f18980b;
    }

    /* renamed from: a */
    private void m24133a(Class<? extends C5972c> cls) {
        C6112c cVar = (C6112c) cls.getAnnotation(C6112c.class);
        if (cVar != null) {
            this.f18981a.put(cVar.mo29054a(), cls);
        }
    }

    /* renamed from: a */
    public final C5972c mo28921a(C5966a aVar) {
        try {
            if (TextUtils.equals(aVar.mo28514a(), "01")) {
                C6103n nVar = new C6103n();
                nVar.mo29036a(aVar.mo28517b());
                nVar.mo28536a(aVar);
                return nVar;
            }
            if (TextUtils.equals(aVar.mo28514a(), "11")) {
                JSONObject a = C5366b.m22027a(aVar.mo28517b());
                Class cls = (Class) this.f18981a.get(C5366b.m22039e(a, "id"));
                if (cls != null) {
                    C5972c cVar = (C5972c) cls.newInstance();
                    cVar.fromJson(a);
                    cVar.mo28536a(aVar);
                    return cVar;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final C5972c mo28922a(C5969b bVar) {
        try {
            JSONObject a = bVar.mo28518a();
            Class cls = (Class) this.f18981a.get(C5366b.m22039e(a, "id"));
            if (cls != null) {
                C5972c cVar = (C5972c) cls.newInstance();
                cVar.fromJson(a);
                cVar.mo28536a(bVar);
                return cVar;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
