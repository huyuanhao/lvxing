package com.bytedance.tea.crash.p213b.p215b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.p213b.p214a.DuplicateLog;
import com.bytedance.tea.crash.p221g.NpthLog;
import java.util.HashMap;

/* renamed from: com.bytedance.tea.crash.b.b.b */
public class DuplicateLogDAO extends AbsDAO<DuplicateLog> {
    public DuplicateLogDAO() {
        super("duplicatelog");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public boolean mo16987a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
        r10 = this;
        r0 = 0
        if (r11 == 0) goto L_0x002e
        boolean r1 = android.text.TextUtils.isEmpty(r12)
        if (r1 == 0) goto L_0x000a
        goto L_0x002e
    L_0x000a:
        r1 = 1
        java.lang.String r3 = r10.f9261b     // Catch:{ Exception -> 0x0026 }
        r4 = 0
        java.lang.String r5 = "path=?"
        java.lang.String[] r6 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0026 }
        r6[r0] = r12     // Catch:{ Exception -> 0x0026 }
        r7 = 0
        r8 = 0
        r9 = 0
        r2 = r11
        android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0026 }
        int r12 = r11.getCount()     // Catch:{ Exception -> 0x0026 }
        r11.close()     // Catch:{ Exception -> 0x0024 }
        goto L_0x002b
    L_0x0024:
        r11 = move-exception
        goto L_0x0028
    L_0x0026:
        r11 = move-exception
        r12 = 0
    L_0x0028:
        com.bytedance.tea.crash.p221g.NpthLog.m12550b(r11)
    L_0x002b:
        if (r12 <= 0) goto L_0x002e
        r0 = 1
    L_0x002e:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p213b.p215b.DuplicateLogDAO.mo16987a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    /* renamed from: a */
    public void mo16984a(SQLiteDatabase sQLiteDatabase, DuplicateLog aVar) {
        String str = C7887a.f26833ID;
        if (aVar != null && !mo16987a(sQLiteDatabase, aVar.f9258a)) {
            super.mo16984a(sQLiteDatabase, aVar);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("delete from ");
                sb.append(this.f9261b);
                sb.append(" where ");
                sb.append(str);
                sb.append(" in (select ");
                sb.append(str);
                sb.append(" from ");
                sb.append(this.f9261b);
                sb.append(" order by ");
                sb.append("insert_time");
                sb.append(" desc limit 1000 offset ");
                sb.append(500);
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            } catch (Exception e) {
                NpthLog.m12550b(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HashMap<String, String> mo16982a() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = "TEXT";
        hashMap.put("path", str);
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", str);
        hashMap.put("ext2", str);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ContentValues mo16981a(DuplicateLog aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.f9258a);
        contentValues.put("insert_time", Long.valueOf(aVar.f9259b));
        return contentValues;
    }
}
