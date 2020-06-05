package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.bk */
class C7428bk extends StandardScheme {
    private C7428bk() {
    }

    /* synthetic */ C7428bk(C7427bj bjVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, TrackPollReq trackPollReq) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                trackPollReq.mo36283k();
                return;
            }
            short s = j.f29148c;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    } else if (j.f29147b == 15) {
                        TList n = fVar.mo40912n();
                        trackPollReq.sRspList = new ArrayList(n.f29150b);
                        for (int i = 0; i < n.f29150b; i++) {
                            CommonResponse commonResponse = new CommonResponse();
                            commonResponse.read(fVar);
                            trackPollReq.sRspList.add(commonResponse);
                        }
                        fVar.mo40913o();
                        trackPollReq.mo36272c(true);
                    } else {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    }
                } else if (j.f29147b == 12) {
                    trackPollReq.cRequest = new CommonRequest();
                    trackPollReq.cRequest.read(fVar);
                    trackPollReq.mo36269b(true);
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 11) {
                trackPollReq.sessionId = fVar.mo40922x();
                trackPollReq.mo36265a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, TrackPollReq trackPollReq) {
        trackPollReq.mo36283k();
        fVar.mo40897a(TrackPollReq.STRUCT_DESC);
        if (trackPollReq.sessionId != null) {
            fVar.mo40894a(TrackPollReq.SESSION_ID_FIELD_DESC);
            fVar.mo40893a(trackPollReq.sessionId);
            fVar.mo40901c();
        }
        if (trackPollReq.cRequest != null && trackPollReq.mo36278g()) {
            fVar.mo40894a(TrackPollReq.C_REQUEST_FIELD_DESC);
            trackPollReq.cRequest.write(fVar);
            fVar.mo40901c();
        }
        if (trackPollReq.sRspList != null && trackPollReq.mo36282j()) {
            fVar.mo40894a(TrackPollReq.S_RSP_LIST_FIELD_DESC);
            fVar.mo40895a(new TList(JceStruct.ZERO_TAG, trackPollReq.sRspList.size()));
            for (CommonResponse write : trackPollReq.sRspList) {
                write.write(fVar);
            }
            fVar.mo40903e();
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
