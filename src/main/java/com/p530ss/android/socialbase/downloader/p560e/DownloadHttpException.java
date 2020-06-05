package com.p530ss.android.socialbase.downloader.p560e;

/* renamed from: com.ss.android.socialbase.downloader.e.c */
public class DownloadHttpException extends BaseException {
    /* renamed from: a */
    private final int f21943a;

    public DownloadHttpException(int i, int i2, String str) {
        super(i, str);
        this.f21943a = i2;
    }

    /* renamed from: c */
    public int mo32085c() {
        return this.f21943a;
    }
}
