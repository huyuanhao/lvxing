package com.tencent.p605ep.common.adapt.iservice.net;

import com.p522qq.taf.jce.JceStruct;

/* renamed from: com.tencent.ep.common.adapt.iservice.net.ISharkService */
public interface ISharkService {
    public static final int CALLBACK_RUN_ON_NET_THREAD = 16;
    public static final int CALLBACK_RUN_ON_THREAD = 0;
    public static final int CALLBACK_RUN_ON_UI = 8;
    public static final int CHANNEL_DEFAULT = 0;
    public static final int CHANNEL_IPV4_REPORT = 2560;
    public static final int CHANNEL_LARGE_DATA = 2048;
    public static final int CHANNEL_ONLY_HTTP = 512;
    public static final int CHANNEL_ONLY_TCP = 1024;
    public static final int DEFAULT = 0;

    String getGuid();

    void getGuidAsyn(IGuidCallback iGuidCallback);

    String getVid();

    void registerSharkPush(int i, int i2, ISharkPushListener3 iSharkPushListener3);

    void registerSharkPush(int i, JceStruct jceStruct, int i2, ISharkPushListener iSharkPushListener);

    void sendShark(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, ISharkCallBack iSharkCallBack);

    void sendShark(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, ISharkCallBack iSharkCallBack, long j);

    void sendShark(int i, byte[] bArr, int i2, ISharkCallBack3 iSharkCallBack3, long j);

    void sendSharkPushResult(int i, long j, int i2, JceStruct jceStruct);

    void sendSharkPushResult(int i, long j, int i2, byte[] bArr);

    void unregisterSharkPush(int i, int i2);
}
