package com.p530ss.android.socialbase.downloader.p558c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import java.io.File;

/* renamed from: com.ss.android.socialbase.downloader.c.a */
public class DownloadDBHelper extends SQLiteOpenHelper {
    /* renamed from: a */
    private static volatile DownloadDBHelper f21724a;
    /* renamed from: b */
    private boolean f21725b = false;

    /* renamed from: a */
    public static DownloadDBHelper m26988a() {
        if (f21724a == null) {
            synchronized (DownloadDBHelper.class) {
                if (f21724a == null) {
                    f21724a = new DownloadDBHelper();
                }
            }
        }
        return f21724a;
    }

    private DownloadDBHelper() {
        super(C6694b.m27342B(), "downloader.db", null, 12);
    }

    public SQLiteDatabase getReadableDatabase() {
        Context B = C6694b.m27342B();
        if (this.f21725b || B == null) {
            return super.getReadableDatabase();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/data/data/");
            sb.append(B.getPackageName());
            sb.append("/database/main/");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdir();
            }
            super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");
            this.f21725b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.getReadableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloadChunk( _id INTEGER, chunkIndex INTEGER, startOffset INTEGER, curOffset INTEGER, endOffset INTEGER, chunkContentLen INTEGER, hostChunkIndex INTEGER )");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005f, code lost:
            r1.execSQL("ALTER TABLE downloader ADD chunkDowngradeRetry INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD backUpUrlsStr TEXT");
            r1.execSQL("ALTER TABLE downloader ADD backUpUrlRetryCount INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD realDownloadTime INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD retryScheduleMinutes INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD independentProcess INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x007d, code lost:
            r1.execSQL("ALTER TABLE downloader ADD auxiliaryJsonobjectString TEXT");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0019, code lost:
            r1.execSQL("ALTER TABLE downloader ADD isFirstDownload INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
            r1.execSQL("ALTER TABLE downloader ADD isFirstSuccess INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0023, code lost:
            r1.execSQL("ALTER TABLE downloader ADD needHttpsToHttpRetry INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD downloadTime INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
            r1.execSQL("ALTER TABLE downloader ADD packageName TEXT");
            r1.execSQL("ALTER TABLE downloader ADD md5 TEXT");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0037, code lost:
            r1.execSQL("ALTER TABLE downloader ADD retryDelay INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD curRetryTime INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD retryDelayStatus INTEGER");
            r1.execSQL("ALTER TABLE downloader ADD defaultHttpServiceBackUp INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004b, code lost:
            r1.execSQL("ALTER TABLE downloadChunk ADD chunkContentLen INTEGER");
            r1.execSQL("ALTER TABLE downloadChunk ADD hostChunkIndex INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0055, code lost:
            r1.execSQL("ALTER TABLE downloader ADD chunkRunnableReuse INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005a, code lost:
            r1.execSQL("ALTER TABLE downloader ADD retryDelayTimeArray TEXT");
     */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r1, int r2, int r3) {
        /*
        r0 = this;
        switch(r2) {
            case 1: goto L_0x0005;
            case 2: goto L_0x0019;
            case 3: goto L_0x001e;
            case 4: goto L_0x0023;
            case 5: goto L_0x002d;
            case 6: goto L_0x0037;
            case 7: goto L_0x004b;
            case 8: goto L_0x0055;
            case 9: goto L_0x005a;
            case 10: goto L_0x005f;
            case 11: goto L_0x007d;
            default: goto L_0x0003;
        }
    L_0x0003:
        goto L_0x0082
    L_0x0005:
        java.lang.String r2 = "ALTER TABLE downloader ADD mimeType TEXT"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD title TEXT"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD notificationEnable INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD notificationVisibility INTEGER"
        r1.execSQL(r2)
    L_0x0019:
        java.lang.String r2 = "ALTER TABLE downloader ADD isFirstDownload INTEGER"
        r1.execSQL(r2)
    L_0x001e:
        java.lang.String r2 = "ALTER TABLE downloader ADD isFirstSuccess INTEGER"
        r1.execSQL(r2)
    L_0x0023:
        java.lang.String r2 = "ALTER TABLE downloader ADD needHttpsToHttpRetry INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD downloadTime INTEGER"
        r1.execSQL(r2)
    L_0x002d:
        java.lang.String r2 = "ALTER TABLE downloader ADD packageName TEXT"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD md5 TEXT"
        r1.execSQL(r2)
    L_0x0037:
        java.lang.String r2 = "ALTER TABLE downloader ADD retryDelay INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD curRetryTime INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD retryDelayStatus INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD defaultHttpServiceBackUp INTEGER"
        r1.execSQL(r2)
    L_0x004b:
        java.lang.String r2 = "ALTER TABLE downloadChunk ADD chunkContentLen INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloadChunk ADD hostChunkIndex INTEGER"
        r1.execSQL(r2)
    L_0x0055:
        java.lang.String r2 = "ALTER TABLE downloader ADD chunkRunnableReuse INTEGER"
        r1.execSQL(r2)
    L_0x005a:
        java.lang.String r2 = "ALTER TABLE downloader ADD retryDelayTimeArray TEXT"
        r1.execSQL(r2)
    L_0x005f:
        java.lang.String r2 = "ALTER TABLE downloader ADD chunkDowngradeRetry INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD backUpUrlsStr TEXT"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD backUpUrlRetryCount INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD realDownloadTime INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD retryScheduleMinutes INTEGER"
        r1.execSQL(r2)
        java.lang.String r2 = "ALTER TABLE downloader ADD independentProcess INTEGER"
        r1.execSQL(r2)
    L_0x007d:
        java.lang.String r2 = "ALTER TABLE downloader ADD auxiliaryJsonobjectString TEXT"
        r1.execSQL(r2)
    L_0x0082:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p558c.DownloadDBHelper.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C6704a.m27756a()) {
            C6704a.m27753a("onDowngrade");
        }
    }
}
