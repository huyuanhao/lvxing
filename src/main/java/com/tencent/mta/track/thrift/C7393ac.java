package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_args;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.ac */
class C7393ac extends StandardScheme {
    private C7393ac() {
    }

    /* synthetic */ C7393ac(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, pollRequest_args pollrequest_args) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                pollrequest_args.mo36090e();
                return;
            }
            if (j.f29148c != 1) {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            } else if (j.f29147b == 12) {
                pollrequest_args.req = new TrackPollReq();
                pollrequest_args.req.read(fVar);
                pollrequest_args.mo36082a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, pollRequest_args pollrequest_args) {
        pollrequest_args.mo36090e();
        fVar.mo40897a(pollRequest_args.STRUCT_DESC);
        if (pollrequest_args.req != null) {
            fVar.mo40894a(pollRequest_args.REQ_FIELD_DESC);
            pollrequest_args.req.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
