package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_args;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.ae */
class C7395ae extends TupleScheme {
    private C7395ae() {
    }

    /* synthetic */ C7395ae(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, pollRequest_args pollrequest_args) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet bitSet = new BitSet();
        if (pollrequest_args.mo36089d()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (pollrequest_args.mo36089d()) {
            pollrequest_args.req.write(tTupleProtocol);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, pollRequest_args pollrequest_args) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        if (tTupleProtocol.mo40944b(1).get(0)) {
            pollrequest_args.req = new TrackPollReq();
            pollrequest_args.req.read(tTupleProtocol);
            pollrequest_args.mo36082a(true);
        }
    }
}
