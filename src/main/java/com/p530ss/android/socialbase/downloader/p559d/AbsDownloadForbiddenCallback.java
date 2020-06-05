package com.p530ss.android.socialbase.downloader.p559d;

import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.d.a */
public abstract class AbsDownloadForbiddenCallback implements IDownloadForbiddenCallback {
    /* renamed from: a */
    private boolean f21789a = false;

    /* renamed from: a */
    public void mo31729a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f21789a = true;
        }
    }

    /* renamed from: a */
    public boolean mo31730a() {
        return this.f21789a;
    }
}
