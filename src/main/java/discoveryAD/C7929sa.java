package discoveryAD;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.ServiceCenter;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkService;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import com.tencent.qqpim.discovery.ADReporter.OuterReportMetaData;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.DiscoverySdk;
import com.tencent.qqpim.discovery.IProRequestCallback;
import com.tencent.qqpim.discovery.internal.model.C7489d;
import com.tencent.qqpim.discovery.internal.model.ClickDataModel;
import com.tencent.qqpim.discovery.internal.protocol.C7493B;
import com.tencent.qqpim.discovery.internal.protocol.C7494C;
import com.tencent.qqpim.discovery.internal.protocol.C7496E;
import com.tencent.qqpim.discovery.internal.protocol.C7501a;
import com.tencent.qqpim.discovery.internal.protocol.C7502b;
import com.tencent.qqpim.discovery.internal.protocol.C7505e;
import com.tencent.qqpim.discovery.internal.protocol.C7506f;
import com.tencent.qqpim.discovery.internal.protocol.C7508h;
import com.tencent.qqpim.discovery.internal.protocol.C7519s;
import com.tencent.qqpim.discovery.internal.protocol.C7522v;
import com.tencent.qqpim.discovery.internal.protocol.GDTSDKReportItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: discoveryAD.sa */
public class C7929sa {
    /* renamed from: ng */
    public static final int f26955ng = 4004;
    /* renamed from: og */
    public static final int f26956og = 4003;
    /* renamed from: pg */
    public static final int f26957pg = 4005;

    /* renamed from: a */
    private static void m34335a(int i, JceStruct jceStruct, JceStruct jceStruct2, IProRequestCallback iProRequestCallback, long j) {
        ((ISharkService) ServiceCenter.get(ISharkService.class)).sendShark(i, jceStruct, jceStruct2, 0, new C7923pa(iProRequestCallback), j);
    }

    /* renamed from: a */
    public static void m34336a(OuterReportMetaData outerReportMetaData, int i) {
        m34337a(outerReportMetaData, i, (ClickDataModel) null);
    }

    /* renamed from: a */
    public static void m34337a(OuterReportMetaData outerReportMetaData, int i, ClickDataModel clickDataModel) {
        ArrayList<String> arrayList;
        if (i == 5) {
            arrayList = outerReportMetaData.startDownLoadtrackurls;
        } else if (i == 6) {
            arrayList = outerReportMetaData.finishDownLoadtrackurls;
        } else if (i == 7) {
            arrayList = outerReportMetaData.installtrackurls;
        } else if (i == 4 && outerReportMetaData.clicktrackurls != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator it = outerReportMetaData.clicktrackurls.iterator();
            while (it.hasNext()) {
                arrayList2.add(C7489d.m32381a((String) it.next(), clickDataModel));
            }
            arrayList = arrayList2;
        } else {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        C7501a aVar = new C7501a();
        aVar.f25136ca = new C7522v();
        aVar.f25136ca.f25283Db = arrayList;
        aVar.f25133W = i;
        aVar.context = outerReportMetaData.context;
        aVar.timeStamp = System.currentTimeMillis() / 1000;
        aVar.positionId = outerReportMetaData.positionId;
        arrayList3.add(aVar);
        m34341b(arrayList3, new C7925qa());
        C7941ya.m34361q(arrayList);
    }

    /* renamed from: a */
    public static void m34338a(GDTSDKReportItem gDTSDKReportItem) {
        ArrayList<GDTSDKReportItem> arrayList = new ArrayList<>();
        arrayList.add(gDTSDKReportItem);
        Log.m31477d("sendADGDTReport", gDTSDKReportItem.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("sendADGDTReport  state:");
        sb.append(gDTSDKReportItem.reportState);
        C7852Aa.m34150L(sb.toString());
        C7506f fVar = new C7506f();
        fVar.f25162Da = arrayList;
        m34335a(f26957pg, fVar, new C7494C(), new C7927ra(), -1);
    }

    /* renamed from: a */
    public static void m34339a(ArrayList<C7489d> arrayList, IProRequestCallback iProRequestCallback) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C7489d dVar = (C7489d) it.next();
            int i = dVar.f25068we;
            C7501a aVar = dVar.f25069xe;
            if (i != 0) {
                C7522v vVar = aVar.f25136ca;
                if (vVar != null) {
                    if (vVar.f25283Db == null) {
                    }
                }
            }
            arrayList2.add(aVar);
        }
        m34341b(arrayList2, iProRequestCallback);
        C7941ya.m34360p(arrayList);
    }

    /* renamed from: a */
    public static void m34340a(List<AdRequestData> list, IProRequestCallback iProRequestCallback, long j) {
        ArrayList<C7502b> arrayList = new ArrayList<>();
        for (AdRequestData adRequestData : list) {
            C7502b bVar = new C7502b();
            bVar.advNum = adRequestData.advNum;
            bVar.positionId = adRequestData.positionId;
            bVar.f25140ga = adRequestData.positionFormatTypes;
            bVar.f25142ia = new HashMap();
            Map<Integer, String> map = bVar.f25142ia;
            Integer valueOf = Integer.valueOf(C7519s.f25244Tf);
            StringBuilder sb = new StringBuilder();
            sb.append(DiscoverySdk.getInstance().getAPPID());
            String str = "";
            sb.append(str);
            map.put(valueOf, sb.toString());
            Map<Integer, String> map2 = bVar.f25142ia;
            Integer valueOf2 = Integer.valueOf(C7519s.f25246Vf);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ScreenUtil.getScreenWidth());
            sb2.append(str);
            map2.put(valueOf2, sb2.toString());
            Map<Integer, String> map3 = bVar.f25142ia;
            Integer valueOf3 = Integer.valueOf(C7519s.f25247Wf);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(ScreenUtil.getScreenHeight());
            sb3.append(str);
            map3.put(valueOf3, sb3.toString());
            Map<Integer, String> map4 = bVar.f25142ia;
            Integer valueOf4 = Integer.valueOf(C7519s.f25248Xf);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(adRequestData.pos_width);
            sb4.append(str);
            map4.put(valueOf4, sb4.toString());
            Map<Integer, String> map5 = bVar.f25142ia;
            Integer valueOf5 = Integer.valueOf(C7519s.f25249Yf);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(adRequestData.pos_height);
            sb5.append(str);
            map5.put(valueOf5, sb5.toString());
            Map<Integer, String> map6 = bVar.f25142ia;
            Integer valueOf6 = Integer.valueOf(C7519s.f25245Uf);
            String str2 = adRequestData.f25046ua;
            if (str2 == null) {
                str2 = C7935va.m34357mb();
            }
            map6.put(valueOf6, str2);
            arrayList.add(bVar);
        }
        C7508h hVar = new C7508h();
        hVar.f25169Fa = arrayList;
        hVar.f25170Ga = true;
        hVar.f25171Ha = true;
        m34335a(4004, hVar, new C7496E(), iProRequestCallback, j);
    }

    /* renamed from: b */
    private static void m34341b(ArrayList<C7501a> arrayList, IProRequestCallback iProRequestCallback) {
        C7505e eVar = new C7505e();
        eVar.f25160za = arrayList;
        C7493B b = new C7493B();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C7501a aVar = (C7501a) it.next();
            int i = -1;
            byte[] bArr = aVar.context;
            if (bArr != null) {
                i = bArr.length;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sendAdReportData : positionId : ");
            sb.append(aVar.positionId);
            sb.append(" , phase : ");
            sb.append(aVar.f25133W);
            sb.append(" context.length : ");
            sb.append(i);
            C7852Aa.m34150L(sb.toString());
        }
        m34335a(f26956og, eVar, b, iProRequestCallback, -1);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static int m34343e(int i, int i2) {
        if (i != 0) {
            return 1;
        }
        return i2 != 0 ? 2 : 0;
    }
}
