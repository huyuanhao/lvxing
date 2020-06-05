package shanhuAD;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.C7479Ad;
import com.tencent.qqpim.discovery.NativeAdList;
import java.util.ArrayList;
import java.util.List;

/* renamed from: shanhuAD.c */
public class C8677c {
    /* renamed from: a */
    public static List<AdDisplayModel> m37688a(C7479Ad ad) {
        if (ad == null) {
            return null;
        }
        NativeAdList nativeAdList = (NativeAdList) ad;
        if (nativeAdList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        SparseArray ads = nativeAdList.getAds();
        for (int i = 0; i < ads.size(); i++) {
            List<AdDisplayModel> list = (List) ads.get(ads.keyAt(i));
            if (list != null) {
                for (AdDisplayModel adDisplayModel : list) {
                    if (adDisplayModel.sdkADRequest) {
                        arrayList.clear();
                        arrayList.add(adDisplayModel);
                        return arrayList;
                    }
                    arrayList.add(adDisplayModel);
                }
                continue;
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static Bitmap m37690e(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    /* renamed from: a */
    public static AdDisplayModel m37687a(C7479Ad ad, boolean z) {
        if (ad == null) {
            return null;
        }
        NativeAdList nativeAdList = (NativeAdList) ad;
        if (nativeAdList == null) {
            return null;
        }
        SparseArray ads = nativeAdList.getAds();
        for (int i = 0; i < ads.size(); i++) {
            List<AdDisplayModel> list = (List) ads.get(ads.keyAt(i));
            if (list != null) {
                for (AdDisplayModel adDisplayModel : list) {
                    if (z == adDisplayModel.sdkADRequest) {
                        return adDisplayModel;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m37689a(SparseArray<List<AdDisplayModel>> sparseArray, List<AdRequestData> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdLoaded get ad groups size : ");
        sb.append(sparseArray.size());
        String str = "testAD";
        Log.d(str, sb.toString());
        for (AdRequestData adRequestData : list) {
            List<AdDisplayModel> list2 = (List) sparseArray.get(adRequestData.positionId);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("---- positionId : ");
            sb2.append(adRequestData.positionId);
            Log.d(str, sb2.toString());
            if (list2 != null) {
                for (AdDisplayModel adDisplayModel : list2) {
                    String str2 = "onAdLoaded get ad : ";
                    if (adDisplayModel.sdkADRequest) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(adDisplayModel.toSDKString());
                        Log.d(str, sb3.toString());
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        sb4.append(adDisplayModel.toString());
                        Log.d(str, sb4.toString());
                    }
                }
            }
        }
    }
}
