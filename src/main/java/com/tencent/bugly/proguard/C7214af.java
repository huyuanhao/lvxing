package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.bugly.C8712a;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.C7175b;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.af */
public class C7214af extends SQLiteOpenHelper {
    /* renamed from: a */
    public static String f24326a = "bugly_db";
    /* renamed from: b */
    public static int f24327b = 15;
    /* renamed from: c */
    protected Context f24328c;
    /* renamed from: d */
    private List<C8712a> f24329d;

    public C7214af(Context context, List<C8712a> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(f24326a);
        sb.append("_");
        C7174a.m30753a(context).getClass();
        sb.append("");
        super(context, sb.toString(), null, f24327b);
        this.f24328c = context;
        this.f24329d = list;
    }

    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_ui");
            sb.append(" ( ");
            sb.append(C7887a.f26833ID);
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_ut");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_tp");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(" , ");
            sb.append("_pc");
            sb.append(" ");
            sb.append("text");
            sb.append(" ) ");
            C7226an.m31147c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_lr");
            sb.append(" ( ");
            sb.append(C7887a.f26833ID);
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tp");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_pc");
            sb.append(" ");
            sb.append("text");
            sb.append(" , ");
            sb.append("_th");
            sb.append(" ");
            sb.append("text");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(" ) ");
            C7226an.m31147c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_pf");
            sb.append(" ( ");
            sb.append(C7887a.f26833ID);
            sb.append(" ");
            sb.append(SettingsContentProvider.INT_TYPE);
            sb.append(" , ");
            sb.append("_tp");
            sb.append(" ");
            sb.append("text");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(C7887a.f26833ID);
            sb.append(StorageInterface.KEY_SPLITER);
            sb.append("_tp");
            sb.append(" )) ");
            C7226an.m31147c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_cr");
            sb.append(" ( ");
            sb.append(C7887a.f26833ID);
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_s1");
            sb.append(" ");
            sb.append("text");
            sb.append(" , ");
            sb.append("_up");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_me");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_uc");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(" ) ");
            C7226an.m31147c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("dl_1002");
            sb.append(" (");
            sb.append(C7887a.f26833ID);
            sb.append(" integer primary key autoincrement, ");
            sb.append("_dUrl");
            sb.append(" varchar(100), ");
            sb.append("_sFile");
            sb.append(" varchar(100), ");
            sb.append("_sLen");
            sb.append(" INTEGER, ");
            sb.append("_tLen");
            sb.append(" INTEGER, ");
            sb.append("_MD5");
            sb.append(" varchar(100), ");
            sb.append("_DLTIME");
            sb.append(" INTEGER)");
            C7226an.m31147c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append("ge_1002");
            sb.append(" (");
            sb.append(C7887a.f26833ID);
            sb.append(" integer primary key autoincrement, ");
            sb.append("_time");
            sb.append(" INTEGER, ");
            sb.append("_datas");
            sb.append(" blob)");
            C7226an.m31147c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("st_1002");
            sb.append(" ( ");
            sb.append(C7887a.f26833ID);
            sb.append(" ");
            sb.append(SettingsContentProvider.INT_TYPE);
            sb.append(" , ");
            sb.append("_tp");
            sb.append(" ");
            sb.append("text");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append("int");
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(",primary key(");
            sb.append(C7887a.f26833ID);
            sb.append(StorageInterface.KEY_SPLITER);
            sb.append("_tp");
            sb.append(" )) ");
            C7226an.m31147c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        } catch (Throwable th) {
            if (!C7226an.m31145b(th)) {
                th.printStackTrace();
            }
        }
        if (this.f24329d != null) {
            for (C8712a onDbCreate : this.f24329d) {
                try {
                    onDbCreate.onDbCreate(sQLiteDatabase);
                } catch (Throwable th2) {
                    if (!C7226an.m31145b(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: a */
    public synchronized boolean mo34795a(SQLiteDatabase sQLiteDatabase) {
        String[] strArr;
        try {
            for (String str : new String[]{"t_lr", "t_ui", "t_pf"}) {
                StringBuilder sb = new StringBuilder();
                sb.append("DROP TABLE IF EXISTS ");
                sb.append(str);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            }
        } catch (Throwable th) {
            if (!C7226an.m31145b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C7226an.m31148d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.f24329d != null) {
            for (C8712a onDbUpgrade : this.f24329d) {
                try {
                    onDbUpgrade.onDbUpgrade(sQLiteDatabase, i, i2);
                } catch (Throwable th) {
                    if (!C7226an.m31145b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (mo34795a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            C7226an.m31148d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f24328c.getDatabasePath(f24326a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    public synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C7175b.m30821c() >= 11) {
            C7226an.m31148d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.f24329d != null) {
                for (C8712a onDbDowngrade : this.f24329d) {
                    try {
                        onDbDowngrade.onDbDowngrade(sQLiteDatabase, i, i2);
                    } catch (Throwable th) {
                        if (!C7226an.m31145b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (mo34795a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                C7226an.m31148d("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f24328c.getDatabasePath(f24326a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                C7226an.m31148d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    C7226an.m31149e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                C7226an.m31148d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    C7226an.m31149e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            C7226an.m31148d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }
}
