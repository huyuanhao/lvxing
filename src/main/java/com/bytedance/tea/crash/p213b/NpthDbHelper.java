package com.bytedance.tea.crash.p213b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.tea.crash.p213b.p215b.DuplicateLogDAO;

/* renamed from: com.bytedance.tea.crash.b.b */
public class NpthDbHelper extends SQLiteOpenHelper {
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public NpthDbHelper(Context context) {
        super(context, "npth_log.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        new DuplicateLogDAO().mo16983a(sQLiteDatabase);
    }
}
