package com.qiyukf.unicorn.p503f.p504a.p505a.p506a;

import android.text.TextUtils;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5967a;
import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import java.util.List;
import org.json.JSONObject;

@C6112c(mo29054a = "bot_form")
/* renamed from: com.qiyukf.unicorn.f.a.a.a.f */
public class C6084f extends C5967a {
    @C6110a(mo29051a = "label")
    /* renamed from: a */
    private String f19016a;
    @C6110a(mo29051a = "params")
    /* renamed from: b */
    private String f19017b;
    @C6110a(mo29051a = "forms")
    /* renamed from: c */
    private List<C6085a> f19018c;
    @C6110a(mo29051a = "hasCommit")
    /* renamed from: d */
    private boolean f19019d;

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.f$a */
    public static class C6085a implements C6070a {
        @C6110a(mo29051a = "id")
        /* renamed from: a */
        private String f19020a;
        @C6110a(mo29051a = "type")
        /* renamed from: b */
        private String f19021b;
        @C6110a(mo29051a = "label")
        /* renamed from: c */
        private String f19022c;
        @C6110a(mo29051a = "required")
        /* renamed from: d */
        private int f19023d;
        @C6110a(mo29051a = "value")
        /* renamed from: e */
        private Object f19024e;

        /* renamed from: a */
        public final String mo28961a() {
            return this.f19020a;
        }

        /* renamed from: a */
        public final void mo28962a(Object obj) {
            this.f19024e = obj;
        }

        /* renamed from: b */
        public final String mo28963b() {
            return this.f19021b;
        }

        /* renamed from: c */
        public final String mo28964c() {
            return this.f19022c;
        }

        /* renamed from: d */
        public final boolean mo28965d() {
            return this.f19023d == 1;
        }

        /* renamed from: e */
        public final boolean mo28966e() {
            return TextUtils.equals(this.f19021b, "image");
        }

        /* renamed from: f */
        public final Object mo28967f() {
            return this.f19024e;
        }

        /* renamed from: g */
        public final String mo28968g() {
            if (!mo28966e()) {
                Object obj = this.f19024e;
                if (obj instanceof String) {
                    return (String) obj;
                }
            }
            return null;
        }

        /* renamed from: h */
        public final JSONObject mo28969h() {
            if (mo28966e()) {
                Object obj = this.f19024e;
                if (obj instanceof JSONObject) {
                    return (JSONObject) obj;
                }
            }
            return null;
        }

        /* renamed from: i */
        public final boolean mo28970i() {
            return !mo28965d() || !TextUtils.isEmpty(mo28968g()) || mo28969h() != null;
        }
    }

    /* renamed from: c */
    public final String mo28956c() {
        return this.f19016a;
    }

    /* renamed from: d */
    public final String mo28957d() {
        return this.f19017b;
    }

    /* renamed from: e */
    public final List<C6085a> mo28958e() {
        return this.f19018c;
    }

    /* renamed from: f */
    public final boolean mo28959f() {
        return this.f19019d;
    }

    /* renamed from: g */
    public final void mo28960g() {
        this.f19019d = true;
    }
}
