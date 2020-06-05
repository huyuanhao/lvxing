package com.alibaba.baichuan.trade.common.adapter.mtop.p063a;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.adapter.mtop.C1219b;
import com.alibaba.baichuan.trade.common.adapter.mtop.C1221d.C1222a;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkRequest;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.p060b.C1211c;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.baichuan.trade.common.utils.C1229c;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.p690b.Mtop;
import org.json.JSONObject;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.mtop.a.b */
public class C1217b implements C1219b {
    /* renamed from: a */
    private MtopBusiness m2381a(NetworkRequest networkRequest) {
        MtopBusiness a = MtopBusiness.m29133a(Mtop.m35533a("OPEN"), m2388b(networkRequest), TextUtils.isEmpty(networkRequest.ttid) ? C1223b.f2468h : networkRequest.ttid);
        if (networkRequest.needWua) {
            a.mo32753g();
        }
        if (networkRequest.needAuth && !networkRequest.isVip) {
            a.mo32732a(networkRequest.authParams, true);
        }
        if (networkRequest.isPost) {
            a.mo32743b(MethodEnum.POST);
        }
        if (networkRequest.extHeaders != null && networkRequest.extHeaders.size() > 0) {
            a.mo32741b(networkRequest.extHeaders);
        }
        if (!networkRequest.showAuthUI) {
            a.f22589e = networkRequest.showAuthUI;
        }
        a.mo32748d(15000);
        a.mo32749e(15000);
        a.mo39753a("baichuan");
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2384a(MtopResponse mtopResponse) {
        StringBuilder sb;
        String str;
        String str2 = "AlibcMtop";
        if (mtopResponse.isApiSuccess()) {
            C1224a.m2404b(str2, "网络请求成功");
            return;
        }
        if (mtopResponse.isSessionInvalid()) {
            sb = new StringBuilder();
            str = "session 失效， do autologin or login business msg = ";
        } else if (mtopResponse.isSystemError() || mtopResponse.isNetworkError() || mtopResponse.isExpiredRequest() || mtopResponse.is41XResult() || mtopResponse.isApiLockedResult() || mtopResponse.isMtopSdkError()) {
            sb = new StringBuilder();
            str = "系统错误，网络错误，防刷，防雪崩 msg =";
        } else {
            sb = new StringBuilder();
            str = "业务错误 msg =";
        }
        sb.append(str);
        sb.append(mtopResponse.getRetMsg());
        C1224a.m2406d(str2, sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2385a(MtopResponse mtopResponse, String str, String str2) {
        String str3 = mtopResponse.isSessionInvalid() ? "session 失效， do autologin or login business" : (mtopResponse.isSystemError() || mtopResponse.isNetworkError() || mtopResponse.isExpiredRequest() || mtopResponse.is41XResult() || mtopResponse.isApiLockedResult() || mtopResponse.isMtopSdkError()) ? "系统错误，网络错误，防刷，防雪崩 " : "业务错误 ";
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("1501");
        sb3.append(str);
        C1211c.m2375a("InvokeMtop", sb2, sb3.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public NetworkResponse m2387b(MtopResponse mtopResponse) {
        NetworkResponse networkResponse = new NetworkResponse();
        if (mtopResponse == null) {
            return networkResponse;
        }
        networkResponse.byteData = mtopResponse.getBytedata();
        StringBuilder sb = new StringBuilder();
        sb.append(mtopResponse.getResponseCode());
        sb.append("");
        networkResponse.httpCode = sb.toString();
        networkResponse.errorCode = mtopResponse.getRetCode();
        networkResponse.errorMsg = mtopResponse.getRetMsg();
        networkResponse.isSuccess = mtopResponse.isApiSuccess();
        if (mtopResponse.getDataJsonObject() != null) {
            String jSONObject = mtopResponse.getDataJsonObject().toString();
            networkResponse.data = (Map) C1229c.m2417a(jSONObject, Map.class);
            networkResponse.jsonData = jSONObject;
        }
        return networkResponse;
    }

    /* renamed from: b */
    private MtopRequest m2388b(NetworkRequest networkRequest) {
        if (TextUtils.isEmpty(networkRequest.apiVersion)) {
            networkRequest.apiVersion = "1.0";
        }
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(networkRequest.apiName);
        mtopRequest.setVersion(networkRequest.apiVersion);
        mtopRequest.setNeedEcode(networkRequest.needLogin);
        mtopRequest.setNeedSession(true);
        if (networkRequest.paramMap != null) {
            JSONObject a = C1229c.m2423a(mtopRequest.getData());
            if (a == null) {
                a = new JSONObject();
            }
            for (Entry entry : networkRequest.paramMap.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        a.put((String) entry.getKey(), ((Serializable) entry.getValue()).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            mtopRequest.setData(a.toString());
        }
        return mtopRequest;
    }

    /* renamed from: a */
    public boolean mo10876a(final C1222a aVar, final NetworkRequest networkRequest) {
        if (networkRequest == null) {
            if (aVar != null) {
                aVar.mo10659b(0, null);
            } else {
                C1224a.m2406d("AlibcMtop", "sendRequest 失败，request & listener 为 null");
            }
            return false;
        }
        m2381a(networkRequest).mo32730a((IRemoteListener) new IRemoteBaseListener() {
            /* renamed from: a */
            public void mo10877a(int i, MtopResponse mtopResponse, Object obj) {
                C1217b.this.m2384a(mtopResponse);
                aVar.mo10659b(networkRequest.requestType, C1217b.this.m2387b(mtopResponse));
                C1217b bVar = C1217b.this;
                String retCode = mtopResponse.getRetCode();
                StringBuilder sb = new StringBuilder();
                sb.append("errMsg = ");
                sb.append(mtopResponse.getRetMsg());
                sb.append(" ,api = ");
                sb.append(mtopResponse.getApi());
                bVar.m2385a(mtopResponse, retCode, sb.toString());
            }

            /* renamed from: a */
            public void mo10878a(int i, MtopResponse mtopResponse, BaseOutDo aVar, Object obj) {
                C1217b.this.m2384a(mtopResponse);
                aVar.mo10658a(networkRequest.requestType, C1217b.this.m2387b(mtopResponse));
                C1211c.m2374a("InvokeMtop");
            }

            /* renamed from: b */
            public void mo10879b(int i, MtopResponse mtopResponse, Object obj) {
                C1217b.this.m2384a(mtopResponse);
                aVar.mo10659b(networkRequest.requestType, C1217b.this.m2387b(mtopResponse));
                C1217b bVar = C1217b.this;
                String retCode = mtopResponse.getRetCode();
                StringBuilder sb = new StringBuilder();
                sb.append("errMsg = ");
                sb.append(mtopResponse.getRetMsg());
                sb.append(" ,api = ");
                sb.append(mtopResponse.getApi());
                bVar.m2385a(mtopResponse, retCode, sb.toString());
            }
        }).mo32744b();
        return true;
    }
}
