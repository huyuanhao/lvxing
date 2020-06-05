package com.p522qq.p523e.comm.p525pi;

import com.p522qq.p523e.ads.cfg.DownAPPConfirmPolicy;
import com.p522qq.p523e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.comm.pi.UBVI */
public interface UBVI {
    public static final Map<String, String> ext = new HashMap();

    void destroy();

    void fetchAd();

    void onWindowFocusChanged(boolean z);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setRefresh(int i);
}
