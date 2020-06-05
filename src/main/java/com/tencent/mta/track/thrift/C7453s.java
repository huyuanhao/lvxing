package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.connect_result;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.s */
class C7453s extends TupleScheme {
    private C7453s() {
    }

    /* synthetic */ C7453s(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, connect_result connect_result) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet bitSet = new BitSet();
        if (connect_result.mo36035d()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (connect_result.mo36035d()) {
            connect_result.success.write(tTupleProtocol);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, connect_result connect_result) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        if (tTupleProtocol.mo40944b(1).get(0)) {
            connect_result.success = new TrackConnectRsp();
            connect_result.success.read(tTupleProtocol);
            connect_result.mo36028a(true);
        }
    }
}
