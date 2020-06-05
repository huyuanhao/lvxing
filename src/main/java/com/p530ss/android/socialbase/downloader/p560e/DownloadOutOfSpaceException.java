package com.p530ss.android.socialbase.downloader.p560e;

import androidx.core.view.PointerIconCompat;

/* renamed from: com.ss.android.socialbase.downloader.e.e */
public class DownloadOutOfSpaceException extends BaseException {
    /* renamed from: a */
    private final long f21944a;
    /* renamed from: b */
    private final long f21945b;

    public DownloadOutOfSpaceException(long j, long j2) {
        super((int) PointerIconCompat.TYPE_CELL, String.format("space is not enough required space is : %s but available space is :%s", new Object[]{String.valueOf(j2), String.valueOf(j)}));
        this.f21944a = j;
        this.f21945b = j2;
    }

    /* renamed from: c */
    public long mo32086c() {
        return this.f21944a;
    }

    /* renamed from: d */
    public long mo32087d() {
        return this.f21945b;
    }
}
