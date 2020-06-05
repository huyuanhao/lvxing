package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;

/* renamed from: com.bytedance.sdk.openadsdk.utils.q */
public class JsBridgeUtils {
    /* renamed from: a */
    public static void m12207a(Uri uri, TTAndroidObject xVar) {
        if (xVar != null && xVar.mo16413a(uri)) {
            try {
                xVar.mo16419b(uri);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("TTAndroidObj handleUri exception: ");
                sb.append(e);
                C2564t.m12225d("WebView", sb.toString());
            }
        }
    }

    /* renamed from: a */
    public static String m12206a(WebView webView, int i) {
        String str = "";
        if (webView == null) {
            return str;
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(userAgentString);
        sb.append(" open_news");
        sb.append(" open_news_u_s/");
        sb.append(i);
        return sb.toString();
    }
}
