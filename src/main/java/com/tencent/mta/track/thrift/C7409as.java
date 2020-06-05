package com.tencent.mta.track.thrift;

import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.as */
class C7409as extends TupleScheme {
    private C7409as() {
    }

    /* synthetic */ C7409as(C7406ap apVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, TrackConnectReq trackConnectReq) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        tTupleProtocol.mo40893a(trackConnectReq.sessionId);
        tTupleProtocol.mo40898a(trackConnectReq.version);
        tTupleProtocol.mo40893a(trackConnectReq.appKey);
        tTupleProtocol.mo40893a(trackConnectReq.deviceInfo);
        tTupleProtocol.mo40892a(trackConnectReq.deviceType.getValue());
        BitSet bitSet = new BitSet();
        if (trackConnectReq.mo36177s()) {
            bitSet.set(0);
        }
        if (trackConnectReq.mo36181v()) {
            bitSet.set(1);
        }
        tTupleProtocol.mo40943a(bitSet, 2);
        if (trackConnectReq.mo36177s()) {
            tTupleProtocol.mo40893a(trackConnectReq.deviceId);
        }
        if (trackConnectReq.mo36181v()) {
            tTupleProtocol.mo40893a(trackConnectReq.lastSessionId);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, TrackConnectReq trackConnectReq) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        trackConnectReq.sessionId = tTupleProtocol.mo40922x();
        trackConnectReq.mo36143a(true);
        trackConnectReq.version = tTupleProtocol.mo40918t();
        trackConnectReq.mo36148b(true);
        trackConnectReq.appKey = tTupleProtocol.mo40922x();
        trackConnectReq.mo36152c(true);
        trackConnectReq.deviceInfo = tTupleProtocol.mo40922x();
        trackConnectReq.mo36155d(true);
        trackConnectReq.deviceType = DeviceType.m31887a(tTupleProtocol.mo40919u());
        trackConnectReq.mo36159e(true);
        BitSet b = tTupleProtocol.mo40944b(2);
        if (b.get(0)) {
            trackConnectReq.deviceId = tTupleProtocol.mo40922x();
            trackConnectReq.mo36162f(true);
        }
        if (b.get(1)) {
            trackConnectReq.lastSessionId = tTupleProtocol.mo40922x();
            trackConnectReq.mo36163g(true);
        }
    }
}
