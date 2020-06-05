package com.kwai.filedownloader.download;

import com.kwai.filedownloader.p358f.C4664f;

/* renamed from: com.kwai.filedownloader.download.a */
public class C4628a {
    /* renamed from: a */
    final long f15095a;
    /* renamed from: b */
    final long f15096b;
    /* renamed from: c */
    final long f15097c;
    /* renamed from: d */
    final long f15098d;

    C4628a(long j, long j2, long j3, long j4) {
        this.f15095a = j;
        this.f15096b = j2;
        this.f15097c = j3;
        this.f15098d = j4;
    }

    public String toString() {
        return C4664f.m19135a("range[%d, %d) current offset[%d]", Long.valueOf(this.f15095a), Long.valueOf(this.f15097c), Long.valueOf(this.f15096b));
    }
}
