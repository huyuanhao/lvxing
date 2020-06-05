package com.p368pw.inner.base.p387d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.p368pw.view.WebActivity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.pw.inner.base.d.c */
public class C5167c {
    /* renamed from: a */
    private static List<String> f16848a = new ArrayList();

    static {
        f16848a.add("com.tencent.mtt");
        f16848a.add("com.UCMobile");
        f16848a.add("com.android.chrome");
        f16848a.add("com.android.browser");
        f16848a.add("sogou.mobile.explorer");
        f16848a.add("com.opera.browser");
        f16848a.add("com.opera.mini.native");
        f16848a.add("com.baidu.browser");
        f16848a.add("org.mozilla.firefox");
        f16848a.add("cn.mozilla.firefox");
        f16848a.add("com.oupeng.mini.android");
        f16848a.add("com.jx.minibrowser");
        f16848a.add("com.qihoo.browser");
        f16848a.add("com.cloud.browser");
        f16848a.add("com.browser2345");
        f16848a.add("com.ijinshan.browser_fast");
    }

    /* renamed from: a */
    private static ActivityInfo m21320a(Context context, List<String> list, List<ResolveInfo> list2) {
        for (String str : list) {
            if (C5191i.m21390a(context, str)) {
                for (ResolveInfo resolveInfo : list2) {
                    if (resolveInfo != null) {
                        if (resolveInfo.activityInfo != null) {
                            ActivityInfo activityInfo = resolveInfo.activityInfo;
                            if (!TextUtils.isEmpty(activityInfo.packageName) && !TextUtils.isEmpty(activityInfo.name) && activityInfo.packageName.equals(str)) {
                                return activityInfo;
                            }
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static List<ResolveInfo> m21321a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setDataAndType(uri, null);
        return context.getPackageManager().queryIntentActivities(intent, 32);
    }

    /* renamed from: a */
    private static void m21322a(Context context, ActivityInfo activityInfo, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setClassName(activityInfo.packageName, activityInfo.name);
            if (context instanceof Activity) {
                intent.addFlags(1073741824);
            } else {
                intent.addFlags(268435456);
                intent.addFlags(32768);
            }
            context.startActivity(intent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public static void m21323a(Context context, String str, String str2) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    Uri parse = Uri.parse(str2);
                    List a = m21321a(context, parse);
                    if (a != null) {
                        if (a.size() != 0) {
                            ActivityInfo a2 = m21320a(context, f16848a, a);
                            if (a2 == null) {
                                a2 = ((ResolveInfo) a.get(0)).activityInfo;
                            }
                            m21322a(context, a2, parse);
                        }
                    }
                    m21324a(context, str, str2, null);
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    /* renamed from: a */
    public static void m21324a(Context context, String str, String str2, String str3) {
        try {
            Intent intent = new Intent(context, WebActivity.class);
            intent.putExtra(WebActivity.LOAD_URL, str2);
            intent.putExtra(WebActivity.BAR_TITLE, str);
            intent.putExtra(WebActivity.WEB_ACT_UUID, str3);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
