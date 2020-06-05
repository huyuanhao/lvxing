package com.tencent.android.tpush.service.p595e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.e */
public class C7052e {
    /* renamed from: a */
    private static volatile C7052e f23432a;
    /* renamed from: b */
    private Context f23433b = null;
    /* renamed from: c */
    private Map<String, String> f23434c = new HashMap(10);
    /* renamed from: d */
    private Map<Long, String> f23435d = new HashMap(10);

    private C7052e(Context context) {
        this.f23433b = context.getApplicationContext();
        this.f23435d.put(Long.valueOf(-1), "");
    }

    /* renamed from: a */
    public static C7052e m30148a(Context context) {
        if (f23432a == null) {
            synchronized (C7052e.class) {
                if (f23432a == null) {
                    f23432a = new C7052e(context);
                }
            }
        }
        return f23432a;
    }

    /* renamed from: a */
    public String mo34151a(long j) {
        String str;
        if (this.f23435d.containsKey(Long.valueOf(j))) {
            return (String) this.f23435d.get(Long.valueOf(j));
        }
        List<String> registerInfos = CacheManager.getRegisterInfos(this.f23433b);
        if (registerInfos != null) {
            for (String str2 : registerInfos) {
                RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str2);
                if (registerInfoByPkgName != null) {
                    this.f23435d.put(Long.valueOf(registerInfoByPkgName.accessId), mo34152a(str2));
                }
            }
        }
        if (this.f23435d.get(Long.valueOf(j)) == null) {
            str = "";
        } else {
            str = (String) this.f23435d.get(Long.valueOf(j));
        }
        return str;
    }

    /* renamed from: a */
    public String mo34152a(String str) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        if (this.f23434c.containsKey(str)) {
            return (String) this.f23434c.get(str);
        }
        List<PackageInfo> installedPackages = CustomDeviceInfos.getInstalledPackages(this.f23433b);
        if (installedPackages != null) {
            for (PackageInfo packageInfo : installedPackages) {
                if (str.equals(packageInfo.packageName)) {
                    this.f23434c.put(str, packageInfo.versionName);
                    return packageInfo.versionName;
                }
            }
        }
        return str2;
    }
}
