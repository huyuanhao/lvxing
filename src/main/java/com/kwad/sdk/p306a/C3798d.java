package com.kwad.sdk.p306a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.kwad.sdk.core.p317a.C4057a;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.a.d */
public class C3798d {

    /* renamed from: com.kwad.sdk.a.d$a */
    static class C3799a {
        /* renamed from: a */
        public String f12912a;
        /* renamed from: b */
        public String f12913b;
        /* renamed from: c */
        public boolean f12914c;

        C3799a() {
        }
    }

    /* renamed from: a */
    public static JSONArray m15737a(Context context) {
        Map b = m15741b(context);
        b.putAll(m15742b(context, C4057a.m16834k()));
        return m15738a(b);
    }

    /* renamed from: a */
    private static JSONArray m15738a(Map<String, C3799a> map) {
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            C3799a aVar = (C3799a) map.get(str);
            if (aVar != null && !TextUtils.isEmpty(aVar.f12912a)) {
                JSONObject jSONObject = new JSONObject();
                C3800e.m15752a(jSONObject, AppEntity.KEY_PKG_NAME_STR, aVar.f12912a);
                C3800e.m15749a(jSONObject, "system_app", (int) aVar.f12914c);
                C3800e.m15752a(jSONObject, "appVersion", aVar.f12913b);
                C3800e.m15746a(jSONArray, jSONObject);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static boolean m15739a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    /* renamed from: a */
    public static JSONArray[] m15740a(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        if (!(context == null || list == null || list.isEmpty())) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Iterator it = list.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        C3799a aVar = new C3799a();
                        aVar.f12912a = packageInfo.packageName;
                        if (packageInfo.applicationInfo != null) {
                            if (!m15739a(packageInfo.applicationInfo)) {
                                if (!m15743b(packageInfo.applicationInfo)) {
                                    z = false;
                                }
                            }
                            aVar.f12914c = z;
                        }
                        aVar.f12913b = packageInfo.versionName;
                        hashMap.put(aVar.f12912a, aVar);
                    } else {
                        C3799a aVar2 = new C3799a();
                        aVar2.f12912a = str;
                        hashMap2.put(aVar2.f12912a, aVar2);
                    }
                } catch (Exception unused) {
                    C3799a aVar3 = new C3799a();
                    aVar3.f12912a = str;
                    hashMap2.put(aVar3.f12912a, aVar3);
                }
            }
            jSONArrayArr[0] = m15738a((Map<String, C3799a>) hashMap);
            jSONArrayArr[1] = m15738a((Map<String, C3799a>) hashMap2);
        }
        return jSONArrayArr;
    }

    /* renamed from: b */
    public static Map<String, C3799a> m15741b(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                if (!(resolveInfo == null || resolveInfo.activityInfo == null || TextUtils.isEmpty(resolveInfo.activityInfo.packageName))) {
                    C3799a aVar = new C3799a();
                    aVar.f12912a = resolveInfo.activityInfo.packageName;
                    if (resolveInfo.activityInfo.applicationInfo != null) {
                        if (!m15739a(resolveInfo.activityInfo.applicationInfo)) {
                            if (!m15743b(resolveInfo.activityInfo.applicationInfo)) {
                                aVar.f12914c = false;
                            }
                        }
                        aVar.f12914c = true;
                    }
                    aVar.f12913b = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionName;
                    hashMap.put(aVar.f12912a, aVar);
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* renamed from: b */
    private static Map<String, C3799a> m15742b(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (!(context == null || list == null)) {
            for (String packageInfo : list) {
                try {
                    boolean z = false;
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(packageInfo, 0);
                    if (packageInfo2 != null) {
                        C3799a aVar = new C3799a();
                        aVar.f12912a = packageInfo2.packageName;
                        if (packageInfo2.applicationInfo != null) {
                            if (m15739a(packageInfo2.applicationInfo) || m15743b(packageInfo2.applicationInfo)) {
                                z = true;
                            }
                            aVar.f12914c = z;
                        }
                        aVar.f12913b = packageInfo2.versionName;
                        hashMap.put(aVar.f12912a, aVar);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private static boolean m15743b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }
}
