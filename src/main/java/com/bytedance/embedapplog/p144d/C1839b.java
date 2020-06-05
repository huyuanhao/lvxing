package com.bytedance.embedapplog.p144d;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.p141a.C1805e;
import com.bytedance.embedapplog.p142b.C1821h;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p143c.C1835a;
import com.bytedance.embedapplog.p143c.C1836b;
import com.bytedance.embedapplog.util.C1855g;
import com.bytedance.embedapplog.util.C1856h;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.b */
public class C1839b {
    /* renamed from: a */
    static final HashMap<String, C1838a> f5162a = new HashMap<>();
    /* renamed from: b */
    private static int f5163b;
    /* renamed from: c */
    private static String f5164c;
    /* renamed from: d */
    private static String f5165d;
    /* renamed from: e */
    private static String f5166e;
    /* renamed from: f */
    private static String f5167f;
    /* renamed from: g */
    private final C1821h f5168g;
    /* renamed from: h */
    private final C1822i f5169h;
    /* renamed from: i */
    private final C1840a f5170i;

    /* renamed from: com.bytedance.embedapplog.d.b$a */
    private static class C1840a extends SQLiteOpenHelper {
        C1840a(Context context, String str, CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (C1838a c : C1839b.f5162a.values()) {
                    String c2 = c.mo13464c();
                    if (c2 != null) {
                        sQLiteDatabase.execSQL(c2);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                } catch (Exception e) {
                    C1856h.m6582a(e);
                }
            } catch (Throwable th) {
                C1856h.m6582a(th);
            } finally {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    C1856h.m6582a(e2);
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUpgrade, ");
            sb.append(i);
            sb.append(", ");
            sb.append(i2);
            C1856h.m6585d(sb.toString(), null);
            try {
                sQLiteDatabase.beginTransaction();
                for (C1838a aVar : C1839b.f5162a.values()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("DROP TABLE IF EXISTS ");
                    sb2.append(aVar.mo13466d());
                    sQLiteDatabase.execSQL(sb2.toString());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                } catch (Exception e) {
                    C1856h.m6582a(e);
                }
            } catch (Throwable th) {
                C1856h.m6584c("", th);
            } finally {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    C1856h.m6582a(e2);
                }
            }
            onCreate(sQLiteDatabase);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    /* renamed from: a */
    private String m6465a(C1838a aVar, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(aVar.mo13466d());
        sb.append(" WHERE ");
        sb.append(AccountConst.KEY_SESSION_ID);
        sb.append("='");
        sb.append(str);
        sb.append("' ORDER BY ");
        sb.append("local_time_ms");
        sb.append(" LIMIT ");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: a */
    private String m6466a(C1838a aVar, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(aVar.mo13466d());
        sb.append(" WHERE ");
        sb.append(AccountConst.KEY_SESSION_ID);
        sb.append("='");
        sb.append(str);
        sb.append("' AND ");
        sb.append("local_time_ms");
        sb.append("<=");
        sb.append(j);
        return sb.toString();
    }

    /* renamed from: a */
    private String m6464a(long j, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE pack SET _fail=");
        sb.append(i);
        sb.append(" WHERE ");
        sb.append("local_time_ms");
        sb.append("=");
        sb.append(j);
        return sb.toString();
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = "SELECT * FROM ";
        sb.append(str);
        sb.append(C1847i.f5200h);
        String str2 = " WHERE ";
        sb.append(str2);
        String str3 = "event_name";
        sb.append(str3);
        sb.append(" =?  AND ");
        String str4 = "monitor_status";
        sb.append(str4);
        sb.append("=?");
        f5164c = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE ");
        sb2.append(C1847i.f5200h);
        sb2.append(" SET ");
        sb2.append("monitor_num");
        sb2.append(" =? WHERE ");
        sb2.append(str3);
        sb2.append(" =? AND ");
        sb2.append(str4);
        sb2.append(" =?");
        f5165d = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(C1847i.f5200h);
        sb3.append(str2);
        sb3.append(MessageKey.MSG_DATE);
        sb3.append("<? ORDER BY ");
        String str5 = "local_time_ms";
        sb3.append(str5);
        sb3.append(" LIMIT ?");
        f5166e = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("DELETE FROM ");
        sb4.append(C1847i.f5200h);
        sb4.append(str2);
        sb4.append(str5);
        sb4.append(" <= ?");
        f5167f = sb4.toString();
        m6470a((C1838a) new C1846h());
        m6470a((C1838a) new C1841c());
        m6470a((C1838a) new C1843e(null, false, null));
        m6470a((C1838a) new C1844f());
        m6470a((C1838a) new C1848j());
        m6470a((C1838a) new C1845g());
        m6470a((C1838a) new C1842d("", new JSONObject()));
        m6470a((C1838a) new C1847i());
    }

    public C1839b(Application application, C1822i iVar, C1821h hVar) {
        this.f5170i = new C1840a(application, "bd_embed_tea_agent.db", null, 29);
        this.f5169h = iVar;
        this.f5168g = hVar;
    }

    /* renamed from: a */
    private static void m6470a(C1838a aVar) {
        f5162a.put(aVar.mo13466d(), aVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
            if (r22[1].length() <= 0) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
            if (r22[2].length() <= 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0065, code lost:
            if (r22[0].length() <= 0) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x019b A[SYNTHETIC, Splitter:B:103:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0104 A[Catch:{ Exception -> 0x0176, all -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0165 A[SYNTHETIC, Splitter:B:71:0x0165] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018c A[SYNTHETIC, Splitter:B:95:0x018c] */
    /* renamed from: a */
    public boolean mo13478a(org.json.JSONObject r26, com.bytedance.embedapplog.p144d.C1844f r27, boolean r28) {
        /*
        r25 = this;
        r7 = r25
        r0 = r27
        r8 = r28
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r2 = "eventv3"
        java.lang.Object r1 = r1.get(r2)
        com.bytedance.embedapplog.d.e r1 = (com.bytedance.embedapplog.p144d.C1843e) r1
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r2 = f5162a
        java.lang.String r3 = "event"
        java.lang.Object r2 = r2.get(r3)
        com.bytedance.embedapplog.d.c r2 = (com.bytedance.embedapplog.p144d.C1841c) r2
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r3 = f5162a
        java.lang.String r4 = "event_misc"
        java.lang.Object r3 = r3.get(r4)
        com.bytedance.embedapplog.d.d r3 = (com.bytedance.embedapplog.p144d.C1842d) r3
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r4 = f5162a
        java.lang.String r9 = "pack"
        java.lang.Object r4 = r4.get(r9)
        r15 = r4
        com.bytedance.embedapplog.d.g r15 = (com.bytedance.embedapplog.p144d.C1845g) r15
        android.content.ContentValues r14 = new android.content.ContentValues
        r14.<init>()
        r13 = 0
        r20 = 0
        com.bytedance.embedapplog.d.b$a r4 = r7.f5170i     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
        android.database.sqlite.SQLiteDatabase r11 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
        r11.beginTransaction()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        r4 = 3
        com.bytedance.embedapplog.d.a[] r12 = new com.bytedance.embedapplog.p144d.C1838a[r4]     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        r12[r20] = r2     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        r10 = 1
        r12[r10] = r1     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        r21 = 2
        r12[r21] = r3     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        org.json.JSONArray[] r6 = new org.json.JSONArray[r4]     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        r3 = 0
        java.lang.String r5 = r0.f5157c     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        r1 = r25
        r2 = r12
        r4 = r11
        r22 = r6
        int r1 = r1.m6462a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        r2 = r22[r20]     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        if (r2 == 0) goto L_0x0071
        r2 = r22[r20]     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
        int r2 = r2.length()     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
        if (r2 > 0) goto L_0x008f
        goto L_0x0071
    L_0x0068:
        r0 = move-exception
        r1 = r0
        r8 = r11
        goto L_0x0199
    L_0x006d:
        r0 = move-exception
        r13 = r11
        goto L_0x0187
    L_0x0071:
        r2 = r22[r10]     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        if (r2 == 0) goto L_0x007d
        r2 = r22[r10]     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
        int r2 = r2.length()     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
        if (r2 > 0) goto L_0x008f
    L_0x007d:
        r2 = r22[r21]     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        if (r2 == 0) goto L_0x0089
        r2 = r22[r21]     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
        int r2 = r2.length()     // Catch:{ Exception -> 0x006d, all -> 0x0068 }
        if (r2 > 0) goto L_0x008f
    L_0x0089:
        boolean r2 = r7.m6474a(r0, r8)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
        if (r2 == 0) goto L_0x00fa
    L_0x008f:
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
        boolean r4 = r7.m6474a(r0, r8)     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
        if (r4 == 0) goto L_0x009b
        r4 = r0
        goto L_0x009c
    L_0x009b:
        r4 = r13
    L_0x009c:
        r5 = 0
        r16 = 0
        r17 = r22[r20]     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
        r18 = r22[r10]     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
        r19 = r22[r21]     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
        r6 = 1
        r10 = r15
        r6 = r11
        r24 = r12
        r11 = r2
        r3 = r13
        r13 = r26
        r2 = r14
        r14 = r4
        r4 = r15
        r15 = r5
        r10.mo13486a(r11, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        android.content.ContentValues r14 = r4.mo13461b(r2)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        r6.insert(r9, r3, r14)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        boolean r2 = com.bytedance.embedapplog.util.C1856h.f5226b     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        if (r2 == 0) goto L_0x00e4
        boolean r2 = r7.m6474a(r0, r8)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        if (r2 == 0) goto L_0x00e4
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        r2.<init>()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        java.lang.String r5 = "send launch, "
        r2.append(r5)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        java.lang.String r5 = r0.f5157c     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        r2.append(r5)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        java.lang.String r5 = ", hadUI:"
        r2.append(r5)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        r2.append(r8)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        com.bytedance.embedapplog.util.C1856h.m6581a(r2, r3)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
    L_0x00e4:
        r8 = 1
        r0.f5185k = r8     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        r5 = r1
        r15 = r24
        goto L_0x0101
    L_0x00eb:
        r0 = move-exception
        goto L_0x00f1
    L_0x00ed:
        r0 = move-exception
        goto L_0x00f7
    L_0x00ef:
        r0 = move-exception
        r6 = r11
    L_0x00f1:
        r1 = r0
        r8 = r6
        goto L_0x0199
    L_0x00f5:
        r0 = move-exception
        r6 = r11
    L_0x00f7:
        r13 = r6
        goto L_0x0187
    L_0x00fa:
        r6 = r11
        r3 = r13
        r2 = r14
        r4 = r15
        r8 = 1
        r5 = r1
        r15 = r12
    L_0x0101:
        int r1 = r15.length     // Catch:{ Exception -> 0x0176, all -> 0x0173 }
        if (r5 >= r1) goto L_0x015d
        java.lang.String r10 = r0.f5157c     // Catch:{ Exception -> 0x0176, all -> 0x0173 }
        r1 = r25
        r2 = r15
        r13 = r3
        r3 = r5
        r11 = r4
        r4 = r6
        r5 = r10
        r8 = r6
        r23 = 1
        r6 = r22
        int r5 = r1.m6462a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        r1 = r22[r20]     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        if (r1 == 0) goto L_0x0123
        r1 = r22[r20]     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        int r1 = r1.length()     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        if (r1 > 0) goto L_0x012f
    L_0x0123:
        r1 = r22[r23]     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        if (r1 == 0) goto L_0x0152
        r1 = r22[r23]     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        int r1 = r1.length()     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        if (r1 <= 0) goto L_0x0152
    L_0x012f:
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        r3 = 0
        r4 = 0
        r16 = 0
        r17 = r22[r20]     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        r18 = r22[r23]     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        r19 = r22[r21]     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        r10 = r11
        r6 = r11
        r11 = r1
        r1 = r13
        r13 = r26
        r2 = r14
        r14 = r3
        r3 = r15
        r15 = r4
        r10.mo13486a(r11, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        android.content.ContentValues r14 = r6.mo13461b(r2)     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        r8.insert(r9, r1, r14)     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        goto L_0x0157
    L_0x0152:
        r6 = r11
        r1 = r13
        r2 = r14
        r3 = r15
        r14 = r2
    L_0x0157:
        r15 = r3
        r4 = r6
        r6 = r8
        r8 = 1
        r3 = r1
        goto L_0x0101
    L_0x015d:
        r8 = r6
        r23 = 1
        r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x0171, all -> 0x016f }
        if (r8 == 0) goto L_0x016e
        r8.endTransaction()     // Catch:{ Exception -> 0x0169 }
        goto L_0x016e
    L_0x0169:
        r0 = move-exception
        r1 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)
    L_0x016e:
        return r23
    L_0x016f:
        r0 = move-exception
        goto L_0x0183
    L_0x0171:
        r0 = move-exception
        goto L_0x017e
    L_0x0173:
        r0 = move-exception
        r8 = r6
        goto L_0x0183
    L_0x0176:
        r0 = move-exception
        r8 = r6
        goto L_0x017e
    L_0x0179:
        r0 = move-exception
        r8 = r11
        goto L_0x0183
    L_0x017c:
        r0 = move-exception
        r8 = r11
    L_0x017e:
        r13 = r8
        goto L_0x0187
    L_0x0180:
        r0 = move-exception
        r1 = r13
        r8 = r1
    L_0x0183:
        r1 = r0
        goto L_0x0199
    L_0x0185:
        r0 = move-exception
        r1 = r13
    L_0x0187:
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)     // Catch:{ all -> 0x0196 }
        if (r13 == 0) goto L_0x0195
        r13.endTransaction()     // Catch:{ Exception -> 0x0190 }
        goto L_0x0195
    L_0x0190:
        r0 = move-exception
        r1 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)
    L_0x0195:
        return r20
    L_0x0196:
        r0 = move-exception
        r1 = r0
        r8 = r13
    L_0x0199:
        if (r8 == 0) goto L_0x01a4
        r8.endTransaction()     // Catch:{ Exception -> 0x019f }
        goto L_0x01a4
    L_0x019f:
        r0 = move-exception
        r2 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r2)
    L_0x01a4:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.mo13478a(org.json.JSONObject, com.bytedance.embedapplog.d.f, boolean):boolean");
    }

    /* renamed from: a */
    private boolean m6474a(C1844f fVar, boolean z) {
        return !fVar.f5185k && z;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r9v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r4v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r43v0 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r43v1 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r43v2 */
    /* JADX WARNING: type inference failed for: r9v13, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r4v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r43v3 */
    /* JADX WARNING: type inference failed for: r43v4 */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r43v5 */
    /* JADX WARNING: type inference failed for: r43v6 */
    /* JADX WARNING: type inference failed for: r2v14, types: [long] */
    /* JADX WARNING: type inference failed for: r43v7 */
    /* JADX WARNING: type inference failed for: r9v16, types: [long] */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r9v23 */
    /* JADX WARNING: type inference failed for: r9v24 */
    /* JADX WARNING: type inference failed for: r43v8 */
    /* JADX WARNING: type inference failed for: r9v25 */
    /* JADX WARNING: type inference failed for: r43v9 */
    /* JADX WARNING: type inference failed for: r43v10 */
    /* JADX WARNING: type inference failed for: r9v26 */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0204, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0205, code lost:
            r9 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0208, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0209, code lost:
            r9 = r43;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v6
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x026c A[SYNTHETIC, Splitter:B:121:0x026c] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0281 A[SYNTHETIC, Splitter:B:131:0x0281] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d6 A[SYNTHETIC, Splitter:B:27:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e0 A[SYNTHETIC, Splitter:B:34:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010a A[SYNTHETIC, Splitter:B:41:0x010a] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0171 A[SYNTHETIC, Splitter:B:58:0x0171] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ac A[Catch:{ Exception -> 0x0241, all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0208 A[Catch:{ Exception -> 0x0241, all -> 0x023f }, ExcHandler: Exception (e java.lang.Exception), PHI: r43 r44 
  PHI: (r43v0 ?) = (r43v2 ?), (r43v2 ?), (r43v2 ?), (r43v3 ?), (r43v7 ?), (r43v7 ?) binds: {(r43v2 ?)=B:65:0x019d, (r43v2 ?)=B:66:?, (r43v2 ?)=B:58:0x0171, (r43v3 ?)=B:54:0x0158, (r43v7 ?)=B:44:0x0133, (r43v7 ?)=B:45:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r44v11 android.database.Cursor) = (r44v13 android.database.Cursor), (r44v13 android.database.Cursor), (r44v13 android.database.Cursor), (r44v14 android.database.Cursor), (r44v16 android.database.Cursor), (r44v16 android.database.Cursor) binds: {(r44v13 android.database.Cursor)=B:65:0x019d, (r44v13 android.database.Cursor)=B:66:?, (r44v13 android.database.Cursor)=B:58:0x0171, (r44v14 android.database.Cursor)=B:54:0x0158, (r44v16 android.database.Cursor)=B:44:0x0133, (r44v16 android.database.Cursor)=B:45:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:44:0x0133] */
    /* JADX WARNING: Unknown variable types count: 14 */
    /* renamed from: a */
    public boolean mo13477a(org.json.JSONObject r48) {
        /*
        r47 = this;
        r7 = r47
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r0 = f5162a
        java.lang.String r1 = "launch"
        java.lang.Object r0 = r0.get(r1)
        com.bytedance.embedapplog.d.f r0 = (com.bytedance.embedapplog.p144d.C1844f) r0
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r2 = "terminate"
        java.lang.Object r1 = r1.get(r2)
        r15 = r1
        com.bytedance.embedapplog.d.j r15 = (com.bytedance.embedapplog.p144d.C1848j) r15
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r2 = "page"
        java.lang.Object r1 = r1.get(r2)
        r14 = r1
        com.bytedance.embedapplog.d.h r14 = (com.bytedance.embedapplog.p144d.C1846h) r14
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r2 = "eventv3"
        java.lang.Object r1 = r1.get(r2)
        r18 = r1
        com.bytedance.embedapplog.d.e r18 = (com.bytedance.embedapplog.p144d.C1843e) r18
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r2 = "event"
        java.lang.Object r1 = r1.get(r2)
        r19 = r1
        com.bytedance.embedapplog.d.c r19 = (com.bytedance.embedapplog.p144d.C1841c) r19
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r2 = "event_misc"
        java.lang.Object r1 = r1.get(r2)
        r20 = r1
        com.bytedance.embedapplog.d.d r20 = (com.bytedance.embedapplog.p144d.C1842d) r20
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r13 = "pack"
        java.lang.Object r1 = r1.get(r13)
        r12 = r1
        com.bytedance.embedapplog.d.g r12 = (com.bytedance.embedapplog.p144d.C1845g) r12
        android.content.ContentValues r1 = new android.content.ContentValues
        r1.<init>()
        r11 = 0
        r31 = 0
        com.bytedance.embedapplog.d.b$a r2 = r7.f5170i     // Catch:{ Exception -> 0x025e, all -> 0x0257 }
        android.database.sqlite.SQLiteDatabase r9 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x025e, all -> 0x0257 }
        r9.beginTransaction()     // Catch:{ Exception -> 0x0254, all -> 0x024e }
        java.lang.String r2 = "SELECT * FROM launch ORDER BY local_time_ms DESC LIMIT 5"
        android.database.Cursor r10 = r9.rawQuery(r2, r11)     // Catch:{ Exception -> 0x0254, all -> 0x024e }
        r32 = -9223372036854775808
        r34 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        r5 = r48
        r8 = r1
        r3 = r32
        r1 = r34
    L_0x0076:
        boolean r6 = r10.moveToNext()     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r16 = r13
        r13 = 1
        if (r6 == 0) goto L_0x020c
        r0.mo13457a(r10)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        java.lang.String r6 = r0.f5157c     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        java.lang.String r11 = com.bytedance.embedapplog.p141a.C1805e.m6277c()     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        boolean r6 = android.text.TextUtils.equals(r6, r11)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        if (r6 == 0) goto L_0x0092
        r13 = r16
        r11 = 0
        goto L_0x0076
    L_0x0092:
        java.lang.String r6 = r0.f5183i     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        com.bytedance.embedapplog.b.i r11 = r7.f5169h     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        java.lang.String r11 = r11.mo13434d()     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        boolean r6 = android.text.TextUtils.equals(r6, r11)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        if (r6 == 0) goto L_0x00b8
        int r6 = r0.f5182h     // Catch:{ Exception -> 0x00b4, all -> 0x00ae }
        com.bytedance.embedapplog.b.i r11 = r7.f5169h     // Catch:{ Exception -> 0x00b4, all -> 0x00ae }
        int r11 = r11.mo13432c()     // Catch:{ Exception -> 0x00b4, all -> 0x00ae }
        if (r6 == r11) goto L_0x00ab
        goto L_0x00b8
    L_0x00ab:
        r36 = r5
        goto L_0x00d0
    L_0x00ae:
        r0 = move-exception
        r1 = r0
        r44 = r10
        goto L_0x027a
    L_0x00b4:
        r0 = move-exception
        r11 = r10
        goto L_0x0262
    L_0x00b8:
        org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r6.<init>()     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        com.bytedance.embedapplog.util.C1857i.m6593b(r6, r5)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        java.lang.String r5 = "app_version"
        java.lang.String r11 = r0.f5183i     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r6.put(r5, r11)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        java.lang.String r5 = "version_code"
        int r11 = r0.f5182h     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r6.put(r5, r11)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r36 = r6
    L_0x00d0:
        long r5 = r0.f5155a     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
        if (r11 >= 0) goto L_0x00d8
        long r1 = r0.f5155a     // Catch:{ Exception -> 0x00b4, all -> 0x00ae }
    L_0x00d8:
        r37 = r1
        long r1 = r0.f5155a     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 <= 0) goto L_0x00e5
        long r1 = r0.f5155a     // Catch:{ Exception -> 0x00b4, all -> 0x00ae }
        r39 = r1
        goto L_0x00e7
    L_0x00e5:
        r39 = r3
    L_0x00e7:
        org.json.JSONArray r21 = r7.m6468a(r0, r15, r14, r9)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r1 = 3
        com.bytedance.embedapplog.d.a[] r11 = new com.bytedance.embedapplog.p144d.C1838a[r1]     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r11[r31] = r19     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r11[r13] = r18     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r2 = 2
        r11[r2] = r20     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        org.json.JSONArray[] r6 = new org.json.JSONArray[r1]     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r3 = 0
        java.lang.String r5 = r0.f5157c     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        r1 = r47
        r2 = r11
        r4 = r9
        r41 = r6
        int r1 = r1.m6462a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        int r2 = r21.length()     // Catch:{ Exception -> 0x0248, all -> 0x0243 }
        if (r2 <= 0) goto L_0x0148
        long r2 = r0.f5155a     // Catch:{ Exception -> 0x0143, all -> 0x013e }
        r4 = 0
        r5 = r41[r31]     // Catch:{ Exception -> 0x0143, all -> 0x013e }
        r6 = r41[r13]     // Catch:{ Exception -> 0x0143, all -> 0x013e }
        r22 = 2
        r23 = r41[r22]     // Catch:{ Exception -> 0x0143, all -> 0x013e }
        r42 = r8
        r8 = r12
        r43 = r9
        r44 = r10
        r9 = r2
        r3 = r11
        r2 = 0
        r11 = r36
        r48 = r12
        r12 = r4
        r4 = r16
        r2 = 1
        r13 = r15
        r45 = r14
        r14 = r21
        r46 = r15
        r15 = r5
        r16 = r6
        r17 = r23
        r8.mo13486a(r9, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        r5 = 2
        goto L_0x016d
    L_0x0138:
        r0 = move-exception
        r1 = r0
        r9 = r43
        goto L_0x027a
    L_0x013e:
        r0 = move-exception
        r43 = r9
        goto L_0x0244
    L_0x0143:
        r0 = move-exception
        r43 = r9
        goto L_0x0249
    L_0x0148:
        r42 = r8
        r43 = r9
        r44 = r10
        r3 = r11
        r48 = r12
        r45 = r14
        r46 = r15
        r4 = r16
        r2 = 1
        r0.f5184j = r2     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
        long r9 = r0.f5155a     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
        r13 = 0
        r14 = 0
        r15 = r41[r31]     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
        r16 = r41[r2]     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
        r5 = 2
        r17 = r41[r5]     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
        r8 = r48
        r11 = r36
        r12 = r0
        r8.mo13486a(r9, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
    L_0x016d:
        boolean r6 = com.bytedance.embedapplog.util.C1856h.f5226b     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
        if (r6 == 0) goto L_0x0199
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        r6.<init>()     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        java.lang.String r8 = "packer launch, "
        r6.append(r8)     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        int r8 = r21.length()     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        if (r8 > 0) goto L_0x0183
        r8 = 1
        goto L_0x0184
    L_0x0183:
        r8 = 0
    L_0x0184:
        r6.append(r8)     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        java.lang.String r8 = ", sid:"
        r6.append(r8)     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        java.lang.String r8 = r0.f5157c     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        r6.append(r8)     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
        r8 = 0
        com.bytedance.embedapplog.util.C1856h.m6581a(r6, r8)     // Catch:{ Exception -> 0x0208, all -> 0x0138 }
    L_0x0199:
        r8 = r48
        r6 = r42
        android.content.ContentValues r6 = r8.mo13461b(r6)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
        r9 = r43
        r10 = 0
        r9.insert(r4, r10, r6)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r11 = r6
        r6 = r1
    L_0x01a9:
        int r1 = r3.length     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        if (r6 >= r1) goto L_0x01f2
        java.lang.String r12 = r0.f5157c     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r1 = r47
        r13 = r10
        r10 = 2
        r14 = 1
        r2 = r3
        r15 = r3
        r3 = r6
        r6 = r4
        r4 = r9
        r5 = r12
        r12 = r6
        r6 = r41
        int r6 = r1.m6462a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r1 = r41[r31]     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        if (r1 != 0) goto L_0x01d3
        r1 = r41[r14]     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        if (r1 != 0) goto L_0x01d3
        r1 = r41[r10]     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        if (r1 == 0) goto L_0x01cd
        goto L_0x01d3
    L_0x01cd:
        r4 = r12
        r10 = r13
        r3 = r15
        r2 = 1
        r5 = 2
        goto L_0x01a9
    L_0x01d3:
        long r1 = r0.f5155a     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r25 = 0
        r26 = 0
        r27 = 0
        r28 = r41[r31]     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r29 = r41[r14]     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r30 = r41[r10]     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r21 = r8
        r22 = r1
        r24 = r36
        r21.mo13486a(r22, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        android.content.ContentValues r11 = r8.mo13461b(r11)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r9.insert(r12, r13, r11)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        goto L_0x01cd
    L_0x01f2:
        r13 = r4
        r12 = r8
        r8 = r11
        r5 = r36
        r1 = r37
        r3 = r39
        r14 = r45
        r15 = r46
        r11 = r10
        r10 = r44
        goto L_0x0076
    L_0x0204:
        r0 = move-exception
        r9 = r43
        goto L_0x0246
    L_0x0208:
        r0 = move-exception
        r9 = r43
        goto L_0x024b
    L_0x020c:
        r44 = r10
        r10 = 2
        r14 = 1
        int r0 = (r1 > r34 ? 1 : (r1 == r34 ? 0 : -1))
        if (r0 == 0) goto L_0x022b
        int r0 = (r3 > r32 ? 1 : (r3 == r32 ? 0 : -1))
        if (r0 == 0) goto L_0x022b
        java.lang.String r0 = "DELETE FROM launch WHERE local_time_ms>=? AND local_time_ms<=?"
        java.lang.String[] r5 = new java.lang.String[r10]     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r5[r31] = r1     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r5[r14] = r1     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        r9.execSQL(r0, r5)     // Catch:{ Exception -> 0x0241, all -> 0x023f }
    L_0x022b:
        r9.setTransactionSuccessful()     // Catch:{ Exception -> 0x0241, all -> 0x023f }
        if (r44 == 0) goto L_0x0233
        r44.close()
    L_0x0233:
        if (r9 == 0) goto L_0x023e
        r9.endTransaction()     // Catch:{ Exception -> 0x0239 }
        goto L_0x023e
    L_0x0239:
        r0 = move-exception
        r1 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)
    L_0x023e:
        return r14
    L_0x023f:
        r0 = move-exception
        goto L_0x0246
    L_0x0241:
        r0 = move-exception
        goto L_0x024b
    L_0x0243:
        r0 = move-exception
    L_0x0244:
        r44 = r10
    L_0x0246:
        r1 = r0
        goto L_0x027a
    L_0x0248:
        r0 = move-exception
    L_0x0249:
        r44 = r10
    L_0x024b:
        r11 = r44
        goto L_0x0262
    L_0x024e:
        r0 = move-exception
        r13 = r11
        r1 = r0
        r44 = r13
        goto L_0x027a
    L_0x0254:
        r0 = move-exception
        r13 = r11
        goto L_0x0262
    L_0x0257:
        r0 = move-exception
        r13 = r11
        r1 = r0
        r9 = r13
        r44 = r9
        goto L_0x027a
    L_0x025e:
        r0 = move-exception
        r13 = r11
        r9 = r13
        r11 = r9
    L_0x0262:
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)     // Catch:{ all -> 0x0276 }
        if (r11 == 0) goto L_0x026a
        r11.close()
    L_0x026a:
        if (r9 == 0) goto L_0x0275
        r9.endTransaction()     // Catch:{ Exception -> 0x0270 }
        goto L_0x0275
    L_0x0270:
        r0 = move-exception
        r1 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)
    L_0x0275:
        return r31
    L_0x0276:
        r0 = move-exception
        r1 = r0
        r44 = r11
    L_0x027a:
        if (r44 == 0) goto L_0x027f
        r44.close()
    L_0x027f:
        if (r9 == 0) goto L_0x028a
        r9.endTransaction()     // Catch:{ Exception -> 0x0285 }
        goto L_0x028a
    L_0x0285:
        r0 = move-exception
        r2 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r2)
    L_0x028a:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.mo13477a(org.json.JSONObject):boolean");
    }

    /* renamed from: a */
    public void mo13474a(Context context, JSONObject jSONObject) {
        if (C1855g.m6579d()) {
            C1845g gVar = (C1845g) f5162a.get("pack");
            long a = m6463a(jSONObject, gVar);
            if (a <= 0) {
                C1855g.m6580e();
            } else if (m6473a(context, gVar)) {
                m6469a(a);
            } else {
                if (C1856h.f5226b) {
                    C1856h.m6581a("s succ:fail", null);
                }
                C1855g.m6577b();
            }
        }
    }

    /* renamed from: a */
    public void mo13473a(Context context) {
        if (f5163b > 0) {
            C1845g gVar = new C1845g();
            int i = f5163b;
            C1843e eVar = new C1843e("bav2b_monitor", true, new C1847i("db_monitor", "db_fail", i).mo13468f().toString());
            if (C1805e.m6278d() != null) {
                C1805e.m6278d().mo13361b(eVar);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(eVar.mo13468f());
            gVar.mo13486a(System.currentTimeMillis(), this.f5169h.mo13425a(), null, null, null, null, jSONArray, null);
            if (m6473a(context, gVar)) {
                f5163b -= i;
            }
        }
    }

    /* renamed from: a */
    private void m6469a(long j) {
        if (j > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("d succ:maxTs =");
            sb.append(j);
            C1856h.m6581a(sb.toString(), null);
            this.f5170i.getWritableDatabase().execSQL(f5167f, new String[]{String.valueOf(j)});
        }
    }

    /* renamed from: a */
    private boolean m6473a(Context context, C1845g gVar) {
        if (C1835a.m6430a(new String[]{C1836b.m6443b(context, this.f5169h.mo13425a())}, AppLog.toEncryptByte(gVar.mo13468f().toString()), this.f5168g) == 200) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cd, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ce, code lost:
            r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d1, code lost:
            r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e3, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e4, code lost:
            com.bytedance.embedapplog.util.C1856h.m6582a(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd A[ExcHandler: all (r0v10 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00df A[SYNTHETIC, Splitter:B:39:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb A[SYNTHETIC, Splitter:B:45:0x00eb] */
    /* renamed from: a */
    private long m6463a(org.json.JSONObject r16, com.bytedance.embedapplog.p144d.C1845g r17) {
        /*
        r15 = this;
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r0 = f5162a
        java.lang.String r1 = com.bytedance.embedapplog.p144d.C1847i.f5200h
        java.lang.Object r0 = r0.get(r1)
        com.bytedance.embedapplog.d.i r0 = (com.bytedance.embedapplog.p144d.C1847i) r0
        org.json.JSONArray r9 = new org.json.JSONArray
        r9.<init>()
        com.bytedance.embedapplog.d.e r1 = new com.bytedance.embedapplog.d.e
        r2 = 1
        r3 = 0
        java.lang.String r4 = "bav2b_monitor"
        r1.m42867init(r4, r2, r3)
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = "["
        r4.append(r5)
        r5 = 0
        r11 = r15
        com.bytedance.embedapplog.d.b$a r7 = r11.f5170i     // Catch:{ Exception -> 0x00d8 }
        android.database.sqlite.SQLiteDatabase r12 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x00d8 }
        r12.beginTransaction()     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        long r7 = com.bytedance.embedapplog.util.C1855g.m6575a()     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        java.lang.String r10 = f5166e     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        r13 = 2
        java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        r14 = 0
        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        r13[r14] = r7     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        r7 = 200(0xc8, float:2.8E-43)
        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        r13[r2] = r7     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        android.database.Cursor r2 = r12.rawQuery(r10, r13)     // Catch:{ Exception -> 0x00d0, all -> 0x00cd }
        r13 = r5
    L_0x004b:
        boolean r5 = r2.moveToNext()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        if (r5 == 0) goto L_0x0088
        r0.mo13457a(r2)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        org.json.JSONObject r5 = r0.mo13468f()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        java.lang.String r6 = r5.toString()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r1.f5179h = r6     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        com.bytedance.embedapplog.a.k r6 = com.bytedance.embedapplog.p141a.C1805e.m6278d()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        if (r6 == 0) goto L_0x006b
        com.bytedance.embedapplog.a.k r6 = com.bytedance.embedapplog.p141a.C1805e.m6278d()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r6.mo13361b(r1)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
    L_0x006b:
        long r6 = r0.f5155a     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        int r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
        if (r8 <= 0) goto L_0x0074
        long r6 = r0.f5155a     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r13 = r6
    L_0x0074:
        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r4.append(r5)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        java.lang.String r5 = ","
        r4.append(r5)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        org.json.JSONObject r5 = r1.mo13468f()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r9.put(r5)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        goto L_0x004b
    L_0x0088:
        java.lang.String r0 = "]"
        r4.append(r0)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r2.close()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        boolean r0 = com.bytedance.embedapplog.util.C1856h.f5226b     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        if (r0 == 0) goto L_0x00ac
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r0.<init>()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        java.lang.String r1 = "p succ:"
        r0.append(r1)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r0.append(r1)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        com.bytedance.embedapplog.util.C1856h.m6581a(r0, r3)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
    L_0x00ac:
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r5 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        r10 = 0
        r1 = r17
        r4 = r16
        r1.mo13486a(r2, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        r12.setTransactionSuccessful()     // Catch:{ Exception -> 0x00cb, all -> 0x00cd }
        if (r12 == 0) goto L_0x00ca
        r12.endTransaction()     // Catch:{ Exception -> 0x00c5 }
        goto L_0x00ca
    L_0x00c5:
        r0 = move-exception
        r1 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)
    L_0x00ca:
        return r13
    L_0x00cb:
        r0 = move-exception
        goto L_0x00d2
    L_0x00cd:
        r0 = move-exception
        r1 = r0
        goto L_0x00e9
    L_0x00d0:
        r0 = move-exception
        r13 = r5
    L_0x00d2:
        r3 = r12
        goto L_0x00da
    L_0x00d4:
        r0 = move-exception
        r1 = r0
        r12 = r3
        goto L_0x00e9
    L_0x00d8:
        r0 = move-exception
        r13 = r5
    L_0x00da:
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)     // Catch:{ all -> 0x00d4 }
        if (r3 == 0) goto L_0x00e8
        r3.endTransaction()     // Catch:{ Exception -> 0x00e3 }
        goto L_0x00e8
    L_0x00e3:
        r0 = move-exception
        r1 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)
    L_0x00e8:
        return r13
    L_0x00e9:
        if (r12 == 0) goto L_0x00f4
        r12.endTransaction()     // Catch:{ Exception -> 0x00ef }
        goto L_0x00f4
    L_0x00ef:
        r0 = move-exception
        r2 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r2)
    L_0x00f4:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.m6463a(org.json.JSONObject, com.bytedance.embedapplog.d.g):long");
    }

    /* renamed from: a */
    private int m6462a(C1838a[] aVarArr, int i, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            jSONArrayArr[i2] = null;
            i2 = i3;
        }
        int i4 = 200;
        while (i4 > 0 && i2 < aVarArr.length) {
            jSONArrayArr[i2] = m6467a(sQLiteDatabase, aVarArr[i2], str, i4);
            i4 -= jSONArrayArr[i2].length();
            if (i4 > 0) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            if (r14 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
            r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
            if (r14 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
            r11 = new java.lang.StringBuilder();
            r11.append("queryEvent, ");
            r11.append(r12);
            r11.append(r0);
            r11.append(r1.length());
            r11.append(r0);
            r11.append(r5);
            com.bytedance.embedapplog.util.C1856h.m6581a(r11.toString(), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
            return r1;
     */
    /* renamed from: a */
    private org.json.JSONArray m6467a(android.database.sqlite.SQLiteDatabase r11, com.bytedance.embedapplog.p144d.C1838a r12, java.lang.String r13, int r14) {
        /*
        r10 = this;
        java.lang.String r0 = ", "
        org.json.JSONArray r1 = new org.json.JSONArray
        r1.<init>()
        r2 = 0
        r4 = 0
        java.lang.String r14 = r10.m6465a(r12, r13, r14)     // Catch:{ all -> 0x005d }
        android.database.Cursor r14 = r11.rawQuery(r14, r4)     // Catch:{ all -> 0x005d }
        r5 = r2
    L_0x0013:
        boolean r7 = r14.moveToNext()     // Catch:{ all -> 0x005b }
        if (r7 == 0) goto L_0x004a
        r12.mo13457a(r14)     // Catch:{ all -> 0x005b }
        boolean r7 = com.bytedance.embedapplog.util.C1856h.f5226b     // Catch:{ all -> 0x005b }
        if (r7 == 0) goto L_0x003a
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
        r7.<init>()     // Catch:{ all -> 0x005b }
        java.lang.String r8 = "queryEvnetInner, "
        r7.append(r8)     // Catch:{ all -> 0x005b }
        r7.append(r13)     // Catch:{ all -> 0x005b }
        r7.append(r0)     // Catch:{ all -> 0x005b }
        r7.append(r12)     // Catch:{ all -> 0x005b }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x005b }
        com.bytedance.embedapplog.util.C1856h.m6581a(r7, r4)     // Catch:{ all -> 0x005b }
    L_0x003a:
        org.json.JSONObject r7 = r12.mo13468f()     // Catch:{ all -> 0x005b }
        r1.put(r7)     // Catch:{ all -> 0x005b }
        long r7 = r12.f5155a     // Catch:{ all -> 0x005b }
        int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
        if (r9 <= 0) goto L_0x0013
        long r5 = r12.f5155a     // Catch:{ all -> 0x005b }
        goto L_0x0013
    L_0x004a:
        int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
        if (r7 <= 0) goto L_0x0055
        java.lang.String r13 = r10.m6466a(r12, r13, r5)     // Catch:{ all -> 0x005b }
        r11.execSQL(r13)     // Catch:{ all -> 0x005b }
    L_0x0055:
        if (r14 == 0) goto L_0x0066
    L_0x0057:
        r14.close()
        goto L_0x0066
    L_0x005b:
        r11 = move-exception
        goto L_0x0060
    L_0x005d:
        r11 = move-exception
        r5 = r2
        r14 = r4
    L_0x0060:
        com.bytedance.embedapplog.util.C1856h.m6582a(r11)     // Catch:{ all -> 0x008b }
        if (r14 == 0) goto L_0x0066
        goto L_0x0057
    L_0x0066:
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r13 = "queryEvent, "
        r11.append(r13)
        r11.append(r12)
        r11.append(r0)
        int r12 = r1.length()
        r11.append(r12)
        r11.append(r0)
        r11.append(r5)
        java.lang.String r11 = r11.toString()
        com.bytedance.embedapplog.util.C1856h.m6581a(r11, r4)
        return r1
    L_0x008b:
        r11 = move-exception
        if (r14 == 0) goto L_0x0091
        r14.close()
    L_0x0091:
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.m6467a(android.database.sqlite.SQLiteDatabase, com.bytedance.embedapplog.d.a, java.lang.String, int):org.json.JSONArray");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
            if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
            r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
            if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
            if (r3.length() <= 0) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
            if (r6 <= 1000) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
            r6 = 1000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
            r13.f5207h = r6;
            r13.f5157c = r12.f5157c;
            r13.f5155a = r12.f5155a;
            r13.f5208i = (r12.f5155a + r6) / 1000;
            r13.f5156b = com.bytedance.embedapplog.p141a.C1811k.m6303a(r11.f5168g);
            r13.f5159e = r12.f5159e;
            r13.f5160f = r12.f5160f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0099, code lost:
            if (com.bytedance.embedapplog.util.C1856h.f5226b == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
            r12 = new java.lang.StringBuilder();
            r12.append("queryPage, ");
            r12.append(r13);
            r12.append(r0);
            r12.append(r3.length());
            com.bytedance.embedapplog.util.C1856h.m6581a(r12.toString(), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b9, code lost:
            return r3;
     */
    /* renamed from: a */
    private org.json.JSONArray m6468a(com.bytedance.embedapplog.p144d.C1844f r12, com.bytedance.embedapplog.p144d.C1848j r13, com.bytedance.embedapplog.p144d.C1846h r14, android.database.sqlite.SQLiteDatabase r15) {
        /*
        r11 = this;
        java.lang.String r0 = ", "
        r1 = 1
        java.lang.String[] r2 = new java.lang.String[r1]
        java.lang.String r3 = r12.f5157c
        r4 = 0
        r2[r4] = r3
        org.json.JSONArray r3 = new org.json.JSONArray
        r3.<init>()
        r5 = 0
        r6 = 0
        java.lang.String r8 = "SELECT * FROM page WHERE session_id=? LIMIT 500"
        android.database.Cursor r8 = r15.rawQuery(r8, r2)     // Catch:{ all -> 0x0061 }
    L_0x0018:
        boolean r9 = r8.moveToNext()     // Catch:{ all -> 0x005f }
        if (r9 == 0) goto L_0x0052
        r14.mo13457a(r8)     // Catch:{ all -> 0x005f }
        boolean r4 = com.bytedance.embedapplog.util.C1856h.f5226b     // Catch:{ all -> 0x005f }
        if (r4 == 0) goto L_0x003f
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
        r4.<init>()     // Catch:{ all -> 0x005f }
        java.lang.String r9 = "queryPageInner, "
        r4.append(r9)     // Catch:{ all -> 0x005f }
        r4.append(r2)     // Catch:{ all -> 0x005f }
        r4.append(r0)     // Catch:{ all -> 0x005f }
        r4.append(r14)     // Catch:{ all -> 0x005f }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005f }
        com.bytedance.embedapplog.util.C1856h.m6581a(r4, r5)     // Catch:{ all -> 0x005f }
    L_0x003f:
        boolean r4 = r14.mo13488i()     // Catch:{ all -> 0x005f }
        if (r4 == 0) goto L_0x004d
        org.json.JSONObject r4 = r14.mo13468f()     // Catch:{ all -> 0x005f }
        r3.put(r4)     // Catch:{ all -> 0x005f }
        goto L_0x0050
    L_0x004d:
        long r9 = r14.f5196h     // Catch:{ all -> 0x005f }
        long r6 = r6 + r9
    L_0x0050:
        r4 = 1
        goto L_0x0018
    L_0x0052:
        if (r4 == 0) goto L_0x0059
        java.lang.String r14 = "DELETE FROM page WHERE session_id=?"
        r15.execSQL(r14, r2)     // Catch:{ all -> 0x005f }
    L_0x0059:
        if (r8 == 0) goto L_0x0069
    L_0x005b:
        r8.close()
        goto L_0x0069
    L_0x005f:
        r14 = move-exception
        goto L_0x0063
    L_0x0061:
        r14 = move-exception
        r8 = r5
    L_0x0063:
        com.bytedance.embedapplog.util.C1856h.m6582a(r14)     // Catch:{ all -> 0x00ba }
        if (r8 == 0) goto L_0x0069
        goto L_0x005b
    L_0x0069:
        int r14 = r3.length()
        if (r14 <= 0) goto L_0x0097
        r14 = 1000(0x3e8, double:4.94E-321)
        int r1 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
        if (r1 <= 0) goto L_0x0076
        goto L_0x0077
    L_0x0076:
        r6 = r14
    L_0x0077:
        r13.f5207h = r6
        java.lang.String r1 = r12.f5157c
        r13.f5157c = r1
        long r1 = r12.f5155a
        r13.f5155a = r1
        long r1 = r12.f5155a
        long r1 = r1 + r6
        long r1 = r1 / r14
        r13.f5208i = r1
        com.bytedance.embedapplog.b.h r14 = r11.f5168g
        long r14 = com.bytedance.embedapplog.p141a.C1811k.m6303a(r14)
        r13.f5156b = r14
        java.lang.String r14 = r12.f5159e
        r13.f5159e = r14
        java.lang.String r12 = r12.f5160f
        r13.f5160f = r12
    L_0x0097:
        boolean r12 = com.bytedance.embedapplog.util.C1856h.f5226b
        if (r12 == 0) goto L_0x00b9
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        java.lang.String r14 = "queryPage, "
        r12.append(r14)
        r12.append(r13)
        r12.append(r0)
        int r13 = r3.length()
        r12.append(r13)
        java.lang.String r12 = r12.toString()
        com.bytedance.embedapplog.util.C1856h.m6581a(r12, r5)
    L_0x00b9:
        return r3
    L_0x00ba:
        r12 = move-exception
        if (r8 == 0) goto L_0x00c0
        r8.close()
    L_0x00c0:
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.m6468a(com.bytedance.embedapplog.d.f, com.bytedance.embedapplog.d.j, com.bytedance.embedapplog.d.h, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
            r1 = new java.lang.StringBuilder();
            r1.append("queryPack, ");
            r1.append(r0.size());
            r1.append(", ");
            r1.append(r0);
            com.bytedance.embedapplog.util.C1856h.m6581a(r1.toString(), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
            if (r3 != null) goto L_0x003b;
     */
    /* renamed from: a */
    public java.util.ArrayList<com.bytedance.embedapplog.p144d.C1845g> mo13472a() {
        /*
        r5 = this;
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        java.util.HashMap<java.lang.String, com.bytedance.embedapplog.d.a> r1 = f5162a
        java.lang.String r2 = "pack"
        java.lang.Object r1 = r1.get(r2)
        com.bytedance.embedapplog.d.g r1 = (com.bytedance.embedapplog.p144d.C1845g) r1
        r2 = 0
        com.bytedance.embedapplog.d.b$a r3 = r5.f5170i     // Catch:{ all -> 0x0034 }
        android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ all -> 0x0034 }
        java.lang.String r4 = "SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2"
        android.database.Cursor r3 = r3.rawQuery(r4, r2)     // Catch:{ all -> 0x0034 }
    L_0x001c:
        boolean r4 = r3.moveToNext()     // Catch:{ all -> 0x0032 }
        if (r4 == 0) goto L_0x002f
        com.bytedance.embedapplog.d.a r1 = r1.clone()     // Catch:{ all -> 0x0032 }
        com.bytedance.embedapplog.d.g r1 = (com.bytedance.embedapplog.p144d.C1845g) r1     // Catch:{ all -> 0x0032 }
        r1.mo13457a(r3)     // Catch:{ all -> 0x0032 }
        r0.add(r1)     // Catch:{ all -> 0x0032 }
        goto L_0x001c
    L_0x002f:
        if (r3 == 0) goto L_0x003e
        goto L_0x003b
    L_0x0032:
        r1 = move-exception
        goto L_0x0036
    L_0x0034:
        r1 = move-exception
        r3 = r2
    L_0x0036:
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)     // Catch:{ all -> 0x005f }
        if (r3 == 0) goto L_0x003e
    L_0x003b:
        r3.close()
    L_0x003e:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r3 = "queryPack, "
        r1.append(r3)
        int r3 = r0.size()
        r1.append(r3)
        java.lang.String r3 = ", "
        r1.append(r3)
        r1.append(r0)
        java.lang.String r1 = r1.toString()
        com.bytedance.embedapplog.util.C1856h.m6581a(r1, r2)
        return r0
    L_0x005f:
        r0 = move-exception
        if (r3 == 0) goto L_0x0065
        r3.close()
    L_0x0065:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.mo13472a():java.util.ArrayList");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Throwable, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0, types: [java.lang.Throwable, android.database.sqlite.SQLiteDatabase]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [java.lang.Throwable, ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.sqlite.SQLiteDatabase]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public void mo13476a(java.util.ArrayList<com.bytedance.embedapplog.p144d.C1845g> r19, java.util.ArrayList<com.bytedance.embedapplog.p144d.C1845g> r20) {
        /*
        r18 = this;
        r1 = r18
        r0 = r19
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "setResult, "
        r2.append(r3)
        r2.append(r0)
        java.lang.String r3 = ", "
        r2.append(r3)
        r3 = r20
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        r4 = 0
        com.bytedance.embedapplog.util.C1856h.m6581a(r2, r4)
        java.util.HashMap r2 = new java.util.HashMap
        r2.<init>()
        java.util.HashMap r5 = new java.util.HashMap
        r5.<init>()
        java.util.HashMap r6 = new java.util.HashMap
        r6.<init>()
        java.util.HashMap r7 = new java.util.HashMap
        r7.<init>()
        java.util.HashMap r8 = new java.util.HashMap
        r8.<init>()
        r9 = 1
        r10 = 0
        if (r0 == 0) goto L_0x006d
        int r11 = r19.size()
        if (r11 <= 0) goto L_0x006d
        r11 = 0
    L_0x0047:
        int r12 = r19.size()
        if (r11 >= r12) goto L_0x006d
        java.lang.Object r12 = r0.get(r11)
        com.bytedance.embedapplog.d.g r12 = (com.bytedance.embedapplog.p144d.C1845g) r12
        int r12 = r12.f5187i
        if (r12 != 0) goto L_0x0061
        java.lang.Object r12 = r0.get(r11)
        com.bytedance.embedapplog.d.g r12 = (com.bytedance.embedapplog.p144d.C1845g) r12
        r1.m6471a(r12, r2, r9)
        goto L_0x006a
    L_0x0061:
        java.lang.Object r12 = r0.get(r11)
        com.bytedance.embedapplog.d.g r12 = (com.bytedance.embedapplog.p144d.C1845g) r12
        r1.m6471a(r12, r7, r10)
    L_0x006a:
        int r11 = r11 + 1
        goto L_0x0047
    L_0x006d:
        java.util.Iterator r11 = r20.iterator()
    L_0x0071:
        boolean r12 = r11.hasNext()
        if (r12 == 0) goto L_0x00b9
        java.lang.Object r12 = r11.next()
        com.bytedance.embedapplog.d.g r12 = (com.bytedance.embedapplog.p144d.C1845g) r12
        int r13 = r12.f5187i
        if (r13 != 0) goto L_0x00a1
        int r13 = r12.f5188j
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        java.lang.Object r13 = r5.get(r13)
        java.util.HashMap r13 = (java.util.HashMap) r13
        if (r13 != 0) goto L_0x009d
        java.util.HashMap r13 = new java.util.HashMap
        r13.<init>()
        int r14 = r12.f5188j
        java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
        r5.put(r14, r13)
    L_0x009d:
        r1.m6471a(r12, r13, r10)
        goto L_0x0071
    L_0x00a1:
        int r13 = r12.f5187i
        int r13 = r13 + r9
        long r13 = (long) r13
        r15 = 5
        int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
        if (r17 <= 0) goto L_0x00b5
        r1.m6471a(r12, r6, r10)
        r0.add(r12)
        r11.remove()
        goto L_0x0071
    L_0x00b5:
        r1.m6471a(r12, r8, r10)
        goto L_0x0071
    L_0x00b9:
        com.bytedance.embedapplog.d.b$a r11 = r1.f5170i     // Catch:{ all -> 0x0140 }
        android.database.sqlite.SQLiteDatabase r4 = r11.getWritableDatabase()     // Catch:{ all -> 0x0140 }
        r4.beginTransaction()     // Catch:{ all -> 0x0140 }
        java.util.Iterator r0 = r19.iterator()     // Catch:{ all -> 0x0140 }
    L_0x00c6:
        boolean r11 = r0.hasNext()     // Catch:{ all -> 0x0140 }
        if (r11 == 0) goto L_0x00e2
        java.lang.Object r11 = r0.next()     // Catch:{ all -> 0x0140 }
        com.bytedance.embedapplog.d.g r11 = (com.bytedance.embedapplog.p144d.C1845g) r11     // Catch:{ all -> 0x0140 }
        java.lang.String r12 = "DELETE FROM pack WHERE local_time_ms=?"
        java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ all -> 0x0140 }
        long r14 = r11.f5155a     // Catch:{ all -> 0x0140 }
        java.lang.String r11 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0140 }
        r13[r10] = r11     // Catch:{ all -> 0x0140 }
        r4.execSQL(r12, r13)     // Catch:{ all -> 0x0140 }
        goto L_0x00c6
    L_0x00e2:
        java.util.Iterator r0 = r20.iterator()     // Catch:{ all -> 0x0140 }
    L_0x00e6:
        boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0140 }
        if (r3 == 0) goto L_0x0101
        java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0140 }
        com.bytedance.embedapplog.d.g r3 = (com.bytedance.embedapplog.p144d.C1845g) r3     // Catch:{ all -> 0x0140 }
        long r10 = r3.f5155a     // Catch:{ all -> 0x0140 }
        int r12 = r3.f5187i     // Catch:{ all -> 0x0140 }
        int r12 = r12 + r9
        r3.f5187i = r12     // Catch:{ all -> 0x0140 }
        java.lang.String r3 = r1.m6464a(r10, r12)     // Catch:{ all -> 0x0140 }
        r4.execSQL(r3)     // Catch:{ all -> 0x0140 }
        goto L_0x00e6
    L_0x0101:
        java.util.Set r0 = r5.keySet()     // Catch:{ all -> 0x0140 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0140 }
    L_0x0109:
        boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0140 }
        if (r3 == 0) goto L_0x0123
        java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0140 }
        java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0140 }
        java.lang.Object r9 = r5.get(r3)     // Catch:{ all -> 0x0140 }
        java.util.HashMap r9 = (java.util.HashMap) r9     // Catch:{ all -> 0x0140 }
        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0140 }
        r1.m6472a(r9, r4, r3)     // Catch:{ all -> 0x0140 }
        goto L_0x0109
    L_0x0123:
        java.lang.String r0 = "success"
        r1.m6472a(r2, r4, r0)     // Catch:{ all -> 0x0140 }
        java.lang.String r0 = "retry_success"
        r1.m6472a(r7, r4, r0)     // Catch:{ all -> 0x0140 }
        java.lang.String r0 = "13"
        r1.m6472a(r6, r4, r0)     // Catch:{ all -> 0x0140 }
        java.lang.String r0 = "22"
        r1.m6472a(r8, r4, r0)     // Catch:{ all -> 0x0140 }
        r4.setTransactionSuccessful()     // Catch:{ all -> 0x0140 }
        if (r4 == 0) goto L_0x014f
        r4.endTransaction()     // Catch:{ Exception -> 0x014a }
        goto L_0x014f
    L_0x0140:
        r0 = move-exception
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)     // Catch:{ all -> 0x0150 }
        if (r4 == 0) goto L_0x014f
        r4.endTransaction()     // Catch:{ Exception -> 0x014a }
        goto L_0x014f
    L_0x014a:
        r0 = move-exception
        r2 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r2)
    L_0x014f:
        return
    L_0x0150:
        r0 = move-exception
        r2 = r0
        if (r4 == 0) goto L_0x015d
        r4.endTransaction()     // Catch:{ Exception -> 0x0158 }
        goto L_0x015d
    L_0x0158:
        r0 = move-exception
        r3 = r0
        com.bytedance.embedapplog.util.C1856h.m6582a(r3)
    L_0x015d:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.mo13476a(java.util.ArrayList, java.util.ArrayList):void");
    }

    /* renamed from: a */
    private void m6471a(C1845g gVar, HashMap<String, Integer> hashMap, boolean z) {
        int i;
        int i2;
        String str = NotificationCompat.CATEGORY_EVENT;
        String str2 = "log_data";
        String str3 = "terminate";
        String str4 = "launch";
        try {
            JSONObject jSONObject = new JSONObject(gVar.mo13487i());
            JSONArray optJSONArray = jSONObject.optJSONArray(str4);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(str3);
            if (optJSONArray == null && optJSONArray2 == null && z) {
                int random = ((int) (Math.random() * 100.0d)) + 1;
                if (random > AppLog.getSuccRate()) {
                    if (C1856h.f5226b) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("drop event,succ rate:");
                        sb.append(AppLog.getSuccRate());
                        sb.append(",random num:");
                        sb.append(random);
                        C1856h.m6581a(sb.toString(), null);
                    }
                    return;
                }
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                hashMap.put(str4, Integer.valueOf(optJSONArray.length()));
            }
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                hashMap.put(str3, Integer.valueOf(optJSONArray2.length()));
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray(str2);
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                hashMap.put(str2, Integer.valueOf(optJSONArray3.length()));
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray(str);
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray4.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray4.getJSONObject(i3);
                    String optString = jSONObject2.optString("tag");
                    String optString2 = jSONObject2.optString("label");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(optString);
                    sb2.append(optString2);
                    String sb3 = sb2.toString();
                    Integer num = (Integer) hashMap.get(sb3);
                    if (num == null) {
                        i2 = 1;
                    } else {
                        i2 = num.intValue() + 1;
                    }
                    hashMap.put(sb3, Integer.valueOf(i2));
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("event_v3");
            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray5.length(); i4++) {
                    String optString3 = optJSONArray5.getJSONObject(i4).optString(str);
                    Integer num2 = (Integer) hashMap.get(optString3);
                    if (num2 == null) {
                        i = 1;
                    } else {
                        i = num2.intValue() + 1;
                    }
                    hashMap.put(optString3, Integer.valueOf(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m6472a(HashMap<String, Integer> hashMap, SQLiteDatabase sQLiteDatabase, String str) {
        if (hashMap != null && hashMap.size() != 0 && C1855g.m6578c()) {
            ContentValues contentValues = null;
            for (String str2 : hashMap.keySet()) {
                Cursor rawQuery = sQLiteDatabase.rawQuery(f5164c, new String[]{str2, str});
                Integer num = (Integer) hashMap.get(str2);
                if (C1856h.f5226b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("i succ:");
                    sb.append(str2);
                    sb.append(" r:");
                    sb.append(str);
                    sb.append(" count:");
                    sb.append(num);
                    sb.append(" date:");
                    sb.append(C1855g.m6575a());
                    C1856h.m6581a(sb.toString(), null);
                }
                if (rawQuery.moveToNext()) {
                    int i = rawQuery.getInt(8);
                    sQLiteDatabase.execSQL(f5165d, new String[]{String.valueOf(i + num.intValue()), str2, str});
                } else {
                    C1847i iVar = new C1847i(str2, str, num.intValue());
                    String d = iVar.mo13466d();
                    contentValues = iVar.mo13461b(contentValues);
                    sQLiteDatabase.insert(d, null, contentValues);
                }
                rawQuery.close();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c A[SYNTHETIC, Splitter:B:18:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo13475a(java.util.ArrayList<com.bytedance.embedapplog.p144d.C1838a> r8) {
        /*
        r7 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "save, "
        r0.append(r1)
        java.lang.String r1 = r8.toString()
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        r1 = 0
        com.bytedance.embedapplog.util.C1856h.m6581a(r0, r1)
        com.bytedance.embedapplog.d.b$a r0 = r7.f5170i     // Catch:{ all -> 0x004a }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x004a }
        r0.beginTransaction()     // Catch:{ all -> 0x0048 }
        java.util.Iterator r2 = r8.iterator()     // Catch:{ all -> 0x0048 }
        r3 = r1
    L_0x0027:
        boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0048 }
        if (r4 == 0) goto L_0x003f
        java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0048 }
        com.bytedance.embedapplog.d.a r4 = (com.bytedance.embedapplog.p144d.C1838a) r4     // Catch:{ all -> 0x0048 }
        java.lang.String r5 = r4.mo13466d()     // Catch:{ all -> 0x0048 }
        android.content.ContentValues r3 = r4.mo13461b(r3)     // Catch:{ all -> 0x0048 }
        r0.insert(r5, r1, r3)     // Catch:{ all -> 0x0048 }
        goto L_0x0027
    L_0x003f:
        r0.setTransactionSuccessful()     // Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0064
        r0.endTransaction()     // Catch:{ all -> 0x0060 }
        goto L_0x0064
    L_0x0048:
        r1 = move-exception
        goto L_0x004e
    L_0x004a:
        r0 = move-exception
        r6 = r1
        r1 = r0
        r0 = r6
    L_0x004e:
        int r2 = f5163b     // Catch:{ all -> 0x0065 }
        int r8 = r8.size()     // Catch:{ all -> 0x0065 }
        int r2 = r2 + r8
        f5163b = r2     // Catch:{ all -> 0x0065 }
        com.bytedance.embedapplog.util.C1856h.m6582a(r1)     // Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x0064
        r0.endTransaction()     // Catch:{ all -> 0x0060 }
        goto L_0x0064
    L_0x0060:
        r8 = move-exception
        com.bytedance.embedapplog.util.C1856h.m6582a(r8)
    L_0x0064:
        return
    L_0x0065:
        r8 = move-exception
        if (r0 == 0) goto L_0x0070
        r0.endTransaction()     // Catch:{ all -> 0x006c }
        goto L_0x0070
    L_0x006c:
        r0 = move-exception
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)
    L_0x0070:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1839b.mo13475a(java.util.ArrayList):void");
    }
}
