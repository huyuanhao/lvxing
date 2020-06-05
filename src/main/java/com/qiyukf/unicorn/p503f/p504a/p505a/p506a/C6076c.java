package com.qiyukf.unicorn.p503f.p504a.p505a.p506a;

import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5967a;
import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6082b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6083c;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import java.util.List;

@C6112c(mo29054a = "detail_view")
/* renamed from: com.qiyukf.unicorn.f.a.a.a.c */
public class C6076c extends C5967a {
    @C6110a(mo29051a = "thumbnail")
    /* renamed from: a */
    private C6083c f18993a;
    @C6110a(mo29051a = "detail")
    /* renamed from: b */
    private C6077a f18994b;

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.c$a */
    public static class C6077a implements C6070a {
        @C6110a(mo29051a = "label")
        /* renamed from: a */
        private String f18995a;
        @C6110a(mo29051a = "list")
        /* renamed from: b */
        private List<List<C6078a>> f18996b;

        /* renamed from: com.qiyukf.unicorn.f.a.a.a.c$a$a */
        public static class C6078a implements C6070a {
            @C6110a(mo29051a = "left")
            /* renamed from: a */
            private C6082b f18997a;
            @C6110a(mo29051a = "right")
            /* renamed from: b */
            private C6082b f18998b;

            /* renamed from: a */
            public final C6082b[] mo28938a() {
                return new C6082b[]{this.f18997a, this.f18998b};
            }
        }

        /* renamed from: a */
        public final String mo28936a() {
            return this.f18995a;
        }

        /* renamed from: b */
        public final List<List<C6078a>> mo28937b() {
            return this.f18996b;
        }
    }

    /* renamed from: c */
    public final C6083c mo28934c() {
        return this.f18993a;
    }

    /* renamed from: d */
    public final C6077a mo28935d() {
        return this.f18994b;
    }
}
