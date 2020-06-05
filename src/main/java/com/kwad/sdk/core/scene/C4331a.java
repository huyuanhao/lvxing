package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import com.kwad.sdk.core.scene.PageScene.PageSource;
import com.kwad.sdk.protocol.model.AdScene;
import java.util.HashMap;

/* renamed from: com.kwad.sdk.core.scene.a */
public class C4331a {
    /* renamed from: a */
    public static C4331a f14238a;
    /* renamed from: b */
    private static Object f14239b = new Object();
    /* renamed from: c */
    private HashMap<Long, String> f14240c = new HashMap<>();
    /* renamed from: d */
    private HashMap<String, PageScene> f14241d = new HashMap<>();
    /* renamed from: e */
    private PageScene f14242e;
    /* renamed from: f */
    private final PageScene f14243f = new PageScene("", PageSource.UNKNOWN, new AdScene(-1));

    /* renamed from: a */
    public static C4331a m17707a() {
        if (f14238a == null) {
            synchronized (f14239b) {
                if (f14238a == null) {
                    f14238a = new C4331a();
                }
            }
        }
        return f14238a;
    }

    /* renamed from: a */
    private void m17708a(String str, PageScene pageScene) {
        if (!this.f14241d.containsKey(str)) {
            this.f14241d.put(str, pageScene);
        }
    }

    /* renamed from: a */
    public PageScene mo24479a(long j) {
        String str = (String) this.f14240c.get(Long.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            return (PageScene) this.f14241d.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo24480a(AdScene adScene, PageSource pageSource, String str) {
        PageScene pageScene = new PageScene(str, pageSource, adScene);
        this.f14240c.put(Long.valueOf(adScene.posId), str);
        PageScene pageScene2 = this.f14242e;
        PageScene pageScene3 = (pageScene2 == null || pageScene2.f14236b == pageSource) ? this.f14243f : this.f14242e;
        m17708a(str, pageScene3);
        this.f14242e = pageScene;
    }

    /* renamed from: a */
    public void mo24481a(String str) {
        this.f14241d.remove(str);
        PageScene pageScene = this.f14242e;
        if (pageScene != null && pageScene.f14237c.equals(str)) {
            this.f14242e = null;
        }
    }
}
