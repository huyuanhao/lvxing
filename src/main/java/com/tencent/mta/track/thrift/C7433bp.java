package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.bp */
class C7433bp extends StandardScheme {
    private C7433bp() {
    }

    /* synthetic */ C7433bp(C7432bo boVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, TrackPollRsp trackPollRsp) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                trackPollRsp.mo36311k();
                return;
            }
            short s = j.f29148c;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    } else if (j.f29147b == 8) {
                        trackPollRsp.pollInterval = fVar.mo40919u();
                        trackPollRsp.mo36300c(true);
                    } else {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    }
                } else if (j.f29147b == 15) {
                    TList n = fVar.mo40912n();
                    trackPollRsp.sReqList = new ArrayList(n.f29150b);
                    for (int i = 0; i < n.f29150b; i++) {
                        CommonRequest commonRequest = new CommonRequest();
                        commonRequest.read(fVar);
                        trackPollRsp.sReqList.add(commonRequest);
                    }
                    fVar.mo40913o();
                    trackPollRsp.mo36297b(true);
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 12) {
                trackPollRsp.cResponse = new CommonResponse();
                trackPollRsp.cResponse.read(fVar);
                trackPollRsp.mo36292a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, TrackPollRsp trackPollRsp) {
        trackPollRsp.mo36311k();
        fVar.mo40897a(TrackPollRsp.STRUCT_DESC);
        if (trackPollRsp.cResponse != null && trackPollRsp.mo36302d()) {
            fVar.mo40894a(TrackPollRsp.C_RESPONSE_FIELD_DESC);
            trackPollRsp.cResponse.write(fVar);
            fVar.mo40901c();
        }
        if (trackPollRsp.sReqList != null && trackPollRsp.mo36306g()) {
            fVar.mo40894a(TrackPollRsp.S_REQ_LIST_FIELD_DESC);
            fVar.mo40895a(new TList(JceStruct.ZERO_TAG, trackPollRsp.sReqList.size()));
            for (CommonRequest write : trackPollRsp.sReqList) {
                write.write(fVar);
            }
            fVar.mo40903e();
            fVar.mo40901c();
        }
        if (trackPollRsp.mo36310j()) {
            fVar.mo40894a(TrackPollRsp.POLL_INTERVAL_FIELD_DESC);
            fVar.mo40892a(trackPollRsp.pollInterval);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
