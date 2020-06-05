package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_result;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.ag */
class C7397ag extends StandardScheme {
    private C7397ag() {
    }

    /* synthetic */ C7397ag(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, pollRequest_result pollrequest_result) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                pollrequest_result.mo36108e();
                return;
            }
            if (j.f29148c != 0) {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            } else if (j.f29147b == 12) {
                pollrequest_result.success = new TrackPollRsp();
                pollrequest_result.success.read(fVar);
                pollrequest_result.mo36100a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, pollRequest_result pollrequest_result) {
        pollrequest_result.mo36108e();
        fVar.mo40897a(pollRequest_result.STRUCT_DESC);
        if (pollrequest_result.success != null) {
            fVar.mo40894a(pollRequest_result.SUCCESS_FIELD_DESC);
            pollrequest_result.success.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
