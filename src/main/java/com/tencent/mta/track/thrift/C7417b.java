package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.b */
class C7417b extends StandardScheme {
    private C7417b() {
    }

    /* synthetic */ C7417b(C7390a aVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, CommonRequest commonRequest) {
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
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    } else if (j.f29147b == 11) {
                        commonRequest.body = fVar.mo40922x();
                        commonRequest.mo35947c(true);
                    } else {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    }
                } else if (j.f29147b == 8) {
                    commonRequest.cmdType = CommonCmdType.m31822a(fVar.mo40919u());
                    commonRequest.mo35944b(true);
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 8) {
                commonRequest.seq = fVar.mo40919u();
                commonRequest.mo35939a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
        fVar.mo40907i();
        if (commonRequest.mo35950d()) {
            commonRequest.mo35963k();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'seq' was not found in serialized data! Struct: ");
        sb.append(toString());
        throw new TProtocolException(sb.toString());
    }

    /* renamed from: b */
    public void write(TProtocol fVar, CommonRequest commonRequest) {
        commonRequest.mo35963k();
        fVar.mo40897a(CommonRequest.STRUCT_DESC);
        fVar.mo40894a(CommonRequest.SEQ_FIELD_DESC);
        fVar.mo40892a(commonRequest.seq);
        fVar.mo40901c();
        if (commonRequest.cmdType != null) {
            fVar.mo40894a(CommonRequest.CMD_TYPE_FIELD_DESC);
            fVar.mo40892a(commonRequest.cmdType.getValue());
            fVar.mo40901c();
        }
        if (commonRequest.body != null && commonRequest.mo35962j()) {
            fVar.mo40894a(CommonRequest.BODY_FIELD_DESC);
            fVar.mo40893a(commonRequest.body);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
