package com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.api.msg.ProductReslectOnclickListener;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import org.json.JSONObject;

@C6112c(mo29054a = "qiyu_template_goods")
/* renamed from: com.qiyukf.unicorn.a.a.a.a.b.b */
public class C5971b extends C5970a {
    @C6110a(mo29051a = "p_status")
    /* renamed from: a */
    private String f18795a;
    @C6110a(mo29051a = "p_img")
    /* renamed from: b */
    private String f18796b;
    @C6110a(mo29051a = "p_name")
    /* renamed from: c */
    private String f18797c;
    @C6110a(mo29051a = "p_price")
    /* renamed from: d */
    private String f18798d;
    @C6110a(mo29051a = "p_count")
    /* renamed from: e */
    private String f18799e;
    @C6110a(mo29051a = "p_stock")
    /* renamed from: f */
    private String f18800f;
    /* renamed from: g */
    private boolean f18801g;
    /* renamed from: h */
    private String f18802h;
    /* renamed from: i */
    private String f18803i;
    /* renamed from: j */
    private ProductReslectOnclickListener f18804j;
    /* renamed from: k */
    private transient JSONObject f18805k;

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        this.f18805k = jSONObject;
    }

    /* renamed from: c */
    public final JSONObject mo28524c() {
        JSONObject jSONObject = this.f18805k;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C5366b.m22032a(jSONObject, "id", mo28537b());
        return jSONObject;
    }

    /* renamed from: d */
    public final String mo28525d() {
        return this.f18795a;
    }

    /* renamed from: e */
    public final String mo28526e() {
        return this.f18796b;
    }

    /* renamed from: f */
    public final String mo28527f() {
        return this.f18797c;
    }

    /* renamed from: g */
    public final String mo28528g() {
        return this.f18798d;
    }

    /* renamed from: h */
    public final String mo28529h() {
        return this.f18799e;
    }

    /* renamed from: i */
    public final String mo28530i() {
        return this.f18800f;
    }

    /* renamed from: j */
    public final boolean mo28531j() {
        return this.f18801g;
    }

    /* renamed from: k */
    public final String mo28532k() {
        return this.f18802h;
    }

    /* renamed from: l */
    public final String mo28533l() {
        return this.f18803i;
    }

    /* renamed from: m */
    public final ProductReslectOnclickListener mo28534m() {
        return this.f18804j;
    }
}
