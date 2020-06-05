package com.p530ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;

/* renamed from: com.ss.android.socialbase.downloader.impls.i */
public class DefaultIdGenerator implements IDownloadIdGenerator {
    /* renamed from: a */
    public int mo32011a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String d = DownloadUtils.m28806d(String.format("%s_%s", new Object[]{str, str2}));
        if (TextUtils.isEmpty(d)) {
            return 0;
        }
        return d.hashCode();
    }
}
