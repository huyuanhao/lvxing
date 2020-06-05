package com.kwad.sdk.core.p330f.p331a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3807j;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.kwad.sdk.core.f.a.h */
public class C4126h {
    /* renamed from: a */
    private Context f13796a;

    public C4126h(Context context) {
        this.f13796a = context;
    }

    /* renamed from: a */
    public String mo23825a() {
        String str = "VivoDeviceIDHelper";
        String str2 = "";
        Cursor cursor = null;
        try {
            cursor = this.f13796a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str2 = cursor.getString(cursor.getColumnIndex(ArgKey.KEY_VALUE));
                StringBuilder sb = new StringBuilder();
                sb.append("getOAID oaid:");
                sb.append(str2);
                C4065b.m16867b(str, sb.toString());
            }
        } catch (Exception e) {
            C4065b.m16867b(str, "getOAID fail");
            C4065b.m16865a(e);
        } catch (Throwable th) {
            C3807j.m15781a((Cursor) null);
            throw th;
        }
        C3807j.m15781a(cursor);
        return str2;
    }
}
