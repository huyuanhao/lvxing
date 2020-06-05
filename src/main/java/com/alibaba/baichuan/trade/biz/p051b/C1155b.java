package com.alibaba.baichuan.trade.biz.p051b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.p058a.C1193a;
import java.lang.ref.WeakReference;

/* renamed from: com.alibaba.baichuan.trade.biz.b.b */
public class C1155b extends WebChromeClient {
    /* renamed from: a */
    private WeakReference<WebChromeClient> f2373a;
    /* renamed from: b */
    private WeakReference<WebView> f2374b;

    public C1155b(WebView webView, WebChromeClient webChromeClient) {
        this.f2373a = new WeakReference<>(webChromeClient);
        this.f2374b = new WeakReference<>(webView);
    }

    public Bitmap getDefaultVideoPoster() {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        return (weakReference == null || weakReference.get() == null) ? super.getDefaultVideoPoster() : ((WebChromeClient) this.f2373a.get()).getDefaultVideoPoster();
    }

    public View getVideoLoadingProgressView() {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        return (weakReference == null || weakReference.get() == null) ? super.getVideoLoadingProgressView() : ((WebChromeClient) this.f2373a.get()).getVideoLoadingProgressView();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).getVisitedHistory(valueCallback);
        }
        super.getVisitedHistory(valueCallback);
    }

    public void onCloseWindow(WebView webView) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onCloseWindow(webView);
        }
        super.onCloseWindow(webView);
    }

    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onConsoleMessage(str, i, str2);
        }
        super.onConsoleMessage(str, i, str2);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        boolean onConsoleMessage = (weakReference == null || weakReference.get() == null) ? false : ((WebChromeClient) this.f2373a.get()).onConsoleMessage(consoleMessage);
        boolean a = C1159e.m2254a((WebView) this.f2374b.get(), consoleMessage, onConsoleMessage);
        if (onConsoleMessage || a) {
            return true;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        return (weakReference == null || weakReference.get() == null) ? super.onCreateWindow(webView, z, z2, message) : ((WebChromeClient) this.f2373a.get()).onCreateWindow(webView, z, z2, message);
    }

    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
        C1159e.m2252a((WebView) this.f2374b.get(), str, str2, j, j2, j3, quotaUpdater);
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
    }

    public void onGeolocationPermissionsHidePrompt() {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onGeolocationPermissionsHidePrompt();
        }
        super.onGeolocationPermissionsHidePrompt();
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onGeolocationPermissionsShowPrompt(str, callback);
        }
        C1159e.m2251a((WebView) this.f2374b.get(), str, callback);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    public void onHideCustomView() {
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        return (weakReference == null || weakReference.get() == null) ? super.onJsAlert(webView, str, str2, jsResult) : ((WebChromeClient) this.f2373a.get()).onJsAlert(webView, str, str2, jsResult);
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        return (weakReference == null || weakReference.get() == null) ? super.onJsBeforeUnload(webView, str, str2, jsResult) : ((WebChromeClient) this.f2373a.get()).onJsBeforeUnload(webView, str, str2, jsResult);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        boolean onJsConfirm = (weakReference == null || weakReference.get() == null) ? false : ((WebChromeClient) this.f2373a.get()).onJsConfirm(webView, str, str2, jsResult);
        boolean a = C1159e.m2258a(webView, str, str2, "", jsResult, onJsConfirm);
        if (onJsConfirm || a) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        boolean onJsPrompt = (weakReference == null || weakReference.get() == null) ? false : ((WebChromeClient) this.f2373a.get()).onJsPrompt(webView, str, str2, str3, jsPromptResult);
        boolean a = C1159e.m2257a(webView, str, str2, str3, jsPromptResult, onJsPrompt);
        if (onJsPrompt || a) {
            return true;
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public boolean onJsTimeout() {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        return (weakReference == null || weakReference.get() == null) ? super.onJsTimeout() : ((WebChromeClient) this.f2373a.get()).onJsTimeout();
    }

    public void onPermissionRequest(PermissionRequest permissionRequest) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onPermissionRequest(permissionRequest);
        }
        super.onPermissionRequest(permissionRequest);
    }

    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onPermissionRequestCanceled(permissionRequest);
        }
        super.onPermissionRequestCanceled(permissionRequest);
    }

    public void onProgressChanged(WebView webView, int i) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onProgressChanged(webView, i);
        }
        C1159e.m2250a(webView, i);
        super.onProgressChanged(webView, i);
    }

    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onReceivedIcon(webView, bitmap);
        }
        super.onReceivedIcon(webView, bitmap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onReceivedTitle(webView, str);
        }
        C1159e.m2260b(webView, str);
        C1193a.m2325a().mo10841a(1201, str);
        super.onReceivedTitle(webView, str);
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onReceivedTouchIconUrl(webView, str, z);
        }
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    public void onRequestFocus(WebView webView) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onRequestFocus(webView);
        }
        super.onRequestFocus(webView);
    }

    @Deprecated
    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onShowCustomView(view, i, customViewCallback);
        }
        super.onShowCustomView(view, i, customViewCallback);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebChromeClient) this.f2373a.get()).onShowCustomView(view, customViewCallback);
        }
        super.onShowCustomView(view, customViewCallback);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        WeakReference<WebChromeClient> weakReference = this.f2373a;
        return (weakReference == null || weakReference.get() == null) ? super.onShowFileChooser(webView, valueCallback, fileChooserParams) : ((WebChromeClient) this.f2373a.get()).onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}
