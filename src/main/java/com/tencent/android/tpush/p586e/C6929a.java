package com.tencent.android.tpush.p586e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p586e.p587a.C6930a;
import com.tencent.android.tpush.service.p595e.C7056i;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.e.a */
public class C6929a {
    /* renamed from: a */
    private static long f23023a = 0;
    /* renamed from: b */
    private static long f23024b = 172800000;
    /* renamed from: c */
    private static C6930a f23025c;

    /* renamed from: d */
    private static C6930a m29592d(Context context) {
        if (f23025c == null) {
            synchronized (C6929a.class) {
                if (f23025c == null) {
                    f23025c = new C6930a(context.getApplicationContext());
                }
            }
        }
        return f23025c;
    }

    /* renamed from: a */
    public static boolean m29587a(Context context, Intent intent) {
        String str = "MessageInfoManager";
        long longExtra = intent.getLongExtra(MessageKey.MSG_ID, -1);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgid", Long.valueOf(longExtra));
        boolean z = true;
        contentValues.put("message", Rijndael.encrypt(intent.toUri(1)));
        contentValues.put("time", Long.valueOf(C7056i.m30187b(intent)));
        contentValues.put("busiid", Long.valueOf(intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0)));
        Integer valueOf = Integer.valueOf(0);
        contentValues.put("showedtime", valueOf);
        contentValues.put(NotificationCompat.CATEGORY_STATUS, valueOf);
        try {
            SQLiteDatabase writableDatabase = m29592d(context).getWritableDatabase();
            if (writableDatabase.insert("messagetoshow", null, contentValues) <= 0) {
                C6864a.m29308i(str, "addCacheMessage Error! ");
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("addNewCacheMessage Error! ");
            sb.append(th);
            C6864a.m29308i(str, sb.toString());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m29585a(Context context, long j) {
        m29594e(context);
        return m29586a(context, j, 1);
    }

    /* renamed from: b */
    public static boolean m29589b(Context context, long j) {
        m29594e(context);
        return m29586a(context, j, 2);
    }

    /* renamed from: c */
    public static boolean m29591c(Context context, long j) {
        return m29586a(context, j, 3);
    }

    /* renamed from: d */
    public static boolean m29593d(Context context, long j) {
        return m29586a(context, j, 4);
    }

    /* renamed from: a */
    private static boolean m29586a(Context context, long j, int i) {
        String str = "MessageInfoManager";
        ContentValues contentValues = new ContentValues();
        boolean z = true;
        if (i == 1 || i == 2) {
            contentValues.put("showedtime", Long.valueOf(System.currentTimeMillis()));
        }
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
        try {
            SQLiteDatabase writableDatabase = m29592d(context).getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append("");
            if (((long) writableDatabase.update("messagetoshow", contentValues, "msgid=?", new String[]{sb.toString()})) <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateCacheMessage Error! msgId:");
                sb2.append(j);
                sb2.append(", status:");
                sb2.append(i);
                C6864a.m29308i(str, sb2.toString());
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("updateCacheMessage Error! ");
            sb3.append(th);
            C6864a.m29308i(str, sb3.toString());
            return false;
        }
    }

    /* renamed from: e */
    private static boolean m29594e(Context context) {
        String str = "MessageInfoManager";
        long currentTimeMillis = System.currentTimeMillis();
        long j = f23023a;
        boolean z = true;
        if (j == 0 || currentTimeMillis - j > 86400000) {
            f23023a = currentTimeMillis;
            long j2 = currentTimeMillis - f23024b;
            try {
                SQLiteDatabase writableDatabase = m29592d(context).getWritableDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append(j2);
                sb.append("");
                if (writableDatabase.delete("messagetoshow", "status >= ? AND showedtime < ? ", new String[]{"1", sb.toString()}) <= 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("delOldShowedCacheMessage Error! toDelTime: ");
                    sb2.append(j2);
                    C6864a.m29298c(str, sb2.toString());
                    z = false;
                }
                writableDatabase.close();
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("delOldShowedCacheMessage Error! ");
                sb3.append(th);
                C6864a.m29308i(str, sb3.toString());
                return false;
            }
        }
        return z;
    }

    /* renamed from: e */
    public static boolean m29595e(Context context, long j) {
        String str = "delCacheMessage Error! msgid to delete: ";
        String str2 = "MessageInfoManager";
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = m29592d(context).getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append("");
            if (writableDatabase.delete("messagetoshow", "msgid=?", new String[]{sb.toString()}) <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(j);
                C6864a.m29308i(str2, sb2.toString());
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
            if (writableDatabase != null) {
                try {
                    writableDatabase.close();
                } catch (Throwable unused2) {
                }
            }
            return true;
        } catch (Throwable unused3) {
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m29584a(Context context) {
        boolean z;
        String str = "MessageInfoManager";
        try {
            SQLiteDatabase writableDatabase = m29592d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", null, null) <= 0) {
                C6864a.m29306g(str, "delAllCacheMessage but no mssgage in db");
                z = false;
            } else {
                z = true;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("delAllCacheMessage Error! ");
            sb.append(th);
            C6864a.m29308i(str, sb.toString());
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m29596f(Context context, long j) {
        String str = "MessageInfoManager";
        try {
            SQLiteDatabase writableDatabase = m29592d(context).getWritableDatabase();
            boolean z = true;
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append("");
            if (writableDatabase.delete("messagetoshow", "busiid=?", new String[]{sb.toString()}) <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("delCacheMessageByBusiId Error! msgid to delete which busiId = : ");
                sb2.append(j);
                C6864a.m29308i(str, sb2.toString());
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("delCacheMessageByBusiId Error! ");
            sb3.append(th);
            C6864a.m29308i(str, sb3.toString());
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m29588b(Context context) {
        boolean z;
        String str = "deleteAllLocalCacheMsgIntent Error! ";
        String str2 = "MessageInfoManager";
        try {
            SQLiteDatabase writableDatabase = m29592d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", "msgid < 0", null) <= 0) {
                C6864a.m29308i(str2, str);
                z = false;
            } else {
                z = true;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(th);
            C6864a.m29308i(str2, sb.toString());
            return false;
        }
    }

    /* renamed from: c */
    public static ArrayList<Intent> m29590c(Context context) {
        String str = "MessageInfoManager";
        ArrayList<Intent> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = m29592d(context).getReadableDatabase();
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("messagetoshow");
            Cursor query = sQLiteQueryBuilder.query(readableDatabase, new String[]{"message"}, "status=0", null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    Intent parseUri = Intent.parseUri(Rijndael.decrypt(query.getString(0)), 1);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    if (VERSION.SDK_INT >= 15) {
                        try {
                            parseUri.getClass().getMethod("setSelector", new Class[]{Intent.class}).invoke(parseUri, new Object[]{null});
                        } catch (Exception e) {
                            C6864a.m29299c(Constants.LogTag, "invoke intent.setComponent error.", e);
                        }
                    }
                    arrayList.add(parseUri);
                }
                query.close();
            }
            readableDatabase.close();
        } catch (URISyntaxException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("getCacheMessages Error: ");
            sb.append(e2);
            C6864a.m29308i(str, sb.toString());
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getNewCacheMessages Error! ");
            sb2.append(th);
            C6864a.m29308i(str, sb2.toString());
        }
        return arrayList;
    }
}
