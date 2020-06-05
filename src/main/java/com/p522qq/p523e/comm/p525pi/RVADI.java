package com.p522qq.p523e.comm.p525pi;

import android.app.Activity;
import com.p522qq.p523e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.RVADI */
public interface RVADI {
    String getAdNetWorkName();

    int getECPM();

    String getECPMLevel();

    long getExpireTimestamp();

    boolean hasShown();

    void loadAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setVolumeOn(boolean z);

    void showAD();

    void showAD(Activity activity);
}
