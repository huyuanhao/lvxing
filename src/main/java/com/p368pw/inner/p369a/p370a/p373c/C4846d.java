package com.p368pw.inner.p369a.p370a.p373c;

import android.content.Intent;
import android.net.Uri;
import com.p368pw.inner.base.p387d.C5205o;
import com.tencent.p605ep.shanhuad.adpublic.H5BrowserListener;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.TMSDKContext;

/* renamed from: com.pw.inner.a.a.c.d */
public class C4846d implements H5BrowserListener {
    public void openAppDetailPage(AdMetaInfo adMetaInfo) {
        C5205o.m21461a();
        if (adMetaInfo == null || adMetaInfo.getAdDisplayModel() == null) {
            C5205o.m21462a("AdMetaInfo或者AdDisplayModel为null，无法上报");
            return;
        }
        new C4849g(adMetaInfo.title, C4839a.m19870d(adMetaInfo)).mo26660c();
        C4839a.m19868b(adMetaInfo, null);
    }

    public void openH5(String str) {
        C5205o.m21461a();
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.parse(str));
            TMSDKContext.getApplicationContext().startActivity(intent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
