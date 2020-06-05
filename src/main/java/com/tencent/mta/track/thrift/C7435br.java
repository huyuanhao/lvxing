package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.br */
class C7435br extends TupleScheme {
    private C7435br() {
    }

    /* synthetic */ C7435br(C7432bo boVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, TrackPollRsp trackPollRsp) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet bitSet = new BitSet();
        if (trackPollRsp.mo36302d()) {
            bitSet.set(0);
        }
        if (trackPollRsp.mo36306g()) {
            bitSet.set(1);
        }
        if (trackPollRsp.mo36310j()) {
            bitSet.set(2);
        }
        tTupleProtocol.mo40943a(bitSet, 3);
        if (trackPollRsp.mo36302d()) {
            trackPollRsp.cResponse.write(tTupleProtocol);
        }
        if (trackPollRsp.mo36306g()) {
            tTupleProtocol.mo40892a(trackPollRsp.sReqList.size());
            for (CommonRequest write : trackPollRsp.sReqList) {
                write.write(tTupleProtocol);
            }
        }
        if (trackPollRsp.mo36310j()) {
            tTupleProtocol.mo40892a(trackPollRsp.pollInterval);
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, TrackPollRsp trackPollRsp) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        BitSet b = tTupleProtocol.mo40944b(3);
        if (b.get(0)) {
            trackPollRsp.cResponse = new CommonResponse();
            trackPollRsp.cResponse.read(tTupleProtocol);
            trackPollRsp.mo36292a(true);
        }
        if (b.get(1)) {
            TList cVar = new TList(JceStruct.ZERO_TAG, tTupleProtocol.mo40919u());
            trackPollRsp.sReqList = new ArrayList(cVar.f29150b);
            for (int i = 0; i < cVar.f29150b; i++) {
                CommonRequest commonRequest = new CommonRequest();
                commonRequest.read(tTupleProtocol);
                trackPollRsp.sReqList.add(commonRequest);
            }
            trackPollRsp.mo36297b(true);
        }
        if (b.get(2)) {
            trackPollRsp.pollInterval = tTupleProtocol.mo40919u();
            trackPollRsp.mo36300c(true);
        }
    }
}
