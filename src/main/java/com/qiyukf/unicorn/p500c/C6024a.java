package com.qiyukf.unicorn.p500c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.p502e.C6052j;
import com.qiyukf.unicorn.p502e.C6056n;
import java.util.Locale;

/* renamed from: com.qiyukf.unicorn.c.a */
public final class C6024a {
    /* renamed from: a */
    private static C6025b f18843a;

    /* renamed from: a */
    private static SQLiteDatabase m24011a() {
        C6025b bVar = f18843a;
        String str = "UnicornDB";
        if (bVar == null) {
            C5264a.m21622c(str, "database is not initialized");
            return null;
        }
        try {
            return bVar.getWritableDatabase();
        } catch (SQLiteException e) {
            StringBuilder sb = new StringBuilder("getWritableDatabase error");
            sb.append(e);
            C5264a.m21617a(str, sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static C6056n m24012a(String str) {
        SQLiteDatabase a = m24011a();
        C6056n nVar = null;
        if (a == null) {
            return null;
        }
        Cursor rawQuery = a.rawQuery(String.format(Locale.getDefault(), "SELECT %1$s FROM staffInfo WHERE staffNimId='%2$s'", new Object[]{"staffNimId,staffName,staffAvatar", str}), null);
        if (rawQuery != null && rawQuery.moveToNext()) {
            try {
                nVar = new C6056n(str, rawQuery.getString(1), rawQuery.getString(2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (rawQuery != null && !rawQuery.isClosed()) {
            rawQuery.close();
        }
        return nVar;
    }

    /* renamed from: a */
    public static void m24013a(Context context) {
        f18843a = new C6025b(context);
    }

    /* renamed from: a */
    public static void m24014a(C6052j jVar) {
        SQLiteDatabase a = m24011a();
        if (a != null) {
            ContentValues contentValues = new ContentValues(3);
            contentValues.put("shopId", jVar.getAccount());
            contentValues.put("shopName", jVar.getName());
            contentValues.put("shopAvatar", jVar.getAvatar());
            String str = "shopInfo";
            if (m24016b(jVar.getAccount()) == null) {
                a.insert(str, null, contentValues);
            } else {
                a.replace(str, null, contentValues);
            }
        }
    }

    /* renamed from: a */
    public static void m24015a(C6056n nVar) {
        SQLiteDatabase a = m24011a();
        if (a != null) {
            ContentValues contentValues = new ContentValues(3);
            contentValues.put("staffNimId", nVar.getAccount());
            contentValues.put("staffName", nVar.getName());
            contentValues.put("staffAvatar", nVar.getAvatar());
            String str = "staffInfo";
            if (m24012a(nVar.getAccount()) == null) {
                a.insert(str, null, contentValues);
            } else {
                a.replace(str, null, contentValues);
            }
        }
    }

    /* renamed from: b */
    public static C6052j m24016b(String str) {
        SQLiteDatabase a = m24011a();
        C6052j jVar = null;
        if (a == null) {
            return null;
        }
        Cursor rawQuery = a.rawQuery(String.format(Locale.getDefault(), "SELECT %1$s FROM shopInfo WHERE shopId='%2$s'", new Object[]{"shopId,shopName,shopAvatar", str}), null);
        if (rawQuery != null && rawQuery.moveToNext()) {
            try {
                jVar = new C6052j(str, rawQuery.getString(1), rawQuery.getString(2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (rawQuery != null && !rawQuery.isClosed()) {
            rawQuery.close();
        }
        return jVar;
    }
}
