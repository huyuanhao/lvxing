package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.ba */
class C7418ba extends StandardScheme {
    private C7418ba() {
    }

    /* synthetic */ C7418ba(C7416az azVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, TrackDisConnectReq trackDisConnectReq) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                trackDisConnectReq.mo36236h();
                return;
            }
            short s = j.f29148c;
            if (s != 1) {
                if (s != 2) {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                } else if (j.f29147b == 11) {
                    trackDisConnectReq.reason = fVar.mo40922x();
                    trackDisConnectReq.mo36227b(true);
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 11) {
                trackDisConnectReq.sessionId = fVar.mo40922x();
                trackDisConnectReq.mo36222a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, TrackDisConnectReq trackDisConnectReq) {
        trackDisConnectReq.mo36236h();
        fVar.mo40897a(TrackDisConnectReq.STRUCT_DESC);
        if (trackDisConnectReq.sessionId != null) {
            fVar.mo40894a(TrackDisConnectReq.SESSION_ID_FIELD_DESC);
            fVar.mo40893a(trackDisConnectReq.sessionId);
            fVar.mo40901c();
        }
        if (trackDisConnectReq.reason != null && trackDisConnectReq.mo36235g()) {
            fVar.mo40894a(TrackDisConnectReq.REASON_FIELD_DESC);
            fVar.mo40893a(trackDisConnectReq.reason);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
