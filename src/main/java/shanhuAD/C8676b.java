package shanhuAD;

import android.util.Log;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdListener;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.DiscoverySdk;
import com.tencent.qqpim.discovery.NativeAdList;
import com.tencent.qqpim.discovery.internal.protocol.GDTSDKReportItem;
import java.util.List;

/* renamed from: shanhuAD.b */
public class C8676b {
    /* renamed from: dk */
    protected NativeAdList f29515dk;
    /* access modifiers changed from: protected */
    /* renamed from: ek */
    public List<AdRequestData> f29516ek;
    /* access modifiers changed from: protected */
    public AdDisplayModel model;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo41444a(List<AdRequestData> list, AdListener adListener) {
        if (list != null && list.size() != 0) {
            this.f29516ek = list;
            Log.d("sharkImplLog", ((AdRequestData) list.get(0)).toString());
            this.f29515dk = new NativeAdList(list);
            this.f29515dk.setAdListener(adListener);
            this.f29515dk.loadRealtimeAd();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo41442a(int i, String str, String str2, int i2) {
        int i3 = i;
        if (i3 == 0) {
            mo41443a(11, true, "", str, str2, 0.0d, i2);
        } else if (i3 == 1) {
            mo41443a(12, true, "", str, str2, 0.0d, i2);
        } else if (i3 == 2) {
            mo41443a(13, true, "", str, str2, 0.0d, i2);
        } else if (i3 == 8) {
            mo41443a(14, true, "", str, str2, 0.0d, i2);
        } else if (i3 == 32) {
            mo41443a(16, true, "", str, str2, 0.0d, i2);
        } else if (i3 == 64) {
            mo41443a(17, true, "", str, str2, 0.0d, i2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo41443a(int i, boolean z, String str, String str2, String str3, double d, int i2) {
        GDTSDKReportItem gDTSDKReportItem = new GDTSDKReportItem();
        gDTSDKReportItem.adPullTimestamp = System.currentTimeMillis() / 1000;
        gDTSDKReportItem.gdtPositionId = str2;
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("");
        gDTSDKReportItem.positionId = sb.toString();
        gDTSDKReportItem.appId = str3;
        gDTSDKReportItem.reportState = i;
        gDTSDKReportItem.isSuccess = z;
        gDTSDKReportItem.errMsg = str;
        gDTSDKReportItem.ecpm = d / 100.0d;
        DiscoverySdk.getInstance().reportGDTSDK(gDTSDKReportItem);
    }
}
