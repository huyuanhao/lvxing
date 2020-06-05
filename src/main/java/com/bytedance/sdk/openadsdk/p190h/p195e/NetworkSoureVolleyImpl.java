package com.bytedance.sdk.openadsdk.p190h.p195e;

import com.bytedance.sdk.adnet.core.DefaultRetryPolicy;
import com.bytedance.sdk.adnet.core.HurlStack;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p162e.IHttpStack;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.openadsdk.h.e.d */
public class NetworkSoureVolleyImpl implements INetworkSource {
    /* renamed from: a */
    private IHttpStack f8848a = TTNetClient.m11426a();

    public NetworkSoureVolleyImpl() {
        if (this.f8848a == null) {
            this.f8848a = new HurlStack();
        }
    }

    /* renamed from: a */
    public AbsResponseWrapper mo16751a(VideoRequest fVar) throws IOException, VAdError {
        VideoCacheRequest eVar = new VideoCacheRequest(fVar.f8849a, fVar.f8850b);
        if (fVar.f8851c != -1) {
            eVar.setRetryPolicy(new DefaultRetryPolicy().mo14330a((int) fVar.f8851c));
        }
        return new VolleyResponseWrapper(this.f8848a.mo14352a(eVar, fVar.f8853e), fVar);
    }
}
