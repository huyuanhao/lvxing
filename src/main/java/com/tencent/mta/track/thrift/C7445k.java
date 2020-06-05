package com.tencent.mta.track.thrift;

import com.tencent.mta.track.thrift.MtaTrackRpc.connect_args._Fields;
import com.tencent.mta.track.thrift.MtaTrackRpc.connect_result;
import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_args;
import com.tencent.mta.track.thrift.MtaTrackRpc.disconnect_result;
import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_args;
import com.tencent.mta.track.thrift.MtaTrackRpc.pollRequest_result;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.thrift.k */
/* synthetic */ class C7445k {
    /* renamed from: a */
    static final /* synthetic */ int[] f24992a = new int[_Fields.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f24993b = new int[connect_result._Fields.values().length];
    /* renamed from: c */
    static final /* synthetic */ int[] f24994c = new int[pollRequest_args._Fields.values().length];
    /* renamed from: d */
    static final /* synthetic */ int[] f24995d = new int[pollRequest_result._Fields.values().length];
    /* renamed from: e */
    static final /* synthetic */ int[] f24996e = new int[disconnect_args._Fields.values().length];
    /* renamed from: f */
    static final /* synthetic */ int[] f24997f = new int[disconnect_result._Fields.values().length];

    static {
        try {
            f24997f[disconnect_result._Fields.SUCCESS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24996e[disconnect_args._Fields.REQ.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f24995d[pollRequest_result._Fields.SUCCESS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f24994c[pollRequest_args._Fields.REQ.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f24993b[connect_result._Fields.SUCCESS.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f24992a[_Fields.REQ.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
