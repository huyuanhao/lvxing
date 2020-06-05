package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_args;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.u */
class C7455u extends StandardScheme {
    private C7455u() {
    }

    /* synthetic */ C7455u(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, disconnect_args disconnect_args) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                disconnect_args.mo36054e();
                return;
            }
            if (j.f29148c != 1) {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            } else if (j.f29147b == 12) {
                disconnect_args.req = new TrackDisConnectReq();
                disconnect_args.req.read(fVar);
                disconnect_args.mo36046a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, disconnect_args disconnect_args) {
        disconnect_args.mo36054e();
        fVar.mo40897a(disconnect_args.STRUCT_DESC);
        if (disconnect_args.req != null) {
            fVar.mo40894a(disconnect_args.REQ_FIELD_DESC);
            disconnect_args.req.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
