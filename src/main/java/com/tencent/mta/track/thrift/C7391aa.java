package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_result;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.aa */
class C7391aa extends TupleScheme {
    private C7391aa() {
    }

    /* synthetic */ C7391aa(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, disconnect_result disconnect_result) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet bitSet = new BitSet();
        if (disconnect_result.mo36071d()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (disconnect_result.mo36071d()) {
            disconnect_result.success.write(tTupleProtocol);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, disconnect_result disconnect_result) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        if (tTupleProtocol.mo40944b(1).get(0)) {
            disconnect_result.success = new TrackDisConnectRsp();
            disconnect_result.success.read(tTupleProtocol);
            disconnect_result.mo36064a(true);
        }
    }
}
