package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic;
import com.bytedance.sdk.openadsdk.p165c.AdEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.StatsBatchEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.StatsEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p199j.TrackRetryRepertoryImpl;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.bytedance.sdk.openadsdk.core.f */
class DBHelper {
    /* access modifiers changed from: private|static|final */
    /* renamed from: c */
    public static final Object f7510c = new Object();
    /* renamed from: a */
    private C2234c f7511a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f7512b;

    /* compiled from: DBHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.core.f$a */
    private class C2232a extends SQLiteOpenHelper {
        /* renamed from: a */
        final Context f7513a;

        public C2232a(Context context) {
            super(context, "ttopensdk.db", null, 6);
            this.f7513a = context;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                m9543a(sQLiteDatabase, this.f7513a);
            } catch (Throwable unused) {
            }
        }

        /* renamed from: a */
        private void m9543a(SQLiteDatabase sQLiteDatabase, Context context) {
            C2564t.m12220b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(AdEventRepertoryImpl.m8433e());
            sQLiteDatabase.execSQL(StatsEventRepertoryImpl.m8517g());
            sQLiteDatabase.execSQL(StatsBatchEventRepertoryImpl.m8505e());
            sQLiteDatabase.execSQL(TrackRetryRepertoryImpl.m11744b());
            sQLiteDatabase.execSQL(TTDynamic.m10870d());
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            String str = "DBHelper";
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("onUpgrade....数据库版本升级.....old:");
                sb.append(i);
                sb.append(",new:");
                sb.append(i2);
                C2564t.m12220b(str, sb.toString());
                if (i > i2) {
                    m9542a(sQLiteDatabase);
                    m9543a(sQLiteDatabase, DBHelper.this.f7512b);
                    C2564t.m12220b(str, "onUpgrade...逆向安装.数据库重置-创建表.....");
                } else {
                    m9543a(sQLiteDatabase, DBHelper.this.f7512b);
                }
                if (i == 1) {
                    C2564t.m12220b(str, "onUpgrade.....执行表创建.....");
                } else if (i == 2) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                } else if (i == 3) {
                    sQLiteDatabase.execSQL(StatsEventRepertoryImpl.m8517g());
                } else if (i == 4) {
                    sQLiteDatabase.execSQL(TTDynamic.m10870d());
                } else if (i == 5) {
                    sQLiteDatabase.execSQL(StatsBatchEventRepertoryImpl.m8505e());
                }
            } catch (Throwable unused) {
            }
        }

        /* renamed from: a */
        private void m9542a(SQLiteDatabase sQLiteDatabase) {
            ArrayList b = m9544b(sQLiteDatabase);
            if (b != null && b.size() > 0) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", new Object[]{(String) it.next()}));
                }
            }
        }

        /* renamed from: b */
        private ArrayList<String> m9544b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (rawQuery != null) {
                    while (rawQuery.moveToNext()) {
                        String string = rawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                    rawQuery.close();
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
    }

    /* compiled from: DBHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.core.f$b */
    private class C2233b extends AbstractCursor {
        public String[] getColumnNames() {
            return new String[0];
        }

        public int getCount() {
            return 0;
        }

        public double getDouble(int i) {
            return 0.0d;
        }

        public float getFloat(int i) {
            return 0.0f;
        }

        public int getInt(int i) {
            return 0;
        }

        public long getLong(int i) {
            return 0;
        }

        public short getShort(int i) {
            return 0;
        }

        public String getString(int i) {
            return null;
        }

        public boolean isNull(int i) {
            return true;
        }

        private C2233b() {
        }
    }

    /* compiled from: DBHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.core.f$c */
    public class C2234c {
        /* renamed from: b */
        private SQLiteDatabase f7517b = null;

        public C2234c() {
        }

        /* renamed from: d */
        private synchronized void m9545d() {
            try {
                synchronized (DBHelper.f7510c) {
                    if (this.f7517b == null || !this.f7517b.isOpen()) {
                        this.f7517b = new C2232a(DBHelper.this.m9540c()).getWritableDatabase();
                        this.f7517b.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (m9546e()) {
                    throw th;
                }
            }
        }

        /* renamed from: a */
        public synchronized void mo15627a(String str) throws SQLException {
            try {
                m9545d();
                this.f7517b.execSQL(str);
            } catch (Throwable th) {
                if (m9546e()) {
                    throw th;
                }
            }
        }

        /* renamed from: a */
        public synchronized Cursor mo15625a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                m9545d();
                cursor = this.f7517b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                Cursor bVar = new C2233b();
                if (!m9546e()) {
                    cursor = bVar;
                } else {
                    throw th;
                }
            }
            return cursor;
        }

        /* renamed from: a */
        public synchronized int mo15622a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                m9545d();
                i = this.f7517b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!m9546e()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        /* renamed from: a */
        public synchronized long mo15624a(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                m9545d();
                j = this.f7517b.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (!m9546e()) {
                    j = -1;
                } else {
                    throw e;
                }
            }
            return j;
        }

        /* renamed from: a */
        public synchronized int mo15623a(String str, String str2, String[] strArr) {
            int i;
            try {
                m9545d();
                i = this.f7517b.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!m9546e()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        /* renamed from: a */
        public synchronized void mo15626a() {
            m9545d();
            if (this.f7517b != null) {
                this.f7517b.beginTransaction();
            }
        }

        /* renamed from: b */
        public synchronized void mo15628b() {
            m9545d();
            if (this.f7517b != null) {
                this.f7517b.setTransactionSuccessful();
            }
        }

        /* renamed from: c */
        public synchronized void mo15629c() {
            m9545d();
            if (this.f7517b != null) {
                this.f7517b.endTransaction();
            }
        }

        /* renamed from: e */
        private synchronized boolean m9546e() {
            boolean z;
            SQLiteDatabase sQLiteDatabase = this.f7517b;
            z = sQLiteDatabase != null && sQLiteDatabase.inTransaction();
            return z;
        }
    }

    DBHelper(Context context) {
        Context context2;
        if (context == null) {
            try {
                context2 = InternalContainer.m10059a();
            } catch (Throwable unused) {
                return;
            }
        } else {
            context2 = context.getApplicationContext();
        }
        this.f7512b = context2;
        if (this.f7511a == null) {
            this.f7511a = new C2234c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Context m9540c() {
        Context context = this.f7512b;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* renamed from: a */
    public C2234c mo15610a() {
        return this.f7511a;
    }
}
