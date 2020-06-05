package com.qiyukf.unicorn.p502e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.pop.ShopInfo;
import com.qiyukf.unicorn.p500c.C6024a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qiyukf.unicorn.e.k */
public final class C6053k implements UserInfoProvider {
    /* renamed from: a */
    private Map<String, ShopInfo> f18937a = new HashMap();

    /* renamed from: a */
    public final ShopInfo getUserInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        ShopInfo shopInfo = (ShopInfo) this.f18937a.get(lowerCase);
        if (shopInfo == null) {
            shopInfo = C6024a.m24016b(lowerCase);
            if (shopInfo != null) {
                this.f18937a.put(lowerCase, shopInfo);
            }
        }
        return shopInfo;
    }

    /* renamed from: a */
    public final void mo28909a(C6052j jVar) {
        if (jVar != null && !TextUtils.isEmpty(jVar.getAccount())) {
            this.f18937a.put(jVar.getAccount(), jVar);
            C6024a.m24014a(jVar);
        }
    }

    public final int getDefaultIconResId() {
        return C6029d.m24039c().getApplicationInfo().icon;
    }

    public final Bitmap getTeamIcon(String str) {
        return null;
    }
}
