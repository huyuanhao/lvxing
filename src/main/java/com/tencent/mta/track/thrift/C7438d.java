package com.tencent.mta.track.thrift;

import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.d */
class C7438d extends TupleScheme {
    private C7438d() {
    }

    /* synthetic */ C7438d(C7390a aVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, CommonRequest commonRequest) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        tTupleProtocol.mo40892a(commonRequest.seq);
        tTupleProtocol.mo40892a(commonRequest.cmdType.getValue());
        BitSet bitSet = new BitSet();
        if (commonRequest.mo35962j()) {
            bitSet.set(0);
        }
        tTupleProtocol.mo40943a(bitSet, 1);
        if (commonRequest.mo35962j()) {
            tTupleProtocol.mo40893a(commonRequest.body);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, CommonRequest commonRequest) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        commonRequest.seq = tTupleProtocol.mo40919u();
        commonRequest.mo35939a(true);
        commonRequest.cmdType = CommonCmdType.m31822a(tTupleProtocol.mo40919u());
        commonRequest.mo35944b(true);
        if (tTupleProtocol.mo40944b(1).get(0)) {
            commonRequest.body = tTupleProtocol.mo40922x();
            commonRequest.mo35947c(true);
        }
    }
}
