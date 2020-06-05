package com.kwad.sdk.core.scene;

import androidx.core.p003os.EnvironmentCompat;
import com.kwad.sdk.protocol.model.AdScene;

public class PageScene {
    /* renamed from: a */
    public final AdScene f14235a;
    /* renamed from: b */
    public final PageSource f14236b;
    /* renamed from: c */
    public final String f14237c;

    /* renamed from: com.kwad.sdk.core.scene.PageScene$PageSource */
    public enum PageSource {
        UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
        ENTRYWIDGET("entry"),
        HOMETAB("homeTab");
        
        public final String mPageName;

        private PageSource(String str) {
            this.mPageName = str;
        }
    }

    public PageScene(String str, PageSource pageSource, AdScene adScene) {
        this.f14236b = pageSource;
        this.f14235a = adScene;
        this.f14237c = str;
    }
}
