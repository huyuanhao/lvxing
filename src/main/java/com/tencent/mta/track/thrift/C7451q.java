package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.connect_result;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.q */
class C7451q extends StandardScheme {
    private C7451q() {
    }

    /* synthetic */ C7451q(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, connect_result connect_result) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                connect_result.mo36036e();
                return;
            }
            if (j.f29148c != 0) {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            } else if (j.f29147b == 12) {
                connect_result.success = new TrackConnectRsp();
                connect_result.success.read(fVar);
                connect_result.mo36028a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, connect_result connect_result) {
        connect_result.mo36036e();
        fVar.mo40897a(connect_result.STRUCT_DESC);
        if (connect_result.success != null) {
            fVar.mo40894a(connect_result.SUCCESS_FIELD_DESC);
            connect_result.success.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
