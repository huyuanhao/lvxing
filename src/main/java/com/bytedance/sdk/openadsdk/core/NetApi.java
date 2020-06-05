package com.bytedance.sdk.openadsdk.core;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.NetApiImpl.C2296c;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel;
import com.bytedance.sdk.openadsdk.p165c.AdEventUploadResult;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.p */
public interface NetApi<T> {

    /* compiled from: NetApi */
    /* renamed from: com.bytedance.sdk.openadsdk.core.p$a */
    public interface C2286a {
        /* renamed from: a */
        void mo15248a(boolean z, long j, long j2);
    }

    /* compiled from: NetApi */
    /* renamed from: com.bytedance.sdk.openadsdk.core.p$b */
    public interface C2287b {
        /* renamed from: a */
        void mo14946a(int i, String str);

        /* renamed from: a */
        void mo14947a(AdInfo aVar);
    }

    /* compiled from: NetApi */
    /* renamed from: com.bytedance.sdk.openadsdk.core.p$c */
    public interface C2288c {
        /* renamed from: a */
        void mo14968a(int i, String str);

        /* renamed from: a */
        void mo14969a(C2296c cVar);
    }

    /* renamed from: a */
    AdEventUploadResult mo15913a(List<T> list);

    /* renamed from: a */
    AdEventUploadResult mo15914a(JSONObject jSONObject);

    /* renamed from: a */
    TempPkgModel mo15915a();

    /* renamed from: a */
    void mo15916a(int i, String str, String str2, Bitmap bitmap);

    /* renamed from: a */
    void mo15917a(AdSlot adSlot, NetExtParams lVar, int i, C2287b bVar);

    /* renamed from: a */
    void mo15918a(MaterialMeta kVar, List<FilterWord> list);

    /* renamed from: a */
    void mo15919a(String str, String str2, C2286a aVar);

    /* renamed from: a */
    void mo15920a(JSONObject jSONObject, C2288c cVar);

    /* renamed from: a */
    boolean mo15921a(JSONObject jSONObject, int i);
}
