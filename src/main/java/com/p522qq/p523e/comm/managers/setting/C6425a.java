package com.p522qq.p523e.comm.managers.setting;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.bugly.BuglyStrategy.C7120a;

/* renamed from: com.qq.e.comm.managers.setting.a */
public final class C6425a extends C6426b {
    public C6425a() {
        Integer valueOf = Integer.valueOf(1);
        mo30157a(KEYS.SDKServerGetADReportSamplingRate, valueOf);
        mo30157a(KEYS.SDKServerExpReportSamplingRate, valueOf);
        Integer valueOf2 = Integer.valueOf(100);
        mo30157a(KEYS.SDKServerClickReportSamplingRate, valueOf2);
        mo30157a(KEYS.RequireWindowFocus, valueOf);
        mo30157a(KEYS.SHOW_LOGO, valueOf);
        mo30157a(KEYS.INNER_BROWSER_SCHEME, "weixin,tel,openapp.jdmobile");
        mo30157a(KEYS.THIRD_PARTY_BROWSER, "com.android.browser,com.android.chrome,com.baidu.browser.apps,com.UCMobile,com.tencent.mtt");
        mo30157a(KEYS.FLOW_CONTROL, valueOf);
        mo30157a(KEYS.GDT_SDK_IDENTITY, valueOf);
        mo30157a(KEYS.Banner_RF, Integer.valueOf(C7120a.MAX_USERDATA_VALUE_LENGTH));
        mo30157a(KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(PathInterpolatorCompat.MAX_NUM_POINTS));
        mo30157a(KEYS.SPLASH_EXPOSURE_TIME, Integer.valueOf(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT));
        mo30157a(KEYS.SPLASH_NETWORK_PERMISION, Integer.valueOf(26));
        mo30157a(KEYS.SPLASH_MAX_REQUEST_NUM, valueOf2);
        mo30157a(KEYS.FORCE_EXPOSURE, valueOf);
    }
}
