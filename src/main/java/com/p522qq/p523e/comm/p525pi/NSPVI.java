package com.p522qq.p523e.comm.p525pi;

import android.view.View;
import android.view.ViewGroup;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.comm.pi.NSPVI */
public interface NSPVI {
    public static final Map<String, String> ext = new HashMap();

    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    void preload();

    void setAdListener(ADListener aDListener);

    void setAdLogoMargin(int i, int i2);

    void setFetchDelay(int i);

    void setFloatView(View view);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setPreloadView(View view);

    void setSkipView(View view);

    void showAd(ViewGroup viewGroup);
}
