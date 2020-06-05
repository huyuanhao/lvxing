package com.p530ss.android.downloadlib;

import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.p531a.p532a.DownloadConfigure;
import com.p530ss.android.p531a.p532a.p533a.AppStatusChangeListener;
import com.p530ss.android.p531a.p532a.p533a.DownloadEventLogger;
import com.p530ss.android.p531a.p532a.p533a.DownloadNetworkFactory;
import com.p530ss.android.p531a.p532a.p533a.DownloadPermissionChecker;
import com.p530ss.android.p531a.p532a.p533a.DownloadSettings;
import com.p530ss.android.p531a.p532a.p533a.DownloadUIFactory;
import com.p530ss.android.p531a.p532a.p536c.C6512a;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppStatusChangeListener;

/* renamed from: com.ss.android.downloadlib.e */
class DownloadConfigureImpl implements DownloadConfigure {
    DownloadConfigureImpl() {
    }

    /* renamed from: a */
    public DownloadConfigure mo31023a(DownloadPermissionChecker gVar) {
        C6565j.m26362a(gVar);
        return this;
    }

    /* renamed from: a */
    public DownloadConfigure mo31021a(DownloadEventLogger eVar) {
        C6565j.m26360a(eVar);
        return this;
    }

    /* renamed from: a */
    public DownloadConfigure mo31025a(DownloadUIFactory jVar) {
        C6565j.m26364a(jVar);
        return this;
    }

    /* renamed from: a */
    public DownloadConfigure mo31022a(DownloadNetworkFactory fVar) {
        C6565j.m26361a(fVar);
        return this;
    }

    /* renamed from: a */
    public DownloadConfigure mo31024a(DownloadSettings hVar) {
        C6565j.m26363a(hVar);
        return this;
    }

    /* renamed from: a */
    public DownloadConfigure mo31026a(C6512a aVar) {
        C6565j.m26365a(aVar);
        return this;
    }

    /* renamed from: a */
    public DownloadConfigure mo31027a(String str) {
        C6565j.m26366a(str);
        return this;
    }

    /* renamed from: a */
    public DownloadConfigure mo31020a(final AppStatusChangeListener aVar) {
        C6565j.m26359a(aVar);
        AppDownloader.m26714h().mo31482a((IAppStatusChangeListener) new IAppStatusChangeListener() {
            /* renamed from: a */
            public boolean mo31408a() {
                return aVar.mo16475a();
            }
        });
        return this;
    }
}
