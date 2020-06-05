package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_result;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.y */
class C7459y extends StandardScheme {
    private C7459y() {
    }

    /* synthetic */ C7459y(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, disconnect_result disconnect_result) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                disconnect_result.mo36072e();
                return;
            }
            if (j.f29148c != 0) {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            } else if (j.f29147b == 12) {
                disconnect_result.success = new TrackDisConnectRsp();
                disconnect_result.success.read(fVar);
                disconnect_result.mo36064a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, disconnect_result disconnect_result) {
        disconnect_result.mo36072e();
        fVar.mo40897a(disconnect_result.STRUCT_DESC);
        if (disconnect_result.success != null) {
            fVar.mo40894a(disconnect_result.SUCCESS_FIELD_DESC);
            disconnect_result.success.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
