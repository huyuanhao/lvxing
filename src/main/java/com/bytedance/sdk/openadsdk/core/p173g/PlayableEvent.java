package com.bytedance.sdk.openadsdk.core.p173g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import java.util.HashMap;

/* renamed from: com.bytedance.sdk.openadsdk.core.g.b */
public class PlayableEvent {
    /* renamed from: a */
    public static void m9612a(Context context, MaterialMeta kVar) {
        AdEventManager.m8419r(context, kVar, "playable_preload", "preload_start", null);
    }

    /* renamed from: a */
    public static void m9614a(Context context, MaterialMeta kVar, long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("loadzip_success_time", Long.valueOf(j));
        hashMap.put("unzip_success_time", Long.valueOf(j2));
        AdEventManager.m8419r(context, kVar, "playable_preload", "preload_success", hashMap);
    }

    /* renamed from: a */
    public static void m9613a(Context context, MaterialMeta kVar, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("error_reason", str);
        AdEventManager.m8419r(context, kVar, "playable_preload", "preload_fail", hashMap);
    }
}
