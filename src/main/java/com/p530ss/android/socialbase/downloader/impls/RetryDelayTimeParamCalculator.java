package com.p530ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: com.ss.android.socialbase.downloader.impls.q */
public class RetryDelayTimeParamCalculator implements IRetryDelayTimeCalculator {
    /* renamed from: a */
    private final long[] f22240a;

    public RetryDelayTimeParamCalculator(String str) {
        this.f22240a = m28550a(str);
    }

    /* renamed from: a */
    public long mo32072a(int i, int i2) {
        long[] jArr = this.f22240a;
        if (jArr == null || jArr.length <= 0) {
            return 0;
        }
        int i3 = i - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        long[] jArr2 = this.f22240a;
        if (i3 > jArr2.length - 1) {
            i3 = jArr2.length - 1;
        }
        return this.f22240a[i3];
    }

    /* renamed from: a */
    private long[] m28550a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(StorageInterface.KEY_SPLITER);
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i = 0; i < split.length; i++) {
                jArr[i] = Long.parseLong(split[i]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
