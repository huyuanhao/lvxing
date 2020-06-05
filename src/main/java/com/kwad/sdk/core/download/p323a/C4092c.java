package com.kwad.sdk.core.download.p323a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import java.util.List;

/* renamed from: com.kwad.sdk.core.download.a.c */
public class C4092c {
    /* renamed from: a */
    public static int m16996a(Context context, AdTemplate adTemplate) {
        if (adTemplate == null || context == null) {
            return 0;
        }
        int a = m16997a(context, C4324c.m17668e(adTemplate).adConversionInfo.deeplinkUrl);
        if (a == 1) {
            C4143b.m17140g(adTemplate);
        } else if (a == -1) {
            C4143b.m17142h(adTemplate);
        }
        return a;
    }

    /* renamed from: a */
    public static int m16997a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            parseUri.setAction("android.intent.action.VIEW");
            parseUri.setFlags(268435456);
            List queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return 0;
            }
            context.startActivity(parseUri);
            return 1;
        } catch (Exception e) {
            C4065b.m16865a(e);
            return -1;
        }
    }
}
