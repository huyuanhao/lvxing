package com.alibaba.mtl.log.p076c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.mtl.appmonitor.p069b.ExceptionEventBuilder;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alibaba.mtl.log.c.b */
class LogSqliteStore implements ILogStore {
    /* renamed from: a */
    String f3356a = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
    /* renamed from: b */
    String f3357b = "SELECT count(*) FROM %s";
    /* renamed from: c */
    String f3358c = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";
    /* renamed from: d */
    C1311a f3359d;

    /* compiled from: LogSqliteStore */
    /* renamed from: com.alibaba.mtl.log.c.b$a */
    class C1311a extends SQLiteOpenHelper {
        /* renamed from: b */
        private AtomicInteger f3361b = new AtomicInteger();
        /* renamed from: c */
        private SQLiteDatabase f3362c;

        C1311a(Context context) {
            super(context, "ut.db", null, 2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
            } catch (Throwable unused) {
            }
            LogSqliteStore.this.m3765a(cursor);
            super.onOpen(sQLiteDatabase);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1 && i2 == 2) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
                } catch (Throwable th) {
                    Logger.m3832a("UTSqliteLogStore", "DB Upgrade Error", th);
                }
            }
        }

        public synchronized SQLiteDatabase getWritableDatabase() {
            try {
                if (this.f3361b.incrementAndGet() == 1) {
                    this.f3362c = super.getWritableDatabase();
                }
            } catch (Throwable th) {
                Logger.m3832a("TAG", "e", th);
                ExceptionEventBuilder.m3405a(th);
            }
            return this.f3362c;
        }

        /* renamed from: a */
        public synchronized void mo11784a(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    if (this.f3361b.decrementAndGet() == 0 && this.f3362c != null) {
                        this.f3362c.close();
                        this.f3362c = null;
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    protected LogSqliteStore(Context context) {
        this.f3359d = new C1311a(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:6|7|8|(3:10|11|(3:12|13|(3:15|(2:17|(2:63|19)(2:20|65))(1:66)|21)(2:64|22)))(3:25|26|27)|(4:29|30|31|32)|33|34|35|47|48) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:23|24|37|38|39|(0)|45|46|35|47|48) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:29|30|31|32) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:41|42|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d5, code lost:
            return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00a1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ba */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00bd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00c8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b7 A[SYNTHETIC, Splitter:B:41:0x00b7] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x00a4=Splitter:B:33:0x00a4, B:55:0x00cb=Splitter:B:55:0x00cb, B:45:0x00bd=Splitter:B:45:0x00bd} */
    /* renamed from: a */
    public synchronized boolean mo11780a(java.util.List<com.alibaba.mtl.log.model.Log> r11) {
        /*
        r10 = this;
        monitor-enter(r10)
        r0 = 1
        if (r11 == 0) goto L_0x00d4
        int r1 = r11.size()     // Catch:{ all -> 0x00d1 }
        if (r1 != 0) goto L_0x000c
        goto L_0x00d4
    L_0x000c:
        r1 = 0
        r2 = 0
        com.alibaba.mtl.log.c.b$a r3 = r10.f3359d     // Catch:{ all -> 0x00aa }
        android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ all -> 0x00aa }
        if (r1 == 0) goto L_0x0091
        r1.beginTransaction()     // Catch:{ all -> 0x00aa }
        r3 = 0
    L_0x001a:
        int r4 = r11.size()     // Catch:{ all -> 0x008e }
        if (r3 >= r4) goto L_0x008c
        java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x008e }
        com.alibaba.mtl.log.model.a r4 = (com.alibaba.mtl.log.model.Log) r4     // Catch:{ all -> 0x008e }
        if (r4 == 0) goto L_0x0089
        android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ all -> 0x008e }
        r5.<init>()     // Catch:{ all -> 0x008e }
        java.lang.String r6 = "eventId"
        java.lang.String r7 = r4.f3462b     // Catch:{ all -> 0x008e }
        r5.put(r6, r7)     // Catch:{ all -> 0x008e }
        java.lang.String r6 = "priority"
        java.lang.String r7 = r4.f3463c     // Catch:{ all -> 0x008e }
        r5.put(r6, r7)     // Catch:{ all -> 0x008e }
        java.lang.String r6 = r4.mo11837b()     // Catch:{ all -> 0x008e }
        java.lang.String r7 = "content"
        r5.put(r7, r6)     // Catch:{ all -> 0x008e }
        java.lang.String r6 = "time"
        java.lang.String r7 = r4.f3464d     // Catch:{ all -> 0x008e }
        r5.put(r6, r7)     // Catch:{ all -> 0x008e }
        java.lang.String r6 = "_index"
        java.lang.String r7 = r4.f3465e     // Catch:{ all -> 0x008e }
        r5.put(r6, r7)     // Catch:{ all -> 0x008e }
        java.lang.String r6 = "log"
        java.lang.String r7 = ""
        long r5 = r1.insert(r6, r7, r5)     // Catch:{ all -> 0x008e }
        r7 = -1
        int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r9 != 0) goto L_0x0061
        goto L_0x009c
    L_0x0061:
        java.lang.String r7 = "UTSqliteLogStore"
        r8 = 6
        java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x008e }
        java.lang.String r9 = "[insert] "
        r8[r2] = r9     // Catch:{ all -> 0x008e }
        java.lang.String r4 = r4.f3465e     // Catch:{ all -> 0x008e }
        r8[r0] = r4     // Catch:{ all -> 0x008e }
        r4 = 2
        java.lang.String r9 = " isSuccess:"
        r8[r4] = r9     // Catch:{ all -> 0x008e }
        r4 = 3
        java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x008e }
        r8[r4] = r9     // Catch:{ all -> 0x008e }
        r4 = 4
        java.lang.String r9 = "ret"
        r8[r4] = r9     // Catch:{ all -> 0x008e }
        r4 = 5
        java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x008e }
        r8[r4] = r5     // Catch:{ all -> 0x008e }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r7, r8)     // Catch:{ all -> 0x008e }
    L_0x0089:
        int r3 = r3 + 1
        goto L_0x001a
    L_0x008c:
        r2 = 1
        goto L_0x009c
    L_0x008e:
        r11 = move-exception
        r2 = 1
        goto L_0x00ab
    L_0x0091:
        java.lang.String r11 = "UTSqliteLogStore"
        java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00aa }
        java.lang.String r3 = "db is null"
        r0[r2] = r3     // Catch:{ all -> 0x00aa }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r11, r0)     // Catch:{ all -> 0x00aa }
    L_0x009c:
        if (r1 == 0) goto L_0x00a4
        r1.setTransactionSuccessful()     // Catch:{ all -> 0x00a1 }
    L_0x00a1:
        r1.endTransaction()     // Catch:{ all -> 0x00a4 }
    L_0x00a4:
        com.alibaba.mtl.log.c.b$a r11 = r10.f3359d     // Catch:{ all -> 0x00d1 }
    L_0x00a6:
        r11.mo11784a(r1)     // Catch:{ all -> 0x00d1 }
        goto L_0x00c0
    L_0x00aa:
        r11 = move-exception
    L_0x00ab:
        java.lang.String r0 = "UTSqliteLogStore"
        java.lang.String r3 = "insert error"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r0, r3, r11)     // Catch:{ all -> 0x00c2 }
        com.alibaba.mtl.appmonitor.p069b.ExceptionEventBuilder.m3405a(r11)     // Catch:{ all -> 0x00c2 }
        if (r1 == 0) goto L_0x00bd
        r1.setTransactionSuccessful()     // Catch:{ all -> 0x00ba }
    L_0x00ba:
        r1.endTransaction()     // Catch:{ all -> 0x00bd }
    L_0x00bd:
        com.alibaba.mtl.log.c.b$a r11 = r10.f3359d     // Catch:{ all -> 0x00d1 }
        goto L_0x00a6
    L_0x00c0:
        monitor-exit(r10)
        return r2
    L_0x00c2:
        r11 = move-exception
        if (r1 == 0) goto L_0x00cb
        r1.setTransactionSuccessful()     // Catch:{ all -> 0x00c8 }
    L_0x00c8:
        r1.endTransaction()     // Catch:{ all -> 0x00cb }
    L_0x00cb:
        com.alibaba.mtl.log.c.b$a r0 = r10.f3359d     // Catch:{ all -> 0x00d1 }
        r0.mo11784a(r1)     // Catch:{ all -> 0x00d1 }
        throw r11     // Catch:{ all -> 0x00d1 }
    L_0x00d1:
        r11 = move-exception
        monitor-exit(r10)
        throw r11
    L_0x00d4:
        monitor-exit(r10)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p076c.LogSqliteStore.mo11780a(java.util.List):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|11|(4:14|(2:16|45)(2:17|(2:19|44)(1:46))|20|12)|21|22|23|24|25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
            return 0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x008d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x009a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x009d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0090=Splitter:B:25:0x0090, B:32:0x009d=Splitter:B:32:0x009d} */
    /* renamed from: b */
    public synchronized int mo11781b(java.util.List<com.alibaba.mtl.log.model.Log> r15) {
        /*
        r14 = this;
        monitor-enter(r14)
        r0 = 0
        if (r15 == 0) goto L_0x00d4
        int r1 = r15.size()     // Catch:{ all -> 0x00d1 }
        if (r1 != 0) goto L_0x000c
        goto L_0x00d4
    L_0x000c:
        com.alibaba.mtl.log.c.b$a r1 = r14.f3359d     // Catch:{ all -> 0x00d1 }
        android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x00d1 }
        r2 = 3
        r3 = 2
        r4 = 4
        r5 = 1
        if (r1 == 0) goto L_0x00a3
        r1.beginTransaction()     // Catch:{ all -> 0x0096 }
        r6 = 0
        r7 = 1
        r8 = 0
    L_0x001e:
        int r9 = r15.size()     // Catch:{ all -> 0x0096 }
        if (r6 >= r9) goto L_0x008a
        java.lang.String r9 = "log"
        java.lang.String r10 = "_id=?"
        java.lang.String[] r11 = new java.lang.String[r5]     // Catch:{ all -> 0x0096 }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
        r12.<init>()     // Catch:{ all -> 0x0096 }
        java.lang.Object r13 = r15.get(r6)     // Catch:{ all -> 0x0096 }
        com.alibaba.mtl.log.model.a r13 = (com.alibaba.mtl.log.model.Log) r13     // Catch:{ all -> 0x0096 }
        int r13 = r13.f3461a     // Catch:{ all -> 0x0096 }
        r12.append(r13)     // Catch:{ all -> 0x0096 }
        java.lang.String r13 = ""
        r12.append(r13)     // Catch:{ all -> 0x0096 }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0096 }
        r11[r0] = r12     // Catch:{ all -> 0x0096 }
        int r9 = r1.delete(r9, r10, r11)     // Catch:{ all -> 0x0096 }
        long r9 = (long) r9     // Catch:{ all -> 0x0096 }
        r11 = 0
        int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
        if (r13 > 0) goto L_0x0075
        java.lang.String r7 = "UTSqliteLogStore"
        java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x0096 }
        java.lang.String r12 = "[delete]  "
        r11[r0] = r12     // Catch:{ all -> 0x0096 }
        java.lang.Object r12 = r15.get(r6)     // Catch:{ all -> 0x0096 }
        com.alibaba.mtl.log.model.a r12 = (com.alibaba.mtl.log.model.Log) r12     // Catch:{ all -> 0x0096 }
        int r12 = r12.f3461a     // Catch:{ all -> 0x0096 }
        java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0096 }
        r11[r5] = r12     // Catch:{ all -> 0x0096 }
        java.lang.String r12 = " ret:"
        r11[r3] = r12     // Catch:{ all -> 0x0096 }
        java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0096 }
        r11[r2] = r9     // Catch:{ all -> 0x0096 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r7, r11)     // Catch:{ all -> 0x0096 }
        r7 = 0
        goto L_0x0087
    L_0x0075:
        java.lang.String r9 = "6005"
        java.lang.Object r10 = r15.get(r6)     // Catch:{ all -> 0x0096 }
        com.alibaba.mtl.log.model.a r10 = (com.alibaba.mtl.log.model.Log) r10     // Catch:{ all -> 0x0096 }
        java.lang.String r10 = r10.f3462b     // Catch:{ all -> 0x0096 }
        boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ all -> 0x0096 }
        if (r9 != 0) goto L_0x0087
        int r8 = r8 + 1
    L_0x0087:
        int r6 = r6 + 1
        goto L_0x001e
    L_0x008a:
        r1.setTransactionSuccessful()     // Catch:{ all -> 0x008d }
    L_0x008d:
        r1.endTransaction()     // Catch:{ all -> 0x0090 }
    L_0x0090:
        com.alibaba.mtl.log.c.b$a r6 = r14.f3359d     // Catch:{ all -> 0x00d1 }
        r6.mo11784a(r1)     // Catch:{ all -> 0x00d1 }
        goto L_0x00b0
    L_0x0096:
        r15 = move-exception
        r1.setTransactionSuccessful()     // Catch:{ all -> 0x009a }
    L_0x009a:
        r1.endTransaction()     // Catch:{ all -> 0x009d }
    L_0x009d:
        com.alibaba.mtl.log.c.b$a r0 = r14.f3359d     // Catch:{ all -> 0x00d1 }
        r0.mo11784a(r1)     // Catch:{ all -> 0x00d1 }
        throw r15     // Catch:{ all -> 0x00d1 }
    L_0x00a3:
        java.lang.String r1 = "UTSqliteLogStore"
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x00d1 }
        java.lang.String r7 = "db is null"
        r6[r0] = r7     // Catch:{ all -> 0x00d1 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r1, r6)     // Catch:{ all -> 0x00d1 }
        r7 = 0
        r8 = 0
    L_0x00b0:
        java.lang.String r1 = "UTSqliteLogStore"
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00d1 }
        java.lang.String r6 = "delete "
        r4[r0] = r6     // Catch:{ all -> 0x00d1 }
        int r15 = r15.size()     // Catch:{ all -> 0x00d1 }
        java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x00d1 }
        r4[r5] = r15     // Catch:{ all -> 0x00d1 }
        java.lang.String r15 = " isSuccess:"
        r4[r3] = r15     // Catch:{ all -> 0x00d1 }
        java.lang.Boolean r15 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x00d1 }
        r4[r2] = r15     // Catch:{ all -> 0x00d1 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r1, r4)     // Catch:{ all -> 0x00d1 }
        monitor-exit(r14)
        return r8
    L_0x00d1:
        r15 = move-exception
        monitor-exit(r14)
        throw r15
    L_0x00d4:
        monitor-exit(r14)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p076c.LogSqliteStore.mo11781b(java.util.List):int");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:21|22|23|24|25|26|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00fc */
    /* renamed from: b */
    public synchronized java.util.ArrayList<com.alibaba.mtl.log.model.Log> mo11777a(java.lang.String r9, int r10) {
        /*
        r8 = this;
        monitor-enter(r8)
        r0 = 0
        if (r10 > 0) goto L_0x000a
        java.util.List r9 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x012b }
        java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x012b }
        monitor-exit(r8)
        return r9
    L_0x000a:
        java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x012b }
        r1.<init>(r10)     // Catch:{ all -> 0x012b }
        com.alibaba.mtl.log.c.b$a r2 = r8.f3359d     // Catch:{ all -> 0x012c }
        android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ all -> 0x012c }
        r3 = 0
        r4 = 1
        if (r2 == 0) goto L_0x011f
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x012c }
        r5.<init>()     // Catch:{ all -> 0x012c }
        java.lang.String r6 = "SELECT * FROM "
        r5.append(r6)     // Catch:{ all -> 0x012c }
        java.lang.String r6 = "log"
        r5.append(r6)     // Catch:{ all -> 0x012c }
        boolean r6 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x012c }
        if (r6 != 0) goto L_0x0036
        java.lang.String r6 = " WHERE "
        r5.append(r6)     // Catch:{ all -> 0x012c }
        r5.append(r9)     // Catch:{ all -> 0x012c }
    L_0x0036:
        java.lang.String r9 = " ORDER BY "
        r5.append(r9)     // Catch:{ all -> 0x012c }
        java.lang.String r9 = "time"
        r5.append(r9)     // Catch:{ all -> 0x012c }
        java.lang.String r9 = " ASC "
        r5.append(r9)     // Catch:{ all -> 0x012c }
        java.lang.String r9 = " LIMIT "
        r5.append(r9)     // Catch:{ all -> 0x012c }
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x012c }
        r9.<init>()     // Catch:{ all -> 0x012c }
        r9.append(r10)     // Catch:{ all -> 0x012c }
        java.lang.String r10 = ""
        r9.append(r10)     // Catch:{ all -> 0x012c }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x012c }
        r5.append(r9)     // Catch:{ all -> 0x012c }
        java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x012c }
        java.lang.String r10 = "UTSqliteLogStore"
        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x012c }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x012c }
        r6.<init>()     // Catch:{ all -> 0x012c }
        java.lang.String r7 = "sql:"
        r6.append(r7)     // Catch:{ all -> 0x012c }
        r6.append(r9)     // Catch:{ all -> 0x012c }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x012c }
        r5[r3] = r6     // Catch:{ all -> 0x012c }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r10, r5)     // Catch:{ all -> 0x012c }
        android.database.Cursor r0 = r2.rawQuery(r9, r0)     // Catch:{ all -> 0x0109 }
    L_0x0080:
        if (r0 == 0) goto L_0x0100
        boolean r9 = r0.moveToNext()     // Catch:{ all -> 0x0109 }
        if (r9 == 0) goto L_0x0100
        com.alibaba.mtl.log.model.a r9 = new com.alibaba.mtl.log.model.a     // Catch:{ all -> 0x0109 }
        r9.m41943init()     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = "UTSqliteLogStore"
        r5 = 4
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0109 }
        java.lang.String r6 = "pos"
        r5[r3] = r6     // Catch:{ all -> 0x0109 }
        int r6 = r0.getPosition()     // Catch:{ all -> 0x0109 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0109 }
        r5[r4] = r6     // Catch:{ all -> 0x0109 }
        r6 = 2
        java.lang.String r7 = "count"
        r5[r6] = r7     // Catch:{ all -> 0x0109 }
        r6 = 3
        int r7 = r0.getCount()     // Catch:{ all -> 0x0109 }
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0109 }
        r5[r6] = r7     // Catch:{ all -> 0x0109 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r10, r5)     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = "_id"
        int r10 = r0.getColumnIndex(r10)     // Catch:{ all -> 0x0109 }
        int r10 = r0.getInt(r10)     // Catch:{ all -> 0x0109 }
        r9.f3461a = r10     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = "eventId"
        int r10 = r0.getColumnIndex(r10)     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = r0.getString(r10)     // Catch:{ all -> 0x0109 }
        r9.f3462b = r10     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = "priority"
        int r10 = r0.getColumnIndex(r10)     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = r0.getString(r10)     // Catch:{ all -> 0x0109 }
        r9.f3463c = r10     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = "content"
        int r10 = r0.getColumnIndex(r10)     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = r0.getString(r10)     // Catch:{ all -> 0x0109 }
        r9.mo11838b(r10)     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = "time"
        int r10 = r0.getColumnIndex(r10)     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = r0.getString(r10)     // Catch:{ all -> 0x0109 }
        r9.f3464d = r10     // Catch:{ all -> 0x0109 }
        java.lang.String r10 = "_index"
        int r10 = r0.getColumnIndex(r10)     // Catch:{ all -> 0x00fc }
        java.lang.String r10 = r0.getString(r10)     // Catch:{ all -> 0x00fc }
        r9.f3465e = r10     // Catch:{ all -> 0x00fc }
    L_0x00fc:
        r1.add(r9)     // Catch:{ all -> 0x0109 }
        goto L_0x0080
    L_0x0100:
        r8.m3765a(r0)     // Catch:{ all -> 0x012c }
    L_0x0103:
        com.alibaba.mtl.log.c.b$a r9 = r8.f3359d     // Catch:{ all -> 0x012c }
        r9.mo11784a(r2)     // Catch:{ all -> 0x012c }
        goto L_0x012c
    L_0x0109:
        r9 = move-exception
        java.lang.String r10 = "UTSqliteLogStore"
        java.lang.String r3 = "[get]"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r10, r3, r9)     // Catch:{ all -> 0x0115 }
        r8.m3765a(r0)     // Catch:{ all -> 0x012c }
        goto L_0x0103
    L_0x0115:
        r9 = move-exception
        r8.m3765a(r0)     // Catch:{ all -> 0x012c }
        com.alibaba.mtl.log.c.b$a r10 = r8.f3359d     // Catch:{ all -> 0x012c }
        r10.mo11784a(r2)     // Catch:{ all -> 0x012c }
        throw r9     // Catch:{ all -> 0x012c }
    L_0x011f:
        java.lang.String r9 = "UTSqliteLogStore"
        java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ all -> 0x012c }
        java.lang.String r0 = "db is null"
        r10[r3] = r0     // Catch:{ all -> 0x012c }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r9, r10)     // Catch:{ all -> 0x012c }
        goto L_0x012c
    L_0x012b:
        r1 = r0
    L_0x012c:
        monitor-exit(r8)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p076c.LogSqliteStore.mo11777a(java.lang.String, int):java.util.ArrayList");
    }

    /* renamed from: a */
    public synchronized int mo11776a() {
        int i;
        C1311a aVar;
        SQLiteDatabase writableDatabase = this.f3359d.getWritableDatabase();
        i = 0;
        if (writableDatabase != null) {
            try {
                Cursor rawQuery = writableDatabase.rawQuery(String.format(this.f3357b, new Object[]{"log"}), null);
                if (rawQuery != null) {
                    rawQuery.moveToFirst();
                    i = rawQuery.getInt(0);
                }
                m3765a(rawQuery);
                aVar = this.f3359d;
            } catch (Throwable unused) {
                m3765a((Cursor) null);
                aVar = this.f3359d;
            }
            aVar.mo11784a(writableDatabase);
        } else {
            Logger.m3833a("UTSqliteLogStore", "db is null");
        }
        return i;
    }

    /* renamed from: b */
    public synchronized void mo11782b() {
        SQLiteDatabase writableDatabase = this.f3359d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", null, null);
            this.f3359d.mo11784a(writableDatabase);
        }
    }

    /* renamed from: a */
    public synchronized void mo11779a(String str, String str2) {
        C1311a aVar;
        SQLiteDatabase writableDatabase = this.f3359d.getWritableDatabase();
        if (writableDatabase != null) {
            String str3 = "log";
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" < ?");
                writableDatabase.delete(str3, sb.toString(), new String[]{String.valueOf(str2)});
                aVar = this.f3359d;
            } catch (Throwable unused) {
                aVar = this.f3359d;
            }
            aVar.mo11784a(writableDatabase);
        } else {
            Logger.m3833a("UTSqliteLogStore", "db is null");
        }
    }

    /* renamed from: a */
    public void mo11778a(int i) {
        if (i > 0) {
            SQLiteDatabase writableDatabase = this.f3359d.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.execSQL(String.format(this.f3358c, new Object[]{Integer.valueOf(i)}));
                } catch (Throwable unused) {
                }
                this.f3359d.mo11784a(writableDatabase);
            } else {
                Logger.m3833a("UTSqliteLogStore", "db is null");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3765a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }
}
