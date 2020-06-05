package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.al */
class C7402al extends StandardScheme {
    private C7402al() {
    }

    /* synthetic */ C7402al(C7401ak akVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, ReqResult reqResult) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                reqResult.mo36132h();
                return;
            }
            short s = j.f29148c;
            if (s != 1) {
                if (s != 2) {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                } else if (j.f29147b == 11) {
                    reqResult.errorMsg = fVar.mo40922x();
                    reqResult.mo36123b(true);
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 8) {
                reqResult.errorCode = ErrorCode.m31888a(fVar.mo40919u());
                reqResult.mo36119a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, ReqResult reqResult) {
        reqResult.mo36132h();
        fVar.mo40897a(ReqResult.STRUCT_DESC);
        if (reqResult.errorCode != null) {
            fVar.mo40894a(ReqResult.ERROR_CODE_FIELD_DESC);
            fVar.mo40892a(reqResult.errorCode.getValue());
            fVar.mo40901c();
        }
        if (reqResult.errorMsg != null && reqResult.mo36131g()) {
            fVar.mo40894a(ReqResult.ERROR_MSG_FIELD_DESC);
            fVar.mo40893a(reqResult.errorMsg);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
