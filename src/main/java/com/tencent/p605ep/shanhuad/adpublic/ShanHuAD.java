package com.tencent.p605ep.shanhuad.adpublic;

import android.content.Context;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.DiscoverySdk;
import com.tencent.qqpim.discovery.NativeAd;
import shanhuAD.C8679e;

/* renamed from: com.tencent.ep.shanhuad.adpublic.ShanHuAD */
public class ShanHuAD {
    /* renamed from: Xj */
    private static boolean f24750Xj = false;

    public static synchronized void init(Context context, H5BrowserListener h5BrowserListener, int i) {
        synchronized (ShanHuAD.class) {
            if (!f24750Xj) {
                DiscoverySdk.sdkInitialize(context, i);
                DiscoverySdk.getInstance();
                DiscoverySdk.getInstance().setIH5Browser(new C8679e(h5BrowserListener));
                DiscoverySdk.setDownLoadSupport(false);
                f24750Xj = true;
            }
        }
    }

    public static void reportActive(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 8, 0);
    }

    public static void reportDownloadFinish(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 6, 0);
    }

    public static void reportInstalled(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 7, 0);
    }

    public static void reportStartDownload(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 5, 0);
    }
}
