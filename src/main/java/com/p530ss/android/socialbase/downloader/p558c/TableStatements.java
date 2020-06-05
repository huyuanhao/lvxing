package com.p530ss.android.socialbase.downloader.p558c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.p530ss.android.socialbase.downloader.p569m.SqlUtils;

/* renamed from: com.ss.android.socialbase.downloader.c.g */
public class TableStatements {
    /* renamed from: a */
    private final SQLiteDatabase f21782a;
    /* renamed from: b */
    private final String f21783b;
    /* renamed from: c */
    private final String[] f21784c;
    /* renamed from: d */
    private final String[] f21785d;
    /* renamed from: e */
    private SQLiteStatement f21786e;
    /* renamed from: f */
    private SQLiteStatement f21787f;
    /* renamed from: g */
    private SQLiteStatement f21788g;

    public TableStatements(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f21782a = sQLiteDatabase;
        this.f21783b = str;
        this.f21784c = strArr;
        this.f21785d = strArr2;
    }

    /* renamed from: a */
    public SQLiteStatement mo31726a() {
        if (this.f21786e == null) {
            SQLiteStatement compileStatement = this.f21782a.compileStatement(SqlUtils.m28943a("INSERT INTO ", this.f21783b, this.f21784c));
            synchronized (this) {
                if (this.f21786e == null) {
                    this.f21786e = compileStatement;
                }
            }
            if (this.f21786e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f21786e;
    }

    /* renamed from: b */
    public SQLiteStatement mo31727b() {
        if (this.f21788g == null) {
            SQLiteStatement compileStatement = this.f21782a.compileStatement(SqlUtils.m28944a(this.f21783b, this.f21785d));
            synchronized (this) {
                if (this.f21788g == null) {
                    this.f21788g = compileStatement;
                }
            }
            if (this.f21788g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f21788g;
    }

    /* renamed from: c */
    public SQLiteStatement mo31728c() {
        if (this.f21787f == null) {
            SQLiteStatement compileStatement = this.f21782a.compileStatement(SqlUtils.m28945a(this.f21783b, this.f21784c, this.f21785d));
            synchronized (this) {
                if (this.f21787f == null) {
                    this.f21787f = compileStatement;
                }
            }
            if (this.f21787f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f21787f;
    }
}
