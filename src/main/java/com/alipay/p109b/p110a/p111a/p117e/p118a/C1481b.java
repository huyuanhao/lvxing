package com.alipay.p109b.p110a.p111a.p117e.p118a;

import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.b.a.a.e.a.b */
public class C1481b {
    /* renamed from: a */
    public static C1482c m4367a(DataReportResult dataReportResult) {
        C1482c cVar = new C1482c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f3756a = dataReportResult.success;
        cVar.f3757b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.f3758c = (String) map.get("apdid");
            cVar.f3759d = (String) map.get("apdidToken");
            cVar.f3762g = (String) map.get("dynamicKey");
            cVar.f3763h = (String) map.get("timeInterval");
            cVar.f3764i = (String) map.get("webrtcUrl");
            cVar.f3765j = "";
            String str = (String) map.get("drmSwitch");
            if (C1460a.m4263b(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    cVar.f3760e = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    cVar.f3761f = sb2.toString();
                }
            }
            String str2 = "apse_degrade";
            if (map.containsKey(str2)) {
                cVar.f3766k = (String) map.get(str2);
            }
        }
        return cVar;
    }

    /* renamed from: a */
    public static DataReportRequest m4368a(C1483d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.f4022os = dVar.f3767a;
        dataReportRequest.rpcVersion = dVar.f3776j;
        dataReportRequest.bizType = "1";
        dataReportRequest.bizData = new HashMap();
        dataReportRequest.bizData.put("apdid", dVar.f3768b);
        dataReportRequest.bizData.put("apdidToken", dVar.f3769c);
        dataReportRequest.bizData.put("umidToken", dVar.f3770d);
        dataReportRequest.bizData.put("dynamicKey", dVar.f3771e);
        dataReportRequest.deviceData = dVar.f3772f;
        return dataReportRequest;
    }
}
