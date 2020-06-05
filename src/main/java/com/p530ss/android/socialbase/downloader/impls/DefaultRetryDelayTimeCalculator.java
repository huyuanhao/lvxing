package com.p530ss.android.socialbase.downloader.impls;

import com.p530ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* renamed from: com.ss.android.socialbase.downloader.impls.j */
public class DefaultRetryDelayTimeCalculator implements IRetryDelayTimeCalculator {
    /* renamed from: a */
    public long mo32072a(int i, int i2) {
        if (i == 1) {
            return 3000;
        }
        if (i == 2) {
            return 15000;
        }
        if (i == 3) {
            return 30000;
        }
        return i > 3 ? 300000 : 0;
    }
}
