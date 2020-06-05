package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.g */
class C7441g extends StandardScheme {
    private C7441g() {
    }

    /* synthetic */ C7441g(C7440f fVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, CommonResponse commonResponse) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                break;
            }
            short s = j.f29148c;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            TProtocolUtil.m37231a(fVar, j.f29147b);
                        } else if (j.f29147b == 11) {
                            commonResponse.body = fVar.mo40922x();
                            commonResponse.mo35987d(true);
                        } else {
                            TProtocolUtil.m37231a(fVar, j.f29147b);
                        }
                    } else if (j.f29147b == 12) {
                        commonResponse.result = new ReqResult();
                        commonResponse.result.read(fVar);
                        commonResponse.mo35985c(true);
                    } else {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    }
                } else if (j.f29147b == 8) {
                    commonResponse.cmdType = CommonCmdType.m31822a(fVar.mo40919u());
                    commonResponse.mo35982b(true);
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 8) {
                commonResponse.seq = fVar.mo40919u();
                commonResponse.mo35977a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
        fVar.mo40907i();
        if (commonResponse.mo35988d()) {
            commonResponse.mo36000n();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'seq' was not found in serialized data! Struct: ");
        sb.append(toString());
        throw new TProtocolException(sb.toString());
    }

    /* renamed from: b */
    public void write(TProtocol fVar, CommonResponse commonResponse) {
        commonResponse.mo36000n();
        fVar.mo40897a(CommonResponse.STRUCT_DESC);
        fVar.mo40894a(CommonResponse.SEQ_FIELD_DESC);
        fVar.mo40892a(commonResponse.seq);
        fVar.mo40901c();
        if (commonResponse.cmdType != null) {
            fVar.mo40894a(CommonResponse.CMD_TYPE_FIELD_DESC);
            fVar.mo40892a(commonResponse.cmdType.getValue());
            fVar.mo40901c();
        }
        if (commonResponse.result != null) {
            fVar.mo40894a(CommonResponse.RESULT_FIELD_DESC);
            commonResponse.result.write(fVar);
            fVar.mo40901c();
        }
        if (commonResponse.body != null && commonResponse.mo35999m()) {
            fVar.mo40894a(CommonResponse.BODY_FIELD_DESC);
            fVar.mo40893a(commonResponse.body);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
