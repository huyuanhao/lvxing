package com.kwad.sdk.p306a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.sdk.a.a */
public class C3795a {
    /* renamed from: a */
    private static final Map<String, String> f12911a = new HashMap();

    static {
        String str = "com.huawei.appmarket";
        f12911a.put("HUAWEI", str);
        String str2 = "com.oppo.market";
        f12911a.put("OPPO", str2);
        f12911a.put("vivo", "com.bbk.appstore");
        f12911a.put("xiaomi", "com.xiaomi.market");
        f12911a.put("OnePlus", str2);
        f12911a.put("Meizu", "com.meizu.mstore");
        f12911a.put(OEM.SAMSUNG, "com.sec.android.app.samsungapps");
        f12911a.put("SMARTISAN", "com.smartisanos.appstore");
        f12911a.put("Realme", str2);
        f12911a.put("HONOR", str);
    }

    /* renamed from: a */
    private static boolean m15728a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m15729a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (OEM.SAMSUNG.equals(Build.BRAND)) {
            StringBuilder sb = new StringBuilder();
            sb.append("http://apps.samsung.com/appquery/appDetail.as?appId=");
            sb.append(str2);
            str = sb.toString();
        }
        try {
            String str3 = (String) f12911a.get(Build.BRAND);
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addFlags(268435456);
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(parseUri, 0)) {
                if (!m15730a(resolveInfo)) {
                    String str4 = resolveInfo.activityInfo.packageName;
                    if (str4.equals(str3) || m15731a(str4)) {
                        parseUri.setComponent(new ComponentName(str4, resolveInfo.activityInfo.name));
                        context.startActivity(parseUri);
                        return true;
                    }
                }
            }
            return m15728a(context, str);
        } catch (Exception unused) {
            return m15728a(context, str);
        }
    }

    /* renamed from: a */
    private static boolean m15730a(ResolveInfo resolveInfo) {
        return resolveInfo == null || resolveInfo.activityInfo == null || TextUtils.isEmpty(resolveInfo.activityInfo.packageName);
    }

    /* renamed from: a */
    private static boolean m15731a(String str) {
        return "OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str);
    }
}
