package com.qiyukf.unicorn.p503f.p504a.p505a.p506a;

import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5967a;
import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import java.util.List;

@C6112c(mo29054a = "card_layout")
/* renamed from: com.qiyukf.unicorn.f.a.a.a.e */
public class C6080e extends C5967a {
    @C6110a(mo29051a = "label")
    /* renamed from: a */
    private String f19001a;
    @C6110a(mo29051a = "list")
    /* renamed from: b */
    private List<C6083c> f19002b;
    @C6110a(mo29051a = "action")
    /* renamed from: c */
    private C6081a f19003c;

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.e$a */
    public static class C6081a implements C6070a {
        @C6110a(mo29051a = "target")
        /* renamed from: a */
        private String f19004a;
        @C6110a(mo29051a = "params")
        /* renamed from: b */
        private String f19005b;
        @C6110a(mo29051a = "type")
        /* renamed from: c */
        private String f19006c;
        @C6110a(mo29051a = "label")
        /* renamed from: d */
        private String f19007d;
        @C6110a(mo29051a = "title")
        /* renamed from: e */
        private String f19008e;

        /* renamed from: a */
        public final String mo28944a() {
            return this.f19004a;
        }

        /* renamed from: b */
        public final String mo28945b() {
            return this.f19005b;
        }

        /* renamed from: c */
        public final String mo28946c() {
            return this.f19006c;
        }

        /* renamed from: d */
        public final String mo28947d() {
            return this.f19007d;
        }

        /* renamed from: e */
        public final String mo28948e() {
            return this.f19008e;
        }
    }

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.e$b */
    public static class C6082b implements C6070a {
        @C6110a(mo29051a = "type")
        /* renamed from: a */
        private String f19009a;
        @C6110a(mo29051a = "value")
        /* renamed from: b */
        private String f19010b;
        @C6110a(mo29051a = "color")
        /* renamed from: c */
        private String f19011c;
        @C6110a(mo29051a = "align")
        /* renamed from: d */
        private String f19012d;
        @C6110a(mo29051a = "flag")
        /* renamed from: e */
        private int f19013e;

        /* renamed from: a */
        public final String mo28949a() {
            return this.f19009a;
        }

        /* renamed from: a */
        public final boolean mo28950a(int i) {
            return (i & this.f19013e) != 0;
        }

        /* renamed from: b */
        public final String mo28951b() {
            return this.f19010b;
        }

        /* renamed from: c */
        public final String mo28952c() {
            return this.f19011c;
        }

        /* renamed from: d */
        public final String mo28953d() {
            return this.f19012d;
        }
    }

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.e$c */
    public static class C6083c implements C6070a {
        @C6110a(mo29051a = "action")
        /* renamed from: a */
        private C6081a f19014a;
        @C6110a(mo29051a = "list")
        /* renamed from: b */
        private List<List<C6082b>> f19015b;

        /* renamed from: a */
        public final C6081a mo28954a() {
            return this.f19014a;
        }

        /* renamed from: b */
        public final List<List<C6082b>> mo28955b() {
            return this.f19015b;
        }
    }

    /* renamed from: c */
    public final String mo28941c() {
        return this.f19001a;
    }

    /* renamed from: d */
    public final List<C6083c> mo28942d() {
        return this.f19002b;
    }

    /* renamed from: e */
    public final C6081a mo28943e() {
        return this.f19003c;
    }
}
