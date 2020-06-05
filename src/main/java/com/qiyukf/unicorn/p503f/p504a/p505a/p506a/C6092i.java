package com.qiyukf.unicorn.p503f.p504a.p505a.p506a;

import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5967a;
import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import java.util.List;
import org.json.JSONObject;

@C6112c(mo29054a = "static_union")
/* renamed from: com.qiyukf.unicorn.f.a.a.a.i */
public class C6092i extends C5967a {
    @C6110a(mo29051a = "unions")
    /* renamed from: a */
    private List<C6093a> f19043a;

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.i$a */
    public static class C6093a implements C6070a {
        @C6110a(mo29051a = "type")
        /* renamed from: a */
        private String f19044a;
        @C6110a(mo29051a = "detail")
        /* renamed from: b */
        private transient JSONObject f19045b;

        /* renamed from: a */
        public final boolean mo28989a() {
            return TextUtils.equals(this.f19044a, "image");
        }

        /* renamed from: b */
        public final boolean mo28990b() {
            return TextUtils.equals(this.f19044a, "link") && TextUtils.equals(C5366b.m22039e(this.f19045b, "type"), "url");
        }

        /* renamed from: c */
        public final boolean mo28991c() {
            return TextUtils.equals(this.f19044a, "link") && TextUtils.equals(C5366b.m22039e(this.f19045b, "type"), "block");
        }

        /* renamed from: d */
        public final boolean mo28992d() {
            return TextUtils.equals(this.f19044a, "richText");
        }

        /* renamed from: e */
        public final String mo28993e() {
            return C5366b.m22039e(this.f19045b, "label");
        }

        /* renamed from: f */
        public final String mo28994f() {
            return C5366b.m22039e(this.f19045b, "url");
        }

        /* renamed from: g */
        public final String mo28995g() {
            return C5366b.m22039e(this.f19045b, "target");
        }

        /* renamed from: h */
        public final String mo28996h() {
            return C5366b.m22039e(this.f19045b, "params");
        }
    }

    /* renamed from: c */
    public final List<C6093a> mo28988c() {
        return this.f19043a;
    }
}
