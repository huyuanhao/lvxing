package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.utils.AppSigning;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.s */
public class SecSdkHelper {
    /* renamed from: a */
    private static SecSdkHelper f7909a;
    /* renamed from: b */
    private static SecSdkHelperInner f7910b;
    /* renamed from: c */
    private volatile boolean f7911c = false;
    /* renamed from: d */
    private volatile boolean f7912d = false;
    /* renamed from: e */
    private String f7913e = null;

    private SecSdkHelper(String str) {
        this.f7913e = str;
        if (m10147b() == null) {
            f7910b = SecSdkHelperInner.m10154b(str);
            return;
        }
        if (!TextUtils.isEmpty(this.f7913e)) {
            this.f7912d = true;
            m10147b().NM_setParams(this.f7913e);
        }
    }

    /* renamed from: a */
    public void mo15923a(String str) {
        SecSdkHelperInner tVar = f7910b;
        if (tVar != null) {
            tVar.mo15927a(str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f7913e)) {
                this.f7913e = str;
            }
            if (!this.f7912d && m10147b() != null) {
                this.f7912d = true;
                m10147b().NM_setParams(str);
            }
        }
    }

    /* renamed from: b */
    public static SecSdkHelper m10148b(String str) {
        if (f7909a == null) {
            synchronized (SecSdkHelper.class) {
                if (f7909a == null) {
                    f7909a = new SecSdkHelper(str);
                }
            }
        }
        return f7909a;
    }

    /* renamed from: c */
    public void mo15924c(String str) {
        SecSdkHelperInner tVar = f7910b;
        if (tVar != null) {
            tVar.mo15928c(str);
        }
        if (!this.f7911c && m10147b() != null) {
            m10147b().NM_reportNow(str);
            this.f7911c = true;
        }
    }

    /* renamed from: a */
    public String mo15922a() {
        String str = "";
        String str2 = null;
        try {
            if (m10147b() != null) {
                str2 = m10147b().NM_pullSg();
            } else if (f7910b != null) {
                str2 = f7910b.mo15926a();
            }
            if (m10149e(str2)) {
                return str2.toUpperCase();
            }
            String a = AppSigning.m12130a(InternalContainer.m10059a());
            if (m10149e(a)) {
                str = a.toUpperCase();
            }
            return str;
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    private boolean m10149e(String str) {
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
    public String mo15925d(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a = DigestUtils.m12169a(str);
        if (TextUtils.isEmpty(a)) {
            return str2;
        }
        if (m10147b() != null) {
            return m10147b().NM_pullVer(a);
        }
        SecSdkHelperInner tVar = f7910b;
        return tVar != null ? tVar.mo15929d(str) : str2;
    }

    /* renamed from: b */
    private TTSecAbs m10147b() {
        return GlobalInfo.m9616c().mo15684n();
    }
}
