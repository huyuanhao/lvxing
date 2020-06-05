package com.kwai.filedownloader.p356d;

import android.content.ContentValues;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.List;

/* renamed from: com.kwai.filedownloader.d.a */
public class C4618a {
    /* renamed from: a */
    private int f15030a;
    /* renamed from: b */
    private int f15031b;
    /* renamed from: c */
    private long f15032c;
    /* renamed from: d */
    private long f15033d;
    /* renamed from: e */
    private long f15034e;

    /* renamed from: a */
    public static long m18899a(List<C4618a> list) {
        long j = 0;
        for (C4618a aVar : list) {
            j += aVar.mo25057d() - aVar.mo25055c();
        }
        return j;
    }

    /* renamed from: a */
    public int mo25049a() {
        return this.f15030a;
    }

    /* renamed from: a */
    public void mo25050a(int i) {
        this.f15030a = i;
    }

    /* renamed from: a */
    public void mo25051a(long j) {
        this.f15032c = j;
    }

    /* renamed from: b */
    public int mo25052b() {
        return this.f15031b;
    }

    /* renamed from: b */
    public void mo25053b(int i) {
        this.f15031b = i;
    }

    /* renamed from: b */
    public void mo25054b(long j) {
        this.f15033d = j;
    }

    /* renamed from: c */
    public long mo25055c() {
        return this.f15032c;
    }

    /* renamed from: c */
    public void mo25056c(long j) {
        this.f15034e = j;
    }

    /* renamed from: d */
    public long mo25057d() {
        return this.f15033d;
    }

    /* renamed from: e */
    public long mo25058e() {
        return this.f15034e;
    }

    /* renamed from: f */
    public ContentValues mo25059f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f15030a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f15031b));
        contentValues.put("startOffset", Long.valueOf(this.f15032c));
        contentValues.put("currentOffset", Long.valueOf(this.f15033d));
        contentValues.put("endOffset", Long.valueOf(this.f15034e));
        return contentValues;
    }

    public String toString() {
        return C4664f.m19135a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f15030a), Integer.valueOf(this.f15031b), Long.valueOf(this.f15032c), Long.valueOf(this.f15034e), Long.valueOf(this.f15033d));
    }
}
