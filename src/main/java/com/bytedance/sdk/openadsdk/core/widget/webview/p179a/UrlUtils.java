package com.bytedance.sdk.openadsdk.core.widget.webview.p179a;

import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.e */
public class UrlUtils {

    /* compiled from: UrlUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.e$a */
    public enum C2372a {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");
        
        /* renamed from: e */
        private String f8412e;

        private C2372a(String str) {
            this.f8412e = str;
        }

        /* renamed from: a */
        public String mo16385a() {
            return this.f8412e;
        }
    }

    /* renamed from: a */
    public static C2372a m10910a(String str) {
        C2372a aVar = C2372a.HTML;
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path == null) {
                return aVar;
            }
            if (path.endsWith(".css")) {
                return C2372a.CSS;
            }
            if (path.endsWith(".js")) {
                return C2372a.JS;
            }
            return (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp")) ? C2372a.IMAGE : aVar;
        } catch (Throwable unused) {
            return aVar;
        }
    }
}
