package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_result;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.ai */
class C7399ai extends TupleScheme {
    private C7399ai() {
    }

    /* synthetic */ C7399ai(C7445k kVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, pollRequest_result pollrequest_result) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet bitSet = new BitSet();
        if (pollrequest_result.mo36107d()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (pollrequest_result.mo36107d()) {
            pollrequest_result.success.write(tTupleProtocol);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, pollRequest_result pollrequest_result) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        if (tTupleProtocol.mo40944b(1).get(0)) {
            pollrequest_result.success = new TrackPollRsp();
            pollrequest_result.success.read(tTupleProtocol);
            pollrequest_result.mo36100a(true);
        }
    }
}
