package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

/* renamed from: com.alipay.sdk.widget.u */
public class C1581u {
    /* renamed from: a */
    private Stack<WebViewWindow> f4021a = new Stack<>();

    /* renamed from: a */
    public WebViewWindow mo12275a() {
        return (WebViewWindow) this.f4021a.pop();
    }

    /* renamed from: a */
    public void mo12276a(WebViewWindow webViewWindow) {
        this.f4021a.push(webViewWindow);
    }

    /* renamed from: b */
    public boolean mo12277b() {
        return this.f4021a.isEmpty();
    }

    /* renamed from: c */
    public void mo12278c() {
        if (!mo12277b()) {
            Iterator it = this.f4021a.iterator();
            while (it.hasNext()) {
                ((WebViewWindow) it.next()).mo12223a();
            }
            this.f4021a.clear();
        }
    }
}
