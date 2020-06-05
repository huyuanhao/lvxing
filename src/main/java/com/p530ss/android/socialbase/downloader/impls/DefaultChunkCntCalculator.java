package com.p530ss.android.socialbase.downloader.impls;

import com.p530ss.android.socialbase.downloader.downloader.IChunkCntCalculator;

/* renamed from: com.ss.android.socialbase.downloader.impls.c */
public class DefaultChunkCntCalculator implements IChunkCntCalculator {
    /* renamed from: a */
    public int mo31302a(long j) {
        if (j < 10485760) {
            return 1;
        }
        if (j < 52428800) {
            return 2;
        }
        return j < 104857600 ? 3 : 4;
    }
}
