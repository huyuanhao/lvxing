package com.alipay.sdk.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.concurrent.ConcurrentHashMap;

public class AlipayResultActivity extends Activity {
    /* renamed from: a */
    public static final ConcurrentHashMap<String, C1490a> f3789a = new ConcurrentHashMap<>();

    /* renamed from: com.alipay.sdk.app.AlipayResultActivity$a */
    public interface C1490a {
        /* renamed from: a */
        void mo12099a(int i, String str, String str2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a A[ADDED_TO_REGION] */
    public void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        java.lang.String r0 = "result"
        java.lang.String r1 = "session"
        java.lang.String r2 = ""
        java.lang.String r3 = "biz"
        super.onCreate(r9)
        java.lang.String r9 = "BSPReturned"
        com.alipay.sdk.app.statistic.C1505a.m4452a(r3, r9, r2)     // Catch:{ all -> 0x00c5 }
        android.content.Intent r9 = r8.getIntent()     // Catch:{ all -> 0x00c5 }
        java.lang.String r4 = r9.getStringExtra(r1)     // Catch:{ all -> 0x00b6 }
        android.os.Bundle r5 = r9.getBundleExtra(r0)     // Catch:{ all -> 0x00b6 }
        java.lang.String r6 = "scene"
        java.lang.String r6 = r9.getStringExtra(r6)     // Catch:{ all -> 0x00b6 }
        java.lang.String r7 = "BSPSession"
        com.alipay.sdk.app.statistic.C1505a.m4452a(r3, r7, r4)     // Catch:{ all -> 0x00b6 }
        java.lang.String r7 = "mqpSchemePay"
        boolean r6 = android.text.TextUtils.equals(r7, r6)     // Catch:{ all -> 0x00c5 }
        if (r6 == 0) goto L_0x0033
        r8.m4386a(r4, r5)     // Catch:{ all -> 0x00c5 }
        return
    L_0x0033:
        boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00c5 }
        if (r6 != 0) goto L_0x003b
        if (r5 != 0) goto L_0x0094
    L_0x003b:
        android.net.Uri r6 = r9.getData()     // Catch:{ all -> 0x00c5 }
        if (r6 == 0) goto L_0x0094
        android.net.Uri r9 = r9.getData()     // Catch:{ all -> 0x0089 }
        java.lang.String r9 = r9.getQuery()     // Catch:{ all -> 0x0089 }
        java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0089 }
        r7 = 2
        byte[] r9 = android.util.Base64.decode(r9, r7)     // Catch:{ all -> 0x0089 }
        java.lang.String r7 = "UTF-8"
        r6.<init>(r9, r7)     // Catch:{ all -> 0x0089 }
        org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x0089 }
        r9.<init>(r6)     // Catch:{ all -> 0x0089 }
        org.json.JSONObject r0 = r9.getJSONObject(r0)     // Catch:{ all -> 0x0089 }
        java.lang.String r4 = r9.getString(r1)     // Catch:{ all -> 0x0089 }
        java.lang.String r9 = "BSPUriSession"
        com.alipay.sdk.app.statistic.C1505a.m4452a(r3, r9, r4)     // Catch:{ all -> 0x0089 }
        android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0089 }
        r9.<init>()     // Catch:{ all -> 0x0089 }
        java.util.Iterator r1 = r0.keys()     // Catch:{ all -> 0x0086 }
    L_0x0070:
        boolean r5 = r1.hasNext()     // Catch:{ all -> 0x0086 }
        if (r5 == 0) goto L_0x0084
        java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x0086 }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0086 }
        java.lang.String r6 = r0.getString(r5)     // Catch:{ all -> 0x0086 }
        r9.putString(r5, r6)     // Catch:{ all -> 0x0086 }
        goto L_0x0070
    L_0x0084:
        r5 = r9
        goto L_0x0094
    L_0x0086:
        r0 = move-exception
        r5 = r9
        goto L_0x008a
    L_0x0089:
        r0 = move-exception
    L_0x008a:
        java.lang.String r9 = "BSPResEx"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r3, r9, r0)     // Catch:{ all -> 0x00c5 }
        java.lang.String r9 = "ParseSchemeQueryError"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r3, r9, r0)     // Catch:{ all -> 0x00c5 }
    L_0x0094:
        boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00c5 }
        if (r9 != 0) goto L_0x00af
        if (r5 != 0) goto L_0x009d
        goto L_0x00af
    L_0x009d:
        r8.m4386a(r4, r5)     // Catch:{ all -> 0x00a7 }
        com.alipay.sdk.app.statistic.C1505a.m4456b(r8, r2)     // Catch:{ all -> 0x00c5 }
        r8.finish()     // Catch:{ all -> 0x00c5 }
        goto L_0x00c8
    L_0x00a7:
        r9 = move-exception
        com.alipay.sdk.app.statistic.C1505a.m4456b(r8, r2)     // Catch:{ all -> 0x00c5 }
        r8.finish()     // Catch:{ all -> 0x00c5 }
        throw r9     // Catch:{ all -> 0x00c5 }
    L_0x00af:
        com.alipay.sdk.app.statistic.C1505a.m4456b(r8, r2)     // Catch:{ all -> 0x00c5 }
        r8.finish()     // Catch:{ all -> 0x00c5 }
        goto L_0x00c8
    L_0x00b6:
        r9 = move-exception
        java.lang.String r0 = "BSPSerError"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r3, r0, r9)     // Catch:{ all -> 0x00c5 }
        java.lang.String r0 = "ParseBundleSerializableError"
        com.alipay.sdk.app.statistic.C1505a.m4453a(r3, r0, r9)     // Catch:{ all -> 0x00c5 }
        r8.finish()     // Catch:{ all -> 0x00c5 }
        return
    L_0x00c5:
        r8.finish()
    L_0x00c8:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AlipayResultActivity.onCreate(android.os.Bundle):void");
    }

    /* renamed from: a */
    private void m4386a(String str, Bundle bundle) {
        C1490a aVar = (C1490a) f3789a.remove(str);
        if (aVar == null) {
            finish();
            return;
        }
        try {
            aVar.mo12099a(bundle.getInt("endCode"), bundle.getString("memo"), bundle.getString(ArgKey.KEY_RESULT));
        } finally {
            finish();
        }
    }
}
