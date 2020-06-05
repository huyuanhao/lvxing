package com.tencent.mta.track.util;

import android.util.Log;
import com.tencent.mta.track.thrift.C7446l;
import org.apache.thrift.protocol.TBinaryProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.util.h */
class C7469h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ThrifClient f25028a;

    C7469h(ThrifClient thrifClient) {
        this.f25028a = thrifClient;
    }

    public void run() {
        try {
            this.f25028a.f25010e = new C7446l(new TBinaryProtocol(this.f25028a.m32316f()));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("TSocket : ");
            sb.append(th);
            Log.e("track", sb.toString());
        }
    }
}
