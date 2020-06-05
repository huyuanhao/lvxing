package com.qiyukf.nimlib.p451c.p452a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;

/* renamed from: com.qiyukf.nimlib.c.a.b */
public final class C5732b {
    /* renamed from: a */
    public static int m23074a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr) {
        int i;
        boolean z;
        boolean z2;
        int i2;
        String str3 = "db";
        int i3 = 0;
        int i4 = -1;
        while (i3 < 3) {
            try {
                i4 = sQLiteDatabase.update(str, contentValues, str2, strArr);
                i = i4;
                z2 = true;
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder sb = new StringBuilder("exec sql exception: ");
                sb.append(e);
                C5264a.m21617a(str3, sb.toString());
                z = m23078a(e);
                i = i2;
                z2 = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                i = i4;
                z2 = false;
            }
            z = false;
            if (z) {
                C5264a.m21626e(str3, "locked");
            }
            if (z2 || !z) {
                return i;
            }
            i3++;
            i4 = i;
        }
        return i4;
    }

    /* renamed from: a */
    public static long m23075a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        long j;
        boolean z;
        boolean z2;
        long j2;
        String str2 = "db";
        long j3 = -1;
        int i = 0;
        while (i < 3) {
            try {
                j3 = sQLiteDatabase.insert(str, null, contentValues);
                j = j3;
                z2 = true;
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder sb = new StringBuilder("exec sql exception: ");
                sb.append(e);
                C5264a.m21617a(str2, sb.toString());
                z = m23078a(e);
                j = j2;
                z2 = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                j = j3;
                z2 = false;
            }
            z = false;
            if (z) {
                C5264a.m21626e(str2, "locked");
            }
            if (z2 || !z) {
                return j;
            }
            i++;
            j3 = j;
        }
        return j3;
    }

    /* renamed from: a */
    public static final Cursor m23076a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        boolean z;
        String str2 = "db";
        Cursor cursor2 = null;
        for (int i = 0; i < 3; i++) {
            try {
                cursor2 = sQLiteDatabase.rawQuery(str, null);
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder sb = new StringBuilder("exec sql exception: ");
                sb.append(e);
                C5264a.m21617a(str2, sb.toString());
                z = m23078a(e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            z = false;
            if (z) {
                C5264a.m21626e(str2, "locked");
            }
            if (cursor2 != null || !z) {
                break;
            }
        }
        return C5736d.m23091a(cursor);
    }

    /* renamed from: a */
    public static String m23077a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("'", "''");
    }

    /* renamed from: a */
    public static final boolean m23078a(SQLiteException sQLiteException) {
        String message = sQLiteException.getMessage();
        return !TextUtils.isEmpty(message) && message.contains("lock");
    }

    /* renamed from: b */
    public static long m23079b(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        long j;
        boolean z;
        boolean z2;
        long j2;
        String str2 = "db";
        long j3 = -1;
        int i = 0;
        while (i < 3) {
            try {
                j3 = sQLiteDatabase.replace(str, null, contentValues);
                j = j3;
                z2 = true;
            } catch (SQLiteException e) {
                e.printStackTrace();
                StringBuilder sb = new StringBuilder("exec sql exception: ");
                sb.append(e);
                C5264a.m21617a(str2, sb.toString());
                z = m23078a(e);
                j = j2;
                z2 = false;
            } catch (Exception e2) {
                e2.printStackTrace();
                j = j3;
                z2 = false;
            }
            z = false;
            if (z) {
                C5264a.m21626e(str2, "locked");
            }
            if (z2 || !z) {
                return j;
            }
            i++;
            j3 = j;
        }
        return j3;
    }
}
