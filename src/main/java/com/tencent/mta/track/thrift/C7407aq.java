package com.tencent.mta.track.thrift;

import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.aq */
class C7407aq extends StandardScheme {
    private C7407aq() {
    }

    /* synthetic */ C7407aq(C7406ap apVar) {
        this();
    }

    /* renamed from: a */
    public void read(TProtocol fVar, TrackConnectReq trackConnectReq) {
        fVar.mo40906h();
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                if (trackConnectReq.mo36164g()) {
                    trackConnectReq.mo36182w();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Required field 'version' was not found in serialized data! Struct: ");
                sb.append(toString());
                throw new TProtocolException(sb.toString());
            }
            switch (j.f29148c) {
                case 1:
                    if (j.f29147b != 11) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                        break;
                    } else {
                        trackConnectReq.sessionId = fVar.mo40922x();
                        trackConnectReq.mo36143a(true);
                        break;
                    }
                case 2:
                    if (j.f29147b != 6) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                        break;
                    } else {
                        trackConnectReq.version = fVar.mo40918t();
                        trackConnectReq.mo36148b(true);
                        break;
                    }
                case 3:
                    if (j.f29147b != 11) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                        break;
                    } else {
                        trackConnectReq.appKey = fVar.mo40922x();
                        trackConnectReq.mo36152c(true);
                        break;
                    }
                case 4:
                    if (j.f29147b != 11) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                        break;
                    } else {
                        trackConnectReq.deviceInfo = fVar.mo40922x();
                        trackConnectReq.mo36155d(true);
                        break;
                    }
                case 5:
                    if (j.f29147b != 8) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                        break;
                    } else {
                        trackConnectReq.deviceType = DeviceType.m31887a(fVar.mo40919u());
                        trackConnectReq.mo36159e(true);
                        break;
                    }
                case 6:
                    if (j.f29147b != 11) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                        break;
                    } else {
                        trackConnectReq.deviceId = fVar.mo40922x();
                        trackConnectReq.mo36162f(true);
                        break;
                    }
                case 7:
                    if (j.f29147b != 11) {
                        TProtocolUtil.m37231a(fVar, j.f29147b);
                        break;
                    } else {
                        trackConnectReq.lastSessionId = fVar.mo40922x();
                        trackConnectReq.mo36163g(true);
                        break;
                    }
                default:
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                    break;
            }
            fVar.mo40909k();
        }
    }

    /* renamed from: b */
    public void write(TProtocol fVar, TrackConnectReq trackConnectReq) {
        trackConnectReq.mo36182w();
        fVar.mo40897a(TrackConnectReq.STRUCT_DESC);
        if (trackConnectReq.sessionId != null) {
            fVar.mo40894a(TrackConnectReq.SESSION_ID_FIELD_DESC);
            fVar.mo40893a(trackConnectReq.sessionId);
            fVar.mo40901c();
        }
        fVar.mo40894a(TrackConnectReq.VERSION_FIELD_DESC);
        fVar.mo40898a(trackConnectReq.version);
        fVar.mo40901c();
        if (trackConnectReq.appKey != null) {
            fVar.mo40894a(TrackConnectReq.APP_KEY_FIELD_DESC);
            fVar.mo40893a(trackConnectReq.appKey);
            fVar.mo40901c();
        }
        if (trackConnectReq.deviceInfo != null) {
            fVar.mo40894a(TrackConnectReq.DEVICE_INFO_FIELD_DESC);
            fVar.mo40893a(trackConnectReq.deviceInfo);
            fVar.mo40901c();
        }
        if (trackConnectReq.deviceType != null) {
            fVar.mo40894a(TrackConnectReq.DEVICE_TYPE_FIELD_DESC);
            fVar.mo40892a(trackConnectReq.deviceType.getValue());
            fVar.mo40901c();
        }
        if (trackConnectReq.deviceId != null && trackConnectReq.mo36177s()) {
            fVar.mo40894a(TrackConnectReq.DEVICE_ID_FIELD_DESC);
            fVar.mo40893a(trackConnectReq.deviceId);
            fVar.mo40901c();
        }
        if (trackConnectReq.lastSessionId != null && trackConnectReq.mo36181v()) {
            fVar.mo40894a(TrackConnectReq.LAST_SESSION_ID_FIELD_DESC);
            fVar.mo40893a(trackConnectReq.lastSessionId);
            fVar.mo40901c();
        }
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
