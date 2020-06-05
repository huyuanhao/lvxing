package com.qiyukf.unicorn.p502e;

import android.text.TextUtils;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.C6029d;

/* renamed from: com.qiyukf.unicorn.e.n */
public final class C6056n implements UserInfo {
    /* renamed from: a */
    private String f18948a;
    /* renamed from: b */
    private String f18949b;
    /* renamed from: c */
    private String f18950c;

    public C6056n(String str, String str2, String str3) {
        this.f18948a = str;
        this.f18949b = str2;
        this.f18950c = str3;
    }

    public final String getAccount() {
        return this.f18948a;
    }

    public final String getAvatar() {
        if (this.f18948a.equals(C5433b.m22192b())) {
            String str = null;
            if (C6029d.m24045e().uiCustomization != null) {
                str = C6029d.m24045e().uiCustomization.rightAvatar;
            }
            if (TextUtils.isEmpty(str)) {
                str = "selfDefault";
            }
            return str;
        }
        if (TextUtils.isEmpty(this.f18950c)) {
            String str2 = (C6029d.m24045e().uiCustomization == null || TextUtils.isEmpty(C6029d.m24045e().uiCustomization.leftAvatar)) ? "staffDefault" : C6029d.m24045e().uiCustomization.leftAvatar;
            this.f18950c = str2;
        }
        return this.f18950c;
    }

    public final String getName() {
        return this.f18949b;
    }
}
