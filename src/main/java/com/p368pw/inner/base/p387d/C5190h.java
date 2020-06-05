package com.p368pw.inner.base.p387d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.pw.inner.base.d.h */
public class C5190h extends SQLiteOpenHelper {
    public C5190h(Context context) {
        super(context, "windb", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_a (id INTEGER primary key autoincrement not null,aa TEXT,bb TEXT,cc TEXT,dd INTEGER,ee TEXT,ff TEXT,gg INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE table_b (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,pk TEXT NOT NULL UNIQUE,iu TEXT NOT NULL,ti TEXT NOT NULL)");
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            C5205o.m21462a("db ug");
            if (i == 1 && i2 == 2) {
                sQLiteDatabase.execSQL("CREATE TABLE table_b (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,pk TEXT NOT NULL UNIQUE,iu TEXT NOT NULL,ti TEXT NOT NULL)");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
