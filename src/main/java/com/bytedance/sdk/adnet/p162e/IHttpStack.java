package com.bytedance.sdk.adnet.p162e;

import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.bytedance.sdk.adnet.e.a */
public interface IHttpStack {
    /* renamed from: a */
    HttpResponse mo14352a(Request<?> request, Map<String, String> map) throws IOException, VAdError;
}
