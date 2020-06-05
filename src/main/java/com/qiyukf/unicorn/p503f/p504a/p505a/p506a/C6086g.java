package com.qiyukf.unicorn.p503f.p504a.p505a.p506a;

import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5967a;
import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.C6109b;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import java.util.List;
import org.json.JSONObject;

@C6112c(mo29054a = "order_logistic")
/* renamed from: com.qiyukf.unicorn.f.a.a.a.g */
public class C6086g extends C5967a {
    @C6110a(mo29051a = "label")
    /* renamed from: a */
    private String f19025a;
    @C6110a(mo29051a = "title")
    /* renamed from: b */
    private String f19026b;
    @C6110a(mo29051a = "list")
    /* renamed from: c */
    private List<C6088b> f19027c;
    @C6110a(mo29051a = "action")
    /* renamed from: d */
    private C6087a f19028d;
    /* renamed from: e */
    private C6089c f19029e;
    /* renamed from: f */
    private transient boolean f19030f;

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.g$a */
    public static class C6087a implements C6070a {
        @C6110a(mo29051a = "p_name")
        /* renamed from: a */
        private String f19031a;
        @C6110a(mo29051a = "target")
        /* renamed from: b */
        private String f19032b;

        /* renamed from: a */
        public final String mo28977a() {
            return this.f19031a;
        }

        /* renamed from: b */
        public final String mo28978b() {
            return this.f19032b;
        }
    }

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.g$b */
    public static class C6088b implements C6070a {
        @C6110a(mo29051a = "logistic")
        /* renamed from: a */
        private String f19033a;
        @C6110a(mo29051a = "timestamp")
        /* renamed from: b */
        private String f19034b;

        /* renamed from: a */
        public final String mo28979a() {
            return this.f19033a;
        }

        /* renamed from: b */
        public final String mo28980b() {
            return this.f19034b;
        }
    }

    /* renamed from: com.qiyukf.unicorn.f.a.a.a.g$c */
    public class C6089c implements C6070a {
        @C6110a(mo29051a = "label")
        /* renamed from: b */
        private String f19036b;

        public C6089c() {
        }

        /* renamed from: a */
        public final String mo28981a() {
            return this.f19036b;
        }
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        super.afterParse(jSONObject);
        if (!TextUtils.isEmpty(this.f19026b)) {
            this.f19029e = new C6089c();
            C6109b.m24269a((Object) this.f19029e, C5366b.m22027a(this.f19026b));
        }
    }

    /* renamed from: c */
    public final String mo28971c() {
        return this.f19025a;
    }

    /* renamed from: d */
    public final C6089c mo28972d() {
        return this.f19029e;
    }

    /* renamed from: e */
    public final List<C6088b> mo28973e() {
        return this.f19027c;
    }

    /* renamed from: f */
    public final C6087a mo28974f() {
        return this.f19028d;
    }

    /* renamed from: g */
    public final boolean mo28975g() {
        return this.f19030f;
    }

    /* renamed from: h */
    public final void mo28976h() {
        this.f19030f = true;
    }
}
