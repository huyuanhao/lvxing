package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.core.p318b.C4062b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.protocol.model.AdScene;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.response.model.b */
public class C4327b implements C4321b {
    /* renamed from: a */
    public String f14215a;
    /* renamed from: b */
    public long f14216b;
    /* renamed from: c */
    public int f14217c;
    /* renamed from: d */
    public List<AdTemplate> f14218d = new ArrayList();
    /* renamed from: e */
    public C4329d f14219e;
    /* renamed from: f */
    public final AdScene f14220f;

    public C4327b(AdScene adScene) {
        this.f14220f = adScene;
    }

    /* renamed from: a */
    public void mo24465a(JSONObject jSONObject) {
        String str = "entryInfo";
        if (jSONObject != null) {
            this.f14216b = jSONObject.optLong("llsid");
            this.f14217c = jSONObject.optInt(ArgKey.KEY_RESULT);
            this.f14215a = jSONObject.optString("errorMsg");
            try {
                JSONArray jSONArray = new JSONArray(C4062b.m16853b(jSONObject.optString("impAdInfo")));
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        AdTemplate adTemplate = new AdTemplate();
                        adTemplate.parseJson(optJSONObject);
                        adTemplate.llsid = this.f14216b;
                        adTemplate.mAdScene = this.f14220f;
                        this.f14218d.add(adTemplate);
                    }
                }
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(str);
                    if (optJSONObject2 == null) {
                        String optString = jSONObject.optString(str);
                        if (!TextUtils.isEmpty(optString)) {
                            String replaceAll = C4062b.m16853b(optString).replaceAll("\\\\", "");
                            optJSONObject2 = new JSONObject(replaceAll.substring(1, replaceAll.length() - 1));
                        }
                    }
                    if (optJSONObject2 != null) {
                        this.f14219e = new C4329d();
                        this.f14219e.mo24473a(optJSONObject2);
                        this.f14219e.f14229f = this.f14218d;
                    }
                } catch (Exception e) {
                    C4065b.m16865a(e);
                }
            } catch (Exception e2) {
                C4065b.m16865a(e2);
            }
        }
    }

    /* renamed from: a */
    public boolean mo24466a() {
        String str;
        String str2 = "AdResultData";
        if (this.f14218d.isEmpty()) {
            str = "adTemplateList is empty";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("adTemplateList size = ");
            sb.append(this.f14218d.size());
            C4065b.m16863a(str2, sb.toString());
            List<AdInfo> list = ((AdTemplate) this.f14218d.get(0)).adInfoList;
            if (list.isEmpty()) {
                str = "adInfoList is empty";
            } else if (((AdInfo) list.get(0)) != null) {
                return false;
            } else {
                str = "adInfo is null";
            }
        }
        C4065b.m16869d(str2, str);
        return true;
    }

    /* renamed from: b */
    public boolean mo24467b() {
        if (!this.f14218d.isEmpty()) {
            return false;
        }
        C4065b.m16869d("AdResultData", "adTemplateList is empty");
        return true;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15753a(jSONObject, "impAdInfo", this.f14218d);
        return jSONObject;
    }
}
