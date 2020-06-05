package com.kwad.sdk.core.p330f.p331a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.p306a.C3807j;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.kwad.sdk.core.f.a.d */
public class C4120d {
    /* renamed from: a */
    private Context f13786a;

    public C4120d(Context context) {
        this.f13786a = context;
    }

    /* renamed from: a */
    private String m17091a(Cursor cursor) {
        String str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(ArgKey.KEY_VALUE);
            if (columnIndex > 0) {
                str = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    /* renamed from: a */
    public String mo23817a() {
        String str = "MeizuDeviceIDHelper";
        String str2 = "";
        Cursor cursor = null;
        try {
            cursor = this.f13786a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            str2 = m17091a(cursor);
            StringBuilder sb = new StringBuilder();
            sb.append("getOAID oaid:");
            sb.append(str2);
            C4065b.m16867b(str, sb.toString());
            try {
                C3807j.m15781a(cursor);
            } catch (Exception e) {
                C4065b.m16867b(str, "getOAID service not found;");
                C4065b.m16865a(e);
            }
        } catch (Throwable th) {
            C3807j.m15781a(cursor);
            throw th;
        }
        return str2;
    }
}
