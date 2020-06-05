package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import com.alipay.sdk.app.C1503j;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.util.C1553o;
import com.alipay.sdk.widget.WebViewWindow.C1556a;
import com.alipay.sdk.widget.WebViewWindow.C1557b;
import com.alipay.sdk.widget.WebViewWindow.C1558c;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.widget.j */
public class C1569j extends C1566g implements C1556a, C1557b, C1558c {
    /* renamed from: b */
    private boolean f3999b = true;
    /* renamed from: c */
    private String f4000c = "GET";
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f4001d = false;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f4002e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public WebViewWindow f4003f = null;
    /* renamed from: g */
    private C1581u f4004g = new C1581u();

    /* renamed from: com.alipay.sdk.widget.j$a */
    private abstract class C1570a implements AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        private C1570a() {
        }

        /* synthetic */ C1570a(C1569j jVar, C1571k kVar) {
            this();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f4001d) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public C1569j(Activity activity) {
        super(activity);
        m4752c();
    }

    /* renamed from: c */
    private boolean m4752c() {
        try {
            this.f4003f = new WebViewWindow(this.f3995a);
            this.f4003f.setChromeProxy(this);
            this.f4003f.setWebClientProxy(this);
            this.f4003f.setWebEventProxy(this);
            addView(this.f4003f);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    private void m4753d() {
        if (this.f3999b) {
            this.f3995a.finish();
        } else {
            this.f4003f.mo12225a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
        }
    }

    /* renamed from: e */
    private void m4754e() {
        WebView webView = this.f4003f.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
            return;
        }
        C1581u uVar = this.f4004g;
        if (uVar == null || uVar.mo12277b()) {
            m4747a(false);
        } else {
            m4755f();
        }
    }

    /* renamed from: a */
    public void mo12257a(String str, String str2, boolean z) {
        this.f4000c = str2;
        this.f4003f.getTitle().setText(str);
        this.f3999b = z;
    }

    /* renamed from: a */
    private void m4747a(boolean z) {
        C1503j.m4440a(z);
        this.f3995a.finish();
    }

    /* renamed from: a */
    public void mo12253a(String str) {
        if ("POST".equals(this.f4000c)) {
            this.f4003f.mo12226a(str, (byte[]) null);
        } else {
            this.f4003f.mo12225a(str);
        }
    }

    /* renamed from: a */
    public void mo12252a() {
        this.f4003f.mo12223a();
        this.f4004g.mo12278c();
    }

    /* renamed from: b */
    public boolean mo12255b() {
        if (!this.f4001d) {
            m4753d();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo12237a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains("sdk_result_code:")) {
            this.f3995a.runOnUiThread(new C1571k(this));
        }
        jsPromptResult.cancel();
        return true;
    }

    /* renamed from: a */
    public void mo12236a(WebViewWindow webViewWindow, String str) {
        if (!str.startsWith("http") && !webViewWindow.getUrl().endsWith(str)) {
            this.f4003f.getTitle().setText(str);
        }
    }

    /* renamed from: f */
    private boolean m4755f() {
        if (this.f4004g.mo12277b()) {
            this.f3995a.finish();
        } else {
            this.f4001d = true;
            WebViewWindow webViewWindow = this.f4003f;
            this.f4003f = this.f4004g.mo12275a();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new C1572l(this, webViewWindow));
            webViewWindow.setAnimation(translateAnimation);
            removeView(webViewWindow);
            addView(this.f4003f);
        }
        return true;
    }

    /* renamed from: b */
    private boolean m4751b(String str, String str2) {
        WebViewWindow webViewWindow = this.f4003f;
        try {
            this.f4003f = new WebViewWindow(this.f3995a);
            this.f4003f.setChromeProxy(this);
            this.f4003f.setWebClientProxy(this);
            this.f4003f.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.f4003f.getTitle().setText(str2);
            }
            this.f4001d = true;
            this.f4004g.mo12276a(webViewWindow);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new C1573m(this, webViewWindow, str));
            this.f4003f.setAnimation(translateAnimation);
            addView(this.f4003f);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo12240b(WebViewWindow webViewWindow, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("alipayjsbridge://")) {
            m4749b(str.substring(17));
        } else if (TextUtils.equals(str, "sdklite://h5quit")) {
            m4747a(false);
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            this.f4003f.mo12225a(str);
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.f3995a.startActivity(intent);
            } catch (Throwable th) {
                C1505a.m4455a(KEYS.BIZ, th);
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo12241c(WebViewWindow webViewWindow, String str) {
        webViewWindow.mo12225a("javascript:window.prompt('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        webViewWindow.getRefreshButton().setVisibility(0);
        return true;
    }

    /* renamed from: a */
    public boolean mo12238a(WebViewWindow webViewWindow, int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedError:");
        sb.append(str2);
        C1505a.m4452a("net", "SSLError", sb.toString());
        webViewWindow.getRefreshButton().setVisibility(0);
        return false;
    }

    /* renamed from: a */
    public boolean mo12239a(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError) {
        StringBuilder sb = new StringBuilder();
        sb.append("2-");
        sb.append(sslError);
        C1505a.m4452a("net", "SSLError", sb.toString());
        if (this.f4002e) {
            sslErrorHandler.proceed();
            this.f4002e = false;
            return true;
        }
        this.f3995a.runOnUiThread(new C1574n(this, sslErrorHandler));
        return true;
    }

    /* renamed from: b */
    private void m4749b(String str) {
        Map c = C1553o.m4687c(str);
        if (str.startsWith("callNativeFunc")) {
            m4746a((String) c.get("func"), (String) c.get("cbId"), (String) c.get("data"));
        } else if (str.startsWith("onBack")) {
            m4754e();
        } else {
            if (str.startsWith("setTitle")) {
                String str2 = "title";
                if (c.containsKey(str2)) {
                    this.f4003f.getTitle().setText((CharSequence) c.get(str2));
                    return;
                }
            }
            if (str.startsWith("onRefresh")) {
                this.f4003f.getWebView().reload();
                return;
            }
            String str3 = "true";
            if (str.startsWith("showBackButton")) {
                String str4 = "bshow";
                if (c.containsKey(str4)) {
                    this.f4003f.getBackButton().setVisibility(TextUtils.equals(str3, (CharSequence) c.get(str4)) ? 0 : 4);
                    return;
                }
            }
            if (str.startsWith("onExit")) {
                C1503j.m4439a((String) c.get(ArgKey.KEY_RESULT));
                m4747a(TextUtils.equals(str3, (CharSequence) c.get("bsucc")));
            } else if (str.startsWith("onLoadJs")) {
                this.f4003f.mo12225a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
            }
        }
    }

    /* renamed from: a */
    private void m4746a(String str, String str2, String str3) {
        JSONObject d = C1553o.m4690d(str3);
        String str4 = "title";
        String str5 = "";
        if (str4.equals(str) && d.has(str4)) {
            this.f4003f.getTitle().setText(d.optString(str4, str5));
        } else if ("refresh".equals(str)) {
            this.f4003f.getWebView().reload();
        } else if ("back".equals(str)) {
            m4754e();
        } else {
            int i = 0;
            if ("exit".equals(str)) {
                C1503j.m4439a(d.optString(ArgKey.KEY_RESULT, null));
                m4747a(d.optBoolean("success", false));
                return;
            }
            String str6 = "show";
            if ("backButton".equals(str)) {
                boolean optBoolean = d.optBoolean(str6, true);
                ImageView backButton = this.f4003f.getBackButton();
                if (!optBoolean) {
                    i = 4;
                }
                backButton.setVisibility(i);
            } else if ("refreshButton".equals(str)) {
                boolean optBoolean2 = d.optBoolean(str6, true);
                ImageView refreshButton = this.f4003f.getRefreshButton();
                if (!optBoolean2) {
                    i = 4;
                }
                refreshButton.setVisibility(i);
            } else if ("pushWindow".equals(str)) {
                String str7 = "url";
                if (d.optString(str7, null) != null) {
                    m4751b(d.optString(str7), d.optString(str4, str5));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo12242a(WebViewWindow webViewWindow) {
        m4753d();
    }

    /* renamed from: b */
    public void mo12243b(WebViewWindow webViewWindow) {
        webViewWindow.getWebView().reload();
        webViewWindow.getRefreshButton().setVisibility(4);
    }
}
