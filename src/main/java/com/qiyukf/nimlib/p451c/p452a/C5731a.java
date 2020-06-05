package com.qiyukf.nimlib.p451c.p452a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.qiyukf.basesdk.p393a.C5264a;
import java.io.File;

/* renamed from: com.qiyukf.nimlib.c.a.a */
public abstract class C5731a {
    /* renamed from: a */
    protected final int f18294a;
    /* renamed from: b */
    protected SQLiteDatabase f18295b;
    /* renamed from: c */
    private boolean f18296c;
    /* renamed from: d */
    private Context f18297d;
    /* renamed from: e */
    private String f18298e;

    public C5731a(Context context, String str) {
        this(context, str, 0);
    }

    private C5731a(Context context, String str, byte b) {
        this.f18297d = context;
        this.f18298e = str;
        this.f18294a = 4;
        this.f18296c = true;
        StringBuilder sb = new StringBuilder("open database: ");
        String str2 = this.f18298e;
        sb.append(str2.substring(str2.lastIndexOf("/") + 1));
        String sb2 = sb.toString();
        String str3 = "db";
        C5264a.m21617a(str3, sb2);
        if (this.f18296c) {
            String str4 = this.f18298e;
            int i = this.f18294a;
            try {
                this.f18295b = SQLiteDatabase.openOrCreateDatabase(m23064c(str4), null);
            } catch (SQLiteException e) {
                StringBuilder sb3 = new StringBuilder("error=");
                sb3.append(e.getLocalizedMessage());
                C5264a.m21617a(str3, sb3.toString());
            }
            int version = this.f18295b.getVersion();
            if (version != i) {
                this.f18295b.beginTransaction();
                if (version == 0) {
                    try {
                        StringBuilder sb4 = new StringBuilder("create database ");
                        sb4.append(str4);
                        C5264a.m21617a(str3, sb4.toString());
                        mo27976a().mo27985a(this.f18295b, this.f18294a);
                    } catch (Exception e2) {
                        StringBuilder sb5 = new StringBuilder("create or upgrade database ");
                        sb5.append(str4);
                        sb5.append(" error: ");
                        sb5.append(e2);
                        C5264a.m21622c(str3, sb5.toString());
                        this.f18295b.endTransaction();
                        return;
                    } catch (Throwable th) {
                        this.f18295b.endTransaction();
                        throw th;
                    }
                } else if (version < i) {
                    StringBuilder sb6 = new StringBuilder("upgrade database ");
                    sb6.append(str4);
                    sb6.append(" from ");
                    sb6.append(version);
                    sb6.append(" to ");
                    sb6.append(i);
                    C5264a.m21617a(str3, sb6.toString());
                    mo27976a().mo27986a(this.f18295b, version, i);
                }
                this.f18295b.setVersion(i);
                this.f18295b.setTransactionSuccessful();
                this.f18295b.endTransaction();
                return;
            }
            return;
        }
        String str5 = this.f18298e;
        int i2 = this.f18294a;
        try {
            this.f18295b = SQLiteDatabase.openDatabase(m23064c(str5), null, 0);
            if (this.f18295b.getVersion() < i2) {
                this.f18295b.close();
                this.f18295b = null;
            }
        } catch (SQLiteException e3) {
            StringBuilder sb7 = new StringBuilder("open database ");
            sb7.append(str5);
            sb7.append(" only failed: ");
            sb7.append(e3);
            C5264a.m21617a(str3, sb7.toString());
        }
    }

    /* renamed from: c */
    private String m23064c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18297d.getApplicationInfo().dataDir);
        sb.append("/");
        sb.append(str);
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        StringBuilder sb3 = new StringBuilder("ready to open db, path=");
        sb3.append(sb2);
        Log.i("db", sb3.toString());
        return sb2;
    }

    /* renamed from: a */
    public final int mo27977a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = this.f18295b;
        if (sQLiteDatabase != null) {
            return C5732b.m23074a(sQLiteDatabase, str, contentValues, str2, strArr);
        }
        return -1;
    }

    /* renamed from: a */
    public final long mo27978a(String str, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.f18295b;
        if (sQLiteDatabase != null) {
            return C5732b.m23075a(sQLiteDatabase, str, contentValues);
        }
        return -1;
    }

    /* renamed from: a */
    public abstract C5733c mo27976a();

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[ADDED_TO_REGION, SYNTHETIC] */
    /* renamed from: a */
    public final void mo27979a(java.lang.String r8) {
        /*
        r7 = this;
        java.lang.String r0 = "db"
        android.database.sqlite.SQLiteDatabase r1 = r7.f18295b
        if (r1 == 0) goto L_0x0040
        r2 = 0
        r3 = 0
    L_0x0008:
        r4 = 3
        if (r3 >= r4) goto L_0x0040
        r1.execSQL(r8)     // Catch:{ SQLiteException -> 0x0018, Exception -> 0x0012 }
        r4 = 1
        r4 = 0
        r5 = 1
        goto L_0x0032
    L_0x0012:
        r4 = move-exception
        r4.printStackTrace()
        r4 = 0
        goto L_0x0031
    L_0x0018:
        r4 = move-exception
        r4.printStackTrace()
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        java.lang.String r6 = "exec sql exception: "
        r5.<init>(r6)
        r5.append(r4)
        java.lang.String r5 = r5.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r0, r5)
        boolean r4 = com.qiyukf.nimlib.p451c.p452a.C5732b.m23078a(r4)
    L_0x0031:
        r5 = 0
    L_0x0032:
        if (r4 == 0) goto L_0x0039
        java.lang.String r6 = "locked"
        com.qiyukf.basesdk.p393a.C5264a.m21626e(r0, r6)
    L_0x0039:
        if (r5 != 0) goto L_0x0040
        if (r4 == 0) goto L_0x0040
        int r3 = r3 + 1
        goto L_0x0008
    L_0x0040:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5731a.mo27979a(java.lang.String):void");
    }

    /* renamed from: b */
    public final long mo27980b(String str, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.f18295b;
        if (sQLiteDatabase != null) {
            return C5732b.m23079b(sQLiteDatabase, str, contentValues);
        }
        return -1;
    }

    /* renamed from: b */
    public final Cursor mo27981b(String str) {
        SQLiteDatabase sQLiteDatabase = this.f18295b;
        if (sQLiteDatabase != null) {
            return C5732b.m23076a(sQLiteDatabase, str);
        }
        return null;
    }

    /* renamed from: b */
    public final boolean mo27982b() {
        return this.f18295b != null;
    }

    /* renamed from: c */
    public final void mo27983c() {
        SQLiteDatabase sQLiteDatabase = this.f18295b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.f18295b = null;
        }
    }

    /* renamed from: d */
    public final SQLiteDatabase mo27984d() {
        return this.f18295b;
    }
}
