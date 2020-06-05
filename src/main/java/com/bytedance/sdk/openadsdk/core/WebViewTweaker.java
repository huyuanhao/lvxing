package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.utils.RomUtils;
import java.util.HashSet;

/* renamed from: com.bytedance.sdk.openadsdk.core.aa */
public class WebViewTweaker {
    /* renamed from: a */
    private static final boolean f7232a;
    /* renamed from: b */
    private static final boolean f7233b = m9085a();
    /* renamed from: c */
    private static int f7234c = -1;
    /* renamed from: d */
    private static int f7235d = -1;
    /* renamed from: e */
    private static int f7236e = -1;
    /* renamed from: f */
    private static Handler f7237f = null;
    /* renamed from: g */
    private static final HashSet<String> f7238g;
    /* renamed from: h */
    private static final HashSet<String> f7239h;

    static {
        boolean z = VERSION.SDK_INT >= 16 && RomUtils.m11951e();
        f7232a = z;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        f7238g = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        f7239h = hashSet2;
    }

    /* renamed from: a */
    public static void m9083a(Context context, WebView webView) {
        if (context != null && webView != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                try {
                    webView.loadUrl("about:blank");
                    if (f7236e > 0) {
                        View rootView = webView.getRootView();
                        if (rootView instanceof ViewGroup) {
                            View childAt = ((ViewGroup) rootView).getChildAt(0);
                            childAt.setDrawingCacheEnabled(true);
                            Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                            childAt.setDrawingCacheEnabled(false);
                            ImageView imageView = new ImageView(activity);
                            imageView.setImageBitmap(createBitmap);
                            imageView.setVisibility(0);
                            ((ViewGroup) rootView).addView(imageView, new LayoutParams(-1, -1));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
            if ("ZTE N5".equals(android.os.Build.MODEL) != false) goto L_0x0017;
     */
    /* renamed from: a */
    private static boolean m9085a() {
        /*
        boolean r0 = f7232a
        if (r0 != 0) goto L_0x0017
        int r0 = android.os.Build.VERSION.SDK_INT
        r1 = 16
        if (r0 != r1) goto L_0x0015
        java.lang.String r0 = android.os.Build.MODEL
        java.lang.String r1 = "ZTE N5"
        boolean r0 = r1.equals(r0)
        if (r0 == 0) goto L_0x0015
        goto L_0x0017
    L_0x0015:
        r0 = 0
        goto L_0x0018
    L_0x0017:
        r0 = 1
    L_0x0018:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.WebViewTweaker.m9085a():boolean");
    }

    /* renamed from: a */
    public static void m9084a(WebView webView) {
        if (webView != null) {
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            ViewParent parent = webView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.removeAllViews();
            try {
                webView.destroy();
            } catch (Throwable unused) {
            }
        }
    }
}
