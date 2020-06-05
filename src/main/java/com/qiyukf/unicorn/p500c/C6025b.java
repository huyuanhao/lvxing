package com.qiyukf.unicorn.p500c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qiyukf.unicorn.C6029d;
import java.io.File;

/* renamed from: com.qiyukf.unicorn.c.b */
public final class C6025b extends SQLiteOpenHelper {

    /* renamed from: com.qiyukf.unicorn.c.b$a */
    interface C6028a {
        /* renamed from: a */
        String[] mo28868a();

        /* renamed from: b */
        String[] mo28869b();
    }

    public C6025b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getApplicationInfo().dataDir);
        String str = "/";
        sb.append(str);
        sb.append(C6029d.m24043d());
        sb.append(str);
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("unicorn.db");
        this(context, sb3.toString());
    }

    private C6025b(Context context, String str) {
        super(context, str, null, 1);
    }

    /* renamed from: a */
    private static void m24017a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        for (String execSQL : strArr) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    /* renamed from: a */
    private C6028a[] m24018a() {
        return new C6028a[]{new C6028a() {
            /* renamed from: a */
            public final String[] mo28868a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS staffInfo(staffNimId Varchar(32) NOT NULL, staffName Varchar(256), staffAvatar Varchar(256))", "CREATE UNIQUE INDEX IF NOT EXISTS staffInfo_staffNimId_index ON staffInfo(staffNimId)"};
            }

            /* renamed from: b */
            public final String[] mo28869b() {
                return new String[0];
            }
        }, new C6028a() {
            /* renamed from: a */
            public final String[] mo28868a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS shopInfo(shopId Varchar(32) NOT NULL, shopName Varchar(256), shopAvatar Varchar(256))", "CREATE UNIQUE INDEX IF NOT EXISTS shopInfo_shopId_index ON shopInfo(shopId)"};
            }

            /* renamed from: b */
            public final String[] mo28869b() {
                return new String[0];
            }
        }};
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C6028a[] a = m24018a();
        for (int i = 0; i < 2; i++) {
            m24017a(sQLiteDatabase, a[i].mo28868a());
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            C6028a[] a = m24018a();
            for (int i3 = 0; i3 < 2; i3++) {
                m24017a(sQLiteDatabase, a[i3].mo28869b());
            }
            i++;
        }
    }
}
