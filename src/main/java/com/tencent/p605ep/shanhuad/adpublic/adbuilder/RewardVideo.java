package com.tencent.p605ep.shanhuad.adpublic.adbuilder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import com.p522qq.p523e.ads.rewardvideo.RewardVideoAD;
import com.p522qq.p523e.ads.rewardvideo.RewardVideoADListener;
import com.p522qq.p523e.comm.util.AdError;
import com.tencent.p605ep.shanhuad.adpublic.ADError;
import com.tencent.p605ep.shanhuad.adpublic.models.AdID;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdListener;
import com.tencent.qqpim.discovery.C7479Ad;
import com.tencent.qqpim.discovery.DiscoverySdk;
import com.tencent.qqpim.discovery.NativeAdList;
import com.tencent.qqpim.discovery.internal.protocol.GDTSDKReportItem;
import java.util.List;
import java.util.Locale;
import shanhuAD.C8675a;
import shanhuAD.C8676b;
import shanhuAD.C8677c;
import shanhuAD.C8680f;
import shanhuAD.C8684i;

/* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.RewardVideo */
public class RewardVideo extends C8676b {
    /* access modifiers changed from: private */
    /* renamed from: gk */
    public RVListener f24782gk;
    /* access modifiers changed from: private */
    /* renamed from: hk */
    public String f24783hk;
    /* access modifiers changed from: private */
    /* renamed from: ik */
    public String f24784ik;
    /* access modifiers changed from: private */
    /* renamed from: kk */
    public RewardVideoAD f24785kk;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public String positionId;
    /* access modifiers changed from: private */
    /* renamed from: wi */
    public AdDisplayModel f24786wi;

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.RewardVideo$AdListenerImpl */
    private class AdListenerImpl implements AdListener {
        private AdListenerImpl() {
        }

        public void onAdClicked(AdDisplayModel adDisplayModel) {
        }

        public void onAdClose(AdDisplayModel adDisplayModel) {
        }

        public void onAdLoaded(C7479Ad ad) {
            SparseArray ads = ((NativeAdList) ad).getAds();
            C8677c.m37689a(ads, RewardVideo.this.f29516ek);
            for (int i = 0; i < ads.size(); i++) {
                List<AdDisplayModel> list = (List) ads.get(ads.keyAt(i));
                if (list != null) {
                    for (AdDisplayModel adDisplayModel : list) {
                        if (!adDisplayModel.sdkADRequest) {
                            RewardVideo.this.f24786wi = adDisplayModel;
                            if (RewardVideo.this.f24782gk != null) {
                                RewardVideo.this.f24782gk.loaded();
                            }
                            return;
                        } else if (adDisplayModel.sdkType == 1) {
                            RewardVideo.this.f24783hk = adDisplayModel.sdkParamappid;
                            RewardVideo.this.f24784ik = adDisplayModel.sdkPosId;
                            RewardVideo rewardVideo = RewardVideo.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append(adDisplayModel.positionId);
                            String str = "";
                            sb.append(str);
                            rewardVideo.positionId = sb.toString();
                            RewardVideo rewardVideo2 = RewardVideo.this;
                            rewardVideo2.f24785kk = new RewardVideoAD(rewardVideo2.mContext, adDisplayModel.sdkParamappid, adDisplayModel.sdkPosId, (RewardVideoADListener) new RewardVideoADImpl());
                            RewardVideo.this.f24785kk.loadAD();
                            RewardVideo.this.m31598a(10, true, str);
                            return;
                        }
                    }
                    continue;
                }
            }
            if (RewardVideo.this.f24782gk != null) {
                RewardVideo.this.f24782gk.onAdError((ADError) C8675a.f29514ck.get(Integer.valueOf(100)));
            }
        }

        public void onAdShow(AdDisplayModel adDisplayModel) {
        }

        public void onError(C7479Ad ad, int i) {
            if (RewardVideo.this.f24782gk != null) {
                RewardVideo.this.f24782gk.onAdError((ADError) C8675a.f29514ck.get(Integer.valueOf(100)));
            }
        }
    }

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.RewardVideo$RVListener */
    public interface RVListener {
        void loaded();

        void onAdError(ADError aDError);

        void onClick();

        void onClose();

        void onVideoComplete();

        void onVideoPlay();
    }

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.RewardVideo$RewardVideoADImpl */
    private class RewardVideoADImpl implements RewardVideoADListener {
        private RewardVideoADImpl() {
        }

        public void onADClick() {
            Log.d("RewardVideoADImpl", "onADClick");
            RewardVideo.this.m31598a(6, true, "");
            if (RewardVideo.this.f24782gk != null) {
                RewardVideo.this.f24782gk.onClick();
            }
        }

        public void onADClose() {
            Log.d("RewardVideoADImpl", "onADClose");
            RewardVideo.this.m31598a(8, true, "");
            if (RewardVideo.this.f24782gk != null) {
                RewardVideo.this.f24782gk.onClose();
            }
        }

        public void onADExpose() {
            Log.d("RewardVideoADImpl", "onADExpose");
            RewardVideo.this.m31598a(4, true, "");
            if (RewardVideo.this.f24782gk != null) {
                RewardVideo.this.f24782gk.onVideoPlay();
            }
        }

        public void onADLoad() {
            if (RewardVideo.this.f24782gk != null) {
                RewardVideo.this.f24782gk.loaded();
            }
            RewardVideo.this.m31598a(1, true, "");
        }

        public void onADShow() {
            Log.d("RewardVideoADImpl", "onADShow");
            RewardVideo.this.m31598a(3, true, "");
        }

        public void onError(AdError adError) {
            String format = String.format(Locale.getDefault(), "onError, error code: %d, error msg: %s", new Object[]{Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg()});
            StringBuilder sb = new StringBuilder();
            sb.append("adError : ");
            sb.append(format);
            Log.d("RewardVideoADImpl", sb.toString());
            if (RewardVideo.this.f24782gk != null) {
                ADError aDError = (ADError) C8675a.f29514ck.get(Integer.valueOf(101));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aDError.msg);
                sb2.append(" gdt code ");
                sb2.append(adError.getErrorCode());
                sb2.append(" , gdt msg ");
                sb2.append(adError.getErrorMsg());
                aDError.msg = sb2.toString();
                RewardVideo.this.f24782gk.onAdError(aDError);
            }
            RewardVideo.this.m31598a(0, false, adError.getErrorMsg());
        }

        public void onReward() {
            Log.d("RewardVideoADImpl", "onReward");
            RewardVideo.this.m31598a(5, true, "");
        }

        public void onVideoCached() {
            Log.d("RewardVideoADImpl", "onVideoCached");
            RewardVideo.this.m31598a(2, true, "");
        }

        public void onVideoComplete() {
            Log.d("RewardVideoADImpl", "onVideoComplete");
            RewardVideo.this.m31598a(7, true, "");
            if (RewardVideo.this.f24782gk != null) {
                RewardVideo.this.f24782gk.onVideoComplete();
            }
        }
    }

    public void load(RVListener rVListener, Context context, AdID adID) {
        this.mContext = context;
        this.f24782gk = rVListener;
        super.mo41444a(C8680f.m37692a(adID, 7, 1), new AdListenerImpl());
    }

    public void showAD() {
        RewardVideoAD rewardVideoAD = this.f24785kk;
        if (rewardVideoAD != null) {
            rewardVideoAD.showAD();
        } else if (this.f24786wi != null) {
            Intent intent = new Intent(this.mContext, RewardVedioPage.class);
            intent.putExtra(RewardVedioPage.INTENT_AD_MODEL, this.f24786wi);
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
            C8684i.getInstance().mo41448a(this.f24786wi.uniqueKey, this.f24782gk);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31598a(int i, boolean z, String str) {
        GDTSDKReportItem gDTSDKReportItem = new GDTSDKReportItem();
        gDTSDKReportItem.adPullTimestamp = System.currentTimeMillis() / 1000;
        gDTSDKReportItem.gdtPositionId = this.f24784ik;
        gDTSDKReportItem.appId = this.f24783hk;
        gDTSDKReportItem.positionId = this.positionId;
        gDTSDKReportItem.reportState = i;
        gDTSDKReportItem.isSuccess = z;
        gDTSDKReportItem.errMsg = str;
        gDTSDKReportItem.ecpm = 0.0d;
        DiscoverySdk.getInstance().reportGDTSDK(gDTSDKReportItem);
    }
}
