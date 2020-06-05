package com.p368pw.inner.base.p385b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.p368pw.inner.base.p387d.C5190h;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;

/* renamed from: com.pw.inner.base.b.a */
public class C5131a {
    /* renamed from: a */
    private Context f16751a;
    /* renamed from: b */
    private SQLiteOpenHelper f16752b;
    /* renamed from: c */
    private SQLiteDatabase f16753c;

    /* renamed from: com.pw.inner.base.b.a$a */
    public interface C5134a {
        /* renamed from: a */
        void mo26382a();
    }

    /* renamed from: com.pw.inner.base.b.a$b */
    public interface C5135b {
        /* renamed from: a */
        void mo25840a(int i);
    }

    /* renamed from: com.pw.inner.base.b.a$c */
    private static class C5136c {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5131a f16758a = new C5131a();
    }

    /* renamed from: a */
    public static C5131a m21242a() {
        return C5136c.f16758a;
    }

    /* renamed from: a */
    public int mo26733a(String str, C5135b bVar) {
        int i = 0;
        Cursor cursor = null;
        try {
            if (this.f16753c != null) {
                String[] strArr = {str};
                Cursor query = this.f16753c.query("table_a", null, "ff = ?", strArr, null, null, null);
                if (query != null && query.getCount() > 0 && query.moveToNext()) {
                    i = query.getInt(query.getColumnIndex("gg"));
                }
                if (query != null) {
                    query.close();
                }
                C5205o.m21462a("dm s act");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
            if (cursor != null) {
                cursor.close();
            }
        }
        if (bVar != null) {
            bVar.mo25840a(i);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* renamed from: a */
    public java.util.List<com.p368pw.inner.base.p385b.C5137b> mo26734a(com.p368pw.inner.base.p385b.C5131a.C5134a r12) {
        /*
        r11 = this;
        r0 = 0
        android.database.sqlite.SQLiteDatabase r1 = r11.f16753c     // Catch:{ all -> 0x00d1 }
        if (r1 == 0) goto L_0x00de
        java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
        r1.<init>()     // Catch:{ all -> 0x00d1 }
        r4 = 0
        r5 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        java.lang.String r9 = "ee desc"
        android.database.sqlite.SQLiteDatabase r2 = r11.f16753c     // Catch:{ all -> 0x00cc }
        java.lang.String r3 = "table_a"
        android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00cc }
        r3 = r0
    L_0x001a:
        boolean r4 = r2.moveToNext()     // Catch:{ all -> 0x00ca }
        if (r4 == 0) goto L_0x009f
        com.pw.inner.base.b.b r4 = new com.pw.inner.base.b.b     // Catch:{ all -> 0x00ca }
        r4.m49233init()     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = "aa"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x00ca }
        r4.f16759a = r5     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = "bb"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x00ca }
        r4.f16760b = r5     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = "cc"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x00ca }
        r4.f16761c = r5     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = "dd"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00ca }
        int r5 = r2.getInt(r5)     // Catch:{ all -> 0x00ca }
        r4.f16762d = r5     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = "ee"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x00ca }
        r4.f16763e = r5     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = "ff"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x00ca }
        r4.f16764f = r5     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = "gg"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x00ca }
        int r5 = r2.getInt(r5)     // Catch:{ all -> 0x00ca }
        r4.f16765g = r5     // Catch:{ all -> 0x00ca }
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ca }
        java.lang.String r7 = r4.f16763e     // Catch:{ all -> 0x00ca }
        java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x00ca }
        long r7 = r7.longValue()     // Catch:{ all -> 0x00ca }
        long r5 = r5 - r7
        r7 = 777600000(0x2e593c00, double:3.84185446E-315)
        int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r9 >= 0) goto L_0x0093
        r1.add(r4)     // Catch:{ all -> 0x00ca }
        goto L_0x001a
    L_0x0093:
        if (r3 != 0) goto L_0x009a
        java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00ca }
        r3.<init>()     // Catch:{ all -> 0x00ca }
    L_0x009a:
        r3.add(r4)     // Catch:{ all -> 0x00ca }
        goto L_0x001a
    L_0x009f:
        if (r3 == 0) goto L_0x00c1
        int r4 = r3.size()     // Catch:{ all -> 0x00ca }
        if (r4 <= 0) goto L_0x00c1
        int r4 = r3.size()     // Catch:{ all -> 0x00ca }
        r5 = 0
    L_0x00ac:
        if (r5 >= r4) goto L_0x00bc
        java.lang.Object r6 = r3.get(r5)     // Catch:{ all -> 0x00ca }
        com.pw.inner.base.b.b r6 = (com.p368pw.inner.base.p385b.C5137b) r6     // Catch:{ all -> 0x00ca }
        java.lang.String r6 = r6.f16764f     // Catch:{ all -> 0x00ca }
        r11.mo26737a(r6, r0)     // Catch:{ all -> 0x00ca }
        int r5 = r5 + 1
        goto L_0x00ac
    L_0x00bc:
        java.lang.String r0 = "dm qe de ot"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r0)     // Catch:{ all -> 0x00ca }
    L_0x00c1:
        r2.close()     // Catch:{ all -> 0x00ca }
        java.lang.String r0 = "dm qe"
        com.p368pw.inner.base.p387d.C5205o.m21462a(r0)     // Catch:{ all -> 0x00ca }
        goto L_0x00dd
    L_0x00ca:
        r0 = move-exception
        goto L_0x00d5
    L_0x00cc:
        r2 = move-exception
        r10 = r2
        r2 = r0
        r0 = r10
        goto L_0x00d5
    L_0x00d1:
        r1 = move-exception
        r2 = r0
        r0 = r1
        r1 = r2
    L_0x00d5:
        com.p368pw.inner.base.p387d.C5205o.m21464a(r0)
        if (r2 == 0) goto L_0x00dd
        r2.close()
    L_0x00dd:
        r0 = r1
    L_0x00de:
        if (r12 == 0) goto L_0x00e3
        r12.mo26382a()
    L_0x00e3:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.base.p385b.C5131a.mo26734a(com.pw.inner.base.b.a$a):java.util.List");
    }

    /* renamed from: a */
    public void mo26735a(Context context) {
        try {
            this.f16751a = context.getApplicationContext();
            this.f16752b = new C5190h(this.f16751a);
            this.f16753c = this.f16752b.getWritableDatabase();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26736a(String str, int i, int i2, final C5134a aVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("dd", Integer.valueOf(i));
            if (i == 2) {
                contentValues.put("ee", String.valueOf(System.currentTimeMillis()));
            }
            contentValues.put("ff", str);
            contentValues.put("gg", Integer.valueOf(i2));
            String str2 = "ff = ?";
            String[] strArr = {str};
            if (this.f16753c != null) {
                this.f16753c.update("table_a", contentValues, str2, strArr);
                C5205o.m21462a("dm ud");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        C5208r.m21479a(new Runnable() {
            public void run() {
                C5134a aVar = aVar;
                if (aVar != null) {
                    aVar.mo26382a();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo26737a(String str, final C5134a aVar) {
        String str2 = "ff = ?";
        try {
            String[] strArr = {str};
            if (this.f16753c != null) {
                this.f16753c.delete("table_a", str2, strArr);
                C5205o.m21462a("dm dl");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        C5208r.m21479a(new Runnable() {
            public void run() {
                C5134a aVar = aVar;
                if (aVar != null) {
                    aVar.mo26382a();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo26738a(String str, String str2, String str3, int i, String str4, String str5, int i2) {
        Cursor cursor;
        String str6;
        String str7 = "ff";
        String str8 = "table_a";
        Cursor cursor2 = null;
        try {
            if (this.f16753c != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("select * from ");
                sb.append(str8);
                sb.append(" where ");
                sb.append(str7);
                sb.append(" = ?");
                cursor = this.f16753c.rawQuery(sb.toString(), new String[]{str5});
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            mo26739b(str, str2, str3, i, str4, str5, i2);
                            str6 = "dm in ud";
                            C5205o.m21462a(str6);
                            cursor2 = cursor;
                        }
                    } catch (Throwable th) {
                        th = th;
                        C5205o.m21464a(th);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("aa", str);
                contentValues.put("bb", str2);
                contentValues.put("cc", str3);
                contentValues.put("dd", Integer.valueOf(i));
                contentValues.put("ee", str4);
                contentValues.put(str7, str5);
                contentValues.put("gg", Integer.valueOf(i2));
                this.f16753c.insert(str8, null, contentValues);
                str6 = "dm in";
                C5205o.m21462a(str6);
                cursor2 = cursor;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursor2;
        }
    }

    /* renamed from: b */
    public void mo26739b(String str, String str2, String str3, int i, String str4, String str5, int i2) {
        try {
            if (this.f16753c != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("aa", str);
                contentValues.put("bb", str2);
                contentValues.put("cc", str3);
                contentValues.put("dd", Integer.valueOf(i));
                contentValues.put("ee", str4);
                contentValues.put("ff", str5);
                contentValues.put("gg", Integer.valueOf(i2));
                String[] strArr = {str5};
                this.f16753c.update("table_a", contentValues, "ff = ?", strArr);
                C5205o.m21462a("dm ud2");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
