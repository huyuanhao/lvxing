package com.tencent.mta.track.thrift;

import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.an */
class C7404an extends TupleScheme {
    private C7404an() {
    }

    /* synthetic */ C7404an(C7401ak akVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, ReqResult reqResult) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        tTupleProtocol.mo40892a(reqResult.errorCode.getValue());
        BitSet bitSet = new BitSet();
        if (reqResult.mo36131g()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (reqResult.mo36131g()) {
            tTupleProtocol.mo40893a(reqResult.errorMsg);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, ReqResult reqResult) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        reqResult.errorCode = ErrorCode.m31888a(tTupleProtocol.mo40919u());
        reqResult.mo36119a(true);
        if (tTupleProtocol.mo40944b(1).get(0)) {
            reqResult.errorMsg = tTupleProtocol.mo40922x();
            reqResult.mo36123b(true);
        }
    }
}
