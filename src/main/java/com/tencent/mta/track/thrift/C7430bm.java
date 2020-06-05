package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.BitSet;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.bm */
class C7430bm extends TupleScheme {
    private C7430bm() {
    }

    /* synthetic */ C7430bm(C7427bj bjVar) {
        this();
    }

    /* renamed from: a */
    public void write(TProtocol fVar, TrackPollReq trackPollReq) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        tTupleProtocol.mo40893a(trackPollReq.sessionId);
        BitSet bitSet = new BitSet();
        if (trackPollReq.mo36278g()) {
            bitSet.set(0);
        }
        if (trackPollReq.mo36282j()) {
            bitSet.set(1);
        }
        tTupleProtocol.mo40943a(bitSet, 2);
        if (trackPollReq.mo36278g()) {
            trackPollReq.cRequest.write(tTupleProtocol);
        }
        if (trackPollReq.mo36282j()) {
            tTupleProtocol.mo40892a(trackPollReq.sRspList.size());
            for (CommonResponse write : trackPollReq.sRspList) {
                write.write(tTupleProtocol);
            }
        }
    }

    /* renamed from: b */
    public void read(TProtocol fVar, TrackPollReq trackPollReq) {
        TTupleProtocol tTupleProtocol = (TTupleProtocol) fVar;
        trackPollReq.sessionId = tTupleProtocol.mo40922x();
        trackPollReq.mo36265a(true);
        BitSet b = tTupleProtocol.mo40944b(2);
        if (b.get(0)) {
            trackPollReq.cRequest = new CommonRequest();
            trackPollReq.cRequest.read(tTupleProtocol);
            trackPollReq.mo36269b(true);
        }
        if (b.get(1)) {
            TList cVar = new TList(JceStruct.ZERO_TAG, tTupleProtocol.mo40919u());
            trackPollReq.sRspList = new ArrayList(cVar.f29150b);
            for (int i = 0; i < cVar.f29150b; i++) {
                CommonResponse commonResponse = new CommonResponse();
                commonResponse.read(tTupleProtocol);
                trackPollReq.sRspList.add(commonResponse);
            }
            trackPollReq.mo36272c(true);
        }
    }
}
