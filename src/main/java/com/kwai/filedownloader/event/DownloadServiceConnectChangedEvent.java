package com.kwai.filedownloader.event;

public class DownloadServiceConnectChangedEvent extends C4646b {
    /* renamed from: c */
    private final ConnectStatus f15165c;
    /* renamed from: d */
    private final Class<?> f15166d;

    /* renamed from: com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent$ConnectStatus */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f15165c = connectStatus;
        this.f15166d = cls;
    }

    /* renamed from: a */
    public ConnectStatus mo25201a() {
        return this.f15165c;
    }
}
