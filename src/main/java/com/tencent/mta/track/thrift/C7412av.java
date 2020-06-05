package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.av */
class C7412av extends StandardScheme {
    private C7412av() {
    }

    /* synthetic */ C7412av(C7411au auVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, TrackConnectRsp trackConnectRsp) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                break;
            }
            short s = j.f29148c;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            TProtocolUtil.m37231a(fVar, j.f29147b);
                        } else if (j.f29147b == 8) {
                            trackConnectRsp.pollInterval = fVar.mo40919u();
                            trackConnectRsp.mo36201d(true);
                        } else {
                            TProtocolUtil.m37231a(fVar, j.f29147b);
                        }
                    } else if (j.f29147b == 12) {
                        trackConnectRsp.result = new ReqResult();
                        trackConnectRsp.result.read(fVar);
                        trackConnectRsp.mo36199c(true);
                    } else {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                    }
                } else if (j.f29147b == 6) {
                    trackConnectRsp.version = fVar.mo40918t();
                    trackConnectRsp.mo36196b(true);
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 11) {
                trackConnectRsp.sessionId = fVar.mo40922x();
                trackConnectRsp.mo36191a(true);
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
        fVar.mo40907i();
        if (!trackConnectRsp.mo36206g()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'version' was not found in serialized data! Struct: ");
            sb.append(toString());
            throw new TProtocolException(sb.toString());
        } else if (trackConnectRsp.mo36213m()) {
            trackConnectRsp.mo36214n();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'pollInterval' was not found in serialized data! Struct: ");
            sb2.append(toString());
            throw new TProtocolException(sb2.toString());
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, TrackConnectRsp trackConnectRsp) {
        trackConnectRsp.mo36214n();
        fVar.mo40897a(TrackConnectRsp.STRUCT_DESC);
        if (trackConnectRsp.sessionId != null) {
            fVar.mo40894a(TrackConnectRsp.SESSION_ID_FIELD_DESC);
            fVar.mo40893a(trackConnectRsp.sessionId);
            fVar.mo40901c();
        }
        fVar.mo40894a(TrackConnectRsp.VERSION_FIELD_DESC);
        fVar.mo40898a(trackConnectRsp.version);
        fVar.mo40901c();
        if (trackConnectRsp.result != null) {
            fVar.mo40894a(TrackConnectRsp.RESULT_FIELD_DESC);
            trackConnectRsp.result.write(fVar);
            fVar.mo40901c();
        }
        fVar.mo40894a(TrackConnectRsp.POLL_INTERVAL_FIELD_DESC);
        fVar.mo40892a(trackConnectRsp.pollInterval);
        fVar.mo40901c();
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
