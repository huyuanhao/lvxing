package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.connect_args;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.o */
class C7449o extends TupleScheme {
    private C7449o() {
    }

    /* synthetic */ C7449o(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, connect_args connect_args) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet bitSet = new BitSet();
        if (connect_args.mo36017d()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (connect_args.mo36017d()) {
            connect_args.req.write(tTupleProtocol);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, connect_args connect_args) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        if (tTupleProtocol.mo40944b(1).get(0)) {
            connect_args.req = new TrackConnectReq();
            connect_args.req.read(tTupleProtocol);
            connect_args.mo36010a(true);
        }
    }
}
