package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.connect_args;
import com.tencent.mta.track.thrift.MtaTrackRpc.connect_result;
import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_args;
import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_result;
import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_args;
import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_result;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.l */
public class C7446l extends TServiceClient {
    public C7446l(TProtocol fVar) {
        super(fVar, fVar);
    }

    /* renamed from: a */
    public TrackConnectRsp mo36387a(TrackConnectReq trackConnectReq) {
        mo36391b(trackConnectReq);
        return mo36386a();
    }

    /* renamed from: b */
    public void mo36391b(TrackConnectReq trackConnectReq) {
        connect_args connect_args = new connect_args();
        connect_args.mo36007a(trackConnectReq);
        sendBase("connect", connect_args);
    }

    /* renamed from: a */
    public TrackConnectRsp mo36386a() {
        connect_result connect_result = new connect_result();
        receiveBase(connect_result, "connect");
        if (connect_result.mo36035d()) {
            return connect_result.success;
        }
        throw new TApplicationException(5, "connect failed: unknown result");
    }

    /* renamed from: a */
    public TrackPollRsp mo36389a(TrackPollReq trackPollReq) {
        mo36393b(trackPollReq);
        return mo36390b();
    }

    /* renamed from: b */
    public void mo36393b(TrackPollReq trackPollReq) {
        pollRequest_args pollrequest_args = new pollRequest_args();
        pollrequest_args.mo36079a(trackPollReq);
        sendBase("pollRequest", pollrequest_args);
    }

    /* renamed from: b */
    public TrackPollRsp mo36390b() {
        pollRequest_result pollrequest_result = new pollRequest_result();
        receiveBase(pollrequest_result, "pollRequest");
        if (pollrequest_result.mo36107d()) {
            return pollrequest_result.success;
        }
        throw new TApplicationException(5, "pollRequest failed: unknown result");
    }

    /* renamed from: a */
    public TrackDisConnectRsp mo36388a(TrackDisConnectReq trackDisConnectReq) {
        mo36392b(trackDisConnectReq);
        return mo36394c();
    }

    /* renamed from: b */
    public void mo36392b(TrackDisConnectReq trackDisConnectReq) {
        disconnect_args disconnect_args = new disconnect_args();
        disconnect_args.mo36043a(trackDisConnectReq);
        sendBase("disconnect", disconnect_args);
    }

    /* renamed from: c */
    public TrackDisConnectRsp mo36394c() {
        disconnect_result disconnect_result = new disconnect_result();
        receiveBase(disconnect_result, "disconnect");
        if (disconnect_result.mo36071d()) {
            return disconnect_result.success;
        }
        throw new TApplicationException(5, "disconnect failed: unknown result");
    }
}
