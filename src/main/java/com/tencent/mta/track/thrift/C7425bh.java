package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.bh */
class C7425bh extends TupleScheme {
    private C7425bh() {
    }

    /* synthetic */ C7425bh(C7422be beVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, TrackDisConnectRsp trackDisConnectRsp) {
        trackDisConnectRsp.result.write((TTupleProtocol) fVar);
    }

    /* renamed from: b */
    public void read(TProtocol fVar, TrackDisConnectRsp trackDisConnectRsp) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        trackDisConnectRsp.result = new ReqResult();
        trackDisConnectRsp.result.read(tTupleProtocol);
        trackDisConnectRsp.mo36245a(true);
    }
}
