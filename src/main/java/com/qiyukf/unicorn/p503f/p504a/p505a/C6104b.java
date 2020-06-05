package com.qiyukf.unicorn.p503f.p504a.p505a;

import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5967a;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p497a.C5968b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6079d;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6095k;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6117d;
import org.json.JSONObject;

@C6111b(mo29052a = 205)
/* renamed from: com.qiyukf.unicorn.f.a.a.b */
public class C6104b extends C6144e {
    @C6110a(mo29051a = "template")
    /* renamed from: a */
    private String f19085a;
    @C6110a(mo29051a = "extendInfo")
    /* renamed from: b */
    private String f19086b;
    /* renamed from: c */
    private C6117d f19087c;
    /* renamed from: d */
    private C5967a f19088d;

    /* renamed from: a */
    public final C5967a mo29038a() {
        return this.f19088d;
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        C5967a aVar;
        super.afterParse(jSONObject);
        if (!TextUtils.isEmpty(this.f19086b)) {
            this.f19087c = new C6117d();
            this.f19087c.mo29073a(C5366b.m22027a(this.f19086b));
        }
        JSONObject a = C5366b.m22027a(this.f19085a);
        String e = C5366b.m22039e(a, "id");
        if (e != null) {
            char c = 65535;
            switch (e.hashCode()) {
                case -1349088399:
                    if (e.equals("custom")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3433178:
                    if (e.equals("pair")) {
                        c = 2;
                        break;
                    }
                    break;
                case 503245625:
                    if (e.equals("card_layout")) {
                        c = 1;
                        break;
                    }
                    break;
                case 756171503:
                    if (e.equals("order_list")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                aVar = new C6095k();
            } else if (c == 1) {
                aVar = new C6080e();
            } else if (c != 2) {
                if (c == 3) {
                    this.f19088d = new C5968b();
                }
                return;
            } else {
                aVar = new C6079d();
            }
            this.f19088d = aVar;
            this.f19088d.fromJson(a);
        }
    }
}
