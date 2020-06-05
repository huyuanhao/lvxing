package com.tencent.android.tpush.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.p584d.C6916a;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.k */
public class C6913k {
    /* renamed from: a */
    private static volatile C6913k f22986a;
    /* renamed from: b */
    private boolean f22987b;
    /* renamed from: c */
    private boolean f22988c;
    /* renamed from: d */
    private int f22989d;

    private C6913k(Context context) {
        this.f22987b = false;
        this.f22988c = false;
        this.f22989d = -1;
        this.f22987b = C6904d.m29466a();
        this.f22988c = C6916a.m29535a(context);
    }

    /* renamed from: a */
    public static C6913k m29501a(Context context) {
        if (f22986a == null) {
            synchronized (C6913k.class) {
                if (f22986a == null) {
                    f22986a = new C6913k(context);
                }
            }
        }
        return f22986a;
    }

    /* renamed from: a */
    public boolean mo33119a() {
        return this.f22987b;
    }

    /* renamed from: b */
    public boolean mo33120b() {
        if (this.f22989d == -1) {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                String lowerCase = str.trim().toLowerCase();
                if ("meizu".equals(lowerCase) || "oppo".equals(lowerCase) || "xiaomi".equals(lowerCase) || "vivo".equals(lowerCase) || OEM.HUAWEI.equals(lowerCase) || this.f22987b) {
                    this.f22989d = 1;
                } else {
                    this.f22989d = 0;
                }
            }
        }
        if (this.f22989d == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo33121c() {
        return this.f22988c;
    }
}
