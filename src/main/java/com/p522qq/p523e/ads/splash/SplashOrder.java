package com.p522qq.p523e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.managers.plugin.C6422c;
import com.p522qq.p523e.comm.p525pi.SOI;
import com.p522qq.p523e.comm.p525pi.SOI.AdProductType;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.splash.SplashOrder */
public class SplashOrder {
    /* renamed from: a */
    private SOI f20157a;

    public SplashOrder(Context context, String str) {
        String str2;
        if (StringUtil.isEmpty(str)) {
            str2 = "initSplashOrder fail with error params";
        } else {
            try {
                if (!GDTADManager.getInstance().initWith(context, str)) {
                    GDTLogger.m25260e("SDK is not ready!");
                    return;
                } else {
                    this.f20157a = GDTADManager.getInstance().getPM().getPOFactory().getSplashOrderDelegate();
                    return;
                }
            } catch (C6422c unused) {
                str2 = "SplashOrder created by factory return null";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        GDTLogger.m25260e(str2);
    }

    public void clickJoinAd(View view) {
        SOI soi = this.f20157a;
        if (soi != null) {
            soi.clickJoinAd(view);
        }
    }

    public void exposureJoinAd(View view, long j) {
        SOI soi = this.f20157a;
        if (soi != null) {
            soi.exposureJoinAd(view, j);
        }
    }

    public Bitmap getJoinAdImage(Options options) {
        SOI soi = this.f20157a;
        if (soi != null) {
            return soi.getJoinAdImage(options);
        }
        return null;
    }

    public Bitmap getOneshotCoverImage(Options options) {
        SOI soi = this.f20157a;
        if (soi != null) {
            return soi.getOneshotCoverImage(options);
        }
        return null;
    }

    public String getOneshotCoverImagePath() {
        SOI soi = this.f20157a;
        if (soi != null) {
            return soi.getOneshotCoverImagePath();
        }
        return null;
    }

    public AdProductType getSplashProductType() {
        SOI soi = this.f20157a;
        return soi != null ? soi.getSplashProductType() : AdProductType.UNKNOWN;
    }

    public boolean isJoinAd() {
        SOI soi = this.f20157a;
        if (soi != null) {
            return soi.isJoinAd();
        }
        return false;
    }

    public void reportJoinAdCost(int i) {
        SOI soi = this.f20157a;
        if (soi != null) {
            soi.reportJoinAdCost(i);
        }
    }
}
