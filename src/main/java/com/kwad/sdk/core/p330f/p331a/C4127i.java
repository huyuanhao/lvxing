package com.kwad.sdk.core.p330f.p331a;

import android.content.Context;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.a.i */
public class C4127i {
    /* renamed from: a */
    private Context f13797a;

    public C4127i(Context context) {
        this.f13797a = context;
    }

    /* renamed from: a */
    public String mo23826a() {
        String str = "XiaomiDeviceIDHelper";
        String str2 = "";
        try {
            Class cls = Class.forName("com.android.id.impl.IdProviderImpl");
            Object newInstance = cls.newInstance();
            String str3 = (String) cls.getMethod("getOAID", new Class[]{Context.class}).invoke(newInstance, new Object[]{this.f13797a});
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("getOAID oaid:");
                sb.append(str3);
                C4065b.m16867b(str, sb.toString());
                return str3;
            } catch (Exception e) {
                String str4 = str3;
                e = e;
                str2 = str4;
                C4065b.m16867b(str, "getOAID fail");
                C4065b.m16865a(e);
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            C4065b.m16867b(str, "getOAID fail");
            C4065b.m16865a(e);
            return str2;
        }
    }
}
