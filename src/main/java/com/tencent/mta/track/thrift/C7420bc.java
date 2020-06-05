package com.tencent.mta.track.thrift;

import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.bc */
class C7420bc extends TupleScheme {
    private C7420bc() {
    }

    /* synthetic */ C7420bc(C7416az azVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, TrackDisConnectReq trackDisConnectReq) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        tTupleProtocol.mo40893a(trackDisConnectReq.sessionId);
        BitSet bitSet = new BitSet();
        if (trackDisConnectReq.mo36235g()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (trackDisConnectReq.mo36235g()) {
            tTupleProtocol.mo40893a(trackDisConnectReq.reason);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, TrackDisConnectReq trackDisConnectReq) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        trackDisConnectReq.sessionId = tTupleProtocol.mo40922x();
        trackDisConnectReq.mo36222a(true);
        if (tTupleProtocol.mo40944b(1).get(0)) {
            trackDisConnectReq.reason = tTupleProtocol.mo40922x();
            trackDisConnectReq.mo36227b(true);
        }
    }
}
