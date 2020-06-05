package com.qiyukf.unicorn.p503f.p504a.p505a.p506a;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5967a;
import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import java.util.List;
import org.json.JSONObject;

@C6112c(mo29054a = "order_list")
/* renamed from: com.qiyukf.unicorn.f.a.a.a.k */
public class C6095k extends C5967a {
    @C6110a(mo29051a = "label")
    /* renamed from: a */
    private String f19053a;
    @C6110a(mo29051a = "list")
    /* renamed from: b */
    private List<C6097b> f19054b;
    @C6110a(mo29051a = "action")
    /* renamed from: c */
    private C6096a f19055c;

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.k$a */
    public static class C6096a implements C6070a {
        @C6110a(mo29051a = "label")
        /* renamed from: a */
        private String f19056a;
        @C6110a(mo29051a = "target")
        /* renamed from: b */
        private String f19057b;
        @C6110a(mo29051a = "params")
        /* renamed from: c */
        private String f19058c;

        /* renamed from: a */
        public final String mo29007a() {
            return this.f19056a;
        }

        /* renamed from: b */
        public final String mo29008b() {
            return this.f19057b;
        }

        /* renamed from: c */
        public final String mo29009c() {
            return this.f19058c;
        }
    }

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.k$b */
    public static class C6097b implements C6070a {
        @C6110a(mo29051a = "s_name")
        /* renamed from: a */
        private String f19059a;
        @C6110a(mo29051a = "s_status")
        /* renamed from: b */
        private String f19060b;
        @C6110a(mo29051a = "goods")
        /* renamed from: c */
        private List<C6098a> f19061c;

        /* renamed from: com.qiyukf.unicorn.f.a.a.a.k$b$a */
        public static class C6098a implements C6070a {
            @C6110a(mo29051a = "target")
            /* renamed from: a */
            private String f19062a;
            @C6110a(mo29051a = "params")
            /* renamed from: b */
            private String f19063b;
            @C6110a(mo29051a = "p_status")
            /* renamed from: c */
            private String f19064c;
            @C6110a(mo29051a = "p_img")
            /* renamed from: d */
            private String f19065d;
            @C6110a(mo29051a = "p_name")
            /* renamed from: e */
            private String f19066e;
            @C6110a(mo29051a = "p_price")
            /* renamed from: f */
            private String f19067f;
            @C6110a(mo29051a = "p_count")
            /* renamed from: g */
            private String f19068g;
            @C6110a(mo29051a = "p_stock")
            /* renamed from: h */
            private String f19069h;
            @C6110a(mo29051a = "p_url")
            /* renamed from: i */
            private String f19070i;
            /* renamed from: j */
            private transient JSONObject f19071j;

            /* renamed from: a */
            public final JSONObject mo29013a() {
                if (this.f19071j == null) {
                    this.f19071j = new JSONObject();
                    C5366b.m22032a(this.f19071j, "target", this.f19062a);
                    C5366b.m22032a(this.f19071j, "params", this.f19063b);
                    C5366b.m22032a(this.f19071j, "p_status", this.f19064c);
                    C5366b.m22032a(this.f19071j, "p_img", this.f19065d);
                    C5366b.m22032a(this.f19071j, "p_name", this.f19066e);
                    C5366b.m22032a(this.f19071j, "p_price", this.f19067f);
                    C5366b.m22032a(this.f19071j, "p_count", this.f19068g);
                    C5366b.m22032a(this.f19071j, "p_stock", this.f19069h);
                    C5366b.m22032a(this.f19071j, "p_url", this.f19070i);
                }
                return this.f19071j;
            }

            /* renamed from: b */
            public final String mo29014b() {
                return this.f19062a;
            }

            /* renamed from: c */
            public final String mo29015c() {
                return this.f19063b;
            }

            /* renamed from: d */
            public final String mo29016d() {
                return this.f19064c;
            }

            /* renamed from: e */
            public final String mo29017e() {
                return this.f19065d;
            }

            /* renamed from: f */
            public final String mo29018f() {
                return this.f19066e;
            }

            /* renamed from: g */
            public final String mo29019g() {
                return this.f19067f;
            }

            /* renamed from: h */
            public final String mo29020h() {
                return this.f19068g;
            }

            /* renamed from: i */
            public final String mo29021i() {
                return this.f19069h;
            }

            /* renamed from: j */
            public final String mo29022j() {
                return this.f19070i;
            }
        }

        /* renamed from: a */
        public final String mo29010a() {
            return this.f19059a;
        }

        /* renamed from: b */
        public final String mo29011b() {
            return this.f19060b;
        }

        /* renamed from: c */
        public final List<C6098a> mo29012c() {
            return this.f19061c;
        }
    }

    /* renamed from: c */
    public final String mo29004c() {
        return this.f19053a;
    }

    /* renamed from: d */
    public final List<C6097b> mo29005d() {
        return this.f19054b;
    }

    /* renamed from: e */
    public final C6096a mo29006e() {
        return this.f19055c;
    }
}
