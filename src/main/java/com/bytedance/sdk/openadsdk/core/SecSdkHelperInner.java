package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.AppSigning;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.pgl.sys.ces.out.ISdkLite;
import com.pgl.sys.ces.out.StcSDKLiteFactory;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashMap;

/* renamed from: com.bytedance.sdk.openadsdk.core.t */
public class SecSdkHelperInner {
    /* renamed from: a */
    private static SecSdkHelperInner f7914a;
    /* renamed from: b */
    private ISdkLite f7915b = StcSDKLiteFactory.getSDK(InternalContainer.m10059a(), "df979cdb-05a7-448c-bece-92d5005a1247", 0);
    /* renamed from: c */
    private volatile boolean f7916c = false;
    /* renamed from: d */
    private String f7917d = null;

    private SecSdkHelperInner(String str) {
        this.f7917d = str;
        if (!TextUtils.isEmpty(this.f7917d)) {
            this.f7915b.setParams(str, null);
        }
        if (GlobalInfo.m9616c().mo15675e() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ArgKey.KEY_APP_ID, GlobalInfo.m9616c().mo15675e());
            this.f7915b.setCustomInfo(hashMap);
        }
    }

    /* renamed from: a */
    public void mo15927a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f7917d)) {
                this.f7917d = str;
                this.f7915b.setParams(this.f7917d, null);
            }
            if (GlobalInfo.m9616c().mo15675e() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(ArgKey.KEY_APP_ID, GlobalInfo.m9616c().mo15675e());
                this.f7915b.setCustomInfo(hashMap);
            }
        }
    }

    /* renamed from: b */
    public static SecSdkHelperInner m10154b(String str) {
        if (f7914a == null) {
            synchronized (SecSdkHelperInner.class) {
                if (f7914a == null) {
                    f7914a = new SecSdkHelperInner(str);
                }
            }
        }
        return f7914a;
    }

    /* renamed from: c */
    public void mo15928c(String str) {
        if (!this.f7916c) {
            this.f7915b.reportNow(str);
            this.f7916c = true;
        }
    }

    /* renamed from: a */
    public String mo15926a() {
        String str = "";
        try {
            String pullSg = this.f7915b.pullSg();
            if (m10155e(pullSg)) {
                return pullSg.toUpperCase();
            }
            String a = AppSigning.m12130a(InternalContainer.m10059a());
            if (m10155e(a)) {
                str = a.toUpperCase();
            }
            return str;
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    private boolean m10155e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split(":");
        if (split == null || split.length < 20) {
            return false;
        }
        for (String equals : split) {
            if (!"00".equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public String mo15929d(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a = DigestUtils.m12169a(str);
        if (TextUtils.isEmpty(a)) {
            return str2;
        }
        return this.f7915b.pullVer(a);
    }
}
