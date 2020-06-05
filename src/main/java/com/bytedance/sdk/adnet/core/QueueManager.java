package com.bytedance.sdk.adnet.core;

import android.content.Context;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.p162e.IHttpStack;
import com.bytedance.sdk.adnet.p162e.INetwork;
import java.io.File;

/* renamed from: com.bytedance.sdk.adnet.core.n */
public class QueueManager {
    /* renamed from: a */
    public static RequestQueue m7904a(Context context) {
        return m7905a(context, (IHttpStack) null);
    }

    /* renamed from: a */
    public static RequestQueue m7905a(Context context, IHttpStack aVar) {
        if (aVar == null) {
            aVar = new HurlStack();
        }
        return m7906a(context, (INetwork) new BasicNetwork(aVar));
    }

    /* renamed from: a */
    private static RequestQueue m7906a(Context context, INetwork cVar) {
        RequestQueue oVar = new RequestQueue(new DiskBasedCache(new File(AdNetSdk.m7649b(context), "reqQueue")), cVar);
        oVar.mo14362a();
        return oVar;
    }
}
