package com.alipay.p109b.p110a.p111a.p117e;

import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* renamed from: com.alipay.b.a.a.e.c */
class C1487c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DataReportRequest f3784a;
    /* renamed from: b */
    final /* synthetic */ C1484b f3785b;

    C1487c(C1484b bVar, DataReportRequest dataReportRequest) {
        this.f3785b = bVar;
        this.f3784a = dataReportRequest;
    }

    public void run() {
        try {
            C1484b.f3778e = this.f3785b.f3781c.reportData(this.f3784a);
        } catch (Throwable th) {
            C1484b.f3778e = new DataReportResult();
            C1484b.f3778e.success = false;
            DataReportResult a = C1484b.f3778e;
            StringBuilder sb = new StringBuilder("static data rpc upload error, ");
            sb.append(C1460a.m4258a(th));
            a.resultCode = sb.toString();
            new StringBuilder("rpc failed:").append(C1460a.m4258a(th));
        }
    }
}
