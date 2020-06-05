package com.tmsdk.module.coin;

import android.content.Context;
import btmsdkobf.C0670cx;
import btmsdkobf.C0691dh;
import btmsdkobf.C0693dj;
import btmsdkobf.C0696dm;
import btmsdkobf.C0716dx;
import btmsdkobf.C0801ej;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.iservice.net.IGuidCallback;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkCallBack;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkCallBack3;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkPushListener;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkPushListener3;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkService;
import com.tencent.p605ep.common.adapt.iservice.net.Triple;

public class DefSharkServiceImpl implements ISharkService {
    /* renamed from: I */
    private static DefSharkServiceImpl f25878I = null;
    private static Object lock = new Object();

    public static DefSharkServiceImpl getInstance(Context context) {
        if (f25878I == null) {
            synchronized (lock) {
                if (f25878I == null) {
                    f25878I = new DefSharkServiceImpl();
                }
            }
        }
        return f25878I;
    }

    public String getGuid() {
        return C0716dx.m434bx().getGuid();
    }

    public void getGuidAsyn(final IGuidCallback iGuidCallback) {
        C0716dx.m434bx().mo9431c(new C0691dh() {
            /* renamed from: b */
            public void mo9292b(int i, String str) {
                IGuidCallback iGuidCallback = iGuidCallback;
                if (iGuidCallback != null) {
                    iGuidCallback.onCallback(i, str);
                }
            }
        });
    }

    public String getVid() {
        return C0716dx.m436bz().mo9242az();
    }

    public void registerSharkPush(int i, int i2, ISharkPushListener3 iSharkPushListener3) {
    }

    public void registerSharkPush(int i, JceStruct jceStruct, int i2, final ISharkPushListener iSharkPushListener) {
        C0670cx.m165al().mo9213a(i, jceStruct, i2, new C0696dm() {
            /* renamed from: a */
            public C0801ej<Long, Integer, JceStruct> mo9297a(int i, long j, int i2, JceStruct jceStruct) {
                Triple onRecvPush = iSharkPushListener.onRecvPush(i, j, i2, jceStruct);
                return new C0801ej<>(onRecvPush.first, onRecvPush.second, onRecvPush.third);
            }
        });
    }

    public void sendShark(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, final ISharkCallBack iSharkCallBack) {
        C0670cx.m165al().mo9214a(i, jceStruct, jceStruct2, i2, iSharkCallBack != null ? new C0693dj() {
            /* renamed from: a */
            public void mo9159a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                iSharkCallBack.onFinish(i, i2, i3, i4, jceStruct);
            }
        } : null, 0);
    }

    public void sendShark(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, ISharkCallBack iSharkCallBack, long j) {
        C76533 r1;
        final ISharkCallBack iSharkCallBack2 = iSharkCallBack;
        if (iSharkCallBack2 != null) {
            r1 = new C0693dj() {
                /* renamed from: a */
                public void mo9159a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    iSharkCallBack2.onFinish(i, i2, i3, i4, jceStruct);
                }
            };
        } else {
            r1 = null;
        }
        C0670cx.m165al().mo9214a(i, jceStruct, jceStruct2, i2, r1, j);
    }

    public void sendShark(int i, byte[] bArr, int i2, ISharkCallBack3 iSharkCallBack3, long j) {
    }

    public void sendSharkPushResult(int i, long j, int i2, JceStruct jceStruct) {
        C0716dx.m434bx().sendSharkPushResult(i, j, i2, jceStruct);
    }

    public void sendSharkPushResult(int i, long j, int i2, byte[] bArr) {
    }

    public void unregisterSharkPush(int i, int i2) {
        C0670cx.m165al().mo9219e(i, i2);
    }
}
