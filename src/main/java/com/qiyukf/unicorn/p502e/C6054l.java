package com.qiyukf.unicorn.p502e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p500c.C6024a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qiyukf.unicorn.e.l */
public final class C6054l implements UserInfoProvider {
    /* renamed from: a */
    private Map<String, C6056n> f18938a = new HashMap();

    /* renamed from: a */
    public static String m24099a(String str) {
        StringBuilder sb = new StringBuilder("QIYU_ROBOT");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m24100b(String str) {
        StringBuilder sb = new StringBuilder("STAFF_GROUP");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo28910a(String str, String str2, String str3) {
        mo28911a(str, str2, str3, "");
    }

    /* renamed from: a */
    public final void mo28911a(String str, String str2, String str3, String str4) {
        Map<String, C6056n> map;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str4);
        C6056n nVar = new C6056n(sb.toString(), str2, str3);
        C6024a.m24015a(nVar);
        if (TextUtils.isEmpty(str4)) {
            map = this.f18938a;
        } else {
            map = this.f18938a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str4);
            str = sb2.toString();
        }
        map.put(str, nVar);
    }

    public final int getDefaultIconResId() {
        return C6029d.m24039c().getApplicationInfo().icon;
    }

    public final Bitmap getTeamIcon(String str) {
        return null;
    }

    public final UserInfo getUserInfo(String str) {
        C6056n nVar = (C6056n) this.f18938a.get(str);
        if (nVar == null) {
            String str2 = "";
            if (TextUtils.equals(str, C5433b.m22192b())) {
                nVar = new C6056n(C5433b.m22192b(), str2, str2);
            } else {
                nVar = C6024a.m24012a(str);
                if (nVar == null) {
                    nVar = new C6056n(str, str2, str2);
                }
            }
            this.f18938a.put(str, nVar);
        }
        return nVar;
    }
}
