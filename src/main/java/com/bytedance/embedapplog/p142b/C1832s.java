package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.bytedance.embedapplog.util.C1850b;
import com.bytedance.embedapplog.util.C1856h;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.s */
class C1832s extends C1816c {
    /* renamed from: e */
    private final Context f5130e;

    C1832s(Context context) {
        super(true, false);
        this.f5130e = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        PackageInfo packageInfo;
        String str = null;
        try {
            packageInfo = this.f5130e.getPackageManager().getPackageInfo(this.f5130e.getPackageName(), 64);
        } catch (Exception e) {
            C1856h.m6582a(e);
            packageInfo = null;
        }
        if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
            Signature signature = packageInfo.signatures[0];
            if (signature != null) {
                str = C1850b.m6561b(signature.toByteArray());
            }
        }
        if (str != null) {
            jSONObject.put("sig_hash", str);
        }
        return true;
    }
}
