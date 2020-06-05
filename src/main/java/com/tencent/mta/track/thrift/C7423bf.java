package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.bf */
class C7423bf extends StandardScheme {
    private C7423bf() {
    }

    /* synthetic */ C7423bf(C7422be beVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, TrackDisConnectRsp trackDisConnectRsp) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                trackDisConnectRsp.mo36253e();
                return;
            }
            if (j.f29148c != 1) {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            } else if (j.f29147b == 12) {
                trackDisConnectRsp.result = new ReqResult();
                trackDisConnectRsp.result.read(fVar);
                trackDisConnectRsp.mo36245a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, TrackDisConnectRsp trackDisConnectRsp) {
        trackDisConnectRsp.mo36253e();
        fVar.mo40897a(TrackDisConnectRsp.STRUCT_DESC);
        if (trackDisConnectRsp.result != null) {
            fVar.mo40894a(TrackDisConnectRsp.RESULT_FIELD_DESC);
            trackDisConnectRsp.result.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
