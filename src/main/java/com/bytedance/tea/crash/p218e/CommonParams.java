package com.bytedance.tea.crash.p218e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.tea.crash.ICommonParams;
import com.bytedance.tea.crash.p221g.App;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.tea.crash.e.a */
public class CommonParams {
    /* renamed from: a */
    private Context f9288a;
    /* renamed from: b */
    private ICommonParams f9289b;
    /* renamed from: c */
    private Map<String, Object> f9290c;

    public CommonParams(Context context, ICommonParams dVar) {
        this.f9288a = context;
        this.f9289b = dVar;
    }

    /* renamed from: a */
    public Map<String, Object> mo17019a() {
        String str = "version_name";
        String str2 = "update_version_code";
        String str3 = "version_code";
        Map<String, Object> a = this.f9289b.mo15827a();
        if (a == null) {
            a = new HashMap<>(4);
        }
        if (m12400a(a)) {
            try {
                PackageInfo packageInfo = this.f9288a.getPackageManager().getPackageInfo(this.f9288a.getPackageName(), 128);
                a.put(str, packageInfo.versionName);
                a.put(str3, Integer.valueOf(packageInfo.versionCode));
                if (a.get(str2) == null) {
                    Object obj = null;
                    if (packageInfo.applicationInfo.metaData != null) {
                        obj = packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE");
                    }
                    if (obj == null) {
                        obj = a.get(str3);
                    }
                    a.put(str2, obj);
                }
            } catch (Throwable unused) {
                a.put(str, App.m12505e(this.f9288a));
                a.put(str3, Integer.valueOf(App.m12506f(this.f9288a)));
                if (a.get(str2) == null) {
                    a.put(str2, a.get(str3));
                }
            }
        }
        return a;
    }

    /* renamed from: b */
    public Map<String, Object> mo17020b() {
        if (this.f9290c == null) {
            this.f9290c = this.f9289b.mo15833g();
        }
        return this.f9290c;
    }

    /* renamed from: a */
    public static boolean m12400a(Map<String, Object> map) {
        return map == null || map.isEmpty() || (!map.containsKey("app_version") && !map.containsKey("version_name")) || !map.containsKey("version_code") || !map.containsKey("update_version_code");
    }

    /* renamed from: c */
    public ICommonParams mo17021c() {
        return this.f9289b;
    }

    /* renamed from: d */
    public String mo17022d() {
        return App.m12504d(this.f9288a);
    }

    /* renamed from: e */
    public String mo17023e() {
        return this.f9289b.mo15828b();
    }
}
