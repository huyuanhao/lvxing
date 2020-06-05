package com.alipay.p109b.p110a.p111a.p117e;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.C1404aa;
import com.alipay.android.phone.mrpc.core.C1416h;
import com.alipay.android.phone.mrpc.core.C1432w;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* renamed from: com.alipay.b.a.a.e.b */
public class C1484b implements C1479a {
    /* renamed from: d */
    private static C1484b f3777d;
    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static DataReportResult f3778e;
    /* renamed from: a */
    private C1432w f3779a = null;
    /* renamed from: b */
    private BugTrackMessageService f3780b = null;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public DataReportService f3781c = null;

    private C1484b(Context context, String str) {
        C1404aa aaVar = new C1404aa();
        aaVar.mo11938a(str);
        this.f3779a = new C1416h(context);
        this.f3780b = (BugTrackMessageService) this.f3779a.mo11966a(BugTrackMessageService.class, aaVar);
        this.f3781c = (DataReportService) this.f3779a.mo11966a(DataReportService.class, aaVar);
    }

    /* renamed from: a */
    public static synchronized C1484b m4372a(Context context, String str) {
        C1484b bVar;
        synchronized (C1484b.class) {
            if (f3777d == null) {
                f3777d = new C1484b(context, str);
            }
            bVar = f3777d;
        }
        return bVar;
    }

    /* renamed from: a */
    public DataReportResult mo12089a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f3781c != null) {
            f3778e = null;
            new Thread(new C1487c(this, dataReportRequest)).start();
            int i = 300000;
            while (f3778e == null && i >= 0) {
                Thread.sleep(50);
                i -= 50;
            }
        }
        return f3778e;
    }

    /* renamed from: a */
    public boolean mo12090a(String str) {
        boolean z = false;
        if (C1460a.m4260a(str)) {
            return false;
        }
        BugTrackMessageService bugTrackMessageService = this.f3780b;
        if (bugTrackMessageService != null) {
            String str2 = null;
            try {
                str2 = bugTrackMessageService.logCollect(C1460a.m4267f(str));
            } catch (Throwable unused) {
            }
            if (!C1460a.m4260a(str2)) {
                z = ((Boolean) new JSONObject(str2).get("success")).booleanValue();
            }
        }
        return z;
    }
}
