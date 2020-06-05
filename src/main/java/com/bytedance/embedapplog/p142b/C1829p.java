package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.C1856h;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.p */
class C1829p extends C1816c {
    /* renamed from: e */
    private final Context f5127e;
    /* renamed from: f */
    private final C1821h f5128f;

    C1829p(Context context, C1821h hVar) {
        super(false, false);
        this.f5127e = context;
        this.f5128f = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        String packageName = this.f5127e.getPackageName();
        String str = "package";
        if (TextUtils.isEmpty(this.f5128f.mo13385T())) {
            jSONObject.put(str, packageName);
        } else {
            if (C1856h.f5226b) {
                C1856h.m6581a("has zijie pkg", null);
            }
            jSONObject.put(str, this.f5128f.mo13385T());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            PackageInfo packageInfo = this.f5127e.getPackageManager().getPackageInfo(packageName, 0);
            int i = packageInfo.versionCode;
            String str2 = "app_version";
            if (!TextUtils.isEmpty(this.f5128f.mo13376K())) {
                jSONObject.put(str2, this.f5128f.mo13376K());
            } else {
                jSONObject.put(str2, packageInfo.versionName);
            }
            String str3 = "app_version_minor";
            if (!TextUtils.isEmpty(this.f5128f.mo13381P())) {
                jSONObject.put(str3, this.f5128f.mo13381P());
            } else {
                jSONObject.put(str3, "");
            }
            String str4 = "version_code";
            if (this.f5128f.mo13373H() != 0) {
                jSONObject.put(str4, this.f5128f.mo13373H());
            } else {
                jSONObject.put(str4, i);
            }
            String str5 = "update_version_code";
            if (this.f5128f.mo13374I() != 0) {
                jSONObject.put(str5, this.f5128f.mo13374I());
            } else {
                jSONObject.put(str5, i);
            }
            String str6 = "manifest_version_code";
            if (this.f5128f.mo13375J() != 0) {
                jSONObject.put(str6, this.f5128f.mo13375J());
            } else {
                jSONObject.put(str6, i);
            }
            if (!TextUtils.isEmpty(this.f5128f.mo13372G())) {
                jSONObject.put("app_name", this.f5128f.mo13372G());
            }
            if (!TextUtils.isEmpty(this.f5128f.mo13377L())) {
                jSONObject.put("tweaked_channel", this.f5128f.mo13377L());
            }
            if (packageInfo.applicationInfo != null) {
                int i2 = packageInfo.applicationInfo.labelRes;
                if (i2 > 0) {
                    jSONObject.put("display_name", this.f5127e.getString(i2));
                }
            }
            return true;
        } catch (NameNotFoundException e) {
            C1856h.m6582a(e);
            return false;
        }
    }
}
