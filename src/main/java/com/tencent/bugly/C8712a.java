package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C7226an;

/* renamed from: com.tencent.bugly.a */
public abstract class C8712a {
    /* renamed from: id */
    public int f23662id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z, BuglyStrategy buglyStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String[] tables;
        try {
            if (getTables() != null) {
                for (String str : getTables()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DROP TABLE IF EXISTS ");
                    sb.append(str);
                    sQLiteDatabase.execSQL(sb.toString());
                }
                onDbCreate(sQLiteDatabase);
            }
        } catch (Throwable th) {
            if (!C7226an.m31145b(th)) {
                th.printStackTrace();
            }
        }
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String[] tables;
        try {
            if (getTables() != null) {
                for (String str : getTables()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DROP TABLE IF EXISTS ");
                    sb.append(str);
                    sQLiteDatabase.execSQL(sb.toString());
                }
                onDbCreate(sQLiteDatabase);
            }
        } catch (Throwable th) {
            if (!C7226an.m31145b(th)) {
                th.printStackTrace();
            }
        }
    }
}
