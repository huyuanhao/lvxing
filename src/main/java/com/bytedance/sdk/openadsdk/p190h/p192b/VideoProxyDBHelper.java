package com.bytedance.sdk.openadsdk.p190h.p192b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.bytedance.sdk.openadsdk.h.b.d */
public class VideoProxyDBHelper extends SQLiteOpenHelper {
    public VideoProxyDBHelper(Context context) {
        super(context, "tt_open_sdk_video.db", null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS video_http_header_t(_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,mime TEXT,contentLength INTEGER,flag INTEGER,extra TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String str = "ALTER TABLE video_http_header_t ADD COLUMN extra TEXT DEFAULT ''";
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN flag INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL(str);
        } else if (i == 2) {
            sQLiteDatabase.execSQL(str);
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS video_http_header_t");
            onCreate(sQLiteDatabase);
        }
    }
}
