package discoveryAD;

import com.tencent.qqpim.discovery.internal.model.C7486a;
import com.tencent.qqpim.discovery.internal.model.C7491f;
import com.tencent.qqpim.discovery.internal.protocol.C7498G;
import com.tencent.qqpim.discovery.internal.protocol.C7499H;
import com.tencent.qqpim.discovery.internal.protocol.C7504d;
import com.tencent.qqpim.discovery.internal.protocol.C7509i;
import com.tencent.qqpim.discovery.internal.protocol.C7510j;
import com.tencent.qqpim.discovery.internal.protocol.C7511k;
import com.tencent.qqpim.discovery.internal.protocol.C7521u;
import com.tencent.qqpim.discovery.internal.protocol.C7523w;
import com.tencent.qqpim.discovery.internal.protocol.C7524x;
import com.tencent.qqpim.discovery.internal.protocol.C7526z;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: discoveryAD.ua */
public class C7933ua {
    /* renamed from: a */
    public static C7486a m34348a(C7498G g) {
        if (g.f25117xa.f25289sa < ((long) ((int) (System.currentTimeMillis() / 1000)))) {
            StringBuilder sb = new StringBuilder();
            sb.append(g.f25117xa.f25287Hb);
            sb.append(" | ");
            sb.append(g.f25117xa.appId);
            sb.append(" 广告时间过期,请调整手机本地时间为北京时间！！！");
            C7852Aa.m34152N(sb.toString());
            return null;
        }
        C7486a aVar = new C7486a();
        C7491f fVar = new C7491f();
        fVar.sdkADRequest = true;
        C7524x xVar = g.f25117xa;
        fVar.sdkType = xVar.sdkType;
        fVar.sdkParamappid = xVar.appId;
        fVar.sdkPosId = xVar.f25287Hb;
        fVar.sdkgdtPosAmount = xVar.f25288Ib;
        fVar.sdkgdtrequestTimeout = xVar.requestTimeout;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(g.positionId);
        sb2.append("");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(g.f25117xa.appId);
        sb4.append(g.f25117xa.f25287Hb);
        fVar.uniqueKey = m34350a(sb3, sb4.toString(), null);
        aVar.f25065te = fVar;
        fVar.positionId = g.positionId;
        aVar.f25062W = 2;
        fVar.f25098rc = (int) g.f25117xa.f25289sa;
        return aVar;
    }

    /* renamed from: a */
    public static C7486a m34349a(C7499H h, int i) {
        String str = null;
        if (h.f25121Ub.f25152sa < ((int) (System.currentTimeMillis() / 1000))) {
            StringBuilder sb = new StringBuilder();
            sb.append(h.f25121Ub.f25154va);
            sb.append(" 广告时间过期,请调整手机本地时间为北京时间！！！");
            C7852Aa.m34152N(sb.toString());
            return null;
        }
        C7486a aVar = new C7486a();
        C7491f fVar = new C7491f();
        aVar.f25065te = fVar;
        fVar.positionId = i;
        aVar.f25062W = 2;
        aVar.f25063Wb = h.f25123Wb;
        aVar.f25064Xb = h.f25124Xb;
        fVar.percentSpent = h.percentSpent;
        fVar.effectiveTime = h.f25125Yb;
        C7504d dVar = h.f25121Ub;
        fVar.f25098rc = dVar.f25152sa;
        C7510j jVar = dVar.f25153ta;
        if (jVar != null) {
            fVar.text1 = jVar.text1;
            fVar.text2 = jVar.text2;
            fVar.text3 = jVar.text3;
            fVar.text4 = jVar.text4;
            fVar.imageUrl1 = jVar.f25184Ua;
            fVar.imageUrl2 = jVar.f25185Va;
            fVar.imageUrl3 = jVar.f25186Wa;
            fVar.videoUrl = jVar.videoUrl;
            fVar.zipUrl = jVar.zipUrl;
            fVar.templateType = jVar.f25187Xa;
            fVar.imgList = jVar.imgList;
        }
        C7509i iVar = dVar.content;
        if (iVar != null) {
            fVar.contentType = iVar.contentType;
            fVar.jumpUrl = iVar.jumpUrl;
            fVar.packageName = iVar.packageName;
            fVar.appDownloadUrl = iVar.appDownloadUrl;
            fVar.f25084Ma = iVar.f25176Ma;
            fVar.f25087Oa = iVar.f25178Oa;
            fVar.channelId = iVar.channelId;
            C7523w wVar = iVar.f25181Ra;
            if (wVar != null) {
                fVar.f25082Ke = wVar.type;
                fVar.f25083Le = wVar.f25284Eb;
                C7521u uVar = iVar.f25180Qa;
                fVar.f25085Me = uVar.f25273qb.f25283Db;
                fVar.f25086Ne = uVar.f25274rb.f25283Db;
                fVar.f25088Oe = uVar.f25275tb.f25283Db;
                fVar.f25089Pe = uVar.f25276ub.f25283Db;
                fVar.f25090Qe = uVar.f25277vb.f25283Db;
                fVar.f25091Re = uVar.f25278wb.f25283Db;
                fVar.f25092Se = uVar.f25279xb.f25283Db;
                fVar.f25093Te = uVar.f25280yb.f25283Db;
                fVar.f25094Ue = uVar.f25281zb.f25283Db;
                fVar.f25095Ve = uVar.f25271Ab.f25283Db;
                fVar.f25096We = uVar.f25272Bb.f25283Db;
            }
        }
        C7511k kVar = dVar.f25155wa;
        if (kVar != null) {
            fVar.continuousExposureTime = kVar.f25192bb;
            fVar.exposureInterval = kVar.f25193cb;
            fVar.scenes = kVar.scenes;
            boolean z = false;
            fVar.isAutoAppDownload = kVar.f25194db == 1;
            C7511k kVar2 = dVar.f25155wa;
            fVar.isDeepLink = kVar2.isDeepLink;
            if (kVar2.rotation == 0) {
                z = true;
            }
            fVar.rotation = z;
            fVar.f25081Je = dVar.f25155wa.f25195eb;
        }
        fVar.context = dVar.context;
        fVar.f25078Ge = String.valueOf(dVar.f25154va);
        int i2 = h.f25121Ub.content.contentType;
        String str2 = "";
        if (i2 == 10 || i2 == 11 || i2 == 12) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(h.f25121Ub.content.contentType);
            sb2.append(str2);
            str = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        sb3.append(str2);
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(dVar.f25154va);
        sb5.append(str2);
        fVar.uniqueKey = m34350a(sb4, sb5.toString(), str);
        ArrayList<C7526z> arrayList = h.f25122Vb;
        if (arrayList != null && !arrayList.isEmpty()) {
            fVar.isneedGuide = true;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C7526z zVar = (C7526z) it.next();
                if (zVar.f25292Lb == 2) {
                    fVar.notifyContent = zVar.text;
                    fVar.notifyInterval = 300;
                    break;
                }
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private static String m34350a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str4 = "|";
        sb.append(str4);
        sb.append(str2);
        if (str3 != null) {
            sb.append(str4);
            sb.append(str3);
        }
        return C7931ta.bytesToHexString(C7931ta.getMD5(sb.toString()));
    }
}
