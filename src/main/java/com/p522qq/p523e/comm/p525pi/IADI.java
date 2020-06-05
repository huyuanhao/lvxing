package com.p522qq.p523e.comm.p525pi;

import android.app.Activity;
import com.p522qq.p523e.ads.cfg.DownAPPConfirmPolicy;
import com.p522qq.p523e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.IADI */
public interface IADI {
    void closePopupWindow();

    void destory();

    void loadAd();

    void setAdListener(ADListener aDListener);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void show();

    void show(Activity activity);

    void showAsPopupWindown();

    void showAsPopupWindown(Activity activity);
}
