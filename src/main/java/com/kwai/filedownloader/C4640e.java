package com.kwai.filedownloader;

import com.kwai.filedownloader.event.C4646b;
import com.kwai.filedownloader.event.C4647c;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus;

/* renamed from: com.kwai.filedownloader.e */
public abstract class C4640e extends C4647c {
    /* renamed from: a */
    private ConnectStatus f15161a;

    /* renamed from: a */
    public abstract void mo25190a();

    /* renamed from: a */
    public boolean mo25191a(C4646b bVar) {
        if (bVar instanceof DownloadServiceConnectChangedEvent) {
            this.f15161a = ((DownloadServiceConnectChangedEvent) bVar).mo25201a();
            if (this.f15161a == ConnectStatus.connected) {
                mo25190a();
            } else {
                mo25192b();
            }
        }
        return false;
    }

    /* renamed from: b */
    public abstract void mo25192b();

    /* renamed from: c */
    public ConnectStatus mo25193c() {
        return this.f15161a;
    }
}
