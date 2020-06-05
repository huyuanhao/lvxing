package com.p530ss.android.socialbase.downloader.impls;

import com.p530ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.p530ss.android.socialbase.downloader.p564i.NetworkQuality;

/* renamed from: com.ss.android.socialbase.downloader.impls.b */
public class DefaultChunkAdjustCalculator implements IChunkAdjustCalculator {
    /* renamed from: a */
    public int mo31305a(int i, NetworkQuality hVar) {
        if (hVar.ordinal() <= NetworkQuality.MODERATE.ordinal()) {
            return 1;
        }
        return hVar == NetworkQuality.GOOD ? i - 1 : i;
    }
}
