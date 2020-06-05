package com.qiyukf.unicorn.p502e;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.api.pop.ShopInfo;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.e.j */
public final class C6052j implements ShopInfo {
    /* renamed from: a */
    private String f18934a;
    /* renamed from: b */
    private String f18935b;
    /* renamed from: c */
    private String f18936c;

    public C6052j() {
    }

    public C6052j(String str, String str2, String str3) {
        this.f18934a = str;
        this.f18935b = str2;
        this.f18936c = str3;
    }

    /* renamed from: a */
    public final void mo28907a(String str) {
        JSONObject a = C5366b.m22027a(str);
        if (a != null) {
            this.f18934a = C5366b.m22039e(a, "id");
            this.f18935b = C5366b.m22039e(a, ArgKey.KEY_NAME);
            this.f18936c = C5366b.m22039e(a, "logo");
        }
    }

    public final String getAccount() {
        return this.f18934a;
    }

    public final String getAvatar() {
        return this.f18936c;
    }

    public final String getName() {
        return this.f18935b;
    }
}
