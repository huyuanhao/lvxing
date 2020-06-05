package com.bytedance.tea.crash.p213b.p215b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.p221g.NpthLog;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;

/* renamed from: com.bytedance.tea.crash.b.b.a */
public abstract class AbsDAO<T> {
    /* renamed from: a */
    protected final String f9260a = C7887a.f26833ID;
    /* renamed from: b */
    protected final String f9261b;

    /* renamed from: a */
    public abstract ContentValues mo16981a(T t);

    /* renamed from: a */
    public abstract HashMap<String, String> mo16982a();

    protected AbsDAO(String str) {
        this.f9261b = str;
    }

    /* renamed from: a */
    public void mo16983a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.f9261b);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap a = mo16982a();
            if (a != null) {
                for (String str : a.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append((String) a.get(str));
                    sb.append(StorageInterface.KEY_SPLITER);
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo16984a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase != null && t != null) {
            try {
                sQLiteDatabase.insert(this.f9261b, null, mo16981a(t));
            } catch (Exception e) {
                NpthLog.m12550b(e);
            }
        }
    }
}
