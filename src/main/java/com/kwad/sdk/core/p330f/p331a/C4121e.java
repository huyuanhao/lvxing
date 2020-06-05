package com.kwad.sdk.core.p330f.p331a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.a.e */
public class C4121e {
    /* renamed from: a */
    private Context f13787a;

    public C4121e(Context context) {
        this.f13787a = context;
    }

    /* renamed from: a */
    public String mo23818a() {
        Bundle bundle;
        String str = "NubiaDeviceIDHelper";
        String str2 = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            String str3 = "getOAID";
            if (VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.f13787a.getContentResolver().acquireContentProviderClient(parse);
                bundle = acquireContentProviderClient.call(str3, null, null);
                if (VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                bundle = this.f13787a.getContentResolver().call(parse, str3, null, null);
            }
            if (bundle != null) {
                if (bundle.getInt("code", -1) == 0) {
                    str2 = bundle.getString("id");
                }
                String string = bundle.getString("message");
                StringBuilder sb = new StringBuilder();
                sb.append("getOAID oaid:");
                sb.append(str2);
                sb.append("faledMsg:");
                sb.append(string);
                C4065b.m16867b(str, sb.toString());
            }
        } catch (Exception e) {
            C4065b.m16867b(str, "getOAID fail");
            C4065b.m16865a(e);
        }
        return str2;
    }
}
