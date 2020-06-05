package com.tencent.p605ep.common.adapt.iservice.net;

import com.p522qq.taf.jce.JceStruct;

/* renamed from: com.tencent.ep.common.adapt.iservice.net.ISharkPushListener */
public interface ISharkPushListener {
    Triple<Long, Integer, JceStruct> onRecvPush(int i, long j, int i2, JceStruct jceStruct);
}
