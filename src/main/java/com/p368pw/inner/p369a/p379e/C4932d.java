package com.p368pw.inner.p369a.p379e;

import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.p369a.p370a.p373c.C4839a;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.e.d */
public class C4932d {
    /* renamed from: a */
    private String f15949a;
    /* renamed from: b */
    private String f15950b;
    /* renamed from: c */
    private String f15951c;
    /* renamed from: d */
    private String f15952d;
    /* renamed from: e */
    private String f15953e;
    /* renamed from: f */
    private String f15954f;
    /* renamed from: g */
    private String f15955g;
    /* renamed from: h */
    private String f15956h;
    /* renamed from: i */
    private String f15957i;
    /* renamed from: j */
    private long f15958j;
    /* renamed from: k */
    private int f15959k = -1;

    /* renamed from: a */
    public static C4932d m20457a(AdMetaInfo adMetaInfo) {
        C4932d dVar = new C4932d();
        dVar.mo26131a(adMetaInfo.cta);
        dVar.mo26135c(adMetaInfo.title);
        dVar.mo26137d(adMetaInfo.desc);
        dVar.mo26139e(adMetaInfo.icon);
        dVar.mo26133b(C4839a.m19867b(adMetaInfo));
        dVar.mo26140f(adMetaInfo.getDownLoadUrl());
        dVar.mo26141g(C4839a.m19870d(adMetaInfo));
        dVar.mo26129a(System.identityHashCode(adMetaInfo));
        dVar.mo26142h(C4839a.m19865a(adMetaInfo));
        dVar.mo26130a(System.currentTimeMillis());
        dVar.mo26143i(UUID.randomUUID().toString());
        return dVar;
    }

    /* renamed from: a */
    public String mo26128a() {
        return this.f15954f;
    }

    /* renamed from: a */
    public void mo26129a(int i) {
        this.f15959k = i;
    }

    /* renamed from: a */
    public void mo26130a(long j) {
        this.f15958j = j;
    }

    /* renamed from: a */
    public void mo26131a(String str) {
        this.f15949a = str;
    }

    /* renamed from: b */
    public String mo26132b() {
        return C5207q.m21478b((CharSequence) this.f15955g) ? this.f15955g : C4839a.m19864a(this.f15959k);
    }

    /* renamed from: b */
    public void mo26133b(String str) {
        this.f15950b = str;
    }

    /* renamed from: c */
    public String mo26134c() {
        return this.f15956h;
    }

    /* renamed from: c */
    public void mo26135c(String str) {
        this.f15951c = str;
    }

    /* renamed from: d */
    public String mo26136d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15957i);
        sb.append(mo26134c());
        return sb.toString();
    }

    /* renamed from: d */
    public void mo26137d(String str) {
        this.f15952d = str;
    }

    /* renamed from: e */
    public JSONObject mo26138e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("btnText", this.f15949a);
            jSONObject.put(C7887a.f26830Fh, this.f15950b);
            jSONObject.put("mainTitle", this.f15951c);
            jSONObject.put("subTitle", this.f15952d);
            jSONObject.put("iconUrl", this.f15953e);
            jSONObject.put("downloadUrl", this.f15954f);
            jSONObject.put(AppEntity.KEY_PKG_NAME_STR, this.f15955g);
            jSONObject.put("uniqueKey", this.f15956h);
            jSONObject.put("cacheTime", this.f15958j);
            jSONObject.put("uuid", this.f15957i);
            return jSONObject;
        } catch (JSONException e) {
            C5205o.m21464a((Throwable) e);
            return null;
        }
    }

    /* renamed from: e */
    public void mo26139e(String str) {
        this.f15953e = str;
    }

    /* renamed from: f */
    public void mo26140f(String str) {
        this.f15954f = str;
    }

    /* renamed from: g */
    public void mo26141g(String str) {
        this.f15955g = str;
    }

    /* renamed from: h */
    public void mo26142h(String str) {
        this.f15956h = str;
    }

    /* renamed from: i */
    public void mo26143i(String str) {
        this.f15957i = str;
    }
}
