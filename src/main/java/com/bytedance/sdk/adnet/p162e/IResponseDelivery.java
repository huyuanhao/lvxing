package com.bytedance.sdk.adnet.p162e;

import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;

/* renamed from: com.bytedance.sdk.adnet.e.d */
public interface IResponseDelivery {
    /* renamed from: a */
    void mo14347a(Request<?> request, C1982p<?> pVar);

    /* renamed from: a */
    void mo14348a(Request<?> request, C1982p<?> pVar, Runnable runnable);

    /* renamed from: a */
    void mo14349a(Request<?> request, VAdError vAdError);
}
