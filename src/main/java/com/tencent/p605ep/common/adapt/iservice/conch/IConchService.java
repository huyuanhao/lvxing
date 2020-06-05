package com.tencent.p605ep.common.adapt.iservice.conch;

import java.util.List;

/* renamed from: com.tencent.ep.common.adapt.iservice.conch.IConchService */
public interface IConchService {

    /* renamed from: com.tencent.ep.common.adapt.iservice.conch.IConchService$IConchPushListener */
    public static abstract class IConchPushListener {
        public int mErrorCode = 0;

        public void onRecvPush(ConchPushInfo conchPushInfo) {
        }
    }

    void pullConch(int i);

    void registerConchPush(int i, IConchPushListener iConchPushListener);

    void registerConchPush(List<Integer> list, IConchPushListener iConchPushListener);

    void reportConchResult(long j, long j2, int i, int i2, int i3, int i4);

    void reportConchResult(ConchPushInfo conchPushInfo, int i, int i2);

    void unRegisterConchPush(int i);

    void unRegisterConchPush(List<Integer> list);
}
