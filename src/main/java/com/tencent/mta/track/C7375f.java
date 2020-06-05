package com.tencent.mta.track;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mta.track.DbAdapter.Table;
import java.io.File;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.f */
class C7375f extends SQLiteOpenHelper {
    /* renamed from: a */
    private final File f24954a;

    C7375f(Context context, String str) {
        super(context, str, null, 4);
        this.f24954a = context.getDatabasePath(str);
    }

    /* renamed from: a */
    public void mo35913a() {
        close();
        this.f24954a.delete();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StatisticsDataAPI.f24839a.booleanValue();
        sQLiteDatabase.execSQL(DbAdapter.f24831a);
        sQLiteDatabase.execSQL(DbAdapter.f24832b);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StatisticsDataAPI.f24839a.booleanValue();
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS ");
        sb.append(Table.EVENTS.mo35805a());
        sQLiteDatabase.execSQL(sb.toString());
        sQLiteDatabase.execSQL(DbAdapter.f24831a);
        sQLiteDatabase.execSQL(DbAdapter.f24832b);
    }
}
