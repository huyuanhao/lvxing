package com.p522qq.p523e.comm.p525pi;

import android.view.View;
import com.p522qq.p523e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.BVI */
public interface BVI {
    void destroy();

    void fetchAd();

    View getView();

    void setAdListener(ADListener aDListener);

    void setDownAPPConfirmPolicy(int i);

    void setRefresh(int i);

    void setRollAnimation(int i);

    void setShowCloseButton(boolean z);
}
