package com.qiyukf.unicorn.p503f.p504a;

import android.util.SparseArray;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5966a;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5969b;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6071a;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6104b;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6108c;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6119a;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6120b;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6121c;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6122d;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6123e;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6124f;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6126g;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6127h;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6128i;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6129j;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6130k;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6131l;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6132m;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6133n;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6134o;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6135p;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6136q;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6137r;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6138s;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6139t;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6140u;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6142v;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6143w;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6146b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6148d;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6149e;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6150f;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6153i;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6155k;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6156l;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6159o;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6160p;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6161q;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6162r;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.a.f */
public final class C6164f implements MsgAttachmentParser {
    /* renamed from: b */
    private static C6164f f19275b;
    /* renamed from: a */
    private final SparseArray<Class<? extends C6118d>> f19276a = new SparseArray<>();

    private C6164f() {
        m24458a(C6119a.class);
        m24458a(C6155k.class);
        m24458a(C6150f.class);
        m24458a(C6133n.class);
        m24458a(C6128i.class);
        m24458a(C6148d.class);
        m24458a(C6131l.class);
        m24458a(C6159o.class);
        m24458a(C6137r.class);
        m24458a(C6153i.class);
        m24458a(C6161q.class);
        m24458a(ProductAttachment.class);
        m24458a(C6129j.class);
        m24458a(C6143w.class);
        m24458a(C6146b.class);
        m24458a(C6120b.class);
        m24458a(C6130k.class);
        m24458a(C6122d.class);
        m24458a(C6135p.class);
        m24458a(C6162r.class);
        m24458a(C6140u.class);
        m24458a(C6136q.class);
        m24458a(C6139t.class);
        m24458a(C6138s.class);
        m24458a(C6121c.class);
        m24458a(C6123e.class);
        m24458a(C5966a.class);
        m24458a(C5969b.class);
        m24458a(C6108c.class);
        m24458a(C6104b.class);
        m24458a(C6149e.class);
        m24458a(C6124f.class);
        m24458a(C6134o.class);
        m24458a(C6142v.class);
        m24458a(C6156l.class);
        m24458a(C6132m.class);
        m24458a(C6160p.class);
        m24458a(C6126g.class);
        m24458a(C6127h.class);
    }

    /* renamed from: a */
    public static C6164f m24457a() {
        if (f19275b == null) {
            f19275b = new C6164f();
        }
        return f19275b;
    }

    /* renamed from: a */
    private void m24458a(Class<? extends C6118d> cls) {
        C6111b bVar = (C6111b) cls.getAnnotation(C6111b.class);
        if (bVar != null) {
            this.f19276a.put(bVar.mo29052a(), cls);
        }
    }

    /* renamed from: a */
    public final C6118d parse(String str) {
        try {
            JSONObject a = C5366b.m22027a(str);
            Class cls = (Class) this.f19276a.get(C5366b.m22034b(a, "cmd"));
            if (cls != null) {
                C6144e eVar = (C6144e) cls.newInstance();
                eVar.fromJson(a);
                if (eVar instanceof C5966a) {
                    return C6071a.m24132a().mo28921a((C5966a) eVar);
                } else if (!(eVar instanceof C5969b)) {
                    return eVar;
                } else {
                    return C6071a.m24132a().mo28922a((C5969b) eVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
