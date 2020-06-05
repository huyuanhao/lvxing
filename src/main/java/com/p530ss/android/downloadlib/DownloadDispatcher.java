package com.p530ss.android.downloadlib;

import android.content.Context;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener;
import com.p530ss.android.p531a.p532a.p534b.p535a.DownloadCompletedListener;

/* renamed from: com.ss.android.downloadlib.f */
interface DownloadDispatcher {
    /* renamed from: a */
    void mo31412a(Context context, int i, DownloadStatusChangeListener dVar, C6507c cVar);

    /* renamed from: a */
    void mo31413a(DownloadCompletedListener aVar);

    /* renamed from: a */
    void mo31414a(String str, int i);

    /* renamed from: a */
    void mo31415a(String str, long j, int i);

    /* renamed from: a */
    void mo31416a(String str, long j, int i, DownloadEventConfig bVar, DownloadController aVar);

    /* renamed from: a */
    void mo31417a(String str, boolean z);
}
