package discoveryAD;

import android.util.SparseArray;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.IProRequestCallback;
import com.tencent.qqpim.discovery.internal.model.C7486a;
import java.util.List;

/* renamed from: discoveryAD.d */
public class C7892d {

    /* renamed from: discoveryAD.d$a */
    public interface C7893a {
        /* renamed from: a */
        void mo38200a(SparseArray<List<C7486a>> sparseArray);

        /* renamed from: a */
        void mo38201a(SparseArray<List<C7486a>> sparseArray, int i);
    }

    public C7892d() {
        C7852Aa.m34156i("AdNetMgr()");
    }

    /* renamed from: a */
    public void mo38199a(List<AdRequestData> list, C7893a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("AdNetMgr_getAds():");
        sb.append(list.toString());
        C7852Aa.m34156i(sb.toString());
        for (AdRequestData adRequestData : list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("send ad req : ");
            sb2.append(adRequestData.positionId);
            C7852Aa.m34150L(sb2.toString());
        }
        C7929sa.m34340a(list, (IProRequestCallback) new C7890c(this, aVar, list), 10000);
    }
}
