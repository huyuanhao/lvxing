package discoveryAD;

import com.tencent.p605ep.common.adapt.ServiceCenter;
import com.tencent.p605ep.common.adapt.iservice.IReportService;
import com.tencent.p605ep.commonbase.api.Log;

/* renamed from: discoveryAD.O */
public class C7873O {
    /* renamed from: Md */
    private static C7873O f26774Md;
    private final String TAG = "FeatureReportProxy";

    private C7873O() {
    }

    public static C7873O getInstance() {
        if (f26774Md == null) {
            synchronized (C7873O.class) {
                if (f26774Md == null) {
                    f26774Md = new C7873O();
                }
            }
        }
        return f26774Md;
    }

    /* renamed from: qb */
    private boolean m34236qb() {
        if (ServiceCenter.get(IReportService.class) != null) {
            return true;
        }
        Log.m31487w("FeatureReportProxy", "please implement IFeatureReport interface,then set into DiscoverySdk");
        return false;
    }

    public void reportString(int i, String str, int i2) {
        if (m34236qb()) {
            ((IReportService) ServiceCenter.get(IReportService.class)).reportString(i, str, i2);
        }
    }
}
