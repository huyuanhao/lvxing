package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.Util;
import com.tencent.stat.event.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.stat.e */
public class C7614e {
    /* renamed from: c */
    static volatile int f25723c = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static StatLogger f25724i = StatCommonHelper.getLogger();
    /* renamed from: j */
    private static Context f25725j = null;
    /* renamed from: l */
    private static C7614e f25726l = null;
    /* renamed from: a */
    volatile int f25727a;
    /* renamed from: b */
    DeviceInfo f25728b;
    /* renamed from: d */
    private C7622a f25729d = null;
    /* renamed from: e */
    private C7622a f25730e = null;
    /* renamed from: f */
    private Handler f25731f = null;
    /* renamed from: g */
    private String f25732g;
    /* renamed from: h */
    private String f25733h;
    /* renamed from: k */
    private long f25734k;
    /* renamed from: m */
    private int f25735m;
    /* renamed from: n */
    private ConcurrentHashMap<Event, String> f25736n;
    /* renamed from: o */
    private boolean f25737o;
    /* renamed from: p */
    private HashMap<String, String> f25738p;

    /* renamed from: com.tencent.stat.e$a */
    static class C7622a extends SQLiteOpenHelper {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f25761a = "";
        /* renamed from: b */
        private Context f25762b = null;

        public C7622a(Context context, String str) {
            super(context, str, null, 3);
            this.f25761a = str;
            this.f25762b = context;
            if (StatConfig.isDebugEnable()) {
                StatLogger f = C7614e.f25724i;
                StringBuilder sb = new StringBuilder();
                sb.append("SQLiteOpenHelper ");
                sb.append(this.f25761a);
                f.mo37108i(sb.toString());
            }
        }

        public synchronized void close() {
            super.close();
        }

        /* renamed from: a */
        public boolean mo37159a() {
            if (StatConfig.isDebugEnable()) {
                StatLogger f = C7614e.f25724i;
                StringBuilder sb = new StringBuilder();
                sb.append("delete ");
                sb.append(this.f25761a);
                f.mo37116w(sb.toString());
            }
            return this.f25762b.deleteDatabase(this.f25761a);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
            sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
            sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        private void m32855a(android.database.sqlite.SQLiteDatabase r10) {
            /*
            r9 = this;
            r0 = 0
            java.lang.String r2 = "user"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0045 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x0043 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0033
            java.lang.String r0 = r1.getString(r5)     // Catch:{ all -> 0x0043 }
            r1.getInt(r4)     // Catch:{ all -> 0x0043 }
            r3 = 2
            r1.getString(r3)     // Catch:{ all -> 0x0043 }
            r3 = 3
            r1.getLong(r3)     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = com.tencent.stat.common.Util.encode(r0)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = "uid"
            r2.put(r6, r3)     // Catch:{ all -> 0x0043 }
        L_0x0033:
            if (r0 == 0) goto L_0x0040
            java.lang.String r3 = "user"
            java.lang.String r6 = "uid=?"
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0043 }
            r4[r5] = r0     // Catch:{ all -> 0x0043 }
            r10.update(r3, r2, r6, r4)     // Catch:{ all -> 0x0043 }
        L_0x0040:
            if (r1 == 0) goto L_0x0053
            goto L_0x0050
        L_0x0043:
            r10 = move-exception
            goto L_0x0047
        L_0x0045:
            r10 = move-exception
            r1 = r0
        L_0x0047:
            com.tencent.stat.common.StatLogger r0 = com.tencent.stat.C7614e.f25724i     // Catch:{ all -> 0x0054 }
            r0.mo37104e(r10)     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0053
        L_0x0050:
            r1.close()
        L_0x0053:
            return
        L_0x0054:
            r10 = move-exception
            if (r1 == 0) goto L_0x005a
            r1.close()
        L_0x005a:
            throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.C7622a.m32855a(android.database.sqlite.SQLiteDatabase):void");
        }

        /* renamed from: b */
        private void m32856b(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.query("events", null, null, null, null, null, null);
                ArrayList<C7623b> arrayList = new ArrayList<>();
                while (cursor.moveToNext()) {
                    C7623b bVar = new C7623b(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
                    arrayList.add(bVar);
                }
                ContentValues contentValues = new ContentValues();
                for (C7623b bVar2 : arrayList) {
                    contentValues.put(MessageKey.MSG_CONTENT, Util.encode(bVar2.f25764b));
                    sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(bVar2.f25763a)});
                }
                if (cursor == null) {
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            StatLogger f = C7614e.f25724i;
            StringBuilder sb = new StringBuilder();
            sb.append("upgrade DB from oldVersion ");
            sb.append(i);
            sb.append(" to newVersion ");
            sb.append(i2);
            f.debug(sb.toString());
            if (i == 1) {
                sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
                m32855a(sQLiteDatabase);
                m32856b(sQLiteDatabase);
            }
            if (i == 2) {
                m32855a(sQLiteDatabase);
                m32856b(sQLiteDatabase);
            }
        }
    }

    /* renamed from: com.tencent.stat.e$b */
    static class C7623b {
        /* renamed from: a */
        long f25763a;
        /* renamed from: b */
        String f25764b;
        /* renamed from: c */
        int f25765c;
        /* renamed from: d */
        int f25766d;

        public C7623b(long j, String str, int i, int i2) {
            this.f25763a = j;
            this.f25764b = str;
            this.f25765c = i;
            this.f25766d = i2;
        }

        public String toString() {
            return this.f25764b;
        }
    }

    /* renamed from: a */
    public int mo37143a() {
        return this.f25727a;
    }

    /* renamed from: g */
    private void m32838g() {
        String str = ", and create new one";
        String str2 = "delete ";
        if (!m32826a(false)) {
            StatLogger statLogger = f25724i;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(this.f25729d.f25761a);
            sb.append(str);
            statLogger.warn(sb.toString());
            this.f25729d.mo37159a();
            this.f25729d = new C7622a(f25725j, this.f25732g);
        }
        if (!m32826a(true)) {
            StatLogger statLogger2 = f25724i;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f25730e.f25761a);
            sb2.append(str);
            statLogger2.warn(sb2.toString());
            this.f25730e.mo37159a();
            this.f25730e = new C7622a(f25725j, this.f25733h);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00de */
    /* renamed from: a */
    private boolean m32826a(boolean r15) {
        /*
        r14 = this;
        java.lang.String r0 = "events"
        java.lang.String r1 = "test"
        r2 = 0
        r3 = 0
        r4 = 1
        android.database.sqlite.SQLiteDatabase r15 = r14.m32835d(r15)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r5.<init>()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r6 = "content"
        r5.put(r6, r1)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r6 = "send_count"
        java.lang.String r7 = "100"
        r5.put(r6, r7)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r6 = "status"
        java.lang.String r7 = java.lang.Integer.toString(r4)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r5.put(r6, r7)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r6 = "timestamp"
        long r7 = java.lang.System.currentTimeMillis()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r5.put(r6, r7)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r15.insert(r0, r3, r5)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r15.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r15.endTransaction()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r5 = "content = ?"
        java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        int r0 = r15.delete(r0, r5, r6)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r6 = "events"
        r7 = 0
        java.lang.String r8 = "content=?"
        java.lang.String[] r9 = new java.lang.String[]{r1}     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r10 = 0
        r11 = 0
        r12 = 0
        java.lang.String r13 = "1"
        r5 = r15
        android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        int r1 = r3.getCount()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r3.close()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        boolean r5 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        if (r5 == 0) goto L_0x0086
        com.tencent.stat.common.StatLogger r5 = f25724i     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r6.<init>()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r7 = "delNum="
        r6.append(r7)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r6.append(r0)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r7 = ",queryNum="
        r6.append(r7)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r6.append(r1)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r6 = r6.toString()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r5.mo37108i(r6)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
    L_0x0086:
        if (r0 == 0) goto L_0x00c2
        if (r1 > 0) goto L_0x00c2
        boolean r0 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        if (r0 == 0) goto L_0x00b7
        java.lang.String r15 = r15.getPath()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r0 = "/"
        java.lang.String[] r15 = r15.split(r0)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        int r0 = r15.length     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        if (r0 <= 0) goto L_0x00b7
        com.tencent.stat.common.StatLogger r0 = f25724i     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r1.<init>()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r5 = "test db passed, db name:"
        r1.append(r5)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        int r5 = r15.length     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        int r5 = r5 - r4
        r15 = r15[r5]     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r1.append(r15)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r15 = r1.toString()     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        r0.mo37108i(r15)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
    L_0x00b7:
        if (r3 == 0) goto L_0x00f2
        r3.close()     // Catch:{ all -> 0x00bd }
        goto L_0x00f2
    L_0x00bd:
        r15 = move-exception
        r15.printStackTrace()
        goto L_0x00f2
    L_0x00c2:
        android.database.SQLException r15 = new android.database.SQLException     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        java.lang.String r0 = "test delete error."
        r15.<init>(r0)     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
        throw r15     // Catch:{ SQLiteFullException -> 0x00de, Exception -> 0x00cc }
    L_0x00ca:
        r15 = move-exception
        goto L_0x00f3
    L_0x00cc:
        r15 = move-exception
        com.tencent.stat.common.StatLogger r0 = f25724i     // Catch:{ all -> 0x00ca }
        r0.mo37104e(r15)     // Catch:{ all -> 0x00ca }
        if (r3 == 0) goto L_0x00dc
        r3.close()     // Catch:{ all -> 0x00d8 }
        goto L_0x00dc
    L_0x00d8:
        r15 = move-exception
        r15.printStackTrace()
    L_0x00dc:
        r4 = 0
        goto L_0x00f2
    L_0x00de:
        com.tencent.stat.common.StatLogger r15 = f25724i     // Catch:{ all -> 0x00ca }
        java.lang.String r0 = "db is full, change to INSTANT"
        r15.warn(r0)     // Catch:{ all -> 0x00ca }
        com.tencent.stat.StatConfig.setReportEventsByOrder(r2)     // Catch:{ all -> 0x00ca }
        com.tencent.stat.StatReportStrategy r15 = com.tencent.stat.StatReportStrategy.INSTANT     // Catch:{ all -> 0x00ca }
        com.tencent.stat.StatConfig.setStatSendStrategy(r15)     // Catch:{ all -> 0x00ca }
        if (r3 == 0) goto L_0x00f2
        r3.close()     // Catch:{ all -> 0x00bd }
    L_0x00f2:
        return r4
    L_0x00f3:
        if (r3 == 0) goto L_0x00fd
        r3.close()     // Catch:{ all -> 0x00f9 }
        goto L_0x00fd
    L_0x00f9:
        r0 = move-exception
        r0.printStackTrace()
    L_0x00fd:
        throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32826a(boolean):boolean");
    }

    private C7614e(Context context) {
        String str = "";
        this.f25732g = str;
        this.f25733h = str;
        this.f25727a = 0;
        this.f25728b = null;
        this.f25734k = 307200;
        this.f25735m = 0;
        this.f25736n = null;
        this.f25737o = false;
        this.f25738p = new HashMap<>();
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            this.f25731f = new Handler(handlerThread.getLooper());
            if (context.getApplicationContext() != null) {
                f25725j = context.getApplicationContext();
            } else {
                f25725j = context;
            }
            this.f25736n = new ConcurrentHashMap<>();
            this.f25732g = StatCommonHelper.getDatabaseName(context);
            StringBuilder sb = new StringBuilder();
            sb.append("pri_");
            sb.append(StatCommonHelper.getDatabaseName(context));
            this.f25733h = sb.toString();
            this.f25729d = new C7622a(f25725j, this.f25732g);
            this.f25730e = new C7622a(f25725j, this.f25733h);
            m32838g();
            m32832b(true);
            m32832b(false);
            m32839h();
            mo37149b(f25725j);
            mo37152e();
            m32843l();
        } catch (Throwable th) {
            f25724i.mo37104e(th);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:26|27|29|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|21|22|37) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0081 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0096 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a9 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[SYNTHETIC, Splitter:B:18:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x0081=Splitter:B:10:0x0081, B:21:0x0096=Splitter:B:21:0x0096} */
    /* renamed from: b */
    private void m32832b(boolean r8) {
        /*
        r7 = this;
        android.database.sqlite.SQLiteDatabase r8 = r7.m32835d(r8)     // Catch:{ all -> 0x0087 }
        r8.beginTransaction()     // Catch:{ all -> 0x0085 }
        android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ all -> 0x0085 }
        r0.<init>()     // Catch:{ all -> 0x0085 }
        java.lang.String r1 = "status"
        r2 = 1
        java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0085 }
        r0.put(r1, r3)     // Catch:{ all -> 0x0085 }
        java.lang.String r1 = "events"
        java.lang.String r3 = "status=?"
        java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x0085 }
        r4 = 0
        r5 = 2
        java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ all -> 0x0085 }
        r2[r4] = r5     // Catch:{ all -> 0x0085 }
        int r0 = r8.update(r1, r0, r3, r2)     // Catch:{ all -> 0x0085 }
        boolean r1 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x0085 }
        if (r1 == 0) goto L_0x004a
        com.tencent.stat.common.StatLogger r1 = f25724i     // Catch:{ all -> 0x0085 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
        r2.<init>()     // Catch:{ all -> 0x0085 }
        java.lang.String r3 = "update "
        r2.append(r3)     // Catch:{ all -> 0x0085 }
        r2.append(r0)     // Catch:{ all -> 0x0085 }
        java.lang.String r0 = " unsent events."
        r2.append(r0)     // Catch:{ all -> 0x0085 }
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0085 }
        r1.mo37108i(r0)     // Catch:{ all -> 0x0085 }
    L_0x004a:
        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0085 }
        r2 = 1000(0x3e8, double:4.94E-321)
        long r0 = r0 / r2
        long r2 = com.tencent.stat.StatConfig.f25375t     // Catch:{ all -> 0x0085 }
        r4 = 24
        long r2 = r2 * r4
        r4 = 60
        long r2 = r2 * r4
        long r2 = r2 * r4
        long r0 = r0 - r2
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
        r2.<init>()     // Catch:{ all -> 0x0085 }
        java.lang.String r3 = "delete from events where timestamp<"
        r2.append(r3)     // Catch:{ all -> 0x0085 }
        r2.append(r0)     // Catch:{ all -> 0x0085 }
        java.lang.String r0 = "  or length(content) >"
        r2.append(r0)     // Catch:{ all -> 0x0085 }
        long r0 = r7.f25734k     // Catch:{ all -> 0x0085 }
        r2.append(r0)     // Catch:{ all -> 0x0085 }
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0085 }
        r8.execSQL(r0)     // Catch:{ all -> 0x0085 }
        if (r8 == 0) goto L_0x009f
        r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x0081 }
    L_0x0081:
        r8.endTransaction()     // Catch:{ all -> 0x0094 }
        goto L_0x009f
    L_0x0085:
        r0 = move-exception
        goto L_0x0089
    L_0x0087:
        r0 = move-exception
        r8 = 0
    L_0x0089:
        com.tencent.stat.common.StatLogger r1 = f25724i     // Catch:{ all -> 0x00a0 }
        r1.mo37104e(r0)     // Catch:{ all -> 0x00a0 }
        if (r8 == 0) goto L_0x009f
        r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x0096 }
        goto L_0x0096
    L_0x0094:
        r8 = move-exception
        goto L_0x009a
    L_0x0096:
        r8.endTransaction()     // Catch:{ all -> 0x0094 }
        goto L_0x009f
    L_0x009a:
        com.tencent.stat.common.StatLogger r0 = f25724i
        r0.mo37104e(r8)
    L_0x009f:
        return
    L_0x00a0:
        r0 = move-exception
        if (r8 == 0) goto L_0x00b2
        r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x00a9 }
        goto L_0x00a9
    L_0x00a7:
        r8 = move-exception
        goto L_0x00ad
    L_0x00a9:
        r8.endTransaction()     // Catch:{ all -> 0x00a7 }
        goto L_0x00b2
    L_0x00ad:
        com.tencent.stat.common.StatLogger r1 = f25724i
        r1.mo37104e(r8)
    L_0x00b2:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32832b(boolean):void");
    }

    /* renamed from: a */
    public static C7614e m32812a(Context context) {
        if (f25726l == null) {
            synchronized (C7614e.class) {
                if (f25726l == null) {
                    f25726l = new C7614e(context);
                }
            }
        }
        return f25726l;
    }

    /* renamed from: b */
    public static C7614e m32827b() {
        return f25726l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo37150c() {
        m32831b(new ArrayList(200), 100, false);
        C7608d.m32797b(f25725j).mo37133b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x021a A[Catch:{ all -> 0x0213, all -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0221 A[Catch:{ all -> 0x0213, all -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02d6 A[SYNTHETIC, Splitter:B:129:0x02d6] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0191 A[Catch:{ all -> 0x02c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01b2 A[Catch:{ all -> 0x02c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01fe A[SYNTHETIC, Splitter:B:92:0x01fe] */
    /* renamed from: b */
    public com.tencent.stat.common.DeviceInfo mo37149b(android.content.Context r28) {
        /*
        r27 = this;
        r7 = r27
        r0 = r28
        com.tencent.stat.common.DeviceInfo r1 = r7.f25728b
        if (r1 == 0) goto L_0x0009
        return r1
    L_0x0009:
        boolean r1 = r27.m32834c(r28)
        java.lang.String r8 = "ts"
        java.lang.String r9 = "app_ver"
        java.lang.String r10 = "user_type"
        java.lang.String r11 = "uid"
        java.lang.String r12 = ","
        r14 = 1000(0x3e8, double:4.94E-321)
        r5 = 0
        r6 = 1
        if (r1 == 0) goto L_0x00dc
        boolean r1 = com.tencent.stat.StatConfig.isDebugEnable()
        if (r1 == 0) goto L_0x002a
        com.tencent.stat.common.StatLogger r1 = f25724i
        java.lang.String r3 = "try to load user info from sp."
        r1.mo37108i(r3)
    L_0x002a:
        java.lang.String r1 = r7.m32813a(r11)
        java.lang.String r3 = ""
        java.lang.String r1 = com.tencent.stat.common.StatPreferences.getString(r0, r1, r3)
        java.lang.String r4 = com.tencent.stat.common.Util.decode(r1)
        java.lang.String r10 = r7.m32813a(r10)
        int r10 = com.tencent.stat.common.StatPreferences.getInt(r0, r10, r6)
        java.lang.String r9 = r7.m32813a(r9)
        java.lang.String r3 = com.tencent.stat.common.StatPreferences.getString(r0, r9, r3)
        java.lang.String r8 = r7.m32813a(r8)
        r9 = r3
        r2 = 0
        long r2 = com.tencent.stat.common.StatPreferences.getLong(r0, r8, r2)
        long r17 = java.lang.System.currentTimeMillis()
        long r17 = r17 / r14
        if (r10 == r6) goto L_0x006f
        long r2 = r2 * r14
        java.lang.String r2 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r2)
        long r14 = r14 * r17
        java.lang.String r3 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r14)
        boolean r2 = r2.equals(r3)
        if (r2 != 0) goto L_0x006f
        r2 = 1
        goto L_0x0070
    L_0x006f:
        r2 = r10
    L_0x0070:
        java.lang.String r3 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r28)
        boolean r3 = r9.equals(r3)
        if (r3 != 0) goto L_0x007c
        r2 = r2 | 2
    L_0x007c:
        r8 = r2
        if (r4 == 0) goto L_0x0084
        java.lang.String[] r2 = r4.split(r12)
        goto L_0x0085
    L_0x0084:
        r2 = 0
    L_0x0085:
        if (r2 == 0) goto L_0x008d
        int r3 = r2.length
        if (r3 <= 0) goto L_0x008d
        r3 = r2[r5]
        goto L_0x0093
    L_0x008d:
        java.lang.String r4 = com.tencent.stat.common.StatCommonHelper.getUserID(r28)
        r3 = r4
        r5 = 1
    L_0x0093:
        if (r2 == 0) goto L_0x00ae
        int r9 = r2.length
        r11 = 2
        if (r9 < r11) goto L_0x00ae
        r13 = r2[r6]
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r3)
        r2.append(r12)
        r2.append(r13)
        java.lang.String r4 = r2.toString()
        goto L_0x00af
    L_0x00ae:
        r13 = 0
    L_0x00af:
        com.tencent.stat.common.DeviceInfo r2 = new com.tencent.stat.common.DeviceInfo
        r2.m53613init(r3, r13, r8)
        r7.f25728b = r2
        java.lang.String r9 = com.tencent.stat.common.Util.encode(r4)
        if (r5 == 0) goto L_0x00cd
        boolean r1 = r9.equals(r1)
        if (r1 == 0) goto L_0x00cd
        r1 = r27
        r2 = r28
        r3 = r9
        r4 = r8
        r5 = r17
        r1.m32816a(r2, r3, r4, r5)
    L_0x00cd:
        if (r8 == r10) goto L_0x02e9
        r1 = r27
        r2 = r28
        r3 = r9
        r4 = r8
        r5 = r17
        r1.m32816a(r2, r3, r4, r5)
        goto L_0x02e9
    L_0x00dc:
        com.tencent.stat.e$a r1 = r7.f25729d     // Catch:{ all -> 0x02cc }
        android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x02cc }
        r1.beginTransaction()     // Catch:{ all -> 0x02cc }
        boolean r1 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x02cc }
        if (r1 == 0) goto L_0x00f7
        com.tencent.stat.common.StatLogger r1 = f25724i     // Catch:{ all -> 0x00f3 }
        java.lang.String r2 = "try to load user info from db."
        r1.mo37108i(r2)     // Catch:{ all -> 0x00f3 }
        goto L_0x00f7
    L_0x00f3:
        r0 = move-exception
        r13 = 0
        goto L_0x02cf
    L_0x00f7:
        com.tencent.stat.e$a r1 = r7.f25729d     // Catch:{ all -> 0x02cc }
        android.database.sqlite.SQLiteDatabase r17 = r1.getReadableDatabase()     // Catch:{ all -> 0x02cc }
        java.lang.String r18 = "user"
        r19 = 0
        r20 = 0
        r21 = 0
        r22 = 0
        r23 = 0
        r24 = 0
        r25 = 0
        android.database.Cursor r4 = r17.query(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x02cc }
        boolean r1 = r4.moveToNext()     // Catch:{ all -> 0x02c9 }
        java.lang.String r3 = "user"
        if (r1 == 0) goto L_0x023e
        java.lang.String r1 = r4.getString(r5)     // Catch:{ all -> 0x02c9 }
        java.lang.String r2 = com.tencent.stat.common.Util.decode(r1)     // Catch:{ all -> 0x02c9 }
        int r13 = r4.getInt(r6)     // Catch:{ all -> 0x02c9 }
        r5 = 2
        java.lang.String r6 = r4.getString(r5)     // Catch:{ all -> 0x02c9 }
        r5 = 3
        long r20 = r4.getLong(r5)     // Catch:{ all -> 0x02c9 }
        long r22 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c9 }
        long r22 = r22 / r14
        r5 = 1
        if (r13 == r5) goto L_0x014c
        long r20 = r20 * r14
        java.lang.String r5 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r20)     // Catch:{ all -> 0x02c9 }
        long r20 = r22 * r14
        java.lang.String r14 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r20)     // Catch:{ all -> 0x02c9 }
        boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x02c9 }
        if (r5 != 0) goto L_0x014c
        r5 = 1
        goto L_0x014d
    L_0x014c:
        r5 = r13
    L_0x014d:
        java.lang.String r14 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r28)     // Catch:{ all -> 0x02c9 }
        boolean r6 = r6.equals(r14)     // Catch:{ all -> 0x02c9 }
        if (r6 != 0) goto L_0x0159
        r5 = r5 | 2
    L_0x0159:
        if (r2 == 0) goto L_0x0160
        java.lang.String[] r6 = r2.split(r12)     // Catch:{ all -> 0x02c9 }
        goto L_0x0161
    L_0x0160:
        r6 = 0
    L_0x0161:
        if (r6 == 0) goto L_0x0189
        int r14 = r6.length     // Catch:{ all -> 0x02c9 }
        if (r14 <= 0) goto L_0x0189
        r14 = 0
        r15 = r6[r14]     // Catch:{ all -> 0x02c9 }
        if (r15 == 0) goto L_0x0176
        int r14 = r15.length()     // Catch:{ all -> 0x02c9 }
        r0 = 11
        if (r14 >= r0) goto L_0x0174
        goto L_0x0176
    L_0x0174:
        r0 = 0
        goto L_0x018f
    L_0x0176:
        java.lang.String r0 = com.tencent.stat.common.Util.getDeviceID(r28)     // Catch:{ all -> 0x02c9 }
        if (r0 == 0) goto L_0x0174
        int r14 = r0.length()     // Catch:{ all -> 0x02c9 }
        r20 = r0
        r0 = 10
        if (r14 <= r0) goto L_0x0174
        r15 = r20
        goto L_0x018e
    L_0x0189:
        java.lang.String r2 = com.tencent.stat.common.StatCommonHelper.getUserID(r28)     // Catch:{ all -> 0x02c9 }
        r15 = r2
    L_0x018e:
        r0 = 1
    L_0x018f:
        if (r6 == 0) goto L_0x01b2
        int r14 = r6.length     // Catch:{ all -> 0x02c9 }
        r20 = r0
        r0 = 2
        if (r14 < r0) goto L_0x01b4
        r0 = 1
        r2 = r6[r0]     // Catch:{ all -> 0x02c9 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c9 }
        r0.<init>()     // Catch:{ all -> 0x02c9 }
        r0.append(r15)     // Catch:{ all -> 0x02c9 }
        r0.append(r12)     // Catch:{ all -> 0x02c9 }
        r0.append(r2)     // Catch:{ all -> 0x02c9 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02c9 }
        r26 = r2
        r2 = r0
        r0 = r26
        goto L_0x01d4
    L_0x01b2:
        r20 = r0
    L_0x01b4:
        java.lang.String r0 = com.tencent.stat.common.StatCommonHelper.getMacId(r28)     // Catch:{ all -> 0x02c9 }
        if (r0 == 0) goto L_0x01d4
        int r6 = r0.length()     // Catch:{ all -> 0x02c9 }
        if (r6 <= 0) goto L_0x01d4
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c9 }
        r2.<init>()     // Catch:{ all -> 0x02c9 }
        r2.append(r15)     // Catch:{ all -> 0x02c9 }
        r2.append(r12)     // Catch:{ all -> 0x02c9 }
        r2.append(r0)     // Catch:{ all -> 0x02c9 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02c9 }
        r20 = 1
    L_0x01d4:
        com.tencent.stat.common.DeviceInfo r6 = new com.tencent.stat.common.DeviceInfo     // Catch:{ all -> 0x02c9 }
        r6.m53613init(r15, r0, r5)     // Catch:{ all -> 0x02c9 }
        r7.f25728b = r6     // Catch:{ all -> 0x02c9 }
        android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ all -> 0x02c9 }
        r0.<init>()     // Catch:{ all -> 0x02c9 }
        java.lang.String r6 = com.tencent.stat.common.Util.encode(r2)     // Catch:{ all -> 0x02c9 }
        r0.put(r11, r6)     // Catch:{ all -> 0x02c9 }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x02c9 }
        r0.put(r10, r2)     // Catch:{ all -> 0x02c9 }
        java.lang.String r2 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r28)     // Catch:{ all -> 0x02c9 }
        r0.put(r9, r2)     // Catch:{ all -> 0x02c9 }
        java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x02c9 }
        r0.put(r8, r2)     // Catch:{ all -> 0x02c9 }
        if (r20 == 0) goto L_0x021a
        com.tencent.stat.e$a r2 = r7.f25729d     // Catch:{ all -> 0x0213 }
        android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ all -> 0x0213 }
        java.lang.String r14 = "uid=?"
        r16 = r4
        r15 = 1
        java.lang.String[] r4 = new java.lang.String[r15]     // Catch:{ all -> 0x022c }
        r18 = 0
        r4[r18] = r1     // Catch:{ all -> 0x022c }
        r2.update(r3, r0, r14, r4)     // Catch:{ all -> 0x022c }
        goto L_0x021f
    L_0x0213:
        r0 = move-exception
        r16 = r4
    L_0x0216:
        r13 = r16
        goto L_0x02cf
    L_0x021a:
        r16 = r4
        r15 = 1
        r18 = 0
    L_0x021f:
        if (r5 == r13) goto L_0x022e
        com.tencent.stat.e$a r1 = r7.f25729d     // Catch:{ all -> 0x022c }
        android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x022c }
        r2 = 0
        r1.replace(r3, r2, r0)     // Catch:{ all -> 0x022c }
        goto L_0x022e
    L_0x022c:
        r0 = move-exception
        goto L_0x0216
    L_0x022e:
        r1 = r27
        r2 = r28
        r0 = r3
        r3 = r6
        r13 = r16
        r4 = r5
        r14 = 0
        r5 = r22
        r1.m32816a(r2, r3, r4, r5)     // Catch:{ all -> 0x02c7 }
        goto L_0x0242
    L_0x023e:
        r0 = r3
        r13 = r4
        r14 = 0
        r15 = 0
    L_0x0242:
        if (r15 != 0) goto L_0x02af
        java.lang.String r15 = com.tencent.stat.common.StatCommonHelper.getUserID(r28)     // Catch:{ all -> 0x02c7 }
        java.lang.String r5 = com.tencent.stat.common.StatCommonHelper.getMacId(r28)     // Catch:{ all -> 0x02c7 }
        if (r5 == 0) goto L_0x0267
        int r1 = r5.length()     // Catch:{ all -> 0x02c7 }
        if (r1 <= 0) goto L_0x0267
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c7 }
        r1.<init>()     // Catch:{ all -> 0x02c7 }
        r1.append(r15)     // Catch:{ all -> 0x02c7 }
        r1.append(r12)     // Catch:{ all -> 0x02c7 }
        r1.append(r5)     // Catch:{ all -> 0x02c7 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x02c7 }
        goto L_0x0268
    L_0x0267:
        r1 = r15
    L_0x0268:
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02c7 }
        r18 = 1000(0x3e8, double:4.94E-321)
        long r18 = r2 / r18
        java.lang.String r2 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r28)     // Catch:{ all -> 0x02c7 }
        android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x02c7 }
        r3.<init>()     // Catch:{ all -> 0x02c7 }
        java.lang.String r4 = com.tencent.stat.common.Util.encode(r1)     // Catch:{ all -> 0x02c7 }
        r3.put(r11, r4)     // Catch:{ all -> 0x02c7 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x02c7 }
        r3.put(r10, r1)     // Catch:{ all -> 0x02c7 }
        r3.put(r9, r2)     // Catch:{ all -> 0x02c7 }
        java.lang.Long r1 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x02c7 }
        r3.put(r8, r1)     // Catch:{ all -> 0x02c7 }
        com.tencent.stat.e$a r1 = r7.f25729d     // Catch:{ all -> 0x02c7 }
        android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x02c7 }
        r2 = 0
        r1.insert(r0, r2, r3)     // Catch:{ all -> 0x02c7 }
        r0 = 0
        r1 = r27
        r2 = r28
        r3 = r4
        r4 = r0
        r0 = r5
        r5 = r18
        r1.m32816a(r2, r3, r4, r5)     // Catch:{ all -> 0x02c7 }
        com.tencent.stat.common.DeviceInfo r1 = new com.tencent.stat.common.DeviceInfo     // Catch:{ all -> 0x02c7 }
        r1.m53613init(r15, r0, r14)     // Catch:{ all -> 0x02c7 }
        r7.f25728b = r1     // Catch:{ all -> 0x02c7 }
    L_0x02af:
        com.tencent.stat.e$a r0 = r7.f25729d     // Catch:{ all -> 0x02c7 }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x02c7 }
        r0.setTransactionSuccessful()     // Catch:{ all -> 0x02c7 }
        if (r13 == 0) goto L_0x02bd
        r13.close()     // Catch:{ all -> 0x02e3 }
    L_0x02bd:
        com.tencent.stat.e$a r0 = r7.f25729d     // Catch:{ all -> 0x02e3 }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x02e3 }
        r0.endTransaction()     // Catch:{ all -> 0x02e3 }
        goto L_0x02e9
    L_0x02c7:
        r0 = move-exception
        goto L_0x02cf
    L_0x02c9:
        r0 = move-exception
        r13 = r4
        goto L_0x02cf
    L_0x02cc:
        r0 = move-exception
        r2 = 0
        r13 = r2
    L_0x02cf:
        com.tencent.stat.common.StatLogger r1 = f25724i     // Catch:{ all -> 0x02ec }
        r1.mo37104e(r0)     // Catch:{ all -> 0x02ec }
        if (r13 == 0) goto L_0x02d9
        r13.close()     // Catch:{ all -> 0x02e3 }
    L_0x02d9:
        com.tencent.stat.e$a r0 = r7.f25729d     // Catch:{ all -> 0x02e3 }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x02e3 }
        r0.endTransaction()     // Catch:{ all -> 0x02e3 }
        goto L_0x02e9
    L_0x02e3:
        r0 = move-exception
        com.tencent.stat.common.StatLogger r1 = f25724i
        r1.mo37104e(r0)
    L_0x02e9:
        com.tencent.stat.common.DeviceInfo r0 = r7.f25728b
        return r0
    L_0x02ec:
        r0 = move-exception
        r1 = r0
        if (r13 == 0) goto L_0x02f3
        r13.close()     // Catch:{ all -> 0x02fd }
    L_0x02f3:
        com.tencent.stat.e$a r0 = r7.f25729d     // Catch:{ all -> 0x02fd }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x02fd }
        r0.endTransaction()     // Catch:{ all -> 0x02fd }
        goto L_0x0303
    L_0x02fd:
        r0 = move-exception
        com.tencent.stat.common.StatLogger r2 = f25724i
        r2.mo37104e(r0)
    L_0x0303:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.mo37149b(android.content.Context):com.tencent.stat.common.DeviceInfo");
    }

    /* renamed from: a */
    private String m32813a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(StatConstants.MTA_DB2SP_TAG);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: c */
    private boolean m32834c(Context context) {
        return StatPreferences.contains(context, m32813a(AppEntity.KEY_UID)) || StatPreferences.contains(context, m32813a("user_type")) || StatPreferences.contains(context, m32813a("app_ver")) || StatPreferences.contains(context, m32813a("ts"));
    }

    /* renamed from: a */
    private void m32816a(Context context, String str, int i, long j) {
        StatPreferences.putString(context, m32813a(AppEntity.KEY_UID), str);
        StatPreferences.putInt(context, m32813a("user_type"), i);
        StatPreferences.putString(context, m32813a("app_ver"), StatCommonHelper.getAppVersion(context));
        StatPreferences.putLong(context, m32813a("ts"), j);
    }

    /* renamed from: a */
    private String m32814a(List<C7623b> list) {
        StringBuilder sb = new StringBuilder(list.size() * 3);
        sb.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (C7623b bVar : list) {
            sb.append(bVar.f25763a);
            if (i != size - 1) {
                sb.append(StorageInterface.KEY_SPLITER);
            }
            i++;
        }
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bf, code lost:
            r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r8 = f25724i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dd, code lost:
            r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00de, code lost:
            if (r8 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e4, code lost:
            r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            f25724i.mo37104e(r8);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x00bb, B:36:0x00cc, B:48:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3 A[SYNTHETIC, Splitter:B:39:0x00d3] */
    /* renamed from: a */
    public synchronized void m32825a(java.util.List<com.tencent.stat.C7614e.C7623b> r7, boolean r8) {
        /*
        r6 = this;
        monitor-enter(r6)
        int r0 = r7.size()     // Catch:{ all -> 0x00eb }
        if (r0 != 0) goto L_0x0009
        monitor-exit(r6)
        return
    L_0x0009:
        boolean r0 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x00eb }
        if (r0 == 0) goto L_0x0031
        com.tencent.stat.common.StatLogger r0 = f25724i     // Catch:{ all -> 0x00eb }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
        r1.<init>()     // Catch:{ all -> 0x00eb }
        java.lang.String r2 = "Delete "
        r1.append(r2)     // Catch:{ all -> 0x00eb }
        int r2 = r7.size()     // Catch:{ all -> 0x00eb }
        r1.append(r2)     // Catch:{ all -> 0x00eb }
        java.lang.String r2 = " events, important:"
        r1.append(r2)     // Catch:{ all -> 0x00eb }
        r1.append(r8)     // Catch:{ all -> 0x00eb }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00eb }
        r0.mo37108i(r1)     // Catch:{ all -> 0x00eb }
    L_0x0031:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
        int r1 = r7.size()     // Catch:{ all -> 0x00eb }
        int r1 = r1 * 3
        r0.<init>(r1)     // Catch:{ all -> 0x00eb }
        java.lang.String r1 = "event_id in ("
        r0.append(r1)     // Catch:{ all -> 0x00eb }
        r1 = 0
        int r2 = r7.size()     // Catch:{ all -> 0x00eb }
        java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00eb }
    L_0x004a:
        boolean r3 = r7.hasNext()     // Catch:{ all -> 0x00eb }
        if (r3 == 0) goto L_0x0067
        java.lang.Object r3 = r7.next()     // Catch:{ all -> 0x00eb }
        com.tencent.stat.e$b r3 = (com.tencent.stat.C7614e.C7623b) r3     // Catch:{ all -> 0x00eb }
        long r3 = r3.f25763a     // Catch:{ all -> 0x00eb }
        r0.append(r3)     // Catch:{ all -> 0x00eb }
        int r3 = r2 + -1
        if (r1 == r3) goto L_0x0064
        java.lang.String r3 = ","
        r0.append(r3)     // Catch:{ all -> 0x00eb }
    L_0x0064:
        int r1 = r1 + 1
        goto L_0x004a
    L_0x0067:
        java.lang.String r7 = ")"
        r0.append(r7)     // Catch:{ all -> 0x00eb }
        r7 = 0
        android.database.sqlite.SQLiteDatabase r8 = r6.m32835d(r8)     // Catch:{ all -> 0x00c8 }
        r8.beginTransaction()     // Catch:{ all -> 0x00c6 }
        java.lang.String r1 = "events"
        java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x00c6 }
        int r7 = r8.delete(r1, r3, r7)     // Catch:{ all -> 0x00c6 }
        boolean r1 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x00c6 }
        if (r1 == 0) goto L_0x00ae
        com.tencent.stat.common.StatLogger r1 = f25724i     // Catch:{ all -> 0x00c6 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
        r3.<init>()     // Catch:{ all -> 0x00c6 }
        java.lang.String r4 = "delete "
        r3.append(r4)     // Catch:{ all -> 0x00c6 }
        r3.append(r2)     // Catch:{ all -> 0x00c6 }
        java.lang.String r2 = " event "
        r3.append(r2)     // Catch:{ all -> 0x00c6 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c6 }
        r3.append(r0)     // Catch:{ all -> 0x00c6 }
        java.lang.String r0 = ", success delete:"
        r3.append(r0)     // Catch:{ all -> 0x00c6 }
        r3.append(r7)     // Catch:{ all -> 0x00c6 }
        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00c6 }
        r1.mo37108i(r0)     // Catch:{ all -> 0x00c6 }
    L_0x00ae:
        int r0 = r6.f25727a     // Catch:{ all -> 0x00c6 }
        int r0 = r0 - r7
        r6.f25727a = r0     // Catch:{ all -> 0x00c6 }
        r8.setTransactionSuccessful()     // Catch:{ all -> 0x00c6 }
        r6.m32839h()     // Catch:{ all -> 0x00c6 }
        if (r8 == 0) goto L_0x00db
        r8.endTransaction()     // Catch:{ all -> 0x00bf }
        goto L_0x00db
    L_0x00bf:
        r7 = move-exception
        com.tencent.stat.common.StatLogger r8 = f25724i     // Catch:{ all -> 0x00eb }
    L_0x00c2:
        r8.mo37104e(r7)     // Catch:{ all -> 0x00eb }
        goto L_0x00db
    L_0x00c6:
        r7 = move-exception
        goto L_0x00cc
    L_0x00c8:
        r8 = move-exception
        r5 = r8
        r8 = r7
        r7 = r5
    L_0x00cc:
        com.tencent.stat.common.StatLogger r0 = f25724i     // Catch:{ all -> 0x00dd }
        r0.mo37104e(r7)     // Catch:{ all -> 0x00dd }
        if (r8 == 0) goto L_0x00db
        r8.endTransaction()     // Catch:{ all -> 0x00d7 }
        goto L_0x00db
    L_0x00d7:
        r7 = move-exception
        com.tencent.stat.common.StatLogger r8 = f25724i     // Catch:{ all -> 0x00eb }
        goto L_0x00c2
    L_0x00db:
        monitor-exit(r6)
        return
    L_0x00dd:
        r7 = move-exception
        if (r8 == 0) goto L_0x00ea
        r8.endTransaction()     // Catch:{ all -> 0x00e4 }
        goto L_0x00ea
    L_0x00e4:
        r8 = move-exception
        com.tencent.stat.common.StatLogger r0 = f25724i     // Catch:{ all -> 0x00eb }
        r0.mo37104e(r8)     // Catch:{ all -> 0x00eb }
    L_0x00ea:
        throw r7     // Catch:{ all -> 0x00eb }
    L_0x00eb:
        r7 = move-exception
        monitor-exit(r6)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32825a(java.util.List, boolean):void");
    }

    /* renamed from: c */
    private int m32833c(boolean z) {
        if (!z) {
            return StatConfig.getMaxSendRetryCount();
        }
        return StatConfig.getMaxImportantDataSendRetryCount();
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b6, code lost:
            r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r6 = f25724i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d2, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d3, code lost:
            if (r7 != null) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            r7.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d9, code lost:
            r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            f25724i.mo37104e(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x00b2, B:36:0x00c1, B:48:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8 A[SYNTHETIC, Splitter:B:39:0x00c8] */
    /* renamed from: a */
    public synchronized void m32824a(java.util.List<com.tencent.stat.C7614e.C7623b> r5, int r6, boolean r7) {
        /*
        r4 = this;
        monitor-enter(r4)
        int r0 = r5.size()     // Catch:{ all -> 0x00e0 }
        if (r0 != 0) goto L_0x0009
        monitor-exit(r4)
        return
    L_0x0009:
        int r0 = r4.m32833c(r7)     // Catch:{ all -> 0x00e0 }
        r1 = 0
        android.database.sqlite.SQLiteDatabase r7 = r4.m32835d(r7)     // Catch:{ all -> 0x00bf }
        r2 = 2
        if (r6 != r2) goto L_0x0033
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
        r0.<init>()     // Catch:{ all -> 0x00bd }
        java.lang.String r2 = "update events set status="
        r0.append(r2)     // Catch:{ all -> 0x00bd }
        r0.append(r6)     // Catch:{ all -> 0x00bd }
        java.lang.String r6 = ", send_count=send_count+1  where "
        r0.append(r6)     // Catch:{ all -> 0x00bd }
        java.lang.String r5 = r4.m32814a(r5)     // Catch:{ all -> 0x00bd }
        r0.append(r5)     // Catch:{ all -> 0x00bd }
        java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x00bd }
        goto L_0x006d
    L_0x0033:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
        r2.<init>()     // Catch:{ all -> 0x00bd }
        java.lang.String r3 = "update events set status="
        r2.append(r3)     // Catch:{ all -> 0x00bd }
        r2.append(r6)     // Catch:{ all -> 0x00bd }
        java.lang.String r6 = " where "
        r2.append(r6)     // Catch:{ all -> 0x00bd }
        java.lang.String r5 = r4.m32814a(r5)     // Catch:{ all -> 0x00bd }
        r2.append(r5)     // Catch:{ all -> 0x00bd }
        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x00bd }
        int r6 = r4.f25735m     // Catch:{ all -> 0x00bd }
        int r6 = r6 % 3
        if (r6 != 0) goto L_0x0067
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
        r6.<init>()     // Catch:{ all -> 0x00bd }
        java.lang.String r1 = "delete from events where send_count>"
        r6.append(r1)     // Catch:{ all -> 0x00bd }
        r6.append(r0)     // Catch:{ all -> 0x00bd }
        java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x00bd }
    L_0x0067:
        int r6 = r4.f25735m     // Catch:{ all -> 0x00bd }
        int r6 = r6 + 1
        r4.f25735m = r6     // Catch:{ all -> 0x00bd }
    L_0x006d:
        boolean r6 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x00bd }
        if (r6 == 0) goto L_0x0089
        com.tencent.stat.common.StatLogger r6 = f25724i     // Catch:{ all -> 0x00bd }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
        r0.<init>()     // Catch:{ all -> 0x00bd }
        java.lang.String r2 = "update sql:"
        r0.append(r2)     // Catch:{ all -> 0x00bd }
        r0.append(r5)     // Catch:{ all -> 0x00bd }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00bd }
        r6.mo37108i(r0)     // Catch:{ all -> 0x00bd }
    L_0x0089:
        r7.beginTransaction()     // Catch:{ all -> 0x00bd }
        r7.execSQL(r5)     // Catch:{ all -> 0x00bd }
        if (r1 == 0) goto L_0x00ad
        com.tencent.stat.common.StatLogger r5 = f25724i     // Catch:{ all -> 0x00bd }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
        r6.<init>()     // Catch:{ all -> 0x00bd }
        java.lang.String r0 = "update for delete sql:"
        r6.append(r0)     // Catch:{ all -> 0x00bd }
        r6.append(r1)     // Catch:{ all -> 0x00bd }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00bd }
        r5.mo37108i(r6)     // Catch:{ all -> 0x00bd }
        r7.execSQL(r1)     // Catch:{ all -> 0x00bd }
        r4.m32839h()     // Catch:{ all -> 0x00bd }
    L_0x00ad:
        r7.setTransactionSuccessful()     // Catch:{ all -> 0x00bd }
        if (r7 == 0) goto L_0x00d0
        r7.endTransaction()     // Catch:{ all -> 0x00b6 }
        goto L_0x00d0
    L_0x00b6:
        r5 = move-exception
        com.tencent.stat.common.StatLogger r6 = f25724i     // Catch:{ all -> 0x00e0 }
    L_0x00b9:
        r6.mo37104e(r5)     // Catch:{ all -> 0x00e0 }
        goto L_0x00d0
    L_0x00bd:
        r5 = move-exception
        goto L_0x00c1
    L_0x00bf:
        r5 = move-exception
        r7 = r1
    L_0x00c1:
        com.tencent.stat.common.StatLogger r6 = f25724i     // Catch:{ all -> 0x00d2 }
        r6.mo37104e(r5)     // Catch:{ all -> 0x00d2 }
        if (r7 == 0) goto L_0x00d0
        r7.endTransaction()     // Catch:{ all -> 0x00cc }
        goto L_0x00d0
    L_0x00cc:
        r5 = move-exception
        com.tencent.stat.common.StatLogger r6 = f25724i     // Catch:{ all -> 0x00e0 }
        goto L_0x00b9
    L_0x00d0:
        monitor-exit(r4)
        return
    L_0x00d2:
        r5 = move-exception
        if (r7 == 0) goto L_0x00df
        r7.endTransaction()     // Catch:{ all -> 0x00d9 }
        goto L_0x00df
    L_0x00d9:
        r6 = move-exception
        com.tencent.stat.common.StatLogger r7 = f25724i     // Catch:{ all -> 0x00e0 }
        r7.mo37104e(r6)     // Catch:{ all -> 0x00e0 }
    L_0x00df:
        throw r5     // Catch:{ all -> 0x00e0 }
    L_0x00e0:
        r5 = move-exception
        monitor-exit(r4)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32824a(java.util.List, int, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37147a(List<C7623b> list, int i, boolean z, boolean z2) {
        Handler handler = this.f25731f;
        if (handler != null) {
            final List<C7623b> list2 = list;
            final int i2 = i;
            final boolean z3 = z;
            final boolean z4 = z2;
            C76151 r1 = new Runnable() {
                public void run() {
                    C7614e.this.m32824a(list2, i2, z3);
                    if (z4) {
                        list2.clear();
                    }
                }
            };
            handler.post(r1);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37148a(final List<C7623b> list, final boolean z, final boolean z2) {
        Handler handler = this.f25731f;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    C7614e.this.m32825a(list, z);
                    if (z2) {
                        list.clear();
                    }
                }
            });
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|(2:19|50)(1:49)) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            f25724i.mo37116w("fetch row error, passed.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0087, code lost:
            if (r14 < 40) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0089, code lost:
            r14 = r14 + 1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x007e */
    /* renamed from: b */
    private synchronized void m32831b(java.util.List<com.tencent.stat.C7614e.C7623b> r13, int r14, boolean r15) {
        /*
        r12 = this;
        monitor-enter(r12)
        r0 = 0
        android.database.sqlite.SQLiteDatabase r1 = r12.m32836e(r15)     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = "events"
        r3 = 0
        java.lang.String r4 = "status=?"
        r15 = 1
        java.lang.String[] r5 = new java.lang.String[r15]     // Catch:{ all -> 0x0097 }
        java.lang.String r6 = java.lang.Integer.toString(r15)     // Catch:{ all -> 0x0097 }
        r10 = 0
        r5[r10] = r6     // Catch:{ all -> 0x0097 }
        r6 = 0
        r7 = 0
        r8 = 0
        java.lang.String r9 = java.lang.Integer.toString(r14)     // Catch:{ all -> 0x0097 }
        android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0097 }
    L_0x0020:
        boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x008c
        long r8 = r0.getLong(r10)     // Catch:{ Exception -> 0x007e }
        java.lang.String r1 = r0.getString(r15)     // Catch:{ Exception -> 0x007e }
        boolean r2 = com.tencent.stat.StatConfig.f25362g     // Catch:{ Exception -> 0x007e }
        if (r2 != 0) goto L_0x0036
        java.lang.String r1 = com.tencent.stat.common.Util.decode(r1)     // Catch:{ Exception -> 0x007e }
    L_0x0036:
        r5 = r1
        r1 = 2
        int r6 = r0.getInt(r1)     // Catch:{ Exception -> 0x007e }
        r1 = 3
        int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x007e }
        com.tencent.stat.e$b r11 = new com.tencent.stat.e$b     // Catch:{ Exception -> 0x007e }
        r2 = r11
        r3 = r8
        r7 = r1
        r2.m53660init(r3, r5, r6, r7)     // Catch:{ Exception -> 0x007e }
        boolean r2 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ Exception -> 0x007e }
        if (r2 == 0) goto L_0x007a
        com.tencent.stat.common.StatLogger r2 = f25724i     // Catch:{ Exception -> 0x007e }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007e }
        r3.<init>()     // Catch:{ Exception -> 0x007e }
        java.lang.String r4 = "peek event, id="
        r3.append(r4)     // Catch:{ Exception -> 0x007e }
        r3.append(r8)     // Catch:{ Exception -> 0x007e }
        java.lang.String r4 = ",send_count="
        r3.append(r4)     // Catch:{ Exception -> 0x007e }
        r3.append(r1)     // Catch:{ Exception -> 0x007e }
        java.lang.String r1 = ",timestamp="
        r3.append(r1)     // Catch:{ Exception -> 0x007e }
        r1 = 4
        long r4 = r0.getLong(r1)     // Catch:{ Exception -> 0x007e }
        r3.append(r4)     // Catch:{ Exception -> 0x007e }
        java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x007e }
        r2.mo37108i(r1)     // Catch:{ Exception -> 0x007e }
    L_0x007a:
        r13.add(r11)     // Catch:{ Exception -> 0x007e }
        goto L_0x0020
    L_0x007e:
        com.tencent.stat.common.StatLogger r1 = f25724i     // Catch:{ all -> 0x0097 }
        java.lang.String r2 = "fetch row error, passed."
        r1.mo37116w(r2)     // Catch:{ all -> 0x0097 }
        r1 = 40
        if (r14 >= r1) goto L_0x0020
        int r14 = r14 + 1
        goto L_0x0020
    L_0x008c:
        if (r0 == 0) goto L_0x00a5
        r0.close()     // Catch:{ all -> 0x0092 }
        goto L_0x00a5
    L_0x0092:
        r13 = move-exception
    L_0x0093:
        r13.printStackTrace()     // Catch:{ all -> 0x00b3 }
        goto L_0x00a5
    L_0x0097:
        r13 = move-exception
        com.tencent.stat.common.StatLogger r14 = f25724i     // Catch:{ all -> 0x00a7 }
        r14.mo37104e(r13)     // Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x00a5
        r0.close()     // Catch:{ all -> 0x00a3 }
        goto L_0x00a5
    L_0x00a3:
        r13 = move-exception
        goto L_0x0093
    L_0x00a5:
        monitor-exit(r12)
        return
    L_0x00a7:
        r13 = move-exception
        if (r0 == 0) goto L_0x00b2
        r0.close()     // Catch:{ all -> 0x00ae }
        goto L_0x00b2
    L_0x00ae:
        r14 = move-exception
        r14.printStackTrace()     // Catch:{ all -> 0x00b3 }
    L_0x00b2:
        throw r13     // Catch:{ all -> 0x00b3 }
    L_0x00b3:
        r13 = move-exception
        monitor-exit(r12)
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32831b(java.util.List, int, boolean):void");
    }

    /* renamed from: h */
    private void m32839h() {
        this.f25727a = m32840i() + m32841j();
    }

    /* renamed from: i */
    private int m32840i() {
        try {
            return (int) DatabaseUtils.queryNumEntries(this.f25729d.getReadableDatabase(), "events");
        } catch (Throwable th) {
            f25724i.mo37104e(th);
            return 0;
        }
    }

    /* renamed from: j */
    private int m32841j() {
        try {
            return (int) DatabaseUtils.queryNumEntries(this.f25730e.getReadableDatabase(), "events");
        } catch (Throwable th) {
            f25724i.mo37104e(th);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00de, code lost:
            r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r2 = f25724i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0136, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0137, code lost:
            if (r3 != null) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            r3.endTransaction();
            m32839h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0140, code lost:
            r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            f25724i.mo37104e(r2);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:31:0x00d7, B:40:0x00e9, B:55:0x0139] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0 A[SYNTHETIC, Splitter:B:43:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0104 A[Catch:{ all -> 0x0136, all -> 0x0140, all -> 0x00de }] */
    /* renamed from: k */
    public void m32842k() {
        /*
        r13 = this;
        boolean r0 = r13.f25737o
        if (r0 == 0) goto L_0x0005
        return
    L_0x0005:
        java.util.concurrent.ConcurrentHashMap<com.tencent.stat.event.Event, java.lang.String> r0 = r13.f25736n
        monitor-enter(r0)
        java.util.concurrent.ConcurrentHashMap<com.tencent.stat.event.Event, java.lang.String> r1 = r13.f25736n     // Catch:{ all -> 0x0147 }
        int r1 = r1.size()     // Catch:{ all -> 0x0147 }
        if (r1 != 0) goto L_0x0012
        monitor-exit(r0)     // Catch:{ all -> 0x0147 }
        return
    L_0x0012:
        r1 = 1
        r13.f25737o = r1     // Catch:{ all -> 0x0147 }
        boolean r2 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x0147 }
        if (r2 == 0) goto L_0x004b
        com.tencent.stat.common.StatLogger r2 = f25724i     // Catch:{ all -> 0x0147 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
        r3.<init>()     // Catch:{ all -> 0x0147 }
        java.lang.String r4 = "insert "
        r3.append(r4)     // Catch:{ all -> 0x0147 }
        java.util.concurrent.ConcurrentHashMap<com.tencent.stat.event.Event, java.lang.String> r4 = r13.f25736n     // Catch:{ all -> 0x0147 }
        int r4 = r4.size()     // Catch:{ all -> 0x0147 }
        r3.append(r4)     // Catch:{ all -> 0x0147 }
        java.lang.String r4 = " events ,numEventsCachedInMemory:"
        r3.append(r4)     // Catch:{ all -> 0x0147 }
        int r4 = com.tencent.stat.StatConfig.f25368m     // Catch:{ all -> 0x0147 }
        r3.append(r4)     // Catch:{ all -> 0x0147 }
        java.lang.String r4 = ",numStoredEvents:"
        r3.append(r4)     // Catch:{ all -> 0x0147 }
        int r4 = r13.f25727a     // Catch:{ all -> 0x0147 }
        r3.append(r4)     // Catch:{ all -> 0x0147 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0147 }
        r2.mo37108i(r3)     // Catch:{ all -> 0x0147 }
    L_0x004b:
        r2 = 0
        com.tencent.stat.e$a r3 = r13.f25729d     // Catch:{ all -> 0x00e7 }
        android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ all -> 0x00e7 }
        r3.beginTransaction()     // Catch:{ all -> 0x00e5 }
        java.util.concurrent.ConcurrentHashMap<com.tencent.stat.event.Event, java.lang.String> r4 = r13.f25736n     // Catch:{ all -> 0x00e5 }
        java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x00e5 }
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00e5 }
    L_0x005f:
        boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00e5 }
        if (r5 == 0) goto L_0x00d2
        java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00e5 }
        java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00e5 }
        java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x00e5 }
        com.tencent.stat.event.Event r5 = (com.tencent.stat.event.Event) r5     // Catch:{ all -> 0x00e5 }
        android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x00e5 }
        r6.<init>()     // Catch:{ all -> 0x00e5 }
        java.lang.String r7 = r5.toJsonString()     // Catch:{ all -> 0x00e5 }
        boolean r8 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x00e5 }
        if (r8 == 0) goto L_0x0096
        com.tencent.stat.common.StatLogger r8 = f25724i     // Catch:{ all -> 0x00e5 }
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
        r9.<init>()     // Catch:{ all -> 0x00e5 }
        java.lang.String r10 = "insert content:"
        r9.append(r10)     // Catch:{ all -> 0x00e5 }
        r9.append(r7)     // Catch:{ all -> 0x00e5 }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00e5 }
        r8.mo37108i(r9)     // Catch:{ all -> 0x00e5 }
    L_0x0096:
        java.lang.String r7 = com.tencent.stat.common.Util.encode(r7)     // Catch:{ all -> 0x00e5 }
        if (r7 == 0) goto L_0x00ce
        int r8 = r7.length()     // Catch:{ all -> 0x00e5 }
        long r8 = (long) r8     // Catch:{ all -> 0x00e5 }
        long r10 = r13.f25734k     // Catch:{ all -> 0x00e5 }
        int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
        if (r12 >= 0) goto L_0x00ce
        java.lang.String r8 = "content"
        r6.put(r8, r7)     // Catch:{ all -> 0x00e5 }
        java.lang.String r7 = "send_count"
        java.lang.String r8 = "0"
        r6.put(r7, r8)     // Catch:{ all -> 0x00e5 }
        java.lang.String r7 = "status"
        java.lang.String r8 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x00e5 }
        r6.put(r7, r8)     // Catch:{ all -> 0x00e5 }
        java.lang.String r7 = "timestamp"
        long r8 = r5.getTimestamp()     // Catch:{ all -> 0x00e5 }
        java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00e5 }
        r6.put(r7, r5)     // Catch:{ all -> 0x00e5 }
        java.lang.String r5 = "events"
        r3.insert(r5, r2, r6)     // Catch:{ all -> 0x00e5 }
    L_0x00ce:
        r4.remove()     // Catch:{ all -> 0x00e5 }
        goto L_0x005f
    L_0x00d2:
        r3.setTransactionSuccessful()     // Catch:{ all -> 0x00e5 }
        if (r3 == 0) goto L_0x00fb
        r3.endTransaction()     // Catch:{ all -> 0x00de }
        r13.m32839h()     // Catch:{ all -> 0x00de }
        goto L_0x00fb
    L_0x00de:
        r1 = move-exception
        com.tencent.stat.common.StatLogger r2 = f25724i     // Catch:{ all -> 0x0147 }
    L_0x00e1:
        r2.mo37104e(r1)     // Catch:{ all -> 0x0147 }
        goto L_0x00fb
    L_0x00e5:
        r1 = move-exception
        goto L_0x00e9
    L_0x00e7:
        r1 = move-exception
        r3 = r2
    L_0x00e9:
        com.tencent.stat.common.StatLogger r2 = f25724i     // Catch:{ all -> 0x0136 }
        r2.mo37104e(r1)     // Catch:{ all -> 0x0136 }
        if (r3 == 0) goto L_0x00fb
        r3.endTransaction()     // Catch:{ all -> 0x00f7 }
        r13.m32839h()     // Catch:{ all -> 0x00f7 }
        goto L_0x00fb
    L_0x00f7:
        r1 = move-exception
        com.tencent.stat.common.StatLogger r2 = f25724i     // Catch:{ all -> 0x0147 }
        goto L_0x00e1
    L_0x00fb:
        r1 = 0
        r13.f25737o = r1     // Catch:{ all -> 0x0147 }
        boolean r1 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x0147 }
        if (r1 == 0) goto L_0x0134
        com.tencent.stat.common.StatLogger r1 = f25724i     // Catch:{ all -> 0x0147 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
        r2.<init>()     // Catch:{ all -> 0x0147 }
        java.lang.String r3 = "after insert, cacheEventsInMemory.size():"
        r2.append(r3)     // Catch:{ all -> 0x0147 }
        java.util.concurrent.ConcurrentHashMap<com.tencent.stat.event.Event, java.lang.String> r3 = r13.f25736n     // Catch:{ all -> 0x0147 }
        int r3 = r3.size()     // Catch:{ all -> 0x0147 }
        r2.append(r3)     // Catch:{ all -> 0x0147 }
        java.lang.String r3 = ",numEventsCachedInMemory:"
        r2.append(r3)     // Catch:{ all -> 0x0147 }
        int r3 = com.tencent.stat.StatConfig.f25368m     // Catch:{ all -> 0x0147 }
        r2.append(r3)     // Catch:{ all -> 0x0147 }
        java.lang.String r3 = ",numStoredEvents:"
        r2.append(r3)     // Catch:{ all -> 0x0147 }
        int r3 = r13.f25727a     // Catch:{ all -> 0x0147 }
        r2.append(r3)     // Catch:{ all -> 0x0147 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0147 }
        r1.mo37108i(r2)     // Catch:{ all -> 0x0147 }
    L_0x0134:
        monitor-exit(r0)     // Catch:{ all -> 0x0147 }
        return
    L_0x0136:
        r1 = move-exception
        if (r3 == 0) goto L_0x0146
        r3.endTransaction()     // Catch:{ all -> 0x0140 }
        r13.m32839h()     // Catch:{ all -> 0x0140 }
        goto L_0x0146
    L_0x0140:
        r2 = move-exception
        com.tencent.stat.common.StatLogger r3 = f25724i     // Catch:{ all -> 0x0147 }
        r3.mo37104e(r2)     // Catch:{ all -> 0x0147 }
    L_0x0146:
        throw r1     // Catch:{ all -> 0x0147 }
    L_0x0147:
        r1 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0147 }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32842k():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo37151d() {
        if (StatConfig.isEnableStatService()) {
            try {
                this.f25731f.post(new Runnable() {
                    public void run() {
                        C7614e.this.m32842k();
                    }
                });
            } catch (Throwable th) {
                f25724i.mo37104e(th);
            }
        }
    }

    /* renamed from: d */
    private SQLiteDatabase m32835d(boolean z) {
        if (!z) {
            return this.f25729d.getWritableDatabase();
        }
        return this.f25730e.getWritableDatabase();
    }

    /* renamed from: e */
    private SQLiteDatabase m32836e(boolean z) {
        if (!z) {
            return this.f25729d.getReadableDatabase();
        }
        return this.f25730e.getReadableDatabase();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00aa A[SYNTHETIC, Splitter:B:33:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc  */
    /* renamed from: a */
    private void m32823a(com.tencent.stat.event.Event r13, com.tencent.stat.StatDispatchCallback r14, boolean r15) {
        /*
        r12 = this;
        r0 = 1
        r1 = 0
        r3 = 0
        android.database.sqlite.SQLiteDatabase r4 = r12.m32835d(r15)     // Catch:{ all -> 0x009f }
        r4.beginTransaction()     // Catch:{ all -> 0x009d }
        java.lang.String r5 = "events"
        if (r15 != 0) goto L_0x002f
        int r15 = r12.f25727a     // Catch:{ all -> 0x009d }
        int r6 = com.tencent.stat.StatConfig.getMaxStoreEventCount()     // Catch:{ all -> 0x009d }
        if (r15 <= r6) goto L_0x002f
        com.tencent.stat.common.StatLogger r15 = f25724i     // Catch:{ all -> 0x009d }
        java.lang.String r6 = "Too many events stored in db."
        r15.warn(r6)     // Catch:{ all -> 0x009d }
        int r15 = r12.f25727a     // Catch:{ all -> 0x009d }
        com.tencent.stat.e$a r6 = r12.f25729d     // Catch:{ all -> 0x009d }
        android.database.sqlite.SQLiteDatabase r6 = r6.getWritableDatabase()     // Catch:{ all -> 0x009d }
        java.lang.String r7 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)"
        int r6 = r6.delete(r5, r7, r3)     // Catch:{ all -> 0x009d }
        int r15 = r15 - r6
        r12.f25727a = r15     // Catch:{ all -> 0x009d }
    L_0x002f:
        android.content.ContentValues r15 = new android.content.ContentValues     // Catch:{ all -> 0x009d }
        r15.<init>()     // Catch:{ all -> 0x009d }
        java.lang.String r6 = r13.toJsonString()     // Catch:{ all -> 0x009d }
        boolean r7 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x009d }
        if (r7 == 0) goto L_0x0054
        com.tencent.stat.common.StatLogger r7 = f25724i     // Catch:{ all -> 0x009d }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x009d }
        r8.<init>()     // Catch:{ all -> 0x009d }
        java.lang.String r9 = "insert 1 event, content:"
        r8.append(r9)     // Catch:{ all -> 0x009d }
        r8.append(r6)     // Catch:{ all -> 0x009d }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x009d }
        r7.mo37108i(r8)     // Catch:{ all -> 0x009d }
    L_0x0054:
        java.lang.String r6 = com.tencent.stat.common.Util.encode(r6)     // Catch:{ all -> 0x009d }
        if (r6 == 0) goto L_0x008c
        int r7 = r6.length()     // Catch:{ all -> 0x009d }
        long r7 = (long) r7     // Catch:{ all -> 0x009d }
        long r9 = r12.f25734k     // Catch:{ all -> 0x009d }
        int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
        if (r11 >= 0) goto L_0x008c
        java.lang.String r7 = "content"
        r15.put(r7, r6)     // Catch:{ all -> 0x009d }
        java.lang.String r6 = "send_count"
        java.lang.String r7 = "0"
        r15.put(r6, r7)     // Catch:{ all -> 0x009d }
        java.lang.String r6 = "status"
        java.lang.String r7 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x009d }
        r15.put(r6, r7)     // Catch:{ all -> 0x009d }
        java.lang.String r6 = "timestamp"
        long r7 = r13.getTimestamp()     // Catch:{ all -> 0x009d }
        java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x009d }
        r15.put(r6, r7)     // Catch:{ all -> 0x009d }
        long r5 = r4.insert(r5, r3, r15)     // Catch:{ all -> 0x009d }
        goto L_0x008d
    L_0x008c:
        r5 = r1
    L_0x008d:
        r4.setTransactionSuccessful()     // Catch:{ all -> 0x009d }
        if (r4 == 0) goto L_0x00ad
        r4.endTransaction()     // Catch:{ all -> 0x0096 }
        goto L_0x00ad
    L_0x0096:
        r15 = move-exception
        com.tencent.stat.common.StatLogger r3 = f25724i
        r3.mo37104e(r15)
        goto L_0x00ad
    L_0x009d:
        r15 = move-exception
        goto L_0x00a1
    L_0x009f:
        r15 = move-exception
        r4 = r3
    L_0x00a1:
        r5 = -1
        com.tencent.stat.common.StatLogger r3 = f25724i     // Catch:{ all -> 0x00f7 }
        r3.mo37104e(r15)     // Catch:{ all -> 0x00f7 }
        if (r4 == 0) goto L_0x00ad
        r4.endTransaction()     // Catch:{ all -> 0x0096 }
    L_0x00ad:
        int r15 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
        if (r15 <= 0) goto L_0x00dc
        int r15 = r12.f25727a
        int r15 = r15 + r0
        r12.f25727a = r15
        boolean r15 = com.tencent.stat.StatConfig.isDebugEnable()
        if (r15 == 0) goto L_0x00d6
        com.tencent.stat.common.StatLogger r15 = f25724i
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "directStoreEvent insert event to db, event:"
        r0.append(r1)
        java.lang.String r13 = r13.toJsonString()
        r0.append(r13)
        java.lang.String r13 = r0.toString()
        r15.mo37101d(r13)
    L_0x00d6:
        if (r14 == 0) goto L_0x00f6
        r14.onDispatchSuccess()
        goto L_0x00f6
    L_0x00dc:
        com.tencent.stat.common.StatLogger r14 = f25724i
        java.lang.StringBuilder r15 = new java.lang.StringBuilder
        r15.<init>()
        java.lang.String r0 = "Failed to store event:"
        r15.append(r0)
        java.lang.String r13 = r13.toJsonString()
        r15.append(r13)
        java.lang.String r13 = r15.toString()
        r14.error(r13)
    L_0x00f6:
        return
    L_0x00f7:
        r13 = move-exception
        if (r4 == 0) goto L_0x0104
        r4.endTransaction()     // Catch:{ all -> 0x00fe }
        goto L_0x0104
    L_0x00fe:
        r14 = move-exception
        com.tencent.stat.common.StatLogger r15 = f25724i
        r15.mo37104e(r14)
    L_0x0104:
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32823a(com.tencent.stat.event.Event, com.tencent.stat.StatDispatchCallback, boolean):void");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: b */
    public synchronized void m32830b(Event event, StatDispatchCallback statDispatchCallback, boolean z, boolean z2) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            if (StatConfig.f25368m > 0 && !z) {
                if (!z2) {
                    if (StatConfig.f25368m > 0) {
                        if (StatConfig.isDebugEnable()) {
                            StatLogger statLogger = f25724i;
                            StringBuilder sb = new StringBuilder();
                            sb.append("cacheEventsInMemory.size():");
                            sb.append(this.f25736n.size());
                            sb.append(",numEventsCachedInMemory:");
                            sb.append(StatConfig.f25368m);
                            sb.append(",numStoredEvents:");
                            sb.append(this.f25727a);
                            statLogger.mo37108i(sb.toString());
                            StatLogger statLogger2 = f25724i;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("cache event:");
                            sb2.append(event.toJsonString());
                            statLogger2.mo37108i(sb2.toString());
                        }
                        this.f25736n.put(event, "");
                        if (this.f25736n.size() >= StatConfig.f25368m) {
                            m32842k();
                        }
                        if (statDispatchCallback != null) {
                            if (this.f25736n.size() > 0) {
                                m32842k();
                            }
                            statDispatchCallback.onDispatchSuccess();
                        }
                    }
                }
            }
            m32823a(event, statDispatchCallback, z);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37146a(Event event, StatDispatchCallback statDispatchCallback, boolean z, boolean z2) {
        Handler handler = this.f25731f;
        if (handler != null) {
            final Event event2 = event;
            final StatDispatchCallback statDispatchCallback2 = statDispatchCallback;
            final boolean z3 = z;
            final boolean z4 = z2;
            C76184 r1 = new Runnable() {
                public void run() {
                    C7614e.this.m32830b(event2, statDispatchCallback2, z3, z4);
                }
            };
            handler.post(r1);
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:39|(2:41|42)|43|44|46|47) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0101 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e3 A[SYNTHETIC, Splitter:B:32:0x00e3] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x00e6=Splitter:B:34:0x00e6, B:23:0x00ce=Splitter:B:23:0x00ce} */
    /* renamed from: b */
    public synchronized void m32829b(com.tencent.stat.StatConfig.C7530a r13) {
        /*
        r12 = this;
        monitor-enter(r12)
        r0 = 0
        java.lang.String r1 = r13.mo36959c()     // Catch:{ all -> 0x00da }
        java.lang.String r2 = com.tencent.stat.common.StatCommonHelper.md5sum(r1)     // Catch:{ all -> 0x00da }
        android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x00da }
        r3.<init>()     // Catch:{ all -> 0x00da }
        java.lang.String r4 = "content"
        org.json.JSONObject r5 = r13.f25388b     // Catch:{ all -> 0x00da }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00da }
        r3.put(r4, r5)     // Catch:{ all -> 0x00da }
        java.lang.String r4 = "md5sum"
        r3.put(r4, r2)     // Catch:{ all -> 0x00da }
        r13.f25389c = r2     // Catch:{ all -> 0x00da }
        java.lang.String r2 = "version"
        int r4 = r13.f25390d     // Catch:{ all -> 0x00da }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00da }
        r3.put(r2, r4)     // Catch:{ all -> 0x00da }
        com.tencent.stat.e$a r2 = r12.f25729d     // Catch:{ all -> 0x00da }
        android.database.sqlite.SQLiteDatabase r4 = r2.getReadableDatabase()     // Catch:{ all -> 0x00da }
        java.lang.String r5 = "config"
        r6 = 0
        r7 = 0
        r8 = 0
        r9 = 0
        r10 = 0
        r11 = 0
        android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00da }
    L_0x003e:
        boolean r4 = r2.moveToNext()     // Catch:{ all -> 0x00d8 }
        r5 = 1
        r6 = 0
        if (r4 == 0) goto L_0x0050
        int r4 = r2.getInt(r6)     // Catch:{ all -> 0x00d8 }
        int r7 = r13.f25387a     // Catch:{ all -> 0x00d8 }
        if (r4 != r7) goto L_0x003e
        r4 = 1
        goto L_0x0051
    L_0x0050:
        r4 = 0
    L_0x0051:
        com.tencent.stat.e$a r7 = r12.f25729d     // Catch:{ all -> 0x00d8 }
        android.database.sqlite.SQLiteDatabase r7 = r7.getWritableDatabase()     // Catch:{ all -> 0x00d8 }
        r7.beginTransaction()     // Catch:{ all -> 0x00d8 }
        if (r5 != r4) goto L_0x0076
        com.tencent.stat.e$a r0 = r12.f25729d     // Catch:{ all -> 0x00d8 }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x00d8 }
        java.lang.String r4 = "config"
        java.lang.String r7 = "type=?"
        java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x00d8 }
        int r13 = r13.f25387a     // Catch:{ all -> 0x00d8 }
        java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x00d8 }
        r5[r6] = r13     // Catch:{ all -> 0x00d8 }
        int r13 = r0.update(r4, r3, r7, r5)     // Catch:{ all -> 0x00d8 }
        long r3 = (long) r13     // Catch:{ all -> 0x00d8 }
        goto L_0x008d
    L_0x0076:
        java.lang.String r4 = "type"
        int r13 = r13.f25387a     // Catch:{ all -> 0x00d8 }
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x00d8 }
        r3.put(r4, r13)     // Catch:{ all -> 0x00d8 }
        com.tencent.stat.e$a r13 = r12.f25729d     // Catch:{ all -> 0x00d8 }
        android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ all -> 0x00d8 }
        java.lang.String r4 = "config"
        long r3 = r13.insert(r4, r0, r3)     // Catch:{ all -> 0x00d8 }
    L_0x008d:
        r5 = -1
        int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r13 != 0) goto L_0x00aa
        com.tencent.stat.common.StatLogger r13 = f25724i     // Catch:{ all -> 0x00d8 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
        r0.<init>()     // Catch:{ all -> 0x00d8 }
        java.lang.String r3 = "Failed to store cfg:"
        r0.append(r3)     // Catch:{ all -> 0x00d8 }
        r0.append(r1)     // Catch:{ all -> 0x00d8 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d8 }
        r13.mo37103e(r0)     // Catch:{ all -> 0x00d8 }
        goto L_0x00c0
    L_0x00aa:
        com.tencent.stat.common.StatLogger r13 = f25724i     // Catch:{ all -> 0x00d8 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
        r0.<init>()     // Catch:{ all -> 0x00d8 }
        java.lang.String r3 = "Sucessed to store cfg:"
        r0.append(r3)     // Catch:{ all -> 0x00d8 }
        r0.append(r1)     // Catch:{ all -> 0x00d8 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d8 }
        r13.mo37101d(r0)     // Catch:{ all -> 0x00d8 }
    L_0x00c0:
        com.tencent.stat.e$a r13 = r12.f25729d     // Catch:{ all -> 0x00d8 }
        android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ all -> 0x00d8 }
        r13.setTransactionSuccessful()     // Catch:{ all -> 0x00d8 }
        if (r2 == 0) goto L_0x00ce
        r2.close()     // Catch:{ all -> 0x00ff }
    L_0x00ce:
        com.tencent.stat.e$a r13 = r12.f25729d     // Catch:{ Exception -> 0x00ed }
        android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ Exception -> 0x00ed }
    L_0x00d4:
        r13.endTransaction()     // Catch:{ Exception -> 0x00ed }
        goto L_0x00ed
    L_0x00d8:
        r13 = move-exception
        goto L_0x00dc
    L_0x00da:
        r13 = move-exception
        r2 = r0
    L_0x00dc:
        com.tencent.stat.common.StatLogger r0 = f25724i     // Catch:{ all -> 0x00ef }
        r0.mo37104e(r13)     // Catch:{ all -> 0x00ef }
        if (r2 == 0) goto L_0x00e6
        r2.close()     // Catch:{ all -> 0x00ff }
    L_0x00e6:
        com.tencent.stat.e$a r13 = r12.f25729d     // Catch:{ Exception -> 0x00ed }
        android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ Exception -> 0x00ed }
        goto L_0x00d4
    L_0x00ed:
        monitor-exit(r12)
        return
    L_0x00ef:
        r13 = move-exception
        if (r2 == 0) goto L_0x00f5
        r2.close()     // Catch:{ all -> 0x00ff }
    L_0x00f5:
        com.tencent.stat.e$a r0 = r12.f25729d     // Catch:{ Exception -> 0x0101 }
        android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ Exception -> 0x0101 }
        r0.endTransaction()     // Catch:{ Exception -> 0x0101 }
        goto L_0x0101
    L_0x00ff:
        r13 = move-exception
        goto L_0x0102
    L_0x0101:
        throw r13     // Catch:{ all -> 0x00ff }
    L_0x0102:
        monitor-exit(r12)
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32829b(com.tencent.stat.StatConfig$a):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37145a(final C7530a aVar) {
        if (aVar != null) {
            aVar.mo36956a(f25725j);
            this.f25731f.post(new Runnable() {
                public void run() {
                    C7614e.this.m32829b(aVar);
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005f, code lost:
            if (r0 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0068, code lost:
            if (r0 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
            return;
     */
    /* renamed from: e */
    public void mo37152e() {
        /*
        r10 = this;
        com.tencent.stat.StatConfig$a r0 = com.tencent.stat.StatConfig.f25357b
        android.content.Context r1 = f25725j
        boolean r0 = r0.mo36958b(r1)
        if (r0 != 0) goto L_0x0075
        com.tencent.stat.StatConfig$a r0 = com.tencent.stat.StatConfig.f25345a
        android.content.Context r1 = f25725j
        boolean r0 = r0.mo36958b(r1)
        if (r0 == 0) goto L_0x0015
        goto L_0x0075
    L_0x0015:
        r0 = 0
        com.tencent.stat.e$a r1 = r10.f25729d     // Catch:{ all -> 0x0062 }
        android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch:{ all -> 0x0062 }
        java.lang.String r3 = "config"
        r4 = 0
        r5 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        r9 = 0
        android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0062 }
    L_0x0028:
        boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x0062 }
        if (r1 == 0) goto L_0x005f
        r1 = 0
        int r1 = r0.getInt(r1)     // Catch:{ all -> 0x0062 }
        r2 = 1
        java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0062 }
        r3 = 2
        java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0062 }
        r4 = 3
        int r4 = r0.getInt(r4)     // Catch:{ all -> 0x0062 }
        com.tencent.stat.StatConfig$a r5 = new com.tencent.stat.StatConfig$a     // Catch:{ all -> 0x0062 }
        r5.m53526init(r1)     // Catch:{ all -> 0x0062 }
        r5.f25387a = r1     // Catch:{ all -> 0x0062 }
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0062 }
        r1.<init>(r2)     // Catch:{ all -> 0x0062 }
        r5.f25388b = r1     // Catch:{ all -> 0x0062 }
        r5.f25389c = r3     // Catch:{ all -> 0x0062 }
        r5.f25390d = r4     // Catch:{ all -> 0x0062 }
        android.content.Context r1 = f25725j     // Catch:{ all -> 0x0062 }
        r5.mo36956a(r1)     // Catch:{ all -> 0x0062 }
        android.content.Context r1 = f25725j     // Catch:{ all -> 0x0062 }
        com.tencent.stat.StatConfig.m32588a(r1, r5)     // Catch:{ all -> 0x0062 }
        goto L_0x0028
    L_0x005f:
        if (r0 == 0) goto L_0x006d
        goto L_0x006a
    L_0x0062:
        r1 = move-exception
        com.tencent.stat.common.StatLogger r2 = f25724i     // Catch:{ all -> 0x006e }
        r2.mo37104e(r1)     // Catch:{ all -> 0x006e }
        if (r0 == 0) goto L_0x006d
    L_0x006a:
        r0.close()
    L_0x006d:
        return
    L_0x006e:
        r1 = move-exception
        if (r0 == 0) goto L_0x0074
        r0.close()
    L_0x0074:
        throw r1
    L_0x0075:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.mo37152e():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
            return;
     */
    /* renamed from: a */
    private synchronized void m32815a(int r4, final boolean r5) {
        /*
        r3 = this;
        monitor-enter(r3)
        int r0 = r3.f25727a     // Catch:{ all -> 0x0079 }
        if (r0 <= 0) goto L_0x0077
        if (r4 <= 0) goto L_0x0077
        boolean r0 = com.tencent.stat.StatServiceImpl.m32632a()     // Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x000e
        goto L_0x0077
    L_0x000e:
        boolean r0 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0031
        com.tencent.stat.common.StatLogger r0 = f25724i     // Catch:{ all -> 0x0079 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
        r1.<init>()     // Catch:{ all -> 0x0079 }
        java.lang.String r2 = "Load "
        r1.append(r2)     // Catch:{ all -> 0x0079 }
        int r2 = r3.f25727a     // Catch:{ all -> 0x0079 }
        r1.append(r2)     // Catch:{ all -> 0x0079 }
        java.lang.String r2 = " unsent events"
        r1.append(r2)     // Catch:{ all -> 0x0079 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0079 }
        r0.mo37108i(r1)     // Catch:{ all -> 0x0079 }
    L_0x0031:
        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0079 }
        r0.<init>(r4)     // Catch:{ all -> 0x0079 }
        r3.m32831b(r0, r4, r5)     // Catch:{ all -> 0x0079 }
        int r4 = r0.size()     // Catch:{ all -> 0x0079 }
        if (r4 <= 0) goto L_0x007f
        boolean r4 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x0079 }
        if (r4 == 0) goto L_0x0064
        com.tencent.stat.common.StatLogger r4 = f25724i     // Catch:{ all -> 0x0079 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
        r1.<init>()     // Catch:{ all -> 0x0079 }
        java.lang.String r2 = "Peek "
        r1.append(r2)     // Catch:{ all -> 0x0079 }
        int r2 = r0.size()     // Catch:{ all -> 0x0079 }
        r1.append(r2)     // Catch:{ all -> 0x0079 }
        java.lang.String r2 = " unsent events."
        r1.append(r2)     // Catch:{ all -> 0x0079 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0079 }
        r4.mo37108i(r1)     // Catch:{ all -> 0x0079 }
    L_0x0064:
        r4 = 2
        r3.m32824a(r0, r4, r5)     // Catch:{ all -> 0x0079 }
        android.content.Context r4 = f25725j     // Catch:{ all -> 0x0079 }
        com.tencent.stat.d r4 = com.tencent.stat.C7608d.m32797b(r4)     // Catch:{ all -> 0x0079 }
        com.tencent.stat.e$6 r1 = new com.tencent.stat.e$6     // Catch:{ all -> 0x0079 }
        r1.m53657init(r0, r5)     // Catch:{ all -> 0x0079 }
        r4.mo37136b(r0, r1)     // Catch:{ all -> 0x0079 }
        goto L_0x007f
    L_0x0077:
        monitor-exit(r3)
        return
    L_0x0079:
        r4 = move-exception
        com.tencent.stat.common.StatLogger r5 = f25724i     // Catch:{ all -> 0x0081 }
        r5.mo37104e(r4)     // Catch:{ all -> 0x0081 }
    L_0x007f:
        monitor-exit(r3)
        return
    L_0x0081:
        r4 = move-exception
        monitor-exit(r3)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7614e.m32815a(int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32828b(int i, boolean z) {
        if (i == -1) {
            if (!z) {
                i = m32840i();
            } else {
                i = m32841j();
            }
        }
        if (i > 0) {
            int sendPeriodMinutes = StatConfig.getSendPeriodMinutes() * 60 * StatConfig.getNumEventsCommitPerSec();
            if (i > sendPeriodMinutes && sendPeriodMinutes > 0) {
                i = sendPeriodMinutes;
            }
            int b = StatConfig.m32596b();
            int i2 = i / b;
            int i3 = i % b;
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = f25724i;
                StringBuilder sb = new StringBuilder();
                sb.append("sentStoreEventsByDb sendNumbers=");
                sb.append(i);
                sb.append(",important=");
                sb.append(z);
                sb.append(",maxSendNumPerFor1Period=");
                sb.append(sendPeriodMinutes);
                sb.append(",maxCount=");
                sb.append(i2);
                sb.append(",restNumbers=");
                sb.append(i3);
                statLogger.mo37108i(sb.toString());
            }
            for (int i4 = 0; i4 < i2; i4++) {
                StatLogger statLogger2 = f25724i;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("round:");
                sb2.append(f25723c);
                sb2.append(" send i:");
                sb2.append(i4);
                statLogger2.mo37108i(sb2.toString());
                m32815a(b, z);
            }
            if (i3 > 0) {
                m32815a(i3, z);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37144a(final int i) {
        this.f25731f.post(new Runnable() {
            public void run() {
                C7614e.this.m32828b(i, true);
                C7614e.this.m32828b(i, false);
            }
        });
    }

    /* renamed from: l */
    private void m32843l() {
        Cursor cursor = null;
        try {
            cursor = this.f25729d.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                this.f25738p.put(cursor.getString(0), cursor.getString(1));
            }
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }
}
