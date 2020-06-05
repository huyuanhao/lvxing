package com.tencent.android.tpush.p586e.p587a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.e.a.a */
public class C6930a extends SQLiteOpenHelper {
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public C6930a(Context context) {
        super(context, "xg_message.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m29597a(sQLiteDatabase);
    }

    /* renamed from: a */
    private void m29597a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE messagetoshow (_id INTEGER PRIMARY KEY AUTOINCREMENT, msgid INTEGER, message TEXT, time INTEGER, busiid INTEGER, showedtime INTEGER, status INTEGER, UNIQUE (msgid) ON CONFLICT IGNORE);");
    }
}
