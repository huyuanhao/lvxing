package com.p530ss.android.downloadlib.p549e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.p530ss.android.downloadlib.activity.TTDelegateActivity;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.OpenAppResult;
import com.p530ss.android.socialbase.downloader.p569m.C6792i;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;

/* renamed from: com.ss.android.downloadlib.e.d */
public class OpenAppUtils {
    /* renamed from: a */
    public static OpenAppResult m26489a(Context context, Uri uri) {
        if (!(context == null || uri == null)) {
            if (OEM.MARKET.equals(uri.getScheme())) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    if (!C6587g.m26523a(context, intent)) {
                        return new OpenAppResult(6, 1);
                    }
                    String h = C6792i.m28938h();
                    if (C6587g.m26535c(context, h) && !C6792i.m28935e()) {
                        intent.setPackage(h);
                    }
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    return new OpenAppResult(5);
                } catch (Exception unused) {
                    return new OpenAppResult(6);
                }
            }
        }
        return new OpenAppResult(6);
    }

    /* renamed from: a */
    public static OpenAppResult m26490a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new OpenAppResult(6);
        }
        if (C6792i.m28935e() && C6587g.m26535c(context, "com.sec.android.app.samsungapps")) {
            return m26495d(context, str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(str);
        return m26489a(context, Uri.parse(sb.toString()));
    }

    /* renamed from: d */
    private static OpenAppResult m26495d(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("http://www.samsungapps.com/appquery/appDetail.as?appId=");
            sb.append(str);
            Uri parse = Uri.parse(sb.toString());
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            context.startActivity(intent);
            return new OpenAppResult(5);
        } catch (Exception unused) {
            return new OpenAppResult(6);
        }
    }

    /* renamed from: a */
    public static OpenAppResult m26492a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return m26493b(C6565j.m26357a(), str2);
        }
        OpenAppResult a = m26491a(str);
        if (a.mo31280a() == 2) {
            a = m26493b(C6565j.m26357a(), str2);
        }
        return a;
    }

    /* renamed from: b */
    public static OpenAppResult m26493b(Context context, String str) {
        Intent e = C6587g.m26539e(context, str);
        if (e == null) {
            return new OpenAppResult(4);
        }
        e.putExtra("START_ONLY_FOR_ANDROID", true);
        try {
            context.startActivity(e);
            return new OpenAppResult(3);
        } catch (Exception unused) {
            return new OpenAppResult(4);
        }
    }

    /* renamed from: a */
    public static OpenAppResult m26491a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new OpenAppResult(2, 3);
        }
        Context a = C6565j.m26357a();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        if (!C6587g.m26533b(a, intent)) {
            return new OpenAppResult(2);
        }
        String str2 = "open_url_mode";
        if (C6565j.m26375i().optInt(str2) == 0 && C6565j.m26377k() != null && C6565j.m26377k().mo16475a() && VERSION.SDK_INT < 29) {
            TTDelegateActivity.m26393a(str);
        } else if (C6565j.m26375i().optInt(str2) != 1 || VERSION.SDK_INT < 26 || VERSION.SDK_INT >= 29) {
            intent.putExtra("open_url", str);
            intent.addFlags(268435456);
            try {
                C6565j.m26357a().startActivity(intent);
            } catch (Exception unused) {
                return new OpenAppResult(2);
            }
        } else {
            TTDelegateActivity.m26393a(str);
        }
        return new OpenAppResult(1);
    }

    /* renamed from: c */
    public static boolean m26494c(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
