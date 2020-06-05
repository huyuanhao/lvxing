package com.kwad.sdk.core.download;

public enum DOWNLOADSTAUS {
    UNKNOWN(0),
    START(1),
    DOWNLOADING(2),
    PROGRESS(3),
    PAUSED(4),
    CANCELLED(5),
    DELETED(6),
    FAILED(7),
    FINISHED(8),
    INSTALL(9),
    INSTALLING(10),
    INSTALL_FAILED(11),
    INSTALL_FINSHED(12);
    
    private int status;

    private DOWNLOADSTAUS(int i) {
        this.status = i;
    }
}
