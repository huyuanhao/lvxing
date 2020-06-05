package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.connect_args;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.m */
class C7447m extends StandardScheme {
    private C7447m() {
    }

    /* synthetic */ C7447m(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, connect_args connect_args) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                connect_args.mo36018e();
                return;
            }
            if (j.f29148c != 1) {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            } else if (j.f29147b == 12) {
                connect_args.req = new TrackConnectReq();
                connect_args.req.read(fVar);
                connect_args.mo36010a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, connect_args connect_args) {
        connect_args.mo36018e();
        fVar.mo40897a(connect_args.STRUCT_DESC);
        if (connect_args.req != null) {
            fVar.mo40894a(connect_args.REQ_FIELD_DESC);
            connect_args.req.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
