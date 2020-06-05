package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_args;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.w */
class C7457w extends TupleScheme {
    private C7457w() {
    }

    /* synthetic */ C7457w(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, disconnect_args disconnect_args) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet bitSet = new BitSet();
        if (disconnect_args.mo36053d()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (disconnect_args.mo36053d()) {
            disconnect_args.req.write(tTupleProtocol);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, disconnect_args disconnect_args) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        if (tTupleProtocol.mo40944b(1).get(0)) {
            disconnect_args.req = new TrackDisConnectReq();
            disconnect_args.req.read(tTupleProtocol);
            disconnect_args.mo36046a(true);
        }
    }
}
