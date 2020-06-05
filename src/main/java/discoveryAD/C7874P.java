package discoveryAD;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.qqpim.discovery.IH5Browser;

/* renamed from: discoveryAD.P */
public class C7874P implements IH5Browser {
    Context context;

    public C7874P(Context context2) {
        this.context = context2.getApplicationContext();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
            if (r3 != null) goto L_0x000e;
     */
    public void openAppDetailPage(com.tencent.qqpim.discovery.AdDisplayModel r3) {
        /*
        r2 = this;
        java.lang.String r0 = r3.jumpUrl
        boolean r1 = android.text.TextUtils.isEmpty(r0)
        if (r1 == 0) goto L_0x000d
        java.lang.String r3 = r3.appDownloadUrl
        if (r3 == 0) goto L_0x000d
        goto L_0x000e
    L_0x000d:
        r3 = r0
    L_0x000e:
        boolean r0 = android.text.TextUtils.isEmpty(r3)
        if (r0 == 0) goto L_0x0015
        return
    L_0x0015:
        android.content.Intent r0 = new android.content.Intent
        java.lang.String r1 = "android.intent.action.VIEW"
        r0.<init>(r1)
        r1 = 268435456(0x10000000, float:2.5243549E-29)
        r0.addFlags(r1)
        android.net.Uri r3 = android.net.Uri.parse(r3)
        r0.setData(r3)
        android.content.Context r3 = r2.context
        r3.startActivity(r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7874P.openAppDetailPage(com.tencent.qqpim.discovery.AdDisplayModel):void");
    }

    public void openH5(String str, boolean z, int i, boolean z2, Bundle bundle) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str));
        this.context.startActivity(intent);
    }

    public void openMiniProgram(String str, String str2) {
    }
}
