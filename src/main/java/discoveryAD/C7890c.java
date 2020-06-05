package discoveryAD;

import android.util.SparseArray;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.IProRequestCallback;
import com.tencent.qqpim.discovery.internal.model.C7486a;
import com.tencent.qqpim.discovery.internal.protocol.C7496E;
import com.tencent.qqpim.discovery.internal.protocol.C7498G;
import com.tencent.qqpim.discovery.internal.protocol.C7499H;
import com.tencent.qqpim.discovery.internal.protocol.C7524x;
import discoveryAD.C7892d.C7893a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: discoveryAD.c */
class C7890c implements IProRequestCallback {
    /* renamed from: Ac */
    final /* synthetic */ List f26880Ac;
    final /* synthetic */ C7892d this$0;
    final /* synthetic */ C7893a val$callback;

    C7890c(C7892d dVar, C7893a aVar, List list) {
        this.this$0 = dVar;
        this.val$callback = aVar;
        this.f26880Ac = list;
    }

    public void onCallback(int i, JceStruct jceStruct) {
        if (i != 0) {
            this.val$callback.mo38201a(null, 4);
            return;
        }
        C7496E e = (C7496E) jceStruct;
        if (e == null) {
            this.val$callback.mo38201a(null, 4);
            return;
        }
        ArrayList<C7498G> arrayList = e.f25110Pb;
        if (C7931ta.m34347g(arrayList)) {
            this.val$callback.mo38201a(null, 4);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" ad back , advPositonResps size : ");
        sb.append(arrayList.size());
        C7852Aa.m34150L(sb.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C7498G g = (C7498G) it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("---------------------------- ad posid :");
            sb2.append(g.positionId);
            sb2.append(" advPositonResps.vecSecureAdvertise size : ");
            sb2.append(g.f25115Rb.size());
            C7852Aa.m34150L(sb2.toString());
            C7524x xVar = g.f25117xa;
            String str = "sharkImplLog";
            if (xVar == null || !xVar.f25286Gb) {
                Iterator it2 = g.f25115Rb.iterator();
                while (it2.hasNext()) {
                    C7499H h = (C7499H) it2.next();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("api ad ,type : ");
                    sb3.append(h.f25121Ub.content.contentType);
                    sb3.append(" ,context size: ");
                    sb3.append(h.f25121Ub.context.length);
                    C7852Aa.m34150L(sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(" expireTime : ");
                    sb4.append(h.f25121Ub.f25152sa);
                    sb4.append(" , advId : ");
                    sb4.append(h.f25121Ub.f25154va);
                    Log.m31477d(str, sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(" displayCtrl : ");
                    sb5.append(h.f25121Ub.f25155wa.toString());
                    Log.m31477d(str, sb5.toString());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(" content.contentType : ");
                    sb6.append(h.f25121Ub.content.contentType);
                    Log.m31477d(str, sb6.toString());
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(" content.jumpUrl : ");
                    sb7.append(h.f25121Ub.content.jumpUrl);
                    Log.m31477d(str, sb7.toString());
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(" content.appDownloadUrl : ");
                    sb8.append(h.f25121Ub.content.appDownloadUrl);
                    Log.m31477d(str, sb8.toString());
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(" content.desttype : ");
                    sb9.append(h.f25121Ub.content.f25176Ma);
                    Log.m31477d(str, sb9.toString());
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(" content.producttype : ");
                    sb10.append(h.f25121Ub.content.f25177Na);
                    Log.m31477d(str, sb10.toString());
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(" content.customedUrl : ");
                    sb11.append(h.f25121Ub.content.f25178Oa);
                    Log.m31477d(str, sb11.toString());
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(" content.adTagType : ");
                    sb12.append(h.f25121Ub.content.f25179Pa);
                    Log.m31477d(str, sb12.toString());
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(" content.channelId : ");
                    sb13.append(h.f25121Ub.content.channelId);
                    Log.m31477d(str, sb13.toString());
                    if (h.f25121Ub.content.f25181Ra != null) {
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append(" content.externalResourceExtraData : ");
                        sb14.append(h.f25121Ub.content.f25181Ra.toString());
                        Log.m31477d(str, sb14.toString());
                        StringBuilder sb15 = new StringBuilder();
                        sb15.append(" content.eventTracking click : ");
                        sb15.append(h.f25121Ub.content.f25180Qa.f25274rb.toString());
                        Log.m31477d(str, sb15.toString());
                        StringBuilder sb16 = new StringBuilder();
                        sb16.append(" content.eventTracking close : ");
                        sb16.append(h.f25121Ub.content.f25180Qa.f25277vb.toString());
                        Log.m31477d(str, sb16.toString());
                        StringBuilder sb17 = new StringBuilder();
                        sb17.append(" content.eventTracking exposure : ");
                        sb17.append(h.f25121Ub.content.f25180Qa.f25273qb.toString());
                        Log.m31477d(str, sb17.toString());
                        StringBuilder sb18 = new StringBuilder();
                        sb18.append(" content.eventTracking finishDownload : ");
                        sb18.append(h.f25121Ub.content.f25180Qa.f25276ub.toString());
                        Log.m31477d(str, sb18.toString());
                        StringBuilder sb19 = new StringBuilder();
                        sb19.append(" content.eventTracking videoPlay25 : ");
                        sb19.append(h.f25121Ub.content.f25180Qa.f25280yb.toString());
                        Log.m31477d(str, sb19.toString());
                        StringBuilder sb20 = new StringBuilder();
                        sb20.append(" content.eventTracking videoPlay50 : ");
                        sb20.append(h.f25121Ub.content.f25180Qa.f25281zb.toString());
                        Log.m31477d(str, sb20.toString());
                        StringBuilder sb21 = new StringBuilder();
                        sb21.append(" content.eventTracking videoPlay75 : ");
                        sb21.append(h.f25121Ub.content.f25180Qa.f25271Ab.toString());
                        Log.m31477d(str, sb21.toString());
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append(" content.eventTracking videoPlayBegin : ");
                        sb22.append(h.f25121Ub.content.f25180Qa.f25278wb.toString());
                        Log.m31477d(str, sb22.toString());
                        StringBuilder sb23 = new StringBuilder();
                        sb23.append(" content.eventTracking videoPlayEnd : ");
                        sb23.append(h.f25121Ub.content.f25180Qa.f25279xb.toString());
                        Log.m31477d(str, sb23.toString());
                    }
                    StringBuilder sb24 = new StringBuilder();
                    sb24.append(" displayInfo : ");
                    sb24.append(h.f25121Ub.f25153ta.toString());
                    Log.m31477d(str, sb24.toString());
                    StringBuilder sb25 = new StringBuilder();
                    sb25.append(" context size: ");
                    sb25.append(h.f25121Ub.context.length);
                    Log.m31477d(str, sb25.toString());
                }
            } else {
                StringBuilder sb26 = new StringBuilder();
                sb26.append(" gdt ad info :");
                sb26.append(xVar.toString());
                Log.m31477d(str, sb26.toString());
                C7852Aa.m34150L("gdt ad ");
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            C7498G g2 = (C7498G) it3.next();
            if (g2.f25116ma == 0) {
                int i2 = g2.positionId;
                if (!C7931ta.m34347g(g2.f25115Rb) || g2.f25117xa.f25286Gb) {
                    C7895e.m34313a(i2, true);
                    C7895e.m34314c(i2, C7895e.f26887Bc);
                    List list = (List) sparseArray.get(i2);
                    if (list == null) {
                        list = new ArrayList(5);
                        sparseArray.put(i2, list);
                    }
                    C7524x xVar2 = g2.f25117xa;
                    if (xVar2 == null || !xVar2.f25286Gb) {
                        Iterator it4 = g2.f25115Rb.iterator();
                        while (it4.hasNext()) {
                            C7486a a = C7933ua.m34349a((C7499H) it4.next(), i2);
                            if (a != null) {
                                list.add(a);
                            }
                        }
                    } else {
                        C7486a a2 = C7933ua.m34348a(g2);
                        if (a2 != null) {
                            list.add(a2);
                        }
                    }
                } else {
                    C7895e.m34313a(i2, false);
                    C7895e.m34314c(i2, C7895e.f26888Cc);
                }
            }
        }
        this.val$callback.mo38200a(sparseArray);
        C7852Aa.m34153d("shark_onCallback() end");
        this.val$callback.mo38201a(sparseArray, 0);
        StringBuilder sb27 = new StringBuilder();
        sb27.append("AdNetMgr_getAds() End:");
        sb27.append(this.f26880Ac.toString());
        sb27.append(" latch.errorcode:");
        sb27.append(0);
        C7852Aa.m34153d(sb27.toString());
    }
}
