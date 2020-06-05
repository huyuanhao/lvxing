package com.tencent.mta.track.thrift;

import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.i */
class C7443i extends TupleScheme {
    private C7443i() {
    }

    /* synthetic */ C7443i(C7440f fVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, CommonResponse commonResponse) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        tTupleProtocol.mo40892a(commonResponse.seq);
        tTupleProtocol.mo40892a(commonResponse.cmdType.getValue());
        commonResponse.result.write(tTupleProtocol);
        BitSet bitSet = new BitSet();
        if (commonResponse.mo35999m()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (commonResponse.mo35999m()) {
            tTupleProtocol.mo40893a(commonResponse.body);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, CommonResponse commonResponse) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        commonResponse.seq = tTupleProtocol.mo40919u();
        commonResponse.mo35977a(true);
        commonResponse.cmdType = CommonCmdType.m31822a(tTupleProtocol.mo40919u());
        commonResponse.mo35982b(true);
        commonResponse.result = new ReqResult();
        commonResponse.result.read(tTupleProtocol);
        commonResponse.mo35985c(true);
        if (tTupleProtocol.mo40944b(1).get(0)) {
            commonResponse.body = tTupleProtocol.mo40922x();
            commonResponse.mo35987d(true);
        }
    }
}
