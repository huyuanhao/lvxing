package com.bytedance.tea.crash.p213b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.p213b.p214a.DuplicateLog;
import com.bytedance.tea.crash.p213b.p215b.DuplicateLogDAO;
import com.bytedance.tea.crash.p221g.NpthLog;

/* renamed from: com.bytedance.tea.crash.b.a */
public class NpthDataManager {
    /* renamed from: a */
    private static volatile NpthDataManager f9255a;
    /* renamed from: b */
    private DuplicateLogDAO f9256b;
    /* renamed from: c */
    private SQLiteDatabase f9257c;

    private NpthDataManager() {
    }

    /* renamed from: a */
    public static NpthDataManager m12329a() {
        if (f9255a == null) {
            synchronized (NpthDataManager.class) {
                if (f9255a == null) {
                    f9255a = new NpthDataManager();
                }
            }
        }
        return f9255a;
    }

    /* renamed from: a */
    public void mo16976a(Context context) {
        try {
            this.f9257c = new NpthDbHelper(context).getWritableDatabase();
        } catch (Throwable th) {
            NpthLog.m12550b(th);
        }
        this.f9256b = new DuplicateLogDAO();
    }

    /* renamed from: a */
    public synchronized void mo16977a(DuplicateLog aVar) {
        if (this.f9256b != null) {
            this.f9256b.mo16984a(this.f9257c, aVar);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo16978a(String str) {
        if (this.f9256b == null) {
            return false;
        }
        return this.f9256b.mo16987a(this.f9257c, str);
    }
}
