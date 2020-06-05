package com.alipay.sdk.widget;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* renamed from: com.alipay.sdk.widget.i */
class C1568i implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ C1567h f3998a;

    C1568i(C1567h hVar) {
        this.f3998a = hVar;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.f3998a.f3995a.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
