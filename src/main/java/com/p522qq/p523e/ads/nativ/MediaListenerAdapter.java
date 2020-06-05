package com.p522qq.p523e.ads.nativ;

import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.MediaListenerAdapter */
public class MediaListenerAdapter implements ADListener {
    /* renamed from: a */
    private MediaListener f20050a;

    public MediaListenerAdapter(MediaListener mediaListener) {
        this.f20050a = mediaListener;
    }

    public void onADEvent(ADEvent aDEvent) {
        String str = "NativeMedia ADEvent Paras error!";
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                    GDTLogger.m25260e(str);
                    break;
                } else {
                    this.f20050a.onVideoReady((long) ((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                }
            case 2:
                this.f20050a.onVideoStart();
                return;
            case 3:
                this.f20050a.onVideoPause();
                return;
            case 4:
                this.f20050a.onVideoComplete();
                return;
            case 5:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                    GDTLogger.m25260e(str);
                    return;
                } else {
                    this.f20050a.onVideoError(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
            case 6:
                this.f20050a.onReplayButtonClicked();
                return;
            case 7:
                this.f20050a.onADButtonClicked();
                return;
            case 8:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Boolean)) {
                    GDTLogger.m25260e(str);
                    break;
                } else {
                    this.f20050a.onFullScreenChanged(((Boolean) aDEvent.getParas()[0]).booleanValue());
                    return;
                }
        }
    }
}
