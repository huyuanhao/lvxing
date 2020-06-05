package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.ax */
class C7414ax extends TupleScheme {
    private C7414ax() {
    }

    /* synthetic */ C7414ax(C7411au auVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, TrackConnectRsp trackConnectRsp) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        tTupleProtocol.mo40893a(trackConnectRsp.sessionId);
        tTupleProtocol.mo40898a(trackConnectRsp.version);
        trackConnectRsp.result.write(tTupleProtocol);
        tTupleProtocol.mo40892a(trackConnectRsp.pollInterval);
    }

    /* renamed from: b */
    public void read(TProtocol fVar, TrackConnectRsp trackConnectRsp) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        trackConnectRsp.sessionId = tTupleProtocol.mo40922x();
        trackConnectRsp.mo36191a(true);
        trackConnectRsp.version = tTupleProtocol.mo40918t();
        trackConnectRsp.mo36196b(true);
        trackConnectRsp.result = new ReqResult();
        trackConnectRsp.result.read(tTupleProtocol);
        trackConnectRsp.mo36199c(true);
        trackConnectRsp.pollInterval = tTupleProtocol.mo40919u();
        trackConnectRsp.mo36201d(true);
    }
}
