package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.reflect.Method;
import java.util.Map;

public class SSWebView extends WebView {
    public SSWebView(Context context) {
        super(context);
        m10851a(context);
    }

    public SSWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10851a(context);
    }

    public SSWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10851a(context);
    }

    /* renamed from: a */
    private void m10851a(Context context) {
        m10853b(context);
        m10852b();
        m10850a();
    }

    public void setNetworkAvailable(boolean z) {
        try {
            super.setNetworkAvailable(z);
        } catch (Exception unused) {
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            super.loadUrl(str, map);
        } catch (Exception unused) {
        }
    }

    public void loadUrl(String str) {
        try {
            setJavaScriptEnabled(str);
            super.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    public void postUrl(String str, byte[] bArr) {
        try {
            setJavaScriptEnabled(str);
            super.postUrl(str, bArr);
        } catch (Exception unused) {
        }
    }

    public void loadData(String str, String str2, String str3) {
        try {
            super.loadData(str, str2, str3);
        } catch (Exception unused) {
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Exception unused) {
        }
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception unused) {
        }
    }

    public void reload() {
        try {
            super.reload();
        } catch (Exception unused) {
        }
    }

    public boolean canGoBack() {
        try {
            return super.canGoBack();
        } catch (Exception unused) {
            return false;
        }
    }

    public void goBack() {
        try {
            super.goBack();
        } catch (Exception unused) {
        }
    }

    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Exception unused) {
            return false;
        }
    }

    public void goForward() {
        try {
            super.goForward();
        } catch (Exception unused) {
        }
    }

    public boolean canGoBackOrForward(int i) {
        try {
            return super.canGoBackOrForward(i);
        } catch (Exception unused) {
            return false;
        }
    }

    public void goBackOrForward(int i) {
        try {
            super.goBackOrForward(i);
        } catch (Exception unused) {
        }
    }

    public String getUrl() {
        try {
            return super.getUrl();
        } catch (Exception unused) {
            return null;
        }
    }

    public String getOriginalUrl() {
        try {
            String originalUrl = super.getOriginalUrl();
            if (originalUrl != null && originalUrl.startsWith("data:text/html")) {
                String url = super.getUrl();
                if (url != null && url.startsWith("file://")) {
                    originalUrl = url;
                }
            }
            return originalUrl;
        } catch (Exception unused) {
            return null;
        }
    }

    public int getProgress() {
        try {
            return super.getProgress();
        } catch (Exception unused) {
            return 100;
        }
    }

    public int getContentHeight() {
        try {
            return super.getContentHeight();
        } catch (Exception unused) {
            return 1;
        }
    }

    public void clearCache(boolean z) {
        try {
            super.clearCache(z);
        } catch (Exception unused) {
        }
    }

    public void clearFormData() {
        try {
            super.clearFormData();
        } catch (Exception unused) {
        }
    }

    public void clearHistory() {
        try {
            super.clearHistory();
        } catch (Exception unused) {
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            super.setWebViewClient(webViewClient);
        } catch (Exception unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            super.setDownloadListener(downloadListener);
        } catch (Exception unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            super.setWebChromeClient(webChromeClient);
        } catch (Exception unused) {
        }
    }

    public void setBackgroundColor(int i) {
        try {
            super.setBackgroundColor(i);
        } catch (Exception unused) {
        }
    }

    public void computeScroll() {
        try {
            super.computeScroll();
        } catch (Exception unused) {
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void setLayerType(int i, Paint paint) {
        try {
            super.setLayerType(i, paint);
        } catch (Throwable unused) {
        }
    }

    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private static void m10853b(Context context) {
        if (VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager == null) {
                    return;
                }
                if (accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, new Object[]{Integer.valueOf(0)});
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private void m10850a() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m10852b() {
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
        }
    }

    private void setJavaScriptEnabled(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                WebSettings settings = getSettings();
                if (settings != null) {
                    if (str.startsWith("file://")) {
                        settings.setJavaScriptEnabled(false);
                    } else {
                        settings.setJavaScriptEnabled(true);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
